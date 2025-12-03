/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.master.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the ProjectTaskStatusMaster service. Represents a row in the &quot;ax_master_ProjectTaskStatusMaster&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see ProjectTaskStatusMasterModel
 * @generated
 */
@ImplementationClassName(
	"com.ax.hrms.master.model.impl.ProjectTaskStatusMasterImpl"
)
@ProviderType
public interface ProjectTaskStatusMaster
	extends PersistedModel, ProjectTaskStatusMasterModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.ax.hrms.master.model.impl.ProjectTaskStatusMasterImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<ProjectTaskStatusMaster, Long>
		PROJECT_TASK_STATUS_MASTER_ID_ACCESSOR =
			new Accessor<ProjectTaskStatusMaster, Long>() {

				@Override
				public Long get(
					ProjectTaskStatusMaster projectTaskStatusMaster) {

					return projectTaskStatusMaster.
						getProjectTaskStatusMasterId();
				}

				@Override
				public Class<Long> getAttributeClass() {
					return Long.class;
				}

				@Override
				public Class<ProjectTaskStatusMaster> getTypeClass() {
					return ProjectTaskStatusMaster.class;
				}

			};

}