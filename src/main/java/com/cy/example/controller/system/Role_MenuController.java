package com.cy.example.controller.system;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.cy.example.carrier.Role_Menu_Ca;
import com.cy.example.controller.BaseController;
import com.cy.example.entity.system.SysMenuEntity;
import com.cy.example.entity.system.SysRoleEntity;
import com.cy.example.entity.system.SysUserEntity;
import com.cy.example.model.Page;
import com.cy.example.model.Result;
import com.cy.example.service.IMenuService;
import com.cy.example.service.IRoleService;
import com.cy.example.service.IRole_MenuService;
import com.cy.example.service.IUserService;
import com.cy.example.util.StringUtil;
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
	
	@PostMapping
	public Result<String> add(@ModelAttribute("rm") Role_Menu_Ca rm) {
//		rm.setN_roleId(Long.valueOf(" ".equals(rm.getC_roleName()) ? "0" : rm.getC_roleName()));
//		rm.setN_permisId(Long.valueOf(" ".equals(rm.getC_permisName()) ? "0" : rm.getC_permisName()));
//		Map<String, Object> map = new HashMap<String, Object>();
//		Role_Menu_Ca user = rmService.selectOne(new EntityWrapper<Role_Menu_Ca>().eq("n_roleId", rm.getN_roleId())
//				.eq("n_permisId", rm.getN_permisId()));
//		if(null == user){
//			boolean flag = rmService.insert(rm);
//			if (flag) {
//				map.put("flag", flag);
//				map.put("msg", "添加成功！");
//			} else {
//				map.put("flag", flag);
//				map.put("msg", "添加失败！");
//			}
//		}else{
//			map.put("flag", false);
//			map.put("msg", "添加失败，该角色已经存在此权限！");
//		}
//		return map;
		return null;
	}

	@PutMapping
	public Result<String> update(@ModelAttribute("rm") Role_Menu_Ca rm) {
//		rm.setN_roleId(Long.valueOf(" ".equals(rm.getC_roleName()) ? "0" : rm.getC_roleName()));
//		rm.setN_permisId(Long.valueOf(" ".equals(rm.getC_permisName()) ? "0" : rm.getC_permisName()));
//		Map<String, Object> map = new HashMap<String, Object>();
//		Role_Menu_Ca user = rmService.selectOne(new EntityWrapper<Role_Menu_Ca>().eq("n_roleId", rm.getN_roleId())
//				.eq("n_permisId", rm.getN_permisId()));
//		if(null == user){
//			boolean flag = rmService.updateById(rm);
//			if (flag) {
//				map.put("flag", flag);
//				map.put("msg", "更新成功！");
//			} else {
//				map.put("flag", flag);
//				map.put("msg", "更新失败！");
//			}
//		}else{
//			map.put("flag", false);
//			map.put("msg", "添加失败，该角色已经存在此权限！");
//		}
//		return map;
		return null;
	}

	@DeleteMapping("/{id}")
	public Result<String> delete(@PathVariable("id")Long id) {
//		boolean flag = rmService.deleteById(rm.getId());
//		Map<String, Object> map = new HashMap<String, Object>();
//		if (flag) {
//			map.put("flag", flag);
//			map.put("msg", "删除成功！");
//		} else {
//			map.put("flag", flag);
//			map.put("msg", "删除失败！");
//		}
//		return map;
		return null;
	}

	@GetMapping("/{rid}")
	public Result<List<Role_Menu_Ca>> findAll(@PathVariable("rid")Integer rid) {
		List<Role_Menu_Ca> list = rmService.findAll(rid);
		return new Result<>(true,null,null,list);
	}

	@GetMapping("/getRoles")
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
