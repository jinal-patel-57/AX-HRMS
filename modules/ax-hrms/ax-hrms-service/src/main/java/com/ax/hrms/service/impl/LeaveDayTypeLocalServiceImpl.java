/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.ax.hrms.service.impl;

import com.ax.hrms.model.LeaveDayType;
import com.ax.hrms.service.base.LeaveDayTypeLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.ax.hrms.model.LeaveDayType",
	service = AopService.class
)
public class LeaveDayTypeLocalServiceImpl
	extends LeaveDayTypeLocalServiceBaseImpl {

	public List<LeaveDayType> findByLeaveDate(Date leaveDate) {
		return leaveDayTypePersistence.findByLeaveDate(leaveDate);
	}

	public List<LeaveDayType> findByLeaveDateBetween(
		Date startDate, Date endDate) {

		DynamicQuery dynamicQuery = dynamicQuery();

		dynamicQuery.add(
			RestrictionsFactoryUtil.ge("leaveDate", _getStartOfDay(startDate)));
		dynamicQuery.add(
			RestrictionsFactoryUtil.le("leaveDate", _getEndOfDay(endDate)));

		return dynamicQuery(dynamicQuery);
	}

	public List<LeaveDayType> findByLeaveRequestId(long leaveRequestId) {
		return leaveDayTypePersistence.findByLeaveRequestId(leaveRequestId);
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
