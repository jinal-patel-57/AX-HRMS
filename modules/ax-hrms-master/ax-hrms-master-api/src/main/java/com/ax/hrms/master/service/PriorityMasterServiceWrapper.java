/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.master.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link PriorityMasterService}.
 *
 * @author Brian Wing Shun Chan
 * @see PriorityMasterService
 * @generated
 */
public class PriorityMasterServiceWrapper
	implements PriorityMasterService, ServiceWrapper<PriorityMasterService> {

	public PriorityMasterServiceWrapper() {
		this(null);
	}

	public PriorityMasterServiceWrapper(
		PriorityMasterService priorityMasterService) {

		_priorityMasterService = priorityMasterService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _priorityMasterService.getOSGiServiceIdentifier();
	}

	@Override
	public PriorityMasterService getWrappedService() {
		return _priorityMasterService;
	}

	@Override
	public void setWrappedService(PriorityMasterService priorityMasterService) {
		_priorityMasterService = priorityMasterService;
	}

	private PriorityMasterService _priorityMasterService;

}