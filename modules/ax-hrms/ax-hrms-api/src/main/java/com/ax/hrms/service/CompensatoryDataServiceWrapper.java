/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CompensatoryDataService}.
 *
 * @author Brian Wing Shun Chan
 * @see CompensatoryDataService
 * @generated
 */
public class CompensatoryDataServiceWrapper
	implements CompensatoryDataService,
			   ServiceWrapper<CompensatoryDataService> {

	public CompensatoryDataServiceWrapper() {
		this(null);
	}

	public CompensatoryDataServiceWrapper(
		CompensatoryDataService compensatoryDataService) {

		_compensatoryDataService = compensatoryDataService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _compensatoryDataService.getOSGiServiceIdentifier();
	}

	@Override
	public CompensatoryDataService getWrappedService() {
		return _compensatoryDataService;
	}

	@Override
	public void setWrappedService(
		CompensatoryDataService compensatoryDataService) {

		_compensatoryDataService = compensatoryDataService;
	}

	private CompensatoryDataService _compensatoryDataService;

}