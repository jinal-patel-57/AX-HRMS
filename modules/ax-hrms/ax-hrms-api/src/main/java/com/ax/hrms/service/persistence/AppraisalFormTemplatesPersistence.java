/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence;

import com.ax.hrms.exception.NoSuchAppraisalFormTemplatesException;
import com.ax.hrms.model.AppraisalFormTemplates;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the appraisal form templates service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AppraisalFormTemplatesUtil
 * @generated
 */
@ProviderType
public interface AppraisalFormTemplatesPersistence
	extends BasePersistence<AppraisalFormTemplates> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AppraisalFormTemplatesUtil} to access the appraisal form templates persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the appraisal form templateses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching appraisal form templateses
	 */
	public java.util.List<AppraisalFormTemplates> findByUuid(String uuid);

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
	public java.util.List<AppraisalFormTemplates> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<AppraisalFormTemplates> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AppraisalFormTemplates>
			orderByComparator);

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
	public java.util.List<AppraisalFormTemplates> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AppraisalFormTemplates>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first appraisal form templates in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appraisal form templates
	 * @throws NoSuchAppraisalFormTemplatesException if a matching appraisal form templates could not be found
	 */
	public AppraisalFormTemplates findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<AppraisalFormTemplates> orderByComparator)
		throws NoSuchAppraisalFormTemplatesException;

	/**
	 * Returns the first appraisal form templates in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appraisal form templates, or <code>null</code> if a matching appraisal form templates could not be found
	 */
	public AppraisalFormTemplates fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<AppraisalFormTemplates>
			orderByComparator);

	/**
	 * Returns the last appraisal form templates in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appraisal form templates
	 * @throws NoSuchAppraisalFormTemplatesException if a matching appraisal form templates could not be found
	 */
	public AppraisalFormTemplates findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<AppraisalFormTemplates> orderByComparator)
		throws NoSuchAppraisalFormTemplatesException;

	/**
	 * Returns the last appraisal form templates in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appraisal form templates, or <code>null</code> if a matching appraisal form templates could not be found
	 */
	public AppraisalFormTemplates fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<AppraisalFormTemplates>
			orderByComparator);

	/**
	 * Returns the appraisal form templateses before and after the current appraisal form templates in the ordered set where uuid = &#63;.
	 *
	 * @param appraisalFormTemplateId the primary key of the current appraisal form templates
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next appraisal form templates
	 * @throws NoSuchAppraisalFormTemplatesException if a appraisal form templates with the primary key could not be found
	 */
	public AppraisalFormTemplates[] findByUuid_PrevAndNext(
			long appraisalFormTemplateId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<AppraisalFormTemplates> orderByComparator)
		throws NoSuchAppraisalFormTemplatesException;

	/**
	 * Removes all the appraisal form templateses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of appraisal form templateses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching appraisal form templateses
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the appraisal form templates where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchAppraisalFormTemplatesException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching appraisal form templates
	 * @throws NoSuchAppraisalFormTemplatesException if a matching appraisal form templates could not be found
	 */
	public AppraisalFormTemplates findByUUID_G(String uuid, long groupId)
		throws NoSuchAppraisalFormTemplatesException;

	/**
	 * Returns the appraisal form templates where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching appraisal form templates, or <code>null</code> if a matching appraisal form templates could not be found
	 */
	public AppraisalFormTemplates fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the appraisal form templates where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching appraisal form templates, or <code>null</code> if a matching appraisal form templates could not be found
	 */
	public AppraisalFormTemplates fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the appraisal form templates where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the appraisal form templates that was removed
	 */
	public AppraisalFormTemplates removeByUUID_G(String uuid, long groupId)
		throws NoSuchAppraisalFormTemplatesException;

	/**
	 * Returns the number of appraisal form templateses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching appraisal form templateses
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the appraisal form templateses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching appraisal form templateses
	 */
	public java.util.List<AppraisalFormTemplates> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<AppraisalFormTemplates> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<AppraisalFormTemplates> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AppraisalFormTemplates>
			orderByComparator);

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
	public java.util.List<AppraisalFormTemplates> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AppraisalFormTemplates>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first appraisal form templates in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appraisal form templates
	 * @throws NoSuchAppraisalFormTemplatesException if a matching appraisal form templates could not be found
	 */
	public AppraisalFormTemplates findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<AppraisalFormTemplates> orderByComparator)
		throws NoSuchAppraisalFormTemplatesException;

	/**
	 * Returns the first appraisal form templates in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appraisal form templates, or <code>null</code> if a matching appraisal form templates could not be found
	 */
	public AppraisalFormTemplates fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<AppraisalFormTemplates>
			orderByComparator);

	/**
	 * Returns the last appraisal form templates in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appraisal form templates
	 * @throws NoSuchAppraisalFormTemplatesException if a matching appraisal form templates could not be found
	 */
	public AppraisalFormTemplates findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<AppraisalFormTemplates> orderByComparator)
		throws NoSuchAppraisalFormTemplatesException;

	/**
	 * Returns the last appraisal form templates in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appraisal form templates, or <code>null</code> if a matching appraisal form templates could not be found
	 */
	public AppraisalFormTemplates fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<AppraisalFormTemplates>
			orderByComparator);

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
	public AppraisalFormTemplates[] findByUuid_C_PrevAndNext(
			long appraisalFormTemplateId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<AppraisalFormTemplates> orderByComparator)
		throws NoSuchAppraisalFormTemplatesException;

	/**
	 * Removes all the appraisal form templateses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of appraisal form templateses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching appraisal form templateses
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns the appraisal form templates where templateYear = &#63; and templateLevelId = &#63; or throws a <code>NoSuchAppraisalFormTemplatesException</code> if it could not be found.
	 *
	 * @param templateYear the template year
	 * @param templateLevelId the template level ID
	 * @return the matching appraisal form templates
	 * @throws NoSuchAppraisalFormTemplatesException if a matching appraisal form templates could not be found
	 */
	public AppraisalFormTemplates findByTemplateYearAndTemplateLevelId(
			String templateYear, long templateLevelId)
		throws NoSuchAppraisalFormTemplatesException;

	/**
	 * Returns the appraisal form templates where templateYear = &#63; and templateLevelId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param templateYear the template year
	 * @param templateLevelId the template level ID
	 * @return the matching appraisal form templates, or <code>null</code> if a matching appraisal form templates could not be found
	 */
	public AppraisalFormTemplates fetchByTemplateYearAndTemplateLevelId(
		String templateYear, long templateLevelId);

	/**
	 * Returns the appraisal form templates where templateYear = &#63; and templateLevelId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param templateYear the template year
	 * @param templateLevelId the template level ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching appraisal form templates, or <code>null</code> if a matching appraisal form templates could not be found
	 */
	public AppraisalFormTemplates fetchByTemplateYearAndTemplateLevelId(
		String templateYear, long templateLevelId, boolean useFinderCache);

	/**
	 * Removes the appraisal form templates where templateYear = &#63; and templateLevelId = &#63; from the database.
	 *
	 * @param templateYear the template year
	 * @param templateLevelId the template level ID
	 * @return the appraisal form templates that was removed
	 */
	public AppraisalFormTemplates removeByTemplateYearAndTemplateLevelId(
			String templateYear, long templateLevelId)
		throws NoSuchAppraisalFormTemplatesException;

	/**
	 * Returns the number of appraisal form templateses where templateYear = &#63; and templateLevelId = &#63;.
	 *
	 * @param templateYear the template year
	 * @param templateLevelId the template level ID
	 * @return the number of matching appraisal form templateses
	 */
	public int countByTemplateYearAndTemplateLevelId(
		String templateYear, long templateLevelId);

	/**
	 * Returns the appraisal form templates where templateLevelId = &#63; and templateYear = &#63; or throws a <code>NoSuchAppraisalFormTemplatesException</code> if it could not be found.
	 *
	 * @param templateLevelId the template level ID
	 * @param templateYear the template year
	 * @return the matching appraisal form templates
	 * @throws NoSuchAppraisalFormTemplatesException if a matching appraisal form templates could not be found
	 */
	public AppraisalFormTemplates findByTemplateLevelIdAndTemplateYear(
			long templateLevelId, String templateYear)
		throws NoSuchAppraisalFormTemplatesException;

	/**
	 * Returns the appraisal form templates where templateLevelId = &#63; and templateYear = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param templateLevelId the template level ID
	 * @param templateYear the template year
	 * @return the matching appraisal form templates, or <code>null</code> if a matching appraisal form templates could not be found
	 */
	public AppraisalFormTemplates fetchByTemplateLevelIdAndTemplateYear(
		long templateLevelId, String templateYear);

	/**
	 * Returns the appraisal form templates where templateLevelId = &#63; and templateYear = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param templateLevelId the template level ID
	 * @param templateYear the template year
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching appraisal form templates, or <code>null</code> if a matching appraisal form templates could not be found
	 */
	public AppraisalFormTemplates fetchByTemplateLevelIdAndTemplateYear(
		long templateLevelId, String templateYear, boolean useFinderCache);

	/**
	 * Removes the appraisal form templates where templateLevelId = &#63; and templateYear = &#63; from the database.
	 *
	 * @param templateLevelId the template level ID
	 * @param templateYear the template year
	 * @return the appraisal form templates that was removed
	 */
	public AppraisalFormTemplates removeByTemplateLevelIdAndTemplateYear(
			long templateLevelId, String templateYear)
		throws NoSuchAppraisalFormTemplatesException;

	/**
	 * Returns the number of appraisal form templateses where templateLevelId = &#63; and templateYear = &#63;.
	 *
	 * @param templateLevelId the template level ID
	 * @param templateYear the template year
	 * @return the number of matching appraisal form templateses
	 */
	public int countByTemplateLevelIdAndTemplateYear(
		long templateLevelId, String templateYear);

	/**
	 * Caches the appraisal form templates in the entity cache if it is enabled.
	 *
	 * @param appraisalFormTemplates the appraisal form templates
	 */
	public void cacheResult(AppraisalFormTemplates appraisalFormTemplates);

	/**
	 * Caches the appraisal form templateses in the entity cache if it is enabled.
	 *
	 * @param appraisalFormTemplateses the appraisal form templateses
	 */
	public void cacheResult(
		java.util.List<AppraisalFormTemplates> appraisalFormTemplateses);

	/**
	 * Creates a new appraisal form templates with the primary key. Does not add the appraisal form templates to the database.
	 *
	 * @param appraisalFormTemplateId the primary key for the new appraisal form templates
	 * @return the new appraisal form templates
	 */
	public AppraisalFormTemplates create(long appraisalFormTemplateId);

	/**
	 * Removes the appraisal form templates with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param appraisalFormTemplateId the primary key of the appraisal form templates
	 * @return the appraisal form templates that was removed
	 * @throws NoSuchAppraisalFormTemplatesException if a appraisal form templates with the primary key could not be found
	 */
	public AppraisalFormTemplates remove(long appraisalFormTemplateId)
		throws NoSuchAppraisalFormTemplatesException;

	public AppraisalFormTemplates updateImpl(
		AppraisalFormTemplates appraisalFormTemplates);

	/**
	 * Returns the appraisal form templates with the primary key or throws a <code>NoSuchAppraisalFormTemplatesException</code> if it could not be found.
	 *
	 * @param appraisalFormTemplateId the primary key of the appraisal form templates
	 * @return the appraisal form templates
	 * @throws NoSuchAppraisalFormTemplatesException if a appraisal form templates with the primary key could not be found
	 */
	public AppraisalFormTemplates findByPrimaryKey(long appraisalFormTemplateId)
		throws NoSuchAppraisalFormTemplatesException;

	/**
	 * Returns the appraisal form templates with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param appraisalFormTemplateId the primary key of the appraisal form templates
	 * @return the appraisal form templates, or <code>null</code> if a appraisal form templates with the primary key could not be found
	 */
	public AppraisalFormTemplates fetchByPrimaryKey(
		long appraisalFormTemplateId);

	/**
	 * Returns all the appraisal form templateses.
	 *
	 * @return the appraisal form templateses
	 */
	public java.util.List<AppraisalFormTemplates> findAll();

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
	public java.util.List<AppraisalFormTemplates> findAll(int start, int end);

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
	public java.util.List<AppraisalFormTemplates> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AppraisalFormTemplates>
			orderByComparator);

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
	public java.util.List<AppraisalFormTemplates> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AppraisalFormTemplates>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the appraisal form templateses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of appraisal form templateses.
	 *
	 * @return the number of appraisal form templateses
	 */
	public int countAll();

}