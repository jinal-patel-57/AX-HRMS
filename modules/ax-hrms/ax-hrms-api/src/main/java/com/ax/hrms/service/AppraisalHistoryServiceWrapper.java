/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AppraisalHistoryService}.
 *
 * @author Brian Wing Shun Chan
 * @see AppraisalHistoryService
 * @generated
 */
public class AppraisalHistoryServiceWrapper
	implements AppraisalHistoryService,
			   ServiceWrapper<AppraisalHistoryService> {

	public AppraisalHistoryServiceWrapper() {
		this(null);
	}

	public AppraisalHistoryServiceWrapper(
		AppraisalHistoryService appraisalHistoryService) {

		_appraisalHistoryService = appraisalHistoryService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _appraisalHistoryService.getOSGiServiceIdentifier();
	}

	@Override
	public AppraisalHistoryService getWrappedService() {
		return _appraisalHistoryService;
	}

	@Override
	public void setWrappedService(
		AppraisalHistoryService appraisalHistoryService) {

		_appraisalHistoryService = appraisalHistoryService;
	}

	private AppraisalHistoryService _appraisalHistoryService;

}