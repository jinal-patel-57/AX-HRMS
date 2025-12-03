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

package com.ax.hrms.master.service.impl;

import com.ax.hrms.master.exception.NoSuchDesignationMasterException;
import com.ax.hrms.master.exception.NoSuchPriorityMasterException;
import com.ax.hrms.master.model.PriorityMaster;
import com.ax.hrms.master.service.base.PriorityMasterLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.ax.hrms.master.model.PriorityMaster",
	service = AopService.class
)
public class PriorityMasterLocalServiceImpl
	extends PriorityMasterLocalServiceBaseImpl {
	
	private Log log = LogFactoryUtil.getLog(PriorityMasterLocalServiceImpl.class);
	
	public PriorityMaster findByPriorityName(String priorityName)
			throws NoSuchPriorityMasterException {
		return priorityMasterPersistence.findByPriorityName(priorityName);
	}
	
	public boolean isPriorityNameExist(String priorityName) {
		try {
			PriorityMaster priorityMaster = findByPriorityName(priorityName);
		}catch (NoSuchPriorityMasterException e) {
			return false;
		}
		return true;
	}
	
	public long getPriorityIdByPriorityName(String priorityName) {
		try {
			return findByPriorityName(priorityName).getPriorityMasterId();
		}catch(NullPointerException | NoSuchPriorityMasterException exception) {
			log.error("PriorityMasterLocalServiceImpl >>> getPriorityIdByPriorityName ::: Exception is: "+ exception.getMessage());
		}
		return 0L;
	}
}