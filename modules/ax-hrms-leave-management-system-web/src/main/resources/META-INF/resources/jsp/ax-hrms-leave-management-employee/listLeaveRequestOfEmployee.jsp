<%@ include file="/init.jsp" %>


<!-- Session Message Keys Start -->
<liferay-ui:success key="leave-request-edited" message="leave-request-edited-success-message"/>
<liferay-ui:success key="leave-request-delete-success-message" message="leave-request-deleted-success-message"/>
<liferay-ui:success key="leaveRequest-canceled-message" message="leave-request-cancel-success-message"/>
<liferay-ui:success key="leave-request-inserted" message="leave-request-inserted-success-message"/>
<liferay-ui:error key="leave-request-delete-failed-message" message="leave-request-deleted-failed-message"/>
<liferay-ui:error key="something-went-wrong-message-key" message="something-went-wrong"/>
<liferay-ui:error key="leave-request-not-inserted" message="leave-request-not-inserted"/>
<!-- Session Message Keys End -->

<portlet:renderURL var="addLeaveRequestUrl">
    <portlet:param name="mvcRenderCommandName" value="/addLeaveRequest"/>
</portlet:renderURL>


<div class="card">
    <div class="card-header d-flex justify-content-between align-items-center">
        <strong>
            Leave Request List
        </strong>
        <a class="btn btn-primary btn-sm ${isApplicableForLeave ? '':'disabled'}" href="${addLeaveRequestUrl}"
           data-senna-off="true">
            <liferay-ui:message key="add-leave-request"/>
        </a>
    </div>
    <div class="card-body">

        <liferay-portlet:renderURL varImpl="iteratorURL"/>

        <liferay-ui:search-container total="${totalLeaveRequestOfEmployee}" delta="3"
                                     emptyResultsMessage="no-Leave-Request-found" iteratorURL="${iteratorURL}">
            <liferay-ui:search-container-results results="${ leaveRequestList}"/>

            <liferay-ui:search-container-row className="com.ax.hrms.leave.management.web.dto.LeaveRequestDto" modelVar="leaveRequest" keyProperty="leaveRequestId">

                <liferay-ui:search-container-column-text name="Employee Name"
                                                         value="${ leaveRequest.getEmployeeName() }"></liferay-ui:search-container-column-text>
                <liferay-ui:search-container-column-text name="Leave Type"
                                                         value="${ leaveRequest.getLeaveType() }"></liferay-ui:search-container-column-text>
                <liferay-ui:search-container-column-text name="Leave Period"
                                                         value="${ leaveRequest.getLeavePeriod() }"></liferay-ui:search-container-column-text>
                <liferay-ui:search-container-column-text name="No of days"
                                                         value="${ leaveRequest.getNoOfDays() }"></liferay-ui:search-container-column-text>
                <liferay-ui:search-container-column-text name="No of Hours"
                                                         value="${ leaveRequest.getNoOfHours() }"></liferay-ui:search-container-column-text>
                <liferay-ui:search-container-column-text name="Status">
                    <c:if test="${leaveRequest.getLeaveRequestStatus() == 'Cancelled'}">
                        <p class="text-danger">Cancelled</p>
                    </c:if>
                    <c:if test="${leaveRequest.getLeaveRequestStatus() != 'Cancelled'}">
                        <p class="text-secondary">${leaveRequest.getLeaveRequestStatus()}</p>
                    </c:if>
                </liferay-ui:search-container-column-text>
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
                            <c:if test="${leaveRequest.getLeaveRequestStatus() == 'Pending'}">
                                <li>
                                    <a class="dropdown-item"
                                       onclick="cancelAction(${leaveRequest.getLeaveRequestId()})"><i
                                            class="icon-ban-circle"></i> <liferay-ui:message
                                            key="cancel"/></a>
                                </li>
                            </c:if>
                            <li>
                                <a href="${viewLeaveRequestDetail }" class="dropdown-item"><i class="icon-eye-open"></i> View</a>
                            </li>
                        </ul>
                    </div>


                </liferay-ui:search-container-column-text>
            </liferay-ui:search-container-row>

            <liferay-ui:search-iterator markupView="laxicon" paginate="true"/>
        </liferay-ui:search-container>
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