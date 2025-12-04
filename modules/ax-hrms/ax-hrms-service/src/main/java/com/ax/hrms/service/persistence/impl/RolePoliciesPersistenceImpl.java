/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence.impl;

import com.ax.hrms.exception.NoSuchRolePoliciesException;
import com.ax.hrms.model.RolePolicies;
import com.ax.hrms.model.RolePoliciesTable;
import com.ax.hrms.model.impl.RolePoliciesImpl;
import com.ax.hrms.model.impl.RolePoliciesModelImpl;
import com.ax.hrms.service.persistence.RolePoliciesPersistence;
import com.ax.hrms.service.persistence.RolePoliciesUtil;
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
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
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
 * The persistence implementation for the role policies service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = RolePoliciesPersistence.class)
public class RolePoliciesPersistenceImpl
	extends BasePersistenceImpl<RolePolicies>
	implements RolePoliciesPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>RolePoliciesUtil</code> to access the role policies persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		RolePoliciesImpl.class.getName();

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
	 * Returns all the role policieses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching role policieses
	 */
	@Override
	public List<RolePolicies> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the role policieses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RolePoliciesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of role policieses
	 * @param end the upper bound of the range of role policieses (not inclusive)
	 * @return the range of matching role policieses
	 */
	@Override
	public List<RolePolicies> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the role policieses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RolePoliciesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of role policieses
	 * @param end the upper bound of the range of role policieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching role policieses
	 */
	@Override
	public List<RolePolicies> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<RolePolicies> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the role policieses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RolePoliciesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of role policieses
	 * @param end the upper bound of the range of role policieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching role policieses
	 */
	@Override
	public List<RolePolicies> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<RolePolicies> orderByComparator,
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

		List<RolePolicies> list = null;

		if (useFinderCache) {
			list = (List<RolePolicies>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RolePolicies rolePolicies : list) {
					if (!uuid.equals(rolePolicies.getUuid())) {
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

			sb.append(_SQL_SELECT_ROLEPOLICIES_WHERE);

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
				sb.append(RolePoliciesModelImpl.ORDER_BY_JPQL);
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

				list = (List<RolePolicies>)QueryUtil.list(
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
	 * Returns the first role policies in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching role policies
	 * @throws NoSuchRolePoliciesException if a matching role policies could not be found
	 */
	@Override
	public RolePolicies findByUuid_First(
			String uuid, OrderByComparator<RolePolicies> orderByComparator)
		throws NoSuchRolePoliciesException {

		RolePolicies rolePolicies = fetchByUuid_First(uuid, orderByComparator);

		if (rolePolicies != null) {
			return rolePolicies;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchRolePoliciesException(sb.toString());
	}

	/**
	 * Returns the first role policies in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching role policies, or <code>null</code> if a matching role policies could not be found
	 */
	@Override
	public RolePolicies fetchByUuid_First(
		String uuid, OrderByComparator<RolePolicies> orderByComparator) {

		List<RolePolicies> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last role policies in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching role policies
	 * @throws NoSuchRolePoliciesException if a matching role policies could not be found
	 */
	@Override
	public RolePolicies findByUuid_Last(
			String uuid, OrderByComparator<RolePolicies> orderByComparator)
		throws NoSuchRolePoliciesException {

		RolePolicies rolePolicies = fetchByUuid_Last(uuid, orderByComparator);

		if (rolePolicies != null) {
			return rolePolicies;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchRolePoliciesException(sb.toString());
	}

	/**
	 * Returns the last role policies in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching role policies, or <code>null</code> if a matching role policies could not be found
	 */
	@Override
	public RolePolicies fetchByUuid_Last(
		String uuid, OrderByComparator<RolePolicies> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<RolePolicies> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the role policieses before and after the current role policies in the ordered set where uuid = &#63;.
	 *
	 * @param rolePoliciesId the primary key of the current role policies
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next role policies
	 * @throws NoSuchRolePoliciesException if a role policies with the primary key could not be found
	 */
	@Override
	public RolePolicies[] findByUuid_PrevAndNext(
			long rolePoliciesId, String uuid,
			OrderByComparator<RolePolicies> orderByComparator)
		throws NoSuchRolePoliciesException {

		uuid = Objects.toString(uuid, "");

		RolePolicies rolePolicies = findByPrimaryKey(rolePoliciesId);

		Session session = null;

		try {
			session = openSession();

			RolePolicies[] array = new RolePoliciesImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, rolePolicies, uuid, orderByComparator, true);

			array[1] = rolePolicies;

			array[2] = getByUuid_PrevAndNext(
				session, rolePolicies, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected RolePolicies getByUuid_PrevAndNext(
		Session session, RolePolicies rolePolicies, String uuid,
		OrderByComparator<RolePolicies> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_ROLEPOLICIES_WHERE);

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
			sb.append(RolePoliciesModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(rolePolicies)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<RolePolicies> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the role policieses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (RolePolicies rolePolicies :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(rolePolicies);
		}
	}

	/**
	 * Returns the number of role policieses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching role policieses
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ROLEPOLICIES_WHERE);

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
		"rolePolicies.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(rolePolicies.uuid IS NULL OR rolePolicies.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;

	/**
	 * Returns the role policies where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchRolePoliciesException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching role policies
	 * @throws NoSuchRolePoliciesException if a matching role policies could not be found
	 */
	@Override
	public RolePolicies findByUUID_G(String uuid, long groupId)
		throws NoSuchRolePoliciesException {

		RolePolicies rolePolicies = fetchByUUID_G(uuid, groupId);

		if (rolePolicies == null) {
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

			throw new NoSuchRolePoliciesException(sb.toString());
		}

		return rolePolicies;
	}

	/**
	 * Returns the role policies where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching role policies, or <code>null</code> if a matching role policies could not be found
	 */
	@Override
	public RolePolicies fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the role policies where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching role policies, or <code>null</code> if a matching role policies could not be found
	 */
	@Override
	public RolePolicies fetchByUUID_G(
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

		if (result instanceof RolePolicies) {
			RolePolicies rolePolicies = (RolePolicies)result;

			if (!Objects.equals(uuid, rolePolicies.getUuid()) ||
				(groupId != rolePolicies.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_ROLEPOLICIES_WHERE);

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

				List<RolePolicies> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					RolePolicies rolePolicies = list.get(0);

					result = rolePolicies;

					cacheResult(rolePolicies);
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
			return (RolePolicies)result;
		}
	}

	/**
	 * Removes the role policies where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the role policies that was removed
	 */
	@Override
	public RolePolicies removeByUUID_G(String uuid, long groupId)
		throws NoSuchRolePoliciesException {

		RolePolicies rolePolicies = findByUUID_G(uuid, groupId);

		return remove(rolePolicies);
	}

	/**
	 * Returns the number of role policieses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching role policieses
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		RolePolicies rolePolicies = fetchByUUID_G(uuid, groupId);

		if (rolePolicies == null) {
			return 0;
		}

		return 1;
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"rolePolicies.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(rolePolicies.uuid IS NULL OR rolePolicies.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"rolePolicies.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the role policieses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching role policieses
	 */
	@Override
	public List<RolePolicies> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the role policieses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RolePoliciesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of role policieses
	 * @param end the upper bound of the range of role policieses (not inclusive)
	 * @return the range of matching role policieses
	 */
	@Override
	public List<RolePolicies> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the role policieses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RolePoliciesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of role policieses
	 * @param end the upper bound of the range of role policieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching role policieses
	 */
	@Override
	public List<RolePolicies> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<RolePolicies> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the role policieses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RolePoliciesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of role policieses
	 * @param end the upper bound of the range of role policieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching role policieses
	 */
	@Override
	public List<RolePolicies> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<RolePolicies> orderByComparator,
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

		List<RolePolicies> list = null;

		if (useFinderCache) {
			list = (List<RolePolicies>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RolePolicies rolePolicies : list) {
					if (!uuid.equals(rolePolicies.getUuid()) ||
						(companyId != rolePolicies.getCompanyId())) {

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

			sb.append(_SQL_SELECT_ROLEPOLICIES_WHERE);

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
				sb.append(RolePoliciesModelImpl.ORDER_BY_JPQL);
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

				list = (List<RolePolicies>)QueryUtil.list(
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
	 * Returns the first role policies in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching role policies
	 * @throws NoSuchRolePoliciesException if a matching role policies could not be found
	 */
	@Override
	public RolePolicies findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<RolePolicies> orderByComparator)
		throws NoSuchRolePoliciesException {

		RolePolicies rolePolicies = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (rolePolicies != null) {
			return rolePolicies;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchRolePoliciesException(sb.toString());
	}

	/**
	 * Returns the first role policies in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching role policies, or <code>null</code> if a matching role policies could not be found
	 */
	@Override
	public RolePolicies fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<RolePolicies> orderByComparator) {

		List<RolePolicies> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last role policies in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching role policies
	 * @throws NoSuchRolePoliciesException if a matching role policies could not be found
	 */
	@Override
	public RolePolicies findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<RolePolicies> orderByComparator)
		throws NoSuchRolePoliciesException {

		RolePolicies rolePolicies = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (rolePolicies != null) {
			return rolePolicies;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchRolePoliciesException(sb.toString());
	}

	/**
	 * Returns the last role policies in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching role policies, or <code>null</code> if a matching role policies could not be found
	 */
	@Override
	public RolePolicies fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<RolePolicies> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<RolePolicies> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the role policieses before and after the current role policies in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param rolePoliciesId the primary key of the current role policies
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next role policies
	 * @throws NoSuchRolePoliciesException if a role policies with the primary key could not be found
	 */
	@Override
	public RolePolicies[] findByUuid_C_PrevAndNext(
			long rolePoliciesId, String uuid, long companyId,
			OrderByComparator<RolePolicies> orderByComparator)
		throws NoSuchRolePoliciesException {

		uuid = Objects.toString(uuid, "");

		RolePolicies rolePolicies = findByPrimaryKey(rolePoliciesId);

		Session session = null;

		try {
			session = openSession();

			RolePolicies[] array = new RolePoliciesImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, rolePolicies, uuid, companyId, orderByComparator,
				true);

			array[1] = rolePolicies;

			array[2] = getByUuid_C_PrevAndNext(
				session, rolePolicies, uuid, companyId, orderByComparator,
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

	protected RolePolicies getByUuid_C_PrevAndNext(
		Session session, RolePolicies rolePolicies, String uuid, long companyId,
		OrderByComparator<RolePolicies> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_ROLEPOLICIES_WHERE);

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
			sb.append(RolePoliciesModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(rolePolicies)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<RolePolicies> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the role policieses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (RolePolicies rolePolicies :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(rolePolicies);
		}
	}

	/**
	 * Returns the number of role policieses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching role policieses
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_ROLEPOLICIES_WHERE);

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
		"rolePolicies.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(rolePolicies.uuid IS NULL OR rolePolicies.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"rolePolicies.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByPolicyId;
	private FinderPath _finderPathWithoutPaginationFindByPolicyId;
	private FinderPath _finderPathCountByPolicyId;

	/**
	 * Returns all the role policieses where policyId = &#63;.
	 *
	 * @param policyId the policy ID
	 * @return the matching role policieses
	 */
	@Override
	public List<RolePolicies> findByPolicyId(long policyId) {
		return findByPolicyId(
			policyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the role policieses where policyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RolePoliciesModelImpl</code>.
	 * </p>
	 *
	 * @param policyId the policy ID
	 * @param start the lower bound of the range of role policieses
	 * @param end the upper bound of the range of role policieses (not inclusive)
	 * @return the range of matching role policieses
	 */
	@Override
	public List<RolePolicies> findByPolicyId(
		long policyId, int start, int end) {

		return findByPolicyId(policyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the role policieses where policyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RolePoliciesModelImpl</code>.
	 * </p>
	 *
	 * @param policyId the policy ID
	 * @param start the lower bound of the range of role policieses
	 * @param end the upper bound of the range of role policieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching role policieses
	 */
	@Override
	public List<RolePolicies> findByPolicyId(
		long policyId, int start, int end,
		OrderByComparator<RolePolicies> orderByComparator) {

		return findByPolicyId(policyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the role policieses where policyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RolePoliciesModelImpl</code>.
	 * </p>
	 *
	 * @param policyId the policy ID
	 * @param start the lower bound of the range of role policieses
	 * @param end the upper bound of the range of role policieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching role policieses
	 */
	@Override
	public List<RolePolicies> findByPolicyId(
		long policyId, int start, int end,
		OrderByComparator<RolePolicies> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByPolicyId;
				finderArgs = new Object[] {policyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByPolicyId;
			finderArgs = new Object[] {policyId, start, end, orderByComparator};
		}

		List<RolePolicies> list = null;

		if (useFinderCache) {
			list = (List<RolePolicies>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RolePolicies rolePolicies : list) {
					if (policyId != rolePolicies.getPolicyId()) {
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

			sb.append(_SQL_SELECT_ROLEPOLICIES_WHERE);

			sb.append(_FINDER_COLUMN_POLICYID_POLICYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(RolePoliciesModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(policyId);

				list = (List<RolePolicies>)QueryUtil.list(
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
	 * Returns the first role policies in the ordered set where policyId = &#63;.
	 *
	 * @param policyId the policy ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching role policies
	 * @throws NoSuchRolePoliciesException if a matching role policies could not be found
	 */
	@Override
	public RolePolicies findByPolicyId_First(
			long policyId, OrderByComparator<RolePolicies> orderByComparator)
		throws NoSuchRolePoliciesException {

		RolePolicies rolePolicies = fetchByPolicyId_First(
			policyId, orderByComparator);

		if (rolePolicies != null) {
			return rolePolicies;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("policyId=");
		sb.append(policyId);

		sb.append("}");

		throw new NoSuchRolePoliciesException(sb.toString());
	}

	/**
	 * Returns the first role policies in the ordered set where policyId = &#63;.
	 *
	 * @param policyId the policy ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching role policies, or <code>null</code> if a matching role policies could not be found
	 */
	@Override
	public RolePolicies fetchByPolicyId_First(
		long policyId, OrderByComparator<RolePolicies> orderByComparator) {

		List<RolePolicies> list = findByPolicyId(
			policyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last role policies in the ordered set where policyId = &#63;.
	 *
	 * @param policyId the policy ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching role policies
	 * @throws NoSuchRolePoliciesException if a matching role policies could not be found
	 */
	@Override
	public RolePolicies findByPolicyId_Last(
			long policyId, OrderByComparator<RolePolicies> orderByComparator)
		throws NoSuchRolePoliciesException {

		RolePolicies rolePolicies = fetchByPolicyId_Last(
			policyId, orderByComparator);

		if (rolePolicies != null) {
			return rolePolicies;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("policyId=");
		sb.append(policyId);

		sb.append("}");

		throw new NoSuchRolePoliciesException(sb.toString());
	}

	/**
	 * Returns the last role policies in the ordered set where policyId = &#63;.
	 *
	 * @param policyId the policy ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching role policies, or <code>null</code> if a matching role policies could not be found
	 */
	@Override
	public RolePolicies fetchByPolicyId_Last(
		long policyId, OrderByComparator<RolePolicies> orderByComparator) {

		int count = countByPolicyId(policyId);

		if (count == 0) {
			return null;
		}

		List<RolePolicies> list = findByPolicyId(
			policyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the role policieses before and after the current role policies in the ordered set where policyId = &#63;.
	 *
	 * @param rolePoliciesId the primary key of the current role policies
	 * @param policyId the policy ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next role policies
	 * @throws NoSuchRolePoliciesException if a role policies with the primary key could not be found
	 */
	@Override
	public RolePolicies[] findByPolicyId_PrevAndNext(
			long rolePoliciesId, long policyId,
			OrderByComparator<RolePolicies> orderByComparator)
		throws NoSuchRolePoliciesException {

		RolePolicies rolePolicies = findByPrimaryKey(rolePoliciesId);

		Session session = null;

		try {
			session = openSession();

			RolePolicies[] array = new RolePoliciesImpl[3];

			array[0] = getByPolicyId_PrevAndNext(
				session, rolePolicies, policyId, orderByComparator, true);

			array[1] = rolePolicies;

			array[2] = getByPolicyId_PrevAndNext(
				session, rolePolicies, policyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected RolePolicies getByPolicyId_PrevAndNext(
		Session session, RolePolicies rolePolicies, long policyId,
		OrderByComparator<RolePolicies> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_ROLEPOLICIES_WHERE);

		sb.append(_FINDER_COLUMN_POLICYID_POLICYID_2);

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
			sb.append(RolePoliciesModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(policyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(rolePolicies)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<RolePolicies> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the role policieses where policyId = &#63; from the database.
	 *
	 * @param policyId the policy ID
	 */
	@Override
	public void removeByPolicyId(long policyId) {
		for (RolePolicies rolePolicies :
				findByPolicyId(
					policyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(rolePolicies);
		}
	}

	/**
	 * Returns the number of role policieses where policyId = &#63;.
	 *
	 * @param policyId the policy ID
	 * @return the number of matching role policieses
	 */
	@Override
	public int countByPolicyId(long policyId) {
		FinderPath finderPath = _finderPathCountByPolicyId;

		Object[] finderArgs = new Object[] {policyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ROLEPOLICIES_WHERE);

			sb.append(_FINDER_COLUMN_POLICYID_POLICYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(policyId);

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

	private static final String _FINDER_COLUMN_POLICYID_POLICYID_2 =
		"rolePolicies.policyId = ?";

	private FinderPath _finderPathFetchByPolicyIdAndRoleId;

	/**
	 * Returns the role policies where policyId = &#63; and roleId = &#63; or throws a <code>NoSuchRolePoliciesException</code> if it could not be found.
	 *
	 * @param policyId the policy ID
	 * @param roleId the role ID
	 * @return the matching role policies
	 * @throws NoSuchRolePoliciesException if a matching role policies could not be found
	 */
	@Override
	public RolePolicies findByPolicyIdAndRoleId(long policyId, long roleId)
		throws NoSuchRolePoliciesException {

		RolePolicies rolePolicies = fetchByPolicyIdAndRoleId(policyId, roleId);

		if (rolePolicies == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("policyId=");
			sb.append(policyId);

			sb.append(", roleId=");
			sb.append(roleId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchRolePoliciesException(sb.toString());
		}

		return rolePolicies;
	}

	/**
	 * Returns the role policies where policyId = &#63; and roleId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param policyId the policy ID
	 * @param roleId the role ID
	 * @return the matching role policies, or <code>null</code> if a matching role policies could not be found
	 */
	@Override
	public RolePolicies fetchByPolicyIdAndRoleId(long policyId, long roleId) {
		return fetchByPolicyIdAndRoleId(policyId, roleId, true);
	}

	/**
	 * Returns the role policies where policyId = &#63; and roleId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param policyId the policy ID
	 * @param roleId the role ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching role policies, or <code>null</code> if a matching role policies could not be found
	 */
	@Override
	public RolePolicies fetchByPolicyIdAndRoleId(
		long policyId, long roleId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {policyId, roleId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByPolicyIdAndRoleId, finderArgs, this);
		}

		if (result instanceof RolePolicies) {
			RolePolicies rolePolicies = (RolePolicies)result;

			if ((policyId != rolePolicies.getPolicyId()) ||
				(roleId != rolePolicies.getRoleId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_ROLEPOLICIES_WHERE);

			sb.append(_FINDER_COLUMN_POLICYIDANDROLEID_POLICYID_2);

			sb.append(_FINDER_COLUMN_POLICYIDANDROLEID_ROLEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(policyId);

				queryPos.add(roleId);

				List<RolePolicies> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByPolicyIdAndRoleId, finderArgs,
							list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {policyId, roleId};
							}

							_log.warn(
								"RolePoliciesPersistenceImpl.fetchByPolicyIdAndRoleId(long, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					RolePolicies rolePolicies = list.get(0);

					result = rolePolicies;

					cacheResult(rolePolicies);
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
			return (RolePolicies)result;
		}
	}

	/**
	 * Removes the role policies where policyId = &#63; and roleId = &#63; from the database.
	 *
	 * @param policyId the policy ID
	 * @param roleId the role ID
	 * @return the role policies that was removed
	 */
	@Override
	public RolePolicies removeByPolicyIdAndRoleId(long policyId, long roleId)
		throws NoSuchRolePoliciesException {

		RolePolicies rolePolicies = findByPolicyIdAndRoleId(policyId, roleId);

		return remove(rolePolicies);
	}

	/**
	 * Returns the number of role policieses where policyId = &#63; and roleId = &#63;.
	 *
	 * @param policyId the policy ID
	 * @param roleId the role ID
	 * @return the number of matching role policieses
	 */
	@Override
	public int countByPolicyIdAndRoleId(long policyId, long roleId) {
		RolePolicies rolePolicies = fetchByPolicyIdAndRoleId(policyId, roleId);

		if (rolePolicies == null) {
			return 0;
		}

		return 1;
	}

	private static final String _FINDER_COLUMN_POLICYIDANDROLEID_POLICYID_2 =
		"rolePolicies.policyId = ? AND ";

	private static final String _FINDER_COLUMN_POLICYIDANDROLEID_ROLEID_2 =
		"rolePolicies.roleId = ?";

	public RolePoliciesPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(RolePolicies.class);

		setModelImplClass(RolePoliciesImpl.class);
		setModelPKClass(long.class);

		setTable(RolePoliciesTable.INSTANCE);
	}

	/**
	 * Caches the role policies in the entity cache if it is enabled.
	 *
	 * @param rolePolicies the role policies
	 */
	@Override
	public void cacheResult(RolePolicies rolePolicies) {
		entityCache.putResult(
			RolePoliciesImpl.class, rolePolicies.getPrimaryKey(), rolePolicies);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {rolePolicies.getUuid(), rolePolicies.getGroupId()},
			rolePolicies);

		finderCache.putResult(
			_finderPathFetchByPolicyIdAndRoleId,
			new Object[] {rolePolicies.getPolicyId(), rolePolicies.getRoleId()},
			rolePolicies);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the role policieses in the entity cache if it is enabled.
	 *
	 * @param rolePolicieses the role policieses
	 */
	@Override
	public void cacheResult(List<RolePolicies> rolePolicieses) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (rolePolicieses.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (RolePolicies rolePolicies : rolePolicieses) {
			if (entityCache.getResult(
					RolePoliciesImpl.class, rolePolicies.getPrimaryKey()) ==
						null) {

				cacheResult(rolePolicies);
			}
		}
	}

	/**
	 * Clears the cache for all role policieses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(RolePoliciesImpl.class);

		finderCache.clearCache(RolePoliciesImpl.class);
	}

	/**
	 * Clears the cache for the role policies.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(RolePolicies rolePolicies) {
		entityCache.removeResult(RolePoliciesImpl.class, rolePolicies);
	}

	@Override
	public void clearCache(List<RolePolicies> rolePolicieses) {
		for (RolePolicies rolePolicies : rolePolicieses) {
			entityCache.removeResult(RolePoliciesImpl.class, rolePolicies);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(RolePoliciesImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(RolePoliciesImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		RolePoliciesModelImpl rolePoliciesModelImpl) {

		Object[] args = new Object[] {
			rolePoliciesModelImpl.getUuid(), rolePoliciesModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathFetchByUUID_G, args, rolePoliciesModelImpl);

		args = new Object[] {
			rolePoliciesModelImpl.getPolicyId(),
			rolePoliciesModelImpl.getRoleId()
		};

		finderCache.putResult(
			_finderPathFetchByPolicyIdAndRoleId, args, rolePoliciesModelImpl);
	}

	/**
	 * Creates a new role policies with the primary key. Does not add the role policies to the database.
	 *
	 * @param rolePoliciesId the primary key for the new role policies
	 * @return the new role policies
	 */
	@Override
	public RolePolicies create(long rolePoliciesId) {
		RolePolicies rolePolicies = new RolePoliciesImpl();

		rolePolicies.setNew(true);
		rolePolicies.setPrimaryKey(rolePoliciesId);

		String uuid = PortalUUIDUtil.generate();

		rolePolicies.setUuid(uuid);

		rolePolicies.setCompanyId(CompanyThreadLocal.getCompanyId());

		return rolePolicies;
	}

	/**
	 * Removes the role policies with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param rolePoliciesId the primary key of the role policies
	 * @return the role policies that was removed
	 * @throws NoSuchRolePoliciesException if a role policies with the primary key could not be found
	 */
	@Override
	public RolePolicies remove(long rolePoliciesId)
		throws NoSuchRolePoliciesException {

		return remove((Serializable)rolePoliciesId);
	}

	/**
	 * Removes the role policies with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the role policies
	 * @return the role policies that was removed
	 * @throws NoSuchRolePoliciesException if a role policies with the primary key could not be found
	 */
	@Override
	public RolePolicies remove(Serializable primaryKey)
		throws NoSuchRolePoliciesException {

		Session session = null;

		try {
			session = openSession();

			RolePolicies rolePolicies = (RolePolicies)session.get(
				RolePoliciesImpl.class, primaryKey);

			if (rolePolicies == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRolePoliciesException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(rolePolicies);
		}
		catch (NoSuchRolePoliciesException noSuchEntityException) {
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
	protected RolePolicies removeImpl(RolePolicies rolePolicies) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(rolePolicies)) {
				rolePolicies = (RolePolicies)session.get(
					RolePoliciesImpl.class, rolePolicies.getPrimaryKeyObj());
			}

			if (rolePolicies != null) {
				session.delete(rolePolicies);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (rolePolicies != null) {
			clearCache(rolePolicies);
		}

		return rolePolicies;
	}

	@Override
	public RolePolicies updateImpl(RolePolicies rolePolicies) {
		boolean isNew = rolePolicies.isNew();

		if (!(rolePolicies instanceof RolePoliciesModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(rolePolicies.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					rolePolicies);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in rolePolicies proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom RolePolicies implementation " +
					rolePolicies.getClass());
		}

		RolePoliciesModelImpl rolePoliciesModelImpl =
			(RolePoliciesModelImpl)rolePolicies;

		if (Validator.isNull(rolePolicies.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			rolePolicies.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (rolePolicies.getCreateDate() == null)) {
			if (serviceContext == null) {
				rolePolicies.setCreateDate(date);
			}
			else {
				rolePolicies.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!rolePoliciesModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				rolePolicies.setModifiedDate(date);
			}
			else {
				rolePolicies.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(rolePolicies);
			}
			else {
				rolePolicies = (RolePolicies)session.merge(rolePolicies);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			RolePoliciesImpl.class, rolePoliciesModelImpl, false, true);

		cacheUniqueFindersCache(rolePoliciesModelImpl);

		if (isNew) {
			rolePolicies.setNew(false);
		}

		rolePolicies.resetOriginalValues();

		return rolePolicies;
	}

	/**
	 * Returns the role policies with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the role policies
	 * @return the role policies
	 * @throws NoSuchRolePoliciesException if a role policies with the primary key could not be found
	 */
	@Override
	public RolePolicies findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRolePoliciesException {

		RolePolicies rolePolicies = fetchByPrimaryKey(primaryKey);

		if (rolePolicies == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRolePoliciesException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return rolePolicies;
	}

	/**
	 * Returns the role policies with the primary key or throws a <code>NoSuchRolePoliciesException</code> if it could not be found.
	 *
	 * @param rolePoliciesId the primary key of the role policies
	 * @return the role policies
	 * @throws NoSuchRolePoliciesException if a role policies with the primary key could not be found
	 */
	@Override
	public RolePolicies findByPrimaryKey(long rolePoliciesId)
		throws NoSuchRolePoliciesException {

		return findByPrimaryKey((Serializable)rolePoliciesId);
	}

	/**
	 * Returns the role policies with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param rolePoliciesId the primary key of the role policies
	 * @return the role policies, or <code>null</code> if a role policies with the primary key could not be found
	 */
	@Override
	public RolePolicies fetchByPrimaryKey(long rolePoliciesId) {
		return fetchByPrimaryKey((Serializable)rolePoliciesId);
	}

	/**
	 * Returns all the role policieses.
	 *
	 * @return the role policieses
	 */
	@Override
	public List<RolePolicies> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the role policieses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RolePoliciesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of role policieses
	 * @param end the upper bound of the range of role policieses (not inclusive)
	 * @return the range of role policieses
	 */
	@Override
	public List<RolePolicies> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the role policieses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RolePoliciesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of role policieses
	 * @param end the upper bound of the range of role policieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of role policieses
	 */
	@Override
	public List<RolePolicies> findAll(
		int start, int end, OrderByComparator<RolePolicies> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the role policieses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RolePoliciesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of role policieses
	 * @param end the upper bound of the range of role policieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of role policieses
	 */
	@Override
	public List<RolePolicies> findAll(
		int start, int end, OrderByComparator<RolePolicies> orderByComparator,
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

		List<RolePolicies> list = null;

		if (useFinderCache) {
			list = (List<RolePolicies>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_ROLEPOLICIES);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_ROLEPOLICIES;

				sql = sql.concat(RolePoliciesModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<RolePolicies>)QueryUtil.list(
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
	 * Removes all the role policieses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (RolePolicies rolePolicies : findAll()) {
			remove(rolePolicies);
		}
	}

	/**
	 * Returns the number of role policieses.
	 *
	 * @return the number of role policieses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_ROLEPOLICIES);

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
		return "rolePoliciesId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_ROLEPOLICIES;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return RolePoliciesModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the role policies persistence.
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

		_finderPathWithPaginationFindByPolicyId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPolicyId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"policyId"}, true);

		_finderPathWithoutPaginationFindByPolicyId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPolicyId",
			new String[] {Long.class.getName()}, new String[] {"policyId"},
			true);

		_finderPathCountByPolicyId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPolicyId",
			new String[] {Long.class.getName()}, new String[] {"policyId"},
			false);

		_finderPathFetchByPolicyIdAndRoleId = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByPolicyIdAndRoleId",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"policyId", "roleId"}, true);

		RolePoliciesUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		RolePoliciesUtil.setPersistence(null);

		entityCache.removeCache(RolePoliciesImpl.class.getName());
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

	private static final String _SQL_SELECT_ROLEPOLICIES =
		"SELECT rolePolicies FROM RolePolicies rolePolicies";

	private static final String _SQL_SELECT_ROLEPOLICIES_WHERE =
		"SELECT rolePolicies FROM RolePolicies rolePolicies WHERE ";

	private static final String _SQL_COUNT_ROLEPOLICIES =
		"SELECT COUNT(rolePolicies) FROM RolePolicies rolePolicies";

	private static final String _SQL_COUNT_ROLEPOLICIES_WHERE =
		"SELECT COUNT(rolePolicies) FROM RolePolicies rolePolicies WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "rolePolicies.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No RolePolicies exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No RolePolicies exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		RolePoliciesPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}