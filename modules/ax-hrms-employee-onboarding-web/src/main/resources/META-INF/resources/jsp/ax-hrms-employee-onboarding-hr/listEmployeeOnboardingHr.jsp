<%@ include file="../../init.jsp" %>
<liferay-ui:success key="updatedSuccessfully" message="Your request has been completed successfully."/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<liferay-ui:success key="off-boarded" message="off-boarded"/>
<portlet:renderURL var="startEmployeeOnboarding">
    <portlet:param name="mvcRenderCommandName" value="/onboardingFormHr"/>
</portlet:renderURL>
<portlet:renderURL var="searchEmployeeOnboardURL">
    <portlet:param name="mvcRenderCommandName" value="/employee/search"/>
</portlet:renderURL>

<div class="card">
    <div class="card-header d-flex justify-content-between align-items-center">

        <!-- LEFT SIDE -->
        <strong class="mb-0">Employee On-Boarding HR</strong>

        <!-- RIGHT SIDE -->
        <div class="d-flex align-items-center">

            <!-- Search Section -->
            <div class="d-flex align-items-center mr-3">
                <input type="text"
                       id="searchInput"
                       class="form-control form-control-sm mr-2"
                       placeholder="Search..."
                       value="${param.searchQuery}" />

                <a href="javascript:void(0);"
                   class="btn btn-primary btn-sm mr-2"
                   onclick="redirectToSearch()">
                    <liferay-ui:message key="search" />
                </a>

                <a href="javascript:void(0);"
                   class="btn btn-outline-secondary btn-sm"
                   onclick="clearSearch()">
                    Clear
                </a>
            </div>

            <!-- Start Onboarding Button -->
            <a href="${startEmployeeOnboarding}"
               class="btn btn-primary btn-sm">
                <liferay-ui:message key="start-employee-onboarding"/>
            </a>

        </div>

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
                                                         
				<!--<liferay-ui:search-container-column-text name="employee-type"
                                                         value="${employeeDetails.employeeType}"/>-->
                <liferay-ui:search-container-column-text
                    name="employee-type"
                    value="<%= employeeDetails.getEmployeeType().substring(0,1).toUpperCase() + employeeDetails.getEmployeeType().substring(1) %>" />

                                                         
				<liferay-ui:search-container-column-text name="status"
                                                         value="${!employeeDetails.isTerminated?'Active':'Terminated'}"/>

				<portlet:renderURL var="viewEmployeeDetailsURL">
					<portlet:param name="mvcRenderCommandName" value="/showEmployeeOnboardingURL"/>
					<portlet:param name="employeeId" value="${employeeDetails.employeeId}"/>
					<portlet:param name="cmd" value="view"/>
				</portlet:renderURL>
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
                                <li>
                                    <a href="${viewEmployeeDetailsURL}"
                                       class="dropdown-item"><i class="icon-eye-open"></i> <liferay-ui:message
                                            key="view"/></a>
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
                    <c:if test="${employeeDetails.isTerminated}">
                    	<div class="dropdown ">
                            <button class="btn fa fa-ellipsis-v dropdown-toggle"
                                    data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <i class="icon-ellipsis-vertical"></i>
                            </button>
                            <ul class="dropdown-menu">
                                <li>
                                    <a href="${viewEmployeeDetailsURL}"
                                       class="dropdown-item"><i class="icon-eye-open"></i> <liferay-ui:message
                                            key="view"/></a>
                                </li>
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
<script>

function redirectToSearch() {
    var value = document.getElementById('searchInput').value;

    var url = '${searchEmployeeOnboardURL}' +
              '&<portlet:namespace/>searchQuery=' +
              encodeURIComponent(value);

    window.location.href = url;
}
function clearSearch() {
    // Get current URL without query string
    var baseUrl = window.location.origin + window.location.pathname;

    // Redirect to clean URL
    window.location.href = baseUrl;
}
</script>