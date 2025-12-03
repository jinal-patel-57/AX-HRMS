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

import com.ax.hrms.master.exception.NoSuchLeaveTypeMasterException;
import com.ax.hrms.master.model.LeaveTypeMaster;
import com.ax.hrms.master.service.base.LeaveTypeMasterLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import org.osgi.service.component.annotations.Component;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.ax.hrms.master.model.LeaveTypeMaster",
	service = AopService.class
)
public class LeaveTypeMasterLocalServiceImpl
	extends LeaveTypeMasterLocalServiceBaseImpl {
	
	private Log log = LogFactoryUtil.getLog(LeaveTypeMasterLocalServiceImpl.class);

	public LeaveTypeMaster findByLeaveTypeName(String leaveTypeName)
			throws NoSuchLeaveTypeMasterException{
		return leaveTypeMasterPersistence.findByLeaveTypeName(leaveTypeName);
	}
	
	public LeaveTypeMaster findByLeaveTypeMasterId(long leaveTypeMasterId)
			throws NoSuchLeaveTypeMasterException {
		return leaveTypeMasterPersistence.findByLeaveTypeMasterId(leaveTypeMasterId);
	}

	public boolean isLeaveTypeNameExists(String leaveTypeName){
		try{
			LeaveTypeMaster leaveTypeMaster = findByLeaveTypeName(leaveTypeName);
		}catch(NoSuchLeaveTypeMasterException e){
			return false;
		}
		return true;
	}
	
	public long getLeaveTypeMasterIdByName(String leaveTypeName) {
		try{
			return findByLeaveTypeName(leaveTypeName).getLeaveTypeMasterId();
		}catch(NullPointerException | NoSuchLeaveTypeMasterException exception) {
			log.error("LeaveTypeMasterLocalServiceImpl >>> getLeaveTypeMasterIdByName ::: Exception is: "+ exception.getMessage());
		}
		return 0L;
	}


	public List<LeaveTypeMaster> findByActiveAndAppearForAll(
			boolean isActive, boolean isAppearForAll) {
		return leaveTypeMasterPersistence.findByActiveAndAppearForAll(isActive, isAppearForAll);
	}
}