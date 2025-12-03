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
 * The table class for the &quot;ax_Address&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Address
 * @generated
 */
public class AddressTable extends BaseTable<AddressTable> {

	public static final AddressTable INSTANCE = new AddressTable();

	public final Column<AddressTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AddressTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AddressTable, Long> createdBy = createColumn(
		"createdBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AddressTable, Long> modifiedBy = createColumn(
		"modifiedBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AddressTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AddressTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AddressTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AddressTable, Long> addressId = createColumn(
		"addressId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<AddressTable, String> line1 = createColumn(
		"line1", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AddressTable, String> line2 = createColumn(
		"line2", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AddressTable, String> line3 = createColumn(
		"line3", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AddressTable, String> state = createColumn(
		"state_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AddressTable, Long> country = createColumn(
		"country", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AddressTable, String> pincode = createColumn(
		"pincode", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private AddressTable() {
		super("ax_Address", AddressTable::new);
	}

}