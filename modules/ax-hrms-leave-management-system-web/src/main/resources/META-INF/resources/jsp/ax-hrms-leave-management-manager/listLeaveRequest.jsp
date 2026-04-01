<%@ include file="../../init.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<portlet:renderURL var="fetchLeaves">
    <portlet:param name="mvcRenderCommandName" value="/"/>
</portlet:renderURL>

<div class="card mt-3">
    <div class="card-header d-flex justify-content-between align-items-center">
        <strong>Leave Requests</strong>
        <form class="form-inline" action="${fetchLeaves}" method="post">
            <select data-live-search="true" class="form-control mr-2 custom-select" id="employeeSelect" name="<portlet:namespace/>employeeId">
                <option value="">Select Employee</option>
                <c:forEach var="employee" items="${employeeList}">
                    <option value="${employee.employeeId}" ${employeeId == employee.employeeId ? 'selected' : ''} >${employee.firstName} ${employee.lastName}</option>
                </c:forEach>
            </select>
            <button type="submit" class="btn btn-primary">Fetch</button>
        </form>
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
                        <liferay-ui:search-container-column-text name="Leave Type Name"
                                                                 value="${leaveRequest.leaveType}"/>
                                <liferay-ui:search-container-column-text name="Start Date of Leave"
                                                                         value="${leaveRequest.startDateOfLeaveRequest}"/>

                        <liferay-ui:search-container-column-text name="End Date of Leave"
                                                                 value="${leaveRequest.endDateOfLeaveRequest}"/>
                                       <liferay-ui:search-container-column-text name="Date of Request Leave"
                                                                                value="${leaveRequest.dateOfRequestedLeave}"/>
                 <liferay-ui:search-container-column-text name="No. of days"
                                                                         value="${ leaveRequest.totalNoOfDays }"></liferay-ui:search-container-column-text>
               <liferay-ui:search-container-column-text name="Modified by"
                                                                      value="${ leaveRequest.getModifiedUser() }"></liferay-ui:search-container-column-text>


                     <%--    <liferay-ui:search-container-column-text name="Status" value="${leaveRequest.status}"/> --%>

                       <liferay-ui:search-container-column-text
                           name="Status"
                           value='<span class="status ${fn:toLowerCase(fn:replace(leaveRequest.status, " ", "-"))}">${leaveRequest.status}</span>' />

<c:set var="isSameEmployee"
       value="${currentEmployeeId == leaveRequest.employeeId}" />

                <liferay-ui:search-container-column-text name="Action">

                    <portlet:actionURL name="/leave/approve" var="approveURL">
                        <portlet:param name="leaveRequestId" value="${leaveRequest.leaveRequestId}"/>
                        <portlet:param name="comment" value="COMMENT"/>
                        <portlet:param name="employeeId" value="${employeeId}"/>
                        <portlet:param name="approvedId" value="${approvedId}"/>
                    </portlet:actionURL>

                    <portlet:actionURL name="/rejectCancelLeaveRequest" var="rejectURL">
                        <portlet:param name="leaveRequestId" value="${leaveRequest.leaveRequestId}"/>
                        <portlet:param name="comment" value="COMMENT"/>
                        <portlet:param name="employeeId" value="${employeeId}"/>
                        <portlet:param name="rejectedId" value="${rejectedId}"/>
                    </portlet:actionURL>

                    <portlet:actionURL name="/rejectCancelLeaveRequest" var="cancelURL">
                         <portlet:param name="leaveRequestId" value="${leaveRequest.leaveRequestId}"/>
                         <portlet:param name="comment" value="COMMENT"/>
                         <portlet:param name="employeeId" value="${employeeId}"/>
                         <portlet:param name="cancelId" value="${cancelId}"/>
                    </portlet:actionURL>

                    <portlet:renderURL var="viewURL">
                        <portlet:param name="mvcRenderCommandName" value="/leave/view" />
                        <portlet:param name="employeeId" value="${employeeId}"/>
                        <portlet:param name="leaveRequestId" value="${leaveRequest.leaveRequestId}" />
                    </portlet:renderURL>

                    <div class="dropdown">
                        <button class="btn fa fa-ellipsis-v dropdown-toggle" data-toggle="dropdown">                                            <i class="icon-ellipsis-vertical"></i>
