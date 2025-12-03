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

import java.util.List;

import org.osgi.service.component.annotations.Component;

import com.ax.hrms.exception.NoSuchProjectHistoryException;
import com.ax.hrms.model.ProjectHistory;
import com.ax.hrms.service.base.ProjectHistoryLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.ax.hrms.model.ProjectHistory",
	service = AopService.class
)
public class ProjectHistoryLocalServiceImpl
	extends ProjectHistoryLocalServiceBaseImpl {
	
	public List<ProjectHistory> findByManagerId(long managerId) {
		return projectHistoryPersistence.findByManagerId(managerId);
	}
	public ProjectHistory findByProjectId(long projectId)
			throws NoSuchProjectHistoryException {
		return projectHistoryPersistence.findByProjectId(projectId);
	}

	
}