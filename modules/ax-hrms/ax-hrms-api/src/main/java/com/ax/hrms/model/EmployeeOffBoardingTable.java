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
 * The table class for the &quot;ax_EmployeeOffBoarding&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeOffBoarding
 * @generated
 */
public class EmployeeOffBoardingTable
	extends BaseTable<EmployeeOffBoardingTable> {

	public static final EmployeeOffBoardingTable INSTANCE =
		new EmployeeOffBoardingTable();

	public final Column<EmployeeOffBoardingTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EmployeeOffBoardingTable, Long> companyId =
		createColumn(
			"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EmployeeOffBoardingTable, Long> createdBy =
		createColumn(
			"createdBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EmployeeOffBoardingTable, Long> modifiedBy =
		createColumn(
			"modifiedBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EmployeeOffBoardingTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EmployeeOffBoardingTable, Date> createDate =
		createColumn(
			"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<EmployeeOffBoardingTable, Date> modifiedDate =
		createColumn(
			"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<EmployeeOffBoardingTable, Long> employeeOffBoardingId =
		createColumn(
			"employeeOffBoardingId", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<EmployeeOffBoardingTable, Boolean> kt = createColumn(
		"kt", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<EmployeeOffBoardingTable, Boolean> assets =
		createColumn(
			"assets", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<EmployeeOffBoardingTable, Boolean> nda = createColumn(
		"nda", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<EmployeeOffBoardingTable, Boolean> mailAndBiometrics =
		createColumn(
			"mailAndBiometrics", Boolean.class, Types.BOOLEAN,
			Column.FLAG_DEFAULT);
	public final Column<EmployeeOffBoardingTable, Long> employeeId =
		createColumn(
			"employeeId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EmployeeOffBoardingTable, Long> experienceLetterId =
		createColumn(
			"experienceLetterId", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<EmployeeOffBoardingTable, String> fullAndFinal =
		createColumn(
			"fullAndFinal", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EmployeeOffBoardingTable, Long> relievingLetterId =
		createColumn(
			"relievingLetterId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EmployeeOffBoardingTable, Boolean> status =
		createColumn(
			"status", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);

	private EmployeeOffBoardingTable() {
		super("ax_EmployeeOffBoarding", EmployeeOffBoardingTable::new);
	}

}