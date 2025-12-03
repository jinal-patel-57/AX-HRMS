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
 * The table class for the &quot;ax_EmployeeBankAccount&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeBankAccount
 * @generated
 */
public class EmployeeBankAccountTable
	extends BaseTable<EmployeeBankAccountTable> {

	public static final EmployeeBankAccountTable INSTANCE =
		new EmployeeBankAccountTable();

	public final Column<EmployeeBankAccountTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EmployeeBankAccountTable, Long> companyId =
		createColumn(
			"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EmployeeBankAccountTable, Long> createdBy =
		createColumn(
			"createdBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EmployeeBankAccountTable, Long> modifiedBy =
		createColumn(
			"modifiedBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EmployeeBankAccountTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EmployeeBankAccountTable, Date> createDate =
		createColumn(
			"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<EmployeeBankAccountTable, Date> modifiedDate =
		createColumn(
			"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<EmployeeBankAccountTable, Long> bankAccountId =
		createColumn(
			"bankAccountId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<EmployeeBankAccountTable, String> accountNumber =
		createColumn(
			"accountNumber", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EmployeeBankAccountTable, String> accountType =
		createColumn(
			"accountType", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EmployeeBankAccountTable, String> beneficiaryName =
		createColumn(
			"beneficiaryName", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<EmployeeBankAccountTable, String> bankName =
		createColumn(
			"bankName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EmployeeBankAccountTable, Boolean> status =
		createColumn(
			"status", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<EmployeeBankAccountTable, String> ifscCode =
		createColumn(
			"ifscCode", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EmployeeBankAccountTable, String> bankBranch =
		createColumn(
			"bankBranch", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EmployeeBankAccountTable, Long> employeeId =
		createColumn(
			"employeeId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private EmployeeBankAccountTable() {
		super("ax_EmployeeBankAccount", EmployeeBankAccountTable::new);
	}

}