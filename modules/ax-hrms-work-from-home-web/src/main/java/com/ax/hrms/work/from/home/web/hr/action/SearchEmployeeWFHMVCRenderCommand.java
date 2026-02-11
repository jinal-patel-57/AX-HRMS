package com.ax.hrms.work.from.home.web.hr.action;

import com.ax.hrms.exception.NoSuchEmployeeDetailsException;
import com.ax.hrms.master.model.LeaveCompensatoryStatusMaster;
import com.ax.hrms.master.service.LeaveCompensatoryStatusMasterLocalService;
import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.model.WorkFromHomeRequest;
import com.ax.hrms.model.WorkFromHomeRequestTable;
import com.ax.hrms.service.EmployeeDetailsLocalService;
import com.ax.hrms.service.WorkFromHomeRequestLocalService;
import com.ax.hrms.work.from.home.web.constants.AxHrmsWorkFromHomePortletKeys;
import com.ax.hrms.work.from.home.web.employee.util.WFHStatusUtil;
import com.ax.hrms.work.from.home.web.hr.dto.WFHRequestDto;

import com.liferay.petra.sql.dsl.DSLQueryFactoryUtil;
import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletURLUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.ArrayList;
import java.util.List;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + AxHrmsWorkFromHomePortletKeys.AXHRMSWORKFROMHOMEHR,
                "mvc.command.name=/wfh/search"
        },
        service = MVCRenderCommand.class
)
public class SearchEmployeeWFHMVCRenderCommand implements MVCRenderCommand {

    private static final Log log =
            LogFactoryUtil.getLog(SearchEmployeeWFHMVCRenderCommand.class);

    @Reference
    private EmployeeDetailsLocalService employeeDetailsLocalService;

    @Reference
    private WorkFromHomeRequestLocalService workFromHomeRequestLocalService;

    @Reference
    private LeaveCompensatoryStatusMasterLocalService leaveStatusLocalService;

    @Override
    public String render(RenderRequest renderRequest,
                         RenderResponse renderResponse) throws PortletException {

        log.info(" SearchEmployeeWFHMVCRenderCommand CALLED");

        String keyword = ParamUtil.getString(renderRequest, "searchQuery", "");
        renderRequest.setAttribute("searchedValue", keyword);

        PortletURL iteratorURL =
                PortletURLUtil.getCurrent(renderRequest, renderResponse);

        SearchContainer<WFHRequestDto> searchContainer =
                new SearchContainer<>(renderRequest, iteratorURL, null, "no-wfh-request-found");

        int cur = ParamUtil.getInteger(renderRequest,
                SearchContainer.DEFAULT_CUR_PARAM, 1);

        int delta = ParamUtil.getInteger(renderRequest,
                SearchContainer.DEFAULT_DELTA_PARAM, 20);

        int start = (cur - 1) * delta;
        int end = start + delta;

        int totalWFHRequests = 0;
        List<WorkFromHomeRequest> wfhRequests = new ArrayList<>();

        try {

            WorkFromHomeRequestTable wfhTable =
                    WorkFromHomeRequestTable.INSTANCE;

            if (Validator.isNotNull(keyword)) {

                keyword = keyword.trim().toLowerCase();

                List<Long> employeeIds =
                        employeeDetailsLocalService.getEmployeeIdByNameString(
                                "%" + keyword + "%");

                if (!employeeIds.isEmpty()) {

                    Long[] employeeIdArray =
                            employeeIds.toArray(new Long[0]);

                    // -------- COUNT QUERY --------
                    DSLQuery countQuery =
                            DSLQueryFactoryUtil
                                    .count()
                                    .from(wfhTable)
                                    .where(wfhTable.employeeId.in(employeeIdArray));

                    totalWFHRequests =
                            (int) workFromHomeRequestLocalService.dslQueryCount(countQuery);

                    // Pagination safety
                    if (start >= totalWFHRequests) {
                        start = 0;
                        end = delta;
                    }

                    end = Math.min(totalWFHRequests, end);

                    // -------- FETCH QUERY --------
                    DSLQuery fetchQuery =
                            DSLQueryFactoryUtil
                                    .select(wfhTable)
                                    .from(wfhTable)
                                    .where(wfhTable.employeeId.in(employeeIdArray))
                                    .orderBy(
                                            wfhTable.createDate.descending()  // or descending()
                                    )
                                    .limit(start, end);

                    wfhRequests =
                            workFromHomeRequestLocalService.dslQuery(fetchQuery);
                }

            } else {


                totalWFHRequests =
                        workFromHomeRequestLocalService.getWorkFromHomeRequestsCount();

                if (start >= totalWFHRequests) {
                    start = 0;
                    end = delta;
                }

                end = Math.min(totalWFHRequests, end);

                wfhRequests =
                        workFromHomeRequestLocalService.getWorkFromHomeRequests(start, end);
            }

            List<LeaveCompensatoryStatusMaster> statusList =
                    leaveStatusLocalService.getLeaveCompensatoryStatusMasters(-1, -1);

            List<WFHRequestDto> dtoList = new ArrayList<>();

            for (WorkFromHomeRequest wfh : wfhRequests) {

                WFHRequestDto dto = new WFHRequestDto();

                dto.setWorkFromHomeRequestId(wfh.getWorkFromHomeRequestId());
                dto.setEmployeeId(wfh.getEmployeeId());
                dto.setStartDate(wfh.getStartDate());
                dto.setEndDate(wfh.getEndDate());
                dto.setReason(wfh.getReason());
                dto.setRequestDate(wfh.getCreateDate());
                dto.setStatus(
                        WFHStatusUtil.getStatusNameById(wfh.getStatus(), statusList)
                );

                try {
                    EmployeeDetails emp =
                            employeeDetailsLocalService.fetchEmployeeDetails(
                                    wfh.getEmployeeId());

                    if (emp != null) {
                        dto.setEmployeeName(
                                emp.getFirstName() + " " + emp.getLastName());
                    }

                    EmployeeDetails modifiedBy =
                            employeeDetailsLocalService.findByLrUserId(
                                    wfh.getModifiedBy());

                    if (modifiedBy != null) {
                        dto.setModifiedBy(
                                modifiedBy.getFirstName() + " " +
                                        modifiedBy.getLastName());
                    }

                } catch (NoSuchEmployeeDetailsException e) {
                    log.warn("Employee not found: " + e.getMessage());
                } catch (Exception e) {
                    log.error("Error mapping DTO", e);
                }

                dtoList.add(dto);
            }

            searchContainer.setDelta(delta);
            searchContainer.setDeltaConfigurable(true);
            searchContainer.setResultsAndTotal(
                    () -> dtoList,
                    totalWFHRequests
            );

            renderRequest.setAttribute("wfhSC", searchContainer);
            renderRequest.setAttribute("totalWFHRequest", totalWFHRequests);
            renderRequest.setAttribute("delta", delta);

            log.info(" Total Records: " + totalWFHRequests);

        } catch (Exception e) {
            log.error("Error while searching WFH requests", e);
        }

        return "/jsp/ax-hrms-work-from-home-hr/list_work_from_home_hr.jsp";
    }
}
