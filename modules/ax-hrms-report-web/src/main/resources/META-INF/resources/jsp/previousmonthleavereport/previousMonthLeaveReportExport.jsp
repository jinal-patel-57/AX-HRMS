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
                    </div>
                </div>

                <div class="col-md-4 col-sm-12">
                    <div class="form-group">
                        <label>To Date</label>
                        <input type="date"
                               class="form-control"
                               id="toDate"
                               name="<portlet:namespace/>toDate">

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

    $(function () {
        $("#previousMonth").on("change", function () {
            if (this.checked) {
                $("#fromDate, #toDate").prop("disabled", true);
            } else {
                $("#fromDate, #toDate").prop("disabled", false);
            }
        });
    });
</script>