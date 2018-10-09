package com.cy.example.controller.system;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.cy.example.config.WebConfig;
import com.cy.example.controller.BaseController;
import com.cy.example.entity.system.LoginRecordEntity;
import com.cy.example.entity.system.MailEntity;
import com.cy.example.entity.system.SysUserEntity;
import com.cy.example.model.Page;
import com.cy.example.model.Result;
import com.cy.example.service.IMailService;
import com.cy.example.service.IUserService;
import com.cy.example.supplement.poi.ExportExcel;
import com.cy.example.supplement.rabbitmq.general.RabbitSender;
import com.cy.example.util.MD5Util;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.annotation.RequiresGuest;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/system/user")
public class UserController extends BaseController {

	@Autowired
	private IUserService userService;
	
	@Autowired
	private IMailService mailService;
	
	@Autowired
	private RabbitSender rabbitSender;

	@RequestMapping("/register")
	@RequiresGuest
	public Result<String> register(@ModelAttribute("user") SysUserEntity user) {
		WebConfig.add(user);
		user.setN_status("0");
		boolean flag = userService.insert(user);
		MailEntity mail = new MailEntity();
		//后面优化为给数据库中的管理员发送
		mail.setTo("pjchenyang@qq.com");
    	mail.setSubject("用户:"+user.getC_username()+"的注册审核提醒");
    	mail.setContent(user.toStringCN());
//		rabbitSender.sendMail(mail);
		String msg;
		if (flag) {
			msg = "注册成功！请等待管理员激活！";
		} else {
			msg = "注册失败！";
		}
		return new Result<>(flag,msg,0,null);
	}
	
	@RequestMapping("/lock")
	@RequiresPermissions("user_lock")
	public Result<String> lock(long id,String n_status) {
		SysUserEntity user = userService.selectById(id);
		user.setN_status(n_status);
		WebConfig.update(user);
		boolean flag = userService.updateById(user);
		String msg;
		if (flag) {
			msg = "操作成功！";
		} else {
			msg = "操作失败！";
		}
		return new Result<>(flag,msg,0,null);
	}

	@PostMapping
	@RequiresPermissions("user_add")
	public Result<String> add(@ModelAttribute("user") SysUserEntity user) {
		user.getN_departmentId().setId(Long.valueOf(user.getN_departmentId().getC_departName()));
		SysUserEntity flag = userService.insertMy(user);
		String msg;
		if (flag != null) {
			msg = "添加成功！";
		} else {
			msg = "添加失败！";
		}
		return new Result<>(flag!= null?true:false,msg,0,null);
	}

	@PutMapping
	@RequiresPermissions("user_update")
	public Result<String> update(@ModelAttribute("user") SysUserEntity user) {
		/*if("男".equals(user.getN_sex())){
			user.setN_sex("1");
		}else if("女".equals(user.getN_sex())){
			user.setN_sex("0");
		}*/
		/*if("可用".equals(user.getN_status())){
			user.setN_status("1");
		}else if("锁定".equals(user.getN_sex())){
			user.setN_status("0");
		}*/
		user.getN_departmentId().setId(Long.valueOf(user.getN_departmentId().getC_departName()));
		SysUserEntity flag = userService.updateMy(user);
		String msg;
		if (flag!= null) {
			msg = "更新成功！";
		} else {
			msg = "更新失败！";
		}
		return new Result<>(flag!= null?true:false,msg,0,null);
	}

	@DeleteMapping("/{id}")
	@RequiresPermissions("user_delete")
	public Result<String> delete(@PathVariable("id")Long id) {
		boolean flag = userService.deleteById(id);
		String msg;
		if (flag) {
			msg = "删除成功！";
		} else {
			msg = "删除失败！";
		}
		return new Result<>(flag,msg,0,null);
	}

