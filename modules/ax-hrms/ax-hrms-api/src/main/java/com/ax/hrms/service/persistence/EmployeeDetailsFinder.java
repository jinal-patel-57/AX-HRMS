/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public interface EmployeeDetailsFinder {

	public java.util.List<Long> getAllontinuedEmployeeIds();

	public java.util.List<Long> getEmployeeIdByNameString(String nameStr);

	public java.util.List<Long> getEmployeeIdByDepartmentId(long departmentId);

	public java.util.List<Long> getEmployeeIdByDesignationId(
		long designationId);

	public java.util.List<Long> getEmployeeIdByDesignationIdAndDepartmentId(
		long designationId, long departmentId);

}