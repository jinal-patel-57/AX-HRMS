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
 * The table class for the &quot;ax_Attachment&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Attachment
 * @generated
 */
public class AttachmentTable extends BaseTable<AttachmentTable> {

	public static final AttachmentTable INSTANCE = new AttachmentTable();

	public final Column<AttachmentTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AttachmentTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AttachmentTable, Long> createdBy = createColumn(
		"createdBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AttachmentTable, Long> modifiedBy = createColumn(
		"modifiedBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AttachmentTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AttachmentTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AttachmentTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AttachmentTable, Long> attachmentId = createColumn(
		"attachmentId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<AttachmentTable, Long> timeTrackerId = createColumn(
		"timeTrackerId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private AttachmentTable() {
		super("ax_Attachment", AttachmentTable::new);
	}

}