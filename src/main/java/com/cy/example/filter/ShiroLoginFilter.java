package com.cy.example.filter;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.web.servlet.AdviceFilter;

import com.cy.example.entity.UserEntity;
import com.cy.example.utils.JsonUtil;
import com.cy.example.utils.StringUtil;

public class ShiroLoginFilter extends AdviceFilter {

    /**
     * 在访问controller前判断是否登录，返回json，不进行重定向。
     * @param request
     * @param response
     * @return true-继续往下执行，false-该filter过滤器已经处理，不继续执行其他过滤器
     * @throws Exception
     */
    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        UserEntity sysUser = (UserEntity) httpServletRequest.getSession().getAttribute("user");
        if (null == sysUser && !StringUtil.IsEmpty(httpServletRequest.getRequestURI(), "/login")) {
            String requestedWith = httpServletRequest.getHeader("X-Requested-With");
            if (!StringUtil.IsNullOrEmpty(requestedWith) && StringUtil.IsEmpty(requestedWith, "XMLHttpRequest")) {//如果是ajax返回指定数据
            	Map<String, Object> result = new HashMap<String, Object>();
    			result.put("flag", false);
    			result.put("msg", "登录错误！");
                httpServletResponse.setCharacterEncoding("UTF-8");
                httpServletResponse.setContentType("application/json");
                httpServletResponse.getWriter().write(JsonUtil.collectToString(result));
                return false;
            } else {//不是ajax进行重定向处理
                httpServletResponse.sendRedirect("/login/local");
                return false;
            }
        }
        return true;
    }

}