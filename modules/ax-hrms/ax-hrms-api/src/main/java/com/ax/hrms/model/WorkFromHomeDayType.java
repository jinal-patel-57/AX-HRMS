/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the WorkFromHomeDayType service. Represents a row in the &quot;ax_WorkFromHomeDayType&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see WorkFromHomeDayTypeModel
 * @generated
 */
@ImplementationClassName("com.ax.hrms.model.impl.WorkFromHomeDayTypeImpl")
@ProviderType
public interface WorkFromHomeDayType
	extends PersistedModel, WorkFromHomeDayTypeModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.ax.hrms.model.impl.WorkFromHomeDayTypeImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<WorkFromHomeDayType, Long>
		WORK_FROM_HOME_DAY_TYPE_ID_ACCESSOR =
			new Accessor<WorkFromHomeDayType, Long>() {

				@Override
				public Long get(WorkFromHomeDayType workFromHomeDayType) {
					return workFromHomeDayType.getWorkFromHomeDayTypeId();
				}

				@Override
				public Class<Long> getAttributeClass() {
					return Long.class;
				}

				@Override
				public Class<WorkFromHomeDayType> getTypeClass() {
					return WorkFromHomeDayType.class;
				}

			};

}