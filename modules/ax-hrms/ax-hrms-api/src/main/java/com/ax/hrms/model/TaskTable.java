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
 * The table class for the &quot;ax_Task&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Task
 * @generated
 */
public class TaskTable extends BaseTable<TaskTable> {

	public static final TaskTable INSTANCE = new TaskTable();

	public final Column<TaskTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TaskTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TaskTable, Long> createdBy = createColumn(
		"createdBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TaskTable, Long> modifiedBy = createColumn(
		"modifiedBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TaskTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TaskTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<TaskTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<TaskTable, Long> taskId = createColumn(
		"taskId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<TaskTable, String> taskName = createColumn(
		"taskName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TaskTable, String> description = createColumn(
		"description", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TaskTable, Long> projectId = createColumn(
		"projectId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TaskTable, Long> mainTaskId = createColumn(
		"mainTaskId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TaskTable, Long> assignedTo = createColumn(
		"assignedTo", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TaskTable, Long> projectTaskStatusMasterId =
		createColumn(
			"projectTaskStatusMasterId", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<TaskTable, Long> priorityMasterId = createColumn(
		"priorityMasterId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TaskTable, Integer> estimatedHours = createColumn(
		"estimatedHours", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<TaskTable, Long> managerId = createColumn(
		"managerId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TaskTable, Date> assignDate = createColumn(
		"assignDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<TaskTable, Date> startDate = createColumn(
		"startDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<TaskTable, Date> dueDate = createColumn(
		"dueDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<TaskTable, Date> completeDate = createColumn(
		"completeDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<TaskTable, Boolean> isBillble = createColumn(
		"isBillble", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<TaskTable, Boolean> isSubTask = createColumn(
		"isSubTask", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);

	private TaskTable() {
		super("ax_Task", TaskTable::new);
	}

}