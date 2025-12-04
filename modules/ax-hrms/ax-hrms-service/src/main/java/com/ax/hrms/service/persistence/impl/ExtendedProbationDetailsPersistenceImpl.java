/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence.impl;

import com.ax.hrms.exception.NoSuchExtendedProbationDetailsException;
import com.ax.hrms.model.ExtendedProbationDetails;
import com.ax.hrms.model.ExtendedProbationDetailsTable;
import com.ax.hrms.model.impl.ExtendedProbationDetailsImpl;
import com.ax.hrms.model.impl.ExtendedProbationDetailsModelImpl;
import com.ax.hrms.service.persistence.ExtendedProbationDetailsPersistence;
import com.ax.hrms.service.persistence.ExtendedProbationDetailsUtil;
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
 * The persistence implementation for the extended probation details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ExtendedProbationDetailsPersistence.class)
public class ExtendedProbationDetailsPersistenceImpl
	extends BasePersistenceImpl<ExtendedProbationDetails>
	implements ExtendedProbationDetailsPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ExtendedProbationDetailsUtil</code> to access the extended probation details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ExtendedProbationDetailsImpl.class.getName();

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
	 * Returns all the extended probation detailses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching extended probation detailses
	 */
	@Override
	public List<ExtendedProbationDetails> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the extended probation detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExtendedProbationDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of extended probation detailses
	 * @param end the upper bound of the range of extended probation detailses (not inclusive)
	 * @return the range of matching extended probation detailses
	 */
	@Override
	public List<ExtendedProbationDetails> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the extended probation detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExtendedProbationDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of extended probation detailses
	 * @param end the upper bound of the range of extended probation detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching extended probation detailses
	 */
	@Override
	public List<ExtendedProbationDetails> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ExtendedProbationDetails> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the extended probation detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExtendedProbationDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of extended probation detailses
	 * @param end the upper bound of the range of extended probation detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching extended probation detailses
	 */
	@Override
	public List<ExtendedProbationDetails> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ExtendedProbationDetails> orderByComparator,
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

		List<ExtendedProbationDetails> list = null;

		if (useFinderCache) {
			list = (List<ExtendedProbationDetails>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ExtendedProbationDetails extendedProbationDetails : list) {
					if (!uuid.equals(extendedProbationDetails.getUuid())) {
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

			sb.append(_SQL_SELECT_EXTENDEDPROBATIONDETAILS_WHERE);

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
				sb.append(ExtendedProbationDetailsModelImpl.ORDER_BY_JPQL);
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

				list = (List<ExtendedProbationDetails>)QueryUtil.list(
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
	 * Returns the first extended probation details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching extended probation details
	 * @throws NoSuchExtendedProbationDetailsException if a matching extended probation details could not be found
	 */
	@Override
	public ExtendedProbationDetails findByUuid_First(
			String uuid,
			OrderByComparator<ExtendedProbationDetails> orderByComparator)
		throws NoSuchExtendedProbationDetailsException {

		ExtendedProbationDetails extendedProbationDetails = fetchByUuid_First(
			uuid, orderByComparator);

		if (extendedProbationDetails != null) {
			return extendedProbationDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchExtendedProbationDetailsException(sb.toString());
	}

	/**
	 * Returns the first extended probation details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching extended probation details, or <code>null</code> if a matching extended probation details could not be found
	 */
	@Override
	public ExtendedProbationDetails fetchByUuid_First(
		String uuid,
		OrderByComparator<ExtendedProbationDetails> orderByComparator) {

		List<ExtendedProbationDetails> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last extended probation details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching extended probation details
	 * @throws NoSuchExtendedProbationDetailsException if a matching extended probation details could not be found
	 */
	@Override
	public ExtendedProbationDetails findByUuid_Last(
			String uuid,
			OrderByComparator<ExtendedProbationDetails> orderByComparator)
		throws NoSuchExtendedProbationDetailsException {

		ExtendedProbationDetails extendedProbationDetails = fetchByUuid_Last(
			uuid, orderByComparator);

		if (extendedProbationDetails != null) {
			return extendedProbationDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchExtendedProbationDetailsException(sb.toString());
	}

	/**
	 * Returns the last extended probation details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching extended probation details, or <code>null</code> if a matching extended probation details could not be found
	 */
	@Override
	public ExtendedProbationDetails fetchByUuid_Last(
		String uuid,
		OrderByComparator<ExtendedProbationDetails> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ExtendedProbationDetails> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the extended probation detailses before and after the current extended probation details in the ordered set where uuid = &#63;.
	 *
	 * @param extendedProbationDetailsId the primary key of the current extended probation details
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next extended probation details
	 * @throws NoSuchExtendedProbationDetailsException if a extended probation details with the primary key could not be found
	 */
	@Override
	public ExtendedProbationDetails[] findByUuid_PrevAndNext(
			long extendedProbationDetailsId, String uuid,
			OrderByComparator<ExtendedProbationDetails> orderByComparator)
		throws NoSuchExtendedProbationDetailsException {

		uuid = Objects.toString(uuid, "");

		ExtendedProbationDetails extendedProbationDetails = findByPrimaryKey(
			extendedProbationDetailsId);

		Session session = null;

		try {
			session = openSession();

			ExtendedProbationDetails[] array =
				new ExtendedProbationDetailsImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, extendedProbationDetails, uuid, orderByComparator,
				true);

			array[1] = extendedProbationDetails;

			array[2] = getByUuid_PrevAndNext(
				session, extendedProbationDetails, uuid, orderByComparator,
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

	protected ExtendedProbationDetails getByUuid_PrevAndNext(
		Session session, ExtendedProbationDetails extendedProbationDetails,
		String uuid,
		OrderByComparator<ExtendedProbationDetails> orderByComparator,
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

		sb.append(_SQL_SELECT_EXTENDEDPROBATIONDETAILS_WHERE);

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
			sb.append(ExtendedProbationDetailsModelImpl.ORDER_BY_JPQL);
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
						extendedProbationDetails)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ExtendedProbationDetails> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the extended probation detailses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (ExtendedProbationDetails extendedProbationDetails :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(extendedProbationDetails);
		}
	}

	/**
	 * Returns the number of extended probation detailses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching extended probation detailses
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EXTENDEDPROBATIONDETAILS_WHERE);

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
		"extendedProbationDetails.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(extendedProbationDetails.uuid IS NULL OR extendedProbationDetails.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;

	/**
	 * Returns the extended probation details where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchExtendedProbationDetailsException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching extended probation details
	 * @throws NoSuchExtendedProbationDetailsException if a matching extended probation details could not be found
	 */
	@Override
	public ExtendedProbationDetails findByUUID_G(String uuid, long groupId)
		throws NoSuchExtendedProbationDetailsException {

		ExtendedProbationDetails extendedProbationDetails = fetchByUUID_G(
			uuid, groupId);

		if (extendedProbationDetails == null) {
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

			throw new NoSuchExtendedProbationDetailsException(sb.toString());
		}

		return extendedProbationDetails;
	}

	/**
	 * Returns the extended probation details where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching extended probation details, or <code>null</code> if a matching extended probation details could not be found
	 */
	@Override
	public ExtendedProbationDetails fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the extended probation details where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching extended probation details, or <code>null</code> if a matching extended probation details could not be found
	 */
	@Override
	public ExtendedProbationDetails fetchByUUID_G(
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

		if (result instanceof ExtendedProbationDetails) {
			ExtendedProbationDetails extendedProbationDetails =
				(ExtendedProbationDetails)result;

			if (!Objects.equals(uuid, extendedProbationDetails.getUuid()) ||
				(groupId != extendedProbationDetails.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_EXTENDEDPROBATIONDETAILS_WHERE);

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

				List<ExtendedProbationDetails> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					ExtendedProbationDetails extendedProbationDetails =
						list.get(0);

					result = extendedProbationDetails;

					cacheResult(extendedProbationDetails);
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
			return (ExtendedProbationDetails)result;
		}
	}

	/**
	 * Removes the extended probation details where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the extended probation details that was removed
	 */
	@Override
	public ExtendedProbationDetails removeByUUID_G(String uuid, long groupId)
		throws NoSuchExtendedProbationDetailsException {

		ExtendedProbationDetails extendedProbationDetails = findByUUID_G(
			uuid, groupId);

		return remove(extendedProbationDetails);
	}

	/**
	 * Returns the number of extended probation detailses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching extended probation detailses
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		ExtendedProbationDetails extendedProbationDetails = fetchByUUID_G(
			uuid, groupId);

		if (extendedProbationDetails == null) {
			return 0;
		}

		return 1;
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"extendedProbationDetails.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(extendedProbationDetails.uuid IS NULL OR extendedProbationDetails.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"extendedProbationDetails.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the extended probation detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching extended probation detailses
	 */
	@Override
	public List<ExtendedProbationDetails> findByUuid_C(
		String uuid, long companyId) {

		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the extended probation detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExtendedProbationDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of extended probation detailses
	 * @param end the upper bound of the range of extended probation detailses (not inclusive)
	 * @return the range of matching extended probation detailses
	 */
	@Override
	public List<ExtendedProbationDetails> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the extended probation detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExtendedProbationDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of extended probation detailses
	 * @param end the upper bound of the range of extended probation detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching extended probation detailses
	 */
	@Override
	public List<ExtendedProbationDetails> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ExtendedProbationDetails> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the extended probation detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExtendedProbationDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of extended probation detailses
	 * @param end the upper bound of the range of extended probation detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching extended probation detailses
	 */
	@Override
	public List<ExtendedProbationDetails> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ExtendedProbationDetails> orderByComparator,
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

		List<ExtendedProbationDetails> list = null;

		if (useFinderCache) {
			list = (List<ExtendedProbationDetails>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ExtendedProbationDetails extendedProbationDetails : list) {
					if (!uuid.equals(extendedProbationDetails.getUuid()) ||
						(companyId !=
							extendedProbationDetails.getCompanyId())) {

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

			sb.append(_SQL_SELECT_EXTENDEDPROBATIONDETAILS_WHERE);

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
				sb.append(ExtendedProbationDetailsModelImpl.ORDER_BY_JPQL);
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

				list = (List<ExtendedProbationDetails>)QueryUtil.list(
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
	 * Returns the first extended probation details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching extended probation details
	 * @throws NoSuchExtendedProbationDetailsException if a matching extended probation details could not be found
	 */
	@Override
	public ExtendedProbationDetails findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ExtendedProbationDetails> orderByComparator)
		throws NoSuchExtendedProbationDetailsException {

		ExtendedProbationDetails extendedProbationDetails = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (extendedProbationDetails != null) {
			return extendedProbationDetails;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchExtendedProbationDetailsException(sb.toString());
	}

	/**
	 * Returns the first extended probation details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching extended probation details, or <code>null</code> if a matching extended probation details could not be found
	 */
	@Override
	public ExtendedProbationDetails fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ExtendedProbationDetails> orderByComparator) {

		List<ExtendedProbationDetails> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last extended probation details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching extended probation details
	 * @throws NoSuchExtendedProbationDetailsException if a matching extended probation details could not be found
	 */
	@Override
	public ExtendedProbationDetails findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ExtendedProbationDetails> orderByComparator)
		throws NoSuchExtendedProbationDetailsException {

		ExtendedProbationDetails extendedProbationDetails = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (extendedProbationDetails != null) {
			return extendedProbationDetails;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchExtendedProbationDetailsException(sb.toString());
	}

	/**
	 * Returns the last extended probation details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching extended probation details, or <code>null</code> if a matching extended probation details could not be found
	 */
	@Override
	public ExtendedProbationDetails fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ExtendedProbationDetails> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<ExtendedProbationDetails> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the extended probation detailses before and after the current extended probation details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param extendedProbationDetailsId the primary key of the current extended probation details
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next extended probation details
	 * @throws NoSuchExtendedProbationDetailsException if a extended probation details with the primary key could not be found
	 */
	@Override
	public ExtendedProbationDetails[] findByUuid_C_PrevAndNext(
			long extendedProbationDetailsId, String uuid, long companyId,
			OrderByComparator<ExtendedProbationDetails> orderByComparator)
		throws NoSuchExtendedProbationDetailsException {

		uuid = Objects.toString(uuid, "");

		ExtendedProbationDetails extendedProbationDetails = findByPrimaryKey(
			extendedProbationDetailsId);

		Session session = null;

		try {
			session = openSession();

			ExtendedProbationDetails[] array =
				new ExtendedProbationDetailsImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, extendedProbationDetails, uuid, companyId,
				orderByComparator, true);

			array[1] = extendedProbationDetails;

			array[2] = getByUuid_C_PrevAndNext(
				session, extendedProbationDetails, uuid, companyId,
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

	protected ExtendedProbationDetails getByUuid_C_PrevAndNext(
		Session session, ExtendedProbationDetails extendedProbationDetails,
		String uuid, long companyId,
		OrderByComparator<ExtendedProbationDetails> orderByComparator,
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

		sb.append(_SQL_SELECT_EXTENDEDPROBATIONDETAILS_WHERE);

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
			sb.append(ExtendedProbationDetailsModelImpl.ORDER_BY_JPQL);
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
						extendedProbationDetails)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ExtendedProbationDetails> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the extended probation detailses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (ExtendedProbationDetails extendedProbationDetails :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(extendedProbationDetails);
		}
	}

	/**
	 * Returns the number of extended probation detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching extended probation detailses
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_EXTENDEDPROBATIONDETAILS_WHERE);

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
		"extendedProbationDetails.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(extendedProbationDetails.uuid IS NULL OR extendedProbationDetails.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"extendedProbationDetails.companyId = ?";

	public ExtendedProbationDetailsPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(ExtendedProbationDetails.class);

		setModelImplClass(ExtendedProbationDetailsImpl.class);
		setModelPKClass(long.class);

		setTable(ExtendedProbationDetailsTable.INSTANCE);
	}

	/**
	 * Caches the extended probation details in the entity cache if it is enabled.
	 *
	 * @param extendedProbationDetails the extended probation details
	 */
	@Override
	public void cacheResult(ExtendedProbationDetails extendedProbationDetails) {
		entityCache.putResult(
			ExtendedProbationDetailsImpl.class,
			extendedProbationDetails.getPrimaryKey(), extendedProbationDetails);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				extendedProbationDetails.getUuid(),
				extendedProbationDetails.getGroupId()
			},
			extendedProbationDetails);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the extended probation detailses in the entity cache if it is enabled.
	 *
	 * @param extendedProbationDetailses the extended probation detailses
	 */
	@Override
	public void cacheResult(
		List<ExtendedProbationDetails> extendedProbationDetailses) {

		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (extendedProbationDetailses.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (ExtendedProbationDetails extendedProbationDetails :
				extendedProbationDetailses) {

			if (entityCache.getResult(
					ExtendedProbationDetailsImpl.class,
					extendedProbationDetails.getPrimaryKey()) == null) {

				cacheResult(extendedProbationDetails);
			}
		}
	}

	/**
	 * Clears the cache for all extended probation detailses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ExtendedProbationDetailsImpl.class);

		finderCache.clearCache(ExtendedProbationDetailsImpl.class);
	}

	/**
	 * Clears the cache for the extended probation details.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ExtendedProbationDetails extendedProbationDetails) {
		entityCache.removeResult(
			ExtendedProbationDetailsImpl.class, extendedProbationDetails);
	}

	@Override
	public void clearCache(
		List<ExtendedProbationDetails> extendedProbationDetailses) {

		for (ExtendedProbationDetails extendedProbationDetails :
				extendedProbationDetailses) {

			entityCache.removeResult(
				ExtendedProbationDetailsImpl.class, extendedProbationDetails);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(ExtendedProbationDetailsImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				ExtendedProbationDetailsImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		ExtendedProbationDetailsModelImpl extendedProbationDetailsModelImpl) {

		Object[] args = new Object[] {
			extendedProbationDetailsModelImpl.getUuid(),
			extendedProbationDetailsModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathFetchByUUID_G, args, extendedProbationDetailsModelImpl);
	}

	/**
	 * Creates a new extended probation details with the primary key. Does not add the extended probation details to the database.
	 *
	 * @param extendedProbationDetailsId the primary key for the new extended probation details
	 * @return the new extended probation details
	 */
	@Override
	public ExtendedProbationDetails create(long extendedProbationDetailsId) {
		ExtendedProbationDetails extendedProbationDetails =
			new ExtendedProbationDetailsImpl();

		extendedProbationDetails.setNew(true);
		extendedProbationDetails.setPrimaryKey(extendedProbationDetailsId);

		String uuid = PortalUUIDUtil.generate();

		extendedProbationDetails.setUuid(uuid);

		extendedProbationDetails.setCompanyId(
			CompanyThreadLocal.getCompanyId());

		return extendedProbationDetails;
	}

	/**
	 * Removes the extended probation details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param extendedProbationDetailsId the primary key of the extended probation details
	 * @return the extended probation details that was removed
	 * @throws NoSuchExtendedProbationDetailsException if a extended probation details with the primary key could not be found
	 */
	@Override
	public ExtendedProbationDetails remove(long extendedProbationDetailsId)
		throws NoSuchExtendedProbationDetailsException {

		return remove((Serializable)extendedProbationDetailsId);
	}

	/**
	 * Removes the extended probation details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the extended probation details
	 * @return the extended probation details that was removed
	 * @throws NoSuchExtendedProbationDetailsException if a extended probation details with the primary key could not be found
	 */
	@Override
	public ExtendedProbationDetails remove(Serializable primaryKey)
		throws NoSuchExtendedProbationDetailsException {

		Session session = null;

		try {
			session = openSession();

			ExtendedProbationDetails extendedProbationDetails =
				(ExtendedProbationDetails)session.get(
					ExtendedProbationDetailsImpl.class, primaryKey);

			if (extendedProbationDetails == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchExtendedProbationDetailsException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(extendedProbationDetails);
		}
		catch (NoSuchExtendedProbationDetailsException noSuchEntityException) {
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
	protected ExtendedProbationDetails removeImpl(
		ExtendedProbationDetails extendedProbationDetails) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(extendedProbationDetails)) {
				extendedProbationDetails =
					(ExtendedProbationDetails)session.get(
						ExtendedProbationDetailsImpl.class,
						extendedProbationDetails.getPrimaryKeyObj());
			}

			if (extendedProbationDetails != null) {
				session.delete(extendedProbationDetails);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (extendedProbationDetails != null) {
			clearCache(extendedProbationDetails);
		}

		return extendedProbationDetails;
	}

	@Override
	public ExtendedProbationDetails updateImpl(
		ExtendedProbationDetails extendedProbationDetails) {

		boolean isNew = extendedProbationDetails.isNew();

		if (!(extendedProbationDetails instanceof
				ExtendedProbationDetailsModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(extendedProbationDetails.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					extendedProbationDetails);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in extendedProbationDetails proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ExtendedProbationDetails implementation " +
					extendedProbationDetails.getClass());
		}

		ExtendedProbationDetailsModelImpl extendedProbationDetailsModelImpl =
			(ExtendedProbationDetailsModelImpl)extendedProbationDetails;

		if (Validator.isNull(extendedProbationDetails.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			extendedProbationDetails.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (extendedProbationDetails.getCreateDate() == null)) {
			if (serviceContext == null) {
				extendedProbationDetails.setCreateDate(date);
			}
			else {
				extendedProbationDetails.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!extendedProbationDetailsModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				extendedProbationDetails.setModifiedDate(date);
			}
			else {
				extendedProbationDetails.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(extendedProbationDetails);
			}
			else {
				extendedProbationDetails =
					(ExtendedProbationDetails)session.merge(
						extendedProbationDetails);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ExtendedProbationDetailsImpl.class,
			extendedProbationDetailsModelImpl, false, true);

		cacheUniqueFindersCache(extendedProbationDetailsModelImpl);

		if (isNew) {
			extendedProbationDetails.setNew(false);
		}

		extendedProbationDetails.resetOriginalValues();

		return extendedProbationDetails;
	}

	/**
	 * Returns the extended probation details with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the extended probation details
	 * @return the extended probation details
	 * @throws NoSuchExtendedProbationDetailsException if a extended probation details with the primary key could not be found
	 */
	@Override
	public ExtendedProbationDetails findByPrimaryKey(Serializable primaryKey)
		throws NoSuchExtendedProbationDetailsException {

		ExtendedProbationDetails extendedProbationDetails = fetchByPrimaryKey(
			primaryKey);

		if (extendedProbationDetails == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchExtendedProbationDetailsException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return extendedProbationDetails;
	}

	/**
	 * Returns the extended probation details with the primary key or throws a <code>NoSuchExtendedProbationDetailsException</code> if it could not be found.
	 *
	 * @param extendedProbationDetailsId the primary key of the extended probation details
	 * @return the extended probation details
	 * @throws NoSuchExtendedProbationDetailsException if a extended probation details with the primary key could not be found
	 */
	@Override
	public ExtendedProbationDetails findByPrimaryKey(
			long extendedProbationDetailsId)
		throws NoSuchExtendedProbationDetailsException {

		return findByPrimaryKey((Serializable)extendedProbationDetailsId);
	}

	/**
	 * Returns the extended probation details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param extendedProbationDetailsId the primary key of the extended probation details
	 * @return the extended probation details, or <code>null</code> if a extended probation details with the primary key could not be found
	 */
	@Override
	public ExtendedProbationDetails fetchByPrimaryKey(
		long extendedProbationDetailsId) {

		return fetchByPrimaryKey((Serializable)extendedProbationDetailsId);
	}

	/**
	 * Returns all the extended probation detailses.
	 *
	 * @return the extended probation detailses
	 */
	@Override
	public List<ExtendedProbationDetails> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the extended probation detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExtendedProbationDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of extended probation detailses
	 * @param end the upper bound of the range of extended probation detailses (not inclusive)
	 * @return the range of extended probation detailses
	 */
	@Override
	public List<ExtendedProbationDetails> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the extended probation detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExtendedProbationDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of extended probation detailses
	 * @param end the upper bound of the range of extended probation detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of extended probation detailses
	 */
	@Override
	public List<ExtendedProbationDetails> findAll(
		int start, int end,
		OrderByComparator<ExtendedProbationDetails> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the extended probation detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExtendedProbationDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of extended probation detailses
	 * @param end the upper bound of the range of extended probation detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of extended probation detailses
	 */
	@Override
	public List<ExtendedProbationDetails> findAll(
		int start, int end,
		OrderByComparator<ExtendedProbationDetails> orderByComparator,
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

		List<ExtendedProbationDetails> list = null;

		if (useFinderCache) {
			list = (List<ExtendedProbationDetails>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_EXTENDEDPROBATIONDETAILS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_EXTENDEDPROBATIONDETAILS;

				sql = sql.concat(
					ExtendedProbationDetailsModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ExtendedProbationDetails>)QueryUtil.list(
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
	 * Removes all the extended probation detailses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ExtendedProbationDetails extendedProbationDetails : findAll()) {
			remove(extendedProbationDetails);
		}
	}

	/**
	 * Returns the number of extended probation detailses.
	 *
	 * @return the number of extended probation detailses
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
					_SQL_COUNT_EXTENDEDPROBATIONDETAILS);

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
		return "extendedProbationDetailsId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_EXTENDEDPROBATIONDETAILS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ExtendedProbationDetailsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the extended probation details persistence.
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

		ExtendedProbationDetailsUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		ExtendedProbationDetailsUtil.setPersistence(null);

		entityCache.removeCache(ExtendedProbationDetailsImpl.class.getName());
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

	private static final String _SQL_SELECT_EXTENDEDPROBATIONDETAILS =
		"SELECT extendedProbationDetails FROM ExtendedProbationDetails extendedProbationDetails";

	private static final String _SQL_SELECT_EXTENDEDPROBATIONDETAILS_WHERE =
		"SELECT extendedProbationDetails FROM ExtendedProbationDetails extendedProbationDetails WHERE ";

	private static final String _SQL_COUNT_EXTENDEDPROBATIONDETAILS =
		"SELECT COUNT(extendedProbationDetails) FROM ExtendedProbationDetails extendedProbationDetails";

	private static final String _SQL_COUNT_EXTENDEDPROBATIONDETAILS_WHERE =
		"SELECT COUNT(extendedProbationDetails) FROM ExtendedProbationDetails extendedProbationDetails WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"extendedProbationDetails.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ExtendedProbationDetails exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ExtendedProbationDetails exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ExtendedProbationDetailsPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}