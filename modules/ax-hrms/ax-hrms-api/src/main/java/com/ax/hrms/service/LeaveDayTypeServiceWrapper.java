/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link LeaveDayTypeService}.
 *
 * @author Brian Wing Shun Chan
 * @see LeaveDayTypeService
 * @generated
 */
public class LeaveDayTypeServiceWrapper
	implements LeaveDayTypeService, ServiceWrapper<LeaveDayTypeService> {

	public LeaveDayTypeServiceWrapper() {
		this(null);
	}

	public LeaveDayTypeServiceWrapper(LeaveDayTypeService leaveDayTypeService) {
		_leaveDayTypeService = leaveDayTypeService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _leaveDayTypeService.getOSGiServiceIdentifier();
	}

	@Override
	public LeaveDayTypeService getWrappedService() {
		return _leaveDayTypeService;
	}

	@Override
	public void setWrappedService(LeaveDayTypeService leaveDayTypeService) {
		_leaveDayTypeService = leaveDayTypeService;
	}

	private LeaveDayTypeService _leaveDayTypeService;

}