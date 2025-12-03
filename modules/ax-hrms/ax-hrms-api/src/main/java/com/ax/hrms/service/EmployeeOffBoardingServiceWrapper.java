/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link EmployeeOffBoardingService}.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeOffBoardingService
 * @generated
 */
public class EmployeeOffBoardingServiceWrapper
	implements EmployeeOffBoardingService,
			   ServiceWrapper<EmployeeOffBoardingService> {

	public EmployeeOffBoardingServiceWrapper() {
		this(null);
	}

	public EmployeeOffBoardingServiceWrapper(
		EmployeeOffBoardingService employeeOffBoardingService) {

		_employeeOffBoardingService = employeeOffBoardingService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _employeeOffBoardingService.getOSGiServiceIdentifier();
	}

	@Override
	public EmployeeOffBoardingService getWrappedService() {
		return _employeeOffBoardingService;
	}

	@Override
	public void setWrappedService(
		EmployeeOffBoardingService employeeOffBoardingService) {

		_employeeOffBoardingService = employeeOffBoardingService;
	}

	private EmployeeOffBoardingService _employeeOffBoardingService;

}