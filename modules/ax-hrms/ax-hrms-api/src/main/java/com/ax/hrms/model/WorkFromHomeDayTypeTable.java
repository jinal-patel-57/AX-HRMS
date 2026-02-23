/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;ax_WorkFromHomeDayType&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see WorkFromHomeDayType
 * @generated
 */
public class WorkFromHomeDayTypeTable
	extends BaseTable<WorkFromHomeDayTypeTable> {

	public static final WorkFromHomeDayTypeTable INSTANCE =
		new WorkFromHomeDayTypeTable();

	public final Column<WorkFromHomeDayTypeTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<WorkFromHomeDayTypeTable, Long> companyId =
		createColumn(
			"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<WorkFromHomeDayTypeTable, Long> createdBy =
		createColumn(
			"createdBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<WorkFromHomeDayTypeTable, Long> modifiedBy =
		createColumn(
			"modifiedBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<WorkFromHomeDayTypeTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<WorkFromHomeDayTypeTable, Date> createDate =
		createColumn(
			"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<WorkFromHomeDayTypeTable, Date> modifiedDate =
		createColumn(
			"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<WorkFromHomeDayTypeTable, Long> workFromHomeDayTypeId =
		createColumn(
			"workFromHomeDayTypeId", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<WorkFromHomeDayTypeTable, Long> workFromHomeRequestId =
		createColumn(
			"workFromHomeRequestId", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<WorkFromHomeDayTypeTable, Date> workFromHomeDate =
		createColumn(
			"workFromHomeDate", Date.class, Types.TIMESTAMP,
			Column.FLAG_DEFAULT);
	public final Column<WorkFromHomeDayTypeTable, Boolean> isHalfDay =
		createColumn(
			"isHalfDay", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<WorkFromHomeDayTypeTable, Boolean> isFirstHalf =
		createColumn(
			"isFirstHalf", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);

	private WorkFromHomeDayTypeTable() {
		super("ax_WorkFromHomeDayType", WorkFromHomeDayTypeTable::new);
	}

}