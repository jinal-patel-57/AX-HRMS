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

import com.ax.hrms.exception.NoSuchHolidayException;
import com.ax.hrms.model.Holiday;
import com.ax.hrms.service.base.HolidayLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.ax.hrms.model.Holiday",
	service = AopService.class
)
public class HolidayLocalServiceImpl extends HolidayLocalServiceBaseImpl {

	@Override
	public List<Holiday> findByYear(int year) {
		
		return holidayPersistence.findByYear(year);
	}
	
	public List<Holiday> findByIsFloaterAndCurrentYear(
			Boolean isFloater, int year) {
		return holidayPersistence.findByIsFloaterAndCurrentYear(isFloater, year);

	}
	public Holiday findByDate(Date date) throws NoSuchHolidayException {
		return holidayPersistence.findByDate(date);
	}
	
	public List<Integer> getYear(){
		
		Session session = holidayPersistence.openSession();
		SQLQuery query = session.createSQLQuery("select DISTINCT year from ax_holiday");
		QueryPos pos = QueryPos.getInstance(query);
		
		return query.list();
	}
	
}