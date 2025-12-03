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
 * The table class for the &quot;ax_UpcomingProbationEmployee&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see UpcomingProbationEmployee
 * @generated
 */
public class UpcomingProbationEmployeeTable
	extends BaseTable<UpcomingProbationEmployeeTable> {

	public static final UpcomingProbationEmployeeTable INSTANCE =
		new UpcomingProbationEmployeeTable();

	public final Column<UpcomingProbationEmployeeTable, String> uuid =
		createColumn("uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<UpcomingProbationEmployeeTable, Long> companyId =
		createColumn(
			"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<UpcomingProbationEmployeeTable, Long> createdBy =
		createColumn(
			"createdBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<UpcomingProbationEmployeeTable, Long> modifiedBy =
		createColumn(
			"modifiedBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<UpcomingProbationEmployeeTable, Long> groupId =
		createColumn("groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<UpcomingProbationEmployeeTable, Date> createDate =
		createColumn(
			"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<UpcomingProbationEmployeeTable, Date> modifiedDate =
		createColumn(
			"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<UpcomingProbationEmployeeTable, Long>
		upcomingProbationEmployeeId = createColumn(
			"upcomingProbationEmployeeId", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<UpcomingProbationEmployeeTable, Long>
		probationDetailId = createColumn(
			"probationDetailId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<UpcomingProbationEmployeeTable, Integer> month =
		createColumn(
			"month", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<UpcomingProbationEmployeeTable, Integer> year =
		createColumn("year", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);

	private UpcomingProbationEmployeeTable() {
		super(
			"ax_UpcomingProbationEmployee",
			UpcomingProbationEmployeeTable::new);
	}

}