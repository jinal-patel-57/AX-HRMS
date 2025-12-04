/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence.impl;

import com.ax.hrms.exception.NoSuchLeaveDayTypeException;
import com.ax.hrms.model.LeaveDayType;
import com.ax.hrms.model.LeaveDayTypeTable;
import com.ax.hrms.model.impl.LeaveDayTypeImpl;
import com.ax.hrms.model.impl.LeaveDayTypeModelImpl;
import com.ax.hrms.service.persistence.LeaveDayTypePersistence;
import com.ax.hrms.service.persistence.LeaveDayTypeUtil;
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
 * The persistence implementation for the leave day type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = LeaveDayTypePersistence.class)
public class LeaveDayTypePersistenceImpl
	extends BasePersistenceImpl<LeaveDayType>
	implements LeaveDayTypePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>LeaveDayTypeUtil</code> to access the leave day type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		LeaveDayTypeImpl.class.getName();

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
	 * Returns all the leave day types where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching leave day types
	 */
	@Override
	public List<LeaveDayType> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the leave day types where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveDayTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of leave day types
	 * @param end the upper bound of the range of leave day types (not inclusive)
	 * @return the range of matching leave day types
	 */
	@Override
	public List<LeaveDayType> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the leave day types where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveDayTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of leave day types
	 * @param end the upper bound of the range of leave day types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leave day types
	 */
	@Override
	public List<LeaveDayType> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<LeaveDayType> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the leave day types where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveDayTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of leave day types
	 * @param end the upper bound of the range of leave day types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching leave day types
	 */
	@Override
	public List<LeaveDayType> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<LeaveDayType> orderByComparator,
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

		List<LeaveDayType> list = null;

		if (useFinderCache) {
			list = (List<LeaveDayType>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LeaveDayType leaveDayType : list) {
					if (!uuid.equals(leaveDayType.getUuid())) {
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

			sb.append(_SQL_SELECT_LEAVEDAYTYPE_WHERE);

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
				sb.append(LeaveDayTypeModelImpl.ORDER_BY_JPQL);
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

				list = (List<LeaveDayType>)QueryUtil.list(
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
	 * Returns the first leave day type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave day type
	 * @throws NoSuchLeaveDayTypeException if a matching leave day type could not be found
	 */
	@Override
	public LeaveDayType findByUuid_First(
			String uuid, OrderByComparator<LeaveDayType> orderByComparator)
		throws NoSuchLeaveDayTypeException {

		LeaveDayType leaveDayType = fetchByUuid_First(uuid, orderByComparator);

		if (leaveDayType != null) {
			return leaveDayType;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchLeaveDayTypeException(sb.toString());
	}

	/**
	 * Returns the first leave day type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave day type, or <code>null</code> if a matching leave day type could not be found
	 */
	@Override
	public LeaveDayType fetchByUuid_First(
		String uuid, OrderByComparator<LeaveDayType> orderByComparator) {

		List<LeaveDayType> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last leave day type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave day type
	 * @throws NoSuchLeaveDayTypeException if a matching leave day type could not be found
	 */
	@Override
	public LeaveDayType findByUuid_Last(
			String uuid, OrderByComparator<LeaveDayType> orderByComparator)
		throws NoSuchLeaveDayTypeException {

		LeaveDayType leaveDayType = fetchByUuid_Last(uuid, orderByComparator);

		if (leaveDayType != null) {
			return leaveDayType;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchLeaveDayTypeException(sb.toString());
	}

	/**
	 * Returns the last leave day type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave day type, or <code>null</code> if a matching leave day type could not be found
	 */
	@Override
	public LeaveDayType fetchByUuid_Last(
		String uuid, OrderByComparator<LeaveDayType> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<LeaveDayType> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the leave day types before and after the current leave day type in the ordered set where uuid = &#63;.
	 *
	 * @param leaveDayTypeId the primary key of the current leave day type
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave day type
	 * @throws NoSuchLeaveDayTypeException if a leave day type with the primary key could not be found
	 */
	@Override
	public LeaveDayType[] findByUuid_PrevAndNext(
			long leaveDayTypeId, String uuid,
			OrderByComparator<LeaveDayType> orderByComparator)
		throws NoSuchLeaveDayTypeException {

		uuid = Objects.toString(uuid, "");

		LeaveDayType leaveDayType = findByPrimaryKey(leaveDayTypeId);

		Session session = null;

		try {
			session = openSession();

			LeaveDayType[] array = new LeaveDayTypeImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, leaveDayType, uuid, orderByComparator, true);

			array[1] = leaveDayType;

			array[2] = getByUuid_PrevAndNext(
				session, leaveDayType, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected LeaveDayType getByUuid_PrevAndNext(
		Session session, LeaveDayType leaveDayType, String uuid,
		OrderByComparator<LeaveDayType> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_LEAVEDAYTYPE_WHERE);

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
			sb.append(LeaveDayTypeModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(leaveDayType)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<LeaveDayType> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the leave day types where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (LeaveDayType leaveDayType :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(leaveDayType);
		}
	}

	/**
	 * Returns the number of leave day types where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching leave day types
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_LEAVEDAYTYPE_WHERE);

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
		"leaveDayType.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(leaveDayType.uuid IS NULL OR leaveDayType.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;

	/**
	 * Returns the leave day type where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchLeaveDayTypeException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching leave day type
	 * @throws NoSuchLeaveDayTypeException if a matching leave day type could not be found
	 */
	@Override
	public LeaveDayType findByUUID_G(String uuid, long groupId)
		throws NoSuchLeaveDayTypeException {

		LeaveDayType leaveDayType = fetchByUUID_G(uuid, groupId);

		if (leaveDayType == null) {
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

			throw new NoSuchLeaveDayTypeException(sb.toString());
		}

		return leaveDayType;
	}

	/**
	 * Returns the leave day type where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching leave day type, or <code>null</code> if a matching leave day type could not be found
	 */
	@Override
	public LeaveDayType fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the leave day type where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching leave day type, or <code>null</code> if a matching leave day type could not be found
	 */
	@Override
	public LeaveDayType fetchByUUID_G(
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

		if (result instanceof LeaveDayType) {
			LeaveDayType leaveDayType = (LeaveDayType)result;

			if (!Objects.equals(uuid, leaveDayType.getUuid()) ||
				(groupId != leaveDayType.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_LEAVEDAYTYPE_WHERE);

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

				List<LeaveDayType> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					LeaveDayType leaveDayType = list.get(0);

					result = leaveDayType;

					cacheResult(leaveDayType);
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
			return (LeaveDayType)result;
		}
	}

	/**
	 * Removes the leave day type where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the leave day type that was removed
	 */
	@Override
	public LeaveDayType removeByUUID_G(String uuid, long groupId)
		throws NoSuchLeaveDayTypeException {

		LeaveDayType leaveDayType = findByUUID_G(uuid, groupId);

		return remove(leaveDayType);
	}

	/**
	 * Returns the number of leave day types where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching leave day types
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		LeaveDayType leaveDayType = fetchByUUID_G(uuid, groupId);

		if (leaveDayType == null) {
			return 0;
		}

		return 1;
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"leaveDayType.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(leaveDayType.uuid IS NULL OR leaveDayType.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"leaveDayType.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the leave day types where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching leave day types
	 */
	@Override
	public List<LeaveDayType> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the leave day types where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveDayTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of leave day types
	 * @param end the upper bound of the range of leave day types (not inclusive)
	 * @return the range of matching leave day types
	 */
	@Override
	public List<LeaveDayType> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the leave day types where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveDayTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of leave day types
	 * @param end the upper bound of the range of leave day types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leave day types
	 */
	@Override
	public List<LeaveDayType> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<LeaveDayType> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the leave day types where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveDayTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of leave day types
	 * @param end the upper bound of the range of leave day types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching leave day types
	 */
	@Override
	public List<LeaveDayType> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<LeaveDayType> orderByComparator,
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

		List<LeaveDayType> list = null;

		if (useFinderCache) {
			list = (List<LeaveDayType>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LeaveDayType leaveDayType : list) {
					if (!uuid.equals(leaveDayType.getUuid()) ||
						(companyId != leaveDayType.getCompanyId())) {

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

			sb.append(_SQL_SELECT_LEAVEDAYTYPE_WHERE);

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
				sb.append(LeaveDayTypeModelImpl.ORDER_BY_JPQL);
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

				list = (List<LeaveDayType>)QueryUtil.list(
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
	 * Returns the first leave day type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave day type
	 * @throws NoSuchLeaveDayTypeException if a matching leave day type could not be found
	 */
	@Override
	public LeaveDayType findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<LeaveDayType> orderByComparator)
		throws NoSuchLeaveDayTypeException {

		LeaveDayType leaveDayType = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (leaveDayType != null) {
			return leaveDayType;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchLeaveDayTypeException(sb.toString());
	}

	/**
	 * Returns the first leave day type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave day type, or <code>null</code> if a matching leave day type could not be found
	 */
	@Override
	public LeaveDayType fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<LeaveDayType> orderByComparator) {

		List<LeaveDayType> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last leave day type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave day type
	 * @throws NoSuchLeaveDayTypeException if a matching leave day type could not be found
	 */
	@Override
	public LeaveDayType findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<LeaveDayType> orderByComparator)
		throws NoSuchLeaveDayTypeException {

		LeaveDayType leaveDayType = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (leaveDayType != null) {
			return leaveDayType;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchLeaveDayTypeException(sb.toString());
	}

	/**
	 * Returns the last leave day type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave day type, or <code>null</code> if a matching leave day type could not be found
	 */
	@Override
	public LeaveDayType fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<LeaveDayType> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<LeaveDayType> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the leave day types before and after the current leave day type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param leaveDayTypeId the primary key of the current leave day type
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave day type
	 * @throws NoSuchLeaveDayTypeException if a leave day type with the primary key could not be found
	 */
	@Override
	public LeaveDayType[] findByUuid_C_PrevAndNext(
			long leaveDayTypeId, String uuid, long companyId,
			OrderByComparator<LeaveDayType> orderByComparator)
		throws NoSuchLeaveDayTypeException {

		uuid = Objects.toString(uuid, "");

		LeaveDayType leaveDayType = findByPrimaryKey(leaveDayTypeId);

		Session session = null;

		try {
			session = openSession();

			LeaveDayType[] array = new LeaveDayTypeImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, leaveDayType, uuid, companyId, orderByComparator,
				true);

			array[1] = leaveDayType;

			array[2] = getByUuid_C_PrevAndNext(
				session, leaveDayType, uuid, companyId, orderByComparator,
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

	protected LeaveDayType getByUuid_C_PrevAndNext(
		Session session, LeaveDayType leaveDayType, String uuid, long companyId,
		OrderByComparator<LeaveDayType> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_LEAVEDAYTYPE_WHERE);

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
			sb.append(LeaveDayTypeModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(leaveDayType)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<LeaveDayType> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the leave day types where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (LeaveDayType leaveDayType :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(leaveDayType);
		}
	}

	/**
	 * Returns the number of leave day types where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching leave day types
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_LEAVEDAYTYPE_WHERE);

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
		"leaveDayType.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(leaveDayType.uuid IS NULL OR leaveDayType.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"leaveDayType.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByLeaveRequestId;
	private FinderPath _finderPathWithoutPaginationFindByLeaveRequestId;
	private FinderPath _finderPathCountByLeaveRequestId;

	/**
	 * Returns all the leave day types where leaveRequestId = &#63;.
	 *
	 * @param leaveRequestId the leave request ID
	 * @return the matching leave day types
	 */
	@Override
	public List<LeaveDayType> findByLeaveRequestId(long leaveRequestId) {
		return findByLeaveRequestId(
			leaveRequestId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the leave day types where leaveRequestId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveDayTypeModelImpl</code>.
	 * </p>
	 *
	 * @param leaveRequestId the leave request ID
	 * @param start the lower bound of the range of leave day types
	 * @param end the upper bound of the range of leave day types (not inclusive)
	 * @return the range of matching leave day types
	 */
	@Override
	public List<LeaveDayType> findByLeaveRequestId(
		long leaveRequestId, int start, int end) {

		return findByLeaveRequestId(leaveRequestId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the leave day types where leaveRequestId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveDayTypeModelImpl</code>.
	 * </p>
	 *
	 * @param leaveRequestId the leave request ID
	 * @param start the lower bound of the range of leave day types
	 * @param end the upper bound of the range of leave day types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leave day types
	 */
	@Override
	public List<LeaveDayType> findByLeaveRequestId(
		long leaveRequestId, int start, int end,
		OrderByComparator<LeaveDayType> orderByComparator) {

		return findByLeaveRequestId(
			leaveRequestId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the leave day types where leaveRequestId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveDayTypeModelImpl</code>.
	 * </p>
	 *
	 * @param leaveRequestId the leave request ID
	 * @param start the lower bound of the range of leave day types
	 * @param end the upper bound of the range of leave day types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching leave day types
	 */
	@Override
	public List<LeaveDayType> findByLeaveRequestId(
		long leaveRequestId, int start, int end,
		OrderByComparator<LeaveDayType> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByLeaveRequestId;
				finderArgs = new Object[] {leaveRequestId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByLeaveRequestId;
			finderArgs = new Object[] {
				leaveRequestId, start, end, orderByComparator
			};
		}

		List<LeaveDayType> list = null;

		if (useFinderCache) {
			list = (List<LeaveDayType>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LeaveDayType leaveDayType : list) {
					if (leaveRequestId != leaveDayType.getLeaveRequestId()) {
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

			sb.append(_SQL_SELECT_LEAVEDAYTYPE_WHERE);

			sb.append(_FINDER_COLUMN_LEAVEREQUESTID_LEAVEREQUESTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(LeaveDayTypeModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(leaveRequestId);

				list = (List<LeaveDayType>)QueryUtil.list(
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
	 * Returns the first leave day type in the ordered set where leaveRequestId = &#63;.
	 *
	 * @param leaveRequestId the leave request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave day type
	 * @throws NoSuchLeaveDayTypeException if a matching leave day type could not be found
	 */
	@Override
	public LeaveDayType findByLeaveRequestId_First(
			long leaveRequestId,
			OrderByComparator<LeaveDayType> orderByComparator)
		throws NoSuchLeaveDayTypeException {

		LeaveDayType leaveDayType = fetchByLeaveRequestId_First(
			leaveRequestId, orderByComparator);

		if (leaveDayType != null) {
			return leaveDayType;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("leaveRequestId=");
		sb.append(leaveRequestId);

		sb.append("}");

		throw new NoSuchLeaveDayTypeException(sb.toString());
	}

	/**
	 * Returns the first leave day type in the ordered set where leaveRequestId = &#63;.
	 *
	 * @param leaveRequestId the leave request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave day type, or <code>null</code> if a matching leave day type could not be found
	 */
	@Override
	public LeaveDayType fetchByLeaveRequestId_First(
		long leaveRequestId,
		OrderByComparator<LeaveDayType> orderByComparator) {

		List<LeaveDayType> list = findByLeaveRequestId(
			leaveRequestId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last leave day type in the ordered set where leaveRequestId = &#63;.
	 *
	 * @param leaveRequestId the leave request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave day type
	 * @throws NoSuchLeaveDayTypeException if a matching leave day type could not be found
	 */
	@Override
	public LeaveDayType findByLeaveRequestId_Last(
			long leaveRequestId,
			OrderByComparator<LeaveDayType> orderByComparator)
		throws NoSuchLeaveDayTypeException {

		LeaveDayType leaveDayType = fetchByLeaveRequestId_Last(
			leaveRequestId, orderByComparator);

		if (leaveDayType != null) {
			return leaveDayType;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("leaveRequestId=");
		sb.append(leaveRequestId);

		sb.append("}");

		throw new NoSuchLeaveDayTypeException(sb.toString());
	}

	/**
	 * Returns the last leave day type in the ordered set where leaveRequestId = &#63;.
	 *
	 * @param leaveRequestId the leave request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave day type, or <code>null</code> if a matching leave day type could not be found
	 */
	@Override
	public LeaveDayType fetchByLeaveRequestId_Last(
		long leaveRequestId,
		OrderByComparator<LeaveDayType> orderByComparator) {

		int count = countByLeaveRequestId(leaveRequestId);

		if (count == 0) {
			return null;
		}

		List<LeaveDayType> list = findByLeaveRequestId(
			leaveRequestId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the leave day types before and after the current leave day type in the ordered set where leaveRequestId = &#63;.
	 *
	 * @param leaveDayTypeId the primary key of the current leave day type
	 * @param leaveRequestId the leave request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave day type
	 * @throws NoSuchLeaveDayTypeException if a leave day type with the primary key could not be found
	 */
	@Override
	public LeaveDayType[] findByLeaveRequestId_PrevAndNext(
			long leaveDayTypeId, long leaveRequestId,
			OrderByComparator<LeaveDayType> orderByComparator)
		throws NoSuchLeaveDayTypeException {

		LeaveDayType leaveDayType = findByPrimaryKey(leaveDayTypeId);

		Session session = null;

		try {
			session = openSession();

			LeaveDayType[] array = new LeaveDayTypeImpl[3];

			array[0] = getByLeaveRequestId_PrevAndNext(
				session, leaveDayType, leaveRequestId, orderByComparator, true);

			array[1] = leaveDayType;

			array[2] = getByLeaveRequestId_PrevAndNext(
				session, leaveDayType, leaveRequestId, orderByComparator,
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

	protected LeaveDayType getByLeaveRequestId_PrevAndNext(
		Session session, LeaveDayType leaveDayType, long leaveRequestId,
		OrderByComparator<LeaveDayType> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_LEAVEDAYTYPE_WHERE);

		sb.append(_FINDER_COLUMN_LEAVEREQUESTID_LEAVEREQUESTID_2);

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
			sb.append(LeaveDayTypeModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(leaveRequestId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(leaveDayType)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<LeaveDayType> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the leave day types where leaveRequestId = &#63; from the database.
	 *
	 * @param leaveRequestId the leave request ID
	 */
	@Override
	public void removeByLeaveRequestId(long leaveRequestId) {
		for (LeaveDayType leaveDayType :
				findByLeaveRequestId(
					leaveRequestId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(leaveDayType);
		}
	}

	/**
	 * Returns the number of leave day types where leaveRequestId = &#63;.
	 *
	 * @param leaveRequestId the leave request ID
	 * @return the number of matching leave day types
	 */
	@Override
	public int countByLeaveRequestId(long leaveRequestId) {
		FinderPath finderPath = _finderPathCountByLeaveRequestId;

		Object[] finderArgs = new Object[] {leaveRequestId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_LEAVEDAYTYPE_WHERE);

			sb.append(_FINDER_COLUMN_LEAVEREQUESTID_LEAVEREQUESTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(leaveRequestId);

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

	private static final String _FINDER_COLUMN_LEAVEREQUESTID_LEAVEREQUESTID_2 =
		"leaveDayType.leaveRequestId = ?";

	public LeaveDayTypePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(LeaveDayType.class);

		setModelImplClass(LeaveDayTypeImpl.class);
		setModelPKClass(long.class);

		setTable(LeaveDayTypeTable.INSTANCE);
	}

	/**
	 * Caches the leave day type in the entity cache if it is enabled.
	 *
	 * @param leaveDayType the leave day type
	 */
	@Override
	public void cacheResult(LeaveDayType leaveDayType) {
		entityCache.putResult(
			LeaveDayTypeImpl.class, leaveDayType.getPrimaryKey(), leaveDayType);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {leaveDayType.getUuid(), leaveDayType.getGroupId()},
			leaveDayType);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the leave day types in the entity cache if it is enabled.
	 *
	 * @param leaveDayTypes the leave day types
	 */
	@Override
	public void cacheResult(List<LeaveDayType> leaveDayTypes) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (leaveDayTypes.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (LeaveDayType leaveDayType : leaveDayTypes) {
			if (entityCache.getResult(
					LeaveDayTypeImpl.class, leaveDayType.getPrimaryKey()) ==
						null) {

				cacheResult(leaveDayType);
			}
		}
	}

	/**
	 * Clears the cache for all leave day types.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(LeaveDayTypeImpl.class);

		finderCache.clearCache(LeaveDayTypeImpl.class);
	}

	/**
	 * Clears the cache for the leave day type.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LeaveDayType leaveDayType) {
		entityCache.removeResult(LeaveDayTypeImpl.class, leaveDayType);
	}

	@Override
	public void clearCache(List<LeaveDayType> leaveDayTypes) {
		for (LeaveDayType leaveDayType : leaveDayTypes) {
			entityCache.removeResult(LeaveDayTypeImpl.class, leaveDayType);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(LeaveDayTypeImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(LeaveDayTypeImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		LeaveDayTypeModelImpl leaveDayTypeModelImpl) {

		Object[] args = new Object[] {
			leaveDayTypeModelImpl.getUuid(), leaveDayTypeModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathFetchByUUID_G, args, leaveDayTypeModelImpl);
	}

	/**
	 * Creates a new leave day type with the primary key. Does not add the leave day type to the database.
	 *
	 * @param leaveDayTypeId the primary key for the new leave day type
	 * @return the new leave day type
	 */
	@Override
	public LeaveDayType create(long leaveDayTypeId) {
		LeaveDayType leaveDayType = new LeaveDayTypeImpl();

		leaveDayType.setNew(true);
		leaveDayType.setPrimaryKey(leaveDayTypeId);

		String uuid = PortalUUIDUtil.generate();

		leaveDayType.setUuid(uuid);

		leaveDayType.setCompanyId(CompanyThreadLocal.getCompanyId());

		return leaveDayType;
	}

	/**
	 * Removes the leave day type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param leaveDayTypeId the primary key of the leave day type
	 * @return the leave day type that was removed
	 * @throws NoSuchLeaveDayTypeException if a leave day type with the primary key could not be found
	 */
	@Override
	public LeaveDayType remove(long leaveDayTypeId)
		throws NoSuchLeaveDayTypeException {

		return remove((Serializable)leaveDayTypeId);
	}

	/**
	 * Removes the leave day type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the leave day type
	 * @return the leave day type that was removed
	 * @throws NoSuchLeaveDayTypeException if a leave day type with the primary key could not be found
	 */
	@Override
	public LeaveDayType remove(Serializable primaryKey)
		throws NoSuchLeaveDayTypeException {

		Session session = null;

		try {
			session = openSession();

			LeaveDayType leaveDayType = (LeaveDayType)session.get(
				LeaveDayTypeImpl.class, primaryKey);

			if (leaveDayType == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLeaveDayTypeException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(leaveDayType);
		}
		catch (NoSuchLeaveDayTypeException noSuchEntityException) {
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
	protected LeaveDayType removeImpl(LeaveDayType leaveDayType) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(leaveDayType)) {
				leaveDayType = (LeaveDayType)session.get(
					LeaveDayTypeImpl.class, leaveDayType.getPrimaryKeyObj());
			}

			if (leaveDayType != null) {
				session.delete(leaveDayType);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (leaveDayType != null) {
			clearCache(leaveDayType);
		}

		return leaveDayType;
	}

	@Override
	public LeaveDayType updateImpl(LeaveDayType leaveDayType) {
		boolean isNew = leaveDayType.isNew();

		if (!(leaveDayType instanceof LeaveDayTypeModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(leaveDayType.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					leaveDayType);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in leaveDayType proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom LeaveDayType implementation " +
					leaveDayType.getClass());
		}

		LeaveDayTypeModelImpl leaveDayTypeModelImpl =
			(LeaveDayTypeModelImpl)leaveDayType;

		if (Validator.isNull(leaveDayType.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			leaveDayType.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (leaveDayType.getCreateDate() == null)) {
			if (serviceContext == null) {
				leaveDayType.setCreateDate(date);
			}
			else {
				leaveDayType.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!leaveDayTypeModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				leaveDayType.setModifiedDate(date);
			}
			else {
				leaveDayType.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(leaveDayType);
			}
			else {
				leaveDayType = (LeaveDayType)session.merge(leaveDayType);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			LeaveDayTypeImpl.class, leaveDayTypeModelImpl, false, true);

		cacheUniqueFindersCache(leaveDayTypeModelImpl);

		if (isNew) {
			leaveDayType.setNew(false);
		}

		leaveDayType.resetOriginalValues();

		return leaveDayType;
	}

	/**
	 * Returns the leave day type with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the leave day type
	 * @return the leave day type
	 * @throws NoSuchLeaveDayTypeException if a leave day type with the primary key could not be found
	 */
	@Override
	public LeaveDayType findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLeaveDayTypeException {

		LeaveDayType leaveDayType = fetchByPrimaryKey(primaryKey);

		if (leaveDayType == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLeaveDayTypeException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return leaveDayType;
	}

	/**
	 * Returns the leave day type with the primary key or throws a <code>NoSuchLeaveDayTypeException</code> if it could not be found.
	 *
	 * @param leaveDayTypeId the primary key of the leave day type
	 * @return the leave day type
	 * @throws NoSuchLeaveDayTypeException if a leave day type with the primary key could not be found
	 */
	@Override
	public LeaveDayType findByPrimaryKey(long leaveDayTypeId)
		throws NoSuchLeaveDayTypeException {

		return findByPrimaryKey((Serializable)leaveDayTypeId);
	}

	/**
	 * Returns the leave day type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param leaveDayTypeId the primary key of the leave day type
	 * @return the leave day type, or <code>null</code> if a leave day type with the primary key could not be found
	 */
	@Override
	public LeaveDayType fetchByPrimaryKey(long leaveDayTypeId) {
		return fetchByPrimaryKey((Serializable)leaveDayTypeId);
	}

	/**
	 * Returns all the leave day types.
	 *
	 * @return the leave day types
	 */
	@Override
	public List<LeaveDayType> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the leave day types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveDayTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave day types
	 * @param end the upper bound of the range of leave day types (not inclusive)
	 * @return the range of leave day types
	 */
	@Override
	public List<LeaveDayType> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the leave day types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveDayTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave day types
	 * @param end the upper bound of the range of leave day types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of leave day types
	 */
	@Override
	public List<LeaveDayType> findAll(
		int start, int end, OrderByComparator<LeaveDayType> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the leave day types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveDayTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave day types
	 * @param end the upper bound of the range of leave day types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of leave day types
	 */
	@Override
	public List<LeaveDayType> findAll(
		int start, int end, OrderByComparator<LeaveDayType> orderByComparator,
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

		List<LeaveDayType> list = null;

		if (useFinderCache) {
			list = (List<LeaveDayType>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_LEAVEDAYTYPE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_LEAVEDAYTYPE;

				sql = sql.concat(LeaveDayTypeModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<LeaveDayType>)QueryUtil.list(
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
	 * Removes all the leave day types from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (LeaveDayType leaveDayType : findAll()) {
			remove(leaveDayType);
		}
	}

	/**
	 * Returns the number of leave day types.
	 *
	 * @return the number of leave day types
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_LEAVEDAYTYPE);

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
		return "leaveDayTypeId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_LEAVEDAYTYPE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return LeaveDayTypeModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the leave day type persistence.
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

		_finderPathWithPaginationFindByLeaveRequestId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLeaveRequestId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"leaveRequestId"}, true);

		_finderPathWithoutPaginationFindByLeaveRequestId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByLeaveRequestId",
			new String[] {Long.class.getName()},
			new String[] {"leaveRequestId"}, true);

		_finderPathCountByLeaveRequestId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLeaveRequestId",
			new String[] {Long.class.getName()},
			new String[] {"leaveRequestId"}, false);

		LeaveDayTypeUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		LeaveDayTypeUtil.setPersistence(null);

		entityCache.removeCache(LeaveDayTypeImpl.class.getName());
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

	private static final String _SQL_SELECT_LEAVEDAYTYPE =
		"SELECT leaveDayType FROM LeaveDayType leaveDayType";

	private static final String _SQL_SELECT_LEAVEDAYTYPE_WHERE =
		"SELECT leaveDayType FROM LeaveDayType leaveDayType WHERE ";

	private static final String _SQL_COUNT_LEAVEDAYTYPE =
		"SELECT COUNT(leaveDayType) FROM LeaveDayType leaveDayType";

	private static final String _SQL_COUNT_LEAVEDAYTYPE_WHERE =
		"SELECT COUNT(leaveDayType) FROM LeaveDayType leaveDayType WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "leaveDayType.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No LeaveDayType exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No LeaveDayType exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		LeaveDayTypePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}