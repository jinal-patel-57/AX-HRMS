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
                delta="20"
                emptyResultsMessage="No leave requests found">

            <liferay-ui:search-container-results results="${managerLeaves}" />

            <liferay-ui:search-container-row
                    className="com.ax.hrms.leave.management.web.dto.LeaveRequestDto"
                    modelVar="leaveRequest"  keyProperty="leaveRequestId">

                <liferay-ui:search-container-column-text
                        name="Employee Name"
                        value="${leaveRequest.employeeName}" />
                        <liferay-ui:search-container-column-text name="Department Name"
                                                                 value="${leaveRequest.departmentName}"/>
                        <liferay-ui:search-container-column-text name="Designation Name"
                                                                 value="${leaveRequest.designationName}"/>

                                <liferay-ui:search-container-column-text name="Start Date of Leave"
                                                                         value="${leaveRequest.startDateOfLeaveRequest}"/>

                        <liferay-ui:search-container-column-text name="End Date of Leave"
                                                                 value="${leaveRequest.endDateOfLeaveRequest}"/>
                         <liferay-ui:search-container-column-text name="Status" value="${leaveRequest.status}"/>

                <liferay-ui:search-container-column-text name="Action">

                    <portlet:actionURL name="/leave/approve" var="approveURL">
                        <portlet:param name="leaveRequestId" value="${leaveRequest.leaveRequestId}"/>
                        <portlet:param name="approvedId" value="${approvedId}"/>
                    </portlet:actionURL>

                    <portlet:actionURL name="/rejectCancelLeaveRequest" var="rejectURL">
                        <portlet:param name="leaveRequestId" value="${leaveRequest.leaveRequestId}"/>
                        <portlet:param name="rejectedId" value="${rejectedId}"/>
                    </portlet:actionURL>

                    <portlet:actionURL name="/rejectCancelLeaveRequest" var="cancelURL">
                         <portlet:param name="leaveRequestId" value="${leaveRequest.leaveRequestId}"/>
                         <portlet:param name="cancelId" value="${cancelId}"/>
                    </portlet:actionURL>

                    <portlet:renderURL var="viewURL">
                        <portlet:param name="mvcRenderCommandName" value="/leave/view" />
                        <portlet:param name="leaveRequestId" value="${leaveRequest.leaveRequestId}" />
                    </portlet:renderURL>

                    <div class="dropdown">
                        <button class="btn fa fa-ellipsis-v dropdown-toggle" data-toggle="dropdown">                                            <i class="icon-ellipsis-vertical"></i>
</button>

                        <ul class="dropdown-menu">
                           <c:choose>
                           <c:when test="${fn:toLowerCase(leaveRequest.status) eq 'pending'}">
                            <li><a href="${approveURL}" class="dropdown-item"><i class="icon-ok"></i> Approve</a></li>
                            <li><a href="${rejectURL}" class="dropdown-item"><i class="icon-ban-circle"></i> Reject</a></li>
                               <li><a href="${cancelURL}" class="dropdown-item"><i class="icon-remove"></i> Cancel</a></li>
                                                         <li><a href="${viewURL}" class="dropdown-item"><i class="icon-eye-open"></i> View</a></li>

                             </c:when>

                                     <c:when test="${fn:toLowerCase(leaveRequest.status) eq 'cancelled'}">
                                         <li>
                                             <a href="${viewURL}" class="dropdown-item">
                                                 <i class="icon-eye-open"></i> View
                                             </a>
                                         </li>
                                     </c:when>
                              <c:otherwise>
                            <li><a href="${cancelURL}" class="dropdown-item"><i class="icon-remove"></i> Cancel</a></li>
                            <li><a href="${viewURL}" class="dropdown-item"><i class="icon-eye-open"></i> View</a></li>
                            </c:otherwise>
                           </c:choose>
                        </ul>
                    </div>

                </liferay-ui:search-container-column-text>

            </liferay-ui:search-container-row>

            <liferay-ui:search-iterator markupView="lexicon"/>
        </liferay-ui:search-container>

    </div>
</div>
