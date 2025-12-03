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
 * The table class for the &quot;ax_Nominee&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Nominee
 * @generated
 */
public class NomineeTable extends BaseTable<NomineeTable> {

	public static final NomineeTable INSTANCE = new NomineeTable();

	public final Column<NomineeTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<NomineeTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<NomineeTable, Long> createdBy = createColumn(
		"createdBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<NomineeTable, Long> modifiedBy = createColumn(
		"modifiedBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<NomineeTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<NomineeTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<NomineeTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<NomineeTable, Long> nomineeId = createColumn(
		"nomineeId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<NomineeTable, String> nomineeFirstName = createColumn(
		"nomineeFirstName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<NomineeTable, String> nomineeLastName = createColumn(
		"nomineeLastName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<NomineeTable, String> nomineeContact = createColumn(
		"nomineeContact", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<NomineeTable, Long> nomineeAddress = createColumn(
		"nomineeAddress", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<NomineeTable, String> relationshipWithNominee =
		createColumn(
			"relationshipWithNominee", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<NomineeTable, Date> nomineeDob = createColumn(
		"nomineeDob", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private NomineeTable() {
		super("ax_Nominee", NomineeTable::new);
	}

}