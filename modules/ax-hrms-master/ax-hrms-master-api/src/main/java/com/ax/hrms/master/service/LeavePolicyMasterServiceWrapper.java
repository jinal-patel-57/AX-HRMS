/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.master.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link LeavePolicyMasterService}.
 *
 * @author Brian Wing Shun Chan
 * @see LeavePolicyMasterService
 * @generated
 */
public class LeavePolicyMasterServiceWrapper
	implements LeavePolicyMasterService,
			   ServiceWrapper<LeavePolicyMasterService> {

	public LeavePolicyMasterServiceWrapper() {
		this(null);
	}

	public LeavePolicyMasterServiceWrapper(
		LeavePolicyMasterService leavePolicyMasterService) {

		_leavePolicyMasterService = leavePolicyMasterService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _leavePolicyMasterService.getOSGiServiceIdentifier();
	}

	@Override
	public LeavePolicyMasterService getWrappedService() {
		return _leavePolicyMasterService;
	}

	@Override
	public void setWrappedService(
		LeavePolicyMasterService leavePolicyMasterService) {

		_leavePolicyMasterService = leavePolicyMasterService;
	}

	private LeavePolicyMasterService _leavePolicyMasterService;

}