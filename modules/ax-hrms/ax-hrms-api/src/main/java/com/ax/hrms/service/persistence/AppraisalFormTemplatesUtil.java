/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence;

import com.ax.hrms.model.AppraisalFormTemplates;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the appraisal form templates service. This utility wraps <code>com.ax.hrms.service.persistence.impl.AppraisalFormTemplatesPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AppraisalFormTemplatesPersistence
 * @generated
 */
public class AppraisalFormTemplatesUtil {

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
		AppraisalFormTemplates appraisalFormTemplates) {

		getPersistence().clearCache(appraisalFormTemplates);
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
	public static Map<Serializable, AppraisalFormTemplates> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<AppraisalFormTemplates> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AppraisalFormTemplates> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AppraisalFormTemplates> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<AppraisalFormTemplates> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static AppraisalFormTemplates update(
		AppraisalFormTemplates appraisalFormTemplates) {

		return getPersistence().update(appraisalFormTemplates);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static AppraisalFormTemplates update(
		AppraisalFormTemplates appraisalFormTemplates,
		ServiceContext serviceContext) {

		return getPersistence().update(appraisalFormTemplates, serviceContext);
	}

	/**
	 * Returns all the appraisal form templateses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching appraisal form templateses
	 */
	public static List<AppraisalFormTemplates> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the appraisal form templateses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalFormTemplatesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of appraisal form templateses
	 * @param end the upper bound of the range of appraisal form templateses (not inclusive)
	 * @return the range of matching appraisal form templateses
	 */
	public static List<AppraisalFormTemplates> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the appraisal form templateses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalFormTemplatesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of appraisal form templateses
	 * @param end the upper bound of the range of appraisal form templateses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching appraisal form templateses
	 */
	public static List<AppraisalFormTemplates> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AppraisalFormTemplates> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the appraisal form templateses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalFormTemplatesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of appraisal form templateses
	 * @param end the upper bound of the range of appraisal form templateses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching appraisal form templateses
	 */
	public static List<AppraisalFormTemplates> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AppraisalFormTemplates> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first appraisal form templates in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appraisal form templates
	 * @throws NoSuchAppraisalFormTemplatesException if a matching appraisal form templates could not be found
	 */
	public static AppraisalFormTemplates findByUuid_First(
			String uuid,
			OrderByComparator<AppraisalFormTemplates> orderByComparator)
		throws com.ax.hrms.exception.NoSuchAppraisalFormTemplatesException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first appraisal form templates in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appraisal form templates, or <code>null</code> if a matching appraisal form templates could not be found
	 */
	public static AppraisalFormTemplates fetchByUuid_First(
		String uuid,
		OrderByComparator<AppraisalFormTemplates> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last appraisal form templates in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appraisal form templates
	 * @throws NoSuchAppraisalFormTemplatesException if a matching appraisal form templates could not be found
	 */
	public static AppraisalFormTemplates findByUuid_Last(
			String uuid,
			OrderByComparator<AppraisalFormTemplates> orderByComparator)
		throws com.ax.hrms.exception.NoSuchAppraisalFormTemplatesException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last appraisal form templates in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appraisal form templates, or <code>null</code> if a matching appraisal form templates could not be found
	 */
	public static AppraisalFormTemplates fetchByUuid_Last(
		String uuid,
		OrderByComparator<AppraisalFormTemplates> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the appraisal form templateses before and after the current appraisal form templates in the ordered set where uuid = &#63;.
	 *
	 * @param appraisalFormTemplateId the primary key of the current appraisal form templates
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next appraisal form templates
	 * @throws NoSuchAppraisalFormTemplatesException if a appraisal form templates with the primary key could not be found
	 */
	public static AppraisalFormTemplates[] findByUuid_PrevAndNext(
			long appraisalFormTemplateId, String uuid,
			OrderByComparator<AppraisalFormTemplates> orderByComparator)
		throws com.ax.hrms.exception.NoSuchAppraisalFormTemplatesException {

		return getPersistence().findByUuid_PrevAndNext(
			appraisalFormTemplateId, uuid, orderByComparator);
	}

	/**
	 * Removes all the appraisal form templateses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of appraisal form templateses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching appraisal form templateses
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the appraisal form templates where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchAppraisalFormTemplatesException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching appraisal form templates
	 * @throws NoSuchAppraisalFormTemplatesException if a matching appraisal form templates could not be found
	 */
	public static AppraisalFormTemplates findByUUID_G(String uuid, long groupId)
		throws com.ax.hrms.exception.NoSuchAppraisalFormTemplatesException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the appraisal form templates where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching appraisal form templates, or <code>null</code> if a matching appraisal form templates could not be found
	 */
	public static AppraisalFormTemplates fetchByUUID_G(
		String uuid, long groupId) {

		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the appraisal form templates where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching appraisal form templates, or <code>null</code> if a matching appraisal form templates could not be found
	 */
	public static AppraisalFormTemplates fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the appraisal form templates where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the appraisal form templates that was removed
	 */
	public static AppraisalFormTemplates removeByUUID_G(
			String uuid, long groupId)
		throws com.ax.hrms.exception.NoSuchAppraisalFormTemplatesException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of appraisal form templateses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching appraisal form templateses
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the appraisal form templateses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching appraisal form templateses
	 */
	public static List<AppraisalFormTemplates> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the appraisal form templateses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalFormTemplatesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of appraisal form templateses
	 * @param end the upper bound of the range of appraisal form templateses (not inclusive)
	 * @return the range of matching appraisal form templateses
	 */
	public static List<AppraisalFormTemplates> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the appraisal form templateses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalFormTemplatesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of appraisal form templateses
	 * @param end the upper bound of the range of appraisal form templateses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching appraisal form templateses
	 */
	public static List<AppraisalFormTemplates> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AppraisalFormTemplates> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the appraisal form templateses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalFormTemplatesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of appraisal form templateses
	 * @param end the upper bound of the range of appraisal form templateses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching appraisal form templateses
	 */
	public static List<AppraisalFormTemplates> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AppraisalFormTemplates> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first appraisal form templates in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appraisal form templates
	 * @throws NoSuchAppraisalFormTemplatesException if a matching appraisal form templates could not be found
	 */
	public static AppraisalFormTemplates findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<AppraisalFormTemplates> orderByComparator)
		throws com.ax.hrms.exception.NoSuchAppraisalFormTemplatesException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first appraisal form templates in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appraisal form templates, or <code>null</code> if a matching appraisal form templates could not be found
	 */
	public static AppraisalFormTemplates fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<AppraisalFormTemplates> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last appraisal form templates in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appraisal form templates
	 * @throws NoSuchAppraisalFormTemplatesException if a matching appraisal form templates could not be found
	 */
	public static AppraisalFormTemplates findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<AppraisalFormTemplates> orderByComparator)
		throws com.ax.hrms.exception.NoSuchAppraisalFormTemplatesException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last appraisal form templates in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appraisal form templates, or <code>null</code> if a matching appraisal form templates could not be found
	 */
	public static AppraisalFormTemplates fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<AppraisalFormTemplates> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the appraisal form templateses before and after the current appraisal form templates in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param appraisalFormTemplateId the primary key of the current appraisal form templates
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next appraisal form templates
	 * @throws NoSuchAppraisalFormTemplatesException if a appraisal form templates with the primary key could not be found
	 */
	public static AppraisalFormTemplates[] findByUuid_C_PrevAndNext(
			long appraisalFormTemplateId, String uuid, long companyId,
			OrderByComparator<AppraisalFormTemplates> orderByComparator)
		throws com.ax.hrms.exception.NoSuchAppraisalFormTemplatesException {

		return getPersistence().findByUuid_C_PrevAndNext(
			appraisalFormTemplateId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the appraisal form templateses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of appraisal form templateses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching appraisal form templateses
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the appraisal form templates where templateYear = &#63; and templateLevelId = &#63; or throws a <code>NoSuchAppraisalFormTemplatesException</code> if it could not be found.
	 *
	 * @param templateYear the template year
	 * @param templateLevelId the template level ID
	 * @return the matching appraisal form templates
	 * @throws NoSuchAppraisalFormTemplatesException if a matching appraisal form templates could not be found
	 */
	public static AppraisalFormTemplates findByTemplateYearAndTemplateLevelId(
			String templateYear, long templateLevelId)
		throws com.ax.hrms.exception.NoSuchAppraisalFormTemplatesException {

		return getPersistence().findByTemplateYearAndTemplateLevelId(
			templateYear, templateLevelId);
	}

	/**
	 * Returns the appraisal form templates where templateYear = &#63; and templateLevelId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param templateYear the template year
	 * @param templateLevelId the template level ID
	 * @return the matching appraisal form templates, or <code>null</code> if a matching appraisal form templates could not be found
	 */
	public static AppraisalFormTemplates fetchByTemplateYearAndTemplateLevelId(
		String templateYear, long templateLevelId) {

		return getPersistence().fetchByTemplateYearAndTemplateLevelId(
			templateYear, templateLevelId);
	}

	/**
	 * Returns the appraisal form templates where templateYear = &#63; and templateLevelId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param templateYear the template year
	 * @param templateLevelId the template level ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching appraisal form templates, or <code>null</code> if a matching appraisal form templates could not be found
	 */
	public static AppraisalFormTemplates fetchByTemplateYearAndTemplateLevelId(
		String templateYear, long templateLevelId, boolean useFinderCache) {

		return getPersistence().fetchByTemplateYearAndTemplateLevelId(
			templateYear, templateLevelId, useFinderCache);
	}

	/**
	 * Removes the appraisal form templates where templateYear = &#63; and templateLevelId = &#63; from the database.
	 *
	 * @param templateYear the template year
	 * @param templateLevelId the template level ID
	 * @return the appraisal form templates that was removed
	 */
	public static AppraisalFormTemplates removeByTemplateYearAndTemplateLevelId(
			String templateYear, long templateLevelId)
		throws com.ax.hrms.exception.NoSuchAppraisalFormTemplatesException {

		return getPersistence().removeByTemplateYearAndTemplateLevelId(
			templateYear, templateLevelId);
	}

	/**
	 * Returns the number of appraisal form templateses where templateYear = &#63; and templateLevelId = &#63;.
	 *
	 * @param templateYear the template year
	 * @param templateLevelId the template level ID
	 * @return the number of matching appraisal form templateses
	 */
	public static int countByTemplateYearAndTemplateLevelId(
		String templateYear, long templateLevelId) {

		return getPersistence().countByTemplateYearAndTemplateLevelId(
			templateYear, templateLevelId);
	}

	/**
	 * Returns the appraisal form templates where templateLevelId = &#63; and templateYear = &#63; or throws a <code>NoSuchAppraisalFormTemplatesException</code> if it could not be found.
	 *
	 * @param templateLevelId the template level ID
	 * @param templateYear the template year
	 * @return the matching appraisal form templates
	 * @throws NoSuchAppraisalFormTemplatesException if a matching appraisal form templates could not be found
	 */
	public static AppraisalFormTemplates findByTemplateLevelIdAndTemplateYear(
			long templateLevelId, String templateYear)
		throws com.ax.hrms.exception.NoSuchAppraisalFormTemplatesException {

		return getPersistence().findByTemplateLevelIdAndTemplateYear(
			templateLevelId, templateYear);
	}

	/**
	 * Returns the appraisal form templates where templateLevelId = &#63; and templateYear = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param templateLevelId the template level ID
	 * @param templateYear the template year
	 * @return the matching appraisal form templates, or <code>null</code> if a matching appraisal form templates could not be found
	 */
	public static AppraisalFormTemplates fetchByTemplateLevelIdAndTemplateYear(
		long templateLevelId, String templateYear) {

		return getPersistence().fetchByTemplateLevelIdAndTemplateYear(
			templateLevelId, templateYear);
	}

	/**
	 * Returns the appraisal form templates where templateLevelId = &#63; and templateYear = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param templateLevelId the template level ID
	 * @param templateYear the template year
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching appraisal form templates, or <code>null</code> if a matching appraisal form templates could not be found
	 */
	public static AppraisalFormTemplates fetchByTemplateLevelIdAndTemplateYear(
		long templateLevelId, String templateYear, boolean useFinderCache) {

		return getPersistence().fetchByTemplateLevelIdAndTemplateYear(
			templateLevelId, templateYear, useFinderCache);
	}

	/**
	 * Removes the appraisal form templates where templateLevelId = &#63; and templateYear = &#63; from the database.
	 *
	 * @param templateLevelId the template level ID
	 * @param templateYear the template year
	 * @return the appraisal form templates that was removed
	 */
	public static AppraisalFormTemplates removeByTemplateLevelIdAndTemplateYear(
			long templateLevelId, String templateYear)
		throws com.ax.hrms.exception.NoSuchAppraisalFormTemplatesException {

		return getPersistence().removeByTemplateLevelIdAndTemplateYear(
			templateLevelId, templateYear);
	}

	/**
	 * Returns the number of appraisal form templateses where templateLevelId = &#63; and templateYear = &#63;.
	 *
	 * @param templateLevelId the template level ID
	 * @param templateYear the template year
	 * @return the number of matching appraisal form templateses
	 */
	public static int countByTemplateLevelIdAndTemplateYear(
		long templateLevelId, String templateYear) {

		return getPersistence().countByTemplateLevelIdAndTemplateYear(
			templateLevelId, templateYear);
	}

	/**
	 * Caches the appraisal form templates in the entity cache if it is enabled.
	 *
	 * @param appraisalFormTemplates the appraisal form templates
	 */
	public static void cacheResult(
		AppraisalFormTemplates appraisalFormTemplates) {

		getPersistence().cacheResult(appraisalFormTemplates);
	}

	/**
	 * Caches the appraisal form templateses in the entity cache if it is enabled.
	 *
	 * @param appraisalFormTemplateses the appraisal form templateses
	 */
	public static void cacheResult(
		List<AppraisalFormTemplates> appraisalFormTemplateses) {

		getPersistence().cacheResult(appraisalFormTemplateses);
	}

	/**
	 * Creates a new appraisal form templates with the primary key. Does not add the appraisal form templates to the database.
	 *
	 * @param appraisalFormTemplateId the primary key for the new appraisal form templates
	 * @return the new appraisal form templates
	 */
	public static AppraisalFormTemplates create(long appraisalFormTemplateId) {
		return getPersistence().create(appraisalFormTemplateId);
	}

	/**
	 * Removes the appraisal form templates with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param appraisalFormTemplateId the primary key of the appraisal form templates
	 * @return the appraisal form templates that was removed
	 * @throws NoSuchAppraisalFormTemplatesException if a appraisal form templates with the primary key could not be found
	 */
	public static AppraisalFormTemplates remove(long appraisalFormTemplateId)
		throws com.ax.hrms.exception.NoSuchAppraisalFormTemplatesException {

		return getPersistence().remove(appraisalFormTemplateId);
	}

	public static AppraisalFormTemplates updateImpl(
		AppraisalFormTemplates appraisalFormTemplates) {

		return getPersistence().updateImpl(appraisalFormTemplates);
	}

	/**
	 * Returns the appraisal form templates with the primary key or throws a <code>NoSuchAppraisalFormTemplatesException</code> if it could not be found.
	 *
	 * @param appraisalFormTemplateId the primary key of the appraisal form templates
	 * @return the appraisal form templates
	 * @throws NoSuchAppraisalFormTemplatesException if a appraisal form templates with the primary key could not be found
	 */
	public static AppraisalFormTemplates findByPrimaryKey(
			long appraisalFormTemplateId)
		throws com.ax.hrms.exception.NoSuchAppraisalFormTemplatesException {

		return getPersistence().findByPrimaryKey(appraisalFormTemplateId);
	}

	/**
	 * Returns the appraisal form templates with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param appraisalFormTemplateId the primary key of the appraisal form templates
	 * @return the appraisal form templates, or <code>null</code> if a appraisal form templates with the primary key could not be found
	 */
	public static AppraisalFormTemplates fetchByPrimaryKey(
		long appraisalFormTemplateId) {

		return getPersistence().fetchByPrimaryKey(appraisalFormTemplateId);
	}

	/**
	 * Returns all the appraisal form templateses.
	 *
	 * @return the appraisal form templateses
	 */
	public static List<AppraisalFormTemplates> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the appraisal form templateses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalFormTemplatesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of appraisal form templateses
	 * @param end the upper bound of the range of appraisal form templateses (not inclusive)
	 * @return the range of appraisal form templateses
	 */
	public static List<AppraisalFormTemplates> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the appraisal form templateses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalFormTemplatesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of appraisal form templateses
	 * @param end the upper bound of the range of appraisal form templateses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of appraisal form templateses
	 */
	public static List<AppraisalFormTemplates> findAll(
		int start, int end,
		OrderByComparator<AppraisalFormTemplates> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the appraisal form templateses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalFormTemplatesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of appraisal form templateses
	 * @param end the upper bound of the range of appraisal form templateses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of appraisal form templateses
	 */
	public static List<AppraisalFormTemplates> findAll(
		int start, int end,
		OrderByComparator<AppraisalFormTemplates> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the appraisal form templateses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of appraisal form templateses.
	 *
	 * @return the number of appraisal form templateses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static AppraisalFormTemplatesPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(
		AppraisalFormTemplatesPersistence persistence) {

		_persistence = persistence;
	}

	private static volatile AppraisalFormTemplatesPersistence _persistence;

}