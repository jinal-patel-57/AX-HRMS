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
 * The extended model interface for the EmployeeEducation service. Represents a row in the &quot;ax_EmployeeEducation&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeEducationModel
 * @generated
 */
@ImplementationClassName("com.ax.hrms.model.impl.EmployeeEducationImpl")
@ProviderType
public interface EmployeeEducation
	extends EmployeeEducationModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.ax.hrms.model.impl.EmployeeEducationImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<EmployeeEducation, Long>
		EDUCATION_ID_ACCESSOR = new Accessor<EmployeeEducation, Long>() {

			@Override
			public Long get(EmployeeEducation employeeEducation) {
				return employeeEducation.getEducationId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<EmployeeEducation> getTypeClass() {
				return EmployeeEducation.class;
			}

		};

}