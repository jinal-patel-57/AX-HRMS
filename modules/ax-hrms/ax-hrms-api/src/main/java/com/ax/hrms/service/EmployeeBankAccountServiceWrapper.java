/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link EmployeeBankAccountService}.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeBankAccountService
 * @generated
 */
public class EmployeeBankAccountServiceWrapper
	implements EmployeeBankAccountService,
			   ServiceWrapper<EmployeeBankAccountService> {

	public EmployeeBankAccountServiceWrapper() {
		this(null);
	}

	public EmployeeBankAccountServiceWrapper(
		EmployeeBankAccountService employeeBankAccountService) {

		_employeeBankAccountService = employeeBankAccountService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _employeeBankAccountService.getOSGiServiceIdentifier();
	}

	@Override
	public EmployeeBankAccountService getWrappedService() {
		return _employeeBankAccountService;
	}

	@Override
	public void setWrappedService(
		EmployeeBankAccountService employeeBankAccountService) {

		_employeeBankAccountService = employeeBankAccountService;
	}

	private EmployeeBankAccountService _employeeBankAccountService;

}