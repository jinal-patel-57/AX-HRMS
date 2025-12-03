<%@ include file="/init.jsp" %>
<portlet:actionURL var="sendSelfEvaluationFormURL" name="/sendSelfEvaluationForm"/>
<portlet:actionURL var="updateEmployeeCtcURL" name="/updateEmployeeCtc"/>
<portlet:actionURL var="sendPeerEvaluationFormURL" name="/sendPeerEvaluationForm"/>
<portlet:actionURL var="sendManagerEvaluationFormURL" name="/sendManagerEvaluationForm"/>
<portlet:actionURL var="scheduleAppraisalMeetingURL" name="/scheduleAppraisalMeeting"/>
<portlet:actionURL var="addEmployeeApprasialFormURL" name="/addApprasialEmployee"/>
<portlet:resourceURL id="/getDesignationList" var="getDesignationListURL"/>
<portlet:resourceURL id="/checkAppraisalFormTemplateAvailability" var="checkAppraisalFormTemplateAvailabilityURL"/>

<head>

    <style>
        .modal-open .modal:not(.show) {
            display: none !important;
        }
    </style>

    <script>
        $(document).ready(function () {
            var config = {};
            config.namespace = '<portlet:namespace />';
            config.checkAppraisalFormTemplateAvailabilityURL = '${checkAppraisalFormTemplateAvailabilityURL}';
            config.getDesignationListURL = '${getDesignationListURL}';
            AXHrmsHrAppraisalFormTemplatesWebPortlet.setConfigs(config);
        });
    </script>

</head>


<liferay-ui:success key="self-skipped" message="self-skipped"/>
<liferay-ui:success key="peer-skipped" message="peer-skipped"/>
<liferay-ui:success key="manager-skipped" message="manager-skipped"/>
<liferay-ui:success key="self-form-sent" message="self-form-sent-successfully"/>
<liferay-ui:success key="manager-form-sent" message="manager-form-sent-successfully"/>
<liferay-ui:success key="peer-form-sent" message="peer-form-sent-successfully"/>
<liferay-ui:success key="meeting-scheduled" message="meeting-scheduled"/>
<liferay-ui:success key="meeting-updated" message="meeting-updated"/>
<liferay-ui:success key="ctc-updated" message="ctc-updated"/>


