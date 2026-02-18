<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<portlet:resourceURL var="downloadURL" id="/comp/off/report/export" />

<div class="mb-4">
    <div class="d-flex align-items-center justify-content-between">
        <div>
            <h3 class="mb-1 font-weight-bold">
                 Compensatory Off
            </h3>
            <p class="text-muted mb-0">
                Generate and download Compensatory Off reports for employees based on date range or previous month.
            </p>
        </div>

    </div>
    <hr>
</div>

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
                <small class="text-danger error-message" id="fromDateError"></small>
                    </div>
                </div>

                <div class="col-md-4 col-sm-12">
                    <div class="form-group">
                        <label>To Date</label>
                        <input type="date"
                               class="form-control"
                               id="toDate"
                               name="<portlet:namespace/>toDate">
          <small class="text-danger error-message" id="toDateError"></small>

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
                                multiple placeholder="Select Employee(s)"
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

        const employeeSelect = $("#employeeIds");

        if (enable) {

            // Enable Select2 properly
            employeeSelect.prop("disabled", false);
            employeeSelect.select2({
                placeholder: "Select Employee(s)",
                allowClear: true,
                width: '100%'
            });

        } else {

            // Clear selection
            employeeSelect.val(null).trigger("change");

            // Enable first (important), then disable
            employeeSelect.prop("disabled", false);
            employeeSelect.select2({
                placeholder: "Select Employee(s)",
                allowClear: true,
                width: '100%'
            });

            employeeSelect.prop("disabled", true);

            $("#employeeError").text("");
            employeeSelect.removeClass("is-invalid");
        }
    }

    $(function () {

        const form = $("form");

        const fromDate = $("#fromDate");
        const toDate = $("#toDate");
        const previousMonth = $("#previousMonth");

        const employeeIds = $("#employeeIds");
        const employeeType = $("input[name='<portlet:namespace/>employeeType']");

        const fromDateError = $("#fromDateError");
        const toDateError = $("#toDateError");
        const employeeError = $("#employeeError");

        employeeIds.select2({
            placeholder: "Select Employee(s)",
            allowClear: true,
            width: '100%'
        });

        function clearDateErrors() {
            fromDateError.text("");
            toDateError.text("");
            fromDate.removeClass("is-invalid");
            toDate.removeClass("is-invalid");
        }

        function clearEmployeeError() {
            employeeError.text("");
            employeeIds.removeClass("is-invalid");
        }

        function validateForm() {

            clearDateErrors();
            clearEmployeeError();

            const isPreviousMonthChecked = previousMonth.is(":checked");
            const fromVal = fromDate.val();
            const toVal = toDate.val();
            const selectedEmployeeType =
                $("input[name='<portlet:namespace/>employeeType']:checked").val();
            const selectedEmployees = employeeIds.val();

            let isValid = true;

            // Date Validation
            if (!isPreviousMonthChecked) {

                if (!fromVal) {
                    fromDateError.text("Please select From Date.");
                    fromDate.addClass("is-invalid");
                    isValid = false;
                }

                if (!toVal) {
                    toDateError.text("Please select To Date.");
                    toDate.addClass("is-invalid");
                    isValid = false;
                }

                if (fromVal && toVal) {
                    const start = new Date(fromVal);
                    const end = new Date(toVal);

                    if (start > end) {
                        toDateError.text("To Date must be same or after From Date.");
                        toDate.addClass("is-invalid");
                        isValid = false;
                    }
                }
            }

            // Employee Validation
            if (selectedEmployeeType === "SPECIFIC") {
                if (!selectedEmployees || selectedEmployees.length === 0) {
                    employeeError.text("Please select at least one employee.");
                    employeeIds.addClass("is-invalid");
                    isValid = false;
                }
            }

            return isValid;
        }

        previousMonth.on("change", function () {

            clearDateErrors();

            if (this.checked) {
                fromDate.prop("disabled", true).val("");
                toDate.prop("disabled", true).val("");
            } else {
                fromDate.prop("disabled", false);
                toDate.prop("disabled", false);
            }
        });

        fromDate.on("change input", validateForm);
        toDate.on("change input", validateForm);

        employeeType.on("change", function () {

            const selectedValue =
                $("input[name='<portlet:namespace/>employeeType']:checked").val();

            if (selectedValue === "ALL") {
                toggleEmployeeSelect(false);
            } else {
                toggleEmployeeSelect(true);
            }

            clearEmployeeError();
        });

        employeeIds.on("change", function () {
            clearEmployeeError();
        });

        form.on("submit", function (e) {
            if (!validateForm()) {
                e.preventDefault();
            }
        });

    });
</script>