/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Comment}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Comment
 * @generated
 */
public class CommentWrapper
	extends BaseModelWrapper<Comment>
	implements Comment, ModelWrapper<Comment> {

	public CommentWrapper(Comment comment) {
		super(comment);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("companyId", getCompanyId());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("groupId", getGroupId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("commentId", getCommentId());
		attributes.put("type", getType());
		attributes.put("action", getAction());
		attributes.put("comment", getComment());
		attributes.put("status", isStatus());
		attributes.put("requestId", getRequestId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long createdBy = (Long)attributes.get("createdBy");

		if (createdBy != null) {
			setCreatedBy(createdBy);
		}

		Long modifiedBy = (Long)attributes.get("modifiedBy");

		if (modifiedBy != null) {
			setModifiedBy(modifiedBy);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long commentId = (Long)attributes.get("commentId");

		if (commentId != null) {
			setCommentId(commentId);
		}

		Long type = (Long)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		String action = (String)attributes.get("action");

		if (action != null) {
			setAction(action);
		}

		String comment = (String)attributes.get("comment");

		if (comment != null) {
			setComment(comment);
		}

		Boolean status = (Boolean)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long requestId = (Long)attributes.get("requestId");

		if (requestId != null) {
			setRequestId(requestId);
		}
	}

	@Override
	public Comment cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the action of this comment.
	 *
	 * @return the action of this comment
	 */
	@Override
	public String getAction() {
		return model.getAction();
	}

	/**
	 * Returns the comment of this comment.
	 *
	 * @return the comment of this comment
	 */
	@Override
	public String getComment() {
		return model.getComment();
	}

	/**
	 * Returns the comment ID of this comment.
	 *
	 * @return the comment ID of this comment
	 */
	@Override
	public long getCommentId() {
		return model.getCommentId();
	}

	/**
	 * Returns the company ID of this comment.
	 *
	 * @return the company ID of this comment
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this comment.
	 *
	 * @return the create date of this comment
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this comment.
	 *
	 * @return the created by of this comment
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the group ID of this comment.
	 *
	 * @return the group ID of this comment
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified by of this comment.
	 *
	 * @return the modified by of this comment
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this comment.
	 *
	 * @return the modified date of this comment
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this comment.
	 *
	 * @return the primary key of this comment
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the request ID of this comment.
	 *
	 * @return the request ID of this comment
	 */
	@Override
	public long getRequestId() {
		return model.getRequestId();
	}

	/**
	 * Returns the status of this comment.
	 *
	 * @return the status of this comment
	 */
	@Override
	public boolean getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the type of this comment.
	 *
	 * @return the type of this comment
	 */
	@Override
	public long getType() {
		return model.getType();
	}

	/**
	 * Returns the uuid of this comment.
	 *
	 * @return the uuid of this comment
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this comment is status.
	 *
	 * @return <code>true</code> if this comment is status; <code>false</code> otherwise
	 */
	@Override
	public boolean isStatus() {
		return model.isStatus();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the action of this comment.
	 *
	 * @param action the action of this comment
	 */
	@Override
	public void setAction(String action) {
		model.setAction(action);
	}

	/**
	 * Sets the comment of this comment.
	 *
	 * @param comment the comment of this comment
	 */
	@Override
	public void setComment(String comment) {
		model.setComment(comment);
	}

	/**
	 * Sets the comment ID of this comment.
	 *
	 * @param commentId the comment ID of this comment
	 */
	@Override
	public void setCommentId(long commentId) {
		model.setCommentId(commentId);
	}

	/**
	 * Sets the company ID of this comment.
	 *
	 * @param companyId the company ID of this comment
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this comment.
	 *
	 * @param createDate the create date of this comment
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this comment.
	 *
	 * @param createdBy the created by of this comment
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the group ID of this comment.
	 *
	 * @param groupId the group ID of this comment
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified by of this comment.
	 *
	 * @param modifiedBy the modified by of this comment
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this comment.
	 *
	 * @param modifiedDate the modified date of this comment
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this comment.
	 *
	 * @param primaryKey the primary key of this comment
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the request ID of this comment.
	 *
	 * @param requestId the request ID of this comment
	 */
	@Override
	public void setRequestId(long requestId) {
		model.setRequestId(requestId);
	}

	/**
	 * Sets whether this comment is status.
	 *
	 * @param status the status of this comment
	 */
	@Override
	public void setStatus(boolean status) {
		model.setStatus(status);
	}

	/**
	 * Sets the type of this comment.
	 *
	 * @param type the type of this comment
	 */
	@Override
	public void setType(long type) {
		model.setType(type);
	}

	/**
	 * Sets the uuid of this comment.
	 *
	 * @param uuid the uuid of this comment
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected CommentWrapper wrap(Comment comment) {
		return new CommentWrapper(comment);
	}

}