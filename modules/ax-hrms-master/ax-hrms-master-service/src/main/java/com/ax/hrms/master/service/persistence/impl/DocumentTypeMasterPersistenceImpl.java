/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.master.service.persistence.impl;

import com.ax.hrms.master.exception.NoSuchDocumentTypeMasterException;
import com.ax.hrms.master.model.DocumentTypeMaster;
import com.ax.hrms.master.model.DocumentTypeMasterTable;
import com.ax.hrms.master.model.impl.DocumentTypeMasterImpl;
import com.ax.hrms.master.model.impl.DocumentTypeMasterModelImpl;
import com.ax.hrms.master.service.persistence.DocumentTypeMasterPersistence;
import com.ax.hrms.master.service.persistence.DocumentTypeMasterUtil;
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
 * The persistence implementation for the document type master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = DocumentTypeMasterPersistence.class)
public class DocumentTypeMasterPersistenceImpl
	extends BasePersistenceImpl<DocumentTypeMaster>
	implements DocumentTypeMasterPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DocumentTypeMasterUtil</code> to access the document type master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DocumentTypeMasterImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByDocumentTypeName;
	private FinderPath _finderPathCountByDocumentTypeName;

	/**
	 * Returns the document type master where documentTypeName = &#63; or throws a <code>NoSuchDocumentTypeMasterException</code> if it could not be found.
	 *
	 * @param documentTypeName the document type name
	 * @return the matching document type master
	 * @throws NoSuchDocumentTypeMasterException if a matching document type master could not be found
	 */
	@Override
	public DocumentTypeMaster findByDocumentTypeName(String documentTypeName)
		throws NoSuchDocumentTypeMasterException {

		DocumentTypeMaster documentTypeMaster = fetchByDocumentTypeName(
			documentTypeName);

		if (documentTypeMaster == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("documentTypeName=");
			sb.append(documentTypeName);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDocumentTypeMasterException(sb.toString());
		}

		return documentTypeMaster;
	}

	/**
	 * Returns the document type master where documentTypeName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param documentTypeName the document type name
	 * @return the matching document type master, or <code>null</code> if a matching document type master could not be found
	 */
	@Override
	public DocumentTypeMaster fetchByDocumentTypeName(String documentTypeName) {
		return fetchByDocumentTypeName(documentTypeName, true);
	}

	/**
	 * Returns the document type master where documentTypeName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param documentTypeName the document type name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching document type master, or <code>null</code> if a matching document type master could not be found
	 */
	@Override
	public DocumentTypeMaster fetchByDocumentTypeName(
		String documentTypeName, boolean useFinderCache) {

		documentTypeName = Objects.toString(documentTypeName, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {documentTypeName};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByDocumentTypeName, finderArgs, this);
		}

		if (result instanceof DocumentTypeMaster) {
			DocumentTypeMaster documentTypeMaster = (DocumentTypeMaster)result;

			if (!Objects.equals(
					documentTypeName,
					documentTypeMaster.getDocumentTypeName())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_DOCUMENTTYPEMASTER_WHERE);

			boolean bindDocumentTypeName = false;

			if (documentTypeName.isEmpty()) {
				sb.append(_FINDER_COLUMN_DOCUMENTTYPENAME_DOCUMENTTYPENAME_3);
			}
			else {
				bindDocumentTypeName = true;

				sb.append(_FINDER_COLUMN_DOCUMENTTYPENAME_DOCUMENTTYPENAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindDocumentTypeName) {
					queryPos.add(StringUtil.toLowerCase(documentTypeName));
				}

				List<DocumentTypeMaster> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByDocumentTypeName, finderArgs,
							list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {documentTypeName};
							}

							_log.warn(
								"DocumentTypeMasterPersistenceImpl.fetchByDocumentTypeName(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DocumentTypeMaster documentTypeMaster = list.get(0);

					result = documentTypeMaster;

					cacheResult(documentTypeMaster);
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
			return (DocumentTypeMaster)result;
		}
	}

	/**
	 * Removes the document type master where documentTypeName = &#63; from the database.
	 *
	 * @param documentTypeName the document type name
	 * @return the document type master that was removed
	 */
	@Override
	public DocumentTypeMaster removeByDocumentTypeName(String documentTypeName)
		throws NoSuchDocumentTypeMasterException {

		DocumentTypeMaster documentTypeMaster = findByDocumentTypeName(
			documentTypeName);

		return remove(documentTypeMaster);
	}

	/**
	 * Returns the number of document type masters where documentTypeName = &#63;.
	 *
	 * @param documentTypeName the document type name
	 * @return the number of matching document type masters
	 */
	@Override
	public int countByDocumentTypeName(String documentTypeName) {
		documentTypeName = Objects.toString(documentTypeName, "");

		FinderPath finderPath = _finderPathCountByDocumentTypeName;

		Object[] finderArgs = new Object[] {documentTypeName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DOCUMENTTYPEMASTER_WHERE);

			boolean bindDocumentTypeName = false;

			if (documentTypeName.isEmpty()) {
				sb.append(_FINDER_COLUMN_DOCUMENTTYPENAME_DOCUMENTTYPENAME_3);
			}
			else {
				bindDocumentTypeName = true;

				sb.append(_FINDER_COLUMN_DOCUMENTTYPENAME_DOCUMENTTYPENAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindDocumentTypeName) {
					queryPos.add(StringUtil.toLowerCase(documentTypeName));
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
		_FINDER_COLUMN_DOCUMENTTYPENAME_DOCUMENTTYPENAME_2 =
			"lower(documentTypeMaster.documentTypeName) = ?";

	private static final String
		_FINDER_COLUMN_DOCUMENTTYPENAME_DOCUMENTTYPENAME_3 =
			"(documentTypeMaster.documentTypeName IS NULL OR documentTypeMaster.documentTypeName = '')";

	public DocumentTypeMasterPersistenceImpl() {
		setModelClass(DocumentTypeMaster.class);

		setModelImplClass(DocumentTypeMasterImpl.class);
		setModelPKClass(long.class);

		setTable(DocumentTypeMasterTable.INSTANCE);
	}

	/**
	 * Caches the document type master in the entity cache if it is enabled.
	 *
	 * @param documentTypeMaster the document type master
	 */
	@Override
	public void cacheResult(DocumentTypeMaster documentTypeMaster) {
		entityCache.putResult(
			DocumentTypeMasterImpl.class, documentTypeMaster.getPrimaryKey(),
			documentTypeMaster);

		finderCache.putResult(
			_finderPathFetchByDocumentTypeName,
			new Object[] {documentTypeMaster.getDocumentTypeName()},
			documentTypeMaster);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the document type masters in the entity cache if it is enabled.
	 *
	 * @param documentTypeMasters the document type masters
	 */
	@Override
	public void cacheResult(List<DocumentTypeMaster> documentTypeMasters) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (documentTypeMasters.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (DocumentTypeMaster documentTypeMaster : documentTypeMasters) {
			if (entityCache.getResult(
					DocumentTypeMasterImpl.class,
					documentTypeMaster.getPrimaryKey()) == null) {

				cacheResult(documentTypeMaster);
			}
		}
	}

	/**
	 * Clears the cache for all document type masters.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DocumentTypeMasterImpl.class);

		finderCache.clearCache(DocumentTypeMasterImpl.class);
	}

	/**
	 * Clears the cache for the document type master.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DocumentTypeMaster documentTypeMaster) {
		entityCache.removeResult(
			DocumentTypeMasterImpl.class, documentTypeMaster);
	}

	@Override
	public void clearCache(List<DocumentTypeMaster> documentTypeMasters) {
		for (DocumentTypeMaster documentTypeMaster : documentTypeMasters) {
			entityCache.removeResult(
				DocumentTypeMasterImpl.class, documentTypeMaster);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(DocumentTypeMasterImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(DocumentTypeMasterImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		DocumentTypeMasterModelImpl documentTypeMasterModelImpl) {

		Object[] args = new Object[] {
			documentTypeMasterModelImpl.getDocumentTypeName()
		};

		finderCache.putResult(
			_finderPathCountByDocumentTypeName, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByDocumentTypeName, args,
			documentTypeMasterModelImpl);
	}

	/**
	 * Creates a new document type master with the primary key. Does not add the document type master to the database.
	 *
	 * @param documentTypeMasterId the primary key for the new document type master
	 * @return the new document type master
	 */
	@Override
	public DocumentTypeMaster create(long documentTypeMasterId) {
		DocumentTypeMaster documentTypeMaster = new DocumentTypeMasterImpl();

		documentTypeMaster.setNew(true);
		documentTypeMaster.setPrimaryKey(documentTypeMasterId);

		documentTypeMaster.setCompanyId(CompanyThreadLocal.getCompanyId());

		return documentTypeMaster;
	}

	/**
	 * Removes the document type master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param documentTypeMasterId the primary key of the document type master
	 * @return the document type master that was removed
	 * @throws NoSuchDocumentTypeMasterException if a document type master with the primary key could not be found
	 */
	@Override
	public DocumentTypeMaster remove(long documentTypeMasterId)
		throws NoSuchDocumentTypeMasterException {

		return remove((Serializable)documentTypeMasterId);
	}

	/**
	 * Removes the document type master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the document type master
	 * @return the document type master that was removed
	 * @throws NoSuchDocumentTypeMasterException if a document type master with the primary key could not be found
	 */
	@Override
	public DocumentTypeMaster remove(Serializable primaryKey)
		throws NoSuchDocumentTypeMasterException {

		Session session = null;

		try {
			session = openSession();

			DocumentTypeMaster documentTypeMaster =
				(DocumentTypeMaster)session.get(
					DocumentTypeMasterImpl.class, primaryKey);

			if (documentTypeMaster == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDocumentTypeMasterException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(documentTypeMaster);
		}
		catch (NoSuchDocumentTypeMasterException noSuchEntityException) {
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
	protected DocumentTypeMaster removeImpl(
		DocumentTypeMaster documentTypeMaster) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(documentTypeMaster)) {
				documentTypeMaster = (DocumentTypeMaster)session.get(
					DocumentTypeMasterImpl.class,
					documentTypeMaster.getPrimaryKeyObj());
			}

			if (documentTypeMaster != null) {
				session.delete(documentTypeMaster);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (documentTypeMaster != null) {
			clearCache(documentTypeMaster);
		}

		return documentTypeMaster;
	}

	@Override
	public DocumentTypeMaster updateImpl(
		DocumentTypeMaster documentTypeMaster) {

		boolean isNew = documentTypeMaster.isNew();

		if (!(documentTypeMaster instanceof DocumentTypeMasterModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(documentTypeMaster.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					documentTypeMaster);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in documentTypeMaster proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom DocumentTypeMaster implementation " +
					documentTypeMaster.getClass());
		}

		DocumentTypeMasterModelImpl documentTypeMasterModelImpl =
			(DocumentTypeMasterModelImpl)documentTypeMaster;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (documentTypeMaster.getCreateDate() == null)) {
			if (serviceContext == null) {
				documentTypeMaster.setCreateDate(date);
			}
			else {
				documentTypeMaster.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!documentTypeMasterModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				documentTypeMaster.setModifiedDate(date);
			}
			else {
				documentTypeMaster.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(documentTypeMaster);
			}
			else {
				documentTypeMaster = (DocumentTypeMaster)session.merge(
					documentTypeMaster);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			DocumentTypeMasterImpl.class, documentTypeMasterModelImpl, false,
			true);

		cacheUniqueFindersCache(documentTypeMasterModelImpl);

		if (isNew) {
			documentTypeMaster.setNew(false);
		}

		documentTypeMaster.resetOriginalValues();

		return documentTypeMaster;
	}

	/**
	 * Returns the document type master with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the document type master
	 * @return the document type master
	 * @throws NoSuchDocumentTypeMasterException if a document type master with the primary key could not be found
	 */
	@Override
	public DocumentTypeMaster findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDocumentTypeMasterException {

		DocumentTypeMaster documentTypeMaster = fetchByPrimaryKey(primaryKey);

		if (documentTypeMaster == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDocumentTypeMasterException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return documentTypeMaster;
	}

	/**
	 * Returns the document type master with the primary key or throws a <code>NoSuchDocumentTypeMasterException</code> if it could not be found.
	 *
	 * @param documentTypeMasterId the primary key of the document type master
	 * @return the document type master
	 * @throws NoSuchDocumentTypeMasterException if a document type master with the primary key could not be found
	 */
	@Override
	public DocumentTypeMaster findByPrimaryKey(long documentTypeMasterId)
		throws NoSuchDocumentTypeMasterException {

		return findByPrimaryKey((Serializable)documentTypeMasterId);
	}

	/**
	 * Returns the document type master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param documentTypeMasterId the primary key of the document type master
	 * @return the document type master, or <code>null</code> if a document type master with the primary key could not be found
	 */
	@Override
	public DocumentTypeMaster fetchByPrimaryKey(long documentTypeMasterId) {
		return fetchByPrimaryKey((Serializable)documentTypeMasterId);
	}

	/**
	 * Returns all the document type masters.
	 *
	 * @return the document type masters
	 */
	@Override
	public List<DocumentTypeMaster> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the document type masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of document type masters
	 * @param end the upper bound of the range of document type masters (not inclusive)
	 * @return the range of document type masters
	 */
	@Override
	public List<DocumentTypeMaster> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the document type masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of document type masters
	 * @param end the upper bound of the range of document type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of document type masters
	 */
	@Override
	public List<DocumentTypeMaster> findAll(
		int start, int end,
		OrderByComparator<DocumentTypeMaster> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the document type masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of document type masters
	 * @param end the upper bound of the range of document type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of document type masters
	 */
	@Override
	public List<DocumentTypeMaster> findAll(
		int start, int end,
		OrderByComparator<DocumentTypeMaster> orderByComparator,
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

		List<DocumentTypeMaster> list = null;

		if (useFinderCache) {
			list = (List<DocumentTypeMaster>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DOCUMENTTYPEMASTER);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DOCUMENTTYPEMASTER;

				sql = sql.concat(DocumentTypeMasterModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<DocumentTypeMaster>)QueryUtil.list(
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
	 * Removes all the document type masters from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DocumentTypeMaster documentTypeMaster : findAll()) {
			remove(documentTypeMaster);
		}
	}

	/**
	 * Returns the number of document type masters.
	 *
	 * @return the number of document type masters
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
					_SQL_COUNT_DOCUMENTTYPEMASTER);

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
		return "documentTypeMasterId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_DOCUMENTTYPEMASTER;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DocumentTypeMasterModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the document type master persistence.
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

		_finderPathFetchByDocumentTypeName = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByDocumentTypeName",
			new String[] {String.class.getName()},
			new String[] {"documentTypeName"}, true);

		_finderPathCountByDocumentTypeName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByDocumentTypeName", new String[] {String.class.getName()},
			new String[] {"documentTypeName"}, false);

		DocumentTypeMasterUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		DocumentTypeMasterUtil.setPersistence(null);

		entityCache.removeCache(DocumentTypeMasterImpl.class.getName());
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

	private static final String _SQL_SELECT_DOCUMENTTYPEMASTER =
		"SELECT documentTypeMaster FROM DocumentTypeMaster documentTypeMaster";

	private static final String _SQL_SELECT_DOCUMENTTYPEMASTER_WHERE =
		"SELECT documentTypeMaster FROM DocumentTypeMaster documentTypeMaster WHERE ";

	private static final String _SQL_COUNT_DOCUMENTTYPEMASTER =
		"SELECT COUNT(documentTypeMaster) FROM DocumentTypeMaster documentTypeMaster";

	private static final String _SQL_COUNT_DOCUMENTTYPEMASTER_WHERE =
		"SELECT COUNT(documentTypeMaster) FROM DocumentTypeMaster documentTypeMaster WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "documentTypeMaster.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No DocumentTypeMaster exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No DocumentTypeMaster exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		DocumentTypeMasterPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}