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
 * The table class for the &quot;ax_PipProgram&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see PipProgram
 * @generated
 */
public class PipProgramTable extends BaseTable<PipProgramTable> {

	public static final PipProgramTable INSTANCE = new PipProgramTable();

	public final Column<PipProgramTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PipProgramTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PipProgramTable, Long> createdBy = createColumn(
		"createdBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PipProgramTable, Long> modifiedBy = createColumn(
		"modifiedBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PipProgramTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PipProgramTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<PipProgramTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<PipProgramTable, Long> pipProgramId = createColumn(
		"pipProgramId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<PipProgramTable, Long> employeeId = createColumn(
		"employeeId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PipProgramTable, Date> startDate = createColumn(
		"startDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<PipProgramTable, Date> endDate = createColumn(
		"endDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<PipProgramTable, Integer> numberOfMonths = createColumn(
		"numberOfMonths", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<PipProgramTable, String> improvementAreas =
		createColumn(
			"improvementAreas", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<PipProgramTable, Date> meetingDate = createColumn(
		"meetingDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<PipProgramTable, String> status = createColumn(
		"status", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PipProgramTable, Boolean> isExtended = createColumn(
		"isExtended", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);

	private PipProgramTable() {
		super("ax_PipProgram", PipProgramTable::new);
	}

}