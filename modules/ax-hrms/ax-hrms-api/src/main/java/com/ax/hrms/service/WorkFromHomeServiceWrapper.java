/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link WorkFromHomeService}.
 *
 * @author Brian Wing Shun Chan
 * @see WorkFromHomeService
 * @generated
 */
public class WorkFromHomeServiceWrapper
	implements ServiceWrapper<WorkFromHomeService>, WorkFromHomeService {

	public WorkFromHomeServiceWrapper() {
		this(null);
	}

	public WorkFromHomeServiceWrapper(WorkFromHomeService workFromHomeService) {
		_workFromHomeService = workFromHomeService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _workFromHomeService.getOSGiServiceIdentifier();
	}

	@Override
	public WorkFromHomeService getWrappedService() {
		return _workFromHomeService;
	}

	@Override
	public void setWrappedService(WorkFromHomeService workFromHomeService) {
		_workFromHomeService = workFromHomeService;
	}

	private WorkFromHomeService _workFromHomeService;

}