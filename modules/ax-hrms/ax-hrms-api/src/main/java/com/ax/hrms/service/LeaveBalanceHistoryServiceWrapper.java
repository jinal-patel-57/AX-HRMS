/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link LeaveBalanceHistoryService}.
 *
 * @author Brian Wing Shun Chan
 * @see LeaveBalanceHistoryService
 * @generated
 */
public class LeaveBalanceHistoryServiceWrapper
	implements LeaveBalanceHistoryService,
			   ServiceWrapper<LeaveBalanceHistoryService> {

	public LeaveBalanceHistoryServiceWrapper() {
		this(null);
	}

	public LeaveBalanceHistoryServiceWrapper(
		LeaveBalanceHistoryService leaveBalanceHistoryService) {

		_leaveBalanceHistoryService = leaveBalanceHistoryService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _leaveBalanceHistoryService.getOSGiServiceIdentifier();
	}

	@Override
	public LeaveBalanceHistoryService getWrappedService() {
		return _leaveBalanceHistoryService;
	}

	@Override
	public void setWrappedService(
		LeaveBalanceHistoryService leaveBalanceHistoryService) {

		_leaveBalanceHistoryService = leaveBalanceHistoryService;
	}

	private LeaveBalanceHistoryService _leaveBalanceHistoryService;

}