/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.master.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the LeaveTypeMaster service. Represents a row in the &quot;ax_master_LeaveTypeMaster&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see LeaveTypeMasterModel
 * @generated
 */
@ImplementationClassName("com.ax.hrms.master.model.impl.LeaveTypeMasterImpl")
@ProviderType
public interface LeaveTypeMaster extends LeaveTypeMasterModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.ax.hrms.master.model.impl.LeaveTypeMasterImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<LeaveTypeMaster, Long>
		LEAVE_TYPE_MASTER_ID_ACCESSOR = new Accessor<LeaveTypeMaster, Long>() {

			@Override
			public Long get(LeaveTypeMaster leaveTypeMaster) {
				return leaveTypeMaster.getLeaveTypeMasterId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<LeaveTypeMaster> getTypeClass() {
				return LeaveTypeMaster.class;
			}

		};

}