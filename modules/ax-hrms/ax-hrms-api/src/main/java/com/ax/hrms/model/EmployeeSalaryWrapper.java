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
 * This class is a wrapper for {@link EmployeeSalary}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeSalary
 * @generated
 */
public class EmployeeSalaryWrapper
	extends BaseModelWrapper<EmployeeSalary>
	implements EmployeeSalary, ModelWrapper<EmployeeSalary> {

	public EmployeeSalaryWrapper(EmployeeSalary employeeSalary) {
		super(employeeSalary);
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
		attributes.put("salaryId", getSalaryId());
		attributes.put("grossSalaryCtcPm", getGrossSalaryCtcPm());
		attributes.put("grossSalaryCtcPa", getGrossSalaryCtcPa());
		attributes.put("employeeId", getEmployeeId());
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

		Long salaryId = (Long)attributes.get("salaryId");

		if (salaryId != null) {
			setSalaryId(salaryId);
		}

		Double grossSalaryCtcPm = (Double)attributes.get("grossSalaryCtcPm");

		if (grossSalaryCtcPm != null) {
			setGrossSalaryCtcPm(grossSalaryCtcPm);
		}

		Double grossSalaryCtcPa = (Double)attributes.get("grossSalaryCtcPa");

		if (grossSalaryCtcPa != null) {
			setGrossSalaryCtcPa(grossSalaryCtcPa);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		Boolean status = (Boolean)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	@Override
	public EmployeeSalary cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this employee salary.
	 *
	 * @return the company ID of this employee salary
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this employee salary.
	 *
	 * @return the create date of this employee salary
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this employee salary.
	 *
	 * @return the created by of this employee salary
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the employee ID of this employee salary.
	 *
	 * @return the employee ID of this employee salary
	 */
	@Override
	public long getEmployeeId() {
		return model.getEmployeeId();
	}

	/**
	 * Returns the gross salary ctc pa of this employee salary.
	 *
	 * @return the gross salary ctc pa of this employee salary
	 */
	@Override
	public double getGrossSalaryCtcPa() {
		return model.getGrossSalaryCtcPa();
	}

	/**
	 * Returns the gross salary ctc pm of this employee salary.
	 *
	 * @return the gross salary ctc pm of this employee salary
	 */
	@Override
	public double getGrossSalaryCtcPm() {
		return model.getGrossSalaryCtcPm();
	}

	/**
	 * Returns the group ID of this employee salary.
	 *
	 * @return the group ID of this employee salary
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified by of this employee salary.
	 *
	 * @return the modified by of this employee salary
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this employee salary.
	 *
	 * @return the modified date of this employee salary
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this employee salary.
	 *
	 * @return the primary key of this employee salary
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the salary ID of this employee salary.
	 *
	 * @return the salary ID of this employee salary
	 */
	@Override
	public long getSalaryId() {
		return model.getSalaryId();
	}

	/**
	 * Returns the status of this employee salary.
	 *
	 * @return the status of this employee salary
	 */
	@Override
	public boolean getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the uuid of this employee salary.
	 *
	 * @return the uuid of this employee salary
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this employee salary is status.
	 *
	 * @return <code>true</code> if this employee salary is status; <code>false</code> otherwise
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
	 * Sets the company ID of this employee salary.
	 *
	 * @param companyId the company ID of this employee salary
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this employee salary.
	 *
	 * @param createDate the create date of this employee salary
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this employee salary.
	 *
	 * @param createdBy the created by of this employee salary
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the employee ID of this employee salary.
	 *
	 * @param employeeId the employee ID of this employee salary
	 */
	@Override
	public void setEmployeeId(long employeeId) {
		model.setEmployeeId(employeeId);
	}

	/**
	 * Sets the gross salary ctc pa of this employee salary.
	 *
	 * @param grossSalaryCtcPa the gross salary ctc pa of this employee salary
	 */
	@Override
	public void setGrossSalaryCtcPa(double grossSalaryCtcPa) {
		model.setGrossSalaryCtcPa(grossSalaryCtcPa);
	}

	/**
	 * Sets the gross salary ctc pm of this employee salary.
	 *
	 * @param grossSalaryCtcPm the gross salary ctc pm of this employee salary
	 */
	@Override
	public void setGrossSalaryCtcPm(double grossSalaryCtcPm) {
		model.setGrossSalaryCtcPm(grossSalaryCtcPm);
	}

	/**
	 * Sets the group ID of this employee salary.
	 *
	 * @param groupId the group ID of this employee salary
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified by of this employee salary.
	 *
	 * @param modifiedBy the modified by of this employee salary
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this employee salary.
	 *
	 * @param modifiedDate the modified date of this employee salary
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this employee salary.
	 *
	 * @param primaryKey the primary key of this employee salary
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the salary ID of this employee salary.
	 *
	 * @param salaryId the salary ID of this employee salary
	 */
	@Override
	public void setSalaryId(long salaryId) {
		model.setSalaryId(salaryId);
	}

	/**
	 * Sets whether this employee salary is status.
	 *
	 * @param status the status of this employee salary
	 */
	@Override
	public void setStatus(boolean status) {
		model.setStatus(status);
	}

	/**
	 * Sets the uuid of this employee salary.
	 *
	 * @param uuid the uuid of this employee salary
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
	protected EmployeeSalaryWrapper wrap(EmployeeSalary employeeSalary) {
		return new EmployeeSalaryWrapper(employeeSalary);
	}

}