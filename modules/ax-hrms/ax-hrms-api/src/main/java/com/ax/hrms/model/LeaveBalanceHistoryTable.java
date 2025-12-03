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
 * The table class for the &quot;ax_LeaveBalanceHistory&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see LeaveBalanceHistory
 * @generated
 */
public class LeaveBalanceHistoryTable
	extends BaseTable<LeaveBalanceHistoryTable> {

	public static final LeaveBalanceHistoryTable INSTANCE =
		new LeaveBalanceHistoryTable();

	public final Column<LeaveBalanceHistoryTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<LeaveBalanceHistoryTable, Long> companyId =
		createColumn(
			"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LeaveBalanceHistoryTable, Long> createdBy =
		createColumn(
			"createdBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LeaveBalanceHistoryTable, Long> modifiedBy =
		createColumn(
			"modifiedBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LeaveBalanceHistoryTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LeaveBalanceHistoryTable, Date> createDate =
		createColumn(
			"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<LeaveBalanceHistoryTable, Date> modifiedDate =
		createColumn(
			"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<LeaveBalanceHistoryTable, Long> leaveBalanceHistoryId =
		createColumn(
			"leaveBalanceHistoryId", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<LeaveBalanceHistoryTable, Long> leaveBalanceId =
		createColumn(
			"leaveBalanceId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LeaveBalanceHistoryTable, Long> employeeId =
		createColumn(
			"employeeId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LeaveBalanceHistoryTable, Long> leaveTypeMasterId =
		createColumn(
			"leaveTypeMasterId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LeaveBalanceHistoryTable, Integer> year = createColumn(
		"year", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<LeaveBalanceHistoryTable, Double> noOfUsedLeaves =
		createColumn(
			"noOfUsedLeaves", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);
	public final Column<LeaveBalanceHistoryTable, Double> noOfRemainingLeaves =
		createColumn(
			"noOfRemainingLeaves", Double.class, Types.DOUBLE,
			Column.FLAG_DEFAULT);

	private LeaveBalanceHistoryTable() {
		super("ax_LeaveBalanceHistory", LeaveBalanceHistoryTable::new);
	}

}