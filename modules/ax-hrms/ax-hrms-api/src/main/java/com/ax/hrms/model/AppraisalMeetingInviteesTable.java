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
 * The table class for the &quot;ax_AppraisalMeetingInvitees&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see AppraisalMeetingInvitees
 * @generated
 */
public class AppraisalMeetingInviteesTable
	extends BaseTable<AppraisalMeetingInviteesTable> {

	public static final AppraisalMeetingInviteesTable INSTANCE =
		new AppraisalMeetingInviteesTable();

	public final Column<AppraisalMeetingInviteesTable, String> uuid =
		createColumn("uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AppraisalMeetingInviteesTable, Long> companyId =
		createColumn(
			"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AppraisalMeetingInviteesTable, Long> createdBy =
		createColumn(
			"createdBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AppraisalMeetingInviteesTable, Long> modifiedBy =
		createColumn(
			"modifiedBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AppraisalMeetingInviteesTable, Long> groupId =
		createColumn("groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AppraisalMeetingInviteesTable, Date> createDate =
		createColumn(
			"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AppraisalMeetingInviteesTable, Date> modifiedDate =
		createColumn(
			"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AppraisalMeetingInviteesTable, Long>
		appraisalMeetingInviteeId = createColumn(
			"appraisalMeetingInviteeId", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<AppraisalMeetingInviteesTable, Long> employeeId =
		createColumn(
			"employeeId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AppraisalMeetingInviteesTable, Long>
		appraisalMeetingId = createColumn(
			"appraisalMeetingId", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);

	private AppraisalMeetingInviteesTable() {
		super(
			"ax_AppraisalMeetingInvitees", AppraisalMeetingInviteesTable::new);
	}

}