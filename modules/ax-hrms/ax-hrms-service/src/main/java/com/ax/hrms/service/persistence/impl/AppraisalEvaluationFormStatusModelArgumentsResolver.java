/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence.impl;

import com.ax.hrms.model.AppraisalEvaluationFormStatusTable;
import com.ax.hrms.model.impl.AppraisalEvaluationFormStatusImpl;
import com.ax.hrms.model.impl.AppraisalEvaluationFormStatusModelImpl;

import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.model.BaseModel;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.osgi.service.component.annotations.Component;

/**
 * The arguments resolver class for retrieving value from AppraisalEvaluationFormStatus.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(
	property = {
		"class.name=com.ax.hrms.model.impl.AppraisalEvaluationFormStatusImpl",
		"table.name=ax_AppraisalEvaluationFormStatus"
	},
	service = ArgumentsResolver.class
)
public class AppraisalEvaluationFormStatusModelArgumentsResolver
	implements ArgumentsResolver {

	@Override
	public Object[] getArguments(
		FinderPath finderPath, BaseModel<?> baseModel, boolean checkColumn,
		boolean original) {

		String[] columnNames = finderPath.getColumnNames();

		if ((columnNames == null) || (columnNames.length == 0)) {
			if (baseModel.isNew()) {
				return new Object[0];
			}

			return null;
		}

		AppraisalEvaluationFormStatusModelImpl
			appraisalEvaluationFormStatusModelImpl =
				(AppraisalEvaluationFormStatusModelImpl)baseModel;

		long columnBitmask =
			appraisalEvaluationFormStatusModelImpl.getColumnBitmask();

		if (!checkColumn || (columnBitmask == 0)) {
			return _getValue(
				appraisalEvaluationFormStatusModelImpl, columnNames, original);
		}

		Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
			finderPath);

		if (finderPathColumnBitmask == null) {
			finderPathColumnBitmask = 0L;

			for (String columnName : columnNames) {
				finderPathColumnBitmask |=
					appraisalEvaluationFormStatusModelImpl.getColumnBitmask(
						columnName);
			}

			_finderPathColumnBitmasksCache.put(
				finderPath, finderPathColumnBitmask);
		}

		if ((columnBitmask & finderPathColumnBitmask) != 0) {
			return _getValue(
				appraisalEvaluationFormStatusModelImpl, columnNames, original);
		}

		return null;
	}

	@Override
	public String getClassName() {
		return AppraisalEvaluationFormStatusImpl.class.getName();
	}

	@Override
	public String getTableName() {
		return AppraisalEvaluationFormStatusTable.INSTANCE.getTableName();
	}

	private static Object[] _getValue(
		AppraisalEvaluationFormStatusModelImpl
			appraisalEvaluationFormStatusModelImpl,
		String[] columnNames, boolean original) {

		Object[] arguments = new Object[columnNames.length];

		for (int i = 0; i < arguments.length; i++) {
			String columnName = columnNames[i];

			if (original) {
				arguments[i] =
					appraisalEvaluationFormStatusModelImpl.
						getColumnOriginalValue(columnName);
			}
			else {
				arguments[i] =
					appraisalEvaluationFormStatusModelImpl.getColumnValue(
						columnName);
			}
		}

		return arguments;
	}

	private static final Map<FinderPath, Long> _finderPathColumnBitmasksCache =
		new ConcurrentHashMap<>();

}