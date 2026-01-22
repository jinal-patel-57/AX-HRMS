/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.master.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link BranchMasterService}.
 *
 * @author Brian Wing Shun Chan
 * @see BranchMasterService
 * @generated
 */
public class BranchMasterServiceWrapper
	implements BranchMasterService, ServiceWrapper<BranchMasterService> {

	public BranchMasterServiceWrapper() {
		this(null);
	}

	public BranchMasterServiceWrapper(BranchMasterService branchMasterService) {
		_branchMasterService = branchMasterService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _branchMasterService.getOSGiServiceIdentifier();
	}

	@Override
	public BranchMasterService getWrappedService() {
		return _branchMasterService;
	}

	@Override
	public void setWrappedService(BranchMasterService branchMasterService) {
		_branchMasterService = branchMasterService;
	}

	private BranchMasterService _branchMasterService;

}