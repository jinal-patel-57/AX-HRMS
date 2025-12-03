<%@ include file="/init.jsp" %>
<portlet:actionURL name="/addPipProgramEmployee" var="addPipProgramEmployeeURL"/>
<portlet:actionURL name="/extendPipProgram" var="extendPipProgramEmployeeURL"/>

<portlet:renderURL var="backURL">
    <portlet:param name="mvcRenderCommandName" value="/" />
</portlet:renderURL>
<div class="card">
    <div class="card-header">
        <strong>
            Add PIP Employee Form
        </strong>
    </div>

    <c:if test="${pipProgram == null}">
    <form action="${addPipProgramEmployeeURL}" method="post" id="pipForm" onsubmit="check_pip_form()">
        </c:if>
        <c:if test="${pipProgram != null}">
        <form action="${extendPipProgramEmployeeURL}" method="post" id="pipForm" onsubmit="check_pip_form()">
            </c:if>
            <div class="card-body">
                <div class="row">
                    <div class="col-md-4 col-sm-12">
                        <!-- Employee Dropdown -->
                        <div class="form-group">
                            <label for="employee"><liferay-ui:message key="select-employee"/><span class="text-danger">*</span></label>
                            <select id="employee" class="form-control" name="<portlet:namespace/>employeeId">
                                <c:if test="${pipProgram == null}">
                                    <!-- Populate this dropdown with employee options -->
                                    <option value="">-- Select Employee --</option>
                                    <!-- Example static options; dynamically generated options should be here -->
                                    <c:forEach var="employee" items="${employeeList}">
                                        <option value="${employee.employeeId}">${employee.firstName} ${employee.lastName}</option>
                                    </c:forEach>
                                </c:if>
                                <c:if test="${pipProgram != null}">
                                    <option value="${pipProgram.employeeId}">${employeeName}</option>
                                </c:if>
                            </select>
                            <label id="employee-error" class="error text-danger" for="employee"></label>
                        </div>
                    </div>

                    <c:if test="${pipProgram == null}">
                        <div class="col-md-4 col-sm-12">
                            <!-- Start Date -->
                            <div class="form-group">
                                <label for="startDate"><liferay-ui:message key="start-date"/><span class="text-danger">*</span></label>
                                <input id="startDate" placeholder="<liferay-ui:message key='start-date'/>"
                                       class="form-control" type="date"
                                       name="<portlet:namespace/>startDate"/>
                                <label id="startDate-error" class="error text-danger" for="startDate"></label>
                            </div>
                        </div>
                    </c:if>
                    <c:if test="${pipProgram != null}">
                        <div class="col-md-4 col-sm-12">
                            <!-- Start Date -->
                            <div class="form-group">
                                <label for="startDate"><liferay-ui:message key="start-date"/><span class="text-danger">*</span></label>
                                <input id="startDate" placeholder="<liferay-ui:message key='start-date'/>"
                                       class="form-control" type="date"
                                       name="<portlet:namespace/>startDate" disabled
                                       value="<fmt:formatDate value='${pipProgram.endDate}' pattern='yyyy-MM-dd'/>"/>
                                <label id="startDate-error" class="error text-danger" for="startDate"></label>
                            </div>
                        </div>
                    </c:if>

                    <div class="col-md-4 col-sm-12">
                        <div class="form-group">
                            <label for="noOfMonths"><liferay-ui:message
                                    key="${pipProgram != null ? 'no-of-extended-months' : 'no-of-months'}"/><span class="text-danger">*</span></label>
                            <input type="number" id="noOfMonths" class="form-control" name="<portlet:namespace/>noOfMonths">
                               
                            <label id="noOfMonths-error" class="error text-danger" for="noOfMonths"></label>
                        </div>
                    </div>

                    <div class="col-md-4 col-sm-12">
                        <!-- Meeting Date -->
                        <div class="form-group">
                            <label for="meetingDate"><liferay-ui:message key="meeting-date"/><span class="text-danger">*</span></label>
                            <input id="meetingDate" placeholder="<liferay-ui:message key='meeting-date'/>"
                                   class="form-control" type="date"
                                   name="<portlet:namespace/>meetingDate"/>
                            <label id="meetingDate-error" class="error text-danger" for="meetingDate"></label>
                        </div>
                    </div>

                    <div class="col-md-4 col-sm-12">
                        <div class="form-group">
                            <label for="Improvement Areas"><liferay-ui:message key="improvement-areas"/></label>
                            <div id="sNote" class="summernote-container"></div>
                            <input type="hidden" id="comments" name="<portlet:namespace />comments"> </input>
                        </div>
                    </div>
                    <input type="hidden" id="pipProgramId" name="<portlet:namespace />pipProgramId"
                           value="${pipProgram.pipProgramId}"/>
                </div>
            </div>
            <div class="card-footer text-right align-items-center">
                <a class="btn btn-outline-danger" href="${backURL}"><liferay-ui:message key="back"/></a>
                <button class="btn btn-outline-success" type="submit"><liferay-ui:message key="submit"/></button>
            </div>
        </form>

</div>




<script>
    $(document).ready(function () {
        var config = new Object({}),
            namespace = '<portlet:namespace />';

        config.namespace = namespace;
        config.code = '${pipProgram.improvementAreas}';

        AxPipProgramWebPortlet.setConfigs(config);
    });
</script>