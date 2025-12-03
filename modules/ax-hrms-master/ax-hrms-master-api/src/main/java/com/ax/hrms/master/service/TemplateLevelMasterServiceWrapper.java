/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.master.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TemplateLevelMasterService}.
 *
 * @author Brian Wing Shun Chan
 * @see TemplateLevelMasterService
 * @generated
 */
public class TemplateLevelMasterServiceWrapper
	implements ServiceWrapper<TemplateLevelMasterService>,
			   TemplateLevelMasterService {

	public TemplateLevelMasterServiceWrapper() {
		this(null);
	}

	public TemplateLevelMasterServiceWrapper(
		TemplateLevelMasterService templateLevelMasterService) {

		_templateLevelMasterService = templateLevelMasterService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _templateLevelMasterService.getOSGiServiceIdentifier();
	}

	@Override
	public TemplateLevelMasterService getWrappedService() {
		return _templateLevelMasterService;
	}

	@Override
	public void setWrappedService(
		TemplateLevelMasterService templateLevelMasterService) {

		_templateLevelMasterService = templateLevelMasterService;
	}

	private TemplateLevelMasterService _templateLevelMasterService;

}