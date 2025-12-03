/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.master.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link DocumentTypeMaster}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DocumentTypeMaster
 * @generated
 */
public class DocumentTypeMasterWrapper
	extends BaseModelWrapper<DocumentTypeMaster>
	implements DocumentTypeMaster, ModelWrapper<DocumentTypeMaster> {

	public DocumentTypeMasterWrapper(DocumentTypeMaster documentTypeMaster) {
		super(documentTypeMaster);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("documentTypeMasterId", getDocumentTypeMasterId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("groupId", getGroupId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("documentTypeName", getDocumentTypeName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long documentTypeMasterId = (Long)attributes.get(
			"documentTypeMasterId");

		if (documentTypeMasterId != null) {
			setDocumentTypeMasterId(documentTypeMasterId);
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

		String documentTypeName = (String)attributes.get("documentTypeName");

		if (documentTypeName != null) {
			setDocumentTypeName(documentTypeName);
		}
	}

	@Override
	public DocumentTypeMaster cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this document type master.
	 *
	 * @return the company ID of this document type master
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this document type master.
	 *
	 * @return the create date of this document type master
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this document type master.
	 *
	 * @return the created by of this document type master
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the document type master ID of this document type master.
	 *
	 * @return the document type master ID of this document type master
	 */
	@Override
	public long getDocumentTypeMasterId() {
		return model.getDocumentTypeMasterId();
	}

	/**
	 * Returns the document type name of this document type master.
	 *
	 * @return the document type name of this document type master
	 */
	@Override
	public String getDocumentTypeName() {
		return model.getDocumentTypeName();
	}

	/**
	 * Returns the group ID of this document type master.
	 *
	 * @return the group ID of this document type master
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified by of this document type master.
	 *
	 * @return the modified by of this document type master
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this document type master.
	 *
	 * @return the modified date of this document type master
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this document type master.
	 *
	 * @return the primary key of this document type master
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this document type master.
	 *
	 * @param companyId the company ID of this document type master
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this document type master.
	 *
	 * @param createDate the create date of this document type master
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this document type master.
	 *
	 * @param createdBy the created by of this document type master
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the document type master ID of this document type master.
	 *
	 * @param documentTypeMasterId the document type master ID of this document type master
	 */
	@Override
	public void setDocumentTypeMasterId(long documentTypeMasterId) {
		model.setDocumentTypeMasterId(documentTypeMasterId);
	}

	/**
	 * Sets the document type name of this document type master.
	 *
	 * @param documentTypeName the document type name of this document type master
	 */
	@Override
	public void setDocumentTypeName(String documentTypeName) {
		model.setDocumentTypeName(documentTypeName);
	}

	/**
	 * Sets the group ID of this document type master.
	 *
	 * @param groupId the group ID of this document type master
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified by of this document type master.
	 *
	 * @param modifiedBy the modified by of this document type master
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this document type master.
	 *
	 * @param modifiedDate the modified date of this document type master
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this document type master.
	 *
	 * @param primaryKey the primary key of this document type master
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected DocumentTypeMasterWrapper wrap(
		DocumentTypeMaster documentTypeMaster) {

		return new DocumentTypeMasterWrapper(documentTypeMaster);
	}

}