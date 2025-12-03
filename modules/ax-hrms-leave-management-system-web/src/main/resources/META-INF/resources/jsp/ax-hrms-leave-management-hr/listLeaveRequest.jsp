<%@ include file="/init.jsp" %>

<!-- Different URL Start -->

<%--Different URL End Here--%>

<%--SESSION_MESSAGES Start Here--%>

<liferay-ui:success key="leave-request-approved" message="leave-request-approved-message"></liferay-ui:success>
<liferay-ui:success key="leave-request-rejected" message="leave-request-rejected-message"></liferay-ui:success>
<liferay-ui:success key="leave-request-cancelled" message="leave-request-cancelled-message"></liferay-ui:success>
<liferay-ui:error key="some-error-found" message="some-error-found-message"/>

<div class="card">
    <div class="card-header">
        <strong>
            List Leave Requests
        </strong>
    </div>
    <div class="card-body">

        <div class="row">
            <div class="col">
                <liferay-portlet:renderURL varImpl="iteratorURL"/>
                <liferay-ui:search-container total="${totalLeaveRequest }" delta="${delta}"
                                             emptyResultsMessage="no-Leave-request-found-error-message"
                                             iteratorURL="${iteratorURL}">
                    <liferay-ui:search-container-results results="${leaveRequestList }"/>
                    <liferay-ui:search-container-row
                            className="package com.ax.hrms.leave.management.web.dto.LeaveRequestDto;"
                            modelVar="leaveRequest" keyProperty="leaveRequestId">
                        <liferay-ui:search-container-column-text name="Employee Name"
                                                                 value="${leaveRequest.employeeName}"/>
                        <liferay-ui:search-container-column-text name="Department Name"
                                                                 value="${leaveRequest.departmentName}"/>
                        <liferay-ui:search-container-column-text name="Designation Name"
                                                                 value="${leaveRequest.designationName}"/>
                        <liferay-ui:search-container-column-text name="Leave Type Name"
                                                                 value="${leaveRequest.leaveType}"/>
                        <liferay-ui:search-container-column-text name="Start Date of Leave"
                                                                 value="${leaveRequest.startDateOfLeaveRequest}"/>
                        <liferay-ui:search-container-column-text name="End Date of Leave"
                                                                 value="${leaveRequest.endDateOfLeaveRequest}"/>
                        <liferay-ui:search-container-column-text name="Date of Request Leave"
                                                                 value="${leaveRequest.dateOfRequestedLeave}"/>
                        <liferay-ui:search-container-column-text name="Status" value="${leaveRequest.status}"/>

                        <liferay-ui:search-container-column-text name="Action">
                            <portlet:actionURL name="/approveLeaveRequest" var="approveLeaveRequestURL">
                                <portlet:param name="leaveRequestId" value="${leaveRequest.leaveRequestId}"/>
                                <portlet:param name="approvedId" value="${approvedId}"/>
                            </portlet:actionURL>

                            <portlet:actionURL name="/rejectCancelLeaveRequest" var="rejectLeaveRequestURL">
                                <portlet:param name="leaveRequestId" value="${leaveRequest.leaveRequestId}"/>
                                <portlet:param name="rejectedId" value="${rejectedId}"/>
                            </portlet:actionURL>

                            <portlet:actionURL name="/rejectCancelLeaveRequest" var="cancelLeaveRequestURL">
                                <portlet:param name="leaveRequestId" value="${leaveRequest.leaveRequestId}"/>
                                <portlet:param name="cancelId" value="${cancelId}"/>
                            </portlet:actionURL>

                            <portlet:renderURL var="viewLeaveRequestURL">
                                <portlet:param name="mvcRenderCommandName" value="/viewLeaveRequest"/>
                                <portlet:param name="leaveRequestId" value="${leaveRequest.leaveRequestId}"/>
                            </portlet:renderURL>

                            <c:choose>
                                <c:when test="${leaveRequest.status.toLowerCase() eq 'pending'}">


                                    <div class="dropdown ">
                                        <button class="btn fa fa-ellipsis-v dropdown-toggle"
                                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                            <i class="icon-ellipsis-vertical"></i>
                                        </button>
                                        <ul class="dropdown-menu">
                                            <li><a href="${approveLeaveRequestURL}"
                                                   class="dropdown-item"><i class="icon-ok"></i> <liferay-ui:message
                                                    key="approve"/></a>
                                            </li>
                                            <li>

                                                <a href="${rejectLeaveRequestURL}"
                                                   class="dropdown-item"><i class="icon-ban-circle"></i> <liferay-ui:message
                                                        key="reject"/></a>
                                            </li>
                                            <li>
                                                <a href="${cancelLeaveRequestURL}"
                                                   class="dropdown-item"><i class="icon-remove"></i> <liferay-ui:message
                                                        key="cancel"/></a>
                                            </li>
                                            <li>
                                                <a href="${viewLeaveRequestURL}"
                                                   class="dropdown-item"><i class="icon-eye-open"></i> <liferay-ui:message
                                                        key="view"/></a>
                                            </li>
                                        </ul>
                                    </div>

                                </c:when>
                                <c:when test="${leaveRequest.status.toLowerCase() eq 'approved' || leaveRequest.status.toLowerCase() eq 'rejected'}">


                                    <div class="dropdown ">
                                        <button class="btn fa fa-ellipsis-v dropdown-toggle"
                                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                            <i class="icon-ellipsis-vertical"></i>
                                        </button>
                                        <ul class="dropdown-menu">
                                            <li>
                                                <a href="${viewLeaveRequestURL}"
                                                   class="dropdown-item"><i class="icon-eye-open"></i> <liferay-ui:message
                                                        key="view"/></a>
                                            </li>
                                            <li>
                                                <a href="${cancelLeaveRequestURL}"
                                                   class="dropdown-item"><i class="icon-remove"></i> <liferay-ui:message
                                                        key="cancel"/></a>
                                            </li>
                                        </ul>
                                    </div>
                                </c:when>
                                <c:when test="${leaveRequest.status.toLowerCase() eq 'cancelled'}">
                                    <div class="dropdown ">
                                        <button class="btn fa fa-ellipsis-v dropdown-toggle"
                                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                            <i class="icon-ellipsis-vertical"></i>
                                        </button>
                                        <ul class="dropdown-menu">
                                            <li>
                                                <a href="${viewLeaveRequestURL}" class="dropdown-item"><i class="icon-eye-open"></i> <liferay-ui:message
                                                        key="view"/></a>
                                            </li>
                                        </ul>
                                    </div>
                                </c:when>
                            </c:choose>
                        </liferay-ui:search-container-column-text>
                    </liferay-ui:search-container-row>
                    <liferay-ui:search-iterator markupView="lexicon"/>
                </liferay-ui:search-container>

            </div>
        </div>
    </div>
</div>
