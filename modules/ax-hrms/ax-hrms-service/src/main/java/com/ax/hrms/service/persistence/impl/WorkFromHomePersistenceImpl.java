/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence.impl;

import com.ax.hrms.exception.NoSuchWorkFromHomeException;
import com.ax.hrms.model.WorkFromHome;
import com.ax.hrms.model.WorkFromHomeTable;
import com.ax.hrms.model.impl.WorkFromHomeImpl;
import com.ax.hrms.model.impl.WorkFromHomeModelImpl;
import com.ax.hrms.service.persistence.WorkFromHomePersistence;
import com.ax.hrms.service.persistence.WorkFromHomeUtil;
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

import java.sql.Timestamp;

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
 * The persistence implementation for the work from home service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = WorkFromHomePersistence.class)
public class WorkFromHomePersistenceImpl
	extends BasePersistenceImpl<WorkFromHome>
	implements WorkFromHomePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>WorkFromHomeUtil</code> to access the work from home persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		WorkFromHomeImpl.class.getName();

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
	 * Returns all the work from homes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching work from homes
	 */
	@Override
	public List<WorkFromHome> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the work from homes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of work from homes
	 * @param end the upper bound of the range of work from homes (not inclusive)
	 * @return the range of matching work from homes
	 */
	@Override
	public List<WorkFromHome> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the work from homes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of work from homes
	 * @param end the upper bound of the range of work from homes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work from homes
	 */
	@Override
	public List<WorkFromHome> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<WorkFromHome> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the work from homes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of work from homes
	 * @param end the upper bound of the range of work from homes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work from homes
	 */
	@Override
	public List<WorkFromHome> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<WorkFromHome> orderByComparator,
		boolean useFinderCache) {

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

		List<WorkFromHome> list = null;

		if (useFinderCache) {
			list = (List<WorkFromHome>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (WorkFromHome workFromHome : list) {
					if (!uuid.equals(workFromHome.getUuid())) {
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

			sb.append(_SQL_SELECT_WORKFROMHOME_WHERE);

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
				sb.append(WorkFromHomeModelImpl.ORDER_BY_JPQL);
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

				list = (List<WorkFromHome>)QueryUtil.list(
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
	 * Returns the first work from home in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work from home
	 * @throws NoSuchWorkFromHomeException if a matching work from home could not be found
	 */
	@Override
	public WorkFromHome findByUuid_First(
			String uuid, OrderByComparator<WorkFromHome> orderByComparator)
		throws NoSuchWorkFromHomeException {

		WorkFromHome workFromHome = fetchByUuid_First(uuid, orderByComparator);

		if (workFromHome != null) {
			return workFromHome;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchWorkFromHomeException(sb.toString());
	}

	/**
	 * Returns the first work from home in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work from home, or <code>null</code> if a matching work from home could not be found
	 */
	@Override
	public WorkFromHome fetchByUuid_First(
		String uuid, OrderByComparator<WorkFromHome> orderByComparator) {

		List<WorkFromHome> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last work from home in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work from home
	 * @throws NoSuchWorkFromHomeException if a matching work from home could not be found
	 */
	@Override
	public WorkFromHome findByUuid_Last(
			String uuid, OrderByComparator<WorkFromHome> orderByComparator)
		throws NoSuchWorkFromHomeException {

		WorkFromHome workFromHome = fetchByUuid_Last(uuid, orderByComparator);

		if (workFromHome != null) {
			return workFromHome;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchWorkFromHomeException(sb.toString());
	}

	/**
	 * Returns the last work from home in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work from home, or <code>null</code> if a matching work from home could not be found
	 */
	@Override
	public WorkFromHome fetchByUuid_Last(
		String uuid, OrderByComparator<WorkFromHome> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<WorkFromHome> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the work from homes before and after the current work from home in the ordered set where uuid = &#63;.
	 *
	 * @param workFromHomeRequestId the primary key of the current work from home
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work from home
	 * @throws NoSuchWorkFromHomeException if a work from home with the primary key could not be found
	 */
	@Override
	public WorkFromHome[] findByUuid_PrevAndNext(
			long workFromHomeRequestId, String uuid,
			OrderByComparator<WorkFromHome> orderByComparator)
		throws NoSuchWorkFromHomeException {

		uuid = Objects.toString(uuid, "");

		WorkFromHome workFromHome = findByPrimaryKey(workFromHomeRequestId);

		Session session = null;

		try {
			session = openSession();

			WorkFromHome[] array = new WorkFromHomeImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, workFromHome, uuid, orderByComparator, true);

			array[1] = workFromHome;

			array[2] = getByUuid_PrevAndNext(
				session, workFromHome, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected WorkFromHome getByUuid_PrevAndNext(
		Session session, WorkFromHome workFromHome, String uuid,
		OrderByComparator<WorkFromHome> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_WORKFROMHOME_WHERE);

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
			sb.append(WorkFromHomeModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(workFromHome)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<WorkFromHome> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the work from homes where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (WorkFromHome workFromHome :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(workFromHome);
		}
	}

	/**
	 * Returns the number of work from homes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching work from homes
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_WORKFROMHOME_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"workFromHome.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(workFromHome.uuid IS NULL OR workFromHome.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the work from home where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchWorkFromHomeException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching work from home
	 * @throws NoSuchWorkFromHomeException if a matching work from home could not be found
	 */
	@Override
	public WorkFromHome findByUUID_G(String uuid, long groupId)
		throws NoSuchWorkFromHomeException {

		WorkFromHome workFromHome = fetchByUUID_G(uuid, groupId);

		if (workFromHome == null) {
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

			throw new NoSuchWorkFromHomeException(sb.toString());
		}

		return workFromHome;
	}

	/**
	 * Returns the work from home where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching work from home, or <code>null</code> if a matching work from home could not be found
	 */
	@Override
	public WorkFromHome fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the work from home where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching work from home, or <code>null</code> if a matching work from home could not be found
	 */
	@Override
	public WorkFromHome fetchByUUID_G(
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

		if (result instanceof WorkFromHome) {
			WorkFromHome workFromHome = (WorkFromHome)result;

			if (!Objects.equals(uuid, workFromHome.getUuid()) ||
				(groupId != workFromHome.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_WORKFROMHOME_WHERE);

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

				List<WorkFromHome> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					WorkFromHome workFromHome = list.get(0);

					result = workFromHome;

					cacheResult(workFromHome);
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
			return (WorkFromHome)result;
		}
	}

	/**
	 * Removes the work from home where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the work from home that was removed
	 */
	@Override
	public WorkFromHome removeByUUID_G(String uuid, long groupId)
		throws NoSuchWorkFromHomeException {

		WorkFromHome workFromHome = findByUUID_G(uuid, groupId);

		return remove(workFromHome);
	}

	/**
	 * Returns the number of work from homes where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching work from homes
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_WORKFROMHOME_WHERE);

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
		"workFromHome.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(workFromHome.uuid IS NULL OR workFromHome.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"workFromHome.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the work from homes where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching work from homes
	 */
	@Override
	public List<WorkFromHome> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the work from homes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of work from homes
	 * @param end the upper bound of the range of work from homes (not inclusive)
	 * @return the range of matching work from homes
	 */
	@Override
	public List<WorkFromHome> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the work from homes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of work from homes
	 * @param end the upper bound of the range of work from homes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work from homes
	 */
	@Override
	public List<WorkFromHome> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<WorkFromHome> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the work from homes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of work from homes
	 * @param end the upper bound of the range of work from homes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work from homes
	 */
	@Override
	public List<WorkFromHome> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<WorkFromHome> orderByComparator,
		boolean useFinderCache) {

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

		List<WorkFromHome> list = null;

		if (useFinderCache) {
			list = (List<WorkFromHome>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (WorkFromHome workFromHome : list) {
					if (!uuid.equals(workFromHome.getUuid()) ||
						(companyId != workFromHome.getCompanyId())) {

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

			sb.append(_SQL_SELECT_WORKFROMHOME_WHERE);

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
				sb.append(WorkFromHomeModelImpl.ORDER_BY_JPQL);
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

				list = (List<WorkFromHome>)QueryUtil.list(
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
	 * Returns the first work from home in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work from home
	 * @throws NoSuchWorkFromHomeException if a matching work from home could not be found
	 */
	@Override
	public WorkFromHome findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<WorkFromHome> orderByComparator)
		throws NoSuchWorkFromHomeException {

		WorkFromHome workFromHome = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (workFromHome != null) {
			return workFromHome;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchWorkFromHomeException(sb.toString());
	}

	/**
	 * Returns the first work from home in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work from home, or <code>null</code> if a matching work from home could not be found
	 */
	@Override
	public WorkFromHome fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<WorkFromHome> orderByComparator) {

		List<WorkFromHome> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last work from home in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work from home
	 * @throws NoSuchWorkFromHomeException if a matching work from home could not be found
	 */
	@Override
	public WorkFromHome findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<WorkFromHome> orderByComparator)
		throws NoSuchWorkFromHomeException {

		WorkFromHome workFromHome = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (workFromHome != null) {
			return workFromHome;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchWorkFromHomeException(sb.toString());
	}

	/**
	 * Returns the last work from home in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work from home, or <code>null</code> if a matching work from home could not be found
	 */
	@Override
	public WorkFromHome fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<WorkFromHome> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<WorkFromHome> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the work from homes before and after the current work from home in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param workFromHomeRequestId the primary key of the current work from home
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work from home
	 * @throws NoSuchWorkFromHomeException if a work from home with the primary key could not be found
	 */
	@Override
	public WorkFromHome[] findByUuid_C_PrevAndNext(
			long workFromHomeRequestId, String uuid, long companyId,
			OrderByComparator<WorkFromHome> orderByComparator)
		throws NoSuchWorkFromHomeException {

		uuid = Objects.toString(uuid, "");

		WorkFromHome workFromHome = findByPrimaryKey(workFromHomeRequestId);

		Session session = null;

		try {
			session = openSession();

			WorkFromHome[] array = new WorkFromHomeImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, workFromHome, uuid, companyId, orderByComparator,
				true);

			array[1] = workFromHome;

			array[2] = getByUuid_C_PrevAndNext(
				session, workFromHome, uuid, companyId, orderByComparator,
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

	protected WorkFromHome getByUuid_C_PrevAndNext(
		Session session, WorkFromHome workFromHome, String uuid, long companyId,
		OrderByComparator<WorkFromHome> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_WORKFROMHOME_WHERE);

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
			sb.append(WorkFromHomeModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(workFromHome)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<WorkFromHome> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the work from homes where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (WorkFromHome workFromHome :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(workFromHome);
		}
	}

	/**
	 * Returns the number of work from homes where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching work from homes
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_WORKFROMHOME_WHERE);

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
		"workFromHome.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(workFromHome.uuid IS NULL OR workFromHome.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"workFromHome.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByUserId;
	private FinderPath _finderPathWithoutPaginationFindByUserId;
	private FinderPath _finderPathCountByUserId;

	/**
	 * Returns all the work from homes where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching work from homes
	 */
	@Override
	public List<WorkFromHome> findByUserId(long userId) {
		return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the work from homes where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of work from homes
	 * @param end the upper bound of the range of work from homes (not inclusive)
	 * @return the range of matching work from homes
	 */
	@Override
	public List<WorkFromHome> findByUserId(long userId, int start, int end) {
		return findByUserId(userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the work from homes where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of work from homes
	 * @param end the upper bound of the range of work from homes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work from homes
	 */
	@Override
	public List<WorkFromHome> findByUserId(
		long userId, int start, int end,
		OrderByComparator<WorkFromHome> orderByComparator) {

		return findByUserId(userId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the work from homes where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of work from homes
	 * @param end the upper bound of the range of work from homes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work from homes
	 */
	@Override
	public List<WorkFromHome> findByUserId(
		long userId, int start, int end,
		OrderByComparator<WorkFromHome> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUserId;
				finderArgs = new Object[] {userId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUserId;
			finderArgs = new Object[] {userId, start, end, orderByComparator};
		}

		List<WorkFromHome> list = null;

		if (useFinderCache) {
			list = (List<WorkFromHome>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (WorkFromHome workFromHome : list) {
					if (userId != workFromHome.getUserId()) {
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

			sb.append(_SQL_SELECT_WORKFROMHOME_WHERE);

			sb.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(WorkFromHomeModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				list = (List<WorkFromHome>)QueryUtil.list(
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
	 * Returns the first work from home in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work from home
	 * @throws NoSuchWorkFromHomeException if a matching work from home could not be found
	 */
	@Override
	public WorkFromHome findByUserId_First(
			long userId, OrderByComparator<WorkFromHome> orderByComparator)
		throws NoSuchWorkFromHomeException {

		WorkFromHome workFromHome = fetchByUserId_First(
			userId, orderByComparator);

		if (workFromHome != null) {
			return workFromHome;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchWorkFromHomeException(sb.toString());
	}

	/**
	 * Returns the first work from home in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work from home, or <code>null</code> if a matching work from home could not be found
	 */
	@Override
	public WorkFromHome fetchByUserId_First(
		long userId, OrderByComparator<WorkFromHome> orderByComparator) {

		List<WorkFromHome> list = findByUserId(userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last work from home in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work from home
	 * @throws NoSuchWorkFromHomeException if a matching work from home could not be found
	 */
	@Override
	public WorkFromHome findByUserId_Last(
			long userId, OrderByComparator<WorkFromHome> orderByComparator)
		throws NoSuchWorkFromHomeException {

		WorkFromHome workFromHome = fetchByUserId_Last(
			userId, orderByComparator);

		if (workFromHome != null) {
			return workFromHome;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchWorkFromHomeException(sb.toString());
	}

	/**
	 * Returns the last work from home in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work from home, or <code>null</code> if a matching work from home could not be found
	 */
	@Override
	public WorkFromHome fetchByUserId_Last(
		long userId, OrderByComparator<WorkFromHome> orderByComparator) {

		int count = countByUserId(userId);

		if (count == 0) {
			return null;
		}

		List<WorkFromHome> list = findByUserId(
			userId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the work from homes before and after the current work from home in the ordered set where userId = &#63;.
	 *
	 * @param workFromHomeRequestId the primary key of the current work from home
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work from home
	 * @throws NoSuchWorkFromHomeException if a work from home with the primary key could not be found
	 */
	@Override
	public WorkFromHome[] findByUserId_PrevAndNext(
			long workFromHomeRequestId, long userId,
			OrderByComparator<WorkFromHome> orderByComparator)
		throws NoSuchWorkFromHomeException {

		WorkFromHome workFromHome = findByPrimaryKey(workFromHomeRequestId);

		Session session = null;

		try {
			session = openSession();

			WorkFromHome[] array = new WorkFromHomeImpl[3];

			array[0] = getByUserId_PrevAndNext(
				session, workFromHome, userId, orderByComparator, true);

			array[1] = workFromHome;

			array[2] = getByUserId_PrevAndNext(
				session, workFromHome, userId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected WorkFromHome getByUserId_PrevAndNext(
		Session session, WorkFromHome workFromHome, long userId,
		OrderByComparator<WorkFromHome> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_WORKFROMHOME_WHERE);

		sb.append(_FINDER_COLUMN_USERID_USERID_2);

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
			sb.append(WorkFromHomeModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(userId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(workFromHome)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<WorkFromHome> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the work from homes where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	@Override
	public void removeByUserId(long userId) {
		for (WorkFromHome workFromHome :
				findByUserId(
					userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(workFromHome);
		}
	}

	/**
	 * Returns the number of work from homes where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching work from homes
	 */
	@Override
	public int countByUserId(long userId) {
		FinderPath finderPath = _finderPathCountByUserId;

		Object[] finderArgs = new Object[] {userId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_WORKFROMHOME_WHERE);

			sb.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

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

	private static final String _FINDER_COLUMN_USERID_USERID_2 =
		"workFromHome.userId = ?";

	private FinderPath _finderPathWithPaginationFindByStatus;
	private FinderPath _finderPathWithoutPaginationFindByStatus;
	private FinderPath _finderPathCountByStatus;

	/**
	 * Returns all the work from homes where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching work from homes
	 */
	@Override
	public List<WorkFromHome> findByStatus(long status) {
		return findByStatus(status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the work from homes where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of work from homes
	 * @param end the upper bound of the range of work from homes (not inclusive)
	 * @return the range of matching work from homes
	 */
	@Override
	public List<WorkFromHome> findByStatus(long status, int start, int end) {
		return findByStatus(status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the work from homes where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of work from homes
	 * @param end the upper bound of the range of work from homes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work from homes
	 */
	@Override
	public List<WorkFromHome> findByStatus(
		long status, int start, int end,
		OrderByComparator<WorkFromHome> orderByComparator) {

		return findByStatus(status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the work from homes where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of work from homes
	 * @param end the upper bound of the range of work from homes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work from homes
	 */
	@Override
	public List<WorkFromHome> findByStatus(
		long status, int start, int end,
		OrderByComparator<WorkFromHome> orderByComparator,
		boolean useFinderCache) {

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

		List<WorkFromHome> list = null;

		if (useFinderCache) {
			list = (List<WorkFromHome>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (WorkFromHome workFromHome : list) {
					if (status != workFromHome.getStatus()) {
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

			sb.append(_SQL_SELECT_WORKFROMHOME_WHERE);

			sb.append(_FINDER_COLUMN_STATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(WorkFromHomeModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(status);

				list = (List<WorkFromHome>)QueryUtil.list(
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
	 * Returns the first work from home in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work from home
	 * @throws NoSuchWorkFromHomeException if a matching work from home could not be found
	 */
	@Override
	public WorkFromHome findByStatus_First(
			long status, OrderByComparator<WorkFromHome> orderByComparator)
		throws NoSuchWorkFromHomeException {

		WorkFromHome workFromHome = fetchByStatus_First(
			status, orderByComparator);

		if (workFromHome != null) {
			return workFromHome;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchWorkFromHomeException(sb.toString());
	}

	/**
	 * Returns the first work from home in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work from home, or <code>null</code> if a matching work from home could not be found
	 */
	@Override
	public WorkFromHome fetchByStatus_First(
		long status, OrderByComparator<WorkFromHome> orderByComparator) {

		List<WorkFromHome> list = findByStatus(status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last work from home in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work from home
	 * @throws NoSuchWorkFromHomeException if a matching work from home could not be found
	 */
	@Override
	public WorkFromHome findByStatus_Last(
			long status, OrderByComparator<WorkFromHome> orderByComparator)
		throws NoSuchWorkFromHomeException {

		WorkFromHome workFromHome = fetchByStatus_Last(
			status, orderByComparator);

		if (workFromHome != null) {
			return workFromHome;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchWorkFromHomeException(sb.toString());
	}

	/**
	 * Returns the last work from home in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work from home, or <code>null</code> if a matching work from home could not be found
	 */
	@Override
	public WorkFromHome fetchByStatus_Last(
		long status, OrderByComparator<WorkFromHome> orderByComparator) {

		int count = countByStatus(status);

		if (count == 0) {
			return null;
		}

		List<WorkFromHome> list = findByStatus(
			status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the work from homes before and after the current work from home in the ordered set where status = &#63;.
	 *
	 * @param workFromHomeRequestId the primary key of the current work from home
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work from home
	 * @throws NoSuchWorkFromHomeException if a work from home with the primary key could not be found
	 */
	@Override
	public WorkFromHome[] findByStatus_PrevAndNext(
			long workFromHomeRequestId, long status,
			OrderByComparator<WorkFromHome> orderByComparator)
		throws NoSuchWorkFromHomeException {

		WorkFromHome workFromHome = findByPrimaryKey(workFromHomeRequestId);

		Session session = null;

		try {
			session = openSession();

			WorkFromHome[] array = new WorkFromHomeImpl[3];

			array[0] = getByStatus_PrevAndNext(
				session, workFromHome, status, orderByComparator, true);

			array[1] = workFromHome;

			array[2] = getByStatus_PrevAndNext(
				session, workFromHome, status, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected WorkFromHome getByStatus_PrevAndNext(
		Session session, WorkFromHome workFromHome, long status,
		OrderByComparator<WorkFromHome> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_WORKFROMHOME_WHERE);

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
			sb.append(WorkFromHomeModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(workFromHome)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<WorkFromHome> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the work from homes where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	@Override
	public void removeByStatus(long status) {
		for (WorkFromHome workFromHome :
				findByStatus(
					status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(workFromHome);
		}
	}

	/**
	 * Returns the number of work from homes where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching work from homes
	 */
	@Override
	public int countByStatus(long status) {
		FinderPath finderPath = _finderPathCountByStatus;

		Object[] finderArgs = new Object[] {status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_WORKFROMHOME_WHERE);

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
		"workFromHome.status = ?";

	private FinderPath _finderPathWithPaginationFindByUserIdAndStatus;
	private FinderPath _finderPathWithoutPaginationFindByUserIdAndStatus;
	private FinderPath _finderPathCountByUserIdAndStatus;

	/**
	 * Returns all the work from homes where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching work from homes
	 */
	@Override
	public List<WorkFromHome> findByUserIdAndStatus(long userId, long status) {
		return findByUserIdAndStatus(
			userId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the work from homes where userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of work from homes
	 * @param end the upper bound of the range of work from homes (not inclusive)
	 * @return the range of matching work from homes
	 */
	@Override
	public List<WorkFromHome> findByUserIdAndStatus(
		long userId, long status, int start, int end) {

		return findByUserIdAndStatus(userId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the work from homes where userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of work from homes
	 * @param end the upper bound of the range of work from homes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work from homes
	 */
	@Override
	public List<WorkFromHome> findByUserIdAndStatus(
		long userId, long status, int start, int end,
		OrderByComparator<WorkFromHome> orderByComparator) {

		return findByUserIdAndStatus(
			userId, status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the work from homes where userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of work from homes
	 * @param end the upper bound of the range of work from homes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work from homes
	 */
	@Override
	public List<WorkFromHome> findByUserIdAndStatus(
		long userId, long status, int start, int end,
		OrderByComparator<WorkFromHome> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUserIdAndStatus;
				finderArgs = new Object[] {userId, status};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUserIdAndStatus;
			finderArgs = new Object[] {
				userId, status, start, end, orderByComparator
			};
		}

		List<WorkFromHome> list = null;

		if (useFinderCache) {
			list = (List<WorkFromHome>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (WorkFromHome workFromHome : list) {
					if ((userId != workFromHome.getUserId()) ||
						(status != workFromHome.getStatus())) {

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

			sb.append(_SQL_SELECT_WORKFROMHOME_WHERE);

			sb.append(_FINDER_COLUMN_USERIDANDSTATUS_USERID_2);

			sb.append(_FINDER_COLUMN_USERIDANDSTATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(WorkFromHomeModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				queryPos.add(status);

				list = (List<WorkFromHome>)QueryUtil.list(
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
	 * Returns the first work from home in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work from home
	 * @throws NoSuchWorkFromHomeException if a matching work from home could not be found
	 */
	@Override
	public WorkFromHome findByUserIdAndStatus_First(
			long userId, long status,
			OrderByComparator<WorkFromHome> orderByComparator)
		throws NoSuchWorkFromHomeException {

		WorkFromHome workFromHome = fetchByUserIdAndStatus_First(
			userId, status, orderByComparator);

		if (workFromHome != null) {
			return workFromHome;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchWorkFromHomeException(sb.toString());
	}

	/**
	 * Returns the first work from home in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work from home, or <code>null</code> if a matching work from home could not be found
	 */
	@Override
	public WorkFromHome fetchByUserIdAndStatus_First(
		long userId, long status,
		OrderByComparator<WorkFromHome> orderByComparator) {

		List<WorkFromHome> list = findByUserIdAndStatus(
			userId, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last work from home in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work from home
	 * @throws NoSuchWorkFromHomeException if a matching work from home could not be found
	 */
	@Override
	public WorkFromHome findByUserIdAndStatus_Last(
			long userId, long status,
			OrderByComparator<WorkFromHome> orderByComparator)
		throws NoSuchWorkFromHomeException {

		WorkFromHome workFromHome = fetchByUserIdAndStatus_Last(
			userId, status, orderByComparator);

		if (workFromHome != null) {
			return workFromHome;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchWorkFromHomeException(sb.toString());
	}

	/**
	 * Returns the last work from home in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work from home, or <code>null</code> if a matching work from home could not be found
	 */
	@Override
	public WorkFromHome fetchByUserIdAndStatus_Last(
		long userId, long status,
		OrderByComparator<WorkFromHome> orderByComparator) {

		int count = countByUserIdAndStatus(userId, status);

		if (count == 0) {
			return null;
		}

		List<WorkFromHome> list = findByUserIdAndStatus(
			userId, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the work from homes before and after the current work from home in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param workFromHomeRequestId the primary key of the current work from home
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work from home
	 * @throws NoSuchWorkFromHomeException if a work from home with the primary key could not be found
	 */
	@Override
	public WorkFromHome[] findByUserIdAndStatus_PrevAndNext(
			long workFromHomeRequestId, long userId, long status,
			OrderByComparator<WorkFromHome> orderByComparator)
		throws NoSuchWorkFromHomeException {

		WorkFromHome workFromHome = findByPrimaryKey(workFromHomeRequestId);

		Session session = null;

		try {
			session = openSession();

			WorkFromHome[] array = new WorkFromHomeImpl[3];

			array[0] = getByUserIdAndStatus_PrevAndNext(
				session, workFromHome, userId, status, orderByComparator, true);

			array[1] = workFromHome;

			array[2] = getByUserIdAndStatus_PrevAndNext(
				session, workFromHome, userId, status, orderByComparator,
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

	protected WorkFromHome getByUserIdAndStatus_PrevAndNext(
		Session session, WorkFromHome workFromHome, long userId, long status,
		OrderByComparator<WorkFromHome> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_WORKFROMHOME_WHERE);

		sb.append(_FINDER_COLUMN_USERIDANDSTATUS_USERID_2);

		sb.append(_FINDER_COLUMN_USERIDANDSTATUS_STATUS_2);

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
			sb.append(WorkFromHomeModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(userId);

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(workFromHome)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<WorkFromHome> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the work from homes where userId = &#63; and status = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param status the status
	 */
	@Override
	public void removeByUserIdAndStatus(long userId, long status) {
		for (WorkFromHome workFromHome :
				findByUserIdAndStatus(
					userId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(workFromHome);
		}
	}

	/**
	 * Returns the number of work from homes where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching work from homes
	 */
	@Override
	public int countByUserIdAndStatus(long userId, long status) {
		FinderPath finderPath = _finderPathCountByUserIdAndStatus;

		Object[] finderArgs = new Object[] {userId, status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_WORKFROMHOME_WHERE);

			sb.append(_FINDER_COLUMN_USERIDANDSTATUS_USERID_2);

			sb.append(_FINDER_COLUMN_USERIDANDSTATUS_STATUS_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

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

	private static final String _FINDER_COLUMN_USERIDANDSTATUS_USERID_2 =
		"workFromHome.userId = ? AND ";

	private static final String _FINDER_COLUMN_USERIDANDSTATUS_STATUS_2 =
		"workFromHome.status = ?";

	private FinderPath _finderPathWithPaginationFindByDateRange;
	private FinderPath _finderPathWithoutPaginationFindByDateRange;
	private FinderPath _finderPathCountByDateRange;

	/**
	 * Returns all the work from homes where startDate = &#63; and endDate = &#63;.
	 *
	 * @param startDate the start date
	 * @param endDate the end date
	 * @return the matching work from homes
	 */
	@Override
	public List<WorkFromHome> findByDateRange(Date startDate, Date endDate) {
		return findByDateRange(
			startDate, endDate, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the work from homes where startDate = &#63; and endDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeModelImpl</code>.
	 * </p>
	 *
	 * @param startDate the start date
	 * @param endDate the end date
	 * @param start the lower bound of the range of work from homes
	 * @param end the upper bound of the range of work from homes (not inclusive)
	 * @return the range of matching work from homes
	 */
	@Override
	public List<WorkFromHome> findByDateRange(
		Date startDate, Date endDate, int start, int end) {

		return findByDateRange(startDate, endDate, start, end, null);
	}

	/**
	 * Returns an ordered range of all the work from homes where startDate = &#63; and endDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeModelImpl</code>.
	 * </p>
	 *
	 * @param startDate the start date
	 * @param endDate the end date
	 * @param start the lower bound of the range of work from homes
	 * @param end the upper bound of the range of work from homes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work from homes
	 */
	@Override
	public List<WorkFromHome> findByDateRange(
		Date startDate, Date endDate, int start, int end,
		OrderByComparator<WorkFromHome> orderByComparator) {

		return findByDateRange(
			startDate, endDate, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the work from homes where startDate = &#63; and endDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeModelImpl</code>.
	 * </p>
	 *
	 * @param startDate the start date
	 * @param endDate the end date
	 * @param start the lower bound of the range of work from homes
	 * @param end the upper bound of the range of work from homes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work from homes
	 */
	@Override
	public List<WorkFromHome> findByDateRange(
		Date startDate, Date endDate, int start, int end,
		OrderByComparator<WorkFromHome> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByDateRange;
				finderArgs = new Object[] {
					_getTime(startDate), _getTime(endDate)
				};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByDateRange;
			finderArgs = new Object[] {
				_getTime(startDate), _getTime(endDate), start, end,
				orderByComparator
			};
		}

		List<WorkFromHome> list = null;

		if (useFinderCache) {
			list = (List<WorkFromHome>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (WorkFromHome workFromHome : list) {
					if (!Objects.equals(
							startDate, workFromHome.getStartDate()) ||
						!Objects.equals(endDate, workFromHome.getEndDate())) {

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

			sb.append(_SQL_SELECT_WORKFROMHOME_WHERE);

			boolean bindStartDate = false;

			if (startDate == null) {
				sb.append(_FINDER_COLUMN_DATERANGE_STARTDATE_1);
			}
			else {
				bindStartDate = true;

				sb.append(_FINDER_COLUMN_DATERANGE_STARTDATE_2);
			}

			boolean bindEndDate = false;

			if (endDate == null) {
				sb.append(_FINDER_COLUMN_DATERANGE_ENDDATE_1);
			}
			else {
				bindEndDate = true;

				sb.append(_FINDER_COLUMN_DATERANGE_ENDDATE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(WorkFromHomeModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindStartDate) {
					queryPos.add(new Timestamp(startDate.getTime()));
				}

				if (bindEndDate) {
					queryPos.add(new Timestamp(endDate.getTime()));
				}

				list = (List<WorkFromHome>)QueryUtil.list(
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
	 * Returns the first work from home in the ordered set where startDate = &#63; and endDate = &#63;.
	 *
	 * @param startDate the start date
	 * @param endDate the end date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work from home
	 * @throws NoSuchWorkFromHomeException if a matching work from home could not be found
	 */
	@Override
	public WorkFromHome findByDateRange_First(
			Date startDate, Date endDate,
			OrderByComparator<WorkFromHome> orderByComparator)
		throws NoSuchWorkFromHomeException {

		WorkFromHome workFromHome = fetchByDateRange_First(
			startDate, endDate, orderByComparator);

		if (workFromHome != null) {
			return workFromHome;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("startDate=");
		sb.append(startDate);

		sb.append(", endDate=");
		sb.append(endDate);

		sb.append("}");

		throw new NoSuchWorkFromHomeException(sb.toString());
	}

	/**
	 * Returns the first work from home in the ordered set where startDate = &#63; and endDate = &#63;.
	 *
	 * @param startDate the start date
	 * @param endDate the end date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work from home, or <code>null</code> if a matching work from home could not be found
	 */
	@Override
	public WorkFromHome fetchByDateRange_First(
		Date startDate, Date endDate,
		OrderByComparator<WorkFromHome> orderByComparator) {

		List<WorkFromHome> list = findByDateRange(
			startDate, endDate, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last work from home in the ordered set where startDate = &#63; and endDate = &#63;.
	 *
	 * @param startDate the start date
	 * @param endDate the end date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work from home
	 * @throws NoSuchWorkFromHomeException if a matching work from home could not be found
	 */
	@Override
	public WorkFromHome findByDateRange_Last(
			Date startDate, Date endDate,
			OrderByComparator<WorkFromHome> orderByComparator)
		throws NoSuchWorkFromHomeException {

		WorkFromHome workFromHome = fetchByDateRange_Last(
			startDate, endDate, orderByComparator);

		if (workFromHome != null) {
			return workFromHome;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("startDate=");
		sb.append(startDate);

		sb.append(", endDate=");
		sb.append(endDate);

		sb.append("}");

		throw new NoSuchWorkFromHomeException(sb.toString());
	}

	/**
	 * Returns the last work from home in the ordered set where startDate = &#63; and endDate = &#63;.
	 *
	 * @param startDate the start date
	 * @param endDate the end date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work from home, or <code>null</code> if a matching work from home could not be found
	 */
	@Override
	public WorkFromHome fetchByDateRange_Last(
		Date startDate, Date endDate,
		OrderByComparator<WorkFromHome> orderByComparator) {

		int count = countByDateRange(startDate, endDate);

		if (count == 0) {
			return null;
		}

		List<WorkFromHome> list = findByDateRange(
			startDate, endDate, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the work from homes before and after the current work from home in the ordered set where startDate = &#63; and endDate = &#63;.
	 *
	 * @param workFromHomeRequestId the primary key of the current work from home
	 * @param startDate the start date
	 * @param endDate the end date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work from home
	 * @throws NoSuchWorkFromHomeException if a work from home with the primary key could not be found
	 */
	@Override
	public WorkFromHome[] findByDateRange_PrevAndNext(
			long workFromHomeRequestId, Date startDate, Date endDate,
			OrderByComparator<WorkFromHome> orderByComparator)
		throws NoSuchWorkFromHomeException {

		WorkFromHome workFromHome = findByPrimaryKey(workFromHomeRequestId);

		Session session = null;

		try {
			session = openSession();

			WorkFromHome[] array = new WorkFromHomeImpl[3];

			array[0] = getByDateRange_PrevAndNext(
				session, workFromHome, startDate, endDate, orderByComparator,
				true);

			array[1] = workFromHome;

			array[2] = getByDateRange_PrevAndNext(
				session, workFromHome, startDate, endDate, orderByComparator,
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

	protected WorkFromHome getByDateRange_PrevAndNext(
		Session session, WorkFromHome workFromHome, Date startDate,
		Date endDate, OrderByComparator<WorkFromHome> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_WORKFROMHOME_WHERE);

		boolean bindStartDate = false;

		if (startDate == null) {
			sb.append(_FINDER_COLUMN_DATERANGE_STARTDATE_1);
		}
		else {
			bindStartDate = true;

			sb.append(_FINDER_COLUMN_DATERANGE_STARTDATE_2);
		}

		boolean bindEndDate = false;

		if (endDate == null) {
			sb.append(_FINDER_COLUMN_DATERANGE_ENDDATE_1);
		}
		else {
			bindEndDate = true;

			sb.append(_FINDER_COLUMN_DATERANGE_ENDDATE_2);
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
			sb.append(WorkFromHomeModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindStartDate) {
			queryPos.add(new Timestamp(startDate.getTime()));
		}

		if (bindEndDate) {
			queryPos.add(new Timestamp(endDate.getTime()));
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(workFromHome)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<WorkFromHome> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the work from homes where startDate = &#63; and endDate = &#63; from the database.
	 *
	 * @param startDate the start date
	 * @param endDate the end date
	 */
	@Override
	public void removeByDateRange(Date startDate, Date endDate) {
		for (WorkFromHome workFromHome :
				findByDateRange(
					startDate, endDate, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(workFromHome);
		}
	}

	/**
	 * Returns the number of work from homes where startDate = &#63; and endDate = &#63;.
	 *
	 * @param startDate the start date
	 * @param endDate the end date
	 * @return the number of matching work from homes
	 */
	@Override
	public int countByDateRange(Date startDate, Date endDate) {
		FinderPath finderPath = _finderPathCountByDateRange;

		Object[] finderArgs = new Object[] {
			_getTime(startDate), _getTime(endDate)
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_WORKFROMHOME_WHERE);

			boolean bindStartDate = false;

			if (startDate == null) {
				sb.append(_FINDER_COLUMN_DATERANGE_STARTDATE_1);
			}
			else {
				bindStartDate = true;

				sb.append(_FINDER_COLUMN_DATERANGE_STARTDATE_2);
			}

			boolean bindEndDate = false;

			if (endDate == null) {
				sb.append(_FINDER_COLUMN_DATERANGE_ENDDATE_1);
			}
			else {
				bindEndDate = true;

				sb.append(_FINDER_COLUMN_DATERANGE_ENDDATE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindStartDate) {
					queryPos.add(new Timestamp(startDate.getTime()));
				}

				if (bindEndDate) {
					queryPos.add(new Timestamp(endDate.getTime()));
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

	private static final String _FINDER_COLUMN_DATERANGE_STARTDATE_1 =
		"workFromHome.startDate IS NULL AND ";

	private static final String _FINDER_COLUMN_DATERANGE_STARTDATE_2 =
		"workFromHome.startDate = ? AND ";

	private static final String _FINDER_COLUMN_DATERANGE_ENDDATE_1 =
		"workFromHome.endDate IS NULL";

	private static final String _FINDER_COLUMN_DATERANGE_ENDDATE_2 =
		"workFromHome.endDate = ?";

	public WorkFromHomePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(WorkFromHome.class);

		setModelImplClass(WorkFromHomeImpl.class);
		setModelPKClass(long.class);

		setTable(WorkFromHomeTable.INSTANCE);
	}

	/**
	 * Caches the work from home in the entity cache if it is enabled.
	 *
	 * @param workFromHome the work from home
	 */
	@Override
	public void cacheResult(WorkFromHome workFromHome) {
		entityCache.putResult(
			WorkFromHomeImpl.class, workFromHome.getPrimaryKey(), workFromHome);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {workFromHome.getUuid(), workFromHome.getGroupId()},
			workFromHome);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the work from homes in the entity cache if it is enabled.
	 *
	 * @param workFromHomes the work from homes
	 */
	@Override
	public void cacheResult(List<WorkFromHome> workFromHomes) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (workFromHomes.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (WorkFromHome workFromHome : workFromHomes) {
			if (entityCache.getResult(
					WorkFromHomeImpl.class, workFromHome.getPrimaryKey()) ==
						null) {

				cacheResult(workFromHome);
			}
		}
	}

	/**
	 * Clears the cache for all work from homes.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(WorkFromHomeImpl.class);

		finderCache.clearCache(WorkFromHomeImpl.class);
	}

	/**
	 * Clears the cache for the work from home.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(WorkFromHome workFromHome) {
		entityCache.removeResult(WorkFromHomeImpl.class, workFromHome);
	}

	@Override
	public void clearCache(List<WorkFromHome> workFromHomes) {
		for (WorkFromHome workFromHome : workFromHomes) {
			entityCache.removeResult(WorkFromHomeImpl.class, workFromHome);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(WorkFromHomeImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(WorkFromHomeImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		WorkFromHomeModelImpl workFromHomeModelImpl) {

		Object[] args = new Object[] {
			workFromHomeModelImpl.getUuid(), workFromHomeModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, workFromHomeModelImpl);
	}

	/**
	 * Creates a new work from home with the primary key. Does not add the work from home to the database.
	 *
	 * @param workFromHomeRequestId the primary key for the new work from home
	 * @return the new work from home
	 */
	@Override
	public WorkFromHome create(long workFromHomeRequestId) {
		WorkFromHome workFromHome = new WorkFromHomeImpl();

		workFromHome.setNew(true);
		workFromHome.setPrimaryKey(workFromHomeRequestId);

		String uuid = PortalUUIDUtil.generate();

		workFromHome.setUuid(uuid);

		workFromHome.setCompanyId(CompanyThreadLocal.getCompanyId());

		return workFromHome;
	}

	/**
	 * Removes the work from home with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param workFromHomeRequestId the primary key of the work from home
	 * @return the work from home that was removed
	 * @throws NoSuchWorkFromHomeException if a work from home with the primary key could not be found
	 */
	@Override
	public WorkFromHome remove(long workFromHomeRequestId)
		throws NoSuchWorkFromHomeException {

		return remove((Serializable)workFromHomeRequestId);
	}

	/**
	 * Removes the work from home with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the work from home
	 * @return the work from home that was removed
	 * @throws NoSuchWorkFromHomeException if a work from home with the primary key could not be found
	 */
	@Override
	public WorkFromHome remove(Serializable primaryKey)
		throws NoSuchWorkFromHomeException {

		Session session = null;

		try {
			session = openSession();

			WorkFromHome workFromHome = (WorkFromHome)session.get(
				WorkFromHomeImpl.class, primaryKey);

			if (workFromHome == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchWorkFromHomeException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(workFromHome);
		}
		catch (NoSuchWorkFromHomeException noSuchEntityException) {
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
	protected WorkFromHome removeImpl(WorkFromHome workFromHome) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(workFromHome)) {
				workFromHome = (WorkFromHome)session.get(
					WorkFromHomeImpl.class, workFromHome.getPrimaryKeyObj());
			}

			if (workFromHome != null) {
				session.delete(workFromHome);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (workFromHome != null) {
			clearCache(workFromHome);
		}

		return workFromHome;
	}

	@Override
	public WorkFromHome updateImpl(WorkFromHome workFromHome) {
		boolean isNew = workFromHome.isNew();

		if (!(workFromHome instanceof WorkFromHomeModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(workFromHome.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					workFromHome);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in workFromHome proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom WorkFromHome implementation " +
					workFromHome.getClass());
		}

		WorkFromHomeModelImpl workFromHomeModelImpl =
			(WorkFromHomeModelImpl)workFromHome;

		if (Validator.isNull(workFromHome.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			workFromHome.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (workFromHome.getCreateDate() == null)) {
			if (serviceContext == null) {
				workFromHome.setCreateDate(date);
			}
			else {
				workFromHome.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!workFromHomeModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				workFromHome.setModifiedDate(date);
			}
			else {
				workFromHome.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(workFromHome);
			}
			else {
				workFromHome = (WorkFromHome)session.merge(workFromHome);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			WorkFromHomeImpl.class, workFromHomeModelImpl, false, true);

		cacheUniqueFindersCache(workFromHomeModelImpl);

		if (isNew) {
			workFromHome.setNew(false);
		}

		workFromHome.resetOriginalValues();

		return workFromHome;
	}

	/**
	 * Returns the work from home with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the work from home
	 * @return the work from home
	 * @throws NoSuchWorkFromHomeException if a work from home with the primary key could not be found
	 */
	@Override
	public WorkFromHome findByPrimaryKey(Serializable primaryKey)
		throws NoSuchWorkFromHomeException {

		WorkFromHome workFromHome = fetchByPrimaryKey(primaryKey);

		if (workFromHome == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchWorkFromHomeException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return workFromHome;
	}

	/**
	 * Returns the work from home with the primary key or throws a <code>NoSuchWorkFromHomeException</code> if it could not be found.
	 *
	 * @param workFromHomeRequestId the primary key of the work from home
	 * @return the work from home
	 * @throws NoSuchWorkFromHomeException if a work from home with the primary key could not be found
	 */
	@Override
	public WorkFromHome findByPrimaryKey(long workFromHomeRequestId)
		throws NoSuchWorkFromHomeException {

		return findByPrimaryKey((Serializable)workFromHomeRequestId);
	}

	/**
	 * Returns the work from home with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param workFromHomeRequestId the primary key of the work from home
	 * @return the work from home, or <code>null</code> if a work from home with the primary key could not be found
	 */
	@Override
	public WorkFromHome fetchByPrimaryKey(long workFromHomeRequestId) {
		return fetchByPrimaryKey((Serializable)workFromHomeRequestId);
	}

	/**
	 * Returns all the work from homes.
	 *
	 * @return the work from homes
	 */
	@Override
	public List<WorkFromHome> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the work from homes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work from homes
	 * @param end the upper bound of the range of work from homes (not inclusive)
	 * @return the range of work from homes
	 */
	@Override
	public List<WorkFromHome> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the work from homes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work from homes
	 * @param end the upper bound of the range of work from homes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of work from homes
	 */
	@Override
	public List<WorkFromHome> findAll(
		int start, int end, OrderByComparator<WorkFromHome> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the work from homes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work from homes
	 * @param end the upper bound of the range of work from homes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of work from homes
	 */
	@Override
	public List<WorkFromHome> findAll(
		int start, int end, OrderByComparator<WorkFromHome> orderByComparator,
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

		List<WorkFromHome> list = null;

		if (useFinderCache) {
			list = (List<WorkFromHome>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_WORKFROMHOME);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_WORKFROMHOME;

				sql = sql.concat(WorkFromHomeModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<WorkFromHome>)QueryUtil.list(
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
	 * Removes all the work from homes from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (WorkFromHome workFromHome : findAll()) {
			remove(workFromHome);
		}
	}

	/**
	 * Returns the number of work from homes.
	 *
	 * @return the number of work from homes
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_WORKFROMHOME);

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
		return "workFromHomeRequestId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_WORKFROMHOME;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return WorkFromHomeModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the work from home persistence.
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

		_finderPathWithPaginationFindByUserId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"userId"}, true);

		_finderPathWithoutPaginationFindByUserId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId",
			new String[] {Long.class.getName()}, new String[] {"userId"}, true);

		_finderPathCountByUserId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] {Long.class.getName()}, new String[] {"userId"},
			false);

		_finderPathWithPaginationFindByStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStatus",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"status"}, true);

		_finderPathWithoutPaginationFindByStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStatus",
			new String[] {Long.class.getName()}, new String[] {"status"}, true);

		_finderPathCountByStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStatus",
			new String[] {Long.class.getName()}, new String[] {"status"},
			false);

		_finderPathWithPaginationFindByUserIdAndStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserIdAndStatus",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"userId", "status"}, true);

		_finderPathWithoutPaginationFindByUserIdAndStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserIdAndStatus",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"userId", "status"}, true);

		_finderPathCountByUserIdAndStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserIdAndStatus",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"userId", "status"}, false);

		_finderPathWithPaginationFindByDateRange = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDateRange",
			new String[] {
				Date.class.getName(), Date.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"startDate", "endDate"}, true);

		_finderPathWithoutPaginationFindByDateRange = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDateRange",
			new String[] {Date.class.getName(), Date.class.getName()},
			new String[] {"startDate", "endDate"}, true);

		_finderPathCountByDateRange = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDateRange",
			new String[] {Date.class.getName(), Date.class.getName()},
			new String[] {"startDate", "endDate"}, false);

		WorkFromHomeUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		WorkFromHomeUtil.setPersistence(null);

		entityCache.removeCache(WorkFromHomeImpl.class.getName());
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

	private static Long _getTime(Date date) {
		if (date == null) {
			return null;
		}

		return date.getTime();
	}

	private static final String _SQL_SELECT_WORKFROMHOME =
		"SELECT workFromHome FROM WorkFromHome workFromHome";

	private static final String _SQL_SELECT_WORKFROMHOME_WHERE =
		"SELECT workFromHome FROM WorkFromHome workFromHome WHERE ";

	private static final String _SQL_COUNT_WORKFROMHOME =
		"SELECT COUNT(workFromHome) FROM WorkFromHome workFromHome";

	private static final String _SQL_COUNT_WORKFROMHOME_WHERE =
		"SELECT COUNT(workFromHome) FROM WorkFromHome workFromHome WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "workFromHome.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No WorkFromHome exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No WorkFromHome exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		WorkFromHomePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}