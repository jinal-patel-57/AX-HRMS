/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link EmployeeAddressService}.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeAddressService
 * @generated
 */
public class EmployeeAddressServiceWrapper
	implements EmployeeAddressService, ServiceWrapper<EmployeeAddressService> {

	public EmployeeAddressServiceWrapper() {
		this(null);
	}

	public EmployeeAddressServiceWrapper(
		EmployeeAddressService employeeAddressService) {

		_employeeAddressService = employeeAddressService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _employeeAddressService.getOSGiServiceIdentifier();
	}

	@Override
	public EmployeeAddressService getWrappedService() {
		return _employeeAddressService;
	}

	@Override
	public void setWrappedService(
		EmployeeAddressService employeeAddressService) {

		_employeeAddressService = employeeAddressService;
	}

	private EmployeeAddressService _employeeAddressService;

}