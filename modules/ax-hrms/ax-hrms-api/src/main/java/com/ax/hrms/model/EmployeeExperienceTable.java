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
 * The table class for the &quot;ax_EmployeeExperience&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeExperience
 * @generated
 */
public class EmployeeExperienceTable
	extends BaseTable<EmployeeExperienceTable> {

	public static final EmployeeExperienceTable INSTANCE =
		new EmployeeExperienceTable();

	public final Column<EmployeeExperienceTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EmployeeExperienceTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EmployeeExperienceTable, Long> createdBy = createColumn(
		"createdBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EmployeeExperienceTable, Long> modifiedBy =
		createColumn(
			"modifiedBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EmployeeExperienceTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EmployeeExperienceTable, Date> createDate =
		createColumn(
			"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<EmployeeExperienceTable, Date> modifiedDate =
		createColumn(
			"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<EmployeeExperienceTable, Long> experienceId =
		createColumn(
			"experienceId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<EmployeeExperienceTable, String> companyName =
		createColumn(
			"companyName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EmployeeExperienceTable, Date> joiningDate =
		createColumn(
			"joiningDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<EmployeeExperienceTable, Date> relievingDate =
		createColumn(
			"relievingDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<EmployeeExperienceTable, Long>
		experienceCertificateMediaId = createColumn(
			"experienceCertificateMediaId", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<EmployeeExperienceTable, Long> employeeId =
		createColumn(
			"employeeId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private EmployeeExperienceTable() {
		super("ax_EmployeeExperience", EmployeeExperienceTable::new);
	}

}