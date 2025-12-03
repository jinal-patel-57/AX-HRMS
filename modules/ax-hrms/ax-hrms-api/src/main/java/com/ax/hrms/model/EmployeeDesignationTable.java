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
 * The table class for the &quot;ax_EmployeeDesignation&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeDesignation
 * @generated
 */
public class EmployeeDesignationTable
	extends BaseTable<EmployeeDesignationTable> {

	public static final EmployeeDesignationTable INSTANCE =
		new EmployeeDesignationTable();

	public final Column<EmployeeDesignationTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EmployeeDesignationTable, Long> companyId =
		createColumn(
			"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EmployeeDesignationTable, Long> createdBy =
		createColumn(
			"createdBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EmployeeDesignationTable, Long> modifiedBy =
		createColumn(
			"modifiedBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EmployeeDesignationTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EmployeeDesignationTable, Date> createDate =
		createColumn(
			"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<EmployeeDesignationTable, Date> modifiedDate =
		createColumn(
			"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<EmployeeDesignationTable, Long> employeeDesignationId =
		createColumn(
			"employeeDesignationId", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<EmployeeDesignationTable, Long> designationMasterId =
		createColumn(
			"designationMasterId", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<EmployeeDesignationTable, Boolean> status =
		createColumn(
			"status", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<EmployeeDesignationTable, Date> startDate =
		createColumn(
			"startDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<EmployeeDesignationTable, Date> endDate = createColumn(
		"endDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<EmployeeDesignationTable, Long> employeeId =
		createColumn(
			"employeeId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private EmployeeDesignationTable() {
		super("ax_EmployeeDesignation", EmployeeDesignationTable::new);
	}

}