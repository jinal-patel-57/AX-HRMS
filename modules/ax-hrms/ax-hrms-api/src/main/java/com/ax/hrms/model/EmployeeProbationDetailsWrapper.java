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
 * This class is a wrapper for {@link EmployeeProbationDetails}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeProbationDetails
 * @generated
 */
public class EmployeeProbationDetailsWrapper
	extends BaseModelWrapper<EmployeeProbationDetails>
	implements EmployeeProbationDetails,
			   ModelWrapper<EmployeeProbationDetails> {

	public EmployeeProbationDetailsWrapper(
		EmployeeProbationDetails employeeProbationDetails) {

		super(employeeProbationDetails);
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
		attributes.put("probationDetailId", getProbationDetailId());
		attributes.put("probationPeriod", getProbationPeriod());
		attributes.put("probationEndDate", getProbationEndDate());
		attributes.put("probationStatusId", getProbationStatusId());
		attributes.put("isExtended", getIsExtended());
		attributes.put("employeeId", getEmployeeId());

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

		Long probationDetailId = (Long)attributes.get("probationDetailId");

		if (probationDetailId != null) {
			setProbationDetailId(probationDetailId);
		}

		Integer probationPeriod = (Integer)attributes.get("probationPeriod");

		if (probationPeriod != null) {
			setProbationPeriod(probationPeriod);
		}

		Date probationEndDate = (Date)attributes.get("probationEndDate");

		if (probationEndDate != null) {
			setProbationEndDate(probationEndDate);
		}

		Long probationStatusId = (Long)attributes.get("probationStatusId");

		if (probationStatusId != null) {
			setProbationStatusId(probationStatusId);
		}

		Boolean isExtended = (Boolean)attributes.get("isExtended");

		if (isExtended != null) {
			setIsExtended(isExtended);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}
	}

	@Override
	public EmployeeProbationDetails cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this employee probation details.
	 *
	 * @return the company ID of this employee probation details
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this employee probation details.
	 *
	 * @return the create date of this employee probation details
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this employee probation details.
	 *
	 * @return the created by of this employee probation details
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the employee ID of this employee probation details.
	 *
	 * @return the employee ID of this employee probation details
	 */
	@Override
	public long getEmployeeId() {
		return model.getEmployeeId();
	}

	/**
	 * Returns the group ID of this employee probation details.
	 *
	 * @return the group ID of this employee probation details
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the is extended of this employee probation details.
	 *
	 * @return the is extended of this employee probation details
	 */
	@Override
	public Boolean getIsExtended() {
		return model.getIsExtended();
	}

	/**
	 * Returns the modified by of this employee probation details.
	 *
	 * @return the modified by of this employee probation details
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this employee probation details.
	 *
	 * @return the modified date of this employee probation details
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this employee probation details.
	 *
	 * @return the primary key of this employee probation details
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the probation detail ID of this employee probation details.
	 *
	 * @return the probation detail ID of this employee probation details
	 */
	@Override
	public long getProbationDetailId() {
		return model.getProbationDetailId();
	}

	/**
	 * Returns the probation end date of this employee probation details.
	 *
	 * @return the probation end date of this employee probation details
	 */
	@Override
	public Date getProbationEndDate() {
		return model.getProbationEndDate();
	}

	/**
	 * Returns the probation period of this employee probation details.
	 *
	 * @return the probation period of this employee probation details
	 */
	@Override
	public int getProbationPeriod() {
		return model.getProbationPeriod();
	}

	/**
	 * Returns the probation status ID of this employee probation details.
	 *
	 * @return the probation status ID of this employee probation details
	 */
	@Override
	public long getProbationStatusId() {
		return model.getProbationStatusId();
	}

	/**
	 * Returns the uuid of this employee probation details.
	 *
	 * @return the uuid of this employee probation details
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
	 * Sets the company ID of this employee probation details.
	 *
	 * @param companyId the company ID of this employee probation details
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this employee probation details.
	 *
	 * @param createDate the create date of this employee probation details
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this employee probation details.
	 *
	 * @param createdBy the created by of this employee probation details
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the employee ID of this employee probation details.
	 *
	 * @param employeeId the employee ID of this employee probation details
	 */
	@Override
	public void setEmployeeId(long employeeId) {
		model.setEmployeeId(employeeId);
	}

	/**
	 * Sets the group ID of this employee probation details.
	 *
	 * @param groupId the group ID of this employee probation details
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the is extended of this employee probation details.
	 *
	 * @param isExtended the is extended of this employee probation details
	 */
	@Override
	public void setIsExtended(Boolean isExtended) {
		model.setIsExtended(isExtended);
	}

	/**
	 * Sets the modified by of this employee probation details.
	 *
	 * @param modifiedBy the modified by of this employee probation details
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this employee probation details.
	 *
	 * @param modifiedDate the modified date of this employee probation details
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this employee probation details.
	 *
	 * @param primaryKey the primary key of this employee probation details
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the probation detail ID of this employee probation details.
	 *
	 * @param probationDetailId the probation detail ID of this employee probation details
	 */
	@Override
	public void setProbationDetailId(long probationDetailId) {
		model.setProbationDetailId(probationDetailId);
	}

	/**
	 * Sets the probation end date of this employee probation details.
	 *
	 * @param probationEndDate the probation end date of this employee probation details
	 */
	@Override
	public void setProbationEndDate(Date probationEndDate) {
		model.setProbationEndDate(probationEndDate);
	}

	/**
	 * Sets the probation period of this employee probation details.
	 *
	 * @param probationPeriod the probation period of this employee probation details
	 */
	@Override
	public void setProbationPeriod(int probationPeriod) {
		model.setProbationPeriod(probationPeriod);
	}

	/**
	 * Sets the probation status ID of this employee probation details.
	 *
	 * @param probationStatusId the probation status ID of this employee probation details
	 */
	@Override
	public void setProbationStatusId(long probationStatusId) {
		model.setProbationStatusId(probationStatusId);
	}

	/**
	 * Sets the uuid of this employee probation details.
	 *
	 * @param uuid the uuid of this employee probation details
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
	protected EmployeeProbationDetailsWrapper wrap(
		EmployeeProbationDetails employeeProbationDetails) {

		return new EmployeeProbationDetailsWrapper(employeeProbationDetails);
	}

}