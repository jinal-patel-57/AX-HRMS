/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;ax_Comment&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Comment
 * @generated
 */
public class CommentTable extends BaseTable<CommentTable> {

	public static final CommentTable INSTANCE = new CommentTable();

	public final Column<CommentTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CommentTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CommentTable, Long> createdBy = createColumn(
		"createdBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CommentTable, Long> modifiedBy = createColumn(
		"modifiedBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CommentTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CommentTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<CommentTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<CommentTable, Long> commentId = createColumn(
		"commentId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<CommentTable, Long> type = createColumn(
		"type_", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CommentTable, String> action = createColumn(
		"action", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CommentTable, String> comment = createColumn(
		"comment_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CommentTable, Boolean> status = createColumn(
		"status", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<CommentTable, Long> requestId = createColumn(
		"requestId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private CommentTable() {
		super("ax_Comment", CommentTable::new);
	}

}