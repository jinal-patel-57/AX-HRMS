/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence.impl;

import com.ax.hrms.exception.NoSuchProjectEmployeeDetailsException;
import com.ax.hrms.model.ProjectEmployeeDetails;
import com.ax.hrms.model.ProjectEmployeeDetailsTable;
import com.ax.hrms.model.impl.ProjectEmployeeDetailsImpl;
import com.ax.hrms.model.impl.ProjectEmployeeDetailsModelImpl;
import com.ax.hrms.service.persistence.ProjectEmployeeDetailsPersistence;
import com.ax.hrms.service.persistence.ProjectEmployeeDetailsUtil;
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
 * The persistence implementation for the project employee details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ProjectEmployeeDetailsPersistence.class)
public class ProjectEmployeeDetailsPersistenceImpl
	extends BasePersistenceImpl<ProjectEmployeeDetails>
	implements ProjectEmployeeDetailsPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ProjectEmployeeDetailsUtil</code> to access the project employee details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ProjectEmployeeDetailsImpl.class.getName();

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
	 * Returns all the project employee detailses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching project employee detailses
	 */
	@Override
	public List<ProjectEmployeeDetails> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the project employee detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectEmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of project employee detailses
	 * @param end the upper bound of the range of project employee detailses (not inclusive)
	 * @return the range of matching project employee detailses
	 */
	@Override
	public List<ProjectEmployeeDetails> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the project employee detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectEmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of project employee detailses
	 * @param end the upper bound of the range of project employee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching project employee detailses
	 */
	@Override
	public List<ProjectEmployeeDetails> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProjectEmployeeDetails> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the project employee detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectEmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of project employee detailses
	 * @param end the upper bound of the range of project employee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching project employee detailses
	 */
	@Override
	public List<ProjectEmployeeDetails> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProjectEmployeeDetails> orderByComparator,
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

		List<ProjectEmployeeDetails> list = null;

		if (useFinderCache) {
			list = (List<ProjectEmployeeDetails>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProjectEmployeeDetails projectEmployeeDetails : list) {
					if (!uuid.equals(projectEmployeeDetails.getUuid())) {
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

			sb.append(_SQL_SELECT_PROJECTEMPLOYEEDETAILS_WHERE);

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
				sb.append(ProjectEmployeeDetailsModelImpl.ORDER_BY_JPQL);
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

				list = (List<ProjectEmployeeDetails>)QueryUtil.list(
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
	 * Returns the first project employee details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project employee details
	 * @throws NoSuchProjectEmployeeDetailsException if a matching project employee details could not be found
	 */
	@Override
	public ProjectEmployeeDetails findByUuid_First(
			String uuid,
			OrderByComparator<ProjectEmployeeDetails> orderByComparator)
		throws NoSuchProjectEmployeeDetailsException {

		ProjectEmployeeDetails projectEmployeeDetails = fetchByUuid_First(
			uuid, orderByComparator);

		if (projectEmployeeDetails != null) {
			return projectEmployeeDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchProjectEmployeeDetailsException(sb.toString());
	}

	/**
	 * Returns the first project employee details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project employee details, or <code>null</code> if a matching project employee details could not be found
	 */
	@Override
	public ProjectEmployeeDetails fetchByUuid_First(
		String uuid,
		OrderByComparator<ProjectEmployeeDetails> orderByComparator) {

		List<ProjectEmployeeDetails> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last project employee details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project employee details
	 * @throws NoSuchProjectEmployeeDetailsException if a matching project employee details could not be found
	 */
	@Override
	public ProjectEmployeeDetails findByUuid_Last(
			String uuid,
			OrderByComparator<ProjectEmployeeDetails> orderByComparator)
		throws NoSuchProjectEmployeeDetailsException {

		ProjectEmployeeDetails projectEmployeeDetails = fetchByUuid_Last(
			uuid, orderByComparator);

		if (projectEmployeeDetails != null) {
			return projectEmployeeDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchProjectEmployeeDetailsException(sb.toString());
	}

	/**
	 * Returns the last project employee details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project employee details, or <code>null</code> if a matching project employee details could not be found
	 */
	@Override
	public ProjectEmployeeDetails fetchByUuid_Last(
		String uuid,
		OrderByComparator<ProjectEmployeeDetails> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ProjectEmployeeDetails> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the project employee detailses before and after the current project employee details in the ordered set where uuid = &#63;.
	 *
	 * @param projectEmployeeDetailsId the primary key of the current project employee details
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next project employee details
	 * @throws NoSuchProjectEmployeeDetailsException if a project employee details with the primary key could not be found
	 */
	@Override
	public ProjectEmployeeDetails[] findByUuid_PrevAndNext(
			long projectEmployeeDetailsId, String uuid,
			OrderByComparator<ProjectEmployeeDetails> orderByComparator)
		throws NoSuchProjectEmployeeDetailsException {

		uuid = Objects.toString(uuid, "");

		ProjectEmployeeDetails projectEmployeeDetails = findByPrimaryKey(
			projectEmployeeDetailsId);

		Session session = null;

		try {
			session = openSession();

			ProjectEmployeeDetails[] array = new ProjectEmployeeDetailsImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, projectEmployeeDetails, uuid, orderByComparator, true);

			array[1] = projectEmployeeDetails;

			array[2] = getByUuid_PrevAndNext(
				session, projectEmployeeDetails, uuid, orderByComparator,
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

	protected ProjectEmployeeDetails getByUuid_PrevAndNext(
		Session session, ProjectEmployeeDetails projectEmployeeDetails,
		String uuid,
		OrderByComparator<ProjectEmployeeDetails> orderByComparator,
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

		sb.append(_SQL_SELECT_PROJECTEMPLOYEEDETAILS_WHERE);

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
			sb.append(ProjectEmployeeDetailsModelImpl.ORDER_BY_JPQL);
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
						projectEmployeeDetails)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProjectEmployeeDetails> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the project employee detailses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (ProjectEmployeeDetails projectEmployeeDetails :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(projectEmployeeDetails);
		}
	}

	/**
	 * Returns the number of project employee detailses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching project employee detailses
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PROJECTEMPLOYEEDETAILS_WHERE);

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
		"projectEmployeeDetails.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(projectEmployeeDetails.uuid IS NULL OR projectEmployeeDetails.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;

	/**
	 * Returns the project employee details where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProjectEmployeeDetailsException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching project employee details
	 * @throws NoSuchProjectEmployeeDetailsException if a matching project employee details could not be found
	 */
	@Override
	public ProjectEmployeeDetails findByUUID_G(String uuid, long groupId)
		throws NoSuchProjectEmployeeDetailsException {

		ProjectEmployeeDetails projectEmployeeDetails = fetchByUUID_G(
			uuid, groupId);

		if (projectEmployeeDetails == null) {
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

			throw new NoSuchProjectEmployeeDetailsException(sb.toString());
		}

		return projectEmployeeDetails;
	}

	/**
	 * Returns the project employee details where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching project employee details, or <code>null</code> if a matching project employee details could not be found
	 */
	@Override
	public ProjectEmployeeDetails fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the project employee details where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching project employee details, or <code>null</code> if a matching project employee details could not be found
	 */
	@Override
	public ProjectEmployeeDetails fetchByUUID_G(
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

		if (result instanceof ProjectEmployeeDetails) {
			ProjectEmployeeDetails projectEmployeeDetails =
				(ProjectEmployeeDetails)result;

			if (!Objects.equals(uuid, projectEmployeeDetails.getUuid()) ||
				(groupId != projectEmployeeDetails.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_PROJECTEMPLOYEEDETAILS_WHERE);

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

				List<ProjectEmployeeDetails> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					ProjectEmployeeDetails projectEmployeeDetails = list.get(0);

					result = projectEmployeeDetails;

					cacheResult(projectEmployeeDetails);
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
			return (ProjectEmployeeDetails)result;
		}
	}

	/**
	 * Removes the project employee details where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the project employee details that was removed
	 */
	@Override
	public ProjectEmployeeDetails removeByUUID_G(String uuid, long groupId)
		throws NoSuchProjectEmployeeDetailsException {

		ProjectEmployeeDetails projectEmployeeDetails = findByUUID_G(
			uuid, groupId);

		return remove(projectEmployeeDetails);
	}

	/**
	 * Returns the number of project employee detailses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching project employee detailses
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		ProjectEmployeeDetails projectEmployeeDetails = fetchByUUID_G(
			uuid, groupId);

		if (projectEmployeeDetails == null) {
			return 0;
		}

		return 1;
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"projectEmployeeDetails.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(projectEmployeeDetails.uuid IS NULL OR projectEmployeeDetails.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"projectEmployeeDetails.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the project employee detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching project employee detailses
	 */
	@Override
	public List<ProjectEmployeeDetails> findByUuid_C(
		String uuid, long companyId) {

		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the project employee detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectEmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of project employee detailses
	 * @param end the upper bound of the range of project employee detailses (not inclusive)
	 * @return the range of matching project employee detailses
	 */
	@Override
	public List<ProjectEmployeeDetails> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the project employee detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectEmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of project employee detailses
	 * @param end the upper bound of the range of project employee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching project employee detailses
	 */
	@Override
	public List<ProjectEmployeeDetails> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProjectEmployeeDetails> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the project employee detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectEmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of project employee detailses
	 * @param end the upper bound of the range of project employee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching project employee detailses
	 */
	@Override
	public List<ProjectEmployeeDetails> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProjectEmployeeDetails> orderByComparator,
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

		List<ProjectEmployeeDetails> list = null;

		if (useFinderCache) {
			list = (List<ProjectEmployeeDetails>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProjectEmployeeDetails projectEmployeeDetails : list) {
					if (!uuid.equals(projectEmployeeDetails.getUuid()) ||
						(companyId != projectEmployeeDetails.getCompanyId())) {

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

			sb.append(_SQL_SELECT_PROJECTEMPLOYEEDETAILS_WHERE);

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
				sb.append(ProjectEmployeeDetailsModelImpl.ORDER_BY_JPQL);
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

				list = (List<ProjectEmployeeDetails>)QueryUtil.list(
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
	 * Returns the first project employee details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project employee details
	 * @throws NoSuchProjectEmployeeDetailsException if a matching project employee details could not be found
	 */
	@Override
	public ProjectEmployeeDetails findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ProjectEmployeeDetails> orderByComparator)
		throws NoSuchProjectEmployeeDetailsException {

		ProjectEmployeeDetails projectEmployeeDetails = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (projectEmployeeDetails != null) {
			return projectEmployeeDetails;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchProjectEmployeeDetailsException(sb.toString());
	}

	/**
	 * Returns the first project employee details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project employee details, or <code>null</code> if a matching project employee details could not be found
	 */
	@Override
	public ProjectEmployeeDetails fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ProjectEmployeeDetails> orderByComparator) {

		List<ProjectEmployeeDetails> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last project employee details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project employee details
	 * @throws NoSuchProjectEmployeeDetailsException if a matching project employee details could not be found
	 */
	@Override
	public ProjectEmployeeDetails findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ProjectEmployeeDetails> orderByComparator)
		throws NoSuchProjectEmployeeDetailsException {

		ProjectEmployeeDetails projectEmployeeDetails = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (projectEmployeeDetails != null) {
			return projectEmployeeDetails;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchProjectEmployeeDetailsException(sb.toString());
	}

	/**
	 * Returns the last project employee details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project employee details, or <code>null</code> if a matching project employee details could not be found
	 */
	@Override
	public ProjectEmployeeDetails fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ProjectEmployeeDetails> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<ProjectEmployeeDetails> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the project employee detailses before and after the current project employee details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param projectEmployeeDetailsId the primary key of the current project employee details
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next project employee details
	 * @throws NoSuchProjectEmployeeDetailsException if a project employee details with the primary key could not be found
	 */
	@Override
	public ProjectEmployeeDetails[] findByUuid_C_PrevAndNext(
			long projectEmployeeDetailsId, String uuid, long companyId,
			OrderByComparator<ProjectEmployeeDetails> orderByComparator)
		throws NoSuchProjectEmployeeDetailsException {

		uuid = Objects.toString(uuid, "");

		ProjectEmployeeDetails projectEmployeeDetails = findByPrimaryKey(
			projectEmployeeDetailsId);

		Session session = null;

		try {
			session = openSession();

			ProjectEmployeeDetails[] array = new ProjectEmployeeDetailsImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, projectEmployeeDetails, uuid, companyId,
				orderByComparator, true);

			array[1] = projectEmployeeDetails;

			array[2] = getByUuid_C_PrevAndNext(
				session, projectEmployeeDetails, uuid, companyId,
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

	protected ProjectEmployeeDetails getByUuid_C_PrevAndNext(
		Session session, ProjectEmployeeDetails projectEmployeeDetails,
		String uuid, long companyId,
		OrderByComparator<ProjectEmployeeDetails> orderByComparator,
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

		sb.append(_SQL_SELECT_PROJECTEMPLOYEEDETAILS_WHERE);

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
			sb.append(ProjectEmployeeDetailsModelImpl.ORDER_BY_JPQL);
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
						projectEmployeeDetails)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProjectEmployeeDetails> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the project employee detailses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (ProjectEmployeeDetails projectEmployeeDetails :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(projectEmployeeDetails);
		}
	}

	/**
	 * Returns the number of project employee detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching project employee detailses
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PROJECTEMPLOYEEDETAILS_WHERE);

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
		"projectEmployeeDetails.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(projectEmployeeDetails.uuid IS NULL OR projectEmployeeDetails.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"projectEmployeeDetails.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByProjectId;
	private FinderPath _finderPathWithoutPaginationFindByProjectId;
	private FinderPath _finderPathCountByProjectId;

	/**
	 * Returns all the project employee detailses where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @return the matching project employee detailses
	 */
	@Override
	public List<ProjectEmployeeDetails> findByProjectId(long projectId) {
		return findByProjectId(
			projectId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the project employee detailses where projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectEmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param projectId the project ID
	 * @param start the lower bound of the range of project employee detailses
	 * @param end the upper bound of the range of project employee detailses (not inclusive)
	 * @return the range of matching project employee detailses
	 */
	@Override
	public List<ProjectEmployeeDetails> findByProjectId(
		long projectId, int start, int end) {

		return findByProjectId(projectId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the project employee detailses where projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectEmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param projectId the project ID
	 * @param start the lower bound of the range of project employee detailses
	 * @param end the upper bound of the range of project employee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching project employee detailses
	 */
	@Override
	public List<ProjectEmployeeDetails> findByProjectId(
		long projectId, int start, int end,
		OrderByComparator<ProjectEmployeeDetails> orderByComparator) {

		return findByProjectId(projectId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the project employee detailses where projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectEmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param projectId the project ID
	 * @param start the lower bound of the range of project employee detailses
	 * @param end the upper bound of the range of project employee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching project employee detailses
	 */
	@Override
	public List<ProjectEmployeeDetails> findByProjectId(
		long projectId, int start, int end,
		OrderByComparator<ProjectEmployeeDetails> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByProjectId;
				finderArgs = new Object[] {projectId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByProjectId;
			finderArgs = new Object[] {
				projectId, start, end, orderByComparator
			};
		}

		List<ProjectEmployeeDetails> list = null;

		if (useFinderCache) {
			list = (List<ProjectEmployeeDetails>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProjectEmployeeDetails projectEmployeeDetails : list) {
					if (projectId != projectEmployeeDetails.getProjectId()) {
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

			sb.append(_SQL_SELECT_PROJECTEMPLOYEEDETAILS_WHERE);

			sb.append(_FINDER_COLUMN_PROJECTID_PROJECTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ProjectEmployeeDetailsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(projectId);

				list = (List<ProjectEmployeeDetails>)QueryUtil.list(
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
	 * Returns the first project employee details in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project employee details
	 * @throws NoSuchProjectEmployeeDetailsException if a matching project employee details could not be found
	 */
	@Override
	public ProjectEmployeeDetails findByProjectId_First(
			long projectId,
			OrderByComparator<ProjectEmployeeDetails> orderByComparator)
		throws NoSuchProjectEmployeeDetailsException {

		ProjectEmployeeDetails projectEmployeeDetails = fetchByProjectId_First(
			projectId, orderByComparator);

		if (projectEmployeeDetails != null) {
			return projectEmployeeDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("projectId=");
		sb.append(projectId);

		sb.append("}");

		throw new NoSuchProjectEmployeeDetailsException(sb.toString());
	}

	/**
	 * Returns the first project employee details in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project employee details, or <code>null</code> if a matching project employee details could not be found
	 */
	@Override
	public ProjectEmployeeDetails fetchByProjectId_First(
		long projectId,
		OrderByComparator<ProjectEmployeeDetails> orderByComparator) {

		List<ProjectEmployeeDetails> list = findByProjectId(
			projectId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last project employee details in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project employee details
	 * @throws NoSuchProjectEmployeeDetailsException if a matching project employee details could not be found
	 */
	@Override
	public ProjectEmployeeDetails findByProjectId_Last(
			long projectId,
			OrderByComparator<ProjectEmployeeDetails> orderByComparator)
		throws NoSuchProjectEmployeeDetailsException {

		ProjectEmployeeDetails projectEmployeeDetails = fetchByProjectId_Last(
			projectId, orderByComparator);

		if (projectEmployeeDetails != null) {
			return projectEmployeeDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("projectId=");
		sb.append(projectId);

		sb.append("}");

		throw new NoSuchProjectEmployeeDetailsException(sb.toString());
	}

	/**
	 * Returns the last project employee details in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project employee details, or <code>null</code> if a matching project employee details could not be found
	 */
	@Override
	public ProjectEmployeeDetails fetchByProjectId_Last(
		long projectId,
		OrderByComparator<ProjectEmployeeDetails> orderByComparator) {

		int count = countByProjectId(projectId);

		if (count == 0) {
			return null;
		}

		List<ProjectEmployeeDetails> list = findByProjectId(
			projectId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the project employee detailses before and after the current project employee details in the ordered set where projectId = &#63;.
	 *
	 * @param projectEmployeeDetailsId the primary key of the current project employee details
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next project employee details
	 * @throws NoSuchProjectEmployeeDetailsException if a project employee details with the primary key could not be found
	 */
	@Override
	public ProjectEmployeeDetails[] findByProjectId_PrevAndNext(
			long projectEmployeeDetailsId, long projectId,
			OrderByComparator<ProjectEmployeeDetails> orderByComparator)
		throws NoSuchProjectEmployeeDetailsException {

		ProjectEmployeeDetails projectEmployeeDetails = findByPrimaryKey(
			projectEmployeeDetailsId);

		Session session = null;

		try {
			session = openSession();

			ProjectEmployeeDetails[] array = new ProjectEmployeeDetailsImpl[3];

			array[0] = getByProjectId_PrevAndNext(
				session, projectEmployeeDetails, projectId, orderByComparator,
				true);

			array[1] = projectEmployeeDetails;

			array[2] = getByProjectId_PrevAndNext(
				session, projectEmployeeDetails, projectId, orderByComparator,
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

	protected ProjectEmployeeDetails getByProjectId_PrevAndNext(
		Session session, ProjectEmployeeDetails projectEmployeeDetails,
		long projectId,
		OrderByComparator<ProjectEmployeeDetails> orderByComparator,
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

		sb.append(_SQL_SELECT_PROJECTEMPLOYEEDETAILS_WHERE);

		sb.append(_FINDER_COLUMN_PROJECTID_PROJECTID_2);

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
			sb.append(ProjectEmployeeDetailsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(projectId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						projectEmployeeDetails)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProjectEmployeeDetails> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the project employee detailses where projectId = &#63; from the database.
	 *
	 * @param projectId the project ID
	 */
	@Override
	public void removeByProjectId(long projectId) {
		for (ProjectEmployeeDetails projectEmployeeDetails :
				findByProjectId(
					projectId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(projectEmployeeDetails);
		}
	}

	/**
	 * Returns the number of project employee detailses where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @return the number of matching project employee detailses
	 */
	@Override
	public int countByProjectId(long projectId) {
		FinderPath finderPath = _finderPathCountByProjectId;

		Object[] finderArgs = new Object[] {projectId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PROJECTEMPLOYEEDETAILS_WHERE);

			sb.append(_FINDER_COLUMN_PROJECTID_PROJECTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(projectId);

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

	private static final String _FINDER_COLUMN_PROJECTID_PROJECTID_2 =
		"projectEmployeeDetails.projectId = ?";

	private FinderPath _finderPathWithPaginationFindByEmployeeId;
	private FinderPath _finderPathWithoutPaginationFindByEmployeeId;
	private FinderPath _finderPathCountByEmployeeId;

	/**
	 * Returns all the project employee detailses where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching project employee detailses
	 */
	@Override
	public List<ProjectEmployeeDetails> findByEmployeeId(long employeeId) {
		return findByEmployeeId(
			employeeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the project employee detailses where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectEmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of project employee detailses
	 * @param end the upper bound of the range of project employee detailses (not inclusive)
	 * @return the range of matching project employee detailses
	 */
	@Override
	public List<ProjectEmployeeDetails> findByEmployeeId(
		long employeeId, int start, int end) {

		return findByEmployeeId(employeeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the project employee detailses where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectEmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of project employee detailses
	 * @param end the upper bound of the range of project employee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching project employee detailses
	 */
	@Override
	public List<ProjectEmployeeDetails> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<ProjectEmployeeDetails> orderByComparator) {

		return findByEmployeeId(
			employeeId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the project employee detailses where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectEmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of project employee detailses
	 * @param end the upper bound of the range of project employee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching project employee detailses
	 */
	@Override
	public List<ProjectEmployeeDetails> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<ProjectEmployeeDetails> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByEmployeeId;
				finderArgs = new Object[] {employeeId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByEmployeeId;
			finderArgs = new Object[] {
				employeeId, start, end, orderByComparator
			};
		}

		List<ProjectEmployeeDetails> list = null;

		if (useFinderCache) {
			list = (List<ProjectEmployeeDetails>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProjectEmployeeDetails projectEmployeeDetails : list) {
					if (employeeId != projectEmployeeDetails.getEmployeeId()) {
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

			sb.append(_SQL_SELECT_PROJECTEMPLOYEEDETAILS_WHERE);

			sb.append(_FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ProjectEmployeeDetailsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(employeeId);

				list = (List<ProjectEmployeeDetails>)QueryUtil.list(
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
	 * Returns the first project employee details in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project employee details
	 * @throws NoSuchProjectEmployeeDetailsException if a matching project employee details could not be found
	 */
	@Override
	public ProjectEmployeeDetails findByEmployeeId_First(
			long employeeId,
			OrderByComparator<ProjectEmployeeDetails> orderByComparator)
		throws NoSuchProjectEmployeeDetailsException {

		ProjectEmployeeDetails projectEmployeeDetails = fetchByEmployeeId_First(
			employeeId, orderByComparator);

		if (projectEmployeeDetails != null) {
			return projectEmployeeDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("employeeId=");
		sb.append(employeeId);

		sb.append("}");

		throw new NoSuchProjectEmployeeDetailsException(sb.toString());
	}

	/**
	 * Returns the first project employee details in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project employee details, or <code>null</code> if a matching project employee details could not be found
	 */
	@Override
	public ProjectEmployeeDetails fetchByEmployeeId_First(
		long employeeId,
		OrderByComparator<ProjectEmployeeDetails> orderByComparator) {

		List<ProjectEmployeeDetails> list = findByEmployeeId(
			employeeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last project employee details in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project employee details
	 * @throws NoSuchProjectEmployeeDetailsException if a matching project employee details could not be found
	 */
	@Override
	public ProjectEmployeeDetails findByEmployeeId_Last(
			long employeeId,
			OrderByComparator<ProjectEmployeeDetails> orderByComparator)
		throws NoSuchProjectEmployeeDetailsException {

		ProjectEmployeeDetails projectEmployeeDetails = fetchByEmployeeId_Last(
			employeeId, orderByComparator);

		if (projectEmployeeDetails != null) {
			return projectEmployeeDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("employeeId=");
		sb.append(employeeId);

		sb.append("}");

		throw new NoSuchProjectEmployeeDetailsException(sb.toString());
	}

	/**
	 * Returns the last project employee details in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project employee details, or <code>null</code> if a matching project employee details could not be found
	 */
	@Override
	public ProjectEmployeeDetails fetchByEmployeeId_Last(
		long employeeId,
		OrderByComparator<ProjectEmployeeDetails> orderByComparator) {

		int count = countByEmployeeId(employeeId);

		if (count == 0) {
			return null;
		}

		List<ProjectEmployeeDetails> list = findByEmployeeId(
			employeeId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the project employee detailses before and after the current project employee details in the ordered set where employeeId = &#63;.
	 *
	 * @param projectEmployeeDetailsId the primary key of the current project employee details
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next project employee details
	 * @throws NoSuchProjectEmployeeDetailsException if a project employee details with the primary key could not be found
	 */
	@Override
	public ProjectEmployeeDetails[] findByEmployeeId_PrevAndNext(
			long projectEmployeeDetailsId, long employeeId,
			OrderByComparator<ProjectEmployeeDetails> orderByComparator)
		throws NoSuchProjectEmployeeDetailsException {

		ProjectEmployeeDetails projectEmployeeDetails = findByPrimaryKey(
			projectEmployeeDetailsId);

		Session session = null;

		try {
			session = openSession();

			ProjectEmployeeDetails[] array = new ProjectEmployeeDetailsImpl[3];

			array[0] = getByEmployeeId_PrevAndNext(
				session, projectEmployeeDetails, employeeId, orderByComparator,
				true);

			array[1] = projectEmployeeDetails;

			array[2] = getByEmployeeId_PrevAndNext(
				session, projectEmployeeDetails, employeeId, orderByComparator,
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

	protected ProjectEmployeeDetails getByEmployeeId_PrevAndNext(
		Session session, ProjectEmployeeDetails projectEmployeeDetails,
		long employeeId,
		OrderByComparator<ProjectEmployeeDetails> orderByComparator,
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

		sb.append(_SQL_SELECT_PROJECTEMPLOYEEDETAILS_WHERE);

		sb.append(_FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2);

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
			sb.append(ProjectEmployeeDetailsModelImpl.ORDER_BY_JPQL);
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
						projectEmployeeDetails)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProjectEmployeeDetails> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the project employee detailses where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	@Override
	public void removeByEmployeeId(long employeeId) {
		for (ProjectEmployeeDetails projectEmployeeDetails :
				findByEmployeeId(
					employeeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(projectEmployeeDetails);
		}
	}

	/**
	 * Returns the number of project employee detailses where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching project employee detailses
	 */
	@Override
	public int countByEmployeeId(long employeeId) {
		FinderPath finderPath = _finderPathCountByEmployeeId;

		Object[] finderArgs = new Object[] {employeeId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PROJECTEMPLOYEEDETAILS_WHERE);

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
		"projectEmployeeDetails.employeeId = ?";

	private FinderPath _finderPathFetchByProjectIdAndEmployeeId;

	/**
	 * Returns the project employee details where projectId = &#63; and employeeId = &#63; or throws a <code>NoSuchProjectEmployeeDetailsException</code> if it could not be found.
	 *
	 * @param projectId the project ID
	 * @param employeeId the employee ID
	 * @return the matching project employee details
	 * @throws NoSuchProjectEmployeeDetailsException if a matching project employee details could not be found
	 */
	@Override
	public ProjectEmployeeDetails findByProjectIdAndEmployeeId(
			long projectId, long employeeId)
		throws NoSuchProjectEmployeeDetailsException {

		ProjectEmployeeDetails projectEmployeeDetails =
			fetchByProjectIdAndEmployeeId(projectId, employeeId);

		if (projectEmployeeDetails == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("projectId=");
			sb.append(projectId);

			sb.append(", employeeId=");
			sb.append(employeeId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchProjectEmployeeDetailsException(sb.toString());
		}

		return projectEmployeeDetails;
	}

	/**
	 * Returns the project employee details where projectId = &#63; and employeeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param projectId the project ID
	 * @param employeeId the employee ID
	 * @return the matching project employee details, or <code>null</code> if a matching project employee details could not be found
	 */
	@Override
	public ProjectEmployeeDetails fetchByProjectIdAndEmployeeId(
		long projectId, long employeeId) {

		return fetchByProjectIdAndEmployeeId(projectId, employeeId, true);
	}

	/**
	 * Returns the project employee details where projectId = &#63; and employeeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param projectId the project ID
	 * @param employeeId the employee ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching project employee details, or <code>null</code> if a matching project employee details could not be found
	 */
	@Override
	public ProjectEmployeeDetails fetchByProjectIdAndEmployeeId(
		long projectId, long employeeId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {projectId, employeeId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByProjectIdAndEmployeeId, finderArgs, this);
		}

		if (result instanceof ProjectEmployeeDetails) {
			ProjectEmployeeDetails projectEmployeeDetails =
				(ProjectEmployeeDetails)result;

			if ((projectId != projectEmployeeDetails.getProjectId()) ||
				(employeeId != projectEmployeeDetails.getEmployeeId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_PROJECTEMPLOYEEDETAILS_WHERE);

			sb.append(_FINDER_COLUMN_PROJECTIDANDEMPLOYEEID_PROJECTID_2);

			sb.append(_FINDER_COLUMN_PROJECTIDANDEMPLOYEEID_EMPLOYEEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(projectId);

				queryPos.add(employeeId);

				List<ProjectEmployeeDetails> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByProjectIdAndEmployeeId,
							finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									projectId, employeeId
								};
							}

							_log.warn(
								"ProjectEmployeeDetailsPersistenceImpl.fetchByProjectIdAndEmployeeId(long, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					ProjectEmployeeDetails projectEmployeeDetails = list.get(0);

					result = projectEmployeeDetails;

					cacheResult(projectEmployeeDetails);
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
			return (ProjectEmployeeDetails)result;
		}
	}

	/**
	 * Removes the project employee details where projectId = &#63; and employeeId = &#63; from the database.
	 *
	 * @param projectId the project ID
	 * @param employeeId the employee ID
	 * @return the project employee details that was removed
	 */
	@Override
	public ProjectEmployeeDetails removeByProjectIdAndEmployeeId(
			long projectId, long employeeId)
		throws NoSuchProjectEmployeeDetailsException {

		ProjectEmployeeDetails projectEmployeeDetails =
			findByProjectIdAndEmployeeId(projectId, employeeId);

		return remove(projectEmployeeDetails);
	}

	/**
	 * Returns the number of project employee detailses where projectId = &#63; and employeeId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param employeeId the employee ID
	 * @return the number of matching project employee detailses
	 */
	@Override
	public int countByProjectIdAndEmployeeId(long projectId, long employeeId) {
		ProjectEmployeeDetails projectEmployeeDetails =
			fetchByProjectIdAndEmployeeId(projectId, employeeId);

		if (projectEmployeeDetails == null) {
			return 0;
		}

		return 1;
	}

	private static final String
		_FINDER_COLUMN_PROJECTIDANDEMPLOYEEID_PROJECTID_2 =
			"projectEmployeeDetails.projectId = ? AND ";

	private static final String
		_FINDER_COLUMN_PROJECTIDANDEMPLOYEEID_EMPLOYEEID_2 =
			"projectEmployeeDetails.employeeId = ?";

	public ProjectEmployeeDetailsPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(ProjectEmployeeDetails.class);

		setModelImplClass(ProjectEmployeeDetailsImpl.class);
		setModelPKClass(long.class);

		setTable(ProjectEmployeeDetailsTable.INSTANCE);
	}

	/**
	 * Caches the project employee details in the entity cache if it is enabled.
	 *
	 * @param projectEmployeeDetails the project employee details
	 */
	@Override
	public void cacheResult(ProjectEmployeeDetails projectEmployeeDetails) {
		entityCache.putResult(
			ProjectEmployeeDetailsImpl.class,
			projectEmployeeDetails.getPrimaryKey(), projectEmployeeDetails);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				projectEmployeeDetails.getUuid(),
				projectEmployeeDetails.getGroupId()
			},
			projectEmployeeDetails);

		finderCache.putResult(
			_finderPathFetchByProjectIdAndEmployeeId,
			new Object[] {
				projectEmployeeDetails.getProjectId(),
				projectEmployeeDetails.getEmployeeId()
			},
			projectEmployeeDetails);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the project employee detailses in the entity cache if it is enabled.
	 *
	 * @param projectEmployeeDetailses the project employee detailses
	 */
	@Override
	public void cacheResult(
		List<ProjectEmployeeDetails> projectEmployeeDetailses) {

		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (projectEmployeeDetailses.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (ProjectEmployeeDetails projectEmployeeDetails :
				projectEmployeeDetailses) {

			if (entityCache.getResult(
					ProjectEmployeeDetailsImpl.class,
					projectEmployeeDetails.getPrimaryKey()) == null) {

				cacheResult(projectEmployeeDetails);
			}
		}
	}

	/**
	 * Clears the cache for all project employee detailses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ProjectEmployeeDetailsImpl.class);

		finderCache.clearCache(ProjectEmployeeDetailsImpl.class);
	}

	/**
	 * Clears the cache for the project employee details.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ProjectEmployeeDetails projectEmployeeDetails) {
		entityCache.removeResult(
			ProjectEmployeeDetailsImpl.class, projectEmployeeDetails);
	}

	@Override
	public void clearCache(
		List<ProjectEmployeeDetails> projectEmployeeDetailses) {

		for (ProjectEmployeeDetails projectEmployeeDetails :
				projectEmployeeDetailses) {

			entityCache.removeResult(
				ProjectEmployeeDetailsImpl.class, projectEmployeeDetails);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(ProjectEmployeeDetailsImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				ProjectEmployeeDetailsImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		ProjectEmployeeDetailsModelImpl projectEmployeeDetailsModelImpl) {

		Object[] args = new Object[] {
			projectEmployeeDetailsModelImpl.getUuid(),
			projectEmployeeDetailsModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathFetchByUUID_G, args, projectEmployeeDetailsModelImpl);

		args = new Object[] {
			projectEmployeeDetailsModelImpl.getProjectId(),
			projectEmployeeDetailsModelImpl.getEmployeeId()
		};

		finderCache.putResult(
			_finderPathFetchByProjectIdAndEmployeeId, args,
			projectEmployeeDetailsModelImpl);
	}

	/**
	 * Creates a new project employee details with the primary key. Does not add the project employee details to the database.
	 *
	 * @param projectEmployeeDetailsId the primary key for the new project employee details
	 * @return the new project employee details
	 */
	@Override
	public ProjectEmployeeDetails create(long projectEmployeeDetailsId) {
		ProjectEmployeeDetails projectEmployeeDetails =
			new ProjectEmployeeDetailsImpl();

		projectEmployeeDetails.setNew(true);
		projectEmployeeDetails.setPrimaryKey(projectEmployeeDetailsId);

		String uuid = PortalUUIDUtil.generate();

		projectEmployeeDetails.setUuid(uuid);

		projectEmployeeDetails.setCompanyId(CompanyThreadLocal.getCompanyId());

		return projectEmployeeDetails;
	}

	/**
	 * Removes the project employee details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param projectEmployeeDetailsId the primary key of the project employee details
	 * @return the project employee details that was removed
	 * @throws NoSuchProjectEmployeeDetailsException if a project employee details with the primary key could not be found
	 */
	@Override
	public ProjectEmployeeDetails remove(long projectEmployeeDetailsId)
		throws NoSuchProjectEmployeeDetailsException {

		return remove((Serializable)projectEmployeeDetailsId);
	}

	/**
	 * Removes the project employee details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the project employee details
	 * @return the project employee details that was removed
	 * @throws NoSuchProjectEmployeeDetailsException if a project employee details with the primary key could not be found
	 */
	@Override
	public ProjectEmployeeDetails remove(Serializable primaryKey)
		throws NoSuchProjectEmployeeDetailsException {

		Session session = null;

		try {
			session = openSession();

			ProjectEmployeeDetails projectEmployeeDetails =
				(ProjectEmployeeDetails)session.get(
					ProjectEmployeeDetailsImpl.class, primaryKey);

			if (projectEmployeeDetails == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProjectEmployeeDetailsException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(projectEmployeeDetails);
		}
		catch (NoSuchProjectEmployeeDetailsException noSuchEntityException) {
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
	protected ProjectEmployeeDetails removeImpl(
		ProjectEmployeeDetails projectEmployeeDetails) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(projectEmployeeDetails)) {
				projectEmployeeDetails = (ProjectEmployeeDetails)session.get(
					ProjectEmployeeDetailsImpl.class,
					projectEmployeeDetails.getPrimaryKeyObj());
			}

			if (projectEmployeeDetails != null) {
				session.delete(projectEmployeeDetails);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (projectEmployeeDetails != null) {
			clearCache(projectEmployeeDetails);
		}

		return projectEmployeeDetails;
	}

	@Override
	public ProjectEmployeeDetails updateImpl(
		ProjectEmployeeDetails projectEmployeeDetails) {

		boolean isNew = projectEmployeeDetails.isNew();

		if (!(projectEmployeeDetails instanceof
				ProjectEmployeeDetailsModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(projectEmployeeDetails.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					projectEmployeeDetails);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in projectEmployeeDetails proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ProjectEmployeeDetails implementation " +
					projectEmployeeDetails.getClass());
		}

		ProjectEmployeeDetailsModelImpl projectEmployeeDetailsModelImpl =
			(ProjectEmployeeDetailsModelImpl)projectEmployeeDetails;

		if (Validator.isNull(projectEmployeeDetails.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			projectEmployeeDetails.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (projectEmployeeDetails.getCreateDate() == null)) {
			if (serviceContext == null) {
				projectEmployeeDetails.setCreateDate(date);
			}
			else {
				projectEmployeeDetails.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!projectEmployeeDetailsModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				projectEmployeeDetails.setModifiedDate(date);
			}
			else {
				projectEmployeeDetails.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(projectEmployeeDetails);
			}
			else {
				projectEmployeeDetails = (ProjectEmployeeDetails)session.merge(
					projectEmployeeDetails);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ProjectEmployeeDetailsImpl.class, projectEmployeeDetailsModelImpl,
			false, true);

		cacheUniqueFindersCache(projectEmployeeDetailsModelImpl);

		if (isNew) {
			projectEmployeeDetails.setNew(false);
		}

		projectEmployeeDetails.resetOriginalValues();

		return projectEmployeeDetails;
	}

	/**
	 * Returns the project employee details with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the project employee details
	 * @return the project employee details
	 * @throws NoSuchProjectEmployeeDetailsException if a project employee details with the primary key could not be found
	 */
	@Override
	public ProjectEmployeeDetails findByPrimaryKey(Serializable primaryKey)
		throws NoSuchProjectEmployeeDetailsException {

		ProjectEmployeeDetails projectEmployeeDetails = fetchByPrimaryKey(
			primaryKey);

		if (projectEmployeeDetails == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchProjectEmployeeDetailsException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return projectEmployeeDetails;
	}

	/**
	 * Returns the project employee details with the primary key or throws a <code>NoSuchProjectEmployeeDetailsException</code> if it could not be found.
	 *
	 * @param projectEmployeeDetailsId the primary key of the project employee details
	 * @return the project employee details
	 * @throws NoSuchProjectEmployeeDetailsException if a project employee details with the primary key could not be found
	 */
	@Override
	public ProjectEmployeeDetails findByPrimaryKey(
			long projectEmployeeDetailsId)
		throws NoSuchProjectEmployeeDetailsException {

		return findByPrimaryKey((Serializable)projectEmployeeDetailsId);
	}

	/**
	 * Returns the project employee details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param projectEmployeeDetailsId the primary key of the project employee details
	 * @return the project employee details, or <code>null</code> if a project employee details with the primary key could not be found
	 */
	@Override
	public ProjectEmployeeDetails fetchByPrimaryKey(
		long projectEmployeeDetailsId) {

		return fetchByPrimaryKey((Serializable)projectEmployeeDetailsId);
	}

	/**
	 * Returns all the project employee detailses.
	 *
	 * @return the project employee detailses
	 */
	@Override
	public List<ProjectEmployeeDetails> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the project employee detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectEmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of project employee detailses
	 * @param end the upper bound of the range of project employee detailses (not inclusive)
	 * @return the range of project employee detailses
	 */
	@Override
	public List<ProjectEmployeeDetails> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the project employee detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectEmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of project employee detailses
	 * @param end the upper bound of the range of project employee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of project employee detailses
	 */
	@Override
	public List<ProjectEmployeeDetails> findAll(
		int start, int end,
		OrderByComparator<ProjectEmployeeDetails> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the project employee detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectEmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of project employee detailses
	 * @param end the upper bound of the range of project employee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of project employee detailses
	 */
	@Override
	public List<ProjectEmployeeDetails> findAll(
		int start, int end,
		OrderByComparator<ProjectEmployeeDetails> orderByComparator,
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

		List<ProjectEmployeeDetails> list = null;

		if (useFinderCache) {
			list = (List<ProjectEmployeeDetails>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PROJECTEMPLOYEEDETAILS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PROJECTEMPLOYEEDETAILS;

				sql = sql.concat(ProjectEmployeeDetailsModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ProjectEmployeeDetails>)QueryUtil.list(
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
	 * Removes all the project employee detailses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ProjectEmployeeDetails projectEmployeeDetails : findAll()) {
			remove(projectEmployeeDetails);
		}
	}

	/**
	 * Returns the number of project employee detailses.
	 *
	 * @return the number of project employee detailses
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
					_SQL_COUNT_PROJECTEMPLOYEEDETAILS);

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
		return "projectEmployeeDetailsId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PROJECTEMPLOYEEDETAILS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ProjectEmployeeDetailsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the project employee details persistence.
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

		_finderPathWithPaginationFindByProjectId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByProjectId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"projectId"}, true);

		_finderPathWithoutPaginationFindByProjectId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByProjectId",
			new String[] {Long.class.getName()}, new String[] {"projectId"},
			true);

		_finderPathCountByProjectId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByProjectId",
			new String[] {Long.class.getName()}, new String[] {"projectId"},
			false);

		_finderPathWithPaginationFindByEmployeeId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByEmployeeId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"employeeId"}, true);

		_finderPathWithoutPaginationFindByEmployeeId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByEmployeeId",
			new String[] {Long.class.getName()}, new String[] {"employeeId"},
			true);

		_finderPathCountByEmployeeId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEmployeeId",
			new String[] {Long.class.getName()}, new String[] {"employeeId"},
			false);

		_finderPathFetchByProjectIdAndEmployeeId = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByProjectIdAndEmployeeId",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"projectId", "employeeId"}, true);

		ProjectEmployeeDetailsUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		ProjectEmployeeDetailsUtil.setPersistence(null);

		entityCache.removeCache(ProjectEmployeeDetailsImpl.class.getName());
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

	private static final String _SQL_SELECT_PROJECTEMPLOYEEDETAILS =
		"SELECT projectEmployeeDetails FROM ProjectEmployeeDetails projectEmployeeDetails";

	private static final String _SQL_SELECT_PROJECTEMPLOYEEDETAILS_WHERE =
		"SELECT projectEmployeeDetails FROM ProjectEmployeeDetails projectEmployeeDetails WHERE ";

	private static final String _SQL_COUNT_PROJECTEMPLOYEEDETAILS =
		"SELECT COUNT(projectEmployeeDetails) FROM ProjectEmployeeDetails projectEmployeeDetails";

	private static final String _SQL_COUNT_PROJECTEMPLOYEEDETAILS_WHERE =
		"SELECT COUNT(projectEmployeeDetails) FROM ProjectEmployeeDetails projectEmployeeDetails WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"projectEmployeeDetails.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ProjectEmployeeDetails exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ProjectEmployeeDetails exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ProjectEmployeeDetailsPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}