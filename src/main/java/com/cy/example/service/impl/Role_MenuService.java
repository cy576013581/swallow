package com.cy.example.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cy.example.carrier.Role_Menu_Ca;
import com.cy.example.config.WebConfig;
import com.cy.example.entity.system.SysUserEntity;
import com.cy.example.mapper.system.Role_MenuMapper;
import com.cy.example.service.IMenuService;
import com.cy.example.service.IRole_MenuService;
import com.cy.example.util.DateUtil;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class Role_MenuService extends ServiceImpl<Role_MenuMapper, Role_Menu_Ca>
	implements IRole_MenuService{
	
	@Autowired
	private Role_MenuMapper mapper;

	@Autowired
	private IMenuService menuService;

	public List<Role_Menu_Ca> findAll(int n_roleId) {
		// TODO Auto-generated method stub
		return mapper.findAll(n_roleId);
	}

	public boolean update(Long roleId,String menuIds){
		String[] menus = menuIds.split(",");
		mapper.delete(new EntityWrapper<Role_Menu_Ca>().eq("n_roleId",roleId));
		SysUserEntity user = (SysUserEntity) SecurityUtils.getSubject().getSession()
				.getAttribute(WebConfig.LOGIN_USER);
		Arrays.stream(menus)
				.forEach(s -> {
					Role_Menu_Ca ca = new Role_Menu_Ca(roleId);
					ca.setN_menuId(Integer.valueOf(s))
						.setC_createDate(DateUtil.getNow(DateUtil.FORMAT_LONG))
					 	.setC_updateDate(DateUtil.getNow(DateUtil.FORMAT_LONG))
					 	.setN_creater(user.getId())
					 	.setN_updater(user.getId())
					 	.setN_deleted(0);
					mapper.insert(ca);
				});

		//刷新缓存
		menuService.refreshUserAll(user.getRole().getId());
		menuService.refreshFindAll();
		menuService.refreshFindRoot();
		return true;
	}
}
