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
 * The table class for the &quot;ax_AppraisalEvaluationFormStatus&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see AppraisalEvaluationFormStatus
 * @generated
 */
public class AppraisalEvaluationFormStatusTable
	extends BaseTable<AppraisalEvaluationFormStatusTable> {

	public static final AppraisalEvaluationFormStatusTable INSTANCE =
		new AppraisalEvaluationFormStatusTable();

	public final Column<AppraisalEvaluationFormStatusTable, String> uuid =
		createColumn("uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AppraisalEvaluationFormStatusTable, Long> companyId =
		createColumn(
			"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AppraisalEvaluationFormStatusTable, Long> createdBy =
		createColumn(
			"createdBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AppraisalEvaluationFormStatusTable, Long> modifiedBy =
		createColumn(
			"modifiedBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AppraisalEvaluationFormStatusTable, Long> groupId =
		createColumn("groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AppraisalEvaluationFormStatusTable, Date> createDate =
		createColumn(
			"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AppraisalEvaluationFormStatusTable, Date> modifiedDate =
		createColumn(
			"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AppraisalEvaluationFormStatusTable, Long>
		appraisalEvaluationFormStatusId = createColumn(
			"appraisalEvaluationFormStatusId", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<AppraisalEvaluationFormStatusTable, Long>
		appraisalProcessId = createColumn(
			"appraisalProcessId", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<AppraisalEvaluationFormStatusTable, Date>
		submissionDate = createColumn(
			"submissionDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AppraisalEvaluationFormStatusTable, Long> employeeId =
		createColumn(
			"employeeId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AppraisalEvaluationFormStatusTable, Long>
		filledEvaluationDocuemntId = createColumn(
			"filledEvaluationDocuemntId", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<AppraisalEvaluationFormStatusTable, Long>
		appraisalFormTemplateId = createColumn(
			"appraisalFormTemplateId", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<AppraisalEvaluationFormStatusTable, Boolean> status =
		createColumn(
			"status", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);

	private AppraisalEvaluationFormStatusTable() {
		super(
			"ax_AppraisalEvaluationFormStatus",
			AppraisalEvaluationFormStatusTable::new);
	}

}