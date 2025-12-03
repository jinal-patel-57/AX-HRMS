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
 * The table class for the &quot;ax_ProjectEmployeeDetails&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see ProjectEmployeeDetails
 * @generated
 */
public class ProjectEmployeeDetailsTable
	extends BaseTable<ProjectEmployeeDetailsTable> {

	public static final ProjectEmployeeDetailsTable INSTANCE =
		new ProjectEmployeeDetailsTable();

	public final Column<ProjectEmployeeDetailsTable, String> uuid =
		createColumn("uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProjectEmployeeDetailsTable, Long> companyId =
		createColumn(
			"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProjectEmployeeDetailsTable, Long> createdBy =
		createColumn(
			"createdBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProjectEmployeeDetailsTable, Long> modifiedBy =
		createColumn(
			"modifiedBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProjectEmployeeDetailsTable, Long> groupId =
		createColumn("groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProjectEmployeeDetailsTable, Date> createDate =
		createColumn(
			"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ProjectEmployeeDetailsTable, Date> modifiedDate =
		createColumn(
			"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ProjectEmployeeDetailsTable, Long>
		projectEmployeeDetailsId = createColumn(
			"projectEmployeeDetailsId", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<ProjectEmployeeDetailsTable, Long> projectId =
		createColumn(
			"projectId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProjectEmployeeDetailsTable, Long> employeeId =
		createColumn(
			"employeeId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private ProjectEmployeeDetailsTable() {
		super("ax_ProjectEmployeeDetails", ProjectEmployeeDetailsTable::new);
	}

}