/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link EmployeeEducationService}.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeEducationService
 * @generated
 */
public class EmployeeEducationServiceWrapper
	implements EmployeeEducationService,
			   ServiceWrapper<EmployeeEducationService> {

	public EmployeeEducationServiceWrapper() {
		this(null);
	}

	public EmployeeEducationServiceWrapper(
		EmployeeEducationService employeeEducationService) {

		_employeeEducationService = employeeEducationService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _employeeEducationService.getOSGiServiceIdentifier();
	}

	@Override
	public EmployeeEducationService getWrappedService() {
		return _employeeEducationService;
	}

	@Override
	public void setWrappedService(
		EmployeeEducationService employeeEducationService) {

		_employeeEducationService = employeeEducationService;
	}

	private EmployeeEducationService _employeeEducationService;

}