/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence;

import com.ax.hrms.exception.NoSuchEmployeeBankAccountException;
import com.ax.hrms.model.EmployeeBankAccount;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the employee bank account service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeBankAccountUtil
 * @generated
 */
@ProviderType
public interface EmployeeBankAccountPersistence
	extends BasePersistence<EmployeeBankAccount> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EmployeeBankAccountUtil} to access the employee bank account persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the employee bank accounts where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching employee bank accounts
	 */
	public java.util.List<EmployeeBankAccount> findByUuid(String uuid);

	/**
	 * Returns a range of all the employee bank accounts where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeBankAccountModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee bank accounts
	 * @param end the upper bound of the range of employee bank accounts (not inclusive)
	 * @return the range of matching employee bank accounts
	 */
	public java.util.List<EmployeeBankAccount> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the employee bank accounts where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeBankAccountModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee bank accounts
	 * @param end the upper bound of the range of employee bank accounts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee bank accounts
	 */
	public java.util.List<EmployeeBankAccount> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeBankAccount>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee bank accounts where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeBankAccountModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee bank accounts
	 * @param end the upper bound of the range of employee bank accounts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee bank accounts
	 */
	public java.util.List<EmployeeBankAccount> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeBankAccount>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee bank account in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee bank account
	 * @throws NoSuchEmployeeBankAccountException if a matching employee bank account could not be found
	 */
	public EmployeeBankAccount findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeBankAccount> orderByComparator)
		throws NoSuchEmployeeBankAccountException;

	/**
	 * Returns the first employee bank account in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee bank account, or <code>null</code> if a matching employee bank account could not be found
	 */
	public EmployeeBankAccount fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeBankAccount>
			orderByComparator);

	/**
	 * Returns the last employee bank account in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee bank account
	 * @throws NoSuchEmployeeBankAccountException if a matching employee bank account could not be found
	 */
	public EmployeeBankAccount findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeBankAccount> orderByComparator)
		throws NoSuchEmployeeBankAccountException;

	/**
	 * Returns the last employee bank account in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee bank account, or <code>null</code> if a matching employee bank account could not be found
	 */
	public EmployeeBankAccount fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeBankAccount>
			orderByComparator);

	/**
	 * Returns the employee bank accounts before and after the current employee bank account in the ordered set where uuid = &#63;.
	 *
	 * @param bankAccountId the primary key of the current employee bank account
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee bank account
	 * @throws NoSuchEmployeeBankAccountException if a employee bank account with the primary key could not be found
	 */
	public EmployeeBankAccount[] findByUuid_PrevAndNext(
			long bankAccountId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeBankAccount> orderByComparator)
		throws NoSuchEmployeeBankAccountException;

	/**
	 * Removes all the employee bank accounts where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of employee bank accounts where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching employee bank accounts
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the employee bank account where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchEmployeeBankAccountException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching employee bank account
	 * @throws NoSuchEmployeeBankAccountException if a matching employee bank account could not be found
	 */
	public EmployeeBankAccount findByUUID_G(String uuid, long groupId)
		throws NoSuchEmployeeBankAccountException;

	/**
	 * Returns the employee bank account where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching employee bank account, or <code>null</code> if a matching employee bank account could not be found
	 */
	public EmployeeBankAccount fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the employee bank account where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching employee bank account, or <code>null</code> if a matching employee bank account could not be found
	 */
	public EmployeeBankAccount fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the employee bank account where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the employee bank account that was removed
	 */
	public EmployeeBankAccount removeByUUID_G(String uuid, long groupId)
		throws NoSuchEmployeeBankAccountException;

	/**
	 * Returns the number of employee bank accounts where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching employee bank accounts
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the employee bank accounts where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching employee bank accounts
	 */
	public java.util.List<EmployeeBankAccount> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the employee bank accounts where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeBankAccountModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee bank accounts
	 * @param end the upper bound of the range of employee bank accounts (not inclusive)
	 * @return the range of matching employee bank accounts
	 */
	public java.util.List<EmployeeBankAccount> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the employee bank accounts where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeBankAccountModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee bank accounts
	 * @param end the upper bound of the range of employee bank accounts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee bank accounts
	 */
	public java.util.List<EmployeeBankAccount> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeBankAccount>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee bank accounts where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeBankAccountModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee bank accounts
	 * @param end the upper bound of the range of employee bank accounts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee bank accounts
	 */
	public java.util.List<EmployeeBankAccount> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeBankAccount>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee bank account in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee bank account
	 * @throws NoSuchEmployeeBankAccountException if a matching employee bank account could not be found
	 */
	public EmployeeBankAccount findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeBankAccount> orderByComparator)
		throws NoSuchEmployeeBankAccountException;

	/**
	 * Returns the first employee bank account in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee bank account, or <code>null</code> if a matching employee bank account could not be found
	 */
	public EmployeeBankAccount fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeBankAccount>
			orderByComparator);

	/**
	 * Returns the last employee bank account in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee bank account
	 * @throws NoSuchEmployeeBankAccountException if a matching employee bank account could not be found
	 */
	public EmployeeBankAccount findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeBankAccount> orderByComparator)
		throws NoSuchEmployeeBankAccountException;

	/**
	 * Returns the last employee bank account in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee bank account, or <code>null</code> if a matching employee bank account could not be found
	 */
	public EmployeeBankAccount fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeBankAccount>
			orderByComparator);

	/**
	 * Returns the employee bank accounts before and after the current employee bank account in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param bankAccountId the primary key of the current employee bank account
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee bank account
	 * @throws NoSuchEmployeeBankAccountException if a employee bank account with the primary key could not be found
	 */
	public EmployeeBankAccount[] findByUuid_C_PrevAndNext(
			long bankAccountId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeBankAccount> orderByComparator)
		throws NoSuchEmployeeBankAccountException;

	/**
	 * Removes all the employee bank accounts where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of employee bank accounts where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching employee bank accounts
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Caches the employee bank account in the entity cache if it is enabled.
	 *
	 * @param employeeBankAccount the employee bank account
	 */
	public void cacheResult(EmployeeBankAccount employeeBankAccount);

	/**
	 * Caches the employee bank accounts in the entity cache if it is enabled.
	 *
	 * @param employeeBankAccounts the employee bank accounts
	 */
	public void cacheResult(
		java.util.List<EmployeeBankAccount> employeeBankAccounts);

	/**
	 * Creates a new employee bank account with the primary key. Does not add the employee bank account to the database.
	 *
	 * @param bankAccountId the primary key for the new employee bank account
	 * @return the new employee bank account
	 */
	public EmployeeBankAccount create(long bankAccountId);

	/**
	 * Removes the employee bank account with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param bankAccountId the primary key of the employee bank account
	 * @return the employee bank account that was removed
	 * @throws NoSuchEmployeeBankAccountException if a employee bank account with the primary key could not be found
	 */
	public EmployeeBankAccount remove(long bankAccountId)
		throws NoSuchEmployeeBankAccountException;

	public EmployeeBankAccount updateImpl(
		EmployeeBankAccount employeeBankAccount);

	/**
	 * Returns the employee bank account with the primary key or throws a <code>NoSuchEmployeeBankAccountException</code> if it could not be found.
	 *
	 * @param bankAccountId the primary key of the employee bank account
	 * @return the employee bank account
	 * @throws NoSuchEmployeeBankAccountException if a employee bank account with the primary key could not be found
	 */
	public EmployeeBankAccount findByPrimaryKey(long bankAccountId)
		throws NoSuchEmployeeBankAccountException;

	/**
	 * Returns the employee bank account with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param bankAccountId the primary key of the employee bank account
	 * @return the employee bank account, or <code>null</code> if a employee bank account with the primary key could not be found
	 */
	public EmployeeBankAccount fetchByPrimaryKey(long bankAccountId);

	/**
	 * Returns all the employee bank accounts.
	 *
	 * @return the employee bank accounts
	 */
	public java.util.List<EmployeeBankAccount> findAll();

	/**
	 * Returns a range of all the employee bank accounts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeBankAccountModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee bank accounts
	 * @param end the upper bound of the range of employee bank accounts (not inclusive)
	 * @return the range of employee bank accounts
	 */
	public java.util.List<EmployeeBankAccount> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the employee bank accounts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeBankAccountModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee bank accounts
	 * @param end the upper bound of the range of employee bank accounts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee bank accounts
	 */
	public java.util.List<EmployeeBankAccount> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeBankAccount>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee bank accounts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeBankAccountModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee bank accounts
	 * @param end the upper bound of the range of employee bank accounts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee bank accounts
	 */
	public java.util.List<EmployeeBankAccount> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeBankAccount>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the employee bank accounts from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of employee bank accounts.
	 *
	 * @return the number of employee bank accounts
	 */
	public int countAll();

}