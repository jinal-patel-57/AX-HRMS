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
 * The table class for the &quot;ax_master_LeaveTypeMaster&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see LeaveTypeMaster
 * @generated
 */
public class LeaveTypeMasterTable extends BaseTable<LeaveTypeMasterTable> {

	public static final LeaveTypeMasterTable INSTANCE =
		new LeaveTypeMasterTable();

	public final Column<LeaveTypeMasterTable, Long> leaveTypeMasterId =
		createColumn(
			"leaveTypeMasterId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<LeaveTypeMasterTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LeaveTypeMasterTable, Long> createdBy = createColumn(
		"createdBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LeaveTypeMasterTable, Long> modifiedBy = createColumn(
		"modifiedBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LeaveTypeMasterTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LeaveTypeMasterTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<LeaveTypeMasterTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<LeaveTypeMasterTable, String> leaveTypeName =
		createColumn(
			"leaveTypeName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<LeaveTypeMasterTable, String> description =
		createColumn(
			"description", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<LeaveTypeMasterTable, Boolean> isActive = createColumn(
		"isActive", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<LeaveTypeMasterTable, Boolean> isAppearForAll =
		createColumn(
			"isAppearForAll", Boolean.class, Types.BOOLEAN,
			Column.FLAG_DEFAULT);

	private LeaveTypeMasterTable() {
		super("ax_master_LeaveTypeMaster", LeaveTypeMasterTable::new);
	}

}