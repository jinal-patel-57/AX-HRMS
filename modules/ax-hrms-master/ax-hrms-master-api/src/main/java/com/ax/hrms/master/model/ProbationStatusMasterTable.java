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
 * The table class for the &quot;ax_master_ProbationStatusMaster&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see ProbationStatusMaster
 * @generated
 */
public class ProbationStatusMasterTable
	extends BaseTable<ProbationStatusMasterTable> {

	public static final ProbationStatusMasterTable INSTANCE =
		new ProbationStatusMasterTable();

	public final Column<ProbationStatusMasterTable, Long>
		probationStatusMasterId = createColumn(
			"probationStatusMasterId", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<ProbationStatusMasterTable, Long> companyId =
		createColumn(
			"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProbationStatusMasterTable, Long> createdBy =
		createColumn(
			"createdBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProbationStatusMasterTable, Long> modifiedBy =
		createColumn(
			"modifiedBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProbationStatusMasterTable, Long> groupId =
		createColumn("groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProbationStatusMasterTable, Date> createDate =
		createColumn(
			"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ProbationStatusMasterTable, Date> modifiedDate =
		createColumn(
			"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ProbationStatusMasterTable, String> statusType =
		createColumn(
			"statusType", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private ProbationStatusMasterTable() {
		super(
			"ax_master_ProbationStatusMaster", ProbationStatusMasterTable::new);
	}

}