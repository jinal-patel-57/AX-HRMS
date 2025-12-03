/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence.impl;

import com.ax.hrms.exception.NoSuchEmployeeSalaryException;
import com.ax.hrms.model.EmployeeSalary;
import com.ax.hrms.model.EmployeeSalaryTable;
import com.ax.hrms.model.impl.EmployeeSalaryImpl;
import com.ax.hrms.model.impl.EmployeeSalaryModelImpl;
import com.ax.hrms.service.persistence.EmployeeSalaryPersistence;
import com.ax.hrms.service.persistence.EmployeeSalaryUtil;
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
 * The persistence implementation for the employee salary service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = EmployeeSalaryPersistence.class)
public class EmployeeSalaryPersistenceImpl
	extends BasePersistenceImpl<EmployeeSalary>
	implements EmployeeSalaryPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>EmployeeSalaryUtil</code> to access the employee salary persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		EmployeeSalaryImpl.class.getName();

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
	 * Returns all the employee salaries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching employee salaries
	 */
	@Override
	public List<EmployeeSalary> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee salaries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeSalaryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee salaries
	 * @param end the upper bound of the range of employee salaries (not inclusive)
	 * @return the range of matching employee salaries
	 */
	@Override
	public List<EmployeeSalary> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee salaries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeSalaryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee salaries
	 * @param end the upper bound of the range of employee salaries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee salaries
	 */
	@Override
	public List<EmployeeSalary> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EmployeeSalary> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee salaries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeSalaryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee salaries
	 * @param end the upper bound of the range of employee salaries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee salaries
	 */
	@Override
	public List<EmployeeSalary> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EmployeeSalary> orderByComparator,
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

		List<EmployeeSalary> list = null;

		if (useFinderCache) {
			list = (List<EmployeeSalary>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EmployeeSalary employeeSalary : list) {
					if (!uuid.equals(employeeSalary.getUuid())) {
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

			sb.append(_SQL_SELECT_EMPLOYEESALARY_WHERE);

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
				sb.append(EmployeeSalaryModelImpl.ORDER_BY_JPQL);
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

				list = (List<EmployeeSalary>)QueryUtil.list(
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
	 * Returns the first employee salary in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee salary
	 * @throws NoSuchEmployeeSalaryException if a matching employee salary could not be found
	 */
	@Override
	public EmployeeSalary findByUuid_First(
			String uuid, OrderByComparator<EmployeeSalary> orderByComparator)
		throws NoSuchEmployeeSalaryException {

		EmployeeSalary employeeSalary = fetchByUuid_First(
			uuid, orderByComparator);

		if (employeeSalary != null) {
			return employeeSalary;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchEmployeeSalaryException(sb.toString());
	}

	/**
	 * Returns the first employee salary in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee salary, or <code>null</code> if a matching employee salary could not be found
	 */
	@Override
	public EmployeeSalary fetchByUuid_First(
		String uuid, OrderByComparator<EmployeeSalary> orderByComparator) {

		List<EmployeeSalary> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee salary in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee salary
	 * @throws NoSuchEmployeeSalaryException if a matching employee salary could not be found
	 */
	@Override
	public EmployeeSalary findByUuid_Last(
			String uuid, OrderByComparator<EmployeeSalary> orderByComparator)
		throws NoSuchEmployeeSalaryException {

		EmployeeSalary employeeSalary = fetchByUuid_Last(
			uuid, orderByComparator);

		if (employeeSalary != null) {
			return employeeSalary;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchEmployeeSalaryException(sb.toString());
	}

	/**
	 * Returns the last employee salary in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee salary, or <code>null</code> if a matching employee salary could not be found
	 */
	@Override
	public EmployeeSalary fetchByUuid_Last(
		String uuid, OrderByComparator<EmployeeSalary> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<EmployeeSalary> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the employee salaries before and after the current employee salary in the ordered set where uuid = &#63;.
	 *
	 * @param salaryId the primary key of the current employee salary
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee salary
	 * @throws NoSuchEmployeeSalaryException if a employee salary with the primary key could not be found
	 */
	@Override
	public EmployeeSalary[] findByUuid_PrevAndNext(
			long salaryId, String uuid,
			OrderByComparator<EmployeeSalary> orderByComparator)
		throws NoSuchEmployeeSalaryException {

		uuid = Objects.toString(uuid, "");

		EmployeeSalary employeeSalary = findByPrimaryKey(salaryId);

		Session session = null;

		try {
			session = openSession();

			EmployeeSalary[] array = new EmployeeSalaryImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, employeeSalary, uuid, orderByComparator, true);

			array[1] = employeeSalary;

			array[2] = getByUuid_PrevAndNext(
				session, employeeSalary, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected EmployeeSalary getByUuid_PrevAndNext(
		Session session, EmployeeSalary employeeSalary, String uuid,
		OrderByComparator<EmployeeSalary> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_EMPLOYEESALARY_WHERE);

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
			sb.append(EmployeeSalaryModelImpl.ORDER_BY_JPQL);
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
						employeeSalary)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EmployeeSalary> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employee salaries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (EmployeeSalary employeeSalary :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(employeeSalary);
		}
	}

	/**
	 * Returns the number of employee salaries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching employee salaries
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EMPLOYEESALARY_WHERE);

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
		"employeeSalary.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(employeeSalary.uuid IS NULL OR employeeSalary.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the employee salary where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchEmployeeSalaryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching employee salary
	 * @throws NoSuchEmployeeSalaryException if a matching employee salary could not be found
	 */
	@Override
	public EmployeeSalary findByUUID_G(String uuid, long groupId)
		throws NoSuchEmployeeSalaryException {

		EmployeeSalary employeeSalary = fetchByUUID_G(uuid, groupId);

		if (employeeSalary == null) {
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

			throw new NoSuchEmployeeSalaryException(sb.toString());
		}

		return employeeSalary;
	}

	/**
	 * Returns the employee salary where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching employee salary, or <code>null</code> if a matching employee salary could not be found
	 */
	@Override
	public EmployeeSalary fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the employee salary where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching employee salary, or <code>null</code> if a matching employee salary could not be found
	 */
	@Override
	public EmployeeSalary fetchByUUID_G(
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

		if (result instanceof EmployeeSalary) {
			EmployeeSalary employeeSalary = (EmployeeSalary)result;

			if (!Objects.equals(uuid, employeeSalary.getUuid()) ||
				(groupId != employeeSalary.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_EMPLOYEESALARY_WHERE);

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

				List<EmployeeSalary> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					EmployeeSalary employeeSalary = list.get(0);

					result = employeeSalary;

					cacheResult(employeeSalary);
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
			return (EmployeeSalary)result;
		}
	}

	/**
	 * Removes the employee salary where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the employee salary that was removed
	 */
	@Override
	public EmployeeSalary removeByUUID_G(String uuid, long groupId)
		throws NoSuchEmployeeSalaryException {

		EmployeeSalary employeeSalary = findByUUID_G(uuid, groupId);

		return remove(employeeSalary);
	}

	/**
	 * Returns the number of employee salaries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching employee salaries
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_EMPLOYEESALARY_WHERE);

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
		"employeeSalary.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(employeeSalary.uuid IS NULL OR employeeSalary.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"employeeSalary.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the employee salaries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching employee salaries
	 */
	@Override
	public List<EmployeeSalary> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee salaries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeSalaryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee salaries
	 * @param end the upper bound of the range of employee salaries (not inclusive)
	 * @return the range of matching employee salaries
	 */
	@Override
	public List<EmployeeSalary> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee salaries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeSalaryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee salaries
	 * @param end the upper bound of the range of employee salaries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee salaries
	 */
	@Override
	public List<EmployeeSalary> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EmployeeSalary> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee salaries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeSalaryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee salaries
	 * @param end the upper bound of the range of employee salaries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee salaries
	 */
	@Override
	public List<EmployeeSalary> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EmployeeSalary> orderByComparator,
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

		List<EmployeeSalary> list = null;

		if (useFinderCache) {
			list = (List<EmployeeSalary>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EmployeeSalary employeeSalary : list) {
					if (!uuid.equals(employeeSalary.getUuid()) ||
						(companyId != employeeSalary.getCompanyId())) {

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

			sb.append(_SQL_SELECT_EMPLOYEESALARY_WHERE);

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
				sb.append(EmployeeSalaryModelImpl.ORDER_BY_JPQL);
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

				list = (List<EmployeeSalary>)QueryUtil.list(
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
	 * Returns the first employee salary in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee salary
	 * @throws NoSuchEmployeeSalaryException if a matching employee salary could not be found
	 */
	@Override
	public EmployeeSalary findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<EmployeeSalary> orderByComparator)
		throws NoSuchEmployeeSalaryException {

		EmployeeSalary employeeSalary = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (employeeSalary != null) {
			return employeeSalary;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchEmployeeSalaryException(sb.toString());
	}

	/**
	 * Returns the first employee salary in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee salary, or <code>null</code> if a matching employee salary could not be found
	 */
	@Override
	public EmployeeSalary fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<EmployeeSalary> orderByComparator) {

		List<EmployeeSalary> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee salary in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee salary
	 * @throws NoSuchEmployeeSalaryException if a matching employee salary could not be found
	 */
	@Override
	public EmployeeSalary findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<EmployeeSalary> orderByComparator)
		throws NoSuchEmployeeSalaryException {

		EmployeeSalary employeeSalary = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (employeeSalary != null) {
			return employeeSalary;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchEmployeeSalaryException(sb.toString());
	}

	/**
	 * Returns the last employee salary in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee salary, or <code>null</code> if a matching employee salary could not be found
	 */
	@Override
	public EmployeeSalary fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<EmployeeSalary> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<EmployeeSalary> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the employee salaries before and after the current employee salary in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param salaryId the primary key of the current employee salary
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee salary
	 * @throws NoSuchEmployeeSalaryException if a employee salary with the primary key could not be found
	 */
	@Override
	public EmployeeSalary[] findByUuid_C_PrevAndNext(
			long salaryId, String uuid, long companyId,
			OrderByComparator<EmployeeSalary> orderByComparator)
		throws NoSuchEmployeeSalaryException {

		uuid = Objects.toString(uuid, "");

		EmployeeSalary employeeSalary = findByPrimaryKey(salaryId);

		Session session = null;

		try {
			session = openSession();

			EmployeeSalary[] array = new EmployeeSalaryImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, employeeSalary, uuid, companyId, orderByComparator,
				true);

			array[1] = employeeSalary;

			array[2] = getByUuid_C_PrevAndNext(
				session, employeeSalary, uuid, companyId, orderByComparator,
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

	protected EmployeeSalary getByUuid_C_PrevAndNext(
		Session session, EmployeeSalary employeeSalary, String uuid,
		long companyId, OrderByComparator<EmployeeSalary> orderByComparator,
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

		sb.append(_SQL_SELECT_EMPLOYEESALARY_WHERE);

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
			sb.append(EmployeeSalaryModelImpl.ORDER_BY_JPQL);
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
						employeeSalary)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EmployeeSalary> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employee salaries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (EmployeeSalary employeeSalary :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(employeeSalary);
		}
	}

	/**
	 * Returns the number of employee salaries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching employee salaries
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_EMPLOYEESALARY_WHERE);

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
		"employeeSalary.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(employeeSalary.uuid IS NULL OR employeeSalary.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"employeeSalary.companyId = ?";

	private FinderPath _finderPathFetchByEmployeeIdAndStatus;
	private FinderPath _finderPathCountByEmployeeIdAndStatus;

	/**
	 * Returns the employee salary where employeeId = &#63; and status = &#63; or throws a <code>NoSuchEmployeeSalaryException</code> if it could not be found.
	 *
	 * @param employeeId the employee ID
	 * @param status the status
	 * @return the matching employee salary
	 * @throws NoSuchEmployeeSalaryException if a matching employee salary could not be found
	 */
	@Override
	public EmployeeSalary findByEmployeeIdAndStatus(
			long employeeId, boolean status)
		throws NoSuchEmployeeSalaryException {

		EmployeeSalary employeeSalary = fetchByEmployeeIdAndStatus(
			employeeId, status);

		if (employeeSalary == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("employeeId=");
			sb.append(employeeId);

			sb.append(", status=");
			sb.append(status);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchEmployeeSalaryException(sb.toString());
		}

		return employeeSalary;
	}

	/**
	 * Returns the employee salary where employeeId = &#63; and status = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param employeeId the employee ID
	 * @param status the status
	 * @return the matching employee salary, or <code>null</code> if a matching employee salary could not be found
	 */
	@Override
	public EmployeeSalary fetchByEmployeeIdAndStatus(
		long employeeId, boolean status) {

		return fetchByEmployeeIdAndStatus(employeeId, status, true);
	}

	/**
	 * Returns the employee salary where employeeId = &#63; and status = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param employeeId the employee ID
	 * @param status the status
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching employee salary, or <code>null</code> if a matching employee salary could not be found
	 */
	@Override
	public EmployeeSalary fetchByEmployeeIdAndStatus(
		long employeeId, boolean status, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {employeeId, status};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByEmployeeIdAndStatus, finderArgs, this);
		}

		if (result instanceof EmployeeSalary) {
			EmployeeSalary employeeSalary = (EmployeeSalary)result;

			if ((employeeId != employeeSalary.getEmployeeId()) ||
				(status != employeeSalary.isStatus())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_EMPLOYEESALARY_WHERE);

			sb.append(_FINDER_COLUMN_EMPLOYEEIDANDSTATUS_EMPLOYEEID_2);

			sb.append(_FINDER_COLUMN_EMPLOYEEIDANDSTATUS_STATUS_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(employeeId);

				queryPos.add(status);

				List<EmployeeSalary> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByEmployeeIdAndStatus, finderArgs,
							list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {employeeId, status};
							}

							_log.warn(
								"EmployeeSalaryPersistenceImpl.fetchByEmployeeIdAndStatus(long, boolean, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					EmployeeSalary employeeSalary = list.get(0);

					result = employeeSalary;

					cacheResult(employeeSalary);
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
			return (EmployeeSalary)result;
		}
	}

	/**
	 * Removes the employee salary where employeeId = &#63; and status = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 * @param status the status
	 * @return the employee salary that was removed
	 */
	@Override
	public EmployeeSalary removeByEmployeeIdAndStatus(
			long employeeId, boolean status)
		throws NoSuchEmployeeSalaryException {

		EmployeeSalary employeeSalary = findByEmployeeIdAndStatus(
			employeeId, status);

		return remove(employeeSalary);
	}

	/**
	 * Returns the number of employee salaries where employeeId = &#63; and status = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param status the status
	 * @return the number of matching employee salaries
	 */
	@Override
	public int countByEmployeeIdAndStatus(long employeeId, boolean status) {
		FinderPath finderPath = _finderPathCountByEmployeeIdAndStatus;

		Object[] finderArgs = new Object[] {employeeId, status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_EMPLOYEESALARY_WHERE);

			sb.append(_FINDER_COLUMN_EMPLOYEEIDANDSTATUS_EMPLOYEEID_2);

			sb.append(_FINDER_COLUMN_EMPLOYEEIDANDSTATUS_STATUS_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(employeeId);

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
		_FINDER_COLUMN_EMPLOYEEIDANDSTATUS_EMPLOYEEID_2 =
			"employeeSalary.employeeId = ? AND ";

	private static final String _FINDER_COLUMN_EMPLOYEEIDANDSTATUS_STATUS_2 =
		"employeeSalary.status = ?";

	public EmployeeSalaryPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(EmployeeSalary.class);

		setModelImplClass(EmployeeSalaryImpl.class);
		setModelPKClass(long.class);

		setTable(EmployeeSalaryTable.INSTANCE);
	}

	/**
	 * Caches the employee salary in the entity cache if it is enabled.
	 *
	 * @param employeeSalary the employee salary
	 */
	@Override
	public void cacheResult(EmployeeSalary employeeSalary) {
		entityCache.putResult(
			EmployeeSalaryImpl.class, employeeSalary.getPrimaryKey(),
			employeeSalary);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				employeeSalary.getUuid(), employeeSalary.getGroupId()
			},
			employeeSalary);

		finderCache.putResult(
			_finderPathFetchByEmployeeIdAndStatus,
			new Object[] {
				employeeSalary.getEmployeeId(), employeeSalary.isStatus()
			},
			employeeSalary);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the employee salaries in the entity cache if it is enabled.
	 *
	 * @param employeeSalaries the employee salaries
	 */
	@Override
	public void cacheResult(List<EmployeeSalary> employeeSalaries) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (employeeSalaries.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (EmployeeSalary employeeSalary : employeeSalaries) {
			if (entityCache.getResult(
					EmployeeSalaryImpl.class, employeeSalary.getPrimaryKey()) ==
						null) {

				cacheResult(employeeSalary);
			}
		}
	}

	/**
	 * Clears the cache for all employee salaries.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(EmployeeSalaryImpl.class);

		finderCache.clearCache(EmployeeSalaryImpl.class);
	}

	/**
	 * Clears the cache for the employee salary.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EmployeeSalary employeeSalary) {
		entityCache.removeResult(EmployeeSalaryImpl.class, employeeSalary);
	}

	@Override
	public void clearCache(List<EmployeeSalary> employeeSalaries) {
		for (EmployeeSalary employeeSalary : employeeSalaries) {
			entityCache.removeResult(EmployeeSalaryImpl.class, employeeSalary);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(EmployeeSalaryImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(EmployeeSalaryImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		EmployeeSalaryModelImpl employeeSalaryModelImpl) {

		Object[] args = new Object[] {
			employeeSalaryModelImpl.getUuid(),
			employeeSalaryModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, employeeSalaryModelImpl);

		args = new Object[] {
			employeeSalaryModelImpl.getEmployeeId(),
			employeeSalaryModelImpl.isStatus()
		};

		finderCache.putResult(
			_finderPathCountByEmployeeIdAndStatus, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByEmployeeIdAndStatus, args,
			employeeSalaryModelImpl);
	}

	/**
	 * Creates a new employee salary with the primary key. Does not add the employee salary to the database.
	 *
	 * @param salaryId the primary key for the new employee salary
	 * @return the new employee salary
	 */
	@Override
	public EmployeeSalary create(long salaryId) {
		EmployeeSalary employeeSalary = new EmployeeSalaryImpl();

		employeeSalary.setNew(true);
		employeeSalary.setPrimaryKey(salaryId);

		String uuid = PortalUUIDUtil.generate();

		employeeSalary.setUuid(uuid);

		employeeSalary.setCompanyId(CompanyThreadLocal.getCompanyId());

		return employeeSalary;
	}

	/**
	 * Removes the employee salary with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param salaryId the primary key of the employee salary
	 * @return the employee salary that was removed
	 * @throws NoSuchEmployeeSalaryException if a employee salary with the primary key could not be found
	 */
	@Override
	public EmployeeSalary remove(long salaryId)
		throws NoSuchEmployeeSalaryException {

		return remove((Serializable)salaryId);
	}

	/**
	 * Removes the employee salary with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the employee salary
	 * @return the employee salary that was removed
	 * @throws NoSuchEmployeeSalaryException if a employee salary with the primary key could not be found
	 */
	@Override
	public EmployeeSalary remove(Serializable primaryKey)
		throws NoSuchEmployeeSalaryException {

		Session session = null;

		try {
			session = openSession();

			EmployeeSalary employeeSalary = (EmployeeSalary)session.get(
				EmployeeSalaryImpl.class, primaryKey);

			if (employeeSalary == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEmployeeSalaryException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(employeeSalary);
		}
		catch (NoSuchEmployeeSalaryException noSuchEntityException) {
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
	protected EmployeeSalary removeImpl(EmployeeSalary employeeSalary) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(employeeSalary)) {
				employeeSalary = (EmployeeSalary)session.get(
					EmployeeSalaryImpl.class,
					employeeSalary.getPrimaryKeyObj());
			}

			if (employeeSalary != null) {
				session.delete(employeeSalary);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (employeeSalary != null) {
			clearCache(employeeSalary);
		}

		return employeeSalary;
	}

	@Override
	public EmployeeSalary updateImpl(EmployeeSalary employeeSalary) {
		boolean isNew = employeeSalary.isNew();

		if (!(employeeSalary instanceof EmployeeSalaryModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(employeeSalary.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					employeeSalary);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in employeeSalary proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom EmployeeSalary implementation " +
					employeeSalary.getClass());
		}

		EmployeeSalaryModelImpl employeeSalaryModelImpl =
			(EmployeeSalaryModelImpl)employeeSalary;

		if (Validator.isNull(employeeSalary.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			employeeSalary.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (employeeSalary.getCreateDate() == null)) {
			if (serviceContext == null) {
				employeeSalary.setCreateDate(date);
			}
			else {
				employeeSalary.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!employeeSalaryModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				employeeSalary.setModifiedDate(date);
			}
			else {
				employeeSalary.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(employeeSalary);
			}
			else {
				employeeSalary = (EmployeeSalary)session.merge(employeeSalary);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			EmployeeSalaryImpl.class, employeeSalaryModelImpl, false, true);

		cacheUniqueFindersCache(employeeSalaryModelImpl);

		if (isNew) {
			employeeSalary.setNew(false);
		}

		employeeSalary.resetOriginalValues();

		return employeeSalary;
	}

	/**
	 * Returns the employee salary with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the employee salary
	 * @return the employee salary
	 * @throws NoSuchEmployeeSalaryException if a employee salary with the primary key could not be found
	 */
	@Override
	public EmployeeSalary findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEmployeeSalaryException {

		EmployeeSalary employeeSalary = fetchByPrimaryKey(primaryKey);

		if (employeeSalary == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEmployeeSalaryException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return employeeSalary;
	}

	/**
	 * Returns the employee salary with the primary key or throws a <code>NoSuchEmployeeSalaryException</code> if it could not be found.
	 *
	 * @param salaryId the primary key of the employee salary
	 * @return the employee salary
	 * @throws NoSuchEmployeeSalaryException if a employee salary with the primary key could not be found
	 */
	@Override
	public EmployeeSalary findByPrimaryKey(long salaryId)
		throws NoSuchEmployeeSalaryException {

		return findByPrimaryKey((Serializable)salaryId);
	}

	/**
	 * Returns the employee salary with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param salaryId the primary key of the employee salary
	 * @return the employee salary, or <code>null</code> if a employee salary with the primary key could not be found
	 */
	@Override
	public EmployeeSalary fetchByPrimaryKey(long salaryId) {
		return fetchByPrimaryKey((Serializable)salaryId);
	}

	/**
	 * Returns all the employee salaries.
	 *
	 * @return the employee salaries
	 */
	@Override
	public List<EmployeeSalary> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee salaries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeSalaryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee salaries
	 * @param end the upper bound of the range of employee salaries (not inclusive)
	 * @return the range of employee salaries
	 */
	@Override
	public List<EmployeeSalary> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee salaries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeSalaryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee salaries
	 * @param end the upper bound of the range of employee salaries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee salaries
	 */
	@Override
	public List<EmployeeSalary> findAll(
		int start, int end,
		OrderByComparator<EmployeeSalary> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee salaries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeSalaryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee salaries
	 * @param end the upper bound of the range of employee salaries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee salaries
	 */
	@Override
	public List<EmployeeSalary> findAll(
		int start, int end, OrderByComparator<EmployeeSalary> orderByComparator,
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

		List<EmployeeSalary> list = null;

		if (useFinderCache) {
			list = (List<EmployeeSalary>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_EMPLOYEESALARY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_EMPLOYEESALARY;

				sql = sql.concat(EmployeeSalaryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<EmployeeSalary>)QueryUtil.list(
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
	 * Removes all the employee salaries from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (EmployeeSalary employeeSalary : findAll()) {
			remove(employeeSalary);
		}
	}

	/**
	 * Returns the number of employee salaries.
	 *
	 * @return the number of employee salaries
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_EMPLOYEESALARY);

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
		return "salaryId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_EMPLOYEESALARY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return EmployeeSalaryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the employee salary persistence.
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

		_finderPathFetchByEmployeeIdAndStatus = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByEmployeeIdAndStatus",
			new String[] {Long.class.getName(), Boolean.class.getName()},
			new String[] {"employeeId", "status"}, true);

		_finderPathCountByEmployeeIdAndStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByEmployeeIdAndStatus",
			new String[] {Long.class.getName(), Boolean.class.getName()},
			new String[] {"employeeId", "status"}, false);

		EmployeeSalaryUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		EmployeeSalaryUtil.setPersistence(null);

		entityCache.removeCache(EmployeeSalaryImpl.class.getName());
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

	private static final String _SQL_SELECT_EMPLOYEESALARY =
		"SELECT employeeSalary FROM EmployeeSalary employeeSalary";

	private static final String _SQL_SELECT_EMPLOYEESALARY_WHERE =
		"SELECT employeeSalary FROM EmployeeSalary employeeSalary WHERE ";

	private static final String _SQL_COUNT_EMPLOYEESALARY =
		"SELECT COUNT(employeeSalary) FROM EmployeeSalary employeeSalary";

	private static final String _SQL_COUNT_EMPLOYEESALARY_WHERE =
		"SELECT COUNT(employeeSalary) FROM EmployeeSalary employeeSalary WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "employeeSalary.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No EmployeeSalary exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No EmployeeSalary exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		EmployeeSalaryPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}