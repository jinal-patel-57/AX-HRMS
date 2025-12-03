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

import com.ax.hrms.exception.NoSuchRolePoliciesException;
import com.ax.hrms.model.RolePolicies;
import com.ax.hrms.service.base.RolePoliciesLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.ax.hrms.model.RolePolicies",
	service = AopService.class
)
public class RolePoliciesLocalServiceImpl
	extends RolePoliciesLocalServiceBaseImpl {
	public List<RolePolicies> findByPolicyId(long policyId) {
		return rolePoliciesPersistence.findByPolicyId(policyId);
	}
	public RolePolicies findByPolicyIdAndRoleId(long policyId, long roleId) throws NoSuchRolePoliciesException {
		return rolePoliciesPersistence.findByPolicyIdAndRoleId(policyId, roleId);
	}
}