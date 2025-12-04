/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence.impl;

import com.ax.hrms.exception.NoSuchAppraisalFormTemplatesException;
import com.ax.hrms.model.AppraisalFormTemplates;
import com.ax.hrms.model.AppraisalFormTemplatesTable;
import com.ax.hrms.model.impl.AppraisalFormTemplatesImpl;
import com.ax.hrms.model.impl.AppraisalFormTemplatesModelImpl;
import com.ax.hrms.service.persistence.AppraisalFormTemplatesPersistence;
import com.ax.hrms.service.persistence.AppraisalFormTemplatesUtil;
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
 * The persistence implementation for the appraisal form templates service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = AppraisalFormTemplatesPersistence.class)
public class AppraisalFormTemplatesPersistenceImpl
	extends BasePersistenceImpl<AppraisalFormTemplates>
	implements AppraisalFormTemplatesPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>AppraisalFormTemplatesUtil</code> to access the appraisal form templates persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		AppraisalFormTemplatesImpl.class.getName();

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
	 * Returns all the appraisal form templateses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching appraisal form templateses
	 */
	@Override
	public List<AppraisalFormTemplates> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the appraisal form templateses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalFormTemplatesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of appraisal form templateses
	 * @param end the upper bound of the range of appraisal form templateses (not inclusive)
	 * @return the range of matching appraisal form templateses
	 */
	@Override
	public List<AppraisalFormTemplates> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the appraisal form templateses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalFormTemplatesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of appraisal form templateses
	 * @param end the upper bound of the range of appraisal form templateses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching appraisal form templateses
	 */
	@Override
	public List<AppraisalFormTemplates> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AppraisalFormTemplates> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the appraisal form templateses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalFormTemplatesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of appraisal form templateses
	 * @param end the upper bound of the range of appraisal form templateses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching appraisal form templateses
	 */
	@Override
	public List<AppraisalFormTemplates> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AppraisalFormTemplates> orderByComparator,
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

		List<AppraisalFormTemplates> list = null;

		if (useFinderCache) {
			list = (List<AppraisalFormTemplates>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AppraisalFormTemplates appraisalFormTemplates : list) {
					if (!uuid.equals(appraisalFormTemplates.getUuid())) {
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

			sb.append(_SQL_SELECT_APPRAISALFORMTEMPLATES_WHERE);

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
				sb.append(AppraisalFormTemplatesModelImpl.ORDER_BY_JPQL);
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

				list = (List<AppraisalFormTemplates>)QueryUtil.list(
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
	 * Returns the first appraisal form templates in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appraisal form templates
	 * @throws NoSuchAppraisalFormTemplatesException if a matching appraisal form templates could not be found
	 */
	@Override
	public AppraisalFormTemplates findByUuid_First(
			String uuid,
			OrderByComparator<AppraisalFormTemplates> orderByComparator)
		throws NoSuchAppraisalFormTemplatesException {

		AppraisalFormTemplates appraisalFormTemplates = fetchByUuid_First(
			uuid, orderByComparator);

		if (appraisalFormTemplates != null) {
			return appraisalFormTemplates;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchAppraisalFormTemplatesException(sb.toString());
	}

	/**
	 * Returns the first appraisal form templates in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appraisal form templates, or <code>null</code> if a matching appraisal form templates could not be found
	 */
	@Override
	public AppraisalFormTemplates fetchByUuid_First(
		String uuid,
		OrderByComparator<AppraisalFormTemplates> orderByComparator) {

		List<AppraisalFormTemplates> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last appraisal form templates in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appraisal form templates
	 * @throws NoSuchAppraisalFormTemplatesException if a matching appraisal form templates could not be found
	 */
	@Override
	public AppraisalFormTemplates findByUuid_Last(
			String uuid,
			OrderByComparator<AppraisalFormTemplates> orderByComparator)
		throws NoSuchAppraisalFormTemplatesException {

		AppraisalFormTemplates appraisalFormTemplates = fetchByUuid_Last(
			uuid, orderByComparator);

		if (appraisalFormTemplates != null) {
			return appraisalFormTemplates;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchAppraisalFormTemplatesException(sb.toString());
	}

	/**
	 * Returns the last appraisal form templates in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appraisal form templates, or <code>null</code> if a matching appraisal form templates could not be found
	 */
	@Override
	public AppraisalFormTemplates fetchByUuid_Last(
		String uuid,
		OrderByComparator<AppraisalFormTemplates> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<AppraisalFormTemplates> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the appraisal form templateses before and after the current appraisal form templates in the ordered set where uuid = &#63;.
	 *
	 * @param appraisalFormTemplateId the primary key of the current appraisal form templates
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next appraisal form templates
	 * @throws NoSuchAppraisalFormTemplatesException if a appraisal form templates with the primary key could not be found
	 */
	@Override
	public AppraisalFormTemplates[] findByUuid_PrevAndNext(
			long appraisalFormTemplateId, String uuid,
			OrderByComparator<AppraisalFormTemplates> orderByComparator)
		throws NoSuchAppraisalFormTemplatesException {

		uuid = Objects.toString(uuid, "");

		AppraisalFormTemplates appraisalFormTemplates = findByPrimaryKey(
			appraisalFormTemplateId);

		Session session = null;

		try {
			session = openSession();

			AppraisalFormTemplates[] array = new AppraisalFormTemplatesImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, appraisalFormTemplates, uuid, orderByComparator, true);

			array[1] = appraisalFormTemplates;

			array[2] = getByUuid_PrevAndNext(
				session, appraisalFormTemplates, uuid, orderByComparator,
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

	protected AppraisalFormTemplates getByUuid_PrevAndNext(
		Session session, AppraisalFormTemplates appraisalFormTemplates,
		String uuid,
		OrderByComparator<AppraisalFormTemplates> orderByComparator,
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

		sb.append(_SQL_SELECT_APPRAISALFORMTEMPLATES_WHERE);

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
			sb.append(AppraisalFormTemplatesModelImpl.ORDER_BY_JPQL);
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
						appraisalFormTemplates)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AppraisalFormTemplates> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the appraisal form templateses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (AppraisalFormTemplates appraisalFormTemplates :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(appraisalFormTemplates);
		}
	}

	/**
	 * Returns the number of appraisal form templateses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching appraisal form templateses
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_APPRAISALFORMTEMPLATES_WHERE);

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
		"appraisalFormTemplates.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(appraisalFormTemplates.uuid IS NULL OR appraisalFormTemplates.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;

	/**
	 * Returns the appraisal form templates where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchAppraisalFormTemplatesException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching appraisal form templates
	 * @throws NoSuchAppraisalFormTemplatesException if a matching appraisal form templates could not be found
	 */
	@Override
	public AppraisalFormTemplates findByUUID_G(String uuid, long groupId)
		throws NoSuchAppraisalFormTemplatesException {

		AppraisalFormTemplates appraisalFormTemplates = fetchByUUID_G(
			uuid, groupId);

		if (appraisalFormTemplates == null) {
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

			throw new NoSuchAppraisalFormTemplatesException(sb.toString());
		}

		return appraisalFormTemplates;
	}

	/**
	 * Returns the appraisal form templates where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching appraisal form templates, or <code>null</code> if a matching appraisal form templates could not be found
	 */
	@Override
	public AppraisalFormTemplates fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the appraisal form templates where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching appraisal form templates, or <code>null</code> if a matching appraisal form templates could not be found
	 */
	@Override
	public AppraisalFormTemplates fetchByUUID_G(
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

		if (result instanceof AppraisalFormTemplates) {
			AppraisalFormTemplates appraisalFormTemplates =
				(AppraisalFormTemplates)result;

			if (!Objects.equals(uuid, appraisalFormTemplates.getUuid()) ||
				(groupId != appraisalFormTemplates.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_APPRAISALFORMTEMPLATES_WHERE);

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

				List<AppraisalFormTemplates> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					AppraisalFormTemplates appraisalFormTemplates = list.get(0);

					result = appraisalFormTemplates;

					cacheResult(appraisalFormTemplates);
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
			return (AppraisalFormTemplates)result;
		}
	}

	/**
	 * Removes the appraisal form templates where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the appraisal form templates that was removed
	 */
	@Override
	public AppraisalFormTemplates removeByUUID_G(String uuid, long groupId)
		throws NoSuchAppraisalFormTemplatesException {

		AppraisalFormTemplates appraisalFormTemplates = findByUUID_G(
			uuid, groupId);

		return remove(appraisalFormTemplates);
	}

	/**
	 * Returns the number of appraisal form templateses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching appraisal form templateses
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		AppraisalFormTemplates appraisalFormTemplates = fetchByUUID_G(
			uuid, groupId);

		if (appraisalFormTemplates == null) {
			return 0;
		}

		return 1;
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"appraisalFormTemplates.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(appraisalFormTemplates.uuid IS NULL OR appraisalFormTemplates.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"appraisalFormTemplates.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the appraisal form templateses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching appraisal form templateses
	 */
	@Override
	public List<AppraisalFormTemplates> findByUuid_C(
		String uuid, long companyId) {

		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the appraisal form templateses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalFormTemplatesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of appraisal form templateses
	 * @param end the upper bound of the range of appraisal form templateses (not inclusive)
	 * @return the range of matching appraisal form templateses
	 */
	@Override
	public List<AppraisalFormTemplates> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the appraisal form templateses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalFormTemplatesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of appraisal form templateses
	 * @param end the upper bound of the range of appraisal form templateses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching appraisal form templateses
	 */
	@Override
	public List<AppraisalFormTemplates> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AppraisalFormTemplates> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the appraisal form templateses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalFormTemplatesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of appraisal form templateses
	 * @param end the upper bound of the range of appraisal form templateses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching appraisal form templateses
	 */
	@Override
	public List<AppraisalFormTemplates> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AppraisalFormTemplates> orderByComparator,
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

		List<AppraisalFormTemplates> list = null;

		if (useFinderCache) {
			list = (List<AppraisalFormTemplates>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AppraisalFormTemplates appraisalFormTemplates : list) {
					if (!uuid.equals(appraisalFormTemplates.getUuid()) ||
						(companyId != appraisalFormTemplates.getCompanyId())) {

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

			sb.append(_SQL_SELECT_APPRAISALFORMTEMPLATES_WHERE);

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
				sb.append(AppraisalFormTemplatesModelImpl.ORDER_BY_JPQL);
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

				list = (List<AppraisalFormTemplates>)QueryUtil.list(
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
	 * Returns the first appraisal form templates in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appraisal form templates
	 * @throws NoSuchAppraisalFormTemplatesException if a matching appraisal form templates could not be found
	 */
	@Override
	public AppraisalFormTemplates findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<AppraisalFormTemplates> orderByComparator)
		throws NoSuchAppraisalFormTemplatesException {

		AppraisalFormTemplates appraisalFormTemplates = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (appraisalFormTemplates != null) {
			return appraisalFormTemplates;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchAppraisalFormTemplatesException(sb.toString());
	}

	/**
	 * Returns the first appraisal form templates in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appraisal form templates, or <code>null</code> if a matching appraisal form templates could not be found
	 */
	@Override
	public AppraisalFormTemplates fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<AppraisalFormTemplates> orderByComparator) {

		List<AppraisalFormTemplates> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last appraisal form templates in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appraisal form templates
	 * @throws NoSuchAppraisalFormTemplatesException if a matching appraisal form templates could not be found
	 */
	@Override
	public AppraisalFormTemplates findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<AppraisalFormTemplates> orderByComparator)
		throws NoSuchAppraisalFormTemplatesException {

		AppraisalFormTemplates appraisalFormTemplates = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (appraisalFormTemplates != null) {
			return appraisalFormTemplates;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchAppraisalFormTemplatesException(sb.toString());
	}

	/**
	 * Returns the last appraisal form templates in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appraisal form templates, or <code>null</code> if a matching appraisal form templates could not be found
	 */
	@Override
	public AppraisalFormTemplates fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<AppraisalFormTemplates> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<AppraisalFormTemplates> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the appraisal form templateses before and after the current appraisal form templates in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param appraisalFormTemplateId the primary key of the current appraisal form templates
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next appraisal form templates
	 * @throws NoSuchAppraisalFormTemplatesException if a appraisal form templates with the primary key could not be found
	 */
	@Override
	public AppraisalFormTemplates[] findByUuid_C_PrevAndNext(
			long appraisalFormTemplateId, String uuid, long companyId,
			OrderByComparator<AppraisalFormTemplates> orderByComparator)
		throws NoSuchAppraisalFormTemplatesException {

		uuid = Objects.toString(uuid, "");

		AppraisalFormTemplates appraisalFormTemplates = findByPrimaryKey(
			appraisalFormTemplateId);

		Session session = null;

		try {
			session = openSession();

			AppraisalFormTemplates[] array = new AppraisalFormTemplatesImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, appraisalFormTemplates, uuid, companyId,
				orderByComparator, true);

			array[1] = appraisalFormTemplates;

			array[2] = getByUuid_C_PrevAndNext(
				session, appraisalFormTemplates, uuid, companyId,
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

	protected AppraisalFormTemplates getByUuid_C_PrevAndNext(
		Session session, AppraisalFormTemplates appraisalFormTemplates,
		String uuid, long companyId,
		OrderByComparator<AppraisalFormTemplates> orderByComparator,
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

		sb.append(_SQL_SELECT_APPRAISALFORMTEMPLATES_WHERE);

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
			sb.append(AppraisalFormTemplatesModelImpl.ORDER_BY_JPQL);
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
						appraisalFormTemplates)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AppraisalFormTemplates> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the appraisal form templateses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (AppraisalFormTemplates appraisalFormTemplates :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(appraisalFormTemplates);
		}
	}

	/**
	 * Returns the number of appraisal form templateses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching appraisal form templateses
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_APPRAISALFORMTEMPLATES_WHERE);

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
		"appraisalFormTemplates.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(appraisalFormTemplates.uuid IS NULL OR appraisalFormTemplates.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"appraisalFormTemplates.companyId = ?";

	private FinderPath _finderPathFetchByTemplateYearAndTemplateLevelId;

	/**
	 * Returns the appraisal form templates where templateYear = &#63; and templateLevelId = &#63; or throws a <code>NoSuchAppraisalFormTemplatesException</code> if it could not be found.
	 *
	 * @param templateYear the template year
	 * @param templateLevelId the template level ID
	 * @return the matching appraisal form templates
	 * @throws NoSuchAppraisalFormTemplatesException if a matching appraisal form templates could not be found
	 */
	@Override
	public AppraisalFormTemplates findByTemplateYearAndTemplateLevelId(
			String templateYear, long templateLevelId)
		throws NoSuchAppraisalFormTemplatesException {

		AppraisalFormTemplates appraisalFormTemplates =
			fetchByTemplateYearAndTemplateLevelId(
				templateYear, templateLevelId);

		if (appraisalFormTemplates == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("templateYear=");
			sb.append(templateYear);

			sb.append(", templateLevelId=");
			sb.append(templateLevelId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchAppraisalFormTemplatesException(sb.toString());
		}

		return appraisalFormTemplates;
	}

	/**
	 * Returns the appraisal form templates where templateYear = &#63; and templateLevelId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param templateYear the template year
	 * @param templateLevelId the template level ID
	 * @return the matching appraisal form templates, or <code>null</code> if a matching appraisal form templates could not be found
	 */
	@Override
	public AppraisalFormTemplates fetchByTemplateYearAndTemplateLevelId(
		String templateYear, long templateLevelId) {

		return fetchByTemplateYearAndTemplateLevelId(
			templateYear, templateLevelId, true);
	}

	/**
	 * Returns the appraisal form templates where templateYear = &#63; and templateLevelId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param templateYear the template year
	 * @param templateLevelId the template level ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching appraisal form templates, or <code>null</code> if a matching appraisal form templates could not be found
	 */
	@Override
	public AppraisalFormTemplates fetchByTemplateYearAndTemplateLevelId(
		String templateYear, long templateLevelId, boolean useFinderCache) {

		templateYear = Objects.toString(templateYear, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {templateYear, templateLevelId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByTemplateYearAndTemplateLevelId, finderArgs,
				this);
		}

		if (result instanceof AppraisalFormTemplates) {
			AppraisalFormTemplates appraisalFormTemplates =
				(AppraisalFormTemplates)result;

			if (!Objects.equals(
					templateYear, appraisalFormTemplates.getTemplateYear()) ||
				(templateLevelId !=
					appraisalFormTemplates.getTemplateLevelId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_APPRAISALFORMTEMPLATES_WHERE);

			boolean bindTemplateYear = false;

			if (templateYear.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_TEMPLATEYEARANDTEMPLATELEVELID_TEMPLATEYEAR_3);
			}
			else {
				bindTemplateYear = true;

				sb.append(
					_FINDER_COLUMN_TEMPLATEYEARANDTEMPLATELEVELID_TEMPLATEYEAR_2);
			}

			sb.append(
				_FINDER_COLUMN_TEMPLATEYEARANDTEMPLATELEVELID_TEMPLATELEVELID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindTemplateYear) {
					queryPos.add(templateYear);
				}

				queryPos.add(templateLevelId);

				List<AppraisalFormTemplates> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByTemplateYearAndTemplateLevelId,
							finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									templateYear, templateLevelId
								};
							}

							_log.warn(
								"AppraisalFormTemplatesPersistenceImpl.fetchByTemplateYearAndTemplateLevelId(String, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					AppraisalFormTemplates appraisalFormTemplates = list.get(0);

					result = appraisalFormTemplates;

					cacheResult(appraisalFormTemplates);
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
			return (AppraisalFormTemplates)result;
		}
	}

	/**
	 * Removes the appraisal form templates where templateYear = &#63; and templateLevelId = &#63; from the database.
	 *
	 * @param templateYear the template year
	 * @param templateLevelId the template level ID
	 * @return the appraisal form templates that was removed
	 */
	@Override
	public AppraisalFormTemplates removeByTemplateYearAndTemplateLevelId(
			String templateYear, long templateLevelId)
		throws NoSuchAppraisalFormTemplatesException {

		AppraisalFormTemplates appraisalFormTemplates =
			findByTemplateYearAndTemplateLevelId(templateYear, templateLevelId);

		return remove(appraisalFormTemplates);
	}

	/**
	 * Returns the number of appraisal form templateses where templateYear = &#63; and templateLevelId = &#63;.
	 *
	 * @param templateYear the template year
	 * @param templateLevelId the template level ID
	 * @return the number of matching appraisal form templateses
	 */
	@Override
	public int countByTemplateYearAndTemplateLevelId(
		String templateYear, long templateLevelId) {

		AppraisalFormTemplates appraisalFormTemplates =
			fetchByTemplateYearAndTemplateLevelId(
				templateYear, templateLevelId);

		if (appraisalFormTemplates == null) {
			return 0;
		}

		return 1;
	}

	private static final String
		_FINDER_COLUMN_TEMPLATEYEARANDTEMPLATELEVELID_TEMPLATEYEAR_2 =
			"appraisalFormTemplates.templateYear = ? AND ";

	private static final String
		_FINDER_COLUMN_TEMPLATEYEARANDTEMPLATELEVELID_TEMPLATEYEAR_3 =
			"(appraisalFormTemplates.templateYear IS NULL OR appraisalFormTemplates.templateYear = '') AND ";

	private static final String
		_FINDER_COLUMN_TEMPLATEYEARANDTEMPLATELEVELID_TEMPLATELEVELID_2 =
			"appraisalFormTemplates.templateLevelId = ?";

	private FinderPath _finderPathFetchByTemplateLevelIdAndTemplateYear;

	/**
	 * Returns the appraisal form templates where templateLevelId = &#63; and templateYear = &#63; or throws a <code>NoSuchAppraisalFormTemplatesException</code> if it could not be found.
	 *
	 * @param templateLevelId the template level ID
	 * @param templateYear the template year
	 * @return the matching appraisal form templates
	 * @throws NoSuchAppraisalFormTemplatesException if a matching appraisal form templates could not be found
	 */
	@Override
	public AppraisalFormTemplates findByTemplateLevelIdAndTemplateYear(
			long templateLevelId, String templateYear)
		throws NoSuchAppraisalFormTemplatesException {

		AppraisalFormTemplates appraisalFormTemplates =
			fetchByTemplateLevelIdAndTemplateYear(
				templateLevelId, templateYear);

		if (appraisalFormTemplates == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("templateLevelId=");
			sb.append(templateLevelId);

			sb.append(", templateYear=");
			sb.append(templateYear);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchAppraisalFormTemplatesException(sb.toString());
		}

		return appraisalFormTemplates;
	}

	/**
	 * Returns the appraisal form templates where templateLevelId = &#63; and templateYear = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param templateLevelId the template level ID
	 * @param templateYear the template year
	 * @return the matching appraisal form templates, or <code>null</code> if a matching appraisal form templates could not be found
	 */
	@Override
	public AppraisalFormTemplates fetchByTemplateLevelIdAndTemplateYear(
		long templateLevelId, String templateYear) {

		return fetchByTemplateLevelIdAndTemplateYear(
			templateLevelId, templateYear, true);
	}

	/**
	 * Returns the appraisal form templates where templateLevelId = &#63; and templateYear = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param templateLevelId the template level ID
	 * @param templateYear the template year
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching appraisal form templates, or <code>null</code> if a matching appraisal form templates could not be found
	 */
	@Override
	public AppraisalFormTemplates fetchByTemplateLevelIdAndTemplateYear(
		long templateLevelId, String templateYear, boolean useFinderCache) {

		templateYear = Objects.toString(templateYear, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {templateLevelId, templateYear};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByTemplateLevelIdAndTemplateYear, finderArgs,
				this);
		}

		if (result instanceof AppraisalFormTemplates) {
			AppraisalFormTemplates appraisalFormTemplates =
				(AppraisalFormTemplates)result;

			if ((templateLevelId !=
					appraisalFormTemplates.getTemplateLevelId()) ||
				!Objects.equals(
					templateYear, appraisalFormTemplates.getTemplateYear())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_APPRAISALFORMTEMPLATES_WHERE);

			sb.append(
				_FINDER_COLUMN_TEMPLATELEVELIDANDTEMPLATEYEAR_TEMPLATELEVELID_2);

			boolean bindTemplateYear = false;

			if (templateYear.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_TEMPLATELEVELIDANDTEMPLATEYEAR_TEMPLATEYEAR_3);
			}
			else {
				bindTemplateYear = true;

				sb.append(
					_FINDER_COLUMN_TEMPLATELEVELIDANDTEMPLATEYEAR_TEMPLATEYEAR_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(templateLevelId);

				if (bindTemplateYear) {
					queryPos.add(StringUtil.toLowerCase(templateYear));
				}

				List<AppraisalFormTemplates> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByTemplateLevelIdAndTemplateYear,
							finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									templateLevelId, templateYear
								};
							}

							_log.warn(
								"AppraisalFormTemplatesPersistenceImpl.fetchByTemplateLevelIdAndTemplateYear(long, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					AppraisalFormTemplates appraisalFormTemplates = list.get(0);

					result = appraisalFormTemplates;

					cacheResult(appraisalFormTemplates);
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
			return (AppraisalFormTemplates)result;
		}
	}

	/**
	 * Removes the appraisal form templates where templateLevelId = &#63; and templateYear = &#63; from the database.
	 *
	 * @param templateLevelId the template level ID
	 * @param templateYear the template year
	 * @return the appraisal form templates that was removed
	 */
	@Override
	public AppraisalFormTemplates removeByTemplateLevelIdAndTemplateYear(
			long templateLevelId, String templateYear)
		throws NoSuchAppraisalFormTemplatesException {

		AppraisalFormTemplates appraisalFormTemplates =
			findByTemplateLevelIdAndTemplateYear(templateLevelId, templateYear);

		return remove(appraisalFormTemplates);
	}

	/**
	 * Returns the number of appraisal form templateses where templateLevelId = &#63; and templateYear = &#63;.
	 *
	 * @param templateLevelId the template level ID
	 * @param templateYear the template year
	 * @return the number of matching appraisal form templateses
	 */
	@Override
	public int countByTemplateLevelIdAndTemplateYear(
		long templateLevelId, String templateYear) {

		AppraisalFormTemplates appraisalFormTemplates =
			fetchByTemplateLevelIdAndTemplateYear(
				templateLevelId, templateYear);

		if (appraisalFormTemplates == null) {
			return 0;
		}

		return 1;
	}

	private static final String
		_FINDER_COLUMN_TEMPLATELEVELIDANDTEMPLATEYEAR_TEMPLATELEVELID_2 =
			"appraisalFormTemplates.templateLevelId = ? AND ";

	private static final String
		_FINDER_COLUMN_TEMPLATELEVELIDANDTEMPLATEYEAR_TEMPLATEYEAR_2 =
			"lower(appraisalFormTemplates.templateYear) = ?";

	private static final String
		_FINDER_COLUMN_TEMPLATELEVELIDANDTEMPLATEYEAR_TEMPLATEYEAR_3 =
			"(appraisalFormTemplates.templateYear IS NULL OR appraisalFormTemplates.templateYear = '')";

	public AppraisalFormTemplatesPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(AppraisalFormTemplates.class);

		setModelImplClass(AppraisalFormTemplatesImpl.class);
		setModelPKClass(long.class);

		setTable(AppraisalFormTemplatesTable.INSTANCE);
	}

	/**
	 * Caches the appraisal form templates in the entity cache if it is enabled.
	 *
	 * @param appraisalFormTemplates the appraisal form templates
	 */
	@Override
	public void cacheResult(AppraisalFormTemplates appraisalFormTemplates) {
		entityCache.putResult(
			AppraisalFormTemplatesImpl.class,
			appraisalFormTemplates.getPrimaryKey(), appraisalFormTemplates);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				appraisalFormTemplates.getUuid(),
				appraisalFormTemplates.getGroupId()
			},
			appraisalFormTemplates);

		finderCache.putResult(
			_finderPathFetchByTemplateYearAndTemplateLevelId,
			new Object[] {
				appraisalFormTemplates.getTemplateYear(),
				appraisalFormTemplates.getTemplateLevelId()
			},
			appraisalFormTemplates);

		finderCache.putResult(
			_finderPathFetchByTemplateLevelIdAndTemplateYear,
			new Object[] {
				appraisalFormTemplates.getTemplateLevelId(),
				appraisalFormTemplates.getTemplateYear()
			},
			appraisalFormTemplates);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the appraisal form templateses in the entity cache if it is enabled.
	 *
	 * @param appraisalFormTemplateses the appraisal form templateses
	 */
	@Override
	public void cacheResult(
		List<AppraisalFormTemplates> appraisalFormTemplateses) {

		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (appraisalFormTemplateses.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (AppraisalFormTemplates appraisalFormTemplates :
				appraisalFormTemplateses) {

			if (entityCache.getResult(
					AppraisalFormTemplatesImpl.class,
					appraisalFormTemplates.getPrimaryKey()) == null) {

				cacheResult(appraisalFormTemplates);
			}
		}
	}

	/**
	 * Clears the cache for all appraisal form templateses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AppraisalFormTemplatesImpl.class);

		finderCache.clearCache(AppraisalFormTemplatesImpl.class);
	}

	/**
	 * Clears the cache for the appraisal form templates.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AppraisalFormTemplates appraisalFormTemplates) {
		entityCache.removeResult(
			AppraisalFormTemplatesImpl.class, appraisalFormTemplates);
	}

	@Override
	public void clearCache(
		List<AppraisalFormTemplates> appraisalFormTemplateses) {

		for (AppraisalFormTemplates appraisalFormTemplates :
				appraisalFormTemplateses) {

			entityCache.removeResult(
				AppraisalFormTemplatesImpl.class, appraisalFormTemplates);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(AppraisalFormTemplatesImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				AppraisalFormTemplatesImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		AppraisalFormTemplatesModelImpl appraisalFormTemplatesModelImpl) {

		Object[] args = new Object[] {
			appraisalFormTemplatesModelImpl.getUuid(),
			appraisalFormTemplatesModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathFetchByUUID_G, args, appraisalFormTemplatesModelImpl);

		args = new Object[] {
			appraisalFormTemplatesModelImpl.getTemplateYear(),
			appraisalFormTemplatesModelImpl.getTemplateLevelId()
		};

		finderCache.putResult(
			_finderPathFetchByTemplateYearAndTemplateLevelId, args,
			appraisalFormTemplatesModelImpl);

		args = new Object[] {
			appraisalFormTemplatesModelImpl.getTemplateLevelId(),
			appraisalFormTemplatesModelImpl.getTemplateYear()
		};

		finderCache.putResult(
			_finderPathFetchByTemplateLevelIdAndTemplateYear, args,
			appraisalFormTemplatesModelImpl);
	}

	/**
	 * Creates a new appraisal form templates with the primary key. Does not add the appraisal form templates to the database.
	 *
	 * @param appraisalFormTemplateId the primary key for the new appraisal form templates
	 * @return the new appraisal form templates
	 */
	@Override
	public AppraisalFormTemplates create(long appraisalFormTemplateId) {
		AppraisalFormTemplates appraisalFormTemplates =
			new AppraisalFormTemplatesImpl();

		appraisalFormTemplates.setNew(true);
		appraisalFormTemplates.setPrimaryKey(appraisalFormTemplateId);

		String uuid = PortalUUIDUtil.generate();

		appraisalFormTemplates.setUuid(uuid);

		appraisalFormTemplates.setCompanyId(CompanyThreadLocal.getCompanyId());

		return appraisalFormTemplates;
	}

	/**
	 * Removes the appraisal form templates with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param appraisalFormTemplateId the primary key of the appraisal form templates
	 * @return the appraisal form templates that was removed
	 * @throws NoSuchAppraisalFormTemplatesException if a appraisal form templates with the primary key could not be found
	 */
	@Override
	public AppraisalFormTemplates remove(long appraisalFormTemplateId)
		throws NoSuchAppraisalFormTemplatesException {

		return remove((Serializable)appraisalFormTemplateId);
	}

	/**
	 * Removes the appraisal form templates with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the appraisal form templates
	 * @return the appraisal form templates that was removed
	 * @throws NoSuchAppraisalFormTemplatesException if a appraisal form templates with the primary key could not be found
	 */
	@Override
	public AppraisalFormTemplates remove(Serializable primaryKey)
		throws NoSuchAppraisalFormTemplatesException {

		Session session = null;

		try {
			session = openSession();

			AppraisalFormTemplates appraisalFormTemplates =
				(AppraisalFormTemplates)session.get(
					AppraisalFormTemplatesImpl.class, primaryKey);

			if (appraisalFormTemplates == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAppraisalFormTemplatesException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(appraisalFormTemplates);
		}
		catch (NoSuchAppraisalFormTemplatesException noSuchEntityException) {
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
	protected AppraisalFormTemplates removeImpl(
		AppraisalFormTemplates appraisalFormTemplates) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(appraisalFormTemplates)) {
				appraisalFormTemplates = (AppraisalFormTemplates)session.get(
					AppraisalFormTemplatesImpl.class,
					appraisalFormTemplates.getPrimaryKeyObj());
			}

			if (appraisalFormTemplates != null) {
				session.delete(appraisalFormTemplates);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (appraisalFormTemplates != null) {
			clearCache(appraisalFormTemplates);
		}

		return appraisalFormTemplates;
	}

	@Override
	public AppraisalFormTemplates updateImpl(
		AppraisalFormTemplates appraisalFormTemplates) {

		boolean isNew = appraisalFormTemplates.isNew();

		if (!(appraisalFormTemplates instanceof
				AppraisalFormTemplatesModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(appraisalFormTemplates.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					appraisalFormTemplates);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in appraisalFormTemplates proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom AppraisalFormTemplates implementation " +
					appraisalFormTemplates.getClass());
		}

		AppraisalFormTemplatesModelImpl appraisalFormTemplatesModelImpl =
			(AppraisalFormTemplatesModelImpl)appraisalFormTemplates;

		if (Validator.isNull(appraisalFormTemplates.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			appraisalFormTemplates.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (appraisalFormTemplates.getCreateDate() == null)) {
			if (serviceContext == null) {
				appraisalFormTemplates.setCreateDate(date);
			}
			else {
				appraisalFormTemplates.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!appraisalFormTemplatesModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				appraisalFormTemplates.setModifiedDate(date);
			}
			else {
				appraisalFormTemplates.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(appraisalFormTemplates);
			}
			else {
				appraisalFormTemplates = (AppraisalFormTemplates)session.merge(
					appraisalFormTemplates);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			AppraisalFormTemplatesImpl.class, appraisalFormTemplatesModelImpl,
			false, true);

		cacheUniqueFindersCache(appraisalFormTemplatesModelImpl);

		if (isNew) {
			appraisalFormTemplates.setNew(false);
		}

		appraisalFormTemplates.resetOriginalValues();

		return appraisalFormTemplates;
	}

	/**
	 * Returns the appraisal form templates with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the appraisal form templates
	 * @return the appraisal form templates
	 * @throws NoSuchAppraisalFormTemplatesException if a appraisal form templates with the primary key could not be found
	 */
	@Override
	public AppraisalFormTemplates findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAppraisalFormTemplatesException {

		AppraisalFormTemplates appraisalFormTemplates = fetchByPrimaryKey(
			primaryKey);

		if (appraisalFormTemplates == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAppraisalFormTemplatesException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return appraisalFormTemplates;
	}

	/**
	 * Returns the appraisal form templates with the primary key or throws a <code>NoSuchAppraisalFormTemplatesException</code> if it could not be found.
	 *
	 * @param appraisalFormTemplateId the primary key of the appraisal form templates
	 * @return the appraisal form templates
	 * @throws NoSuchAppraisalFormTemplatesException if a appraisal form templates with the primary key could not be found
	 */
	@Override
	public AppraisalFormTemplates findByPrimaryKey(long appraisalFormTemplateId)
		throws NoSuchAppraisalFormTemplatesException {

		return findByPrimaryKey((Serializable)appraisalFormTemplateId);
	}

	/**
	 * Returns the appraisal form templates with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param appraisalFormTemplateId the primary key of the appraisal form templates
	 * @return the appraisal form templates, or <code>null</code> if a appraisal form templates with the primary key could not be found
	 */
	@Override
	public AppraisalFormTemplates fetchByPrimaryKey(
		long appraisalFormTemplateId) {

		return fetchByPrimaryKey((Serializable)appraisalFormTemplateId);
	}

	/**
	 * Returns all the appraisal form templateses.
	 *
	 * @return the appraisal form templateses
	 */
	@Override
	public List<AppraisalFormTemplates> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the appraisal form templateses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalFormTemplatesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of appraisal form templateses
	 * @param end the upper bound of the range of appraisal form templateses (not inclusive)
	 * @return the range of appraisal form templateses
	 */
	@Override
	public List<AppraisalFormTemplates> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the appraisal form templateses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalFormTemplatesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of appraisal form templateses
	 * @param end the upper bound of the range of appraisal form templateses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of appraisal form templateses
	 */
	@Override
	public List<AppraisalFormTemplates> findAll(
		int start, int end,
		OrderByComparator<AppraisalFormTemplates> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the appraisal form templateses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalFormTemplatesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of appraisal form templateses
	 * @param end the upper bound of the range of appraisal form templateses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of appraisal form templateses
	 */
	@Override
	public List<AppraisalFormTemplates> findAll(
		int start, int end,
		OrderByComparator<AppraisalFormTemplates> orderByComparator,
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

		List<AppraisalFormTemplates> list = null;

		if (useFinderCache) {
			list = (List<AppraisalFormTemplates>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_APPRAISALFORMTEMPLATES);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_APPRAISALFORMTEMPLATES;

				sql = sql.concat(AppraisalFormTemplatesModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<AppraisalFormTemplates>)QueryUtil.list(
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
	 * Removes all the appraisal form templateses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (AppraisalFormTemplates appraisalFormTemplates : findAll()) {
			remove(appraisalFormTemplates);
		}
	}

	/**
	 * Returns the number of appraisal form templateses.
	 *
	 * @return the number of appraisal form templateses
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
					_SQL_COUNT_APPRAISALFORMTEMPLATES);

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
		return "appraisalFormTemplateId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_APPRAISALFORMTEMPLATES;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return AppraisalFormTemplatesModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the appraisal form templates persistence.
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

		_finderPathFetchByTemplateYearAndTemplateLevelId = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByTemplateYearAndTemplateLevelId",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"templateYear", "templateLevelId"}, true);

		_finderPathFetchByTemplateLevelIdAndTemplateYear = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByTemplateLevelIdAndTemplateYear",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"templateLevelId", "templateYear"}, true);

		AppraisalFormTemplatesUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		AppraisalFormTemplatesUtil.setPersistence(null);

		entityCache.removeCache(AppraisalFormTemplatesImpl.class.getName());
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

	private static final String _SQL_SELECT_APPRAISALFORMTEMPLATES =
		"SELECT appraisalFormTemplates FROM AppraisalFormTemplates appraisalFormTemplates";

	private static final String _SQL_SELECT_APPRAISALFORMTEMPLATES_WHERE =
		"SELECT appraisalFormTemplates FROM AppraisalFormTemplates appraisalFormTemplates WHERE ";

	private static final String _SQL_COUNT_APPRAISALFORMTEMPLATES =
		"SELECT COUNT(appraisalFormTemplates) FROM AppraisalFormTemplates appraisalFormTemplates";

	private static final String _SQL_COUNT_APPRAISALFORMTEMPLATES_WHERE =
		"SELECT COUNT(appraisalFormTemplates) FROM AppraisalFormTemplates appraisalFormTemplates WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"appraisalFormTemplates.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No AppraisalFormTemplates exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No AppraisalFormTemplates exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		AppraisalFormTemplatesPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}