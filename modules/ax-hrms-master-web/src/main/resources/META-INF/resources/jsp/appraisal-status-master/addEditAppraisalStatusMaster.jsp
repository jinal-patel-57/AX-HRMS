<%@ include file="/init.jsp" %>
<portlet:actionURL name="/addEditAppraisalStatusMasterDetails" var="addEditAppraisalStatus" >
</portlet:actionURL>
<portlet:renderURL var="appraisalStatusMasterList">
	<portlet:param name="mvcRenderCommandName" value="/" />
</portlet:renderURL>

    <liferay-ui:success key="success" message="Appraisal Status Successfully Added!" />
    <liferay-ui:success key="success-edit" message="Appraisal Status Successfully Edited!" />
    <liferay-ui:error key="error-already-exist" message="Appraisal Status Already Exist!" />
    <liferay-ui:success key="success-delete" message="Appraisal Status Successfully Deleted!" />
    
    
    <div class="card">
  <div class="card-header"><strong> <liferay-ui:message key="add-appraisal-status"/>  </strong></div>
            <form action="${addEditAppraisalStatus}" method="post" id="appraisalStatusForm">
            <input type="hidden" value="${appraisalStatusMaster.appraisalStatusMasterId}" name="<portlet:namespace/>appraisalStatusMasterId">
  <div class="card-body mb-0">  <div class="form-group">
            <label class="" for="status"><liferay-ui:message key="enter-a-status"/><span class="text-danger">*</span></label>
            <input id="status" placeholder="<liferay-ui:message key='enter-a-status'/>" class="form-control" type="text"
                name="<portlet:namespace/>status" value="${appraisalStatusMaster.status} ${status}" />
            <label id="status-error" class="error text-danger" for="status"></label>
        </div>
        </div>
  <div class="card-footer text-right mb-0">
                <a href="${appraisalStatusMasterList}" class="btn btn-outline-danger mr-1"><liferay-ui:message key="back"/></a>
                <button class="btn btn-outline-success" type="submit"><liferay-ui:message key="submit"/></button>
        </div>
    </form>
</div>
            


      

        
  <script>
        $(document).ready(function () {
            var config = new Object({}),
                namespace = '<portlet:namespace />';
            config.namespace = namespace;
            AxHrmsAppraisalStatusMaster.setConfigsForValidation(config);
        });
</script>