<c:if test="${isHr}">
    <div class="card">
        <div class="card-header d-flex justify-content-between align-items-center">
            <strong>
                Appraisal Process HR
            </strong>

            <button type="button" class="btn btn-primary" id="addEmployee" onclick="open_add_appraisal_popup();">Add
            </button>
        </div>
        <div class="card-body">
            <c:if test="${not empty appraisalProcessList}">

            <table class="table">
                <thead>
                <tr>
                    <th scope="col"><liferay-ui:message key="employee-name"/></th>
                    <th scope="col"><liferay-ui:message key="departments"/></th>
                    <th scope="col"><liferay-ui:message key="designations"/></th>
                    <th scope="col"><liferay-ui:message key="appraisal-date"/></th>
                    <th scope="col"><liferay-ui:message key="no-of-years-completed"/></th>
                    <th scope="col"><liferay-ui:message key="status"/></th>
                    <th scope="col"><liferay-ui:message key="action"/></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="appraisalProcess" items="${appraisalProcessList}">
                    <tr>
                        <th scope="row">${appraisalProcess.employeeFullName}</th>
                        <td>${appraisalProcess.departments}</td>
                        <td>${appraisalProcess.designations}</td>
                        <td>${appraisalProcess.appraisalDate}</td>
                        <td>${appraisalProcess.noOfYearsCompleted}</td>
                        <td>${appraisalProcess.appraisalStatus}</td>

                        <c:if test="${appraisalProcess.actionStatus == 0}">
                            <td>
                                <button type="button" class="btn btn-sm btn-primary w-100 mb-2"
                                        onclick="send_self_evaluation_form_modal(${appraisalProcess.getAppraisalProcessId()})">
                                    <liferay-ui:message key="send-self-eval-form"/>
                                </button>
                                <portlet:actionURL var="skipURL" name="/skipURL">
                                    <portlet:param name="appraisalProcessId"
                                                   value="${appraisalProcess.getAppraisalProcessId()}"/>
                                    <portlet:param name="level" value="Self"/>
                                </portlet:actionURL>
                                <a type="button" href="${skipURL}"
                                   class="btn btn-sm btn-primary w-100 "><liferay-ui:message
                                        key="skip"/></a>
                            </td>

                        </c:if>

                        <c:if test="${appraisalProcess.actionStatus == 1}">
                            <td>
                                <button type="button" class="btn btn-sm btn-primary w-100 mb-1"
                                        onclick="send_peer_evaluation_form_modal(${appraisalProcess.getAppraisalProcessId()})">
                                    <liferay-ui:message key="send-peer-eval-form"/>
                                </button>
                                <portlet:actionURL var="skipURL" name="/skipURL">
                                    <portlet:param name="appraisalProcessId"
                                                   value="${appraisalProcess.getAppraisalProcessId()}"/>
                                    <portlet:param name="level" value="Peer"/>
                                </portlet:actionURL>
                                <a type="button" href="${skipURL}"
                                   class="btn btn-sm btn-primary w-100 "><liferay-ui:message
                                        key="skip"/></a>
                            </td>
                        </c:if>
                        <c:if test="${appraisalProcess.actionStatus == 2}">
                            <td>
                                <button type="button" class="btn btn-sm btn-primary w-100 mb-2"
                                        onclick="send_manager_evaluation_form_modal(${appraisalProcess.getAppraisalProcessId()})">
                                    <liferay-ui:message key="send-manager-eval-form"/>
                                </button>
                                <portlet:actionURL var="skipURL" name="/skipURL">
                                    <portlet:param name="appraisalProcessId"
                                                   value="${appraisalProcess.getAppraisalProcessId()}"/>
                                    <portlet:param name="level" value="Manager"/>
                                </portlet:actionURL>
                                <a type="button" href="${skipURL}"
                                   class="btn btn-sm btn-primary w-100 "><liferay-ui:message
                                        key="skip"/></a>
                            </td>
                        </c:if>
                        <c:if test="${appraisalProcess.actionStatus == 3}">
                            <td>
                                <button type="button" class="btn btn-sm btn-primary w-100 "
                                        onclick="schedule_meeting_form_modal(${appraisalProcess.getAppraisalProcessId()})">
                                    <liferay-ui:message key="schedule-meeting"/>
                                </button>
                            </td>
                        </c:if>
                        <c:if test="${appraisalProcess.actionStatus == 4}">
                            <td cla>
                                <button type="button" class="btn btn-sm btn-primary w-100 mb-2"
                                        onclick="update_meeting_form_modal(${appraisalProcess.getAppraisalMeetingId()}, '${appraisalProcess.getAppraisalMeetingDate()}', '${appraisalProcess.getAppraisalMeetingTime()}','${appraisalProcess.getListOfAttendees()}', ${appraisalProcess.getAppraisalProcessId()})">
                                    <liferay-ui:message key="update-meeting"/>
                                </button>
                                <button type="button" class="btn btn-sm btn-primary w-100 "
                                        onclick="update_employee_ctc_form_modal('${appraisalProcess.employeeFullName}','${appraisalProcess.designations}',${appraisalProcess.getAppraisalProcessId()})">
                                    <liferay-ui:message key="update-ctc"/>
                                </button>
                            </td>
                        </c:if>
                        <c:if test="${appraisalProcess.actionStatus == 5}">
                            <td>
                                <a href="#" class="btn btn-sm btn-primary w-100">
                                    Process Closed
                                </a>
                            </td>
                        </c:if>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            </c:if>
                <c:if test="${empty appraisalProcessList}">
                    <div class="alert alert-info">
                        There are no current appraisal process pending!
                    </div>
                </c:if>
        </div>
    </div>


    <!-- UPDATE EMPLOYEE CTC -->
    <div class="modal fade" id="updateEmployeeCTC" tabindex="-1" role="dialog" aria-labelledby="updateEmployeeCTCLabel"
         aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="updateEmployeeCTCLabel"><liferay-ui:message key="update-ctc"/></h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form action="${updateEmployeeCtcURL}" id="updateEmployeeCtc" method="post"
                          enctype="multipart/form-data">
                        <div class="form-group">
                            <label for="employeeName">Employee Name<span class="text-danger">*</span></label>
                            <input id="employeeName" class="form-control" type="text" name="employeeName"
                                   value="John Doe" disabled/>

                        </div>
                        <div class="form-group">
                            <label for="currentDesignation">Current Designation<span class="text-danger">*</span></label>
                            <input id="currentDesignation" class="form-control" type="text" name="currentDesignation"
                                   value="Senior Developer" disabled/>
                        </div>
                        <div class="form-group">
                            <label for="updatedDesignation">Updated Designation<span class="text-danger">*</span></label>
                            <select id="updatedDesignation" class="form-control"
                                    name="<portlet:namespace/>updatedDesignation">
                                <option value="">Select Updated Designation</option>

                            </select>
                            <label id="updatedDesignation-error" class="error text-danger"
                                   for="updatedDesignation"></label>

                        </div>
                        <div class="form-group">
                            <label for="updateGrossSalaryPM">Update Gross Salary CTC PM<span class="text-danger">*</span></label>
                            <input id="updateGrossSalaryPM" class="form-control" type="number"
                                   name="<portlet:namespace/>updateGrossSalaryPM"/>
                            <label id="updateGrossSalaryPM-error" class="error text-danger"
                                   for="updateGrossSalaryPM"></label>

                        </div>
                        <div class="form-group">
                            <label for="updateGrossSalaryPA">Updated Gross Salary CTC PA<span class="text-danger">*</span></label>
                            <input id="updateGrossSalaryPA" class="form-control" type="number"
                                   name="<portlet:namespace/>updateGrossSalaryPA"/>
                            <label id="updateGrossSalaryPA-error" class="error text-danger"
                                   for="updateGrossSalaryPA"></label>

                        </div>
                        <div class="form-group">
                            <label for="documentName">Document Name<span class="text-danger">*</span></label>
                            <input id="documentName" class="form-control" type="text"
                                   name="<portlet:namespace/>documentName"/>
                            <label id="documentName-error" class="error text-danger" for="documentName"></label>
                        </div>
                        <div class="form-group">
                            <label for="uploadDocument">Upload Document<span class="text-danger">*</span></label>
                            <input id="uploadDocument" class="form-control" type="file"
                                   name="<portlet:namespace/>uploadDocument"/>
                            <label id="uploadDocument-error" class="error text-danger" for="uploadDocument"></label>
                        </div>
                        <div class="form-group">
                            <label for="comments">Comments</label>
                            <textarea name="<portlet:namespace/>comments" id="comments" class="form-control"></textarea>
                            <label id="comments-error" class="error text-danger" for="comments"></label>
                        </div>
                        <input type="hidden" name="<portlet:namespace/>appraisalProcessId"
                               id="updateCtcAppraisalProcessId" value="">
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-outline-danger" data-dismiss="modal"><liferay-ui:message
                            key="close"/></button>
                    <button type="button" class="btn btn-outline-success" onclick="updateEmployeeCtcForm()">
                        <liferay-ui:message
                                key="update"/></button>
                </div>
                </form>
            </div>
        </div>
    </div>


    <!-- Update Scheduled Meeting-->
    <div class="modal fade" id="updateMeetingModal" tabindex="-1" role="dialog"
         aria-labelledby="updateMeetingModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="updateMeetingModalLabel"><liferay-ui:message key="update-meeting"/>
                    </h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form action="${scheduleAppraisalMeetingURL}" id="updateMeetingForm" method="post">
                        <div class="form-group">
                            <label class="" for="updateMeetingDate"><liferay-ui:message key="submission-date"/><span class="text-danger">*</span></label>
                            <input id="updateMeetingDate" placeholder="<liferay-ui:message key='submission-date'/>"
                                   class="form-control" type="date" name="<portlet:namespace/>updateMeetingDate"/>
                            <label id="updateMeetingDate-error" class="error text-danger"
                                   for="updateMeetingDate"></label>
                        </div>
                        <div class="form-group">
                            <label for="updateMeetingTime"><liferay-ui:message key="time"/><span class="text-danger">*</span></label>
                            <input id="updateMeetingTime" class="form-control" type="time"
                                   name="<portlet:namespace />updateMeetingTime"/>
                            <label id="updateMeetingTime-error" class="error text-danger"
                                   for="updateMeetingTime"></label>
                        </div>
                        <div class="form-group">Team<span class="text-danger">*</span>
                            <select id="updatedMeetingSelect" name="<portlet:namespace />teamIdSelectBox"
                                    class="custom-select mr-sm-2">
                                <!-- adding the user list -->
                                <option value=""><liferay-ui:message key="select-attendee"/></option>
                                <c:forEach var="user" items="${userList}">
                                    <option value="${user.userId}">${user.getFullName()}</option>
                                </c:forEach>
                            </select>
                            <label id="updatedMeetingSelect-error" class="error text-danger"
                                   for="updatedMeetingSelect"></label>

                            <input type="hidden" id="updatedAttendeeList" name="<portlet:namespace/>teamId"/>
                            <div id="selectedOptionsContainerUpdatedAttendees" class="selected-options mt-2"></div>
                        </div>
                        <input type="hidden" name="<portlet:namespace/>meetingId" id="meetingId" value="">
                        <input type="hidden" name="<portlet:namespace/>appraisalProcessId"
                               id="updateMeetingAppraisalProcessId" value="">
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-outline-danger" data-dismiss="modal"><liferay-ui:message
                            key="close"/></button>
                    <button type="button" class="btn btn-outline-success"
                            onclick="updateScheduledMeetingForm()"><liferay-ui:message key="update"/></button>
                </div>
                </form>
            </div>
        </div>
    </div>


    <!-- SCHEDULE MEETING MODAL -->
    <div class="modal fade" id="scheduleMeetingModal" tabindex="-1" role="dialog"
         aria-labelledby="scheduleMeetingModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="scheduleMeetingModalLabel"><liferay-ui:message key="schedule-meeting"/>
                    </h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form action="${scheduleAppraisalMeetingURL}" id="scheduleMeetingForm" method="post">
                        <div class="form-group">
                            <label class="" for="meetingDate"><liferay-ui:message key="submission-date"/><span class="text-danger">*</span></label>
                            <input id="meetingDate" placeholder="<liferay-ui:message key='submission-date'/>"
                                   class="form-control" type="date" name="<portlet:namespace/>meetingDate"/>
                            <label id="meetingDate-error" class="error text-danger" for="meetingDate"></label>
                        </div>
                        <div class="form-group">
                            <label for="meetingTime"><liferay-ui:message key="time"/><span class="text-danger">*</span></label>
                            <input id="meetingTime" class="form-control" type="time"
                                   name="<portlet:namespace />meetingTime"/>
                            <label id="meetingTime-error" class="error text-danger" for="meetingTime"></label>
                        </div>
                        <div class="form-group">Team<span class="text-danger">*</span>
                            <select id="meetingSelect" name="<portlet:namespace />teamIdSelectBox"
                                    class="custom-select mr-sm-2">
                                <!-- adding the user list -->
                                <option value=""><liferay-ui:message key="select-attendee"/></option>
                                <c:forEach var="user" items="${userList}">
                                    <option value="${user.userId}">${user.getFullName()}</option>
                                </c:forEach>
                            </select>
                            <label id="meetingSelect-error" class="error text-danger" for="meetingSelect"></label>

                            <input type="hidden" id="attendeeList" name="<portlet:namespace/>teamId"/>
                            <div id="selectedOptionsContainerAttendees" class="selected-options mt-2"></div>
                        </div>
                        <input type="hidden" name="<portlet:namespace/>appraisalProcessId" id="apidScheduleMeeting"
                               value="">
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-outline-danger" data-dismiss="modal"><liferay-ui:message
                            key="close"/></button>
                    <button type="button" class="btn btn-outline-success"
                            onclick="submitScheduleMeetingForm()"><liferay-ui:message key="send"/></button>
                </div>
                </form>
            </div>
        </div>
    </div>

    <!-- MANAGER MODAL -->
    <div class="modal fade" id="managerModal" tabindex="-1" role="dialog" aria-labelledby="managerModalLabel"
         aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="managerModalLabel"><liferay-ui:message key="send-manager-eval-form"/>
                    </h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form action="${sendManagerEvaluationFormURL}" id="managerForm" method="post">
                        <div class="form-group">
                            <label class="" for="submissionDate"><liferay-ui:message key="submission-date"/><span class="text-danger">*</span></label>
                            <input id="submissionDate" placeholder="<liferay-ui:message key='submission-date'/>"
                                   class="form-control" type="date" name="<portlet:namespace/>submissionDate"/>
                            <label id="submissionDate-error" class="error text-danger" for="submissionDate"></label>
                        </div>
                        <div class="form-group">Team<span class="text-danger">*</span>
                            <select id="managerSelect" name="<portlet:namespace />teamIdSelectBox"
                                    class="custom-select mr-sm-2">
                                <!-- adding the user list -->
                                <option value=""><liferay-ui:message key="selected-option"/></option>
                                <c:forEach var="user" items="${userList}">
                                    <option value="${user.userId}">${user.getFullName()}</option>
                                </c:forEach>
                            </select>
                            <input type="hidden" id="managerList" name="<portlet:namespace/>teamId"/>
                            <div id="selectedOptionsContainerManager" class="selected-options mt-2"></div>
                        </div>
                        <input type="hidden" name="<portlet:namespace/>appraisalProcessId" id="apidManager" value="">
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-outline-danger" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-outline-success"
                            onclick="submitManagerEvaluationForm()"><liferay-ui:message key="send"/></button>
                </div>
                </form>
            </div>
        </div>
    </div>


    <div class="modal fade" id="peerModal" tabindex="-1" role="dialog" aria-labelledby="peerModalLabel"
         aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="peerModalLabel"><liferay-ui:message key="send-peer-eval-form"/></h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form action="${sendPeerEvaluationFormURL}" id="peerForm" method="post">
                        <div class="form-group">
                            <label class="" for="submissionDate"><liferay-ui:message key="submission-date"/><span class="text-danger">*</span></label>
                            <input id="submissionDate" placeholder="<liferay-ui:message key='submission-date'/>"
                                   class="form-control" type="date" name="<portlet:namespace/>submissionDate"/>
                            <label id="submissionDate-error" class="error text-danger" for="submissionDate"></label>
                        </div>
                        <div class="form-group">Team<span class="text-danger">*</span>
                            <select id="peerSelect" name="<portlet:namespace />teamIdSelectBox"
                                    class="custom-select mr-sm-2">
                                <!-- adding the user list -->
                                <option value=""><liferay-ui:message key="selected-option"/></option>
                                <c:forEach var="user" items="${userList}">
                                    <option value="${user.userId}">${user.getFullName()}</option>
                                </c:forEach>
                            </select>
                            <input type="hidden" id="peerList" name="<portlet:namespace/>teamId"/>
                            <div id="selectedOptionsContainer" class="selected-options mt-2"></div>
                        </div>

                        <input type="hidden" name="<portlet:namespace/>appraisalProcessId" id="apidpeer" value="">
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-outline-danger" data-dismiss="modal"><liferay-ui:message
                            key="close"/></button>
                    <button type="button" class="btn btn-outline-success"
                            onclick="submitPeerEvaluationForm()"><liferay-ui:message key="send"/></button>
                </div>
                </form>
            </div>
        </div>
    </div>

    <div class="modal fade" id="selfModal" tabindex="-1" role="dialog" aria-labelledby="selfModalLabel"
         aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="selfModalLabel"><liferay-ui:message key="send-self-eval-form"/></h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form action="${sendSelfEvaluationFormURL}" id="selfForm" method="post">
                        <div class="form-group">
                            <label class="" for="submissionDate"><liferay-ui:message key="submission-date"/><span class="text-danger">*</span></label>
                            <input id="submissionDate" placeholder="<liferay-ui:message key='submission-date'/>"
                                   class="form-control" type="date" name="<portlet:namespace/>submissionDate"/>
                            <label id="submissionDate-error" class="error text-danger" for="submissionDate"></label>
                        </div>
                        <input type="hidden" name="<portlet:namespace/>appraisalProcessId" id="apid" value="">
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-outline-danger" data-dismiss="modal"><liferay-ui:message
                            key="close"/></button>
                    <button type="button" class="btn btn-outline-success"
                            onclick="submitSelfEvaluationForm()"><liferay-ui:message key="Send"/></button>
                </div>
                </form>
            </div>
        </div>
    </div>


    <div class="modal fade" id="addEmployeeModel" tabindex="-1" role="dialog" aria-labelledby="addEmployeeModalLabel"
         aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="selfModalLabel"><liferay-ui:message
                            key="Add Employee For Apprasial"/></h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form action="${addEmployeeApprasialFormURL}" id="addEmployeeForm" method="post">


                        <div class="form-group">
                            <label for="<portlet:namespace />employee"><liferay-ui:message key="Employee"/><span class="text-danger">*</span></label>
                            <select class="form-control" id="apprasialEmployee" name="<portlet:namespace />employee">
                                <option value="">--Select Assignee--</option>
                                <c:forEach var="employee" items="${employeeList}">
                                    <option value="${employee.getEmployeeId()}">
                                            ${employee.getFirstName()} ${employee.getLastName() }
                                        (${employee.getEmployeeCode() })
                                    </option>
                                </c:forEach>
                            </select>
                        </div>


                        <input type="hidden" name="<portlet:namespace/>employeeId" id="empid" value="">
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-outline-danger" data-dismiss="modal"><liferay-ui:message
                            key="close"/></button>
                    <button type="button" class="btn btn-outline-success"
                            onclick="submitAddEmployeeForm()"><liferay-ui:message key="Submit"/></button>
                </div>
                </form>
            </div>
        </div>
    </div>


</c:if>

<c:if test="${!isHr}">
    <div class="card">
        <div class="card-header">
            <strong>
                Appraisal Process
            </strong>
        </div>
        <div class="card-body">
            <div class="alert alert-warning" role="alert">
                No Current Appraisal Forms to be Submitted!
            </div>
        </div>
    </div>


</c:if>