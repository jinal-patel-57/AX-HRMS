/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link EmployeeWishService}.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeWishService
 * @generated
 */
public class EmployeeWishServiceWrapper
	implements EmployeeWishService, ServiceWrapper<EmployeeWishService> {

	public EmployeeWishServiceWrapper() {
		this(null);
	}

	public EmployeeWishServiceWrapper(EmployeeWishService employeeWishService) {
		_employeeWishService = employeeWishService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _employeeWishService.getOSGiServiceIdentifier();
	}

	@Override
	public EmployeeWishService getWrappedService() {
		return _employeeWishService;
	}

	@Override
	public void setWrappedService(EmployeeWishService employeeWishService) {
		_employeeWishService = employeeWishService;
	}

	private EmployeeWishService _employeeWishService;

}