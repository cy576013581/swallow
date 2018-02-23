package com.cy.example.service;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;
import com.cy.example.carrier.PageCa;
import com.cy.example.entity.system.SysNoticeEntity;

public interface INoticeService extends IService<SysNoticeEntity> {
	
	List<SysNoticeEntity> searchAll(SysNoticeEntity notice, PageCa page);

	int searchAllCount(SysNoticeEntity notice);
}
