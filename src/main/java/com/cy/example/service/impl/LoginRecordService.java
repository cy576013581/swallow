package com.cy.example.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cy.example.model.Page;
import com.cy.example.entity.system.LoginRecordEntity;
import com.cy.example.mapper.system.LoginRecordMapper;
import com.cy.example.service.ILoginRecordService;
import com.cy.example.util.DateUtil;

@Service
public class LoginRecordService extends ServiceImpl<LoginRecordMapper, LoginRecordEntity>
	implements ILoginRecordService{
	
	@Autowired
	private LoginRecordMapper loginRecordMapper;
	

	public List<LoginRecordEntity> searchAll(LoginRecordEntity loginRecord,
			Page page) {
		// TODO Auto-generated method stub
		return loginRecordMapper.searchAll(loginRecord, page);
	}

	public int searchAllCount(LoginRecordEntity loginRecord) {
		// TODO Auto-generated method stub
		return loginRecordMapper.searchAllCount(loginRecord);
	}
	
	//近7天登陆人数统计
    public Map<String, Object> recentLoginCount(){
    	Map<String, Object> mapDate = new HashMap<String, Object>();
    	Map<String, Object> mapCount = new HashMap<String, Object>();
    	String date = DateUtil.format(DateUtil.addDay(new Date(), -7));
    	for(int i=1;i<=7;i++){
    		int daySum = loginRecordMapper.recentLoginCount(date);
    		mapDate.put("date"+i, date.substring(5));
    		mapCount.put("sum"+i, daySum);
    		date = DateUtil.format(DateUtil.addDay(DateUtil.parse(date), 1));
    	}
    	Map<String, Object> map = new HashMap<String, Object>();
    	map.put("date", mapDate);
    	map.put("sum", mapCount);
    	return map;
    }
}
