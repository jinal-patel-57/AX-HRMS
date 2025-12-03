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
 * The table class for the &quot;ax_TimeTracker&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see TimeTracker
 * @generated
 */
public class TimeTrackerTable extends BaseTable<TimeTrackerTable> {

	public static final TimeTrackerTable INSTANCE = new TimeTrackerTable();

	public final Column<TimeTrackerTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TimeTrackerTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TimeTrackerTable, Long> createdBy = createColumn(
		"createdBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TimeTrackerTable, Long> modifiedBy = createColumn(
		"modifiedBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TimeTrackerTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TimeTrackerTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<TimeTrackerTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<TimeTrackerTable, Long> timeTrackerId = createColumn(
		"timeTrackerId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<TimeTrackerTable, Long> taskId = createColumn(
		"taskId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TimeTrackerTable, Long> employeeId = createColumn(
		"employeeId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TimeTrackerTable, Date> startTime = createColumn(
		"startTime", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<TimeTrackerTable, Date> endTime = createColumn(
		"endTime", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<TimeTrackerTable, Double> duration = createColumn(
		"duration", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);
	public final Column<TimeTrackerTable, String> description = createColumn(
		"description", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TimeTrackerTable, String> managerApproveStatus =
		createColumn(
			"managerApproveStatus", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);

	private TimeTrackerTable() {
		super("ax_TimeTracker", TimeTrackerTable::new);
	}

}