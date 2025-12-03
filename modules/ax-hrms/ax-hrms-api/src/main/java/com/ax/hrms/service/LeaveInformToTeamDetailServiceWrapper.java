/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link LeaveInformToTeamDetailService}.
 *
 * @author Brian Wing Shun Chan
 * @see LeaveInformToTeamDetailService
 * @generated
 */
public class LeaveInformToTeamDetailServiceWrapper
	implements LeaveInformToTeamDetailService,
			   ServiceWrapper<LeaveInformToTeamDetailService> {

	public LeaveInformToTeamDetailServiceWrapper() {
		this(null);
	}

	public LeaveInformToTeamDetailServiceWrapper(
		LeaveInformToTeamDetailService leaveInformToTeamDetailService) {

		_leaveInformToTeamDetailService = leaveInformToTeamDetailService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _leaveInformToTeamDetailService.getOSGiServiceIdentifier();
	}

	@Override
	public LeaveInformToTeamDetailService getWrappedService() {
		return _leaveInformToTeamDetailService;
	}

	@Override
	public void setWrappedService(
		LeaveInformToTeamDetailService leaveInformToTeamDetailService) {

		_leaveInformToTeamDetailService = leaveInformToTeamDetailService;
	}

	private LeaveInformToTeamDetailService _leaveInformToTeamDetailService;

}