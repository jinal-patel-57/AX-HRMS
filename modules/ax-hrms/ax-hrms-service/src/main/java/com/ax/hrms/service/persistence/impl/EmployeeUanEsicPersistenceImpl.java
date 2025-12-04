/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence.impl;

import com.ax.hrms.exception.NoSuchEmployeeUanEsicException;
import com.ax.hrms.model.EmployeeUanEsic;
import com.ax.hrms.model.EmployeeUanEsicTable;
import com.ax.hrms.model.impl.EmployeeUanEsicImpl;
import com.ax.hrms.model.impl.EmployeeUanEsicModelImpl;
import com.ax.hrms.service.persistence.EmployeeUanEsicPersistence;
import com.ax.hrms.service.persistence.EmployeeUanEsicUtil;
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
 * The persistence implementation for the employee uan esic service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = EmployeeUanEsicPersistence.class)
public class EmployeeUanEsicPersistenceImpl
	extends BasePersistenceImpl<EmployeeUanEsic>
	implements EmployeeUanEsicPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>EmployeeUanEsicUtil</code> to access the employee uan esic persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		EmployeeUanEsicImpl.class.getName();

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
	 * Returns all the employee uan esics where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching employee uan esics
	 */
	@Override
	public List<EmployeeUanEsic> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee uan esics where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeUanEsicModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee uan esics
	 * @param end the upper bound of the range of employee uan esics (not inclusive)
	 * @return the range of matching employee uan esics
	 */
	@Override
	public List<EmployeeUanEsic> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee uan esics where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeUanEsicModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee uan esics
	 * @param end the upper bound of the range of employee uan esics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee uan esics
	 */
	@Override
	public List<EmployeeUanEsic> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EmployeeUanEsic> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee uan esics where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeUanEsicModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee uan esics
	 * @param end the upper bound of the range of employee uan esics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee uan esics
	 */
	@Override
	public List<EmployeeUanEsic> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EmployeeUanEsic> orderByComparator,
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

		List<EmployeeUanEsic> list = null;

		if (useFinderCache) {
			list = (List<EmployeeUanEsic>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EmployeeUanEsic employeeUanEsic : list) {
					if (!uuid.equals(employeeUanEsic.getUuid())) {
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

			sb.append(_SQL_SELECT_EMPLOYEEUANESIC_WHERE);

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
				sb.append(EmployeeUanEsicModelImpl.ORDER_BY_JPQL);
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

				list = (List<EmployeeUanEsic>)QueryUtil.list(
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
	 * Returns the first employee uan esic in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee uan esic
	 * @throws NoSuchEmployeeUanEsicException if a matching employee uan esic could not be found
	 */
	@Override
	public EmployeeUanEsic findByUuid_First(
			String uuid, OrderByComparator<EmployeeUanEsic> orderByComparator)
		throws NoSuchEmployeeUanEsicException {

		EmployeeUanEsic employeeUanEsic = fetchByUuid_First(
			uuid, orderByComparator);

		if (employeeUanEsic != null) {
			return employeeUanEsic;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchEmployeeUanEsicException(sb.toString());
	}

	/**
	 * Returns the first employee uan esic in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee uan esic, or <code>null</code> if a matching employee uan esic could not be found
	 */
	@Override
	public EmployeeUanEsic fetchByUuid_First(
		String uuid, OrderByComparator<EmployeeUanEsic> orderByComparator) {

		List<EmployeeUanEsic> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee uan esic in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee uan esic
	 * @throws NoSuchEmployeeUanEsicException if a matching employee uan esic could not be found
	 */
	@Override
	public EmployeeUanEsic findByUuid_Last(
			String uuid, OrderByComparator<EmployeeUanEsic> orderByComparator)
		throws NoSuchEmployeeUanEsicException {

		EmployeeUanEsic employeeUanEsic = fetchByUuid_Last(
			uuid, orderByComparator);

		if (employeeUanEsic != null) {
			return employeeUanEsic;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchEmployeeUanEsicException(sb.toString());
	}

	/**
	 * Returns the last employee uan esic in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee uan esic, or <code>null</code> if a matching employee uan esic could not be found
	 */
	@Override
	public EmployeeUanEsic fetchByUuid_Last(
		String uuid, OrderByComparator<EmployeeUanEsic> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<EmployeeUanEsic> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the employee uan esics before and after the current employee uan esic in the ordered set where uuid = &#63;.
	 *
	 * @param uanEsicId the primary key of the current employee uan esic
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee uan esic
	 * @throws NoSuchEmployeeUanEsicException if a employee uan esic with the primary key could not be found
	 */
	@Override
	public EmployeeUanEsic[] findByUuid_PrevAndNext(
			long uanEsicId, String uuid,
			OrderByComparator<EmployeeUanEsic> orderByComparator)
		throws NoSuchEmployeeUanEsicException {

		uuid = Objects.toString(uuid, "");

		EmployeeUanEsic employeeUanEsic = findByPrimaryKey(uanEsicId);

		Session session = null;

		try {
			session = openSession();

			EmployeeUanEsic[] array = new EmployeeUanEsicImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, employeeUanEsic, uuid, orderByComparator, true);

			array[1] = employeeUanEsic;

			array[2] = getByUuid_PrevAndNext(
				session, employeeUanEsic, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected EmployeeUanEsic getByUuid_PrevAndNext(
		Session session, EmployeeUanEsic employeeUanEsic, String uuid,
		OrderByComparator<EmployeeUanEsic> orderByComparator,
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

		sb.append(_SQL_SELECT_EMPLOYEEUANESIC_WHERE);

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
			sb.append(EmployeeUanEsicModelImpl.ORDER_BY_JPQL);
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
						employeeUanEsic)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EmployeeUanEsic> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employee uan esics where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (EmployeeUanEsic employeeUanEsic :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(employeeUanEsic);
		}
	}

	/**
	 * Returns the number of employee uan esics where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching employee uan esics
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EMPLOYEEUANESIC_WHERE);

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
		"employeeUanEsic.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(employeeUanEsic.uuid IS NULL OR employeeUanEsic.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;

	/**
	 * Returns the employee uan esic where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchEmployeeUanEsicException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching employee uan esic
	 * @throws NoSuchEmployeeUanEsicException if a matching employee uan esic could not be found
	 */
	@Override
	public EmployeeUanEsic findByUUID_G(String uuid, long groupId)
		throws NoSuchEmployeeUanEsicException {

		EmployeeUanEsic employeeUanEsic = fetchByUUID_G(uuid, groupId);

		if (employeeUanEsic == null) {
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

			throw new NoSuchEmployeeUanEsicException(sb.toString());
		}

		return employeeUanEsic;
	}

	/**
	 * Returns the employee uan esic where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching employee uan esic, or <code>null</code> if a matching employee uan esic could not be found
	 */
	@Override
	public EmployeeUanEsic fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the employee uan esic where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching employee uan esic, or <code>null</code> if a matching employee uan esic could not be found
	 */
	@Override
	public EmployeeUanEsic fetchByUUID_G(
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

		if (result instanceof EmployeeUanEsic) {
			EmployeeUanEsic employeeUanEsic = (EmployeeUanEsic)result;

			if (!Objects.equals(uuid, employeeUanEsic.getUuid()) ||
				(groupId != employeeUanEsic.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_EMPLOYEEUANESIC_WHERE);

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

				List<EmployeeUanEsic> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					EmployeeUanEsic employeeUanEsic = list.get(0);

					result = employeeUanEsic;

					cacheResult(employeeUanEsic);
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
			return (EmployeeUanEsic)result;
		}
	}

	/**
	 * Removes the employee uan esic where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the employee uan esic that was removed
	 */
	@Override
	public EmployeeUanEsic removeByUUID_G(String uuid, long groupId)
		throws NoSuchEmployeeUanEsicException {

		EmployeeUanEsic employeeUanEsic = findByUUID_G(uuid, groupId);

		return remove(employeeUanEsic);
	}

	/**
	 * Returns the number of employee uan esics where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching employee uan esics
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		EmployeeUanEsic employeeUanEsic = fetchByUUID_G(uuid, groupId);

		if (employeeUanEsic == null) {
			return 0;
		}

		return 1;
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"employeeUanEsic.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(employeeUanEsic.uuid IS NULL OR employeeUanEsic.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"employeeUanEsic.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the employee uan esics where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching employee uan esics
	 */
	@Override
	public List<EmployeeUanEsic> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee uan esics where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeUanEsicModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee uan esics
	 * @param end the upper bound of the range of employee uan esics (not inclusive)
	 * @return the range of matching employee uan esics
	 */
	@Override
	public List<EmployeeUanEsic> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee uan esics where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeUanEsicModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee uan esics
	 * @param end the upper bound of the range of employee uan esics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee uan esics
	 */
	@Override
	public List<EmployeeUanEsic> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EmployeeUanEsic> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee uan esics where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeUanEsicModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee uan esics
	 * @param end the upper bound of the range of employee uan esics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee uan esics
	 */
	@Override
	public List<EmployeeUanEsic> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EmployeeUanEsic> orderByComparator,
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

		List<EmployeeUanEsic> list = null;

		if (useFinderCache) {
			list = (List<EmployeeUanEsic>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EmployeeUanEsic employeeUanEsic : list) {
					if (!uuid.equals(employeeUanEsic.getUuid()) ||
						(companyId != employeeUanEsic.getCompanyId())) {

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

			sb.append(_SQL_SELECT_EMPLOYEEUANESIC_WHERE);

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
				sb.append(EmployeeUanEsicModelImpl.ORDER_BY_JPQL);
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

				list = (List<EmployeeUanEsic>)QueryUtil.list(
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
	 * Returns the first employee uan esic in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee uan esic
	 * @throws NoSuchEmployeeUanEsicException if a matching employee uan esic could not be found
	 */
	@Override
	public EmployeeUanEsic findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<EmployeeUanEsic> orderByComparator)
		throws NoSuchEmployeeUanEsicException {

		EmployeeUanEsic employeeUanEsic = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (employeeUanEsic != null) {
			return employeeUanEsic;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchEmployeeUanEsicException(sb.toString());
	}

	/**
	 * Returns the first employee uan esic in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee uan esic, or <code>null</code> if a matching employee uan esic could not be found
	 */
	@Override
	public EmployeeUanEsic fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<EmployeeUanEsic> orderByComparator) {

		List<EmployeeUanEsic> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee uan esic in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee uan esic
	 * @throws NoSuchEmployeeUanEsicException if a matching employee uan esic could not be found
	 */
	@Override
	public EmployeeUanEsic findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<EmployeeUanEsic> orderByComparator)
		throws NoSuchEmployeeUanEsicException {

		EmployeeUanEsic employeeUanEsic = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (employeeUanEsic != null) {
			return employeeUanEsic;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchEmployeeUanEsicException(sb.toString());
	}

	/**
	 * Returns the last employee uan esic in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee uan esic, or <code>null</code> if a matching employee uan esic could not be found
	 */
	@Override
	public EmployeeUanEsic fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<EmployeeUanEsic> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<EmployeeUanEsic> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the employee uan esics before and after the current employee uan esic in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uanEsicId the primary key of the current employee uan esic
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee uan esic
	 * @throws NoSuchEmployeeUanEsicException if a employee uan esic with the primary key could not be found
	 */
	@Override
	public EmployeeUanEsic[] findByUuid_C_PrevAndNext(
			long uanEsicId, String uuid, long companyId,
			OrderByComparator<EmployeeUanEsic> orderByComparator)
		throws NoSuchEmployeeUanEsicException {

		uuid = Objects.toString(uuid, "");

		EmployeeUanEsic employeeUanEsic = findByPrimaryKey(uanEsicId);

		Session session = null;

		try {
			session = openSession();

			EmployeeUanEsic[] array = new EmployeeUanEsicImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, employeeUanEsic, uuid, companyId, orderByComparator,
				true);

			array[1] = employeeUanEsic;

			array[2] = getByUuid_C_PrevAndNext(
				session, employeeUanEsic, uuid, companyId, orderByComparator,
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

	protected EmployeeUanEsic getByUuid_C_PrevAndNext(
		Session session, EmployeeUanEsic employeeUanEsic, String uuid,
		long companyId, OrderByComparator<EmployeeUanEsic> orderByComparator,
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

		sb.append(_SQL_SELECT_EMPLOYEEUANESIC_WHERE);

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
			sb.append(EmployeeUanEsicModelImpl.ORDER_BY_JPQL);
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
						employeeUanEsic)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EmployeeUanEsic> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employee uan esics where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (EmployeeUanEsic employeeUanEsic :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(employeeUanEsic);
		}
	}

	/**
	 * Returns the number of employee uan esics where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching employee uan esics
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_EMPLOYEEUANESIC_WHERE);

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
		"employeeUanEsic.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(employeeUanEsic.uuid IS NULL OR employeeUanEsic.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"employeeUanEsic.companyId = ?";

	public EmployeeUanEsicPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(EmployeeUanEsic.class);

		setModelImplClass(EmployeeUanEsicImpl.class);
		setModelPKClass(long.class);

		setTable(EmployeeUanEsicTable.INSTANCE);
	}

	/**
	 * Caches the employee uan esic in the entity cache if it is enabled.
	 *
	 * @param employeeUanEsic the employee uan esic
	 */
	@Override
	public void cacheResult(EmployeeUanEsic employeeUanEsic) {
		entityCache.putResult(
			EmployeeUanEsicImpl.class, employeeUanEsic.getPrimaryKey(),
			employeeUanEsic);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				employeeUanEsic.getUuid(), employeeUanEsic.getGroupId()
			},
			employeeUanEsic);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the employee uan esics in the entity cache if it is enabled.
	 *
	 * @param employeeUanEsics the employee uan esics
	 */
	@Override
	public void cacheResult(List<EmployeeUanEsic> employeeUanEsics) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (employeeUanEsics.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (EmployeeUanEsic employeeUanEsic : employeeUanEsics) {
			if (entityCache.getResult(
					EmployeeUanEsicImpl.class,
					employeeUanEsic.getPrimaryKey()) == null) {

				cacheResult(employeeUanEsic);
			}
		}
	}

	/**
	 * Clears the cache for all employee uan esics.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(EmployeeUanEsicImpl.class);

		finderCache.clearCache(EmployeeUanEsicImpl.class);
	}

	/**
	 * Clears the cache for the employee uan esic.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EmployeeUanEsic employeeUanEsic) {
		entityCache.removeResult(EmployeeUanEsicImpl.class, employeeUanEsic);
	}

	@Override
	public void clearCache(List<EmployeeUanEsic> employeeUanEsics) {
		for (EmployeeUanEsic employeeUanEsic : employeeUanEsics) {
			entityCache.removeResult(
				EmployeeUanEsicImpl.class, employeeUanEsic);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(EmployeeUanEsicImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(EmployeeUanEsicImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		EmployeeUanEsicModelImpl employeeUanEsicModelImpl) {

		Object[] args = new Object[] {
			employeeUanEsicModelImpl.getUuid(),
			employeeUanEsicModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathFetchByUUID_G, args, employeeUanEsicModelImpl);
	}

	/**
	 * Creates a new employee uan esic with the primary key. Does not add the employee uan esic to the database.
	 *
	 * @param uanEsicId the primary key for the new employee uan esic
	 * @return the new employee uan esic
	 */
	@Override
	public EmployeeUanEsic create(long uanEsicId) {
		EmployeeUanEsic employeeUanEsic = new EmployeeUanEsicImpl();

		employeeUanEsic.setNew(true);
		employeeUanEsic.setPrimaryKey(uanEsicId);

		String uuid = PortalUUIDUtil.generate();

		employeeUanEsic.setUuid(uuid);

		employeeUanEsic.setCompanyId(CompanyThreadLocal.getCompanyId());

		return employeeUanEsic;
	}

	/**
	 * Removes the employee uan esic with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param uanEsicId the primary key of the employee uan esic
	 * @return the employee uan esic that was removed
	 * @throws NoSuchEmployeeUanEsicException if a employee uan esic with the primary key could not be found
	 */
	@Override
	public EmployeeUanEsic remove(long uanEsicId)
		throws NoSuchEmployeeUanEsicException {

		return remove((Serializable)uanEsicId);
	}

	/**
	 * Removes the employee uan esic with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the employee uan esic
	 * @return the employee uan esic that was removed
	 * @throws NoSuchEmployeeUanEsicException if a employee uan esic with the primary key could not be found
	 */
	@Override
	public EmployeeUanEsic remove(Serializable primaryKey)
		throws NoSuchEmployeeUanEsicException {

		Session session = null;

		try {
			session = openSession();

			EmployeeUanEsic employeeUanEsic = (EmployeeUanEsic)session.get(
				EmployeeUanEsicImpl.class, primaryKey);

			if (employeeUanEsic == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEmployeeUanEsicException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(employeeUanEsic);
		}
		catch (NoSuchEmployeeUanEsicException noSuchEntityException) {
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
	protected EmployeeUanEsic removeImpl(EmployeeUanEsic employeeUanEsic) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(employeeUanEsic)) {
				employeeUanEsic = (EmployeeUanEsic)session.get(
					EmployeeUanEsicImpl.class,
					employeeUanEsic.getPrimaryKeyObj());
			}

			if (employeeUanEsic != null) {
				session.delete(employeeUanEsic);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (employeeUanEsic != null) {
			clearCache(employeeUanEsic);
		}

		return employeeUanEsic;
	}

	@Override
	public EmployeeUanEsic updateImpl(EmployeeUanEsic employeeUanEsic) {
		boolean isNew = employeeUanEsic.isNew();

		if (!(employeeUanEsic instanceof EmployeeUanEsicModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(employeeUanEsic.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					employeeUanEsic);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in employeeUanEsic proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom EmployeeUanEsic implementation " +
					employeeUanEsic.getClass());
		}

		EmployeeUanEsicModelImpl employeeUanEsicModelImpl =
			(EmployeeUanEsicModelImpl)employeeUanEsic;

		if (Validator.isNull(employeeUanEsic.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			employeeUanEsic.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (employeeUanEsic.getCreateDate() == null)) {
			if (serviceContext == null) {
				employeeUanEsic.setCreateDate(date);
			}
			else {
				employeeUanEsic.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!employeeUanEsicModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				employeeUanEsic.setModifiedDate(date);
			}
			else {
				employeeUanEsic.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(employeeUanEsic);
			}
			else {
				employeeUanEsic = (EmployeeUanEsic)session.merge(
					employeeUanEsic);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			EmployeeUanEsicImpl.class, employeeUanEsicModelImpl, false, true);

		cacheUniqueFindersCache(employeeUanEsicModelImpl);

		if (isNew) {
			employeeUanEsic.setNew(false);
		}

		employeeUanEsic.resetOriginalValues();

		return employeeUanEsic;
	}

	/**
	 * Returns the employee uan esic with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the employee uan esic
	 * @return the employee uan esic
	 * @throws NoSuchEmployeeUanEsicException if a employee uan esic with the primary key could not be found
	 */
	@Override
	public EmployeeUanEsic findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEmployeeUanEsicException {

		EmployeeUanEsic employeeUanEsic = fetchByPrimaryKey(primaryKey);

		if (employeeUanEsic == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEmployeeUanEsicException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return employeeUanEsic;
	}

	/**
	 * Returns the employee uan esic with the primary key or throws a <code>NoSuchEmployeeUanEsicException</code> if it could not be found.
	 *
	 * @param uanEsicId the primary key of the employee uan esic
	 * @return the employee uan esic
	 * @throws NoSuchEmployeeUanEsicException if a employee uan esic with the primary key could not be found
	 */
	@Override
	public EmployeeUanEsic findByPrimaryKey(long uanEsicId)
		throws NoSuchEmployeeUanEsicException {

		return findByPrimaryKey((Serializable)uanEsicId);
	}

	/**
	 * Returns the employee uan esic with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param uanEsicId the primary key of the employee uan esic
	 * @return the employee uan esic, or <code>null</code> if a employee uan esic with the primary key could not be found
	 */
	@Override
	public EmployeeUanEsic fetchByPrimaryKey(long uanEsicId) {
		return fetchByPrimaryKey((Serializable)uanEsicId);
	}

	/**
	 * Returns all the employee uan esics.
	 *
	 * @return the employee uan esics
	 */
	@Override
	public List<EmployeeUanEsic> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee uan esics.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeUanEsicModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee uan esics
	 * @param end the upper bound of the range of employee uan esics (not inclusive)
	 * @return the range of employee uan esics
	 */
	@Override
	public List<EmployeeUanEsic> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee uan esics.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeUanEsicModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee uan esics
	 * @param end the upper bound of the range of employee uan esics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee uan esics
	 */
	@Override
	public List<EmployeeUanEsic> findAll(
		int start, int end,
		OrderByComparator<EmployeeUanEsic> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee uan esics.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeUanEsicModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee uan esics
	 * @param end the upper bound of the range of employee uan esics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee uan esics
	 */
	@Override
	public List<EmployeeUanEsic> findAll(
		int start, int end,
		OrderByComparator<EmployeeUanEsic> orderByComparator,
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

		List<EmployeeUanEsic> list = null;

		if (useFinderCache) {
			list = (List<EmployeeUanEsic>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_EMPLOYEEUANESIC);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_EMPLOYEEUANESIC;

				sql = sql.concat(EmployeeUanEsicModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<EmployeeUanEsic>)QueryUtil.list(
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
	 * Removes all the employee uan esics from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (EmployeeUanEsic employeeUanEsic : findAll()) {
			remove(employeeUanEsic);
		}
	}

	/**
	 * Returns the number of employee uan esics.
	 *
	 * @return the number of employee uan esics
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_EMPLOYEEUANESIC);

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
		return "uanEsicId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_EMPLOYEEUANESIC;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return EmployeeUanEsicModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the employee uan esic persistence.
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

		EmployeeUanEsicUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		EmployeeUanEsicUtil.setPersistence(null);

		entityCache.removeCache(EmployeeUanEsicImpl.class.getName());
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

	private static final String _SQL_SELECT_EMPLOYEEUANESIC =
		"SELECT employeeUanEsic FROM EmployeeUanEsic employeeUanEsic";

	private static final String _SQL_SELECT_EMPLOYEEUANESIC_WHERE =
		"SELECT employeeUanEsic FROM EmployeeUanEsic employeeUanEsic WHERE ";

	private static final String _SQL_COUNT_EMPLOYEEUANESIC =
		"SELECT COUNT(employeeUanEsic) FROM EmployeeUanEsic employeeUanEsic";

	private static final String _SQL_COUNT_EMPLOYEEUANESIC_WHERE =
		"SELECT COUNT(employeeUanEsic) FROM EmployeeUanEsic employeeUanEsic WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "employeeUanEsic.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No EmployeeUanEsic exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No EmployeeUanEsic exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		EmployeeUanEsicPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}