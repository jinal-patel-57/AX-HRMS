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
 * This class is a wrapper for {@link EmployeeDocument}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeDocument
 * @generated
 */
public class EmployeeDocumentWrapper
	extends BaseModelWrapper<EmployeeDocument>
	implements EmployeeDocument, ModelWrapper<EmployeeDocument> {

	public EmployeeDocumentWrapper(EmployeeDocument employeeDocument) {
		super(employeeDocument);
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
		attributes.put("documentId", getDocumentId());
		attributes.put("documentTypeId", getDocumentTypeId());
		attributes.put("documentNumber", getDocumentNumber());
		attributes.put("documentName", getDocumentName());
		attributes.put("documentMediaId", getDocumentMediaId());
		attributes.put("documentStatus", isDocumentStatus());
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

		Long documentId = (Long)attributes.get("documentId");

		if (documentId != null) {
			setDocumentId(documentId);
		}

		Long documentTypeId = (Long)attributes.get("documentTypeId");

		if (documentTypeId != null) {
			setDocumentTypeId(documentTypeId);
		}

		String documentNumber = (String)attributes.get("documentNumber");

		if (documentNumber != null) {
			setDocumentNumber(documentNumber);
		}

		String documentName = (String)attributes.get("documentName");

		if (documentName != null) {
			setDocumentName(documentName);
		}

		Long documentMediaId = (Long)attributes.get("documentMediaId");

		if (documentMediaId != null) {
			setDocumentMediaId(documentMediaId);
		}

		Boolean documentStatus = (Boolean)attributes.get("documentStatus");

		if (documentStatus != null) {
			setDocumentStatus(documentStatus);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}
	}

	@Override
	public EmployeeDocument cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this employee document.
	 *
	 * @return the company ID of this employee document
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this employee document.
	 *
	 * @return the create date of this employee document
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this employee document.
	 *
	 * @return the created by of this employee document
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the document ID of this employee document.
	 *
	 * @return the document ID of this employee document
	 */
	@Override
	public long getDocumentId() {
		return model.getDocumentId();
	}

	/**
	 * Returns the document media ID of this employee document.
	 *
	 * @return the document media ID of this employee document
	 */
	@Override
	public long getDocumentMediaId() {
		return model.getDocumentMediaId();
	}

	/**
	 * Returns the document name of this employee document.
	 *
	 * @return the document name of this employee document
	 */
	@Override
	public String getDocumentName() {
		return model.getDocumentName();
	}

	/**
	 * Returns the document number of this employee document.
	 *
	 * @return the document number of this employee document
	 */
	@Override
	public String getDocumentNumber() {
		return model.getDocumentNumber();
	}

	/**
	 * Returns the document status of this employee document.
	 *
	 * @return the document status of this employee document
	 */
	@Override
	public boolean getDocumentStatus() {
		return model.getDocumentStatus();
	}

	/**
	 * Returns the document type ID of this employee document.
	 *
	 * @return the document type ID of this employee document
	 */
	@Override
	public long getDocumentTypeId() {
		return model.getDocumentTypeId();
	}

	/**
	 * Returns the employee ID of this employee document.
	 *
	 * @return the employee ID of this employee document
	 */
	@Override
	public long getEmployeeId() {
		return model.getEmployeeId();
	}

	/**
	 * Returns the group ID of this employee document.
	 *
	 * @return the group ID of this employee document
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified by of this employee document.
	 *
	 * @return the modified by of this employee document
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this employee document.
	 *
	 * @return the modified date of this employee document
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this employee document.
	 *
	 * @return the primary key of this employee document
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the uuid of this employee document.
	 *
	 * @return the uuid of this employee document
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this employee document is document status.
	 *
	 * @return <code>true</code> if this employee document is document status; <code>false</code> otherwise
	 */
	@Override
	public boolean isDocumentStatus() {
		return model.isDocumentStatus();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this employee document.
	 *
	 * @param companyId the company ID of this employee document
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this employee document.
	 *
	 * @param createDate the create date of this employee document
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this employee document.
	 *
	 * @param createdBy the created by of this employee document
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the document ID of this employee document.
	 *
	 * @param documentId the document ID of this employee document
	 */
	@Override
	public void setDocumentId(long documentId) {
		model.setDocumentId(documentId);
	}

	/**
	 * Sets the document media ID of this employee document.
	 *
	 * @param documentMediaId the document media ID of this employee document
	 */
	@Override
	public void setDocumentMediaId(long documentMediaId) {
		model.setDocumentMediaId(documentMediaId);
	}

	/**
	 * Sets the document name of this employee document.
	 *
	 * @param documentName the document name of this employee document
	 */
	@Override
	public void setDocumentName(String documentName) {
		model.setDocumentName(documentName);
	}

	/**
	 * Sets the document number of this employee document.
	 *
	 * @param documentNumber the document number of this employee document
	 */
	@Override
	public void setDocumentNumber(String documentNumber) {
		model.setDocumentNumber(documentNumber);
	}

	/**
	 * Sets whether this employee document is document status.
	 *
	 * @param documentStatus the document status of this employee document
	 */
	@Override
	public void setDocumentStatus(boolean documentStatus) {
		model.setDocumentStatus(documentStatus);
	}

	/**
	 * Sets the document type ID of this employee document.
	 *
	 * @param documentTypeId the document type ID of this employee document
	 */
	@Override
	public void setDocumentTypeId(long documentTypeId) {
		model.setDocumentTypeId(documentTypeId);
	}

	/**
	 * Sets the employee ID of this employee document.
	 *
	 * @param employeeId the employee ID of this employee document
	 */
	@Override
	public void setEmployeeId(long employeeId) {
		model.setEmployeeId(employeeId);
	}

	/**
	 * Sets the group ID of this employee document.
	 *
	 * @param groupId the group ID of this employee document
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified by of this employee document.
	 *
	 * @param modifiedBy the modified by of this employee document
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this employee document.
	 *
	 * @param modifiedDate the modified date of this employee document
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this employee document.
	 *
	 * @param primaryKey the primary key of this employee document
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the uuid of this employee document.
	 *
	 * @param uuid the uuid of this employee document
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
	protected EmployeeDocumentWrapper wrap(EmployeeDocument employeeDocument) {
		return new EmployeeDocumentWrapper(employeeDocument);
	}

}