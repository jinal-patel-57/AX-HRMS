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

import com.ax.hrms.model.LeaveBalanceHistory;
import com.ax.hrms.service.base.LeaveBalanceHistoryLocalServiceBaseImpl;

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
	property = "model.class.name=com.ax.hrms.model.LeaveBalanceHistory",
	service = AopService.class
)
public class LeaveBalanceHistoryLocalServiceImpl
	extends LeaveBalanceHistoryLocalServiceBaseImpl {
	
	public List<Integer> getAllYear(){
		
		Session session = leaveBalanceHistoryPersistence.openSession();
		SQLQuery query = session.createSQLQuery("select distinct year from ax_leavebalancehistory");
		QueryPos pos = QueryPos.getInstance(query);
		
		return query.list();
	}
	public List<LeaveBalanceHistory> findByYear(int year) {
		return leaveBalanceHistoryPersistence.findByYear(year);
	}
	public List<LeaveBalanceHistory> findByEmployeeIdAndYear(
			long employeeId, int year) {
		return leaveBalanceHistoryPersistence.findByEmployeeIdAndYear(employeeId, year);
	}
	public List<LeaveBalanceHistory> findByEmployeeId(long employeeId) {
		return leaveBalanceHistoryPersistence.findByEmployeeId(employeeId);
	}
}