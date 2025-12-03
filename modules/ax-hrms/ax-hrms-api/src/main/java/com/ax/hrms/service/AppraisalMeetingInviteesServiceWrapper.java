/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AppraisalMeetingInviteesService}.
 *
 * @author Brian Wing Shun Chan
 * @see AppraisalMeetingInviteesService
 * @generated
 */
public class AppraisalMeetingInviteesServiceWrapper
	implements AppraisalMeetingInviteesService,
			   ServiceWrapper<AppraisalMeetingInviteesService> {

	public AppraisalMeetingInviteesServiceWrapper() {
		this(null);
	}

	public AppraisalMeetingInviteesServiceWrapper(
		AppraisalMeetingInviteesService appraisalMeetingInviteesService) {

		_appraisalMeetingInviteesService = appraisalMeetingInviteesService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _appraisalMeetingInviteesService.getOSGiServiceIdentifier();
	}

	@Override
	public AppraisalMeetingInviteesService getWrappedService() {
		return _appraisalMeetingInviteesService;
	}

	@Override
	public void setWrappedService(
		AppraisalMeetingInviteesService appraisalMeetingInviteesService) {

		_appraisalMeetingInviteesService = appraisalMeetingInviteesService;
	}

	private AppraisalMeetingInviteesService _appraisalMeetingInviteesService;

}