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
 * The table class for the &quot;ax_master_EducationLevelMaster&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see EducationLevelMaster
 * @generated
 */
public class EducationLevelMasterTable
	extends BaseTable<EducationLevelMasterTable> {

	public static final EducationLevelMasterTable INSTANCE =
		new EducationLevelMasterTable();

	public final Column<EducationLevelMasterTable, Long>
		educationLevelMasterId = createColumn(
			"educationLevelMasterId", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<EducationLevelMasterTable, Long> companyId =
		createColumn(
			"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EducationLevelMasterTable, Long> createdBy =
		createColumn(
			"createdBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EducationLevelMasterTable, Long> modifiedBy =
		createColumn(
			"modifiedBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EducationLevelMasterTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EducationLevelMasterTable, Date> createDate =
		createColumn(
			"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<EducationLevelMasterTable, Date> modifiedDate =
		createColumn(
			"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<EducationLevelMasterTable, String> levelName =
		createColumn(
			"levelName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private EducationLevelMasterTable() {
		super("ax_master_EducationLevelMaster", EducationLevelMasterTable::new);
	}

}