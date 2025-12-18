/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link WorkFromHomeRequestService}.
 *
 * @author Brian Wing Shun Chan
 * @see WorkFromHomeRequestService
 * @generated
 */
public class WorkFromHomeRequestServiceWrapper
	implements ServiceWrapper<WorkFromHomeRequestService>,
			   WorkFromHomeRequestService {

	public WorkFromHomeRequestServiceWrapper() {
		this(null);
	}

	public WorkFromHomeRequestServiceWrapper(
		WorkFromHomeRequestService workFromHomeRequestService) {

		_workFromHomeRequestService = workFromHomeRequestService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _workFromHomeRequestService.getOSGiServiceIdentifier();
	}

	@Override
	public WorkFromHomeRequestService getWrappedService() {
		return _workFromHomeRequestService;
	}

	@Override
	public void setWrappedService(
		WorkFromHomeRequestService workFromHomeRequestService) {

		_workFromHomeRequestService = workFromHomeRequestService;
	}

	private WorkFromHomeRequestService _workFromHomeRequestService;

}