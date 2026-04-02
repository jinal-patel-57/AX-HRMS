<%@ include file="/init.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


<!-- Session Message Keys Start -->
<liferay-ui:success key="leave-request-edited" message="leave-request-edited-success-message"/>
<liferay-ui:success key="leave-request-delete-success-message" message="leave-request-deleted-success-message"/>
<liferay-ui:success key="leaveRequest-canceled-message" message="leave-request-cancel-success-message"/>
<liferay-ui:success key="leave-request-inserted" message="leave-request-inserted-success-message"/>
<liferay-ui:error key="leave-request-delete-failed-message" message="leave-request-deleted-failed-message"/>
<liferay-ui:error key="something-went-wrong-message-key" message="something-went-wrong"/>
<liferay-ui:error key="leave-request-not-inserted" message="leave-request-not-inserted"/>
<liferay-ui:error key="leave-request-not-inserted-because-of-probation" message="leave-request-not-inserted-because-of-probation-message"/>
<liferay-ui:error key="leave-request-not-inserted-because-of-unauthorized" message="leave-request-not-inserted-because-of-unauthorized-message"/>
<liferay-ui:error key="leave-request-not-inserted-because-of-ovelapped" message="leave-request-not-inserted-because-of-ovelapped-message"/>
<!-- Session Message Keys End -->

<portlet:renderURL var="addLeaveRequestUrl">
    <portlet:param name="mvcRenderCommandName" value="/addLeaveRequest"/>
</portlet:renderURL>


<div class="card">
    <div class="card-header d-flex justify-content-between align-items-center">
        <strong>
            Leave Requests
        </strong>
        <a class="btn btn-primary btn-sm ${isApplicableForLeave ? '':'disabled'}" href="${addLeaveRequestUrl}"
           data-senna-off="true">
            <liferay-ui:message key="add-leave-request"/>
        </a>
    </div>
    <div class="card-body">

        <liferay-portlet:renderURL varImpl="iteratorURL"/>

        <liferay-ui:search-container total="${totalLeaveRequestOfEmployee}" delta="20"
                                     emptyResultsMessage="no-Leave-Request-found" iteratorURL="${iteratorURL}">
            <liferay-ui:search-container-results results="${ leaveRequestList}"/>

            <liferay-ui:search-container-row className="com.ax.hrms.leave.management.web.dto.LeaveRequestDto" modelVar="leaveRequest" keyProperty="leaveRequestId">


                <liferay-ui:search-container-column-text name="Leave Type"
                                                         value="${ leaveRequest.getLeaveType() }"></liferay-ui:search-container-column-text>
                <liferay-ui:search-container-column-text name="Leave Period"
                                                         value="${ leaveRequest.getLeavePeriod() }"></liferay-ui:search-container-column-text>
                <liferay-ui:search-container-column-text name="No. of days"
                                                         value="${ leaveRequest.getNoOfDays() }"></liferay-ui:search-container-column-text>
                <liferay-ui:search-container-column-text name="Modified by"
                                                         value="${ leaveRequest.getModifiedUser() }"></liferay-ui:search-container-column-text>




           <%--    <liferay-ui:search-container-column-text name="Status">
                    <c:if test="${leaveRequest.getLeaveRequestStatus() == 'Cancelled'}">
                        <p class="text-danger m-0">Cancelled</p>
                    </c:if>
                    <c:if test="${leaveRequest.getLeaveRequestStatus() != 'Cancelled'}">
                        <p class="text-secondary m-0">${leaveRequest.getLeaveRequestStatus()}</p>
                    </c:if>
                </liferay-ui:search-container-column-text>--%>

                <liferay-ui:search-container-column-text
                           name="Status"
                           value='<span class="status ${fn:toLowerCase(fn:replace(leaveRequest.getLeaveRequestStatus(), " ", "-"))}">${leaveRequest.getLeaveRequestStatus()}</span>' />


                <liferay-ui:search-container-column-text name="Action">

                    <portlet:actionURL name="/cancelLeaveRequest" var="cancelUrl">
                        <portlet:param name="leaveRequestId" value="LEAVE_REQUEST_ID"/>
                        <portlet:param name="iteratorUrl" value="${iteratorURL }"/>
                    </portlet:actionURL>
                    <portlet:renderURL var="viewLeaveRequestDetail">
                        <portlet:param name="mvcRenderCommandName" value="/viewLeaveRequestDetail"/>
                        <portlet:param name="leaveRequestId" value="${leaveRequest.leaveRequestId}"/>
                    </portlet:renderURL>


                    <div class="dropdown ">
                        <button class="btn fa fa-ellipsis-v dropdown-toggle"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <i class="icon-ellipsis-vertical"></i>
                        </button>
                        <ul class="dropdown-menu">
                            <li>
                                <a href="${viewLeaveRequestDetail }" class="dropdown-item"><i class="icon-eye-open"></i> View</a>
                            </li>
                            <c:if test="${leaveRequest.getLeaveRequestStatus() == 'Pending'}">
                               <li>
                                   <a class="dropdown-item cancel-leave-btn"
                                      data-leave-id="${leaveRequest.getLeaveRequestId()}">
                                       <i class="icon-ban-circle"></i>
                                       <liferay-ui:message key="cancel"/>
                                   </a>
                               </li>
                            </c:if>

                        </ul>
                    </div>


                </liferay-ui:search-container-column-text>
            </liferay-ui:search-container-row>

            <liferay-ui:search-iterator markupView="laxicon" paginate="true"/>
        </liferay-ui:search-container>
    </div>
