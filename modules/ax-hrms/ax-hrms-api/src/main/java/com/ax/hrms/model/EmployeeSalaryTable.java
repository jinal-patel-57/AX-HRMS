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
 * The table class for the &quot;ax_EmployeeSalary&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeSalary
 * @generated
 */
public class EmployeeSalaryTable extends BaseTable<EmployeeSalaryTable> {

	public static final EmployeeSalaryTable INSTANCE =
		new EmployeeSalaryTable();

	public final Column<EmployeeSalaryTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EmployeeSalaryTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EmployeeSalaryTable, Long> createdBy = createColumn(
		"createdBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EmployeeSalaryTable, Long> modifiedBy = createColumn(
		"modifiedBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EmployeeSalaryTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EmployeeSalaryTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<EmployeeSalaryTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<EmployeeSalaryTable, Long> salaryId = createColumn(
		"salaryId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<EmployeeSalaryTable, Double> grossSalaryCtcPm =
		createColumn(
			"grossSalaryCtcPm", Double.class, Types.DOUBLE,
			Column.FLAG_DEFAULT);
	public final Column<EmployeeSalaryTable, Double> grossSalaryCtcPa =
		createColumn(
			"grossSalaryCtcPa", Double.class, Types.DOUBLE,
			Column.FLAG_DEFAULT);
	public final Column<EmployeeSalaryTable, Long> employeeId = createColumn(
		"employeeId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EmployeeSalaryTable, Boolean> status = createColumn(
		"status", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);

	private EmployeeSalaryTable() {
		super("ax_EmployeeSalary", EmployeeSalaryTable::new);
	}

}