<%@ include file="/init.jsp" %>
<%--Liferay Urls start here--%>
<portlet:renderURL var="homeUrl"/>
<portlet:actionURL name="/addAppraisalFormTemplate" var="addAppraisalFormTemplateURL"></portlet:actionURL>
<%--Liferay Urls end here--%>

<%--SESSION_MESSAGES Start Here--%>
<liferay-ui:error key="existed-entry" message="existed-entry-message"/>
<%--SESSION_MESSAGES End Here--%>
<div class="card">
    <form action="${addAppraisalFormTemplateURL}" method="Post" enctype="multipart/form-data"   id="<portlet:namespace/>appraisalFormTemplateForm">
    <div class="card-header">
        <strong><liferay-ui:message key="appraisal-form-templates-form-heading"/></strong>
    </div>
    <div class="card-body">

        <div class="row">
            <input type="hidden" id="<portlet:namespace/>appraisalFormTemplateId"
                   name="<portlet:namespace/>appraisalFormTemplateId"
                   value="${appraisalFormTemplate.appraisalFormTemplateId}">
            <div class="col-md-4 col-sm-12 mb-3">
                <div class="form-group">
                    <label for="<portlet:namespace/>templateName"><liferay-ui:message
                            key="template-name-text"/><span class="text-danger">*</span></label>
                    <input type="text" id="<portlet:namespace/>templateName" name="<portlet:namespace/>templateName"
                           class="form-control"
                           value="${not empty existedFormTemplate ? existedFormTemplate.templateName : (not empty appraisalFormTemplate ? appraisalFormTemplate.templateName : '')}"/>
                </div>
            </div>
            <div class="col-md-4 col-sm-12 mb-3">
                <div class="form-group">
                    <label for="<portlet:namespace/>formTemplateFile"><liferay-ui:message
                            key="upload-appraisal-form-template-text"/><span class="text-danger">*</span></label>
                    <input type="file" id="<portlet:namespace/>formTemplateFile"
                           name="<portlet:namespace/>formTemplateFile"
                           class="form-control" value="${URL}" title="${fileName}"/>
                </div>
            </div>
            <div class="col-md-4 col-sm-12 mb-3">
                <div class="form-group">
                    <label for="<portlet:namespace/>level"><liferay-ui:message key="level-text"/><span class="text-danger">*</span></label>
                    <select id="<portlet:namespace/>level" class="form-control" name="<portlet:namespace/>level">
                        <option value=""><liferay-ui:message key="select-option"/></option>
                        <c:forEach var="templateLevelMaster" items="${templateLevelMasterList}">
                            <option value="${templateLevelMaster.templateLevelMasterId}" ${not empty existedFormTemplate ? (existedFormTemplate.templateLevelId == templateLevelMaster.templateLevelMasterId ? 'selected': '') : (not empty appraisalFormTemplate ? (appraisalFormTemplate.templateLevelId == templateLevelMaster.templateLevelMasterId ? 'selected': ''):'')}>${templateLevelMaster.levelName}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="col-md-4 col-sm-12 mb-3">
                <div class="form-group">
                    <label for="<portlet:namespace/>yearOfTemplate"><liferay-ui:message key="year-text"/><span class="text-danger">*</span></label>
                    <select id="<portlet:namespace/>yearOfTemplate" class="form-control"
                            name="<portlet:namespace/>yearOfTemplate">
                        <option value=""><liferay-ui:message key="select-option"/></option>
                    </select>
                </div>
            </div>
        </div>
    </div>
    <div class="card-footer text-right">
        <a href="${homeUrl}" class="btn btn-outline-danger"><liferay-ui:message key="back"/></a>
        <button type="submit" class="btn btn-outline-success"><liferay-ui:message key="submit-text"/></button>
    </div>
    </form>
</div>


<script>
    $(document).ready(function () {
        var config = {};
        config.namespace = '<portlet:namespace />';
        config.year = '${not empty existedFormTemplate ? (existedFormTemplate.templateYear) : (not empty appraisalFormTemplate ? appraisalFormTemplate.templateYear : "")}';
        config.fileName = '${not empty fileName ? fileName : ""}';
        config.filePath = '${not empty URL ? URL : ""}';

        AXHrmsHrAppraisalFormTemplatesWebPortlet.setConfigs(config);
        AXHrmsHrAppraisalFormTemplatesWebPortlet.setFileData(config);
    });
</script>