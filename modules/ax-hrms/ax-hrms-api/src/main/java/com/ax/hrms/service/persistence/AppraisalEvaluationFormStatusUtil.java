/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence;

import com.ax.hrms.model.AppraisalEvaluationFormStatus;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the appraisal evaluation form status service. This utility wraps <code>com.ax.hrms.service.persistence.impl.AppraisalEvaluationFormStatusPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AppraisalEvaluationFormStatusPersistence
 * @generated
 */
public class AppraisalEvaluationFormStatusUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(
		AppraisalEvaluationFormStatus appraisalEvaluationFormStatus) {

		getPersistence().clearCache(appraisalEvaluationFormStatus);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, AppraisalEvaluationFormStatus>
		fetchByPrimaryKeys(Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<AppraisalEvaluationFormStatus> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AppraisalEvaluationFormStatus> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AppraisalEvaluationFormStatus> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<AppraisalEvaluationFormStatus> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static AppraisalEvaluationFormStatus update(
		AppraisalEvaluationFormStatus appraisalEvaluationFormStatus) {

		return getPersistence().update(appraisalEvaluationFormStatus);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static AppraisalEvaluationFormStatus update(
		AppraisalEvaluationFormStatus appraisalEvaluationFormStatus,
		ServiceContext serviceContext) {

		return getPersistence().update(
			appraisalEvaluationFormStatus, serviceContext);
	}

	/**
	 * Returns all the appraisal evaluation form statuses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching appraisal evaluation form statuses
	 */
	public static List<AppraisalEvaluationFormStatus> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

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
	public static List<AppraisalEvaluationFormStatus> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static List<AppraisalEvaluationFormStatus> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AppraisalEvaluationFormStatus> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

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
	public static List<AppraisalEvaluationFormStatus> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AppraisalEvaluationFormStatus> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first appraisal evaluation form status in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appraisal evaluation form status
	 * @throws NoSuchAppraisalEvaluationFormStatusException if a matching appraisal evaluation form status could not be found
	 */
	public static AppraisalEvaluationFormStatus findByUuid_First(
			String uuid,
			OrderByComparator<AppraisalEvaluationFormStatus> orderByComparator)
		throws com.ax.hrms.exception.
			NoSuchAppraisalEvaluationFormStatusException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first appraisal evaluation form status in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appraisal evaluation form status, or <code>null</code> if a matching appraisal evaluation form status could not be found
	 */
	public static AppraisalEvaluationFormStatus fetchByUuid_First(
		String uuid,
		OrderByComparator<AppraisalEvaluationFormStatus> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last appraisal evaluation form status in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appraisal evaluation form status
	 * @throws NoSuchAppraisalEvaluationFormStatusException if a matching appraisal evaluation form status could not be found
	 */
	public static AppraisalEvaluationFormStatus findByUuid_Last(
			String uuid,
			OrderByComparator<AppraisalEvaluationFormStatus> orderByComparator)
		throws com.ax.hrms.exception.
			NoSuchAppraisalEvaluationFormStatusException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last appraisal evaluation form status in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appraisal evaluation form status, or <code>null</code> if a matching appraisal evaluation form status could not be found
	 */
	public static AppraisalEvaluationFormStatus fetchByUuid_Last(
		String uuid,
		OrderByComparator<AppraisalEvaluationFormStatus> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the appraisal evaluation form statuses before and after the current appraisal evaluation form status in the ordered set where uuid = &#63;.
	 *
	 * @param appraisalEvaluationFormStatusId the primary key of the current appraisal evaluation form status
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next appraisal evaluation form status
	 * @throws NoSuchAppraisalEvaluationFormStatusException if a appraisal evaluation form status with the primary key could not be found
	 */
	public static AppraisalEvaluationFormStatus[] findByUuid_PrevAndNext(
			long appraisalEvaluationFormStatusId, String uuid,
			OrderByComparator<AppraisalEvaluationFormStatus> orderByComparator)
		throws com.ax.hrms.exception.
			NoSuchAppraisalEvaluationFormStatusException {

		return getPersistence().findByUuid_PrevAndNext(
			appraisalEvaluationFormStatusId, uuid, orderByComparator);
	}

	/**
	 * Removes all the appraisal evaluation form statuses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of appraisal evaluation form statuses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching appraisal evaluation form statuses
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the appraisal evaluation form status where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchAppraisalEvaluationFormStatusException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching appraisal evaluation form status
	 * @throws NoSuchAppraisalEvaluationFormStatusException if a matching appraisal evaluation form status could not be found
	 */
	public static AppraisalEvaluationFormStatus findByUUID_G(
			String uuid, long groupId)
		throws com.ax.hrms.exception.
			NoSuchAppraisalEvaluationFormStatusException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the appraisal evaluation form status where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching appraisal evaluation form status, or <code>null</code> if a matching appraisal evaluation form status could not be found
	 */
	public static AppraisalEvaluationFormStatus fetchByUUID_G(
		String uuid, long groupId) {

		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the appraisal evaluation form status where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching appraisal evaluation form status, or <code>null</code> if a matching appraisal evaluation form status could not be found
	 */
	public static AppraisalEvaluationFormStatus fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the appraisal evaluation form status where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the appraisal evaluation form status that was removed
	 */
	public static AppraisalEvaluationFormStatus removeByUUID_G(
			String uuid, long groupId)
		throws com.ax.hrms.exception.
			NoSuchAppraisalEvaluationFormStatusException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of appraisal evaluation form statuses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching appraisal evaluation form statuses
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the appraisal evaluation form statuses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching appraisal evaluation form statuses
	 */
	public static List<AppraisalEvaluationFormStatus> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

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
	public static List<AppraisalEvaluationFormStatus> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

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
	public static List<AppraisalEvaluationFormStatus> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AppraisalEvaluationFormStatus> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

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
	public static List<AppraisalEvaluationFormStatus> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AppraisalEvaluationFormStatus> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first appraisal evaluation form status in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appraisal evaluation form status
	 * @throws NoSuchAppraisalEvaluationFormStatusException if a matching appraisal evaluation form status could not be found
	 */
	public static AppraisalEvaluationFormStatus findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<AppraisalEvaluationFormStatus> orderByComparator)
		throws com.ax.hrms.exception.
			NoSuchAppraisalEvaluationFormStatusException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first appraisal evaluation form status in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appraisal evaluation form status, or <code>null</code> if a matching appraisal evaluation form status could not be found
	 */
	public static AppraisalEvaluationFormStatus fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<AppraisalEvaluationFormStatus> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last appraisal evaluation form status in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appraisal evaluation form status
	 * @throws NoSuchAppraisalEvaluationFormStatusException if a matching appraisal evaluation form status could not be found
	 */
	public static AppraisalEvaluationFormStatus findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<AppraisalEvaluationFormStatus> orderByComparator)
		throws com.ax.hrms.exception.
			NoSuchAppraisalEvaluationFormStatusException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last appraisal evaluation form status in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appraisal evaluation form status, or <code>null</code> if a matching appraisal evaluation form status could not be found
	 */
	public static AppraisalEvaluationFormStatus fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<AppraisalEvaluationFormStatus> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

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
	public static AppraisalEvaluationFormStatus[] findByUuid_C_PrevAndNext(
			long appraisalEvaluationFormStatusId, String uuid, long companyId,
			OrderByComparator<AppraisalEvaluationFormStatus> orderByComparator)
		throws com.ax.hrms.exception.
			NoSuchAppraisalEvaluationFormStatusException {

		return getPersistence().findByUuid_C_PrevAndNext(
			appraisalEvaluationFormStatusId, uuid, companyId,
			orderByComparator);
	}

	/**
	 * Removes all the appraisal evaluation form statuses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of appraisal evaluation form statuses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching appraisal evaluation form statuses
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the appraisal evaluation form statuses where appraisalProcessId = &#63; and appraisalFormTemplateId = &#63;.
	 *
	 * @param appraisalProcessId the appraisal process ID
	 * @param appraisalFormTemplateId the appraisal form template ID
	 * @return the matching appraisal evaluation form statuses
	 */
	public static List<AppraisalEvaluationFormStatus>
		findByAppraisalProcessIdAndAppraisalFormTemplateId(
			long appraisalProcessId, long appraisalFormTemplateId) {

		return getPersistence().
			findByAppraisalProcessIdAndAppraisalFormTemplateId(
				appraisalProcessId, appraisalFormTemplateId);
	}

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
	public static List<AppraisalEvaluationFormStatus>
		findByAppraisalProcessIdAndAppraisalFormTemplateId(
			long appraisalProcessId, long appraisalFormTemplateId, int start,
			int end) {

		return getPersistence().
			findByAppraisalProcessIdAndAppraisalFormTemplateId(
				appraisalProcessId, appraisalFormTemplateId, start, end);
	}

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
	public static List<AppraisalEvaluationFormStatus>
		findByAppraisalProcessIdAndAppraisalFormTemplateId(
			long appraisalProcessId, long appraisalFormTemplateId, int start,
			int end,
			OrderByComparator<AppraisalEvaluationFormStatus>
				orderByComparator) {

		return getPersistence().
			findByAppraisalProcessIdAndAppraisalFormTemplateId(
				appraisalProcessId, appraisalFormTemplateId, start, end,
				orderByComparator);
	}

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
	public static List<AppraisalEvaluationFormStatus>
		findByAppraisalProcessIdAndAppraisalFormTemplateId(
			long appraisalProcessId, long appraisalFormTemplateId, int start,
			int end,
			OrderByComparator<AppraisalEvaluationFormStatus> orderByComparator,
			boolean useFinderCache) {

		return getPersistence().
			findByAppraisalProcessIdAndAppraisalFormTemplateId(
				appraisalProcessId, appraisalFormTemplateId, start, end,
				orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first appraisal evaluation form status in the ordered set where appraisalProcessId = &#63; and appraisalFormTemplateId = &#63;.
	 *
	 * @param appraisalProcessId the appraisal process ID
	 * @param appraisalFormTemplateId the appraisal form template ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appraisal evaluation form status
	 * @throws NoSuchAppraisalEvaluationFormStatusException if a matching appraisal evaluation form status could not be found
	 */
	public static AppraisalEvaluationFormStatus
			findByAppraisalProcessIdAndAppraisalFormTemplateId_First(
				long appraisalProcessId, long appraisalFormTemplateId,
				OrderByComparator<AppraisalEvaluationFormStatus>
					orderByComparator)
		throws com.ax.hrms.exception.
			NoSuchAppraisalEvaluationFormStatusException {

		return getPersistence().
			findByAppraisalProcessIdAndAppraisalFormTemplateId_First(
				appraisalProcessId, appraisalFormTemplateId, orderByComparator);
	}

	/**
	 * Returns the first appraisal evaluation form status in the ordered set where appraisalProcessId = &#63; and appraisalFormTemplateId = &#63;.
	 *
	 * @param appraisalProcessId the appraisal process ID
	 * @param appraisalFormTemplateId the appraisal form template ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appraisal evaluation form status, or <code>null</code> if a matching appraisal evaluation form status could not be found
	 */
	public static AppraisalEvaluationFormStatus
		fetchByAppraisalProcessIdAndAppraisalFormTemplateId_First(
			long appraisalProcessId, long appraisalFormTemplateId,
			OrderByComparator<AppraisalEvaluationFormStatus>
				orderByComparator) {

		return getPersistence().
			fetchByAppraisalProcessIdAndAppraisalFormTemplateId_First(
				appraisalProcessId, appraisalFormTemplateId, orderByComparator);
	}

	/**
	 * Returns the last appraisal evaluation form status in the ordered set where appraisalProcessId = &#63; and appraisalFormTemplateId = &#63;.
	 *
	 * @param appraisalProcessId the appraisal process ID
	 * @param appraisalFormTemplateId the appraisal form template ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appraisal evaluation form status
	 * @throws NoSuchAppraisalEvaluationFormStatusException if a matching appraisal evaluation form status could not be found
	 */
	public static AppraisalEvaluationFormStatus
			findByAppraisalProcessIdAndAppraisalFormTemplateId_Last(
				long appraisalProcessId, long appraisalFormTemplateId,
				OrderByComparator<AppraisalEvaluationFormStatus>
					orderByComparator)
		throws com.ax.hrms.exception.
			NoSuchAppraisalEvaluationFormStatusException {

		return getPersistence().
			findByAppraisalProcessIdAndAppraisalFormTemplateId_Last(
				appraisalProcessId, appraisalFormTemplateId, orderByComparator);
	}

	/**
	 * Returns the last appraisal evaluation form status in the ordered set where appraisalProcessId = &#63; and appraisalFormTemplateId = &#63;.
	 *
	 * @param appraisalProcessId the appraisal process ID
	 * @param appraisalFormTemplateId the appraisal form template ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appraisal evaluation form status, or <code>null</code> if a matching appraisal evaluation form status could not be found
	 */
	public static AppraisalEvaluationFormStatus
		fetchByAppraisalProcessIdAndAppraisalFormTemplateId_Last(
			long appraisalProcessId, long appraisalFormTemplateId,
			OrderByComparator<AppraisalEvaluationFormStatus>
				orderByComparator) {

		return getPersistence().
			fetchByAppraisalProcessIdAndAppraisalFormTemplateId_Last(
				appraisalProcessId, appraisalFormTemplateId, orderByComparator);
	}

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
	public static AppraisalEvaluationFormStatus[]
			findByAppraisalProcessIdAndAppraisalFormTemplateId_PrevAndNext(
				long appraisalEvaluationFormStatusId, long appraisalProcessId,
				long appraisalFormTemplateId,
				OrderByComparator<AppraisalEvaluationFormStatus>
					orderByComparator)
		throws com.ax.hrms.exception.
			NoSuchAppraisalEvaluationFormStatusException {

		return getPersistence().
			findByAppraisalProcessIdAndAppraisalFormTemplateId_PrevAndNext(
				appraisalEvaluationFormStatusId, appraisalProcessId,
				appraisalFormTemplateId, orderByComparator);
	}

	/**
	 * Removes all the appraisal evaluation form statuses where appraisalProcessId = &#63; and appraisalFormTemplateId = &#63; from the database.
	 *
	 * @param appraisalProcessId the appraisal process ID
	 * @param appraisalFormTemplateId the appraisal form template ID
	 */
	public static void removeByAppraisalProcessIdAndAppraisalFormTemplateId(
		long appraisalProcessId, long appraisalFormTemplateId) {

		getPersistence().removeByAppraisalProcessIdAndAppraisalFormTemplateId(
			appraisalProcessId, appraisalFormTemplateId);
	}

	/**
	 * Returns the number of appraisal evaluation form statuses where appraisalProcessId = &#63; and appraisalFormTemplateId = &#63;.
	 *
	 * @param appraisalProcessId the appraisal process ID
	 * @param appraisalFormTemplateId the appraisal form template ID
	 * @return the number of matching appraisal evaluation form statuses
	 */
	public static int countByAppraisalProcessIdAndAppraisalFormTemplateId(
		long appraisalProcessId, long appraisalFormTemplateId) {

		return getPersistence().
			countByAppraisalProcessIdAndAppraisalFormTemplateId(
				appraisalProcessId, appraisalFormTemplateId);
	}

	/**
	 * Returns all the appraisal evaluation form statuses where submissionDate = &#63; and status = &#63;.
	 *
	 * @param submissionDate the submission date
	 * @param status the status
	 * @return the matching appraisal evaluation form statuses
	 */
	public static List<AppraisalEvaluationFormStatus>
		findByStatusAndSubmissionDate(Date submissionDate, boolean status) {

		return getPersistence().findByStatusAndSubmissionDate(
			submissionDate, status);
	}

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
	public static List<AppraisalEvaluationFormStatus>
		findByStatusAndSubmissionDate(
			Date submissionDate, boolean status, int start, int end) {

		return getPersistence().findByStatusAndSubmissionDate(
			submissionDate, status, start, end);
	}

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
	public static List<AppraisalEvaluationFormStatus>
		findByStatusAndSubmissionDate(
			Date submissionDate, boolean status, int start, int end,
			OrderByComparator<AppraisalEvaluationFormStatus>
				orderByComparator) {

		return getPersistence().findByStatusAndSubmissionDate(
			submissionDate, status, start, end, orderByComparator);
	}

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
	public static List<AppraisalEvaluationFormStatus>
		findByStatusAndSubmissionDate(
			Date submissionDate, boolean status, int start, int end,
			OrderByComparator<AppraisalEvaluationFormStatus> orderByComparator,
			boolean useFinderCache) {

		return getPersistence().findByStatusAndSubmissionDate(
			submissionDate, status, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first appraisal evaluation form status in the ordered set where submissionDate = &#63; and status = &#63;.
	 *
	 * @param submissionDate the submission date
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appraisal evaluation form status
	 * @throws NoSuchAppraisalEvaluationFormStatusException if a matching appraisal evaluation form status could not be found
	 */
	public static AppraisalEvaluationFormStatus
			findByStatusAndSubmissionDate_First(
				Date submissionDate, boolean status,
				OrderByComparator<AppraisalEvaluationFormStatus>
					orderByComparator)
		throws com.ax.hrms.exception.
			NoSuchAppraisalEvaluationFormStatusException {

		return getPersistence().findByStatusAndSubmissionDate_First(
			submissionDate, status, orderByComparator);
	}

	/**
	 * Returns the first appraisal evaluation form status in the ordered set where submissionDate = &#63; and status = &#63;.
	 *
	 * @param submissionDate the submission date
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appraisal evaluation form status, or <code>null</code> if a matching appraisal evaluation form status could not be found
	 */
	public static AppraisalEvaluationFormStatus
		fetchByStatusAndSubmissionDate_First(
			Date submissionDate, boolean status,
			OrderByComparator<AppraisalEvaluationFormStatus>
				orderByComparator) {

		return getPersistence().fetchByStatusAndSubmissionDate_First(
			submissionDate, status, orderByComparator);
	}

	/**
	 * Returns the last appraisal evaluation form status in the ordered set where submissionDate = &#63; and status = &#63;.
	 *
	 * @param submissionDate the submission date
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appraisal evaluation form status
	 * @throws NoSuchAppraisalEvaluationFormStatusException if a matching appraisal evaluation form status could not be found
	 */
	public static AppraisalEvaluationFormStatus
			findByStatusAndSubmissionDate_Last(
				Date submissionDate, boolean status,
				OrderByComparator<AppraisalEvaluationFormStatus>
					orderByComparator)
		throws com.ax.hrms.exception.
			NoSuchAppraisalEvaluationFormStatusException {

		return getPersistence().findByStatusAndSubmissionDate_Last(
			submissionDate, status, orderByComparator);
	}

	/**
	 * Returns the last appraisal evaluation form status in the ordered set where submissionDate = &#63; and status = &#63;.
	 *
	 * @param submissionDate the submission date
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appraisal evaluation form status, or <code>null</code> if a matching appraisal evaluation form status could not be found
	 */
	public static AppraisalEvaluationFormStatus
		fetchByStatusAndSubmissionDate_Last(
			Date submissionDate, boolean status,
			OrderByComparator<AppraisalEvaluationFormStatus>
				orderByComparator) {

		return getPersistence().fetchByStatusAndSubmissionDate_Last(
			submissionDate, status, orderByComparator);
	}

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
	public static AppraisalEvaluationFormStatus[]
			findByStatusAndSubmissionDate_PrevAndNext(
				long appraisalEvaluationFormStatusId, Date submissionDate,
				boolean status,
				OrderByComparator<AppraisalEvaluationFormStatus>
					orderByComparator)
		throws com.ax.hrms.exception.
			NoSuchAppraisalEvaluationFormStatusException {

		return getPersistence().findByStatusAndSubmissionDate_PrevAndNext(
			appraisalEvaluationFormStatusId, submissionDate, status,
			orderByComparator);
	}

	/**
	 * Removes all the appraisal evaluation form statuses where submissionDate = &#63; and status = &#63; from the database.
	 *
	 * @param submissionDate the submission date
	 * @param status the status
	 */
	public static void removeByStatusAndSubmissionDate(
		Date submissionDate, boolean status) {

		getPersistence().removeByStatusAndSubmissionDate(
			submissionDate, status);
	}

	/**
	 * Returns the number of appraisal evaluation form statuses where submissionDate = &#63; and status = &#63;.
	 *
	 * @param submissionDate the submission date
	 * @param status the status
	 * @return the number of matching appraisal evaluation form statuses
	 */
	public static int countByStatusAndSubmissionDate(
		Date submissionDate, boolean status) {

		return getPersistence().countByStatusAndSubmissionDate(
			submissionDate, status);
	}

	/**
	 * Caches the appraisal evaluation form status in the entity cache if it is enabled.
	 *
	 * @param appraisalEvaluationFormStatus the appraisal evaluation form status
	 */
	public static void cacheResult(
		AppraisalEvaluationFormStatus appraisalEvaluationFormStatus) {

		getPersistence().cacheResult(appraisalEvaluationFormStatus);
	}

	/**
	 * Caches the appraisal evaluation form statuses in the entity cache if it is enabled.
	 *
	 * @param appraisalEvaluationFormStatuses the appraisal evaluation form statuses
	 */
	public static void cacheResult(
		List<AppraisalEvaluationFormStatus> appraisalEvaluationFormStatuses) {

		getPersistence().cacheResult(appraisalEvaluationFormStatuses);
	}

	/**
	 * Creates a new appraisal evaluation form status with the primary key. Does not add the appraisal evaluation form status to the database.
	 *
	 * @param appraisalEvaluationFormStatusId the primary key for the new appraisal evaluation form status
	 * @return the new appraisal evaluation form status
	 */
	public static AppraisalEvaluationFormStatus create(
		long appraisalEvaluationFormStatusId) {

		return getPersistence().create(appraisalEvaluationFormStatusId);
	}

	/**
	 * Removes the appraisal evaluation form status with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param appraisalEvaluationFormStatusId the primary key of the appraisal evaluation form status
	 * @return the appraisal evaluation form status that was removed
	 * @throws NoSuchAppraisalEvaluationFormStatusException if a appraisal evaluation form status with the primary key could not be found
	 */
	public static AppraisalEvaluationFormStatus remove(
			long appraisalEvaluationFormStatusId)
		throws com.ax.hrms.exception.
			NoSuchAppraisalEvaluationFormStatusException {

		return getPersistence().remove(appraisalEvaluationFormStatusId);
	}

	public static AppraisalEvaluationFormStatus updateImpl(
		AppraisalEvaluationFormStatus appraisalEvaluationFormStatus) {

		return getPersistence().updateImpl(appraisalEvaluationFormStatus);
	}

	/**
	 * Returns the appraisal evaluation form status with the primary key or throws a <code>NoSuchAppraisalEvaluationFormStatusException</code> if it could not be found.
	 *
	 * @param appraisalEvaluationFormStatusId the primary key of the appraisal evaluation form status
	 * @return the appraisal evaluation form status
	 * @throws NoSuchAppraisalEvaluationFormStatusException if a appraisal evaluation form status with the primary key could not be found
	 */
	public static AppraisalEvaluationFormStatus findByPrimaryKey(
			long appraisalEvaluationFormStatusId)
		throws com.ax.hrms.exception.
			NoSuchAppraisalEvaluationFormStatusException {

		return getPersistence().findByPrimaryKey(
			appraisalEvaluationFormStatusId);
	}

	/**
	 * Returns the appraisal evaluation form status with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param appraisalEvaluationFormStatusId the primary key of the appraisal evaluation form status
	 * @return the appraisal evaluation form status, or <code>null</code> if a appraisal evaluation form status with the primary key could not be found
	 */
	public static AppraisalEvaluationFormStatus fetchByPrimaryKey(
		long appraisalEvaluationFormStatusId) {

		return getPersistence().fetchByPrimaryKey(
			appraisalEvaluationFormStatusId);
	}

	/**
	 * Returns all the appraisal evaluation form statuses.
	 *
	 * @return the appraisal evaluation form statuses
	 */
	public static List<AppraisalEvaluationFormStatus> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<AppraisalEvaluationFormStatus> findAll(
		int start, int end) {

		return getPersistence().findAll(start, end);
	}

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
	public static List<AppraisalEvaluationFormStatus> findAll(
		int start, int end,
		OrderByComparator<AppraisalEvaluationFormStatus> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<AppraisalEvaluationFormStatus> findAll(
		int start, int end,
		OrderByComparator<AppraisalEvaluationFormStatus> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the appraisal evaluation form statuses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of appraisal evaluation form statuses.
	 *
	 * @return the number of appraisal evaluation form statuses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static AppraisalEvaluationFormStatusPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(
		AppraisalEvaluationFormStatusPersistence persistence) {

		_persistence = persistence;
	}

	private static volatile AppraisalEvaluationFormStatusPersistence
		_persistence;

}