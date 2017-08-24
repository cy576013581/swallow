package com.cy.example.service.impl;

import java.util.Date;

import com.cy.example.entity.UserEntity;
import com.cy.example.utils.DateUtil;
import com.cy.example.utils.SecrecyUtil;

public class BaseServiceImpl {

	public void add(UserEntity user) {
		user.setC_createDate(DateUtil.getNow());
		user.setC_updateDate(DateUtil.getNow());
//		user.setN_creater(n_creater);
//		user.setN_updater(n_updater);
		user.setN_deleted(0);
    }
}
