/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link LeaveRequestService}.
 *
 * @author Brian Wing Shun Chan
 * @see LeaveRequestService
 * @generated
 */
public class LeaveRequestServiceWrapper
	implements LeaveRequestService, ServiceWrapper<LeaveRequestService> {

	public LeaveRequestServiceWrapper() {
		this(null);
	}

	public LeaveRequestServiceWrapper(LeaveRequestService leaveRequestService) {
		_leaveRequestService = leaveRequestService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _leaveRequestService.getOSGiServiceIdentifier();
	}

	@Override
	public LeaveRequestService getWrappedService() {
		return _leaveRequestService;
	}

	@Override
	public void setWrappedService(LeaveRequestService leaveRequestService) {
		_leaveRequestService = leaveRequestService;
	}

	private LeaveRequestService _leaveRequestService;

}