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
 * This class is a wrapper for {@link AppraisalMeeting}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AppraisalMeeting
 * @generated
 */
public class AppraisalMeetingWrapper
	extends BaseModelWrapper<AppraisalMeeting>
	implements AppraisalMeeting, ModelWrapper<AppraisalMeeting> {

	public AppraisalMeetingWrapper(AppraisalMeeting appraisalMeeting) {
		super(appraisalMeeting);
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
		attributes.put("appraisalMeetingId", getAppraisalMeetingId());
		attributes.put("appraisalProcessId", getAppraisalProcessId());
		attributes.put("meetingDate", getMeetingDate());
		attributes.put("meetingTime", getMeetingTime());
		attributes.put("status", isStatus());

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

		Long appraisalMeetingId = (Long)attributes.get("appraisalMeetingId");

		if (appraisalMeetingId != null) {
			setAppraisalMeetingId(appraisalMeetingId);
		}

		Long appraisalProcessId = (Long)attributes.get("appraisalProcessId");

		if (appraisalProcessId != null) {
			setAppraisalProcessId(appraisalProcessId);
		}

		Date meetingDate = (Date)attributes.get("meetingDate");

		if (meetingDate != null) {
			setMeetingDate(meetingDate);
		}

		Date meetingTime = (Date)attributes.get("meetingTime");

		if (meetingTime != null) {
			setMeetingTime(meetingTime);
		}

		Boolean status = (Boolean)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	@Override
	public AppraisalMeeting cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the appraisal meeting ID of this appraisal meeting.
	 *
	 * @return the appraisal meeting ID of this appraisal meeting
	 */
	@Override
	public long getAppraisalMeetingId() {
		return model.getAppraisalMeetingId();
	}

	/**
	 * Returns the appraisal process ID of this appraisal meeting.
	 *
	 * @return the appraisal process ID of this appraisal meeting
	 */
	@Override
	public long getAppraisalProcessId() {
		return model.getAppraisalProcessId();
	}

	/**
	 * Returns the company ID of this appraisal meeting.
	 *
	 * @return the company ID of this appraisal meeting
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this appraisal meeting.
	 *
	 * @return the create date of this appraisal meeting
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this appraisal meeting.
	 *
	 * @return the created by of this appraisal meeting
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the group ID of this appraisal meeting.
	 *
	 * @return the group ID of this appraisal meeting
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the meeting date of this appraisal meeting.
	 *
	 * @return the meeting date of this appraisal meeting
	 */
	@Override
	public Date getMeetingDate() {
		return model.getMeetingDate();
	}

	/**
	 * Returns the meeting time of this appraisal meeting.
	 *
	 * @return the meeting time of this appraisal meeting
	 */
	@Override
	public Date getMeetingTime() {
		return model.getMeetingTime();
	}

	/**
	 * Returns the modified by of this appraisal meeting.
	 *
	 * @return the modified by of this appraisal meeting
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this appraisal meeting.
	 *
	 * @return the modified date of this appraisal meeting
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this appraisal meeting.
	 *
	 * @return the primary key of this appraisal meeting
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this appraisal meeting.
	 *
	 * @return the status of this appraisal meeting
	 */
	@Override
	public boolean getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the uuid of this appraisal meeting.
	 *
	 * @return the uuid of this appraisal meeting
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this appraisal meeting is status.
	 *
	 * @return <code>true</code> if this appraisal meeting is status; <code>false</code> otherwise
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
	 * Sets the appraisal meeting ID of this appraisal meeting.
	 *
	 * @param appraisalMeetingId the appraisal meeting ID of this appraisal meeting
	 */
	@Override
	public void setAppraisalMeetingId(long appraisalMeetingId) {
		model.setAppraisalMeetingId(appraisalMeetingId);
	}

	/**
	 * Sets the appraisal process ID of this appraisal meeting.
	 *
	 * @param appraisalProcessId the appraisal process ID of this appraisal meeting
	 */
	@Override
	public void setAppraisalProcessId(long appraisalProcessId) {
		model.setAppraisalProcessId(appraisalProcessId);
	}

	/**
	 * Sets the company ID of this appraisal meeting.
	 *
	 * @param companyId the company ID of this appraisal meeting
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this appraisal meeting.
	 *
	 * @param createDate the create date of this appraisal meeting
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this appraisal meeting.
	 *
	 * @param createdBy the created by of this appraisal meeting
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the group ID of this appraisal meeting.
	 *
	 * @param groupId the group ID of this appraisal meeting
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the meeting date of this appraisal meeting.
	 *
	 * @param meetingDate the meeting date of this appraisal meeting
	 */
	@Override
	public void setMeetingDate(Date meetingDate) {
		model.setMeetingDate(meetingDate);
	}

	/**
	 * Sets the meeting time of this appraisal meeting.
	 *
	 * @param meetingTime the meeting time of this appraisal meeting
	 */
	@Override
	public void setMeetingTime(Date meetingTime) {
		model.setMeetingTime(meetingTime);
	}

	/**
	 * Sets the modified by of this appraisal meeting.
	 *
	 * @param modifiedBy the modified by of this appraisal meeting
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this appraisal meeting.
	 *
	 * @param modifiedDate the modified date of this appraisal meeting
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this appraisal meeting.
	 *
	 * @param primaryKey the primary key of this appraisal meeting
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets whether this appraisal meeting is status.
	 *
	 * @param status the status of this appraisal meeting
	 */
	@Override
	public void setStatus(boolean status) {
		model.setStatus(status);
	}

	/**
	 * Sets the uuid of this appraisal meeting.
	 *
	 * @param uuid the uuid of this appraisal meeting
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
	protected AppraisalMeetingWrapper wrap(AppraisalMeeting appraisalMeeting) {
		return new AppraisalMeetingWrapper(appraisalMeeting);
	}

}