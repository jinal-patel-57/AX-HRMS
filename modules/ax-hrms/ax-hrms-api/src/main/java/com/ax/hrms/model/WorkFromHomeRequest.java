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
 * The extended model interface for the WorkFromHomeRequest service. Represents a row in the &quot;ax_WorkFromHomeRequest&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see WorkFromHomeRequestModel
 * @generated
 */
@ImplementationClassName("com.ax.hrms.model.impl.WorkFromHomeRequestImpl")
@ProviderType
public interface WorkFromHomeRequest
	extends PersistedModel, WorkFromHomeRequestModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.ax.hrms.model.impl.WorkFromHomeRequestImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<WorkFromHomeRequest, Long>
		WORK_FROM_HOME_REQUEST_ID_ACCESSOR =
			new Accessor<WorkFromHomeRequest, Long>() {

				@Override
				public Long get(WorkFromHomeRequest workFromHomeRequest) {
					return workFromHomeRequest.getWorkFromHomeRequestId();
				}

				@Override
				public Class<Long> getAttributeClass() {
					return Long.class;
				}

				@Override
				public Class<WorkFromHomeRequest> getTypeClass() {
					return WorkFromHomeRequest.class;
				}

			};

}