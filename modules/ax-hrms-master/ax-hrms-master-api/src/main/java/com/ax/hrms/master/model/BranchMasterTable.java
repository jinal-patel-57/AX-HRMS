/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.master.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;ax_master_BranchMaster&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see BranchMaster
 * @generated
 */
public class BranchMasterTable extends BaseTable<BranchMasterTable> {

	public static final BranchMasterTable INSTANCE = new BranchMasterTable();

	public final Column<BranchMasterTable, Long> branchMasterId = createColumn(
		"branchMasterId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<BranchMasterTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<BranchMasterTable, Long> createdBy = createColumn(
		"createdBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<BranchMasterTable, Long> modifiedBy = createColumn(
		"modifiedBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<BranchMasterTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<BranchMasterTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<BranchMasterTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<BranchMasterTable, String> branchName = createColumn(
		"branchName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BranchMasterTable, Long> addressId = createColumn(
		"addressId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private BranchMasterTable() {
		super("ax_master_BranchMaster", BranchMasterTable::new);
	}

}