/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TimeTrackerService}.
 *
 * @author Brian Wing Shun Chan
 * @see TimeTrackerService
 * @generated
 */
public class TimeTrackerServiceWrapper
	implements ServiceWrapper<TimeTrackerService>, TimeTrackerService {

	public TimeTrackerServiceWrapper() {
		this(null);
	}

	public TimeTrackerServiceWrapper(TimeTrackerService timeTrackerService) {
		_timeTrackerService = timeTrackerService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _timeTrackerService.getOSGiServiceIdentifier();
	}

	@Override
	public TimeTrackerService getWrappedService() {
		return _timeTrackerService;
	}

	@Override
	public void setWrappedService(TimeTrackerService timeTrackerService) {
		_timeTrackerService = timeTrackerService;
	}

	private TimeTrackerService _timeTrackerService;

}