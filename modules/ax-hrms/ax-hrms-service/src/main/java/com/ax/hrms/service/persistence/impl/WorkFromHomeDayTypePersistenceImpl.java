/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence.impl;

import com.ax.hrms.exception.NoSuchWorkFromHomeDayTypeException;
import com.ax.hrms.model.WorkFromHomeDayType;
import com.ax.hrms.model.WorkFromHomeDayTypeTable;
import com.ax.hrms.model.impl.WorkFromHomeDayTypeImpl;
import com.ax.hrms.model.impl.WorkFromHomeDayTypeModelImpl;
import com.ax.hrms.service.persistence.WorkFromHomeDayTypePersistence;
import com.ax.hrms.service.persistence.WorkFromHomeDayTypeUtil;
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
 * The persistence implementation for the work from home day type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = WorkFromHomeDayTypePersistence.class)
public class WorkFromHomeDayTypePersistenceImpl
	extends BasePersistenceImpl<WorkFromHomeDayType>
	implements WorkFromHomeDayTypePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>WorkFromHomeDayTypeUtil</code> to access the work from home day type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		WorkFromHomeDayTypeImpl.class.getName();

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
	 * Returns all the work from home day types where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching work from home day types
	 */
	@Override
	public List<WorkFromHomeDayType> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the work from home day types where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeDayTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of work from home day types
	 * @param end the upper bound of the range of work from home day types (not inclusive)
	 * @return the range of matching work from home day types
	 */
	@Override
	public List<WorkFromHomeDayType> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the work from home day types where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeDayTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of work from home day types
	 * @param end the upper bound of the range of work from home day types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work from home day types
	 */
	@Override
	public List<WorkFromHomeDayType> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<WorkFromHomeDayType> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the work from home day types where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeDayTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of work from home day types
	 * @param end the upper bound of the range of work from home day types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work from home day types
	 */
	@Override
	public List<WorkFromHomeDayType> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<WorkFromHomeDayType> orderByComparator,
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

		List<WorkFromHomeDayType> list = null;

		if (useFinderCache) {
			list = (List<WorkFromHomeDayType>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (WorkFromHomeDayType workFromHomeDayType : list) {
					if (!uuid.equals(workFromHomeDayType.getUuid())) {
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

			sb.append(_SQL_SELECT_WORKFROMHOMEDAYTYPE_WHERE);

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
				sb.append(WorkFromHomeDayTypeModelImpl.ORDER_BY_JPQL);
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

				list = (List<WorkFromHomeDayType>)QueryUtil.list(
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
	 * Returns the first work from home day type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work from home day type
	 * @throws NoSuchWorkFromHomeDayTypeException if a matching work from home day type could not be found
	 */
	@Override
	public WorkFromHomeDayType findByUuid_First(
			String uuid,
			OrderByComparator<WorkFromHomeDayType> orderByComparator)
		throws NoSuchWorkFromHomeDayTypeException {

		WorkFromHomeDayType workFromHomeDayType = fetchByUuid_First(
			uuid, orderByComparator);

		if (workFromHomeDayType != null) {
			return workFromHomeDayType;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchWorkFromHomeDayTypeException(sb.toString());
	}

	/**
	 * Returns the first work from home day type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work from home day type, or <code>null</code> if a matching work from home day type could not be found
	 */
	@Override
	public WorkFromHomeDayType fetchByUuid_First(
		String uuid, OrderByComparator<WorkFromHomeDayType> orderByComparator) {

		List<WorkFromHomeDayType> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last work from home day type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work from home day type
	 * @throws NoSuchWorkFromHomeDayTypeException if a matching work from home day type could not be found
	 */
	@Override
	public WorkFromHomeDayType findByUuid_Last(
			String uuid,
			OrderByComparator<WorkFromHomeDayType> orderByComparator)
		throws NoSuchWorkFromHomeDayTypeException {

		WorkFromHomeDayType workFromHomeDayType = fetchByUuid_Last(
			uuid, orderByComparator);

		if (workFromHomeDayType != null) {
			return workFromHomeDayType;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchWorkFromHomeDayTypeException(sb.toString());
	}

	/**
	 * Returns the last work from home day type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work from home day type, or <code>null</code> if a matching work from home day type could not be found
	 */
	@Override
	public WorkFromHomeDayType fetchByUuid_Last(
		String uuid, OrderByComparator<WorkFromHomeDayType> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<WorkFromHomeDayType> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the work from home day types before and after the current work from home day type in the ordered set where uuid = &#63;.
	 *
	 * @param workFromHomeDayTypeId the primary key of the current work from home day type
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work from home day type
	 * @throws NoSuchWorkFromHomeDayTypeException if a work from home day type with the primary key could not be found
	 */
	@Override
	public WorkFromHomeDayType[] findByUuid_PrevAndNext(
			long workFromHomeDayTypeId, String uuid,
			OrderByComparator<WorkFromHomeDayType> orderByComparator)
		throws NoSuchWorkFromHomeDayTypeException {

		uuid = Objects.toString(uuid, "");

		WorkFromHomeDayType workFromHomeDayType = findByPrimaryKey(
			workFromHomeDayTypeId);

		Session session = null;

		try {
			session = openSession();

			WorkFromHomeDayType[] array = new WorkFromHomeDayTypeImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, workFromHomeDayType, uuid, orderByComparator, true);

			array[1] = workFromHomeDayType;

			array[2] = getByUuid_PrevAndNext(
				session, workFromHomeDayType, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected WorkFromHomeDayType getByUuid_PrevAndNext(
		Session session, WorkFromHomeDayType workFromHomeDayType, String uuid,
		OrderByComparator<WorkFromHomeDayType> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_WORKFROMHOMEDAYTYPE_WHERE);

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
			sb.append(WorkFromHomeDayTypeModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(
						workFromHomeDayType)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<WorkFromHomeDayType> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the work from home day types where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (WorkFromHomeDayType workFromHomeDayType :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(workFromHomeDayType);
		}
	}

	/**
	 * Returns the number of work from home day types where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching work from home day types
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_WORKFROMHOMEDAYTYPE_WHERE);

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
		"workFromHomeDayType.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(workFromHomeDayType.uuid IS NULL OR workFromHomeDayType.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the work from home day type where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchWorkFromHomeDayTypeException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching work from home day type
	 * @throws NoSuchWorkFromHomeDayTypeException if a matching work from home day type could not be found
	 */
	@Override
	public WorkFromHomeDayType findByUUID_G(String uuid, long groupId)
		throws NoSuchWorkFromHomeDayTypeException {

		WorkFromHomeDayType workFromHomeDayType = fetchByUUID_G(uuid, groupId);

		if (workFromHomeDayType == null) {
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

			throw new NoSuchWorkFromHomeDayTypeException(sb.toString());
		}

		return workFromHomeDayType;
	}

	/**
	 * Returns the work from home day type where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching work from home day type, or <code>null</code> if a matching work from home day type could not be found
	 */
	@Override
	public WorkFromHomeDayType fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the work from home day type where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching work from home day type, or <code>null</code> if a matching work from home day type could not be found
	 */
	@Override
	public WorkFromHomeDayType fetchByUUID_G(
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

		if (result instanceof WorkFromHomeDayType) {
			WorkFromHomeDayType workFromHomeDayType =
				(WorkFromHomeDayType)result;

			if (!Objects.equals(uuid, workFromHomeDayType.getUuid()) ||
				(groupId != workFromHomeDayType.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_WORKFROMHOMEDAYTYPE_WHERE);

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

				List<WorkFromHomeDayType> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					WorkFromHomeDayType workFromHomeDayType = list.get(0);

					result = workFromHomeDayType;

					cacheResult(workFromHomeDayType);
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
			return (WorkFromHomeDayType)result;
		}
	}

	/**
	 * Removes the work from home day type where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the work from home day type that was removed
	 */
	@Override
	public WorkFromHomeDayType removeByUUID_G(String uuid, long groupId)
		throws NoSuchWorkFromHomeDayTypeException {

		WorkFromHomeDayType workFromHomeDayType = findByUUID_G(uuid, groupId);

		return remove(workFromHomeDayType);
	}

	/**
	 * Returns the number of work from home day types where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching work from home day types
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_WORKFROMHOMEDAYTYPE_WHERE);

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
		"workFromHomeDayType.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(workFromHomeDayType.uuid IS NULL OR workFromHomeDayType.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"workFromHomeDayType.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the work from home day types where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching work from home day types
	 */
	@Override
	public List<WorkFromHomeDayType> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the work from home day types where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeDayTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of work from home day types
	 * @param end the upper bound of the range of work from home day types (not inclusive)
	 * @return the range of matching work from home day types
	 */
	@Override
	public List<WorkFromHomeDayType> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the work from home day types where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeDayTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of work from home day types
	 * @param end the upper bound of the range of work from home day types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work from home day types
	 */
	@Override
	public List<WorkFromHomeDayType> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<WorkFromHomeDayType> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the work from home day types where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeDayTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of work from home day types
	 * @param end the upper bound of the range of work from home day types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work from home day types
	 */
	@Override
	public List<WorkFromHomeDayType> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<WorkFromHomeDayType> orderByComparator,
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

		List<WorkFromHomeDayType> list = null;

		if (useFinderCache) {
			list = (List<WorkFromHomeDayType>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (WorkFromHomeDayType workFromHomeDayType : list) {
					if (!uuid.equals(workFromHomeDayType.getUuid()) ||
						(companyId != workFromHomeDayType.getCompanyId())) {

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

			sb.append(_SQL_SELECT_WORKFROMHOMEDAYTYPE_WHERE);

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
				sb.append(WorkFromHomeDayTypeModelImpl.ORDER_BY_JPQL);
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

				list = (List<WorkFromHomeDayType>)QueryUtil.list(
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
	 * Returns the first work from home day type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work from home day type
	 * @throws NoSuchWorkFromHomeDayTypeException if a matching work from home day type could not be found
	 */
	@Override
	public WorkFromHomeDayType findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<WorkFromHomeDayType> orderByComparator)
		throws NoSuchWorkFromHomeDayTypeException {

		WorkFromHomeDayType workFromHomeDayType = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (workFromHomeDayType != null) {
			return workFromHomeDayType;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchWorkFromHomeDayTypeException(sb.toString());
	}

	/**
	 * Returns the first work from home day type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work from home day type, or <code>null</code> if a matching work from home day type could not be found
	 */
	@Override
	public WorkFromHomeDayType fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<WorkFromHomeDayType> orderByComparator) {

		List<WorkFromHomeDayType> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last work from home day type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work from home day type
	 * @throws NoSuchWorkFromHomeDayTypeException if a matching work from home day type could not be found
	 */
	@Override
	public WorkFromHomeDayType findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<WorkFromHomeDayType> orderByComparator)
		throws NoSuchWorkFromHomeDayTypeException {

		WorkFromHomeDayType workFromHomeDayType = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (workFromHomeDayType != null) {
			return workFromHomeDayType;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchWorkFromHomeDayTypeException(sb.toString());
	}

	/**
	 * Returns the last work from home day type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work from home day type, or <code>null</code> if a matching work from home day type could not be found
	 */
	@Override
	public WorkFromHomeDayType fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<WorkFromHomeDayType> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<WorkFromHomeDayType> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the work from home day types before and after the current work from home day type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param workFromHomeDayTypeId the primary key of the current work from home day type
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work from home day type
	 * @throws NoSuchWorkFromHomeDayTypeException if a work from home day type with the primary key could not be found
	 */
	@Override
	public WorkFromHomeDayType[] findByUuid_C_PrevAndNext(
			long workFromHomeDayTypeId, String uuid, long companyId,
			OrderByComparator<WorkFromHomeDayType> orderByComparator)
		throws NoSuchWorkFromHomeDayTypeException {

		uuid = Objects.toString(uuid, "");

		WorkFromHomeDayType workFromHomeDayType = findByPrimaryKey(
			workFromHomeDayTypeId);

		Session session = null;

		try {
			session = openSession();

			WorkFromHomeDayType[] array = new WorkFromHomeDayTypeImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, workFromHomeDayType, uuid, companyId,
				orderByComparator, true);

			array[1] = workFromHomeDayType;

			array[2] = getByUuid_C_PrevAndNext(
				session, workFromHomeDayType, uuid, companyId,
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

	protected WorkFromHomeDayType getByUuid_C_PrevAndNext(
		Session session, WorkFromHomeDayType workFromHomeDayType, String uuid,
		long companyId,
		OrderByComparator<WorkFromHomeDayType> orderByComparator,
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

		sb.append(_SQL_SELECT_WORKFROMHOMEDAYTYPE_WHERE);

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
			sb.append(WorkFromHomeDayTypeModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(
						workFromHomeDayType)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<WorkFromHomeDayType> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the work from home day types where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (WorkFromHomeDayType workFromHomeDayType :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(workFromHomeDayType);
		}
	}

	/**
	 * Returns the number of work from home day types where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching work from home day types
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_WORKFROMHOMEDAYTYPE_WHERE);

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
		"workFromHomeDayType.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(workFromHomeDayType.uuid IS NULL OR workFromHomeDayType.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"workFromHomeDayType.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByWorkFromHomeRequestId;
	private FinderPath _finderPathWithoutPaginationFindByWorkFromHomeRequestId;
	private FinderPath _finderPathCountByWorkFromHomeRequestId;

	/**
	 * Returns all the work from home day types where workFromHomeRequestId = &#63;.
	 *
	 * @param workFromHomeRequestId the work from home request ID
	 * @return the matching work from home day types
	 */
	@Override
	public List<WorkFromHomeDayType> findByWorkFromHomeRequestId(
		long workFromHomeRequestId) {

		return findByWorkFromHomeRequestId(
			workFromHomeRequestId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the work from home day types where workFromHomeRequestId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeDayTypeModelImpl</code>.
	 * </p>
	 *
	 * @param workFromHomeRequestId the work from home request ID
	 * @param start the lower bound of the range of work from home day types
	 * @param end the upper bound of the range of work from home day types (not inclusive)
	 * @return the range of matching work from home day types
	 */
	@Override
	public List<WorkFromHomeDayType> findByWorkFromHomeRequestId(
		long workFromHomeRequestId, int start, int end) {

		return findByWorkFromHomeRequestId(
			workFromHomeRequestId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the work from home day types where workFromHomeRequestId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeDayTypeModelImpl</code>.
	 * </p>
	 *
	 * @param workFromHomeRequestId the work from home request ID
	 * @param start the lower bound of the range of work from home day types
	 * @param end the upper bound of the range of work from home day types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work from home day types
	 */
	@Override
	public List<WorkFromHomeDayType> findByWorkFromHomeRequestId(
		long workFromHomeRequestId, int start, int end,
		OrderByComparator<WorkFromHomeDayType> orderByComparator) {

		return findByWorkFromHomeRequestId(
			workFromHomeRequestId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the work from home day types where workFromHomeRequestId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeDayTypeModelImpl</code>.
	 * </p>
	 *
	 * @param workFromHomeRequestId the work from home request ID
	 * @param start the lower bound of the range of work from home day types
	 * @param end the upper bound of the range of work from home day types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work from home day types
	 */
	@Override
	public List<WorkFromHomeDayType> findByWorkFromHomeRequestId(
		long workFromHomeRequestId, int start, int end,
		OrderByComparator<WorkFromHomeDayType> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByWorkFromHomeRequestId;
				finderArgs = new Object[] {workFromHomeRequestId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByWorkFromHomeRequestId;
			finderArgs = new Object[] {
				workFromHomeRequestId, start, end, orderByComparator
			};
		}

		List<WorkFromHomeDayType> list = null;

		if (useFinderCache) {
			list = (List<WorkFromHomeDayType>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (WorkFromHomeDayType workFromHomeDayType : list) {
					if (workFromHomeRequestId !=
							workFromHomeDayType.getWorkFromHomeRequestId()) {

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

			sb.append(_SQL_SELECT_WORKFROMHOMEDAYTYPE_WHERE);

			sb.append(
				_FINDER_COLUMN_WORKFROMHOMEREQUESTID_WORKFROMHOMEREQUESTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(WorkFromHomeDayTypeModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(workFromHomeRequestId);

				list = (List<WorkFromHomeDayType>)QueryUtil.list(
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
	 * Returns the first work from home day type in the ordered set where workFromHomeRequestId = &#63;.
	 *
	 * @param workFromHomeRequestId the work from home request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work from home day type
	 * @throws NoSuchWorkFromHomeDayTypeException if a matching work from home day type could not be found
	 */
	@Override
	public WorkFromHomeDayType findByWorkFromHomeRequestId_First(
			long workFromHomeRequestId,
			OrderByComparator<WorkFromHomeDayType> orderByComparator)
		throws NoSuchWorkFromHomeDayTypeException {

		WorkFromHomeDayType workFromHomeDayType =
			fetchByWorkFromHomeRequestId_First(
				workFromHomeRequestId, orderByComparator);

		if (workFromHomeDayType != null) {
			return workFromHomeDayType;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("workFromHomeRequestId=");
		sb.append(workFromHomeRequestId);

		sb.append("}");

		throw new NoSuchWorkFromHomeDayTypeException(sb.toString());
	}

	/**
	 * Returns the first work from home day type in the ordered set where workFromHomeRequestId = &#63;.
	 *
	 * @param workFromHomeRequestId the work from home request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work from home day type, or <code>null</code> if a matching work from home day type could not be found
	 */
	@Override
	public WorkFromHomeDayType fetchByWorkFromHomeRequestId_First(
		long workFromHomeRequestId,
		OrderByComparator<WorkFromHomeDayType> orderByComparator) {

		List<WorkFromHomeDayType> list = findByWorkFromHomeRequestId(
			workFromHomeRequestId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last work from home day type in the ordered set where workFromHomeRequestId = &#63;.
	 *
	 * @param workFromHomeRequestId the work from home request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work from home day type
	 * @throws NoSuchWorkFromHomeDayTypeException if a matching work from home day type could not be found
	 */
	@Override
	public WorkFromHomeDayType findByWorkFromHomeRequestId_Last(
			long workFromHomeRequestId,
			OrderByComparator<WorkFromHomeDayType> orderByComparator)
		throws NoSuchWorkFromHomeDayTypeException {

		WorkFromHomeDayType workFromHomeDayType =
			fetchByWorkFromHomeRequestId_Last(
				workFromHomeRequestId, orderByComparator);

		if (workFromHomeDayType != null) {
			return workFromHomeDayType;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("workFromHomeRequestId=");
		sb.append(workFromHomeRequestId);

		sb.append("}");

		throw new NoSuchWorkFromHomeDayTypeException(sb.toString());
	}

	/**
	 * Returns the last work from home day type in the ordered set where workFromHomeRequestId = &#63;.
	 *
	 * @param workFromHomeRequestId the work from home request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work from home day type, or <code>null</code> if a matching work from home day type could not be found
	 */
	@Override
	public WorkFromHomeDayType fetchByWorkFromHomeRequestId_Last(
		long workFromHomeRequestId,
		OrderByComparator<WorkFromHomeDayType> orderByComparator) {

		int count = countByWorkFromHomeRequestId(workFromHomeRequestId);

		if (count == 0) {
			return null;
		}

		List<WorkFromHomeDayType> list = findByWorkFromHomeRequestId(
			workFromHomeRequestId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the work from home day types before and after the current work from home day type in the ordered set where workFromHomeRequestId = &#63;.
	 *
	 * @param workFromHomeDayTypeId the primary key of the current work from home day type
	 * @param workFromHomeRequestId the work from home request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work from home day type
	 * @throws NoSuchWorkFromHomeDayTypeException if a work from home day type with the primary key could not be found
	 */
	@Override
	public WorkFromHomeDayType[] findByWorkFromHomeRequestId_PrevAndNext(
			long workFromHomeDayTypeId, long workFromHomeRequestId,
			OrderByComparator<WorkFromHomeDayType> orderByComparator)
		throws NoSuchWorkFromHomeDayTypeException {

		WorkFromHomeDayType workFromHomeDayType = findByPrimaryKey(
			workFromHomeDayTypeId);

		Session session = null;

		try {
			session = openSession();

			WorkFromHomeDayType[] array = new WorkFromHomeDayTypeImpl[3];

			array[0] = getByWorkFromHomeRequestId_PrevAndNext(
				session, workFromHomeDayType, workFromHomeRequestId,
				orderByComparator, true);

			array[1] = workFromHomeDayType;

			array[2] = getByWorkFromHomeRequestId_PrevAndNext(
				session, workFromHomeDayType, workFromHomeRequestId,
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

	protected WorkFromHomeDayType getByWorkFromHomeRequestId_PrevAndNext(
		Session session, WorkFromHomeDayType workFromHomeDayType,
		long workFromHomeRequestId,
		OrderByComparator<WorkFromHomeDayType> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_WORKFROMHOMEDAYTYPE_WHERE);

		sb.append(_FINDER_COLUMN_WORKFROMHOMEREQUESTID_WORKFROMHOMEREQUESTID_2);

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
			sb.append(WorkFromHomeDayTypeModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(workFromHomeRequestId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						workFromHomeDayType)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<WorkFromHomeDayType> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the work from home day types where workFromHomeRequestId = &#63; from the database.
	 *
	 * @param workFromHomeRequestId the work from home request ID
	 */
	@Override
	public void removeByWorkFromHomeRequestId(long workFromHomeRequestId) {
		for (WorkFromHomeDayType workFromHomeDayType :
				findByWorkFromHomeRequestId(
					workFromHomeRequestId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(workFromHomeDayType);
		}
	}

	/**
	 * Returns the number of work from home day types where workFromHomeRequestId = &#63;.
	 *
	 * @param workFromHomeRequestId the work from home request ID
	 * @return the number of matching work from home day types
	 */
	@Override
	public int countByWorkFromHomeRequestId(long workFromHomeRequestId) {
		FinderPath finderPath = _finderPathCountByWorkFromHomeRequestId;

		Object[] finderArgs = new Object[] {workFromHomeRequestId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_WORKFROMHOMEDAYTYPE_WHERE);

			sb.append(
				_FINDER_COLUMN_WORKFROMHOMEREQUESTID_WORKFROMHOMEREQUESTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(workFromHomeRequestId);

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
		_FINDER_COLUMN_WORKFROMHOMEREQUESTID_WORKFROMHOMEREQUESTID_2 =
			"workFromHomeDayType.workFromHomeRequestId = ?";

	private FinderPath _finderPathWithPaginationFindByWorkFromHomeDate;
	private FinderPath _finderPathWithoutPaginationFindByWorkFromHomeDate;
	private FinderPath _finderPathCountByWorkFromHomeDate;

	/**
	 * Returns all the work from home day types where workFromHomeDate = &#63;.
	 *
	 * @param workFromHomeDate the work from home date
	 * @return the matching work from home day types
	 */
	@Override
	public List<WorkFromHomeDayType> findByWorkFromHomeDate(
		Date workFromHomeDate) {

		return findByWorkFromHomeDate(
			workFromHomeDate, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the work from home day types where workFromHomeDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeDayTypeModelImpl</code>.
	 * </p>
	 *
	 * @param workFromHomeDate the work from home date
	 * @param start the lower bound of the range of work from home day types
	 * @param end the upper bound of the range of work from home day types (not inclusive)
	 * @return the range of matching work from home day types
	 */
	@Override
	public List<WorkFromHomeDayType> findByWorkFromHomeDate(
		Date workFromHomeDate, int start, int end) {

		return findByWorkFromHomeDate(workFromHomeDate, start, end, null);
	}

	/**
	 * Returns an ordered range of all the work from home day types where workFromHomeDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeDayTypeModelImpl</code>.
	 * </p>
	 *
	 * @param workFromHomeDate the work from home date
	 * @param start the lower bound of the range of work from home day types
	 * @param end the upper bound of the range of work from home day types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work from home day types
	 */
	@Override
	public List<WorkFromHomeDayType> findByWorkFromHomeDate(
		Date workFromHomeDate, int start, int end,
		OrderByComparator<WorkFromHomeDayType> orderByComparator) {

		return findByWorkFromHomeDate(
			workFromHomeDate, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the work from home day types where workFromHomeDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeDayTypeModelImpl</code>.
	 * </p>
	 *
	 * @param workFromHomeDate the work from home date
	 * @param start the lower bound of the range of work from home day types
	 * @param end the upper bound of the range of work from home day types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work from home day types
	 */
	@Override
	public List<WorkFromHomeDayType> findByWorkFromHomeDate(
		Date workFromHomeDate, int start, int end,
		OrderByComparator<WorkFromHomeDayType> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByWorkFromHomeDate;
				finderArgs = new Object[] {_getTime(workFromHomeDate)};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByWorkFromHomeDate;
			finderArgs = new Object[] {
				_getTime(workFromHomeDate), start, end, orderByComparator
			};
		}

		List<WorkFromHomeDayType> list = null;

		if (useFinderCache) {
			list = (List<WorkFromHomeDayType>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (WorkFromHomeDayType workFromHomeDayType : list) {
					if (!Objects.equals(
							workFromHomeDate,
							workFromHomeDayType.getWorkFromHomeDate())) {

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

			sb.append(_SQL_SELECT_WORKFROMHOMEDAYTYPE_WHERE);

			boolean bindWorkFromHomeDate = false;

			if (workFromHomeDate == null) {
				sb.append(_FINDER_COLUMN_WORKFROMHOMEDATE_WORKFROMHOMEDATE_1);
			}
			else {
				bindWorkFromHomeDate = true;

				sb.append(_FINDER_COLUMN_WORKFROMHOMEDATE_WORKFROMHOMEDATE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(WorkFromHomeDayTypeModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindWorkFromHomeDate) {
					queryPos.add(new Timestamp(workFromHomeDate.getTime()));
				}

				list = (List<WorkFromHomeDayType>)QueryUtil.list(
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
	 * Returns the first work from home day type in the ordered set where workFromHomeDate = &#63;.
	 *
	 * @param workFromHomeDate the work from home date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work from home day type
	 * @throws NoSuchWorkFromHomeDayTypeException if a matching work from home day type could not be found
	 */
	@Override
	public WorkFromHomeDayType findByWorkFromHomeDate_First(
			Date workFromHomeDate,
			OrderByComparator<WorkFromHomeDayType> orderByComparator)
		throws NoSuchWorkFromHomeDayTypeException {

		WorkFromHomeDayType workFromHomeDayType = fetchByWorkFromHomeDate_First(
			workFromHomeDate, orderByComparator);

		if (workFromHomeDayType != null) {
			return workFromHomeDayType;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("workFromHomeDate=");
		sb.append(workFromHomeDate);

		sb.append("}");

		throw new NoSuchWorkFromHomeDayTypeException(sb.toString());
	}

	/**
	 * Returns the first work from home day type in the ordered set where workFromHomeDate = &#63;.
	 *
	 * @param workFromHomeDate the work from home date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work from home day type, or <code>null</code> if a matching work from home day type could not be found
	 */
	@Override
	public WorkFromHomeDayType fetchByWorkFromHomeDate_First(
		Date workFromHomeDate,
		OrderByComparator<WorkFromHomeDayType> orderByComparator) {

		List<WorkFromHomeDayType> list = findByWorkFromHomeDate(
			workFromHomeDate, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last work from home day type in the ordered set where workFromHomeDate = &#63;.
	 *
	 * @param workFromHomeDate the work from home date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work from home day type
	 * @throws NoSuchWorkFromHomeDayTypeException if a matching work from home day type could not be found
	 */
	@Override
	public WorkFromHomeDayType findByWorkFromHomeDate_Last(
			Date workFromHomeDate,
			OrderByComparator<WorkFromHomeDayType> orderByComparator)
		throws NoSuchWorkFromHomeDayTypeException {

		WorkFromHomeDayType workFromHomeDayType = fetchByWorkFromHomeDate_Last(
			workFromHomeDate, orderByComparator);

		if (workFromHomeDayType != null) {
			return workFromHomeDayType;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("workFromHomeDate=");
		sb.append(workFromHomeDate);

		sb.append("}");

		throw new NoSuchWorkFromHomeDayTypeException(sb.toString());
	}

	/**
	 * Returns the last work from home day type in the ordered set where workFromHomeDate = &#63;.
	 *
	 * @param workFromHomeDate the work from home date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work from home day type, or <code>null</code> if a matching work from home day type could not be found
	 */
	@Override
	public WorkFromHomeDayType fetchByWorkFromHomeDate_Last(
		Date workFromHomeDate,
		OrderByComparator<WorkFromHomeDayType> orderByComparator) {

		int count = countByWorkFromHomeDate(workFromHomeDate);

		if (count == 0) {
			return null;
		}

		List<WorkFromHomeDayType> list = findByWorkFromHomeDate(
			workFromHomeDate, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the work from home day types before and after the current work from home day type in the ordered set where workFromHomeDate = &#63;.
	 *
	 * @param workFromHomeDayTypeId the primary key of the current work from home day type
	 * @param workFromHomeDate the work from home date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work from home day type
	 * @throws NoSuchWorkFromHomeDayTypeException if a work from home day type with the primary key could not be found
	 */
	@Override
	public WorkFromHomeDayType[] findByWorkFromHomeDate_PrevAndNext(
			long workFromHomeDayTypeId, Date workFromHomeDate,
			OrderByComparator<WorkFromHomeDayType> orderByComparator)
		throws NoSuchWorkFromHomeDayTypeException {

		WorkFromHomeDayType workFromHomeDayType = findByPrimaryKey(
			workFromHomeDayTypeId);

		Session session = null;

		try {
			session = openSession();

			WorkFromHomeDayType[] array = new WorkFromHomeDayTypeImpl[3];

			array[0] = getByWorkFromHomeDate_PrevAndNext(
				session, workFromHomeDayType, workFromHomeDate,
				orderByComparator, true);

			array[1] = workFromHomeDayType;

			array[2] = getByWorkFromHomeDate_PrevAndNext(
				session, workFromHomeDayType, workFromHomeDate,
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

	protected WorkFromHomeDayType getByWorkFromHomeDate_PrevAndNext(
		Session session, WorkFromHomeDayType workFromHomeDayType,
		Date workFromHomeDate,
		OrderByComparator<WorkFromHomeDayType> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_WORKFROMHOMEDAYTYPE_WHERE);

		boolean bindWorkFromHomeDate = false;

		if (workFromHomeDate == null) {
			sb.append(_FINDER_COLUMN_WORKFROMHOMEDATE_WORKFROMHOMEDATE_1);
		}
		else {
			bindWorkFromHomeDate = true;

			sb.append(_FINDER_COLUMN_WORKFROMHOMEDATE_WORKFROMHOMEDATE_2);
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
			sb.append(WorkFromHomeDayTypeModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindWorkFromHomeDate) {
			queryPos.add(new Timestamp(workFromHomeDate.getTime()));
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						workFromHomeDayType)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<WorkFromHomeDayType> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the work from home day types where workFromHomeDate = &#63; from the database.
	 *
	 * @param workFromHomeDate the work from home date
	 */
	@Override
	public void removeByWorkFromHomeDate(Date workFromHomeDate) {
		for (WorkFromHomeDayType workFromHomeDayType :
				findByWorkFromHomeDate(
					workFromHomeDate, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(workFromHomeDayType);
		}
	}

	/**
	 * Returns the number of work from home day types where workFromHomeDate = &#63;.
	 *
	 * @param workFromHomeDate the work from home date
	 * @return the number of matching work from home day types
	 */
	@Override
	public int countByWorkFromHomeDate(Date workFromHomeDate) {
		FinderPath finderPath = _finderPathCountByWorkFromHomeDate;

		Object[] finderArgs = new Object[] {_getTime(workFromHomeDate)};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_WORKFROMHOMEDAYTYPE_WHERE);

			boolean bindWorkFromHomeDate = false;

			if (workFromHomeDate == null) {
				sb.append(_FINDER_COLUMN_WORKFROMHOMEDATE_WORKFROMHOMEDATE_1);
			}
			else {
				bindWorkFromHomeDate = true;

				sb.append(_FINDER_COLUMN_WORKFROMHOMEDATE_WORKFROMHOMEDATE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindWorkFromHomeDate) {
					queryPos.add(new Timestamp(workFromHomeDate.getTime()));
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

	private static final String
		_FINDER_COLUMN_WORKFROMHOMEDATE_WORKFROMHOMEDATE_1 =
			"workFromHomeDayType.workFromHomeDate IS NULL";

	private static final String
		_FINDER_COLUMN_WORKFROMHOMEDATE_WORKFROMHOMEDATE_2 =
			"workFromHomeDayType.workFromHomeDate = ?";

	public WorkFromHomeDayTypePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(WorkFromHomeDayType.class);

		setModelImplClass(WorkFromHomeDayTypeImpl.class);
		setModelPKClass(long.class);

		setTable(WorkFromHomeDayTypeTable.INSTANCE);
	}

	/**
	 * Caches the work from home day type in the entity cache if it is enabled.
	 *
	 * @param workFromHomeDayType the work from home day type
	 */
	@Override
	public void cacheResult(WorkFromHomeDayType workFromHomeDayType) {
		entityCache.putResult(
			WorkFromHomeDayTypeImpl.class, workFromHomeDayType.getPrimaryKey(),
			workFromHomeDayType);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				workFromHomeDayType.getUuid(), workFromHomeDayType.getGroupId()
			},
			workFromHomeDayType);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the work from home day types in the entity cache if it is enabled.
	 *
	 * @param workFromHomeDayTypes the work from home day types
	 */
	@Override
	public void cacheResult(List<WorkFromHomeDayType> workFromHomeDayTypes) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (workFromHomeDayTypes.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (WorkFromHomeDayType workFromHomeDayType : workFromHomeDayTypes) {
			if (entityCache.getResult(
					WorkFromHomeDayTypeImpl.class,
					workFromHomeDayType.getPrimaryKey()) == null) {

				cacheResult(workFromHomeDayType);
			}
		}
	}

	/**
	 * Clears the cache for all work from home day types.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(WorkFromHomeDayTypeImpl.class);

		finderCache.clearCache(WorkFromHomeDayTypeImpl.class);
	}

	/**
	 * Clears the cache for the work from home day type.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(WorkFromHomeDayType workFromHomeDayType) {
		entityCache.removeResult(
			WorkFromHomeDayTypeImpl.class, workFromHomeDayType);
	}

	@Override
	public void clearCache(List<WorkFromHomeDayType> workFromHomeDayTypes) {
		for (WorkFromHomeDayType workFromHomeDayType : workFromHomeDayTypes) {
			entityCache.removeResult(
				WorkFromHomeDayTypeImpl.class, workFromHomeDayType);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(WorkFromHomeDayTypeImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(WorkFromHomeDayTypeImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		WorkFromHomeDayTypeModelImpl workFromHomeDayTypeModelImpl) {

		Object[] args = new Object[] {
			workFromHomeDayTypeModelImpl.getUuid(),
			workFromHomeDayTypeModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, workFromHomeDayTypeModelImpl);
	}

	/**
	 * Creates a new work from home day type with the primary key. Does not add the work from home day type to the database.
	 *
	 * @param workFromHomeDayTypeId the primary key for the new work from home day type
	 * @return the new work from home day type
	 */
	@Override
	public WorkFromHomeDayType create(long workFromHomeDayTypeId) {
		WorkFromHomeDayType workFromHomeDayType = new WorkFromHomeDayTypeImpl();

		workFromHomeDayType.setNew(true);
		workFromHomeDayType.setPrimaryKey(workFromHomeDayTypeId);

		String uuid = PortalUUIDUtil.generate();

		workFromHomeDayType.setUuid(uuid);

		workFromHomeDayType.setCompanyId(CompanyThreadLocal.getCompanyId());

		return workFromHomeDayType;
	}

	/**
	 * Removes the work from home day type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param workFromHomeDayTypeId the primary key of the work from home day type
	 * @return the work from home day type that was removed
	 * @throws NoSuchWorkFromHomeDayTypeException if a work from home day type with the primary key could not be found
	 */
	@Override
	public WorkFromHomeDayType remove(long workFromHomeDayTypeId)
		throws NoSuchWorkFromHomeDayTypeException {

		return remove((Serializable)workFromHomeDayTypeId);
	}

	/**
	 * Removes the work from home day type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the work from home day type
	 * @return the work from home day type that was removed
	 * @throws NoSuchWorkFromHomeDayTypeException if a work from home day type with the primary key could not be found
	 */
	@Override
	public WorkFromHomeDayType remove(Serializable primaryKey)
		throws NoSuchWorkFromHomeDayTypeException {

		Session session = null;

		try {
			session = openSession();

			WorkFromHomeDayType workFromHomeDayType =
				(WorkFromHomeDayType)session.get(
					WorkFromHomeDayTypeImpl.class, primaryKey);

			if (workFromHomeDayType == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchWorkFromHomeDayTypeException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(workFromHomeDayType);
		}
		catch (NoSuchWorkFromHomeDayTypeException noSuchEntityException) {
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
	protected WorkFromHomeDayType removeImpl(
		WorkFromHomeDayType workFromHomeDayType) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(workFromHomeDayType)) {
				workFromHomeDayType = (WorkFromHomeDayType)session.get(
					WorkFromHomeDayTypeImpl.class,
					workFromHomeDayType.getPrimaryKeyObj());
			}

			if (workFromHomeDayType != null) {
				session.delete(workFromHomeDayType);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (workFromHomeDayType != null) {
			clearCache(workFromHomeDayType);
		}

		return workFromHomeDayType;
	}

	@Override
	public WorkFromHomeDayType updateImpl(
		WorkFromHomeDayType workFromHomeDayType) {

		boolean isNew = workFromHomeDayType.isNew();

		if (!(workFromHomeDayType instanceof WorkFromHomeDayTypeModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(workFromHomeDayType.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					workFromHomeDayType);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in workFromHomeDayType proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom WorkFromHomeDayType implementation " +
					workFromHomeDayType.getClass());
		}

		WorkFromHomeDayTypeModelImpl workFromHomeDayTypeModelImpl =
			(WorkFromHomeDayTypeModelImpl)workFromHomeDayType;

		if (Validator.isNull(workFromHomeDayType.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			workFromHomeDayType.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (workFromHomeDayType.getCreateDate() == null)) {
			if (serviceContext == null) {
				workFromHomeDayType.setCreateDate(date);
			}
			else {
				workFromHomeDayType.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!workFromHomeDayTypeModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				workFromHomeDayType.setModifiedDate(date);
			}
			else {
				workFromHomeDayType.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(workFromHomeDayType);
			}
			else {
				workFromHomeDayType = (WorkFromHomeDayType)session.merge(
					workFromHomeDayType);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			WorkFromHomeDayTypeImpl.class, workFromHomeDayTypeModelImpl, false,
			true);

		cacheUniqueFindersCache(workFromHomeDayTypeModelImpl);

		if (isNew) {
			workFromHomeDayType.setNew(false);
		}

		workFromHomeDayType.resetOriginalValues();

		return workFromHomeDayType;
	}

	/**
	 * Returns the work from home day type with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the work from home day type
	 * @return the work from home day type
	 * @throws NoSuchWorkFromHomeDayTypeException if a work from home day type with the primary key could not be found
	 */
	@Override
	public WorkFromHomeDayType findByPrimaryKey(Serializable primaryKey)
		throws NoSuchWorkFromHomeDayTypeException {

		WorkFromHomeDayType workFromHomeDayType = fetchByPrimaryKey(primaryKey);

		if (workFromHomeDayType == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchWorkFromHomeDayTypeException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return workFromHomeDayType;
	}

	/**
	 * Returns the work from home day type with the primary key or throws a <code>NoSuchWorkFromHomeDayTypeException</code> if it could not be found.
	 *
	 * @param workFromHomeDayTypeId the primary key of the work from home day type
	 * @return the work from home day type
	 * @throws NoSuchWorkFromHomeDayTypeException if a work from home day type with the primary key could not be found
	 */
	@Override
	public WorkFromHomeDayType findByPrimaryKey(long workFromHomeDayTypeId)
		throws NoSuchWorkFromHomeDayTypeException {

		return findByPrimaryKey((Serializable)workFromHomeDayTypeId);
	}

	/**
	 * Returns the work from home day type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param workFromHomeDayTypeId the primary key of the work from home day type
	 * @return the work from home day type, or <code>null</code> if a work from home day type with the primary key could not be found
	 */
	@Override
	public WorkFromHomeDayType fetchByPrimaryKey(long workFromHomeDayTypeId) {
		return fetchByPrimaryKey((Serializable)workFromHomeDayTypeId);
	}

	/**
	 * Returns all the work from home day types.
	 *
	 * @return the work from home day types
	 */
	@Override
	public List<WorkFromHomeDayType> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the work from home day types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeDayTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work from home day types
	 * @param end the upper bound of the range of work from home day types (not inclusive)
	 * @return the range of work from home day types
	 */
	@Override
	public List<WorkFromHomeDayType> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the work from home day types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeDayTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work from home day types
	 * @param end the upper bound of the range of work from home day types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of work from home day types
	 */
	@Override
	public List<WorkFromHomeDayType> findAll(
		int start, int end,
		OrderByComparator<WorkFromHomeDayType> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the work from home day types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeDayTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work from home day types
	 * @param end the upper bound of the range of work from home day types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of work from home day types
	 */
	@Override
	public List<WorkFromHomeDayType> findAll(
		int start, int end,
		OrderByComparator<WorkFromHomeDayType> orderByComparator,
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

		List<WorkFromHomeDayType> list = null;

		if (useFinderCache) {
			list = (List<WorkFromHomeDayType>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_WORKFROMHOMEDAYTYPE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_WORKFROMHOMEDAYTYPE;

				sql = sql.concat(WorkFromHomeDayTypeModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<WorkFromHomeDayType>)QueryUtil.list(
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
	 * Removes all the work from home day types from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (WorkFromHomeDayType workFromHomeDayType : findAll()) {
			remove(workFromHomeDayType);
		}
	}

	/**
	 * Returns the number of work from home day types.
	 *
	 * @return the number of work from home day types
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(
					_SQL_COUNT_WORKFROMHOMEDAYTYPE);

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
		return "workFromHomeDayTypeId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_WORKFROMHOMEDAYTYPE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return WorkFromHomeDayTypeModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the work from home day type persistence.
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

		_finderPathWithPaginationFindByWorkFromHomeRequestId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByWorkFromHomeRequestId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"workFromHomeRequestId"}, true);

		_finderPathWithoutPaginationFindByWorkFromHomeRequestId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByWorkFromHomeRequestId",
				new String[] {Long.class.getName()},
				new String[] {"workFromHomeRequestId"}, true);

		_finderPathCountByWorkFromHomeRequestId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByWorkFromHomeRequestId", new String[] {Long.class.getName()},
			new String[] {"workFromHomeRequestId"}, false);

		_finderPathWithPaginationFindByWorkFromHomeDate = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByWorkFromHomeDate",
			new String[] {
				Date.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"workFromHomeDate"}, true);

		_finderPathWithoutPaginationFindByWorkFromHomeDate = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByWorkFromHomeDate",
			new String[] {Date.class.getName()},
			new String[] {"workFromHomeDate"}, true);

		_finderPathCountByWorkFromHomeDate = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByWorkFromHomeDate", new String[] {Date.class.getName()},
			new String[] {"workFromHomeDate"}, false);

		WorkFromHomeDayTypeUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		WorkFromHomeDayTypeUtil.setPersistence(null);

		entityCache.removeCache(WorkFromHomeDayTypeImpl.class.getName());
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

	private static final String _SQL_SELECT_WORKFROMHOMEDAYTYPE =
		"SELECT workFromHomeDayType FROM WorkFromHomeDayType workFromHomeDayType";

	private static final String _SQL_SELECT_WORKFROMHOMEDAYTYPE_WHERE =
		"SELECT workFromHomeDayType FROM WorkFromHomeDayType workFromHomeDayType WHERE ";

	private static final String _SQL_COUNT_WORKFROMHOMEDAYTYPE =
		"SELECT COUNT(workFromHomeDayType) FROM WorkFromHomeDayType workFromHomeDayType";

	private static final String _SQL_COUNT_WORKFROMHOMEDAYTYPE_WHERE =
		"SELECT COUNT(workFromHomeDayType) FROM WorkFromHomeDayType workFromHomeDayType WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "workFromHomeDayType.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No WorkFromHomeDayType exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No WorkFromHomeDayType exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		WorkFromHomeDayTypePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}