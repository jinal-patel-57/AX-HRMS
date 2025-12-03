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
 * The table class for the &quot;ax_master_DesignationMaster&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see DesignationMaster
 * @generated
 */
public class DesignationMasterTable extends BaseTable<DesignationMasterTable> {

	public static final DesignationMasterTable INSTANCE =
		new DesignationMasterTable();

	public final Column<DesignationMasterTable, Long> designationMasterId =
		createColumn(
			"designationMasterId", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<DesignationMasterTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DesignationMasterTable, Long> createdBy = createColumn(
		"createdBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DesignationMasterTable, Long> modifiedBy = createColumn(
		"modifiedBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DesignationMasterTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DesignationMasterTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DesignationMasterTable, Date> modifiedDate =
		createColumn(
			"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DesignationMasterTable, String> designationName =
		createColumn(
			"designationName", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);

	private DesignationMasterTable() {
		super("ax_master_DesignationMaster", DesignationMasterTable::new);
	}

}