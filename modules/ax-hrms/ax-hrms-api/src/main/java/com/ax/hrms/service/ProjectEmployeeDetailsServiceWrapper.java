/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ProjectEmployeeDetailsService}.
 *
 * @author Brian Wing Shun Chan
 * @see ProjectEmployeeDetailsService
 * @generated
 */
public class ProjectEmployeeDetailsServiceWrapper
	implements ProjectEmployeeDetailsService,
			   ServiceWrapper<ProjectEmployeeDetailsService> {

	public ProjectEmployeeDetailsServiceWrapper() {
		this(null);
	}

	public ProjectEmployeeDetailsServiceWrapper(
		ProjectEmployeeDetailsService projectEmployeeDetailsService) {

		_projectEmployeeDetailsService = projectEmployeeDetailsService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _projectEmployeeDetailsService.getOSGiServiceIdentifier();
	}

	@Override
	public ProjectEmployeeDetailsService getWrappedService() {
		return _projectEmployeeDetailsService;
	}

	@Override
	public void setWrappedService(
		ProjectEmployeeDetailsService projectEmployeeDetailsService) {

		_projectEmployeeDetailsService = projectEmployeeDetailsService;
	}

	private ProjectEmployeeDetailsService _projectEmployeeDetailsService;

}