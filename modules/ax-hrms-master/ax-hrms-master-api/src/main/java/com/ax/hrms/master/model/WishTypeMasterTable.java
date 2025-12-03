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
 * The table class for the &quot;ax_master_WishTypeMaster&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see WishTypeMaster
 * @generated
 */
public class WishTypeMasterTable extends BaseTable<WishTypeMasterTable> {

	public static final WishTypeMasterTable INSTANCE =
		new WishTypeMasterTable();

	public final Column<WishTypeMasterTable, Long> wishTypeMasterId =
		createColumn(
			"wishTypeMasterId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<WishTypeMasterTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<WishTypeMasterTable, Long> createdBy = createColumn(
		"createdBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<WishTypeMasterTable, Long> modifiedBy = createColumn(
		"modifiedBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<WishTypeMasterTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<WishTypeMasterTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<WishTypeMasterTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<WishTypeMasterTable, String> wishType = createColumn(
		"wishType", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private WishTypeMasterTable() {
		super("ax_master_WishTypeMaster", WishTypeMasterTable::new);
	}

}