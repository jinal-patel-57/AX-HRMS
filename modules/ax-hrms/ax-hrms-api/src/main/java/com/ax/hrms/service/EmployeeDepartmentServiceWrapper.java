/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link EmployeeDepartmentService}.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeDepartmentService
 * @generated
 */
public class EmployeeDepartmentServiceWrapper
	implements EmployeeDepartmentService,
			   ServiceWrapper<EmployeeDepartmentService> {

	public EmployeeDepartmentServiceWrapper() {
		this(null);
	}

	public EmployeeDepartmentServiceWrapper(
		EmployeeDepartmentService employeeDepartmentService) {

		_employeeDepartmentService = employeeDepartmentService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _employeeDepartmentService.getOSGiServiceIdentifier();
	}

	@Override
	public EmployeeDepartmentService getWrappedService() {
		return _employeeDepartmentService;
	}

	@Override
	public void setWrappedService(
		EmployeeDepartmentService employeeDepartmentService) {

		_employeeDepartmentService = employeeDepartmentService;
	}

	private EmployeeDepartmentService _employeeDepartmentService;

}