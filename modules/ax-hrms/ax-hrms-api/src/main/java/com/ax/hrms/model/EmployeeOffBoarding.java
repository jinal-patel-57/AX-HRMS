/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the EmployeeOffBoarding service. Represents a row in the &quot;ax_EmployeeOffBoarding&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeOffBoardingModel
 * @generated
 */
@ImplementationClassName("com.ax.hrms.model.impl.EmployeeOffBoardingImpl")
@ProviderType
public interface EmployeeOffBoarding
	extends EmployeeOffBoardingModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.ax.hrms.model.impl.EmployeeOffBoardingImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<EmployeeOffBoarding, Long>
		EMPLOYEE_OFF_BOARDING_ID_ACCESSOR =
			new Accessor<EmployeeOffBoarding, Long>() {

				@Override
				public Long get(EmployeeOffBoarding employeeOffBoarding) {
					return employeeOffBoarding.getEmployeeOffBoardingId();
				}

				@Override
				public Class<Long> getAttributeClass() {
					return Long.class;
				}

				@Override
				public Class<EmployeeOffBoarding> getTypeClass() {
					return EmployeeOffBoarding.class;
				}

			};

}