	@GetMapping
	@RequiresPermissions("user_list")
	public Result<List<SysUserEntity>> findAll(@ModelAttribute("page") Page page){
		// System.out.print("================================="+page.toString()+page.getIndex());
		List<SysUserEntity> list = userService.findAll(page);
		int sum = userService.selectCount(new EntityWrapper<SysUserEntity>());
		
		for(SysUserEntity entity : list){
			if("1".equals(entity.getN_sex())){
				entity.setN_sex("男");
			}else if("0".equals(entity.getN_sex())){
				entity.setN_sex("女");
			}
			if("1".equals(entity.getN_status())){
				entity.setN_status("可用");
			}else if("0".equals(entity.getN_status())){
				entity.setN_status("锁定");
			}
		}
		return new Result<>(true,null,sum,list);
	}

	@GetMapping("/search")
	@RequiresPermissions("user_list")
	public Result<List<SysUserEntity>> search(
			@ModelAttribute("user") SysUserEntity user,
			@ModelAttribute("page") Page page) {
		List<SysUserEntity> users = userService.searchAll(user, page);
		int sum = userService.searchAllCount(user);
		return new Result<>(true,null,sum,users);
	}

	@GetMapping("/export")
	@Transactional(readOnly = true)
	@RequiresPermissions("user_export")
	public ResponseEntity<byte[]> export() throws Exception {
		List<SysUserEntity> list = userService.selectList(new EntityWrapper<>());
		String[] name = {"用户名","联系方式","电子邮箱","年龄","性别","用户状态"};
		String[] column = {"c_username","c_phone","c_email","n_age","n_sex","n_status"};
		ExportExcel exportExcel = new ExportExcel("系统用户数据");

//		n_departmentId.id   ，n_departmentId.c_departName  所属部门

		HSSFWorkbook workbook = exportExcel.wirteExcel(column,name,list);
		ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
		workbook.write(outByteStream);

		HttpHeaders headers = getFileHeader("user.xls");

		return ResponseEntity
				.ok()
				.headers(headers)
				.contentType(MediaType.parseMediaType("application/octet-stream"))
				.body(outByteStream.toByteArray());
	}

	@SuppressWarnings("finally")
	@RequestMapping("/validate")
	public Result<String> validate(String username, String password,String validate,Boolean rememberMe) {
		password = MD5Util.GetMD5Code(password);
		UsernamePasswordToken token = new UsernamePasswordToken(username, password,rememberMe);
		boolean flag = false;
		String msg = "";
		try {
			Subject subject = SecurityUtils.getSubject();
			String kaptcha = (String) subject.getSession().getAttribute("vrifyCode");
			if (!StringUtil.IsEqual(validate,kaptcha)){
				msg = "登录失败，验证码错误！";
			}else{
				subject.login(token); // 完成登录
				SysUserEntity user = (SysUserEntity) subject.getPrincipal();
				subject.getSession().setAttribute(WebConfig.LOGIN_USER, user);
				LoginRecordEntity loginRecord = new LoginRecordEntity();
				WebConfig.add(loginRecord);
				loginRecord.setC_loginIp(super.getIP(getRequest()));
				loginRecord.setC_username(user.getC_username());
				//采用消息中心的通知添加
				rabbitSender.sendLoginRecord(loginRecord);
				//清楚错误次数缓存
//				userService.removeCount(user.getC_username());
				msg = "登陆成功！";
				flag = true;
			}
		} catch (Exception exception) {
			if (exception instanceof UnknownAccountException) {
				log.info("账号不存在： -- > UnknownAccountException");
				msg = "登录失败，用户账号不存在！";
			} else if (exception instanceof IncorrectCredentialsException) {
				log.info(" 密码不正确： -- >IncorrectCredentialsException");
				msg = "登录失败，用户密码不正确！";
			} else if (exception instanceof LockedAccountException) {
				log.info(" 用户被锁定： -- >LockedAccountException");
				msg = "登录失败，用户被锁定！";
			} else if (exception instanceof DisabledAccountException) {
				log.info(" 由于密码输入错误次数大于5次，帐号已经禁止登录！ -- >DisabledAccountException");
				msg = "由于密码输入错误次数大于5次，请5分钟之后登录！";
			}else {
				log.info("else -- >" + exception);
				msg = "登录失败，发生未知错误：" + exception;
			}


		} finally {
			return new Result<>(flag,msg,0,null);
		}
	}

}
