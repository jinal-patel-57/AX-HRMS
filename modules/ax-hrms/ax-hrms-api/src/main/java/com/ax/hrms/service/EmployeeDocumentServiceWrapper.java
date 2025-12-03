/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link EmployeeDocumentService}.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeDocumentService
 * @generated
 */
public class EmployeeDocumentServiceWrapper
	implements EmployeeDocumentService,
			   ServiceWrapper<EmployeeDocumentService> {

	public EmployeeDocumentServiceWrapper() {
		this(null);
	}

	public EmployeeDocumentServiceWrapper(
		EmployeeDocumentService employeeDocumentService) {

		_employeeDocumentService = employeeDocumentService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _employeeDocumentService.getOSGiServiceIdentifier();
	}

	@Override
	public EmployeeDocumentService getWrappedService() {
		return _employeeDocumentService;
	}

	@Override
	public void setWrappedService(
		EmployeeDocumentService employeeDocumentService) {

		_employeeDocumentService = employeeDocumentService;
	}

	private EmployeeDocumentService _employeeDocumentService;

}