package com.cy.example.controller.system;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.cy.example.carrier.Role_Permis_Ca;
import com.cy.example.controller.BaseController;
import com.cy.example.entity.system.SysPermissionEntity;
import com.cy.example.entity.system.SysRoleEntity;
import com.cy.example.model.Result;
import com.cy.example.service.IPermissionService;
import com.cy.example.service.IRoleService;
import com.cy.example.service.IRole_PermisService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/system/role_permis")
public class Role_PermisController extends BaseController {

	@Autowired
	private IRole_PermisService rpService;

	@Autowired
	private IRoleService roleService;

	@Autowired
	private IPermissionService permissionService;
	
	@PutMapping
    @RequiresPermissions("role_permis:update")
	public Result<String> updates(Long roleId,String permisIds) {
		rpService.update(roleId,permisIds);
		return new Result<>(true,"更新成功！",null,null);
	}

	@GetMapping("/{rid}")
    @RequiresPermissions("role_permis:list")
	public Result<List<Role_Permis_Ca>> findAll(@PathVariable("rid")Integer rid) {
		List<Role_Permis_Ca> list = rpService.findAll(rid);
		return new Result<>(true,null,null,list);
	}

	@GetMapping("/getPermis")
    @RequiresPermissions("role_permis:list")
	public Result<List<SysPermissionEntity>> getPermis(){
		List<SysPermissionEntity> data = permissionService.findAll();
		return new Result<>(true,null,null,data);
	}

	@GetMapping("/getRoles")
    @RequiresPermissions("role_permis:list")
	public Result<List<Map<String, Object>>> getRoles(){
		List<SysRoleEntity> data = roleService.selectList(new EntityWrapper<SysRoleEntity>().setSqlSelect("id,c_roleName"));

		List<Map<String, Object>> list = new ArrayList<>();
		for (SysRoleEntity user : data){
			Map<String, Object> map = new HashMap<>();
			map.put("text",user.getC_roleName());
			map.put("value",user.getId());
			list.add(map);
		}

		return new Result<>(true,null,null,list);
	}
}