</button>

                       <ul class="dropdown-menu">
                           <c:choose>


                               <c:when test="${fn:toLowerCase(leaveRequest.status) eq 'pending'}">

                                   <c:if test="${!isSameEmployee}">
                                       <li>
                                           <a href="javascript:void(0);"
                                              class="dropdown-item"
                                              onclick="openActionModal('${approveURL}', 'APPROVE')">
                                               <i class="icon-ok"></i> Approve
                                           </a>
                                       </li>

                                       <li>
                                           <a href="javascript:void(0);"
                                              class="dropdown-item"
                                              onclick="openActionModal('${rejectURL}', 'REJECT')">
                                               <i class="icon-ban-circle"></i> Reject
                                           </a>
                                       </li>

                                       <li>
                                           <a href="javascript:void(0);"
                                              class="dropdown-item"
                                              onclick="openActionModal('${cancelURL}', 'CANCEL')">
                                               <i class="icon-remove"></i> Cancel
                                           </a>
                                       </li>
                                   </c:if>

                                   <li>
                                       <a href="${viewURL}" class="dropdown-item">
                                           <i class="icon-eye-open"></i> View
                                       </a>
                                   </li>

                               </c:when>

                               <c:when test="${fn:toLowerCase(leaveRequest.status) eq 'cancelled'}">
                                   <li>
                                       <a href="${viewURL}" class="dropdown-item">
                                           <i class="icon-eye-open"></i> View
                                       </a>
                                   </li>
                               </c:when>

                               <c:otherwise>

                                   <!-- CANCEL ONLY IF NOT SAME EMPLOYEE -->
                                   <c:if test="${!isSameEmployee}">
                                       <li>
                                           <a href="javascript:void(0);"
                                              class="dropdown-item"
                                              onclick="openActionModal('${cancelURL}', 'CANCEL')">
                                               <i class="icon-remove"></i> Cancel
                                           </a>
                                       </li>
                                   </c:if>

                                   <li>
                                       <a href="${viewURL}" class="dropdown-item">
                                           <i class="icon-eye-open"></i> View
                                       </a>
                                   </li>

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




<div class="modal fade" id="actionModal" tabindex="-1">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">

            <div class="modal-header">
                <h5 class="modal-title" id="modalTitle">Action</h5>
                <button type="button" class="close" data-dismiss="modal">
                      <i class="icon-remove"></i>
                </button>
            </div>

            <div class="modal-body">
                                    <label for="comment">
                                        <liferay-ui:message key="Comment"/>
                                       <span class="text-danger">*</span>
                                    </label>
                <textarea class="form-control"
                          id="actionComment"
                          placeholder="Enter comment"
                          rows="4"></textarea>
            <small id="actionCommentError"
                   class="text-danger d-none">
                Comment is required.
            </small>
                <input type="hidden" id="requestId">
                <input type="hidden" id="actionURL">
                <input type="hidden" id="actionType">
            </div>

            <div class="modal-footer">
                <button class="btn btn-secondary"
                        data-dismiss="modal">
                    Close
                </button>

                <button class="btn btn-primary"
                        onclick="submitAction()">
                    Submit
                </button>
            </div>

        </div>
    </div>
</div>



<script type="text/javascript">
    function openActionModal(actionURL, action) {

    	document.getElementById('actionURL').value = actionURL;
        document.getElementById('actionComment').value = '';

        document.getElementById('modalTitle').innerText =
            action.charAt(0) + action.slice(1).toLowerCase() + " Request";

        $('#actionModal').modal('show');
    }

    document.getElementById('actionComment')
        .addEventListener('input', function () {

            this.classList.remove('is-invalid');
            document.getElementById('actionCommentError')
                .classList.add('d-none');
    });

    function submitAction() {
     const commentField = document.getElementById('actionComment');
        const errorField = document.getElementById('actionCommentError');

        const comment = commentField.value.trim();
        if (comment === '') {
            commentField.classList.add('is-invalid');
            errorField.classList.remove('d-none');
            commentField.focus();
            return;
        } else {
            commentField.classList.remove('is-invalid');
            errorField.classList.add('d-none');
        }
       // const comment = document.getElementById('actionComment').value.trim();
        var actionURL = document.getElementById('actionURL').value.replace('COMMENT', comment);
        console.log("actionURL -- ", actionURL);

        window.location.href = actionURL;

    }
</script>