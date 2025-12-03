/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AttachmentService}.
 *
 * @author Brian Wing Shun Chan
 * @see AttachmentService
 * @generated
 */
public class AttachmentServiceWrapper
	implements AttachmentService, ServiceWrapper<AttachmentService> {

	public AttachmentServiceWrapper() {
		this(null);
	}

	public AttachmentServiceWrapper(AttachmentService attachmentService) {
		_attachmentService = attachmentService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _attachmentService.getOSGiServiceIdentifier();
	}

	@Override
	public AttachmentService getWrappedService() {
		return _attachmentService;
	}

	@Override
	public void setWrappedService(AttachmentService attachmentService) {
		_attachmentService = attachmentService;
	}

	private AttachmentService _attachmentService;

}