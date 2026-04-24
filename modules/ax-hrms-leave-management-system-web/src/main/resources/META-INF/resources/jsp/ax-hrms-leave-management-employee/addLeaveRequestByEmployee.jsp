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
                Leave Request
            </strong>
        </div>

        <c:catch>
            <form method="Post" action="${addLeaveRequestUrl }" id="<portlet:namespace/>leaveRequestForm" >
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
                                    <label><liferay-ui:message key="employee-detail"/><span class="text-danger">*</span></label>
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
                                <label><liferay-ui:message key="leave-type"/><span class="text-danger">*</span></label>
                                <select id="<portlet:namespace />leaveType" name="<portlet:namespace />leaveType"
                                        class="form-control custom-select mr-sm-2">
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
                                <label id="startDateLabel">
                                    <liferay-ui:message key="start-date"/>
                                </label><span class="text-danger">*</span>
                                <input type="date" id="<portlet:namespace />startDate" name="<portlet:namespace />startDate"
                                       class="form-control" max="9999-12-31"/>
                            </div>
                        </div>
                        <div class="col-sm-12 col-md-4 col-lg-4" id="endDateContainer">
                            <div class="form-group">
                                <label><liferay-ui:message key="end-date"/><span class="text-danger">*</span></label>
                                <input type="date" id="<portlet:namespace />endDate" name="<portlet:namespace />endDate"
                                       class="form-control" max="9999-12-31"/>
                            </div>
                        </div>

                        <div class="col-sm-12 col-md-4 col-lg-4">
                            <div class="form-group">
                                <label><liferay-ui:message key="Inform Team Members"/></label>
                                <select class="form-control mt-3 custom-multi-select"
                                        id="teamIdSelectBox"
                                        name="<portlet:namespace />teamIdSelectBox"
                                        data-live-search="true"
                                        multiple
                                        placeholder="Select Employee(s)">
                                    <c:forEach var="employeeDetailsList" items="${employeeDetailsList}">
                                        <option value="${employeeDetailsList.getEmployeeId()}">${employeeDetailsList.employeeCode}: ${employeeDetailsList.getFirstName()} ${employeeDetailsList.getLastName()}</option>
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
                        <div class="col-sm-12 col-md-8">
                            <div class="form-group">
                                <div id="dateInputsContainer" style="display:none;" ></div>
                            </div>
                        </div>

                        <div class="col-sm-12 col-md-12 col-lg-12">
                            <div class="form-group">
                                <label>Leave Reason<span class="text-danger">*</span></label>
                                <textarea id="<portlet:namespace />reason" name="<portlet:namespace />reason" rows="4"
                                          cols="30"
                                          class="form-control"></textarea>
                                          <small class="text-muted " id="reasonCharCount">
                                               Minimum 10 and maximum 500 characters allowed.
                                          </small>

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






    <!-- Custom Message Modal -->
    <div id="customMessageModal" class="custom-modal-overlay">
        <div class="custom-modal">
            <div class="custom-modal-header">
                <span id="customModalTitle">Message</span>
                <button type="button" class="custom-modal-close" onclick="closeCustomModal()">
                    &times;
                </button>
            </div>

            <div class="custom-modal-body" id="customModalBody">
            </div>

            <div class="custom-modal-footer">
                <button type="button" class="btn btn-outline-secondary" onclick="closeCustomModal()">
                    Cancel
                </button>
            </div>
        </div>
    </div>









    <script>

    function showMessage(message, type = 'warning') {

        let title = 'Message';
        let bodyClass = 'modal-info';

        if (type === 'error') {
            title = 'Error';
            bodyClass = 'modal-error';
        } else if (type === 'success') {
            title = 'Success';
            bodyClass = 'modal-success';
        } else if (type === 'warning') {
            title = 'Warning Message';
            bodyClass = 'modal-warning';
        }

        document.getElementById('customModalTitle').innerText = title;
        document.getElementById('customModalBody').innerHTML =
            '<div class="' + bodyClass + '">' + message + '</div>';

        document.getElementById('customMessageModal').style.display = 'flex';
    }

    function closeCustomModal() {
        document.getElementById('customMessageModal').style.display = 'none';
    }

        $(document).ready(function () {
            let holidayList = ${empty holidayJson ? '[]' : holidayJson};
           const namespace = '<portlet:namespace />';
           // namespace = '<portlet:namespace />';
            var config = new Object({});

            config.namespace = namespace;
            config.isContinuous = $('#<portlet:namespace />leaveType').find(':selected').data('is-continuous');
            config.remainingLeave = $('#<portlet:namespace />leaveType').find(':selected').data('remaining-leaves');
            config.isApplicableForFloater = $('#<portlet:namespace />leaveType').find(':selected').data('is-applicable-floater');
            config.getFloaters = '<portlet:resourceURL id="/viewFloaterDays" />';
            config.getEmployeeLeavesData = '<portlet:resourceURL id="/viewEmployeeLeavesDetail" />';
            config.holidayList=holidayList;
            AxEmployeeLeaveManagement.setConfigs(config);

            // Initialize Team Members Multi-Select with localStorage and rendering
            const teamSelect = $("#teamIdSelectBox");
            const selectedOptionsContainer = $('#selectedOptionsContainer');

            let selectedValues = [];

            // Function to get team IDs from localStorage
            function getTeamIds() {
                return JSON.parse(localStorage.getItem('selectedOptions') || '[]');
            }

            // Function to update hidden field with selected values
            function setTeamIdInParams() {
                const teamIds = getTeamIds();
                $("#" + namespace + "teamId").val(teamIds.join(','));
            }

            // Function to render selected options visually
            function renderSelectedOptions() {
                selectedOptionsContainer.empty();
                selectedValues = getTeamIds();

                selectedValues.forEach(function(value) {
                    const selectedOptionElement = $('<div>').addClass('selected-option');
                    const text = $('#teamIdSelectBox option[value="' + value + '"]').text();
                    const span = $('<span>').text(text);
                    const closeButton = $('<button type="button">').text('x');

                    closeButton.click(function(e) {
                        e.preventDefault();
                        selectedValues = selectedValues.filter(v => v !== value);
                        localStorage.setItem('selectedOptions', JSON.stringify(selectedValues));
                        renderSelectedOptions();
                        setTeamIdInParams();
                    });

                    selectedOptionElement.append(span, closeButton);
                    selectedOptionsContainer.append(selectedOptionElement);
                });
            }

            // Initialize Select2
            teamSelect.select2({
                placeholder: "Select Employee(s)",
                allowClear: true,
                width: '100%'
            });

            // Handle selection changes
            teamSelect.on("change", function() {
                const selectedVals = $(this).val();
                if (selectedVals && selectedVals.length > 0) {
                    selectedValues = selectedVals;
                    localStorage.setItem('selectedOptions', JSON.stringify(selectedVals));
                    renderSelectedOptions();
                    setTeamIdInParams();
                } else {
                    localStorage.removeItem('selectedOptions');
                    renderSelectedOptions();
                    setTeamIdInParams();
                }
            });

            // Render initial selected options on page load
            renderSelectedOptions();

        });

    $(document).ready(function () {

        var config = new Object({});
        const namespace = '<portlet:namespace />';

        let isSubmitting = false;

        form.addEventListener("submit", function (e) {

        // Initialize Team Members Multi-Select with localStorage and rendering
        const teamSelect = $("#teamIdSelectBox");
        const selectedOptionsContainer = $('#selectedOptionsContainer');
        //const namespace = '<portlet:namespace />';
        let selectedValues = [];

        // Function to get team IDs from localStorage
        function getTeamIds() {
            return JSON.parse(localStorage.getItem('selectedOptions') || '[]');
        }

        // Function to update hidden field with selected values
        function setTeamIdInParams() {
            const teamIds = getTeamIds();
            $("#" + namespace + "teamId").val(teamIds.join(','));
        }

        // Function to render selected options visually
        function renderSelectedOptions() {
            selectedOptionsContainer.empty();
            selectedValues = getTeamIds();

            selectedValues.forEach(function(value) {
                const selectedOptionElement = $('<div>').addClass('selected-option');
                const text = $('#teamIdSelectBox option[value="' + value + '"]').text();
                const span = $('<span>').text(text);
                const closeButton = $('<button type="button">').text('x');

                closeButton.click(function(e) {
                    e.preventDefault();
                    selectedValues = selectedValues.filter(v => v !== value);
                    localStorage.setItem('selectedOptions', JSON.stringify(selectedValues));
                    renderSelectedOptions();
                    setTeamIdInParams();
                });

                selectedOptionElement.append(span, closeButton);
                selectedOptionsContainer.append(selectedOptionElement);
            });
        }

        // Initialize Select2
        teamSelect.select2({
            placeholder: "Select Employee(s)",
            allowClear: true,
            width: '100%'
        });

        // Handle selection changes
        teamSelect.on("change", function() {
            const selectedVals = $(this).val();
            if (selectedVals && selectedVals.length > 0) {
                selectedValues = selectedVals;
                localStorage.setItem('selectedOptions', JSON.stringify(selectedVals));
                renderSelectedOptions();
                setTeamIdInParams();
            } else {
                localStorage.removeItem('selectedOptions');
                renderSelectedOptions();
                setTeamIdInParams();
            }

            if (isSubmitting) {
                e.preventDefault();
                return false;
            }

            isSubmitting = true;
            submitBtn.disabled = true;

        });
    });
    </script>