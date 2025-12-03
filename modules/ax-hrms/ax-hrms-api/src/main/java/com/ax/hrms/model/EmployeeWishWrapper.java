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
 * This class is a wrapper for {@link EmployeeWish}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeWish
 * @generated
 */
public class EmployeeWishWrapper
	extends BaseModelWrapper<EmployeeWish>
	implements EmployeeWish, ModelWrapper<EmployeeWish> {

	public EmployeeWishWrapper(EmployeeWish employeeWish) {
		super(employeeWish);
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
		attributes.put("wishId", getWishId());
		attributes.put("senderId", getSenderId());
		attributes.put("receiverId", getReceiverId());
		attributes.put("content", getContent());
		attributes.put("wishTypeMasterId", getWishTypeMasterId());
		attributes.put("timeStamp", getTimeStamp());

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

		Long wishId = (Long)attributes.get("wishId");

		if (wishId != null) {
			setWishId(wishId);
		}

		Long senderId = (Long)attributes.get("senderId");

		if (senderId != null) {
			setSenderId(senderId);
		}

		Long receiverId = (Long)attributes.get("receiverId");

		if (receiverId != null) {
			setReceiverId(receiverId);
		}

		String content = (String)attributes.get("content");

		if (content != null) {
			setContent(content);
		}

		Long wishTypeMasterId = (Long)attributes.get("wishTypeMasterId");

		if (wishTypeMasterId != null) {
			setWishTypeMasterId(wishTypeMasterId);
		}

		Date timeStamp = (Date)attributes.get("timeStamp");

		if (timeStamp != null) {
			setTimeStamp(timeStamp);
		}
	}

	@Override
	public EmployeeWish cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this employee wish.
	 *
	 * @return the company ID of this employee wish
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the content of this employee wish.
	 *
	 * @return the content of this employee wish
	 */
	@Override
	public String getContent() {
		return model.getContent();
	}

	/**
	 * Returns the create date of this employee wish.
	 *
	 * @return the create date of this employee wish
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this employee wish.
	 *
	 * @return the created by of this employee wish
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the group ID of this employee wish.
	 *
	 * @return the group ID of this employee wish
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified by of this employee wish.
	 *
	 * @return the modified by of this employee wish
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this employee wish.
	 *
	 * @return the modified date of this employee wish
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this employee wish.
	 *
	 * @return the primary key of this employee wish
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the receiver ID of this employee wish.
	 *
	 * @return the receiver ID of this employee wish
	 */
	@Override
	public long getReceiverId() {
		return model.getReceiverId();
	}

	/**
	 * Returns the sender ID of this employee wish.
	 *
	 * @return the sender ID of this employee wish
	 */
	@Override
	public long getSenderId() {
		return model.getSenderId();
	}

	/**
	 * Returns the time stamp of this employee wish.
	 *
	 * @return the time stamp of this employee wish
	 */
	@Override
	public Date getTimeStamp() {
		return model.getTimeStamp();
	}

	/**
	 * Returns the uuid of this employee wish.
	 *
	 * @return the uuid of this employee wish
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns the wish ID of this employee wish.
	 *
	 * @return the wish ID of this employee wish
	 */
	@Override
	public long getWishId() {
		return model.getWishId();
	}

	/**
	 * Returns the wish type master ID of this employee wish.
	 *
	 * @return the wish type master ID of this employee wish
	 */
	@Override
	public long getWishTypeMasterId() {
		return model.getWishTypeMasterId();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this employee wish.
	 *
	 * @param companyId the company ID of this employee wish
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the content of this employee wish.
	 *
	 * @param content the content of this employee wish
	 */
	@Override
	public void setContent(String content) {
		model.setContent(content);
	}

	/**
	 * Sets the create date of this employee wish.
	 *
	 * @param createDate the create date of this employee wish
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this employee wish.
	 *
	 * @param createdBy the created by of this employee wish
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the group ID of this employee wish.
	 *
	 * @param groupId the group ID of this employee wish
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified by of this employee wish.
	 *
	 * @param modifiedBy the modified by of this employee wish
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this employee wish.
	 *
	 * @param modifiedDate the modified date of this employee wish
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this employee wish.
	 *
	 * @param primaryKey the primary key of this employee wish
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the receiver ID of this employee wish.
	 *
	 * @param receiverId the receiver ID of this employee wish
	 */
	@Override
	public void setReceiverId(long receiverId) {
		model.setReceiverId(receiverId);
	}

	/**
	 * Sets the sender ID of this employee wish.
	 *
	 * @param senderId the sender ID of this employee wish
	 */
	@Override
	public void setSenderId(long senderId) {
		model.setSenderId(senderId);
	}

	/**
	 * Sets the time stamp of this employee wish.
	 *
	 * @param timeStamp the time stamp of this employee wish
	 */
	@Override
	public void setTimeStamp(Date timeStamp) {
		model.setTimeStamp(timeStamp);
	}

	/**
	 * Sets the uuid of this employee wish.
	 *
	 * @param uuid the uuid of this employee wish
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	/**
	 * Sets the wish ID of this employee wish.
	 *
	 * @param wishId the wish ID of this employee wish
	 */
	@Override
	public void setWishId(long wishId) {
		model.setWishId(wishId);
	}

	/**
	 * Sets the wish type master ID of this employee wish.
	 *
	 * @param wishTypeMasterId the wish type master ID of this employee wish
	 */
	@Override
	public void setWishTypeMasterId(long wishTypeMasterId) {
		model.setWishTypeMasterId(wishTypeMasterId);
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
	protected EmployeeWishWrapper wrap(EmployeeWish employeeWish) {
		return new EmployeeWishWrapper(employeeWish);
	}

}