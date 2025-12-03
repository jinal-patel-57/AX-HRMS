/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link EmployeeDesignationService}.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeDesignationService
 * @generated
 */
public class EmployeeDesignationServiceWrapper
	implements EmployeeDesignationService,
			   ServiceWrapper<EmployeeDesignationService> {

	public EmployeeDesignationServiceWrapper() {
		this(null);
	}

	public EmployeeDesignationServiceWrapper(
		EmployeeDesignationService employeeDesignationService) {

		_employeeDesignationService = employeeDesignationService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _employeeDesignationService.getOSGiServiceIdentifier();
	}

	@Override
	public EmployeeDesignationService getWrappedService() {
		return _employeeDesignationService;
	}

	@Override
	public void setWrappedService(
		EmployeeDesignationService employeeDesignationService) {

		_employeeDesignationService = employeeDesignationService;
	}

	private EmployeeDesignationService _employeeDesignationService;

}