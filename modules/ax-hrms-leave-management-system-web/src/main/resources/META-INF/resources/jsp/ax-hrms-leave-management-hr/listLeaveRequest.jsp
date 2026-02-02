<%@ include file="../../init.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


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
          Leave Request List
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
                    <liferay-ui:search-container-row className="com.ax.hrms.leave.management.web.dto.LeaveRequestDto" modelVar="leaveRequest" keyProperty="leaveRequestId">
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
                       <liferay-ui:search-container-column-text name="Modified by"
                                                                  value="${ leaveRequest.getModifiedUser() }"></liferay-ui:search-container-column-text>


                       <liferay-ui:search-container-column-text

                           name="Status"



                           value='<span class="status ${fn:toLowerCase(fn:replace(leaveRequest.status, " ", "-"))}">${leaveRequest.status}</span>' />


                        <liferay-ui:search-container-column-text name="Action">
                            <portlet:actionURL name="/approveLeaveRequest" var="approveLeaveRequestURL">
                                <portlet:param name="leaveRequestId" value="${leaveRequest.leaveRequestId}"/>
                                <portlet:param name="comment" value="COMMENT"/>
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
                                            <li>
                                            	<button class="btn btn-success"
										        	onclick="openActionModal('${approveLeaveRequestURL}', 'APPROVE')">
										    			Approveee
												</button>
											</li>
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

<%-- <div class="modal fade" id="addCommentModal" tabindex="-1" role="dialog"
     aria-labelledby="addCommentModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="addCommentModalLabel"><liferay-ui:message
                        key="add-comment-data"/>
                </h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form action="${addCommentURL}" id="addCommentForm" method="post">
	            <div class="modal-body">
                    <div class="form-group">
                        <label for="comment"><liferay-ui:message key="comment"/></label>
                        <textarea id="comment" class="form-control"
                                  name="<portlet:namespace />comment"></textarea>
                        <label id="comment-error" class="error text-danger" for="comment"></label>
                    </div>
	            </div>
	            <div class="modal-footer d-flex justify-content-end">
	                <button type="button" class="btn btn-outline-danger btn-sm mr-1" data-dismiss="modal"><liferay-ui:message
	                        key="close"/></button>
	                <button type="button" class="btn btn-outline-success btn-sm"
	                        onclick="submit_compensatory_form()"><liferay-ui:message key="submit"/></button>
	            </div>
            </form>
        </div>
    </div>
</div> --%>

<div class="modal fade" id="actionModal" tabindex="-1">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">

            <div class="modal-header">
                <h5 class="modal-title" id="modalTitle">Action</h5>
                <button type="button" class="close" data-dismiss="modal">
                    ×
                </button>
            </div>

            <div class="modal-body">
                <textarea class="form-control"
                          id="actionComment"
                          placeholder="Enter comment"
                          rows="4"></textarea>

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

function submitAction() {

	const comment = document.getElementById('actionComment').value.trim();
    var actionURL = document.getElementById('actionURL').value.replace('COMMENT', comment);
    console.log("actionURL -- ", actionURL);

    if (!comment) {
        alert('Comment is required');
        return;
    }
    debugger;
    window.location.href = actionURL;

}
</script>
