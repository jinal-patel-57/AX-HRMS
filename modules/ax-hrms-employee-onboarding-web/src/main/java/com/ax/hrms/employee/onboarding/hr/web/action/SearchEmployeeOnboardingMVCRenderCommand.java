package com.ax.hrms.employee.onboarding.hr.web.action;

import com.ax.hrms.employee.onboarding.web.constants.AxHrmsEmployeeOnboardingHrWebPortletConstants;
import com.ax.hrms.employee.onboarding.web.constants.AxHrmsEmployeeOnboardingWebPortletKeys;
import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.model.EmployeeDetailsTable;
import com.ax.hrms.service.EmployeeDetailsLocalService;

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
                "javax.portlet.name=" + AxHrmsEmployeeOnboardingWebPortletKeys.AX_HRMS_EMPLOYEE_ONBOARDING_HR_WEB,
                "mvc.command.name=/employee/search"
        },
        service = MVCRenderCommand.class
)
public class SearchEmployeeOnboardingMVCRenderCommand implements MVCRenderCommand {

    private static final Log log =
            LogFactoryUtil.getLog(SearchEmployeeOnboardingMVCRenderCommand.class);

    @Reference
    private EmployeeDetailsLocalService employeeDetailsLocalService;

    @Override
    public String render(RenderRequest renderRequest,
                         RenderResponse renderResponse) throws PortletException {

        log.info("Employee Search Called");

        String keyword = ParamUtil.getString(renderRequest, "searchQuery", "");
        renderRequest.setAttribute("searchedValue", keyword);

        PortletURL iteratorURL =
                PortletURLUtil.getCurrent(renderRequest, renderResponse);

        SearchContainer<EmployeeDetails> searchContainer =
                new SearchContainer<>(renderRequest, iteratorURL, null, "no-record-found");

        int cur = ParamUtil.getInteger(renderRequest,
                SearchContainer.DEFAULT_CUR_PARAM, 1);

        int delta = ParamUtil.getInteger(renderRequest,
                SearchContainer.DEFAULT_DELTA_PARAM, 20);

        int start = (cur - 1) * delta;
        int end = start + delta;

        int totalEmployees = 0;
        List<EmployeeDetails> employeeList = new ArrayList<>();

        try {

            EmployeeDetailsTable employeeTable =
                    EmployeeDetailsTable.INSTANCE;

            if (Validator.isNotNull(keyword)) {

                keyword = keyword.trim().toLowerCase();

                List<Long> employeeIds =
                        employeeDetailsLocalService
                                .getEmployeeIdByNameString("%" + keyword + "%");

                if (!employeeIds.isEmpty()) {

                    Long[] employeeIdArray =
                            employeeIds.toArray(new Long[0]);

                    // -------- COUNT QUERY --------
                    com.liferay.petra.sql.dsl.query.DSLQuery countQuery =
                            DSLQueryFactoryUtil
                                    .count()
                                    .from(employeeTable)
                                    .where(employeeTable.employeeId.in(employeeIdArray));

                    totalEmployees =
                            (int) employeeDetailsLocalService
                                    .dslQueryCount(countQuery);

                    if (start >= totalEmployees) {
                        start = 0;
                        end = delta;
                    }

                    end = Math.min(totalEmployees, end);

                    // -------- FETCH QUERY --------
                    com.liferay.petra.sql.dsl.query.DSLQuery fetchQuery =
                            DSLQueryFactoryUtil
                                    .select(employeeTable)
                                    .from(employeeTable)
                                    .where(employeeTable.employeeId.in(employeeIdArray))
                                    .orderBy(
                                            employeeTable.createDate.descending()
                                    )
                                    .limit(start, end);

                    employeeList =
                            employeeDetailsLocalService.dslQuery(fetchQuery);
                }

            } else {

                totalEmployees =
                        employeeDetailsLocalService.getEmployeeDetailsesCount();

                if (start >= totalEmployees) {
                    start = 0;
                    end = delta;
                }

                end = Math.min(totalEmployees, end);

                employeeList =
                        employeeDetailsLocalService
                                .getEmployeeDetailses(start, end);
            }


            final int finalTotal = totalEmployees;
            final List<EmployeeDetails> finalList = employeeList;

            searchContainer.setDelta(delta);
            searchContainer.setDeltaConfigurable(true);
            searchContainer.setResultsAndTotal(
                    () -> finalList,
                    finalTotal
            );

            renderRequest.setAttribute(
                    AxHrmsEmployeeOnboardingHrWebPortletConstants.EMPLOYEE_ON_BOARDING_HR_SC,
                    searchContainer
            );

            renderRequest.setAttribute(
                    AxHrmsEmployeeOnboardingHrWebPortletConstants.COUNT,
                    finalTotal
            );

            log.info("Total Employees Found: " + finalTotal);

        } catch (Exception e) {
            log.error("Error while searching employees", e);
        }

        return AxHrmsEmployeeOnboardingHrWebPortletConstants
                .EMPLOYEE_ON_BOARDING_HR_LIST_JSP;
    }
}
