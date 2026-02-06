<%@ include file="/init.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.liferay.portal.kernel.repository.model.FileEntry" %>
<%@ page import="com.liferay.document.library.kernel.service.DLAppLocalServiceUtil" %>
<%@ page import="com.liferay.document.library.kernel.util.DLUtil" %>
<%@ page import="com.liferay.portal.kernel.theme.ThemeDisplay" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>

<portlet:actionURL name="/addEditEmployeeEducationURL" var="addEditEmployeeEducationURL"/>

<form id="educationStepperForm"
      action="${addEditEmployeeEducationURL}"
      method="post"
      enctype="multipart/form-data"
      data-senna="off">

    <div class="card-header">
        <strong><liferay-ui:message key="education-details"/></strong>
    </div>

    <div class="card-body">

        <!-- Message for Intern / Contractor -->
        <c:if test="${employeeDetail.employeeType == 'contractor'}">
            <div class="alert alert-info">
                You are not required to fill this data! You can proceed to the next step.
            </div>
        </c:if>

        <c:if test="${employeeDetail.employeeType != 'contractor'}">

            <div id="education-section-container">

                <!-- ===================== -->
                <!-- CASE 1: NO EXISTING DATA -->
                <!-- ===================== -->
                <c:if test="${educationListSize <= 0}">
                    <div class="education-section" id="initial-education-section">
                        <div class="card">
                            <div class="card-body">

                                <div class="row">

                                    <!-- Level Name -->
                                    <div class="col-md-4 col-sm-12 mb-3">
                                        <label class="form-label">
                                            <liferay-ui:message key="level-name"/> <span class="text-danger">*</span>
                                        </label>

                                        <select id="<portlet:namespace/>levelName1"
                                                name="<portlet:namespace/>levelName1"
                                                class="form-select">
                                            <option value="">Select Level</option>

                                            <c:forEach var="educationLevelMaster" items="${educationLevelMastersList}">
                                                <option value="${educationLevelMaster.educationLevelMasterId}">
                                                    ${educationLevelMaster.levelName}
                                                </option>
                                            </c:forEach>
                                        </select>
                                    </div>

                                    <!-- Institution -->
                                    <div class="col-md-4 col-sm-12 mb-3">
                                        <label class="form-label">
                                            <liferay-ui:message key="Institution"/> <span class="text-danger">*</span>
                                        </label>
                                        <input type="text"
                                               class="form-control"
                                               id="<portlet:namespace/>institution1"
                                               name="<portlet:namespace/>institution1"
                                               maxlength="70"/>
                                    </div>

                                    <!-- Degree -->
                                    <div class="col-md-4 col-sm-12 mb-3">
                                        <label class="form-label">
                                            <liferay-ui:message key="Degree"/> <span class="text-danger">*</span>
                                        </label>
                                        <input type="text"
                                               class="form-control"
                                               id="<portlet:namespace/>degree1"
                                               name="<portlet:namespace/>degree1"
                                               maxlength="75"/>
                                    </div>

                                    <!-- Start Date -->
                                    <div class="col-md-4 col-sm-12 mb-3">
                                        <label class="form-label">
                                            <liferay-ui:message key="start-date"/> <span class="text-danger">*</span>
                                        </label>
                                        <input type="date"
                                               class="form-control"
                                               id="<portlet:namespace/>startDate1"
                                               name="<portlet:namespace/>startDate1"/>
                                    </div>

                                    <!-- End Date -->
                                    <div class="col-md-4 col-sm-12 mb-3">
                                        <label class="form-label">
                                            <liferay-ui:message key="end-date"/> <span class="text-danger">*</span>
                                        </label>
                                        <input type="date"
                                               class="form-control"
                                               id="<portlet:namespace/>endDate1"
                                               name="<portlet:namespace/>endDate1"/>
                                    </div>

                                    <!-- Certificate Attachment -->
                                    <div class="col-md-4 col-sm-12 mb-3">
                                        <label class="form-label">
                                            <liferay-ui:message key="education-certificate-attachment"/><span class="text-danger">*</span>
                                        </label>

                                        <input type="file"
                                               class="form-control"
                                               id="<portlet:namespace/>educationCertificateAttachment1"
                                               data-existing-file-id="0"
                                               name="<portlet:namespace/>educationCertificateAttachment1" />
                                    </div>

                                    <!-- Passing Year -->
                                    <div class="col-md-4 col-sm-12 mb-3">
                                        <label class="form-label">
                                            <liferay-ui:message key="passing-year"/> <span class="text-danger">*</span>
                                        </label>
                                        <input type="text"
                                               class="form-control"
                                               id="<portlet:namespace/>passingYear1"
                                               name="<portlet:namespace/>passingYear1"
                                               maxlength="4"
                                               readonly/>
                                    </div>

                                    <input type="hidden"
                                           id="educationCurrentIndex"
                                           name="<portlet:namespace/>educationCurrentIndex"
                                           value="1"/>

                                    <input type="hidden"
                                           id="firstVisitEducation"
                                           name="<portlet:namespace/>firstVisitEducation"
                                           value="true"/>

                                </div>
                            </div>
                        </div>
                    </div>
                </c:if>

                <!-- ===================== -->
                <!-- CASE 2: EXISTING RECORDS -->
                <!-- ===================== -->
                <c:if test="${educationListSize > 0}">
                    <c:forEach var="educationItem" items="${educationList}" varStatus="status">



                        <div class="education-section" id="initial-education-section">
                            <div class="card">
                                <div class="card-body">

                                    <div class="row">

                                        <!-- Level Name -->
                                        <div class="col-md-4 col-sm-12 mb-3">
                                            <label class="form-label">
                                                <liferay-ui:message key="level-name"/> <span class="text-danger">*</span>
                                            </label>

                                            <select id="<portlet:namespace/>levelName${status.index+1}"
                                                    name="<portlet:namespace/>levelName${status.index+1}"
                                                    class="form-select">
                                                <option value="">Select Level</option>

                                                <c:forEach var="educationLevelMaster" items="${educationLevelMastersList}">
                                                    <option value="${educationLevelMaster.educationLevelMasterId}"
                                                            ${educationItem.levelId == educationLevelMaster.educationLevelMasterId ? 'selected' : ''}>
                                                        ${educationLevelMaster.levelName}
                                                    </option>
                                                </c:forEach>
                                            </select>
                                        </div>

                                        <!-- Institution -->
                                        <div class="col-md-4 col-sm-12 mb-3">
                                            <label class="form-label">
                                                <liferay-ui:message key="Institution"/> <span class="text-danger">*</span>
                                            </label>
                                            <input type="text"
                                                   class="form-control"
                                                   id="<portlet:namespace/>institution${status.index+1}"
                                                   name="<portlet:namespace/>institution${status.index+1}"
                                                   value="${educationItem.institution}"
                                                   maxlength="250"/>
                                        </div>

                                        <!-- Degree -->
                                        <div class="col-md-4 col-sm-12 mb-3">
                                            <label class="form-label">
                                                <liferay-ui:message key="Degree"/> <span class="text-danger">*</span>
                                            </label>
                                            <input type="text"
                                                   class="form-control"
                                                   id="<portlet:namespace/>degree${status.index+1}"
                                                   name="<portlet:namespace/>degree${status.index+1}"
                                                   value="${educationItem.degree}"
                                                   maxlength="75"/>
                                        </div>

                                        <!-- Start Date -->
                                        <div class="col-md-4 col-sm-12 mb-3">
                                            <label class="form-label"><liferay-ui:message key="start-date"/></label>
                                            <input type="date"
                                                   class="form-control"
                                                   id="<portlet:namespace/>startDate${status.index+1}"
                                                   name="<portlet:namespace/>startDate${status.index+1}"
                                                   value="<fmt:formatDate value='${educationItem.startDate}' pattern='yyyy-MM-dd'/>"/>
                                        </div>

                                        <!-- End Date -->
                                        <div class="col-md-4 col-sm-12 mb-3">
                                            <label class="form-label"><liferay-ui:message key="end-date"/></label>
                                            <input type="date"
                                                   class="form-control"
                                                   id="<portlet:namespace/>endDate${status.index+1}"
                                                   name="<portlet:namespace/>endDate${status.index+1}"
                                                   value="<fmt:formatDate value='${educationItem.endDate}' pattern='yyyy-MM-dd'/>"/>
                                        </div>

                                        <!-- Attachment -->
                                        <div class="col-md-4 col-sm-12 mb-3">
                                            <label class="form-label">
                                                <liferay-ui:message key="education-certificate-attachment"/>
                                            </label>

                                            <input type="file"
                                                   class="form-control"
                                                   id="<portlet:namespace/>educationCertificateAttachment${status.index+1}"
                                                   data-existing-file-id="${educationItem.educationCertificateMediaId}"
                                                   name="<portlet:namespace/>educationCertificateAttachment${status.index+1}"/>

                                           <c:if test="${educationItem.educationCertificateMediaId > 0}">
                                                                                               <%
                                                                                                   com.ax.hrms.model.EmployeeEducation edu =
                                                                                                       (com.ax.hrms.model.EmployeeEducation) pageContext.findAttribute("educationItem");

                                                                                                   long fileEntryId = edu.getEducationCertificateMediaId();
                                                                                                   String previewURL = "";

                                                                                                   if (fileEntryId > 0) {
                                                                                                       try {
                                                                                                           FileEntry fe = DLAppLocalServiceUtil.getFileEntry(fileEntryId);
                                                                                                           ThemeDisplay td = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

                                                                                                           previewURL = DLUtil.getPreviewURL(
                                                                                                                   fe,
                                                                                                                   fe.getFileVersion(),
                                                                                                                   td,
                                                                                                                   ""
                                                                                                           );
                                                                                                       } catch (Exception e) {
                                                                                                           System.out.println("Inside exception -- " + e.getMessage());
                                                                                                       }
                                                                                                   }
                                                                                               %>

                                                                                               <a target="_blank" href="<%= previewURL %>">View Existing Attachment</a>
                                                                                           </c:if>
                                        </div>

                                        <!-- Passing Year -->
                                        <div class="col-md-4 col-sm-12 mb-3">
                                            <label class="form-label">
                                                <liferay-ui:message key="passing-year"/> <span class="text-danger">*</span>
                                            </label>
                                            <input type="text"
                                                   class="form-control"
                                                   id="<portlet:namespace/>passingYear${status.index+1}"
                                                   name="<portlet:namespace/>passingYear${status.index+1}"
                                                   value="${educationItem.passingYear}"
                                                   maxlength="4"
                                                   readonly/>
                                        </div>

                                        <input type="hidden"
                                               id="educationCurrentIndex"
                                               name="<portlet:namespace/>educationCurrentIndex"
                                               value="${status.index+1}"/>

                                        <input type="hidden"
                                               id="firstVisitEducation"
                                               name="<portlet:namespace/>firstVisitEducation"
                                               value="true"/>

                                    </div>
                                </div>

                                <!-- Delete Button -->
                                 <c:if test="${educationListSize > 1}">
                                <div class="card-footer text-right">
                                    <portlet:actionURL var="deleteEmployeeEducationURL"
                                                       name="/deleteEmployeeEducationURL">
                                        <portlet:param name="educationId" value="${educationItem.educationId}"/>
                                    </portlet:actionURL>

                                    <%-- <a href="#" data-url="${deleteEmployeeEducationURL}" data-education-id="${educationItem.educationId}"
                                       class="btn btn-outline-danger delete-section delete-education-btn">
                                        <i class="icon-trash"></i>
                                    </a> --%>

                                    <button
							            type="button"
							            class="btn btn-outline-danger delete-education-btn"
							            data-education-id="${educationItem.educationId}"
							            data-url="${deleteEmployeeEducationURL}" >
							            <i class="icon-trash"></i>
							        </button>

                                </div>
                                </c:if>

                            </div>
                        </div>

                    </c:forEach>
                </c:if>

            </div>

            <!-- Add New Section Button -->
            <button type="button" class="btn btn-outline-success" id="add-education-section">
                <i class="icon-plus"></i>
            </button>

        </c:if>

        <input type="hidden" name="<portlet:namespace/>employeeId" value="${employeeId}"/>

    </div>

    <!-- FOOTER BUTTONS -->
    <div class="card-footer text-right">

        <c:if test="${employeeDetail.employeeType != 'contractor'}">
            <button type="button" class="btn btn-outline-primary previous-button">Previous</button>
            <button type="button" class="btn btn-outline-primary next-button-education-details">Next</button>
        </c:if>

        <c:if test="${employeeDetail.employeeType == 'contractor'}">
            <button type="button" class="btn btn-outline-primary previous-button ">Previous</button>
            <button type="button" class="btn btn-outline-primary" id="noactionbtnEducation">Next</button>
        </c:if>

    </div>

</form>
