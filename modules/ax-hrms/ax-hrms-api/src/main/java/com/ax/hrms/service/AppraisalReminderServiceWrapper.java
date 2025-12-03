/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AppraisalReminderService}.
 *
 * @author Brian Wing Shun Chan
 * @see AppraisalReminderService
 * @generated
 */
public class AppraisalReminderServiceWrapper
	implements AppraisalReminderService,
			   ServiceWrapper<AppraisalReminderService> {

	public AppraisalReminderServiceWrapper() {
		this(null);
	}

	public AppraisalReminderServiceWrapper(
		AppraisalReminderService appraisalReminderService) {

		_appraisalReminderService = appraisalReminderService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _appraisalReminderService.getOSGiServiceIdentifier();
	}

	@Override
	public AppraisalReminderService getWrappedService() {
		return _appraisalReminderService;
	}

	@Override
	public void setWrappedService(
		AppraisalReminderService appraisalReminderService) {

		_appraisalReminderService = appraisalReminderService;
	}

	private AppraisalReminderService _appraisalReminderService;

}