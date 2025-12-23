/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.impl;

import com.ax.hrms.model.WorkFromHomeRequest;
import com.ax.hrms.service.base.WorkFromHomeRequestLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import org.osgi.service.component.annotations.Component;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.ax.hrms.model.WorkFromHomeRequest",
	service = AopService.class
)
public class WorkFromHomeRequestLocalServiceImpl
	extends WorkFromHomeRequestLocalServiceBaseImpl {

    public List<WorkFromHomeRequest> findByEmployeeId(
            long employeeId, int start, int end) {

        return workFromHomeRequestPersistence.findByEmployeeId(employeeId, start, end);
    }

    public int countByEmployeeId(long employeeId) {
        return workFromHomeRequestPersistence.countByEmployeeId(employeeId);
    }
}