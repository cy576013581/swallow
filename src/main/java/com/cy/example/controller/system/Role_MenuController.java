package com.cy.example.controller.system;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.cy.example.carrier.PageCa;
import com.cy.example.carrier.Role_Menu_Ca;
import com.cy.example.controller.BaseController;
import com.cy.example.service.IRole_MenuService;

@Controller
@RequestMapping("/system/role_menu")
public class Role_MenuController extends BaseController {

	@Autowired
	private IRole_MenuService rmService;
	
	@RequestMapping("/add")
	@ResponseBody
	public Map<String, Object> add(@ModelAttribute("rm") Role_Menu_Ca rm) {
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

	@RequestMapping("/update")
	@ResponseBody
	public Map<String, Object> update(@ModelAttribute("rm") Role_Menu_Ca rm) {
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

	@RequestMapping("/delete")
	@ResponseBody
	public Map<String, Object> delete(@ModelAttribute("rm") Role_Menu_Ca rm) {
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

	@RequestMapping("/findAll")
	@ResponseBody
	public Map<String, Object> findAll(@ModelAttribute("page")PageCa page) {
		List<Role_Menu_Ca> list = rmService.findAll(page);
		Map<String, Object> map = new HashMap<String, Object>();
		int sum = rmService.findAllCount(page);
		map.put("rows", list);
		map.put("total", sum);
		return map;
	}
}
