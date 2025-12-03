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
 * This class is a wrapper for {@link Nominee}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Nominee
 * @generated
 */
public class NomineeWrapper
	extends BaseModelWrapper<Nominee>
	implements ModelWrapper<Nominee>, Nominee {

	public NomineeWrapper(Nominee nominee) {
		super(nominee);
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
		attributes.put("nomineeId", getNomineeId());
		attributes.put("nomineeFirstName", getNomineeFirstName());
		attributes.put("nomineeLastName", getNomineeLastName());
		attributes.put("nomineeContact", getNomineeContact());
		attributes.put("nomineeAddress", getNomineeAddress());
		attributes.put("relationshipWithNominee", getRelationshipWithNominee());
		attributes.put("nomineeDob", getNomineeDob());

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

		Long nomineeId = (Long)attributes.get("nomineeId");

		if (nomineeId != null) {
			setNomineeId(nomineeId);
		}

		String nomineeFirstName = (String)attributes.get("nomineeFirstName");

		if (nomineeFirstName != null) {
			setNomineeFirstName(nomineeFirstName);
		}

		String nomineeLastName = (String)attributes.get("nomineeLastName");

		if (nomineeLastName != null) {
			setNomineeLastName(nomineeLastName);
		}

		String nomineeContact = (String)attributes.get("nomineeContact");

		if (nomineeContact != null) {
			setNomineeContact(nomineeContact);
		}

		Long nomineeAddress = (Long)attributes.get("nomineeAddress");

		if (nomineeAddress != null) {
			setNomineeAddress(nomineeAddress);
		}

		String relationshipWithNominee = (String)attributes.get(
			"relationshipWithNominee");

		if (relationshipWithNominee != null) {
			setRelationshipWithNominee(relationshipWithNominee);
		}

		Date nomineeDob = (Date)attributes.get("nomineeDob");

		if (nomineeDob != null) {
			setNomineeDob(nomineeDob);
		}
	}

	@Override
	public Nominee cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this nominee.
	 *
	 * @return the company ID of this nominee
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this nominee.
	 *
	 * @return the create date of this nominee
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this nominee.
	 *
	 * @return the created by of this nominee
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the group ID of this nominee.
	 *
	 * @return the group ID of this nominee
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified by of this nominee.
	 *
	 * @return the modified by of this nominee
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this nominee.
	 *
	 * @return the modified date of this nominee
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the nominee address of this nominee.
	 *
	 * @return the nominee address of this nominee
	 */
	@Override
	public long getNomineeAddress() {
		return model.getNomineeAddress();
	}

	/**
	 * Returns the nominee contact of this nominee.
	 *
	 * @return the nominee contact of this nominee
	 */
	@Override
	public String getNomineeContact() {
		return model.getNomineeContact();
	}

	/**
	 * Returns the nominee dob of this nominee.
	 *
	 * @return the nominee dob of this nominee
	 */
	@Override
	public Date getNomineeDob() {
		return model.getNomineeDob();
	}

	/**
	 * Returns the nominee first name of this nominee.
	 *
	 * @return the nominee first name of this nominee
	 */
	@Override
	public String getNomineeFirstName() {
		return model.getNomineeFirstName();
	}

	/**
	 * Returns the nominee ID of this nominee.
	 *
	 * @return the nominee ID of this nominee
	 */
	@Override
	public long getNomineeId() {
		return model.getNomineeId();
	}

	/**
	 * Returns the nominee last name of this nominee.
	 *
	 * @return the nominee last name of this nominee
	 */
	@Override
	public String getNomineeLastName() {
		return model.getNomineeLastName();
	}

	/**
	 * Returns the primary key of this nominee.
	 *
	 * @return the primary key of this nominee
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the relationship with nominee of this nominee.
	 *
	 * @return the relationship with nominee of this nominee
	 */
	@Override
	public String getRelationshipWithNominee() {
		return model.getRelationshipWithNominee();
	}

	/**
	 * Returns the uuid of this nominee.
	 *
	 * @return the uuid of this nominee
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
	 * Sets the company ID of this nominee.
	 *
	 * @param companyId the company ID of this nominee
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this nominee.
	 *
	 * @param createDate the create date of this nominee
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this nominee.
	 *
	 * @param createdBy the created by of this nominee
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the group ID of this nominee.
	 *
	 * @param groupId the group ID of this nominee
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified by of this nominee.
	 *
	 * @param modifiedBy the modified by of this nominee
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this nominee.
	 *
	 * @param modifiedDate the modified date of this nominee
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the nominee address of this nominee.
	 *
	 * @param nomineeAddress the nominee address of this nominee
	 */
	@Override
	public void setNomineeAddress(long nomineeAddress) {
		model.setNomineeAddress(nomineeAddress);
	}

	/**
	 * Sets the nominee contact of this nominee.
	 *
	 * @param nomineeContact the nominee contact of this nominee
	 */
	@Override
	public void setNomineeContact(String nomineeContact) {
		model.setNomineeContact(nomineeContact);
	}

	/**
	 * Sets the nominee dob of this nominee.
	 *
	 * @param nomineeDob the nominee dob of this nominee
	 */
	@Override
	public void setNomineeDob(Date nomineeDob) {
		model.setNomineeDob(nomineeDob);
	}

	/**
	 * Sets the nominee first name of this nominee.
	 *
	 * @param nomineeFirstName the nominee first name of this nominee
	 */
	@Override
	public void setNomineeFirstName(String nomineeFirstName) {
		model.setNomineeFirstName(nomineeFirstName);
	}

	/**
	 * Sets the nominee ID of this nominee.
	 *
	 * @param nomineeId the nominee ID of this nominee
	 */
	@Override
	public void setNomineeId(long nomineeId) {
		model.setNomineeId(nomineeId);
	}

	/**
	 * Sets the nominee last name of this nominee.
	 *
	 * @param nomineeLastName the nominee last name of this nominee
	 */
	@Override
	public void setNomineeLastName(String nomineeLastName) {
		model.setNomineeLastName(nomineeLastName);
	}

	/**
	 * Sets the primary key of this nominee.
	 *
	 * @param primaryKey the primary key of this nominee
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the relationship with nominee of this nominee.
	 *
	 * @param relationshipWithNominee the relationship with nominee of this nominee
	 */
	@Override
	public void setRelationshipWithNominee(String relationshipWithNominee) {
		model.setRelationshipWithNominee(relationshipWithNominee);
	}

	/**
	 * Sets the uuid of this nominee.
	 *
	 * @param uuid the uuid of this nominee
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
	protected NomineeWrapper wrap(Nominee nominee) {
		return new NomineeWrapper(nominee);
	}

}