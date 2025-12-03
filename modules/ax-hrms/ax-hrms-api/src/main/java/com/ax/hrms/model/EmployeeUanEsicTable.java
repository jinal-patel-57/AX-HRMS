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
 * The table class for the &quot;ax_EmployeeUanEsic&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeUanEsic
 * @generated
 */
public class EmployeeUanEsicTable extends BaseTable<EmployeeUanEsicTable> {

	public static final EmployeeUanEsicTable INSTANCE =
		new EmployeeUanEsicTable();

	public final Column<EmployeeUanEsicTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EmployeeUanEsicTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EmployeeUanEsicTable, Long> createdBy = createColumn(
		"createdBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EmployeeUanEsicTable, Long> modifiedBy = createColumn(
		"modifiedBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EmployeeUanEsicTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EmployeeUanEsicTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<EmployeeUanEsicTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<EmployeeUanEsicTable, Long> uanEsicId = createColumn(
		"uanEsicId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<EmployeeUanEsicTable, String> uan = createColumn(
		"uan", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EmployeeUanEsicTable, String> esicNo = createColumn(
		"esicNo", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EmployeeUanEsicTable, Boolean> status = createColumn(
		"status", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);

	private EmployeeUanEsicTable() {
		super("ax_EmployeeUanEsic", EmployeeUanEsicTable::new);
	}

}