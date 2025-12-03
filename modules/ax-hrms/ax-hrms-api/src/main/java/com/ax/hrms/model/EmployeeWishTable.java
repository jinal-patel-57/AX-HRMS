/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;ax_EmployeeWish&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeWish
 * @generated
 */
public class EmployeeWishTable extends BaseTable<EmployeeWishTable> {

	public static final EmployeeWishTable INSTANCE = new EmployeeWishTable();

	public final Column<EmployeeWishTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EmployeeWishTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EmployeeWishTable, Long> createdBy = createColumn(
		"createdBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EmployeeWishTable, Long> modifiedBy = createColumn(
		"modifiedBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EmployeeWishTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EmployeeWishTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<EmployeeWishTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<EmployeeWishTable, Long> wishId = createColumn(
		"wishId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<EmployeeWishTable, Long> senderId = createColumn(
		"senderId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EmployeeWishTable, Long> receiverId = createColumn(
		"receiverId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EmployeeWishTable, String> content = createColumn(
		"content", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EmployeeWishTable, Long> wishTypeMasterId =
		createColumn(
			"wishTypeMasterId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EmployeeWishTable, Date> timeStamp = createColumn(
		"timeStamp", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private EmployeeWishTable() {
		super("ax_EmployeeWish", EmployeeWishTable::new);
	}

}