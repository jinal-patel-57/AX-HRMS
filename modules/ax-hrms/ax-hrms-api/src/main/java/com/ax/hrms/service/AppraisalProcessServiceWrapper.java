/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AppraisalProcessService}.
 *
 * @author Brian Wing Shun Chan
 * @see AppraisalProcessService
 * @generated
 */
public class AppraisalProcessServiceWrapper
	implements AppraisalProcessService,
			   ServiceWrapper<AppraisalProcessService> {

	public AppraisalProcessServiceWrapper() {
		this(null);
	}

	public AppraisalProcessServiceWrapper(
		AppraisalProcessService appraisalProcessService) {

		_appraisalProcessService = appraisalProcessService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _appraisalProcessService.getOSGiServiceIdentifier();
	}

	@Override
	public AppraisalProcessService getWrappedService() {
		return _appraisalProcessService;
	}

	@Override
	public void setWrappedService(
		AppraisalProcessService appraisalProcessService) {

		_appraisalProcessService = appraisalProcessService;
	}

	private AppraisalProcessService _appraisalProcessService;

}