/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.ax.hrms.service.impl;

import com.ax.hrms.model.Task;
import com.ax.hrms.service.base.TaskLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.ax.hrms.model.Task",
	service = AopService.class
)
public class TaskLocalServiceImpl extends TaskLocalServiceBaseImpl {
	public List<Task> findByProjectId(long projectId) {
		return taskPersistence.findByProjectId(projectId);
	}
	
	public List<Task> findByProjectId(long projectId, int start, int end) {
		return taskPersistence.findByProjectId(projectId, start, end);

	}
	public List<Task> findByProjectIdAndManagerId(
			long projectId, long managerId) {
		return taskPersistence.findByProjectIdAndManagerId(projectId, managerId);
	}
	
	public List<Task> findByProjectIdAndManagerId(
			long projectId, long managerId, int start, int end) {

		return taskPersistence.findByProjectIdAndManagerId(projectId, managerId, start, end);
	}
	
	public List<Task> findByProjectIdAndAssigneeId(
			long projectId, long assignedTo) {
		return taskPersistence.findByProjectIdAndAssigneeId(projectId, assignedTo);

	}
	public List<Task> findByProjectIdAndAssigneeId(
			long projectId, long assignedTo, int start, int end) {
		return taskPersistence.findByProjectIdAndAssigneeId(projectId, assignedTo, start, end);
	}
	
	
	public List<Task> findByManagerId(long managerId) {
		return taskPersistence.findByManagerId(managerId);
	}
	public List<Task> findByAssignedTo(long assignedTo) {
		return taskPersistence.findByAssignedTo(assignedTo);
	}
	
}