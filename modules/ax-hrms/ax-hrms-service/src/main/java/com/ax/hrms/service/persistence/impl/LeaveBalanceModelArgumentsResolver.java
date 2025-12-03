/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence.impl;

import com.ax.hrms.model.LeaveBalanceTable;
import com.ax.hrms.model.impl.LeaveBalanceImpl;
import com.ax.hrms.model.impl.LeaveBalanceModelImpl;

import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.model.BaseModel;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.osgi.service.component.annotations.Component;

/**
 * The arguments resolver class for retrieving value from LeaveBalance.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(
	property = {
		"class.name=com.ax.hrms.model.impl.LeaveBalanceImpl",
		"table.name=ax_LeaveBalance"
	},
	service = ArgumentsResolver.class
)
public class LeaveBalanceModelArgumentsResolver implements ArgumentsResolver {

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

		LeaveBalanceModelImpl leaveBalanceModelImpl =
			(LeaveBalanceModelImpl)baseModel;

		long columnBitmask = leaveBalanceModelImpl.getColumnBitmask();

		if (!checkColumn || (columnBitmask == 0)) {
			return _getValue(leaveBalanceModelImpl, columnNames, original);
		}

		Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
			finderPath);

		if (finderPathColumnBitmask == null) {
			finderPathColumnBitmask = 0L;

			for (String columnName : columnNames) {
				finderPathColumnBitmask |=
					leaveBalanceModelImpl.getColumnBitmask(columnName);
			}

			_finderPathColumnBitmasksCache.put(
				finderPath, finderPathColumnBitmask);
		}

		if ((columnBitmask & finderPathColumnBitmask) != 0) {
			return _getValue(leaveBalanceModelImpl, columnNames, original);
		}

		return null;
	}

	@Override
	public String getClassName() {
		return LeaveBalanceImpl.class.getName();
	}

	@Override
	public String getTableName() {
		return LeaveBalanceTable.INSTANCE.getTableName();
	}

	private static Object[] _getValue(
		LeaveBalanceModelImpl leaveBalanceModelImpl, String[] columnNames,
		boolean original) {

		Object[] arguments = new Object[columnNames.length];

		for (int i = 0; i < arguments.length; i++) {
			String columnName = columnNames[i];

			if (original) {
				arguments[i] = leaveBalanceModelImpl.getColumnOriginalValue(
					columnName);
			}
			else {
				arguments[i] = leaveBalanceModelImpl.getColumnValue(columnName);
			}
		}

		return arguments;
	}

	private static final Map<FinderPath, Long> _finderPathColumnBitmasksCache =
		new ConcurrentHashMap<>();

}