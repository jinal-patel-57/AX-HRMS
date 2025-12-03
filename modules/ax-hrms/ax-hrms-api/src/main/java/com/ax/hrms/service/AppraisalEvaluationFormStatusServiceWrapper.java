/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AppraisalEvaluationFormStatusService}.
 *
 * @author Brian Wing Shun Chan
 * @see AppraisalEvaluationFormStatusService
 * @generated
 */
public class AppraisalEvaluationFormStatusServiceWrapper
	implements AppraisalEvaluationFormStatusService,
			   ServiceWrapper<AppraisalEvaluationFormStatusService> {

	public AppraisalEvaluationFormStatusServiceWrapper() {
		this(null);
	}

	public AppraisalEvaluationFormStatusServiceWrapper(
		AppraisalEvaluationFormStatusService
			appraisalEvaluationFormStatusService) {

		_appraisalEvaluationFormStatusService =
			appraisalEvaluationFormStatusService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _appraisalEvaluationFormStatusService.getOSGiServiceIdentifier();
	}

	@Override
	public AppraisalEvaluationFormStatusService getWrappedService() {
		return _appraisalEvaluationFormStatusService;
	}

	@Override
	public void setWrappedService(
		AppraisalEvaluationFormStatusService
			appraisalEvaluationFormStatusService) {

		_appraisalEvaluationFormStatusService =
			appraisalEvaluationFormStatusService;
	}

	private AppraisalEvaluationFormStatusService
		_appraisalEvaluationFormStatusService;

}