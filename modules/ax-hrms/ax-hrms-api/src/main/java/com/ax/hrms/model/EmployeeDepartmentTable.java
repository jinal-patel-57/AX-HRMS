/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;ax_EmployeeDepartment&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeDepartment
 * @generated
 */
public class EmployeeDepartmentTable
	extends BaseTable<EmployeeDepartmentTable> {

	public static final EmployeeDepartmentTable INSTANCE =
		new EmployeeDepartmentTable();

	public final Column<EmployeeDepartmentTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EmployeeDepartmentTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EmployeeDepartmentTable, Long> createdBy = createColumn(
		"createdBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EmployeeDepartmentTable, Long> modifiedBy =
		createColumn(
			"modifiedBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EmployeeDepartmentTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EmployeeDepartmentTable, Date> createDate =
		createColumn(
			"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<EmployeeDepartmentTable, Date> modifiedDate =
		createColumn(
			"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<EmployeeDepartmentTable, Long> employeeDepartmentId =
		createColumn(
			"employeeDepartmentId", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<EmployeeDepartmentTable, Long> departmentMasterId =
		createColumn(
			"departmentMasterId", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<EmployeeDepartmentTable, Boolean> status = createColumn(
		"status", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<EmployeeDepartmentTable, Date> dateOfChange =
		createColumn(
			"dateOfChange", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<EmployeeDepartmentTable, Long> employeeId =
		createColumn(
			"employeeId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private EmployeeDepartmentTable() {
		super("ax_EmployeeDepartment", EmployeeDepartmentTable::new);
	}

}