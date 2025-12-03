/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link HolidayService}.
 *
 * @author Brian Wing Shun Chan
 * @see HolidayService
 * @generated
 */
public class HolidayServiceWrapper
	implements HolidayService, ServiceWrapper<HolidayService> {

	public HolidayServiceWrapper() {
		this(null);
	}

	public HolidayServiceWrapper(HolidayService holidayService) {
		_holidayService = holidayService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _holidayService.getOSGiServiceIdentifier();
	}

	@Override
	public HolidayService getWrappedService() {
		return _holidayService;
	}

	@Override
	public void setWrappedService(HolidayService holidayService) {
		_holidayService = holidayService;
	}

	private HolidayService _holidayService;

}