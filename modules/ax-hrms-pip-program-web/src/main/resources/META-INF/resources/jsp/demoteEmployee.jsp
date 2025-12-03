<%@ include file="/init.jsp" %>
<portlet:actionURL name="/demotePipEmployee" var="demoteEmployeeURL"/>
<portlet:renderURL var="backURL">
    <portlet:param name="mvcRenderCommandName" value="/" />
</portlet:renderURL>
<div class="card">
    <div class="card-header">
        <strong>Demote Employee</strong>
    </div>
    <form action="${demoteEmployeeURL}" method="post" id="demotionForm" onsubmit="check_pip_demotion_form()">

        <div class="card-body">
            <div class="row">
                <!-- Employee Dropdown --> <!-- Meeting Date -->
                <div class="col-md-4 col-sm-12">
                    <div class="form-group">
                        <label for="currentDesignation"><liferay-ui:message key="current-designation"/><span class="text-danger">*</span></label>
                        <input id="currentDesignation" placeholder="<liferay-ui:message key='meeting-date'/>"
                               class="form-control"
                               disabled type="text" name="<portlet:namespace/>currentDesignation"
                               value="${currentDesignation}"/>
                    </div>
                </div>

                <div class="col-md-4 col-sm-12">
                    <div class="form-group">
                        <label for="currentDesignation"><liferay-ui:message key="employee-name"/><span class="text-danger">*</span></label>
                        <input id="currentDesignation" placeholder="<liferay-ui:message key='meeting-date'/>"
                               class="form-control"
                               disabled type="text" name="<portlet:namespace/>currentDesignation"
                               value="${employeeName}"/>
                    </div>
                </div>

                <div class="col-md-4 col-sm-12">
                    <div class="form-group">
                        <label for="designationSelect"><liferay-ui:message key="select-updated-designation"/><span class="text-danger">*</span></label>
                        <select id="designationSelect" class="form-control"
                                name="<portlet:namespace/>designationSelect">
                            <!-- Populate this dropdown with employee options -->
                            <option value="">-- Select Designation --</option>
                            <!-- Example static options; dynamically generated options should be here -->
                            <c:forEach var="designation" items="${designationList}">
                                <option value="${designation.designationMasterId}">${designation.designationName}</option>
                            </c:forEach>
                        </select>
                        <label id="designationSelect-error" class="error text-danger" for="designationSelect"></label>
                    </div>
                </div>

                <input type="hidden" id="pipProgramId" name="<portlet:namespace />pipProgramId"
                       value="${pipProgramId}"/>

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
        AxPipProgramWebPortlet.setConfigs(config);
    });
</script>