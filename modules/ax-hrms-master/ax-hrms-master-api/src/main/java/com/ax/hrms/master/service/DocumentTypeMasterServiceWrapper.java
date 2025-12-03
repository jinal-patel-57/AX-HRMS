/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.master.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DocumentTypeMasterService}.
 *
 * @author Brian Wing Shun Chan
 * @see DocumentTypeMasterService
 * @generated
 */
public class DocumentTypeMasterServiceWrapper
	implements DocumentTypeMasterService,
			   ServiceWrapper<DocumentTypeMasterService> {

	public DocumentTypeMasterServiceWrapper() {
		this(null);
	}

	public DocumentTypeMasterServiceWrapper(
		DocumentTypeMasterService documentTypeMasterService) {

		_documentTypeMasterService = documentTypeMasterService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _documentTypeMasterService.getOSGiServiceIdentifier();
	}

	@Override
	public DocumentTypeMasterService getWrappedService() {
		return _documentTypeMasterService;
	}

	@Override
	public void setWrappedService(
		DocumentTypeMasterService documentTypeMasterService) {

		_documentTypeMasterService = documentTypeMasterService;
	}

	private DocumentTypeMasterService _documentTypeMasterService;

}