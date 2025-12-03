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

import com.ax.hrms.master.exception.NoSuchDesignationMasterException;
import com.ax.hrms.master.model.DesignationMaster;
import com.ax.hrms.master.service.base.DesignationMasterLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.ax.hrms.master.model.DesignationMaster",
	service = AopService.class
)
public class DesignationMasterLocalServiceImpl
	extends DesignationMasterLocalServiceBaseImpl {
	
	private static Log log = LogFactoryUtil.getLog(DesignationMasterLocalServiceImpl.class);
	
	public DesignationMaster findByDesignationName(String designationName)
			throws NoSuchDesignationMasterException {
		return designationMasterPersistence.findByDesignationName(designationName);
	}
	
	public boolean isNameExist(String designationName) {
		try {
			DesignationMaster designationMaster = findByDesignationName(designationName);
		}catch(NoSuchDesignationMasterException noDesignationFoundException) {
			return false;
		}
		return true;
	}

	public long getDesignationIdByName(String designationName){
		try{
			return findByDesignationName(designationName).getDesignationMasterId();
		}catch(NullPointerException | NoSuchDesignationMasterException exception) {
			log.error("DesignationMasterLocalServiceImpl >>> getDesignationIdByName ::: Exception is: "+ exception.getMessage());
		}
		return 0L;
	}
	public DesignationMaster findByDesignationNameById(long designationMasterId)
			throws NoSuchDesignationMasterException {

		return designationMasterPersistence.findByDesignationNameById(designationMasterId);
	}
	
	public List<String> getDesigNameList(){
		
		Session session = designationMasterPersistence.openSession();
		SQLQuery query = session.createSQLQuery("select distinct designationname from ax_master_designationmaster");
		QueryPos pos = QueryPos.getInstance(query);
		
		return query.list();
	}
}