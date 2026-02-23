/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link WorkFromHomeDayTypeService}.
 *
 * @author Brian Wing Shun Chan
 * @see WorkFromHomeDayTypeService
 * @generated
 */
public class WorkFromHomeDayTypeServiceWrapper
	implements ServiceWrapper<WorkFromHomeDayTypeService>,
			   WorkFromHomeDayTypeService {

	public WorkFromHomeDayTypeServiceWrapper() {
		this(null);
	}

	public WorkFromHomeDayTypeServiceWrapper(
		WorkFromHomeDayTypeService workFromHomeDayTypeService) {

		_workFromHomeDayTypeService = workFromHomeDayTypeService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _workFromHomeDayTypeService.getOSGiServiceIdentifier();
	}

	@Override
	public WorkFromHomeDayTypeService getWrappedService() {
		return _workFromHomeDayTypeService;
	}

	@Override
	public void setWrappedService(
		WorkFromHomeDayTypeService workFromHomeDayTypeService) {

		_workFromHomeDayTypeService = workFromHomeDayTypeService;
	}

	private WorkFromHomeDayTypeService _workFromHomeDayTypeService;

}