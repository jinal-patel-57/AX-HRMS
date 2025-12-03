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
 * The table class for the &quot;ax_LeaveDayType&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see LeaveDayType
 * @generated
 */
public class LeaveDayTypeTable extends BaseTable<LeaveDayTypeTable> {

	public static final LeaveDayTypeTable INSTANCE = new LeaveDayTypeTable();

	public final Column<LeaveDayTypeTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<LeaveDayTypeTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LeaveDayTypeTable, Long> createdBy = createColumn(
		"createdBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LeaveDayTypeTable, Long> modifiedBy = createColumn(
		"modifiedBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LeaveDayTypeTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LeaveDayTypeTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<LeaveDayTypeTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<LeaveDayTypeTable, Long> leaveDayTypeId = createColumn(
		"leaveDayTypeId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<LeaveDayTypeTable, Long> leaveRequestId = createColumn(
		"leaveRequestId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LeaveDayTypeTable, Date> leaveDate = createColumn(
		"leaveDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<LeaveDayTypeTable, Boolean> isHalfDay = createColumn(
		"isHalfDay", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<LeaveDayTypeTable, Boolean> isFirstHalf = createColumn(
		"isFirstHalf", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);

	private LeaveDayTypeTable() {
		super("ax_LeaveDayType", LeaveDayTypeTable::new);
	}

}