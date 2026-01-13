
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<portlet:resourceURL var="downloadURL" id="/leave_balance/export" />

<div class="container-fluid">

    <!-- Heading -->
    <div class="row mb-4">
        <div class="col-12">
            <h4 class="font-weight-bold">
                Leave Balance Report
            </h4>
            <p class="text-muted mb-0">
                Download employee leave balance in Excel format
            </p>
        </div>
    </div>

    <!-- Filter Card -->
    <div class="card">
        <div class="card-body">

            <form method="post" action="${downloadURL}">

                <!-- Employee Selection -->
                <div class="form-group row">
                    <label class="col-md-3 col-form-label">
                        Employee
                    </label>
                    <div class="col-md-9">

                        <div class="custom-control custom-radio custom-control-inline">
                            <input type="radio"
                                   id="allEmployees"
                                   name="<portlet:namespace/>employeeType"
                                   value="ALL"
                                   class="custom-control-input"
                                   checked
                                   onclick="toggleEmployeeSelect(false)">
                            <label class="custom-control-label" for="allEmployees">
                                All Employees
                            </label>
                        </div>

                        <div class="custom-control custom-radio custom-control-inline">
                            <input type="radio"
                                   id="specificEmployees"
                                   name="<portlet:namespace/>employeeType"
                                   value="SPECIFIC"
                                   class="custom-control-input"
                                   onclick="toggleEmployeeSelect(true)">
                            <label class="custom-control-label" for="specificEmployees">
                                Specific Employee(s)
                            </label>
                        </div>

                        <select class="form-control mt-3"
                                id="employeeIds"
                                name="<portlet:namespace/>employeeIds"
                                multiple
                                disabled>
                            <c:forEach var="employee" items="${employeeList}">
                                <option value="${employee.getEmployeeId()}">
                                       ${employee.getEmployeeCode() }: ${employee.getFirstName()} ${employee.getLastName() }
                                </option>
                            </c:forEach>
                        </select>

                        <small class="form-text text-muted">
                            Hold <strong>Ctrl</strong> (Windows) or <strong>Cmd</strong> (Mac) to select multiple employees
                        </small>

                    </div>
                </div>

                <div class="form-group row">
                    <label class="col-md-3 col-form-label">
                        Year
                    </label>
                    <div class="col-md-9">
						<select class="form-control mt-3"
                                id="year"
                                name="<portlet:namespace/>year">
                            <c:forEach var="year" items="${yearList}">
                                <option value="${year}">
                                       ${year}
                                </option>
                            </c:forEach>
                        </select>
                    </div>
                </div>

                <div class="form-group row mb-0">
                    <div class="col-md-9 offset-md-3">
                        <button type="submit" class="btn btn-primary">
                            Download Excel
                        </button>
                    </div>
                </div>

            </form>

        </div>
    </div>

</div>

<script>
    function toggleEmployeeSelect(enable) {
        document.getElementById("employeeIds").disabled = !enable;
    }
</script>
