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
 * The table class for the &quot;ax_ExtendedProbationDetails&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see ExtendedProbationDetails
 * @generated
 */
public class ExtendedProbationDetailsTable
	extends BaseTable<ExtendedProbationDetailsTable> {

	public static final ExtendedProbationDetailsTable INSTANCE =
		new ExtendedProbationDetailsTable();

	public final Column<ExtendedProbationDetailsTable, String> uuid =
		createColumn("uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ExtendedProbationDetailsTable, Long> companyId =
		createColumn(
			"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ExtendedProbationDetailsTable, Long> createdBy =
		createColumn(
			"createdBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ExtendedProbationDetailsTable, Long> modifiedBy =
		createColumn(
			"modifiedBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ExtendedProbationDetailsTable, Long> groupId =
		createColumn("groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ExtendedProbationDetailsTable, Date> createDate =
		createColumn(
			"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ExtendedProbationDetailsTable, Date> modifiedDate =
		createColumn(
			"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ExtendedProbationDetailsTable, Long>
		extendedProbationDetailsId = createColumn(
			"extendedProbationDetailsId", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<ExtendedProbationDetailsTable, Long> probationDetailId =
		createColumn(
			"probationDetailId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ExtendedProbationDetailsTable, Date> extendDate =
		createColumn(
			"extendDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ExtendedProbationDetailsTable, String> evalutionReview =
		createColumn(
			"evalutionReview", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<ExtendedProbationDetailsTable, Integer>
		extendedProbationPeriod = createColumn(
			"extendedProbationPeriod", Integer.class, Types.INTEGER,
			Column.FLAG_DEFAULT);
	public final Column<ExtendedProbationDetailsTable, Date>
		extendedProbationEndDate = createColumn(
			"extendedProbationEndDate", Date.class, Types.TIMESTAMP,
			Column.FLAG_DEFAULT);

	private ExtendedProbationDetailsTable() {
		super(
			"ax_ExtendedProbationDetails", ExtendedProbationDetailsTable::new);
	}

}