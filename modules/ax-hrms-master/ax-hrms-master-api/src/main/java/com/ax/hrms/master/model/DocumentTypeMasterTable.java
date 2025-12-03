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
 * The table class for the &quot;ax_master_DocumentTypeMaster&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see DocumentTypeMaster
 * @generated
 */
public class DocumentTypeMasterTable
	extends BaseTable<DocumentTypeMasterTable> {

	public static final DocumentTypeMasterTable INSTANCE =
		new DocumentTypeMasterTable();

	public final Column<DocumentTypeMasterTable, Long> documentTypeMasterId =
		createColumn(
			"documentTypeMasterId", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<DocumentTypeMasterTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DocumentTypeMasterTable, Long> createdBy = createColumn(
		"createdBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DocumentTypeMasterTable, Long> modifiedBy =
		createColumn(
			"modifiedBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DocumentTypeMasterTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DocumentTypeMasterTable, Date> createDate =
		createColumn(
			"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DocumentTypeMasterTable, Date> modifiedDate =
		createColumn(
			"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DocumentTypeMasterTable, String> documentTypeName =
		createColumn(
			"documentTypeName", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);

	private DocumentTypeMasterTable() {
		super("ax_master_DocumentTypeMaster", DocumentTypeMasterTable::new);
	}

}