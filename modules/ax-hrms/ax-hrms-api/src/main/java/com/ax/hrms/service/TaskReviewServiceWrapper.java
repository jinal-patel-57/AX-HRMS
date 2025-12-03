/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TaskReviewService}.
 *
 * @author Brian Wing Shun Chan
 * @see TaskReviewService
 * @generated
 */
public class TaskReviewServiceWrapper
	implements ServiceWrapper<TaskReviewService>, TaskReviewService {

	public TaskReviewServiceWrapper() {
		this(null);
	}

	public TaskReviewServiceWrapper(TaskReviewService taskReviewService) {
		_taskReviewService = taskReviewService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _taskReviewService.getOSGiServiceIdentifier();
	}

	@Override
	public TaskReviewService getWrappedService() {
		return _taskReviewService;
	}

	@Override
	public void setWrappedService(TaskReviewService taskReviewService) {
		_taskReviewService = taskReviewService;
	}

	private TaskReviewService _taskReviewService;

}