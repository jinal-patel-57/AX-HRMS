/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence.impl;

import com.ax.hrms.exception.NoSuchUpcomingProbationEmployeeException;
import com.ax.hrms.model.UpcomingProbationEmployee;
import com.ax.hrms.model.UpcomingProbationEmployeeTable;
import com.ax.hrms.model.impl.UpcomingProbationEmployeeImpl;
import com.ax.hrms.model.impl.UpcomingProbationEmployeeModelImpl;
import com.ax.hrms.service.persistence.UpcomingProbationEmployeePersistence;
import com.ax.hrms.service.persistence.UpcomingProbationEmployeeUtil;
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
 * The persistence implementation for the upcoming probation employee service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = UpcomingProbationEmployeePersistence.class)
public class UpcomingProbationEmployeePersistenceImpl
	extends BasePersistenceImpl<UpcomingProbationEmployee>
	implements UpcomingProbationEmployeePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>UpcomingProbationEmployeeUtil</code> to access the upcoming probation employee persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		UpcomingProbationEmployeeImpl.class.getName();

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
	 * Returns all the upcoming probation employees where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching upcoming probation employees
	 */
	@Override
	public List<UpcomingProbationEmployee> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the upcoming probation employees where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UpcomingProbationEmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of upcoming probation employees
	 * @param end the upper bound of the range of upcoming probation employees (not inclusive)
	 * @return the range of matching upcoming probation employees
	 */
	@Override
	public List<UpcomingProbationEmployee> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the upcoming probation employees where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UpcomingProbationEmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of upcoming probation employees
	 * @param end the upper bound of the range of upcoming probation employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching upcoming probation employees
	 */
	@Override
	public List<UpcomingProbationEmployee> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<UpcomingProbationEmployee> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the upcoming probation employees where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UpcomingProbationEmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of upcoming probation employees
	 * @param end the upper bound of the range of upcoming probation employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching upcoming probation employees
	 */
	@Override
	public List<UpcomingProbationEmployee> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<UpcomingProbationEmployee> orderByComparator,
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

		List<UpcomingProbationEmployee> list = null;

		if (useFinderCache) {
			list = (List<UpcomingProbationEmployee>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (UpcomingProbationEmployee upcomingProbationEmployee :
						list) {

					if (!uuid.equals(upcomingProbationEmployee.getUuid())) {
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

			sb.append(_SQL_SELECT_UPCOMINGPROBATIONEMPLOYEE_WHERE);

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
				sb.append(UpcomingProbationEmployeeModelImpl.ORDER_BY_JPQL);
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

				list = (List<UpcomingProbationEmployee>)QueryUtil.list(
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
	 * Returns the first upcoming probation employee in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching upcoming probation employee
	 * @throws NoSuchUpcomingProbationEmployeeException if a matching upcoming probation employee could not be found
	 */
	@Override
	public UpcomingProbationEmployee findByUuid_First(
			String uuid,
			OrderByComparator<UpcomingProbationEmployee> orderByComparator)
		throws NoSuchUpcomingProbationEmployeeException {

		UpcomingProbationEmployee upcomingProbationEmployee = fetchByUuid_First(
			uuid, orderByComparator);

		if (upcomingProbationEmployee != null) {
			return upcomingProbationEmployee;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchUpcomingProbationEmployeeException(sb.toString());
	}

	/**
	 * Returns the first upcoming probation employee in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching upcoming probation employee, or <code>null</code> if a matching upcoming probation employee could not be found
	 */
	@Override
	public UpcomingProbationEmployee fetchByUuid_First(
		String uuid,
		OrderByComparator<UpcomingProbationEmployee> orderByComparator) {

		List<UpcomingProbationEmployee> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last upcoming probation employee in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching upcoming probation employee
	 * @throws NoSuchUpcomingProbationEmployeeException if a matching upcoming probation employee could not be found
	 */
	@Override
	public UpcomingProbationEmployee findByUuid_Last(
			String uuid,
			OrderByComparator<UpcomingProbationEmployee> orderByComparator)
		throws NoSuchUpcomingProbationEmployeeException {

		UpcomingProbationEmployee upcomingProbationEmployee = fetchByUuid_Last(
			uuid, orderByComparator);

		if (upcomingProbationEmployee != null) {
			return upcomingProbationEmployee;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchUpcomingProbationEmployeeException(sb.toString());
	}

	/**
	 * Returns the last upcoming probation employee in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching upcoming probation employee, or <code>null</code> if a matching upcoming probation employee could not be found
	 */
	@Override
	public UpcomingProbationEmployee fetchByUuid_Last(
		String uuid,
		OrderByComparator<UpcomingProbationEmployee> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<UpcomingProbationEmployee> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the upcoming probation employees before and after the current upcoming probation employee in the ordered set where uuid = &#63;.
	 *
	 * @param upcomingProbationEmployeeId the primary key of the current upcoming probation employee
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next upcoming probation employee
	 * @throws NoSuchUpcomingProbationEmployeeException if a upcoming probation employee with the primary key could not be found
	 */
	@Override
	public UpcomingProbationEmployee[] findByUuid_PrevAndNext(
			long upcomingProbationEmployeeId, String uuid,
			OrderByComparator<UpcomingProbationEmployee> orderByComparator)
		throws NoSuchUpcomingProbationEmployeeException {

		uuid = Objects.toString(uuid, "");

		UpcomingProbationEmployee upcomingProbationEmployee = findByPrimaryKey(
			upcomingProbationEmployeeId);

		Session session = null;

		try {
			session = openSession();

			UpcomingProbationEmployee[] array =
				new UpcomingProbationEmployeeImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, upcomingProbationEmployee, uuid, orderByComparator,
				true);

			array[1] = upcomingProbationEmployee;

			array[2] = getByUuid_PrevAndNext(
				session, upcomingProbationEmployee, uuid, orderByComparator,
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

	protected UpcomingProbationEmployee getByUuid_PrevAndNext(
		Session session, UpcomingProbationEmployee upcomingProbationEmployee,
		String uuid,
		OrderByComparator<UpcomingProbationEmployee> orderByComparator,
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

		sb.append(_SQL_SELECT_UPCOMINGPROBATIONEMPLOYEE_WHERE);

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
			sb.append(UpcomingProbationEmployeeModelImpl.ORDER_BY_JPQL);
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
						upcomingProbationEmployee)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<UpcomingProbationEmployee> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the upcoming probation employees where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (UpcomingProbationEmployee upcomingProbationEmployee :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(upcomingProbationEmployee);
		}
	}

	/**
	 * Returns the number of upcoming probation employees where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching upcoming probation employees
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_UPCOMINGPROBATIONEMPLOYEE_WHERE);

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
		"upcomingProbationEmployee.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(upcomingProbationEmployee.uuid IS NULL OR upcomingProbationEmployee.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the upcoming probation employee where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchUpcomingProbationEmployeeException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching upcoming probation employee
	 * @throws NoSuchUpcomingProbationEmployeeException if a matching upcoming probation employee could not be found
	 */
	@Override
	public UpcomingProbationEmployee findByUUID_G(String uuid, long groupId)
		throws NoSuchUpcomingProbationEmployeeException {

		UpcomingProbationEmployee upcomingProbationEmployee = fetchByUUID_G(
			uuid, groupId);

		if (upcomingProbationEmployee == null) {
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

			throw new NoSuchUpcomingProbationEmployeeException(sb.toString());
		}

		return upcomingProbationEmployee;
	}

	/**
	 * Returns the upcoming probation employee where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching upcoming probation employee, or <code>null</code> if a matching upcoming probation employee could not be found
	 */
	@Override
	public UpcomingProbationEmployee fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the upcoming probation employee where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching upcoming probation employee, or <code>null</code> if a matching upcoming probation employee could not be found
	 */
	@Override
	public UpcomingProbationEmployee fetchByUUID_G(
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

		if (result instanceof UpcomingProbationEmployee) {
			UpcomingProbationEmployee upcomingProbationEmployee =
				(UpcomingProbationEmployee)result;

			if (!Objects.equals(uuid, upcomingProbationEmployee.getUuid()) ||
				(groupId != upcomingProbationEmployee.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_UPCOMINGPROBATIONEMPLOYEE_WHERE);

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

				List<UpcomingProbationEmployee> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					UpcomingProbationEmployee upcomingProbationEmployee =
						list.get(0);

					result = upcomingProbationEmployee;

					cacheResult(upcomingProbationEmployee);
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
			return (UpcomingProbationEmployee)result;
		}
	}

	/**
	 * Removes the upcoming probation employee where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the upcoming probation employee that was removed
	 */
	@Override
	public UpcomingProbationEmployee removeByUUID_G(String uuid, long groupId)
		throws NoSuchUpcomingProbationEmployeeException {

		UpcomingProbationEmployee upcomingProbationEmployee = findByUUID_G(
			uuid, groupId);

		return remove(upcomingProbationEmployee);
	}

	/**
	 * Returns the number of upcoming probation employees where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching upcoming probation employees
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_UPCOMINGPROBATIONEMPLOYEE_WHERE);

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
		"upcomingProbationEmployee.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(upcomingProbationEmployee.uuid IS NULL OR upcomingProbationEmployee.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"upcomingProbationEmployee.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the upcoming probation employees where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching upcoming probation employees
	 */
	@Override
	public List<UpcomingProbationEmployee> findByUuid_C(
		String uuid, long companyId) {

		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the upcoming probation employees where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UpcomingProbationEmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of upcoming probation employees
	 * @param end the upper bound of the range of upcoming probation employees (not inclusive)
	 * @return the range of matching upcoming probation employees
	 */
	@Override
	public List<UpcomingProbationEmployee> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the upcoming probation employees where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UpcomingProbationEmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of upcoming probation employees
	 * @param end the upper bound of the range of upcoming probation employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching upcoming probation employees
	 */
	@Override
	public List<UpcomingProbationEmployee> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<UpcomingProbationEmployee> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the upcoming probation employees where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UpcomingProbationEmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of upcoming probation employees
	 * @param end the upper bound of the range of upcoming probation employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching upcoming probation employees
	 */
	@Override
	public List<UpcomingProbationEmployee> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<UpcomingProbationEmployee> orderByComparator,
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

		List<UpcomingProbationEmployee> list = null;

		if (useFinderCache) {
			list = (List<UpcomingProbationEmployee>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (UpcomingProbationEmployee upcomingProbationEmployee :
						list) {

					if (!uuid.equals(upcomingProbationEmployee.getUuid()) ||
						(companyId !=
							upcomingProbationEmployee.getCompanyId())) {

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

			sb.append(_SQL_SELECT_UPCOMINGPROBATIONEMPLOYEE_WHERE);

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
				sb.append(UpcomingProbationEmployeeModelImpl.ORDER_BY_JPQL);
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

				list = (List<UpcomingProbationEmployee>)QueryUtil.list(
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
	 * Returns the first upcoming probation employee in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching upcoming probation employee
	 * @throws NoSuchUpcomingProbationEmployeeException if a matching upcoming probation employee could not be found
	 */
	@Override
	public UpcomingProbationEmployee findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<UpcomingProbationEmployee> orderByComparator)
		throws NoSuchUpcomingProbationEmployeeException {

		UpcomingProbationEmployee upcomingProbationEmployee =
			fetchByUuid_C_First(uuid, companyId, orderByComparator);

		if (upcomingProbationEmployee != null) {
			return upcomingProbationEmployee;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchUpcomingProbationEmployeeException(sb.toString());
	}

	/**
	 * Returns the first upcoming probation employee in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching upcoming probation employee, or <code>null</code> if a matching upcoming probation employee could not be found
	 */
	@Override
	public UpcomingProbationEmployee fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<UpcomingProbationEmployee> orderByComparator) {

		List<UpcomingProbationEmployee> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last upcoming probation employee in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching upcoming probation employee
	 * @throws NoSuchUpcomingProbationEmployeeException if a matching upcoming probation employee could not be found
	 */
	@Override
	public UpcomingProbationEmployee findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<UpcomingProbationEmployee> orderByComparator)
		throws NoSuchUpcomingProbationEmployeeException {

		UpcomingProbationEmployee upcomingProbationEmployee =
			fetchByUuid_C_Last(uuid, companyId, orderByComparator);

		if (upcomingProbationEmployee != null) {
			return upcomingProbationEmployee;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchUpcomingProbationEmployeeException(sb.toString());
	}

	/**
	 * Returns the last upcoming probation employee in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching upcoming probation employee, or <code>null</code> if a matching upcoming probation employee could not be found
	 */
	@Override
	public UpcomingProbationEmployee fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<UpcomingProbationEmployee> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<UpcomingProbationEmployee> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the upcoming probation employees before and after the current upcoming probation employee in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param upcomingProbationEmployeeId the primary key of the current upcoming probation employee
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next upcoming probation employee
	 * @throws NoSuchUpcomingProbationEmployeeException if a upcoming probation employee with the primary key could not be found
	 */
	@Override
	public UpcomingProbationEmployee[] findByUuid_C_PrevAndNext(
			long upcomingProbationEmployeeId, String uuid, long companyId,
			OrderByComparator<UpcomingProbationEmployee> orderByComparator)
		throws NoSuchUpcomingProbationEmployeeException {

		uuid = Objects.toString(uuid, "");

		UpcomingProbationEmployee upcomingProbationEmployee = findByPrimaryKey(
			upcomingProbationEmployeeId);

		Session session = null;

		try {
			session = openSession();

			UpcomingProbationEmployee[] array =
				new UpcomingProbationEmployeeImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, upcomingProbationEmployee, uuid, companyId,
				orderByComparator, true);

			array[1] = upcomingProbationEmployee;

			array[2] = getByUuid_C_PrevAndNext(
				session, upcomingProbationEmployee, uuid, companyId,
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

	protected UpcomingProbationEmployee getByUuid_C_PrevAndNext(
		Session session, UpcomingProbationEmployee upcomingProbationEmployee,
		String uuid, long companyId,
		OrderByComparator<UpcomingProbationEmployee> orderByComparator,
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

		sb.append(_SQL_SELECT_UPCOMINGPROBATIONEMPLOYEE_WHERE);

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
			sb.append(UpcomingProbationEmployeeModelImpl.ORDER_BY_JPQL);
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
						upcomingProbationEmployee)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<UpcomingProbationEmployee> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the upcoming probation employees where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (UpcomingProbationEmployee upcomingProbationEmployee :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(upcomingProbationEmployee);
		}
	}

	/**
	 * Returns the number of upcoming probation employees where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching upcoming probation employees
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_UPCOMINGPROBATIONEMPLOYEE_WHERE);

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
		"upcomingProbationEmployee.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(upcomingProbationEmployee.uuid IS NULL OR upcomingProbationEmployee.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"upcomingProbationEmployee.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByMonthAndYear;
	private FinderPath _finderPathWithoutPaginationFindByMonthAndYear;
	private FinderPath _finderPathCountByMonthAndYear;

	/**
	 * Returns all the upcoming probation employees where month = &#63; and year = &#63;.
	 *
	 * @param month the month
	 * @param year the year
	 * @return the matching upcoming probation employees
	 */
	@Override
	public List<UpcomingProbationEmployee> findByMonthAndYear(
		int month, int year) {

		return findByMonthAndYear(
			month, year, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the upcoming probation employees where month = &#63; and year = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UpcomingProbationEmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param month the month
	 * @param year the year
	 * @param start the lower bound of the range of upcoming probation employees
	 * @param end the upper bound of the range of upcoming probation employees (not inclusive)
	 * @return the range of matching upcoming probation employees
	 */
	@Override
	public List<UpcomingProbationEmployee> findByMonthAndYear(
		int month, int year, int start, int end) {

		return findByMonthAndYear(month, year, start, end, null);
	}

	/**
	 * Returns an ordered range of all the upcoming probation employees where month = &#63; and year = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UpcomingProbationEmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param month the month
	 * @param year the year
	 * @param start the lower bound of the range of upcoming probation employees
	 * @param end the upper bound of the range of upcoming probation employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching upcoming probation employees
	 */
	@Override
	public List<UpcomingProbationEmployee> findByMonthAndYear(
		int month, int year, int start, int end,
		OrderByComparator<UpcomingProbationEmployee> orderByComparator) {

		return findByMonthAndYear(
			month, year, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the upcoming probation employees where month = &#63; and year = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UpcomingProbationEmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param month the month
	 * @param year the year
	 * @param start the lower bound of the range of upcoming probation employees
	 * @param end the upper bound of the range of upcoming probation employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching upcoming probation employees
	 */
	@Override
	public List<UpcomingProbationEmployee> findByMonthAndYear(
		int month, int year, int start, int end,
		OrderByComparator<UpcomingProbationEmployee> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByMonthAndYear;
				finderArgs = new Object[] {month, year};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByMonthAndYear;
			finderArgs = new Object[] {
				month, year, start, end, orderByComparator
			};
		}

		List<UpcomingProbationEmployee> list = null;

		if (useFinderCache) {
			list = (List<UpcomingProbationEmployee>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (UpcomingProbationEmployee upcomingProbationEmployee :
						list) {

					if ((month != upcomingProbationEmployee.getMonth()) ||
						(year != upcomingProbationEmployee.getYear())) {

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

			sb.append(_SQL_SELECT_UPCOMINGPROBATIONEMPLOYEE_WHERE);

			sb.append(_FINDER_COLUMN_MONTHANDYEAR_MONTH_2);

			sb.append(_FINDER_COLUMN_MONTHANDYEAR_YEAR_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(UpcomingProbationEmployeeModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(month);

				queryPos.add(year);

				list = (List<UpcomingProbationEmployee>)QueryUtil.list(
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
	 * Returns the first upcoming probation employee in the ordered set where month = &#63; and year = &#63;.
	 *
	 * @param month the month
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching upcoming probation employee
	 * @throws NoSuchUpcomingProbationEmployeeException if a matching upcoming probation employee could not be found
	 */
	@Override
	public UpcomingProbationEmployee findByMonthAndYear_First(
			int month, int year,
			OrderByComparator<UpcomingProbationEmployee> orderByComparator)
		throws NoSuchUpcomingProbationEmployeeException {

		UpcomingProbationEmployee upcomingProbationEmployee =
			fetchByMonthAndYear_First(month, year, orderByComparator);

		if (upcomingProbationEmployee != null) {
			return upcomingProbationEmployee;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("month=");
		sb.append(month);

		sb.append(", year=");
		sb.append(year);

		sb.append("}");

		throw new NoSuchUpcomingProbationEmployeeException(sb.toString());
	}

	/**
	 * Returns the first upcoming probation employee in the ordered set where month = &#63; and year = &#63;.
	 *
	 * @param month the month
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching upcoming probation employee, or <code>null</code> if a matching upcoming probation employee could not be found
	 */
	@Override
	public UpcomingProbationEmployee fetchByMonthAndYear_First(
		int month, int year,
		OrderByComparator<UpcomingProbationEmployee> orderByComparator) {

		List<UpcomingProbationEmployee> list = findByMonthAndYear(
			month, year, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last upcoming probation employee in the ordered set where month = &#63; and year = &#63;.
	 *
	 * @param month the month
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching upcoming probation employee
	 * @throws NoSuchUpcomingProbationEmployeeException if a matching upcoming probation employee could not be found
	 */
	@Override
	public UpcomingProbationEmployee findByMonthAndYear_Last(
			int month, int year,
			OrderByComparator<UpcomingProbationEmployee> orderByComparator)
		throws NoSuchUpcomingProbationEmployeeException {

		UpcomingProbationEmployee upcomingProbationEmployee =
			fetchByMonthAndYear_Last(month, year, orderByComparator);

		if (upcomingProbationEmployee != null) {
			return upcomingProbationEmployee;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("month=");
		sb.append(month);

		sb.append(", year=");
		sb.append(year);

		sb.append("}");

		throw new NoSuchUpcomingProbationEmployeeException(sb.toString());
	}

	/**
	 * Returns the last upcoming probation employee in the ordered set where month = &#63; and year = &#63;.
	 *
	 * @param month the month
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching upcoming probation employee, or <code>null</code> if a matching upcoming probation employee could not be found
	 */
	@Override
	public UpcomingProbationEmployee fetchByMonthAndYear_Last(
		int month, int year,
		OrderByComparator<UpcomingProbationEmployee> orderByComparator) {

		int count = countByMonthAndYear(month, year);

		if (count == 0) {
			return null;
		}

		List<UpcomingProbationEmployee> list = findByMonthAndYear(
			month, year, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the upcoming probation employees before and after the current upcoming probation employee in the ordered set where month = &#63; and year = &#63;.
	 *
	 * @param upcomingProbationEmployeeId the primary key of the current upcoming probation employee
	 * @param month the month
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next upcoming probation employee
	 * @throws NoSuchUpcomingProbationEmployeeException if a upcoming probation employee with the primary key could not be found
	 */
	@Override
	public UpcomingProbationEmployee[] findByMonthAndYear_PrevAndNext(
			long upcomingProbationEmployeeId, int month, int year,
			OrderByComparator<UpcomingProbationEmployee> orderByComparator)
		throws NoSuchUpcomingProbationEmployeeException {

		UpcomingProbationEmployee upcomingProbationEmployee = findByPrimaryKey(
			upcomingProbationEmployeeId);

		Session session = null;

		try {
			session = openSession();

			UpcomingProbationEmployee[] array =
				new UpcomingProbationEmployeeImpl[3];

			array[0] = getByMonthAndYear_PrevAndNext(
				session, upcomingProbationEmployee, month, year,
				orderByComparator, true);

			array[1] = upcomingProbationEmployee;

			array[2] = getByMonthAndYear_PrevAndNext(
				session, upcomingProbationEmployee, month, year,
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

	protected UpcomingProbationEmployee getByMonthAndYear_PrevAndNext(
		Session session, UpcomingProbationEmployee upcomingProbationEmployee,
		int month, int year,
		OrderByComparator<UpcomingProbationEmployee> orderByComparator,
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

		sb.append(_SQL_SELECT_UPCOMINGPROBATIONEMPLOYEE_WHERE);

		sb.append(_FINDER_COLUMN_MONTHANDYEAR_MONTH_2);

		sb.append(_FINDER_COLUMN_MONTHANDYEAR_YEAR_2);

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
			sb.append(UpcomingProbationEmployeeModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(month);

		queryPos.add(year);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						upcomingProbationEmployee)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<UpcomingProbationEmployee> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the upcoming probation employees where month = &#63; and year = &#63; from the database.
	 *
	 * @param month the month
	 * @param year the year
	 */
	@Override
	public void removeByMonthAndYear(int month, int year) {
		for (UpcomingProbationEmployee upcomingProbationEmployee :
				findByMonthAndYear(
					month, year, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(upcomingProbationEmployee);
		}
	}

	/**
	 * Returns the number of upcoming probation employees where month = &#63; and year = &#63;.
	 *
	 * @param month the month
	 * @param year the year
	 * @return the number of matching upcoming probation employees
	 */
	@Override
	public int countByMonthAndYear(int month, int year) {
		FinderPath finderPath = _finderPathCountByMonthAndYear;

		Object[] finderArgs = new Object[] {month, year};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_UPCOMINGPROBATIONEMPLOYEE_WHERE);

			sb.append(_FINDER_COLUMN_MONTHANDYEAR_MONTH_2);

			sb.append(_FINDER_COLUMN_MONTHANDYEAR_YEAR_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(month);

				queryPos.add(year);

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

	private static final String _FINDER_COLUMN_MONTHANDYEAR_MONTH_2 =
		"upcomingProbationEmployee.month = ? AND ";

	private static final String _FINDER_COLUMN_MONTHANDYEAR_YEAR_2 =
		"upcomingProbationEmployee.year = ?";

	public UpcomingProbationEmployeePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(UpcomingProbationEmployee.class);

		setModelImplClass(UpcomingProbationEmployeeImpl.class);
		setModelPKClass(long.class);

		setTable(UpcomingProbationEmployeeTable.INSTANCE);
	}

	/**
	 * Caches the upcoming probation employee in the entity cache if it is enabled.
	 *
	 * @param upcomingProbationEmployee the upcoming probation employee
	 */
	@Override
	public void cacheResult(
		UpcomingProbationEmployee upcomingProbationEmployee) {

		entityCache.putResult(
			UpcomingProbationEmployeeImpl.class,
			upcomingProbationEmployee.getPrimaryKey(),
			upcomingProbationEmployee);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				upcomingProbationEmployee.getUuid(),
				upcomingProbationEmployee.getGroupId()
			},
			upcomingProbationEmployee);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the upcoming probation employees in the entity cache if it is enabled.
	 *
	 * @param upcomingProbationEmployees the upcoming probation employees
	 */
	@Override
	public void cacheResult(
		List<UpcomingProbationEmployee> upcomingProbationEmployees) {

		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (upcomingProbationEmployees.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (UpcomingProbationEmployee upcomingProbationEmployee :
				upcomingProbationEmployees) {

			if (entityCache.getResult(
					UpcomingProbationEmployeeImpl.class,
					upcomingProbationEmployee.getPrimaryKey()) == null) {

				cacheResult(upcomingProbationEmployee);
			}
		}
	}

	/**
	 * Clears the cache for all upcoming probation employees.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(UpcomingProbationEmployeeImpl.class);

		finderCache.clearCache(UpcomingProbationEmployeeImpl.class);
	}

	/**
	 * Clears the cache for the upcoming probation employee.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		UpcomingProbationEmployee upcomingProbationEmployee) {

		entityCache.removeResult(
			UpcomingProbationEmployeeImpl.class, upcomingProbationEmployee);
	}

	@Override
	public void clearCache(
		List<UpcomingProbationEmployee> upcomingProbationEmployees) {

		for (UpcomingProbationEmployee upcomingProbationEmployee :
				upcomingProbationEmployees) {

			entityCache.removeResult(
				UpcomingProbationEmployeeImpl.class, upcomingProbationEmployee);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(UpcomingProbationEmployeeImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				UpcomingProbationEmployeeImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		UpcomingProbationEmployeeModelImpl upcomingProbationEmployeeModelImpl) {

		Object[] args = new Object[] {
			upcomingProbationEmployeeModelImpl.getUuid(),
			upcomingProbationEmployeeModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, upcomingProbationEmployeeModelImpl);
	}

	/**
	 * Creates a new upcoming probation employee with the primary key. Does not add the upcoming probation employee to the database.
	 *
	 * @param upcomingProbationEmployeeId the primary key for the new upcoming probation employee
	 * @return the new upcoming probation employee
	 */
	@Override
	public UpcomingProbationEmployee create(long upcomingProbationEmployeeId) {
		UpcomingProbationEmployee upcomingProbationEmployee =
			new UpcomingProbationEmployeeImpl();

		upcomingProbationEmployee.setNew(true);
		upcomingProbationEmployee.setPrimaryKey(upcomingProbationEmployeeId);

		String uuid = PortalUUIDUtil.generate();

		upcomingProbationEmployee.setUuid(uuid);

		upcomingProbationEmployee.setCompanyId(
			CompanyThreadLocal.getCompanyId());

		return upcomingProbationEmployee;
	}

	/**
	 * Removes the upcoming probation employee with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param upcomingProbationEmployeeId the primary key of the upcoming probation employee
	 * @return the upcoming probation employee that was removed
	 * @throws NoSuchUpcomingProbationEmployeeException if a upcoming probation employee with the primary key could not be found
	 */
	@Override
	public UpcomingProbationEmployee remove(long upcomingProbationEmployeeId)
		throws NoSuchUpcomingProbationEmployeeException {

		return remove((Serializable)upcomingProbationEmployeeId);
	}

	/**
	 * Removes the upcoming probation employee with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the upcoming probation employee
	 * @return the upcoming probation employee that was removed
	 * @throws NoSuchUpcomingProbationEmployeeException if a upcoming probation employee with the primary key could not be found
	 */
	@Override
	public UpcomingProbationEmployee remove(Serializable primaryKey)
		throws NoSuchUpcomingProbationEmployeeException {

		Session session = null;

		try {
			session = openSession();

			UpcomingProbationEmployee upcomingProbationEmployee =
				(UpcomingProbationEmployee)session.get(
					UpcomingProbationEmployeeImpl.class, primaryKey);

			if (upcomingProbationEmployee == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUpcomingProbationEmployeeException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(upcomingProbationEmployee);
		}
		catch (NoSuchUpcomingProbationEmployeeException noSuchEntityException) {
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
	protected UpcomingProbationEmployee removeImpl(
		UpcomingProbationEmployee upcomingProbationEmployee) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(upcomingProbationEmployee)) {
				upcomingProbationEmployee =
					(UpcomingProbationEmployee)session.get(
						UpcomingProbationEmployeeImpl.class,
						upcomingProbationEmployee.getPrimaryKeyObj());
			}

			if (upcomingProbationEmployee != null) {
				session.delete(upcomingProbationEmployee);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (upcomingProbationEmployee != null) {
			clearCache(upcomingProbationEmployee);
		}

		return upcomingProbationEmployee;
	}

	@Override
	public UpcomingProbationEmployee updateImpl(
		UpcomingProbationEmployee upcomingProbationEmployee) {

		boolean isNew = upcomingProbationEmployee.isNew();

		if (!(upcomingProbationEmployee instanceof
				UpcomingProbationEmployeeModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(upcomingProbationEmployee.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					upcomingProbationEmployee);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in upcomingProbationEmployee proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom UpcomingProbationEmployee implementation " +
					upcomingProbationEmployee.getClass());
		}

		UpcomingProbationEmployeeModelImpl upcomingProbationEmployeeModelImpl =
			(UpcomingProbationEmployeeModelImpl)upcomingProbationEmployee;

		if (Validator.isNull(upcomingProbationEmployee.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			upcomingProbationEmployee.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (upcomingProbationEmployee.getCreateDate() == null)) {
			if (serviceContext == null) {
				upcomingProbationEmployee.setCreateDate(date);
			}
			else {
				upcomingProbationEmployee.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!upcomingProbationEmployeeModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				upcomingProbationEmployee.setModifiedDate(date);
			}
			else {
				upcomingProbationEmployee.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(upcomingProbationEmployee);
			}
			else {
				upcomingProbationEmployee =
					(UpcomingProbationEmployee)session.merge(
						upcomingProbationEmployee);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			UpcomingProbationEmployeeImpl.class,
			upcomingProbationEmployeeModelImpl, false, true);

		cacheUniqueFindersCache(upcomingProbationEmployeeModelImpl);

		if (isNew) {
			upcomingProbationEmployee.setNew(false);
		}

		upcomingProbationEmployee.resetOriginalValues();

		return upcomingProbationEmployee;
	}

	/**
	 * Returns the upcoming probation employee with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the upcoming probation employee
	 * @return the upcoming probation employee
	 * @throws NoSuchUpcomingProbationEmployeeException if a upcoming probation employee with the primary key could not be found
	 */
	@Override
	public UpcomingProbationEmployee findByPrimaryKey(Serializable primaryKey)
		throws NoSuchUpcomingProbationEmployeeException {

		UpcomingProbationEmployee upcomingProbationEmployee = fetchByPrimaryKey(
			primaryKey);

		if (upcomingProbationEmployee == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchUpcomingProbationEmployeeException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return upcomingProbationEmployee;
	}

	/**
	 * Returns the upcoming probation employee with the primary key or throws a <code>NoSuchUpcomingProbationEmployeeException</code> if it could not be found.
	 *
	 * @param upcomingProbationEmployeeId the primary key of the upcoming probation employee
	 * @return the upcoming probation employee
	 * @throws NoSuchUpcomingProbationEmployeeException if a upcoming probation employee with the primary key could not be found
	 */
	@Override
	public UpcomingProbationEmployee findByPrimaryKey(
			long upcomingProbationEmployeeId)
		throws NoSuchUpcomingProbationEmployeeException {

		return findByPrimaryKey((Serializable)upcomingProbationEmployeeId);
	}

	/**
	 * Returns the upcoming probation employee with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param upcomingProbationEmployeeId the primary key of the upcoming probation employee
	 * @return the upcoming probation employee, or <code>null</code> if a upcoming probation employee with the primary key could not be found
	 */
	@Override
	public UpcomingProbationEmployee fetchByPrimaryKey(
		long upcomingProbationEmployeeId) {

		return fetchByPrimaryKey((Serializable)upcomingProbationEmployeeId);
	}

	/**
	 * Returns all the upcoming probation employees.
	 *
	 * @return the upcoming probation employees
	 */
	@Override
	public List<UpcomingProbationEmployee> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the upcoming probation employees.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UpcomingProbationEmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of upcoming probation employees
	 * @param end the upper bound of the range of upcoming probation employees (not inclusive)
	 * @return the range of upcoming probation employees
	 */
	@Override
	public List<UpcomingProbationEmployee> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the upcoming probation employees.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UpcomingProbationEmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of upcoming probation employees
	 * @param end the upper bound of the range of upcoming probation employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of upcoming probation employees
	 */
	@Override
	public List<UpcomingProbationEmployee> findAll(
		int start, int end,
		OrderByComparator<UpcomingProbationEmployee> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the upcoming probation employees.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UpcomingProbationEmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of upcoming probation employees
	 * @param end the upper bound of the range of upcoming probation employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of upcoming probation employees
	 */
	@Override
	public List<UpcomingProbationEmployee> findAll(
		int start, int end,
		OrderByComparator<UpcomingProbationEmployee> orderByComparator,
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

		List<UpcomingProbationEmployee> list = null;

		if (useFinderCache) {
			list = (List<UpcomingProbationEmployee>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_UPCOMINGPROBATIONEMPLOYEE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_UPCOMINGPROBATIONEMPLOYEE;

				sql = sql.concat(
					UpcomingProbationEmployeeModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<UpcomingProbationEmployee>)QueryUtil.list(
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
	 * Removes all the upcoming probation employees from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (UpcomingProbationEmployee upcomingProbationEmployee : findAll()) {
			remove(upcomingProbationEmployee);
		}
	}

	/**
	 * Returns the number of upcoming probation employees.
	 *
	 * @return the number of upcoming probation employees
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
					_SQL_COUNT_UPCOMINGPROBATIONEMPLOYEE);

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
		return "upcomingProbationEmployeeId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_UPCOMINGPROBATIONEMPLOYEE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return UpcomingProbationEmployeeModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the upcoming probation employee persistence.
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

		_finderPathWithPaginationFindByMonthAndYear = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByMonthAndYear",
			new String[] {
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"month", "year"}, true);

		_finderPathWithoutPaginationFindByMonthAndYear = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByMonthAndYear",
			new String[] {Integer.class.getName(), Integer.class.getName()},
			new String[] {"month", "year"}, true);

		_finderPathCountByMonthAndYear = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByMonthAndYear",
			new String[] {Integer.class.getName(), Integer.class.getName()},
			new String[] {"month", "year"}, false);

		UpcomingProbationEmployeeUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		UpcomingProbationEmployeeUtil.setPersistence(null);

		entityCache.removeCache(UpcomingProbationEmployeeImpl.class.getName());
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

	private static final String _SQL_SELECT_UPCOMINGPROBATIONEMPLOYEE =
		"SELECT upcomingProbationEmployee FROM UpcomingProbationEmployee upcomingProbationEmployee";

	private static final String _SQL_SELECT_UPCOMINGPROBATIONEMPLOYEE_WHERE =
		"SELECT upcomingProbationEmployee FROM UpcomingProbationEmployee upcomingProbationEmployee WHERE ";

	private static final String _SQL_COUNT_UPCOMINGPROBATIONEMPLOYEE =
		"SELECT COUNT(upcomingProbationEmployee) FROM UpcomingProbationEmployee upcomingProbationEmployee";

	private static final String _SQL_COUNT_UPCOMINGPROBATIONEMPLOYEE_WHERE =
		"SELECT COUNT(upcomingProbationEmployee) FROM UpcomingProbationEmployee upcomingProbationEmployee WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"upcomingProbationEmployee.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No UpcomingProbationEmployee exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No UpcomingProbationEmployee exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		UpcomingProbationEmployeePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}