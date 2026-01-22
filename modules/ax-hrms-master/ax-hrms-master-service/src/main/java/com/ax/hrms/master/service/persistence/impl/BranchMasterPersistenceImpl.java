/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.master.service.persistence.impl;

import com.ax.hrms.master.exception.NoSuchBranchMasterException;
import com.ax.hrms.master.model.BranchMaster;
import com.ax.hrms.master.model.BranchMasterTable;
import com.ax.hrms.master.model.impl.BranchMasterImpl;
import com.ax.hrms.master.model.impl.BranchMasterModelImpl;
import com.ax.hrms.master.service.persistence.BranchMasterPersistence;
import com.ax.hrms.master.service.persistence.BranchMasterUtil;
import com.ax.hrms.master.service.persistence.impl.constants.ax_masterPersistenceConstants;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
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

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the branch master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = BranchMasterPersistence.class)
public class BranchMasterPersistenceImpl
	extends BasePersistenceImpl<BranchMaster>
	implements BranchMasterPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>BranchMasterUtil</code> to access the branch master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		BranchMasterImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public BranchMasterPersistenceImpl() {
		setModelClass(BranchMaster.class);

		setModelImplClass(BranchMasterImpl.class);
		setModelPKClass(long.class);

		setTable(BranchMasterTable.INSTANCE);
	}

	/**
	 * Caches the branch master in the entity cache if it is enabled.
	 *
	 * @param branchMaster the branch master
	 */
	@Override
	public void cacheResult(BranchMaster branchMaster) {
		entityCache.putResult(
			BranchMasterImpl.class, branchMaster.getPrimaryKey(), branchMaster);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the branch masters in the entity cache if it is enabled.
	 *
	 * @param branchMasters the branch masters
	 */
	@Override
	public void cacheResult(List<BranchMaster> branchMasters) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (branchMasters.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (BranchMaster branchMaster : branchMasters) {
			if (entityCache.getResult(
					BranchMasterImpl.class, branchMaster.getPrimaryKey()) ==
						null) {

				cacheResult(branchMaster);
			}
		}
	}

	/**
	 * Clears the cache for all branch masters.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(BranchMasterImpl.class);

		finderCache.clearCache(BranchMasterImpl.class);
	}

	/**
	 * Clears the cache for the branch master.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(BranchMaster branchMaster) {
		entityCache.removeResult(BranchMasterImpl.class, branchMaster);
	}

	@Override
	public void clearCache(List<BranchMaster> branchMasters) {
		for (BranchMaster branchMaster : branchMasters) {
			entityCache.removeResult(BranchMasterImpl.class, branchMaster);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(BranchMasterImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(BranchMasterImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new branch master with the primary key. Does not add the branch master to the database.
	 *
	 * @param branchMasterId the primary key for the new branch master
	 * @return the new branch master
	 */
	@Override
	public BranchMaster create(long branchMasterId) {
		BranchMaster branchMaster = new BranchMasterImpl();

		branchMaster.setNew(true);
		branchMaster.setPrimaryKey(branchMasterId);

		branchMaster.setCompanyId(CompanyThreadLocal.getCompanyId());

		return branchMaster;
	}

	/**
	 * Removes the branch master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param branchMasterId the primary key of the branch master
	 * @return the branch master that was removed
	 * @throws NoSuchBranchMasterException if a branch master with the primary key could not be found
	 */
	@Override
	public BranchMaster remove(long branchMasterId)
		throws NoSuchBranchMasterException {

		return remove((Serializable)branchMasterId);
	}

	/**
	 * Removes the branch master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the branch master
	 * @return the branch master that was removed
	 * @throws NoSuchBranchMasterException if a branch master with the primary key could not be found
	 */
	@Override
	public BranchMaster remove(Serializable primaryKey)
		throws NoSuchBranchMasterException {

		Session session = null;

		try {
			session = openSession();

			BranchMaster branchMaster = (BranchMaster)session.get(
				BranchMasterImpl.class, primaryKey);

			if (branchMaster == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBranchMasterException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(branchMaster);
		}
		catch (NoSuchBranchMasterException noSuchEntityException) {
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
	protected BranchMaster removeImpl(BranchMaster branchMaster) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(branchMaster)) {
				branchMaster = (BranchMaster)session.get(
					BranchMasterImpl.class, branchMaster.getPrimaryKeyObj());
			}

			if (branchMaster != null) {
				session.delete(branchMaster);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (branchMaster != null) {
			clearCache(branchMaster);
		}

		return branchMaster;
	}

	@Override
	public BranchMaster updateImpl(BranchMaster branchMaster) {
		boolean isNew = branchMaster.isNew();

		if (!(branchMaster instanceof BranchMasterModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(branchMaster.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					branchMaster);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in branchMaster proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom BranchMaster implementation " +
					branchMaster.getClass());
		}

		BranchMasterModelImpl branchMasterModelImpl =
			(BranchMasterModelImpl)branchMaster;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (branchMaster.getCreateDate() == null)) {
			if (serviceContext == null) {
				branchMaster.setCreateDate(date);
			}
			else {
				branchMaster.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!branchMasterModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				branchMaster.setModifiedDate(date);
			}
			else {
				branchMaster.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(branchMaster);
			}
			else {
				branchMaster = (BranchMaster)session.merge(branchMaster);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			BranchMasterImpl.class, branchMaster, false, true);

		if (isNew) {
			branchMaster.setNew(false);
		}

		branchMaster.resetOriginalValues();

		return branchMaster;
	}

	/**
	 * Returns the branch master with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the branch master
	 * @return the branch master
	 * @throws NoSuchBranchMasterException if a branch master with the primary key could not be found
	 */
	@Override
	public BranchMaster findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBranchMasterException {

		BranchMaster branchMaster = fetchByPrimaryKey(primaryKey);

		if (branchMaster == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBranchMasterException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return branchMaster;
	}

	/**
	 * Returns the branch master with the primary key or throws a <code>NoSuchBranchMasterException</code> if it could not be found.
	 *
	 * @param branchMasterId the primary key of the branch master
	 * @return the branch master
	 * @throws NoSuchBranchMasterException if a branch master with the primary key could not be found
	 */
	@Override
	public BranchMaster findByPrimaryKey(long branchMasterId)
		throws NoSuchBranchMasterException {

		return findByPrimaryKey((Serializable)branchMasterId);
	}

	/**
	 * Returns the branch master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param branchMasterId the primary key of the branch master
	 * @return the branch master, or <code>null</code> if a branch master with the primary key could not be found
	 */
	@Override
	public BranchMaster fetchByPrimaryKey(long branchMasterId) {
		return fetchByPrimaryKey((Serializable)branchMasterId);
	}

	/**
	 * Returns all the branch masters.
	 *
	 * @return the branch masters
	 */
	@Override
	public List<BranchMaster> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the branch masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BranchMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of branch masters
	 * @param end the upper bound of the range of branch masters (not inclusive)
	 * @return the range of branch masters
	 */
	@Override
	public List<BranchMaster> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the branch masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BranchMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of branch masters
	 * @param end the upper bound of the range of branch masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of branch masters
	 */
	@Override
	public List<BranchMaster> findAll(
		int start, int end, OrderByComparator<BranchMaster> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the branch masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BranchMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of branch masters
	 * @param end the upper bound of the range of branch masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of branch masters
	 */
	@Override
	public List<BranchMaster> findAll(
		int start, int end, OrderByComparator<BranchMaster> orderByComparator,
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

		List<BranchMaster> list = null;

		if (useFinderCache) {
			list = (List<BranchMaster>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_BRANCHMASTER);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_BRANCHMASTER;

				sql = sql.concat(BranchMasterModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<BranchMaster>)QueryUtil.list(
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
	 * Removes all the branch masters from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (BranchMaster branchMaster : findAll()) {
			remove(branchMaster);
		}
	}

	/**
	 * Returns the number of branch masters.
	 *
	 * @return the number of branch masters
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_BRANCHMASTER);

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
		return "branchMasterId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_BRANCHMASTER;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return BranchMasterModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the branch master persistence.
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

		BranchMasterUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		BranchMasterUtil.setPersistence(null);

		entityCache.removeCache(BranchMasterImpl.class.getName());
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

	private static final String _SQL_SELECT_BRANCHMASTER =
		"SELECT branchMaster FROM BranchMaster branchMaster";

	private static final String _SQL_COUNT_BRANCHMASTER =
		"SELECT COUNT(branchMaster) FROM BranchMaster branchMaster";

	private static final String _ORDER_BY_ENTITY_ALIAS = "branchMaster.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No BranchMaster exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		BranchMasterPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}