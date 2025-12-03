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
 * The table class for the &quot;ax_Holiday&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Holiday
 * @generated
 */
public class HolidayTable extends BaseTable<HolidayTable> {

	public static final HolidayTable INSTANCE = new HolidayTable();

	public final Column<HolidayTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<HolidayTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<HolidayTable, Long> createdBy = createColumn(
		"createdBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<HolidayTable, Long> modifiedBy = createColumn(
		"modifiedBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<HolidayTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<HolidayTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<HolidayTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<HolidayTable, Long> holidayId = createColumn(
		"holidayId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<HolidayTable, String> holidayName = createColumn(
		"holidayName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<HolidayTable, Date> date = createColumn(
		"date_", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<HolidayTable, String> description = createColumn(
		"description", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<HolidayTable, Integer> year = createColumn(
		"year", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<HolidayTable, Boolean> isFloater = createColumn(
		"isFloater", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);

	private HolidayTable() {
		super("ax_Holiday", HolidayTable::new);
	}

}