/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.master.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link EducationLevelMasterService}.
 *
 * @author Brian Wing Shun Chan
 * @see EducationLevelMasterService
 * @generated
 */
public class EducationLevelMasterServiceWrapper
	implements EducationLevelMasterService,
			   ServiceWrapper<EducationLevelMasterService> {

	public EducationLevelMasterServiceWrapper() {
		this(null);
	}

	public EducationLevelMasterServiceWrapper(
		EducationLevelMasterService educationLevelMasterService) {

		_educationLevelMasterService = educationLevelMasterService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _educationLevelMasterService.getOSGiServiceIdentifier();
	}

	@Override
	public EducationLevelMasterService getWrappedService() {
		return _educationLevelMasterService;
	}

	@Override
	public void setWrappedService(
		EducationLevelMasterService educationLevelMasterService) {

		_educationLevelMasterService = educationLevelMasterService;
	}

	private EducationLevelMasterService _educationLevelMasterService;

}