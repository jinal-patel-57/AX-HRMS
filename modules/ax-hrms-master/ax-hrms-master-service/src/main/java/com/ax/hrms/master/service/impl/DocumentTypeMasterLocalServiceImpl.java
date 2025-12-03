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

import org.osgi.service.component.annotations.Component;

import com.ax.hrms.master.exception.NoSuchDocumentTypeMasterException;
import com.ax.hrms.master.model.DocumentTypeMaster;
import com.ax.hrms.master.service.base.DocumentTypeMasterLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.ax.hrms.master.model.DocumentTypeMaster",
	service = AopService.class
)
public class DocumentTypeMasterLocalServiceImpl
	extends DocumentTypeMasterLocalServiceBaseImpl {
	private Log log = LogFactoryUtil.getLog(DocumentTypeMasterLocalServiceImpl.class);
	public DocumentTypeMaster findByDocumentTypeName(String documentTypeName)
			throws NoSuchDocumentTypeMasterException {
		return documentTypeMasterPersistence.findByDocumentTypeName(documentTypeName);
	}
	
	public boolean isDocumentTypeNameExists(String documentTypeName){
		try{
			DocumentTypeMaster documentTypeMaster = findByDocumentTypeName(documentTypeName);
		}catch(NoSuchDocumentTypeMasterException e){
			return false;
		}
		return true;
	}
	public long getDocumentTypeMasterIdByName(String documentTypeName) {
		try{
			return findByDocumentTypeName(documentTypeName).getDocumentTypeMasterId();
		}catch(NullPointerException | NoSuchDocumentTypeMasterException exception) {
			log.error("DocumentTypeMasterLocalServiceImpl >>> getDocumentTypeMasterIdByName ::: Exception is: "+ exception.getMessage());
		}
		return 0L;
	}
}