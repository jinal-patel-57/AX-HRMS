/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence.impl;

import com.ax.hrms.exception.NoSuchEmployeeOffBoardingException;
import com.ax.hrms.model.EmployeeOffBoarding;
import com.ax.hrms.model.EmployeeOffBoardingTable;
import com.ax.hrms.model.impl.EmployeeOffBoardingImpl;
import com.ax.hrms.model.impl.EmployeeOffBoardingModelImpl;
import com.ax.hrms.service.persistence.EmployeeOffBoardingPersistence;
import com.ax.hrms.service.persistence.EmployeeOffBoardingUtil;
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
 * The persistence implementation for the employee off boarding service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = EmployeeOffBoardingPersistence.class)
public class EmployeeOffBoardingPersistenceImpl
	extends BasePersistenceImpl<EmployeeOffBoarding>
	implements EmployeeOffBoardingPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>EmployeeOffBoardingUtil</code> to access the employee off boarding persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		EmployeeOffBoardingImpl.class.getName();

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
	 * Returns all the employee off boardings where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching employee off boardings
	 */
	@Override
	public List<EmployeeOffBoarding> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee off boardings where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeOffBoardingModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee off boardings
	 * @param end the upper bound of the range of employee off boardings (not inclusive)
	 * @return the range of matching employee off boardings
	 */
	@Override
	public List<EmployeeOffBoarding> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee off boardings where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeOffBoardingModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee off boardings
	 * @param end the upper bound of the range of employee off boardings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee off boardings
	 */
	@Override
	public List<EmployeeOffBoarding> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EmployeeOffBoarding> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee off boardings where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeOffBoardingModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee off boardings
	 * @param end the upper bound of the range of employee off boardings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee off boardings
	 */
	@Override
	public List<EmployeeOffBoarding> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EmployeeOffBoarding> orderByComparator,
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

		List<EmployeeOffBoarding> list = null;

		if (useFinderCache) {
			list = (List<EmployeeOffBoarding>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EmployeeOffBoarding employeeOffBoarding : list) {
					if (!uuid.equals(employeeOffBoarding.getUuid())) {
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

			sb.append(_SQL_SELECT_EMPLOYEEOFFBOARDING_WHERE);

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
				sb.append(EmployeeOffBoardingModelImpl.ORDER_BY_JPQL);
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

				list = (List<EmployeeOffBoarding>)QueryUtil.list(
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
	 * Returns the first employee off boarding in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee off boarding
	 * @throws NoSuchEmployeeOffBoardingException if a matching employee off boarding could not be found
	 */
	@Override
	public EmployeeOffBoarding findByUuid_First(
			String uuid,
			OrderByComparator<EmployeeOffBoarding> orderByComparator)
		throws NoSuchEmployeeOffBoardingException {

		EmployeeOffBoarding employeeOffBoarding = fetchByUuid_First(
			uuid, orderByComparator);

		if (employeeOffBoarding != null) {
			return employeeOffBoarding;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchEmployeeOffBoardingException(sb.toString());
	}

	/**
	 * Returns the first employee off boarding in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee off boarding, or <code>null</code> if a matching employee off boarding could not be found
	 */
	@Override
	public EmployeeOffBoarding fetchByUuid_First(
		String uuid, OrderByComparator<EmployeeOffBoarding> orderByComparator) {

		List<EmployeeOffBoarding> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee off boarding in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee off boarding
	 * @throws NoSuchEmployeeOffBoardingException if a matching employee off boarding could not be found
	 */
	@Override
	public EmployeeOffBoarding findByUuid_Last(
			String uuid,
			OrderByComparator<EmployeeOffBoarding> orderByComparator)
		throws NoSuchEmployeeOffBoardingException {

		EmployeeOffBoarding employeeOffBoarding = fetchByUuid_Last(
			uuid, orderByComparator);

		if (employeeOffBoarding != null) {
			return employeeOffBoarding;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchEmployeeOffBoardingException(sb.toString());
	}

	/**
	 * Returns the last employee off boarding in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee off boarding, or <code>null</code> if a matching employee off boarding could not be found
	 */
	@Override
	public EmployeeOffBoarding fetchByUuid_Last(
		String uuid, OrderByComparator<EmployeeOffBoarding> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<EmployeeOffBoarding> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the employee off boardings before and after the current employee off boarding in the ordered set where uuid = &#63;.
	 *
	 * @param employeeOffBoardingId the primary key of the current employee off boarding
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee off boarding
	 * @throws NoSuchEmployeeOffBoardingException if a employee off boarding with the primary key could not be found
	 */
	@Override
	public EmployeeOffBoarding[] findByUuid_PrevAndNext(
			long employeeOffBoardingId, String uuid,
			OrderByComparator<EmployeeOffBoarding> orderByComparator)
		throws NoSuchEmployeeOffBoardingException {

		uuid = Objects.toString(uuid, "");

		EmployeeOffBoarding employeeOffBoarding = findByPrimaryKey(
			employeeOffBoardingId);

		Session session = null;

		try {
			session = openSession();

			EmployeeOffBoarding[] array = new EmployeeOffBoardingImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, employeeOffBoarding, uuid, orderByComparator, true);

			array[1] = employeeOffBoarding;

			array[2] = getByUuid_PrevAndNext(
				session, employeeOffBoarding, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected EmployeeOffBoarding getByUuid_PrevAndNext(
		Session session, EmployeeOffBoarding employeeOffBoarding, String uuid,
		OrderByComparator<EmployeeOffBoarding> orderByComparator,
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

		sb.append(_SQL_SELECT_EMPLOYEEOFFBOARDING_WHERE);

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
			sb.append(EmployeeOffBoardingModelImpl.ORDER_BY_JPQL);
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
						employeeOffBoarding)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EmployeeOffBoarding> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employee off boardings where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (EmployeeOffBoarding employeeOffBoarding :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(employeeOffBoarding);
		}
	}

	/**
	 * Returns the number of employee off boardings where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching employee off boardings
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EMPLOYEEOFFBOARDING_WHERE);

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
		"employeeOffBoarding.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(employeeOffBoarding.uuid IS NULL OR employeeOffBoarding.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;

	/**
	 * Returns the employee off boarding where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchEmployeeOffBoardingException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching employee off boarding
	 * @throws NoSuchEmployeeOffBoardingException if a matching employee off boarding could not be found
	 */
	@Override
	public EmployeeOffBoarding findByUUID_G(String uuid, long groupId)
		throws NoSuchEmployeeOffBoardingException {

		EmployeeOffBoarding employeeOffBoarding = fetchByUUID_G(uuid, groupId);

		if (employeeOffBoarding == null) {
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

			throw new NoSuchEmployeeOffBoardingException(sb.toString());
		}

		return employeeOffBoarding;
	}

	/**
	 * Returns the employee off boarding where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching employee off boarding, or <code>null</code> if a matching employee off boarding could not be found
	 */
	@Override
	public EmployeeOffBoarding fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the employee off boarding where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching employee off boarding, or <code>null</code> if a matching employee off boarding could not be found
	 */
	@Override
	public EmployeeOffBoarding fetchByUUID_G(
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

		if (result instanceof EmployeeOffBoarding) {
			EmployeeOffBoarding employeeOffBoarding =
				(EmployeeOffBoarding)result;

			if (!Objects.equals(uuid, employeeOffBoarding.getUuid()) ||
				(groupId != employeeOffBoarding.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_EMPLOYEEOFFBOARDING_WHERE);

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

				List<EmployeeOffBoarding> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					EmployeeOffBoarding employeeOffBoarding = list.get(0);

					result = employeeOffBoarding;

					cacheResult(employeeOffBoarding);
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
			return (EmployeeOffBoarding)result;
		}
	}

	/**
	 * Removes the employee off boarding where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the employee off boarding that was removed
	 */
	@Override
	public EmployeeOffBoarding removeByUUID_G(String uuid, long groupId)
		throws NoSuchEmployeeOffBoardingException {

		EmployeeOffBoarding employeeOffBoarding = findByUUID_G(uuid, groupId);

		return remove(employeeOffBoarding);
	}

	/**
	 * Returns the number of employee off boardings where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching employee off boardings
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		EmployeeOffBoarding employeeOffBoarding = fetchByUUID_G(uuid, groupId);

		if (employeeOffBoarding == null) {
			return 0;
		}

		return 1;
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"employeeOffBoarding.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(employeeOffBoarding.uuid IS NULL OR employeeOffBoarding.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"employeeOffBoarding.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the employee off boardings where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching employee off boardings
	 */
	@Override
	public List<EmployeeOffBoarding> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee off boardings where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeOffBoardingModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee off boardings
	 * @param end the upper bound of the range of employee off boardings (not inclusive)
	 * @return the range of matching employee off boardings
	 */
	@Override
	public List<EmployeeOffBoarding> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee off boardings where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeOffBoardingModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee off boardings
	 * @param end the upper bound of the range of employee off boardings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee off boardings
	 */
	@Override
	public List<EmployeeOffBoarding> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EmployeeOffBoarding> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee off boardings where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeOffBoardingModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee off boardings
	 * @param end the upper bound of the range of employee off boardings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee off boardings
	 */
	@Override
	public List<EmployeeOffBoarding> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EmployeeOffBoarding> orderByComparator,
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

		List<EmployeeOffBoarding> list = null;

		if (useFinderCache) {
			list = (List<EmployeeOffBoarding>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EmployeeOffBoarding employeeOffBoarding : list) {
					if (!uuid.equals(employeeOffBoarding.getUuid()) ||
						(companyId != employeeOffBoarding.getCompanyId())) {

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

			sb.append(_SQL_SELECT_EMPLOYEEOFFBOARDING_WHERE);

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
				sb.append(EmployeeOffBoardingModelImpl.ORDER_BY_JPQL);
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

				list = (List<EmployeeOffBoarding>)QueryUtil.list(
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
	 * Returns the first employee off boarding in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee off boarding
	 * @throws NoSuchEmployeeOffBoardingException if a matching employee off boarding could not be found
	 */
	@Override
	public EmployeeOffBoarding findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<EmployeeOffBoarding> orderByComparator)
		throws NoSuchEmployeeOffBoardingException {

		EmployeeOffBoarding employeeOffBoarding = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (employeeOffBoarding != null) {
			return employeeOffBoarding;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchEmployeeOffBoardingException(sb.toString());
	}

	/**
	 * Returns the first employee off boarding in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee off boarding, or <code>null</code> if a matching employee off boarding could not be found
	 */
	@Override
	public EmployeeOffBoarding fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<EmployeeOffBoarding> orderByComparator) {

		List<EmployeeOffBoarding> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee off boarding in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee off boarding
	 * @throws NoSuchEmployeeOffBoardingException if a matching employee off boarding could not be found
	 */
	@Override
	public EmployeeOffBoarding findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<EmployeeOffBoarding> orderByComparator)
		throws NoSuchEmployeeOffBoardingException {

		EmployeeOffBoarding employeeOffBoarding = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (employeeOffBoarding != null) {
			return employeeOffBoarding;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchEmployeeOffBoardingException(sb.toString());
	}

	/**
	 * Returns the last employee off boarding in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee off boarding, or <code>null</code> if a matching employee off boarding could not be found
	 */
	@Override
	public EmployeeOffBoarding fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<EmployeeOffBoarding> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<EmployeeOffBoarding> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the employee off boardings before and after the current employee off boarding in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param employeeOffBoardingId the primary key of the current employee off boarding
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee off boarding
	 * @throws NoSuchEmployeeOffBoardingException if a employee off boarding with the primary key could not be found
	 */
	@Override
	public EmployeeOffBoarding[] findByUuid_C_PrevAndNext(
			long employeeOffBoardingId, String uuid, long companyId,
			OrderByComparator<EmployeeOffBoarding> orderByComparator)
		throws NoSuchEmployeeOffBoardingException {

		uuid = Objects.toString(uuid, "");

		EmployeeOffBoarding employeeOffBoarding = findByPrimaryKey(
			employeeOffBoardingId);

		Session session = null;

		try {
			session = openSession();

			EmployeeOffBoarding[] array = new EmployeeOffBoardingImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, employeeOffBoarding, uuid, companyId,
				orderByComparator, true);

			array[1] = employeeOffBoarding;

			array[2] = getByUuid_C_PrevAndNext(
				session, employeeOffBoarding, uuid, companyId,
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

	protected EmployeeOffBoarding getByUuid_C_PrevAndNext(
		Session session, EmployeeOffBoarding employeeOffBoarding, String uuid,
		long companyId,
		OrderByComparator<EmployeeOffBoarding> orderByComparator,
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

		sb.append(_SQL_SELECT_EMPLOYEEOFFBOARDING_WHERE);

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
			sb.append(EmployeeOffBoardingModelImpl.ORDER_BY_JPQL);
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
						employeeOffBoarding)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EmployeeOffBoarding> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employee off boardings where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (EmployeeOffBoarding employeeOffBoarding :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(employeeOffBoarding);
		}
	}

	/**
	 * Returns the number of employee off boardings where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching employee off boardings
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_EMPLOYEEOFFBOARDING_WHERE);

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
		"employeeOffBoarding.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(employeeOffBoarding.uuid IS NULL OR employeeOffBoarding.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"employeeOffBoarding.companyId = ?";

	private FinderPath _finderPathFetchByEmployeeId;

	/**
	 * Returns the employee off boarding where employeeId = &#63; or throws a <code>NoSuchEmployeeOffBoardingException</code> if it could not be found.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee off boarding
	 * @throws NoSuchEmployeeOffBoardingException if a matching employee off boarding could not be found
	 */
	@Override
	public EmployeeOffBoarding findByEmployeeId(long employeeId)
		throws NoSuchEmployeeOffBoardingException {

		EmployeeOffBoarding employeeOffBoarding = fetchByEmployeeId(employeeId);

		if (employeeOffBoarding == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("employeeId=");
			sb.append(employeeId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchEmployeeOffBoardingException(sb.toString());
		}

		return employeeOffBoarding;
	}

	/**
	 * Returns the employee off boarding where employeeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee off boarding, or <code>null</code> if a matching employee off boarding could not be found
	 */
	@Override
	public EmployeeOffBoarding fetchByEmployeeId(long employeeId) {
		return fetchByEmployeeId(employeeId, true);
	}

	/**
	 * Returns the employee off boarding where employeeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param employeeId the employee ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching employee off boarding, or <code>null</code> if a matching employee off boarding could not be found
	 */
	@Override
	public EmployeeOffBoarding fetchByEmployeeId(
		long employeeId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {employeeId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByEmployeeId, finderArgs, this);
		}

		if (result instanceof EmployeeOffBoarding) {
			EmployeeOffBoarding employeeOffBoarding =
				(EmployeeOffBoarding)result;

			if (employeeId != employeeOffBoarding.getEmployeeId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_EMPLOYEEOFFBOARDING_WHERE);

			sb.append(_FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(employeeId);

				List<EmployeeOffBoarding> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByEmployeeId, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {employeeId};
							}

							_log.warn(
								"EmployeeOffBoardingPersistenceImpl.fetchByEmployeeId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					EmployeeOffBoarding employeeOffBoarding = list.get(0);

					result = employeeOffBoarding;

					cacheResult(employeeOffBoarding);
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
			return (EmployeeOffBoarding)result;
		}
	}

	/**
	 * Removes the employee off boarding where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 * @return the employee off boarding that was removed
	 */
	@Override
	public EmployeeOffBoarding removeByEmployeeId(long employeeId)
		throws NoSuchEmployeeOffBoardingException {

		EmployeeOffBoarding employeeOffBoarding = findByEmployeeId(employeeId);

		return remove(employeeOffBoarding);
	}

	/**
	 * Returns the number of employee off boardings where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee off boardings
	 */
	@Override
	public int countByEmployeeId(long employeeId) {
		EmployeeOffBoarding employeeOffBoarding = fetchByEmployeeId(employeeId);

		if (employeeOffBoarding == null) {
			return 0;
		}

		return 1;
	}

	private static final String _FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2 =
		"employeeOffBoarding.employeeId = ?";

	public EmployeeOffBoardingPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(EmployeeOffBoarding.class);

		setModelImplClass(EmployeeOffBoardingImpl.class);
		setModelPKClass(long.class);

		setTable(EmployeeOffBoardingTable.INSTANCE);
	}

	/**
	 * Caches the employee off boarding in the entity cache if it is enabled.
	 *
	 * @param employeeOffBoarding the employee off boarding
	 */
	@Override
	public void cacheResult(EmployeeOffBoarding employeeOffBoarding) {
		entityCache.putResult(
			EmployeeOffBoardingImpl.class, employeeOffBoarding.getPrimaryKey(),
			employeeOffBoarding);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				employeeOffBoarding.getUuid(), employeeOffBoarding.getGroupId()
			},
			employeeOffBoarding);

		finderCache.putResult(
			_finderPathFetchByEmployeeId,
			new Object[] {employeeOffBoarding.getEmployeeId()},
			employeeOffBoarding);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the employee off boardings in the entity cache if it is enabled.
	 *
	 * @param employeeOffBoardings the employee off boardings
	 */
	@Override
	public void cacheResult(List<EmployeeOffBoarding> employeeOffBoardings) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (employeeOffBoardings.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (EmployeeOffBoarding employeeOffBoarding : employeeOffBoardings) {
			if (entityCache.getResult(
					EmployeeOffBoardingImpl.class,
					employeeOffBoarding.getPrimaryKey()) == null) {

				cacheResult(employeeOffBoarding);
			}
		}
	}

	/**
	 * Clears the cache for all employee off boardings.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(EmployeeOffBoardingImpl.class);

		finderCache.clearCache(EmployeeOffBoardingImpl.class);
	}

	/**
	 * Clears the cache for the employee off boarding.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EmployeeOffBoarding employeeOffBoarding) {
		entityCache.removeResult(
			EmployeeOffBoardingImpl.class, employeeOffBoarding);
	}

	@Override
	public void clearCache(List<EmployeeOffBoarding> employeeOffBoardings) {
		for (EmployeeOffBoarding employeeOffBoarding : employeeOffBoardings) {
			entityCache.removeResult(
				EmployeeOffBoardingImpl.class, employeeOffBoarding);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(EmployeeOffBoardingImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(EmployeeOffBoardingImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		EmployeeOffBoardingModelImpl employeeOffBoardingModelImpl) {

		Object[] args = new Object[] {
			employeeOffBoardingModelImpl.getUuid(),
			employeeOffBoardingModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathFetchByUUID_G, args, employeeOffBoardingModelImpl);

		args = new Object[] {employeeOffBoardingModelImpl.getEmployeeId()};

		finderCache.putResult(
			_finderPathFetchByEmployeeId, args, employeeOffBoardingModelImpl);
	}

	/**
	 * Creates a new employee off boarding with the primary key. Does not add the employee off boarding to the database.
	 *
	 * @param employeeOffBoardingId the primary key for the new employee off boarding
	 * @return the new employee off boarding
	 */
	@Override
	public EmployeeOffBoarding create(long employeeOffBoardingId) {
		EmployeeOffBoarding employeeOffBoarding = new EmployeeOffBoardingImpl();

		employeeOffBoarding.setNew(true);
		employeeOffBoarding.setPrimaryKey(employeeOffBoardingId);

		String uuid = PortalUUIDUtil.generate();

		employeeOffBoarding.setUuid(uuid);

		employeeOffBoarding.setCompanyId(CompanyThreadLocal.getCompanyId());

		return employeeOffBoarding;
	}

	/**
	 * Removes the employee off boarding with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeOffBoardingId the primary key of the employee off boarding
	 * @return the employee off boarding that was removed
	 * @throws NoSuchEmployeeOffBoardingException if a employee off boarding with the primary key could not be found
	 */
	@Override
	public EmployeeOffBoarding remove(long employeeOffBoardingId)
		throws NoSuchEmployeeOffBoardingException {

		return remove((Serializable)employeeOffBoardingId);
	}

	/**
	 * Removes the employee off boarding with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the employee off boarding
	 * @return the employee off boarding that was removed
	 * @throws NoSuchEmployeeOffBoardingException if a employee off boarding with the primary key could not be found
	 */
	@Override
	public EmployeeOffBoarding remove(Serializable primaryKey)
		throws NoSuchEmployeeOffBoardingException {

		Session session = null;

		try {
			session = openSession();

			EmployeeOffBoarding employeeOffBoarding =
				(EmployeeOffBoarding)session.get(
					EmployeeOffBoardingImpl.class, primaryKey);

			if (employeeOffBoarding == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEmployeeOffBoardingException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(employeeOffBoarding);
		}
		catch (NoSuchEmployeeOffBoardingException noSuchEntityException) {
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
	protected EmployeeOffBoarding removeImpl(
		EmployeeOffBoarding employeeOffBoarding) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(employeeOffBoarding)) {
				employeeOffBoarding = (EmployeeOffBoarding)session.get(
					EmployeeOffBoardingImpl.class,
					employeeOffBoarding.getPrimaryKeyObj());
			}

			if (employeeOffBoarding != null) {
				session.delete(employeeOffBoarding);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (employeeOffBoarding != null) {
			clearCache(employeeOffBoarding);
		}

		return employeeOffBoarding;
	}

	@Override
	public EmployeeOffBoarding updateImpl(
		EmployeeOffBoarding employeeOffBoarding) {

		boolean isNew = employeeOffBoarding.isNew();

		if (!(employeeOffBoarding instanceof EmployeeOffBoardingModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(employeeOffBoarding.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					employeeOffBoarding);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in employeeOffBoarding proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom EmployeeOffBoarding implementation " +
					employeeOffBoarding.getClass());
		}

		EmployeeOffBoardingModelImpl employeeOffBoardingModelImpl =
			(EmployeeOffBoardingModelImpl)employeeOffBoarding;

		if (Validator.isNull(employeeOffBoarding.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			employeeOffBoarding.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (employeeOffBoarding.getCreateDate() == null)) {
			if (serviceContext == null) {
				employeeOffBoarding.setCreateDate(date);
			}
			else {
				employeeOffBoarding.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!employeeOffBoardingModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				employeeOffBoarding.setModifiedDate(date);
			}
			else {
				employeeOffBoarding.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(employeeOffBoarding);
			}
			else {
				employeeOffBoarding = (EmployeeOffBoarding)session.merge(
					employeeOffBoarding);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			EmployeeOffBoardingImpl.class, employeeOffBoardingModelImpl, false,
			true);

		cacheUniqueFindersCache(employeeOffBoardingModelImpl);

		if (isNew) {
			employeeOffBoarding.setNew(false);
		}

		employeeOffBoarding.resetOriginalValues();

		return employeeOffBoarding;
	}

	/**
	 * Returns the employee off boarding with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the employee off boarding
	 * @return the employee off boarding
	 * @throws NoSuchEmployeeOffBoardingException if a employee off boarding with the primary key could not be found
	 */
	@Override
	public EmployeeOffBoarding findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEmployeeOffBoardingException {

		EmployeeOffBoarding employeeOffBoarding = fetchByPrimaryKey(primaryKey);

		if (employeeOffBoarding == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEmployeeOffBoardingException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return employeeOffBoarding;
	}

	/**
	 * Returns the employee off boarding with the primary key or throws a <code>NoSuchEmployeeOffBoardingException</code> if it could not be found.
	 *
	 * @param employeeOffBoardingId the primary key of the employee off boarding
	 * @return the employee off boarding
	 * @throws NoSuchEmployeeOffBoardingException if a employee off boarding with the primary key could not be found
	 */
	@Override
	public EmployeeOffBoarding findByPrimaryKey(long employeeOffBoardingId)
		throws NoSuchEmployeeOffBoardingException {

		return findByPrimaryKey((Serializable)employeeOffBoardingId);
	}

	/**
	 * Returns the employee off boarding with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeOffBoardingId the primary key of the employee off boarding
	 * @return the employee off boarding, or <code>null</code> if a employee off boarding with the primary key could not be found
	 */
	@Override
	public EmployeeOffBoarding fetchByPrimaryKey(long employeeOffBoardingId) {
		return fetchByPrimaryKey((Serializable)employeeOffBoardingId);
	}

	/**
	 * Returns all the employee off boardings.
	 *
	 * @return the employee off boardings
	 */
	@Override
	public List<EmployeeOffBoarding> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee off boardings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeOffBoardingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee off boardings
	 * @param end the upper bound of the range of employee off boardings (not inclusive)
	 * @return the range of employee off boardings
	 */
	@Override
	public List<EmployeeOffBoarding> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee off boardings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeOffBoardingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee off boardings
	 * @param end the upper bound of the range of employee off boardings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee off boardings
	 */
	@Override
	public List<EmployeeOffBoarding> findAll(
		int start, int end,
		OrderByComparator<EmployeeOffBoarding> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee off boardings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeOffBoardingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee off boardings
	 * @param end the upper bound of the range of employee off boardings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee off boardings
	 */
	@Override
	public List<EmployeeOffBoarding> findAll(
		int start, int end,
		OrderByComparator<EmployeeOffBoarding> orderByComparator,
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

		List<EmployeeOffBoarding> list = null;

		if (useFinderCache) {
			list = (List<EmployeeOffBoarding>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_EMPLOYEEOFFBOARDING);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_EMPLOYEEOFFBOARDING;

				sql = sql.concat(EmployeeOffBoardingModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<EmployeeOffBoarding>)QueryUtil.list(
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
	 * Removes all the employee off boardings from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (EmployeeOffBoarding employeeOffBoarding : findAll()) {
			remove(employeeOffBoarding);
		}
	}

	/**
	 * Returns the number of employee off boardings.
	 *
	 * @return the number of employee off boardings
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
					_SQL_COUNT_EMPLOYEEOFFBOARDING);

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
		return "employeeOffBoardingId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_EMPLOYEEOFFBOARDING;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return EmployeeOffBoardingModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the employee off boarding persistence.
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

		_finderPathFetchByEmployeeId = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByEmployeeId",
			new String[] {Long.class.getName()}, new String[] {"employeeId"},
			true);

		EmployeeOffBoardingUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		EmployeeOffBoardingUtil.setPersistence(null);

		entityCache.removeCache(EmployeeOffBoardingImpl.class.getName());
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

	private static final String _SQL_SELECT_EMPLOYEEOFFBOARDING =
		"SELECT employeeOffBoarding FROM EmployeeOffBoarding employeeOffBoarding";

	private static final String _SQL_SELECT_EMPLOYEEOFFBOARDING_WHERE =
		"SELECT employeeOffBoarding FROM EmployeeOffBoarding employeeOffBoarding WHERE ";

	private static final String _SQL_COUNT_EMPLOYEEOFFBOARDING =
		"SELECT COUNT(employeeOffBoarding) FROM EmployeeOffBoarding employeeOffBoarding";

	private static final String _SQL_COUNT_EMPLOYEEOFFBOARDING_WHERE =
		"SELECT COUNT(employeeOffBoarding) FROM EmployeeOffBoarding employeeOffBoarding WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "employeeOffBoarding.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No EmployeeOffBoarding exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No EmployeeOffBoarding exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		EmployeeOffBoardingPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}