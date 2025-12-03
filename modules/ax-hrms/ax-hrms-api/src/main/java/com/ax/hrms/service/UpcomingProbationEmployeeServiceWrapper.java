/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link UpcomingProbationEmployeeService}.
 *
 * @author Brian Wing Shun Chan
 * @see UpcomingProbationEmployeeService
 * @generated
 */
public class UpcomingProbationEmployeeServiceWrapper
	implements ServiceWrapper<UpcomingProbationEmployeeService>,
			   UpcomingProbationEmployeeService {

	public UpcomingProbationEmployeeServiceWrapper() {
		this(null);
	}

	public UpcomingProbationEmployeeServiceWrapper(
		UpcomingProbationEmployeeService upcomingProbationEmployeeService) {

		_upcomingProbationEmployeeService = upcomingProbationEmployeeService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _upcomingProbationEmployeeService.getOSGiServiceIdentifier();
	}

	@Override
	public UpcomingProbationEmployeeService getWrappedService() {
		return _upcomingProbationEmployeeService;
	}

	@Override
	public void setWrappedService(
		UpcomingProbationEmployeeService upcomingProbationEmployeeService) {

		_upcomingProbationEmployeeService = upcomingProbationEmployeeService;
	}

	private UpcomingProbationEmployeeService _upcomingProbationEmployeeService;

}