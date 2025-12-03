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

package com.ax.hrms.master.service.impl;

import com.ax.hrms.master.exception.NoSuchProjectTaskStatusMasterException;
import com.ax.hrms.master.model.ProjectTaskStatusMaster;
import com.ax.hrms.master.service.base.ProjectTaskStatusMasterLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.ax.hrms.master.model.ProjectTaskStatusMaster",
	service = AopService.class
)
public class ProjectTaskStatusMasterLocalServiceImpl
	extends ProjectTaskStatusMasterLocalServiceBaseImpl {

	public ProjectTaskStatusMaster fetchBystatusNameAndApplicableFor(
			String projectTaskStatusName, String applicableFor) throws NoSuchProjectTaskStatusMasterException {

		return null;
	}

	public ProjectTaskStatusMaster findBystatusNameAndApplicableFor(
			String projectTaskStatusName, String applicableFor) throws NoSuchProjectTaskStatusMasterException {

		return null;
	}

	public ProjectTaskStatusMaster
	findByStatusNameAndApplicableForProjectAndTask(
			String projectTaskStatusName, boolean isApplicableForProject,
			boolean isApplicableForTask)
			throws NoSuchProjectTaskStatusMasterException {
		return  projectTaskStatusMasterPersistence.findByStatusNameAndApplicableForProjectAndTask(projectTaskStatusName,isApplicableForProject,isApplicableForTask);
	}

	public ProjectTaskStatusMaster findByProjectTaskStatusName(
			String projectTaskStatusName)
			throws NoSuchProjectTaskStatusMasterException {
		return projectTaskStatusMasterPersistence.findByProjectTaskStatusName(projectTaskStatusName);
	}
}