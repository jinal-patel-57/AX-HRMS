/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.master.service.persistence.impl;

import com.ax.hrms.master.exception.NoSuchPolicyTypeMasterException;
import com.ax.hrms.master.model.PolicyTypeMaster;
import com.ax.hrms.master.model.PolicyTypeMasterTable;
import com.ax.hrms.master.model.impl.PolicyTypeMasterImpl;
import com.ax.hrms.master.model.impl.PolicyTypeMasterModelImpl;
import com.ax.hrms.master.service.persistence.PolicyTypeMasterPersistence;
import com.ax.hrms.master.service.persistence.PolicyTypeMasterUtil;
import com.ax.hrms.master.service.persistence.impl.constants.ax_masterPersistenceConstants;

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
import com.liferay.portal.kernel.util.StringUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
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
 * The persistence implementation for the policy type master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = PolicyTypeMasterPersistence.class)
public class PolicyTypeMasterPersistenceImpl
	extends BasePersistenceImpl<PolicyTypeMaster>
	implements PolicyTypeMasterPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>PolicyTypeMasterUtil</code> to access the policy type master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		PolicyTypeMasterImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByPolicyType;
	private FinderPath _finderPathCountByPolicyType;

	/**
	 * Returns the policy type master where policyType = &#63; or throws a <code>NoSuchPolicyTypeMasterException</code> if it could not be found.
	 *
	 * @param policyType the policy type
	 * @return the matching policy type master
	 * @throws NoSuchPolicyTypeMasterException if a matching policy type master could not be found
	 */
	@Override
	public PolicyTypeMaster findByPolicyType(String policyType)
		throws NoSuchPolicyTypeMasterException {

		PolicyTypeMaster policyTypeMaster = fetchByPolicyType(policyType);

		if (policyTypeMaster == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("policyType=");
			sb.append(policyType);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchPolicyTypeMasterException(sb.toString());
		}

		return policyTypeMaster;
	}

	/**
	 * Returns the policy type master where policyType = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param policyType the policy type
	 * @return the matching policy type master, or <code>null</code> if a matching policy type master could not be found
	 */
	@Override
	public PolicyTypeMaster fetchByPolicyType(String policyType) {
		return fetchByPolicyType(policyType, true);
	}

	/**
	 * Returns the policy type master where policyType = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param policyType the policy type
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching policy type master, or <code>null</code> if a matching policy type master could not be found
	 */
	@Override
	public PolicyTypeMaster fetchByPolicyType(
		String policyType, boolean useFinderCache) {

		policyType = Objects.toString(policyType, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {policyType};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByPolicyType, finderArgs, this);
		}

		if (result instanceof PolicyTypeMaster) {
			PolicyTypeMaster policyTypeMaster = (PolicyTypeMaster)result;

			if (!Objects.equals(policyType, policyTypeMaster.getPolicyType())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_POLICYTYPEMASTER_WHERE);

			boolean bindPolicyType = false;

			if (policyType.isEmpty()) {
				sb.append(_FINDER_COLUMN_POLICYTYPE_POLICYTYPE_3);
			}
			else {
				bindPolicyType = true;

				sb.append(_FINDER_COLUMN_POLICYTYPE_POLICYTYPE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindPolicyType) {
					queryPos.add(StringUtil.toLowerCase(policyType));
				}

				List<PolicyTypeMaster> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByPolicyType, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {policyType};
							}

							_log.warn(
								"PolicyTypeMasterPersistenceImpl.fetchByPolicyType(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					PolicyTypeMaster policyTypeMaster = list.get(0);

					result = policyTypeMaster;

					cacheResult(policyTypeMaster);
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
			return (PolicyTypeMaster)result;
		}
	}

	/**
	 * Removes the policy type master where policyType = &#63; from the database.
	 *
	 * @param policyType the policy type
	 * @return the policy type master that was removed
	 */
	@Override
	public PolicyTypeMaster removeByPolicyType(String policyType)
		throws NoSuchPolicyTypeMasterException {

		PolicyTypeMaster policyTypeMaster = findByPolicyType(policyType);

		return remove(policyTypeMaster);
	}

	/**
	 * Returns the number of policy type masters where policyType = &#63;.
	 *
	 * @param policyType the policy type
	 * @return the number of matching policy type masters
	 */
	@Override
	public int countByPolicyType(String policyType) {
		policyType = Objects.toString(policyType, "");

		FinderPath finderPath = _finderPathCountByPolicyType;

		Object[] finderArgs = new Object[] {policyType};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_POLICYTYPEMASTER_WHERE);

			boolean bindPolicyType = false;

			if (policyType.isEmpty()) {
				sb.append(_FINDER_COLUMN_POLICYTYPE_POLICYTYPE_3);
			}
			else {
				bindPolicyType = true;

				sb.append(_FINDER_COLUMN_POLICYTYPE_POLICYTYPE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindPolicyType) {
					queryPos.add(StringUtil.toLowerCase(policyType));
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

	private static final String _FINDER_COLUMN_POLICYTYPE_POLICYTYPE_2 =
		"lower(policyTypeMaster.policyType) = ?";

	private static final String _FINDER_COLUMN_POLICYTYPE_POLICYTYPE_3 =
		"(policyTypeMaster.policyType IS NULL OR policyTypeMaster.policyType = '')";

	public PolicyTypeMasterPersistenceImpl() {
		setModelClass(PolicyTypeMaster.class);

		setModelImplClass(PolicyTypeMasterImpl.class);
		setModelPKClass(long.class);

		setTable(PolicyTypeMasterTable.INSTANCE);
	}

	/**
	 * Caches the policy type master in the entity cache if it is enabled.
	 *
	 * @param policyTypeMaster the policy type master
	 */
	@Override
	public void cacheResult(PolicyTypeMaster policyTypeMaster) {
		entityCache.putResult(
			PolicyTypeMasterImpl.class, policyTypeMaster.getPrimaryKey(),
			policyTypeMaster);

		finderCache.putResult(
			_finderPathFetchByPolicyType,
			new Object[] {policyTypeMaster.getPolicyType()}, policyTypeMaster);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the policy type masters in the entity cache if it is enabled.
	 *
	 * @param policyTypeMasters the policy type masters
	 */
	@Override
	public void cacheResult(List<PolicyTypeMaster> policyTypeMasters) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (policyTypeMasters.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (PolicyTypeMaster policyTypeMaster : policyTypeMasters) {
			if (entityCache.getResult(
					PolicyTypeMasterImpl.class,
					policyTypeMaster.getPrimaryKey()) == null) {

				cacheResult(policyTypeMaster);
			}
		}
	}

	/**
	 * Clears the cache for all policy type masters.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PolicyTypeMasterImpl.class);

		finderCache.clearCache(PolicyTypeMasterImpl.class);
	}

	/**
	 * Clears the cache for the policy type master.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PolicyTypeMaster policyTypeMaster) {
		entityCache.removeResult(PolicyTypeMasterImpl.class, policyTypeMaster);
	}

	@Override
	public void clearCache(List<PolicyTypeMaster> policyTypeMasters) {
		for (PolicyTypeMaster policyTypeMaster : policyTypeMasters) {
			entityCache.removeResult(
				PolicyTypeMasterImpl.class, policyTypeMaster);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(PolicyTypeMasterImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(PolicyTypeMasterImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		PolicyTypeMasterModelImpl policyTypeMasterModelImpl) {

		Object[] args = new Object[] {
			policyTypeMasterModelImpl.getPolicyType()
		};

		finderCache.putResult(
			_finderPathCountByPolicyType, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByPolicyType, args, policyTypeMasterModelImpl);
	}

	/**
	 * Creates a new policy type master with the primary key. Does not add the policy type master to the database.
	 *
	 * @param policyTypeMasterID the primary key for the new policy type master
	 * @return the new policy type master
	 */
	@Override
	public PolicyTypeMaster create(long policyTypeMasterID) {
		PolicyTypeMaster policyTypeMaster = new PolicyTypeMasterImpl();

		policyTypeMaster.setNew(true);
		policyTypeMaster.setPrimaryKey(policyTypeMasterID);

		policyTypeMaster.setCompanyId(CompanyThreadLocal.getCompanyId());

		return policyTypeMaster;
	}

	/**
	 * Removes the policy type master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param policyTypeMasterID the primary key of the policy type master
	 * @return the policy type master that was removed
	 * @throws NoSuchPolicyTypeMasterException if a policy type master with the primary key could not be found
	 */
	@Override
	public PolicyTypeMaster remove(long policyTypeMasterID)
		throws NoSuchPolicyTypeMasterException {

		return remove((Serializable)policyTypeMasterID);
	}

	/**
	 * Removes the policy type master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the policy type master
	 * @return the policy type master that was removed
	 * @throws NoSuchPolicyTypeMasterException if a policy type master with the primary key could not be found
	 */
	@Override
	public PolicyTypeMaster remove(Serializable primaryKey)
		throws NoSuchPolicyTypeMasterException {

		Session session = null;

		try {
			session = openSession();

			PolicyTypeMaster policyTypeMaster = (PolicyTypeMaster)session.get(
				PolicyTypeMasterImpl.class, primaryKey);

			if (policyTypeMaster == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPolicyTypeMasterException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(policyTypeMaster);
		}
		catch (NoSuchPolicyTypeMasterException noSuchEntityException) {
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
	protected PolicyTypeMaster removeImpl(PolicyTypeMaster policyTypeMaster) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(policyTypeMaster)) {
				policyTypeMaster = (PolicyTypeMaster)session.get(
					PolicyTypeMasterImpl.class,
					policyTypeMaster.getPrimaryKeyObj());
			}

			if (policyTypeMaster != null) {
				session.delete(policyTypeMaster);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (policyTypeMaster != null) {
			clearCache(policyTypeMaster);
		}

		return policyTypeMaster;
	}

	@Override
	public PolicyTypeMaster updateImpl(PolicyTypeMaster policyTypeMaster) {
		boolean isNew = policyTypeMaster.isNew();

		if (!(policyTypeMaster instanceof PolicyTypeMasterModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(policyTypeMaster.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					policyTypeMaster);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in policyTypeMaster proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom PolicyTypeMaster implementation " +
					policyTypeMaster.getClass());
		}

		PolicyTypeMasterModelImpl policyTypeMasterModelImpl =
			(PolicyTypeMasterModelImpl)policyTypeMaster;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (policyTypeMaster.getCreateDate() == null)) {
			if (serviceContext == null) {
				policyTypeMaster.setCreateDate(date);
			}
			else {
				policyTypeMaster.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!policyTypeMasterModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				policyTypeMaster.setModifiedDate(date);
			}
			else {
				policyTypeMaster.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(policyTypeMaster);
			}
			else {
				policyTypeMaster = (PolicyTypeMaster)session.merge(
					policyTypeMaster);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			PolicyTypeMasterImpl.class, policyTypeMasterModelImpl, false, true);

		cacheUniqueFindersCache(policyTypeMasterModelImpl);

		if (isNew) {
			policyTypeMaster.setNew(false);
		}

		policyTypeMaster.resetOriginalValues();

		return policyTypeMaster;
	}

	/**
	 * Returns the policy type master with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the policy type master
	 * @return the policy type master
	 * @throws NoSuchPolicyTypeMasterException if a policy type master with the primary key could not be found
	 */
	@Override
	public PolicyTypeMaster findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPolicyTypeMasterException {

		PolicyTypeMaster policyTypeMaster = fetchByPrimaryKey(primaryKey);

		if (policyTypeMaster == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPolicyTypeMasterException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return policyTypeMaster;
	}

	/**
	 * Returns the policy type master with the primary key or throws a <code>NoSuchPolicyTypeMasterException</code> if it could not be found.
	 *
	 * @param policyTypeMasterID the primary key of the policy type master
	 * @return the policy type master
	 * @throws NoSuchPolicyTypeMasterException if a policy type master with the primary key could not be found
	 */
	@Override
	public PolicyTypeMaster findByPrimaryKey(long policyTypeMasterID)
		throws NoSuchPolicyTypeMasterException {

		return findByPrimaryKey((Serializable)policyTypeMasterID);
	}

	/**
	 * Returns the policy type master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param policyTypeMasterID the primary key of the policy type master
	 * @return the policy type master, or <code>null</code> if a policy type master with the primary key could not be found
	 */
	@Override
	public PolicyTypeMaster fetchByPrimaryKey(long policyTypeMasterID) {
		return fetchByPrimaryKey((Serializable)policyTypeMasterID);
	}

	/**
	 * Returns all the policy type masters.
	 *
	 * @return the policy type masters
	 */
	@Override
	public List<PolicyTypeMaster> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the policy type masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of policy type masters
	 * @param end the upper bound of the range of policy type masters (not inclusive)
	 * @return the range of policy type masters
	 */
	@Override
	public List<PolicyTypeMaster> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the policy type masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of policy type masters
	 * @param end the upper bound of the range of policy type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of policy type masters
	 */
	@Override
	public List<PolicyTypeMaster> findAll(
		int start, int end,
		OrderByComparator<PolicyTypeMaster> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the policy type masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of policy type masters
	 * @param end the upper bound of the range of policy type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of policy type masters
	 */
	@Override
	public List<PolicyTypeMaster> findAll(
		int start, int end,
		OrderByComparator<PolicyTypeMaster> orderByComparator,
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

		List<PolicyTypeMaster> list = null;

		if (useFinderCache) {
			list = (List<PolicyTypeMaster>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_POLICYTYPEMASTER);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_POLICYTYPEMASTER;

				sql = sql.concat(PolicyTypeMasterModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<PolicyTypeMaster>)QueryUtil.list(
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
	 * Removes all the policy type masters from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (PolicyTypeMaster policyTypeMaster : findAll()) {
			remove(policyTypeMaster);
		}
	}

	/**
	 * Returns the number of policy type masters.
	 *
	 * @return the number of policy type masters
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_POLICYTYPEMASTER);

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
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "policyTypeMasterID";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_POLICYTYPEMASTER;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return PolicyTypeMasterModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the policy type master persistence.
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

		_finderPathFetchByPolicyType = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByPolicyType",
			new String[] {String.class.getName()}, new String[] {"policyType"},
			true);

		_finderPathCountByPolicyType = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPolicyType",
			new String[] {String.class.getName()}, new String[] {"policyType"},
			false);

		PolicyTypeMasterUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		PolicyTypeMasterUtil.setPersistence(null);

		entityCache.removeCache(PolicyTypeMasterImpl.class.getName());
	}

	@Override
	@Reference(
		target = ax_masterPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = ax_masterPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = ax_masterPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_POLICYTYPEMASTER =
		"SELECT policyTypeMaster FROM PolicyTypeMaster policyTypeMaster";

	private static final String _SQL_SELECT_POLICYTYPEMASTER_WHERE =
		"SELECT policyTypeMaster FROM PolicyTypeMaster policyTypeMaster WHERE ";

	private static final String _SQL_COUNT_POLICYTYPEMASTER =
		"SELECT COUNT(policyTypeMaster) FROM PolicyTypeMaster policyTypeMaster";

	private static final String _SQL_COUNT_POLICYTYPEMASTER_WHERE =
		"SELECT COUNT(policyTypeMaster) FROM PolicyTypeMaster policyTypeMaster WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "policyTypeMaster.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No PolicyTypeMaster exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No PolicyTypeMaster exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		PolicyTypeMasterPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}