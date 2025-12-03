/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence.impl;

import com.ax.hrms.model.AppraisalMeetingInviteesTable;
import com.ax.hrms.model.impl.AppraisalMeetingInviteesImpl;
import com.ax.hrms.model.impl.AppraisalMeetingInviteesModelImpl;

import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.model.BaseModel;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.osgi.service.component.annotations.Component;

/**
 * The arguments resolver class for retrieving value from AppraisalMeetingInvitees.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(
	property = {
		"class.name=com.ax.hrms.model.impl.AppraisalMeetingInviteesImpl",
		"table.name=ax_AppraisalMeetingInvitees"
	},
	service = ArgumentsResolver.class
)
public class AppraisalMeetingInviteesModelArgumentsResolver
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

		AppraisalMeetingInviteesModelImpl appraisalMeetingInviteesModelImpl =
			(AppraisalMeetingInviteesModelImpl)baseModel;

		long columnBitmask =
			appraisalMeetingInviteesModelImpl.getColumnBitmask();

		if (!checkColumn || (columnBitmask == 0)) {
			return _getValue(
				appraisalMeetingInviteesModelImpl, columnNames, original);
		}

		Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
			finderPath);

		if (finderPathColumnBitmask == null) {
			finderPathColumnBitmask = 0L;

			for (String columnName : columnNames) {
				finderPathColumnBitmask |=
					appraisalMeetingInviteesModelImpl.getColumnBitmask(
						columnName);
			}

			_finderPathColumnBitmasksCache.put(
				finderPath, finderPathColumnBitmask);
		}

		if ((columnBitmask & finderPathColumnBitmask) != 0) {
			return _getValue(
				appraisalMeetingInviteesModelImpl, columnNames, original);
		}

		return null;
	}

	@Override
	public String getClassName() {
		return AppraisalMeetingInviteesImpl.class.getName();
	}

	@Override
	public String getTableName() {
		return AppraisalMeetingInviteesTable.INSTANCE.getTableName();
	}

	private static Object[] _getValue(
		AppraisalMeetingInviteesModelImpl appraisalMeetingInviteesModelImpl,
		String[] columnNames, boolean original) {

		Object[] arguments = new Object[columnNames.length];

		for (int i = 0; i < arguments.length; i++) {
			String columnName = columnNames[i];

			if (original) {
				arguments[i] =
					appraisalMeetingInviteesModelImpl.getColumnOriginalValue(
						columnName);
			}
			else {
				arguments[i] = appraisalMeetingInviteesModelImpl.getColumnValue(
					columnName);
			}
		}

		return arguments;
	}

	private static final Map<FinderPath, Long> _finderPathColumnBitmasksCache =
		new ConcurrentHashMap<>();

}