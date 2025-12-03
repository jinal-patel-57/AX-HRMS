/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence;

import com.ax.hrms.model.Attachment;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the attachment service. This utility wraps <code>com.ax.hrms.service.persistence.impl.AttachmentPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AttachmentPersistence
 * @generated
 */
public class AttachmentUtil {

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
	public static void clearCache(Attachment attachment) {
		getPersistence().clearCache(attachment);
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
	public static Map<Serializable, Attachment> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Attachment> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Attachment> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Attachment> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Attachment> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Attachment update(Attachment attachment) {
		return getPersistence().update(attachment);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Attachment update(
		Attachment attachment, ServiceContext serviceContext) {

		return getPersistence().update(attachment, serviceContext);
	}

	/**
	 * Returns all the attachments where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching attachments
	 */
	public static List<Attachment> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the attachments where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AttachmentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of attachments
	 * @param end the upper bound of the range of attachments (not inclusive)
	 * @return the range of matching attachments
	 */
	public static List<Attachment> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the attachments where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AttachmentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of attachments
	 * @param end the upper bound of the range of attachments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching attachments
	 */
	public static List<Attachment> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Attachment> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the attachments where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AttachmentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of attachments
	 * @param end the upper bound of the range of attachments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching attachments
	 */
	public static List<Attachment> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Attachment> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first attachment in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching attachment
	 * @throws NoSuchAttachmentException if a matching attachment could not be found
	 */
	public static Attachment findByUuid_First(
			String uuid, OrderByComparator<Attachment> orderByComparator)
		throws com.ax.hrms.exception.NoSuchAttachmentException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first attachment in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching attachment, or <code>null</code> if a matching attachment could not be found
	 */
	public static Attachment fetchByUuid_First(
		String uuid, OrderByComparator<Attachment> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last attachment in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching attachment
	 * @throws NoSuchAttachmentException if a matching attachment could not be found
	 */
	public static Attachment findByUuid_Last(
			String uuid, OrderByComparator<Attachment> orderByComparator)
		throws com.ax.hrms.exception.NoSuchAttachmentException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last attachment in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching attachment, or <code>null</code> if a matching attachment could not be found
	 */
	public static Attachment fetchByUuid_Last(
		String uuid, OrderByComparator<Attachment> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the attachments before and after the current attachment in the ordered set where uuid = &#63;.
	 *
	 * @param attachmentId the primary key of the current attachment
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next attachment
	 * @throws NoSuchAttachmentException if a attachment with the primary key could not be found
	 */
	public static Attachment[] findByUuid_PrevAndNext(
			long attachmentId, String uuid,
			OrderByComparator<Attachment> orderByComparator)
		throws com.ax.hrms.exception.NoSuchAttachmentException {

		return getPersistence().findByUuid_PrevAndNext(
			attachmentId, uuid, orderByComparator);
	}

	/**
	 * Removes all the attachments where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of attachments where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching attachments
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the attachment where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchAttachmentException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching attachment
	 * @throws NoSuchAttachmentException if a matching attachment could not be found
	 */
	public static Attachment findByUUID_G(String uuid, long groupId)
		throws com.ax.hrms.exception.NoSuchAttachmentException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the attachment where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching attachment, or <code>null</code> if a matching attachment could not be found
	 */
	public static Attachment fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the attachment where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching attachment, or <code>null</code> if a matching attachment could not be found
	 */
	public static Attachment fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the attachment where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the attachment that was removed
	 */
	public static Attachment removeByUUID_G(String uuid, long groupId)
		throws com.ax.hrms.exception.NoSuchAttachmentException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of attachments where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching attachments
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the attachments where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching attachments
	 */
	public static List<Attachment> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the attachments where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AttachmentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of attachments
	 * @param end the upper bound of the range of attachments (not inclusive)
	 * @return the range of matching attachments
	 */
	public static List<Attachment> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the attachments where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AttachmentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of attachments
	 * @param end the upper bound of the range of attachments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching attachments
	 */
	public static List<Attachment> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Attachment> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the attachments where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AttachmentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of attachments
	 * @param end the upper bound of the range of attachments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching attachments
	 */
	public static List<Attachment> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Attachment> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first attachment in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching attachment
	 * @throws NoSuchAttachmentException if a matching attachment could not be found
	 */
	public static Attachment findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Attachment> orderByComparator)
		throws com.ax.hrms.exception.NoSuchAttachmentException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first attachment in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching attachment, or <code>null</code> if a matching attachment could not be found
	 */
	public static Attachment fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Attachment> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last attachment in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching attachment
	 * @throws NoSuchAttachmentException if a matching attachment could not be found
	 */
	public static Attachment findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Attachment> orderByComparator)
		throws com.ax.hrms.exception.NoSuchAttachmentException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last attachment in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching attachment, or <code>null</code> if a matching attachment could not be found
	 */
	public static Attachment fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Attachment> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the attachments before and after the current attachment in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param attachmentId the primary key of the current attachment
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next attachment
	 * @throws NoSuchAttachmentException if a attachment with the primary key could not be found
	 */
	public static Attachment[] findByUuid_C_PrevAndNext(
			long attachmentId, String uuid, long companyId,
			OrderByComparator<Attachment> orderByComparator)
		throws com.ax.hrms.exception.NoSuchAttachmentException {

		return getPersistence().findByUuid_C_PrevAndNext(
			attachmentId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the attachments where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of attachments where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching attachments
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the attachments where timeTrackerId = &#63;.
	 *
	 * @param timeTrackerId the time tracker ID
	 * @return the matching attachments
	 */
	public static List<Attachment> findByTimeTrackerId(long timeTrackerId) {
		return getPersistence().findByTimeTrackerId(timeTrackerId);
	}

	/**
	 * Returns a range of all the attachments where timeTrackerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AttachmentModelImpl</code>.
	 * </p>
	 *
	 * @param timeTrackerId the time tracker ID
	 * @param start the lower bound of the range of attachments
	 * @param end the upper bound of the range of attachments (not inclusive)
	 * @return the range of matching attachments
	 */
	public static List<Attachment> findByTimeTrackerId(
		long timeTrackerId, int start, int end) {

		return getPersistence().findByTimeTrackerId(timeTrackerId, start, end);
	}

	/**
	 * Returns an ordered range of all the attachments where timeTrackerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AttachmentModelImpl</code>.
	 * </p>
	 *
	 * @param timeTrackerId the time tracker ID
	 * @param start the lower bound of the range of attachments
	 * @param end the upper bound of the range of attachments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching attachments
	 */
	public static List<Attachment> findByTimeTrackerId(
		long timeTrackerId, int start, int end,
		OrderByComparator<Attachment> orderByComparator) {

		return getPersistence().findByTimeTrackerId(
			timeTrackerId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the attachments where timeTrackerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AttachmentModelImpl</code>.
	 * </p>
	 *
	 * @param timeTrackerId the time tracker ID
	 * @param start the lower bound of the range of attachments
	 * @param end the upper bound of the range of attachments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching attachments
	 */
	public static List<Attachment> findByTimeTrackerId(
		long timeTrackerId, int start, int end,
		OrderByComparator<Attachment> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByTimeTrackerId(
			timeTrackerId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first attachment in the ordered set where timeTrackerId = &#63;.
	 *
	 * @param timeTrackerId the time tracker ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching attachment
	 * @throws NoSuchAttachmentException if a matching attachment could not be found
	 */
	public static Attachment findByTimeTrackerId_First(
			long timeTrackerId, OrderByComparator<Attachment> orderByComparator)
		throws com.ax.hrms.exception.NoSuchAttachmentException {

		return getPersistence().findByTimeTrackerId_First(
			timeTrackerId, orderByComparator);
	}

	/**
	 * Returns the first attachment in the ordered set where timeTrackerId = &#63;.
	 *
	 * @param timeTrackerId the time tracker ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching attachment, or <code>null</code> if a matching attachment could not be found
	 */
	public static Attachment fetchByTimeTrackerId_First(
		long timeTrackerId, OrderByComparator<Attachment> orderByComparator) {

		return getPersistence().fetchByTimeTrackerId_First(
			timeTrackerId, orderByComparator);
	}

	/**
	 * Returns the last attachment in the ordered set where timeTrackerId = &#63;.
	 *
	 * @param timeTrackerId the time tracker ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching attachment
	 * @throws NoSuchAttachmentException if a matching attachment could not be found
	 */
	public static Attachment findByTimeTrackerId_Last(
			long timeTrackerId, OrderByComparator<Attachment> orderByComparator)
		throws com.ax.hrms.exception.NoSuchAttachmentException {

		return getPersistence().findByTimeTrackerId_Last(
			timeTrackerId, orderByComparator);
	}

	/**
	 * Returns the last attachment in the ordered set where timeTrackerId = &#63;.
	 *
	 * @param timeTrackerId the time tracker ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching attachment, or <code>null</code> if a matching attachment could not be found
	 */
	public static Attachment fetchByTimeTrackerId_Last(
		long timeTrackerId, OrderByComparator<Attachment> orderByComparator) {

		return getPersistence().fetchByTimeTrackerId_Last(
			timeTrackerId, orderByComparator);
	}

	/**
	 * Returns the attachments before and after the current attachment in the ordered set where timeTrackerId = &#63;.
	 *
	 * @param attachmentId the primary key of the current attachment
	 * @param timeTrackerId the time tracker ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next attachment
	 * @throws NoSuchAttachmentException if a attachment with the primary key could not be found
	 */
	public static Attachment[] findByTimeTrackerId_PrevAndNext(
			long attachmentId, long timeTrackerId,
			OrderByComparator<Attachment> orderByComparator)
		throws com.ax.hrms.exception.NoSuchAttachmentException {

		return getPersistence().findByTimeTrackerId_PrevAndNext(
			attachmentId, timeTrackerId, orderByComparator);
	}

	/**
	 * Removes all the attachments where timeTrackerId = &#63; from the database.
	 *
	 * @param timeTrackerId the time tracker ID
	 */
	public static void removeByTimeTrackerId(long timeTrackerId) {
		getPersistence().removeByTimeTrackerId(timeTrackerId);
	}

	/**
	 * Returns the number of attachments where timeTrackerId = &#63;.
	 *
	 * @param timeTrackerId the time tracker ID
	 * @return the number of matching attachments
	 */
	public static int countByTimeTrackerId(long timeTrackerId) {
		return getPersistence().countByTimeTrackerId(timeTrackerId);
	}

	/**
	 * Caches the attachment in the entity cache if it is enabled.
	 *
	 * @param attachment the attachment
	 */
	public static void cacheResult(Attachment attachment) {
		getPersistence().cacheResult(attachment);
	}

	/**
	 * Caches the attachments in the entity cache if it is enabled.
	 *
	 * @param attachments the attachments
	 */
	public static void cacheResult(List<Attachment> attachments) {
		getPersistence().cacheResult(attachments);
	}

	/**
	 * Creates a new attachment with the primary key. Does not add the attachment to the database.
	 *
	 * @param attachmentId the primary key for the new attachment
	 * @return the new attachment
	 */
	public static Attachment create(long attachmentId) {
		return getPersistence().create(attachmentId);
	}

	/**
	 * Removes the attachment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param attachmentId the primary key of the attachment
	 * @return the attachment that was removed
	 * @throws NoSuchAttachmentException if a attachment with the primary key could not be found
	 */
	public static Attachment remove(long attachmentId)
		throws com.ax.hrms.exception.NoSuchAttachmentException {

		return getPersistence().remove(attachmentId);
	}

	public static Attachment updateImpl(Attachment attachment) {
		return getPersistence().updateImpl(attachment);
	}

	/**
	 * Returns the attachment with the primary key or throws a <code>NoSuchAttachmentException</code> if it could not be found.
	 *
	 * @param attachmentId the primary key of the attachment
	 * @return the attachment
	 * @throws NoSuchAttachmentException if a attachment with the primary key could not be found
	 */
	public static Attachment findByPrimaryKey(long attachmentId)
		throws com.ax.hrms.exception.NoSuchAttachmentException {

		return getPersistence().findByPrimaryKey(attachmentId);
	}

	/**
	 * Returns the attachment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param attachmentId the primary key of the attachment
	 * @return the attachment, or <code>null</code> if a attachment with the primary key could not be found
	 */
	public static Attachment fetchByPrimaryKey(long attachmentId) {
		return getPersistence().fetchByPrimaryKey(attachmentId);
	}

	/**
	 * Returns all the attachments.
	 *
	 * @return the attachments
	 */
	public static List<Attachment> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the attachments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AttachmentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of attachments
	 * @param end the upper bound of the range of attachments (not inclusive)
	 * @return the range of attachments
	 */
	public static List<Attachment> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the attachments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AttachmentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of attachments
	 * @param end the upper bound of the range of attachments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of attachments
	 */
	public static List<Attachment> findAll(
		int start, int end, OrderByComparator<Attachment> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the attachments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AttachmentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of attachments
	 * @param end the upper bound of the range of attachments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of attachments
	 */
	public static List<Attachment> findAll(
		int start, int end, OrderByComparator<Attachment> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the attachments from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of attachments.
	 *
	 * @return the number of attachments
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static AttachmentPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(AttachmentPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile AttachmentPersistence _persistence;

}