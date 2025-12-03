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
 * The table class for the &quot;ax_EmployeeProbationDetails&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeProbationDetails
 * @generated
 */
public class EmployeeProbationDetailsTable
	extends BaseTable<EmployeeProbationDetailsTable> {

	public static final EmployeeProbationDetailsTable INSTANCE =
		new EmployeeProbationDetailsTable();

	public final Column<EmployeeProbationDetailsTable, String> uuid =
		createColumn("uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EmployeeProbationDetailsTable, Long> companyId =
		createColumn(
			"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EmployeeProbationDetailsTable, Long> createdBy =
		createColumn(
			"createdBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EmployeeProbationDetailsTable, Long> modifiedBy =
		createColumn(
			"modifiedBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EmployeeProbationDetailsTable, Long> groupId =
		createColumn("groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EmployeeProbationDetailsTable, Date> createDate =
		createColumn(
			"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<EmployeeProbationDetailsTable, Date> modifiedDate =
		createColumn(
			"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<EmployeeProbationDetailsTable, Long> probationDetailId =
		createColumn(
			"probationDetailId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<EmployeeProbationDetailsTable, Integer>
		probationPeriod = createColumn(
			"probationPeriod", Integer.class, Types.INTEGER,
			Column.FLAG_DEFAULT);
	public final Column<EmployeeProbationDetailsTable, Date> probationEndDate =
		createColumn(
			"probationEndDate", Date.class, Types.TIMESTAMP,
			Column.FLAG_DEFAULT);
	public final Column<EmployeeProbationDetailsTable, Long> probationStatusId =
		createColumn(
			"probationStatusId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EmployeeProbationDetailsTable, Boolean> isExtended =
		createColumn(
			"isExtended", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<EmployeeProbationDetailsTable, Long> employeeId =
		createColumn(
			"employeeId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private EmployeeProbationDetailsTable() {
		super(
			"ax_EmployeeProbationDetails", EmployeeProbationDetailsTable::new);
	}

}