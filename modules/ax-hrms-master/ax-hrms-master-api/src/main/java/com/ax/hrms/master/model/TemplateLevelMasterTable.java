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
 * The table class for the &quot;ax_master_TemplateLevelMaster&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see TemplateLevelMaster
 * @generated
 */
public class TemplateLevelMasterTable
	extends BaseTable<TemplateLevelMasterTable> {

	public static final TemplateLevelMasterTable INSTANCE =
		new TemplateLevelMasterTable();

	public final Column<TemplateLevelMasterTable, Long> templateLevelMasterId =
		createColumn(
			"templateLevelMasterId", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<TemplateLevelMasterTable, Long> companyId =
		createColumn(
			"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TemplateLevelMasterTable, Long> createdBy =
		createColumn(
			"createdBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TemplateLevelMasterTable, Long> modifiedBy =
		createColumn(
			"modifiedBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TemplateLevelMasterTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TemplateLevelMasterTable, Date> createDate =
		createColumn(
			"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<TemplateLevelMasterTable, Date> modifiedDate =
		createColumn(
			"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<TemplateLevelMasterTable, String> levelName =
		createColumn(
			"levelName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private TemplateLevelMasterTable() {
		super("ax_master_TemplateLevelMaster", TemplateLevelMasterTable::new);
	}

}