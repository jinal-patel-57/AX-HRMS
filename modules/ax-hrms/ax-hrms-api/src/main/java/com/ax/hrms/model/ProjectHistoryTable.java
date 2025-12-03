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
 * The table class for the &quot;ax_ProjectHistory&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see ProjectHistory
 * @generated
 */
public class ProjectHistoryTable extends BaseTable<ProjectHistoryTable> {

	public static final ProjectHistoryTable INSTANCE =
		new ProjectHistoryTable();

	public final Column<ProjectHistoryTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProjectHistoryTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProjectHistoryTable, Long> createdBy = createColumn(
		"createdBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProjectHistoryTable, Long> modifiedBy = createColumn(
		"modifiedBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProjectHistoryTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProjectHistoryTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ProjectHistoryTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ProjectHistoryTable, Long> projectHistoryId =
		createColumn(
			"projectHistoryId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<ProjectHistoryTable, Long> projectId = createColumn(
		"projectId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProjectHistoryTable, Long> projectTaskStatusMasterId =
		createColumn(
			"projectTaskStatusMasterId", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<ProjectHistoryTable, Long> managerId = createColumn(
		"managerId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProjectHistoryTable, Date> startDate = createColumn(
		"startDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ProjectHistoryTable, Boolean> isBillble = createColumn(
		"isBillble", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);

	private ProjectHistoryTable() {
		super("ax_ProjectHistory", ProjectHistoryTable::new);
	}

}