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

import com.ax.hrms.exception.NoSuchEmployeeDetailsException;
import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.service.base.EmployeeDetailsLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.ax.hrms.model.EmployeeDetails",
	service = AopService.class
)
public class EmployeeDetailsLocalServiceImpl extends EmployeeDetailsLocalServiceBaseImpl {
	
	public EmployeeDetails findByEmployeeId(long employeeId)
			throws NoSuchEmployeeDetailsException {
		return employeeDetailsPersistence.findByEmployeeId(employeeId);
	}
	
	public EmployeeDetails findByLrUserId(long lrUserId)
			throws NoSuchEmployeeDetailsException {
		return employeeDetailsPersistence.findByLrUserId(lrUserId);
	}
	
	@Override
	public List<EmployeeDetails> findByLeavingDate(Date date) {
		
		return employeeDetailsPersistence.findByLeavingDate(date);
	}
	public List<Long> getAllContinuedEmployeeId(){
		return employeeDetailsFinder.getAllontinuedEmployeeIds();
	}
	public List<Long> getEmployeeIdByNameString(String nameStr){
		return employeeDetailsFinder.getEmployeeIdByNameString(nameStr);
	}
	public List<Long> getEmployeeIdByDepartmentId(long departmentId){
		return employeeDetailsFinder.getEmployeeIdByDepartmentId(departmentId);
	}
	public List<Long> getEmployeeIdByDesignationId(long designationId){
		return employeeDetailsFinder.getEmployeeIdByDesignationId(designationId);
	}
	public List<Long> getEmployeeIdByDesignationIdAndDepartmentId(long designationId,long departmentId){
		return employeeDetailsFinder.getEmployeeIdByDesignationIdAndDepartmentId(designationId,departmentId);
	}
	@Override
	public List<EmployeeDetails> findByEmployeeName(
		String firstName, String lastName) {

		return employeeDetailsPersistence.findByEmployeeName(
			firstName, lastName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}
	
	public List<Object[]> findEmployeeByName(String fName, String lName){
		Session session = employeeDetailsPersistence.openSession();
		SQLQuery query = session.createSQLQuery("SELECT ed.employeeId, ed.firstName, ed.lastName, ed.officialEmail, ed.mobileNo, ed.skypeId, dm.designationName, dp.departmentName, ed.dateOfBirth, ed.leavingDate \r\n" + 
				"FROM ax_EmployeeDetails ed\r\n" + 
				"JOIN ax_EmployeeDesignation edes ON ed.employeeId = edes.employeeId \r\n" + 
				"JOIN ax_master_DesignationMaster dm ON edes.designationMasterId = dm.designationMasterId\r\n" + 
				"JOIN ax_EmployeeDepartment edep ON ed.employeeId = edep.employeeId\r\n" + 
				"JOIN ax_master_DepartmentMaster dp ON edep.departmentMasterId = dp.departmentMasterId\r\n" + 
				"WHERE ed.firstName = ? \r\n" + 
				"UNION \r\n" + 
				"SELECT ed.employeeId, ed.firstName, ed.lastName, ed.officialEmail, ed.mobileNo, ed.skypeId, dm.designationName, dp.departmentName, ed.dateOfBirth, ed.leavingDate \r\n" + 
				"FROM ax_EmployeeDetails ed\r\n" + 
				"JOIN ax_EmployeeDesignation edes ON ed.employeeId = edes.employeeId\r\n" + 
				"JOIN ax_master_DesignationMaster dm ON edes.designationMasterId = dm.designationMasterId \r\n" + 
				"JOIN ax_EmployeeDepartment edep ON ed.employeeId = edep.employeeId\r\n" + 
				"JOIN ax_master_DepartmentMaster dp ON edep.departmentMasterId = dp.departmentMasterId\r\n" + 
				"WHERE ed.lastName = ? ");
		
		QueryPos pos = QueryPos.getInstance(query);
		pos.add(fName);
		pos.add(lName);
		
		return query.list();
	}
	
	public List<Object[]> getAllDesigByEmpId(long empId){
		Session session = employeeDetailsPersistence.openSession();
		SQLQuery query = session.createSQLQuery("SELECT dm.designationName, dp.departmentName\r\n" + 
				"FROM ax_EmployeeDetails ed\r\n" + 
				"JOIN ax_EmployeeDesignation edes ON ed.employeeId = edes.employeeId\r\n" + 
				"JOIN ax_master_DesignationMaster dm ON edes.designationMasterId = dm.designationMasterId\r\n" + 
				"JOIN ax_EmployeeDepartment edep ON ed.employeeId = edep.employeeId\r\n" + 
				"JOIN ax_master_DepartmentMaster dp ON edep.departmentMasterId = dp.departmentMasterId\r\n" + 
				"WHERE ed.employeeId = ? ");
		
		QueryPos pos = QueryPos.getInstance(query);
		pos.add(empId);
		
		return query.list(); 
	}
	
	public List<Object[]> FilterByDepartmentDesignationName(String departName, String desgiName){
		Session session = employeeDetailsPersistence.openSession();
		SQLQuery query = session.createSQLQuery("SELECT ed.employeeId, ed.firstName, ed.lastName, ed.officialEmail, ed.mobileNo, ed.skypeId, dm.designationName, dp.departmentName, ed.dateOfBirth, ed.leavingDate \r\n" + 
				"FROM ax_EmployeeDetails ed\r\n" + 
				"JOIN ax_EmployeeDesignation edes ON ed.employeeId = edes.employeeId \r\n" + 
				"JOIN ax_master_DesignationMaster dm ON edes.designationMasterId = dm.designationMasterId \r\n" + 
				"JOIN ax_EmployeeDepartment edep ON ed.employeeId = edep.employeeId\r\n" + 
				"JOIN ax_master_DepartmentMaster dp ON edep.departmentMasterId = dp.departmentMasterId\r\n" + 
				"WHERE dp.departmentName = ? \r\n" + 
				"UNION\r\n" + 
				"SELECT ed.employeeId, ed.firstName, ed.lastName, ed.officialEmail, ed.mobileNo, ed.skypeId, dm.designationName, dp.departmentName, ed.dateOfBirth, ed.leavingDate \r\n" + 
				"FROM ax_EmployeeDetails ed\r\n" + 
				"JOIN ax_EmployeeDesignation edes ON ed.employeeId = edes.employeeId \r\n" + 
				"JOIN ax_master_DesignationMaster dm ON edes.designationMasterId = dm.designationMasterId \r\n" + 
				"JOIN ax_EmployeeDepartment edep ON ed.employeeId = edep.employeeId\r\n" + 
				"JOIN ax_master_DepartmentMaster dp ON edep.departmentMasterId = dp.departmentMasterId\r\n" + 
				"WHERE dm.designationName = ? ");
		
		QueryPos pos = QueryPos.getInstance(query);
		pos.add(departName);
		pos.add(desgiName);
		
		return query.list();
	}
	
	public List<Long> getEmployeeIdByLruserid(long lruserid){
		Session session = employeeDetailsPersistence.openSession();
		SQLQuery query = session.createSQLQuery("select employeeid from ax_employeedetails where lruserid = ? ");
		
		QueryPos pos = QueryPos.getInstance(query);
		pos.add(lruserid);
		
		return query.list();
	}
	public List<EmployeeDetails> findByIsTerminated(boolean isTerminated) {
		return employeeDetailsPersistence.findByIsTerminated(isTerminated);
	}
}