/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.impl;

import com.ax.hrms.model.WorkFromHomeDayType;
import com.ax.hrms.service.base.WorkFromHomeDayTypeLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;

import java.util.Calendar;

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

		return workFromHomeDayTypePersistence.findByWorkFromHomeRequestId(
			workFromHomeRequestId);
	}

	public List<WorkFromHomeDayType> findByWorkFromHomeDate(
		Date workFromHomeDate) {

		return workFromHomeDayTypePersistence.findByWorkFromHomeDate(
			workFromHomeDate);
	}

	public List<WorkFromHomeDayType> findByWorkFromHomeDateBetween(
		Date startDate, Date endDate) {

		DynamicQuery dynamicQuery = dynamicQuery();

		dynamicQuery.add(
			RestrictionsFactoryUtil.ge(
				"workFromHomeDate", _getStartOfDay(startDate)));
		dynamicQuery.add(
			RestrictionsFactoryUtil.le(
				"workFromHomeDate", _getEndOfDay(endDate)));

		return dynamicQuery(dynamicQuery);
	}

	private Date _getEndOfDay(Date date) {
		Calendar calendar = Calendar.getInstance();

		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MILLISECOND, 999);

		return calendar.getTime();
	}

	private Date _getStartOfDay(Date date) {
		Calendar calendar = Calendar.getInstance();

		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);

		return calendar.getTime();
	}
}
