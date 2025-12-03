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
 * The table class for the &quot;ax_CompensatoryData&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see CompensatoryData
 * @generated
 */
public class CompensatoryDataTable extends BaseTable<CompensatoryDataTable> {

	public static final CompensatoryDataTable INSTANCE =
		new CompensatoryDataTable();

	public final Column<CompensatoryDataTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CompensatoryDataTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CompensatoryDataTable, Long> createdBy = createColumn(
		"createdBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CompensatoryDataTable, Long> modifiedBy = createColumn(
		"modifiedBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CompensatoryDataTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CompensatoryDataTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<CompensatoryDataTable, Date> modifiedDate =
		createColumn(
			"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<CompensatoryDataTable, Long> compensatoryDataId =
		createColumn(
			"compensatoryDataId", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<CompensatoryDataTable, Long> employeeId = createColumn(
		"employeeId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CompensatoryDataTable, Date> dateOfCompensation =
		createColumn(
			"dateOfCompensation", Date.class, Types.TIMESTAMP,
			Column.FLAG_DEFAULT);
	public final Column<CompensatoryDataTable, Integer> requestedHours =
		createColumn(
			"requestedHours", Integer.class, Types.INTEGER,
			Column.FLAG_DEFAULT);
	public final Column<CompensatoryDataTable, Integer> approvedHours =
		createColumn(
			"approvedHours", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<CompensatoryDataTable, Long> managerId = createColumn(
		"managerId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CompensatoryDataTable, Long>
		leaveCompensatoryStatusMasterId = createColumn(
			"leaveCompensatoryStatusMasterId", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<CompensatoryDataTable, String> description =
		createColumn(
			"description", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private CompensatoryDataTable() {
		super("ax_CompensatoryData", CompensatoryDataTable::new);
	}

}