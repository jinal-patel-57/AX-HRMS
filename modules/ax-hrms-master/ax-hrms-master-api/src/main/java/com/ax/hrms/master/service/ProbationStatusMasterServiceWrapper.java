/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.master.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ProbationStatusMasterService}.
 *
 * @author Brian Wing Shun Chan
 * @see ProbationStatusMasterService
 * @generated
 */
public class ProbationStatusMasterServiceWrapper
	implements ProbationStatusMasterService,
			   ServiceWrapper<ProbationStatusMasterService> {

	public ProbationStatusMasterServiceWrapper() {
		this(null);
	}

	public ProbationStatusMasterServiceWrapper(
		ProbationStatusMasterService probationStatusMasterService) {

		_probationStatusMasterService = probationStatusMasterService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _probationStatusMasterService.getOSGiServiceIdentifier();
	}

	@Override
	public ProbationStatusMasterService getWrappedService() {
		return _probationStatusMasterService;
	}

	@Override
	public void setWrappedService(
		ProbationStatusMasterService probationStatusMasterService) {

		_probationStatusMasterService = probationStatusMasterService;
	}

	private ProbationStatusMasterService _probationStatusMasterService;

}