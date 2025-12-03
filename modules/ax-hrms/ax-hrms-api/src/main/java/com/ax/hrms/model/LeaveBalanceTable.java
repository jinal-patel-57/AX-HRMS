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
 * The table class for the &quot;ax_LeaveBalance&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see LeaveBalance
 * @generated
 */
public class LeaveBalanceTable extends BaseTable<LeaveBalanceTable> {

	public static final LeaveBalanceTable INSTANCE = new LeaveBalanceTable();

	public final Column<LeaveBalanceTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<LeaveBalanceTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LeaveBalanceTable, Long> createdBy = createColumn(
		"createdBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LeaveBalanceTable, Long> modifiedBy = createColumn(
		"modifiedBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LeaveBalanceTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LeaveBalanceTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<LeaveBalanceTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<LeaveBalanceTable, Long> leaveBalanceId = createColumn(
		"leaveBalanceId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<LeaveBalanceTable, Long> employeeId = createColumn(
		"employeeId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LeaveBalanceTable, Long> leaveTypeMasterId =
		createColumn(
			"leaveTypeMasterId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LeaveBalanceTable, Integer> year = createColumn(
		"year", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<LeaveBalanceTable, Double> noOfUsedLeaves =
		createColumn(
			"noOfUsedLeaves", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);
	public final Column<LeaveBalanceTable, Double> noOfRemainingLeaves =
		createColumn(
			"noOfRemainingLeaves", Double.class, Types.DOUBLE,
			Column.FLAG_DEFAULT);

	private LeaveBalanceTable() {
		super("ax_LeaveBalance", LeaveBalanceTable::new);
	}

}