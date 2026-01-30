/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.impl;

import com.ax.hrms.model.Comment;
import com.ax.hrms.service.base.CommentLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;

import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.theme.ThemeDisplay;
import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.ax.hrms.model.Comment",
	service = AopService.class
)
public class CommentLocalServiceImpl extends CommentLocalServiceBaseImpl {
	
	public List<Comment> findByRequestId(long requestId) {
		return commentPersistence.findByRequestId(requestId);
	}
	
	public List<Comment> findByRequestIdAndStatus(long requestId, boolean status) {
		return commentPersistence.findByRequestIdAndStatus(requestId, status);
	}
	
	public List<Comment> findByStatus(boolean status) {
		return commentPersistence.findByStatus(status);
	}
	
	public List<Comment> findByType(long type) {
		return commentPersistence.findByType(type);
	}
	
	public List<Comment> findByTypeActionRequestIdAndStatus(long type, String action, long requestId, boolean status) {
		return commentPersistence.findByTypeActionRequestIdAndStatus(type, action, requestId, status);
	}
	
	public List<Comment> findByTypeRequestIdAndStatus(long type, long requestId, boolean status) {
		return commentPersistence.findByTypeRequestIdAndStatus(type, requestId, status);
	}
	public Comment addWorkflowComment(
			ThemeDisplay themeDisplay,
			long type,
			String action,
			long requestId,
			String commentText
	) {

		Comment comment =
				commentPersistence.create(
						counterLocalService.increment(Comment.class.getName())
				);

		Date now = new Date();

		comment.setCompanyId(themeDisplay.getCompanyId());
		comment.setGroupId(themeDisplay.getScopeGroupId());
		comment.setCreatedBy(themeDisplay.getUserId());
		comment.setModifiedBy(themeDisplay.getUserId());
		comment.setCreateDate(now);
		comment.setModifiedDate(now);

		comment.setType(type);
		comment.setAction(action);
		comment.setComment(commentText);
		comment.setRequestId(requestId);
		comment.setStatus(true);

		return commentPersistence.update(comment);
	}


}