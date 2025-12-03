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
 * This class is a wrapper for {@link EmployeeOffBoarding}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeOffBoarding
 * @generated
 */
public class EmployeeOffBoardingWrapper
	extends BaseModelWrapper<EmployeeOffBoarding>
	implements EmployeeOffBoarding, ModelWrapper<EmployeeOffBoarding> {

	public EmployeeOffBoardingWrapper(EmployeeOffBoarding employeeOffBoarding) {
		super(employeeOffBoarding);
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
		attributes.put("employeeOffBoardingId", getEmployeeOffBoardingId());
		attributes.put("kt", isKt());
		attributes.put("assets", isAssets());
		attributes.put("nda", isNda());
		attributes.put("mailAndBiometrics", isMailAndBiometrics());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("experienceLetterId", getExperienceLetterId());
		attributes.put("fullAndFinal", getFullAndFinal());
		attributes.put("relievingLetterId", getRelievingLetterId());
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

		Long employeeOffBoardingId = (Long)attributes.get(
			"employeeOffBoardingId");

		if (employeeOffBoardingId != null) {
			setEmployeeOffBoardingId(employeeOffBoardingId);
		}

		Boolean kt = (Boolean)attributes.get("kt");

		if (kt != null) {
			setKt(kt);
		}

		Boolean assets = (Boolean)attributes.get("assets");

		if (assets != null) {
			setAssets(assets);
		}

		Boolean nda = (Boolean)attributes.get("nda");

		if (nda != null) {
			setNda(nda);
		}

		Boolean mailAndBiometrics = (Boolean)attributes.get(
			"mailAndBiometrics");

		if (mailAndBiometrics != null) {
			setMailAndBiometrics(mailAndBiometrics);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		Long experienceLetterId = (Long)attributes.get("experienceLetterId");

		if (experienceLetterId != null) {
			setExperienceLetterId(experienceLetterId);
		}

		String fullAndFinal = (String)attributes.get("fullAndFinal");

		if (fullAndFinal != null) {
			setFullAndFinal(fullAndFinal);
		}

		Long relievingLetterId = (Long)attributes.get("relievingLetterId");

		if (relievingLetterId != null) {
			setRelievingLetterId(relievingLetterId);
		}

		Boolean status = (Boolean)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	@Override
	public EmployeeOffBoarding cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the assets of this employee off boarding.
	 *
	 * @return the assets of this employee off boarding
	 */
	@Override
	public boolean getAssets() {
		return model.getAssets();
	}

	/**
	 * Returns the company ID of this employee off boarding.
	 *
	 * @return the company ID of this employee off boarding
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this employee off boarding.
	 *
	 * @return the create date of this employee off boarding
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this employee off boarding.
	 *
	 * @return the created by of this employee off boarding
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the employee ID of this employee off boarding.
	 *
	 * @return the employee ID of this employee off boarding
	 */
	@Override
	public long getEmployeeId() {
		return model.getEmployeeId();
	}

	/**
	 * Returns the employee off boarding ID of this employee off boarding.
	 *
	 * @return the employee off boarding ID of this employee off boarding
	 */
	@Override
	public long getEmployeeOffBoardingId() {
		return model.getEmployeeOffBoardingId();
	}

	/**
	 * Returns the experience letter ID of this employee off boarding.
	 *
	 * @return the experience letter ID of this employee off boarding
	 */
	@Override
	public long getExperienceLetterId() {
		return model.getExperienceLetterId();
	}

	/**
	 * Returns the full and final of this employee off boarding.
	 *
	 * @return the full and final of this employee off boarding
	 */
	@Override
	public String getFullAndFinal() {
		return model.getFullAndFinal();
	}

	/**
	 * Returns the group ID of this employee off boarding.
	 *
	 * @return the group ID of this employee off boarding
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the kt of this employee off boarding.
	 *
	 * @return the kt of this employee off boarding
	 */
	@Override
	public boolean getKt() {
		return model.getKt();
	}

	/**
	 * Returns the mail and biometrics of this employee off boarding.
	 *
	 * @return the mail and biometrics of this employee off boarding
	 */
	@Override
	public boolean getMailAndBiometrics() {
		return model.getMailAndBiometrics();
	}

	/**
	 * Returns the modified by of this employee off boarding.
	 *
	 * @return the modified by of this employee off boarding
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this employee off boarding.
	 *
	 * @return the modified date of this employee off boarding
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the nda of this employee off boarding.
	 *
	 * @return the nda of this employee off boarding
	 */
	@Override
	public boolean getNda() {
		return model.getNda();
	}

	/**
	 * Returns the primary key of this employee off boarding.
	 *
	 * @return the primary key of this employee off boarding
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the relieving letter ID of this employee off boarding.
	 *
	 * @return the relieving letter ID of this employee off boarding
	 */
	@Override
	public long getRelievingLetterId() {
		return model.getRelievingLetterId();
	}

	/**
	 * Returns the status of this employee off boarding.
	 *
	 * @return the status of this employee off boarding
	 */
	@Override
	public boolean getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the uuid of this employee off boarding.
	 *
	 * @return the uuid of this employee off boarding
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this employee off boarding is assets.
	 *
	 * @return <code>true</code> if this employee off boarding is assets; <code>false</code> otherwise
	 */
	@Override
	public boolean isAssets() {
		return model.isAssets();
	}

	/**
	 * Returns <code>true</code> if this employee off boarding is kt.
	 *
	 * @return <code>true</code> if this employee off boarding is kt; <code>false</code> otherwise
	 */
	@Override
	public boolean isKt() {
		return model.isKt();
	}

	/**
	 * Returns <code>true</code> if this employee off boarding is mail and biometrics.
	 *
	 * @return <code>true</code> if this employee off boarding is mail and biometrics; <code>false</code> otherwise
	 */
	@Override
	public boolean isMailAndBiometrics() {
		return model.isMailAndBiometrics();
	}

	/**
	 * Returns <code>true</code> if this employee off boarding is nda.
	 *
	 * @return <code>true</code> if this employee off boarding is nda; <code>false</code> otherwise
	 */
	@Override
	public boolean isNda() {
		return model.isNda();
	}

	/**
	 * Returns <code>true</code> if this employee off boarding is status.
	 *
	 * @return <code>true</code> if this employee off boarding is status; <code>false</code> otherwise
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
	 * Sets whether this employee off boarding is assets.
	 *
	 * @param assets the assets of this employee off boarding
	 */
	@Override
	public void setAssets(boolean assets) {
		model.setAssets(assets);
	}

	/**
	 * Sets the company ID of this employee off boarding.
	 *
	 * @param companyId the company ID of this employee off boarding
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this employee off boarding.
	 *
	 * @param createDate the create date of this employee off boarding
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this employee off boarding.
	 *
	 * @param createdBy the created by of this employee off boarding
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the employee ID of this employee off boarding.
	 *
	 * @param employeeId the employee ID of this employee off boarding
	 */
	@Override
	public void setEmployeeId(long employeeId) {
		model.setEmployeeId(employeeId);
	}

	/**
	 * Sets the employee off boarding ID of this employee off boarding.
	 *
	 * @param employeeOffBoardingId the employee off boarding ID of this employee off boarding
	 */
	@Override
	public void setEmployeeOffBoardingId(long employeeOffBoardingId) {
		model.setEmployeeOffBoardingId(employeeOffBoardingId);
	}

	/**
	 * Sets the experience letter ID of this employee off boarding.
	 *
	 * @param experienceLetterId the experience letter ID of this employee off boarding
	 */
	@Override
	public void setExperienceLetterId(long experienceLetterId) {
		model.setExperienceLetterId(experienceLetterId);
	}

	/**
	 * Sets the full and final of this employee off boarding.
	 *
	 * @param fullAndFinal the full and final of this employee off boarding
	 */
	@Override
	public void setFullAndFinal(String fullAndFinal) {
		model.setFullAndFinal(fullAndFinal);
	}

	/**
	 * Sets the group ID of this employee off boarding.
	 *
	 * @param groupId the group ID of this employee off boarding
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets whether this employee off boarding is kt.
	 *
	 * @param kt the kt of this employee off boarding
	 */
	@Override
	public void setKt(boolean kt) {
		model.setKt(kt);
	}

	/**
	 * Sets whether this employee off boarding is mail and biometrics.
	 *
	 * @param mailAndBiometrics the mail and biometrics of this employee off boarding
	 */
	@Override
	public void setMailAndBiometrics(boolean mailAndBiometrics) {
		model.setMailAndBiometrics(mailAndBiometrics);
	}

	/**
	 * Sets the modified by of this employee off boarding.
	 *
	 * @param modifiedBy the modified by of this employee off boarding
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this employee off boarding.
	 *
	 * @param modifiedDate the modified date of this employee off boarding
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets whether this employee off boarding is nda.
	 *
	 * @param nda the nda of this employee off boarding
	 */
	@Override
	public void setNda(boolean nda) {
		model.setNda(nda);
	}

	/**
	 * Sets the primary key of this employee off boarding.
	 *
	 * @param primaryKey the primary key of this employee off boarding
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the relieving letter ID of this employee off boarding.
	 *
	 * @param relievingLetterId the relieving letter ID of this employee off boarding
	 */
	@Override
	public void setRelievingLetterId(long relievingLetterId) {
		model.setRelievingLetterId(relievingLetterId);
	}

	/**
	 * Sets whether this employee off boarding is status.
	 *
	 * @param status the status of this employee off boarding
	 */
	@Override
	public void setStatus(boolean status) {
		model.setStatus(status);
	}

	/**
	 * Sets the uuid of this employee off boarding.
	 *
	 * @param uuid the uuid of this employee off boarding
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
	protected EmployeeOffBoardingWrapper wrap(
		EmployeeOffBoarding employeeOffBoarding) {

		return new EmployeeOffBoardingWrapper(employeeOffBoarding);
	}

}