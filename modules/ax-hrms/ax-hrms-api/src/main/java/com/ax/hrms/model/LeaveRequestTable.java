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
 * The table class for the &quot;ax_LeaveRequest&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see LeaveRequest
 * @generated
 */
public class LeaveRequestTable extends BaseTable<LeaveRequestTable> {

	public static final LeaveRequestTable INSTANCE = new LeaveRequestTable();

	public final Column<LeaveRequestTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<LeaveRequestTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LeaveRequestTable, Long> createdBy = createColumn(
		"createdBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LeaveRequestTable, Long> modifiedBy = createColumn(
		"modifiedBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LeaveRequestTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LeaveRequestTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<LeaveRequestTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<LeaveRequestTable, Long> leaveRequestId = createColumn(
		"leaveRequestId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<LeaveRequestTable, Long> employeeId = createColumn(
		"employeeId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LeaveRequestTable, Long> leaveTypeMasterId =
		createColumn(
			"leaveTypeMasterId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LeaveRequestTable, Date> startDateTime = createColumn(
		"startDateTime", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<LeaveRequestTable, Date> endDateTime = createColumn(
		"endDateTime", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<LeaveRequestTable, String> reason = createColumn(
		"reason", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<LeaveRequestTable, Long>
		leaveCompensatoryStatusMasterId = createColumn(
			"leaveCompensatoryStatusMasterId", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<LeaveRequestTable, Long> hrApprovalId = createColumn(
		"hrApprovalId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LeaveRequestTable, Long> managerApprovalId =
		createColumn(
			"managerApprovalId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LeaveRequestTable, Date> dateOfRequest = createColumn(
		"dateOfRequest", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private LeaveRequestTable() {
		super("ax_LeaveRequest", LeaveRequestTable::new);
	}

}