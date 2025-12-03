/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AppraisalMeetingService}.
 *
 * @author Brian Wing Shun Chan
 * @see AppraisalMeetingService
 * @generated
 */
public class AppraisalMeetingServiceWrapper
	implements AppraisalMeetingService,
			   ServiceWrapper<AppraisalMeetingService> {

	public AppraisalMeetingServiceWrapper() {
		this(null);
	}

	public AppraisalMeetingServiceWrapper(
		AppraisalMeetingService appraisalMeetingService) {

		_appraisalMeetingService = appraisalMeetingService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _appraisalMeetingService.getOSGiServiceIdentifier();
	}

	@Override
	public AppraisalMeetingService getWrappedService() {
		return _appraisalMeetingService;
	}

	@Override
	public void setWrappedService(
		AppraisalMeetingService appraisalMeetingService) {

		_appraisalMeetingService = appraisalMeetingService;
	}

	private AppraisalMeetingService _appraisalMeetingService;

}