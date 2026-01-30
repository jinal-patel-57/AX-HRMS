/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence;

import com.ax.hrms.exception.NoSuchCommentException;
import com.ax.hrms.model.Comment;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the comment service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CommentUtil
 * @generated
 */
@ProviderType
public interface CommentPersistence extends BasePersistence<Comment> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CommentUtil} to access the comment persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the comments where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching comments
	 */
	public java.util.List<Comment> findByUuid(String uuid);

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
	public java.util.List<Comment> findByUuid(String uuid, int start, int end);

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
	public java.util.List<Comment> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Comment>
			orderByComparator);

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
	public java.util.List<Comment> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Comment>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first comment in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comment
	 * @throws NoSuchCommentException if a matching comment could not be found
	 */
	public Comment findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Comment>
				orderByComparator)
		throws NoSuchCommentException;

	/**
	 * Returns the first comment in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comment, or <code>null</code> if a matching comment could not be found
	 */
	public Comment fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Comment>
			orderByComparator);

	/**
	 * Returns the last comment in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comment
	 * @throws NoSuchCommentException if a matching comment could not be found
	 */
	public Comment findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Comment>
				orderByComparator)
		throws NoSuchCommentException;

	/**
	 * Returns the last comment in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comment, or <code>null</code> if a matching comment could not be found
	 */
	public Comment fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Comment>
			orderByComparator);

	/**
	 * Returns the comments before and after the current comment in the ordered set where uuid = &#63;.
	 *
	 * @param commentId the primary key of the current comment
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next comment
	 * @throws NoSuchCommentException if a comment with the primary key could not be found
	 */
	public Comment[] findByUuid_PrevAndNext(
			long commentId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Comment>
				orderByComparator)
		throws NoSuchCommentException;

	/**
	 * Removes all the comments where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of comments where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching comments
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the comment where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchCommentException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching comment
	 * @throws NoSuchCommentException if a matching comment could not be found
	 */
	public Comment findByUUID_G(String uuid, long groupId)
		throws NoSuchCommentException;

	/**
	 * Returns the comment where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching comment, or <code>null</code> if a matching comment could not be found
	 */
	public Comment fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the comment where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching comment, or <code>null</code> if a matching comment could not be found
	 */
	public Comment fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the comment where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the comment that was removed
	 */
	public Comment removeByUUID_G(String uuid, long groupId)
		throws NoSuchCommentException;

	/**
	 * Returns the number of comments where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching comments
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the comments where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching comments
	 */
	public java.util.List<Comment> findByUuid_C(String uuid, long companyId);

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
	public java.util.List<Comment> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<Comment> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Comment>
			orderByComparator);

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
	public java.util.List<Comment> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Comment>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first comment in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comment
	 * @throws NoSuchCommentException if a matching comment could not be found
	 */
	public Comment findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Comment>
				orderByComparator)
		throws NoSuchCommentException;

	/**
	 * Returns the first comment in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comment, or <code>null</code> if a matching comment could not be found
	 */
	public Comment fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Comment>
			orderByComparator);

	/**
	 * Returns the last comment in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comment
	 * @throws NoSuchCommentException if a matching comment could not be found
	 */
	public Comment findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Comment>
				orderByComparator)
		throws NoSuchCommentException;

	/**
	 * Returns the last comment in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comment, or <code>null</code> if a matching comment could not be found
	 */
	public Comment fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Comment>
			orderByComparator);

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
	public Comment[] findByUuid_C_PrevAndNext(
			long commentId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Comment>
				orderByComparator)
		throws NoSuchCommentException;

	/**
	 * Removes all the comments where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of comments where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching comments
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the comments where type = &#63;.
	 *
	 * @param type the type
	 * @return the matching comments
	 */
	public java.util.List<Comment> findByType(long type);

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
	public java.util.List<Comment> findByType(long type, int start, int end);

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
	public java.util.List<Comment> findByType(
		long type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Comment>
			orderByComparator);

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
	public java.util.List<Comment> findByType(
		long type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Comment>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first comment in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comment
	 * @throws NoSuchCommentException if a matching comment could not be found
	 */
	public Comment findByType_First(
			long type,
			com.liferay.portal.kernel.util.OrderByComparator<Comment>
				orderByComparator)
		throws NoSuchCommentException;

	/**
	 * Returns the first comment in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comment, or <code>null</code> if a matching comment could not be found
	 */
	public Comment fetchByType_First(
		long type,
		com.liferay.portal.kernel.util.OrderByComparator<Comment>
			orderByComparator);

	/**
	 * Returns the last comment in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comment
	 * @throws NoSuchCommentException if a matching comment could not be found
	 */
	public Comment findByType_Last(
			long type,
			com.liferay.portal.kernel.util.OrderByComparator<Comment>
				orderByComparator)
		throws NoSuchCommentException;

	/**
	 * Returns the last comment in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comment, or <code>null</code> if a matching comment could not be found
	 */
	public Comment fetchByType_Last(
		long type,
		com.liferay.portal.kernel.util.OrderByComparator<Comment>
			orderByComparator);

	/**
	 * Returns the comments before and after the current comment in the ordered set where type = &#63;.
	 *
	 * @param commentId the primary key of the current comment
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next comment
	 * @throws NoSuchCommentException if a comment with the primary key could not be found
	 */
	public Comment[] findByType_PrevAndNext(
			long commentId, long type,
			com.liferay.portal.kernel.util.OrderByComparator<Comment>
				orderByComparator)
		throws NoSuchCommentException;

	/**
	 * Removes all the comments where type = &#63; from the database.
	 *
	 * @param type the type
	 */
	public void removeByType(long type);

	/**
	 * Returns the number of comments where type = &#63;.
	 *
	 * @param type the type
	 * @return the number of matching comments
	 */
	public int countByType(long type);

	/**
	 * Returns all the comments where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching comments
	 */
	public java.util.List<Comment> findByStatus(boolean status);

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
	public java.util.List<Comment> findByStatus(
		boolean status, int start, int end);

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
	public java.util.List<Comment> findByStatus(
		boolean status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Comment>
			orderByComparator);

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
	public java.util.List<Comment> findByStatus(
		boolean status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Comment>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first comment in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comment
	 * @throws NoSuchCommentException if a matching comment could not be found
	 */
	public Comment findByStatus_First(
			boolean status,
			com.liferay.portal.kernel.util.OrderByComparator<Comment>
				orderByComparator)
		throws NoSuchCommentException;

	/**
	 * Returns the first comment in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comment, or <code>null</code> if a matching comment could not be found
	 */
	public Comment fetchByStatus_First(
		boolean status,
		com.liferay.portal.kernel.util.OrderByComparator<Comment>
			orderByComparator);

	/**
	 * Returns the last comment in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comment
	 * @throws NoSuchCommentException if a matching comment could not be found
	 */
	public Comment findByStatus_Last(
			boolean status,
			com.liferay.portal.kernel.util.OrderByComparator<Comment>
				orderByComparator)
		throws NoSuchCommentException;

	/**
	 * Returns the last comment in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comment, or <code>null</code> if a matching comment could not be found
	 */
	public Comment fetchByStatus_Last(
		boolean status,
		com.liferay.portal.kernel.util.OrderByComparator<Comment>
			orderByComparator);

	/**
	 * Returns the comments before and after the current comment in the ordered set where status = &#63;.
	 *
	 * @param commentId the primary key of the current comment
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next comment
	 * @throws NoSuchCommentException if a comment with the primary key could not be found
	 */
	public Comment[] findByStatus_PrevAndNext(
			long commentId, boolean status,
			com.liferay.portal.kernel.util.OrderByComparator<Comment>
				orderByComparator)
		throws NoSuchCommentException;

	/**
	 * Removes all the comments where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public void removeByStatus(boolean status);

	/**
	 * Returns the number of comments where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching comments
	 */
	public int countByStatus(boolean status);

	/**
	 * Returns all the comments where requestId = &#63;.
	 *
	 * @param requestId the request ID
	 * @return the matching comments
	 */
	public java.util.List<Comment> findByRequestId(long requestId);

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
	public java.util.List<Comment> findByRequestId(
		long requestId, int start, int end);

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
	public java.util.List<Comment> findByRequestId(
		long requestId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Comment>
			orderByComparator);

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
	public java.util.List<Comment> findByRequestId(
		long requestId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Comment>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first comment in the ordered set where requestId = &#63;.
	 *
	 * @param requestId the request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comment
	 * @throws NoSuchCommentException if a matching comment could not be found
	 */
	public Comment findByRequestId_First(
			long requestId,
			com.liferay.portal.kernel.util.OrderByComparator<Comment>
				orderByComparator)
		throws NoSuchCommentException;

	/**
	 * Returns the first comment in the ordered set where requestId = &#63;.
	 *
	 * @param requestId the request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comment, or <code>null</code> if a matching comment could not be found
	 */
	public Comment fetchByRequestId_First(
		long requestId,
		com.liferay.portal.kernel.util.OrderByComparator<Comment>
			orderByComparator);

	/**
	 * Returns the last comment in the ordered set where requestId = &#63;.
	 *
	 * @param requestId the request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comment
	 * @throws NoSuchCommentException if a matching comment could not be found
	 */
	public Comment findByRequestId_Last(
			long requestId,
			com.liferay.portal.kernel.util.OrderByComparator<Comment>
				orderByComparator)
		throws NoSuchCommentException;

	/**
	 * Returns the last comment in the ordered set where requestId = &#63;.
	 *
	 * @param requestId the request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comment, or <code>null</code> if a matching comment could not be found
	 */
	public Comment fetchByRequestId_Last(
		long requestId,
		com.liferay.portal.kernel.util.OrderByComparator<Comment>
			orderByComparator);

	/**
	 * Returns the comments before and after the current comment in the ordered set where requestId = &#63;.
	 *
	 * @param commentId the primary key of the current comment
	 * @param requestId the request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next comment
	 * @throws NoSuchCommentException if a comment with the primary key could not be found
	 */
	public Comment[] findByRequestId_PrevAndNext(
			long commentId, long requestId,
			com.liferay.portal.kernel.util.OrderByComparator<Comment>
				orderByComparator)
		throws NoSuchCommentException;

	/**
	 * Removes all the comments where requestId = &#63; from the database.
	 *
	 * @param requestId the request ID
	 */
	public void removeByRequestId(long requestId);

	/**
	 * Returns the number of comments where requestId = &#63;.
	 *
	 * @param requestId the request ID
	 * @return the number of matching comments
	 */
	public int countByRequestId(long requestId);

	/**
	 * Returns all the comments where requestId = &#63; and status = &#63;.
	 *
	 * @param requestId the request ID
	 * @param status the status
	 * @return the matching comments
	 */
	public java.util.List<Comment> findByRequestIdAndStatus(
		long requestId, boolean status);

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
	public java.util.List<Comment> findByRequestIdAndStatus(
		long requestId, boolean status, int start, int end);

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
	public java.util.List<Comment> findByRequestIdAndStatus(
		long requestId, boolean status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Comment>
			orderByComparator);

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
	public java.util.List<Comment> findByRequestIdAndStatus(
		long requestId, boolean status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Comment>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first comment in the ordered set where requestId = &#63; and status = &#63;.
	 *
	 * @param requestId the request ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comment
	 * @throws NoSuchCommentException if a matching comment could not be found
	 */
	public Comment findByRequestIdAndStatus_First(
			long requestId, boolean status,
			com.liferay.portal.kernel.util.OrderByComparator<Comment>
				orderByComparator)
		throws NoSuchCommentException;

	/**
	 * Returns the first comment in the ordered set where requestId = &#63; and status = &#63;.
	 *
	 * @param requestId the request ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comment, or <code>null</code> if a matching comment could not be found
	 */
	public Comment fetchByRequestIdAndStatus_First(
		long requestId, boolean status,
		com.liferay.portal.kernel.util.OrderByComparator<Comment>
			orderByComparator);

	/**
	 * Returns the last comment in the ordered set where requestId = &#63; and status = &#63;.
	 *
	 * @param requestId the request ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comment
	 * @throws NoSuchCommentException if a matching comment could not be found
	 */
	public Comment findByRequestIdAndStatus_Last(
			long requestId, boolean status,
			com.liferay.portal.kernel.util.OrderByComparator<Comment>
				orderByComparator)
		throws NoSuchCommentException;

	/**
	 * Returns the last comment in the ordered set where requestId = &#63; and status = &#63;.
	 *
	 * @param requestId the request ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comment, or <code>null</code> if a matching comment could not be found
	 */
	public Comment fetchByRequestIdAndStatus_Last(
		long requestId, boolean status,
		com.liferay.portal.kernel.util.OrderByComparator<Comment>
			orderByComparator);

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
	public Comment[] findByRequestIdAndStatus_PrevAndNext(
			long commentId, long requestId, boolean status,
			com.liferay.portal.kernel.util.OrderByComparator<Comment>
				orderByComparator)
		throws NoSuchCommentException;

	/**
	 * Removes all the comments where requestId = &#63; and status = &#63; from the database.
	 *
	 * @param requestId the request ID
	 * @param status the status
	 */
	public void removeByRequestIdAndStatus(long requestId, boolean status);

	/**
	 * Returns the number of comments where requestId = &#63; and status = &#63;.
	 *
	 * @param requestId the request ID
	 * @param status the status
	 * @return the number of matching comments
	 */
	public int countByRequestIdAndStatus(long requestId, boolean status);

	/**
	 * Returns all the comments where type = &#63; and requestId = &#63; and status = &#63;.
	 *
	 * @param type the type
	 * @param requestId the request ID
	 * @param status the status
	 * @return the matching comments
	 */
	public java.util.List<Comment> findByTypeRequestIdAndStatus(
		long type, long requestId, boolean status);

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
	public java.util.List<Comment> findByTypeRequestIdAndStatus(
		long type, long requestId, boolean status, int start, int end);

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
	public java.util.List<Comment> findByTypeRequestIdAndStatus(
		long type, long requestId, boolean status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Comment>
			orderByComparator);

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
	public java.util.List<Comment> findByTypeRequestIdAndStatus(
		long type, long requestId, boolean status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Comment>
			orderByComparator,
		boolean useFinderCache);

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
	public Comment findByTypeRequestIdAndStatus_First(
			long type, long requestId, boolean status,
			com.liferay.portal.kernel.util.OrderByComparator<Comment>
				orderByComparator)
		throws NoSuchCommentException;

	/**
	 * Returns the first comment in the ordered set where type = &#63; and requestId = &#63; and status = &#63;.
	 *
	 * @param type the type
	 * @param requestId the request ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comment, or <code>null</code> if a matching comment could not be found
	 */
	public Comment fetchByTypeRequestIdAndStatus_First(
		long type, long requestId, boolean status,
		com.liferay.portal.kernel.util.OrderByComparator<Comment>
			orderByComparator);

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
	public Comment findByTypeRequestIdAndStatus_Last(
			long type, long requestId, boolean status,
			com.liferay.portal.kernel.util.OrderByComparator<Comment>
				orderByComparator)
		throws NoSuchCommentException;

	/**
	 * Returns the last comment in the ordered set where type = &#63; and requestId = &#63; and status = &#63;.
	 *
	 * @param type the type
	 * @param requestId the request ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comment, or <code>null</code> if a matching comment could not be found
	 */
	public Comment fetchByTypeRequestIdAndStatus_Last(
		long type, long requestId, boolean status,
		com.liferay.portal.kernel.util.OrderByComparator<Comment>
			orderByComparator);

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
	public Comment[] findByTypeRequestIdAndStatus_PrevAndNext(
			long commentId, long type, long requestId, boolean status,
			com.liferay.portal.kernel.util.OrderByComparator<Comment>
				orderByComparator)
		throws NoSuchCommentException;

	/**
	 * Removes all the comments where type = &#63; and requestId = &#63; and status = &#63; from the database.
	 *
	 * @param type the type
	 * @param requestId the request ID
	 * @param status the status
	 */
	public void removeByTypeRequestIdAndStatus(
		long type, long requestId, boolean status);

	/**
	 * Returns the number of comments where type = &#63; and requestId = &#63; and status = &#63;.
	 *
	 * @param type the type
	 * @param requestId the request ID
	 * @param status the status
	 * @return the number of matching comments
	 */
	public int countByTypeRequestIdAndStatus(
		long type, long requestId, boolean status);

	/**
	 * Returns all the comments where type = &#63; and action = &#63; and requestId = &#63; and status = &#63;.
	 *
	 * @param type the type
	 * @param action the action
	 * @param requestId the request ID
	 * @param status the status
	 * @return the matching comments
	 */
	public java.util.List<Comment> findByTypeActionRequestIdAndStatus(
		long type, String action, long requestId, boolean status);

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
	public java.util.List<Comment> findByTypeActionRequestIdAndStatus(
		long type, String action, long requestId, boolean status, int start,
		int end);

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
	public java.util.List<Comment> findByTypeActionRequestIdAndStatus(
		long type, String action, long requestId, boolean status, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Comment>
			orderByComparator);

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
	public java.util.List<Comment> findByTypeActionRequestIdAndStatus(
		long type, String action, long requestId, boolean status, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Comment>
			orderByComparator,
		boolean useFinderCache);

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
	public Comment findByTypeActionRequestIdAndStatus_First(
			long type, String action, long requestId, boolean status,
			com.liferay.portal.kernel.util.OrderByComparator<Comment>
				orderByComparator)
		throws NoSuchCommentException;

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
	public Comment fetchByTypeActionRequestIdAndStatus_First(
		long type, String action, long requestId, boolean status,
		com.liferay.portal.kernel.util.OrderByComparator<Comment>
			orderByComparator);

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
	public Comment findByTypeActionRequestIdAndStatus_Last(
			long type, String action, long requestId, boolean status,
			com.liferay.portal.kernel.util.OrderByComparator<Comment>
				orderByComparator)
		throws NoSuchCommentException;

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
	public Comment fetchByTypeActionRequestIdAndStatus_Last(
		long type, String action, long requestId, boolean status,
		com.liferay.portal.kernel.util.OrderByComparator<Comment>
			orderByComparator);

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
	public Comment[] findByTypeActionRequestIdAndStatus_PrevAndNext(
			long commentId, long type, String action, long requestId,
			boolean status,
			com.liferay.portal.kernel.util.OrderByComparator<Comment>
				orderByComparator)
		throws NoSuchCommentException;

	/**
	 * Removes all the comments where type = &#63; and action = &#63; and requestId = &#63; and status = &#63; from the database.
	 *
	 * @param type the type
	 * @param action the action
	 * @param requestId the request ID
	 * @param status the status
	 */
	public void removeByTypeActionRequestIdAndStatus(
		long type, String action, long requestId, boolean status);

	/**
	 * Returns the number of comments where type = &#63; and action = &#63; and requestId = &#63; and status = &#63;.
	 *
	 * @param type the type
	 * @param action the action
	 * @param requestId the request ID
	 * @param status the status
	 * @return the number of matching comments
	 */
	public int countByTypeActionRequestIdAndStatus(
		long type, String action, long requestId, boolean status);

	/**
	 * Caches the comment in the entity cache if it is enabled.
	 *
	 * @param comment the comment
	 */
	public void cacheResult(Comment comment);

	/**
	 * Caches the comments in the entity cache if it is enabled.
	 *
	 * @param comments the comments
	 */
	public void cacheResult(java.util.List<Comment> comments);

	/**
	 * Creates a new comment with the primary key. Does not add the comment to the database.
	 *
	 * @param commentId the primary key for the new comment
	 * @return the new comment
	 */
	public Comment create(long commentId);

	/**
	 * Removes the comment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param commentId the primary key of the comment
	 * @return the comment that was removed
	 * @throws NoSuchCommentException if a comment with the primary key could not be found
	 */
	public Comment remove(long commentId) throws NoSuchCommentException;

	public Comment updateImpl(Comment comment);

	/**
	 * Returns the comment with the primary key or throws a <code>NoSuchCommentException</code> if it could not be found.
	 *
	 * @param commentId the primary key of the comment
	 * @return the comment
	 * @throws NoSuchCommentException if a comment with the primary key could not be found
	 */
	public Comment findByPrimaryKey(long commentId)
		throws NoSuchCommentException;

	/**
	 * Returns the comment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param commentId the primary key of the comment
	 * @return the comment, or <code>null</code> if a comment with the primary key could not be found
	 */
	public Comment fetchByPrimaryKey(long commentId);

	/**
	 * Returns all the comments.
	 *
	 * @return the comments
	 */
	public java.util.List<Comment> findAll();

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
	public java.util.List<Comment> findAll(int start, int end);

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
	public java.util.List<Comment> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Comment>
			orderByComparator);

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
	public java.util.List<Comment> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Comment>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the comments from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of comments.
	 *
	 * @return the number of comments
	 */
	public int countAll();

}