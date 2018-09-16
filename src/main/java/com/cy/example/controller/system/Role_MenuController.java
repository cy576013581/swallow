package com.cy.example.controller.system;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.cy.example.carrier.Role_Menu_Ca;
import com.cy.example.controller.BaseController;
import com.cy.example.entity.system.SysMenuEntity;
import com.cy.example.entity.system.SysRoleEntity;
import com.cy.example.model.Result;
import com.cy.example.service.IMenuService;
import com.cy.example.service.IRoleService;
import com.cy.example.service.IRole_MenuService;
import com.cy.example.util.StringUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/system/role_menu")
public class Role_MenuController extends BaseController {

	@Autowired
	private IRole_MenuService rmService;

	@Autowired
	private IRoleService roleService;

	@Autowired
	private IMenuService menuService;

	@PutMapping
	@RequiresPermissions("role_menu_update")
	public Result<String> updates(Long roleId,String menuIds) {
		rmService.update(roleId,menuIds);
		return new Result<>(true,"更新成功！",null,null);
	}

	@GetMapping("/{rid}")
	@RequiresPermissions("role_menu_list")
	public Result<List<Role_Menu_Ca>> findAll(@PathVariable("rid")Integer rid) {
		List<Role_Menu_Ca> list = rmService.findAll(rid);
		return new Result<>(true,null,null,list);
	}

	@GetMapping("/getRoles")
	@RequiresPermissions("role_menu_list")
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

	@GetMapping("/getMenus")
	@RequiresPermissions("role_menu_list")
	public Result<List<Map<String, Object>>> getMenus(){
		List<SysMenuEntity> data = menuService.findAll();

		List<Map<String, Object>> list = new ArrayList<>();
		for (SysMenuEntity menu : data){
			if (StringUtil.IsEqual("[root]",menu.getC_node())){
				Map<String,Object> map = new HashMap<>();
				map.put("c_menuName",menu.getC_menuName());
				map.put("c_url",menu.getC_url());
				map.put("id",menu.getId());
				List<Map<String,Object>> tempList = new ArrayList<>();
				for (int i =0 ;i<data.size();i++){
					Map<String,Object> temp = new HashMap<>();
					if(StringUtil.IsEqual(String.valueOf(menu.getId()),data.get(i).getC_node().trim())){
						temp.put("c_menuName",data.get(i).getC_menuName());
						temp.put("c_url",data.get(i).getC_url());
						temp.put("id",data.get(i).getId());
						tempList.add(temp);
					}
				}
				if (tempList.size()>0){
					map.put("children",tempList);
				}
				list.add(map);
			}
		}
		return new Result<>(true,null,null,list);
	}
}
