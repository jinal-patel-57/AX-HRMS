/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence;

import com.ax.hrms.model.Comment;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the comment service. This utility wraps <code>com.ax.hrms.service.persistence.impl.CommentPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CommentPersistence
 * @generated
 */
public class CommentUtil {

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
	public static void clearCache(Comment comment) {
		getPersistence().clearCache(comment);
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
	public static Map<Serializable, Comment> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Comment> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Comment> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Comment> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Comment> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Comment update(Comment comment) {
		return getPersistence().update(comment);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Comment update(
		Comment comment, ServiceContext serviceContext) {

		return getPersistence().update(comment, serviceContext);
	}

	/**
	 * Returns all the comments where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching comments
	 */
	public static List<Comment> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the comments where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of comments
	 * @param end the upper bound of the range of comments (not inclusive)
	 * @return the range of matching comments
	 */
	public static List<Comment> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the comments where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of comments
	 * @param end the upper bound of the range of comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching comments
	 */
	public static List<Comment> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Comment> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the comments where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of comments
	 * @param end the upper bound of the range of comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching comments
	 */
	public static List<Comment> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Comment> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first comment in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comment
	 * @throws NoSuchCommentException if a matching comment could not be found
	 */
	public static Comment findByUuid_First(
			String uuid, OrderByComparator<Comment> orderByComparator)
		throws com.ax.hrms.exception.NoSuchCommentException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first comment in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comment, or <code>null</code> if a matching comment could not be found
	 */
	public static Comment fetchByUuid_First(
		String uuid, OrderByComparator<Comment> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last comment in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comment
	 * @throws NoSuchCommentException if a matching comment could not be found
	 */
	public static Comment findByUuid_Last(
			String uuid, OrderByComparator<Comment> orderByComparator)
		throws com.ax.hrms.exception.NoSuchCommentException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last comment in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comment, or <code>null</code> if a matching comment could not be found
	 */
	public static Comment fetchByUuid_Last(
		String uuid, OrderByComparator<Comment> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the comments before and after the current comment in the ordered set where uuid = &#63;.
	 *
	 * @param commentId the primary key of the current comment
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next comment
	 * @throws NoSuchCommentException if a comment with the primary key could not be found
	 */
	public static Comment[] findByUuid_PrevAndNext(
			long commentId, String uuid,
			OrderByComparator<Comment> orderByComparator)
		throws com.ax.hrms.exception.NoSuchCommentException {

		return getPersistence().findByUuid_PrevAndNext(
			commentId, uuid, orderByComparator);
	}

	/**
	 * Removes all the comments where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of comments where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching comments
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the comment where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchCommentException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching comment
	 * @throws NoSuchCommentException if a matching comment could not be found
	 */
	public static Comment findByUUID_G(String uuid, long groupId)
		throws com.ax.hrms.exception.NoSuchCommentException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the comment where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching comment, or <code>null</code> if a matching comment could not be found
	 */
	public static Comment fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the comment where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching comment, or <code>null</code> if a matching comment could not be found
	 */
	public static Comment fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the comment where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the comment that was removed
	 */
	public static Comment removeByUUID_G(String uuid, long groupId)
		throws com.ax.hrms.exception.NoSuchCommentException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of comments where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching comments
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the comments where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching comments
	 */
	public static List<Comment> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the comments where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of comments
	 * @param end the upper bound of the range of comments (not inclusive)
	 * @return the range of matching comments
	 */
	public static List<Comment> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the comments where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of comments
	 * @param end the upper bound of the range of comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching comments
	 */
	public static List<Comment> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Comment> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the comments where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of comments
	 * @param end the upper bound of the range of comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching comments
	 */
	public static List<Comment> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Comment> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first comment in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comment
	 * @throws NoSuchCommentException if a matching comment could not be found
	 */
	public static Comment findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Comment> orderByComparator)
		throws com.ax.hrms.exception.NoSuchCommentException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first comment in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comment, or <code>null</code> if a matching comment could not be found
	 */
	public static Comment fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Comment> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last comment in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comment
	 * @throws NoSuchCommentException if a matching comment could not be found
	 */
	public static Comment findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Comment> orderByComparator)
		throws com.ax.hrms.exception.NoSuchCommentException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last comment in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comment, or <code>null</code> if a matching comment could not be found
	 */
	public static Comment fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Comment> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the comments before and after the current comment in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param commentId the primary key of the current comment
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next comment
	 * @throws NoSuchCommentException if a comment with the primary key could not be found
	 */
	public static Comment[] findByUuid_C_PrevAndNext(
			long commentId, String uuid, long companyId,
			OrderByComparator<Comment> orderByComparator)
		throws com.ax.hrms.exception.NoSuchCommentException {

		return getPersistence().findByUuid_C_PrevAndNext(
			commentId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the comments where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of comments where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching comments
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the comments where type = &#63;.
	 *
	 * @param type the type
	 * @return the matching comments
	 */
	public static List<Comment> findByType(long type) {
		return getPersistence().findByType(type);
	}

	/**
	 * Returns a range of all the comments where type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentModelImpl</code>.
	 * </p>
	 *
	 * @param type the type
	 * @param start the lower bound of the range of comments
	 * @param end the upper bound of the range of comments (not inclusive)
	 * @return the range of matching comments
	 */
	public static List<Comment> findByType(long type, int start, int end) {
		return getPersistence().findByType(type, start, end);
	}

	/**
	 * Returns an ordered range of all the comments where type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentModelImpl</code>.
	 * </p>
	 *
	 * @param type the type
	 * @param start the lower bound of the range of comments
	 * @param end the upper bound of the range of comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching comments
	 */
	public static List<Comment> findByType(
		long type, int start, int end,
		OrderByComparator<Comment> orderByComparator) {

		return getPersistence().findByType(type, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the comments where type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentModelImpl</code>.
	 * </p>
	 *
	 * @param type the type
	 * @param start the lower bound of the range of comments
	 * @param end the upper bound of the range of comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching comments
	 */
	public static List<Comment> findByType(
		long type, int start, int end,
		OrderByComparator<Comment> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByType(
			type, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first comment in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comment
	 * @throws NoSuchCommentException if a matching comment could not be found
	 */
	public static Comment findByType_First(
			long type, OrderByComparator<Comment> orderByComparator)
		throws com.ax.hrms.exception.NoSuchCommentException {

		return getPersistence().findByType_First(type, orderByComparator);
	}

	/**
	 * Returns the first comment in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comment, or <code>null</code> if a matching comment could not be found
	 */
	public static Comment fetchByType_First(
		long type, OrderByComparator<Comment> orderByComparator) {

		return getPersistence().fetchByType_First(type, orderByComparator);
	}

	/**
	 * Returns the last comment in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comment
	 * @throws NoSuchCommentException if a matching comment could not be found
	 */
	public static Comment findByType_Last(
			long type, OrderByComparator<Comment> orderByComparator)
		throws com.ax.hrms.exception.NoSuchCommentException {

		return getPersistence().findByType_Last(type, orderByComparator);
	}

	/**
	 * Returns the last comment in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comment, or <code>null</code> if a matching comment could not be found
	 */
	public static Comment fetchByType_Last(
		long type, OrderByComparator<Comment> orderByComparator) {

		return getPersistence().fetchByType_Last(type, orderByComparator);
	}

	/**
	 * Returns the comments before and after the current comment in the ordered set where type = &#63;.
	 *
	 * @param commentId the primary key of the current comment
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next comment
	 * @throws NoSuchCommentException if a comment with the primary key could not be found
	 */
	public static Comment[] findByType_PrevAndNext(
			long commentId, long type,
			OrderByComparator<Comment> orderByComparator)
		throws com.ax.hrms.exception.NoSuchCommentException {

		return getPersistence().findByType_PrevAndNext(
			commentId, type, orderByComparator);
	}

	/**
	 * Removes all the comments where type = &#63; from the database.
	 *
	 * @param type the type
	 */
	public static void removeByType(long type) {
		getPersistence().removeByType(type);
	}

	/**
	 * Returns the number of comments where type = &#63;.
	 *
	 * @param type the type
	 * @return the number of matching comments
	 */
	public static int countByType(long type) {
		return getPersistence().countByType(type);
	}

	/**
	 * Returns all the comments where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching comments
	 */
	public static List<Comment> findByStatus(boolean status) {
		return getPersistence().findByStatus(status);
	}

	/**
	 * Returns a range of all the comments where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of comments
	 * @param end the upper bound of the range of comments (not inclusive)
	 * @return the range of matching comments
	 */
	public static List<Comment> findByStatus(
		boolean status, int start, int end) {

		return getPersistence().findByStatus(status, start, end);
	}

	/**
	 * Returns an ordered range of all the comments where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of comments
	 * @param end the upper bound of the range of comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching comments
	 */
	public static List<Comment> findByStatus(
		boolean status, int start, int end,
		OrderByComparator<Comment> orderByComparator) {

		return getPersistence().findByStatus(
			status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the comments where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of comments
	 * @param end the upper bound of the range of comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching comments
	 */
	public static List<Comment> findByStatus(
		boolean status, int start, int end,
		OrderByComparator<Comment> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByStatus(
			status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first comment in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comment
	 * @throws NoSuchCommentException if a matching comment could not be found
	 */
	public static Comment findByStatus_First(
			boolean status, OrderByComparator<Comment> orderByComparator)
		throws com.ax.hrms.exception.NoSuchCommentException {

		return getPersistence().findByStatus_First(status, orderByComparator);
	}

	/**
	 * Returns the first comment in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comment, or <code>null</code> if a matching comment could not be found
	 */
	public static Comment fetchByStatus_First(
		boolean status, OrderByComparator<Comment> orderByComparator) {

		return getPersistence().fetchByStatus_First(status, orderByComparator);
	}

	/**
	 * Returns the last comment in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comment
	 * @throws NoSuchCommentException if a matching comment could not be found
	 */
	public static Comment findByStatus_Last(
			boolean status, OrderByComparator<Comment> orderByComparator)
		throws com.ax.hrms.exception.NoSuchCommentException {

		return getPersistence().findByStatus_Last(status, orderByComparator);
	}

	/**
	 * Returns the last comment in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comment, or <code>null</code> if a matching comment could not be found
	 */
	public static Comment fetchByStatus_Last(
		boolean status, OrderByComparator<Comment> orderByComparator) {

		return getPersistence().fetchByStatus_Last(status, orderByComparator);
	}

	/**
	 * Returns the comments before and after the current comment in the ordered set where status = &#63;.
	 *
	 * @param commentId the primary key of the current comment
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next comment
	 * @throws NoSuchCommentException if a comment with the primary key could not be found
	 */
	public static Comment[] findByStatus_PrevAndNext(
			long commentId, boolean status,
			OrderByComparator<Comment> orderByComparator)
		throws com.ax.hrms.exception.NoSuchCommentException {

		return getPersistence().findByStatus_PrevAndNext(
			commentId, status, orderByComparator);
	}

	/**
	 * Removes all the comments where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public static void removeByStatus(boolean status) {
		getPersistence().removeByStatus(status);
	}

	/**
	 * Returns the number of comments where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching comments
	 */
	public static int countByStatus(boolean status) {
		return getPersistence().countByStatus(status);
	}

	/**
	 * Returns all the comments where requestId = &#63;.
	 *
	 * @param requestId the request ID
	 * @return the matching comments
	 */
	public static List<Comment> findByRequestId(long requestId) {
		return getPersistence().findByRequestId(requestId);
	}

	/**
	 * Returns a range of all the comments where requestId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentModelImpl</code>.
	 * </p>
	 *
	 * @param requestId the request ID
	 * @param start the lower bound of the range of comments
	 * @param end the upper bound of the range of comments (not inclusive)
	 * @return the range of matching comments
	 */
	public static List<Comment> findByRequestId(
		long requestId, int start, int end) {

		return getPersistence().findByRequestId(requestId, start, end);
	}

	/**
	 * Returns an ordered range of all the comments where requestId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentModelImpl</code>.
	 * </p>
	 *
	 * @param requestId the request ID
	 * @param start the lower bound of the range of comments
	 * @param end the upper bound of the range of comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching comments
	 */
	public static List<Comment> findByRequestId(
		long requestId, int start, int end,
		OrderByComparator<Comment> orderByComparator) {

		return getPersistence().findByRequestId(
			requestId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the comments where requestId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentModelImpl</code>.
	 * </p>
	 *
	 * @param requestId the request ID
	 * @param start the lower bound of the range of comments
	 * @param end the upper bound of the range of comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching comments
	 */
	public static List<Comment> findByRequestId(
		long requestId, int start, int end,
		OrderByComparator<Comment> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByRequestId(
			requestId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first comment in the ordered set where requestId = &#63;.
	 *
	 * @param requestId the request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comment
	 * @throws NoSuchCommentException if a matching comment could not be found
	 */
	public static Comment findByRequestId_First(
			long requestId, OrderByComparator<Comment> orderByComparator)
		throws com.ax.hrms.exception.NoSuchCommentException {

		return getPersistence().findByRequestId_First(
			requestId, orderByComparator);
	}

	/**
	 * Returns the first comment in the ordered set where requestId = &#63;.
	 *
	 * @param requestId the request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comment, or <code>null</code> if a matching comment could not be found
	 */
	public static Comment fetchByRequestId_First(
		long requestId, OrderByComparator<Comment> orderByComparator) {

		return getPersistence().fetchByRequestId_First(
			requestId, orderByComparator);
	}

	/**
	 * Returns the last comment in the ordered set where requestId = &#63;.
	 *
	 * @param requestId the request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comment
	 * @throws NoSuchCommentException if a matching comment could not be found
	 */
	public static Comment findByRequestId_Last(
			long requestId, OrderByComparator<Comment> orderByComparator)
		throws com.ax.hrms.exception.NoSuchCommentException {

		return getPersistence().findByRequestId_Last(
			requestId, orderByComparator);
	}

	/**
	 * Returns the last comment in the ordered set where requestId = &#63;.
	 *
	 * @param requestId the request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comment, or <code>null</code> if a matching comment could not be found
	 */
	public static Comment fetchByRequestId_Last(
		long requestId, OrderByComparator<Comment> orderByComparator) {

		return getPersistence().fetchByRequestId_Last(
			requestId, orderByComparator);
	}

	/**
	 * Returns the comments before and after the current comment in the ordered set where requestId = &#63;.
	 *
	 * @param commentId the primary key of the current comment
	 * @param requestId the request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next comment
	 * @throws NoSuchCommentException if a comment with the primary key could not be found
	 */
	public static Comment[] findByRequestId_PrevAndNext(
			long commentId, long requestId,
			OrderByComparator<Comment> orderByComparator)
		throws com.ax.hrms.exception.NoSuchCommentException {

		return getPersistence().findByRequestId_PrevAndNext(
			commentId, requestId, orderByComparator);
	}

	/**
	 * Removes all the comments where requestId = &#63; from the database.
	 *
	 * @param requestId the request ID
	 */
	public static void removeByRequestId(long requestId) {
		getPersistence().removeByRequestId(requestId);
	}

	/**
	 * Returns the number of comments where requestId = &#63;.
	 *
	 * @param requestId the request ID
	 * @return the number of matching comments
	 */
	public static int countByRequestId(long requestId) {
		return getPersistence().countByRequestId(requestId);
	}

	/**
	 * Returns all the comments where requestId = &#63; and status = &#63;.
	 *
	 * @param requestId the request ID
	 * @param status the status
	 * @return the matching comments
	 */
	public static List<Comment> findByRequestIdAndStatus(
		long requestId, boolean status) {

		return getPersistence().findByRequestIdAndStatus(requestId, status);
	}

	/**
	 * Returns a range of all the comments where requestId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentModelImpl</code>.
	 * </p>
	 *
	 * @param requestId the request ID
	 * @param status the status
	 * @param start the lower bound of the range of comments
	 * @param end the upper bound of the range of comments (not inclusive)
	 * @return the range of matching comments
	 */
	public static List<Comment> findByRequestIdAndStatus(
		long requestId, boolean status, int start, int end) {

		return getPersistence().findByRequestIdAndStatus(
			requestId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the comments where requestId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentModelImpl</code>.
	 * </p>
	 *
	 * @param requestId the request ID
	 * @param status the status
	 * @param start the lower bound of the range of comments
	 * @param end the upper bound of the range of comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching comments
	 */
	public static List<Comment> findByRequestIdAndStatus(
		long requestId, boolean status, int start, int end,
		OrderByComparator<Comment> orderByComparator) {

		return getPersistence().findByRequestIdAndStatus(
			requestId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the comments where requestId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentModelImpl</code>.
	 * </p>
	 *
	 * @param requestId the request ID
	 * @param status the status
	 * @param start the lower bound of the range of comments
	 * @param end the upper bound of the range of comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching comments
	 */
	public static List<Comment> findByRequestIdAndStatus(
		long requestId, boolean status, int start, int end,
		OrderByComparator<Comment> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByRequestIdAndStatus(
			requestId, status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first comment in the ordered set where requestId = &#63; and status = &#63;.
	 *
	 * @param requestId the request ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comment
	 * @throws NoSuchCommentException if a matching comment could not be found
	 */
	public static Comment findByRequestIdAndStatus_First(
			long requestId, boolean status,
			OrderByComparator<Comment> orderByComparator)
		throws com.ax.hrms.exception.NoSuchCommentException {

		return getPersistence().findByRequestIdAndStatus_First(
			requestId, status, orderByComparator);
	}

	/**
	 * Returns the first comment in the ordered set where requestId = &#63; and status = &#63;.
	 *
	 * @param requestId the request ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comment, or <code>null</code> if a matching comment could not be found
	 */
	public static Comment fetchByRequestIdAndStatus_First(
		long requestId, boolean status,
		OrderByComparator<Comment> orderByComparator) {

		return getPersistence().fetchByRequestIdAndStatus_First(
			requestId, status, orderByComparator);
	}

	/**
	 * Returns the last comment in the ordered set where requestId = &#63; and status = &#63;.
	 *
	 * @param requestId the request ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comment
	 * @throws NoSuchCommentException if a matching comment could not be found
	 */
	public static Comment findByRequestIdAndStatus_Last(
			long requestId, boolean status,
			OrderByComparator<Comment> orderByComparator)
		throws com.ax.hrms.exception.NoSuchCommentException {

		return getPersistence().findByRequestIdAndStatus_Last(
			requestId, status, orderByComparator);
	}

	/**
	 * Returns the last comment in the ordered set where requestId = &#63; and status = &#63;.
	 *
	 * @param requestId the request ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comment, or <code>null</code> if a matching comment could not be found
	 */
	public static Comment fetchByRequestIdAndStatus_Last(
		long requestId, boolean status,
		OrderByComparator<Comment> orderByComparator) {

		return getPersistence().fetchByRequestIdAndStatus_Last(
			requestId, status, orderByComparator);
	}

	/**
	 * Returns the comments before and after the current comment in the ordered set where requestId = &#63; and status = &#63;.
	 *
	 * @param commentId the primary key of the current comment
	 * @param requestId the request ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next comment
	 * @throws NoSuchCommentException if a comment with the primary key could not be found
	 */
	public static Comment[] findByRequestIdAndStatus_PrevAndNext(
			long commentId, long requestId, boolean status,
			OrderByComparator<Comment> orderByComparator)
		throws com.ax.hrms.exception.NoSuchCommentException {

		return getPersistence().findByRequestIdAndStatus_PrevAndNext(
			commentId, requestId, status, orderByComparator);
	}

	/**
	 * Removes all the comments where requestId = &#63; and status = &#63; from the database.
	 *
	 * @param requestId the request ID
	 * @param status the status
	 */
	public static void removeByRequestIdAndStatus(
		long requestId, boolean status) {

		getPersistence().removeByRequestIdAndStatus(requestId, status);
	}

	/**
	 * Returns the number of comments where requestId = &#63; and status = &#63;.
	 *
	 * @param requestId the request ID
	 * @param status the status
	 * @return the number of matching comments
	 */
	public static int countByRequestIdAndStatus(
		long requestId, boolean status) {

		return getPersistence().countByRequestIdAndStatus(requestId, status);
	}

	/**
	 * Returns all the comments where type = &#63; and requestId = &#63; and status = &#63;.
	 *
	 * @param type the type
	 * @param requestId the request ID
	 * @param status the status
	 * @return the matching comments
	 */
	public static List<Comment> findByTypeRequestIdAndStatus(
		long type, long requestId, boolean status) {

		return getPersistence().findByTypeRequestIdAndStatus(
			type, requestId, status);
	}

	/**
	 * Returns a range of all the comments where type = &#63; and requestId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentModelImpl</code>.
	 * </p>
	 *
	 * @param type the type
	 * @param requestId the request ID
	 * @param status the status
	 * @param start the lower bound of the range of comments
	 * @param end the upper bound of the range of comments (not inclusive)
	 * @return the range of matching comments
	 */
	public static List<Comment> findByTypeRequestIdAndStatus(
		long type, long requestId, boolean status, int start, int end) {

		return getPersistence().findByTypeRequestIdAndStatus(
			type, requestId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the comments where type = &#63; and requestId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentModelImpl</code>.
	 * </p>
	 *
	 * @param type the type
	 * @param requestId the request ID
	 * @param status the status
	 * @param start the lower bound of the range of comments
	 * @param end the upper bound of the range of comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching comments
	 */
	public static List<Comment> findByTypeRequestIdAndStatus(
		long type, long requestId, boolean status, int start, int end,
		OrderByComparator<Comment> orderByComparator) {

		return getPersistence().findByTypeRequestIdAndStatus(
			type, requestId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the comments where type = &#63; and requestId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentModelImpl</code>.
	 * </p>
	 *
	 * @param type the type
	 * @param requestId the request ID
	 * @param status the status
	 * @param start the lower bound of the range of comments
	 * @param end the upper bound of the range of comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching comments
	 */
	public static List<Comment> findByTypeRequestIdAndStatus(
		long type, long requestId, boolean status, int start, int end,
		OrderByComparator<Comment> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByTypeRequestIdAndStatus(
			type, requestId, status, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first comment in the ordered set where type = &#63; and requestId = &#63; and status = &#63;.
	 *
	 * @param type the type
	 * @param requestId the request ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comment
	 * @throws NoSuchCommentException if a matching comment could not be found
	 */
	public static Comment findByTypeRequestIdAndStatus_First(
			long type, long requestId, boolean status,
			OrderByComparator<Comment> orderByComparator)
		throws com.ax.hrms.exception.NoSuchCommentException {

		return getPersistence().findByTypeRequestIdAndStatus_First(
			type, requestId, status, orderByComparator);
	}

	/**
	 * Returns the first comment in the ordered set where type = &#63; and requestId = &#63; and status = &#63;.
	 *
	 * @param type the type
	 * @param requestId the request ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comment, or <code>null</code> if a matching comment could not be found
	 */
	public static Comment fetchByTypeRequestIdAndStatus_First(
		long type, long requestId, boolean status,
		OrderByComparator<Comment> orderByComparator) {

		return getPersistence().fetchByTypeRequestIdAndStatus_First(
			type, requestId, status, orderByComparator);
	}

	/**
	 * Returns the last comment in the ordered set where type = &#63; and requestId = &#63; and status = &#63;.
	 *
	 * @param type the type
	 * @param requestId the request ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comment
	 * @throws NoSuchCommentException if a matching comment could not be found
	 */
	public static Comment findByTypeRequestIdAndStatus_Last(
			long type, long requestId, boolean status,
			OrderByComparator<Comment> orderByComparator)
		throws com.ax.hrms.exception.NoSuchCommentException {

		return getPersistence().findByTypeRequestIdAndStatus_Last(
			type, requestId, status, orderByComparator);
	}

	/**
	 * Returns the last comment in the ordered set where type = &#63; and requestId = &#63; and status = &#63;.
	 *
	 * @param type the type
	 * @param requestId the request ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comment, or <code>null</code> if a matching comment could not be found
	 */
	public static Comment fetchByTypeRequestIdAndStatus_Last(
		long type, long requestId, boolean status,
		OrderByComparator<Comment> orderByComparator) {

		return getPersistence().fetchByTypeRequestIdAndStatus_Last(
			type, requestId, status, orderByComparator);
	}

	/**
	 * Returns the comments before and after the current comment in the ordered set where type = &#63; and requestId = &#63; and status = &#63;.
	 *
	 * @param commentId the primary key of the current comment
	 * @param type the type
	 * @param requestId the request ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next comment
	 * @throws NoSuchCommentException if a comment with the primary key could not be found
	 */
	public static Comment[] findByTypeRequestIdAndStatus_PrevAndNext(
			long commentId, long type, long requestId, boolean status,
			OrderByComparator<Comment> orderByComparator)
		throws com.ax.hrms.exception.NoSuchCommentException {

		return getPersistence().findByTypeRequestIdAndStatus_PrevAndNext(
			commentId, type, requestId, status, orderByComparator);
	}

	/**
	 * Removes all the comments where type = &#63; and requestId = &#63; and status = &#63; from the database.
	 *
	 * @param type the type
	 * @param requestId the request ID
	 * @param status the status
	 */
	public static void removeByTypeRequestIdAndStatus(
		long type, long requestId, boolean status) {

		getPersistence().removeByTypeRequestIdAndStatus(
			type, requestId, status);
	}

	/**
	 * Returns the number of comments where type = &#63; and requestId = &#63; and status = &#63;.
	 *
	 * @param type the type
	 * @param requestId the request ID
	 * @param status the status
	 * @return the number of matching comments
	 */
	public static int countByTypeRequestIdAndStatus(
		long type, long requestId, boolean status) {

		return getPersistence().countByTypeRequestIdAndStatus(
			type, requestId, status);
	}

	/**
	 * Returns all the comments where type = &#63; and action = &#63; and requestId = &#63; and status = &#63;.
	 *
	 * @param type the type
	 * @param action the action
	 * @param requestId the request ID
	 * @param status the status
	 * @return the matching comments
	 */
	public static List<Comment> findByTypeActionRequestIdAndStatus(
		long type, String action, long requestId, boolean status) {

		return getPersistence().findByTypeActionRequestIdAndStatus(
			type, action, requestId, status);
	}

	/**
	 * Returns a range of all the comments where type = &#63; and action = &#63; and requestId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentModelImpl</code>.
	 * </p>
	 *
	 * @param type the type
	 * @param action the action
	 * @param requestId the request ID
	 * @param status the status
	 * @param start the lower bound of the range of comments
	 * @param end the upper bound of the range of comments (not inclusive)
	 * @return the range of matching comments
	 */
	public static List<Comment> findByTypeActionRequestIdAndStatus(
		long type, String action, long requestId, boolean status, int start,
		int end) {

		return getPersistence().findByTypeActionRequestIdAndStatus(
			type, action, requestId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the comments where type = &#63; and action = &#63; and requestId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentModelImpl</code>.
	 * </p>
	 *
	 * @param type the type
	 * @param action the action
	 * @param requestId the request ID
	 * @param status the status
	 * @param start the lower bound of the range of comments
	 * @param end the upper bound of the range of comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching comments
	 */
	public static List<Comment> findByTypeActionRequestIdAndStatus(
		long type, String action, long requestId, boolean status, int start,
		int end, OrderByComparator<Comment> orderByComparator) {

		return getPersistence().findByTypeActionRequestIdAndStatus(
			type, action, requestId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the comments where type = &#63; and action = &#63; and requestId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentModelImpl</code>.
	 * </p>
	 *
	 * @param type the type
	 * @param action the action
	 * @param requestId the request ID
	 * @param status the status
	 * @param start the lower bound of the range of comments
	 * @param end the upper bound of the range of comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching comments
	 */
	public static List<Comment> findByTypeActionRequestIdAndStatus(
		long type, String action, long requestId, boolean status, int start,
		int end, OrderByComparator<Comment> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByTypeActionRequestIdAndStatus(
			type, action, requestId, status, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first comment in the ordered set where type = &#63; and action = &#63; and requestId = &#63; and status = &#63;.
	 *
	 * @param type the type
	 * @param action the action
	 * @param requestId the request ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comment
	 * @throws NoSuchCommentException if a matching comment could not be found
	 */
	public static Comment findByTypeActionRequestIdAndStatus_First(
			long type, String action, long requestId, boolean status,
			OrderByComparator<Comment> orderByComparator)
		throws com.ax.hrms.exception.NoSuchCommentException {

		return getPersistence().findByTypeActionRequestIdAndStatus_First(
			type, action, requestId, status, orderByComparator);
	}

	/**
	 * Returns the first comment in the ordered set where type = &#63; and action = &#63; and requestId = &#63; and status = &#63;.
	 *
	 * @param type the type
	 * @param action the action
	 * @param requestId the request ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comment, or <code>null</code> if a matching comment could not be found
	 */
	public static Comment fetchByTypeActionRequestIdAndStatus_First(
		long type, String action, long requestId, boolean status,
		OrderByComparator<Comment> orderByComparator) {

		return getPersistence().fetchByTypeActionRequestIdAndStatus_First(
			type, action, requestId, status, orderByComparator);
	}

	/**
	 * Returns the last comment in the ordered set where type = &#63; and action = &#63; and requestId = &#63; and status = &#63;.
	 *
	 * @param type the type
	 * @param action the action
	 * @param requestId the request ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comment
	 * @throws NoSuchCommentException if a matching comment could not be found
	 */
	public static Comment findByTypeActionRequestIdAndStatus_Last(
			long type, String action, long requestId, boolean status,
			OrderByComparator<Comment> orderByComparator)
		throws com.ax.hrms.exception.NoSuchCommentException {

		return getPersistence().findByTypeActionRequestIdAndStatus_Last(
			type, action, requestId, status, orderByComparator);
	}

	/**
	 * Returns the last comment in the ordered set where type = &#63; and action = &#63; and requestId = &#63; and status = &#63;.
	 *
	 * @param type the type
	 * @param action the action
	 * @param requestId the request ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comment, or <code>null</code> if a matching comment could not be found
	 */
	public static Comment fetchByTypeActionRequestIdAndStatus_Last(
		long type, String action, long requestId, boolean status,
		OrderByComparator<Comment> orderByComparator) {

		return getPersistence().fetchByTypeActionRequestIdAndStatus_Last(
			type, action, requestId, status, orderByComparator);
	}

	/**
	 * Returns the comments before and after the current comment in the ordered set where type = &#63; and action = &#63; and requestId = &#63; and status = &#63;.
	 *
	 * @param commentId the primary key of the current comment
	 * @param type the type
	 * @param action the action
	 * @param requestId the request ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next comment
	 * @throws NoSuchCommentException if a comment with the primary key could not be found
	 */
	public static Comment[] findByTypeActionRequestIdAndStatus_PrevAndNext(
			long commentId, long type, String action, long requestId,
			boolean status, OrderByComparator<Comment> orderByComparator)
		throws com.ax.hrms.exception.NoSuchCommentException {

		return getPersistence().findByTypeActionRequestIdAndStatus_PrevAndNext(
			commentId, type, action, requestId, status, orderByComparator);
	}

	/**
	 * Removes all the comments where type = &#63; and action = &#63; and requestId = &#63; and status = &#63; from the database.
	 *
	 * @param type the type
	 * @param action the action
	 * @param requestId the request ID
	 * @param status the status
	 */
	public static void removeByTypeActionRequestIdAndStatus(
		long type, String action, long requestId, boolean status) {

		getPersistence().removeByTypeActionRequestIdAndStatus(
			type, action, requestId, status);
	}

	/**
	 * Returns the number of comments where type = &#63; and action = &#63; and requestId = &#63; and status = &#63;.
	 *
	 * @param type the type
	 * @param action the action
	 * @param requestId the request ID
	 * @param status the status
	 * @return the number of matching comments
	 */
	public static int countByTypeActionRequestIdAndStatus(
		long type, String action, long requestId, boolean status) {

		return getPersistence().countByTypeActionRequestIdAndStatus(
			type, action, requestId, status);
	}

	/**
	 * Caches the comment in the entity cache if it is enabled.
	 *
	 * @param comment the comment
	 */
	public static void cacheResult(Comment comment) {
		getPersistence().cacheResult(comment);
	}

	/**
	 * Caches the comments in the entity cache if it is enabled.
	 *
	 * @param comments the comments
	 */
	public static void cacheResult(List<Comment> comments) {
		getPersistence().cacheResult(comments);
	}

	/**
	 * Creates a new comment with the primary key. Does not add the comment to the database.
	 *
	 * @param commentId the primary key for the new comment
	 * @return the new comment
	 */
	public static Comment create(long commentId) {
		return getPersistence().create(commentId);
	}

	/**
	 * Removes the comment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param commentId the primary key of the comment
	 * @return the comment that was removed
	 * @throws NoSuchCommentException if a comment with the primary key could not be found
	 */
	public static Comment remove(long commentId)
		throws com.ax.hrms.exception.NoSuchCommentException {

		return getPersistence().remove(commentId);
	}

	public static Comment updateImpl(Comment comment) {
		return getPersistence().updateImpl(comment);
	}

	/**
	 * Returns the comment with the primary key or throws a <code>NoSuchCommentException</code> if it could not be found.
	 *
	 * @param commentId the primary key of the comment
	 * @return the comment
	 * @throws NoSuchCommentException if a comment with the primary key could not be found
	 */
	public static Comment findByPrimaryKey(long commentId)
		throws com.ax.hrms.exception.NoSuchCommentException {

		return getPersistence().findByPrimaryKey(commentId);
	}

	/**
	 * Returns the comment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param commentId the primary key of the comment
	 * @return the comment, or <code>null</code> if a comment with the primary key could not be found
	 */
	public static Comment fetchByPrimaryKey(long commentId) {
		return getPersistence().fetchByPrimaryKey(commentId);
	}

	/**
	 * Returns all the comments.
	 *
	 * @return the comments
	 */
	public static List<Comment> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the comments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of comments
	 * @param end the upper bound of the range of comments (not inclusive)
	 * @return the range of comments
	 */
	public static List<Comment> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the comments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of comments
	 * @param end the upper bound of the range of comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of comments
	 */
	public static List<Comment> findAll(
		int start, int end, OrderByComparator<Comment> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the comments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of comments
	 * @param end the upper bound of the range of comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of comments
	 */
	public static List<Comment> findAll(
		int start, int end, OrderByComparator<Comment> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the comments from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of comments.
	 *
	 * @return the number of comments
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CommentPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(CommentPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile CommentPersistence _persistence;

}