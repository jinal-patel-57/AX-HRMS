/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence.impl;

import com.ax.hrms.exception.NoSuchPipProgramException;
import com.ax.hrms.model.PipProgram;
import com.ax.hrms.model.PipProgramTable;
import com.ax.hrms.model.impl.PipProgramImpl;
import com.ax.hrms.model.impl.PipProgramModelImpl;
import com.ax.hrms.service.persistence.PipProgramPersistence;
import com.ax.hrms.service.persistence.PipProgramUtil;
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
 * The persistence implementation for the pip program service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = PipProgramPersistence.class)
public class PipProgramPersistenceImpl
	extends BasePersistenceImpl<PipProgram> implements PipProgramPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>PipProgramUtil</code> to access the pip program persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		PipProgramImpl.class.getName();

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
	 * Returns all the pip programs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching pip programs
	 */
	@Override
	public List<PipProgram> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the pip programs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PipProgramModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of pip programs
	 * @param end the upper bound of the range of pip programs (not inclusive)
	 * @return the range of matching pip programs
	 */
	@Override
	public List<PipProgram> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the pip programs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PipProgramModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of pip programs
	 * @param end the upper bound of the range of pip programs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching pip programs
	 */
	@Override
	public List<PipProgram> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<PipProgram> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the pip programs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PipProgramModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of pip programs
	 * @param end the upper bound of the range of pip programs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching pip programs
	 */
	@Override
	public List<PipProgram> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<PipProgram> orderByComparator,
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

		List<PipProgram> list = null;

		if (useFinderCache) {
			list = (List<PipProgram>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PipProgram pipProgram : list) {
					if (!uuid.equals(pipProgram.getUuid())) {
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

			sb.append(_SQL_SELECT_PIPPROGRAM_WHERE);

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
				sb.append(PipProgramModelImpl.ORDER_BY_JPQL);
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

				list = (List<PipProgram>)QueryUtil.list(
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
	 * Returns the first pip program in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pip program
	 * @throws NoSuchPipProgramException if a matching pip program could not be found
	 */
	@Override
	public PipProgram findByUuid_First(
			String uuid, OrderByComparator<PipProgram> orderByComparator)
		throws NoSuchPipProgramException {

		PipProgram pipProgram = fetchByUuid_First(uuid, orderByComparator);

		if (pipProgram != null) {
			return pipProgram;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchPipProgramException(sb.toString());
	}

	/**
	 * Returns the first pip program in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pip program, or <code>null</code> if a matching pip program could not be found
	 */
	@Override
	public PipProgram fetchByUuid_First(
		String uuid, OrderByComparator<PipProgram> orderByComparator) {

		List<PipProgram> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last pip program in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pip program
	 * @throws NoSuchPipProgramException if a matching pip program could not be found
	 */
	@Override
	public PipProgram findByUuid_Last(
			String uuid, OrderByComparator<PipProgram> orderByComparator)
		throws NoSuchPipProgramException {

		PipProgram pipProgram = fetchByUuid_Last(uuid, orderByComparator);

		if (pipProgram != null) {
			return pipProgram;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchPipProgramException(sb.toString());
	}

	/**
	 * Returns the last pip program in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pip program, or <code>null</code> if a matching pip program could not be found
	 */
	@Override
	public PipProgram fetchByUuid_Last(
		String uuid, OrderByComparator<PipProgram> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<PipProgram> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the pip programs before and after the current pip program in the ordered set where uuid = &#63;.
	 *
	 * @param pipProgramId the primary key of the current pip program
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next pip program
	 * @throws NoSuchPipProgramException if a pip program with the primary key could not be found
	 */
	@Override
	public PipProgram[] findByUuid_PrevAndNext(
			long pipProgramId, String uuid,
			OrderByComparator<PipProgram> orderByComparator)
		throws NoSuchPipProgramException {

		uuid = Objects.toString(uuid, "");

		PipProgram pipProgram = findByPrimaryKey(pipProgramId);

		Session session = null;

		try {
			session = openSession();

			PipProgram[] array = new PipProgramImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, pipProgram, uuid, orderByComparator, true);

			array[1] = pipProgram;

			array[2] = getByUuid_PrevAndNext(
				session, pipProgram, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected PipProgram getByUuid_PrevAndNext(
		Session session, PipProgram pipProgram, String uuid,
		OrderByComparator<PipProgram> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PIPPROGRAM_WHERE);

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
			sb.append(PipProgramModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(pipProgram)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<PipProgram> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the pip programs where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (PipProgram pipProgram :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(pipProgram);
		}
	}

	/**
	 * Returns the number of pip programs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching pip programs
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PIPPROGRAM_WHERE);

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
		"pipProgram.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(pipProgram.uuid IS NULL OR pipProgram.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the pip program where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchPipProgramException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching pip program
	 * @throws NoSuchPipProgramException if a matching pip program could not be found
	 */
	@Override
	public PipProgram findByUUID_G(String uuid, long groupId)
		throws NoSuchPipProgramException {

		PipProgram pipProgram = fetchByUUID_G(uuid, groupId);

		if (pipProgram == null) {
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

			throw new NoSuchPipProgramException(sb.toString());
		}

		return pipProgram;
	}

	/**
	 * Returns the pip program where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching pip program, or <code>null</code> if a matching pip program could not be found
	 */
	@Override
	public PipProgram fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the pip program where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching pip program, or <code>null</code> if a matching pip program could not be found
	 */
	@Override
	public PipProgram fetchByUUID_G(
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

		if (result instanceof PipProgram) {
			PipProgram pipProgram = (PipProgram)result;

			if (!Objects.equals(uuid, pipProgram.getUuid()) ||
				(groupId != pipProgram.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_PIPPROGRAM_WHERE);

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

				List<PipProgram> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					PipProgram pipProgram = list.get(0);

					result = pipProgram;

					cacheResult(pipProgram);
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
			return (PipProgram)result;
		}
	}

	/**
	 * Removes the pip program where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the pip program that was removed
	 */
	@Override
	public PipProgram removeByUUID_G(String uuid, long groupId)
		throws NoSuchPipProgramException {

		PipProgram pipProgram = findByUUID_G(uuid, groupId);

		return remove(pipProgram);
	}

	/**
	 * Returns the number of pip programs where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching pip programs
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PIPPROGRAM_WHERE);

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
		"pipProgram.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(pipProgram.uuid IS NULL OR pipProgram.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"pipProgram.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the pip programs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching pip programs
	 */
	@Override
	public List<PipProgram> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the pip programs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PipProgramModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of pip programs
	 * @param end the upper bound of the range of pip programs (not inclusive)
	 * @return the range of matching pip programs
	 */
	@Override
	public List<PipProgram> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the pip programs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PipProgramModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of pip programs
	 * @param end the upper bound of the range of pip programs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching pip programs
	 */
	@Override
	public List<PipProgram> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<PipProgram> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the pip programs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PipProgramModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of pip programs
	 * @param end the upper bound of the range of pip programs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching pip programs
	 */
	@Override
	public List<PipProgram> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<PipProgram> orderByComparator,
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

		List<PipProgram> list = null;

		if (useFinderCache) {
			list = (List<PipProgram>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PipProgram pipProgram : list) {
					if (!uuid.equals(pipProgram.getUuid()) ||
						(companyId != pipProgram.getCompanyId())) {

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

			sb.append(_SQL_SELECT_PIPPROGRAM_WHERE);

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
				sb.append(PipProgramModelImpl.ORDER_BY_JPQL);
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

				list = (List<PipProgram>)QueryUtil.list(
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
	 * Returns the first pip program in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pip program
	 * @throws NoSuchPipProgramException if a matching pip program could not be found
	 */
	@Override
	public PipProgram findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<PipProgram> orderByComparator)
		throws NoSuchPipProgramException {

		PipProgram pipProgram = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (pipProgram != null) {
			return pipProgram;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchPipProgramException(sb.toString());
	}

	/**
	 * Returns the first pip program in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pip program, or <code>null</code> if a matching pip program could not be found
	 */
	@Override
	public PipProgram fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<PipProgram> orderByComparator) {

		List<PipProgram> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last pip program in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pip program
	 * @throws NoSuchPipProgramException if a matching pip program could not be found
	 */
	@Override
	public PipProgram findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<PipProgram> orderByComparator)
		throws NoSuchPipProgramException {

		PipProgram pipProgram = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (pipProgram != null) {
			return pipProgram;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchPipProgramException(sb.toString());
	}

	/**
	 * Returns the last pip program in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pip program, or <code>null</code> if a matching pip program could not be found
	 */
	@Override
	public PipProgram fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<PipProgram> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<PipProgram> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the pip programs before and after the current pip program in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param pipProgramId the primary key of the current pip program
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next pip program
	 * @throws NoSuchPipProgramException if a pip program with the primary key could not be found
	 */
	@Override
	public PipProgram[] findByUuid_C_PrevAndNext(
			long pipProgramId, String uuid, long companyId,
			OrderByComparator<PipProgram> orderByComparator)
		throws NoSuchPipProgramException {

		uuid = Objects.toString(uuid, "");

		PipProgram pipProgram = findByPrimaryKey(pipProgramId);

		Session session = null;

		try {
			session = openSession();

			PipProgram[] array = new PipProgramImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, pipProgram, uuid, companyId, orderByComparator, true);

			array[1] = pipProgram;

			array[2] = getByUuid_C_PrevAndNext(
				session, pipProgram, uuid, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected PipProgram getByUuid_C_PrevAndNext(
		Session session, PipProgram pipProgram, String uuid, long companyId,
		OrderByComparator<PipProgram> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_PIPPROGRAM_WHERE);

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
			sb.append(PipProgramModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(pipProgram)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<PipProgram> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the pip programs where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (PipProgram pipProgram :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(pipProgram);
		}
	}

	/**
	 * Returns the number of pip programs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching pip programs
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PIPPROGRAM_WHERE);

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
		"pipProgram.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(pipProgram.uuid IS NULL OR pipProgram.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"pipProgram.companyId = ?";

	public PipProgramPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(PipProgram.class);

		setModelImplClass(PipProgramImpl.class);
		setModelPKClass(long.class);

		setTable(PipProgramTable.INSTANCE);
	}

	/**
	 * Caches the pip program in the entity cache if it is enabled.
	 *
	 * @param pipProgram the pip program
	 */
	@Override
	public void cacheResult(PipProgram pipProgram) {
		entityCache.putResult(
			PipProgramImpl.class, pipProgram.getPrimaryKey(), pipProgram);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {pipProgram.getUuid(), pipProgram.getGroupId()},
			pipProgram);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the pip programs in the entity cache if it is enabled.
	 *
	 * @param pipPrograms the pip programs
	 */
	@Override
	public void cacheResult(List<PipProgram> pipPrograms) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (pipPrograms.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (PipProgram pipProgram : pipPrograms) {
			if (entityCache.getResult(
					PipProgramImpl.class, pipProgram.getPrimaryKey()) == null) {

				cacheResult(pipProgram);
			}
		}
	}

	/**
	 * Clears the cache for all pip programs.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PipProgramImpl.class);

		finderCache.clearCache(PipProgramImpl.class);
	}

	/**
	 * Clears the cache for the pip program.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PipProgram pipProgram) {
		entityCache.removeResult(PipProgramImpl.class, pipProgram);
	}

	@Override
	public void clearCache(List<PipProgram> pipPrograms) {
		for (PipProgram pipProgram : pipPrograms) {
			entityCache.removeResult(PipProgramImpl.class, pipProgram);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(PipProgramImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(PipProgramImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		PipProgramModelImpl pipProgramModelImpl) {

		Object[] args = new Object[] {
			pipProgramModelImpl.getUuid(), pipProgramModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, pipProgramModelImpl);
	}

	/**
	 * Creates a new pip program with the primary key. Does not add the pip program to the database.
	 *
	 * @param pipProgramId the primary key for the new pip program
	 * @return the new pip program
	 */
	@Override
	public PipProgram create(long pipProgramId) {
		PipProgram pipProgram = new PipProgramImpl();

		pipProgram.setNew(true);
		pipProgram.setPrimaryKey(pipProgramId);

		String uuid = PortalUUIDUtil.generate();

		pipProgram.setUuid(uuid);

		pipProgram.setCompanyId(CompanyThreadLocal.getCompanyId());

		return pipProgram;
	}

	/**
	 * Removes the pip program with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param pipProgramId the primary key of the pip program
	 * @return the pip program that was removed
	 * @throws NoSuchPipProgramException if a pip program with the primary key could not be found
	 */
	@Override
	public PipProgram remove(long pipProgramId)
		throws NoSuchPipProgramException {

		return remove((Serializable)pipProgramId);
	}

	/**
	 * Removes the pip program with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the pip program
	 * @return the pip program that was removed
	 * @throws NoSuchPipProgramException if a pip program with the primary key could not be found
	 */
	@Override
	public PipProgram remove(Serializable primaryKey)
		throws NoSuchPipProgramException {

		Session session = null;

		try {
			session = openSession();

			PipProgram pipProgram = (PipProgram)session.get(
				PipProgramImpl.class, primaryKey);

			if (pipProgram == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPipProgramException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(pipProgram);
		}
		catch (NoSuchPipProgramException noSuchEntityException) {
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
	protected PipProgram removeImpl(PipProgram pipProgram) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(pipProgram)) {
				pipProgram = (PipProgram)session.get(
					PipProgramImpl.class, pipProgram.getPrimaryKeyObj());
			}

			if (pipProgram != null) {
				session.delete(pipProgram);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (pipProgram != null) {
			clearCache(pipProgram);
		}

		return pipProgram;
	}

	@Override
	public PipProgram updateImpl(PipProgram pipProgram) {
		boolean isNew = pipProgram.isNew();

		if (!(pipProgram instanceof PipProgramModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(pipProgram.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(pipProgram);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in pipProgram proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom PipProgram implementation " +
					pipProgram.getClass());
		}

		PipProgramModelImpl pipProgramModelImpl =
			(PipProgramModelImpl)pipProgram;

		if (Validator.isNull(pipProgram.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			pipProgram.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (pipProgram.getCreateDate() == null)) {
			if (serviceContext == null) {
				pipProgram.setCreateDate(date);
			}
			else {
				pipProgram.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!pipProgramModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				pipProgram.setModifiedDate(date);
			}
			else {
				pipProgram.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(pipProgram);
			}
			else {
				pipProgram = (PipProgram)session.merge(pipProgram);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			PipProgramImpl.class, pipProgramModelImpl, false, true);

		cacheUniqueFindersCache(pipProgramModelImpl);

		if (isNew) {
			pipProgram.setNew(false);
		}

		pipProgram.resetOriginalValues();

		return pipProgram;
	}

	/**
	 * Returns the pip program with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the pip program
	 * @return the pip program
	 * @throws NoSuchPipProgramException if a pip program with the primary key could not be found
	 */
	@Override
	public PipProgram findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPipProgramException {

		PipProgram pipProgram = fetchByPrimaryKey(primaryKey);

		if (pipProgram == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPipProgramException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return pipProgram;
	}

	/**
	 * Returns the pip program with the primary key or throws a <code>NoSuchPipProgramException</code> if it could not be found.
	 *
	 * @param pipProgramId the primary key of the pip program
	 * @return the pip program
	 * @throws NoSuchPipProgramException if a pip program with the primary key could not be found
	 */
	@Override
	public PipProgram findByPrimaryKey(long pipProgramId)
		throws NoSuchPipProgramException {

		return findByPrimaryKey((Serializable)pipProgramId);
	}

	/**
	 * Returns the pip program with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param pipProgramId the primary key of the pip program
	 * @return the pip program, or <code>null</code> if a pip program with the primary key could not be found
	 */
	@Override
	public PipProgram fetchByPrimaryKey(long pipProgramId) {
		return fetchByPrimaryKey((Serializable)pipProgramId);
	}

	/**
	 * Returns all the pip programs.
	 *
	 * @return the pip programs
	 */
	@Override
	public List<PipProgram> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the pip programs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PipProgramModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pip programs
	 * @param end the upper bound of the range of pip programs (not inclusive)
	 * @return the range of pip programs
	 */
	@Override
	public List<PipProgram> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the pip programs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PipProgramModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pip programs
	 * @param end the upper bound of the range of pip programs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of pip programs
	 */
	@Override
	public List<PipProgram> findAll(
		int start, int end, OrderByComparator<PipProgram> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the pip programs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PipProgramModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pip programs
	 * @param end the upper bound of the range of pip programs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of pip programs
	 */
	@Override
	public List<PipProgram> findAll(
		int start, int end, OrderByComparator<PipProgram> orderByComparator,
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

		List<PipProgram> list = null;

		if (useFinderCache) {
			list = (List<PipProgram>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PIPPROGRAM);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PIPPROGRAM;

				sql = sql.concat(PipProgramModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<PipProgram>)QueryUtil.list(
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
	 * Removes all the pip programs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (PipProgram pipProgram : findAll()) {
			remove(pipProgram);
		}
	}

	/**
	 * Returns the number of pip programs.
	 *
	 * @return the number of pip programs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_PIPPROGRAM);

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
		return "pipProgramId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PIPPROGRAM;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return PipProgramModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the pip program persistence.
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

		PipProgramUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		PipProgramUtil.setPersistence(null);

		entityCache.removeCache(PipProgramImpl.class.getName());
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

	private static final String _SQL_SELECT_PIPPROGRAM =
		"SELECT pipProgram FROM PipProgram pipProgram";

	private static final String _SQL_SELECT_PIPPROGRAM_WHERE =
		"SELECT pipProgram FROM PipProgram pipProgram WHERE ";

	private static final String _SQL_COUNT_PIPPROGRAM =
		"SELECT COUNT(pipProgram) FROM PipProgram pipProgram";

	private static final String _SQL_COUNT_PIPPROGRAM_WHERE =
		"SELECT COUNT(pipProgram) FROM PipProgram pipProgram WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "pipProgram.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No PipProgram exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No PipProgram exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		PipProgramPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}