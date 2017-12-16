package com.cy.example.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.cy.example.config.WebConfig;
import com.cy.example.entity.SysMenuEntity;
import com.cy.example.entity.SysPermissionEntity;
import com.cy.example.entity.SysRoleEntity;
import com.cy.example.entity.UserEntity;
import com.cy.example.service.IMenuService;
import com.cy.example.service.IPermissionService;
import com.cy.example.service.IRoleService;
import com.cy.example.service.IUserService;

@Controller
public class SystemController {
	
	@Autowired
	private IPermissionService permisService;
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IRoleService roleService;
	
	@Autowired
	private IMenuService menuService;
	
	@Value("${swallow.system.name}")
	private String SYS_NAME;

	@RequestMapping("/index")
	public String showIndex(ModelMap map) {
		map.put("SYS_NAME", SYS_NAME);
		return "index";
	}

	@RequestMapping("/main")
	public String showMain(HttpSession session, ModelMap map) {
		UserEntity user = (UserEntity) session
				.getAttribute(WebConfig.LOGIN_USER);
		List<SysMenuEntity> menuList = menuService.findAll();
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
		map.put("user", user);
		map.put("menuList", data);
		map.put("SYS_NAME", SYS_NAME);
		return "main/main";
	}

	@RequestMapping("/loginOut")
	public String loginOut(HttpSession session) {
		session.removeAttribute(WebConfig.LOGIN_USER);
		return "index";
	}
	
	@RequestMapping("/menu/home")
	public String showHome() {
		return "main/home";
	}

	@RequestMapping("/menu/calendarManage")
	public String calendarManage() {
		return "calendarManage";
	}

	@RequestMapping("/menu/userManage")
	public String userManage() {
		return "userManage";
	}
	
	@RequestMapping("/menu/menuManage")
	public String menuManage(ModelMap map) {
		List<SysMenuEntity> menuList = menuService.findRoot();
		map.put("menuList", menuList);
		return "menuManage";
	}

	@RequestMapping("/menu/loginRecordManage")
	public String loginRecordManage() {
		return "loginRecordManage";
	}

	@RequestMapping("/menu/uploadFile")
	public String uploadFile() {
		return "test_uploadFile";
	}
	
	@RequestMapping("/menu/roleManage")
	public String roleManage() {
		return "roleManage";
	}
	
	@RequestMapping("/menu/permissionManage")
	public String permissionManage() {
		return "permissionManage";
	}
	
	@RequestMapping("/menu/user_roleManage")
	public String user_roleManage(ModelMap map) {
		List<UserEntity> userList = userService.selectList(new EntityWrapper<UserEntity>());
		List<SysRoleEntity> roleList = roleService.selectList(new EntityWrapper<SysRoleEntity>());
		map.put("userList", userList);
		map.put("roleList", roleList);
		return "user_roleManage";
	}
	
	@RequestMapping("/menu/role_permisManage")
	public String role_permisManage(ModelMap map) {
		List<SysPermissionEntity> permisList = permisService.selectList(new EntityWrapper<SysPermissionEntity>());
		List<SysRoleEntity> roleList = roleService.selectList(new EntityWrapper<SysRoleEntity>());
		map.put("permisList", permisList);
		map.put("roleList", roleList);
		return "role_permisManage";
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
}
