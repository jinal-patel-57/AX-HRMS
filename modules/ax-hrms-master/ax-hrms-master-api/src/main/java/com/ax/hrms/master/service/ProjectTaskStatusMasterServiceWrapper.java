/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.master.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ProjectTaskStatusMasterService}.
 *
 * @author Brian Wing Shun Chan
 * @see ProjectTaskStatusMasterService
 * @generated
 */
public class ProjectTaskStatusMasterServiceWrapper
	implements ProjectTaskStatusMasterService,
			   ServiceWrapper<ProjectTaskStatusMasterService> {

	public ProjectTaskStatusMasterServiceWrapper() {
		this(null);
	}

	public ProjectTaskStatusMasterServiceWrapper(
		ProjectTaskStatusMasterService projectTaskStatusMasterService) {

		_projectTaskStatusMasterService = projectTaskStatusMasterService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _projectTaskStatusMasterService.getOSGiServiceIdentifier();
	}

	@Override
	public ProjectTaskStatusMasterService getWrappedService() {
		return _projectTaskStatusMasterService;
	}

	@Override
	public void setWrappedService(
		ProjectTaskStatusMasterService projectTaskStatusMasterService) {

		_projectTaskStatusMasterService = projectTaskStatusMasterService;
	}

	private ProjectTaskStatusMasterService _projectTaskStatusMasterService;

}