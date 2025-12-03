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
 * This class is a wrapper for {@link PipProgram}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PipProgram
 * @generated
 */
public class PipProgramWrapper
	extends BaseModelWrapper<PipProgram>
	implements ModelWrapper<PipProgram>, PipProgram {

	public PipProgramWrapper(PipProgram pipProgram) {
		super(pipProgram);
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
		attributes.put("pipProgramId", getPipProgramId());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());
		attributes.put("numberOfMonths", getNumberOfMonths());
		attributes.put("improvementAreas", getImprovementAreas());
		attributes.put("meetingDate", getMeetingDate());
		attributes.put("status", getStatus());
		attributes.put("isExtended", isIsExtended());

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

		Long pipProgramId = (Long)attributes.get("pipProgramId");

		if (pipProgramId != null) {
			setPipProgramId(pipProgramId);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}

		Integer numberOfMonths = (Integer)attributes.get("numberOfMonths");

		if (numberOfMonths != null) {
			setNumberOfMonths(numberOfMonths);
		}

		String improvementAreas = (String)attributes.get("improvementAreas");

		if (improvementAreas != null) {
			setImprovementAreas(improvementAreas);
		}

		Date meetingDate = (Date)attributes.get("meetingDate");

		if (meetingDate != null) {
			setMeetingDate(meetingDate);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Boolean isExtended = (Boolean)attributes.get("isExtended");

		if (isExtended != null) {
			setIsExtended(isExtended);
		}
	}

	@Override
	public PipProgram cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this pip program.
	 *
	 * @return the company ID of this pip program
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this pip program.
	 *
	 * @return the create date of this pip program
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this pip program.
	 *
	 * @return the created by of this pip program
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the employee ID of this pip program.
	 *
	 * @return the employee ID of this pip program
	 */
	@Override
	public long getEmployeeId() {
		return model.getEmployeeId();
	}

	/**
	 * Returns the end date of this pip program.
	 *
	 * @return the end date of this pip program
	 */
	@Override
	public Date getEndDate() {
		return model.getEndDate();
	}

	/**
	 * Returns the group ID of this pip program.
	 *
	 * @return the group ID of this pip program
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the improvement areas of this pip program.
	 *
	 * @return the improvement areas of this pip program
	 */
	@Override
	public String getImprovementAreas() {
		return model.getImprovementAreas();
	}

	/**
	 * Returns the is extended of this pip program.
	 *
	 * @return the is extended of this pip program
	 */
	@Override
	public boolean getIsExtended() {
		return model.getIsExtended();
	}

	/**
	 * Returns the meeting date of this pip program.
	 *
	 * @return the meeting date of this pip program
	 */
	@Override
	public Date getMeetingDate() {
		return model.getMeetingDate();
	}

	/**
	 * Returns the modified by of this pip program.
	 *
	 * @return the modified by of this pip program
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this pip program.
	 *
	 * @return the modified date of this pip program
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the number of months of this pip program.
	 *
	 * @return the number of months of this pip program
	 */
	@Override
	public int getNumberOfMonths() {
		return model.getNumberOfMonths();
	}

	/**
	 * Returns the pip program ID of this pip program.
	 *
	 * @return the pip program ID of this pip program
	 */
	@Override
	public long getPipProgramId() {
		return model.getPipProgramId();
	}

	/**
	 * Returns the primary key of this pip program.
	 *
	 * @return the primary key of this pip program
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the start date of this pip program.
	 *
	 * @return the start date of this pip program
	 */
	@Override
	public Date getStartDate() {
		return model.getStartDate();
	}

	/**
	 * Returns the status of this pip program.
	 *
	 * @return the status of this pip program
	 */
	@Override
	public String getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the uuid of this pip program.
	 *
	 * @return the uuid of this pip program
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this pip program is is extended.
	 *
	 * @return <code>true</code> if this pip program is is extended; <code>false</code> otherwise
	 */
	@Override
	public boolean isIsExtended() {
		return model.isIsExtended();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this pip program.
	 *
	 * @param companyId the company ID of this pip program
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this pip program.
	 *
	 * @param createDate the create date of this pip program
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this pip program.
	 *
	 * @param createdBy the created by of this pip program
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the employee ID of this pip program.
	 *
	 * @param employeeId the employee ID of this pip program
	 */
	@Override
	public void setEmployeeId(long employeeId) {
		model.setEmployeeId(employeeId);
	}

	/**
	 * Sets the end date of this pip program.
	 *
	 * @param endDate the end date of this pip program
	 */
	@Override
	public void setEndDate(Date endDate) {
		model.setEndDate(endDate);
	}

	/**
	 * Sets the group ID of this pip program.
	 *
	 * @param groupId the group ID of this pip program
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the improvement areas of this pip program.
	 *
	 * @param improvementAreas the improvement areas of this pip program
	 */
	@Override
	public void setImprovementAreas(String improvementAreas) {
		model.setImprovementAreas(improvementAreas);
	}

	/**
	 * Sets whether this pip program is is extended.
	 *
	 * @param isExtended the is extended of this pip program
	 */
	@Override
	public void setIsExtended(boolean isExtended) {
		model.setIsExtended(isExtended);
	}

	/**
	 * Sets the meeting date of this pip program.
	 *
	 * @param meetingDate the meeting date of this pip program
	 */
	@Override
	public void setMeetingDate(Date meetingDate) {
		model.setMeetingDate(meetingDate);
	}

	/**
	 * Sets the modified by of this pip program.
	 *
	 * @param modifiedBy the modified by of this pip program
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this pip program.
	 *
	 * @param modifiedDate the modified date of this pip program
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the number of months of this pip program.
	 *
	 * @param numberOfMonths the number of months of this pip program
	 */
	@Override
	public void setNumberOfMonths(int numberOfMonths) {
		model.setNumberOfMonths(numberOfMonths);
	}

	/**
	 * Sets the pip program ID of this pip program.
	 *
	 * @param pipProgramId the pip program ID of this pip program
	 */
	@Override
	public void setPipProgramId(long pipProgramId) {
		model.setPipProgramId(pipProgramId);
	}

	/**
	 * Sets the primary key of this pip program.
	 *
	 * @param primaryKey the primary key of this pip program
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the start date of this pip program.
	 *
	 * @param startDate the start date of this pip program
	 */
	@Override
	public void setStartDate(Date startDate) {
		model.setStartDate(startDate);
	}

	/**
	 * Sets the status of this pip program.
	 *
	 * @param status the status of this pip program
	 */
	@Override
	public void setStatus(String status) {
		model.setStatus(status);
	}

	/**
	 * Sets the uuid of this pip program.
	 *
	 * @param uuid the uuid of this pip program
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
	protected PipProgramWrapper wrap(PipProgram pipProgram) {
		return new PipProgramWrapper(pipProgram);
	}

}