/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence.impl;

import com.ax.hrms.model.LeaveInformToTeamDetailTable;
import com.ax.hrms.model.impl.LeaveInformToTeamDetailImpl;
import com.ax.hrms.model.impl.LeaveInformToTeamDetailModelImpl;

import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.model.BaseModel;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.osgi.service.component.annotations.Component;

/**
 * The arguments resolver class for retrieving value from LeaveInformToTeamDetail.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(
	property = {
		"class.name=com.ax.hrms.model.impl.LeaveInformToTeamDetailImpl",
		"table.name=ax_LeaveInformToTeamDetail"
	},
	service = ArgumentsResolver.class
)
public class LeaveInformToTeamDetailModelArgumentsResolver
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

		LeaveInformToTeamDetailModelImpl leaveInformToTeamDetailModelImpl =
			(LeaveInformToTeamDetailModelImpl)baseModel;

		long columnBitmask =
			leaveInformToTeamDetailModelImpl.getColumnBitmask();

		if (!checkColumn || (columnBitmask == 0)) {
			return _getValue(
				leaveInformToTeamDetailModelImpl, columnNames, original);
		}

		Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
			finderPath);

		if (finderPathColumnBitmask == null) {
			finderPathColumnBitmask = 0L;

			for (String columnName : columnNames) {
				finderPathColumnBitmask |=
					leaveInformToTeamDetailModelImpl.getColumnBitmask(
						columnName);
			}

			_finderPathColumnBitmasksCache.put(
				finderPath, finderPathColumnBitmask);
		}

		if ((columnBitmask & finderPathColumnBitmask) != 0) {
			return _getValue(
				leaveInformToTeamDetailModelImpl, columnNames, original);
		}

		return null;
	}

	@Override
	public String getClassName() {
		return LeaveInformToTeamDetailImpl.class.getName();
	}

	@Override
	public String getTableName() {
		return LeaveInformToTeamDetailTable.INSTANCE.getTableName();
	}

	private static Object[] _getValue(
		LeaveInformToTeamDetailModelImpl leaveInformToTeamDetailModelImpl,
		String[] columnNames, boolean original) {

		Object[] arguments = new Object[columnNames.length];

		for (int i = 0; i < arguments.length; i++) {
			String columnName = columnNames[i];

			if (original) {
				arguments[i] =
					leaveInformToTeamDetailModelImpl.getColumnOriginalValue(
						columnName);
			}
			else {
				arguments[i] = leaveInformToTeamDetailModelImpl.getColumnValue(
					columnName);
			}
		}

		return arguments;
	}

	private static final Map<FinderPath, Long> _finderPathColumnBitmasksCache =
		new ConcurrentHashMap<>();

}