/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence.impl;

import com.ax.hrms.exception.NoSuchEmployeeBankAccountException;
import com.ax.hrms.model.EmployeeBankAccount;
import com.ax.hrms.model.EmployeeBankAccountTable;
import com.ax.hrms.model.impl.EmployeeBankAccountImpl;
import com.ax.hrms.model.impl.EmployeeBankAccountModelImpl;
import com.ax.hrms.service.persistence.EmployeeBankAccountPersistence;
import com.ax.hrms.service.persistence.EmployeeBankAccountUtil;
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
 * The persistence implementation for the employee bank account service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = EmployeeBankAccountPersistence.class)
public class EmployeeBankAccountPersistenceImpl
	extends BasePersistenceImpl<EmployeeBankAccount>
	implements EmployeeBankAccountPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>EmployeeBankAccountUtil</code> to access the employee bank account persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		EmployeeBankAccountImpl.class.getName();

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
	 * Returns all the employee bank accounts where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching employee bank accounts
	 */
	@Override
	public List<EmployeeBankAccount> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee bank accounts where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeBankAccountModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee bank accounts
	 * @param end the upper bound of the range of employee bank accounts (not inclusive)
	 * @return the range of matching employee bank accounts
	 */
	@Override
	public List<EmployeeBankAccount> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee bank accounts where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeBankAccountModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee bank accounts
	 * @param end the upper bound of the range of employee bank accounts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee bank accounts
	 */
	@Override
	public List<EmployeeBankAccount> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EmployeeBankAccount> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee bank accounts where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeBankAccountModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee bank accounts
	 * @param end the upper bound of the range of employee bank accounts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee bank accounts
	 */
	@Override
	public List<EmployeeBankAccount> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EmployeeBankAccount> orderByComparator,
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

		List<EmployeeBankAccount> list = null;

		if (useFinderCache) {
			list = (List<EmployeeBankAccount>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EmployeeBankAccount employeeBankAccount : list) {
					if (!uuid.equals(employeeBankAccount.getUuid())) {
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

			sb.append(_SQL_SELECT_EMPLOYEEBANKACCOUNT_WHERE);

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
				sb.append(EmployeeBankAccountModelImpl.ORDER_BY_JPQL);
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

				list = (List<EmployeeBankAccount>)QueryUtil.list(
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
	 * Returns the first employee bank account in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee bank account
	 * @throws NoSuchEmployeeBankAccountException if a matching employee bank account could not be found
	 */
	@Override
	public EmployeeBankAccount findByUuid_First(
			String uuid,
			OrderByComparator<EmployeeBankAccount> orderByComparator)
		throws NoSuchEmployeeBankAccountException {

		EmployeeBankAccount employeeBankAccount = fetchByUuid_First(
			uuid, orderByComparator);

		if (employeeBankAccount != null) {
			return employeeBankAccount;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchEmployeeBankAccountException(sb.toString());
	}

	/**
	 * Returns the first employee bank account in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee bank account, or <code>null</code> if a matching employee bank account could not be found
	 */
	@Override
	public EmployeeBankAccount fetchByUuid_First(
		String uuid, OrderByComparator<EmployeeBankAccount> orderByComparator) {

		List<EmployeeBankAccount> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee bank account in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee bank account
	 * @throws NoSuchEmployeeBankAccountException if a matching employee bank account could not be found
	 */
	@Override
	public EmployeeBankAccount findByUuid_Last(
			String uuid,
			OrderByComparator<EmployeeBankAccount> orderByComparator)
		throws NoSuchEmployeeBankAccountException {

		EmployeeBankAccount employeeBankAccount = fetchByUuid_Last(
			uuid, orderByComparator);

		if (employeeBankAccount != null) {
			return employeeBankAccount;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchEmployeeBankAccountException(sb.toString());
	}

	/**
	 * Returns the last employee bank account in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee bank account, or <code>null</code> if a matching employee bank account could not be found
	 */
	@Override
	public EmployeeBankAccount fetchByUuid_Last(
		String uuid, OrderByComparator<EmployeeBankAccount> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<EmployeeBankAccount> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the employee bank accounts before and after the current employee bank account in the ordered set where uuid = &#63;.
	 *
	 * @param bankAccountId the primary key of the current employee bank account
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee bank account
	 * @throws NoSuchEmployeeBankAccountException if a employee bank account with the primary key could not be found
	 */
	@Override
	public EmployeeBankAccount[] findByUuid_PrevAndNext(
			long bankAccountId, String uuid,
			OrderByComparator<EmployeeBankAccount> orderByComparator)
		throws NoSuchEmployeeBankAccountException {

		uuid = Objects.toString(uuid, "");

		EmployeeBankAccount employeeBankAccount = findByPrimaryKey(
			bankAccountId);

		Session session = null;

		try {
			session = openSession();

			EmployeeBankAccount[] array = new EmployeeBankAccountImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, employeeBankAccount, uuid, orderByComparator, true);

			array[1] = employeeBankAccount;

			array[2] = getByUuid_PrevAndNext(
				session, employeeBankAccount, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected EmployeeBankAccount getByUuid_PrevAndNext(
		Session session, EmployeeBankAccount employeeBankAccount, String uuid,
		OrderByComparator<EmployeeBankAccount> orderByComparator,
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

		sb.append(_SQL_SELECT_EMPLOYEEBANKACCOUNT_WHERE);

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
			sb.append(EmployeeBankAccountModelImpl.ORDER_BY_JPQL);
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
						employeeBankAccount)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EmployeeBankAccount> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employee bank accounts where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (EmployeeBankAccount employeeBankAccount :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(employeeBankAccount);
		}
	}

	/**
	 * Returns the number of employee bank accounts where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching employee bank accounts
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EMPLOYEEBANKACCOUNT_WHERE);

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
		"employeeBankAccount.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(employeeBankAccount.uuid IS NULL OR employeeBankAccount.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;

	/**
	 * Returns the employee bank account where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchEmployeeBankAccountException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching employee bank account
	 * @throws NoSuchEmployeeBankAccountException if a matching employee bank account could not be found
	 */
	@Override
	public EmployeeBankAccount findByUUID_G(String uuid, long groupId)
		throws NoSuchEmployeeBankAccountException {

		EmployeeBankAccount employeeBankAccount = fetchByUUID_G(uuid, groupId);

		if (employeeBankAccount == null) {
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

			throw new NoSuchEmployeeBankAccountException(sb.toString());
		}

		return employeeBankAccount;
	}

	/**
	 * Returns the employee bank account where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching employee bank account, or <code>null</code> if a matching employee bank account could not be found
	 */
	@Override
	public EmployeeBankAccount fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the employee bank account where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching employee bank account, or <code>null</code> if a matching employee bank account could not be found
	 */
	@Override
	public EmployeeBankAccount fetchByUUID_G(
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

		if (result instanceof EmployeeBankAccount) {
			EmployeeBankAccount employeeBankAccount =
				(EmployeeBankAccount)result;

			if (!Objects.equals(uuid, employeeBankAccount.getUuid()) ||
				(groupId != employeeBankAccount.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_EMPLOYEEBANKACCOUNT_WHERE);

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

				List<EmployeeBankAccount> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					EmployeeBankAccount employeeBankAccount = list.get(0);

					result = employeeBankAccount;

					cacheResult(employeeBankAccount);
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
			return (EmployeeBankAccount)result;
		}
	}

	/**
	 * Removes the employee bank account where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the employee bank account that was removed
	 */
	@Override
	public EmployeeBankAccount removeByUUID_G(String uuid, long groupId)
		throws NoSuchEmployeeBankAccountException {

		EmployeeBankAccount employeeBankAccount = findByUUID_G(uuid, groupId);

		return remove(employeeBankAccount);
	}

	/**
	 * Returns the number of employee bank accounts where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching employee bank accounts
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		EmployeeBankAccount employeeBankAccount = fetchByUUID_G(uuid, groupId);

		if (employeeBankAccount == null) {
			return 0;
		}

		return 1;
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"employeeBankAccount.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(employeeBankAccount.uuid IS NULL OR employeeBankAccount.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"employeeBankAccount.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the employee bank accounts where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching employee bank accounts
	 */
	@Override
	public List<EmployeeBankAccount> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee bank accounts where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeBankAccountModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee bank accounts
	 * @param end the upper bound of the range of employee bank accounts (not inclusive)
	 * @return the range of matching employee bank accounts
	 */
	@Override
	public List<EmployeeBankAccount> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee bank accounts where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeBankAccountModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee bank accounts
	 * @param end the upper bound of the range of employee bank accounts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee bank accounts
	 */
	@Override
	public List<EmployeeBankAccount> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EmployeeBankAccount> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee bank accounts where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeBankAccountModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee bank accounts
	 * @param end the upper bound of the range of employee bank accounts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee bank accounts
	 */
	@Override
	public List<EmployeeBankAccount> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EmployeeBankAccount> orderByComparator,
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

		List<EmployeeBankAccount> list = null;

		if (useFinderCache) {
			list = (List<EmployeeBankAccount>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EmployeeBankAccount employeeBankAccount : list) {
					if (!uuid.equals(employeeBankAccount.getUuid()) ||
						(companyId != employeeBankAccount.getCompanyId())) {

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

			sb.append(_SQL_SELECT_EMPLOYEEBANKACCOUNT_WHERE);

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
				sb.append(EmployeeBankAccountModelImpl.ORDER_BY_JPQL);
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

				list = (List<EmployeeBankAccount>)QueryUtil.list(
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
	 * Returns the first employee bank account in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee bank account
	 * @throws NoSuchEmployeeBankAccountException if a matching employee bank account could not be found
	 */
	@Override
	public EmployeeBankAccount findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<EmployeeBankAccount> orderByComparator)
		throws NoSuchEmployeeBankAccountException {

		EmployeeBankAccount employeeBankAccount = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (employeeBankAccount != null) {
			return employeeBankAccount;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchEmployeeBankAccountException(sb.toString());
	}

	/**
	 * Returns the first employee bank account in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee bank account, or <code>null</code> if a matching employee bank account could not be found
	 */
	@Override
	public EmployeeBankAccount fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<EmployeeBankAccount> orderByComparator) {

		List<EmployeeBankAccount> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee bank account in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee bank account
	 * @throws NoSuchEmployeeBankAccountException if a matching employee bank account could not be found
	 */
	@Override
	public EmployeeBankAccount findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<EmployeeBankAccount> orderByComparator)
		throws NoSuchEmployeeBankAccountException {

		EmployeeBankAccount employeeBankAccount = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (employeeBankAccount != null) {
			return employeeBankAccount;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchEmployeeBankAccountException(sb.toString());
	}

	/**
	 * Returns the last employee bank account in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee bank account, or <code>null</code> if a matching employee bank account could not be found
	 */
	@Override
	public EmployeeBankAccount fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<EmployeeBankAccount> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<EmployeeBankAccount> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the employee bank accounts before and after the current employee bank account in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param bankAccountId the primary key of the current employee bank account
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee bank account
	 * @throws NoSuchEmployeeBankAccountException if a employee bank account with the primary key could not be found
	 */
	@Override
	public EmployeeBankAccount[] findByUuid_C_PrevAndNext(
			long bankAccountId, String uuid, long companyId,
			OrderByComparator<EmployeeBankAccount> orderByComparator)
		throws NoSuchEmployeeBankAccountException {

		uuid = Objects.toString(uuid, "");

		EmployeeBankAccount employeeBankAccount = findByPrimaryKey(
			bankAccountId);

		Session session = null;

		try {
			session = openSession();

			EmployeeBankAccount[] array = new EmployeeBankAccountImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, employeeBankAccount, uuid, companyId,
				orderByComparator, true);

			array[1] = employeeBankAccount;

			array[2] = getByUuid_C_PrevAndNext(
				session, employeeBankAccount, uuid, companyId,
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

	protected EmployeeBankAccount getByUuid_C_PrevAndNext(
		Session session, EmployeeBankAccount employeeBankAccount, String uuid,
		long companyId,
		OrderByComparator<EmployeeBankAccount> orderByComparator,
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

		sb.append(_SQL_SELECT_EMPLOYEEBANKACCOUNT_WHERE);

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
			sb.append(EmployeeBankAccountModelImpl.ORDER_BY_JPQL);
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
						employeeBankAccount)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EmployeeBankAccount> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employee bank accounts where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (EmployeeBankAccount employeeBankAccount :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(employeeBankAccount);
		}
	}

	/**
	 * Returns the number of employee bank accounts where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching employee bank accounts
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_EMPLOYEEBANKACCOUNT_WHERE);

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
		"employeeBankAccount.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(employeeBankAccount.uuid IS NULL OR employeeBankAccount.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"employeeBankAccount.companyId = ?";

	public EmployeeBankAccountPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(EmployeeBankAccount.class);

		setModelImplClass(EmployeeBankAccountImpl.class);
		setModelPKClass(long.class);

		setTable(EmployeeBankAccountTable.INSTANCE);
	}

	/**
	 * Caches the employee bank account in the entity cache if it is enabled.
	 *
	 * @param employeeBankAccount the employee bank account
	 */
	@Override
	public void cacheResult(EmployeeBankAccount employeeBankAccount) {
		entityCache.putResult(
			EmployeeBankAccountImpl.class, employeeBankAccount.getPrimaryKey(),
			employeeBankAccount);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				employeeBankAccount.getUuid(), employeeBankAccount.getGroupId()
			},
			employeeBankAccount);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the employee bank accounts in the entity cache if it is enabled.
	 *
	 * @param employeeBankAccounts the employee bank accounts
	 */
	@Override
	public void cacheResult(List<EmployeeBankAccount> employeeBankAccounts) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (employeeBankAccounts.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (EmployeeBankAccount employeeBankAccount : employeeBankAccounts) {
			if (entityCache.getResult(
					EmployeeBankAccountImpl.class,
					employeeBankAccount.getPrimaryKey()) == null) {

				cacheResult(employeeBankAccount);
			}
		}
	}

	/**
	 * Clears the cache for all employee bank accounts.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(EmployeeBankAccountImpl.class);

		finderCache.clearCache(EmployeeBankAccountImpl.class);
	}

	/**
	 * Clears the cache for the employee bank account.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EmployeeBankAccount employeeBankAccount) {
		entityCache.removeResult(
			EmployeeBankAccountImpl.class, employeeBankAccount);
	}

	@Override
	public void clearCache(List<EmployeeBankAccount> employeeBankAccounts) {
		for (EmployeeBankAccount employeeBankAccount : employeeBankAccounts) {
			entityCache.removeResult(
				EmployeeBankAccountImpl.class, employeeBankAccount);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(EmployeeBankAccountImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(EmployeeBankAccountImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		EmployeeBankAccountModelImpl employeeBankAccountModelImpl) {

		Object[] args = new Object[] {
			employeeBankAccountModelImpl.getUuid(),
			employeeBankAccountModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathFetchByUUID_G, args, employeeBankAccountModelImpl);
	}

	/**
	 * Creates a new employee bank account with the primary key. Does not add the employee bank account to the database.
	 *
	 * @param bankAccountId the primary key for the new employee bank account
	 * @return the new employee bank account
	 */
	@Override
	public EmployeeBankAccount create(long bankAccountId) {
		EmployeeBankAccount employeeBankAccount = new EmployeeBankAccountImpl();

		employeeBankAccount.setNew(true);
		employeeBankAccount.setPrimaryKey(bankAccountId);

		String uuid = PortalUUIDUtil.generate();

		employeeBankAccount.setUuid(uuid);

		employeeBankAccount.setCompanyId(CompanyThreadLocal.getCompanyId());

		return employeeBankAccount;
	}

	/**
	 * Removes the employee bank account with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param bankAccountId the primary key of the employee bank account
	 * @return the employee bank account that was removed
	 * @throws NoSuchEmployeeBankAccountException if a employee bank account with the primary key could not be found
	 */
	@Override
	public EmployeeBankAccount remove(long bankAccountId)
		throws NoSuchEmployeeBankAccountException {

		return remove((Serializable)bankAccountId);
	}

	/**
	 * Removes the employee bank account with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the employee bank account
	 * @return the employee bank account that was removed
	 * @throws NoSuchEmployeeBankAccountException if a employee bank account with the primary key could not be found
	 */
	@Override
	public EmployeeBankAccount remove(Serializable primaryKey)
		throws NoSuchEmployeeBankAccountException {

		Session session = null;

		try {
			session = openSession();

			EmployeeBankAccount employeeBankAccount =
				(EmployeeBankAccount)session.get(
					EmployeeBankAccountImpl.class, primaryKey);

			if (employeeBankAccount == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEmployeeBankAccountException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(employeeBankAccount);
		}
		catch (NoSuchEmployeeBankAccountException noSuchEntityException) {
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
	protected EmployeeBankAccount removeImpl(
		EmployeeBankAccount employeeBankAccount) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(employeeBankAccount)) {
				employeeBankAccount = (EmployeeBankAccount)session.get(
					EmployeeBankAccountImpl.class,
					employeeBankAccount.getPrimaryKeyObj());
			}

			if (employeeBankAccount != null) {
				session.delete(employeeBankAccount);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (employeeBankAccount != null) {
			clearCache(employeeBankAccount);
		}

		return employeeBankAccount;
	}

	@Override
	public EmployeeBankAccount updateImpl(
		EmployeeBankAccount employeeBankAccount) {

		boolean isNew = employeeBankAccount.isNew();

		if (!(employeeBankAccount instanceof EmployeeBankAccountModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(employeeBankAccount.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					employeeBankAccount);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in employeeBankAccount proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom EmployeeBankAccount implementation " +
					employeeBankAccount.getClass());
		}

		EmployeeBankAccountModelImpl employeeBankAccountModelImpl =
			(EmployeeBankAccountModelImpl)employeeBankAccount;

		if (Validator.isNull(employeeBankAccount.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			employeeBankAccount.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (employeeBankAccount.getCreateDate() == null)) {
			if (serviceContext == null) {
				employeeBankAccount.setCreateDate(date);
			}
			else {
				employeeBankAccount.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!employeeBankAccountModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				employeeBankAccount.setModifiedDate(date);
			}
			else {
				employeeBankAccount.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(employeeBankAccount);
			}
			else {
				employeeBankAccount = (EmployeeBankAccount)session.merge(
					employeeBankAccount);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			EmployeeBankAccountImpl.class, employeeBankAccountModelImpl, false,
			true);

		cacheUniqueFindersCache(employeeBankAccountModelImpl);

		if (isNew) {
			employeeBankAccount.setNew(false);
		}

		employeeBankAccount.resetOriginalValues();

		return employeeBankAccount;
	}

	/**
	 * Returns the employee bank account with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the employee bank account
	 * @return the employee bank account
	 * @throws NoSuchEmployeeBankAccountException if a employee bank account with the primary key could not be found
	 */
	@Override
	public EmployeeBankAccount findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEmployeeBankAccountException {

		EmployeeBankAccount employeeBankAccount = fetchByPrimaryKey(primaryKey);

		if (employeeBankAccount == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEmployeeBankAccountException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return employeeBankAccount;
	}

	/**
	 * Returns the employee bank account with the primary key or throws a <code>NoSuchEmployeeBankAccountException</code> if it could not be found.
	 *
	 * @param bankAccountId the primary key of the employee bank account
	 * @return the employee bank account
	 * @throws NoSuchEmployeeBankAccountException if a employee bank account with the primary key could not be found
	 */
	@Override
	public EmployeeBankAccount findByPrimaryKey(long bankAccountId)
		throws NoSuchEmployeeBankAccountException {

		return findByPrimaryKey((Serializable)bankAccountId);
	}

	/**
	 * Returns the employee bank account with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param bankAccountId the primary key of the employee bank account
	 * @return the employee bank account, or <code>null</code> if a employee bank account with the primary key could not be found
	 */
	@Override
	public EmployeeBankAccount fetchByPrimaryKey(long bankAccountId) {
		return fetchByPrimaryKey((Serializable)bankAccountId);
	}

	/**
	 * Returns all the employee bank accounts.
	 *
	 * @return the employee bank accounts
	 */
	@Override
	public List<EmployeeBankAccount> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee bank accounts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeBankAccountModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee bank accounts
	 * @param end the upper bound of the range of employee bank accounts (not inclusive)
	 * @return the range of employee bank accounts
	 */
	@Override
	public List<EmployeeBankAccount> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee bank accounts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeBankAccountModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee bank accounts
	 * @param end the upper bound of the range of employee bank accounts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee bank accounts
	 */
	@Override
	public List<EmployeeBankAccount> findAll(
		int start, int end,
		OrderByComparator<EmployeeBankAccount> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee bank accounts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeBankAccountModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee bank accounts
	 * @param end the upper bound of the range of employee bank accounts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee bank accounts
	 */
	@Override
	public List<EmployeeBankAccount> findAll(
		int start, int end,
		OrderByComparator<EmployeeBankAccount> orderByComparator,
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

		List<EmployeeBankAccount> list = null;

		if (useFinderCache) {
			list = (List<EmployeeBankAccount>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_EMPLOYEEBANKACCOUNT);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_EMPLOYEEBANKACCOUNT;

				sql = sql.concat(EmployeeBankAccountModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<EmployeeBankAccount>)QueryUtil.list(
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
	 * Removes all the employee bank accounts from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (EmployeeBankAccount employeeBankAccount : findAll()) {
			remove(employeeBankAccount);
		}
	}

	/**
	 * Returns the number of employee bank accounts.
	 *
	 * @return the number of employee bank accounts
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
					_SQL_COUNT_EMPLOYEEBANKACCOUNT);

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
		return "bankAccountId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_EMPLOYEEBANKACCOUNT;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return EmployeeBankAccountModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the employee bank account persistence.
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

		EmployeeBankAccountUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		EmployeeBankAccountUtil.setPersistence(null);

		entityCache.removeCache(EmployeeBankAccountImpl.class.getName());
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

	private static final String _SQL_SELECT_EMPLOYEEBANKACCOUNT =
		"SELECT employeeBankAccount FROM EmployeeBankAccount employeeBankAccount";

	private static final String _SQL_SELECT_EMPLOYEEBANKACCOUNT_WHERE =
		"SELECT employeeBankAccount FROM EmployeeBankAccount employeeBankAccount WHERE ";

	private static final String _SQL_COUNT_EMPLOYEEBANKACCOUNT =
		"SELECT COUNT(employeeBankAccount) FROM EmployeeBankAccount employeeBankAccount";

	private static final String _SQL_COUNT_EMPLOYEEBANKACCOUNT_WHERE =
		"SELECT COUNT(employeeBankAccount) FROM EmployeeBankAccount employeeBankAccount WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "employeeBankAccount.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No EmployeeBankAccount exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No EmployeeBankAccount exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		EmployeeBankAccountPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}