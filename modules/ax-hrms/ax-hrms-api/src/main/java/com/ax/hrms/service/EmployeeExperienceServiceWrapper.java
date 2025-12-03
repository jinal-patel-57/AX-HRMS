/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link EmployeeExperienceService}.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeExperienceService
 * @generated
 */
public class EmployeeExperienceServiceWrapper
	implements EmployeeExperienceService,
			   ServiceWrapper<EmployeeExperienceService> {

	public EmployeeExperienceServiceWrapper() {
		this(null);
	}

	public EmployeeExperienceServiceWrapper(
		EmployeeExperienceService employeeExperienceService) {

		_employeeExperienceService = employeeExperienceService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _employeeExperienceService.getOSGiServiceIdentifier();
	}

	@Override
	public EmployeeExperienceService getWrappedService() {
		return _employeeExperienceService;
	}

	@Override
	public void setWrappedService(
		EmployeeExperienceService employeeExperienceService) {

		_employeeExperienceService = employeeExperienceService;
	}

	private EmployeeExperienceService _employeeExperienceService;

}