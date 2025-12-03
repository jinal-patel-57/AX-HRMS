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
 * The extended model interface for the AppraisalReminder service. Represents a row in the &quot;ax_AppraisalReminder&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see AppraisalReminderModel
 * @generated
 */
@ImplementationClassName("com.ax.hrms.model.impl.AppraisalReminderImpl")
@ProviderType
public interface AppraisalReminder
	extends AppraisalReminderModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.ax.hrms.model.impl.AppraisalReminderImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<AppraisalReminder, Long>
		APPRAISAL_REMAINDER_ID_ACCESSOR =
			new Accessor<AppraisalReminder, Long>() {

				@Override
				public Long get(AppraisalReminder appraisalReminder) {
					return appraisalReminder.getAppraisalRemainderId();
				}

				@Override
				public Class<Long> getAttributeClass() {
					return Long.class;
				}

				@Override
				public Class<AppraisalReminder> getTypeClass() {
					return AppraisalReminder.class;
				}

			};

}