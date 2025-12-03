/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link PolicyService}.
 *
 * @author Brian Wing Shun Chan
 * @see PolicyService
 * @generated
 */
public class PolicyServiceWrapper
	implements PolicyService, ServiceWrapper<PolicyService> {

	public PolicyServiceWrapper() {
		this(null);
	}

	public PolicyServiceWrapper(PolicyService policyService) {
		_policyService = policyService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _policyService.getOSGiServiceIdentifier();
	}

	@Override
	public PolicyService getWrappedService() {
		return _policyService;
	}

	@Override
	public void setWrappedService(PolicyService policyService) {
		_policyService = policyService;
	}

	private PolicyService _policyService;

}