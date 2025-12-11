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
 * The table class for the &quot;ax_WorkFromHome&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see WorkFromHome
 * @generated
 */
public class WorkFromHomeTable extends BaseTable<WorkFromHomeTable> {

	public static final WorkFromHomeTable INSTANCE = new WorkFromHomeTable();

	public final Column<WorkFromHomeTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<WorkFromHomeTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<WorkFromHomeTable, Long> createdBy = createColumn(
		"createdBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<WorkFromHomeTable, Long> modifiedBy = createColumn(
		"modifiedBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<WorkFromHomeTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<WorkFromHomeTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<WorkFromHomeTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<WorkFromHomeTable, Long> workFromHomeRequestId =
		createColumn(
			"workFromHomeRequestId", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<WorkFromHomeTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<WorkFromHomeTable, Long> reviewerId = createColumn(
		"reviewerId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<WorkFromHomeTable, String> teamMailId = createColumn(
		"teamMailId", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<WorkFromHomeTable, String> status = createColumn(
		"status", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<WorkFromHomeTable, String> reason = createColumn(
		"reason", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<WorkFromHomeTable, Date> requestDate = createColumn(
		"requestDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<WorkFromHomeTable, Date> startDate = createColumn(
		"startDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<WorkFromHomeTable, Date> endDate = createColumn(
		"endDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private WorkFromHomeTable() {
		super("ax_WorkFromHome", WorkFromHomeTable::new);
	}

}