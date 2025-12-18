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
 * The table class for the &quot;ax_WorkFromHomeRequest&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see WorkFromHomeRequest
 * @generated
 */
public class WorkFromHomeRequestTable
	extends BaseTable<WorkFromHomeRequestTable> {

	public static final WorkFromHomeRequestTable INSTANCE =
		new WorkFromHomeRequestTable();

	public final Column<WorkFromHomeRequestTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<WorkFromHomeRequestTable, Long> companyId =
		createColumn(
			"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<WorkFromHomeRequestTable, Long> createdBy =
		createColumn(
			"createdBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<WorkFromHomeRequestTable, Long> modifiedBy =
		createColumn(
			"modifiedBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<WorkFromHomeRequestTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<WorkFromHomeRequestTable, Date> createDate =
		createColumn(
			"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<WorkFromHomeRequestTable, Date> modifiedDate =
		createColumn(
			"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<WorkFromHomeRequestTable, Long> workFromHomeRequestId =
		createColumn(
			"workFromHomeRequestId", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<WorkFromHomeRequestTable, Long> employeeId =
		createColumn(
			"employeeId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<WorkFromHomeRequestTable, Long> reviewerId =
		createColumn(
			"reviewerId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<WorkFromHomeRequestTable, String> teamMailId =
		createColumn(
			"teamMailId", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<WorkFromHomeRequestTable, Long> status = createColumn(
		"status", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<WorkFromHomeRequestTable, String> reason = createColumn(
		"reason", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<WorkFromHomeRequestTable, Date> requestDate =
		createColumn(
			"requestDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<WorkFromHomeRequestTable, Date> startDate =
		createColumn(
			"startDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<WorkFromHomeRequestTable, Date> endDate = createColumn(
		"endDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private WorkFromHomeRequestTable() {
		super("ax_WorkFromHomeRequest", WorkFromHomeRequestTable::new);
	}

}