/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link EmployeeSalaryService}.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeSalaryService
 * @generated
 */
public class EmployeeSalaryServiceWrapper
	implements EmployeeSalaryService, ServiceWrapper<EmployeeSalaryService> {

	public EmployeeSalaryServiceWrapper() {
		this(null);
	}

	public EmployeeSalaryServiceWrapper(
		EmployeeSalaryService employeeSalaryService) {

		_employeeSalaryService = employeeSalaryService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _employeeSalaryService.getOSGiServiceIdentifier();
	}

	@Override
	public EmployeeSalaryService getWrappedService() {
		return _employeeSalaryService;
	}

	@Override
	public void setWrappedService(EmployeeSalaryService employeeSalaryService) {
		_employeeSalaryService = employeeSalaryService;
	}

	private EmployeeSalaryService _employeeSalaryService;

}