/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.master.service.persistence.impl;

import com.ax.hrms.master.model.PriorityMasterTable;
import com.ax.hrms.master.model.impl.PriorityMasterImpl;
import com.ax.hrms.master.model.impl.PriorityMasterModelImpl;

import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.model.BaseModel;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.osgi.service.component.annotations.Component;

/**
 * The arguments resolver class for retrieving value from PriorityMaster.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(
	property = {
		"class.name=com.ax.hrms.master.model.impl.PriorityMasterImpl",
		"table.name=ax_master_PriorityMaster"
	},
	service = ArgumentsResolver.class
)
public class PriorityMasterModelArgumentsResolver implements ArgumentsResolver {

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

		PriorityMasterModelImpl priorityMasterModelImpl =
			(PriorityMasterModelImpl)baseModel;

		long columnBitmask = priorityMasterModelImpl.getColumnBitmask();

		if (!checkColumn || (columnBitmask == 0)) {
			return _getValue(priorityMasterModelImpl, columnNames, original);
		}

		Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
			finderPath);

		if (finderPathColumnBitmask == null) {
			finderPathColumnBitmask = 0L;

			for (String columnName : columnNames) {
				finderPathColumnBitmask |=
					priorityMasterModelImpl.getColumnBitmask(columnName);
			}

			_finderPathColumnBitmasksCache.put(
				finderPath, finderPathColumnBitmask);
		}

		if ((columnBitmask & finderPathColumnBitmask) != 0) {
			return _getValue(priorityMasterModelImpl, columnNames, original);
		}

		return null;
	}

	@Override
	public String getClassName() {
		return PriorityMasterImpl.class.getName();
	}

	@Override
	public String getTableName() {
		return PriorityMasterTable.INSTANCE.getTableName();
	}

	private static Object[] _getValue(
		PriorityMasterModelImpl priorityMasterModelImpl, String[] columnNames,
		boolean original) {

		Object[] arguments = new Object[columnNames.length];

		for (int i = 0; i < arguments.length; i++) {
			String columnName = columnNames[i];

			if (original) {
				arguments[i] = priorityMasterModelImpl.getColumnOriginalValue(
					columnName);
			}
			else {
				arguments[i] = priorityMasterModelImpl.getColumnValue(
					columnName);
			}
		}

		return arguments;
	}

	private static final Map<FinderPath, Long> _finderPathColumnBitmasksCache =
		new ConcurrentHashMap<>();

}