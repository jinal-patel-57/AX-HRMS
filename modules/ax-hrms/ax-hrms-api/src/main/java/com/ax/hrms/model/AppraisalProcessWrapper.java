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
 * This class is a wrapper for {@link AppraisalProcess}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AppraisalProcess
 * @generated
 */
public class AppraisalProcessWrapper
	extends BaseModelWrapper<AppraisalProcess>
	implements AppraisalProcess, ModelWrapper<AppraisalProcess> {

	public AppraisalProcessWrapper(AppraisalProcess appraisalProcess) {
		super(appraisalProcess);
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
		attributes.put("appraisalProcessId", getAppraisalProcessId());
		attributes.put("isSelfEvalutionFormSent", isIsSelfEvalutionFormSent());
		attributes.put(
			"isSelfEvalutionFormFilled", isIsSelfEvalutionFormFilled());
		attributes.put(
			"arePeerEvaluationFormSent", isArePeerEvaluationFormSent());
		attributes.put(
			"arePeerEvaluationFormFilled", isArePeerEvaluationFormFilled());
		attributes.put("isManagementFormSent", isIsManagementFormSent());
		attributes.put("isManagementFormFilled", isIsManagementFormFilled());
		attributes.put("isMeetingScheduled", isIsMeetingScheduled());
		attributes.put("isMeetingDone", isIsMeetingDone());
		attributes.put("isSalaryUpdated", isIsSalaryUpdated());
		attributes.put("status", getStatus());

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

		Long appraisalProcessId = (Long)attributes.get("appraisalProcessId");

		if (appraisalProcessId != null) {
			setAppraisalProcessId(appraisalProcessId);
		}

		Boolean isSelfEvalutionFormSent = (Boolean)attributes.get(
			"isSelfEvalutionFormSent");

		if (isSelfEvalutionFormSent != null) {
			setIsSelfEvalutionFormSent(isSelfEvalutionFormSent);
		}

		Boolean isSelfEvalutionFormFilled = (Boolean)attributes.get(
			"isSelfEvalutionFormFilled");

		if (isSelfEvalutionFormFilled != null) {
			setIsSelfEvalutionFormFilled(isSelfEvalutionFormFilled);
		}

		Boolean arePeerEvaluationFormSent = (Boolean)attributes.get(
			"arePeerEvaluationFormSent");

		if (arePeerEvaluationFormSent != null) {
			setArePeerEvaluationFormSent(arePeerEvaluationFormSent);
		}

		Boolean arePeerEvaluationFormFilled = (Boolean)attributes.get(
			"arePeerEvaluationFormFilled");

		if (arePeerEvaluationFormFilled != null) {
			setArePeerEvaluationFormFilled(arePeerEvaluationFormFilled);
		}

		Boolean isManagementFormSent = (Boolean)attributes.get(
			"isManagementFormSent");

		if (isManagementFormSent != null) {
			setIsManagementFormSent(isManagementFormSent);
		}

		Boolean isManagementFormFilled = (Boolean)attributes.get(
			"isManagementFormFilled");

		if (isManagementFormFilled != null) {
			setIsManagementFormFilled(isManagementFormFilled);
		}

		Boolean isMeetingScheduled = (Boolean)attributes.get(
			"isMeetingScheduled");

		if (isMeetingScheduled != null) {
			setIsMeetingScheduled(isMeetingScheduled);
		}

		Boolean isMeetingDone = (Boolean)attributes.get("isMeetingDone");

		if (isMeetingDone != null) {
			setIsMeetingDone(isMeetingDone);
		}

		Boolean isSalaryUpdated = (Boolean)attributes.get("isSalaryUpdated");

		if (isSalaryUpdated != null) {
			setIsSalaryUpdated(isSalaryUpdated);
		}

		Long status = (Long)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	@Override
	public AppraisalProcess cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the appraisal process ID of this appraisal process.
	 *
	 * @return the appraisal process ID of this appraisal process
	 */
	@Override
	public long getAppraisalProcessId() {
		return model.getAppraisalProcessId();
	}

	/**
	 * Returns the are peer evaluation form filled of this appraisal process.
	 *
	 * @return the are peer evaluation form filled of this appraisal process
	 */
	@Override
	public boolean getArePeerEvaluationFormFilled() {
		return model.getArePeerEvaluationFormFilled();
	}

	/**
	 * Returns the are peer evaluation form sent of this appraisal process.
	 *
	 * @return the are peer evaluation form sent of this appraisal process
	 */
	@Override
	public boolean getArePeerEvaluationFormSent() {
		return model.getArePeerEvaluationFormSent();
	}

	/**
	 * Returns the company ID of this appraisal process.
	 *
	 * @return the company ID of this appraisal process
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this appraisal process.
	 *
	 * @return the create date of this appraisal process
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this appraisal process.
	 *
	 * @return the created by of this appraisal process
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the group ID of this appraisal process.
	 *
	 * @return the group ID of this appraisal process
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the is management form filled of this appraisal process.
	 *
	 * @return the is management form filled of this appraisal process
	 */
	@Override
	public boolean getIsManagementFormFilled() {
		return model.getIsManagementFormFilled();
	}

	/**
	 * Returns the is management form sent of this appraisal process.
	 *
	 * @return the is management form sent of this appraisal process
	 */
	@Override
	public boolean getIsManagementFormSent() {
		return model.getIsManagementFormSent();
	}

	/**
	 * Returns the is meeting done of this appraisal process.
	 *
	 * @return the is meeting done of this appraisal process
	 */
	@Override
	public boolean getIsMeetingDone() {
		return model.getIsMeetingDone();
	}

	/**
	 * Returns the is meeting scheduled of this appraisal process.
	 *
	 * @return the is meeting scheduled of this appraisal process
	 */
	@Override
	public boolean getIsMeetingScheduled() {
		return model.getIsMeetingScheduled();
	}

	/**
	 * Returns the is salary updated of this appraisal process.
	 *
	 * @return the is salary updated of this appraisal process
	 */
	@Override
	public boolean getIsSalaryUpdated() {
		return model.getIsSalaryUpdated();
	}

	/**
	 * Returns the is self evalution form filled of this appraisal process.
	 *
	 * @return the is self evalution form filled of this appraisal process
	 */
	@Override
	public boolean getIsSelfEvalutionFormFilled() {
		return model.getIsSelfEvalutionFormFilled();
	}

	/**
	 * Returns the is self evalution form sent of this appraisal process.
	 *
	 * @return the is self evalution form sent of this appraisal process
	 */
	@Override
	public boolean getIsSelfEvalutionFormSent() {
		return model.getIsSelfEvalutionFormSent();
	}

	/**
	 * Returns the modified by of this appraisal process.
	 *
	 * @return the modified by of this appraisal process
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this appraisal process.
	 *
	 * @return the modified date of this appraisal process
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this appraisal process.
	 *
	 * @return the primary key of this appraisal process
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this appraisal process.
	 *
	 * @return the status of this appraisal process
	 */
	@Override
	public long getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the uuid of this appraisal process.
	 *
	 * @return the uuid of this appraisal process
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this appraisal process is are peer evaluation form filled.
	 *
	 * @return <code>true</code> if this appraisal process is are peer evaluation form filled; <code>false</code> otherwise
	 */
	@Override
	public boolean isArePeerEvaluationFormFilled() {
		return model.isArePeerEvaluationFormFilled();
	}

	/**
	 * Returns <code>true</code> if this appraisal process is are peer evaluation form sent.
	 *
	 * @return <code>true</code> if this appraisal process is are peer evaluation form sent; <code>false</code> otherwise
	 */
	@Override
	public boolean isArePeerEvaluationFormSent() {
		return model.isArePeerEvaluationFormSent();
	}

	/**
	 * Returns <code>true</code> if this appraisal process is is management form filled.
	 *
	 * @return <code>true</code> if this appraisal process is is management form filled; <code>false</code> otherwise
	 */
	@Override
	public boolean isIsManagementFormFilled() {
		return model.isIsManagementFormFilled();
	}

	/**
	 * Returns <code>true</code> if this appraisal process is is management form sent.
	 *
	 * @return <code>true</code> if this appraisal process is is management form sent; <code>false</code> otherwise
	 */
	@Override
	public boolean isIsManagementFormSent() {
		return model.isIsManagementFormSent();
	}

	/**
	 * Returns <code>true</code> if this appraisal process is is meeting done.
	 *
	 * @return <code>true</code> if this appraisal process is is meeting done; <code>false</code> otherwise
	 */
	@Override
	public boolean isIsMeetingDone() {
		return model.isIsMeetingDone();
	}

	/**
	 * Returns <code>true</code> if this appraisal process is is meeting scheduled.
	 *
	 * @return <code>true</code> if this appraisal process is is meeting scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isIsMeetingScheduled() {
		return model.isIsMeetingScheduled();
	}

	/**
	 * Returns <code>true</code> if this appraisal process is is salary updated.
	 *
	 * @return <code>true</code> if this appraisal process is is salary updated; <code>false</code> otherwise
	 */
	@Override
	public boolean isIsSalaryUpdated() {
		return model.isIsSalaryUpdated();
	}

	/**
	 * Returns <code>true</code> if this appraisal process is is self evalution form filled.
	 *
	 * @return <code>true</code> if this appraisal process is is self evalution form filled; <code>false</code> otherwise
	 */
	@Override
	public boolean isIsSelfEvalutionFormFilled() {
		return model.isIsSelfEvalutionFormFilled();
	}

	/**
	 * Returns <code>true</code> if this appraisal process is is self evalution form sent.
	 *
	 * @return <code>true</code> if this appraisal process is is self evalution form sent; <code>false</code> otherwise
	 */
	@Override
	public boolean isIsSelfEvalutionFormSent() {
		return model.isIsSelfEvalutionFormSent();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the appraisal process ID of this appraisal process.
	 *
	 * @param appraisalProcessId the appraisal process ID of this appraisal process
	 */
	@Override
	public void setAppraisalProcessId(long appraisalProcessId) {
		model.setAppraisalProcessId(appraisalProcessId);
	}

	/**
	 * Sets whether this appraisal process is are peer evaluation form filled.
	 *
	 * @param arePeerEvaluationFormFilled the are peer evaluation form filled of this appraisal process
	 */
	@Override
	public void setArePeerEvaluationFormFilled(
		boolean arePeerEvaluationFormFilled) {

		model.setArePeerEvaluationFormFilled(arePeerEvaluationFormFilled);
	}

	/**
	 * Sets whether this appraisal process is are peer evaluation form sent.
	 *
	 * @param arePeerEvaluationFormSent the are peer evaluation form sent of this appraisal process
	 */
	@Override
	public void setArePeerEvaluationFormSent(
		boolean arePeerEvaluationFormSent) {

		model.setArePeerEvaluationFormSent(arePeerEvaluationFormSent);
	}

	/**
	 * Sets the company ID of this appraisal process.
	 *
	 * @param companyId the company ID of this appraisal process
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this appraisal process.
	 *
	 * @param createDate the create date of this appraisal process
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this appraisal process.
	 *
	 * @param createdBy the created by of this appraisal process
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the group ID of this appraisal process.
	 *
	 * @param groupId the group ID of this appraisal process
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets whether this appraisal process is is management form filled.
	 *
	 * @param isManagementFormFilled the is management form filled of this appraisal process
	 */
	@Override
	public void setIsManagementFormFilled(boolean isManagementFormFilled) {
		model.setIsManagementFormFilled(isManagementFormFilled);
	}

	/**
	 * Sets whether this appraisal process is is management form sent.
	 *
	 * @param isManagementFormSent the is management form sent of this appraisal process
	 */
	@Override
	public void setIsManagementFormSent(boolean isManagementFormSent) {
		model.setIsManagementFormSent(isManagementFormSent);
	}

	/**
	 * Sets whether this appraisal process is is meeting done.
	 *
	 * @param isMeetingDone the is meeting done of this appraisal process
	 */
	@Override
	public void setIsMeetingDone(boolean isMeetingDone) {
		model.setIsMeetingDone(isMeetingDone);
	}

	/**
	 * Sets whether this appraisal process is is meeting scheduled.
	 *
	 * @param isMeetingScheduled the is meeting scheduled of this appraisal process
	 */
	@Override
	public void setIsMeetingScheduled(boolean isMeetingScheduled) {
		model.setIsMeetingScheduled(isMeetingScheduled);
	}

	/**
	 * Sets whether this appraisal process is is salary updated.
	 *
	 * @param isSalaryUpdated the is salary updated of this appraisal process
	 */
	@Override
	public void setIsSalaryUpdated(boolean isSalaryUpdated) {
		model.setIsSalaryUpdated(isSalaryUpdated);
	}

	/**
	 * Sets whether this appraisal process is is self evalution form filled.
	 *
	 * @param isSelfEvalutionFormFilled the is self evalution form filled of this appraisal process
	 */
	@Override
	public void setIsSelfEvalutionFormFilled(
		boolean isSelfEvalutionFormFilled) {

		model.setIsSelfEvalutionFormFilled(isSelfEvalutionFormFilled);
	}

	/**
	 * Sets whether this appraisal process is is self evalution form sent.
	 *
	 * @param isSelfEvalutionFormSent the is self evalution form sent of this appraisal process
	 */
	@Override
	public void setIsSelfEvalutionFormSent(boolean isSelfEvalutionFormSent) {
		model.setIsSelfEvalutionFormSent(isSelfEvalutionFormSent);
	}

	/**
	 * Sets the modified by of this appraisal process.
	 *
	 * @param modifiedBy the modified by of this appraisal process
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this appraisal process.
	 *
	 * @param modifiedDate the modified date of this appraisal process
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this appraisal process.
	 *
	 * @param primaryKey the primary key of this appraisal process
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this appraisal process.
	 *
	 * @param status the status of this appraisal process
	 */
	@Override
	public void setStatus(long status) {
		model.setStatus(status);
	}

	/**
	 * Sets the uuid of this appraisal process.
	 *
	 * @param uuid the uuid of this appraisal process
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
	protected AppraisalProcessWrapper wrap(AppraisalProcess appraisalProcess) {
		return new AppraisalProcessWrapper(appraisalProcess);
	}

}