/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.master.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link PolicyTypeMasterService}.
 *
 * @author Brian Wing Shun Chan
 * @see PolicyTypeMasterService
 * @generated
 */
public class PolicyTypeMasterServiceWrapper
	implements PolicyTypeMasterService,
			   ServiceWrapper<PolicyTypeMasterService> {

	public PolicyTypeMasterServiceWrapper() {
		this(null);
	}

	public PolicyTypeMasterServiceWrapper(
		PolicyTypeMasterService policyTypeMasterService) {

		_policyTypeMasterService = policyTypeMasterService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _policyTypeMasterService.getOSGiServiceIdentifier();
	}

	@Override
	public PolicyTypeMasterService getWrappedService() {
		return _policyTypeMasterService;
	}

	@Override
	public void setWrappedService(
		PolicyTypeMasterService policyTypeMasterService) {

		_policyTypeMasterService = policyTypeMasterService;
	}

	private PolicyTypeMasterService _policyTypeMasterService;

}