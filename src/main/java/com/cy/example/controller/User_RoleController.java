package com.cy.example.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.cy.example.carrier.PageCa;
import com.cy.example.carrier.User_Role_Ca;
import com.cy.example.entity.UserEntity;
import com.cy.example.service.IUser_RoleService;

@Controller
@RequestMapping("/system/user_role")
public class User_RoleController extends BaseController {

	@Autowired
	private IUser_RoleService urService;
	
	@RequestMapping("/add")
	@ResponseBody
	public Map<String, Object> add(@ModelAttribute("ur") User_Role_Ca ur) {
		ur.setN_userId(Long.valueOf(ur.getC_username()));
		ur.setN_roleId(Long.valueOf(ur.getC_roleName()));
		super.add(ur);
		Map<String, Object> map = new HashMap<String, Object>();
		User_Role_Ca user = urService.selectOne(new EntityWrapper<User_Role_Ca>().eq("n_userId", ur.getN_userId()));
		if(null == user){
			boolean flag = urService.insert(ur);
			if (flag) {
				map.put("flag", flag);
				map.put("msg", "添加成功！");
			} else {
				map.put("flag", flag);
				map.put("msg", "添加失败！");
			}
		}else{
			map.put("flag", false);
			map.put("msg", "添加失败，该用户已经存在角色！");
		}
		
		
		return map;
	}

	@RequestMapping("/update")
	@ResponseBody
	public Map<String, Object> update(@ModelAttribute("ur") User_Role_Ca ur) {
		ur.setN_userId(Long.valueOf(ur.getC_username()));
		ur.setN_roleId(Long.valueOf(ur.getC_roleName()));
		super.update(ur);
		Map<String, Object> map = new HashMap<String, Object>();
		User_Role_Ca user = urService.selectOne(new EntityWrapper<User_Role_Ca>().eq("n_userId", ur.getN_userId()));
		if(null == user){
			boolean flag = urService.updateById(ur);
			if (flag) {
				map.put("flag", flag);
				map.put("msg", "更新成功！");
			} else {
				map.put("flag", flag);
				map.put("msg", "更新失败！");
			}
		}else{
			map.put("flag", false);
			map.put("msg", "添加失败，该用户已经存在角色！");
		}
		return map;
	}

	@RequestMapping("/delete")
	@ResponseBody
	public Map<String, Object> delete(@ModelAttribute("ur") User_Role_Ca ur) {
		boolean flag = urService.deleteById(ur.getId());
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

	@RequestMapping("/findAll")
	@ResponseBody
	public Map<String, Object> findAll(@ModelAttribute("page")PageCa page) {
		List<User_Role_Ca> list = urService.findAll(page);
		Map<String, Object> map = new HashMap<String, Object>();
		int sum = urService.findAllCount(page);
		map.put("rows", list);
		map.put("total", sum);
		return map;
	}

	@RequestMapping("/searchData")
	@ResponseBody
	public Map<String, Object> searchData(
			@ModelAttribute("ur") User_Role_Ca ur,
			@ModelAttribute("page") PageCa page) {
		ur.setN_userId(Long.valueOf(" ".equals(ur.getC_username()) ? "0" : ur.getC_username()));
		ur.setN_roleId(Long.valueOf(" ".equals(ur.getC_roleName()) ? "0" : ur.getC_roleName()));
		Map<String, Object> map = new HashMap<String, Object>();
		List<User_Role_Ca> list = urService.searchAll(
				ur, page);
		int sum = urService.searchAllCount(ur, page);
		map.put("rows", list);
		map.put("total", sum);
		return map;
	}

}
