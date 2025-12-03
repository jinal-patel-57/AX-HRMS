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
 * The table class for the &quot;ax_master_LeaveCompensatoryStatusMaster&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see LeaveCompensatoryStatusMaster
 * @generated
 */
public class LeaveCompensatoryStatusMasterTable
	extends BaseTable<LeaveCompensatoryStatusMasterTable> {

	public static final LeaveCompensatoryStatusMasterTable INSTANCE =
		new LeaveCompensatoryStatusMasterTable();

	public final Column<LeaveCompensatoryStatusMasterTable, Long>
		leaveCompensatoryStatusMasterId = createColumn(
			"leaveCompensatoryStatusMasterId", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<LeaveCompensatoryStatusMasterTable, Long> companyId =
		createColumn(
			"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LeaveCompensatoryStatusMasterTable, Long> createdBy =
		createColumn(
			"createdBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LeaveCompensatoryStatusMasterTable, Long> modifiedBy =
		createColumn(
			"modifiedBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LeaveCompensatoryStatusMasterTable, Long> groupId =
		createColumn("groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LeaveCompensatoryStatusMasterTable, Date> createDate =
		createColumn(
			"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<LeaveCompensatoryStatusMasterTable, Date> modifiedDate =
		createColumn(
			"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<LeaveCompensatoryStatusMasterTable, String>
		leaveCompensatoryStatus = createColumn(
			"leaveCompensatoryStatus", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);

	private LeaveCompensatoryStatusMasterTable() {
		super(
			"ax_master_LeaveCompensatoryStatusMaster",
			LeaveCompensatoryStatusMasterTable::new);
	}

}