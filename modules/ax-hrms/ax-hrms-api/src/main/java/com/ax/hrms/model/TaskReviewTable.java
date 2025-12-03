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
 * The table class for the &quot;ax_TaskReview&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see TaskReview
 * @generated
 */
public class TaskReviewTable extends BaseTable<TaskReviewTable> {

	public static final TaskReviewTable INSTANCE = new TaskReviewTable();

	public final Column<TaskReviewTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TaskReviewTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TaskReviewTable, Long> createdBy = createColumn(
		"createdBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TaskReviewTable, Long> modifiedBy = createColumn(
		"modifiedBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TaskReviewTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TaskReviewTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<TaskReviewTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<TaskReviewTable, Long> taskReviewId = createColumn(
		"taskReviewId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<TaskReviewTable, Long> taskId = createColumn(
		"taskId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TaskReviewTable, Long> reviewerId = createColumn(
		"reviewerId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TaskReviewTable, String> review = createColumn(
		"review", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TaskReviewTable, Date> dateOfReview = createColumn(
		"dateOfReview", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private TaskReviewTable() {
		super("ax_TaskReview", TaskReviewTable::new);
	}

}