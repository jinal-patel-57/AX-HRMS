<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<portlet:resourceURL var="downloadURL" id="/previous/month/leave/report/export" />

<div class="card">
    <div class="card-body">

        <form method="post" action="${downloadURL}">

            <!-- Date Range + Employee Selection -->
            <div class="row mb-3">

                <!-- Date Range -->
                <div class="col-md-4 col-sm-12">
                    <div class="form-group">
                        <label>From Date</label>
                        <input type="date"
                               class="form-control"
                               id="fromDate"
                               name="<portlet:namespace/>fromDate">
                        <small class="text-danger" id="fromDateError"></small>
                    </div>
                </div>

                <div class="col-md-4 col-sm-12">
                    <div class="form-group">
                        <label>To Date</label>
                        <input type="date"
                               class="form-control"
                               id="toDate"
                               name="<portlet:namespace/>toDate">
                        <small class="text-danger" id="toDateError"></small>
                    </div>
                </div>

                <!-- Previous Month -->
                <div class="col-md-4 col-sm-12 d-flex align-items-end">
                    <div class="form-group">
                        <div class="form-check">
                            <input type="checkbox"
                                   id="previousMonth"
                                   name="<portlet:namespace/>previousMonth"
                                   class="form-check-input">

                            <label class="form-check-label" for="previousMonth">
                                Previous Month
                            </label>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Employee Selection -->
            <div class="row mb-3">
                <div class="col-md-3 col-sm-12">
                    <div class="form-group">
                        <label>Employee</label>
                        <div class="radio-group">

                            <div class="form-check d-flex align-items-center c-gap-1">
                                <input type="radio"
                                       id="allEmployees"
                                       name="<portlet:namespace/>employeeType"
                                       value="ALL"
                                       class="form-check-input"
                                       checked
                                       onclick="toggleEmployeeSelect(false)">
                                <label class="form-check-label" for="allEmployees">
                                    All Employees
                                </label>
                            </div>

                            <div class="form-check d-flex align-items-center c-gap-1">
                                <input type="radio"
                                       id="specificEmployees"
                                       name="<portlet:namespace/>employeeType"
                                       value="SPECIFIC"
                                       class="form-check-input"
                                       onclick="toggleEmployeeSelect(true)">
                                <label class="form-check-label" for="specificEmployees">
                                    Specific Employee(s)
                                </label>
                            </div>

                        </div>
                    </div>
                </div>

                <div class="col-md-9 col-sm-12">
                    <div class="form-group">
                        <select class="form-control mt-3 custom-multi-select"
                                id="employeeIds"
                                data-live-search="true"
                                name="<portlet:namespace/>employeeIds"
                                multiple
                                placeholder="Select Employee(s)"
                                disabled>
                            <c:forEach var="employee" items="${employeeList}">
                                <option value="${employee.getEmployeeId()}">
                                    ${employee.getEmployeeCode()}: ${employee.getFirstName()} ${employee.getLastName()}
                                </option>
                            </c:forEach>
                        </select>
                        <small class="text-danger" id="employeeError"></small>
                        <div id="selectedOptionsContainer" class="selected-options"></div>
                    </div>
                </div>
            </div>

            <!-- Submit -->
            <div class="row">
                <div class="col-12 text-right">
                    <button type="submit" class="btn btn-primary">
                        Download Excel
                    </button>
                </div>
            </div>

        </form>

    </div>
</div>

<script>
    function toggleEmployeeSelect(enable) {
        document.getElementById("employeeIds").disabled = !enable;
    }

    function validateForm() {
        const isPreviousMonth = $("#previousMonth").is(":checked");
        const fromDateVal = $("#fromDate").val();
        const toDateVal = $("#toDate").val();
        const selectedEmployeeType = $("input[name='<portlet:namespace/>employeeType']:checked").val();
        const selectedEmployees = $("#employeeIds").val();

        let isValid = true;

        // Clear errors
        $("#fromDateError").text("").closest(".form-group").find("input").removeClass("is-invalid");
        $("#toDateError").text("").closest(".form-group").find("input").removeClass("is-invalid");
        $("#employeeError").text("").closest(".form-group").find("select").removeClass("is-invalid");

        // Validate dates if previous month is not checked
        if (!isPreviousMonth) {
            if (!fromDateVal || fromDateVal.trim() === "") {
                $("#fromDateError").text("Please select From Date.");
                $("#fromDate").addClass("is-invalid");
                isValid = false;
            }
            if (!toDateVal || toDateVal.trim() === "") {
                $("#toDateError").text("Please select To Date.");
                $("#toDate").addClass("is-invalid");
                isValid = false;
            }
        }

        // Validate employee selection for SPECIFIC type
        if (selectedEmployeeType === "SPECIFIC") {
            if (!selectedEmployees || selectedEmployees.length === 0) {
                $("#employeeError").text("Please select at least one employee.");
                $("#employeeIds").addClass("is-invalid");
                isValid = false;
            }
        }

        return isValid;
    }

    $(function () {
        const previousMonthCheckbox = $("#previousMonth");
        const fromDate = $("#fromDate");
        const toDate = $("#toDate");
        const employeeSelect = $("#employeeIds");
        const form = $("form");

        // Function to set previous month dates
        function setPreviousMonthDates() {
            try {
                const today = new Date();
                const year = today.getFullYear();
                const month = today.getMonth();
                
                // First day of previous month
                const firstDayDate = new Date(year, month - 1, 1);
                
                // Last day of previous month (day 0 of current month)
                const lastDayDate = new Date(year, month, 0);
                
                // Format as yyyy-MM-dd for HTML date input using string concatenation
                const padZero = function(num) {
                    return num < 10 ? '0' + num : '' + num;
                };
                
                const fromDateFormatted = firstDayDate.getFullYear() + '-' + padZero(firstDayDate.getMonth() + 1) + '-' + padZero(firstDayDate.getDate());
                const toDateFormatted = lastDayDate.getFullYear() + '-' + padZero(lastDayDate.getMonth() + 1) + '-' + padZero(lastDayDate.getDate());
                
                // Set values directly on DOM elements
                document.getElementById("fromDate").value = fromDateFormatted;
                document.getElementById("toDate").value = toDateFormatted;
                
            } catch (e) {
                console.error("Error setting dates:", e);
            }
        }

        previousMonthCheckbox.on("change", function () {
            if (this.checked) {
                setPreviousMonthDates();
                
                fromDate.prop("disabled", true);
                toDate.prop("disabled", true);
                $("#fromDateError").text("");
                $("#toDateError").text("");
                fromDate.removeClass("is-invalid");
                toDate.removeClass("is-invalid");
            } else {
                document.getElementById("fromDate").value = "";
                document.getElementById("toDate").value = "";
                fromDate.prop("disabled", false);
                toDate.prop("disabled", false);
            }
        });

        fromDate.on("change", function () {
            $("#fromDateError").text("");
            fromDate.removeClass("is-invalid");
        });

        toDate.on("change", function () {
            $("#toDateError").text("");
            toDate.removeClass("is-invalid");
        });

        employeeSelect.on("change", function () {
            $("#employeeError").text("");
            employeeSelect.removeClass("is-invalid");
        });

        form.on("submit", function (e) {
            if (!validateForm()) {
                e.preventDefault();
            }
        });
    });
</script>