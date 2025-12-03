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
 * The table class for the &quot;ax_AppraisalMeeting&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see AppraisalMeeting
 * @generated
 */
public class AppraisalMeetingTable extends BaseTable<AppraisalMeetingTable> {

	public static final AppraisalMeetingTable INSTANCE =
		new AppraisalMeetingTable();

	public final Column<AppraisalMeetingTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AppraisalMeetingTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AppraisalMeetingTable, Long> createdBy = createColumn(
		"createdBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AppraisalMeetingTable, Long> modifiedBy = createColumn(
		"modifiedBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AppraisalMeetingTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AppraisalMeetingTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AppraisalMeetingTable, Date> modifiedDate =
		createColumn(
			"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AppraisalMeetingTable, Long> appraisalMeetingId =
		createColumn(
			"appraisalMeetingId", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<AppraisalMeetingTable, Long> appraisalProcessId =
		createColumn(
			"appraisalProcessId", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<AppraisalMeetingTable, Date> meetingDate = createColumn(
		"meetingDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AppraisalMeetingTable, Date> meetingTime = createColumn(
		"meetingTime", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AppraisalMeetingTable, Boolean> status = createColumn(
		"status", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);

	private AppraisalMeetingTable() {
		super("ax_AppraisalMeeting", AppraisalMeetingTable::new);
	}

}