/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.master.service.persistence.impl;

import com.ax.hrms.master.exception.NoSuchProjectTaskStatusMasterException;
import com.ax.hrms.master.model.ProjectTaskStatusMaster;
import com.ax.hrms.master.model.ProjectTaskStatusMasterTable;
import com.ax.hrms.master.model.impl.ProjectTaskStatusMasterImpl;
import com.ax.hrms.master.model.impl.ProjectTaskStatusMasterModelImpl;
import com.ax.hrms.master.service.persistence.ProjectTaskStatusMasterPersistence;
import com.ax.hrms.master.service.persistence.ProjectTaskStatusMasterUtil;
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
 * The persistence implementation for the project task status master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ProjectTaskStatusMasterPersistence.class)
public class ProjectTaskStatusMasterPersistenceImpl
	extends BasePersistenceImpl<ProjectTaskStatusMaster>
	implements ProjectTaskStatusMasterPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ProjectTaskStatusMasterUtil</code> to access the project task status master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ProjectTaskStatusMasterImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath
		_finderPathFetchByStatusNameAndApplicableForProjectAndTask;
	private FinderPath
		_finderPathCountByStatusNameAndApplicableForProjectAndTask;

	/**
	 * Returns the project task status master where projectTaskStatusName = &#63; and isApplicableForProject = &#63; and isApplicableForTask = &#63; or throws a <code>NoSuchProjectTaskStatusMasterException</code> if it could not be found.
	 *
	 * @param projectTaskStatusName the project task status name
	 * @param isApplicableForProject the is applicable for project
	 * @param isApplicableForTask the is applicable for task
	 * @return the matching project task status master
	 * @throws NoSuchProjectTaskStatusMasterException if a matching project task status master could not be found
	 */
	@Override
	public ProjectTaskStatusMaster
			findByStatusNameAndApplicableForProjectAndTask(
				String projectTaskStatusName, boolean isApplicableForProject,
				boolean isApplicableForTask)
		throws NoSuchProjectTaskStatusMasterException {

		ProjectTaskStatusMaster projectTaskStatusMaster =
			fetchByStatusNameAndApplicableForProjectAndTask(
				projectTaskStatusName, isApplicableForProject,
				isApplicableForTask);

		if (projectTaskStatusMaster == null) {
			StringBundler sb = new StringBundler(8);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("projectTaskStatusName=");
			sb.append(projectTaskStatusName);

			sb.append(", isApplicableForProject=");
			sb.append(isApplicableForProject);

			sb.append(", isApplicableForTask=");
			sb.append(isApplicableForTask);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchProjectTaskStatusMasterException(sb.toString());
		}

		return projectTaskStatusMaster;
	}

	/**
	 * Returns the project task status master where projectTaskStatusName = &#63; and isApplicableForProject = &#63; and isApplicableForTask = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param projectTaskStatusName the project task status name
	 * @param isApplicableForProject the is applicable for project
	 * @param isApplicableForTask the is applicable for task
	 * @return the matching project task status master, or <code>null</code> if a matching project task status master could not be found
	 */
	@Override
	public ProjectTaskStatusMaster
		fetchByStatusNameAndApplicableForProjectAndTask(
			String projectTaskStatusName, boolean isApplicableForProject,
			boolean isApplicableForTask) {

		return fetchByStatusNameAndApplicableForProjectAndTask(
			projectTaskStatusName, isApplicableForProject, isApplicableForTask,
			true);
	}

	/**
	 * Returns the project task status master where projectTaskStatusName = &#63; and isApplicableForProject = &#63; and isApplicableForTask = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param projectTaskStatusName the project task status name
	 * @param isApplicableForProject the is applicable for project
	 * @param isApplicableForTask the is applicable for task
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching project task status master, or <code>null</code> if a matching project task status master could not be found
	 */
	@Override
	public ProjectTaskStatusMaster
		fetchByStatusNameAndApplicableForProjectAndTask(
			String projectTaskStatusName, boolean isApplicableForProject,
			boolean isApplicableForTask, boolean useFinderCache) {

		projectTaskStatusName = Objects.toString(projectTaskStatusName, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {
				projectTaskStatusName, isApplicableForProject,
				isApplicableForTask
			};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByStatusNameAndApplicableForProjectAndTask,
				finderArgs, this);
		}

		if (result instanceof ProjectTaskStatusMaster) {
			ProjectTaskStatusMaster projectTaskStatusMaster =
				(ProjectTaskStatusMaster)result;

			if (!Objects.equals(
					projectTaskStatusName,
					projectTaskStatusMaster.getProjectTaskStatusName()) ||
				(isApplicableForProject !=
					projectTaskStatusMaster.isIsApplicableForProject()) ||
				(isApplicableForTask !=
					projectTaskStatusMaster.isIsApplicableForTask())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(5);

			sb.append(_SQL_SELECT_PROJECTTASKSTATUSMASTER_WHERE);

			boolean bindProjectTaskStatusName = false;

			if (projectTaskStatusName.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_STATUSNAMEANDAPPLICABLEFORPROJECTANDTASK_PROJECTTASKSTATUSNAME_3);
			}
			else {
				bindProjectTaskStatusName = true;

				sb.append(
					_FINDER_COLUMN_STATUSNAMEANDAPPLICABLEFORPROJECTANDTASK_PROJECTTASKSTATUSNAME_2);
			}

			sb.append(
				_FINDER_COLUMN_STATUSNAMEANDAPPLICABLEFORPROJECTANDTASK_ISAPPLICABLEFORPROJECT_2);

			sb.append(
				_FINDER_COLUMN_STATUSNAMEANDAPPLICABLEFORPROJECTANDTASK_ISAPPLICABLEFORTASK_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindProjectTaskStatusName) {
					queryPos.add(StringUtil.toLowerCase(projectTaskStatusName));
				}

				queryPos.add(isApplicableForProject);

				queryPos.add(isApplicableForTask);

				List<ProjectTaskStatusMaster> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByStatusNameAndApplicableForProjectAndTask,
							finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									projectTaskStatusName,
									isApplicableForProject, isApplicableForTask
								};
							}

							_log.warn(
								"ProjectTaskStatusMasterPersistenceImpl.fetchByStatusNameAndApplicableForProjectAndTask(String, boolean, boolean, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					ProjectTaskStatusMaster projectTaskStatusMaster = list.get(
						0);

					result = projectTaskStatusMaster;

					cacheResult(projectTaskStatusMaster);
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
			return (ProjectTaskStatusMaster)result;
		}
	}

	/**
	 * Removes the project task status master where projectTaskStatusName = &#63; and isApplicableForProject = &#63; and isApplicableForTask = &#63; from the database.
	 *
	 * @param projectTaskStatusName the project task status name
	 * @param isApplicableForProject the is applicable for project
	 * @param isApplicableForTask the is applicable for task
	 * @return the project task status master that was removed
	 */
	@Override
	public ProjectTaskStatusMaster
			removeByStatusNameAndApplicableForProjectAndTask(
				String projectTaskStatusName, boolean isApplicableForProject,
				boolean isApplicableForTask)
		throws NoSuchProjectTaskStatusMasterException {

		ProjectTaskStatusMaster projectTaskStatusMaster =
			findByStatusNameAndApplicableForProjectAndTask(
				projectTaskStatusName, isApplicableForProject,
				isApplicableForTask);

		return remove(projectTaskStatusMaster);
	}

	/**
	 * Returns the number of project task status masters where projectTaskStatusName = &#63; and isApplicableForProject = &#63; and isApplicableForTask = &#63;.
	 *
	 * @param projectTaskStatusName the project task status name
	 * @param isApplicableForProject the is applicable for project
	 * @param isApplicableForTask the is applicable for task
	 * @return the number of matching project task status masters
	 */
	@Override
	public int countByStatusNameAndApplicableForProjectAndTask(
		String projectTaskStatusName, boolean isApplicableForProject,
		boolean isApplicableForTask) {

		projectTaskStatusName = Objects.toString(projectTaskStatusName, "");

		FinderPath finderPath =
			_finderPathCountByStatusNameAndApplicableForProjectAndTask;

		Object[] finderArgs = new Object[] {
			projectTaskStatusName, isApplicableForProject, isApplicableForTask
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_PROJECTTASKSTATUSMASTER_WHERE);

			boolean bindProjectTaskStatusName = false;

			if (projectTaskStatusName.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_STATUSNAMEANDAPPLICABLEFORPROJECTANDTASK_PROJECTTASKSTATUSNAME_3);
			}
			else {
				bindProjectTaskStatusName = true;

				sb.append(
					_FINDER_COLUMN_STATUSNAMEANDAPPLICABLEFORPROJECTANDTASK_PROJECTTASKSTATUSNAME_2);
			}

			sb.append(
				_FINDER_COLUMN_STATUSNAMEANDAPPLICABLEFORPROJECTANDTASK_ISAPPLICABLEFORPROJECT_2);

			sb.append(
				_FINDER_COLUMN_STATUSNAMEANDAPPLICABLEFORPROJECTANDTASK_ISAPPLICABLEFORTASK_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindProjectTaskStatusName) {
					queryPos.add(StringUtil.toLowerCase(projectTaskStatusName));
				}

				queryPos.add(isApplicableForProject);

				queryPos.add(isApplicableForTask);

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
		_FINDER_COLUMN_STATUSNAMEANDAPPLICABLEFORPROJECTANDTASK_PROJECTTASKSTATUSNAME_2 =
			"lower(projectTaskStatusMaster.projectTaskStatusName) = ? AND ";

	private static final String
		_FINDER_COLUMN_STATUSNAMEANDAPPLICABLEFORPROJECTANDTASK_PROJECTTASKSTATUSNAME_3 =
			"(projectTaskStatusMaster.projectTaskStatusName IS NULL OR projectTaskStatusMaster.projectTaskStatusName = '') AND ";

	private static final String
		_FINDER_COLUMN_STATUSNAMEANDAPPLICABLEFORPROJECTANDTASK_ISAPPLICABLEFORPROJECT_2 =
			"projectTaskStatusMaster.isApplicableForProject = ? AND ";

	private static final String
		_FINDER_COLUMN_STATUSNAMEANDAPPLICABLEFORPROJECTANDTASK_ISAPPLICABLEFORTASK_2 =
			"projectTaskStatusMaster.isApplicableForTask = ?";

	private FinderPath _finderPathFetchByProjectTaskStatusName;
	private FinderPath _finderPathCountByProjectTaskStatusName;

	/**
	 * Returns the project task status master where projectTaskStatusName = &#63; or throws a <code>NoSuchProjectTaskStatusMasterException</code> if it could not be found.
	 *
	 * @param projectTaskStatusName the project task status name
	 * @return the matching project task status master
	 * @throws NoSuchProjectTaskStatusMasterException if a matching project task status master could not be found
	 */
	@Override
	public ProjectTaskStatusMaster findByProjectTaskStatusName(
			String projectTaskStatusName)
		throws NoSuchProjectTaskStatusMasterException {

		ProjectTaskStatusMaster projectTaskStatusMaster =
			fetchByProjectTaskStatusName(projectTaskStatusName);

		if (projectTaskStatusMaster == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("projectTaskStatusName=");
			sb.append(projectTaskStatusName);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchProjectTaskStatusMasterException(sb.toString());
		}

		return projectTaskStatusMaster;
	}

	/**
	 * Returns the project task status master where projectTaskStatusName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param projectTaskStatusName the project task status name
	 * @return the matching project task status master, or <code>null</code> if a matching project task status master could not be found
	 */
	@Override
	public ProjectTaskStatusMaster fetchByProjectTaskStatusName(
		String projectTaskStatusName) {

		return fetchByProjectTaskStatusName(projectTaskStatusName, true);
	}

	/**
	 * Returns the project task status master where projectTaskStatusName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param projectTaskStatusName the project task status name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching project task status master, or <code>null</code> if a matching project task status master could not be found
	 */
	@Override
	public ProjectTaskStatusMaster fetchByProjectTaskStatusName(
		String projectTaskStatusName, boolean useFinderCache) {

		projectTaskStatusName = Objects.toString(projectTaskStatusName, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {projectTaskStatusName};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByProjectTaskStatusName, finderArgs, this);
		}

		if (result instanceof ProjectTaskStatusMaster) {
			ProjectTaskStatusMaster projectTaskStatusMaster =
				(ProjectTaskStatusMaster)result;

			if (!Objects.equals(
					projectTaskStatusName,
					projectTaskStatusMaster.getProjectTaskStatusName())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_PROJECTTASKSTATUSMASTER_WHERE);

			boolean bindProjectTaskStatusName = false;

			if (projectTaskStatusName.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_PROJECTTASKSTATUSNAME_PROJECTTASKSTATUSNAME_3);
			}
			else {
				bindProjectTaskStatusName = true;

				sb.append(
					_FINDER_COLUMN_PROJECTTASKSTATUSNAME_PROJECTTASKSTATUSNAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindProjectTaskStatusName) {
					queryPos.add(StringUtil.toLowerCase(projectTaskStatusName));
				}

				List<ProjectTaskStatusMaster> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByProjectTaskStatusName, finderArgs,
							list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									projectTaskStatusName
								};
							}

							_log.warn(
								"ProjectTaskStatusMasterPersistenceImpl.fetchByProjectTaskStatusName(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					ProjectTaskStatusMaster projectTaskStatusMaster = list.get(
						0);

					result = projectTaskStatusMaster;

					cacheResult(projectTaskStatusMaster);
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
			return (ProjectTaskStatusMaster)result;
		}
	}

	/**
	 * Removes the project task status master where projectTaskStatusName = &#63; from the database.
	 *
	 * @param projectTaskStatusName the project task status name
	 * @return the project task status master that was removed
	 */
	@Override
	public ProjectTaskStatusMaster removeByProjectTaskStatusName(
			String projectTaskStatusName)
		throws NoSuchProjectTaskStatusMasterException {

		ProjectTaskStatusMaster projectTaskStatusMaster =
			findByProjectTaskStatusName(projectTaskStatusName);

		return remove(projectTaskStatusMaster);
	}

	/**
	 * Returns the number of project task status masters where projectTaskStatusName = &#63;.
	 *
	 * @param projectTaskStatusName the project task status name
	 * @return the number of matching project task status masters
	 */
	@Override
	public int countByProjectTaskStatusName(String projectTaskStatusName) {
		projectTaskStatusName = Objects.toString(projectTaskStatusName, "");

		FinderPath finderPath = _finderPathCountByProjectTaskStatusName;

		Object[] finderArgs = new Object[] {projectTaskStatusName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PROJECTTASKSTATUSMASTER_WHERE);

			boolean bindProjectTaskStatusName = false;

			if (projectTaskStatusName.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_PROJECTTASKSTATUSNAME_PROJECTTASKSTATUSNAME_3);
			}
			else {
				bindProjectTaskStatusName = true;

				sb.append(
					_FINDER_COLUMN_PROJECTTASKSTATUSNAME_PROJECTTASKSTATUSNAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindProjectTaskStatusName) {
					queryPos.add(StringUtil.toLowerCase(projectTaskStatusName));
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
		_FINDER_COLUMN_PROJECTTASKSTATUSNAME_PROJECTTASKSTATUSNAME_2 =
			"lower(projectTaskStatusMaster.projectTaskStatusName) = ?";

	private static final String
		_FINDER_COLUMN_PROJECTTASKSTATUSNAME_PROJECTTASKSTATUSNAME_3 =
			"(projectTaskStatusMaster.projectTaskStatusName IS NULL OR projectTaskStatusMaster.projectTaskStatusName = '')";

	public ProjectTaskStatusMasterPersistenceImpl() {
		setModelClass(ProjectTaskStatusMaster.class);

		setModelImplClass(ProjectTaskStatusMasterImpl.class);
		setModelPKClass(long.class);

		setTable(ProjectTaskStatusMasterTable.INSTANCE);
	}

	/**
	 * Caches the project task status master in the entity cache if it is enabled.
	 *
	 * @param projectTaskStatusMaster the project task status master
	 */
	@Override
	public void cacheResult(ProjectTaskStatusMaster projectTaskStatusMaster) {
		entityCache.putResult(
			ProjectTaskStatusMasterImpl.class,
			projectTaskStatusMaster.getPrimaryKey(), projectTaskStatusMaster);

		finderCache.putResult(
			_finderPathFetchByStatusNameAndApplicableForProjectAndTask,
			new Object[] {
				projectTaskStatusMaster.getProjectTaskStatusName(),
				projectTaskStatusMaster.isIsApplicableForProject(),
				projectTaskStatusMaster.isIsApplicableForTask()
			},
			projectTaskStatusMaster);

		finderCache.putResult(
			_finderPathFetchByProjectTaskStatusName,
			new Object[] {projectTaskStatusMaster.getProjectTaskStatusName()},
			projectTaskStatusMaster);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the project task status masters in the entity cache if it is enabled.
	 *
	 * @param projectTaskStatusMasters the project task status masters
	 */
	@Override
	public void cacheResult(
		List<ProjectTaskStatusMaster> projectTaskStatusMasters) {

		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (projectTaskStatusMasters.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (ProjectTaskStatusMaster projectTaskStatusMaster :
				projectTaskStatusMasters) {

			if (entityCache.getResult(
					ProjectTaskStatusMasterImpl.class,
					projectTaskStatusMaster.getPrimaryKey()) == null) {

				cacheResult(projectTaskStatusMaster);
			}
		}
	}

	/**
	 * Clears the cache for all project task status masters.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ProjectTaskStatusMasterImpl.class);

		finderCache.clearCache(ProjectTaskStatusMasterImpl.class);
	}

	/**
	 * Clears the cache for the project task status master.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ProjectTaskStatusMaster projectTaskStatusMaster) {
		entityCache.removeResult(
			ProjectTaskStatusMasterImpl.class, projectTaskStatusMaster);
	}

	@Override
	public void clearCache(
		List<ProjectTaskStatusMaster> projectTaskStatusMasters) {

		for (ProjectTaskStatusMaster projectTaskStatusMaster :
				projectTaskStatusMasters) {

			entityCache.removeResult(
				ProjectTaskStatusMasterImpl.class, projectTaskStatusMaster);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(ProjectTaskStatusMasterImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				ProjectTaskStatusMasterImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		ProjectTaskStatusMasterModelImpl projectTaskStatusMasterModelImpl) {

		Object[] args = new Object[] {
			projectTaskStatusMasterModelImpl.getProjectTaskStatusName(),
			projectTaskStatusMasterModelImpl.isIsApplicableForProject(),
			projectTaskStatusMasterModelImpl.isIsApplicableForTask()
		};

		finderCache.putResult(
			_finderPathCountByStatusNameAndApplicableForProjectAndTask, args,
			Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByStatusNameAndApplicableForProjectAndTask, args,
			projectTaskStatusMasterModelImpl);

		args = new Object[] {
			projectTaskStatusMasterModelImpl.getProjectTaskStatusName()
		};

		finderCache.putResult(
			_finderPathCountByProjectTaskStatusName, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByProjectTaskStatusName, args,
			projectTaskStatusMasterModelImpl);
	}

	/**
	 * Creates a new project task status master with the primary key. Does not add the project task status master to the database.
	 *
	 * @param projectTaskStatusMasterId the primary key for the new project task status master
	 * @return the new project task status master
	 */
	@Override
	public ProjectTaskStatusMaster create(long projectTaskStatusMasterId) {
		ProjectTaskStatusMaster projectTaskStatusMaster =
			new ProjectTaskStatusMasterImpl();

		projectTaskStatusMaster.setNew(true);
		projectTaskStatusMaster.setPrimaryKey(projectTaskStatusMasterId);

		projectTaskStatusMaster.setCompanyId(CompanyThreadLocal.getCompanyId());

		return projectTaskStatusMaster;
	}

	/**
	 * Removes the project task status master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param projectTaskStatusMasterId the primary key of the project task status master
	 * @return the project task status master that was removed
	 * @throws NoSuchProjectTaskStatusMasterException if a project task status master with the primary key could not be found
	 */
	@Override
	public ProjectTaskStatusMaster remove(long projectTaskStatusMasterId)
		throws NoSuchProjectTaskStatusMasterException {

		return remove((Serializable)projectTaskStatusMasterId);
	}

	/**
	 * Removes the project task status master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the project task status master
	 * @return the project task status master that was removed
	 * @throws NoSuchProjectTaskStatusMasterException if a project task status master with the primary key could not be found
	 */
	@Override
	public ProjectTaskStatusMaster remove(Serializable primaryKey)
		throws NoSuchProjectTaskStatusMasterException {

		Session session = null;

		try {
			session = openSession();

			ProjectTaskStatusMaster projectTaskStatusMaster =
				(ProjectTaskStatusMaster)session.get(
					ProjectTaskStatusMasterImpl.class, primaryKey);

			if (projectTaskStatusMaster == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProjectTaskStatusMasterException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(projectTaskStatusMaster);
		}
		catch (NoSuchProjectTaskStatusMasterException noSuchEntityException) {
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
	protected ProjectTaskStatusMaster removeImpl(
		ProjectTaskStatusMaster projectTaskStatusMaster) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(projectTaskStatusMaster)) {
				projectTaskStatusMaster = (ProjectTaskStatusMaster)session.get(
					ProjectTaskStatusMasterImpl.class,
					projectTaskStatusMaster.getPrimaryKeyObj());
			}

			if (projectTaskStatusMaster != null) {
				session.delete(projectTaskStatusMaster);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (projectTaskStatusMaster != null) {
			clearCache(projectTaskStatusMaster);
		}

		return projectTaskStatusMaster;
	}

	@Override
	public ProjectTaskStatusMaster updateImpl(
		ProjectTaskStatusMaster projectTaskStatusMaster) {

		boolean isNew = projectTaskStatusMaster.isNew();

		if (!(projectTaskStatusMaster instanceof
				ProjectTaskStatusMasterModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(projectTaskStatusMaster.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					projectTaskStatusMaster);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in projectTaskStatusMaster proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ProjectTaskStatusMaster implementation " +
					projectTaskStatusMaster.getClass());
		}

		ProjectTaskStatusMasterModelImpl projectTaskStatusMasterModelImpl =
			(ProjectTaskStatusMasterModelImpl)projectTaskStatusMaster;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (projectTaskStatusMaster.getCreateDate() == null)) {
			if (serviceContext == null) {
				projectTaskStatusMaster.setCreateDate(date);
			}
			else {
				projectTaskStatusMaster.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!projectTaskStatusMasterModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				projectTaskStatusMaster.setModifiedDate(date);
			}
			else {
				projectTaskStatusMaster.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(projectTaskStatusMaster);
			}
			else {
				projectTaskStatusMaster =
					(ProjectTaskStatusMaster)session.merge(
						projectTaskStatusMaster);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ProjectTaskStatusMasterImpl.class, projectTaskStatusMasterModelImpl,
			false, true);

		cacheUniqueFindersCache(projectTaskStatusMasterModelImpl);

		if (isNew) {
			projectTaskStatusMaster.setNew(false);
		}

		projectTaskStatusMaster.resetOriginalValues();

		return projectTaskStatusMaster;
	}

	/**
	 * Returns the project task status master with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the project task status master
	 * @return the project task status master
	 * @throws NoSuchProjectTaskStatusMasterException if a project task status master with the primary key could not be found
	 */
	@Override
	public ProjectTaskStatusMaster findByPrimaryKey(Serializable primaryKey)
		throws NoSuchProjectTaskStatusMasterException {

		ProjectTaskStatusMaster projectTaskStatusMaster = fetchByPrimaryKey(
			primaryKey);

		if (projectTaskStatusMaster == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchProjectTaskStatusMasterException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return projectTaskStatusMaster;
	}

	/**
	 * Returns the project task status master with the primary key or throws a <code>NoSuchProjectTaskStatusMasterException</code> if it could not be found.
	 *
	 * @param projectTaskStatusMasterId the primary key of the project task status master
	 * @return the project task status master
	 * @throws NoSuchProjectTaskStatusMasterException if a project task status master with the primary key could not be found
	 */
	@Override
	public ProjectTaskStatusMaster findByPrimaryKey(
			long projectTaskStatusMasterId)
		throws NoSuchProjectTaskStatusMasterException {

		return findByPrimaryKey((Serializable)projectTaskStatusMasterId);
	}

	/**
	 * Returns the project task status master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param projectTaskStatusMasterId the primary key of the project task status master
	 * @return the project task status master, or <code>null</code> if a project task status master with the primary key could not be found
	 */
	@Override
	public ProjectTaskStatusMaster fetchByPrimaryKey(
		long projectTaskStatusMasterId) {

		return fetchByPrimaryKey((Serializable)projectTaskStatusMasterId);
	}

	/**
	 * Returns all the project task status masters.
	 *
	 * @return the project task status masters
	 */
	@Override
	public List<ProjectTaskStatusMaster> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the project task status masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectTaskStatusMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of project task status masters
	 * @param end the upper bound of the range of project task status masters (not inclusive)
	 * @return the range of project task status masters
	 */
	@Override
	public List<ProjectTaskStatusMaster> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the project task status masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectTaskStatusMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of project task status masters
	 * @param end the upper bound of the range of project task status masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of project task status masters
	 */
	@Override
	public List<ProjectTaskStatusMaster> findAll(
		int start, int end,
		OrderByComparator<ProjectTaskStatusMaster> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the project task status masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectTaskStatusMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of project task status masters
	 * @param end the upper bound of the range of project task status masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of project task status masters
	 */
	@Override
	public List<ProjectTaskStatusMaster> findAll(
		int start, int end,
		OrderByComparator<ProjectTaskStatusMaster> orderByComparator,
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

		List<ProjectTaskStatusMaster> list = null;

		if (useFinderCache) {
			list = (List<ProjectTaskStatusMaster>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PROJECTTASKSTATUSMASTER);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PROJECTTASKSTATUSMASTER;

				sql = sql.concat(
					ProjectTaskStatusMasterModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ProjectTaskStatusMaster>)QueryUtil.list(
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
	 * Removes all the project task status masters from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ProjectTaskStatusMaster projectTaskStatusMaster : findAll()) {
			remove(projectTaskStatusMaster);
		}
	}

	/**
	 * Returns the number of project task status masters.
	 *
	 * @return the number of project task status masters
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
					_SQL_COUNT_PROJECTTASKSTATUSMASTER);

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
		return "projectTaskStatusMasterId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PROJECTTASKSTATUSMASTER;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ProjectTaskStatusMasterModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the project task status master persistence.
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

		_finderPathFetchByStatusNameAndApplicableForProjectAndTask =
			new FinderPath(
				FINDER_CLASS_NAME_ENTITY,
				"fetchByStatusNameAndApplicableForProjectAndTask",
				new String[] {
					String.class.getName(), Boolean.class.getName(),
					Boolean.class.getName()
				},
				new String[] {
					"projectTaskStatusName", "isApplicableForProject",
					"isApplicableForTask"
				},
				true);

		_finderPathCountByStatusNameAndApplicableForProjectAndTask =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"countByStatusNameAndApplicableForProjectAndTask",
				new String[] {
					String.class.getName(), Boolean.class.getName(),
					Boolean.class.getName()
				},
				new String[] {
					"projectTaskStatusName", "isApplicableForProject",
					"isApplicableForTask"
				},
				false);

		_finderPathFetchByProjectTaskStatusName = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByProjectTaskStatusName",
			new String[] {String.class.getName()},
			new String[] {"projectTaskStatusName"}, true);

		_finderPathCountByProjectTaskStatusName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByProjectTaskStatusName",
			new String[] {String.class.getName()},
			new String[] {"projectTaskStatusName"}, false);

		ProjectTaskStatusMasterUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		ProjectTaskStatusMasterUtil.setPersistence(null);

		entityCache.removeCache(ProjectTaskStatusMasterImpl.class.getName());
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

	private static final String _SQL_SELECT_PROJECTTASKSTATUSMASTER =
		"SELECT projectTaskStatusMaster FROM ProjectTaskStatusMaster projectTaskStatusMaster";

	private static final String _SQL_SELECT_PROJECTTASKSTATUSMASTER_WHERE =
		"SELECT projectTaskStatusMaster FROM ProjectTaskStatusMaster projectTaskStatusMaster WHERE ";

	private static final String _SQL_COUNT_PROJECTTASKSTATUSMASTER =
		"SELECT COUNT(projectTaskStatusMaster) FROM ProjectTaskStatusMaster projectTaskStatusMaster";

	private static final String _SQL_COUNT_PROJECTTASKSTATUSMASTER_WHERE =
		"SELECT COUNT(projectTaskStatusMaster) FROM ProjectTaskStatusMaster projectTaskStatusMaster WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"projectTaskStatusMaster.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ProjectTaskStatusMaster exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ProjectTaskStatusMaster exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ProjectTaskStatusMasterPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}