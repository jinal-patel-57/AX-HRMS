/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.master.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link LeaveTypeMasterService}.
 *
 * @author Brian Wing Shun Chan
 * @see LeaveTypeMasterService
 * @generated
 */
public class LeaveTypeMasterServiceWrapper
	implements LeaveTypeMasterService, ServiceWrapper<LeaveTypeMasterService> {

	public LeaveTypeMasterServiceWrapper() {
		this(null);
	}

	public LeaveTypeMasterServiceWrapper(
		LeaveTypeMasterService leaveTypeMasterService) {

		_leaveTypeMasterService = leaveTypeMasterService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _leaveTypeMasterService.getOSGiServiceIdentifier();
	}

	@Override
	public LeaveTypeMasterService getWrappedService() {
		return _leaveTypeMasterService;
	}

	@Override
	public void setWrappedService(
		LeaveTypeMasterService leaveTypeMasterService) {

		_leaveTypeMasterService = leaveTypeMasterService;
	}

	private LeaveTypeMasterService _leaveTypeMasterService;

}