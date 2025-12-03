/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.master.service.persistence.impl;

import com.ax.hrms.master.exception.NoSuchDesignationMasterException;
import com.ax.hrms.master.model.DesignationMaster;
import com.ax.hrms.master.model.DesignationMasterTable;
import com.ax.hrms.master.model.impl.DesignationMasterImpl;
import com.ax.hrms.master.model.impl.DesignationMasterModelImpl;
import com.ax.hrms.master.service.persistence.DesignationMasterPersistence;
import com.ax.hrms.master.service.persistence.DesignationMasterUtil;
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
 * The persistence implementation for the designation master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = DesignationMasterPersistence.class)
public class DesignationMasterPersistenceImpl
	extends BasePersistenceImpl<DesignationMaster>
	implements DesignationMasterPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DesignationMasterUtil</code> to access the designation master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DesignationMasterImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByDesignationName;
	private FinderPath _finderPathCountByDesignationName;

	/**
	 * Returns the designation master where designationName = &#63; or throws a <code>NoSuchDesignationMasterException</code> if it could not be found.
	 *
	 * @param designationName the designation name
	 * @return the matching designation master
	 * @throws NoSuchDesignationMasterException if a matching designation master could not be found
	 */
	@Override
	public DesignationMaster findByDesignationName(String designationName)
		throws NoSuchDesignationMasterException {

		DesignationMaster designationMaster = fetchByDesignationName(
			designationName);

		if (designationMaster == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("designationName=");
			sb.append(designationName);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDesignationMasterException(sb.toString());
		}

		return designationMaster;
	}

	/**
	 * Returns the designation master where designationName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param designationName the designation name
	 * @return the matching designation master, or <code>null</code> if a matching designation master could not be found
	 */
	@Override
	public DesignationMaster fetchByDesignationName(String designationName) {
		return fetchByDesignationName(designationName, true);
	}

	/**
	 * Returns the designation master where designationName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param designationName the designation name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching designation master, or <code>null</code> if a matching designation master could not be found
	 */
	@Override
	public DesignationMaster fetchByDesignationName(
		String designationName, boolean useFinderCache) {

		designationName = Objects.toString(designationName, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {designationName};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByDesignationName, finderArgs, this);
		}

		if (result instanceof DesignationMaster) {
			DesignationMaster designationMaster = (DesignationMaster)result;

			if (!Objects.equals(
					designationName, designationMaster.getDesignationName())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_DESIGNATIONMASTER_WHERE);

			boolean bindDesignationName = false;

			if (designationName.isEmpty()) {
				sb.append(_FINDER_COLUMN_DESIGNATIONNAME_DESIGNATIONNAME_3);
			}
			else {
				bindDesignationName = true;

				sb.append(_FINDER_COLUMN_DESIGNATIONNAME_DESIGNATIONNAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindDesignationName) {
					queryPos.add(StringUtil.toLowerCase(designationName));
				}

				List<DesignationMaster> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByDesignationName, finderArgs,
							list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {designationName};
							}

							_log.warn(
								"DesignationMasterPersistenceImpl.fetchByDesignationName(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DesignationMaster designationMaster = list.get(0);

					result = designationMaster;

					cacheResult(designationMaster);
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
			return (DesignationMaster)result;
		}
	}

	/**
	 * Removes the designation master where designationName = &#63; from the database.
	 *
	 * @param designationName the designation name
	 * @return the designation master that was removed
	 */
	@Override
	public DesignationMaster removeByDesignationName(String designationName)
		throws NoSuchDesignationMasterException {

		DesignationMaster designationMaster = findByDesignationName(
			designationName);

		return remove(designationMaster);
	}

	/**
	 * Returns the number of designation masters where designationName = &#63;.
	 *
	 * @param designationName the designation name
	 * @return the number of matching designation masters
	 */
	@Override
	public int countByDesignationName(String designationName) {
		designationName = Objects.toString(designationName, "");

		FinderPath finderPath = _finderPathCountByDesignationName;

		Object[] finderArgs = new Object[] {designationName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DESIGNATIONMASTER_WHERE);

			boolean bindDesignationName = false;

			if (designationName.isEmpty()) {
				sb.append(_FINDER_COLUMN_DESIGNATIONNAME_DESIGNATIONNAME_3);
			}
			else {
				bindDesignationName = true;

				sb.append(_FINDER_COLUMN_DESIGNATIONNAME_DESIGNATIONNAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindDesignationName) {
					queryPos.add(StringUtil.toLowerCase(designationName));
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

	private static final String
		_FINDER_COLUMN_DESIGNATIONNAME_DESIGNATIONNAME_2 =
			"lower(designationMaster.designationName) = ?";

	private static final String
		_FINDER_COLUMN_DESIGNATIONNAME_DESIGNATIONNAME_3 =
			"(designationMaster.designationName IS NULL OR designationMaster.designationName = '')";

	private FinderPath _finderPathFetchByDesignationNameById;
	private FinderPath _finderPathCountByDesignationNameById;

	/**
	 * Returns the designation master where designationMasterId = &#63; or throws a <code>NoSuchDesignationMasterException</code> if it could not be found.
	 *
	 * @param designationMasterId the designation master ID
	 * @return the matching designation master
	 * @throws NoSuchDesignationMasterException if a matching designation master could not be found
	 */
	@Override
	public DesignationMaster findByDesignationNameById(long designationMasterId)
		throws NoSuchDesignationMasterException {

		DesignationMaster designationMaster = fetchByDesignationNameById(
			designationMasterId);

		if (designationMaster == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("designationMasterId=");
			sb.append(designationMasterId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDesignationMasterException(sb.toString());
		}

		return designationMaster;
	}

	/**
	 * Returns the designation master where designationMasterId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param designationMasterId the designation master ID
	 * @return the matching designation master, or <code>null</code> if a matching designation master could not be found
	 */
	@Override
	public DesignationMaster fetchByDesignationNameById(
		long designationMasterId) {

		return fetchByDesignationNameById(designationMasterId, true);
	}

	/**
	 * Returns the designation master where designationMasterId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param designationMasterId the designation master ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching designation master, or <code>null</code> if a matching designation master could not be found
	 */
	@Override
	public DesignationMaster fetchByDesignationNameById(
		long designationMasterId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {designationMasterId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByDesignationNameById, finderArgs, this);
		}

		if (result instanceof DesignationMaster) {
			DesignationMaster designationMaster = (DesignationMaster)result;

			if (designationMasterId !=
					designationMaster.getDesignationMasterId()) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_DESIGNATIONMASTER_WHERE);

			sb.append(_FINDER_COLUMN_DESIGNATIONNAMEBYID_DESIGNATIONMASTERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(designationMasterId);

				List<DesignationMaster> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByDesignationNameById, finderArgs,
							list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {designationMasterId};
							}

							_log.warn(
								"DesignationMasterPersistenceImpl.fetchByDesignationNameById(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DesignationMaster designationMaster = list.get(0);

					result = designationMaster;

					cacheResult(designationMaster);
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
			return (DesignationMaster)result;
		}
	}

	/**
	 * Removes the designation master where designationMasterId = &#63; from the database.
	 *
	 * @param designationMasterId the designation master ID
	 * @return the designation master that was removed
	 */
	@Override
	public DesignationMaster removeByDesignationNameById(
			long designationMasterId)
		throws NoSuchDesignationMasterException {

		DesignationMaster designationMaster = findByDesignationNameById(
			designationMasterId);

		return remove(designationMaster);
	}

	/**
	 * Returns the number of designation masters where designationMasterId = &#63;.
	 *
	 * @param designationMasterId the designation master ID
	 * @return the number of matching designation masters
	 */
	@Override
	public int countByDesignationNameById(long designationMasterId) {
		FinderPath finderPath = _finderPathCountByDesignationNameById;

		Object[] finderArgs = new Object[] {designationMasterId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DESIGNATIONMASTER_WHERE);

			sb.append(_FINDER_COLUMN_DESIGNATIONNAMEBYID_DESIGNATIONMASTERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(designationMasterId);

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

	private static final String
		_FINDER_COLUMN_DESIGNATIONNAMEBYID_DESIGNATIONMASTERID_2 =
			"designationMaster.designationMasterId = ?";

	public DesignationMasterPersistenceImpl() {
		setModelClass(DesignationMaster.class);

		setModelImplClass(DesignationMasterImpl.class);
		setModelPKClass(long.class);

		setTable(DesignationMasterTable.INSTANCE);
	}

	/**
	 * Caches the designation master in the entity cache if it is enabled.
	 *
	 * @param designationMaster the designation master
	 */
	@Override
	public void cacheResult(DesignationMaster designationMaster) {
		entityCache.putResult(
			DesignationMasterImpl.class, designationMaster.getPrimaryKey(),
			designationMaster);

		finderCache.putResult(
			_finderPathFetchByDesignationName,
			new Object[] {designationMaster.getDesignationName()},
			designationMaster);

		finderCache.putResult(
			_finderPathFetchByDesignationNameById,
			new Object[] {designationMaster.getDesignationMasterId()},
			designationMaster);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the designation masters in the entity cache if it is enabled.
	 *
	 * @param designationMasters the designation masters
	 */
	@Override
	public void cacheResult(List<DesignationMaster> designationMasters) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (designationMasters.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (DesignationMaster designationMaster : designationMasters) {
			if (entityCache.getResult(
					DesignationMasterImpl.class,
					designationMaster.getPrimaryKey()) == null) {

				cacheResult(designationMaster);
			}
		}
	}

	/**
	 * Clears the cache for all designation masters.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DesignationMasterImpl.class);

		finderCache.clearCache(DesignationMasterImpl.class);
	}

	/**
	 * Clears the cache for the designation master.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DesignationMaster designationMaster) {
		entityCache.removeResult(
			DesignationMasterImpl.class, designationMaster);
	}

	@Override
	public void clearCache(List<DesignationMaster> designationMasters) {
		for (DesignationMaster designationMaster : designationMasters) {
			entityCache.removeResult(
				DesignationMasterImpl.class, designationMaster);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(DesignationMasterImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(DesignationMasterImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		DesignationMasterModelImpl designationMasterModelImpl) {

		Object[] args = new Object[] {
			designationMasterModelImpl.getDesignationName()
		};

		finderCache.putResult(
			_finderPathCountByDesignationName, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByDesignationName, args,
			designationMasterModelImpl);

		args = new Object[] {
			designationMasterModelImpl.getDesignationMasterId()
		};

		finderCache.putResult(
			_finderPathCountByDesignationNameById, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByDesignationNameById, args,
			designationMasterModelImpl);
	}

	/**
	 * Creates a new designation master with the primary key. Does not add the designation master to the database.
	 *
	 * @param designationMasterId the primary key for the new designation master
	 * @return the new designation master
	 */
	@Override
	public DesignationMaster create(long designationMasterId) {
		DesignationMaster designationMaster = new DesignationMasterImpl();

		designationMaster.setNew(true);
		designationMaster.setPrimaryKey(designationMasterId);

		designationMaster.setCompanyId(CompanyThreadLocal.getCompanyId());

		return designationMaster;
	}

	/**
	 * Removes the designation master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param designationMasterId the primary key of the designation master
	 * @return the designation master that was removed
	 * @throws NoSuchDesignationMasterException if a designation master with the primary key could not be found
	 */
	@Override
	public DesignationMaster remove(long designationMasterId)
		throws NoSuchDesignationMasterException {

		return remove((Serializable)designationMasterId);
	}

	/**
	 * Removes the designation master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the designation master
	 * @return the designation master that was removed
	 * @throws NoSuchDesignationMasterException if a designation master with the primary key could not be found
	 */
	@Override
	public DesignationMaster remove(Serializable primaryKey)
		throws NoSuchDesignationMasterException {

		Session session = null;

		try {
			session = openSession();

			DesignationMaster designationMaster =
				(DesignationMaster)session.get(
					DesignationMasterImpl.class, primaryKey);

			if (designationMaster == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDesignationMasterException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(designationMaster);
		}
		catch (NoSuchDesignationMasterException noSuchEntityException) {
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
	protected DesignationMaster removeImpl(
		DesignationMaster designationMaster) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(designationMaster)) {
				designationMaster = (DesignationMaster)session.get(
					DesignationMasterImpl.class,
					designationMaster.getPrimaryKeyObj());
			}

			if (designationMaster != null) {
				session.delete(designationMaster);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (designationMaster != null) {
			clearCache(designationMaster);
		}

		return designationMaster;
	}

	@Override
	public DesignationMaster updateImpl(DesignationMaster designationMaster) {
		boolean isNew = designationMaster.isNew();

		if (!(designationMaster instanceof DesignationMasterModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(designationMaster.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					designationMaster);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in designationMaster proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom DesignationMaster implementation " +
					designationMaster.getClass());
		}

		DesignationMasterModelImpl designationMasterModelImpl =
			(DesignationMasterModelImpl)designationMaster;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (designationMaster.getCreateDate() == null)) {
			if (serviceContext == null) {
				designationMaster.setCreateDate(date);
			}
			else {
				designationMaster.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!designationMasterModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				designationMaster.setModifiedDate(date);
			}
			else {
				designationMaster.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(designationMaster);
			}
			else {
				designationMaster = (DesignationMaster)session.merge(
					designationMaster);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			DesignationMasterImpl.class, designationMasterModelImpl, false,
			true);

		cacheUniqueFindersCache(designationMasterModelImpl);

		if (isNew) {
			designationMaster.setNew(false);
		}

		designationMaster.resetOriginalValues();

		return designationMaster;
	}

	/**
	 * Returns the designation master with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the designation master
	 * @return the designation master
	 * @throws NoSuchDesignationMasterException if a designation master with the primary key could not be found
	 */
	@Override
	public DesignationMaster findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDesignationMasterException {

		DesignationMaster designationMaster = fetchByPrimaryKey(primaryKey);

		if (designationMaster == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDesignationMasterException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return designationMaster;
	}

	/**
	 * Returns the designation master with the primary key or throws a <code>NoSuchDesignationMasterException</code> if it could not be found.
	 *
	 * @param designationMasterId the primary key of the designation master
	 * @return the designation master
	 * @throws NoSuchDesignationMasterException if a designation master with the primary key could not be found
	 */
	@Override
	public DesignationMaster findByPrimaryKey(long designationMasterId)
		throws NoSuchDesignationMasterException {

		return findByPrimaryKey((Serializable)designationMasterId);
	}

	/**
	 * Returns the designation master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param designationMasterId the primary key of the designation master
	 * @return the designation master, or <code>null</code> if a designation master with the primary key could not be found
	 */
	@Override
	public DesignationMaster fetchByPrimaryKey(long designationMasterId) {
		return fetchByPrimaryKey((Serializable)designationMasterId);
	}

	/**
	 * Returns all the designation masters.
	 *
	 * @return the designation masters
	 */
	@Override
	public List<DesignationMaster> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the designation masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of designation masters
	 * @param end the upper bound of the range of designation masters (not inclusive)
	 * @return the range of designation masters
	 */
	@Override
	public List<DesignationMaster> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the designation masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of designation masters
	 * @param end the upper bound of the range of designation masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of designation masters
	 */
	@Override
	public List<DesignationMaster> findAll(
		int start, int end,
		OrderByComparator<DesignationMaster> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the designation masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of designation masters
	 * @param end the upper bound of the range of designation masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of designation masters
	 */
	@Override
	public List<DesignationMaster> findAll(
		int start, int end,
		OrderByComparator<DesignationMaster> orderByComparator,
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

		List<DesignationMaster> list = null;

		if (useFinderCache) {
			list = (List<DesignationMaster>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DESIGNATIONMASTER);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DESIGNATIONMASTER;

				sql = sql.concat(DesignationMasterModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<DesignationMaster>)QueryUtil.list(
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
	 * Removes all the designation masters from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DesignationMaster designationMaster : findAll()) {
			remove(designationMaster);
		}
	}

	/**
	 * Returns the number of designation masters.
	 *
	 * @return the number of designation masters
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_DESIGNATIONMASTER);

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
		return "designationMasterId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_DESIGNATIONMASTER;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DesignationMasterModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the designation master persistence.
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

		_finderPathFetchByDesignationName = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByDesignationName",
			new String[] {String.class.getName()},
			new String[] {"designationName"}, true);

		_finderPathCountByDesignationName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDesignationName",
			new String[] {String.class.getName()},
			new String[] {"designationName"}, false);

		_finderPathFetchByDesignationNameById = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByDesignationNameById",
			new String[] {Long.class.getName()},
			new String[] {"designationMasterId"}, true);

		_finderPathCountByDesignationNameById = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByDesignationNameById", new String[] {Long.class.getName()},
			new String[] {"designationMasterId"}, false);

		DesignationMasterUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		DesignationMasterUtil.setPersistence(null);

		entityCache.removeCache(DesignationMasterImpl.class.getName());
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

	private static final String _SQL_SELECT_DESIGNATIONMASTER =
		"SELECT designationMaster FROM DesignationMaster designationMaster";

	private static final String _SQL_SELECT_DESIGNATIONMASTER_WHERE =
		"SELECT designationMaster FROM DesignationMaster designationMaster WHERE ";

	private static final String _SQL_COUNT_DESIGNATIONMASTER =
		"SELECT COUNT(designationMaster) FROM DesignationMaster designationMaster";

	private static final String _SQL_COUNT_DESIGNATIONMASTER_WHERE =
		"SELECT COUNT(designationMaster) FROM DesignationMaster designationMaster WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "designationMaster.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No DesignationMaster exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No DesignationMaster exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		DesignationMasterPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}