</div>
<div class="modal fade" id="cancelLeaveModal" tabindex="-1"
     aria-labelledby="cancelLeaveModalLabel"
     aria-hidden="true">

    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">

            <div class="modal-header text-white">
                <h5 class="modal-title" id="cancelLeaveModalLabel">
                    <i class="icon-warning-sign"></i>
                    Confirm Cancel
                </h5>

                <button type="button" class="close" data-dismiss="modal">
                    <span>&times;</span>
                </button>
            </div>

            <div class="modal-body text-center">
                <p class="mb-2">
                    <strong>This action cannot be undone.</strong>
                </p>
                <p>
                    Are you sure you want to cancel this Leave request?
                </p>
            </div>

            <div class="modal-footer justify-content-center">
                <button type="button"
                        class="btn btn-outline-secondary btn-sm"
                        data-dismiss="modal">
                    Cancel
                </button>

                <button type="button"
                        id="confirmCancelLeaveBtn"
                        class="btn btn-danger btn-sm">
                    Confirm
                </button>
            </div>

        </div>
    </div>
</div>


<script>

    function cancelAction(leaveRequestId) {
        var config = new Object({}),
            namespace = '<portlet:namespace />';

        config.namespace = namespace;
        config.cancelUrl = '${cancelUrl}';
        config.leaveRequestId = leaveRequestId;

        AxEmployeeLeaveManagement.setConfigsForCancelLeaveRequest(config);
    }
</script>

<script>

document.addEventListener("DOMContentLoaded", function () {

    let leaveRequestId = null;

    document.querySelectorAll(".cancel-leave-btn").forEach(function (btn) {

        btn.addEventListener("click", function () {

            leaveRequestId = this.getAttribute("data-leave-id");

            const modalElement = document.getElementById("cancelLeaveModal");

            if (modalElement) {
                const modalInstance = new bootstrap.Modal(modalElement);
                modalInstance.show();
            }
        });
    });

    const confirmCancelBtn = document.getElementById("confirmCancelLeaveBtn");

    if (confirmCancelBtn) {

        confirmCancelBtn.addEventListener("click", function () {

            if (leaveRequestId) {
                cancelAction(leaveRequestId);
            }

        });

    }

});

</script>