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

import com.ax.hrms.exception.NoSuchProjectEmployeeDetailsException;
import com.ax.hrms.model.ProjectEmployeeDetails;
import com.ax.hrms.service.base.ProjectEmployeeDetailsLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.ax.hrms.model.ProjectEmployeeDetails",
	service = AopService.class
)
public class ProjectEmployeeDetailsLocalServiceImpl
	extends ProjectEmployeeDetailsLocalServiceBaseImpl {
	public List<ProjectEmployeeDetails> findByProjectId(long projectId) {
		return projectEmployeeDetailsPersistence.findByProjectId(projectId);
	}
	
	public List<ProjectEmployeeDetails> findByEmployeeId(long employeeId) {
		return projectEmployeeDetailsPersistence.findByEmployeeId(employeeId);
	}
	public List<ProjectEmployeeDetails> findByEmployeeId(
			long employeeId, int start, int end) {
		return projectEmployeeDetailsPersistence.findByEmployeeId(employeeId, start, end);
	}
	public ProjectEmployeeDetails findByProjectIdAndEmployeeId(
			long projectId, long employeeId)
		throws NoSuchProjectEmployeeDetailsException{
	return projectEmployeeDetailsPersistence.findByProjectIdAndEmployeeId(projectId, employeeId);
	}
}