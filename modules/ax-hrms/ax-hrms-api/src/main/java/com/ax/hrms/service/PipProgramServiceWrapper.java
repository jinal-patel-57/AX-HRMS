/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link PipProgramService}.
 *
 * @author Brian Wing Shun Chan
 * @see PipProgramService
 * @generated
 */
public class PipProgramServiceWrapper
	implements PipProgramService, ServiceWrapper<PipProgramService> {

	public PipProgramServiceWrapper() {
		this(null);
	}

	public PipProgramServiceWrapper(PipProgramService pipProgramService) {
		_pipProgramService = pipProgramService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _pipProgramService.getOSGiServiceIdentifier();
	}

	@Override
	public PipProgramService getWrappedService() {
		return _pipProgramService;
	}

	@Override
	public void setWrappedService(PipProgramService pipProgramService) {
		_pipProgramService = pipProgramService;
	}

	private PipProgramService _pipProgramService;

}