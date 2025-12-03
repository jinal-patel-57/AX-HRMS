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
 * The table class for the &quot;ax_Policy&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Policy
 * @generated
 */
public class PolicyTable extends BaseTable<PolicyTable> {

	public static final PolicyTable INSTANCE = new PolicyTable();

	public final Column<PolicyTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PolicyTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PolicyTable, Long> createdBy = createColumn(
		"createdBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PolicyTable, Long> modifiedBy = createColumn(
		"modifiedBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PolicyTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PolicyTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<PolicyTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<PolicyTable, Long> policyId = createColumn(
		"policyId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<PolicyTable, String> policyName = createColumn(
		"policyName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PolicyTable, String> policyDescription = createColumn(
		"policyDescription", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PolicyTable, Integer> year = createColumn(
		"year", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<PolicyTable, Boolean> status = createColumn(
		"status", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<PolicyTable, Long> policyTypeId = createColumn(
		"policyTypeId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PolicyTable, Long> policyDocumentId = createColumn(
		"policyDocumentId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PolicyTable, Date> applicableDate = createColumn(
		"applicableDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private PolicyTable() {
		super("ax_Policy", PolicyTable::new);
	}

}