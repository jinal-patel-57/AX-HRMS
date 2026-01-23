<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<portlet:resourceURL var="downloadURL" id="/export/employeeDetails" />

<div class="card">
    <div class="card-body">

        <form method="post" action="${downloadURL}">

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
</script>