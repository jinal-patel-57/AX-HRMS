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

import com.ax.hrms.exception.NoSuchLeaveBalanceException;
import com.ax.hrms.exception.NoSuchLeaveRequestException;
import com.ax.hrms.model.LeaveBalance;
import com.ax.hrms.model.LeaveRequest;
import com.ax.hrms.service.base.LeaveRequestLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.ax.hrms.model.LeaveRequest",
	service = AopService.class
)
public class LeaveRequestLocalServiceImpl
	extends LeaveRequestLocalServiceBaseImpl {
	
	public List<LeaveRequest> findByEmployeeId(long employeeId) {
		return leaveRequestPersistence.findByEmployeeId(employeeId);
	}
	public LeaveRequest findByleaveRequestId(long leaveRequestId)
			throws NoSuchLeaveRequestException {

		return leaveRequestPersistence.findByleaveRequestId(leaveRequestId);
	}
	
	
}