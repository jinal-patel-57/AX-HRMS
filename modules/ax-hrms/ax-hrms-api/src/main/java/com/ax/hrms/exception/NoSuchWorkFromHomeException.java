/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package com.ax.hrms.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchWorkFromHomeException extends NoSuchModelException {

	public NoSuchWorkFromHomeException() {
	}

	public NoSuchWorkFromHomeException(String msg) {
		super(msg);
	}

	public NoSuchWorkFromHomeException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchWorkFromHomeException(Throwable throwable) {
		super(throwable);
	}

}