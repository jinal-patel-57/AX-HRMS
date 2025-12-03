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
 * The table class for the &quot;ax_EmployeeEducation&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeEducation
 * @generated
 */
public class EmployeeEducationTable extends BaseTable<EmployeeEducationTable> {

	public static final EmployeeEducationTable INSTANCE =
		new EmployeeEducationTable();

	public final Column<EmployeeEducationTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EmployeeEducationTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EmployeeEducationTable, Long> createdBy = createColumn(
		"createdBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EmployeeEducationTable, Long> modifiedBy = createColumn(
		"modifiedBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EmployeeEducationTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EmployeeEducationTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<EmployeeEducationTable, Date> modifiedDate =
		createColumn(
			"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<EmployeeEducationTable, Long> educationId =
		createColumn(
			"educationId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<EmployeeEducationTable, Long> levelId = createColumn(
		"levelId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EmployeeEducationTable, String> institution =
		createColumn(
			"institution", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EmployeeEducationTable, String> degree = createColumn(
		"degree", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EmployeeEducationTable, Date> startDate = createColumn(
		"startDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<EmployeeEducationTable, String> passingYear =
		createColumn(
			"passingYear", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EmployeeEducationTable, Date> endDate = createColumn(
		"endDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<EmployeeEducationTable, Long> employeeId = createColumn(
		"employeeId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private EmployeeEducationTable() {
		super("ax_EmployeeEducation", EmployeeEducationTable::new);
	}

}