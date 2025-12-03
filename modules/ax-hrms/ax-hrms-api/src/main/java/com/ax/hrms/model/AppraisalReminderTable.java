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
 * The table class for the &quot;ax_AppraisalReminder&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see AppraisalReminder
 * @generated
 */
public class AppraisalReminderTable extends BaseTable<AppraisalReminderTable> {

	public static final AppraisalReminderTable INSTANCE =
		new AppraisalReminderTable();

	public final Column<AppraisalReminderTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AppraisalReminderTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AppraisalReminderTable, Long> createdBy = createColumn(
		"createdBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AppraisalReminderTable, Long> modifiedBy = createColumn(
		"modifiedBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AppraisalReminderTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AppraisalReminderTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AppraisalReminderTable, Date> modifiedDate =
		createColumn(
			"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AppraisalReminderTable, Long> appraisalRemainderId =
		createColumn(
			"appraisalRemainderId", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<AppraisalReminderTable, Long> employeeId = createColumn(
		"employeeId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AppraisalReminderTable, String>
		appraisalRemainderMonth = createColumn(
			"appraisalRemainderMonth", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<AppraisalReminderTable, String> appraisalRemainderYear =
		createColumn(
			"appraisalRemainderYear", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<AppraisalReminderTable, Long> appraisalProcessId =
		createColumn(
			"appraisalProcessId", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);

	private AppraisalReminderTable() {
		super("ax_AppraisalReminder", AppraisalReminderTable::new);
	}

}