package com.cy.example.controller.system;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.cy.example.config.WebConfig;
import com.cy.example.controller.BaseController;
import com.cy.example.entity.system.*;
import com.cy.example.service.*;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.*;

@Slf4j
@Controller
public class SystemController extends BaseController {
	
	@Autowired
	private IPermissionService permisService;
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IRoleService roleService;
	
	@Autowired
	private IMenuService menuService;
	
	@Autowired
	private ILoginRecordService loginRecordService;
	
	@Autowired
	private IDepartmentService departmentService;
	
	@Autowired
	private INoticeService noticeService;
	
	@Value("${swallow.system.name}")
	private String SYS_NAME;

	@Autowired
	DefaultKaptcha defaultKaptcha;

	@RequestMapping("/kaptcha")
	public void defaultKaptcha(HttpServletResponse httpServletResponse) throws Exception{
		byte[] captchaChallengeAsJpeg = null;
		ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
		try {
			//生产验证码字符串并保存到session中
			String createText = defaultKaptcha.createText();
			SecurityUtils.getSubject().getSession().setAttribute("vrifyCode", createText);
			//使用生产的验证码字符串返回一个BufferedImage对象并转为byte写入到byte数组中
			BufferedImage challenge = defaultKaptcha.createImage(createText);
			ImageIO.write(challenge, "jpg", jpegOutputStream);
		} catch (IllegalArgumentException e) {
			httpServletResponse.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}

		//定义response输出类型为image/jpeg类型，使用response输出流输出图片的byte数组
		captchaChallengeAsJpeg = jpegOutputStream.toByteArray();
		httpServletResponse.setHeader("Cache-Control", "no-store");
		httpServletResponse.setHeader("Pragma", "no-cache");
		httpServletResponse.setDateHeader("Expires", 0);
		httpServletResponse.setContentType("image/jpeg");
		ServletOutputStream responseOutputStream =
				httpServletResponse.getOutputStream();
		responseOutputStream.write(captchaChallengeAsJpeg);
		responseOutputStream.flush();
		responseOutputStream.close();
	}

	@RequestMapping("/index")
	public String showIndex(ModelMap map) {
		map.put("SYS_NAME", SYS_NAME);
		return "index";
	}

	@RequestMapping("/main")
	public String showMain(HttpSession session, ModelMap map) {
		SysUserEntity user = (SysUserEntity) session
				.getAttribute(WebConfig.LOGIN_USER);
		log.info("---roleID"+user.getRole().getId());
		List<SysMenuEntity> menuList = menuService.findUserAll(user.getRole().getId());
		Map<String, List<SysMenuEntity>> data = new HashMap<String, List<SysMenuEntity>>();
		for (int i = 0; i < menuList.size(); i++) {
			if("[root]".equals(menuList.get(i).getC_node())){
				List<SysMenuEntity> tool = new ArrayList<SysMenuEntity>();
				for (int j = 0; j < menuList.size(); j++) {
					if(String.valueOf(menuList.get(i).getId()).equals(menuList.get(j).getC_node())){
						tool.add(menuList.get(j));
					}
				}
				data.put(menuList.get(i).getC_menuName(), tool);
			}
		}
		//在线人数统计
		map.put("user", user);
		map.put("menuList", data);
		map.put("SYS_NAME", SYS_NAME);
		map.put("activeNum", WebConfig.getActiveUserSum());
		return "main/main";
	}

	@RequestMapping("/main2")
	public String showMain2(HttpSession session, ModelMap map) {
		SysUserEntity user = (SysUserEntity) session
				.getAttribute(WebConfig.LOGIN_USER);
		List<SysMenuEntity> menuList = menuService.findUserAll(user.getRole().getId());
		Map<String, List<SysMenuEntity>> data = new HashMap<String, List<SysMenuEntity>>();
		for (int i = 0; i < menuList.size(); i++) {
			if("[root]".equals(menuList.get(i).getC_node())){
				List<SysMenuEntity> tool = new ArrayList<SysMenuEntity>();
				for (int j = 0; j < menuList.size(); j++) {
					if(String.valueOf(menuList.get(i).getId()).equals(menuList.get(j).getC_node())){
						tool.add(menuList.get(j));
					}
				}
				data.put(menuList.get(i).getC_menuName(), tool);
			}
		}
		//在线人数统计
		map.put("user", user);
		map.put("menuList", data);
		map.put("SYS_NAME", SYS_NAME);
		map.put("activeNum", WebConfig.getActiveUserSum());
		return "main/main2";
	}

