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
import com.ax.hrms.model.LeaveBalance;
import com.ax.hrms.model.LeaveBalanceHistory;
import com.ax.hrms.service.base.LeaveBalanceLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.ax.hrms.model.LeaveBalance",
	service = AopService.class
)
public class LeaveBalanceLocalServiceImpl
	extends LeaveBalanceLocalServiceBaseImpl {
	
	public LeaveBalance findByEmployeeIdAndLeaveTypeMasterId(
			long employeeId, long leaveTypeMasterId)
		throws NoSuchLeaveBalanceException {
		return leaveBalancePersistence.findByEmployeeIdAndLeaveTypeMasterId(employeeId, leaveTypeMasterId);
	}
	public LeaveBalance findByEmployeeIdLeaveTypeMasterIdAndYear(
			long employeeId, long leaveTypeMasterId, int year)
		throws NoSuchLeaveBalanceException {

		return leaveBalancePersistence.findByEmployeeIdLeaveTypeMasterIdAndYear(employeeId, leaveTypeMasterId, year);
	}
	
	public List<Object[]> getLeaveReportByEmployeeId (long empId){
		Session session = leaveBalancePersistence.openSession();
		SQLQuery query = session.createSQLQuery("SELECT lm.leaveTypeName,\r\n" + 
				"	lb.noOfRemainingLeaves, lb.year\r\n" + 
				"	FROM\r\n" + 
				"	ax_LeaveBalance lb\r\n" + 
				"	JOIN\r\n" + 
				"	ax_master_LeaveTypeMaster lm \r\n" + 
				"	ON\r\n" + 
				"	lb.leaveTypeMasterId = lm.leaveTypeMasterId\r\n" + 
				"	WHERE\r\n" + 
				"	lb.employeeId = ? ");
		
		QueryPos pos = QueryPos.getInstance(query);
		pos.add(empId);
		
		return query.list(); 
	} 
	public List<LeaveBalance> findByEmployeeId(long employeeId) {
		return leaveBalancePersistence.findByEmployeeId(employeeId);

	}
	public List<LeaveBalance> findByEmployeeIdAndYear(
			long employeeId, int year) {
	return leaveBalancePersistence.findByEmployeeIdAndYear(employeeId, year);
	}
	
	public List<LeaveBalance> findByYear(int year) {
		return leaveBalancePersistence.findByYear(year);
	}
	
	public List<LeaveBalance> findByLeaveTypeMasterIdAndYear(
			long leaveTypeMasterId, int year) {
		return leaveBalancePersistence.findByLeaveTypeMasterIdAndYear(leaveTypeMasterId, year);
	}


}