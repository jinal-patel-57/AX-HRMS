/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.master.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DesignationMasterService}.
 *
 * @author Brian Wing Shun Chan
 * @see DesignationMasterService
 * @generated
 */
public class DesignationMasterServiceWrapper
	implements DesignationMasterService,
			   ServiceWrapper<DesignationMasterService> {

	public DesignationMasterServiceWrapper() {
		this(null);
	}

	public DesignationMasterServiceWrapper(
		DesignationMasterService designationMasterService) {

		_designationMasterService = designationMasterService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _designationMasterService.getOSGiServiceIdentifier();
	}

	@Override
	public DesignationMasterService getWrappedService() {
		return _designationMasterService;
	}

	@Override
	public void setWrappedService(
		DesignationMasterService designationMasterService) {

		_designationMasterService = designationMasterService;
	}

	private DesignationMasterService _designationMasterService;

}