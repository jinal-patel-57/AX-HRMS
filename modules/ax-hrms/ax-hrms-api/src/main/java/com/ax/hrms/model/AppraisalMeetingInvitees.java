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
 * The extended model interface for the AppraisalMeetingInvitees service. Represents a row in the &quot;ax_AppraisalMeetingInvitees&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see AppraisalMeetingInviteesModel
 * @generated
 */
@ImplementationClassName("com.ax.hrms.model.impl.AppraisalMeetingInviteesImpl")
@ProviderType
public interface AppraisalMeetingInvitees
	extends AppraisalMeetingInviteesModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.ax.hrms.model.impl.AppraisalMeetingInviteesImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<AppraisalMeetingInvitees, Long>
		APPRAISAL_MEETING_INVITEE_ID_ACCESSOR =
			new Accessor<AppraisalMeetingInvitees, Long>() {

				@Override
				public Long get(
					AppraisalMeetingInvitees appraisalMeetingInvitees) {

					return appraisalMeetingInvitees.
						getAppraisalMeetingInviteeId();
				}

				@Override
				public Class<Long> getAttributeClass() {
					return Long.class;
				}

				@Override
				public Class<AppraisalMeetingInvitees> getTypeClass() {
					return AppraisalMeetingInvitees.class;
				}

			};

}