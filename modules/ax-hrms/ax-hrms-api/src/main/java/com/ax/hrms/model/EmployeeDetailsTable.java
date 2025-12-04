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
 * The table class for the &quot;ax_EmployeeDetails&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeDetails
 * @generated
 */
public class EmployeeDetailsTable extends BaseTable<EmployeeDetailsTable> {

	public static final EmployeeDetailsTable INSTANCE =
		new EmployeeDetailsTable();

	public final Column<EmployeeDetailsTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EmployeeDetailsTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EmployeeDetailsTable, Long> createdBy = createColumn(
		"createdBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EmployeeDetailsTable, Long> modifiedBy = createColumn(
		"modifiedBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EmployeeDetailsTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EmployeeDetailsTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<EmployeeDetailsTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<EmployeeDetailsTable, Long> employeeId = createColumn(
		"employeeId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<EmployeeDetailsTable, String> employeeCode =
		createColumn(
			"employeeCode", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EmployeeDetailsTable, Long> lrUserId = createColumn(
		"lrUserId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EmployeeDetailsTable, String> firstName = createColumn(
		"firstName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EmployeeDetailsTable, String> lastName = createColumn(
		"lastName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EmployeeDetailsTable, String> officialEmail =
		createColumn(
			"officialEmail", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EmployeeDetailsTable, String> personalEmail =
		createColumn(
			"personalEmail", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EmployeeDetailsTable, Date> joiningDate = createColumn(
		"joiningDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<EmployeeDetailsTable, Date> leavingDate = createColumn(
		"leavingDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<EmployeeDetailsTable, String> mobileNo = createColumn(
		"mobileNo", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EmployeeDetailsTable, String> gender = createColumn(
		"gender", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EmployeeDetailsTable, String> fatherName = createColumn(
		"fatherName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EmployeeDetailsTable, Date> dateOfBirth = createColumn(
		"dateOfBirth", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<EmployeeDetailsTable, Boolean> maritalStatus =
		createColumn(
			"maritalStatus", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<EmployeeDetailsTable, Date> marriageDate = createColumn(
		"marriageDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<EmployeeDetailsTable, String> spouseName = createColumn(
		"spouseName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EmployeeDetailsTable, Long> employeeAddressId =
		createColumn(
			"employeeAddressId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EmployeeDetailsTable, String> skypeId = createColumn(
		"skypeId", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EmployeeDetailsTable, Long> nominneeId = createColumn(
		"nominneeId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EmployeeDetailsTable, Long> bankAccountId =
		createColumn(
			"bankAccountId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EmployeeDetailsTable, Long> uanEsicId = createColumn(
		"uanEsicId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EmployeeDetailsTable, Long> probationStatusId =
		createColumn(
			"probationStatusId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EmployeeDetailsTable, Boolean> isEmployeeOnboarded =
		createColumn(
			"isEmployeeOnboarded", Boolean.class, Types.BOOLEAN,
			Column.FLAG_DEFAULT);
	public final Column<EmployeeDetailsTable, Boolean> isExperienced =
		createColumn(
			"isExperienced", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<EmployeeDetailsTable, Boolean> isProbationEnabled =
		createColumn(
			"isProbationEnabled", Boolean.class, Types.BOOLEAN,
			Column.FLAG_DEFAULT);
	public final Column<EmployeeDetailsTable, Long> profilePicId = createColumn(
		"profilePicId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EmployeeDetailsTable, String> insuranceLink =
		createColumn(
			"insuranceLink", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EmployeeDetailsTable, Boolean> isTerminated =
		createColumn(
			"isTerminated", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<EmployeeDetailsTable, Date> appraisalDate =
		createColumn(
			"appraisalDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<EmployeeDetailsTable, String> employeeType =
		createColumn(
			"employeeType", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EmployeeDetailsTable, Double> stipend = createColumn(
		"stipend", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);

	private EmployeeDetailsTable() {
		super("ax_EmployeeDetails", EmployeeDetailsTable::new);
	}

}