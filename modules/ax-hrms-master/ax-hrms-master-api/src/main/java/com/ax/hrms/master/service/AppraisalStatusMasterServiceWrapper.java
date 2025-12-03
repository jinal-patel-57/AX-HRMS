/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.master.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AppraisalStatusMasterService}.
 *
 * @author Brian Wing Shun Chan
 * @see AppraisalStatusMasterService
 * @generated
 */
public class AppraisalStatusMasterServiceWrapper
	implements AppraisalStatusMasterService,
			   ServiceWrapper<AppraisalStatusMasterService> {

	public AppraisalStatusMasterServiceWrapper() {
		this(null);
	}

	public AppraisalStatusMasterServiceWrapper(
		AppraisalStatusMasterService appraisalStatusMasterService) {

		_appraisalStatusMasterService = appraisalStatusMasterService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _appraisalStatusMasterService.getOSGiServiceIdentifier();
	}

	@Override
	public AppraisalStatusMasterService getWrappedService() {
		return _appraisalStatusMasterService;
	}

	@Override
	public void setWrappedService(
		AppraisalStatusMasterService appraisalStatusMasterService) {

		_appraisalStatusMasterService = appraisalStatusMasterService;
	}

	private AppraisalStatusMasterService _appraisalStatusMasterService;

}