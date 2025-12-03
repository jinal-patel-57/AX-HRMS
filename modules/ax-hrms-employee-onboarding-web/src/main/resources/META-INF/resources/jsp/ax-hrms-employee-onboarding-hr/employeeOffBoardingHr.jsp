<%@ include file="/init.jsp" %>
<portlet:actionURL name="/employeeOffBoardingHr" var="employeeOffBoardingHrURL"/>
<portlet:renderURL var="backURL">
    <portlet:param name="mvcRenderCommandName" value="/"/>
</portlet:renderURL>

<liferay-ui:success key="draft-saved" message="draft-saved"
/>


<div class="card">
    <div class="card-header"><strong>Employee Off-Boarding HR</strong></div>
    <form action="${employeeOffBoardingHrURL}" method="post">

        <div class="card-body">
            <input type="hidden" name="<portlet:namespace/>employeeId" value="${employeeId}">
            <div class="row">
                <div class="col-md-6">
                    <div class="form-group">
                        <div class="form-check mb-2">
                            <c:if test="${employeeOffBoarding.kt}">
                                <input class="form-check-input checkbox" type="checkbox" id="checkbox1"
                                       name="<portlet:namespace/>kt" checked>
                            </c:if>
                            <c:if test="${!employeeOffBoarding.kt}">
                                <input class="form-check-input checkbox" type="checkbox" id="checkbox1"
                                       name="<portlet:namespace/>kt">
                            </c:if>
                            <label class="form-check-label" for="checkbox1"><liferay-ui:message
                                    key='kt-doc-submitted'/></label>
                        </div>
                        <div class="form-check mb-2">
                            <c:if test="${employeeOffBoarding.nda}">
                                <input class="form-check-input checkbox" type="checkbox" id="checkbox2"
                                       name="<portlet:namespace/>nda" checked>
                            </c:if>
                            <c:if test="${!employeeOffBoarding.nda}">
                                <input class="form-check-input checkbox" type="checkbox" id="checkbox2"
                                       name="<portlet:namespace/>nda">
                            </c:if>
                            <label class="form-check-label" for="checkbox2"><liferay-ui:message
                                    key='nda-doc-siged'/></label>
                        </div>
                        <div class="form-check mb-2">
                            <c:if test="${employeeOffBoarding.assets}">
                                <input class="form-check-input checkbox" type="checkbox" id="checkbox3"
                                       name="<portlet:namespace/>asset" checked>
                            </c:if>
                            <c:if test="${!employeeOffBoarding.assets}">
                                <input class="form-check-input checkbox" type="checkbox" id="checkbox3"
                                       name="<portlet:namespace/>asset">
                            </c:if>
                            <label class="form-check-label" for="checkbox3"><liferay-ui:message
                                    key='assets-submitted'/></label>
                        </div>
                        <div class="form-check mb-2">
                            <c:if test="${employeeOffBoarding.mailAndBiometrics}">
                                <input class="form-check-input checkbox" type="checkbox" id="checkbox4"
                                       name="<portlet:namespace/>mailAndBiometrics" checked>
                            </c:if>
                            <c:if test="${!employeeOffBoarding.mailAndBiometrics}">
                                <input class="form-check-input checkbox" type="checkbox" id="checkbox4"
                                       name="<portlet:namespace/>mailAndBiometrics">
                            </c:if>
                            <label class="form-check-label" for="checkbox4"><liferay-ui:message key='plum'/></label>
                        </div>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="form-group">
                        <label for="fileUpload1"><liferay-ui:message key='exp-letter'/><span class="text-danger">*</span></label>
                        <input type="file" class="form-control-file file-upload" id="fileUpload1" disabled
                               name="<portlet:namespace/>file1">
                    </div>
                    <div class="form-group">
                        <label for="fileUpload2"><liferay-ui:message key='rel-letter'/><span class="text-danger">*</span></label>
                        <input type="file" class="form-control-file file-upload" id="fileUpload2" disabled
                               name="<portlet:namespace/>file2">
                    </div>
                    <div class="form-group">
                        <label for="fileUpload3"><liferay-ui:message key='full-final-letter'/><span class="text-danger">*</span></label>
                        <textarea class="form-control-file file-upload" id="fileUpload3" disabled rows="4"
                                  name="<portlet:namespace/>fullAndFinal">${fullAndFinalLetterFileName}</textarea>
                    </div>
                </div>
            </div>
            <div class="form-group">

            </div>
        </div>
        <div class="card-footer text-right align-items-center">
            <a href="${backURL}" class="btn btn-outline-danger"><liferay-ui:message key='back'/></a>
            <button type="submit" class="btn btn-outline-success" name="<portlet:namespace/>offBoard" value="offBoard"
                    id="offBoardBtn" disabled><liferay-ui:message key='off-board'/></button>
            <button type="submit" class="btn btn-outline-primary" id="saveDraftBtn" name="<portlet:namespace/>draft"
                    value="draft"><liferay-ui:message key='save-draft'/></button>
        </div>
    </form>

</div>


<script>
    $(document).ready(function () {
        var config = new Object({}),
            namespace = '<portlet:namespace />';

        config.namespace = namespace;
        config.experienceLetterFileName = '${experienceLetterFileName}';
        config.relievingLetterFileName = '${relievingLetterFileName}';
        <%--config.fullAndFinalLetterFileName = '${fullAndFinalLetterFileName}';--%>

        AxHrmsEmployeeOnboardingHrWebPortlet.setConfigsForValidation(config);
    });
</script>