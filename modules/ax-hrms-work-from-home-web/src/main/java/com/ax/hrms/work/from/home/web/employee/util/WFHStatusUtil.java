package com.ax.hrms.work.from.home.web.employee.util;

import com.ax.hrms.master.model.LeaveCompensatoryStatusMaster;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.List;
import java.util.Optional;

/**
 * Utility class to get readable WFH status from LeaveCompensatoryStatusMaster
 */
public class WFHStatusUtil {

    private WFHStatusUtil() {
        // Private constructor to prevent instantiation
    }

    private static final Log log = LogFactoryUtil.getLog(WFHStatusUtil.class);

    /**
     * Get WFH status name by status ID
     *
     * @param statusId   Status ID from WorkFromHome entity
     * @param statusList List of LeaveCompensatoryStatusMaster
     * @return Status name as String
     */
    public static String getStatusNameById(long statusId, List<LeaveCompensatoryStatusMaster> statusList) {
        try {
            Optional<LeaveCompensatoryStatusMaster> statusObj = statusList.stream()
                    .filter(status -> status.getLeaveCompensatoryStatusMasterId() == statusId)
                    .findFirst();

            if (statusObj.isPresent()) {
                return statusObj.get().getLeaveCompensatoryStatus();
            } else {
                log.warn("No WFH status found for ID: " + statusId);
            }
        } catch (Exception e) {
            log.error("Error while fetching WFH status for ID: " + statusId, e);
        }

        return "Unknown";
    }
}
