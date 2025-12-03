/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AppraisalFormTemplatesService}.
 *
 * @author Brian Wing Shun Chan
 * @see AppraisalFormTemplatesService
 * @generated
 */
public class AppraisalFormTemplatesServiceWrapper
	implements AppraisalFormTemplatesService,
			   ServiceWrapper<AppraisalFormTemplatesService> {

	public AppraisalFormTemplatesServiceWrapper() {
		this(null);
	}

	public AppraisalFormTemplatesServiceWrapper(
		AppraisalFormTemplatesService appraisalFormTemplatesService) {

		_appraisalFormTemplatesService = appraisalFormTemplatesService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _appraisalFormTemplatesService.getOSGiServiceIdentifier();
	}

	@Override
	public AppraisalFormTemplatesService getWrappedService() {
		return _appraisalFormTemplatesService;
	}

	@Override
	public void setWrappedService(
		AppraisalFormTemplatesService appraisalFormTemplatesService) {

		_appraisalFormTemplatesService = appraisalFormTemplatesService;
	}

	private AppraisalFormTemplatesService _appraisalFormTemplatesService;

}