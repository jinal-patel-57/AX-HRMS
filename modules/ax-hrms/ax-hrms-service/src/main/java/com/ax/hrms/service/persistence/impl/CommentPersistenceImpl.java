/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence.impl;

import com.ax.hrms.exception.NoSuchCommentException;
import com.ax.hrms.model.Comment;
import com.ax.hrms.model.CommentTable;
import com.ax.hrms.model.impl.CommentImpl;
import com.ax.hrms.model.impl.CommentModelImpl;
import com.ax.hrms.service.persistence.CommentPersistence;
import com.ax.hrms.service.persistence.CommentUtil;
import com.ax.hrms.service.persistence.impl.constants.axPersistenceConstants;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the comment service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = CommentPersistence.class)
public class CommentPersistenceImpl
	extends BasePersistenceImpl<Comment> implements CommentPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CommentUtil</code> to access the comment persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CommentImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the comments where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching comments
	 */
	@Override
	public List<Comment> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Comment> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<Comment> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Comment> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<Comment> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Comment> orderByComparator, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<Comment> list = null;

		if (useFinderCache) {
			list = (List<Comment>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Comment comment : list) {
					if (!uuid.equals(comment.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_COMMENT_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CommentModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<Comment>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first comment in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comment
	 * @throws NoSuchCommentException if a matching comment could not be found
	 */
	@Override
	public Comment findByUuid_First(
			String uuid, OrderByComparator<Comment> orderByComparator)
		throws NoSuchCommentException {

		Comment comment = fetchByUuid_First(uuid, orderByComparator);

		if (comment != null) {
			return comment;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchCommentException(sb.toString());
	}

	/**
	 * Returns the first comment in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comment, or <code>null</code> if a matching comment could not be found
	 */
	@Override
	public Comment fetchByUuid_First(
		String uuid, OrderByComparator<Comment> orderByComparator) {

		List<Comment> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last comment in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comment
	 * @throws NoSuchCommentException if a matching comment could not be found
	 */
	@Override
	public Comment findByUuid_Last(
			String uuid, OrderByComparator<Comment> orderByComparator)
		throws NoSuchCommentException {

		Comment comment = fetchByUuid_Last(uuid, orderByComparator);

		if (comment != null) {
			return comment;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchCommentException(sb.toString());
	}

	/**
	 * Returns the last comment in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comment, or <code>null</code> if a matching comment could not be found
	 */
	@Override
	public Comment fetchByUuid_Last(
		String uuid, OrderByComparator<Comment> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Comment> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Comment[] findByUuid_PrevAndNext(
			long commentId, String uuid,
			OrderByComparator<Comment> orderByComparator)
		throws NoSuchCommentException {

		uuid = Objects.toString(uuid, "");

		Comment comment = findByPrimaryKey(commentId);

		Session session = null;

		try {
			session = openSession();

			Comment[] array = new CommentImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, comment, uuid, orderByComparator, true);

			array[1] = comment;

			array[2] = getByUuid_PrevAndNext(
				session, comment, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Comment getByUuid_PrevAndNext(
		Session session, Comment comment, String uuid,
		OrderByComparator<Comment> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_COMMENT_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(CommentModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(comment)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Comment> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the comments where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Comment comment :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(comment);
		}
	}

	/**
	 * Returns the number of comments where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching comments
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_COMMENT_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 = "comment.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(comment.uuid IS NULL OR comment.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the comment where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchCommentException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching comment
	 * @throws NoSuchCommentException if a matching comment could not be found
	 */
	@Override
	public Comment findByUUID_G(String uuid, long groupId)
		throws NoSuchCommentException {

		Comment comment = fetchByUUID_G(uuid, groupId);

		if (comment == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("uuid=");
			sb.append(uuid);

			sb.append(", groupId=");
			sb.append(groupId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchCommentException(sb.toString());
		}

		return comment;
	}

	/**
	 * Returns the comment where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching comment, or <code>null</code> if a matching comment could not be found
	 */
	@Override
	public Comment fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the comment where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching comment, or <code>null</code> if a matching comment could not be found
	 */
	@Override
	public Comment fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {uuid, groupId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByUUID_G, finderArgs, this);
		}

		if (result instanceof Comment) {
			Comment comment = (Comment)result;

			if (!Objects.equals(uuid, comment.getUuid()) ||
				(groupId != comment.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_COMMENT_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				List<Comment> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					Comment comment = list.get(0);

					result = comment;

					cacheResult(comment);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Comment)result;
		}
	}

	/**
	 * Removes the comment where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the comment that was removed
	 */
	@Override
	public Comment removeByUUID_G(String uuid, long groupId)
		throws NoSuchCommentException {

		Comment comment = findByUUID_G(uuid, groupId);

		return remove(comment);
	}

	/**
	 * Returns the number of comments where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching comments
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_COMMENT_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"comment.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(comment.uuid IS NULL OR comment.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"comment.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the comments where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching comments
	 */
	@Override
	public List<Comment> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Comment> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
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
	@Override
	public List<Comment> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Comment> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
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
	@Override
	public List<Comment> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Comment> orderByComparator, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid_C;
				finderArgs = new Object[] {uuid, companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid_C;
			finderArgs = new Object[] {
				uuid, companyId, start, end, orderByComparator
			};
		}

		List<Comment> list = null;

		if (useFinderCache) {
			list = (List<Comment>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Comment comment : list) {
					if (!uuid.equals(comment.getUuid()) ||
						(companyId != comment.getCompanyId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_COMMENT_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CommentModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				list = (List<Comment>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Comment findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Comment> orderByComparator)
		throws NoSuchCommentException {

		Comment comment = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (comment != null) {
			return comment;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchCommentException(sb.toString());
	}

	/**
	 * Returns the first comment in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comment, or <code>null</code> if a matching comment could not be found
	 */
	@Override
	public Comment fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Comment> orderByComparator) {

		List<Comment> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Comment findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Comment> orderByComparator)
		throws NoSuchCommentException {

		Comment comment = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (comment != null) {
			return comment;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchCommentException(sb.toString());
	}

	/**
	 * Returns the last comment in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comment, or <code>null</code> if a matching comment could not be found
	 */
	@Override
	public Comment fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Comment> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<Comment> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Comment[] findByUuid_C_PrevAndNext(
			long commentId, String uuid, long companyId,
			OrderByComparator<Comment> orderByComparator)
		throws NoSuchCommentException {

		uuid = Objects.toString(uuid, "");

		Comment comment = findByPrimaryKey(commentId);

		Session session = null;

		try {
			session = openSession();

			Comment[] array = new CommentImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, comment, uuid, companyId, orderByComparator, true);

			array[1] = comment;

			array[2] = getByUuid_C_PrevAndNext(
				session, comment, uuid, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Comment getByUuid_C_PrevAndNext(
		Session session, Comment comment, String uuid, long companyId,
		OrderByComparator<Comment> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_COMMENT_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(CommentModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(comment)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Comment> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the comments where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (Comment comment :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(comment);
		}
	}

	/**
	 * Returns the number of comments where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching comments
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_COMMENT_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_2 =
		"comment.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(comment.uuid IS NULL OR comment.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"comment.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByType;
	private FinderPath _finderPathWithoutPaginationFindByType;
	private FinderPath _finderPathCountByType;

	/**
	 * Returns all the comments where type = &#63;.
	 *
	 * @param type the type
	 * @return the matching comments
	 */
	@Override
	public List<Comment> findByType(long type) {
		return findByType(type, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Comment> findByType(long type, int start, int end) {
		return findByType(type, start, end, null);
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
	@Override
	public List<Comment> findByType(
		long type, int start, int end,
		OrderByComparator<Comment> orderByComparator) {

		return findByType(type, start, end, orderByComparator, true);
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
	@Override
	public List<Comment> findByType(
		long type, int start, int end,
		OrderByComparator<Comment> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByType;
				finderArgs = new Object[] {type};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByType;
			finderArgs = new Object[] {type, start, end, orderByComparator};
		}

		List<Comment> list = null;

		if (useFinderCache) {
			list = (List<Comment>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Comment comment : list) {
					if (type != comment.getType()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_COMMENT_WHERE);

			sb.append(_FINDER_COLUMN_TYPE_TYPE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CommentModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(type);

				list = (List<Comment>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first comment in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comment
	 * @throws NoSuchCommentException if a matching comment could not be found
	 */
	@Override
	public Comment findByType_First(
			long type, OrderByComparator<Comment> orderByComparator)
		throws NoSuchCommentException {

		Comment comment = fetchByType_First(type, orderByComparator);

		if (comment != null) {
			return comment;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("type=");
		sb.append(type);

		sb.append("}");

		throw new NoSuchCommentException(sb.toString());
	}

	/**
	 * Returns the first comment in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comment, or <code>null</code> if a matching comment could not be found
	 */
	@Override
	public Comment fetchByType_First(
		long type, OrderByComparator<Comment> orderByComparator) {

		List<Comment> list = findByType(type, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last comment in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comment
	 * @throws NoSuchCommentException if a matching comment could not be found
	 */
	@Override
	public Comment findByType_Last(
			long type, OrderByComparator<Comment> orderByComparator)
		throws NoSuchCommentException {

		Comment comment = fetchByType_Last(type, orderByComparator);

		if (comment != null) {
			return comment;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("type=");
		sb.append(type);

		sb.append("}");

		throw new NoSuchCommentException(sb.toString());
	}

	/**
	 * Returns the last comment in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comment, or <code>null</code> if a matching comment could not be found
	 */
	@Override
	public Comment fetchByType_Last(
		long type, OrderByComparator<Comment> orderByComparator) {

		int count = countByType(type);

		if (count == 0) {
			return null;
		}

		List<Comment> list = findByType(
			type, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Comment[] findByType_PrevAndNext(
			long commentId, long type,
			OrderByComparator<Comment> orderByComparator)
		throws NoSuchCommentException {

		Comment comment = findByPrimaryKey(commentId);

		Session session = null;

		try {
			session = openSession();

			Comment[] array = new CommentImpl[3];

			array[0] = getByType_PrevAndNext(
				session, comment, type, orderByComparator, true);

			array[1] = comment;

			array[2] = getByType_PrevAndNext(
				session, comment, type, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Comment getByType_PrevAndNext(
		Session session, Comment comment, long type,
		OrderByComparator<Comment> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_COMMENT_WHERE);

		sb.append(_FINDER_COLUMN_TYPE_TYPE_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(CommentModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(type);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(comment)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Comment> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the comments where type = &#63; from the database.
	 *
	 * @param type the type
	 */
	@Override
	public void removeByType(long type) {
		for (Comment comment :
				findByType(type, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(comment);
		}
	}

	/**
	 * Returns the number of comments where type = &#63;.
	 *
	 * @param type the type
	 * @return the number of matching comments
	 */
	@Override
	public int countByType(long type) {
		FinderPath finderPath = _finderPathCountByType;

		Object[] finderArgs = new Object[] {type};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_COMMENT_WHERE);

			sb.append(_FINDER_COLUMN_TYPE_TYPE_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(type);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_TYPE_TYPE_2 = "comment.type = ?";

	private FinderPath _finderPathWithPaginationFindByStatus;
	private FinderPath _finderPathWithoutPaginationFindByStatus;
	private FinderPath _finderPathCountByStatus;

	/**
	 * Returns all the comments where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching comments
	 */
	@Override
	public List<Comment> findByStatus(boolean status) {
		return findByStatus(status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Comment> findByStatus(boolean status, int start, int end) {
		return findByStatus(status, start, end, null);
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
	@Override
	public List<Comment> findByStatus(
		boolean status, int start, int end,
		OrderByComparator<Comment> orderByComparator) {

		return findByStatus(status, start, end, orderByComparator, true);
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
	@Override
	public List<Comment> findByStatus(
		boolean status, int start, int end,
		OrderByComparator<Comment> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByStatus;
				finderArgs = new Object[] {status};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByStatus;
			finderArgs = new Object[] {status, start, end, orderByComparator};
		}

		List<Comment> list = null;

		if (useFinderCache) {
			list = (List<Comment>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Comment comment : list) {
					if (status != comment.isStatus()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_COMMENT_WHERE);

			sb.append(_FINDER_COLUMN_STATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CommentModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(status);

				list = (List<Comment>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first comment in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comment
	 * @throws NoSuchCommentException if a matching comment could not be found
	 */
	@Override
	public Comment findByStatus_First(
			boolean status, OrderByComparator<Comment> orderByComparator)
		throws NoSuchCommentException {

		Comment comment = fetchByStatus_First(status, orderByComparator);

		if (comment != null) {
			return comment;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchCommentException(sb.toString());
	}

	/**
	 * Returns the first comment in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comment, or <code>null</code> if a matching comment could not be found
	 */
	@Override
	public Comment fetchByStatus_First(
		boolean status, OrderByComparator<Comment> orderByComparator) {

		List<Comment> list = findByStatus(status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last comment in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comment
	 * @throws NoSuchCommentException if a matching comment could not be found
	 */
	@Override
	public Comment findByStatus_Last(
			boolean status, OrderByComparator<Comment> orderByComparator)
		throws NoSuchCommentException {

		Comment comment = fetchByStatus_Last(status, orderByComparator);

		if (comment != null) {
			return comment;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchCommentException(sb.toString());
	}

	/**
	 * Returns the last comment in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comment, or <code>null</code> if a matching comment could not be found
	 */
	@Override
	public Comment fetchByStatus_Last(
		boolean status, OrderByComparator<Comment> orderByComparator) {

		int count = countByStatus(status);

		if (count == 0) {
			return null;
		}

		List<Comment> list = findByStatus(
			status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Comment[] findByStatus_PrevAndNext(
			long commentId, boolean status,
			OrderByComparator<Comment> orderByComparator)
		throws NoSuchCommentException {

		Comment comment = findByPrimaryKey(commentId);

		Session session = null;

		try {
			session = openSession();

			Comment[] array = new CommentImpl[3];

			array[0] = getByStatus_PrevAndNext(
				session, comment, status, orderByComparator, true);

			array[1] = comment;

			array[2] = getByStatus_PrevAndNext(
				session, comment, status, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Comment getByStatus_PrevAndNext(
		Session session, Comment comment, boolean status,
		OrderByComparator<Comment> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_COMMENT_WHERE);

		sb.append(_FINDER_COLUMN_STATUS_STATUS_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(CommentModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(comment)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Comment> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the comments where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	@Override
	public void removeByStatus(boolean status) {
		for (Comment comment :
				findByStatus(
					status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(comment);
		}
	}

	/**
	 * Returns the number of comments where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching comments
	 */
	@Override
	public int countByStatus(boolean status) {
		FinderPath finderPath = _finderPathCountByStatus;

		Object[] finderArgs = new Object[] {status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_COMMENT_WHERE);

			sb.append(_FINDER_COLUMN_STATUS_STATUS_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(status);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_STATUS_STATUS_2 =
		"comment.status = ?";

	private FinderPath _finderPathWithPaginationFindByRequestId;
	private FinderPath _finderPathWithoutPaginationFindByRequestId;
	private FinderPath _finderPathCountByRequestId;

	/**
	 * Returns all the comments where requestId = &#63;.
	 *
	 * @param requestId the request ID
	 * @return the matching comments
	 */
	@Override
	public List<Comment> findByRequestId(long requestId) {
		return findByRequestId(
			requestId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Comment> findByRequestId(long requestId, int start, int end) {
		return findByRequestId(requestId, start, end, null);
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
	@Override
	public List<Comment> findByRequestId(
		long requestId, int start, int end,
		OrderByComparator<Comment> orderByComparator) {

		return findByRequestId(requestId, start, end, orderByComparator, true);
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
	@Override
	public List<Comment> findByRequestId(
		long requestId, int start, int end,
		OrderByComparator<Comment> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByRequestId;
				finderArgs = new Object[] {requestId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByRequestId;
			finderArgs = new Object[] {
				requestId, start, end, orderByComparator
			};
		}

		List<Comment> list = null;

		if (useFinderCache) {
			list = (List<Comment>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Comment comment : list) {
					if (requestId != comment.getRequestId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_COMMENT_WHERE);

			sb.append(_FINDER_COLUMN_REQUESTID_REQUESTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CommentModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(requestId);

				list = (List<Comment>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first comment in the ordered set where requestId = &#63;.
	 *
	 * @param requestId the request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comment
	 * @throws NoSuchCommentException if a matching comment could not be found
	 */
	@Override
	public Comment findByRequestId_First(
			long requestId, OrderByComparator<Comment> orderByComparator)
		throws NoSuchCommentException {

		Comment comment = fetchByRequestId_First(requestId, orderByComparator);

		if (comment != null) {
			return comment;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("requestId=");
		sb.append(requestId);

		sb.append("}");

		throw new NoSuchCommentException(sb.toString());
	}

	/**
	 * Returns the first comment in the ordered set where requestId = &#63;.
	 *
	 * @param requestId the request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comment, or <code>null</code> if a matching comment could not be found
	 */
	@Override
	public Comment fetchByRequestId_First(
		long requestId, OrderByComparator<Comment> orderByComparator) {

		List<Comment> list = findByRequestId(
			requestId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last comment in the ordered set where requestId = &#63;.
	 *
	 * @param requestId the request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comment
	 * @throws NoSuchCommentException if a matching comment could not be found
	 */
	@Override
	public Comment findByRequestId_Last(
			long requestId, OrderByComparator<Comment> orderByComparator)
		throws NoSuchCommentException {

		Comment comment = fetchByRequestId_Last(requestId, orderByComparator);

		if (comment != null) {
			return comment;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("requestId=");
		sb.append(requestId);

		sb.append("}");

		throw new NoSuchCommentException(sb.toString());
	}

	/**
	 * Returns the last comment in the ordered set where requestId = &#63;.
	 *
	 * @param requestId the request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comment, or <code>null</code> if a matching comment could not be found
	 */
	@Override
	public Comment fetchByRequestId_Last(
		long requestId, OrderByComparator<Comment> orderByComparator) {

		int count = countByRequestId(requestId);

		if (count == 0) {
			return null;
		}

		List<Comment> list = findByRequestId(
			requestId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Comment[] findByRequestId_PrevAndNext(
			long commentId, long requestId,
			OrderByComparator<Comment> orderByComparator)
		throws NoSuchCommentException {

		Comment comment = findByPrimaryKey(commentId);

		Session session = null;

		try {
			session = openSession();

			Comment[] array = new CommentImpl[3];

			array[0] = getByRequestId_PrevAndNext(
				session, comment, requestId, orderByComparator, true);

			array[1] = comment;

			array[2] = getByRequestId_PrevAndNext(
				session, comment, requestId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Comment getByRequestId_PrevAndNext(
		Session session, Comment comment, long requestId,
		OrderByComparator<Comment> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_COMMENT_WHERE);

		sb.append(_FINDER_COLUMN_REQUESTID_REQUESTID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(CommentModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(requestId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(comment)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Comment> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the comments where requestId = &#63; from the database.
	 *
	 * @param requestId the request ID
	 */
	@Override
	public void removeByRequestId(long requestId) {
		for (Comment comment :
				findByRequestId(
					requestId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(comment);
		}
	}

	/**
	 * Returns the number of comments where requestId = &#63;.
	 *
	 * @param requestId the request ID
	 * @return the number of matching comments
	 */
	@Override
	public int countByRequestId(long requestId) {
		FinderPath finderPath = _finderPathCountByRequestId;

		Object[] finderArgs = new Object[] {requestId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_COMMENT_WHERE);

			sb.append(_FINDER_COLUMN_REQUESTID_REQUESTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(requestId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_REQUESTID_REQUESTID_2 =
		"comment.requestId = ?";

	private FinderPath _finderPathWithPaginationFindByRequestIdAndStatus;
	private FinderPath _finderPathWithoutPaginationFindByRequestIdAndStatus;
	private FinderPath _finderPathCountByRequestIdAndStatus;

	/**
	 * Returns all the comments where requestId = &#63; and status = &#63;.
	 *
	 * @param requestId the request ID
	 * @param status the status
	 * @return the matching comments
	 */
	@Override
	public List<Comment> findByRequestIdAndStatus(
		long requestId, boolean status) {

		return findByRequestIdAndStatus(
			requestId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Comment> findByRequestIdAndStatus(
		long requestId, boolean status, int start, int end) {

		return findByRequestIdAndStatus(requestId, status, start, end, null);
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
	@Override
	public List<Comment> findByRequestIdAndStatus(
		long requestId, boolean status, int start, int end,
		OrderByComparator<Comment> orderByComparator) {

		return findByRequestIdAndStatus(
			requestId, status, start, end, orderByComparator, true);
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
	@Override
	public List<Comment> findByRequestIdAndStatus(
		long requestId, boolean status, int start, int end,
		OrderByComparator<Comment> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByRequestIdAndStatus;
				finderArgs = new Object[] {requestId, status};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByRequestIdAndStatus;
			finderArgs = new Object[] {
				requestId, status, start, end, orderByComparator
			};
		}

		List<Comment> list = null;

		if (useFinderCache) {
			list = (List<Comment>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Comment comment : list) {
					if ((requestId != comment.getRequestId()) ||
						(status != comment.isStatus())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_COMMENT_WHERE);

			sb.append(_FINDER_COLUMN_REQUESTIDANDSTATUS_REQUESTID_2);

			sb.append(_FINDER_COLUMN_REQUESTIDANDSTATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CommentModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(requestId);

				queryPos.add(status);

				list = (List<Comment>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Comment findByRequestIdAndStatus_First(
			long requestId, boolean status,
			OrderByComparator<Comment> orderByComparator)
		throws NoSuchCommentException {

		Comment comment = fetchByRequestIdAndStatus_First(
			requestId, status, orderByComparator);

		if (comment != null) {
			return comment;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("requestId=");
		sb.append(requestId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchCommentException(sb.toString());
	}

	/**
	 * Returns the first comment in the ordered set where requestId = &#63; and status = &#63;.
	 *
	 * @param requestId the request ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comment, or <code>null</code> if a matching comment could not be found
	 */
	@Override
	public Comment fetchByRequestIdAndStatus_First(
		long requestId, boolean status,
		OrderByComparator<Comment> orderByComparator) {

		List<Comment> list = findByRequestIdAndStatus(
			requestId, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Comment findByRequestIdAndStatus_Last(
			long requestId, boolean status,
			OrderByComparator<Comment> orderByComparator)
		throws NoSuchCommentException {

		Comment comment = fetchByRequestIdAndStatus_Last(
			requestId, status, orderByComparator);

		if (comment != null) {
			return comment;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("requestId=");
		sb.append(requestId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchCommentException(sb.toString());
	}

	/**
	 * Returns the last comment in the ordered set where requestId = &#63; and status = &#63;.
	 *
	 * @param requestId the request ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comment, or <code>null</code> if a matching comment could not be found
	 */
	@Override
	public Comment fetchByRequestIdAndStatus_Last(
		long requestId, boolean status,
		OrderByComparator<Comment> orderByComparator) {

		int count = countByRequestIdAndStatus(requestId, status);

		if (count == 0) {
			return null;
		}

		List<Comment> list = findByRequestIdAndStatus(
			requestId, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Comment[] findByRequestIdAndStatus_PrevAndNext(
			long commentId, long requestId, boolean status,
			OrderByComparator<Comment> orderByComparator)
		throws NoSuchCommentException {

		Comment comment = findByPrimaryKey(commentId);

		Session session = null;

		try {
			session = openSession();

			Comment[] array = new CommentImpl[3];

			array[0] = getByRequestIdAndStatus_PrevAndNext(
				session, comment, requestId, status, orderByComparator, true);

			array[1] = comment;

			array[2] = getByRequestIdAndStatus_PrevAndNext(
				session, comment, requestId, status, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Comment getByRequestIdAndStatus_PrevAndNext(
		Session session, Comment comment, long requestId, boolean status,
		OrderByComparator<Comment> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_COMMENT_WHERE);

		sb.append(_FINDER_COLUMN_REQUESTIDANDSTATUS_REQUESTID_2);

		sb.append(_FINDER_COLUMN_REQUESTIDANDSTATUS_STATUS_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(CommentModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(requestId);

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(comment)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Comment> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the comments where requestId = &#63; and status = &#63; from the database.
	 *
	 * @param requestId the request ID
	 * @param status the status
	 */
	@Override
	public void removeByRequestIdAndStatus(long requestId, boolean status) {
		for (Comment comment :
				findByRequestIdAndStatus(
					requestId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(comment);
		}
	}

	/**
	 * Returns the number of comments where requestId = &#63; and status = &#63;.
	 *
	 * @param requestId the request ID
	 * @param status the status
	 * @return the number of matching comments
	 */
	@Override
	public int countByRequestIdAndStatus(long requestId, boolean status) {
		FinderPath finderPath = _finderPathCountByRequestIdAndStatus;

		Object[] finderArgs = new Object[] {requestId, status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_COMMENT_WHERE);

			sb.append(_FINDER_COLUMN_REQUESTIDANDSTATUS_REQUESTID_2);

			sb.append(_FINDER_COLUMN_REQUESTIDANDSTATUS_STATUS_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(requestId);

				queryPos.add(status);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_REQUESTIDANDSTATUS_REQUESTID_2 =
		"comment.requestId = ? AND ";

	private static final String _FINDER_COLUMN_REQUESTIDANDSTATUS_STATUS_2 =
		"comment.status = ?";

	private FinderPath _finderPathWithPaginationFindByTypeRequestIdAndStatus;
	private FinderPath _finderPathWithoutPaginationFindByTypeRequestIdAndStatus;
	private FinderPath _finderPathCountByTypeRequestIdAndStatus;

	/**
	 * Returns all the comments where type = &#63; and requestId = &#63; and status = &#63;.
	 *
	 * @param type the type
	 * @param requestId the request ID
	 * @param status the status
	 * @return the matching comments
	 */
	@Override
	public List<Comment> findByTypeRequestIdAndStatus(
		long type, long requestId, boolean status) {

		return findByTypeRequestIdAndStatus(
			type, requestId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<Comment> findByTypeRequestIdAndStatus(
		long type, long requestId, boolean status, int start, int end) {

		return findByTypeRequestIdAndStatus(
			type, requestId, status, start, end, null);
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
	@Override
	public List<Comment> findByTypeRequestIdAndStatus(
		long type, long requestId, boolean status, int start, int end,
		OrderByComparator<Comment> orderByComparator) {

		return findByTypeRequestIdAndStatus(
			type, requestId, status, start, end, orderByComparator, true);
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
	@Override
	public List<Comment> findByTypeRequestIdAndStatus(
		long type, long requestId, boolean status, int start, int end,
		OrderByComparator<Comment> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByTypeRequestIdAndStatus;
				finderArgs = new Object[] {type, requestId, status};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByTypeRequestIdAndStatus;
			finderArgs = new Object[] {
				type, requestId, status, start, end, orderByComparator
			};
		}

		List<Comment> list = null;

		if (useFinderCache) {
			list = (List<Comment>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Comment comment : list) {
					if ((type != comment.getType()) ||
						(requestId != comment.getRequestId()) ||
						(status != comment.isStatus())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					5 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(5);
			}

			sb.append(_SQL_SELECT_COMMENT_WHERE);

			sb.append(_FINDER_COLUMN_TYPEREQUESTIDANDSTATUS_TYPE_2);

			sb.append(_FINDER_COLUMN_TYPEREQUESTIDANDSTATUS_REQUESTID_2);

			sb.append(_FINDER_COLUMN_TYPEREQUESTIDANDSTATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CommentModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(type);

				queryPos.add(requestId);

				queryPos.add(status);

				list = (List<Comment>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Comment findByTypeRequestIdAndStatus_First(
			long type, long requestId, boolean status,
			OrderByComparator<Comment> orderByComparator)
		throws NoSuchCommentException {

		Comment comment = fetchByTypeRequestIdAndStatus_First(
			type, requestId, status, orderByComparator);

		if (comment != null) {
			return comment;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("type=");
		sb.append(type);

		sb.append(", requestId=");
		sb.append(requestId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchCommentException(sb.toString());
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
	@Override
	public Comment fetchByTypeRequestIdAndStatus_First(
		long type, long requestId, boolean status,
		OrderByComparator<Comment> orderByComparator) {

		List<Comment> list = findByTypeRequestIdAndStatus(
			type, requestId, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Comment findByTypeRequestIdAndStatus_Last(
			long type, long requestId, boolean status,
			OrderByComparator<Comment> orderByComparator)
		throws NoSuchCommentException {

		Comment comment = fetchByTypeRequestIdAndStatus_Last(
			type, requestId, status, orderByComparator);

		if (comment != null) {
			return comment;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("type=");
		sb.append(type);

		sb.append(", requestId=");
		sb.append(requestId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchCommentException(sb.toString());
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
	@Override
	public Comment fetchByTypeRequestIdAndStatus_Last(
		long type, long requestId, boolean status,
		OrderByComparator<Comment> orderByComparator) {

		int count = countByTypeRequestIdAndStatus(type, requestId, status);

		if (count == 0) {
			return null;
		}

		List<Comment> list = findByTypeRequestIdAndStatus(
			type, requestId, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Comment[] findByTypeRequestIdAndStatus_PrevAndNext(
			long commentId, long type, long requestId, boolean status,
			OrderByComparator<Comment> orderByComparator)
		throws NoSuchCommentException {

		Comment comment = findByPrimaryKey(commentId);

		Session session = null;

		try {
			session = openSession();

			Comment[] array = new CommentImpl[3];

			array[0] = getByTypeRequestIdAndStatus_PrevAndNext(
				session, comment, type, requestId, status, orderByComparator,
				true);

			array[1] = comment;

			array[2] = getByTypeRequestIdAndStatus_PrevAndNext(
				session, comment, type, requestId, status, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Comment getByTypeRequestIdAndStatus_PrevAndNext(
		Session session, Comment comment, long type, long requestId,
		boolean status, OrderByComparator<Comment> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(5);
		}

		sb.append(_SQL_SELECT_COMMENT_WHERE);

		sb.append(_FINDER_COLUMN_TYPEREQUESTIDANDSTATUS_TYPE_2);

		sb.append(_FINDER_COLUMN_TYPEREQUESTIDANDSTATUS_REQUESTID_2);

		sb.append(_FINDER_COLUMN_TYPEREQUESTIDANDSTATUS_STATUS_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(CommentModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(type);

		queryPos.add(requestId);

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(comment)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Comment> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the comments where type = &#63; and requestId = &#63; and status = &#63; from the database.
	 *
	 * @param type the type
	 * @param requestId the request ID
	 * @param status the status
	 */
	@Override
	public void removeByTypeRequestIdAndStatus(
		long type, long requestId, boolean status) {

		for (Comment comment :
				findByTypeRequestIdAndStatus(
					type, requestId, status, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(comment);
		}
	}

	/**
	 * Returns the number of comments where type = &#63; and requestId = &#63; and status = &#63;.
	 *
	 * @param type the type
	 * @param requestId the request ID
	 * @param status the status
	 * @return the number of matching comments
	 */
	@Override
	public int countByTypeRequestIdAndStatus(
		long type, long requestId, boolean status) {

		FinderPath finderPath = _finderPathCountByTypeRequestIdAndStatus;

		Object[] finderArgs = new Object[] {type, requestId, status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_COMMENT_WHERE);

			sb.append(_FINDER_COLUMN_TYPEREQUESTIDANDSTATUS_TYPE_2);

			sb.append(_FINDER_COLUMN_TYPEREQUESTIDANDSTATUS_REQUESTID_2);

			sb.append(_FINDER_COLUMN_TYPEREQUESTIDANDSTATUS_STATUS_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(type);

				queryPos.add(requestId);

				queryPos.add(status);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_TYPEREQUESTIDANDSTATUS_TYPE_2 =
		"comment.type = ? AND ";

	private static final String
		_FINDER_COLUMN_TYPEREQUESTIDANDSTATUS_REQUESTID_2 =
			"comment.requestId = ? AND ";

	private static final String _FINDER_COLUMN_TYPEREQUESTIDANDSTATUS_STATUS_2 =
		"comment.status = ?";

	private FinderPath
		_finderPathWithPaginationFindByTypeActionRequestIdAndStatus;
	private FinderPath
		_finderPathWithoutPaginationFindByTypeActionRequestIdAndStatus;
	private FinderPath _finderPathCountByTypeActionRequestIdAndStatus;

	/**
	 * Returns all the comments where type = &#63; and action = &#63; and requestId = &#63; and status = &#63;.
	 *
	 * @param type the type
	 * @param action the action
	 * @param requestId the request ID
	 * @param status the status
	 * @return the matching comments
	 */
	@Override
	public List<Comment> findByTypeActionRequestIdAndStatus(
		long type, String action, long requestId, boolean status) {

		return findByTypeActionRequestIdAndStatus(
			type, action, requestId, status, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<Comment> findByTypeActionRequestIdAndStatus(
		long type, String action, long requestId, boolean status, int start,
		int end) {

		return findByTypeActionRequestIdAndStatus(
			type, action, requestId, status, start, end, null);
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
	@Override
	public List<Comment> findByTypeActionRequestIdAndStatus(
		long type, String action, long requestId, boolean status, int start,
		int end, OrderByComparator<Comment> orderByComparator) {

		return findByTypeActionRequestIdAndStatus(
			type, action, requestId, status, start, end, orderByComparator,
			true);
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
	@Override
	public List<Comment> findByTypeActionRequestIdAndStatus(
		long type, String action, long requestId, boolean status, int start,
		int end, OrderByComparator<Comment> orderByComparator,
		boolean useFinderCache) {

		action = Objects.toString(action, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByTypeActionRequestIdAndStatus;
				finderArgs = new Object[] {type, action, requestId, status};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByTypeActionRequestIdAndStatus;
			finderArgs = new Object[] {
				type, action, requestId, status, start, end, orderByComparator
			};
		}

		List<Comment> list = null;

		if (useFinderCache) {
			list = (List<Comment>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Comment comment : list) {
					if ((type != comment.getType()) ||
						!action.equals(comment.getAction()) ||
						(requestId != comment.getRequestId()) ||
						(status != comment.isStatus())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					6 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(6);
			}

			sb.append(_SQL_SELECT_COMMENT_WHERE);

			sb.append(_FINDER_COLUMN_TYPEACTIONREQUESTIDANDSTATUS_TYPE_2);

			boolean bindAction = false;

			if (action.isEmpty()) {
				sb.append(_FINDER_COLUMN_TYPEACTIONREQUESTIDANDSTATUS_ACTION_3);
			}
			else {
				bindAction = true;

				sb.append(_FINDER_COLUMN_TYPEACTIONREQUESTIDANDSTATUS_ACTION_2);
			}

			sb.append(_FINDER_COLUMN_TYPEACTIONREQUESTIDANDSTATUS_REQUESTID_2);

			sb.append(_FINDER_COLUMN_TYPEACTIONREQUESTIDANDSTATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CommentModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(type);

				if (bindAction) {
					queryPos.add(action);
				}

				queryPos.add(requestId);

				queryPos.add(status);

				list = (List<Comment>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Comment findByTypeActionRequestIdAndStatus_First(
			long type, String action, long requestId, boolean status,
			OrderByComparator<Comment> orderByComparator)
		throws NoSuchCommentException {

		Comment comment = fetchByTypeActionRequestIdAndStatus_First(
			type, action, requestId, status, orderByComparator);

		if (comment != null) {
			return comment;
		}

		StringBundler sb = new StringBundler(10);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("type=");
		sb.append(type);

		sb.append(", action=");
		sb.append(action);

		sb.append(", requestId=");
		sb.append(requestId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchCommentException(sb.toString());
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
	@Override
	public Comment fetchByTypeActionRequestIdAndStatus_First(
		long type, String action, long requestId, boolean status,
		OrderByComparator<Comment> orderByComparator) {

		List<Comment> list = findByTypeActionRequestIdAndStatus(
			type, action, requestId, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Comment findByTypeActionRequestIdAndStatus_Last(
			long type, String action, long requestId, boolean status,
			OrderByComparator<Comment> orderByComparator)
		throws NoSuchCommentException {

		Comment comment = fetchByTypeActionRequestIdAndStatus_Last(
			type, action, requestId, status, orderByComparator);

		if (comment != null) {
			return comment;
		}

		StringBundler sb = new StringBundler(10);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("type=");
		sb.append(type);

		sb.append(", action=");
		sb.append(action);

		sb.append(", requestId=");
		sb.append(requestId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchCommentException(sb.toString());
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
	@Override
	public Comment fetchByTypeActionRequestIdAndStatus_Last(
		long type, String action, long requestId, boolean status,
		OrderByComparator<Comment> orderByComparator) {

		int count = countByTypeActionRequestIdAndStatus(
			type, action, requestId, status);

		if (count == 0) {
			return null;
		}

		List<Comment> list = findByTypeActionRequestIdAndStatus(
			type, action, requestId, status, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Comment[] findByTypeActionRequestIdAndStatus_PrevAndNext(
			long commentId, long type, String action, long requestId,
			boolean status, OrderByComparator<Comment> orderByComparator)
		throws NoSuchCommentException {

		action = Objects.toString(action, "");

		Comment comment = findByPrimaryKey(commentId);

		Session session = null;

		try {
			session = openSession();

			Comment[] array = new CommentImpl[3];

			array[0] = getByTypeActionRequestIdAndStatus_PrevAndNext(
				session, comment, type, action, requestId, status,
				orderByComparator, true);

			array[1] = comment;

			array[2] = getByTypeActionRequestIdAndStatus_PrevAndNext(
				session, comment, type, action, requestId, status,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Comment getByTypeActionRequestIdAndStatus_PrevAndNext(
		Session session, Comment comment, long type, String action,
		long requestId, boolean status,
		OrderByComparator<Comment> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				7 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(6);
		}

		sb.append(_SQL_SELECT_COMMENT_WHERE);

		sb.append(_FINDER_COLUMN_TYPEACTIONREQUESTIDANDSTATUS_TYPE_2);

		boolean bindAction = false;

		if (action.isEmpty()) {
			sb.append(_FINDER_COLUMN_TYPEACTIONREQUESTIDANDSTATUS_ACTION_3);
		}
		else {
			bindAction = true;

			sb.append(_FINDER_COLUMN_TYPEACTIONREQUESTIDANDSTATUS_ACTION_2);
		}

		sb.append(_FINDER_COLUMN_TYPEACTIONREQUESTIDANDSTATUS_REQUESTID_2);

		sb.append(_FINDER_COLUMN_TYPEACTIONREQUESTIDANDSTATUS_STATUS_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(CommentModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(type);

		if (bindAction) {
			queryPos.add(action);
		}

		queryPos.add(requestId);

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(comment)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Comment> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the comments where type = &#63; and action = &#63; and requestId = &#63; and status = &#63; from the database.
	 *
	 * @param type the type
	 * @param action the action
	 * @param requestId the request ID
	 * @param status the status
	 */
	@Override
	public void removeByTypeActionRequestIdAndStatus(
		long type, String action, long requestId, boolean status) {

		for (Comment comment :
				findByTypeActionRequestIdAndStatus(
					type, action, requestId, status, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(comment);
		}
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
	@Override
	public int countByTypeActionRequestIdAndStatus(
		long type, String action, long requestId, boolean status) {

		action = Objects.toString(action, "");

		FinderPath finderPath = _finderPathCountByTypeActionRequestIdAndStatus;

		Object[] finderArgs = new Object[] {type, action, requestId, status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(5);

			sb.append(_SQL_COUNT_COMMENT_WHERE);

			sb.append(_FINDER_COLUMN_TYPEACTIONREQUESTIDANDSTATUS_TYPE_2);

			boolean bindAction = false;

			if (action.isEmpty()) {
				sb.append(_FINDER_COLUMN_TYPEACTIONREQUESTIDANDSTATUS_ACTION_3);
			}
			else {
				bindAction = true;

				sb.append(_FINDER_COLUMN_TYPEACTIONREQUESTIDANDSTATUS_ACTION_2);
			}

			sb.append(_FINDER_COLUMN_TYPEACTIONREQUESTIDANDSTATUS_REQUESTID_2);

			sb.append(_FINDER_COLUMN_TYPEACTIONREQUESTIDANDSTATUS_STATUS_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(type);

				if (bindAction) {
					queryPos.add(action);
				}

				queryPos.add(requestId);

				queryPos.add(status);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String
		_FINDER_COLUMN_TYPEACTIONREQUESTIDANDSTATUS_TYPE_2 =
			"comment.type = ? AND ";

	private static final String
		_FINDER_COLUMN_TYPEACTIONREQUESTIDANDSTATUS_ACTION_2 =
			"comment.action = ? AND ";

	private static final String
		_FINDER_COLUMN_TYPEACTIONREQUESTIDANDSTATUS_ACTION_3 =
			"(comment.action IS NULL OR comment.action = '') AND ";

	private static final String
		_FINDER_COLUMN_TYPEACTIONREQUESTIDANDSTATUS_REQUESTID_2 =
			"comment.requestId = ? AND ";

	private static final String
		_FINDER_COLUMN_TYPEACTIONREQUESTIDANDSTATUS_STATUS_2 =
			"comment.status = ?";

	public CommentPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("type", "type_");
		dbColumnNames.put("comment", "comment_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Comment.class);

		setModelImplClass(CommentImpl.class);
		setModelPKClass(long.class);

		setTable(CommentTable.INSTANCE);
	}

	/**
	 * Caches the comment in the entity cache if it is enabled.
	 *
	 * @param comment the comment
	 */
	@Override
	public void cacheResult(Comment comment) {
		entityCache.putResult(
			CommentImpl.class, comment.getPrimaryKey(), comment);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {comment.getUuid(), comment.getGroupId()}, comment);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the comments in the entity cache if it is enabled.
	 *
	 * @param comments the comments
	 */
	@Override
	public void cacheResult(List<Comment> comments) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (comments.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Comment comment : comments) {
			if (entityCache.getResult(
					CommentImpl.class, comment.getPrimaryKey()) == null) {

				cacheResult(comment);
			}
		}
	}

	/**
	 * Clears the cache for all comments.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CommentImpl.class);

		finderCache.clearCache(CommentImpl.class);
	}

	/**
	 * Clears the cache for the comment.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Comment comment) {
		entityCache.removeResult(CommentImpl.class, comment);
	}

	@Override
	public void clearCache(List<Comment> comments) {
		for (Comment comment : comments) {
			entityCache.removeResult(CommentImpl.class, comment);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(CommentImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(CommentImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(CommentModelImpl commentModelImpl) {
		Object[] args = new Object[] {
			commentModelImpl.getUuid(), commentModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(_finderPathFetchByUUID_G, args, commentModelImpl);
	}

	/**
	 * Creates a new comment with the primary key. Does not add the comment to the database.
	 *
	 * @param commentId the primary key for the new comment
	 * @return the new comment
	 */
	@Override
	public Comment create(long commentId) {
		Comment comment = new CommentImpl();

		comment.setNew(true);
		comment.setPrimaryKey(commentId);

		String uuid = PortalUUIDUtil.generate();

		comment.setUuid(uuid);

		comment.setCompanyId(CompanyThreadLocal.getCompanyId());

		return comment;
	}

	/**
	 * Removes the comment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param commentId the primary key of the comment
	 * @return the comment that was removed
	 * @throws NoSuchCommentException if a comment with the primary key could not be found
	 */
	@Override
	public Comment remove(long commentId) throws NoSuchCommentException {
		return remove((Serializable)commentId);
	}

	/**
	 * Removes the comment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the comment
	 * @return the comment that was removed
	 * @throws NoSuchCommentException if a comment with the primary key could not be found
	 */
	@Override
	public Comment remove(Serializable primaryKey)
		throws NoSuchCommentException {

		Session session = null;

		try {
			session = openSession();

			Comment comment = (Comment)session.get(
				CommentImpl.class, primaryKey);

			if (comment == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCommentException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(comment);
		}
		catch (NoSuchCommentException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Comment removeImpl(Comment comment) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(comment)) {
				comment = (Comment)session.get(
					CommentImpl.class, comment.getPrimaryKeyObj());
			}

			if (comment != null) {
				session.delete(comment);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (comment != null) {
			clearCache(comment);
		}

		return comment;
	}

	@Override
	public Comment updateImpl(Comment comment) {
		boolean isNew = comment.isNew();

		if (!(comment instanceof CommentModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(comment.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(comment);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in comment proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Comment implementation " +
					comment.getClass());
		}

		CommentModelImpl commentModelImpl = (CommentModelImpl)comment;

		if (Validator.isNull(comment.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			comment.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (comment.getCreateDate() == null)) {
			if (serviceContext == null) {
				comment.setCreateDate(date);
			}
			else {
				comment.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!commentModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				comment.setModifiedDate(date);
			}
			else {
				comment.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(comment);
			}
			else {
				comment = (Comment)session.merge(comment);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(CommentImpl.class, commentModelImpl, false, true);

		cacheUniqueFindersCache(commentModelImpl);

		if (isNew) {
			comment.setNew(false);
		}

		comment.resetOriginalValues();

		return comment;
	}

	/**
	 * Returns the comment with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the comment
	 * @return the comment
	 * @throws NoSuchCommentException if a comment with the primary key could not be found
	 */
	@Override
	public Comment findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCommentException {

		Comment comment = fetchByPrimaryKey(primaryKey);

		if (comment == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCommentException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return comment;
	}

	/**
	 * Returns the comment with the primary key or throws a <code>NoSuchCommentException</code> if it could not be found.
	 *
	 * @param commentId the primary key of the comment
	 * @return the comment
	 * @throws NoSuchCommentException if a comment with the primary key could not be found
	 */
	@Override
	public Comment findByPrimaryKey(long commentId)
		throws NoSuchCommentException {

		return findByPrimaryKey((Serializable)commentId);
	}

	/**
	 * Returns the comment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param commentId the primary key of the comment
	 * @return the comment, or <code>null</code> if a comment with the primary key could not be found
	 */
	@Override
	public Comment fetchByPrimaryKey(long commentId) {
		return fetchByPrimaryKey((Serializable)commentId);
	}

	/**
	 * Returns all the comments.
	 *
	 * @return the comments
	 */
	@Override
	public List<Comment> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Comment> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Comment> findAll(
		int start, int end, OrderByComparator<Comment> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Comment> findAll(
		int start, int end, OrderByComparator<Comment> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<Comment> list = null;

		if (useFinderCache) {
			list = (List<Comment>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_COMMENT);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_COMMENT;

				sql = sql.concat(CommentModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Comment>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the comments from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Comment comment : findAll()) {
			remove(comment);
		}
	}

	/**
	 * Returns the number of comments.
	 *
	 * @return the number of comments
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_COMMENT);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "commentId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_COMMENT;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CommentModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the comment persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"uuid_"}, true);

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			true);

		_finderPathCountByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			false);

		_finderPathFetchByUUID_G = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, true);

		_finderPathCountByUUID_G = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, false);

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathCountByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, false);

		_finderPathWithPaginationFindByType = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByType",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"type_"}, true);

		_finderPathWithoutPaginationFindByType = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByType",
			new String[] {Long.class.getName()}, new String[] {"type_"}, true);

		_finderPathCountByType = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByType",
			new String[] {Long.class.getName()}, new String[] {"type_"}, false);

		_finderPathWithPaginationFindByStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStatus",
			new String[] {
				Boolean.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"status"}, true);

		_finderPathWithoutPaginationFindByStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStatus",
			new String[] {Boolean.class.getName()}, new String[] {"status"},
			true);

		_finderPathCountByStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStatus",
			new String[] {Boolean.class.getName()}, new String[] {"status"},
			false);

		_finderPathWithPaginationFindByRequestId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByRequestId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"requestId"}, true);

		_finderPathWithoutPaginationFindByRequestId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByRequestId",
			new String[] {Long.class.getName()}, new String[] {"requestId"},
			true);

		_finderPathCountByRequestId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByRequestId",
			new String[] {Long.class.getName()}, new String[] {"requestId"},
			false);

		_finderPathWithPaginationFindByRequestIdAndStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByRequestIdAndStatus",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"requestId", "status"}, true);

		_finderPathWithoutPaginationFindByRequestIdAndStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByRequestIdAndStatus",
			new String[] {Long.class.getName(), Boolean.class.getName()},
			new String[] {"requestId", "status"}, true);

		_finderPathCountByRequestIdAndStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByRequestIdAndStatus",
			new String[] {Long.class.getName(), Boolean.class.getName()},
			new String[] {"requestId", "status"}, false);

		_finderPathWithPaginationFindByTypeRequestIdAndStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByTypeRequestIdAndStatus",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"type_", "requestId", "status"}, true);

		_finderPathWithoutPaginationFindByTypeRequestIdAndStatus =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByTypeRequestIdAndStatus",
				new String[] {
					Long.class.getName(), Long.class.getName(),
					Boolean.class.getName()
				},
				new String[] {"type_", "requestId", "status"}, true);

		_finderPathCountByTypeRequestIdAndStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByTypeRequestIdAndStatus",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			},
			new String[] {"type_", "requestId", "status"}, false);

		_finderPathWithPaginationFindByTypeActionRequestIdAndStatus =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByTypeActionRequestIdAndStatus",
				new String[] {
					Long.class.getName(), String.class.getName(),
					Long.class.getName(), Boolean.class.getName(),
					Integer.class.getName(), Integer.class.getName(),
					OrderByComparator.class.getName()
				},
				new String[] {"type_", "action", "requestId", "status"}, true);

		_finderPathWithoutPaginationFindByTypeActionRequestIdAndStatus =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByTypeActionRequestIdAndStatus",
				new String[] {
					Long.class.getName(), String.class.getName(),
					Long.class.getName(), Boolean.class.getName()
				},
				new String[] {"type_", "action", "requestId", "status"}, true);

		_finderPathCountByTypeActionRequestIdAndStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByTypeActionRequestIdAndStatus",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName(), Boolean.class.getName()
			},
			new String[] {"type_", "action", "requestId", "status"}, false);

		CommentUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		CommentUtil.setPersistence(null);

		entityCache.removeCache(CommentImpl.class.getName());
	}

	@Override
	@Reference(
		target = axPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = axPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = axPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_COMMENT =
		"SELECT comment FROM Comment comment";

	private static final String _SQL_SELECT_COMMENT_WHERE =
		"SELECT comment FROM Comment comment WHERE ";

	private static final String _SQL_COUNT_COMMENT =
		"SELECT COUNT(comment) FROM Comment comment";

	private static final String _SQL_COUNT_COMMENT_WHERE =
		"SELECT COUNT(comment) FROM Comment comment WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "comment.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Comment exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Comment exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		CommentPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "type", "comment"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}