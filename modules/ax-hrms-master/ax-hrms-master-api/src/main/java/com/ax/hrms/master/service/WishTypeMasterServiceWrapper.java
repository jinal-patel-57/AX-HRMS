/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.master.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link WishTypeMasterService}.
 *
 * @author Brian Wing Shun Chan
 * @see WishTypeMasterService
 * @generated
 */
public class WishTypeMasterServiceWrapper
	implements ServiceWrapper<WishTypeMasterService>, WishTypeMasterService {

	public WishTypeMasterServiceWrapper() {
		this(null);
	}

	public WishTypeMasterServiceWrapper(
		WishTypeMasterService wishTypeMasterService) {

		_wishTypeMasterService = wishTypeMasterService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _wishTypeMasterService.getOSGiServiceIdentifier();
	}

	@Override
	public WishTypeMasterService getWrappedService() {
		return _wishTypeMasterService;
	}

	@Override
	public void setWrappedService(WishTypeMasterService wishTypeMasterService) {
		_wishTypeMasterService = wishTypeMasterService;
	}

	private WishTypeMasterService _wishTypeMasterService;

}