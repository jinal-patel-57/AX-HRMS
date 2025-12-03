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
 * The table class for the &quot;ax_AppraisalFormTemplates&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see AppraisalFormTemplates
 * @generated
 */
public class AppraisalFormTemplatesTable
	extends BaseTable<AppraisalFormTemplatesTable> {

	public static final AppraisalFormTemplatesTable INSTANCE =
		new AppraisalFormTemplatesTable();

	public final Column<AppraisalFormTemplatesTable, String> uuid =
		createColumn("uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AppraisalFormTemplatesTable, Long> companyId =
		createColumn(
			"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AppraisalFormTemplatesTable, Long> createdBy =
		createColumn(
			"createdBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AppraisalFormTemplatesTable, Long> modifiedBy =
		createColumn(
			"modifiedBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AppraisalFormTemplatesTable, Long> groupId =
		createColumn("groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AppraisalFormTemplatesTable, Date> createDate =
		createColumn(
			"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AppraisalFormTemplatesTable, Date> modifiedDate =
		createColumn(
			"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AppraisalFormTemplatesTable, Long>
		appraisalFormTemplateId = createColumn(
			"appraisalFormTemplateId", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<AppraisalFormTemplatesTable, String> templateName =
		createColumn(
			"templateName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AppraisalFormTemplatesTable, Long> templateDocumentId =
		createColumn(
			"templateDocumentId", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<AppraisalFormTemplatesTable, Long> templateLevelId =
		createColumn(
			"templateLevelId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AppraisalFormTemplatesTable, String> templateYear =
		createColumn(
			"templateYear", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AppraisalFormTemplatesTable, Boolean> status =
		createColumn(
			"status", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);

	private AppraisalFormTemplatesTable() {
		super("ax_AppraisalFormTemplates", AppraisalFormTemplatesTable::new);
	}

}