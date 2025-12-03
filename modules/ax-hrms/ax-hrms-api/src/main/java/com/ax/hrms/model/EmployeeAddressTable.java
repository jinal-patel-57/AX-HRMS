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
 * The table class for the &quot;ax_EmployeeAddress&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeAddress
 * @generated
 */
public class EmployeeAddressTable extends BaseTable<EmployeeAddressTable> {

	public static final EmployeeAddressTable INSTANCE =
		new EmployeeAddressTable();

	public final Column<EmployeeAddressTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EmployeeAddressTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EmployeeAddressTable, Long> createdBy = createColumn(
		"createdBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EmployeeAddressTable, Long> modifiedBy = createColumn(
		"modifiedBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EmployeeAddressTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EmployeeAddressTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<EmployeeAddressTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<EmployeeAddressTable, Long> employeeAddressId =
		createColumn(
			"employeeAddressId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<EmployeeAddressTable, Long> presentAddress =
		createColumn(
			"presentAddress", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EmployeeAddressTable, Long> permanentAddress =
		createColumn(
			"permanentAddress", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EmployeeAddressTable, Boolean> presentPermanentSame =
		createColumn(
			"presentPermanentSame", Boolean.class, Types.BOOLEAN,
			Column.FLAG_DEFAULT);
	public final Column<EmployeeAddressTable, Boolean> status = createColumn(
		"status", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<EmployeeAddressTable, Long> employeeId = createColumn(
		"employeeId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private EmployeeAddressTable() {
		super("ax_EmployeeAddress", EmployeeAddressTable::new);
	}

}