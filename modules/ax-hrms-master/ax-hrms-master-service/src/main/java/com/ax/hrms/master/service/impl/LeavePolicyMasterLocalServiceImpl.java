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

import com.ax.hrms.master.exception.NoSuchLeavePolicyMasterException;
import com.ax.hrms.master.model.LeavePolicyMaster;
import com.ax.hrms.master.service.base.LeavePolicyMasterLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.ax.hrms.master.model.LeavePolicyMaster",
	service = AopService.class
)
public class LeavePolicyMasterLocalServiceImpl
	extends LeavePolicyMasterLocalServiceBaseImpl {
	
	public LeavePolicyMaster findByLeaveTypeMasterId(long leaveTypeMasterId)
			throws NoSuchLeavePolicyMasterException {
		return leavePolicyMasterPersistence.findByLeaveTypeMasterId(leaveTypeMasterId);
	}

	@Override
	public LeavePolicyMaster findByLeaveTypeMasterIdAndYearOfPolicy(long leaveTypeMasterId, int yearOfPolicy) throws NoSuchLeavePolicyMasterException {
		return null;
	}

	public LeavePolicyMaster findByLeaveTypeMasterIdAndYearOfPolicyAndEligibleAfterMonths(
			long leaveTypeMasterId, int yearOfPolicy, int eligibleAfterMonths)
			throws NoSuchLeavePolicyMasterException {
		return leavePolicyMasterPersistence.findByLeaveTypeMasterIdAndYearOfPolicyAndEligibleAfterMonths(leaveTypeMasterId, yearOfPolicy,eligibleAfterMonths);
	}

	public LeavePolicyMaster findByLeaveTypeMasterIdAndYear(
			long leaveTypeMasterId, int yearOfPolicy)
		throws NoSuchLeavePolicyMasterException {
		return leavePolicyMasterPersistence.findByLeaveTypeMasterIdAndYear(leaveTypeMasterId, yearOfPolicy);
	}
	
	public List<LeavePolicyMaster> findByYear(int yearOfPolicy) {
		return leavePolicyMasterPersistence.findByYear(yearOfPolicy);
	}
	
	}