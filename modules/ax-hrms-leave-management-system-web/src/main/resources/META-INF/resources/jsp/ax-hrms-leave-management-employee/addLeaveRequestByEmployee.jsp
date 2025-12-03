<%@ include file="/init.jsp" %>

<%--SESSION_MESSAGES Start Here--%>
<liferay-ui:error key="leave-request-already-exists" message="leave-request-already-exists-message"/>
<liferay-ui:error key="something-went-wrong-message-key" message="something-went-wrong"/>
<%--SESSION_MESSAGES End Here--%>

<!-- Different URL Start -->
<portlet:renderURL var="homeUrl"/>
<portlet:actionURL name="/addLeaveRequest" var="addLeaveRequestUrl"/>
<liferay-portlet:resourceURL var="getFloaters">
    <portlet:param name="mvcRenderCommandName" value="/viewFloaterDays"/>
</liferay-portlet:resourceURL>
<liferay-portlet:resourceURL var="getEmployeeLeavesDataURL">
    <portlet:param name="mvcRenderCommandName" value="/viewEmployeeLeavesDetail"/>
</liferay-portlet:resourceURL>
<!-- Different URL End -->


<div class="card">
    <div class="card-header">
        <strong>
            Employee Leave Request
        </strong>
    </div>

    <c:catch>
        <form method="Post" action="${addLeaveRequestUrl }" id="<portlet:namespace/>leaveRequestForm">
            <div class="card-body">
                <div class="row">

                    <input type="hidden" value="${leaveTypeMasterList.get(0).getEmployeeId()}"
                           id="<portlet:namespace />employeeId"
                           name="<portlet:namespace />employeeId"/>
                    <c:if test="${isHrStatus}">
                        <div class="col-sm-12 col-md-4 col-lg-4">
                            <div class="form-group">
                                <input type="hidden" id="<portlet:namespace />hrStatus"
                                       name="<portlet:namespace />hrStatus"
                                       value="${isHrStatus}" style="display:none;"/>
                                <liferay-ui:message key="employee-detail"/><span class="text-danger">*</span>
                                <select id="<portlet:namespace />employeeNames"
                                        name="<portlet:namespace />employeeNames"
                                        class="custom-select mr-sm-2">
                                    <option value="">-- Select Employee --</option>
                                    <c:forEach var="employeeDetailsList" items="${employeeDetailsList}">
                                        <option value="${employeeDetailsList.getEmployeeId()}">${employeeDetailsList.firstName} ${employeeDetailsList.lastName}
                                            (${employeeDetailsList.employeeCode})
                                        </option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>

                    </c:if>
                    <div class="col-sm-12 col-md-4 col-lg-4">
                        <div class="form-group" id="leaveTypeContainer">
                            <liferay-ui:message key="leave-type"/><span class="text-danger">*</span>
                            <select id="<portlet:namespace />leaveType" name="<portlet:namespace />leaveType"
                                    class="custom-select mr-sm-2">
                                <option value="">-- <liferay-ui:message key="select-leave-type"/> --</option>
                                <c:forEach var="leaveTypeList" items="${leaveTypeMasterList}">
                                    <option value="${leaveTypeList.leaveTypeId}"
                                            data-remaining-leaves="${leaveTypeList.noOfRemainingLeaves}"
                                            data-is-continuous="${leaveTypeList.getIsContinuous()}"
                                            data-is-applicable-floater="${leaveTypeList.isApplicableFloater()}"/>
                                    ${leaveTypeList.leaveType}
                                    </option>
                                </c:forEach>
                            </select>
                            <div><p class="text-primary" id="remainingLeavesPar"></p></div>
                        </div>
                    </div>

                    <div class="col-sm-12 col-md-4 col-lg-4" id="startDateContainer">
                        <div class="form-group">
                            <liferay-ui:message key="start-date"/><span class="text-danger">*</span>
                            <input type="date" id="<portlet:namespace />startDate" name="<portlet:namespace />startDate"
                                   class="form-control"/>
                        </div>
                    </div>
                    <div class="col-sm-12 col-md-4 col-lg-4" id="endDateContainer">
                        <div class="form-group">
                            <liferay-ui:message key="end-date"/><span class="text-danger">*</span>
                            <input type="date" id="<portlet:namespace />endDate" name="<portlet:namespace />endDate"
                                   class="form-control"/>
                        </div>
                    </div>

                    <div class="col-sm-12 col-md-4 col-lg-4">
                        <div class="form-group">
                            <liferay-ui:message key="team-id"/>
                            <select id="mySelect" name="<portlet:namespace />teamIdSelectBox"
                                    class="custom-select mr-sm-2">
                                <option value="">Select an option</option>
                                <c:forEach var="employeeDetailsList" items="${employeeDetailsList}">
                                    <option value="${employeeDetailsList.getEmployeeId()}">${employeeDetailsList.getEmployeeId()} ${employeeDetailsList.getFirstName()}</option>
                                </c:forEach>
                            </select>
                            <input type="hidden" id="<portlet:namespace />teamId" name="<portlet:namespace />teamId"/>
                            <div id="selectedOptionsContainer" class="selected-options"></div>
                        </div>
                    </div>
                    <div class="col-sm-12 col-md-4 col-lg-4">
                        <div class="form-group">
                            <div id="floaterDaysContainer"></div>
                        </div>
                    </div>
                    <div class="col-sm-12 col-md-4 col-lg-4">
                        <div class="form-group">
                            <div id="dateInputsContainer" style="display:none;"></div>
                        </div>
                    </div>

                    <div class="col-sm-12 col-md-12 col-lg-12">
                        <div class="form-group">
                            <liferay-ui:message key="reason"/>
                            <textarea id="<portlet:namespace />reason" name="<portlet:namespace />reason" rows="4"
                                      cols="30"
                                      class="form-control"></textarea>
                        </div>
                    </div>
                </div>
            </div>
            <div class="card-footer text-right align-items-center">
                <a href="${homeUrl}" class="btn btn-outline-danger"><liferay-ui:message key="back"/></a>
                <button type="submit" class="btn btn-outline-success" id="<portlet:namespace />submit"><liferay-ui:message
                        key="submit"/></button>
            </div>
        </form>
    </c:catch>
</div>


<script>
    function showMessage(newMessage) {
        Liferay.Util.openToast({
            title: 'Info',
            message: newMessage,
            type: 'info',
            autoClose: 10000
        });
    }


    $(document).ready(function () {

        var config = new Object({});
        namespace = '<portlet:namespace />';

        config.namespace = namespace;
        config.isContinuous = $('#<portlet:namespace />leaveType').find(':selected').data('is-continuous');
        config.remainingLeave = $('#<portlet:namespace />leaveType').find(':selected').data('remaining-leaves');
        config.isApplicableForFloater = $('#<portlet:namespace />leaveType').find(':selected').data('is-applicable-floater');
        config.getFloaters = '<portlet:resourceURL id="/viewFloaterDays" />';
        config.getEmployeeLeavesData = '<portlet:resourceURL id="/viewEmployeeLeavesDetail" />';

        AxEmployeeLeaveManagement.setConfigs(config);
    });
</script>