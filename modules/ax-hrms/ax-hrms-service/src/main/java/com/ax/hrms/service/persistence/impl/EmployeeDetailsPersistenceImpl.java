/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence.impl;

import com.ax.hrms.exception.NoSuchEmployeeDetailsException;
import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.model.EmployeeDetailsTable;
import com.ax.hrms.model.impl.EmployeeDetailsImpl;
import com.ax.hrms.model.impl.EmployeeDetailsModelImpl;
import com.ax.hrms.service.persistence.EmployeeDetailsPersistence;
import com.ax.hrms.service.persistence.EmployeeDetailsUtil;
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

import java.sql.Timestamp;

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
 * The persistence implementation for the employee details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = EmployeeDetailsPersistence.class)
public class EmployeeDetailsPersistenceImpl
	extends BasePersistenceImpl<EmployeeDetails>
	implements EmployeeDetailsPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>EmployeeDetailsUtil</code> to access the employee details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		EmployeeDetailsImpl.class.getName();

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
	 * Returns all the employee detailses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching employee detailses
	 */
	@Override
	public List<EmployeeDetails> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee detailses
	 * @param end the upper bound of the range of employee detailses (not inclusive)
	 * @return the range of matching employee detailses
	 */
	@Override
	public List<EmployeeDetails> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee detailses
	 * @param end the upper bound of the range of employee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee detailses
	 */
	@Override
	public List<EmployeeDetails> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EmployeeDetails> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee detailses
	 * @param end the upper bound of the range of employee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee detailses
	 */
	@Override
	public List<EmployeeDetails> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EmployeeDetails> orderByComparator,
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

		List<EmployeeDetails> list = null;

		if (useFinderCache) {
			list = (List<EmployeeDetails>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EmployeeDetails employeeDetails : list) {
					if (!uuid.equals(employeeDetails.getUuid())) {
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

			sb.append(_SQL_SELECT_EMPLOYEEDETAILS_WHERE);

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
				sb.append(EmployeeDetailsModelImpl.ORDER_BY_JPQL);
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

				list = (List<EmployeeDetails>)QueryUtil.list(
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
	 * Returns the first employee details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee details
	 * @throws NoSuchEmployeeDetailsException if a matching employee details could not be found
	 */
	@Override
	public EmployeeDetails findByUuid_First(
			String uuid, OrderByComparator<EmployeeDetails> orderByComparator)
		throws NoSuchEmployeeDetailsException {

		EmployeeDetails employeeDetails = fetchByUuid_First(
			uuid, orderByComparator);

		if (employeeDetails != null) {
			return employeeDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchEmployeeDetailsException(sb.toString());
	}

	/**
	 * Returns the first employee details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee details, or <code>null</code> if a matching employee details could not be found
	 */
	@Override
	public EmployeeDetails fetchByUuid_First(
		String uuid, OrderByComparator<EmployeeDetails> orderByComparator) {

		List<EmployeeDetails> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee details
	 * @throws NoSuchEmployeeDetailsException if a matching employee details could not be found
	 */
	@Override
	public EmployeeDetails findByUuid_Last(
			String uuid, OrderByComparator<EmployeeDetails> orderByComparator)
		throws NoSuchEmployeeDetailsException {

		EmployeeDetails employeeDetails = fetchByUuid_Last(
			uuid, orderByComparator);

		if (employeeDetails != null) {
			return employeeDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchEmployeeDetailsException(sb.toString());
	}

	/**
	 * Returns the last employee details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee details, or <code>null</code> if a matching employee details could not be found
	 */
	@Override
	public EmployeeDetails fetchByUuid_Last(
		String uuid, OrderByComparator<EmployeeDetails> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<EmployeeDetails> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the employee detailses before and after the current employee details in the ordered set where uuid = &#63;.
	 *
	 * @param employeeId the primary key of the current employee details
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee details
	 * @throws NoSuchEmployeeDetailsException if a employee details with the primary key could not be found
	 */
	@Override
	public EmployeeDetails[] findByUuid_PrevAndNext(
			long employeeId, String uuid,
			OrderByComparator<EmployeeDetails> orderByComparator)
		throws NoSuchEmployeeDetailsException {

		uuid = Objects.toString(uuid, "");

		EmployeeDetails employeeDetails = findByPrimaryKey(employeeId);

		Session session = null;

		try {
			session = openSession();

			EmployeeDetails[] array = new EmployeeDetailsImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, employeeDetails, uuid, orderByComparator, true);

			array[1] = employeeDetails;

			array[2] = getByUuid_PrevAndNext(
				session, employeeDetails, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected EmployeeDetails getByUuid_PrevAndNext(
		Session session, EmployeeDetails employeeDetails, String uuid,
		OrderByComparator<EmployeeDetails> orderByComparator,
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

		sb.append(_SQL_SELECT_EMPLOYEEDETAILS_WHERE);

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
			sb.append(EmployeeDetailsModelImpl.ORDER_BY_JPQL);
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
						employeeDetails)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EmployeeDetails> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employee detailses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (EmployeeDetails employeeDetails :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(employeeDetails);
		}
	}

	/**
	 * Returns the number of employee detailses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching employee detailses
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EMPLOYEEDETAILS_WHERE);

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
		"employeeDetails.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(employeeDetails.uuid IS NULL OR employeeDetails.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the employee details where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchEmployeeDetailsException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching employee details
	 * @throws NoSuchEmployeeDetailsException if a matching employee details could not be found
	 */
	@Override
	public EmployeeDetails findByUUID_G(String uuid, long groupId)
		throws NoSuchEmployeeDetailsException {

		EmployeeDetails employeeDetails = fetchByUUID_G(uuid, groupId);

		if (employeeDetails == null) {
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

			throw new NoSuchEmployeeDetailsException(sb.toString());
		}

		return employeeDetails;
	}

	/**
	 * Returns the employee details where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching employee details, or <code>null</code> if a matching employee details could not be found
	 */
	@Override
	public EmployeeDetails fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the employee details where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching employee details, or <code>null</code> if a matching employee details could not be found
	 */
	@Override
	public EmployeeDetails fetchByUUID_G(
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

		if (result instanceof EmployeeDetails) {
			EmployeeDetails employeeDetails = (EmployeeDetails)result;

			if (!Objects.equals(uuid, employeeDetails.getUuid()) ||
				(groupId != employeeDetails.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_EMPLOYEEDETAILS_WHERE);

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

				List<EmployeeDetails> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					EmployeeDetails employeeDetails = list.get(0);

					result = employeeDetails;

					cacheResult(employeeDetails);
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
			return (EmployeeDetails)result;
		}
	}

	/**
	 * Removes the employee details where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the employee details that was removed
	 */
	@Override
	public EmployeeDetails removeByUUID_G(String uuid, long groupId)
		throws NoSuchEmployeeDetailsException {

		EmployeeDetails employeeDetails = findByUUID_G(uuid, groupId);

		return remove(employeeDetails);
	}

	/**
	 * Returns the number of employee detailses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching employee detailses
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_EMPLOYEEDETAILS_WHERE);

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
		"employeeDetails.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(employeeDetails.uuid IS NULL OR employeeDetails.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"employeeDetails.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the employee detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching employee detailses
	 */
	@Override
	public List<EmployeeDetails> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee detailses
	 * @param end the upper bound of the range of employee detailses (not inclusive)
	 * @return the range of matching employee detailses
	 */
	@Override
	public List<EmployeeDetails> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee detailses
	 * @param end the upper bound of the range of employee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee detailses
	 */
	@Override
	public List<EmployeeDetails> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EmployeeDetails> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee detailses
	 * @param end the upper bound of the range of employee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee detailses
	 */
	@Override
	public List<EmployeeDetails> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EmployeeDetails> orderByComparator,
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

		List<EmployeeDetails> list = null;

		if (useFinderCache) {
			list = (List<EmployeeDetails>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EmployeeDetails employeeDetails : list) {
					if (!uuid.equals(employeeDetails.getUuid()) ||
						(companyId != employeeDetails.getCompanyId())) {

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

			sb.append(_SQL_SELECT_EMPLOYEEDETAILS_WHERE);

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
				sb.append(EmployeeDetailsModelImpl.ORDER_BY_JPQL);
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

				list = (List<EmployeeDetails>)QueryUtil.list(
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
	 * Returns the first employee details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee details
	 * @throws NoSuchEmployeeDetailsException if a matching employee details could not be found
	 */
	@Override
	public EmployeeDetails findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<EmployeeDetails> orderByComparator)
		throws NoSuchEmployeeDetailsException {

		EmployeeDetails employeeDetails = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (employeeDetails != null) {
			return employeeDetails;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchEmployeeDetailsException(sb.toString());
	}

	/**
	 * Returns the first employee details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee details, or <code>null</code> if a matching employee details could not be found
	 */
	@Override
	public EmployeeDetails fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<EmployeeDetails> orderByComparator) {

		List<EmployeeDetails> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee details
	 * @throws NoSuchEmployeeDetailsException if a matching employee details could not be found
	 */
	@Override
	public EmployeeDetails findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<EmployeeDetails> orderByComparator)
		throws NoSuchEmployeeDetailsException {

		EmployeeDetails employeeDetails = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (employeeDetails != null) {
			return employeeDetails;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchEmployeeDetailsException(sb.toString());
	}

	/**
	 * Returns the last employee details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee details, or <code>null</code> if a matching employee details could not be found
	 */
	@Override
	public EmployeeDetails fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<EmployeeDetails> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<EmployeeDetails> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the employee detailses before and after the current employee details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param employeeId the primary key of the current employee details
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee details
	 * @throws NoSuchEmployeeDetailsException if a employee details with the primary key could not be found
	 */
	@Override
	public EmployeeDetails[] findByUuid_C_PrevAndNext(
			long employeeId, String uuid, long companyId,
			OrderByComparator<EmployeeDetails> orderByComparator)
		throws NoSuchEmployeeDetailsException {

		uuid = Objects.toString(uuid, "");

		EmployeeDetails employeeDetails = findByPrimaryKey(employeeId);

		Session session = null;

		try {
			session = openSession();

			EmployeeDetails[] array = new EmployeeDetailsImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, employeeDetails, uuid, companyId, orderByComparator,
				true);

			array[1] = employeeDetails;

			array[2] = getByUuid_C_PrevAndNext(
				session, employeeDetails, uuid, companyId, orderByComparator,
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

	protected EmployeeDetails getByUuid_C_PrevAndNext(
		Session session, EmployeeDetails employeeDetails, String uuid,
		long companyId, OrderByComparator<EmployeeDetails> orderByComparator,
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

		sb.append(_SQL_SELECT_EMPLOYEEDETAILS_WHERE);

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
			sb.append(EmployeeDetailsModelImpl.ORDER_BY_JPQL);
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
						employeeDetails)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EmployeeDetails> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employee detailses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (EmployeeDetails employeeDetails :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(employeeDetails);
		}
	}

	/**
	 * Returns the number of employee detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching employee detailses
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_EMPLOYEEDETAILS_WHERE);

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
		"employeeDetails.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(employeeDetails.uuid IS NULL OR employeeDetails.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"employeeDetails.companyId = ?";

	private FinderPath _finderPathFetchByEmployeeId;
	private FinderPath _finderPathCountByEmployeeId;

	/**
	 * Returns the employee details where employeeId = &#63; or throws a <code>NoSuchEmployeeDetailsException</code> if it could not be found.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee details
	 * @throws NoSuchEmployeeDetailsException if a matching employee details could not be found
	 */
	@Override
	public EmployeeDetails findByEmployeeId(long employeeId)
		throws NoSuchEmployeeDetailsException {

		EmployeeDetails employeeDetails = fetchByEmployeeId(employeeId);

		if (employeeDetails == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("employeeId=");
			sb.append(employeeId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchEmployeeDetailsException(sb.toString());
		}

		return employeeDetails;
	}

	/**
	 * Returns the employee details where employeeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee details, or <code>null</code> if a matching employee details could not be found
	 */
	@Override
	public EmployeeDetails fetchByEmployeeId(long employeeId) {
		return fetchByEmployeeId(employeeId, true);
	}

	/**
	 * Returns the employee details where employeeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param employeeId the employee ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching employee details, or <code>null</code> if a matching employee details could not be found
	 */
	@Override
	public EmployeeDetails fetchByEmployeeId(
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

		if (result instanceof EmployeeDetails) {
			EmployeeDetails employeeDetails = (EmployeeDetails)result;

			if (employeeId != employeeDetails.getEmployeeId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_EMPLOYEEDETAILS_WHERE);

			sb.append(_FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(employeeId);

				List<EmployeeDetails> list = query.list();

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
								"EmployeeDetailsPersistenceImpl.fetchByEmployeeId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					EmployeeDetails employeeDetails = list.get(0);

					result = employeeDetails;

					cacheResult(employeeDetails);
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
			return (EmployeeDetails)result;
		}
	}

	/**
	 * Removes the employee details where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 * @return the employee details that was removed
	 */
	@Override
	public EmployeeDetails removeByEmployeeId(long employeeId)
		throws NoSuchEmployeeDetailsException {

		EmployeeDetails employeeDetails = findByEmployeeId(employeeId);

		return remove(employeeDetails);
	}

	/**
	 * Returns the number of employee detailses where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee detailses
	 */
	@Override
	public int countByEmployeeId(long employeeId) {
		FinderPath finderPath = _finderPathCountByEmployeeId;

		Object[] finderArgs = new Object[] {employeeId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EMPLOYEEDETAILS_WHERE);

			sb.append(_FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2);

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

	private static final String _FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2 =
		"employeeDetails.employeeId = ?";

	private FinderPath _finderPathFetchByLrUserId;
	private FinderPath _finderPathCountByLrUserId;

	/**
	 * Returns the employee details where lrUserId = &#63; or throws a <code>NoSuchEmployeeDetailsException</code> if it could not be found.
	 *
	 * @param lrUserId the lr user ID
	 * @return the matching employee details
	 * @throws NoSuchEmployeeDetailsException if a matching employee details could not be found
	 */
	@Override
	public EmployeeDetails findByLrUserId(long lrUserId)
		throws NoSuchEmployeeDetailsException {

		EmployeeDetails employeeDetails = fetchByLrUserId(lrUserId);

		if (employeeDetails == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("lrUserId=");
			sb.append(lrUserId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchEmployeeDetailsException(sb.toString());
		}

		return employeeDetails;
	}

	/**
	 * Returns the employee details where lrUserId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param lrUserId the lr user ID
	 * @return the matching employee details, or <code>null</code> if a matching employee details could not be found
	 */
	@Override
	public EmployeeDetails fetchByLrUserId(long lrUserId) {
		return fetchByLrUserId(lrUserId, true);
	}

	/**
	 * Returns the employee details where lrUserId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param lrUserId the lr user ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching employee details, or <code>null</code> if a matching employee details could not be found
	 */
	@Override
	public EmployeeDetails fetchByLrUserId(
		long lrUserId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {lrUserId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByLrUserId, finderArgs, this);
		}

		if (result instanceof EmployeeDetails) {
			EmployeeDetails employeeDetails = (EmployeeDetails)result;

			if (lrUserId != employeeDetails.getLrUserId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_EMPLOYEEDETAILS_WHERE);

			sb.append(_FINDER_COLUMN_LRUSERID_LRUSERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(lrUserId);

				List<EmployeeDetails> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByLrUserId, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {lrUserId};
							}

							_log.warn(
								"EmployeeDetailsPersistenceImpl.fetchByLrUserId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					EmployeeDetails employeeDetails = list.get(0);

					result = employeeDetails;

					cacheResult(employeeDetails);
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
			return (EmployeeDetails)result;
		}
	}

	/**
	 * Removes the employee details where lrUserId = &#63; from the database.
	 *
	 * @param lrUserId the lr user ID
	 * @return the employee details that was removed
	 */
	@Override
	public EmployeeDetails removeByLrUserId(long lrUserId)
		throws NoSuchEmployeeDetailsException {

		EmployeeDetails employeeDetails = findByLrUserId(lrUserId);

		return remove(employeeDetails);
	}

	/**
	 * Returns the number of employee detailses where lrUserId = &#63;.
	 *
	 * @param lrUserId the lr user ID
	 * @return the number of matching employee detailses
	 */
	@Override
	public int countByLrUserId(long lrUserId) {
		FinderPath finderPath = _finderPathCountByLrUserId;

		Object[] finderArgs = new Object[] {lrUserId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EMPLOYEEDETAILS_WHERE);

			sb.append(_FINDER_COLUMN_LRUSERID_LRUSERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(lrUserId);

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

	private static final String _FINDER_COLUMN_LRUSERID_LRUSERID_2 =
		"employeeDetails.lrUserId = ?";

	private FinderPath _finderPathWithPaginationFindByLeavingDate;
	private FinderPath _finderPathWithoutPaginationFindByLeavingDate;
	private FinderPath _finderPathCountByLeavingDate;

	/**
	 * Returns all the employee detailses where leavingDate = &#63;.
	 *
	 * @param leavingDate the leaving date
	 * @return the matching employee detailses
	 */
	@Override
	public List<EmployeeDetails> findByLeavingDate(Date leavingDate) {
		return findByLeavingDate(
			leavingDate, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee detailses where leavingDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param leavingDate the leaving date
	 * @param start the lower bound of the range of employee detailses
	 * @param end the upper bound of the range of employee detailses (not inclusive)
	 * @return the range of matching employee detailses
	 */
	@Override
	public List<EmployeeDetails> findByLeavingDate(
		Date leavingDate, int start, int end) {

		return findByLeavingDate(leavingDate, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee detailses where leavingDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param leavingDate the leaving date
	 * @param start the lower bound of the range of employee detailses
	 * @param end the upper bound of the range of employee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee detailses
	 */
	@Override
	public List<EmployeeDetails> findByLeavingDate(
		Date leavingDate, int start, int end,
		OrderByComparator<EmployeeDetails> orderByComparator) {

		return findByLeavingDate(
			leavingDate, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee detailses where leavingDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param leavingDate the leaving date
	 * @param start the lower bound of the range of employee detailses
	 * @param end the upper bound of the range of employee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee detailses
	 */
	@Override
	public List<EmployeeDetails> findByLeavingDate(
		Date leavingDate, int start, int end,
		OrderByComparator<EmployeeDetails> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByLeavingDate;
				finderArgs = new Object[] {_getTime(leavingDate)};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByLeavingDate;
			finderArgs = new Object[] {
				_getTime(leavingDate), start, end, orderByComparator
			};
		}

		List<EmployeeDetails> list = null;

		if (useFinderCache) {
			list = (List<EmployeeDetails>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EmployeeDetails employeeDetails : list) {
					if (!Objects.equals(
							leavingDate, employeeDetails.getLeavingDate())) {

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

			sb.append(_SQL_SELECT_EMPLOYEEDETAILS_WHERE);

			boolean bindLeavingDate = false;

			if (leavingDate == null) {
				sb.append(_FINDER_COLUMN_LEAVINGDATE_LEAVINGDATE_1);
			}
			else {
				bindLeavingDate = true;

				sb.append(_FINDER_COLUMN_LEAVINGDATE_LEAVINGDATE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EmployeeDetailsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindLeavingDate) {
					queryPos.add(new Timestamp(leavingDate.getTime()));
				}

				list = (List<EmployeeDetails>)QueryUtil.list(
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
	 * Returns the first employee details in the ordered set where leavingDate = &#63;.
	 *
	 * @param leavingDate the leaving date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee details
	 * @throws NoSuchEmployeeDetailsException if a matching employee details could not be found
	 */
	@Override
	public EmployeeDetails findByLeavingDate_First(
			Date leavingDate,
			OrderByComparator<EmployeeDetails> orderByComparator)
		throws NoSuchEmployeeDetailsException {

		EmployeeDetails employeeDetails = fetchByLeavingDate_First(
			leavingDate, orderByComparator);

		if (employeeDetails != null) {
			return employeeDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("leavingDate=");
		sb.append(leavingDate);

		sb.append("}");

		throw new NoSuchEmployeeDetailsException(sb.toString());
	}

	/**
	 * Returns the first employee details in the ordered set where leavingDate = &#63;.
	 *
	 * @param leavingDate the leaving date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee details, or <code>null</code> if a matching employee details could not be found
	 */
	@Override
	public EmployeeDetails fetchByLeavingDate_First(
		Date leavingDate,
		OrderByComparator<EmployeeDetails> orderByComparator) {

		List<EmployeeDetails> list = findByLeavingDate(
			leavingDate, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee details in the ordered set where leavingDate = &#63;.
	 *
	 * @param leavingDate the leaving date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee details
	 * @throws NoSuchEmployeeDetailsException if a matching employee details could not be found
	 */
	@Override
	public EmployeeDetails findByLeavingDate_Last(
			Date leavingDate,
			OrderByComparator<EmployeeDetails> orderByComparator)
		throws NoSuchEmployeeDetailsException {

		EmployeeDetails employeeDetails = fetchByLeavingDate_Last(
			leavingDate, orderByComparator);

		if (employeeDetails != null) {
			return employeeDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("leavingDate=");
		sb.append(leavingDate);

		sb.append("}");

		throw new NoSuchEmployeeDetailsException(sb.toString());
	}

	/**
	 * Returns the last employee details in the ordered set where leavingDate = &#63;.
	 *
	 * @param leavingDate the leaving date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee details, or <code>null</code> if a matching employee details could not be found
	 */
	@Override
	public EmployeeDetails fetchByLeavingDate_Last(
		Date leavingDate,
		OrderByComparator<EmployeeDetails> orderByComparator) {

		int count = countByLeavingDate(leavingDate);

		if (count == 0) {
			return null;
		}

		List<EmployeeDetails> list = findByLeavingDate(
			leavingDate, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the employee detailses before and after the current employee details in the ordered set where leavingDate = &#63;.
	 *
	 * @param employeeId the primary key of the current employee details
	 * @param leavingDate the leaving date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee details
	 * @throws NoSuchEmployeeDetailsException if a employee details with the primary key could not be found
	 */
	@Override
	public EmployeeDetails[] findByLeavingDate_PrevAndNext(
			long employeeId, Date leavingDate,
			OrderByComparator<EmployeeDetails> orderByComparator)
		throws NoSuchEmployeeDetailsException {

		EmployeeDetails employeeDetails = findByPrimaryKey(employeeId);

		Session session = null;

		try {
			session = openSession();

			EmployeeDetails[] array = new EmployeeDetailsImpl[3];

			array[0] = getByLeavingDate_PrevAndNext(
				session, employeeDetails, leavingDate, orderByComparator, true);

			array[1] = employeeDetails;

			array[2] = getByLeavingDate_PrevAndNext(
				session, employeeDetails, leavingDate, orderByComparator,
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

	protected EmployeeDetails getByLeavingDate_PrevAndNext(
		Session session, EmployeeDetails employeeDetails, Date leavingDate,
		OrderByComparator<EmployeeDetails> orderByComparator,
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

		sb.append(_SQL_SELECT_EMPLOYEEDETAILS_WHERE);

		boolean bindLeavingDate = false;

		if (leavingDate == null) {
			sb.append(_FINDER_COLUMN_LEAVINGDATE_LEAVINGDATE_1);
		}
		else {
			bindLeavingDate = true;

			sb.append(_FINDER_COLUMN_LEAVINGDATE_LEAVINGDATE_2);
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
			sb.append(EmployeeDetailsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindLeavingDate) {
			queryPos.add(new Timestamp(leavingDate.getTime()));
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						employeeDetails)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EmployeeDetails> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employee detailses where leavingDate = &#63; from the database.
	 *
	 * @param leavingDate the leaving date
	 */
	@Override
	public void removeByLeavingDate(Date leavingDate) {
		for (EmployeeDetails employeeDetails :
				findByLeavingDate(
					leavingDate, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(employeeDetails);
		}
	}

	/**
	 * Returns the number of employee detailses where leavingDate = &#63;.
	 *
	 * @param leavingDate the leaving date
	 * @return the number of matching employee detailses
	 */
	@Override
	public int countByLeavingDate(Date leavingDate) {
		FinderPath finderPath = _finderPathCountByLeavingDate;

		Object[] finderArgs = new Object[] {_getTime(leavingDate)};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EMPLOYEEDETAILS_WHERE);

			boolean bindLeavingDate = false;

			if (leavingDate == null) {
				sb.append(_FINDER_COLUMN_LEAVINGDATE_LEAVINGDATE_1);
			}
			else {
				bindLeavingDate = true;

				sb.append(_FINDER_COLUMN_LEAVINGDATE_LEAVINGDATE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindLeavingDate) {
					queryPos.add(new Timestamp(leavingDate.getTime()));
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

	private static final String _FINDER_COLUMN_LEAVINGDATE_LEAVINGDATE_1 =
		"employeeDetails.leavingDate IS NULL";

	private static final String _FINDER_COLUMN_LEAVINGDATE_LEAVINGDATE_2 =
		"employeeDetails.leavingDate = ?";

	private FinderPath _finderPathWithPaginationFindByEmployeeName;
	private FinderPath _finderPathWithoutPaginationFindByEmployeeName;
	private FinderPath _finderPathCountByEmployeeName;

	/**
	 * Returns all the employee detailses where firstName = &#63; and lastName = &#63;.
	 *
	 * @param firstName the first name
	 * @param lastName the last name
	 * @return the matching employee detailses
	 */
	@Override
	public List<EmployeeDetails> findByEmployeeName(
		String firstName, String lastName) {

		return findByEmployeeName(
			firstName, lastName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee detailses where firstName = &#63; and lastName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param start the lower bound of the range of employee detailses
	 * @param end the upper bound of the range of employee detailses (not inclusive)
	 * @return the range of matching employee detailses
	 */
	@Override
	public List<EmployeeDetails> findByEmployeeName(
		String firstName, String lastName, int start, int end) {

		return findByEmployeeName(firstName, lastName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee detailses where firstName = &#63; and lastName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param start the lower bound of the range of employee detailses
	 * @param end the upper bound of the range of employee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee detailses
	 */
	@Override
	public List<EmployeeDetails> findByEmployeeName(
		String firstName, String lastName, int start, int end,
		OrderByComparator<EmployeeDetails> orderByComparator) {

		return findByEmployeeName(
			firstName, lastName, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee detailses where firstName = &#63; and lastName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param start the lower bound of the range of employee detailses
	 * @param end the upper bound of the range of employee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee detailses
	 */
	@Override
	public List<EmployeeDetails> findByEmployeeName(
		String firstName, String lastName, int start, int end,
		OrderByComparator<EmployeeDetails> orderByComparator,
		boolean useFinderCache) {

		firstName = Objects.toString(firstName, "");
		lastName = Objects.toString(lastName, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByEmployeeName;
				finderArgs = new Object[] {firstName, lastName};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByEmployeeName;
			finderArgs = new Object[] {
				firstName, lastName, start, end, orderByComparator
			};
		}

		List<EmployeeDetails> list = null;

		if (useFinderCache) {
			list = (List<EmployeeDetails>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EmployeeDetails employeeDetails : list) {
					if (!firstName.equals(employeeDetails.getFirstName()) ||
						!lastName.equals(employeeDetails.getLastName())) {

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

			sb.append(_SQL_SELECT_EMPLOYEEDETAILS_WHERE);

			boolean bindFirstName = false;

			if (firstName.isEmpty()) {
				sb.append(_FINDER_COLUMN_EMPLOYEENAME_FIRSTNAME_3);
			}
			else {
				bindFirstName = true;

				sb.append(_FINDER_COLUMN_EMPLOYEENAME_FIRSTNAME_2);
			}

			boolean bindLastName = false;

			if (lastName.isEmpty()) {
				sb.append(_FINDER_COLUMN_EMPLOYEENAME_LASTNAME_3);
			}
			else {
				bindLastName = true;

				sb.append(_FINDER_COLUMN_EMPLOYEENAME_LASTNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EmployeeDetailsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindFirstName) {
					queryPos.add(firstName);
				}

				if (bindLastName) {
					queryPos.add(lastName);
				}

				list = (List<EmployeeDetails>)QueryUtil.list(
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
	 * Returns the first employee details in the ordered set where firstName = &#63; and lastName = &#63;.
	 *
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee details
	 * @throws NoSuchEmployeeDetailsException if a matching employee details could not be found
	 */
	@Override
	public EmployeeDetails findByEmployeeName_First(
			String firstName, String lastName,
			OrderByComparator<EmployeeDetails> orderByComparator)
		throws NoSuchEmployeeDetailsException {

		EmployeeDetails employeeDetails = fetchByEmployeeName_First(
			firstName, lastName, orderByComparator);

		if (employeeDetails != null) {
			return employeeDetails;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("firstName=");
		sb.append(firstName);

		sb.append(", lastName=");
		sb.append(lastName);

		sb.append("}");

		throw new NoSuchEmployeeDetailsException(sb.toString());
	}

	/**
	 * Returns the first employee details in the ordered set where firstName = &#63; and lastName = &#63;.
	 *
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee details, or <code>null</code> if a matching employee details could not be found
	 */
	@Override
	public EmployeeDetails fetchByEmployeeName_First(
		String firstName, String lastName,
		OrderByComparator<EmployeeDetails> orderByComparator) {

		List<EmployeeDetails> list = findByEmployeeName(
			firstName, lastName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee details in the ordered set where firstName = &#63; and lastName = &#63;.
	 *
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee details
	 * @throws NoSuchEmployeeDetailsException if a matching employee details could not be found
	 */
	@Override
	public EmployeeDetails findByEmployeeName_Last(
			String firstName, String lastName,
			OrderByComparator<EmployeeDetails> orderByComparator)
		throws NoSuchEmployeeDetailsException {

		EmployeeDetails employeeDetails = fetchByEmployeeName_Last(
			firstName, lastName, orderByComparator);

		if (employeeDetails != null) {
			return employeeDetails;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("firstName=");
		sb.append(firstName);

		sb.append(", lastName=");
		sb.append(lastName);

		sb.append("}");

		throw new NoSuchEmployeeDetailsException(sb.toString());
	}

	/**
	 * Returns the last employee details in the ordered set where firstName = &#63; and lastName = &#63;.
	 *
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee details, or <code>null</code> if a matching employee details could not be found
	 */
	@Override
	public EmployeeDetails fetchByEmployeeName_Last(
		String firstName, String lastName,
		OrderByComparator<EmployeeDetails> orderByComparator) {

		int count = countByEmployeeName(firstName, lastName);

		if (count == 0) {
			return null;
		}

		List<EmployeeDetails> list = findByEmployeeName(
			firstName, lastName, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the employee detailses before and after the current employee details in the ordered set where firstName = &#63; and lastName = &#63;.
	 *
	 * @param employeeId the primary key of the current employee details
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee details
	 * @throws NoSuchEmployeeDetailsException if a employee details with the primary key could not be found
	 */
	@Override
	public EmployeeDetails[] findByEmployeeName_PrevAndNext(
			long employeeId, String firstName, String lastName,
			OrderByComparator<EmployeeDetails> orderByComparator)
		throws NoSuchEmployeeDetailsException {

		firstName = Objects.toString(firstName, "");
		lastName = Objects.toString(lastName, "");

		EmployeeDetails employeeDetails = findByPrimaryKey(employeeId);

		Session session = null;

		try {
			session = openSession();

			EmployeeDetails[] array = new EmployeeDetailsImpl[3];

			array[0] = getByEmployeeName_PrevAndNext(
				session, employeeDetails, firstName, lastName,
				orderByComparator, true);

			array[1] = employeeDetails;

			array[2] = getByEmployeeName_PrevAndNext(
				session, employeeDetails, firstName, lastName,
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

	protected EmployeeDetails getByEmployeeName_PrevAndNext(
		Session session, EmployeeDetails employeeDetails, String firstName,
		String lastName, OrderByComparator<EmployeeDetails> orderByComparator,
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

		sb.append(_SQL_SELECT_EMPLOYEEDETAILS_WHERE);

		boolean bindFirstName = false;

		if (firstName.isEmpty()) {
			sb.append(_FINDER_COLUMN_EMPLOYEENAME_FIRSTNAME_3);
		}
		else {
			bindFirstName = true;

			sb.append(_FINDER_COLUMN_EMPLOYEENAME_FIRSTNAME_2);
		}

		boolean bindLastName = false;

		if (lastName.isEmpty()) {
			sb.append(_FINDER_COLUMN_EMPLOYEENAME_LASTNAME_3);
		}
		else {
			bindLastName = true;

			sb.append(_FINDER_COLUMN_EMPLOYEENAME_LASTNAME_2);
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
			sb.append(EmployeeDetailsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindFirstName) {
			queryPos.add(firstName);
		}

		if (bindLastName) {
			queryPos.add(lastName);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						employeeDetails)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EmployeeDetails> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employee detailses where firstName = &#63; and lastName = &#63; from the database.
	 *
	 * @param firstName the first name
	 * @param lastName the last name
	 */
	@Override
	public void removeByEmployeeName(String firstName, String lastName) {
		for (EmployeeDetails employeeDetails :
				findByEmployeeName(
					firstName, lastName, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(employeeDetails);
		}
	}

	/**
	 * Returns the number of employee detailses where firstName = &#63; and lastName = &#63;.
	 *
	 * @param firstName the first name
	 * @param lastName the last name
	 * @return the number of matching employee detailses
	 */
	@Override
	public int countByEmployeeName(String firstName, String lastName) {
		firstName = Objects.toString(firstName, "");
		lastName = Objects.toString(lastName, "");

		FinderPath finderPath = _finderPathCountByEmployeeName;

		Object[] finderArgs = new Object[] {firstName, lastName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_EMPLOYEEDETAILS_WHERE);

			boolean bindFirstName = false;

			if (firstName.isEmpty()) {
				sb.append(_FINDER_COLUMN_EMPLOYEENAME_FIRSTNAME_3);
			}
			else {
				bindFirstName = true;

				sb.append(_FINDER_COLUMN_EMPLOYEENAME_FIRSTNAME_2);
			}

			boolean bindLastName = false;

			if (lastName.isEmpty()) {
				sb.append(_FINDER_COLUMN_EMPLOYEENAME_LASTNAME_3);
			}
			else {
				bindLastName = true;

				sb.append(_FINDER_COLUMN_EMPLOYEENAME_LASTNAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindFirstName) {
					queryPos.add(firstName);
				}

				if (bindLastName) {
					queryPos.add(lastName);
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

	private static final String _FINDER_COLUMN_EMPLOYEENAME_FIRSTNAME_2 =
		"employeeDetails.firstName = ? AND ";

	private static final String _FINDER_COLUMN_EMPLOYEENAME_FIRSTNAME_3 =
		"(employeeDetails.firstName IS NULL OR employeeDetails.firstName = '') AND ";

	private static final String _FINDER_COLUMN_EMPLOYEENAME_LASTNAME_2 =
		"employeeDetails.lastName = ?";

	private static final String _FINDER_COLUMN_EMPLOYEENAME_LASTNAME_3 =
		"(employeeDetails.lastName IS NULL OR employeeDetails.lastName = '')";

	private FinderPath _finderPathWithPaginationFindByIsTerminated;
	private FinderPath _finderPathWithoutPaginationFindByIsTerminated;
	private FinderPath _finderPathCountByIsTerminated;

	/**
	 * Returns all the employee detailses where isTerminated = &#63;.
	 *
	 * @param isTerminated the is terminated
	 * @return the matching employee detailses
	 */
	@Override
	public List<EmployeeDetails> findByIsTerminated(boolean isTerminated) {
		return findByIsTerminated(
			isTerminated, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee detailses where isTerminated = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param isTerminated the is terminated
	 * @param start the lower bound of the range of employee detailses
	 * @param end the upper bound of the range of employee detailses (not inclusive)
	 * @return the range of matching employee detailses
	 */
	@Override
	public List<EmployeeDetails> findByIsTerminated(
		boolean isTerminated, int start, int end) {

		return findByIsTerminated(isTerminated, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee detailses where isTerminated = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param isTerminated the is terminated
	 * @param start the lower bound of the range of employee detailses
	 * @param end the upper bound of the range of employee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee detailses
	 */
	@Override
	public List<EmployeeDetails> findByIsTerminated(
		boolean isTerminated, int start, int end,
		OrderByComparator<EmployeeDetails> orderByComparator) {

		return findByIsTerminated(
			isTerminated, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee detailses where isTerminated = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param isTerminated the is terminated
	 * @param start the lower bound of the range of employee detailses
	 * @param end the upper bound of the range of employee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee detailses
	 */
	@Override
	public List<EmployeeDetails> findByIsTerminated(
		boolean isTerminated, int start, int end,
		OrderByComparator<EmployeeDetails> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByIsTerminated;
				finderArgs = new Object[] {isTerminated};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByIsTerminated;
			finderArgs = new Object[] {
				isTerminated, start, end, orderByComparator
			};
		}

		List<EmployeeDetails> list = null;

		if (useFinderCache) {
			list = (List<EmployeeDetails>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EmployeeDetails employeeDetails : list) {
					if (isTerminated != employeeDetails.isIsTerminated()) {
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

			sb.append(_SQL_SELECT_EMPLOYEEDETAILS_WHERE);

			sb.append(_FINDER_COLUMN_ISTERMINATED_ISTERMINATED_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EmployeeDetailsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(isTerminated);

				list = (List<EmployeeDetails>)QueryUtil.list(
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
	 * Returns the first employee details in the ordered set where isTerminated = &#63;.
	 *
	 * @param isTerminated the is terminated
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee details
	 * @throws NoSuchEmployeeDetailsException if a matching employee details could not be found
	 */
	@Override
	public EmployeeDetails findByIsTerminated_First(
			boolean isTerminated,
			OrderByComparator<EmployeeDetails> orderByComparator)
		throws NoSuchEmployeeDetailsException {

		EmployeeDetails employeeDetails = fetchByIsTerminated_First(
			isTerminated, orderByComparator);

		if (employeeDetails != null) {
			return employeeDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("isTerminated=");
		sb.append(isTerminated);

		sb.append("}");

		throw new NoSuchEmployeeDetailsException(sb.toString());
	}

	/**
	 * Returns the first employee details in the ordered set where isTerminated = &#63;.
	 *
	 * @param isTerminated the is terminated
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee details, or <code>null</code> if a matching employee details could not be found
	 */
	@Override
	public EmployeeDetails fetchByIsTerminated_First(
		boolean isTerminated,
		OrderByComparator<EmployeeDetails> orderByComparator) {

		List<EmployeeDetails> list = findByIsTerminated(
			isTerminated, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee details in the ordered set where isTerminated = &#63;.
	 *
	 * @param isTerminated the is terminated
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee details
	 * @throws NoSuchEmployeeDetailsException if a matching employee details could not be found
	 */
	@Override
	public EmployeeDetails findByIsTerminated_Last(
			boolean isTerminated,
			OrderByComparator<EmployeeDetails> orderByComparator)
		throws NoSuchEmployeeDetailsException {

		EmployeeDetails employeeDetails = fetchByIsTerminated_Last(
			isTerminated, orderByComparator);

		if (employeeDetails != null) {
			return employeeDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("isTerminated=");
		sb.append(isTerminated);

		sb.append("}");

		throw new NoSuchEmployeeDetailsException(sb.toString());
	}

	/**
	 * Returns the last employee details in the ordered set where isTerminated = &#63;.
	 *
	 * @param isTerminated the is terminated
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee details, or <code>null</code> if a matching employee details could not be found
	 */
	@Override
	public EmployeeDetails fetchByIsTerminated_Last(
		boolean isTerminated,
		OrderByComparator<EmployeeDetails> orderByComparator) {

		int count = countByIsTerminated(isTerminated);

		if (count == 0) {
			return null;
		}

		List<EmployeeDetails> list = findByIsTerminated(
			isTerminated, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the employee detailses before and after the current employee details in the ordered set where isTerminated = &#63;.
	 *
	 * @param employeeId the primary key of the current employee details
	 * @param isTerminated the is terminated
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee details
	 * @throws NoSuchEmployeeDetailsException if a employee details with the primary key could not be found
	 */
	@Override
	public EmployeeDetails[] findByIsTerminated_PrevAndNext(
			long employeeId, boolean isTerminated,
			OrderByComparator<EmployeeDetails> orderByComparator)
		throws NoSuchEmployeeDetailsException {

		EmployeeDetails employeeDetails = findByPrimaryKey(employeeId);

		Session session = null;

		try {
			session = openSession();

			EmployeeDetails[] array = new EmployeeDetailsImpl[3];

			array[0] = getByIsTerminated_PrevAndNext(
				session, employeeDetails, isTerminated, orderByComparator,
				true);

			array[1] = employeeDetails;

			array[2] = getByIsTerminated_PrevAndNext(
				session, employeeDetails, isTerminated, orderByComparator,
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

	protected EmployeeDetails getByIsTerminated_PrevAndNext(
		Session session, EmployeeDetails employeeDetails, boolean isTerminated,
		OrderByComparator<EmployeeDetails> orderByComparator,
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

		sb.append(_SQL_SELECT_EMPLOYEEDETAILS_WHERE);

		sb.append(_FINDER_COLUMN_ISTERMINATED_ISTERMINATED_2);

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
			sb.append(EmployeeDetailsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(isTerminated);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						employeeDetails)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EmployeeDetails> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employee detailses where isTerminated = &#63; from the database.
	 *
	 * @param isTerminated the is terminated
	 */
	@Override
	public void removeByIsTerminated(boolean isTerminated) {
		for (EmployeeDetails employeeDetails :
				findByIsTerminated(
					isTerminated, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(employeeDetails);
		}
	}

	/**
	 * Returns the number of employee detailses where isTerminated = &#63;.
	 *
	 * @param isTerminated the is terminated
	 * @return the number of matching employee detailses
	 */
	@Override
	public int countByIsTerminated(boolean isTerminated) {
		FinderPath finderPath = _finderPathCountByIsTerminated;

		Object[] finderArgs = new Object[] {isTerminated};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EMPLOYEEDETAILS_WHERE);

			sb.append(_FINDER_COLUMN_ISTERMINATED_ISTERMINATED_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(isTerminated);

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

	private static final String _FINDER_COLUMN_ISTERMINATED_ISTERMINATED_2 =
		"employeeDetails.isTerminated = ?";

	public EmployeeDetailsPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(EmployeeDetails.class);

		setModelImplClass(EmployeeDetailsImpl.class);
		setModelPKClass(long.class);

		setTable(EmployeeDetailsTable.INSTANCE);
	}

	/**
	 * Caches the employee details in the entity cache if it is enabled.
	 *
	 * @param employeeDetails the employee details
	 */
	@Override
	public void cacheResult(EmployeeDetails employeeDetails) {
		entityCache.putResult(
			EmployeeDetailsImpl.class, employeeDetails.getPrimaryKey(),
			employeeDetails);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				employeeDetails.getUuid(), employeeDetails.getGroupId()
			},
			employeeDetails);

		finderCache.putResult(
			_finderPathFetchByEmployeeId,
			new Object[] {employeeDetails.getEmployeeId()}, employeeDetails);

		finderCache.putResult(
			_finderPathFetchByLrUserId,
			new Object[] {employeeDetails.getLrUserId()}, employeeDetails);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the employee detailses in the entity cache if it is enabled.
	 *
	 * @param employeeDetailses the employee detailses
	 */
	@Override
	public void cacheResult(List<EmployeeDetails> employeeDetailses) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (employeeDetailses.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (EmployeeDetails employeeDetails : employeeDetailses) {
			if (entityCache.getResult(
					EmployeeDetailsImpl.class,
					employeeDetails.getPrimaryKey()) == null) {

				cacheResult(employeeDetails);
			}
		}
	}

	/**
	 * Clears the cache for all employee detailses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(EmployeeDetailsImpl.class);

		finderCache.clearCache(EmployeeDetailsImpl.class);
	}

	/**
	 * Clears the cache for the employee details.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EmployeeDetails employeeDetails) {
		entityCache.removeResult(EmployeeDetailsImpl.class, employeeDetails);
	}

	@Override
	public void clearCache(List<EmployeeDetails> employeeDetailses) {
		for (EmployeeDetails employeeDetails : employeeDetailses) {
			entityCache.removeResult(
				EmployeeDetailsImpl.class, employeeDetails);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(EmployeeDetailsImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(EmployeeDetailsImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		EmployeeDetailsModelImpl employeeDetailsModelImpl) {

		Object[] args = new Object[] {
			employeeDetailsModelImpl.getUuid(),
			employeeDetailsModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, employeeDetailsModelImpl);

		args = new Object[] {employeeDetailsModelImpl.getEmployeeId()};

		finderCache.putResult(
			_finderPathCountByEmployeeId, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByEmployeeId, args, employeeDetailsModelImpl);

		args = new Object[] {employeeDetailsModelImpl.getLrUserId()};

		finderCache.putResult(
			_finderPathCountByLrUserId, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByLrUserId, args, employeeDetailsModelImpl);
	}

	/**
	 * Creates a new employee details with the primary key. Does not add the employee details to the database.
	 *
	 * @param employeeId the primary key for the new employee details
	 * @return the new employee details
	 */
	@Override
	public EmployeeDetails create(long employeeId) {
		EmployeeDetails employeeDetails = new EmployeeDetailsImpl();

		employeeDetails.setNew(true);
		employeeDetails.setPrimaryKey(employeeId);

		String uuid = PortalUUIDUtil.generate();

		employeeDetails.setUuid(uuid);

		employeeDetails.setCompanyId(CompanyThreadLocal.getCompanyId());

		return employeeDetails;
	}

	/**
	 * Removes the employee details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeId the primary key of the employee details
	 * @return the employee details that was removed
	 * @throws NoSuchEmployeeDetailsException if a employee details with the primary key could not be found
	 */
	@Override
	public EmployeeDetails remove(long employeeId)
		throws NoSuchEmployeeDetailsException {

		return remove((Serializable)employeeId);
	}

	/**
	 * Removes the employee details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the employee details
	 * @return the employee details that was removed
	 * @throws NoSuchEmployeeDetailsException if a employee details with the primary key could not be found
	 */
	@Override
	public EmployeeDetails remove(Serializable primaryKey)
		throws NoSuchEmployeeDetailsException {

		Session session = null;

		try {
			session = openSession();

			EmployeeDetails employeeDetails = (EmployeeDetails)session.get(
				EmployeeDetailsImpl.class, primaryKey);

			if (employeeDetails == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEmployeeDetailsException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(employeeDetails);
		}
		catch (NoSuchEmployeeDetailsException noSuchEntityException) {
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
	protected EmployeeDetails removeImpl(EmployeeDetails employeeDetails) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(employeeDetails)) {
				employeeDetails = (EmployeeDetails)session.get(
					EmployeeDetailsImpl.class,
					employeeDetails.getPrimaryKeyObj());
			}

			if (employeeDetails != null) {
				session.delete(employeeDetails);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (employeeDetails != null) {
			clearCache(employeeDetails);
		}

		return employeeDetails;
	}

	@Override
	public EmployeeDetails updateImpl(EmployeeDetails employeeDetails) {
		boolean isNew = employeeDetails.isNew();

		if (!(employeeDetails instanceof EmployeeDetailsModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(employeeDetails.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					employeeDetails);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in employeeDetails proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom EmployeeDetails implementation " +
					employeeDetails.getClass());
		}

		EmployeeDetailsModelImpl employeeDetailsModelImpl =
			(EmployeeDetailsModelImpl)employeeDetails;

		if (Validator.isNull(employeeDetails.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			employeeDetails.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (employeeDetails.getCreateDate() == null)) {
			if (serviceContext == null) {
				employeeDetails.setCreateDate(date);
			}
			else {
				employeeDetails.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!employeeDetailsModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				employeeDetails.setModifiedDate(date);
			}
			else {
				employeeDetails.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(employeeDetails);
			}
			else {
				employeeDetails = (EmployeeDetails)session.merge(
					employeeDetails);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			EmployeeDetailsImpl.class, employeeDetailsModelImpl, false, true);

		cacheUniqueFindersCache(employeeDetailsModelImpl);

		if (isNew) {
			employeeDetails.setNew(false);
		}

		employeeDetails.resetOriginalValues();

		return employeeDetails;
	}

	/**
	 * Returns the employee details with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the employee details
	 * @return the employee details
	 * @throws NoSuchEmployeeDetailsException if a employee details with the primary key could not be found
	 */
	@Override
	public EmployeeDetails findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEmployeeDetailsException {

		EmployeeDetails employeeDetails = fetchByPrimaryKey(primaryKey);

		if (employeeDetails == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEmployeeDetailsException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return employeeDetails;
	}

	/**
	 * Returns the employee details with the primary key or throws a <code>NoSuchEmployeeDetailsException</code> if it could not be found.
	 *
	 * @param employeeId the primary key of the employee details
	 * @return the employee details
	 * @throws NoSuchEmployeeDetailsException if a employee details with the primary key could not be found
	 */
	@Override
	public EmployeeDetails findByPrimaryKey(long employeeId)
		throws NoSuchEmployeeDetailsException {

		return findByPrimaryKey((Serializable)employeeId);
	}

	/**
	 * Returns the employee details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeId the primary key of the employee details
	 * @return the employee details, or <code>null</code> if a employee details with the primary key could not be found
	 */
	@Override
	public EmployeeDetails fetchByPrimaryKey(long employeeId) {
		return fetchByPrimaryKey((Serializable)employeeId);
	}

	/**
	 * Returns all the employee detailses.
	 *
	 * @return the employee detailses
	 */
	@Override
	public List<EmployeeDetails> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee detailses
	 * @param end the upper bound of the range of employee detailses (not inclusive)
	 * @return the range of employee detailses
	 */
	@Override
	public List<EmployeeDetails> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee detailses
	 * @param end the upper bound of the range of employee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee detailses
	 */
	@Override
	public List<EmployeeDetails> findAll(
		int start, int end,
		OrderByComparator<EmployeeDetails> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee detailses
	 * @param end the upper bound of the range of employee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee detailses
	 */
	@Override
	public List<EmployeeDetails> findAll(
		int start, int end,
		OrderByComparator<EmployeeDetails> orderByComparator,
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

		List<EmployeeDetails> list = null;

		if (useFinderCache) {
			list = (List<EmployeeDetails>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_EMPLOYEEDETAILS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_EMPLOYEEDETAILS;

				sql = sql.concat(EmployeeDetailsModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<EmployeeDetails>)QueryUtil.list(
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
	 * Removes all the employee detailses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (EmployeeDetails employeeDetails : findAll()) {
			remove(employeeDetails);
		}
	}

	/**
	 * Returns the number of employee detailses.
	 *
	 * @return the number of employee detailses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_EMPLOYEEDETAILS);

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
		return "employeeId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_EMPLOYEEDETAILS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return EmployeeDetailsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the employee details persistence.
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

		_finderPathFetchByEmployeeId = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByEmployeeId",
			new String[] {Long.class.getName()}, new String[] {"employeeId"},
			true);

		_finderPathCountByEmployeeId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEmployeeId",
			new String[] {Long.class.getName()}, new String[] {"employeeId"},
			false);

		_finderPathFetchByLrUserId = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByLrUserId",
			new String[] {Long.class.getName()}, new String[] {"lrUserId"},
			true);

		_finderPathCountByLrUserId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLrUserId",
			new String[] {Long.class.getName()}, new String[] {"lrUserId"},
			false);

		_finderPathWithPaginationFindByLeavingDate = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLeavingDate",
			new String[] {
				Date.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"leavingDate"}, true);

		_finderPathWithoutPaginationFindByLeavingDate = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByLeavingDate",
			new String[] {Date.class.getName()}, new String[] {"leavingDate"},
			true);

		_finderPathCountByLeavingDate = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLeavingDate",
			new String[] {Date.class.getName()}, new String[] {"leavingDate"},
			false);

		_finderPathWithPaginationFindByEmployeeName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByEmployeeName",
			new String[] {
				String.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"firstName", "lastName"}, true);

		_finderPathWithoutPaginationFindByEmployeeName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByEmployeeName",
			new String[] {String.class.getName(), String.class.getName()},
			new String[] {"firstName", "lastName"}, true);

		_finderPathCountByEmployeeName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEmployeeName",
			new String[] {String.class.getName(), String.class.getName()},
			new String[] {"firstName", "lastName"}, false);

		_finderPathWithPaginationFindByIsTerminated = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByIsTerminated",
			new String[] {
				Boolean.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"isTerminated"}, true);

		_finderPathWithoutPaginationFindByIsTerminated = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByIsTerminated",
			new String[] {Boolean.class.getName()},
			new String[] {"isTerminated"}, true);

		_finderPathCountByIsTerminated = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByIsTerminated",
			new String[] {Boolean.class.getName()},
			new String[] {"isTerminated"}, false);

		EmployeeDetailsUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		EmployeeDetailsUtil.setPersistence(null);

		entityCache.removeCache(EmployeeDetailsImpl.class.getName());
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

	private static final String _SQL_SELECT_EMPLOYEEDETAILS =
		"SELECT employeeDetails FROM EmployeeDetails employeeDetails";

	private static final String _SQL_SELECT_EMPLOYEEDETAILS_WHERE =
		"SELECT employeeDetails FROM EmployeeDetails employeeDetails WHERE ";

	private static final String _SQL_COUNT_EMPLOYEEDETAILS =
		"SELECT COUNT(employeeDetails) FROM EmployeeDetails employeeDetails";

	private static final String _SQL_COUNT_EMPLOYEEDETAILS_WHERE =
		"SELECT COUNT(employeeDetails) FROM EmployeeDetails employeeDetails WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "employeeDetails.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No EmployeeDetails exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No EmployeeDetails exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		EmployeeDetailsPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}