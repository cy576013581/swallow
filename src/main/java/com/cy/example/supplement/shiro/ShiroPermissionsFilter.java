package com.cy.example.supplement.shiro;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.web.filter.authz.PermissionsAuthorizationFilter;

import com.cy.example.util.StringUtil;

@Slf4j
public class ShiroPermissionsFilter extends PermissionsAuthorizationFilter {

	/**
     * shiro认证perms资源失败后回调方法
     * @param servletRequest
     * @param servletResponse
     * @return
     * @throws IOException
     */
    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws IOException {
    	log.info("----------权限控制-------------");
    	HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        String requestedWith = httpServletRequest.getHeader("X-Requested-With");
        if (!StringUtil.IsNullOrEmpty(requestedWith) &&
                StringUtil.IsEqual(requestedWith, "XMLHttpRequest")) {//如果是ajax返回指定格式数据
        	Map<String, Object> result = new HashMap<String, Object>();
			result.put("flag", false);
			result.put("msg", "权限不足！");
            httpServletResponse.setCharacterEncoding("UTF-8");
            httpServletResponse.setContentType("application/json");
            httpServletResponse.getWriter().write(JSONObject.toJSONString(result));
        } else {//如果是普通请求进行重定向
            httpServletResponse.sendRedirect("/403");
        }
        return false;
    }
	
}
