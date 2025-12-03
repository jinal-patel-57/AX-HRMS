/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.liferay.portal.kernel.module.service.Snapshot;

/**
 * Provides the remote service utility for AppraisalMeetingInvitees. This utility wraps
 * <code>com.ax.hrms.service.impl.AppraisalMeetingInviteesServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see AppraisalMeetingInviteesService
 * @generated
 */
public class AppraisalMeetingInviteesServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ax.hrms.service.impl.AppraisalMeetingInviteesServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static AppraisalMeetingInviteesService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<AppraisalMeetingInviteesService>
		_serviceSnapshot = new Snapshot<>(
			AppraisalMeetingInviteesServiceUtil.class,
			AppraisalMeetingInviteesService.class);

}