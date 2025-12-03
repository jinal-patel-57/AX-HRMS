/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.master.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;ax_master_PolicyTypeMaster&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see PolicyTypeMaster
 * @generated
 */
public class PolicyTypeMasterTable extends BaseTable<PolicyTypeMasterTable> {

	public static final PolicyTypeMasterTable INSTANCE =
		new PolicyTypeMasterTable();

	public final Column<PolicyTypeMasterTable, Long> policyTypeMasterID =
		createColumn(
			"policyTypeMasterID", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<PolicyTypeMasterTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PolicyTypeMasterTable, Long> createdBy = createColumn(
		"createdBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PolicyTypeMasterTable, Long> modifiedBy = createColumn(
		"modifiedBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PolicyTypeMasterTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PolicyTypeMasterTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<PolicyTypeMasterTable, Date> modifiedDate =
		createColumn(
			"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<PolicyTypeMasterTable, String> policyType =
		createColumn(
			"policyType", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private PolicyTypeMasterTable() {
		super("ax_master_PolicyTypeMaster", PolicyTypeMasterTable::new);
	}

}