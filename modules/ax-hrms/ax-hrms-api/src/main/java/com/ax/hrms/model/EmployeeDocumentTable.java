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
 * The table class for the &quot;ax_EmployeeDocument&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeDocument
 * @generated
 */
public class EmployeeDocumentTable extends BaseTable<EmployeeDocumentTable> {

	public static final EmployeeDocumentTable INSTANCE =
		new EmployeeDocumentTable();

	public final Column<EmployeeDocumentTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EmployeeDocumentTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EmployeeDocumentTable, Long> createdBy = createColumn(
		"createdBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EmployeeDocumentTable, Long> modifiedBy = createColumn(
		"modifiedBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EmployeeDocumentTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EmployeeDocumentTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<EmployeeDocumentTable, Date> modifiedDate =
		createColumn(
			"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<EmployeeDocumentTable, Long> documentId = createColumn(
		"documentId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<EmployeeDocumentTable, Long> documentTypeId =
		createColumn(
			"documentTypeId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EmployeeDocumentTable, String> documentNumber =
		createColumn(
			"documentNumber", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EmployeeDocumentTable, String> documentName =
		createColumn(
			"documentName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EmployeeDocumentTable, Long> documentMediaId =
		createColumn(
			"documentMediaId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EmployeeDocumentTable, Boolean> documentStatus =
		createColumn(
			"documentStatus", Boolean.class, Types.BOOLEAN,
			Column.FLAG_DEFAULT);
	public final Column<EmployeeDocumentTable, Long> employeeId = createColumn(
		"employeeId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private EmployeeDocumentTable() {
		super("ax_EmployeeDocument", EmployeeDocumentTable::new);
	}

}