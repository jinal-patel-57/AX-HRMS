/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link EmployeeDetailsService}.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeDetailsService
 * @generated
 */
public class EmployeeDetailsServiceWrapper
	implements EmployeeDetailsService, ServiceWrapper<EmployeeDetailsService> {

	public EmployeeDetailsServiceWrapper() {
		this(null);
	}

	public EmployeeDetailsServiceWrapper(
		EmployeeDetailsService employeeDetailsService) {

		_employeeDetailsService = employeeDetailsService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _employeeDetailsService.getOSGiServiceIdentifier();
	}

	@Override
	public EmployeeDetailsService getWrappedService() {
		return _employeeDetailsService;
	}

	@Override
	public void setWrappedService(
		EmployeeDetailsService employeeDetailsService) {

		_employeeDetailsService = employeeDetailsService;
	}

	private EmployeeDetailsService _employeeDetailsService;

}