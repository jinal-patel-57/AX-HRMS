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
 * The table class for the &quot;ax_master_DepartmentMaster&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see DepartmentMaster
 * @generated
 */
public class DepartmentMasterTable extends BaseTable<DepartmentMasterTable> {

	public static final DepartmentMasterTable INSTANCE =
		new DepartmentMasterTable();

	public final Column<DepartmentMasterTable, Long> departmentMasterId =
		createColumn(
			"departmentMasterId", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<DepartmentMasterTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DepartmentMasterTable, Long> createdBy = createColumn(
		"createdBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DepartmentMasterTable, Long> modifiedBy = createColumn(
		"modifiedBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DepartmentMasterTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DepartmentMasterTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DepartmentMasterTable, Date> modifiedDate =
		createColumn(
			"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DepartmentMasterTable, String> departmentName =
		createColumn(
			"departmentName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private DepartmentMasterTable() {
		super("ax_master_DepartmentMaster", DepartmentMasterTable::new);
	}

}