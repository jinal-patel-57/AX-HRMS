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
 * This class is a wrapper for {@link ExtendedProbationDetails}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ExtendedProbationDetails
 * @generated
 */
public class ExtendedProbationDetailsWrapper
	extends BaseModelWrapper<ExtendedProbationDetails>
	implements ExtendedProbationDetails,
			   ModelWrapper<ExtendedProbationDetails> {

	public ExtendedProbationDetailsWrapper(
		ExtendedProbationDetails extendedProbationDetails) {

		super(extendedProbationDetails);
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
			"extendedProbationDetailsId", getExtendedProbationDetailsId());
		attributes.put("probationDetailId", getProbationDetailId());
		attributes.put("extendDate", getExtendDate());
		attributes.put("evalutionReview", getEvalutionReview());
		attributes.put("extendedProbationPeriod", getExtendedProbationPeriod());
		attributes.put(
			"extendedProbationEndDate", getExtendedProbationEndDate());

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

		Long extendedProbationDetailsId = (Long)attributes.get(
			"extendedProbationDetailsId");

		if (extendedProbationDetailsId != null) {
			setExtendedProbationDetailsId(extendedProbationDetailsId);
		}

		Long probationDetailId = (Long)attributes.get("probationDetailId");

		if (probationDetailId != null) {
			setProbationDetailId(probationDetailId);
		}

		Date extendDate = (Date)attributes.get("extendDate");

		if (extendDate != null) {
			setExtendDate(extendDate);
		}

		String evalutionReview = (String)attributes.get("evalutionReview");

		if (evalutionReview != null) {
			setEvalutionReview(evalutionReview);
		}

		Integer extendedProbationPeriod = (Integer)attributes.get(
			"extendedProbationPeriod");

		if (extendedProbationPeriod != null) {
			setExtendedProbationPeriod(extendedProbationPeriod);
		}

		Date extendedProbationEndDate = (Date)attributes.get(
			"extendedProbationEndDate");

		if (extendedProbationEndDate != null) {
			setExtendedProbationEndDate(extendedProbationEndDate);
		}
	}

	@Override
	public ExtendedProbationDetails cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this extended probation details.
	 *
	 * @return the company ID of this extended probation details
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this extended probation details.
	 *
	 * @return the create date of this extended probation details
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this extended probation details.
	 *
	 * @return the created by of this extended probation details
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the evalution review of this extended probation details.
	 *
	 * @return the evalution review of this extended probation details
	 */
	@Override
	public String getEvalutionReview() {
		return model.getEvalutionReview();
	}

	/**
	 * Returns the extend date of this extended probation details.
	 *
	 * @return the extend date of this extended probation details
	 */
	@Override
	public Date getExtendDate() {
		return model.getExtendDate();
	}

	/**
	 * Returns the extended probation details ID of this extended probation details.
	 *
	 * @return the extended probation details ID of this extended probation details
	 */
	@Override
	public long getExtendedProbationDetailsId() {
		return model.getExtendedProbationDetailsId();
	}

	/**
	 * Returns the extended probation end date of this extended probation details.
	 *
	 * @return the extended probation end date of this extended probation details
	 */
	@Override
	public Date getExtendedProbationEndDate() {
		return model.getExtendedProbationEndDate();
	}

	/**
	 * Returns the extended probation period of this extended probation details.
	 *
	 * @return the extended probation period of this extended probation details
	 */
	@Override
	public int getExtendedProbationPeriod() {
		return model.getExtendedProbationPeriod();
	}

	/**
	 * Returns the group ID of this extended probation details.
	 *
	 * @return the group ID of this extended probation details
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified by of this extended probation details.
	 *
	 * @return the modified by of this extended probation details
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this extended probation details.
	 *
	 * @return the modified date of this extended probation details
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this extended probation details.
	 *
	 * @return the primary key of this extended probation details
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the probation detail ID of this extended probation details.
	 *
	 * @return the probation detail ID of this extended probation details
	 */
	@Override
	public long getProbationDetailId() {
		return model.getProbationDetailId();
	}

	/**
	 * Returns the uuid of this extended probation details.
	 *
	 * @return the uuid of this extended probation details
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
	 * Sets the company ID of this extended probation details.
	 *
	 * @param companyId the company ID of this extended probation details
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this extended probation details.
	 *
	 * @param createDate the create date of this extended probation details
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this extended probation details.
	 *
	 * @param createdBy the created by of this extended probation details
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the evalution review of this extended probation details.
	 *
	 * @param evalutionReview the evalution review of this extended probation details
	 */
	@Override
	public void setEvalutionReview(String evalutionReview) {
		model.setEvalutionReview(evalutionReview);
	}

	/**
	 * Sets the extend date of this extended probation details.
	 *
	 * @param extendDate the extend date of this extended probation details
	 */
	@Override
	public void setExtendDate(Date extendDate) {
		model.setExtendDate(extendDate);
	}

	/**
	 * Sets the extended probation details ID of this extended probation details.
	 *
	 * @param extendedProbationDetailsId the extended probation details ID of this extended probation details
	 */
	@Override
	public void setExtendedProbationDetailsId(long extendedProbationDetailsId) {
		model.setExtendedProbationDetailsId(extendedProbationDetailsId);
	}

	/**
	 * Sets the extended probation end date of this extended probation details.
	 *
	 * @param extendedProbationEndDate the extended probation end date of this extended probation details
	 */
	@Override
	public void setExtendedProbationEndDate(Date extendedProbationEndDate) {
		model.setExtendedProbationEndDate(extendedProbationEndDate);
	}

	/**
	 * Sets the extended probation period of this extended probation details.
	 *
	 * @param extendedProbationPeriod the extended probation period of this extended probation details
	 */
	@Override
	public void setExtendedProbationPeriod(int extendedProbationPeriod) {
		model.setExtendedProbationPeriod(extendedProbationPeriod);
	}

	/**
	 * Sets the group ID of this extended probation details.
	 *
	 * @param groupId the group ID of this extended probation details
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified by of this extended probation details.
	 *
	 * @param modifiedBy the modified by of this extended probation details
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this extended probation details.
	 *
	 * @param modifiedDate the modified date of this extended probation details
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this extended probation details.
	 *
	 * @param primaryKey the primary key of this extended probation details
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the probation detail ID of this extended probation details.
	 *
	 * @param probationDetailId the probation detail ID of this extended probation details
	 */
	@Override
	public void setProbationDetailId(long probationDetailId) {
		model.setProbationDetailId(probationDetailId);
	}

	/**
	 * Sets the uuid of this extended probation details.
	 *
	 * @param uuid the uuid of this extended probation details
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
	protected ExtendedProbationDetailsWrapper wrap(
		ExtendedProbationDetails extendedProbationDetails) {

		return new ExtendedProbationDetailsWrapper(extendedProbationDetails);
	}

}