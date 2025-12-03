/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.master.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;ax_master_ProjectTaskStatusMaster&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see ProjectTaskStatusMaster
 * @generated
 */
public class ProjectTaskStatusMasterTable
	extends BaseTable<ProjectTaskStatusMasterTable> {

	public static final ProjectTaskStatusMasterTable INSTANCE =
		new ProjectTaskStatusMasterTable();

	public final Column<ProjectTaskStatusMasterTable, Long>
		projectTaskStatusMasterId = createColumn(
			"projectTaskStatusMasterId", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<ProjectTaskStatusMasterTable, Long> companyId =
		createColumn(
			"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProjectTaskStatusMasterTable, Long> createdBy =
		createColumn(
			"createdBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProjectTaskStatusMasterTable, Long> modifiedBy =
		createColumn(
			"modifiedBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProjectTaskStatusMasterTable, Long> groupId =
		createColumn("groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProjectTaskStatusMasterTable, Date> createDate =
		createColumn(
			"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ProjectTaskStatusMasterTable, Date> modifiedDate =
		createColumn(
			"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ProjectTaskStatusMasterTable, String>
		projectTaskStatusName = createColumn(
			"projectTaskStatusName", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<ProjectTaskStatusMasterTable, Boolean>
		isApplicableForProject = createColumn(
			"isApplicableForProject", Boolean.class, Types.BOOLEAN,
			Column.FLAG_DEFAULT);
	public final Column<ProjectTaskStatusMasterTable, Boolean>
		isApplicableForTask = createColumn(
			"isApplicableForTask", Boolean.class, Types.BOOLEAN,
			Column.FLAG_DEFAULT);

	private ProjectTaskStatusMasterTable() {
		super(
			"ax_master_ProjectTaskStatusMaster",
			ProjectTaskStatusMasterTable::new);
	}

}