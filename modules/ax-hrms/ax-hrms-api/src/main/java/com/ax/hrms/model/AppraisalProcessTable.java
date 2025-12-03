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
 * The table class for the &quot;ax_AppraisalProcess&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see AppraisalProcess
 * @generated
 */
public class AppraisalProcessTable extends BaseTable<AppraisalProcessTable> {

	public static final AppraisalProcessTable INSTANCE =
		new AppraisalProcessTable();

	public final Column<AppraisalProcessTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AppraisalProcessTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AppraisalProcessTable, Long> createdBy = createColumn(
		"createdBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AppraisalProcessTable, Long> modifiedBy = createColumn(
		"modifiedBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AppraisalProcessTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AppraisalProcessTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AppraisalProcessTable, Date> modifiedDate =
		createColumn(
			"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AppraisalProcessTable, Long> appraisalProcessId =
		createColumn(
			"appraisalProcessId", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<AppraisalProcessTable, Boolean>
		isSelfEvalutionFormSent = createColumn(
			"isSelfEvalutionFormSent", Boolean.class, Types.BOOLEAN,
			Column.FLAG_DEFAULT);
	public final Column<AppraisalProcessTable, Boolean>
		isSelfEvalutionFormFilled = createColumn(
			"isSelfEvalutionFormFilled", Boolean.class, Types.BOOLEAN,
			Column.FLAG_DEFAULT);
	public final Column<AppraisalProcessTable, Boolean>
		arePeerEvaluationFormSent = createColumn(
			"arePeerEvaluationFormSent", Boolean.class, Types.BOOLEAN,
			Column.FLAG_DEFAULT);
	public final Column<AppraisalProcessTable, Boolean>
		arePeerEvaluationFormFilled = createColumn(
			"arePeerEvaluationFormFilled", Boolean.class, Types.BOOLEAN,
			Column.FLAG_DEFAULT);
	public final Column<AppraisalProcessTable, Boolean> isManagementFormSent =
		createColumn(
			"isManagementFormSent", Boolean.class, Types.BOOLEAN,
			Column.FLAG_DEFAULT);
	public final Column<AppraisalProcessTable, Boolean> isManagementFormFilled =
		createColumn(
			"isManagementFormFilled", Boolean.class, Types.BOOLEAN,
			Column.FLAG_DEFAULT);
	public final Column<AppraisalProcessTable, Boolean> isMeetingScheduled =
		createColumn(
			"isMeetingScheduled", Boolean.class, Types.BOOLEAN,
			Column.FLAG_DEFAULT);
	public final Column<AppraisalProcessTable, Boolean> isMeetingDone =
		createColumn(
			"isMeetingDone", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<AppraisalProcessTable, Boolean> isSalaryUpdated =
		createColumn(
			"isSalaryUpdated", Boolean.class, Types.BOOLEAN,
			Column.FLAG_DEFAULT);
	public final Column<AppraisalProcessTable, Long> status = createColumn(
		"status", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private AppraisalProcessTable() {
		super("ax_AppraisalProcess", AppraisalProcessTable::new);
	}

}