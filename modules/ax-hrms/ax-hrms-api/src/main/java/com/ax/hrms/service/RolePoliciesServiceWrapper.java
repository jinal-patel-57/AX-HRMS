/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link RolePoliciesService}.
 *
 * @author Brian Wing Shun Chan
 * @see RolePoliciesService
 * @generated
 */
public class RolePoliciesServiceWrapper
	implements RolePoliciesService, ServiceWrapper<RolePoliciesService> {

	public RolePoliciesServiceWrapper() {
		this(null);
	}

	public RolePoliciesServiceWrapper(RolePoliciesService rolePoliciesService) {
		_rolePoliciesService = rolePoliciesService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _rolePoliciesService.getOSGiServiceIdentifier();
	}

	@Override
	public RolePoliciesService getWrappedService() {
		return _rolePoliciesService;
	}

	@Override
	public void setWrappedService(RolePoliciesService rolePoliciesService) {
		_rolePoliciesService = rolePoliciesService;
	}

	private RolePoliciesService _rolePoliciesService;

}