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
 * This class is a wrapper for {@link LeaveRequest}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LeaveRequest
 * @generated
 */
public class LeaveRequestWrapper
	extends BaseModelWrapper<LeaveRequest>
	implements LeaveRequest, ModelWrapper<LeaveRequest> {

	public LeaveRequestWrapper(LeaveRequest leaveRequest) {
		super(leaveRequest);
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
		attributes.put("leaveRequestId", getLeaveRequestId());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("leaveTypeMasterId", getLeaveTypeMasterId());
		attributes.put("startDateTime", getStartDateTime());
		attributes.put("endDateTime", getEndDateTime());
		attributes.put("reason", getReason());
		attributes.put(
			"leaveCompensatoryStatusMasterId",
			getLeaveCompensatoryStatusMasterId());
		attributes.put("hrApprovalId", getHrApprovalId());
		attributes.put("managerApprovalId", getManagerApprovalId());
		attributes.put("dateOfRequest", getDateOfRequest());

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

		Long leaveRequestId = (Long)attributes.get("leaveRequestId");

		if (leaveRequestId != null) {
			setLeaveRequestId(leaveRequestId);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		Long leaveTypeMasterId = (Long)attributes.get("leaveTypeMasterId");

		if (leaveTypeMasterId != null) {
			setLeaveTypeMasterId(leaveTypeMasterId);
		}

		Date startDateTime = (Date)attributes.get("startDateTime");

		if (startDateTime != null) {
			setStartDateTime(startDateTime);
		}

		Date endDateTime = (Date)attributes.get("endDateTime");

		if (endDateTime != null) {
			setEndDateTime(endDateTime);
		}

		String reason = (String)attributes.get("reason");

		if (reason != null) {
			setReason(reason);
		}

		Long leaveCompensatoryStatusMasterId = (Long)attributes.get(
			"leaveCompensatoryStatusMasterId");

		if (leaveCompensatoryStatusMasterId != null) {
			setLeaveCompensatoryStatusMasterId(leaveCompensatoryStatusMasterId);
		}

		Long hrApprovalId = (Long)attributes.get("hrApprovalId");

		if (hrApprovalId != null) {
			setHrApprovalId(hrApprovalId);
		}

		Long managerApprovalId = (Long)attributes.get("managerApprovalId");

		if (managerApprovalId != null) {
			setManagerApprovalId(managerApprovalId);
		}

		Date dateOfRequest = (Date)attributes.get("dateOfRequest");

		if (dateOfRequest != null) {
			setDateOfRequest(dateOfRequest);
		}
	}

	@Override
	public LeaveRequest cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this leave request.
	 *
	 * @return the company ID of this leave request
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this leave request.
	 *
	 * @return the create date of this leave request
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this leave request.
	 *
	 * @return the created by of this leave request
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the date of request of this leave request.
	 *
	 * @return the date of request of this leave request
	 */
	@Override
	public Date getDateOfRequest() {
		return model.getDateOfRequest();
	}

	/**
	 * Returns the employee ID of this leave request.
	 *
	 * @return the employee ID of this leave request
	 */
	@Override
	public long getEmployeeId() {
		return model.getEmployeeId();
	}

	/**
	 * Returns the end date time of this leave request.
	 *
	 * @return the end date time of this leave request
	 */
	@Override
	public Date getEndDateTime() {
		return model.getEndDateTime();
	}

	/**
	 * Returns the group ID of this leave request.
	 *
	 * @return the group ID of this leave request
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the hr approval ID of this leave request.
	 *
	 * @return the hr approval ID of this leave request
	 */
	@Override
	public long getHrApprovalId() {
		return model.getHrApprovalId();
	}

	/**
	 * Returns the leave compensatory status master ID of this leave request.
	 *
	 * @return the leave compensatory status master ID of this leave request
	 */
	@Override
	public long getLeaveCompensatoryStatusMasterId() {
		return model.getLeaveCompensatoryStatusMasterId();
	}

	/**
	 * Returns the leave request ID of this leave request.
	 *
	 * @return the leave request ID of this leave request
	 */
	@Override
	public long getLeaveRequestId() {
		return model.getLeaveRequestId();
	}

	/**
	 * Returns the leave type master ID of this leave request.
	 *
	 * @return the leave type master ID of this leave request
	 */
	@Override
	public long getLeaveTypeMasterId() {
		return model.getLeaveTypeMasterId();
	}

	/**
	 * Returns the manager approval ID of this leave request.
	 *
	 * @return the manager approval ID of this leave request
	 */
	@Override
	public long getManagerApprovalId() {
		return model.getManagerApprovalId();
	}

	/**
	 * Returns the modified by of this leave request.
	 *
	 * @return the modified by of this leave request
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this leave request.
	 *
	 * @return the modified date of this leave request
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this leave request.
	 *
	 * @return the primary key of this leave request
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the reason of this leave request.
	 *
	 * @return the reason of this leave request
	 */
	@Override
	public String getReason() {
		return model.getReason();
	}

	/**
	 * Returns the start date time of this leave request.
	 *
	 * @return the start date time of this leave request
	 */
	@Override
	public Date getStartDateTime() {
		return model.getStartDateTime();
	}

	/**
	 * Returns the uuid of this leave request.
	 *
	 * @return the uuid of this leave request
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
	 * Sets the company ID of this leave request.
	 *
	 * @param companyId the company ID of this leave request
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this leave request.
	 *
	 * @param createDate the create date of this leave request
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this leave request.
	 *
	 * @param createdBy the created by of this leave request
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the date of request of this leave request.
	 *
	 * @param dateOfRequest the date of request of this leave request
	 */
	@Override
	public void setDateOfRequest(Date dateOfRequest) {
		model.setDateOfRequest(dateOfRequest);
	}

	/**
	 * Sets the employee ID of this leave request.
	 *
	 * @param employeeId the employee ID of this leave request
	 */
	@Override
	public void setEmployeeId(long employeeId) {
		model.setEmployeeId(employeeId);
	}

	/**
	 * Sets the end date time of this leave request.
	 *
	 * @param endDateTime the end date time of this leave request
	 */
	@Override
	public void setEndDateTime(Date endDateTime) {
		model.setEndDateTime(endDateTime);
	}

	/**
	 * Sets the group ID of this leave request.
	 *
	 * @param groupId the group ID of this leave request
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the hr approval ID of this leave request.
	 *
	 * @param hrApprovalId the hr approval ID of this leave request
	 */
	@Override
	public void setHrApprovalId(long hrApprovalId) {
		model.setHrApprovalId(hrApprovalId);
	}

	/**
	 * Sets the leave compensatory status master ID of this leave request.
	 *
	 * @param leaveCompensatoryStatusMasterId the leave compensatory status master ID of this leave request
	 */
	@Override
	public void setLeaveCompensatoryStatusMasterId(
		long leaveCompensatoryStatusMasterId) {

		model.setLeaveCompensatoryStatusMasterId(
			leaveCompensatoryStatusMasterId);
	}

	/**
	 * Sets the leave request ID of this leave request.
	 *
	 * @param leaveRequestId the leave request ID of this leave request
	 */
	@Override
	public void setLeaveRequestId(long leaveRequestId) {
		model.setLeaveRequestId(leaveRequestId);
	}

	/**
	 * Sets the leave type master ID of this leave request.
	 *
	 * @param leaveTypeMasterId the leave type master ID of this leave request
	 */
	@Override
	public void setLeaveTypeMasterId(long leaveTypeMasterId) {
		model.setLeaveTypeMasterId(leaveTypeMasterId);
	}

	/**
	 * Sets the manager approval ID of this leave request.
	 *
	 * @param managerApprovalId the manager approval ID of this leave request
	 */
	@Override
	public void setManagerApprovalId(long managerApprovalId) {
		model.setManagerApprovalId(managerApprovalId);
	}

	/**
	 * Sets the modified by of this leave request.
	 *
	 * @param modifiedBy the modified by of this leave request
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this leave request.
	 *
	 * @param modifiedDate the modified date of this leave request
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this leave request.
	 *
	 * @param primaryKey the primary key of this leave request
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the reason of this leave request.
	 *
	 * @param reason the reason of this leave request
	 */
	@Override
	public void setReason(String reason) {
		model.setReason(reason);
	}

	/**
	 * Sets the start date time of this leave request.
	 *
	 * @param startDateTime the start date time of this leave request
	 */
	@Override
	public void setStartDateTime(Date startDateTime) {
		model.setStartDateTime(startDateTime);
	}

	/**
	 * Sets the uuid of this leave request.
	 *
	 * @param uuid the uuid of this leave request
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
	protected LeaveRequestWrapper wrap(LeaveRequest leaveRequest) {
		return new LeaveRequestWrapper(leaveRequest);
	}

}