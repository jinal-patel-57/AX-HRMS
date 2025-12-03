/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.master.service.persistence.impl;

import com.ax.hrms.master.exception.NoSuchWishTypeMasterException;
import com.ax.hrms.master.model.WishTypeMaster;
import com.ax.hrms.master.model.WishTypeMasterTable;
import com.ax.hrms.master.model.impl.WishTypeMasterImpl;
import com.ax.hrms.master.model.impl.WishTypeMasterModelImpl;
import com.ax.hrms.master.service.persistence.WishTypeMasterPersistence;
import com.ax.hrms.master.service.persistence.WishTypeMasterUtil;
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
 * The persistence implementation for the wish type master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = WishTypeMasterPersistence.class)
public class WishTypeMasterPersistenceImpl
	extends BasePersistenceImpl<WishTypeMaster>
	implements WishTypeMasterPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>WishTypeMasterUtil</code> to access the wish type master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		WishTypeMasterImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByWishType;
	private FinderPath _finderPathCountByWishType;

	/**
	 * Returns the wish type master where wishType = &#63; or throws a <code>NoSuchWishTypeMasterException</code> if it could not be found.
	 *
	 * @param wishType the wish type
	 * @return the matching wish type master
	 * @throws NoSuchWishTypeMasterException if a matching wish type master could not be found
	 */
	@Override
	public WishTypeMaster findByWishType(String wishType)
		throws NoSuchWishTypeMasterException {

		WishTypeMaster wishTypeMaster = fetchByWishType(wishType);

		if (wishTypeMaster == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("wishType=");
			sb.append(wishType);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchWishTypeMasterException(sb.toString());
		}

		return wishTypeMaster;
	}

	/**
	 * Returns the wish type master where wishType = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param wishType the wish type
	 * @return the matching wish type master, or <code>null</code> if a matching wish type master could not be found
	 */
	@Override
	public WishTypeMaster fetchByWishType(String wishType) {
		return fetchByWishType(wishType, true);
	}

	/**
	 * Returns the wish type master where wishType = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param wishType the wish type
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching wish type master, or <code>null</code> if a matching wish type master could not be found
	 */
	@Override
	public WishTypeMaster fetchByWishType(
		String wishType, boolean useFinderCache) {

		wishType = Objects.toString(wishType, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {wishType};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByWishType, finderArgs, this);
		}

		if (result instanceof WishTypeMaster) {
			WishTypeMaster wishTypeMaster = (WishTypeMaster)result;

			if (!Objects.equals(wishType, wishTypeMaster.getWishType())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_WISHTYPEMASTER_WHERE);

			boolean bindWishType = false;

			if (wishType.isEmpty()) {
				sb.append(_FINDER_COLUMN_WISHTYPE_WISHTYPE_3);
			}
			else {
				bindWishType = true;

				sb.append(_FINDER_COLUMN_WISHTYPE_WISHTYPE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindWishType) {
					queryPos.add(StringUtil.toLowerCase(wishType));
				}

				List<WishTypeMaster> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByWishType, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {wishType};
							}

							_log.warn(
								"WishTypeMasterPersistenceImpl.fetchByWishType(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					WishTypeMaster wishTypeMaster = list.get(0);

					result = wishTypeMaster;

					cacheResult(wishTypeMaster);
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
			return (WishTypeMaster)result;
		}
	}

	/**
	 * Removes the wish type master where wishType = &#63; from the database.
	 *
	 * @param wishType the wish type
	 * @return the wish type master that was removed
	 */
	@Override
	public WishTypeMaster removeByWishType(String wishType)
		throws NoSuchWishTypeMasterException {

		WishTypeMaster wishTypeMaster = findByWishType(wishType);

		return remove(wishTypeMaster);
	}

	/**
	 * Returns the number of wish type masters where wishType = &#63;.
	 *
	 * @param wishType the wish type
	 * @return the number of matching wish type masters
	 */
	@Override
	public int countByWishType(String wishType) {
		wishType = Objects.toString(wishType, "");

		FinderPath finderPath = _finderPathCountByWishType;

		Object[] finderArgs = new Object[] {wishType};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_WISHTYPEMASTER_WHERE);

			boolean bindWishType = false;

			if (wishType.isEmpty()) {
				sb.append(_FINDER_COLUMN_WISHTYPE_WISHTYPE_3);
			}
			else {
				bindWishType = true;

				sb.append(_FINDER_COLUMN_WISHTYPE_WISHTYPE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindWishType) {
					queryPos.add(StringUtil.toLowerCase(wishType));
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

	private static final String _FINDER_COLUMN_WISHTYPE_WISHTYPE_2 =
		"lower(wishTypeMaster.wishType) = ?";

	private static final String _FINDER_COLUMN_WISHTYPE_WISHTYPE_3 =
		"(wishTypeMaster.wishType IS NULL OR wishTypeMaster.wishType = '')";

	public WishTypeMasterPersistenceImpl() {
		setModelClass(WishTypeMaster.class);

		setModelImplClass(WishTypeMasterImpl.class);
		setModelPKClass(long.class);

		setTable(WishTypeMasterTable.INSTANCE);
	}

	/**
	 * Caches the wish type master in the entity cache if it is enabled.
	 *
	 * @param wishTypeMaster the wish type master
	 */
	@Override
	public void cacheResult(WishTypeMaster wishTypeMaster) {
		entityCache.putResult(
			WishTypeMasterImpl.class, wishTypeMaster.getPrimaryKey(),
			wishTypeMaster);

		finderCache.putResult(
			_finderPathFetchByWishType,
			new Object[] {wishTypeMaster.getWishType()}, wishTypeMaster);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the wish type masters in the entity cache if it is enabled.
	 *
	 * @param wishTypeMasters the wish type masters
	 */
	@Override
	public void cacheResult(List<WishTypeMaster> wishTypeMasters) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (wishTypeMasters.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (WishTypeMaster wishTypeMaster : wishTypeMasters) {
			if (entityCache.getResult(
					WishTypeMasterImpl.class, wishTypeMaster.getPrimaryKey()) ==
						null) {

				cacheResult(wishTypeMaster);
			}
		}
	}

	/**
	 * Clears the cache for all wish type masters.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(WishTypeMasterImpl.class);

		finderCache.clearCache(WishTypeMasterImpl.class);
	}

	/**
	 * Clears the cache for the wish type master.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(WishTypeMaster wishTypeMaster) {
		entityCache.removeResult(WishTypeMasterImpl.class, wishTypeMaster);
	}

	@Override
	public void clearCache(List<WishTypeMaster> wishTypeMasters) {
		for (WishTypeMaster wishTypeMaster : wishTypeMasters) {
			entityCache.removeResult(WishTypeMasterImpl.class, wishTypeMaster);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(WishTypeMasterImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(WishTypeMasterImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		WishTypeMasterModelImpl wishTypeMasterModelImpl) {

		Object[] args = new Object[] {wishTypeMasterModelImpl.getWishType()};

		finderCache.putResult(
			_finderPathCountByWishType, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByWishType, args, wishTypeMasterModelImpl);
	}

	/**
	 * Creates a new wish type master with the primary key. Does not add the wish type master to the database.
	 *
	 * @param wishTypeMasterId the primary key for the new wish type master
	 * @return the new wish type master
	 */
	@Override
	public WishTypeMaster create(long wishTypeMasterId) {
		WishTypeMaster wishTypeMaster = new WishTypeMasterImpl();

		wishTypeMaster.setNew(true);
		wishTypeMaster.setPrimaryKey(wishTypeMasterId);

		wishTypeMaster.setCompanyId(CompanyThreadLocal.getCompanyId());

		return wishTypeMaster;
	}

	/**
	 * Removes the wish type master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param wishTypeMasterId the primary key of the wish type master
	 * @return the wish type master that was removed
	 * @throws NoSuchWishTypeMasterException if a wish type master with the primary key could not be found
	 */
	@Override
	public WishTypeMaster remove(long wishTypeMasterId)
		throws NoSuchWishTypeMasterException {

		return remove((Serializable)wishTypeMasterId);
	}

	/**
	 * Removes the wish type master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the wish type master
	 * @return the wish type master that was removed
	 * @throws NoSuchWishTypeMasterException if a wish type master with the primary key could not be found
	 */
	@Override
	public WishTypeMaster remove(Serializable primaryKey)
		throws NoSuchWishTypeMasterException {

		Session session = null;

		try {
			session = openSession();

			WishTypeMaster wishTypeMaster = (WishTypeMaster)session.get(
				WishTypeMasterImpl.class, primaryKey);

			if (wishTypeMaster == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchWishTypeMasterException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(wishTypeMaster);
		}
		catch (NoSuchWishTypeMasterException noSuchEntityException) {
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
	protected WishTypeMaster removeImpl(WishTypeMaster wishTypeMaster) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(wishTypeMaster)) {
				wishTypeMaster = (WishTypeMaster)session.get(
					WishTypeMasterImpl.class,
					wishTypeMaster.getPrimaryKeyObj());
			}

			if (wishTypeMaster != null) {
				session.delete(wishTypeMaster);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (wishTypeMaster != null) {
			clearCache(wishTypeMaster);
		}

		return wishTypeMaster;
	}

	@Override
	public WishTypeMaster updateImpl(WishTypeMaster wishTypeMaster) {
		boolean isNew = wishTypeMaster.isNew();

		if (!(wishTypeMaster instanceof WishTypeMasterModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(wishTypeMaster.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					wishTypeMaster);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in wishTypeMaster proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom WishTypeMaster implementation " +
					wishTypeMaster.getClass());
		}

		WishTypeMasterModelImpl wishTypeMasterModelImpl =
			(WishTypeMasterModelImpl)wishTypeMaster;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (wishTypeMaster.getCreateDate() == null)) {
			if (serviceContext == null) {
				wishTypeMaster.setCreateDate(date);
			}
			else {
				wishTypeMaster.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!wishTypeMasterModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				wishTypeMaster.setModifiedDate(date);
			}
			else {
				wishTypeMaster.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(wishTypeMaster);
			}
			else {
				wishTypeMaster = (WishTypeMaster)session.merge(wishTypeMaster);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			WishTypeMasterImpl.class, wishTypeMasterModelImpl, false, true);

		cacheUniqueFindersCache(wishTypeMasterModelImpl);

		if (isNew) {
			wishTypeMaster.setNew(false);
		}

		wishTypeMaster.resetOriginalValues();

		return wishTypeMaster;
	}

	/**
	 * Returns the wish type master with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the wish type master
	 * @return the wish type master
	 * @throws NoSuchWishTypeMasterException if a wish type master with the primary key could not be found
	 */
	@Override
	public WishTypeMaster findByPrimaryKey(Serializable primaryKey)
		throws NoSuchWishTypeMasterException {

		WishTypeMaster wishTypeMaster = fetchByPrimaryKey(primaryKey);

		if (wishTypeMaster == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchWishTypeMasterException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return wishTypeMaster;
	}

	/**
	 * Returns the wish type master with the primary key or throws a <code>NoSuchWishTypeMasterException</code> if it could not be found.
	 *
	 * @param wishTypeMasterId the primary key of the wish type master
	 * @return the wish type master
	 * @throws NoSuchWishTypeMasterException if a wish type master with the primary key could not be found
	 */
	@Override
	public WishTypeMaster findByPrimaryKey(long wishTypeMasterId)
		throws NoSuchWishTypeMasterException {

		return findByPrimaryKey((Serializable)wishTypeMasterId);
	}

	/**
	 * Returns the wish type master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param wishTypeMasterId the primary key of the wish type master
	 * @return the wish type master, or <code>null</code> if a wish type master with the primary key could not be found
	 */
	@Override
	public WishTypeMaster fetchByPrimaryKey(long wishTypeMasterId) {
		return fetchByPrimaryKey((Serializable)wishTypeMasterId);
	}

	/**
	 * Returns all the wish type masters.
	 *
	 * @return the wish type masters
	 */
	@Override
	public List<WishTypeMaster> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the wish type masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WishTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of wish type masters
	 * @param end the upper bound of the range of wish type masters (not inclusive)
	 * @return the range of wish type masters
	 */
	@Override
	public List<WishTypeMaster> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the wish type masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WishTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of wish type masters
	 * @param end the upper bound of the range of wish type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of wish type masters
	 */
	@Override
	public List<WishTypeMaster> findAll(
		int start, int end,
		OrderByComparator<WishTypeMaster> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the wish type masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WishTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of wish type masters
	 * @param end the upper bound of the range of wish type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of wish type masters
	 */
	@Override
	public List<WishTypeMaster> findAll(
		int start, int end, OrderByComparator<WishTypeMaster> orderByComparator,
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

		List<WishTypeMaster> list = null;

		if (useFinderCache) {
			list = (List<WishTypeMaster>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_WISHTYPEMASTER);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_WISHTYPEMASTER;

				sql = sql.concat(WishTypeMasterModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<WishTypeMaster>)QueryUtil.list(
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
	 * Removes all the wish type masters from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (WishTypeMaster wishTypeMaster : findAll()) {
			remove(wishTypeMaster);
		}
	}

	/**
	 * Returns the number of wish type masters.
	 *
	 * @return the number of wish type masters
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_WISHTYPEMASTER);

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
		return "wishTypeMasterId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_WISHTYPEMASTER;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return WishTypeMasterModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the wish type master persistence.
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

		_finderPathFetchByWishType = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByWishType",
			new String[] {String.class.getName()}, new String[] {"wishType"},
			true);

		_finderPathCountByWishType = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByWishType",
			new String[] {String.class.getName()}, new String[] {"wishType"},
			false);

		WishTypeMasterUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		WishTypeMasterUtil.setPersistence(null);

		entityCache.removeCache(WishTypeMasterImpl.class.getName());
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

	private static final String _SQL_SELECT_WISHTYPEMASTER =
		"SELECT wishTypeMaster FROM WishTypeMaster wishTypeMaster";

	private static final String _SQL_SELECT_WISHTYPEMASTER_WHERE =
		"SELECT wishTypeMaster FROM WishTypeMaster wishTypeMaster WHERE ";

	private static final String _SQL_COUNT_WISHTYPEMASTER =
		"SELECT COUNT(wishTypeMaster) FROM WishTypeMaster wishTypeMaster";

	private static final String _SQL_COUNT_WISHTYPEMASTER_WHERE =
		"SELECT COUNT(wishTypeMaster) FROM WishTypeMaster wishTypeMaster WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "wishTypeMaster.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No WishTypeMaster exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No WishTypeMaster exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		WishTypeMasterPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}