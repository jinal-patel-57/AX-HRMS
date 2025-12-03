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
 * This class is a wrapper for {@link AppraisalMeetingInvitees}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AppraisalMeetingInvitees
 * @generated
 */
public class AppraisalMeetingInviteesWrapper
	extends BaseModelWrapper<AppraisalMeetingInvitees>
	implements AppraisalMeetingInvitees,
			   ModelWrapper<AppraisalMeetingInvitees> {

	public AppraisalMeetingInviteesWrapper(
		AppraisalMeetingInvitees appraisalMeetingInvitees) {

		super(appraisalMeetingInvitees);
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
		attributes.put(
			"appraisalMeetingInviteeId", getAppraisalMeetingInviteeId());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("appraisalMeetingId", getAppraisalMeetingId());

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

		Long appraisalMeetingInviteeId = (Long)attributes.get(
			"appraisalMeetingInviteeId");

		if (appraisalMeetingInviteeId != null) {
			setAppraisalMeetingInviteeId(appraisalMeetingInviteeId);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		Long appraisalMeetingId = (Long)attributes.get("appraisalMeetingId");

		if (appraisalMeetingId != null) {
			setAppraisalMeetingId(appraisalMeetingId);
		}
	}

	@Override
	public AppraisalMeetingInvitees cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the appraisal meeting ID of this appraisal meeting invitees.
	 *
	 * @return the appraisal meeting ID of this appraisal meeting invitees
	 */
	@Override
	public long getAppraisalMeetingId() {
		return model.getAppraisalMeetingId();
	}

	/**
	 * Returns the appraisal meeting invitee ID of this appraisal meeting invitees.
	 *
	 * @return the appraisal meeting invitee ID of this appraisal meeting invitees
	 */
	@Override
	public long getAppraisalMeetingInviteeId() {
		return model.getAppraisalMeetingInviteeId();
	}

	/**
	 * Returns the company ID of this appraisal meeting invitees.
	 *
	 * @return the company ID of this appraisal meeting invitees
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this appraisal meeting invitees.
	 *
	 * @return the create date of this appraisal meeting invitees
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this appraisal meeting invitees.
	 *
	 * @return the created by of this appraisal meeting invitees
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the employee ID of this appraisal meeting invitees.
	 *
	 * @return the employee ID of this appraisal meeting invitees
	 */
	@Override
	public long getEmployeeId() {
		return model.getEmployeeId();
	}

	/**
	 * Returns the group ID of this appraisal meeting invitees.
	 *
	 * @return the group ID of this appraisal meeting invitees
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified by of this appraisal meeting invitees.
	 *
	 * @return the modified by of this appraisal meeting invitees
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this appraisal meeting invitees.
	 *
	 * @return the modified date of this appraisal meeting invitees
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this appraisal meeting invitees.
	 *
	 * @return the primary key of this appraisal meeting invitees
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the uuid of this appraisal meeting invitees.
	 *
	 * @return the uuid of this appraisal meeting invitees
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
	 * Sets the appraisal meeting ID of this appraisal meeting invitees.
	 *
	 * @param appraisalMeetingId the appraisal meeting ID of this appraisal meeting invitees
	 */
	@Override
	public void setAppraisalMeetingId(long appraisalMeetingId) {
		model.setAppraisalMeetingId(appraisalMeetingId);
	}

	/**
	 * Sets the appraisal meeting invitee ID of this appraisal meeting invitees.
	 *
	 * @param appraisalMeetingInviteeId the appraisal meeting invitee ID of this appraisal meeting invitees
	 */
	@Override
	public void setAppraisalMeetingInviteeId(long appraisalMeetingInviteeId) {
		model.setAppraisalMeetingInviteeId(appraisalMeetingInviteeId);
	}

	/**
	 * Sets the company ID of this appraisal meeting invitees.
	 *
	 * @param companyId the company ID of this appraisal meeting invitees
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this appraisal meeting invitees.
	 *
	 * @param createDate the create date of this appraisal meeting invitees
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this appraisal meeting invitees.
	 *
	 * @param createdBy the created by of this appraisal meeting invitees
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the employee ID of this appraisal meeting invitees.
	 *
	 * @param employeeId the employee ID of this appraisal meeting invitees
	 */
	@Override
	public void setEmployeeId(long employeeId) {
		model.setEmployeeId(employeeId);
	}

	/**
	 * Sets the group ID of this appraisal meeting invitees.
	 *
	 * @param groupId the group ID of this appraisal meeting invitees
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified by of this appraisal meeting invitees.
	 *
	 * @param modifiedBy the modified by of this appraisal meeting invitees
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this appraisal meeting invitees.
	 *
	 * @param modifiedDate the modified date of this appraisal meeting invitees
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this appraisal meeting invitees.
	 *
	 * @param primaryKey the primary key of this appraisal meeting invitees
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the uuid of this appraisal meeting invitees.
	 *
	 * @param uuid the uuid of this appraisal meeting invitees
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
	protected AppraisalMeetingInviteesWrapper wrap(
		AppraisalMeetingInvitees appraisalMeetingInvitees) {

		return new AppraisalMeetingInviteesWrapper(appraisalMeetingInvitees);
	}

}