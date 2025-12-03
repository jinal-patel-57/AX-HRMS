/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link EmployeeUanEsicService}.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeUanEsicService
 * @generated
 */
public class EmployeeUanEsicServiceWrapper
	implements EmployeeUanEsicService, ServiceWrapper<EmployeeUanEsicService> {

	public EmployeeUanEsicServiceWrapper() {
		this(null);
	}

	public EmployeeUanEsicServiceWrapper(
		EmployeeUanEsicService employeeUanEsicService) {

		_employeeUanEsicService = employeeUanEsicService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _employeeUanEsicService.getOSGiServiceIdentifier();
	}

	@Override
	public EmployeeUanEsicService getWrappedService() {
		return _employeeUanEsicService;
	}

	@Override
	public void setWrappedService(
		EmployeeUanEsicService employeeUanEsicService) {

		_employeeUanEsicService = employeeUanEsicService;
	}

	private EmployeeUanEsicService _employeeUanEsicService;

}