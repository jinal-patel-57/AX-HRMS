/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.master.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DepartmentMasterService}.
 *
 * @author Brian Wing Shun Chan
 * @see DepartmentMasterService
 * @generated
 */
public class DepartmentMasterServiceWrapper
	implements DepartmentMasterService,
			   ServiceWrapper<DepartmentMasterService> {

	public DepartmentMasterServiceWrapper() {
		this(null);
	}

	public DepartmentMasterServiceWrapper(
		DepartmentMasterService departmentMasterService) {

		_departmentMasterService = departmentMasterService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _departmentMasterService.getOSGiServiceIdentifier();
	}

	@Override
	public DepartmentMasterService getWrappedService() {
		return _departmentMasterService;
	}

	@Override
	public void setWrappedService(
		DepartmentMasterService departmentMasterService) {

		_departmentMasterService = departmentMasterService;
	}

	private DepartmentMasterService _departmentMasterService;

}