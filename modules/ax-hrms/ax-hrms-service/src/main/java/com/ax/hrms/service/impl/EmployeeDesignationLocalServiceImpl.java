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

import com.ax.hrms.exception.NoSuchEmployeeDesignationException;
import com.ax.hrms.model.EmployeeDesignation;
import com.ax.hrms.service.base.EmployeeDesignationLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.ax.hrms.model.EmployeeDesignation",
	service = AopService.class
)
public class EmployeeDesignationLocalServiceImpl
	extends EmployeeDesignationLocalServiceBaseImpl {

	Log log = LogFactoryUtil.getLog(EmployeeDesignationLocalServiceImpl.class);
	

	public EmployeeDesignation findByEmployeeId(long employeeId)
			throws NoSuchEmployeeDesignationException {
		return employeeDesignationPersistence.findByEmployeeId(employeeId);
	}

	public long getDesignationIdByEmployeeId(long employeeId){
        try {
            return findByEmployeeId(employeeId).getDesignationMasterId();
        } catch (NoSuchEmployeeDesignationException e) {
			log.error("EmployeeDesignationLocalServiceImpl >>> getDesignationIdByEmployeeId ::: Exception is: "+e.getMessage());
        }
		return 0L;
    }
}