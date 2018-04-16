package com.cy.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cy.example.model.Page;
import com.cy.example.entity.system.SysNoticeEntity;
import com.cy.example.mapper.system.NoticeMapper;
import com.cy.example.service.INoticeService;

@Service
public class NoticeService extends ServiceImpl<NoticeMapper, SysNoticeEntity>
	implements INoticeService{
	
	@Autowired
	private NoticeMapper noticeMapper;
	

	public List<SysNoticeEntity> searchAll(SysNoticeEntity notice,
			Page page) {
		// TODO Auto-generated method stub
		return noticeMapper.searchAll(notice, page);
	}

	public int searchAllCount(SysNoticeEntity notice) {
		// TODO Auto-generated method stub
		return noticeMapper.searchAllCount(notice);
	}
}
