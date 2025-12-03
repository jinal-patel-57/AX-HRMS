/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.master.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link LeaveCompensatoryStatusMasterService}.
 *
 * @author Brian Wing Shun Chan
 * @see LeaveCompensatoryStatusMasterService
 * @generated
 */
public class LeaveCompensatoryStatusMasterServiceWrapper
	implements LeaveCompensatoryStatusMasterService,
			   ServiceWrapper<LeaveCompensatoryStatusMasterService> {

	public LeaveCompensatoryStatusMasterServiceWrapper() {
		this(null);
	}

	public LeaveCompensatoryStatusMasterServiceWrapper(
		LeaveCompensatoryStatusMasterService
			leaveCompensatoryStatusMasterService) {

		_leaveCompensatoryStatusMasterService =
			leaveCompensatoryStatusMasterService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _leaveCompensatoryStatusMasterService.getOSGiServiceIdentifier();
	}

	@Override
	public LeaveCompensatoryStatusMasterService getWrappedService() {
		return _leaveCompensatoryStatusMasterService;
	}

	@Override
	public void setWrappedService(
		LeaveCompensatoryStatusMasterService
			leaveCompensatoryStatusMasterService) {

		_leaveCompensatoryStatusMasterService =
			leaveCompensatoryStatusMasterService;
	}

	private LeaveCompensatoryStatusMasterService
		_leaveCompensatoryStatusMasterService;

}