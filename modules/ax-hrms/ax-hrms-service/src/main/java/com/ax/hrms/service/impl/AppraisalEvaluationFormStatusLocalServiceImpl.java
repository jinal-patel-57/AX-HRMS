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

import com.ax.hrms.model.AppraisalEvaluationFormStatus;
import com.ax.hrms.service.base.AppraisalEvaluationFormStatusLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import org.osgi.service.component.annotations.Component;

import java.util.Date;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.ax.hrms.model.AppraisalEvaluationFormStatus",
	service = AopService.class
)
public class AppraisalEvaluationFormStatusLocalServiceImpl
	extends AppraisalEvaluationFormStatusLocalServiceBaseImpl {
	public List<AppraisalEvaluationFormStatus>
	findByAppraisalProcessIdAndAppraisalFormTemplateId(
			long appraisalProcessId, long appraisalFormTemplateId) {
		return appraisalEvaluationFormStatusPersistence.findByAppraisalProcessIdAndAppraisalFormTemplateId(appraisalProcessId,appraisalFormTemplateId);
	}


	public List<AppraisalEvaluationFormStatus> findByStatusAndSubmissionDate(
			Date submissionDate, boolean status) {
		return appraisalEvaluationFormStatusPersistence.findByStatusAndSubmissionDate(submissionDate,status);
	}
}