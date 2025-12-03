/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ProjectHistoryService}.
 *
 * @author Brian Wing Shun Chan
 * @see ProjectHistoryService
 * @generated
 */
public class ProjectHistoryServiceWrapper
	implements ProjectHistoryService, ServiceWrapper<ProjectHistoryService> {

	public ProjectHistoryServiceWrapper() {
		this(null);
	}

	public ProjectHistoryServiceWrapper(
		ProjectHistoryService projectHistoryService) {

		_projectHistoryService = projectHistoryService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _projectHistoryService.getOSGiServiceIdentifier();
	}

	@Override
	public ProjectHistoryService getWrappedService() {
		return _projectHistoryService;
	}

	@Override
	public void setWrappedService(ProjectHistoryService projectHistoryService) {
		_projectHistoryService = projectHistoryService;
	}

	private ProjectHistoryService _projectHistoryService;

}