<%@ include file="/init.jsp" %>

<portlet:renderURL var="startEmployeeOnboarding">
    <portlet:param name="mvcRenderCommandName" value="/onboardingFormHr"/>
</portlet:renderURL>

<liferay-ui:success key="off-boarded" message="off-boarded"
/>




<div class="card">
    <div class="card-header d-flex justify-content-between align-items-center">
        <strong>Employee On-Boarding HR</strong>
        <a href="${startEmployeeOnboarding}" class="btn btn-primary"><liferay-ui:message
                key="start-employee-onboarding"/></a>
    </div>
    <div class="card-body">


        <liferay-ui:search-container deltaConfigurable="${true}" total="${count}"
                                     searchContainer="${EmployeeOnBoardingHrSC}" delta="4"
                                     emptyResultsMessage="No Employees found!!, Please add one to Se it here.">
            <liferay-ui:search-container-results results="${EmployeeOnBoardingHrSC.results}"/>

            <liferay-ui:search-container-row className="com.ax.hrms.model.EmployeeDetails" modelVar="employeeDetails"
                                             keyProperty="employeeId">

                <liferay-ui:search-container-column-text name="first-name" value="${employeeDetails.firstName}"/>

                <liferay-ui:search-container-column-text name="last-name" value="${employeeDetails.lastName}"/>


                <liferay-ui:search-container-column-text name="official-email"
                                                         value="${employeeDetails.officialEmail}"/>


                <liferay-ui:search-container-column-text name="actions">
                    <c:if test="${!employeeDetails.isTerminated}">

                        <portlet:renderURL var="updateEmployeeOnboardingDetails">
                            <portlet:param name="mvcRenderCommandName" value="/viewEmployeeOnBoarding"/>
                            <portlet:param name="employeeId" value="${employeeDetails.employeeId}"/>
                        </portlet:renderURL>

                        <portlet:renderURL var="employeeOffBoardingURL">
                            <portlet:param name="mvcRenderCommandName" value="/employeeOffBoarding"/>
                            <portlet:param name="employeeId" value="${employeeDetails.employeeId}"/>
                        </portlet:renderURL>

                        <portlet:renderURL var="convertInternToEmployeeURL">
                            <portlet:param name="mvcRenderCommandName" value="/convertInternToEmployee"/>
                            <portlet:param name="employeeId" value="${employeeDetails.employeeId}"/>
                        </portlet:renderURL>

                        <!-- <a href="" class="btn btn-sm btn-outline-success mr-3"><i
                        class="fa-solid fa-eye"></i></a> -->

                        <div class="dropdown ">
                            <button class="btn fa fa-ellipsis-v dropdown-toggle"
                                    data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <i class="icon-ellipsis-vertical"></i>
                            </button>
                            <ul class="dropdown-menu">
                                <li>
                                    <a href="${employeeOffBoardingURL}"
                                       class="dropdown-item"><i class="icon-remove-circle"></i> <liferay-ui:message
                                            key="off-board"/></a>
                                </li>

                                <li>
                                    <a href="${updateEmployeeOnboardingDetails}"
                                       class="dropdown-item"><i class="icon-edit"></i> <liferay-ui:message
                                            key="update"/></a>
                                </li>
                                <c:if test="${employeeDetails.employeeType == 'intern'}">
                                    <li>
                                        <a href="${convertInternToEmployeeURL}"
                                           class="dropdown-item"><i class="icon-ok"></i> <liferay-ui:message
                                                key="mark-as-permanent"/></a>
                                    </li>
                                </c:if>
                            </ul>
                        </div>
                    </c:if>
                </liferay-ui:search-container-column-text>
            </liferay-ui:search-container-row>
            <liferay-ui:search-iterator paginate="${true}" markupView="lexicon"
                                        searchContainer="${EmployeeOnBoardingHrSC}"/>
        </liferay-ui:search-container>
    </div>
    <%--    <div class="card-footer">Footer</div>--%>
</div>
