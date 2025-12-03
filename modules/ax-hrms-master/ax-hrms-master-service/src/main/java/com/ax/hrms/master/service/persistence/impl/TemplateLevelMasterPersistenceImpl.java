/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.master.service.persistence.impl;

import com.ax.hrms.master.exception.NoSuchTemplateLevelMasterException;
import com.ax.hrms.master.model.TemplateLevelMaster;
import com.ax.hrms.master.model.TemplateLevelMasterTable;
import com.ax.hrms.master.model.impl.TemplateLevelMasterImpl;
import com.ax.hrms.master.model.impl.TemplateLevelMasterModelImpl;
import com.ax.hrms.master.service.persistence.TemplateLevelMasterPersistence;
import com.ax.hrms.master.service.persistence.TemplateLevelMasterUtil;
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
 * The persistence implementation for the template level master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = TemplateLevelMasterPersistence.class)
public class TemplateLevelMasterPersistenceImpl
	extends BasePersistenceImpl<TemplateLevelMaster>
	implements TemplateLevelMasterPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>TemplateLevelMasterUtil</code> to access the template level master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		TemplateLevelMasterImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchBylevelName;
	private FinderPath _finderPathCountBylevelName;

	/**
	 * Returns the template level master where levelName = &#63; or throws a <code>NoSuchTemplateLevelMasterException</code> if it could not be found.
	 *
	 * @param levelName the level name
	 * @return the matching template level master
	 * @throws NoSuchTemplateLevelMasterException if a matching template level master could not be found
	 */
	@Override
	public TemplateLevelMaster findBylevelName(String levelName)
		throws NoSuchTemplateLevelMasterException {

		TemplateLevelMaster templateLevelMaster = fetchBylevelName(levelName);

		if (templateLevelMaster == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("levelName=");
			sb.append(levelName);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchTemplateLevelMasterException(sb.toString());
		}

		return templateLevelMaster;
	}

	/**
	 * Returns the template level master where levelName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param levelName the level name
	 * @return the matching template level master, or <code>null</code> if a matching template level master could not be found
	 */
	@Override
	public TemplateLevelMaster fetchBylevelName(String levelName) {
		return fetchBylevelName(levelName, true);
	}

	/**
	 * Returns the template level master where levelName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param levelName the level name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching template level master, or <code>null</code> if a matching template level master could not be found
	 */
	@Override
	public TemplateLevelMaster fetchBylevelName(
		String levelName, boolean useFinderCache) {

		levelName = Objects.toString(levelName, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {levelName};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchBylevelName, finderArgs, this);
		}

		if (result instanceof TemplateLevelMaster) {
			TemplateLevelMaster templateLevelMaster =
				(TemplateLevelMaster)result;

			if (!Objects.equals(
					levelName, templateLevelMaster.getLevelName())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_TEMPLATELEVELMASTER_WHERE);

			boolean bindLevelName = false;

			if (levelName.isEmpty()) {
				sb.append(_FINDER_COLUMN_LEVELNAME_LEVELNAME_3);
			}
			else {
				bindLevelName = true;

				sb.append(_FINDER_COLUMN_LEVELNAME_LEVELNAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindLevelName) {
					queryPos.add(StringUtil.toLowerCase(levelName));
				}

				List<TemplateLevelMaster> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchBylevelName, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {levelName};
							}

							_log.warn(
								"TemplateLevelMasterPersistenceImpl.fetchBylevelName(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					TemplateLevelMaster templateLevelMaster = list.get(0);

					result = templateLevelMaster;

					cacheResult(templateLevelMaster);
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
			return (TemplateLevelMaster)result;
		}
	}

	/**
	 * Removes the template level master where levelName = &#63; from the database.
	 *
	 * @param levelName the level name
	 * @return the template level master that was removed
	 */
	@Override
	public TemplateLevelMaster removeBylevelName(String levelName)
		throws NoSuchTemplateLevelMasterException {

		TemplateLevelMaster templateLevelMaster = findBylevelName(levelName);

		return remove(templateLevelMaster);
	}

	/**
	 * Returns the number of template level masters where levelName = &#63;.
	 *
	 * @param levelName the level name
	 * @return the number of matching template level masters
	 */
	@Override
	public int countBylevelName(String levelName) {
		levelName = Objects.toString(levelName, "");

		FinderPath finderPath = _finderPathCountBylevelName;

		Object[] finderArgs = new Object[] {levelName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TEMPLATELEVELMASTER_WHERE);

			boolean bindLevelName = false;

			if (levelName.isEmpty()) {
				sb.append(_FINDER_COLUMN_LEVELNAME_LEVELNAME_3);
			}
			else {
				bindLevelName = true;

				sb.append(_FINDER_COLUMN_LEVELNAME_LEVELNAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindLevelName) {
					queryPos.add(StringUtil.toLowerCase(levelName));
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

	private static final String _FINDER_COLUMN_LEVELNAME_LEVELNAME_2 =
		"lower(templateLevelMaster.levelName) = ?";

	private static final String _FINDER_COLUMN_LEVELNAME_LEVELNAME_3 =
		"(templateLevelMaster.levelName IS NULL OR templateLevelMaster.levelName = '')";

	public TemplateLevelMasterPersistenceImpl() {
		setModelClass(TemplateLevelMaster.class);

		setModelImplClass(TemplateLevelMasterImpl.class);
		setModelPKClass(long.class);

		setTable(TemplateLevelMasterTable.INSTANCE);
	}

	/**
	 * Caches the template level master in the entity cache if it is enabled.
	 *
	 * @param templateLevelMaster the template level master
	 */
	@Override
	public void cacheResult(TemplateLevelMaster templateLevelMaster) {
		entityCache.putResult(
			TemplateLevelMasterImpl.class, templateLevelMaster.getPrimaryKey(),
			templateLevelMaster);

		finderCache.putResult(
			_finderPathFetchBylevelName,
			new Object[] {templateLevelMaster.getLevelName()},
			templateLevelMaster);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the template level masters in the entity cache if it is enabled.
	 *
	 * @param templateLevelMasters the template level masters
	 */
	@Override
	public void cacheResult(List<TemplateLevelMaster> templateLevelMasters) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (templateLevelMasters.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (TemplateLevelMaster templateLevelMaster : templateLevelMasters) {
			if (entityCache.getResult(
					TemplateLevelMasterImpl.class,
					templateLevelMaster.getPrimaryKey()) == null) {

				cacheResult(templateLevelMaster);
			}
		}
	}

	/**
	 * Clears the cache for all template level masters.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TemplateLevelMasterImpl.class);

		finderCache.clearCache(TemplateLevelMasterImpl.class);
	}

	/**
	 * Clears the cache for the template level master.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TemplateLevelMaster templateLevelMaster) {
		entityCache.removeResult(
			TemplateLevelMasterImpl.class, templateLevelMaster);
	}

	@Override
	public void clearCache(List<TemplateLevelMaster> templateLevelMasters) {
		for (TemplateLevelMaster templateLevelMaster : templateLevelMasters) {
			entityCache.removeResult(
				TemplateLevelMasterImpl.class, templateLevelMaster);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(TemplateLevelMasterImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(TemplateLevelMasterImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		TemplateLevelMasterModelImpl templateLevelMasterModelImpl) {

		Object[] args = new Object[] {
			templateLevelMasterModelImpl.getLevelName()
		};

		finderCache.putResult(
			_finderPathCountBylevelName, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchBylevelName, args, templateLevelMasterModelImpl);
	}

	/**
	 * Creates a new template level master with the primary key. Does not add the template level master to the database.
	 *
	 * @param templateLevelMasterId the primary key for the new template level master
	 * @return the new template level master
	 */
	@Override
	public TemplateLevelMaster create(long templateLevelMasterId) {
		TemplateLevelMaster templateLevelMaster = new TemplateLevelMasterImpl();

		templateLevelMaster.setNew(true);
		templateLevelMaster.setPrimaryKey(templateLevelMasterId);

		templateLevelMaster.setCompanyId(CompanyThreadLocal.getCompanyId());

		return templateLevelMaster;
	}

	/**
	 * Removes the template level master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param templateLevelMasterId the primary key of the template level master
	 * @return the template level master that was removed
	 * @throws NoSuchTemplateLevelMasterException if a template level master with the primary key could not be found
	 */
	@Override
	public TemplateLevelMaster remove(long templateLevelMasterId)
		throws NoSuchTemplateLevelMasterException {

		return remove((Serializable)templateLevelMasterId);
	}

	/**
	 * Removes the template level master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the template level master
	 * @return the template level master that was removed
	 * @throws NoSuchTemplateLevelMasterException if a template level master with the primary key could not be found
	 */
	@Override
	public TemplateLevelMaster remove(Serializable primaryKey)
		throws NoSuchTemplateLevelMasterException {

		Session session = null;

		try {
			session = openSession();

			TemplateLevelMaster templateLevelMaster =
				(TemplateLevelMaster)session.get(
					TemplateLevelMasterImpl.class, primaryKey);

			if (templateLevelMaster == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTemplateLevelMasterException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(templateLevelMaster);
		}
		catch (NoSuchTemplateLevelMasterException noSuchEntityException) {
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
	protected TemplateLevelMaster removeImpl(
		TemplateLevelMaster templateLevelMaster) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(templateLevelMaster)) {
				templateLevelMaster = (TemplateLevelMaster)session.get(
					TemplateLevelMasterImpl.class,
					templateLevelMaster.getPrimaryKeyObj());
			}

			if (templateLevelMaster != null) {
				session.delete(templateLevelMaster);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (templateLevelMaster != null) {
			clearCache(templateLevelMaster);
		}

		return templateLevelMaster;
	}

	@Override
	public TemplateLevelMaster updateImpl(
		TemplateLevelMaster templateLevelMaster) {

		boolean isNew = templateLevelMaster.isNew();

		if (!(templateLevelMaster instanceof TemplateLevelMasterModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(templateLevelMaster.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					templateLevelMaster);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in templateLevelMaster proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom TemplateLevelMaster implementation " +
					templateLevelMaster.getClass());
		}

		TemplateLevelMasterModelImpl templateLevelMasterModelImpl =
			(TemplateLevelMasterModelImpl)templateLevelMaster;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (templateLevelMaster.getCreateDate() == null)) {
			if (serviceContext == null) {
				templateLevelMaster.setCreateDate(date);
			}
			else {
				templateLevelMaster.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!templateLevelMasterModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				templateLevelMaster.setModifiedDate(date);
			}
			else {
				templateLevelMaster.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(templateLevelMaster);
			}
			else {
				templateLevelMaster = (TemplateLevelMaster)session.merge(
					templateLevelMaster);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			TemplateLevelMasterImpl.class, templateLevelMasterModelImpl, false,
			true);

		cacheUniqueFindersCache(templateLevelMasterModelImpl);

		if (isNew) {
			templateLevelMaster.setNew(false);
		}

		templateLevelMaster.resetOriginalValues();

		return templateLevelMaster;
	}

	/**
	 * Returns the template level master with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the template level master
	 * @return the template level master
	 * @throws NoSuchTemplateLevelMasterException if a template level master with the primary key could not be found
	 */
	@Override
	public TemplateLevelMaster findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTemplateLevelMasterException {

		TemplateLevelMaster templateLevelMaster = fetchByPrimaryKey(primaryKey);

		if (templateLevelMaster == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTemplateLevelMasterException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return templateLevelMaster;
	}

	/**
	 * Returns the template level master with the primary key or throws a <code>NoSuchTemplateLevelMasterException</code> if it could not be found.
	 *
	 * @param templateLevelMasterId the primary key of the template level master
	 * @return the template level master
	 * @throws NoSuchTemplateLevelMasterException if a template level master with the primary key could not be found
	 */
	@Override
	public TemplateLevelMaster findByPrimaryKey(long templateLevelMasterId)
		throws NoSuchTemplateLevelMasterException {

		return findByPrimaryKey((Serializable)templateLevelMasterId);
	}

	/**
	 * Returns the template level master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param templateLevelMasterId the primary key of the template level master
	 * @return the template level master, or <code>null</code> if a template level master with the primary key could not be found
	 */
	@Override
	public TemplateLevelMaster fetchByPrimaryKey(long templateLevelMasterId) {
		return fetchByPrimaryKey((Serializable)templateLevelMasterId);
	}

	/**
	 * Returns all the template level masters.
	 *
	 * @return the template level masters
	 */
	@Override
	public List<TemplateLevelMaster> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the template level masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TemplateLevelMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of template level masters
	 * @param end the upper bound of the range of template level masters (not inclusive)
	 * @return the range of template level masters
	 */
	@Override
	public List<TemplateLevelMaster> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the template level masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TemplateLevelMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of template level masters
	 * @param end the upper bound of the range of template level masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of template level masters
	 */
	@Override
	public List<TemplateLevelMaster> findAll(
		int start, int end,
		OrderByComparator<TemplateLevelMaster> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the template level masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TemplateLevelMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of template level masters
	 * @param end the upper bound of the range of template level masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of template level masters
	 */
	@Override
	public List<TemplateLevelMaster> findAll(
		int start, int end,
		OrderByComparator<TemplateLevelMaster> orderByComparator,
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

		List<TemplateLevelMaster> list = null;

		if (useFinderCache) {
			list = (List<TemplateLevelMaster>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_TEMPLATELEVELMASTER);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_TEMPLATELEVELMASTER;

				sql = sql.concat(TemplateLevelMasterModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<TemplateLevelMaster>)QueryUtil.list(
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
	 * Removes all the template level masters from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (TemplateLevelMaster templateLevelMaster : findAll()) {
			remove(templateLevelMaster);
		}
	}

	/**
	 * Returns the number of template level masters.
	 *
	 * @return the number of template level masters
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
					_SQL_COUNT_TEMPLATELEVELMASTER);

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
		return "templateLevelMasterId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_TEMPLATELEVELMASTER;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return TemplateLevelMasterModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the template level master persistence.
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

		_finderPathFetchBylevelName = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchBylevelName",
			new String[] {String.class.getName()}, new String[] {"levelName"},
			true);

		_finderPathCountBylevelName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBylevelName",
			new String[] {String.class.getName()}, new String[] {"levelName"},
			false);

		TemplateLevelMasterUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		TemplateLevelMasterUtil.setPersistence(null);

		entityCache.removeCache(TemplateLevelMasterImpl.class.getName());
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

	private static final String _SQL_SELECT_TEMPLATELEVELMASTER =
		"SELECT templateLevelMaster FROM TemplateLevelMaster templateLevelMaster";

	private static final String _SQL_SELECT_TEMPLATELEVELMASTER_WHERE =
		"SELECT templateLevelMaster FROM TemplateLevelMaster templateLevelMaster WHERE ";

	private static final String _SQL_COUNT_TEMPLATELEVELMASTER =
		"SELECT COUNT(templateLevelMaster) FROM TemplateLevelMaster templateLevelMaster";

	private static final String _SQL_COUNT_TEMPLATELEVELMASTER_WHERE =
		"SELECT COUNT(templateLevelMaster) FROM TemplateLevelMaster templateLevelMaster WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "templateLevelMaster.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No TemplateLevelMaster exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No TemplateLevelMaster exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		TemplateLevelMasterPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}