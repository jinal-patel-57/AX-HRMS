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
 * The table class for the &quot;ax_master_AppraisalStatusMaster&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see AppraisalStatusMaster
 * @generated
 */
public class AppraisalStatusMasterTable
	extends BaseTable<AppraisalStatusMasterTable> {

	public static final AppraisalStatusMasterTable INSTANCE =
		new AppraisalStatusMasterTable();

	public final Column<AppraisalStatusMasterTable, Long>
		appraisalStatusMasterId = createColumn(
			"appraisalStatusMasterId", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<AppraisalStatusMasterTable, Long> companyId =
		createColumn(
			"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AppraisalStatusMasterTable, Long> createdBy =
		createColumn(
			"createdBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AppraisalStatusMasterTable, Long> modifiedBy =
		createColumn(
			"modifiedBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AppraisalStatusMasterTable, Long> groupId =
		createColumn("groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AppraisalStatusMasterTable, Date> createDate =
		createColumn(
			"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AppraisalStatusMasterTable, Date> modifiedDate =
		createColumn(
			"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AppraisalStatusMasterTable, String> status =
		createColumn(
			"status", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private AppraisalStatusMasterTable() {
		super(
			"ax_master_AppraisalStatusMaster", AppraisalStatusMasterTable::new);
	}

}