<%@ include file="/init.jsp" %>
    <portlet:actionURL name="/addEditProjectTaskStatusMasterDetails" var="addEditProjectTaskStatusMaster">
    </portlet:actionURL>
    <portlet:renderURL var="projectTaskStatusMasterList">
        <portlet:param name="mvcRenderCommandName" value="/" />
    </portlet:renderURL>

    <liferay-ui:error key="error-already-exist" message="project-task-status-already-exist" />
    <liferay-ui:success key="success" message="project-task-status-success" />
    <liferay-ui:success key="success-delete" message="project-task-status-delete" />
    <liferay-ui:success key="success-edit" message="project-task-status-edit" />

<div class="card">
  <div class="card-header"><strong><liferay-ui:message key="add-project-task-status" /> </strong></div>
  <form action="${addEditProjectTaskStatusMaster}" method="post" id="projectTaskStatusForm">
  <div class="card-body mb-0">
        <input type="hidden" value="${projectTaskStatusMaster.projectTaskStatusMasterId}"
            name="<portlet:namespace/>projectTaskStatusMasterId">

        <div class="form-group">
            <label class="" for="projectTaskStatusName"><liferay-ui:message key="enter-a-project-status-name" /><span class="text-danger">*</span></label>
            <input id="projectTaskStatusName" placeholder="<liferay-ui:message key='enter-a-project-status-name'/>"
                class="form-control" type="text" name="<portlet:namespace/>projectTaskStatusName"
                value="${projectTaskStatusMaster.projectTaskStatusName} ${status}" />
            <label id="projectTaskStatusName-error" class="error text-danger" for="projectTaskStatusName"></label>
        </div>


        <div class="form-group">
            <div class="form-check form-check-inline">
                <input id="isApplicableForProject" class="form-check-input" type="checkbox"
                    name="<portlet:namespace/>isApplicableForProject" 
                    <c:if test="${projectTaskStatusMaster.isApplicableForProject}">
                        checked
                    </c:if>
                />
                <label class="form-check-label" for="isApplicableForProject">
                    <liferay-ui:message key="is-applicable-for-project" />
                </label>
            </div>
            <div class="form-check form-check-inline">
                <input id="isApplicableForTask" class="form-check-input" type="checkbox"
                    name="<portlet:namespace/>isApplicableForTask" 
                    <c:if test="${projectTaskStatusMaster.isApplicableForTask}">
                        checked
                    </c:if>
                />
                <label class="form-check-label" for="isApplicableForTask">
                    <liferay-ui:message key="is-applicable-for-task" />
                </label>
            </div>
        </div>
        
</div>
  <div class="card-footer text-right mb-0">
 <a href="${projectTaskStatusMasterList}" class="btn btn-outline-danger mr-1"><liferay-ui:message key="back" /></a>
            
                <button class="btn btn-outline-success " type="submit"><liferay-ui:message key="submit" /></button>

</div>
    </form>
</div>

  
       
               
    <script>
        $(document).ready(function () {
            var config = new Object({}),
                namespace = '<portlet:namespace />';

            config.namespace = namespace;

            AxHrmsProjectTaskStatusMasterWebPortlet.setConfigsForValidation(config);
        });	
    </script>