/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence.impl;

import com.ax.hrms.model.EmployeeUanEsicTable;
import com.ax.hrms.model.impl.EmployeeUanEsicImpl;
import com.ax.hrms.model.impl.EmployeeUanEsicModelImpl;

import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.model.BaseModel;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.osgi.service.component.annotations.Component;

/**
 * The arguments resolver class for retrieving value from EmployeeUanEsic.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(
	property = {
		"class.name=com.ax.hrms.model.impl.EmployeeUanEsicImpl",
		"table.name=ax_EmployeeUanEsic"
	},
	service = ArgumentsResolver.class
)
public class EmployeeUanEsicModelArgumentsResolver
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

		EmployeeUanEsicModelImpl employeeUanEsicModelImpl =
			(EmployeeUanEsicModelImpl)baseModel;

		long columnBitmask = employeeUanEsicModelImpl.getColumnBitmask();

		if (!checkColumn || (columnBitmask == 0)) {
			return _getValue(employeeUanEsicModelImpl, columnNames, original);
		}

		Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
			finderPath);

		if (finderPathColumnBitmask == null) {
			finderPathColumnBitmask = 0L;

			for (String columnName : columnNames) {
				finderPathColumnBitmask |=
					employeeUanEsicModelImpl.getColumnBitmask(columnName);
			}

			_finderPathColumnBitmasksCache.put(
				finderPath, finderPathColumnBitmask);
		}

		if ((columnBitmask & finderPathColumnBitmask) != 0) {
			return _getValue(employeeUanEsicModelImpl, columnNames, original);
		}

		return null;
	}

	@Override
	public String getClassName() {
		return EmployeeUanEsicImpl.class.getName();
	}

	@Override
	public String getTableName() {
		return EmployeeUanEsicTable.INSTANCE.getTableName();
	}

	private static Object[] _getValue(
		EmployeeUanEsicModelImpl employeeUanEsicModelImpl, String[] columnNames,
		boolean original) {

		Object[] arguments = new Object[columnNames.length];

		for (int i = 0; i < arguments.length; i++) {
			String columnName = columnNames[i];

			if (original) {
				arguments[i] = employeeUanEsicModelImpl.getColumnOriginalValue(
					columnName);
			}
			else {
				arguments[i] = employeeUanEsicModelImpl.getColumnValue(
					columnName);
			}
		}

		return arguments;
	}

	private static final Map<FinderPath, Long> _finderPathColumnBitmasksCache =
		new ConcurrentHashMap<>();

}