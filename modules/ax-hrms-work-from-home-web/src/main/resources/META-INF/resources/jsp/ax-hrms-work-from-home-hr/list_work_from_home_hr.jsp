<%@ include file="../../init.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div class="card mt-3">
    <div class="card-header">
        <strong>Team Leave Requests</strong>
    </div>

    <div class="card-body">

        <liferay-ui:search-container
                total="${fn:length(managerLeaves)}"
                delta="10"
                emptyResultsMessage="No leave requests found">

            <liferay-ui:search-container-results results="${managerLeaves}" />

            <liferay-ui:search-container-row
                    className="com.ax.hrms.leave.management.manager.web.dto.LeaveWithEmployeeDTO"
                    modelVar="item">

                <liferay-ui:search-container-column-text
                        name="Employee Name"
                        value="${item.employee.firstName} ${item.employee.lastName}" />

                <liferay-ui:search-container-column-text
                        name="Employee Code"
                        value="${item.employee.employeeCode}" />

                <liferay-ui:search-container-column-text
                        name="Leave Type (Master ID)"
                        value="${item.leave.leaveTypeMasterId}" />

                <liferay-ui:search-container-column-text name="From Date">
                    <fmt:formatDate value="${item.leave.startDateTime}" pattern="dd-MM-yyyy" />
                </liferay-ui:search-container-column-text>

                <liferay-ui:search-container-column-text name="To Date">
                    <fmt:formatDate value="${item.leave.endDateTime}" pattern="dd-MM-yyyy" />
                </liferay-ui:search-container-column-text>

                <liferay-ui:search-container-column-text
                        name="Reason"
                        value="${item.leave.reason}" />

                <liferay-ui:search-container-column-text
                        name="Status"
                        value="${item.statusName}" />

                <!-- Action Dropdown -->
                <liferay-ui:search-container-column-text name="Action">

                    <portlet:actionURL name="/leave/approve" var="approveURL">
                        <portlet:param name="leaveId" value="${item.leave.leaveRequestId}" />
                    </portlet:actionURL>

                    <portlet:actionURL name="/leave/reject" var="rejectURL">
                        <portlet:param name="leaveId" value="${item.leave.leaveRequestId}" />
                    </portlet:actionURL>

                    <portlet:actionURL name="/leave/cancel" var="cancelURL">
                        <portlet:param name="leaveId" value="${item.leave.leaveRequestId}" />
                    </portlet:actionURL>

                    <portlet:renderURL var="viewURL">
                        <portlet:param name="mvcRenderCommandName" value="/leave/view" />
                        <portlet:param name="leaveId" value="${item.leave.leaveRequestId}" />
                    </portlet:renderURL>

                    <div class="dropdown">
                        <button class="btn fa fa-ellipsis-v dropdown-toggle" data-toggle="dropdown"></button>

                        <ul class="dropdown-menu">

                            <c:choose>
                                <!-- Pending leaves can be approved, rejected, or cancelled -->
                                <c:when test="${fn:toLowerCase(item.statusName) eq 'pending'}">
                                    <li><a href="${approveURL}" class="dropdown-item"><i class="icon-ok"></i> Approve</a></li>
                                    <li><a href="${rejectURL}" class="dropdown-item"><i class="icon-ban-circle"></i> Reject</a></li>
                                    <li><a href="${cancelURL}" class="dropdown-item"><i class="icon-remove"></i> Cancel</a></li>
                                </c:when>

                                <!-- Approved or rejected leaves can only be cancelled -->
                                <c:when test="${fn:toLowerCase(item.statusName) eq 'approved' || fn:toLowerCase(item.statusName) eq 'rejected'}">
                                    <li><a href="${cancelURL}" class="dropdown-item"><i class="icon-remove"></i> Cancel</a></li>
                                </c:when>
                            </c:choose>

                            <li><a href="${viewURL}" class="dropdown-item"><i class="icon-eye-open"></i> View</a></li>

                        </ul>
                    </div>

                </liferay-ui:search-container-column-text>

            </liferay-ui:search-container-row>

            <liferay-ui:search-iterator markupView="lexicon"/>
        </liferay-ui:search-container>

    </div>
</div>
