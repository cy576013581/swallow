package com.cy.example.supplement.activiti;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;
import org.apache.shiro.SecurityUtils;

import com.cy.example.config.WebConfig;
import com.cy.example.entity.UserEntity;

@SuppressWarnings("serial")
public class ManagerTaskHandler implements TaskListener {

	public void notify(DelegateTask delegateTask) {
		//设置个人任务的办理人
		UserEntity user = (UserEntity) SecurityUtils.getSubject().getSession()
				.getAttribute(WebConfig.LOGIN_USER);
		delegateTask.setAssignee(String.valueOf(user.getN_superior().getId()));
		
	}

}