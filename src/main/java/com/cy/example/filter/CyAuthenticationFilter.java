package com.cy.example.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cy.example.utils.JsonUtil;

public class CyAuthenticationFilter extends AuthorizationFilter {

	private static final Logger logger = LoggerFactory
			.getLogger(CyAuthenticationFilter.class);

	@Override
	public boolean isAccessAllowed(ServletRequest request,
			ServletResponse response, Object mappedValue) throws IOException {
		// TODO Auto-generated method stub
		logger.info("-------------权限拦截---------------");
		Subject subject = getSubject(request, response);
        String[] perms = (String[]) mappedValue;

        boolean isPermitted = true;
        if (perms != null && perms.length > 0) {
            if (perms.length == 1) {
                if (!subject.isPermitted(perms[0])) {
                    isPermitted = false;
                }
            } else {
                if (!subject.isPermittedAll(perms)) {
                    isPermitted = false;
                }
            }
        }
        if (!isPermitted) {
			Map<String, Object> result = new HashMap<String, Object>();
			result.put("flag", false);
			result.put("msg", "权限不足！");
			response.getWriter().print(JsonUtil.collectToString(result));
		}
        return isPermitted;

		
	}

}
