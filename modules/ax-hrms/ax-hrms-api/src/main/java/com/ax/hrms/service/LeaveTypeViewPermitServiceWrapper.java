/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link LeaveTypeViewPermitService}.
 *
 * @author Brian Wing Shun Chan
 * @see LeaveTypeViewPermitService
 * @generated
 */
public class LeaveTypeViewPermitServiceWrapper
	implements LeaveTypeViewPermitService,
			   ServiceWrapper<LeaveTypeViewPermitService> {

	public LeaveTypeViewPermitServiceWrapper() {
		this(null);
	}

	public LeaveTypeViewPermitServiceWrapper(
		LeaveTypeViewPermitService leaveTypeViewPermitService) {

		_leaveTypeViewPermitService = leaveTypeViewPermitService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _leaveTypeViewPermitService.getOSGiServiceIdentifier();
	}

	@Override
	public LeaveTypeViewPermitService getWrappedService() {
		return _leaveTypeViewPermitService;
	}

	@Override
	public void setWrappedService(
		LeaveTypeViewPermitService leaveTypeViewPermitService) {

		_leaveTypeViewPermitService = leaveTypeViewPermitService;
	}

	private LeaveTypeViewPermitService _leaveTypeViewPermitService;

}