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
 * The table class for the &quot;ax_LeaveTypeViewPermit&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see LeaveTypeViewPermit
 * @generated
 */
public class LeaveTypeViewPermitTable
	extends BaseTable<LeaveTypeViewPermitTable> {

	public static final LeaveTypeViewPermitTable INSTANCE =
		new LeaveTypeViewPermitTable();

	public final Column<LeaveTypeViewPermitTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<LeaveTypeViewPermitTable, Long> companyId =
		createColumn(
			"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LeaveTypeViewPermitTable, Long> createdBy =
		createColumn(
			"createdBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LeaveTypeViewPermitTable, Long> modifiedBy =
		createColumn(
			"modifiedBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LeaveTypeViewPermitTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LeaveTypeViewPermitTable, Date> createDate =
		createColumn(
			"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<LeaveTypeViewPermitTable, Date> modifiedDate =
		createColumn(
			"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<LeaveTypeViewPermitTable, Long> leaveTypeViewPermitId =
		createColumn(
			"leaveTypeViewPermitId", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<LeaveTypeViewPermitTable, Long> leaveTypeMasterId =
		createColumn(
			"leaveTypeMasterId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LeaveTypeViewPermitTable, Long> employeeId =
		createColumn(
			"employeeId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LeaveTypeViewPermitTable, Integer>
		yearOfLeaveTypeViewPermit = createColumn(
			"yearOfLeaveTypeViewPermit", Integer.class, Types.INTEGER,
			Column.FLAG_DEFAULT);

	private LeaveTypeViewPermitTable() {
		super("ax_LeaveTypeViewPermit", LeaveTypeViewPermitTable::new);
	}

}