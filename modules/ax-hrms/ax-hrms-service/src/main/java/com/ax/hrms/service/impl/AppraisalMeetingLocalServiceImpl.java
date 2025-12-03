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

import com.ax.hrms.exception.NoSuchAppraisalMeetingException;
import com.ax.hrms.model.AppraisalMeeting;
import com.ax.hrms.service.base.AppraisalMeetingLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.ax.hrms.model.AppraisalMeeting",
	service = AopService.class
)
public class AppraisalMeetingLocalServiceImpl
	extends AppraisalMeetingLocalServiceBaseImpl {

	public AppraisalMeeting findByAppraisalProcessId(long appraisalProcessId) throws NoSuchAppraisalMeetingException {
		return appraisalMeetingPersistence.findByAppraisalProcessId(appraisalProcessId);
	}
}