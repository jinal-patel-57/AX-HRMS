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
 * The extended model interface for the LeaveBalance service. Represents a row in the &quot;ax_LeaveBalance&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see LeaveBalanceModel
 * @generated
 */
@ImplementationClassName("com.ax.hrms.model.impl.LeaveBalanceImpl")
@ProviderType
public interface LeaveBalance extends LeaveBalanceModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.ax.hrms.model.impl.LeaveBalanceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<LeaveBalance, Long> LEAVE_BALANCE_ID_ACCESSOR =
		new Accessor<LeaveBalance, Long>() {

			@Override
			public Long get(LeaveBalance leaveBalance) {
				return leaveBalance.getLeaveBalanceId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<LeaveBalance> getTypeClass() {
				return LeaveBalance.class;
			}

		};

}