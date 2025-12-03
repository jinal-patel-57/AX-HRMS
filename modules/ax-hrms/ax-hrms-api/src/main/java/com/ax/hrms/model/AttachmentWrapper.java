/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
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
 * This class is a wrapper for {@link Attachment}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Attachment
 * @generated
 */
public class AttachmentWrapper
	extends BaseModelWrapper<Attachment>
	implements Attachment, ModelWrapper<Attachment> {

	public AttachmentWrapper(Attachment attachment) {
		super(attachment);
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
		attributes.put("attachmentId", getAttachmentId());
		attributes.put("timeTrackerId", getTimeTrackerId());

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

		Long attachmentId = (Long)attributes.get("attachmentId");

		if (attachmentId != null) {
			setAttachmentId(attachmentId);
		}

		Long timeTrackerId = (Long)attributes.get("timeTrackerId");

		if (timeTrackerId != null) {
			setTimeTrackerId(timeTrackerId);
		}
	}

	@Override
	public Attachment cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the attachment ID of this attachment.
	 *
	 * @return the attachment ID of this attachment
	 */
	@Override
	public long getAttachmentId() {
		return model.getAttachmentId();
	}

	/**
	 * Returns the company ID of this attachment.
	 *
	 * @return the company ID of this attachment
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this attachment.
	 *
	 * @return the create date of this attachment
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this attachment.
	 *
	 * @return the created by of this attachment
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the group ID of this attachment.
	 *
	 * @return the group ID of this attachment
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified by of this attachment.
	 *
	 * @return the modified by of this attachment
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this attachment.
	 *
	 * @return the modified date of this attachment
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this attachment.
	 *
	 * @return the primary key of this attachment
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the time tracker ID of this attachment.
	 *
	 * @return the time tracker ID of this attachment
	 */
	@Override
	public long getTimeTrackerId() {
		return model.getTimeTrackerId();
	}

	/**
	 * Returns the uuid of this attachment.
	 *
	 * @return the uuid of this attachment
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the attachment ID of this attachment.
	 *
	 * @param attachmentId the attachment ID of this attachment
	 */
	@Override
	public void setAttachmentId(long attachmentId) {
		model.setAttachmentId(attachmentId);
	}

	/**
	 * Sets the company ID of this attachment.
	 *
	 * @param companyId the company ID of this attachment
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this attachment.
	 *
	 * @param createDate the create date of this attachment
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this attachment.
	 *
	 * @param createdBy the created by of this attachment
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the group ID of this attachment.
	 *
	 * @param groupId the group ID of this attachment
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified by of this attachment.
	 *
	 * @param modifiedBy the modified by of this attachment
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this attachment.
	 *
	 * @param modifiedDate the modified date of this attachment
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this attachment.
	 *
	 * @param primaryKey the primary key of this attachment
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the time tracker ID of this attachment.
	 *
	 * @param timeTrackerId the time tracker ID of this attachment
	 */
	@Override
	public void setTimeTrackerId(long timeTrackerId) {
		model.setTimeTrackerId(timeTrackerId);
	}

	/**
	 * Sets the uuid of this attachment.
	 *
	 * @param uuid the uuid of this attachment
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
	protected AttachmentWrapper wrap(Attachment attachment) {
		return new AttachmentWrapper(attachment);
	}

}