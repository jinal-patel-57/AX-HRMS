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
 * The table class for the &quot;ax_master_PriorityMaster&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see PriorityMaster
 * @generated
 */
public class PriorityMasterTable extends BaseTable<PriorityMasterTable> {

	public static final PriorityMasterTable INSTANCE =
		new PriorityMasterTable();

	public final Column<PriorityMasterTable, Long> priorityMasterId =
		createColumn(
			"priorityMasterId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<PriorityMasterTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PriorityMasterTable, Long> createdBy = createColumn(
		"createdBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PriorityMasterTable, Long> modifiedBy = createColumn(
		"modifiedBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PriorityMasterTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PriorityMasterTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<PriorityMasterTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<PriorityMasterTable, String> priorityName =
		createColumn(
			"priorityName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private PriorityMasterTable() {
		super("ax_master_PriorityMaster", PriorityMasterTable::new);
	}

}