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
 * The table class for the &quot;ax_RolePolicies&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see RolePolicies
 * @generated
 */
public class RolePoliciesTable extends BaseTable<RolePoliciesTable> {

	public static final RolePoliciesTable INSTANCE = new RolePoliciesTable();

	public final Column<RolePoliciesTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<RolePoliciesTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<RolePoliciesTable, Long> createdBy = createColumn(
		"createdBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<RolePoliciesTable, Long> modifiedBy = createColumn(
		"modifiedBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<RolePoliciesTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<RolePoliciesTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<RolePoliciesTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<RolePoliciesTable, Long> rolePoliciesId = createColumn(
		"rolePoliciesId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<RolePoliciesTable, Long> roleId = createColumn(
		"roleId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<RolePoliciesTable, Long> policyId = createColumn(
		"policyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private RolePoliciesTable() {
		super("ax_RolePolicies", RolePoliciesTable::new);
	}

}