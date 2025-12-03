/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link EmployeeProbationDetailsService}.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeProbationDetailsService
 * @generated
 */
public class EmployeeProbationDetailsServiceWrapper
	implements EmployeeProbationDetailsService,
			   ServiceWrapper<EmployeeProbationDetailsService> {

	public EmployeeProbationDetailsServiceWrapper() {
		this(null);
	}

	public EmployeeProbationDetailsServiceWrapper(
		EmployeeProbationDetailsService employeeProbationDetailsService) {

		_employeeProbationDetailsService = employeeProbationDetailsService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _employeeProbationDetailsService.getOSGiServiceIdentifier();
	}

	@Override
	public EmployeeProbationDetailsService getWrappedService() {
		return _employeeProbationDetailsService;
	}

	@Override
	public void setWrappedService(
		EmployeeProbationDetailsService employeeProbationDetailsService) {

		_employeeProbationDetailsService = employeeProbationDetailsService;
	}

	private EmployeeProbationDetailsService _employeeProbationDetailsService;

}