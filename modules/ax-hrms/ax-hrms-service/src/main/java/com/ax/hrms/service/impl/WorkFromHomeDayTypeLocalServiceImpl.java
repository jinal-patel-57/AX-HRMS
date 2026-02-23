/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.impl;

import com.ax.hrms.model.WorkFromHomeDayType;
import com.ax.hrms.service.base.WorkFromHomeDayTypeLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import org.osgi.service.component.annotations.Component;

import java.util.Date;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.ax.hrms.model.WorkFromHomeDayType",
	service = AopService.class
)
public class WorkFromHomeDayTypeLocalServiceImpl
	extends WorkFromHomeDayTypeLocalServiceBaseImpl {

	public List<WorkFromHomeDayType> findByWorkFromHomeRequestId(
			long workFromHomeRequestId) {
		return workFromHomeDayTypePersistence.findByWorkFromHomeRequestId(workFromHomeRequestId);
	}

	public List<WorkFromHomeDayType> findByWorkFromHomeDate(
			Date workFromHomeDate) {

		return workFromHomeDayTypePersistence.findByWorkFromHomeDate(workFromHomeDate);
	}
}