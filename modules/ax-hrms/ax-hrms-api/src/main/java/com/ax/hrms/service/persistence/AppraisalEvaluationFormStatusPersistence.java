/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence;

import com.ax.hrms.exception.NoSuchAppraisalEvaluationFormStatusException;
import com.ax.hrms.model.AppraisalEvaluationFormStatus;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the appraisal evaluation form status service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AppraisalEvaluationFormStatusUtil
 * @generated
 */
@ProviderType
public interface AppraisalEvaluationFormStatusPersistence
	extends BasePersistence<AppraisalEvaluationFormStatus> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AppraisalEvaluationFormStatusUtil} to access the appraisal evaluation form status persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the appraisal evaluation form statuses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching appraisal evaluation form statuses
	 */
	public java.util.List<AppraisalEvaluationFormStatus> findByUuid(
		String uuid);

	/**
	 * Returns a range of all the appraisal evaluation form statuses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalEvaluationFormStatusModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of appraisal evaluation form statuses
	 * @param end the upper bound of the range of appraisal evaluation form statuses (not inclusive)
	 * @return the range of matching appraisal evaluation form statuses
	 */
	public java.util.List<AppraisalEvaluationFormStatus> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the appraisal evaluation form statuses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalEvaluationFormStatusModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of appraisal evaluation form statuses
	 * @param end the upper bound of the range of appraisal evaluation form statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching appraisal evaluation form statuses
	 */
	public java.util.List<AppraisalEvaluationFormStatus> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<AppraisalEvaluationFormStatus> orderByComparator);

	/**
	 * Returns an ordered range of all the appraisal evaluation form statuses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalEvaluationFormStatusModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of appraisal evaluation form statuses
	 * @param end the upper bound of the range of appraisal evaluation form statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching appraisal evaluation form statuses
	 */
	public java.util.List<AppraisalEvaluationFormStatus> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<AppraisalEvaluationFormStatus> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first appraisal evaluation form status in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appraisal evaluation form status
	 * @throws NoSuchAppraisalEvaluationFormStatusException if a matching appraisal evaluation form status could not be found
	 */
	public AppraisalEvaluationFormStatus findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<AppraisalEvaluationFormStatus> orderByComparator)
		throws NoSuchAppraisalEvaluationFormStatusException;

	/**
	 * Returns the first appraisal evaluation form status in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appraisal evaluation form status, or <code>null</code> if a matching appraisal evaluation form status could not be found
	 */
	public AppraisalEvaluationFormStatus fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator
			<AppraisalEvaluationFormStatus> orderByComparator);

	/**
	 * Returns the last appraisal evaluation form status in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appraisal evaluation form status
	 * @throws NoSuchAppraisalEvaluationFormStatusException if a matching appraisal evaluation form status could not be found
	 */
	public AppraisalEvaluationFormStatus findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<AppraisalEvaluationFormStatus> orderByComparator)
		throws NoSuchAppraisalEvaluationFormStatusException;

	/**
	 * Returns the last appraisal evaluation form status in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appraisal evaluation form status, or <code>null</code> if a matching appraisal evaluation form status could not be found
	 */
	public AppraisalEvaluationFormStatus fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator
			<AppraisalEvaluationFormStatus> orderByComparator);

	/**
	 * Returns the appraisal evaluation form statuses before and after the current appraisal evaluation form status in the ordered set where uuid = &#63;.
	 *
	 * @param appraisalEvaluationFormStatusId the primary key of the current appraisal evaluation form status
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next appraisal evaluation form status
	 * @throws NoSuchAppraisalEvaluationFormStatusException if a appraisal evaluation form status with the primary key could not be found
	 */
	public AppraisalEvaluationFormStatus[] findByUuid_PrevAndNext(
			long appraisalEvaluationFormStatusId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<AppraisalEvaluationFormStatus> orderByComparator)
		throws NoSuchAppraisalEvaluationFormStatusException;

	/**
	 * Removes all the appraisal evaluation form statuses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of appraisal evaluation form statuses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching appraisal evaluation form statuses
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the appraisal evaluation form status where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchAppraisalEvaluationFormStatusException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching appraisal evaluation form status
	 * @throws NoSuchAppraisalEvaluationFormStatusException if a matching appraisal evaluation form status could not be found
	 */
	public AppraisalEvaluationFormStatus findByUUID_G(String uuid, long groupId)
		throws NoSuchAppraisalEvaluationFormStatusException;

	/**
	 * Returns the appraisal evaluation form status where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching appraisal evaluation form status, or <code>null</code> if a matching appraisal evaluation form status could not be found
	 */
	public AppraisalEvaluationFormStatus fetchByUUID_G(
		String uuid, long groupId);

	/**
	 * Returns the appraisal evaluation form status where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching appraisal evaluation form status, or <code>null</code> if a matching appraisal evaluation form status could not be found
	 */
	public AppraisalEvaluationFormStatus fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the appraisal evaluation form status where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the appraisal evaluation form status that was removed
	 */
	public AppraisalEvaluationFormStatus removeByUUID_G(
			String uuid, long groupId)
		throws NoSuchAppraisalEvaluationFormStatusException;

	/**
	 * Returns the number of appraisal evaluation form statuses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching appraisal evaluation form statuses
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the appraisal evaluation form statuses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching appraisal evaluation form statuses
	 */
	public java.util.List<AppraisalEvaluationFormStatus> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the appraisal evaluation form statuses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalEvaluationFormStatusModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of appraisal evaluation form statuses
	 * @param end the upper bound of the range of appraisal evaluation form statuses (not inclusive)
	 * @return the range of matching appraisal evaluation form statuses
	 */
	public java.util.List<AppraisalEvaluationFormStatus> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the appraisal evaluation form statuses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalEvaluationFormStatusModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of appraisal evaluation form statuses
	 * @param end the upper bound of the range of appraisal evaluation form statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching appraisal evaluation form statuses
	 */
	public java.util.List<AppraisalEvaluationFormStatus> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<AppraisalEvaluationFormStatus> orderByComparator);

	/**
	 * Returns an ordered range of all the appraisal evaluation form statuses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalEvaluationFormStatusModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of appraisal evaluation form statuses
	 * @param end the upper bound of the range of appraisal evaluation form statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching appraisal evaluation form statuses
	 */
	public java.util.List<AppraisalEvaluationFormStatus> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<AppraisalEvaluationFormStatus> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first appraisal evaluation form status in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appraisal evaluation form status
	 * @throws NoSuchAppraisalEvaluationFormStatusException if a matching appraisal evaluation form status could not be found
	 */
	public AppraisalEvaluationFormStatus findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<AppraisalEvaluationFormStatus> orderByComparator)
		throws NoSuchAppraisalEvaluationFormStatusException;

	/**
	 * Returns the first appraisal evaluation form status in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appraisal evaluation form status, or <code>null</code> if a matching appraisal evaluation form status could not be found
	 */
	public AppraisalEvaluationFormStatus fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator
			<AppraisalEvaluationFormStatus> orderByComparator);

	/**
	 * Returns the last appraisal evaluation form status in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appraisal evaluation form status
	 * @throws NoSuchAppraisalEvaluationFormStatusException if a matching appraisal evaluation form status could not be found
	 */
	public AppraisalEvaluationFormStatus findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<AppraisalEvaluationFormStatus> orderByComparator)
		throws NoSuchAppraisalEvaluationFormStatusException;

	/**
	 * Returns the last appraisal evaluation form status in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appraisal evaluation form status, or <code>null</code> if a matching appraisal evaluation form status could not be found
	 */
	public AppraisalEvaluationFormStatus fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator
			<AppraisalEvaluationFormStatus> orderByComparator);

	/**
	 * Returns the appraisal evaluation form statuses before and after the current appraisal evaluation form status in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param appraisalEvaluationFormStatusId the primary key of the current appraisal evaluation form status
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next appraisal evaluation form status
	 * @throws NoSuchAppraisalEvaluationFormStatusException if a appraisal evaluation form status with the primary key could not be found
	 */
	public AppraisalEvaluationFormStatus[] findByUuid_C_PrevAndNext(
			long appraisalEvaluationFormStatusId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<AppraisalEvaluationFormStatus> orderByComparator)
		throws NoSuchAppraisalEvaluationFormStatusException;

	/**
	 * Removes all the appraisal evaluation form statuses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of appraisal evaluation form statuses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching appraisal evaluation form statuses
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the appraisal evaluation form statuses where appraisalProcessId = &#63; and appraisalFormTemplateId = &#63;.
	 *
	 * @param appraisalProcessId the appraisal process ID
	 * @param appraisalFormTemplateId the appraisal form template ID
	 * @return the matching appraisal evaluation form statuses
	 */
	public java.util.List<AppraisalEvaluationFormStatus>
		findByAppraisalProcessIdAndAppraisalFormTemplateId(
			long appraisalProcessId, long appraisalFormTemplateId);

	/**
	 * Returns a range of all the appraisal evaluation form statuses where appraisalProcessId = &#63; and appraisalFormTemplateId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalEvaluationFormStatusModelImpl</code>.
	 * </p>
	 *
	 * @param appraisalProcessId the appraisal process ID
	 * @param appraisalFormTemplateId the appraisal form template ID
	 * @param start the lower bound of the range of appraisal evaluation form statuses
	 * @param end the upper bound of the range of appraisal evaluation form statuses (not inclusive)
	 * @return the range of matching appraisal evaluation form statuses
	 */
	public java.util.List<AppraisalEvaluationFormStatus>
		findByAppraisalProcessIdAndAppraisalFormTemplateId(
			long appraisalProcessId, long appraisalFormTemplateId, int start,
			int end);

	/**
	 * Returns an ordered range of all the appraisal evaluation form statuses where appraisalProcessId = &#63; and appraisalFormTemplateId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalEvaluationFormStatusModelImpl</code>.
	 * </p>
	 *
	 * @param appraisalProcessId the appraisal process ID
	 * @param appraisalFormTemplateId the appraisal form template ID
	 * @param start the lower bound of the range of appraisal evaluation form statuses
	 * @param end the upper bound of the range of appraisal evaluation form statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching appraisal evaluation form statuses
	 */
	public java.util.List<AppraisalEvaluationFormStatus>
		findByAppraisalProcessIdAndAppraisalFormTemplateId(
			long appraisalProcessId, long appraisalFormTemplateId, int start,
			int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<AppraisalEvaluationFormStatus> orderByComparator);

	/**
	 * Returns an ordered range of all the appraisal evaluation form statuses where appraisalProcessId = &#63; and appraisalFormTemplateId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalEvaluationFormStatusModelImpl</code>.
	 * </p>
	 *
	 * @param appraisalProcessId the appraisal process ID
	 * @param appraisalFormTemplateId the appraisal form template ID
	 * @param start the lower bound of the range of appraisal evaluation form statuses
	 * @param end the upper bound of the range of appraisal evaluation form statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching appraisal evaluation form statuses
	 */
	public java.util.List<AppraisalEvaluationFormStatus>
		findByAppraisalProcessIdAndAppraisalFormTemplateId(
			long appraisalProcessId, long appraisalFormTemplateId, int start,
			int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<AppraisalEvaluationFormStatus> orderByComparator,
			boolean useFinderCache);

	/**
	 * Returns the first appraisal evaluation form status in the ordered set where appraisalProcessId = &#63; and appraisalFormTemplateId = &#63;.
	 *
	 * @param appraisalProcessId the appraisal process ID
	 * @param appraisalFormTemplateId the appraisal form template ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appraisal evaluation form status
	 * @throws NoSuchAppraisalEvaluationFormStatusException if a matching appraisal evaluation form status could not be found
	 */
	public AppraisalEvaluationFormStatus
			findByAppraisalProcessIdAndAppraisalFormTemplateId_First(
				long appraisalProcessId, long appraisalFormTemplateId,
				com.liferay.portal.kernel.util.OrderByComparator
					<AppraisalEvaluationFormStatus> orderByComparator)
		throws NoSuchAppraisalEvaluationFormStatusException;

	/**
	 * Returns the first appraisal evaluation form status in the ordered set where appraisalProcessId = &#63; and appraisalFormTemplateId = &#63;.
	 *
	 * @param appraisalProcessId the appraisal process ID
	 * @param appraisalFormTemplateId the appraisal form template ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appraisal evaluation form status, or <code>null</code> if a matching appraisal evaluation form status could not be found
	 */
	public AppraisalEvaluationFormStatus
		fetchByAppraisalProcessIdAndAppraisalFormTemplateId_First(
			long appraisalProcessId, long appraisalFormTemplateId,
			com.liferay.portal.kernel.util.OrderByComparator
				<AppraisalEvaluationFormStatus> orderByComparator);

	/**
	 * Returns the last appraisal evaluation form status in the ordered set where appraisalProcessId = &#63; and appraisalFormTemplateId = &#63;.
	 *
	 * @param appraisalProcessId the appraisal process ID
	 * @param appraisalFormTemplateId the appraisal form template ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appraisal evaluation form status
	 * @throws NoSuchAppraisalEvaluationFormStatusException if a matching appraisal evaluation form status could not be found
	 */
	public AppraisalEvaluationFormStatus
			findByAppraisalProcessIdAndAppraisalFormTemplateId_Last(
				long appraisalProcessId, long appraisalFormTemplateId,
				com.liferay.portal.kernel.util.OrderByComparator
					<AppraisalEvaluationFormStatus> orderByComparator)
		throws NoSuchAppraisalEvaluationFormStatusException;

	/**
	 * Returns the last appraisal evaluation form status in the ordered set where appraisalProcessId = &#63; and appraisalFormTemplateId = &#63;.
	 *
	 * @param appraisalProcessId the appraisal process ID
	 * @param appraisalFormTemplateId the appraisal form template ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appraisal evaluation form status, or <code>null</code> if a matching appraisal evaluation form status could not be found
	 */
	public AppraisalEvaluationFormStatus
		fetchByAppraisalProcessIdAndAppraisalFormTemplateId_Last(
			long appraisalProcessId, long appraisalFormTemplateId,
			com.liferay.portal.kernel.util.OrderByComparator
				<AppraisalEvaluationFormStatus> orderByComparator);

	/**
	 * Returns the appraisal evaluation form statuses before and after the current appraisal evaluation form status in the ordered set where appraisalProcessId = &#63; and appraisalFormTemplateId = &#63;.
	 *
	 * @param appraisalEvaluationFormStatusId the primary key of the current appraisal evaluation form status
	 * @param appraisalProcessId the appraisal process ID
	 * @param appraisalFormTemplateId the appraisal form template ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next appraisal evaluation form status
	 * @throws NoSuchAppraisalEvaluationFormStatusException if a appraisal evaluation form status with the primary key could not be found
	 */
	public AppraisalEvaluationFormStatus[]
			findByAppraisalProcessIdAndAppraisalFormTemplateId_PrevAndNext(
				long appraisalEvaluationFormStatusId, long appraisalProcessId,
				long appraisalFormTemplateId,
				com.liferay.portal.kernel.util.OrderByComparator
					<AppraisalEvaluationFormStatus> orderByComparator)
		throws NoSuchAppraisalEvaluationFormStatusException;

	/**
	 * Removes all the appraisal evaluation form statuses where appraisalProcessId = &#63; and appraisalFormTemplateId = &#63; from the database.
	 *
	 * @param appraisalProcessId the appraisal process ID
	 * @param appraisalFormTemplateId the appraisal form template ID
	 */
	public void removeByAppraisalProcessIdAndAppraisalFormTemplateId(
		long appraisalProcessId, long appraisalFormTemplateId);

	/**
	 * Returns the number of appraisal evaluation form statuses where appraisalProcessId = &#63; and appraisalFormTemplateId = &#63;.
	 *
	 * @param appraisalProcessId the appraisal process ID
	 * @param appraisalFormTemplateId the appraisal form template ID
	 * @return the number of matching appraisal evaluation form statuses
	 */
	public int countByAppraisalProcessIdAndAppraisalFormTemplateId(
		long appraisalProcessId, long appraisalFormTemplateId);

	/**
	 * Returns all the appraisal evaluation form statuses where submissionDate = &#63; and status = &#63;.
	 *
	 * @param submissionDate the submission date
	 * @param status the status
	 * @return the matching appraisal evaluation form statuses
	 */
	public java.util.List<AppraisalEvaluationFormStatus>
		findByStatusAndSubmissionDate(Date submissionDate, boolean status);

	/**
	 * Returns a range of all the appraisal evaluation form statuses where submissionDate = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalEvaluationFormStatusModelImpl</code>.
	 * </p>
	 *
	 * @param submissionDate the submission date
	 * @param status the status
	 * @param start the lower bound of the range of appraisal evaluation form statuses
	 * @param end the upper bound of the range of appraisal evaluation form statuses (not inclusive)
	 * @return the range of matching appraisal evaluation form statuses
	 */
	public java.util.List<AppraisalEvaluationFormStatus>
		findByStatusAndSubmissionDate(
			Date submissionDate, boolean status, int start, int end);

	/**
	 * Returns an ordered range of all the appraisal evaluation form statuses where submissionDate = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalEvaluationFormStatusModelImpl</code>.
	 * </p>
	 *
	 * @param submissionDate the submission date
	 * @param status the status
	 * @param start the lower bound of the range of appraisal evaluation form statuses
	 * @param end the upper bound of the range of appraisal evaluation form statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching appraisal evaluation form statuses
	 */
	public java.util.List<AppraisalEvaluationFormStatus>
		findByStatusAndSubmissionDate(
			Date submissionDate, boolean status, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<AppraisalEvaluationFormStatus> orderByComparator);

	/**
	 * Returns an ordered range of all the appraisal evaluation form statuses where submissionDate = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalEvaluationFormStatusModelImpl</code>.
	 * </p>
	 *
	 * @param submissionDate the submission date
	 * @param status the status
	 * @param start the lower bound of the range of appraisal evaluation form statuses
	 * @param end the upper bound of the range of appraisal evaluation form statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching appraisal evaluation form statuses
	 */
	public java.util.List<AppraisalEvaluationFormStatus>
		findByStatusAndSubmissionDate(
			Date submissionDate, boolean status, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<AppraisalEvaluationFormStatus> orderByComparator,
			boolean useFinderCache);

	/**
	 * Returns the first appraisal evaluation form status in the ordered set where submissionDate = &#63; and status = &#63;.
	 *
	 * @param submissionDate the submission date
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appraisal evaluation form status
	 * @throws NoSuchAppraisalEvaluationFormStatusException if a matching appraisal evaluation form status could not be found
	 */
	public AppraisalEvaluationFormStatus findByStatusAndSubmissionDate_First(
			Date submissionDate, boolean status,
			com.liferay.portal.kernel.util.OrderByComparator
				<AppraisalEvaluationFormStatus> orderByComparator)
		throws NoSuchAppraisalEvaluationFormStatusException;

	/**
	 * Returns the first appraisal evaluation form status in the ordered set where submissionDate = &#63; and status = &#63;.
	 *
	 * @param submissionDate the submission date
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appraisal evaluation form status, or <code>null</code> if a matching appraisal evaluation form status could not be found
	 */
	public AppraisalEvaluationFormStatus fetchByStatusAndSubmissionDate_First(
		Date submissionDate, boolean status,
		com.liferay.portal.kernel.util.OrderByComparator
			<AppraisalEvaluationFormStatus> orderByComparator);

	/**
	 * Returns the last appraisal evaluation form status in the ordered set where submissionDate = &#63; and status = &#63;.
	 *
	 * @param submissionDate the submission date
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appraisal evaluation form status
	 * @throws NoSuchAppraisalEvaluationFormStatusException if a matching appraisal evaluation form status could not be found
	 */
	public AppraisalEvaluationFormStatus findByStatusAndSubmissionDate_Last(
			Date submissionDate, boolean status,
			com.liferay.portal.kernel.util.OrderByComparator
				<AppraisalEvaluationFormStatus> orderByComparator)
		throws NoSuchAppraisalEvaluationFormStatusException;

	/**
	 * Returns the last appraisal evaluation form status in the ordered set where submissionDate = &#63; and status = &#63;.
	 *
	 * @param submissionDate the submission date
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appraisal evaluation form status, or <code>null</code> if a matching appraisal evaluation form status could not be found
	 */
	public AppraisalEvaluationFormStatus fetchByStatusAndSubmissionDate_Last(
		Date submissionDate, boolean status,
		com.liferay.portal.kernel.util.OrderByComparator
			<AppraisalEvaluationFormStatus> orderByComparator);

	/**
	 * Returns the appraisal evaluation form statuses before and after the current appraisal evaluation form status in the ordered set where submissionDate = &#63; and status = &#63;.
	 *
	 * @param appraisalEvaluationFormStatusId the primary key of the current appraisal evaluation form status
	 * @param submissionDate the submission date
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next appraisal evaluation form status
	 * @throws NoSuchAppraisalEvaluationFormStatusException if a appraisal evaluation form status with the primary key could not be found
	 */
	public AppraisalEvaluationFormStatus[]
			findByStatusAndSubmissionDate_PrevAndNext(
				long appraisalEvaluationFormStatusId, Date submissionDate,
				boolean status,
				com.liferay.portal.kernel.util.OrderByComparator
					<AppraisalEvaluationFormStatus> orderByComparator)
		throws NoSuchAppraisalEvaluationFormStatusException;

	/**
	 * Removes all the appraisal evaluation form statuses where submissionDate = &#63; and status = &#63; from the database.
	 *
	 * @param submissionDate the submission date
	 * @param status the status
	 */
	public void removeByStatusAndSubmissionDate(
		Date submissionDate, boolean status);

	/**
	 * Returns the number of appraisal evaluation form statuses where submissionDate = &#63; and status = &#63;.
	 *
	 * @param submissionDate the submission date
	 * @param status the status
	 * @return the number of matching appraisal evaluation form statuses
	 */
	public int countByStatusAndSubmissionDate(
		Date submissionDate, boolean status);

	/**
	 * Caches the appraisal evaluation form status in the entity cache if it is enabled.
	 *
	 * @param appraisalEvaluationFormStatus the appraisal evaluation form status
	 */
	public void cacheResult(
		AppraisalEvaluationFormStatus appraisalEvaluationFormStatus);

	/**
	 * Caches the appraisal evaluation form statuses in the entity cache if it is enabled.
	 *
	 * @param appraisalEvaluationFormStatuses the appraisal evaluation form statuses
	 */
	public void cacheResult(
		java.util.List<AppraisalEvaluationFormStatus>
			appraisalEvaluationFormStatuses);

	/**
	 * Creates a new appraisal evaluation form status with the primary key. Does not add the appraisal evaluation form status to the database.
	 *
	 * @param appraisalEvaluationFormStatusId the primary key for the new appraisal evaluation form status
	 * @return the new appraisal evaluation form status
	 */
	public AppraisalEvaluationFormStatus create(
		long appraisalEvaluationFormStatusId);

	/**
	 * Removes the appraisal evaluation form status with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param appraisalEvaluationFormStatusId the primary key of the appraisal evaluation form status
	 * @return the appraisal evaluation form status that was removed
	 * @throws NoSuchAppraisalEvaluationFormStatusException if a appraisal evaluation form status with the primary key could not be found
	 */
	public AppraisalEvaluationFormStatus remove(
			long appraisalEvaluationFormStatusId)
		throws NoSuchAppraisalEvaluationFormStatusException;

	public AppraisalEvaluationFormStatus updateImpl(
		AppraisalEvaluationFormStatus appraisalEvaluationFormStatus);

	/**
	 * Returns the appraisal evaluation form status with the primary key or throws a <code>NoSuchAppraisalEvaluationFormStatusException</code> if it could not be found.
	 *
	 * @param appraisalEvaluationFormStatusId the primary key of the appraisal evaluation form status
	 * @return the appraisal evaluation form status
	 * @throws NoSuchAppraisalEvaluationFormStatusException if a appraisal evaluation form status with the primary key could not be found
	 */
	public AppraisalEvaluationFormStatus findByPrimaryKey(
			long appraisalEvaluationFormStatusId)
		throws NoSuchAppraisalEvaluationFormStatusException;

	/**
	 * Returns the appraisal evaluation form status with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param appraisalEvaluationFormStatusId the primary key of the appraisal evaluation form status
	 * @return the appraisal evaluation form status, or <code>null</code> if a appraisal evaluation form status with the primary key could not be found
	 */
	public AppraisalEvaluationFormStatus fetchByPrimaryKey(
		long appraisalEvaluationFormStatusId);

	/**
	 * Returns all the appraisal evaluation form statuses.
	 *
	 * @return the appraisal evaluation form statuses
	 */
	public java.util.List<AppraisalEvaluationFormStatus> findAll();

	/**
	 * Returns a range of all the appraisal evaluation form statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalEvaluationFormStatusModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of appraisal evaluation form statuses
	 * @param end the upper bound of the range of appraisal evaluation form statuses (not inclusive)
	 * @return the range of appraisal evaluation form statuses
	 */
	public java.util.List<AppraisalEvaluationFormStatus> findAll(
		int start, int end);

	/**
	 * Returns an ordered range of all the appraisal evaluation form statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalEvaluationFormStatusModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of appraisal evaluation form statuses
	 * @param end the upper bound of the range of appraisal evaluation form statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of appraisal evaluation form statuses
	 */
	public java.util.List<AppraisalEvaluationFormStatus> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<AppraisalEvaluationFormStatus> orderByComparator);

	/**
	 * Returns an ordered range of all the appraisal evaluation form statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalEvaluationFormStatusModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of appraisal evaluation form statuses
	 * @param end the upper bound of the range of appraisal evaluation form statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of appraisal evaluation form statuses
	 */
	public java.util.List<AppraisalEvaluationFormStatus> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<AppraisalEvaluationFormStatus> orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the appraisal evaluation form statuses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of appraisal evaluation form statuses.
	 *
	 * @return the number of appraisal evaluation form statuses
	 */
	public int countAll();

}