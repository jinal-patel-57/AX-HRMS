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
 * The table class for the &quot;ax_master_LeavePolicyMaster&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see LeavePolicyMaster
 * @generated
 */
public class LeavePolicyMasterTable extends BaseTable<LeavePolicyMasterTable> {

	public static final LeavePolicyMasterTable INSTANCE =
		new LeavePolicyMasterTable();

	public final Column<LeavePolicyMasterTable, Long> leavePolicyMasterId =
		createColumn(
			"leavePolicyMasterId", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<LeavePolicyMasterTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LeavePolicyMasterTable, Long> createdBy = createColumn(
		"createdBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LeavePolicyMasterTable, Long> modifiedBy = createColumn(
		"modifiedBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LeavePolicyMasterTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LeavePolicyMasterTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<LeavePolicyMasterTable, Date> modifiedDate =
		createColumn(
			"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<LeavePolicyMasterTable, String> description =
		createColumn(
			"description", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<LeavePolicyMasterTable, Double> accrualRate =
		createColumn(
			"accrualRate", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);
	public final Column<LeavePolicyMasterTable, Double> maximumBalance =
		createColumn(
			"maximumBalance", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);
	public final Column<LeavePolicyMasterTable, Long> leaveTypeMasterId =
		createColumn(
			"leaveTypeMasterId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LeavePolicyMasterTable, Boolean> isCheckMax =
		createColumn(
			"isCheckMax", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<LeavePolicyMasterTable, Integer> yearOfPolicy =
		createColumn(
			"yearOfPolicy", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<LeavePolicyMasterTable, Boolean> isCarryForward =
		createColumn(
			"isCarryForward", Boolean.class, Types.BOOLEAN,
			Column.FLAG_DEFAULT);
	public final Column<LeavePolicyMasterTable, Boolean> isContinuous =
		createColumn(
			"isContinuous", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<LeavePolicyMasterTable, Integer> eligibleAfterMonths =
		createColumn(
			"eligibleAfterMonths", Integer.class, Types.INTEGER,
			Column.FLAG_DEFAULT);
	public final Column<LeavePolicyMasterTable, Boolean> isApplicableFloater =
		createColumn(
			"isApplicableFloater", Boolean.class, Types.BOOLEAN,
			Column.FLAG_DEFAULT);

	private LeavePolicyMasterTable() {
		super("ax_master_LeavePolicyMaster", LeavePolicyMasterTable::new);
	}

}