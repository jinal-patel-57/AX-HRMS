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
 * The table class for the &quot;ax_LeaveInformToTeamDetail&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see LeaveInformToTeamDetail
 * @generated
 */
public class LeaveInformToTeamDetailTable
	extends BaseTable<LeaveInformToTeamDetailTable> {

	public static final LeaveInformToTeamDetailTable INSTANCE =
		new LeaveInformToTeamDetailTable();

	public final Column<LeaveInformToTeamDetailTable, String> uuid =
		createColumn("uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<LeaveInformToTeamDetailTable, Long> companyId =
		createColumn(
			"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LeaveInformToTeamDetailTable, Long> createdBy =
		createColumn(
			"createdBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LeaveInformToTeamDetailTable, Long> modifiedBy =
		createColumn(
			"modifiedBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LeaveInformToTeamDetailTable, Long> groupId =
		createColumn("groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LeaveInformToTeamDetailTable, Date> createDate =
		createColumn(
			"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<LeaveInformToTeamDetailTable, Date> modifiedDate =
		createColumn(
			"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<LeaveInformToTeamDetailTable, Long> leaveInformId =
		createColumn(
			"leaveInformId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<LeaveInformToTeamDetailTable, Long> leaveRequestId =
		createColumn(
			"leaveRequestId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LeaveInformToTeamDetailTable, Long> employeeId =
		createColumn(
			"employeeId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private LeaveInformToTeamDetailTable() {
		super("ax_LeaveInformToTeamDetail", LeaveInformToTeamDetailTable::new);
	}

}