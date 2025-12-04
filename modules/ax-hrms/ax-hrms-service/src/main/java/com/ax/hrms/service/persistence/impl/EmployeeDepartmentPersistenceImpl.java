/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence.impl;

import com.ax.hrms.exception.NoSuchEmployeeDepartmentException;
import com.ax.hrms.model.EmployeeDepartment;
import com.ax.hrms.model.EmployeeDepartmentTable;
import com.ax.hrms.model.impl.EmployeeDepartmentImpl;
import com.ax.hrms.model.impl.EmployeeDepartmentModelImpl;
import com.ax.hrms.service.persistence.EmployeeDepartmentPersistence;
import com.ax.hrms.service.persistence.EmployeeDepartmentUtil;
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
 * The persistence implementation for the employee department service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = EmployeeDepartmentPersistence.class)
public class EmployeeDepartmentPersistenceImpl
	extends BasePersistenceImpl<EmployeeDepartment>
	implements EmployeeDepartmentPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>EmployeeDepartmentUtil</code> to access the employee department persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		EmployeeDepartmentImpl.class.getName();

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
	 * Returns all the employee departments where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching employee departments
	 */
	@Override
	public List<EmployeeDepartment> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee departments where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDepartmentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee departments
	 * @param end the upper bound of the range of employee departments (not inclusive)
	 * @return the range of matching employee departments
	 */
	@Override
	public List<EmployeeDepartment> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee departments where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDepartmentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee departments
	 * @param end the upper bound of the range of employee departments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee departments
	 */
	@Override
	public List<EmployeeDepartment> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EmployeeDepartment> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee departments where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDepartmentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee departments
	 * @param end the upper bound of the range of employee departments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee departments
	 */
	@Override
	public List<EmployeeDepartment> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EmployeeDepartment> orderByComparator,
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

		List<EmployeeDepartment> list = null;

		if (useFinderCache) {
			list = (List<EmployeeDepartment>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EmployeeDepartment employeeDepartment : list) {
					if (!uuid.equals(employeeDepartment.getUuid())) {
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

			sb.append(_SQL_SELECT_EMPLOYEEDEPARTMENT_WHERE);

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
				sb.append(EmployeeDepartmentModelImpl.ORDER_BY_JPQL);
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

				list = (List<EmployeeDepartment>)QueryUtil.list(
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
	 * Returns the first employee department in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee department
	 * @throws NoSuchEmployeeDepartmentException if a matching employee department could not be found
	 */
	@Override
	public EmployeeDepartment findByUuid_First(
			String uuid,
			OrderByComparator<EmployeeDepartment> orderByComparator)
		throws NoSuchEmployeeDepartmentException {

		EmployeeDepartment employeeDepartment = fetchByUuid_First(
			uuid, orderByComparator);

		if (employeeDepartment != null) {
			return employeeDepartment;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchEmployeeDepartmentException(sb.toString());
	}

	/**
	 * Returns the first employee department in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee department, or <code>null</code> if a matching employee department could not be found
	 */
	@Override
	public EmployeeDepartment fetchByUuid_First(
		String uuid, OrderByComparator<EmployeeDepartment> orderByComparator) {

		List<EmployeeDepartment> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee department in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee department
	 * @throws NoSuchEmployeeDepartmentException if a matching employee department could not be found
	 */
	@Override
	public EmployeeDepartment findByUuid_Last(
			String uuid,
			OrderByComparator<EmployeeDepartment> orderByComparator)
		throws NoSuchEmployeeDepartmentException {

		EmployeeDepartment employeeDepartment = fetchByUuid_Last(
			uuid, orderByComparator);

		if (employeeDepartment != null) {
			return employeeDepartment;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchEmployeeDepartmentException(sb.toString());
	}

	/**
	 * Returns the last employee department in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee department, or <code>null</code> if a matching employee department could not be found
	 */
	@Override
	public EmployeeDepartment fetchByUuid_Last(
		String uuid, OrderByComparator<EmployeeDepartment> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<EmployeeDepartment> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the employee departments before and after the current employee department in the ordered set where uuid = &#63;.
	 *
	 * @param employeeDepartmentId the primary key of the current employee department
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee department
	 * @throws NoSuchEmployeeDepartmentException if a employee department with the primary key could not be found
	 */
	@Override
	public EmployeeDepartment[] findByUuid_PrevAndNext(
			long employeeDepartmentId, String uuid,
			OrderByComparator<EmployeeDepartment> orderByComparator)
		throws NoSuchEmployeeDepartmentException {

		uuid = Objects.toString(uuid, "");

		EmployeeDepartment employeeDepartment = findByPrimaryKey(
			employeeDepartmentId);

		Session session = null;

		try {
			session = openSession();

			EmployeeDepartment[] array = new EmployeeDepartmentImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, employeeDepartment, uuid, orderByComparator, true);

			array[1] = employeeDepartment;

			array[2] = getByUuid_PrevAndNext(
				session, employeeDepartment, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected EmployeeDepartment getByUuid_PrevAndNext(
		Session session, EmployeeDepartment employeeDepartment, String uuid,
		OrderByComparator<EmployeeDepartment> orderByComparator,
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

		sb.append(_SQL_SELECT_EMPLOYEEDEPARTMENT_WHERE);

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
			sb.append(EmployeeDepartmentModelImpl.ORDER_BY_JPQL);
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
						employeeDepartment)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EmployeeDepartment> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employee departments where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (EmployeeDepartment employeeDepartment :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(employeeDepartment);
		}
	}

	/**
	 * Returns the number of employee departments where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching employee departments
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EMPLOYEEDEPARTMENT_WHERE);

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
		"employeeDepartment.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(employeeDepartment.uuid IS NULL OR employeeDepartment.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;

	/**
	 * Returns the employee department where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchEmployeeDepartmentException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching employee department
	 * @throws NoSuchEmployeeDepartmentException if a matching employee department could not be found
	 */
	@Override
	public EmployeeDepartment findByUUID_G(String uuid, long groupId)
		throws NoSuchEmployeeDepartmentException {

		EmployeeDepartment employeeDepartment = fetchByUUID_G(uuid, groupId);

		if (employeeDepartment == null) {
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

			throw new NoSuchEmployeeDepartmentException(sb.toString());
		}

		return employeeDepartment;
	}

	/**
	 * Returns the employee department where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching employee department, or <code>null</code> if a matching employee department could not be found
	 */
	@Override
	public EmployeeDepartment fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the employee department where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching employee department, or <code>null</code> if a matching employee department could not be found
	 */
	@Override
	public EmployeeDepartment fetchByUUID_G(
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

		if (result instanceof EmployeeDepartment) {
			EmployeeDepartment employeeDepartment = (EmployeeDepartment)result;

			if (!Objects.equals(uuid, employeeDepartment.getUuid()) ||
				(groupId != employeeDepartment.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_EMPLOYEEDEPARTMENT_WHERE);

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

				List<EmployeeDepartment> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					EmployeeDepartment employeeDepartment = list.get(0);

					result = employeeDepartment;

					cacheResult(employeeDepartment);
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
			return (EmployeeDepartment)result;
		}
	}

	/**
	 * Removes the employee department where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the employee department that was removed
	 */
	@Override
	public EmployeeDepartment removeByUUID_G(String uuid, long groupId)
		throws NoSuchEmployeeDepartmentException {

		EmployeeDepartment employeeDepartment = findByUUID_G(uuid, groupId);

		return remove(employeeDepartment);
	}

	/**
	 * Returns the number of employee departments where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching employee departments
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		EmployeeDepartment employeeDepartment = fetchByUUID_G(uuid, groupId);

		if (employeeDepartment == null) {
			return 0;
		}

		return 1;
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"employeeDepartment.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(employeeDepartment.uuid IS NULL OR employeeDepartment.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"employeeDepartment.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the employee departments where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching employee departments
	 */
	@Override
	public List<EmployeeDepartment> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee departments where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDepartmentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee departments
	 * @param end the upper bound of the range of employee departments (not inclusive)
	 * @return the range of matching employee departments
	 */
	@Override
	public List<EmployeeDepartment> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee departments where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDepartmentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee departments
	 * @param end the upper bound of the range of employee departments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee departments
	 */
	@Override
	public List<EmployeeDepartment> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EmployeeDepartment> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee departments where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDepartmentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee departments
	 * @param end the upper bound of the range of employee departments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee departments
	 */
	@Override
	public List<EmployeeDepartment> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EmployeeDepartment> orderByComparator,
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

		List<EmployeeDepartment> list = null;

		if (useFinderCache) {
			list = (List<EmployeeDepartment>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EmployeeDepartment employeeDepartment : list) {
					if (!uuid.equals(employeeDepartment.getUuid()) ||
						(companyId != employeeDepartment.getCompanyId())) {

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

			sb.append(_SQL_SELECT_EMPLOYEEDEPARTMENT_WHERE);

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
				sb.append(EmployeeDepartmentModelImpl.ORDER_BY_JPQL);
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

				list = (List<EmployeeDepartment>)QueryUtil.list(
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
	 * Returns the first employee department in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee department
	 * @throws NoSuchEmployeeDepartmentException if a matching employee department could not be found
	 */
	@Override
	public EmployeeDepartment findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<EmployeeDepartment> orderByComparator)
		throws NoSuchEmployeeDepartmentException {

		EmployeeDepartment employeeDepartment = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (employeeDepartment != null) {
			return employeeDepartment;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchEmployeeDepartmentException(sb.toString());
	}

	/**
	 * Returns the first employee department in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee department, or <code>null</code> if a matching employee department could not be found
	 */
	@Override
	public EmployeeDepartment fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<EmployeeDepartment> orderByComparator) {

		List<EmployeeDepartment> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee department in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee department
	 * @throws NoSuchEmployeeDepartmentException if a matching employee department could not be found
	 */
	@Override
	public EmployeeDepartment findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<EmployeeDepartment> orderByComparator)
		throws NoSuchEmployeeDepartmentException {

		EmployeeDepartment employeeDepartment = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (employeeDepartment != null) {
			return employeeDepartment;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchEmployeeDepartmentException(sb.toString());
	}

	/**
	 * Returns the last employee department in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee department, or <code>null</code> if a matching employee department could not be found
	 */
	@Override
	public EmployeeDepartment fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<EmployeeDepartment> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<EmployeeDepartment> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the employee departments before and after the current employee department in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param employeeDepartmentId the primary key of the current employee department
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee department
	 * @throws NoSuchEmployeeDepartmentException if a employee department with the primary key could not be found
	 */
	@Override
	public EmployeeDepartment[] findByUuid_C_PrevAndNext(
			long employeeDepartmentId, String uuid, long companyId,
			OrderByComparator<EmployeeDepartment> orderByComparator)
		throws NoSuchEmployeeDepartmentException {

		uuid = Objects.toString(uuid, "");

		EmployeeDepartment employeeDepartment = findByPrimaryKey(
			employeeDepartmentId);

		Session session = null;

		try {
			session = openSession();

			EmployeeDepartment[] array = new EmployeeDepartmentImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, employeeDepartment, uuid, companyId, orderByComparator,
				true);

			array[1] = employeeDepartment;

			array[2] = getByUuid_C_PrevAndNext(
				session, employeeDepartment, uuid, companyId, orderByComparator,
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

	protected EmployeeDepartment getByUuid_C_PrevAndNext(
		Session session, EmployeeDepartment employeeDepartment, String uuid,
		long companyId, OrderByComparator<EmployeeDepartment> orderByComparator,
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

		sb.append(_SQL_SELECT_EMPLOYEEDEPARTMENT_WHERE);

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
			sb.append(EmployeeDepartmentModelImpl.ORDER_BY_JPQL);
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
						employeeDepartment)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EmployeeDepartment> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employee departments where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (EmployeeDepartment employeeDepartment :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(employeeDepartment);
		}
	}

	/**
	 * Returns the number of employee departments where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching employee departments
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_EMPLOYEEDEPARTMENT_WHERE);

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
		"employeeDepartment.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(employeeDepartment.uuid IS NULL OR employeeDepartment.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"employeeDepartment.companyId = ?";

	private FinderPath _finderPathFetchByEmployeeId;

	/**
	 * Returns the employee department where employeeId = &#63; or throws a <code>NoSuchEmployeeDepartmentException</code> if it could not be found.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee department
	 * @throws NoSuchEmployeeDepartmentException if a matching employee department could not be found
	 */
	@Override
	public EmployeeDepartment findByEmployeeId(long employeeId)
		throws NoSuchEmployeeDepartmentException {

		EmployeeDepartment employeeDepartment = fetchByEmployeeId(employeeId);

		if (employeeDepartment == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("employeeId=");
			sb.append(employeeId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchEmployeeDepartmentException(sb.toString());
		}

		return employeeDepartment;
	}

	/**
	 * Returns the employee department where employeeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee department, or <code>null</code> if a matching employee department could not be found
	 */
	@Override
	public EmployeeDepartment fetchByEmployeeId(long employeeId) {
		return fetchByEmployeeId(employeeId, true);
	}

	/**
	 * Returns the employee department where employeeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param employeeId the employee ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching employee department, or <code>null</code> if a matching employee department could not be found
	 */
	@Override
	public EmployeeDepartment fetchByEmployeeId(
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

		if (result instanceof EmployeeDepartment) {
			EmployeeDepartment employeeDepartment = (EmployeeDepartment)result;

			if (employeeId != employeeDepartment.getEmployeeId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_EMPLOYEEDEPARTMENT_WHERE);

			sb.append(_FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(employeeId);

				List<EmployeeDepartment> list = query.list();

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
								"EmployeeDepartmentPersistenceImpl.fetchByEmployeeId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					EmployeeDepartment employeeDepartment = list.get(0);

					result = employeeDepartment;

					cacheResult(employeeDepartment);
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
			return (EmployeeDepartment)result;
		}
	}

	/**
	 * Removes the employee department where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 * @return the employee department that was removed
	 */
	@Override
	public EmployeeDepartment removeByEmployeeId(long employeeId)
		throws NoSuchEmployeeDepartmentException {

		EmployeeDepartment employeeDepartment = findByEmployeeId(employeeId);

		return remove(employeeDepartment);
	}

	/**
	 * Returns the number of employee departments where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee departments
	 */
	@Override
	public int countByEmployeeId(long employeeId) {
		EmployeeDepartment employeeDepartment = fetchByEmployeeId(employeeId);

		if (employeeDepartment == null) {
			return 0;
		}

		return 1;
	}

	private static final String _FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2 =
		"employeeDepartment.employeeId = ?";

	private FinderPath _finderPathWithPaginationFindByEmployeeIdGetDepartments;
	private FinderPath
		_finderPathWithoutPaginationFindByEmployeeIdGetDepartments;
	private FinderPath _finderPathCountByEmployeeIdGetDepartments;

	/**
	 * Returns all the employee departments where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee departments
	 */
	@Override
	public List<EmployeeDepartment> findByEmployeeIdGetDepartments(
		long employeeId) {

		return findByEmployeeIdGetDepartments(
			employeeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee departments where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDepartmentModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee departments
	 * @param end the upper bound of the range of employee departments (not inclusive)
	 * @return the range of matching employee departments
	 */
	@Override
	public List<EmployeeDepartment> findByEmployeeIdGetDepartments(
		long employeeId, int start, int end) {

		return findByEmployeeIdGetDepartments(employeeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee departments where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDepartmentModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee departments
	 * @param end the upper bound of the range of employee departments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee departments
	 */
	@Override
	public List<EmployeeDepartment> findByEmployeeIdGetDepartments(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeDepartment> orderByComparator) {

		return findByEmployeeIdGetDepartments(
			employeeId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee departments where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDepartmentModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee departments
	 * @param end the upper bound of the range of employee departments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee departments
	 */
	@Override
	public List<EmployeeDepartment> findByEmployeeIdGetDepartments(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeDepartment> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByEmployeeIdGetDepartments;
				finderArgs = new Object[] {employeeId};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByEmployeeIdGetDepartments;
			finderArgs = new Object[] {
				employeeId, start, end, orderByComparator
			};
		}

		List<EmployeeDepartment> list = null;

		if (useFinderCache) {
			list = (List<EmployeeDepartment>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EmployeeDepartment employeeDepartment : list) {
					if (employeeId != employeeDepartment.getEmployeeId()) {
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

			sb.append(_SQL_SELECT_EMPLOYEEDEPARTMENT_WHERE);

			sb.append(_FINDER_COLUMN_EMPLOYEEIDGETDEPARTMENTS_EMPLOYEEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EmployeeDepartmentModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(employeeId);

				list = (List<EmployeeDepartment>)QueryUtil.list(
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
	 * Returns the first employee department in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee department
	 * @throws NoSuchEmployeeDepartmentException if a matching employee department could not be found
	 */
	@Override
	public EmployeeDepartment findByEmployeeIdGetDepartments_First(
			long employeeId,
			OrderByComparator<EmployeeDepartment> orderByComparator)
		throws NoSuchEmployeeDepartmentException {

		EmployeeDepartment employeeDepartment =
			fetchByEmployeeIdGetDepartments_First(
				employeeId, orderByComparator);

		if (employeeDepartment != null) {
			return employeeDepartment;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("employeeId=");
		sb.append(employeeId);

		sb.append("}");

		throw new NoSuchEmployeeDepartmentException(sb.toString());
	}

	/**
	 * Returns the first employee department in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee department, or <code>null</code> if a matching employee department could not be found
	 */
	@Override
	public EmployeeDepartment fetchByEmployeeIdGetDepartments_First(
		long employeeId,
		OrderByComparator<EmployeeDepartment> orderByComparator) {

		List<EmployeeDepartment> list = findByEmployeeIdGetDepartments(
			employeeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee department in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee department
	 * @throws NoSuchEmployeeDepartmentException if a matching employee department could not be found
	 */
	@Override
	public EmployeeDepartment findByEmployeeIdGetDepartments_Last(
			long employeeId,
			OrderByComparator<EmployeeDepartment> orderByComparator)
		throws NoSuchEmployeeDepartmentException {

		EmployeeDepartment employeeDepartment =
			fetchByEmployeeIdGetDepartments_Last(employeeId, orderByComparator);

		if (employeeDepartment != null) {
			return employeeDepartment;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("employeeId=");
		sb.append(employeeId);

		sb.append("}");

		throw new NoSuchEmployeeDepartmentException(sb.toString());
	}

	/**
	 * Returns the last employee department in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee department, or <code>null</code> if a matching employee department could not be found
	 */
	@Override
	public EmployeeDepartment fetchByEmployeeIdGetDepartments_Last(
		long employeeId,
		OrderByComparator<EmployeeDepartment> orderByComparator) {

		int count = countByEmployeeIdGetDepartments(employeeId);

		if (count == 0) {
			return null;
		}

		List<EmployeeDepartment> list = findByEmployeeIdGetDepartments(
			employeeId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the employee departments before and after the current employee department in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeDepartmentId the primary key of the current employee department
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee department
	 * @throws NoSuchEmployeeDepartmentException if a employee department with the primary key could not be found
	 */
	@Override
	public EmployeeDepartment[] findByEmployeeIdGetDepartments_PrevAndNext(
			long employeeDepartmentId, long employeeId,
			OrderByComparator<EmployeeDepartment> orderByComparator)
		throws NoSuchEmployeeDepartmentException {

		EmployeeDepartment employeeDepartment = findByPrimaryKey(
			employeeDepartmentId);

		Session session = null;

		try {
			session = openSession();

			EmployeeDepartment[] array = new EmployeeDepartmentImpl[3];

			array[0] = getByEmployeeIdGetDepartments_PrevAndNext(
				session, employeeDepartment, employeeId, orderByComparator,
				true);

			array[1] = employeeDepartment;

			array[2] = getByEmployeeIdGetDepartments_PrevAndNext(
				session, employeeDepartment, employeeId, orderByComparator,
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

	protected EmployeeDepartment getByEmployeeIdGetDepartments_PrevAndNext(
		Session session, EmployeeDepartment employeeDepartment, long employeeId,
		OrderByComparator<EmployeeDepartment> orderByComparator,
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

		sb.append(_SQL_SELECT_EMPLOYEEDEPARTMENT_WHERE);

		sb.append(_FINDER_COLUMN_EMPLOYEEIDGETDEPARTMENTS_EMPLOYEEID_2);

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
			sb.append(EmployeeDepartmentModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(employeeId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						employeeDepartment)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EmployeeDepartment> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employee departments where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	@Override
	public void removeByEmployeeIdGetDepartments(long employeeId) {
		for (EmployeeDepartment employeeDepartment :
				findByEmployeeIdGetDepartments(
					employeeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(employeeDepartment);
		}
	}

	/**
	 * Returns the number of employee departments where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee departments
	 */
	@Override
	public int countByEmployeeIdGetDepartments(long employeeId) {
		FinderPath finderPath = _finderPathCountByEmployeeIdGetDepartments;

		Object[] finderArgs = new Object[] {employeeId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EMPLOYEEDEPARTMENT_WHERE);

			sb.append(_FINDER_COLUMN_EMPLOYEEIDGETDEPARTMENTS_EMPLOYEEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(employeeId);

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
		_FINDER_COLUMN_EMPLOYEEIDGETDEPARTMENTS_EMPLOYEEID_2 =
			"employeeDepartment.employeeId = ?";

	private FinderPath _finderPathWithPaginationFindBydepartmentMasterId;
	private FinderPath _finderPathWithoutPaginationFindBydepartmentMasterId;
	private FinderPath _finderPathCountBydepartmentMasterId;

	/**
	 * Returns all the employee departments where departmentMasterId = &#63;.
	 *
	 * @param departmentMasterId the department master ID
	 * @return the matching employee departments
	 */
	@Override
	public List<EmployeeDepartment> findBydepartmentMasterId(
		long departmentMasterId) {

		return findBydepartmentMasterId(
			departmentMasterId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee departments where departmentMasterId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDepartmentModelImpl</code>.
	 * </p>
	 *
	 * @param departmentMasterId the department master ID
	 * @param start the lower bound of the range of employee departments
	 * @param end the upper bound of the range of employee departments (not inclusive)
	 * @return the range of matching employee departments
	 */
	@Override
	public List<EmployeeDepartment> findBydepartmentMasterId(
		long departmentMasterId, int start, int end) {

		return findBydepartmentMasterId(departmentMasterId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee departments where departmentMasterId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDepartmentModelImpl</code>.
	 * </p>
	 *
	 * @param departmentMasterId the department master ID
	 * @param start the lower bound of the range of employee departments
	 * @param end the upper bound of the range of employee departments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee departments
	 */
	@Override
	public List<EmployeeDepartment> findBydepartmentMasterId(
		long departmentMasterId, int start, int end,
		OrderByComparator<EmployeeDepartment> orderByComparator) {

		return findBydepartmentMasterId(
			departmentMasterId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee departments where departmentMasterId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDepartmentModelImpl</code>.
	 * </p>
	 *
	 * @param departmentMasterId the department master ID
	 * @param start the lower bound of the range of employee departments
	 * @param end the upper bound of the range of employee departments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee departments
	 */
	@Override
	public List<EmployeeDepartment> findBydepartmentMasterId(
		long departmentMasterId, int start, int end,
		OrderByComparator<EmployeeDepartment> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindBydepartmentMasterId;
				finderArgs = new Object[] {departmentMasterId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBydepartmentMasterId;
			finderArgs = new Object[] {
				departmentMasterId, start, end, orderByComparator
			};
		}

		List<EmployeeDepartment> list = null;

		if (useFinderCache) {
			list = (List<EmployeeDepartment>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EmployeeDepartment employeeDepartment : list) {
					if (departmentMasterId !=
							employeeDepartment.getDepartmentMasterId()) {

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

			sb.append(_SQL_SELECT_EMPLOYEEDEPARTMENT_WHERE);

			sb.append(_FINDER_COLUMN_DEPARTMENTMASTERID_DEPARTMENTMASTERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EmployeeDepartmentModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(departmentMasterId);

				list = (List<EmployeeDepartment>)QueryUtil.list(
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
	 * Returns the first employee department in the ordered set where departmentMasterId = &#63;.
	 *
	 * @param departmentMasterId the department master ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee department
	 * @throws NoSuchEmployeeDepartmentException if a matching employee department could not be found
	 */
	@Override
	public EmployeeDepartment findBydepartmentMasterId_First(
			long departmentMasterId,
			OrderByComparator<EmployeeDepartment> orderByComparator)
		throws NoSuchEmployeeDepartmentException {

		EmployeeDepartment employeeDepartment = fetchBydepartmentMasterId_First(
			departmentMasterId, orderByComparator);

		if (employeeDepartment != null) {
			return employeeDepartment;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("departmentMasterId=");
		sb.append(departmentMasterId);

		sb.append("}");

		throw new NoSuchEmployeeDepartmentException(sb.toString());
	}

	/**
	 * Returns the first employee department in the ordered set where departmentMasterId = &#63;.
	 *
	 * @param departmentMasterId the department master ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee department, or <code>null</code> if a matching employee department could not be found
	 */
	@Override
	public EmployeeDepartment fetchBydepartmentMasterId_First(
		long departmentMasterId,
		OrderByComparator<EmployeeDepartment> orderByComparator) {

		List<EmployeeDepartment> list = findBydepartmentMasterId(
			departmentMasterId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee department in the ordered set where departmentMasterId = &#63;.
	 *
	 * @param departmentMasterId the department master ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee department
	 * @throws NoSuchEmployeeDepartmentException if a matching employee department could not be found
	 */
	@Override
	public EmployeeDepartment findBydepartmentMasterId_Last(
			long departmentMasterId,
			OrderByComparator<EmployeeDepartment> orderByComparator)
		throws NoSuchEmployeeDepartmentException {

		EmployeeDepartment employeeDepartment = fetchBydepartmentMasterId_Last(
			departmentMasterId, orderByComparator);

		if (employeeDepartment != null) {
			return employeeDepartment;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("departmentMasterId=");
		sb.append(departmentMasterId);

		sb.append("}");

		throw new NoSuchEmployeeDepartmentException(sb.toString());
	}

	/**
	 * Returns the last employee department in the ordered set where departmentMasterId = &#63;.
	 *
	 * @param departmentMasterId the department master ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee department, or <code>null</code> if a matching employee department could not be found
	 */
	@Override
	public EmployeeDepartment fetchBydepartmentMasterId_Last(
		long departmentMasterId,
		OrderByComparator<EmployeeDepartment> orderByComparator) {

		int count = countBydepartmentMasterId(departmentMasterId);

		if (count == 0) {
			return null;
		}

		List<EmployeeDepartment> list = findBydepartmentMasterId(
			departmentMasterId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the employee departments before and after the current employee department in the ordered set where departmentMasterId = &#63;.
	 *
	 * @param employeeDepartmentId the primary key of the current employee department
	 * @param departmentMasterId the department master ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee department
	 * @throws NoSuchEmployeeDepartmentException if a employee department with the primary key could not be found
	 */
	@Override
	public EmployeeDepartment[] findBydepartmentMasterId_PrevAndNext(
			long employeeDepartmentId, long departmentMasterId,
			OrderByComparator<EmployeeDepartment> orderByComparator)
		throws NoSuchEmployeeDepartmentException {

		EmployeeDepartment employeeDepartment = findByPrimaryKey(
			employeeDepartmentId);

		Session session = null;

		try {
			session = openSession();

			EmployeeDepartment[] array = new EmployeeDepartmentImpl[3];

			array[0] = getBydepartmentMasterId_PrevAndNext(
				session, employeeDepartment, departmentMasterId,
				orderByComparator, true);

			array[1] = employeeDepartment;

			array[2] = getBydepartmentMasterId_PrevAndNext(
				session, employeeDepartment, departmentMasterId,
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

	protected EmployeeDepartment getBydepartmentMasterId_PrevAndNext(
		Session session, EmployeeDepartment employeeDepartment,
		long departmentMasterId,
		OrderByComparator<EmployeeDepartment> orderByComparator,
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

		sb.append(_SQL_SELECT_EMPLOYEEDEPARTMENT_WHERE);

		sb.append(_FINDER_COLUMN_DEPARTMENTMASTERID_DEPARTMENTMASTERID_2);

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
			sb.append(EmployeeDepartmentModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(departmentMasterId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						employeeDepartment)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EmployeeDepartment> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employee departments where departmentMasterId = &#63; from the database.
	 *
	 * @param departmentMasterId the department master ID
	 */
	@Override
	public void removeBydepartmentMasterId(long departmentMasterId) {
		for (EmployeeDepartment employeeDepartment :
				findBydepartmentMasterId(
					departmentMasterId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(employeeDepartment);
		}
	}

	/**
	 * Returns the number of employee departments where departmentMasterId = &#63;.
	 *
	 * @param departmentMasterId the department master ID
	 * @return the number of matching employee departments
	 */
	@Override
	public int countBydepartmentMasterId(long departmentMasterId) {
		FinderPath finderPath = _finderPathCountBydepartmentMasterId;

		Object[] finderArgs = new Object[] {departmentMasterId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EMPLOYEEDEPARTMENT_WHERE);

			sb.append(_FINDER_COLUMN_DEPARTMENTMASTERID_DEPARTMENTMASTERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(departmentMasterId);

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
		_FINDER_COLUMN_DEPARTMENTMASTERID_DEPARTMENTMASTERID_2 =
			"employeeDepartment.departmentMasterId = ?";

	private FinderPath
		_finderPathFetchByEmployeeIdAndStatusAndDepartmentMasterId;

	/**
	 * Returns the employee department where departmentMasterId = &#63; and status = &#63; and employeeId = &#63; or throws a <code>NoSuchEmployeeDepartmentException</code> if it could not be found.
	 *
	 * @param departmentMasterId the department master ID
	 * @param status the status
	 * @param employeeId the employee ID
	 * @return the matching employee department
	 * @throws NoSuchEmployeeDepartmentException if a matching employee department could not be found
	 */
	@Override
	public EmployeeDepartment findByEmployeeIdAndStatusAndDepartmentMasterId(
			long departmentMasterId, boolean status, long employeeId)
		throws NoSuchEmployeeDepartmentException {

		EmployeeDepartment employeeDepartment =
			fetchByEmployeeIdAndStatusAndDepartmentMasterId(
				departmentMasterId, status, employeeId);

		if (employeeDepartment == null) {
			StringBundler sb = new StringBundler(8);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("departmentMasterId=");
			sb.append(departmentMasterId);

			sb.append(", status=");
			sb.append(status);

			sb.append(", employeeId=");
			sb.append(employeeId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchEmployeeDepartmentException(sb.toString());
		}

		return employeeDepartment;
	}

	/**
	 * Returns the employee department where departmentMasterId = &#63; and status = &#63; and employeeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param departmentMasterId the department master ID
	 * @param status the status
	 * @param employeeId the employee ID
	 * @return the matching employee department, or <code>null</code> if a matching employee department could not be found
	 */
	@Override
	public EmployeeDepartment fetchByEmployeeIdAndStatusAndDepartmentMasterId(
		long departmentMasterId, boolean status, long employeeId) {

		return fetchByEmployeeIdAndStatusAndDepartmentMasterId(
			departmentMasterId, status, employeeId, true);
	}

	/**
	 * Returns the employee department where departmentMasterId = &#63; and status = &#63; and employeeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param departmentMasterId the department master ID
	 * @param status the status
	 * @param employeeId the employee ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching employee department, or <code>null</code> if a matching employee department could not be found
	 */
	@Override
	public EmployeeDepartment fetchByEmployeeIdAndStatusAndDepartmentMasterId(
		long departmentMasterId, boolean status, long employeeId,
		boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {departmentMasterId, status, employeeId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByEmployeeIdAndStatusAndDepartmentMasterId,
				finderArgs, this);
		}

		if (result instanceof EmployeeDepartment) {
			EmployeeDepartment employeeDepartment = (EmployeeDepartment)result;

			if ((departmentMasterId !=
					employeeDepartment.getDepartmentMasterId()) ||
				(status != employeeDepartment.isStatus()) ||
				(employeeId != employeeDepartment.getEmployeeId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(5);

			sb.append(_SQL_SELECT_EMPLOYEEDEPARTMENT_WHERE);

			sb.append(
				_FINDER_COLUMN_EMPLOYEEIDANDSTATUSANDDEPARTMENTMASTERID_DEPARTMENTMASTERID_2);

			sb.append(
				_FINDER_COLUMN_EMPLOYEEIDANDSTATUSANDDEPARTMENTMASTERID_STATUS_2);

			sb.append(
				_FINDER_COLUMN_EMPLOYEEIDANDSTATUSANDDEPARTMENTMASTERID_EMPLOYEEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(departmentMasterId);

				queryPos.add(status);

				queryPos.add(employeeId);

				List<EmployeeDepartment> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByEmployeeIdAndStatusAndDepartmentMasterId,
							finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									departmentMasterId, status, employeeId
								};
							}

							_log.warn(
								"EmployeeDepartmentPersistenceImpl.fetchByEmployeeIdAndStatusAndDepartmentMasterId(long, boolean, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					EmployeeDepartment employeeDepartment = list.get(0);

					result = employeeDepartment;

					cacheResult(employeeDepartment);
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
			return (EmployeeDepartment)result;
		}
	}

	/**
	 * Removes the employee department where departmentMasterId = &#63; and status = &#63; and employeeId = &#63; from the database.
	 *
	 * @param departmentMasterId the department master ID
	 * @param status the status
	 * @param employeeId the employee ID
	 * @return the employee department that was removed
	 */
	@Override
	public EmployeeDepartment removeByEmployeeIdAndStatusAndDepartmentMasterId(
			long departmentMasterId, boolean status, long employeeId)
		throws NoSuchEmployeeDepartmentException {

		EmployeeDepartment employeeDepartment =
			findByEmployeeIdAndStatusAndDepartmentMasterId(
				departmentMasterId, status, employeeId);

		return remove(employeeDepartment);
	}

	/**
	 * Returns the number of employee departments where departmentMasterId = &#63; and status = &#63; and employeeId = &#63;.
	 *
	 * @param departmentMasterId the department master ID
	 * @param status the status
	 * @param employeeId the employee ID
	 * @return the number of matching employee departments
	 */
	@Override
	public int countByEmployeeIdAndStatusAndDepartmentMasterId(
		long departmentMasterId, boolean status, long employeeId) {

		EmployeeDepartment employeeDepartment =
			fetchByEmployeeIdAndStatusAndDepartmentMasterId(
				departmentMasterId, status, employeeId);

		if (employeeDepartment == null) {
			return 0;
		}

		return 1;
	}

	private static final String
		_FINDER_COLUMN_EMPLOYEEIDANDSTATUSANDDEPARTMENTMASTERID_DEPARTMENTMASTERID_2 =
			"employeeDepartment.departmentMasterId = ? AND ";

	private static final String
		_FINDER_COLUMN_EMPLOYEEIDANDSTATUSANDDEPARTMENTMASTERID_STATUS_2 =
			"employeeDepartment.status = ? AND ";

	private static final String
		_FINDER_COLUMN_EMPLOYEEIDANDSTATUSANDDEPARTMENTMASTERID_EMPLOYEEID_2 =
			"employeeDepartment.employeeId = ?";

	public EmployeeDepartmentPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(EmployeeDepartment.class);

		setModelImplClass(EmployeeDepartmentImpl.class);
		setModelPKClass(long.class);

		setTable(EmployeeDepartmentTable.INSTANCE);
	}

	/**
	 * Caches the employee department in the entity cache if it is enabled.
	 *
	 * @param employeeDepartment the employee department
	 */
	@Override
	public void cacheResult(EmployeeDepartment employeeDepartment) {
		entityCache.putResult(
			EmployeeDepartmentImpl.class, employeeDepartment.getPrimaryKey(),
			employeeDepartment);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				employeeDepartment.getUuid(), employeeDepartment.getGroupId()
			},
			employeeDepartment);

		finderCache.putResult(
			_finderPathFetchByEmployeeId,
			new Object[] {employeeDepartment.getEmployeeId()},
			employeeDepartment);

		finderCache.putResult(
			_finderPathFetchByEmployeeIdAndStatusAndDepartmentMasterId,
			new Object[] {
				employeeDepartment.getDepartmentMasterId(),
				employeeDepartment.isStatus(),
				employeeDepartment.getEmployeeId()
			},
			employeeDepartment);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the employee departments in the entity cache if it is enabled.
	 *
	 * @param employeeDepartments the employee departments
	 */
	@Override
	public void cacheResult(List<EmployeeDepartment> employeeDepartments) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (employeeDepartments.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (EmployeeDepartment employeeDepartment : employeeDepartments) {
			if (entityCache.getResult(
					EmployeeDepartmentImpl.class,
					employeeDepartment.getPrimaryKey()) == null) {

				cacheResult(employeeDepartment);
			}
		}
	}

	/**
	 * Clears the cache for all employee departments.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(EmployeeDepartmentImpl.class);

		finderCache.clearCache(EmployeeDepartmentImpl.class);
	}

	/**
	 * Clears the cache for the employee department.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EmployeeDepartment employeeDepartment) {
		entityCache.removeResult(
			EmployeeDepartmentImpl.class, employeeDepartment);
	}

	@Override
	public void clearCache(List<EmployeeDepartment> employeeDepartments) {
		for (EmployeeDepartment employeeDepartment : employeeDepartments) {
			entityCache.removeResult(
				EmployeeDepartmentImpl.class, employeeDepartment);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(EmployeeDepartmentImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(EmployeeDepartmentImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		EmployeeDepartmentModelImpl employeeDepartmentModelImpl) {

		Object[] args = new Object[] {
			employeeDepartmentModelImpl.getUuid(),
			employeeDepartmentModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathFetchByUUID_G, args, employeeDepartmentModelImpl);

		args = new Object[] {employeeDepartmentModelImpl.getEmployeeId()};

		finderCache.putResult(
			_finderPathFetchByEmployeeId, args, employeeDepartmentModelImpl);

		args = new Object[] {
			employeeDepartmentModelImpl.getDepartmentMasterId(),
			employeeDepartmentModelImpl.isStatus(),
			employeeDepartmentModelImpl.getEmployeeId()
		};

		finderCache.putResult(
			_finderPathFetchByEmployeeIdAndStatusAndDepartmentMasterId, args,
			employeeDepartmentModelImpl);
	}

	/**
	 * Creates a new employee department with the primary key. Does not add the employee department to the database.
	 *
	 * @param employeeDepartmentId the primary key for the new employee department
	 * @return the new employee department
	 */
	@Override
	public EmployeeDepartment create(long employeeDepartmentId) {
		EmployeeDepartment employeeDepartment = new EmployeeDepartmentImpl();

		employeeDepartment.setNew(true);
		employeeDepartment.setPrimaryKey(employeeDepartmentId);

		String uuid = PortalUUIDUtil.generate();

		employeeDepartment.setUuid(uuid);

		employeeDepartment.setCompanyId(CompanyThreadLocal.getCompanyId());

		return employeeDepartment;
	}

	/**
	 * Removes the employee department with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeDepartmentId the primary key of the employee department
	 * @return the employee department that was removed
	 * @throws NoSuchEmployeeDepartmentException if a employee department with the primary key could not be found
	 */
	@Override
	public EmployeeDepartment remove(long employeeDepartmentId)
		throws NoSuchEmployeeDepartmentException {

		return remove((Serializable)employeeDepartmentId);
	}

	/**
	 * Removes the employee department with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the employee department
	 * @return the employee department that was removed
	 * @throws NoSuchEmployeeDepartmentException if a employee department with the primary key could not be found
	 */
	@Override
	public EmployeeDepartment remove(Serializable primaryKey)
		throws NoSuchEmployeeDepartmentException {

		Session session = null;

		try {
			session = openSession();

			EmployeeDepartment employeeDepartment =
				(EmployeeDepartment)session.get(
					EmployeeDepartmentImpl.class, primaryKey);

			if (employeeDepartment == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEmployeeDepartmentException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(employeeDepartment);
		}
		catch (NoSuchEmployeeDepartmentException noSuchEntityException) {
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
	protected EmployeeDepartment removeImpl(
		EmployeeDepartment employeeDepartment) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(employeeDepartment)) {
				employeeDepartment = (EmployeeDepartment)session.get(
					EmployeeDepartmentImpl.class,
					employeeDepartment.getPrimaryKeyObj());
			}

			if (employeeDepartment != null) {
				session.delete(employeeDepartment);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (employeeDepartment != null) {
			clearCache(employeeDepartment);
		}

		return employeeDepartment;
	}

	@Override
	public EmployeeDepartment updateImpl(
		EmployeeDepartment employeeDepartment) {

		boolean isNew = employeeDepartment.isNew();

		if (!(employeeDepartment instanceof EmployeeDepartmentModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(employeeDepartment.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					employeeDepartment);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in employeeDepartment proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom EmployeeDepartment implementation " +
					employeeDepartment.getClass());
		}

		EmployeeDepartmentModelImpl employeeDepartmentModelImpl =
			(EmployeeDepartmentModelImpl)employeeDepartment;

		if (Validator.isNull(employeeDepartment.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			employeeDepartment.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (employeeDepartment.getCreateDate() == null)) {
			if (serviceContext == null) {
				employeeDepartment.setCreateDate(date);
			}
			else {
				employeeDepartment.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!employeeDepartmentModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				employeeDepartment.setModifiedDate(date);
			}
			else {
				employeeDepartment.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(employeeDepartment);
			}
			else {
				employeeDepartment = (EmployeeDepartment)session.merge(
					employeeDepartment);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			EmployeeDepartmentImpl.class, employeeDepartmentModelImpl, false,
			true);

		cacheUniqueFindersCache(employeeDepartmentModelImpl);

		if (isNew) {
			employeeDepartment.setNew(false);
		}

		employeeDepartment.resetOriginalValues();

		return employeeDepartment;
	}

	/**
	 * Returns the employee department with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the employee department
	 * @return the employee department
	 * @throws NoSuchEmployeeDepartmentException if a employee department with the primary key could not be found
	 */
	@Override
	public EmployeeDepartment findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEmployeeDepartmentException {

		EmployeeDepartment employeeDepartment = fetchByPrimaryKey(primaryKey);

		if (employeeDepartment == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEmployeeDepartmentException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return employeeDepartment;
	}

	/**
	 * Returns the employee department with the primary key or throws a <code>NoSuchEmployeeDepartmentException</code> if it could not be found.
	 *
	 * @param employeeDepartmentId the primary key of the employee department
	 * @return the employee department
	 * @throws NoSuchEmployeeDepartmentException if a employee department with the primary key could not be found
	 */
	@Override
	public EmployeeDepartment findByPrimaryKey(long employeeDepartmentId)
		throws NoSuchEmployeeDepartmentException {

		return findByPrimaryKey((Serializable)employeeDepartmentId);
	}

	/**
	 * Returns the employee department with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeDepartmentId the primary key of the employee department
	 * @return the employee department, or <code>null</code> if a employee department with the primary key could not be found
	 */
	@Override
	public EmployeeDepartment fetchByPrimaryKey(long employeeDepartmentId) {
		return fetchByPrimaryKey((Serializable)employeeDepartmentId);
	}

	/**
	 * Returns all the employee departments.
	 *
	 * @return the employee departments
	 */
	@Override
	public List<EmployeeDepartment> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee departments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDepartmentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee departments
	 * @param end the upper bound of the range of employee departments (not inclusive)
	 * @return the range of employee departments
	 */
	@Override
	public List<EmployeeDepartment> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee departments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDepartmentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee departments
	 * @param end the upper bound of the range of employee departments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee departments
	 */
	@Override
	public List<EmployeeDepartment> findAll(
		int start, int end,
		OrderByComparator<EmployeeDepartment> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee departments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDepartmentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee departments
	 * @param end the upper bound of the range of employee departments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee departments
	 */
	@Override
	public List<EmployeeDepartment> findAll(
		int start, int end,
		OrderByComparator<EmployeeDepartment> orderByComparator,
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

		List<EmployeeDepartment> list = null;

		if (useFinderCache) {
			list = (List<EmployeeDepartment>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_EMPLOYEEDEPARTMENT);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_EMPLOYEEDEPARTMENT;

				sql = sql.concat(EmployeeDepartmentModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<EmployeeDepartment>)QueryUtil.list(
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
	 * Removes all the employee departments from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (EmployeeDepartment employeeDepartment : findAll()) {
			remove(employeeDepartment);
		}
	}

	/**
	 * Returns the number of employee departments.
	 *
	 * @return the number of employee departments
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
					_SQL_COUNT_EMPLOYEEDEPARTMENT);

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
		return "employeeDepartmentId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_EMPLOYEEDEPARTMENT;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return EmployeeDepartmentModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the employee department persistence.
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

		_finderPathWithPaginationFindByEmployeeIdGetDepartments =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByEmployeeIdGetDepartments",
				new String[] {
					Long.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				},
				new String[] {"employeeId"}, true);

		_finderPathWithoutPaginationFindByEmployeeIdGetDepartments =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByEmployeeIdGetDepartments",
				new String[] {Long.class.getName()},
				new String[] {"employeeId"}, true);

		_finderPathCountByEmployeeIdGetDepartments = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByEmployeeIdGetDepartments",
			new String[] {Long.class.getName()}, new String[] {"employeeId"},
			false);

		_finderPathWithPaginationFindBydepartmentMasterId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBydepartmentMasterId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"departmentMasterId"}, true);

		_finderPathWithoutPaginationFindBydepartmentMasterId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBydepartmentMasterId", new String[] {Long.class.getName()},
			new String[] {"departmentMasterId"}, true);

		_finderPathCountBydepartmentMasterId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBydepartmentMasterId", new String[] {Long.class.getName()},
			new String[] {"departmentMasterId"}, false);

		_finderPathFetchByEmployeeIdAndStatusAndDepartmentMasterId =
			new FinderPath(
				FINDER_CLASS_NAME_ENTITY,
				"fetchByEmployeeIdAndStatusAndDepartmentMasterId",
				new String[] {
					Long.class.getName(), Boolean.class.getName(),
					Long.class.getName()
				},
				new String[] {"departmentMasterId", "status", "employeeId"},
				true);

		EmployeeDepartmentUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		EmployeeDepartmentUtil.setPersistence(null);

		entityCache.removeCache(EmployeeDepartmentImpl.class.getName());
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

	private static final String _SQL_SELECT_EMPLOYEEDEPARTMENT =
		"SELECT employeeDepartment FROM EmployeeDepartment employeeDepartment";

	private static final String _SQL_SELECT_EMPLOYEEDEPARTMENT_WHERE =
		"SELECT employeeDepartment FROM EmployeeDepartment employeeDepartment WHERE ";

	private static final String _SQL_COUNT_EMPLOYEEDEPARTMENT =
		"SELECT COUNT(employeeDepartment) FROM EmployeeDepartment employeeDepartment";

	private static final String _SQL_COUNT_EMPLOYEEDEPARTMENT_WHERE =
		"SELECT COUNT(employeeDepartment) FROM EmployeeDepartment employeeDepartment WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "employeeDepartment.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No EmployeeDepartment exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No EmployeeDepartment exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		EmployeeDepartmentPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}