	@RequestMapping("/loginOut")
	public String loginOut(HttpSession session, ModelMap map) {
		map.put("SYS_NAME", SYS_NAME);
		session.removeAttribute(WebConfig.LOGIN_USER);
		return "index";
	}

	@RequestMapping("/online")
	public String getOnline(ModelMap map){
		HashSet<String> set =  WebConfig.getActiveUsers();
		map.put("users",set);
		return "online";
	}
	
	@RequestMapping("/menu/home")
	public String showHome(ModelMap map) {
		Map<String, Object> loginRecord = loginRecordService.recentLoginCount();
		Page<LoginRecordEntity> recordList = loginRecordService.selectPage(new Page<LoginRecordEntity>(1, 20)
				, new EntityWrapper<LoginRecordEntity>().orderBy("c_createDate",false));
		Page<SysNoticeEntity> list = noticeService.selectPage(new Page<SysNoticeEntity>(1, 10)
				, new EntityWrapper<SysNoticeEntity>().setSqlSelect("c_title,c_content,n_order,c_createDate,c_updateDate,id")
					.orderBy("c_updateDate",false));
		map.put("noticeList", list.getRecords());
		map.put("loginRecord", loginRecord);
		map.put("recordList", recordList.getRecords());
		return "main/home";
	}

	@RequestMapping("/menu/calendarManage")
	public String calendarManage() {
		return "manage/calendarManage";
	}

	@RequestMapping("/menu/userManage")
	public String userManage(ModelMap map) {
		List<SysDepartmentEntity> departList = departmentService.selectList(new EntityWrapper<SysDepartmentEntity>());
		map.put("departList", departList); 
		return "manage/userManage";
	}
	
	@RequestMapping("/menu/menuManage")
	public String menuManage(ModelMap map) {
		List<SysMenuEntity> menuList = menuService.findRoot();
		map.put("menuList", menuList);
		return "manage/menuManage";
	}

	@RequestMapping("/menu/loginRecordManage")
	public String loginRecordManage() {
		return "manage/loginRecordManage";
	}

	@RequestMapping("/menu/uploadFile")
	public String uploadFile() {
		return "test_uploadFile";
	}
	
	@RequestMapping("/menu/roleManage")
	public String roleManage() {
		return "manage/roleManage";
	}
	
	@RequestMapping("/menu/permissionManage")
	public String permissionManage() {
		return "manage/permissionManage";
	}
	
	@RequestMapping("/menu/user_roleManage")
	public String user_roleManage(ModelMap map) {
		List<SysUserEntity> userList = userService.selectList(new EntityWrapper<SysUserEntity>());
		List<SysRoleEntity> roleList = roleService.selectList(new EntityWrapper<SysRoleEntity>());
		map.put("userList", userList);
		map.put("roleList", roleList);
		return "manage/user_roleManage";
	}
	
	@RequestMapping("/menu/role_permisManage")
	@RequiresPermissions("role_permis:list")
	public String role_permisManage(ModelMap map) {
		List<SysPermissionEntity> permisList = permisService.selectList(new EntityWrapper<SysPermissionEntity>());
		List<SysRoleEntity> roleList = roleService.selectList(new EntityWrapper<SysRoleEntity>());
		map.put("permisList", permisList);
		map.put("roleList", roleList);
		return "manage/role_permisManage";
	}

	@RequestMapping("/menu/role_menuManage")
	@RequiresPermissions("role_menu:list")
	public String role_menuManage(ModelMap map) {
		return "manage/role_menuManage";
	}

	@RequestMapping("/menu/departmentManage")
	public String departmentManage(ModelMap map) {
		return "manage/departmentManage";
	}

	@RequestMapping("/menu/noticeManage")
	public String noticeManage(ModelMap map) {
		return "manage/noticeManage";
	}
	
	@RequestMapping("/menu/workflow/deployManage")
	public String deployManage(ModelMap map) {
		
		return "workflow/deployManage";
	}
	
	@RequestMapping("/menu/workflow/processDefinitionManage")
	public String processDefinitionManage(ModelMap map) {
		return "workflow/processDefinitionManage";
	}
	
	@RequestMapping("/menu/workflow/leaveBillManage")
	public String leaveBillManage(ModelMap map) {
		return "workflow/leaveBillManage";
	}
	
	@RequestMapping("/menu/workflow/taskManage")
	public String taskManage(ModelMap map) {
		return "workflow/taskManage";
	}

	@RequestMapping("/403")
	public String error403() {
		return "error/403";
	}
}
