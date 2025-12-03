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

import com.ax.hrms.master.exception.NoSuchPolicyTypeMasterException;
import com.ax.hrms.master.model.LeaveTypeMaster;
import com.ax.hrms.master.model.PolicyTypeMaster;
import com.ax.hrms.master.service.base.PolicyTypeMasterLocalServiceBaseImpl;
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
	property = "model.class.name=com.ax.hrms.master.model.PolicyTypeMaster",
	service = AopService.class
)
public class PolicyTypeMasterLocalServiceImpl
	extends PolicyTypeMasterLocalServiceBaseImpl {
	
	public PolicyTypeMaster findByPolicyType(String policyType) throws NoSuchPolicyTypeMasterException {
		
		return policyTypeMasterPersistence.findByPolicyType(policyType);
	}
	
	public List<String> getAllPolicyType(){
		
		Session session = policyTypeMasterPersistence.openSession();
		SQLQuery query = session.createSQLQuery("select distinct policytype from ax_master_policytypemaster");
		QueryPos pos = QueryPos.getInstance(query);
		
		return query.list();
	}
}

