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

import com.ax.hrms.master.exception.NoSuchDepartmentMasterException;
import com.ax.hrms.master.exception.NoSuchDesignationMasterException;
import com.ax.hrms.master.model.DepartmentMaster;
import com.ax.hrms.master.service.base.DepartmentMasterLocalServiceBaseImpl;

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
	property = "model.class.name=com.ax.hrms.master.model.DepartmentMaster",
	service = AopService.class
)
public class DepartmentMasterLocalServiceImpl
	extends DepartmentMasterLocalServiceBaseImpl {
	
	public DepartmentMaster findByDepartmentName(String departmentName) throws NoSuchDepartmentMasterException {
		
      return departmentMasterPersistence.findByDepartmentName(departmentName);
	}
	
	public boolean isNameExist(String departmentName) {
			try {
				DepartmentMaster departmentMaster = findByDepartmentName(departmentName);
			} catch (NoSuchDepartmentMasterException e) {
				// TODO Auto-generated catch block
				return false;
			}
		return true;
	}
	
	public DepartmentMaster findByDepartmentNameById(long departmentMasterId)
			throws NoSuchDepartmentMasterException {
		return departmentMasterPersistence.findByDepartmentNameById(departmentMasterId);
	}
	
	public List<String> getDepartNameList(){
		
		Session session = departmentMasterPersistence.openSession();
		SQLQuery query = session.createSQLQuery("select distinct departmentname from ax_master_departmentmaster");
		QueryPos pos = QueryPos.getInstance(query);
		
		return query.list();
	}
}
