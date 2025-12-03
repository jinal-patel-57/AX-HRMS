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
 * This class is a wrapper for {@link AppraisalReminder}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AppraisalReminder
 * @generated
 */
public class AppraisalReminderWrapper
	extends BaseModelWrapper<AppraisalReminder>
	implements AppraisalReminder, ModelWrapper<AppraisalReminder> {

	public AppraisalReminderWrapper(AppraisalReminder appraisalReminder) {
		super(appraisalReminder);
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
		attributes.put("appraisalRemainderId", getAppraisalRemainderId());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("appraisalRemainderMonth", getAppraisalRemainderMonth());
		attributes.put("appraisalRemainderYear", getAppraisalRemainderYear());
		attributes.put("appraisalProcessId", getAppraisalProcessId());

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

		Long appraisalRemainderId = (Long)attributes.get(
			"appraisalRemainderId");

		if (appraisalRemainderId != null) {
			setAppraisalRemainderId(appraisalRemainderId);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		String appraisalRemainderMonth = (String)attributes.get(
			"appraisalRemainderMonth");

		if (appraisalRemainderMonth != null) {
			setAppraisalRemainderMonth(appraisalRemainderMonth);
		}

		String appraisalRemainderYear = (String)attributes.get(
			"appraisalRemainderYear");

		if (appraisalRemainderYear != null) {
			setAppraisalRemainderYear(appraisalRemainderYear);
		}

		Long appraisalProcessId = (Long)attributes.get("appraisalProcessId");

		if (appraisalProcessId != null) {
			setAppraisalProcessId(appraisalProcessId);
		}
	}

	@Override
	public AppraisalReminder cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the appraisal process ID of this appraisal reminder.
	 *
	 * @return the appraisal process ID of this appraisal reminder
	 */
	@Override
	public long getAppraisalProcessId() {
		return model.getAppraisalProcessId();
	}

	/**
	 * Returns the appraisal remainder ID of this appraisal reminder.
	 *
	 * @return the appraisal remainder ID of this appraisal reminder
	 */
	@Override
	public long getAppraisalRemainderId() {
		return model.getAppraisalRemainderId();
	}

	/**
	 * Returns the appraisal remainder month of this appraisal reminder.
	 *
	 * @return the appraisal remainder month of this appraisal reminder
	 */
	@Override
	public String getAppraisalRemainderMonth() {
		return model.getAppraisalRemainderMonth();
	}

	/**
	 * Returns the appraisal remainder year of this appraisal reminder.
	 *
	 * @return the appraisal remainder year of this appraisal reminder
	 */
	@Override
	public String getAppraisalRemainderYear() {
		return model.getAppraisalRemainderYear();
	}

	/**
	 * Returns the company ID of this appraisal reminder.
	 *
	 * @return the company ID of this appraisal reminder
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this appraisal reminder.
	 *
	 * @return the create date of this appraisal reminder
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this appraisal reminder.
	 *
	 * @return the created by of this appraisal reminder
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the employee ID of this appraisal reminder.
	 *
	 * @return the employee ID of this appraisal reminder
	 */
	@Override
	public long getEmployeeId() {
		return model.getEmployeeId();
	}

	/**
	 * Returns the group ID of this appraisal reminder.
	 *
	 * @return the group ID of this appraisal reminder
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified by of this appraisal reminder.
	 *
	 * @return the modified by of this appraisal reminder
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this appraisal reminder.
	 *
	 * @return the modified date of this appraisal reminder
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this appraisal reminder.
	 *
	 * @return the primary key of this appraisal reminder
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the uuid of this appraisal reminder.
	 *
	 * @return the uuid of this appraisal reminder
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
	 * Sets the appraisal process ID of this appraisal reminder.
	 *
	 * @param appraisalProcessId the appraisal process ID of this appraisal reminder
	 */
	@Override
	public void setAppraisalProcessId(long appraisalProcessId) {
		model.setAppraisalProcessId(appraisalProcessId);
	}

	/**
	 * Sets the appraisal remainder ID of this appraisal reminder.
	 *
	 * @param appraisalRemainderId the appraisal remainder ID of this appraisal reminder
	 */
	@Override
	public void setAppraisalRemainderId(long appraisalRemainderId) {
		model.setAppraisalRemainderId(appraisalRemainderId);
	}

	/**
	 * Sets the appraisal remainder month of this appraisal reminder.
	 *
	 * @param appraisalRemainderMonth the appraisal remainder month of this appraisal reminder
	 */
	@Override
	public void setAppraisalRemainderMonth(String appraisalRemainderMonth) {
		model.setAppraisalRemainderMonth(appraisalRemainderMonth);
	}

	/**
	 * Sets the appraisal remainder year of this appraisal reminder.
	 *
	 * @param appraisalRemainderYear the appraisal remainder year of this appraisal reminder
	 */
	@Override
	public void setAppraisalRemainderYear(String appraisalRemainderYear) {
		model.setAppraisalRemainderYear(appraisalRemainderYear);
	}

	/**
	 * Sets the company ID of this appraisal reminder.
	 *
	 * @param companyId the company ID of this appraisal reminder
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this appraisal reminder.
	 *
	 * @param createDate the create date of this appraisal reminder
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this appraisal reminder.
	 *
	 * @param createdBy the created by of this appraisal reminder
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the employee ID of this appraisal reminder.
	 *
	 * @param employeeId the employee ID of this appraisal reminder
	 */
	@Override
	public void setEmployeeId(long employeeId) {
		model.setEmployeeId(employeeId);
	}

	/**
	 * Sets the group ID of this appraisal reminder.
	 *
	 * @param groupId the group ID of this appraisal reminder
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified by of this appraisal reminder.
	 *
	 * @param modifiedBy the modified by of this appraisal reminder
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this appraisal reminder.
	 *
	 * @param modifiedDate the modified date of this appraisal reminder
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this appraisal reminder.
	 *
	 * @param primaryKey the primary key of this appraisal reminder
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the uuid of this appraisal reminder.
	 *
	 * @param uuid the uuid of this appraisal reminder
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
	protected AppraisalReminderWrapper wrap(
		AppraisalReminder appraisalReminder) {

		return new AppraisalReminderWrapper(appraisalReminder);
	}

}