<%@ include file="/init.jsp" %>

<portlet:renderURL var="homeUrl"/>

<div class="card">
    <div class="card-header"><strong>View Appraisal Form Template</strong></div>
    <div class="card-body">
        <div class="row">
            <div class="col-md-4 col-sm-12 mb-3">
                <p class="text-center my-0"><b><liferay-ui:message key="template-id-text"/></b></p>

                <p class="text-center my-0">${appraisalFormTemplate.appraisalFormTemplateId }</p>
            </div>
            <div class="col-md-4 col-sm-12 mb-3">
                <p class="text-center my-0"><b><liferay-ui:message key="template-name-text"/></b></p>

                <p class="text-center my-0">${appraisalFormTemplate.templateName }</p>
            </div>
            <div class="col-md-4 col-sm-12 mb-3">
                <p class="text-center my-0"><b><liferay-ui:message key="file-name-text"/></b></p>

                <p class="text-center my-0">${appraisalFormTemplate.fileName }</p>
            </div>
            <div class="col-md-4 col-sm-12 mb-3">
                <p class="text-center my-0"><b><liferay-ui:message key="level-text"/></b></p>

                <p class="text-center my-0">${appraisalFormTemplate.templateLevelName }</p>
            </div>
            <div class="col-md-4 col-sm-12 mb-3">
                <p class="text-center my-0"><b><liferay-ui:message key="year-text"/> </b></p>

                <p class="text-center my-0">${appraisalFormTemplate.templateYear }</p>
            </div>
        </div>

    </div>
    <div class="card-footer text-right">
        <a href="${homeUrl }" class="btn btn-outline-danger"><liferay-ui:message key="back"></liferay-ui:message></a>
    </div>
</div>
