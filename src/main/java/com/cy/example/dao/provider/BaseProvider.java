package com.cy.example.dao.provider;

import java.lang.reflect.Field;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cy.example.config.LoginInterceptor;
import com.cy.example.entity.User;

public class BaseProvider {
	
	private Logger logger = LoggerFactory.getLogger(BaseProvider.class);
	
	public String searchData(User obj){
		// 获取对象obj的所有属性域  
		StringBuffer strSql = new StringBuffer();
		strSql.append("select * from ");
		strSql.append(obj.getClass().getSimpleName().toLowerCase()+"s where 1=1 ");
	    Field[] fields = obj.getClass().getDeclaredFields();  
	    for (Field field : fields)  
	    {  
	        String varName = field.getName();  
	        try  
	        {  	if("id".equals(varName)){
	        		continue;
	        	}
	            boolean access = field.isAccessible();  
	            if(!access) field.setAccessible(true);  
	            //从obj中获取field变量  
	            Object o = field.get(obj);  
	            System.out.println("变量： " + varName + " = " + o); 
	            if(o != null && !"".equals(o)){
	            	strSql.append(" and "+varName+" = "+o);
	            }
	            if(!access) field.setAccessible(false);  
	        }  
	        catch (Exception ex)  
	        {  
	            ex.printStackTrace();  
	        }  
	    }  
	    logger.info(strSql.toString());
		return strSql.toString();
	}
}
