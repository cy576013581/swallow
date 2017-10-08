package com.cy.example.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.cy.example.carrier.PageCa;
import com.cy.example.config.WebConfig;
import com.cy.example.entity.LoginRecordEntity;
import com.cy.example.entity.UserEntity;
import com.cy.example.service.ILoginRecordService;
import com.cy.example.service.IUserService;
import com.cy.example.utils.MD5Util;
import com.fasterxml.jackson.core.JsonProcessingException;

@Controller
@RequestMapping("/system/user")
public class UserController extends BaseController {

	@Autowired
	private IUserService userService;

	@Autowired
	private ILoginRecordService loginRecordService;

	private static final Logger logger = LoggerFactory
			.getLogger(UserController.class);

	@RequestMapping("/add")
	@ResponseBody
	public Map<String, Object> add(@ModelAttribute("user") UserEntity user) {
		super.add(user);
		boolean flag = userService.insert(user);
		Map<String, Object> map = new HashMap<String, Object>();
		if (flag) {
			map.put("flag", flag);
			map.put("msg", "添加成功！");
		} else {
			map.put("flag", flag);
			map.put("msg", "添加失败！");
		}
		return map;
	}

	@RequestMapping("/update")
	@ResponseBody
	public Map<String, Object> update(@ModelAttribute("user") UserEntity user) {
		super.update(user);
		int rows = userService.updateMy(user);
		Map<String, Object> map = new HashMap<String, Object>();
		if (rows > 0) {
			map.put("flag", true);
			map.put("msg", "更新成功！");
		} else {
			map.put("flag", false);
			map.put("msg", "更新失败！");
		}
		return map;
	}

	@RequestMapping("/delete")
	@ResponseBody
	public Map<String, Object> delete(@ModelAttribute("user") UserEntity user) {
		boolean flag = userService.deleteById(user.getId());
		Map<String, Object> map = new HashMap<String, Object>();
		if (flag) {
			map.put("flag", flag);
			map.put("msg", "删除成功！");
		} else {
			map.put("flag", flag);
			map.put("msg", "删除失败！");
		}
		return map;
	}

	@RequestMapping("/find")
	public Map<String, Object> findOne() {
		Map<String, Object> map = new HashMap<String, Object>();
		return map;
	}

	@RequestMapping("/findAll")
	@ResponseBody
	public Map<String, Object> findAll(int page, int rows)
			throws JsonProcessingException {
		// System.out.print("================================="+page.toString()+page.getIndex());
		Page<UserEntity> list = userService.selectPage(new Page<UserEntity>(page, rows)
				, new EntityWrapper<UserEntity>());

		Map<String, Object> map = new HashMap<String, Object>();
		int sum = userService.selectCount(new EntityWrapper<UserEntity>());
		map.put("rows", list.getRecords());
		map.put("total", sum);
		return map;
	}

	@RequestMapping("/searchData")
	@ResponseBody
	public Map<String, Object> searchData(
			@ModelAttribute("user") UserEntity user,
			@ModelAttribute("pageVo") PageCa page) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<UserEntity> users = userService.searchAll(user, page);
		int sum = userService.searchAllCount(user, page);
		map.put("rows", users);
		map.put("total", sum);
		return map;
	}

	@SuppressWarnings("finally")
	@RequestMapping("/validate")
	@ResponseBody
	public Map<String, Object> validate(String username, String password) {
		Map<String, Object> map = new HashMap<String, Object>();
		password = MD5Util.GetMD5Code(password);
		UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(
				username, password);
		boolean flag = true;
		String msg = "";
		Subject subject = SecurityUtils.getSubject();
		try {
			subject.login(usernamePasswordToken); // 完成登录
			UserEntity user = (UserEntity) subject.getPrincipal();
			subject.getSession().setAttribute(WebConfig.LOGIN_USER, user);
			LoginRecordEntity loginRecord = new LoginRecordEntity();
			super.add(loginRecord);
			loginRecord.setC_loginIp(super.getIP(getRequest()));
			loginRecord.setC_username(user.getC_username());
			loginRecordService.insert(loginRecord);
			msg = "登陆成功！";
			map.put("flag", flag);
		} catch (Exception exception) {
			if (exception instanceof UnknownAccountException) {
				logger.info("账号不存在： -- > UnknownAccountException");
				msg = "登录失败，用户账号不存在！";
			} else if (exception instanceof IncorrectCredentialsException) {
				logger.info(" 密码不正确： -- >IncorrectCredentialsException");
				msg = "登录失败，用户密码不正确！";
			} else {
				logger.info("else -- >" + exception);
				msg = "登录失败，发生未知错误：" + exception;
			}
			map.put("flag", false);
		} finally {
			map.put("msg", msg);
			return map;
		}
	}

}
