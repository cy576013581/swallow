package com.cy.example.mapper.system;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cy.example.model.Page;
import com.cy.example.entity.system.SysNoticeEntity;
import com.cy.example.mapper.SuperMapper;

@Mapper
public interface NoticeMapper extends SuperMapper<SysNoticeEntity> {

	int searchAllCount(@Param("notice") SysNoticeEntity notice);

	List<SysNoticeEntity> searchAll(
			@Param("notice") SysNoticeEntity notice,
			@Param("page") Page page);
	
	public int recentLoginCount(String date);
}
