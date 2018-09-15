package com.cy.example.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cy.example.carrier.Role_Permis_Ca;
import com.cy.example.config.WebConfig;
import com.cy.example.entity.system.SysUserEntity;
import com.cy.example.mapper.system.Role_PermisMapper;
import com.cy.example.service.IRole_PermisService;
import com.cy.example.util.DateUtil;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Role_PermisService extends ServiceImpl<Role_PermisMapper, Role_Permis_Ca>
	implements IRole_PermisService{
	
	@Autowired
	private Role_PermisMapper mapper;

	public List<Role_Permis_Ca> findAll(int n_roleId) {
		// TODO Auto-generated method stub
		return mapper.findAll(n_roleId);
	}

	public boolean update(Long roleId,String permisIds){
		String[] permis = permisIds.split(",");
		mapper.delete(new EntityWrapper<Role_Permis_Ca>().eq("n_roleId",roleId));
		SysUserEntity user = (SysUserEntity) SecurityUtils.getSubject().getSession()
				.getAttribute(WebConfig.LOGIN_USER);
		for (String p: permis ) {
			Role_Permis_Ca ca = new Role_Permis_Ca(roleId);
			ca.setN_permisId(Integer.valueOf(p));
			ca.setC_createDate(DateUtil.getNow(DateUtil.FORMAT_LONG));
			ca.setC_updateDate(DateUtil.getNow(DateUtil.FORMAT_LONG));
			ca.setN_creater(user.getId());
			ca.setN_updater(user.getId());
			ca.setN_deleted(0);
			mapper.insert(ca);
		}
		return true;
	}

	
}
