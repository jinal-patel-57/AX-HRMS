<%@ include file="/init.jsp" %>


<%--Liferay Urls start here--%>
<portlet:renderURL var="addAppraisalFormTemplateRenderURL">
    <portlet:param name="mvcRenderCommandName" value="/jsp/appraisal-form-templates/addAppraisalFormTemplate.jsp"/>
</portlet:renderURL>
<%--Liferay Urls end here--%>

<%--SESSION_MESSAGES Start Here--%>
<liferay-ui:success key="add-form-template-successfully" message="add-form-template-successfully"/>
<liferay-ui:success key="appraisal-form-updated-successfully" message="appraisal-form-updated-successfully"/>
<liferay-ui:error key="appraisal-form-not-added" message="appraisal-form-not-added"/>
<liferay-ui:error key="appraisal-form-not-updated" message="appraisal-form-not-updated"/>
<liferay-ui:success key="delete-appraisal-form-template" message="delete-appraisal-form-template"/>
<%--SESSION_MESSAGES End Here--%>
<div class="card">
    <div class="card-header d-flex justify-content-between align-items-center">
        <strong><liferay-ui:message key="list-of-appraisal-form-template-heading"/></strong>
        <a href="${addAppraisalFormTemplateRenderURL}" class="btn btn-primary"><liferay-ui:message
                key="add-button-text"/></a>
    </div>
    <div class="card-body">

        <%--            //Add Appraisal Form Template button here--%>
        <liferay-portlet:renderURL varImpl="iteratorURL"/>

        <liferay-ui:search-container total="${ totalAppraisalFormTemplates}" delta="3"
                                     emptyResultsMessage="no-appraisal-form-template-found"
                                     iteratorURL="${iteratorURL}">
            <liferay-ui:search-container-results results="${ appraisalFormTemplateList}"/>

            <liferay-ui:search-container-row className="com.ax.hrms.model.AppraisalFormTemplates"
                                             modelVar="appraisalFormTemplate" keyProperty="appraisalFormTemplateId">

                <liferay-ui:search-container-column-text name="Template Id"
                                                         value="${ appraisalFormTemplate.appraisalFormTemplateId }"></liferay-ui:search-container-column-text>
                <liferay-ui:search-container-column-text name="Appraisal Form Template Name"
                                                         value="${ appraisalFormTemplate.templateName }"></liferay-ui:search-container-column-text>
                <liferay-ui:search-container-column-text name="Year Of Template"
                                                         value="${ appraisalFormTemplate.templateYear }"></liferay-ui:search-container-column-text>
                <liferay-ui:search-container-column-text name="Template Level"
                                                         value="${ appraisalFormTemplate.templateLevelName }"></liferay-ui:search-container-column-text>
                <liferay-ui:search-container-column-text name="File Name"
                                                         value="${ appraisalFormTemplate.fileName }"></liferay-ui:search-container-column-text>

                <liferay-ui:search-container-column-text name="Action">
                    <portlet:renderURL var="editAppraisalFormTemplate">
                        <portlet:param name="mvcRenderCommandName" value="/fetchDataInAppraisalFormTemplate"/>
                        <portlet:param name="appraisalFormTemplateId"
                                       value="${appraisalFormTemplate.appraisalFormTemplateId}"/>
                    </portlet:renderURL>
                    <portlet:renderURL var="viewAppraisalFormTemplate">
                        <portlet:param name="mvcRenderCommandName" value="/viewAppraisalFormTemplate"/>
                        <portlet:param name="appraisalFormTemplateId"
                                       value="${appraisalFormTemplate.appraisalFormTemplateId}"/>
                    </portlet:renderURL>
                    <portlet:actionURL name="/deleteAppraisalFormTemplate" var="deleteUrl">
                        <portlet:param name="appraisalFormTemplateId" value="APPRAISAL_FORM_TEMPLATE_ID"/>
                        <portlet:param name="iteratorUrl" value="${iteratorURL }"/>
                    </portlet:actionURL>




                    <div class="dropdown ">
                        <button class="btn fa fa-ellipsis-v dropdown-toggle"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <i class="icon-ellipsis-vertical"></i>
                        </button>
                        <ul class="dropdown-menu">
                            <li><a href="${viewAppraisalFormTemplate }" class="dropdown-item "><i class="icon-eye-open"></i> <liferay-ui:message
                                    key="view" /></a></li>
                            <li><a href="${editAppraisalFormTemplate }" class=" dropdown-item"><i class="icon-edit"></i> <liferay-ui:message
                                    key="edit" /></a></li>
                            <li><a class="dropdown-item"
                                   onclick="deleteAction(${appraisalFormTemplate.appraisalFormTemplateId})"><i class="icon-trash"></i> <liferay-ui:message
                                    key="delete" /></a></li>
                        </ul>
                    </div>



                </liferay-ui:search-container-column-text>

            </liferay-ui:search-container-row>

            <liferay-ui:search-iterator markupView="lexicon" paginate="true"/>
        </liferay-ui:search-container>
    </div>
</div>

<script>
    function deleteAction(appraisalFormTemplateId) {
        var config = new Object({}),
            namespace = '<portlet:namespace />';

        config.namespace = namespace;
        config.deleteUrl = '${deleteUrl}';
        config.appraisalFormTemplateId = appraisalFormTemplateId;

        AXHrmsHrAppraisalFormTemplatesWebPortlet.setConfigsForDeleteAppraisalFormTemplate(config);
    }
</script>