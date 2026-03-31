    <%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
    <%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    <portlet:resourceURL var="downloadURL" id="/leave_report/export" />

    <!-- Filter Card -->
    <div class="card">
        <div class="card-body">

            <form method="post" action="${downloadURL}">

                <!-- Employee Selection -->
                <div class="row mb-3">
                    <div class="col-md-3 col-sm-12">
                        <div class="form-group">
                            <label for="<portlet:namespace/>startDate">Start Date</label>
                            <input type="date"
                                   class="form-control"
                                   id="startDate"
                                   name="<portlet:namespace/>startDate" />
                        </div>
                     </div>
                         <div class="col-md-3 col-sm-12">
                        <div class="form-group mt-2">
                            <label for="<portlet:namespace/>endDate">End Date</label>
                            <input type="date"
                                   class="form-control"
                                   id="endDate"
                                   name="<portlet:namespace/>endDate" />
                        </div>
                        </div>
                        <small class="text-danger" id="dateError"></small>


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
                    <div class="col-md-3 col-sm-12">
                        <div class="form-group">
                            <select class="form-control mt-3 custom-multi-select"
                                id="employeeIds" data-live-search="true"
                                name="<portlet:namespace/>employeeIds"
                                multiple placeholder="Select Employee(s)"
                                disabled>
                                <c:forEach var="employee" items="${employeeList}">
                                    <option value="${employee.getEmployeeId()}">
                                        ${employee.getEmployeeCode() }: ${employee.getFirstName()} ${employee.getLastName() }
                                    </option>
                                </c:forEach>
                            </select>
                            <small class="text-danger" id="employeeError"></small>

                            <div id="selectedOptionsContainer" class="selected-options"></div>
                        </div>
                    </div>
                </div>
                                    </div>

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
        $(document).ready(function () {
            const startDate = $("#startDate");
            const endDate = $("#endDate");
            const dateError = $("#dateError");
            const employeeSelect = $("#employeeIds");
            const form = $("form");
            const employeeError = $("#employeeError");

            /* -------- Initialize Select2 ONLY ONCE -------- */

            employeeSelect.select2({
                placeholder: "Select Employee(s)",
                allowClear: true,
                width: "100%"
            });

            /* -------- Toggle Function -------- */


            function toggleEmployeeSelect(enable) {

                if (enable) {
                    // Enable select2 properly
                    employeeSelect.prop("disabled", false);
                } else {
                    // Clear selected values properly
                    employeeSelect.val(null).trigger("change");
                employeeSelect.select2({
                    placeholder: "Select Employee(s)",
                    allowClear: true,
                    width: '100%'
                });
                    // Disable using select2 mechanism
                    employeeSelect.prop("disabled", true);

                    clearEmployeeError();
                }


            }

            /* -------- Clear Error -------- */

            function clearEmployeeError() {
                employeeError.text("");
                employeeSelect.removeClass("is-invalid");
            }

            function clearDateError() {
                dateError.text("");
                startDate.removeClass("is-invalid");
                endDate.removeClass("is-invalid");
            }

            /* -------- Validation -------- */

            function validateForm() {

                clearEmployeeError();
                clearDateError();

                const selectedEmployeeType =
                    $("input[name='<portlet:namespace/>employeeType']:checked").val();

                const selectedEmployees = employeeSelect.val();
                const start = startDate.val();
                const end = endDate.val();

                let isValid = true;

                if (!start || !end) {
                    dateError.text("Start Date and End Date are required.");
                    startDate.addClass("is-invalid");
                    endDate.addClass("is-invalid");
                    isValid = false;
                } else if (new Date(start) > new Date(end)) {
                    dateError.text("Start Date cannot be greater than End Date.");
                    startDate.addClass("is-invalid");
                    endDate.addClass("is-invalid");
                    isValid = false;
                }


                if (selectedEmployeeType === "SPECIFIC") {

                    if (!selectedEmployees || selectedEmployees.length === 0) {
                        employeeError.text("Please select at least one employee.");
                        employeeSelect.addClass("is-invalid");
                        isValid = false;
                    }
                }

                return isValid;
            }

            /* -------- Radio Change -------- */

            $("input[name='<portlet:namespace/>employeeType']").on("change", function () {

                const selectedValue =
                    $("input[name='<portlet:namespace/>employeeType']:checked").val();

                if (selectedValue === "ALL") {
                    toggleEmployeeSelect(false);
                } else {
                    toggleEmployeeSelect(true);
                }
            });

            /* -------- Remove error on selection -------- */
            startDate.on("change", clearDateError);
            endDate.on("change", clearDateError);
            employeeSelect.on("change", function () {
                clearEmployeeError();
            });

            /* -------- Form Submit -------- */

            form.on("submit", function (e) {
                if (!validateForm()) {
                    e.preventDefault();
                }
            });

            /* -------- Default State -------- */
            toggleEmployeeSelect(false);

        });
    </script>
