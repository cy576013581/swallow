package com.cy.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.cy.example.entity.SysPermissionEntity;
import com.cy.example.entity.SysRoleEntity;
import com.cy.example.entity.UserEntity;
import com.cy.example.service.IPermissionService;
import com.cy.example.service.IRoleService;
import com.cy.example.service.IUserService;

@Controller
@RequestMapping("/menu")
public class MenuController {
	
	@Autowired
	private IPermissionService permisService;
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IRoleService roleService;

	@RequestMapping("/home")
	public String showHome() {
		return "main/home";
	}

	@RequestMapping("/calendarManage")
	public String calendarManage() {
		return "calendarManage";
	}

	@RequestMapping("/userManage")
	public String userManage() {
		return "userManage";
	}

	@RequestMapping("/loginRecordManage")
	public String loginRecordManage() {
		return "loginRecordManage";
	}

	@RequestMapping("/uploadFile")
	public String uploadFile() {
		return "test_uploadFile";
	}
	
	@RequestMapping("/roleManage")
	public String roleManage() {
		return "roleManage";
	}
	
	@RequestMapping("/permissionManage")
	public String permissionManage() {
		return "permissionManage";
	}
	
	@RequestMapping("/user_roleManage")
	public String user_roleManage(ModelMap map) {
		List<UserEntity> userList = userService.selectList(new EntityWrapper<UserEntity>());
		List<SysRoleEntity> roleList = roleService.selectList(new EntityWrapper<SysRoleEntity>());
		map.put("userList", userList);
		map.put("roleList", roleList);
		return "user_roleManage";
	}
	
	@RequestMapping("/role_permisManage")
	public String role_permisManage(ModelMap map) {
		List<SysPermissionEntity> permisList = permisService.selectList(new EntityWrapper<SysPermissionEntity>());
		List<SysRoleEntity> roleList = roleService.selectList(new EntityWrapper<SysRoleEntity>());
		map.put("permisList", permisList);
		map.put("roleList", roleList);
		return "role_permisManage";
	}

}
