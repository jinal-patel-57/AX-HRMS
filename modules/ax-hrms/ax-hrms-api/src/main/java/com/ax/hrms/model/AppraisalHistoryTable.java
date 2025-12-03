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
 * The table class for the &quot;ax_AppraisalHistory&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see AppraisalHistory
 * @generated
 */
public class AppraisalHistoryTable extends BaseTable<AppraisalHistoryTable> {

	public static final AppraisalHistoryTable INSTANCE =
		new AppraisalHistoryTable();

	public final Column<AppraisalHistoryTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AppraisalHistoryTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AppraisalHistoryTable, Long> createdBy = createColumn(
		"createdBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AppraisalHistoryTable, Long> modifiedBy = createColumn(
		"modifiedBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AppraisalHistoryTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AppraisalHistoryTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AppraisalHistoryTable, Date> modifiedDate =
		createColumn(
			"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AppraisalHistoryTable, Long> appraisalId = createColumn(
		"appraisalId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<AppraisalHistoryTable, Long> salaryId = createColumn(
		"salaryId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AppraisalHistoryTable, Date> appraisalDate =
		createColumn(
			"appraisalDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AppraisalHistoryTable, Long> appraisalDocumentId =
		createColumn(
			"appraisalDocumentId", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<AppraisalHistoryTable, Double> updatedCtcPa =
		createColumn(
			"updatedCtcPa", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);
	public final Column<AppraisalHistoryTable, Double> updatedCtcPm =
		createColumn(
			"updatedCtcPm", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);
	public final Column<AppraisalHistoryTable, Double> rating = createColumn(
		"rating", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);
	public final Column<AppraisalHistoryTable, String> comments = createColumn(
		"comments", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private AppraisalHistoryTable() {
		super("ax_AppraisalHistory", AppraisalHistoryTable::new);
	}

}