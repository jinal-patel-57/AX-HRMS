<%@ include file="/init.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<portlet:actionURL name="/addEditEmployeeExperienceURL" var="addEditEmployeeExperienceURL"/>
<form id="experienceStepperForm" action="${addEditEmployeeExperienceURL}"
      method="POST" enctype="multipart/form-data">
    <div class="card-header">
        <strong>
            <liferay-ui:message key="experience-details"/>
        </strong>
    </div>
    <div class="card-body">
        <c:if test="${employeeDetail.employeeType == 'intern' || employeeDetail.employeeType == 'contractor'}">
            <div class="alert alert-info">
                You are not required to fill this data! You can proceed with the further process!
            </div>
        </c:if>

        <c:if test="${employeeDetail.employeeType != 'intern' && employeeDetail.employeeType != 'contractor'}">
            <div id="experience-section-container">
                <c:if test="${experienceListSize <= 0 }">
                    <div class="experience-section">
                        <div class="card">
                            <div class="card-body">
                                <!-- Company Name -->
                                <div class="row">
                                    <div class="col-md-4 col-sm-12 mb-3">
                                        <div class="form-group">
                                            <label for="companyName1" class="form-label"> <liferay-ui:message
                                                    key="company-name"/><span class="text-danger">*</span>
                                            </label> <input type="text" class="form-control"
                                                            id="<portlet:namespace />companyName1"
                                                            name="<portlet:namespace />companyName1" maxlength="75"
                                                            required/>
                                        </div>
                                    </div>

                                    <!-- Row with Joining Date and Relieving Date -->
                                    <div class="col-md-4 col-sm-12 mb-3">

                                        <div class="form-group">
                                            <label for="joiningDate1" class="form-label"> <liferay-ui:message
                                                    key="joining-date"/><span class="text-danger">*</span>
                                            </label> <input type="date" class="form-control"
                                                            id="<portlet:namespace />joiningDate1"
                                                            name="<portlet:namespace />joiningDate1" required/>
                                        </div>
                                    </div>
                                    <div class="col-md-4 col-sm-12 mb-3">

                                        <div class="form-group">
                                            <label for="relievingDate1" class="form-label"> <liferay-ui:message
                                                    key="relieving-date"/><span class="text-danger">*</span>
                                            </label> <input type="date" class="form-control"
                                                            id="<portlet:namespace />relievingDate1"
                                                            name="<portlet:namespace />relievingDate1" required/>
                                        </div>
                                    </div>

                                    <!-- Experience Certificate Attachment -->
                                    <div class="col-md-4 col-sm-12 mb-3">

                                        <div class="form-group">
                                            <label for="experienceCertificateAttachment1"> <liferay-ui:message
                                                    key="experience-certificate-attachment"/><span class="text-danger">*</span>
                                            </label>
                                            <input id="<portlet:namespace />experienceCertificateAttachment1"
                                                   type="file"
                                                   name="<portlet:namespace />experienceCertificateAttachment1"
                                                   class="form-control"
                                                   required title="Please select a experience Certificate Attachment">
                                        </div>
                                    </div>

                                    <input type="hidden" id="firstVisit" name="<portlet:namespace/>firstVisit"
                                           value="true"/>
                                    <input type="hidden" id="currentIndex" name="<portlet:namespace/>currentIndex"
                                           value="1"/>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:if>
                <c:if test="${experienceListSize > 0 }">
                    <c:forEach items="${experienceList}" var="experienceItem" varStatus="status">

                        <div class="experience-section">
                            <div class="card">
                                <div class="card-body">
                                    <div class="row">
                                        <div class="col-md-4 col-sm-12 mb-3">
                                            <!-- Company Name -->
                                            <div class="form-group">
                                                <label for="companyName1" class="form-label"> <liferay-ui:message
                                                        key="company-name"/><span class="text-danger">*</span>
                                                </label> <input type="text" class="form-control"
                                                                id="<portlet:namespace />companyName${status.index+1}"
                                                                name="<portlet:namespace />companyName${status.index+1}"
                                                                maxlength="75"
                                                                value="${experienceItem.companyName}" required/>
                                            </div>
                                        </div>
                                        <div class="col-md-4 col-sm-12 mb-3">

                                            <div class="form-group">
                                                <label for="joiningDate1" class="form-label"> <liferay-ui:message
                                                        key="joining-date"/><span class="text-danger">*</span>
                                                </label> <input type="date" class="form-control"
                                                                id="<portlet:namespace />joiningDate${status.index+1}"
                                                                name="<portlet:namespace />joiningDate${status.index+1}"
                                                                value="<fmt:formatDate value='${experienceItem.joiningDate}' pattern='yyyy-MM-dd'/>"
                                                                required/>
                                            </div>
                                        </div>
                                        <div class="col-md-4 col-sm-12 mb-3">

                                            <div class="form-group">
                                                <label for="relievingDate1" class="form-label"> <liferay-ui:message
                                                        key="relieving-date"/><span class="text-danger">*</span>
                                                </label> <input type="date" class="form-control"
                                                                id="<portlet:namespace />relievingDate1"
                                                                name="<portlet:namespace />relievingDate1"
                                                                value="<fmt:formatDate value='${experienceItem.relievingDate}' pattern='yyyy-MM-dd'/>"
                                                                required/>
                                            </div>
                                        </div>
                                        <!-- Experience Certificate Attachment -->
                                        <div class="col-md-4 col-sm-12 mb-3">

                                            <div class="form-group">
                                                <label for="experienceCertificateAttachment1"> <liferay-ui:message
                                                        key="experience-certificate-attachment"/><span class="text-danger">*</span>
                                                </label>
                                                <input id="<portlet:namespace />experienceCertificateAttachment${status.index+1}"
                                                       type="file" value="${certificateMediaIdPath}" readonly
                                                       name="<portlet:namespace />experienceCertificateAttachment${status.index+1}"
                                                       class="form-control" required
                                                       title="Please select a experience Certificate Attachment">
                                            </div>
                                        </div>
                                    </div>

                                    <portlet:actionURL var="deleteEmployeeExperienceURL"
                                                       name="/deleteEmployeeExperienceURL">
                                        <portlet:param name="experienceId" value="${experienceItem.experienceId}"/>
                                    </portlet:actionURL>


                                    <input type="hidden" id="firstVisit" name="<portlet:namespace/>firstVisit"
                                           value="true"/>
                                    <input type="hidden" id="currentIndex" name="<portlet:namespace/>currentIndex"
                                           value="1"/>
                                </div>
                                <div class="card-footer text-right">
                                    <a href="${deleteEmployeeExperienceURL}" id="delete-experience-action-link"
                                       class="btn btn-outline-danger delete-section"><i class="icon-trash"></i></a>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </c:if>
                <button class="btn btn-danger delete-section d-none" type="button">Delete</button>
            </div>

            <!-- Plus button to add new experience sections -->
            <button class="btn btn-outline-success" type="button"
                    id="add-experience-section"><i class="icon-plus"></i>
            </button>
        </c:if>

        <input type="hidden" name="<portlet:namespace/>employeeId" value="${employeeId}">

        <!-- Navigation buttons -->
    </div>
    <div class="card-footer text-right align-items-center">

        <c:if test="${employeeDetail.employeeType != 'intern' && employeeDetail.employeeType != 'contractor'}">
            <button class="btn btn-outline-primary previous-button" type="button">Previous</button>
            <button class="btn btn-outline-primary next-button next-button-experience-details" type="button">Next
            </button>
        </c:if>

        <c:if test="${employeeDetail.employeeType == 'intern' || employeeDetail.employeeType == 'contractor'}">
            <button class="btn btn-outline-success" type="button" id="add-education-section" hidden="hidden"><i
                    class="icon-plus"></i>
            </button>
            <button class="btn btn-outline-primary previous-button" type="button">Previous</button>
            <button id="noactionbtnExperience" class="btn btn-outline-primary next-button"
                    type="button">Next
            </button>
        </c:if>


    </div>


</form>
<script>
    function addExperienceSection() {
        var config = new Object({}),
            namespace = '<portlet:namespace />';
        config.namespace = namespace;

        AxHrmsEmployeeOnboardingEmployeeWebPortlet.setConfigsForAddExperienceSection(config);
    }

    document.getElementById('add-experience-section').addEventListener('click', addExperienceSection);
</script> 