<%@ include file="/init.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="com.liferay.portal.kernel.repository.model.FileEntry" %>
<%@ page import="com.liferay.document.library.kernel.service.DLAppLocalServiceUtil" %>
<%@ page import="com.liferay.document.library.kernel.util.DLUtil" %>
<%@ page import="com.liferay.portal.kernel.theme.ThemeDisplay" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>

<portlet:actionURL name="/addEditEmployeeExperienceURL" var="addEditEmployeeExperienceURL"/>

<form id="experienceStepperForm"
      action="${addEditEmployeeExperienceURL}"
      method="POST"
      enctype="multipart/form-data"
      data-senna="off">

    <div class="card-header">
        <strong><liferay-ui:message key="experience-details"/></strong>
    </div>

    <div class="card-body">

        <!-- INTERN / CONTRACTOR -->
        <c:if test="${employeeDetail.employeeType == 'intern' || employeeDetail.employeeType == 'contractor'}">
            <div class="alert alert-info">
                You are not required to fill this data! You can proceed further.
            </div>
        </c:if>

        <!-- EMPLOYEE -->
        <c:if test="${employeeDetail.employeeType != 'intern' && employeeDetail.employeeType != 'contractor'}">

            <div id="experience-section-container">

                <!-- NO RECORD -->
                <c:if test="${experienceListSize <= 0}">
                    <div class="experience-section" id="initial-experience-section">
                        <div class="card">
                            <div class="card-body">
                                <div class="row">

                                    <div class="col-md-4 mb-3">
                                        <label><liferay-ui:message key="company-name"/> <span class="text-danger">*</span> </label>
                                        <input type="text" class="form-control"
                                               name="<portlet:namespace/>companyName1"/>
                                    </div>

                                    <div class="col-md-4 mb-3">
                                        <label><liferay-ui:message key="joining-date"/> <span class="text-danger">*</span> </label>
                                        <input type="date" class="form-control"
                                               name="<portlet:namespace/>joiningDate1"/>
                                    </div>

                                    <div class="col-md-4 mb-3">
                                        <label><liferay-ui:message key="relieving-date"/> <span class="text-danger">*</span> </label>
                                        <input type="date" class="form-control"
                                               name="<portlet:namespace/>relievingDate1"/>
                                    </div>

                                    <div class="col-md-4 mb-3">
                                        <label><liferay-ui:message key="experience-certificate-attachment"/><span class="text-danger">*</span> </label>
                                        <input type="file" class="form-control"
                                               name="<portlet:namespace/>experienceCertificateAttachment1"
                                               data-existing-file-id="0"
                                               accept="image/*,application/pdf"
                                               multiple/>
                                    </div>

                                    <input type="hidden" id="currentIndex"
                                           name="<portlet:namespace/>currentIndex" value="1"/>

                                    <input type="hidden" id="firstVisit"
                                           name="<portlet:namespace/>firstVisit" value="true"/>

                                </div>
                            </div>
                        </div>
                    </div>
                </c:if>

                <!-- EXISTING RECORDS -->









                <c:if test="${experienceListSize > 0}">
                    <c:forEach items="${experienceList}" var="experienceItem" varStatus="status">

                        <div class="experience-section"
                             data-experience-id="${experienceItem.experienceId}">
                            <div class="card">
                                <div class="card-body">
                                    <div class="row">

                                        <div class="col-md-4 mb-3">
                                            <label><liferay-ui:message key="company-name"/> <span class="text-danger">*</span> </label>
                                            <input type="text" class="form-control"
                                                   name="<portlet:namespace/>companyName${status.index+1}"
                                                   value="${experienceItem.companyName}"/>
                                        </div>

                                        <div class="col-md-4 mb-3">
                                            <label><liferay-ui:message key="joining-date"/> <span class="text-danger">*</span> </label>
                                            <input type="date" class="form-control"
                                                   name="<portlet:namespace/>joiningDate${status.index+1}"
                                                   value="<fmt:formatDate value='${experienceItem.joiningDate}' pattern='yyyy-MM-dd'/>"/>
                                        </div>

                                        <div class="col-md-4 mb-3">
                                            <label><liferay-ui:message key="relieving-date"/> <span class="text-danger">*</span> </label>
                                            <input type="date" class="form-control"
                                                   name="<portlet:namespace/>relievingDate${status.index+1}"
                                                   value="<fmt:formatDate value='${experienceItem.relievingDate}' pattern='yyyy-MM-dd'/>"/>
                                        </div>

                                        <!-- Attachment + Preview -->
                                        <div class="col-md-4 mb-3">
                                            <label><liferay-ui:message key="experience-certificate-attachment"/><span class="text-danger">*</span> </label>

                                            <input type="file" class="form-control"
                                                   name="<portlet:namespace/>experienceCertificateAttachment${status.index+1}"
                                                   accept="image/*,application/pdf"
                                                   data-existing-file-id="${experienceItem.experienceCertificateMediaId}"
                                                   multiple
                                                   />

                                            <c:if test="${not empty experienceItem.experienceCertificateMediaId}">
                                                  <%
                                                     com.ax.hrms.model.EmployeeExperience exp =
                                                         (com.ax.hrms.model.EmployeeExperience) pageContext.findAttribute("experienceItem");
                                                                 String mediaIds = exp.getExperienceCertificateMediaId();
                                                                  System.out.println("DEBUG: Media IDs from DB = " + mediaIds);
                                                                  if (mediaIds != null && !mediaIds.isEmpty()) {
                                                                     String[] fileEntryIds = mediaIds.split(",");

                                                     for (String idStr : fileEntryIds) {
                                                    try {
                                                            long fileEntryId = Long.parseLong(idStr.trim());
                                                            FileEntry fileEntry =
                                                                DLAppLocalServiceUtil.getFileEntry(fileEntryId);

                                                            String previewURL = DLUtil.getPreviewURL(
                                                                fileEntry,
                                                                fileEntry.getFileVersion(),
                                                                themeDisplay,
                                                                ""
                                                            );

                                                            System.out.println(
                                                                "DEBUG: File found → ID=" + fileEntryId +
                                                                ", Name=" + fileEntry.getFileName()
                                                            );

                                                 %>
                                                <div>
                                                    <a href="<%= previewURL %>" target="_blank">
                                                          <%= fileEntry.getFileName() %>
                                                    </a>
                                                </div>

                                                    <%
                                                                } catch (Exception e) {
                                                                    System.out.println(
                                                                        "ERROR: Unable to load fileEntryId=" + idStr
                                                                    );
                                                                    e.printStackTrace();
                                                                }
                                                            }
                                                        }
                                                    %>
                                            </c:if>
                                        </div>

                                        <input type="hidden" id="currentIndex"
                                               name="<portlet:namespace/>currentIndex"
                                               value="${status.index+1}"/>
                                    </div>
                                </div>

                                <!-- DELETE (EXISTING RECORD) -->
                                <c:if test="${experienceListSize > 1}">
                                <div class="card-footer text-right">
                                    <portlet:actionURL var="deleteEmployeeExperienceURL"
                                                       name="/deleteEmployeeExperienceURL">
                                        <portlet:param name="experienceId"
                                                       value="${experienceItem.experienceId}"/>
                                    </portlet:actionURL>

                                    <%-- <a href="${deleteEmployeeExperienceURL}"
                                       data-delete-url="${deleteEmployeeExperienceURL}"
                                       class="btn btn-outline-danger delete-section">
                                        <i class="icon-trash"></i>
                                    </a> --%>
                                    <button
							            type="button"
							            class="btn btn-outline-danger delete-experience-btn"
							            data-experience-id="${experienceItem.experienceId}"
							            data-url="${deleteEmployeeExperienceURL}" >
							            <i class="icon-trash"></i>
							        </button>
                                </div>
                                </c:if>

                            </div>
                        </div>

                    </c:forEach>

                </c:if>



























            </div>

            <button type="button" id="add-experience-section"
                    class="btn btn-outline-success">
                <i class="icon-plus"></i>
            </button>

        </c:if>


    </div>
    <input type="hidden"
         name="<portlet:namespace/>employeeId"
         value="${employeeDetail.employeeId}"/>

    <div class="card-footer text-right">
        <button type="button" class="btn btn-outline-primary previous-button">Previous</button>

        <c:if test="${employeeDetail.employeeType != 'intern' && employeeDetail.employeeType != 'contractor'}">
            <button type="button" class="btn btn-outline-primary next-button-experience-details">
                Next
            </button>
        </c:if>

        <c:if test="${employeeDetail.employeeType == 'intern' || employeeDetail.employeeType == 'contractor'}">
            <button type="button" id="noactionbtnExperience"
                    class="btn btn-outline-primary">
                Next
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

    const addExpBtn = document.getElementById('add-experience-section');
    if (addExpBtn) {
        addExpBtn.addEventListener('click', addExperienceSection);
    }

</script>