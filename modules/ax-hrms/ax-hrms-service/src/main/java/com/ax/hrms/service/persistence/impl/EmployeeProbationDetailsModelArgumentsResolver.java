/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence.impl;

import com.ax.hrms.model.EmployeeProbationDetailsTable;
import com.ax.hrms.model.impl.EmployeeProbationDetailsImpl;
import com.ax.hrms.model.impl.EmployeeProbationDetailsModelImpl;

import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.model.BaseModel;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.osgi.service.component.annotations.Component;

/**
 * The arguments resolver class for retrieving value from EmployeeProbationDetails.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(
	property = {
		"class.name=com.ax.hrms.model.impl.EmployeeProbationDetailsImpl",
		"table.name=ax_EmployeeProbationDetails"
	},
	service = ArgumentsResolver.class
)
public class EmployeeProbationDetailsModelArgumentsResolver
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

		EmployeeProbationDetailsModelImpl employeeProbationDetailsModelImpl =
			(EmployeeProbationDetailsModelImpl)baseModel;

		long columnBitmask =
			employeeProbationDetailsModelImpl.getColumnBitmask();

		if (!checkColumn || (columnBitmask == 0)) {
			return _getValue(
				employeeProbationDetailsModelImpl, columnNames, original);
		}

		Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
			finderPath);

		if (finderPathColumnBitmask == null) {
			finderPathColumnBitmask = 0L;

			for (String columnName : columnNames) {
				finderPathColumnBitmask |=
					employeeProbationDetailsModelImpl.getColumnBitmask(
						columnName);
			}

			_finderPathColumnBitmasksCache.put(
				finderPath, finderPathColumnBitmask);
		}

		if ((columnBitmask & finderPathColumnBitmask) != 0) {
			return _getValue(
				employeeProbationDetailsModelImpl, columnNames, original);
		}

		return null;
	}

	@Override
	public String getClassName() {
		return EmployeeProbationDetailsImpl.class.getName();
	}

	@Override
	public String getTableName() {
		return EmployeeProbationDetailsTable.INSTANCE.getTableName();
	}

	private static Object[] _getValue(
		EmployeeProbationDetailsModelImpl employeeProbationDetailsModelImpl,
		String[] columnNames, boolean original) {

		Object[] arguments = new Object[columnNames.length];

		for (int i = 0; i < arguments.length; i++) {
			String columnName = columnNames[i];

			if (original) {
				arguments[i] =
					employeeProbationDetailsModelImpl.getColumnOriginalValue(
						columnName);
			}
			else {
				arguments[i] = employeeProbationDetailsModelImpl.getColumnValue(
					columnName);
			}
		}

		return arguments;
	}

	private static final Map<FinderPath, Long> _finderPathColumnBitmasksCache =
		new ConcurrentHashMap<>();

}