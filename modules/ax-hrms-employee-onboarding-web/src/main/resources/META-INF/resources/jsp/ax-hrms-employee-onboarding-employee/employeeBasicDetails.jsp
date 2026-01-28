<%@ include file="/init.jsp" %>
<%@ page import="com.liferay.portal.kernel.repository.model.FileEntry" %>
<%@ page import="com.liferay.document.library.kernel.service.DLAppLocalServiceUtil" %>
<%@ page import="com.liferay.document.library.kernel.util.DLUtil" %>
<%@ page import="com.liferay.portal.kernel.theme.ThemeDisplay" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<portlet:actionURL name="/addEditEmployeeOnBoarding"
                   var="addEditEmployeeOnBoardingURL"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<form id="stepperForm" action="${addEditEmployeeOnBoardingURL}"
      method="post">

    <div class="card-header">
        <strong>
            <liferay-ui:message key="basic-details"/>
        </strong>
    </div>
    <div class="card-body">
        <!-- First Row: Personal Email, Date of Birth, Mobile No -->
        <div class="row mb-3">
            <div class="col-md-4 col-sm-12 mb-3">
                <label for="<portlet:namespace />personalEmail" class="form-label">
                    <liferay-ui:message key="personal-email"/><span class="text-danger">*</span>
                </label>
                <input type="email" class="form-control"
                       id="<portlet:namespace />personalEmail"
                       name="<portlet:namespace />personalEmail"
                       value="${employeeDetail.personalEmail}"/>
            </div>

            <div class="col-md-4 col-sm-12 mb-3">
                <label for="<portlet:namespace />dateOfBirth" class="form-label">
                    <liferay-ui:message key="date-of-birth"/><span class="text-danger">*</span>
                </label>
                <input type="date" class="form-control"
                       id="<portlet:namespace />dateOfBirth"
                       name="<portlet:namespace />dateOfBirth"
                       value="<fmt:formatDate value='${employeeDetail.dateOfBirth}' pattern='yyyy-MM-dd'/>"/>
            </div>

            <div class="col-md-4 col-sm-12 mb-3">
                <label for="<portlet:namespace />mobileNo" class="form-label">
                    <liferay-ui:message key="mobile-no"/><span class="text-danger">*</span>
                </label>
                <input type="tel" class="form-control"
                       id="<portlet:namespace />mobileNo"
                       name="<portlet:namespace />mobileNo" maxlength="10" inputmode="numeric" pattern="[0-9]{10}"
                       value="${employeeDetail.mobileNo}"/>
            </div>

            <!-- Second Row: Skype ID and Father's Name -->
            <!-- <div class="col-md-4 col-sm-12 mb-3">
                <label for="<portlet:namespace />skypeId" class="form-label">
                    <liferay-ui:message key="skype-id"/><span class="text-danger">*</span>
                </label>
                <input type="text" class="form-control"
                       id="<portlet:namespace />skypeId"
                       name="<portlet:namespace />skypeId"
                       value="${employeeDetail.skypeId}"/>
            </div> -->
            <div class="col-md-4 col-sm-12 mb-3">
                <label for="<portlet:namespace />fatherName" class="form-label">
                    <liferay-ui:message key="father-name"/><span class="text-danger">*</span>
                </label>
                <input type="text" class="form-control"
                       id="<portlet:namespace />fatherName"
                       name="<portlet:namespace />fatherName"
                       value="${employeeDetail.fatherName}" maxlength="50"/>
            </div>





            <div class="col-md-4 col-sm-12 mb-3">
                <label for="<portlet:namespace />aadharNumber" class="form-label">
                    <liferay-ui:message key="aadhar-number"/><span class="text-danger">*</span>
                </label>
                <input type="text" class="form-control"
                       id="<portlet:namespace />aadharNumber"
                       name="<portlet:namespace />aadharNumber"
                       value="${employeeDetail.aadhaarCardNumber}" maxlength="12"/>
            </div>



            <div class="col-md-4 col-sm-12 mb-3">
                <label for="<portlet:namespace />panNumber" class="form-label">
                    <liferay-ui:message key="pan-number"/><span class="text-danger">*</span>
                </label>
                <input type="text" class="form-control"
                       id="<portlet:namespace />panNumber"
                       name="<portlet:namespace />panNumber"
                       value="${employeeDetail.panCardNumber}" maxlength="10"/>
            </div>

        <div class="col-md-4 col-sm-12 mb-3">
                <label for="<portlet:namespace />nameAsPerAadhaarCard" class="form-label">
                    <liferay-ui:message key="nameAsPerAadhaarCard"/><span class="text-danger">*</span>
                </label>
                <input type="text" class="form-control"
                       id="<portlet:namespace />nameAsPerAadhaarCard"
                       name="<portlet:namespace />nameAsPerAadhaarCard"
                       value="${employeeDetail.nameAsPerAadhaarCard}" maxlength="50"/>
            </div>


            <!-- Fourth Row: Employee Profile Picture -->
            <div class="col-md-4 col-sm-12 mb-3">
                <label for="employeeProfilePicture" class="form-label">
                    <liferay-ui:message key="employee-profile-picture"/><span class="text-danger">*</span>
                </label>
                <input id="<portlet:namespace />employeeProfilePicture" type="file"
                       value="${profilePicName}"
                       name="<portlet:namespace />employeeProfilePicture"

                       class="form-control"
                       accept="image/*" >

                       <c:if test="${employeeDetail.profilePicId > 0}">
                                      <%
                                          com.ax.hrms.model.EmployeeDetails edu =
                                              (com.ax.hrms.model.EmployeeDetails) request.getAttribute("employeeDetail");

                                          long fileEntryId = edu.getProfilePicId();
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
                                                  e.printStackTrace();
                                              }
                                          }
                                      %>

                                      <a target="_blank" href="<%= previewURL %>">View Profile Picture</a>
                                  </c:if>




            </div>
            <!-- adding aadhaar card and pan card filed here -->
            <!-- Aadhaar Card -->
            <div class="col-md-4 col-sm-12 mb-3">
                <label class="form-label">
                    Aadhaar Card <span class="text-danger">*</span>
                </label>

                <input type="file"
                       class="form-control"
                       id="<portlet:namespace />aadhaarCard"
                       name="<portlet:namespace />aadhaarCard"
                       accept="application/pdf,image/*"
                       value="${aadhaarCardFileName}"/>

                <c:if test="${employeeDetail.aadhaarCardFileId > 0}">
                    <%
                        com.ax.hrms.model.EmployeeDetails edu =
                            (com.ax.hrms.model.EmployeeDetails) request.getAttribute("employeeDetail");

                        long fileEntryId = edu.getAadhaarCardFileId();
                        String previewURL = "";

                        if (fileEntryId > 0) {
                            try {
                                FileEntry fe = DLAppLocalServiceUtil.getFileEntry(fileEntryId);
                                ThemeDisplay td =
                                    (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

                                previewURL = DLUtil.getPreviewURL(
                                        fe,
                                        fe.getFileVersion(),
                                        td,
                                        ""
                                );
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    %>

                    <a target="_blank" href="<%= previewURL %>">View Aadhaar Card</a>
                </c:if>

            </div>


            <!-- PAN Card -->
           <div class="col-md-4 col-sm-12 mb-3">
               <label class="form-label">
                   PAN Card <span class="text-danger">*</span>
               </label>

               <input type="file"
                      class="form-control"
                      id="<portlet:namespace />panCard"
                      name="<portlet:namespace />panCard"
                      accept="application/pdf,image/*"
                      value="panCardFileName"/>

             <c:if test="${employeeDetail.panCardFileId > 0}">
                 <%
                     com.ax.hrms.model.EmployeeDetails edu =
                         (com.ax.hrms.model.EmployeeDetails) request.getAttribute("employeeDetail");

                     long fileEntryId = edu.getPanCardFileId();
                     String previewURL = "";

                     if (fileEntryId > 0) {
                         try {
                             FileEntry fe = DLAppLocalServiceUtil.getFileEntry(fileEntryId);
                             ThemeDisplay td =
                                 (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

                             previewURL = DLUtil.getPreviewURL(
                                     fe,
                                     fe.getFileVersion(),
                                     td,
                                     ""
                             );
                         } catch (Exception e) {
                             e.printStackTrace();
                         }
                     }
                 %>

                 <a target="_blank" href="<%= previewURL %>">View PAN Card</a>
             </c:if>

           </div>




            <!-- end here that field -->
            <!-- Third Row: Marital Status, Marriage Date, and Spouse Name -->
            <div class="col-md-4 col-sm-12 mb-3">
                <label class="form-label"></label>
                <div class="form-check mt-2">
                    <input type="checkbox" class="form-check-input"
                           id="<portlet:namespace />maritalStatus"
                           name="<portlet:namespace />maritalStatus" value="true"
                    ${employeeDetail.maritalStatus ? 'checked' : ''} />
                    <label class="form-check-label" for="<portlet:namespace />maritalStatus">
                        <liferay-ui:message key="married"/>
                    </label>
                </div>
            </div>

            <div class="col-md-4 col-sm-12 mb-3">
                <label for="<portlet:namespace />marriageDate" class="form-label">
                    <liferay-ui:message key="marriage-date"/>
                </label>
                <input type="date" class="form-control"
                       id="<portlet:namespace />marriageDate"
                       name="<portlet:namespace />marriageDate"
                       value="<fmt:formatDate value='${employeeDetail.marriageDate}' pattern='yyyy-MM-dd'/>"/>
            </div>

            <div class="col-md-4 col-sm-12 mb-3">
                <label for="<portlet:namespace />spouseName" class="form-label">
                    <liferay-ui:message key="spouse-name"/>
                </label>
                <input type="text" class="form-control"
                       id="<portlet:namespace />spouseName"
                       name="<portlet:namespace />spouseName"
                       value="${employeeDetail.spouseName}" maxlength="50"/>
            </div>


        </div>

        <c:if test="${isHrStatus}">
            <!-- HR Specific Fields -->
            <div class="row">
                <div class="col-md-4 col-sm-12 mb-3">
                    <!-- Employee Code -->
                    <label class="" for="employeeCode"><liferay-ui:message key="employee-code"/><span class="text-danger">*</span></label>
                    <input id="employeeCode" placeholder="<liferay-ui:message key='employee-code'/>"
                           class="form-control" type="text"
                           name="<portlet:namespace/>employeeCode"
                           value='${employeeDetail.employeeCode}'/>
                    <label id="employeeCode-error" class="error text-danger" for="employeeCode"></label>
                </div>

                <div class="col-md-4 col-sm-12 mb-3">
                    <!-- First Name -->
                    <label class="" for="firstName"><liferay-ui:message key="first-name"/><span class="text-danger">*</span></label>
                    <input id="firstName" placeholder="<liferay-ui:message key='first-name'/>"
                           class="form-control" type="text"
                           name="<portlet:namespace/>firstName"
                           value='${employeeDetail.firstName}'/>
                    <label id="firstName-error" class="error text-danger" for="firstName"></label>
                </div>

                <div class="col-md-4 col-sm-12 mb-3">
                    <!-- Last Name -->
                    <label class="" for="lastName"><liferay-ui:message key="last-name"/><span class="text-danger">*</span></label>
                    <input id="lastName" placeholder="<liferay-ui:message key='last-name'/>"
                           class="form-control" type="text"
                           name="<portlet:namespace/>lastName"
                           value='${employeeDetail.lastName}'/>
                    <label id="lastName-error" class="error text-danger" for="lastName"></label>
                </div>

                <div class="col-md-4 col-sm-12 mb-3">
                    <!-- Middle Name -->
                    <label class="" for="middleName"><liferay-ui:message key="middle-name"/><span class="text-danger">*</span></label>
                    <input id="middleName" placeholder="<liferay-ui:message key='middle-name'/>"
                           class="form-control" type="text"
                           name="<portlet:namespace/>middleName"
                           value="${employeeUser.middleName}"/>
                    <label id="middleName-error" class="error text-danger" for="middleName"></label>
                </div>

                <div class="col-md-4 col-sm-12 mb-3">
                    <!-- Designation -->
                    <label class="" for="designation"><liferay-ui:message key="designation"/><span class="text-danger">*</span></label>
                    <select class="form-control" id="designation" name="<portlet:namespace/>designation">
                        <option><liferay-ui:message key="select-designation"/></option>
                        <c:forEach items="${designationMasterList}" var="designation">
                            <option value="${designation.designationMasterId}"
                                ${employeeDesignation.designationMasterId == designation.designationMasterId ? 'selected' : '' }>
                                    ${designation.designationName}
                            </option>
                        </c:forEach>
                    </select>
                    <label id="designation-error" class="error text-danger" for="designation"></label>
                </div>

                <div class="col-md-4 col-sm-12 mb-3">
                    <!-- Gender -->
                    <label class="" for="gender"><liferay-ui:message key="gender"/><span class="text-danger">*</span></label><br/>
                    <div class="d-flex c-gap-3 align-items-center">
                        <div class="form-check">
                            <input class="form-check-input" type="radio"
                                name="<portlet:namespace />gender" id="male" value="Male"
                                ${employeeDetail.gender == 'Male' ? 'checked' : '' }>
                            <label class="form-check-label" for="male"><liferay-ui:message key="male"/></label>
                        </div>
                        <div class="form-check">
                            <input class="form-check-input" type="radio"
                                name="<portlet:namespace />gender" id="female" value="Female"
                                ${employeeDetail.gender == 'Female' ? 'checked' : '' }>
                            <label class="form-check-label" for="female"><liferay-ui:message key="female"/></label>
                        </div>
                    </div>
                    <label id="gender-error" class="error text-danger" for="gender"></label>
                </div>

                <div class="col-md-4 col-sm-12 mb-3">
                    <!-- Is Experienced -->
                    <label class="" for="isExperienced"><liferay-ui:message key="is-experienced"/><span class="text-danger">*</span></label>
                    <div class="d-flex c-gap-3 align-items-center">
                        <div class="form-check">
                            <input class="form-check-input" type="radio"
                                name="<portlet:namespace />isExperienced" id="yes" value="Yes"
                               ${employeeDetail.isExperienced ? 'checked' : ''}
                            <label class="form-check-label" for="yes"><liferay-ui:message key="yes"/></label>
                        </div>
                        <div class="form-check">
                            <input class="form-check-input" type="radio"
                                name="<portlet:namespace />isExperienced" id="no" value="No"
                                ${!employeeDetail.isExperienced ? 'checked' : ''}>
                            <label class="form-check-label" for="no"><liferay-ui:message key="no"/></label>
                        </div>
                    </div>
                    <label id="isExperienced-error" class="error text-danger" for="isExperienced"></label>
                </div>
                <div class="col-md-4 col-sm-12">
                                    <div class="form-group">
                                        <label class="" for="experienceYear">
                                            <liferay-ui:message key="experience-year" />
                                            <span class="text-danger">*</span>
                                        </label>
                                        <input
                                            id="experienceYear"
                                            placeholder="Years Of Experience"
                                            class="form-control"
                                            type="text"
                                            name="<portlet:namespace/>experienceYear"
                                            value="${employeeDetail.getExperienceYears()}"


                                             />
                                        <label id="experienceYear-error"
                                               class="error text-danger"
                                               for="experienceYear"></label>
                                    </div>
                                </div>

                <div class="col-md-4 col-sm-12 mb-3">
                    <!-- Joining Date -->
                    <label class="" for="joiningDate"><liferay-ui:message key="joining-date"/><span class="text-danger">*</span></label>
                    <input id="joiningDate" placeholder="<liferay-ui:message key='joining-date'/>"
                           class="form-control" type="date"
                           name="<portlet:namespace/>joiningDate"
                           value="<fmt:formatDate value='${employeeDetail.joiningDate}' pattern='yyyy-MM-dd'/>"/>
                    <label id="joiningDate-error" class="error text-danger" for="joiningDate"></label>
                </div>
                <div class="col-md-4 col-sm-12 mb-3">
                    <!-- Gross Salary CTC PM -->
                    <label class="" for="grossSalaryCTCPM"><liferay-ui:message key="gross-salary-ctc-pm"/><span class="text-danger">*</span></label>
                    <input id="grossSalaryCTCPM" placeholder="<liferay-ui:message key='gross-salary-ctc-pm'/>"
                           class="form-control" type="text"
                           name="<portlet:namespace/>grossSalaryCTCPM"
                           value="${ctcPm}"
                           />
                    <label id="grossSalaryCTCPM-error" class="error text-danger" for="grossSalaryCTCPM"></label>
                </div>

                <div class="col-md-4 col-sm-12 mb-3">
                    <!-- Gross Salary CTC PA -->
                    <label class="" for="grossSalaryCTCPA"><liferay-ui:message key="gross-salary-ctc-pa"/><span class="text-danger">*</span></label>
                    <input id="grossSalaryCTCPA" placeholder="<liferay-ui:message key='gross-salary-ctc-pa'/>"
                           class="form-control" type="text"
                           name="<portlet:namespace/>grossSalaryCTCPA"
                           value="${ctcPa}" readonly />
                    <label id="grossSalaryCTCPA-error" class="error text-danger" for="grossSalaryCTCPA"></label>
                </div>

                <div class="col-md-4 col-sm-12 mb-3">
                    <!-- Department -->
                    <label class="" for="department"><liferay-ui:message key="department"/><span class="text-danger">*</span></label>
                    <select class="form-control" id="department" name="<portlet:namespace/>department">
                        <option value="" disabled selected><liferay-ui:message key="select-department"/></option>
                        <c:forEach items="${departmentMasterList}" var="department">
                            <option value="${department.departmentMasterId}"
                                ${departmentIds.contains(department.departmentMasterId) ? 'selected' : '' }>
                                    ${department.departmentName}
                            </option>
                        </c:forEach>
                    </select>
                    <label id="department-error" class="error text-danger" for="department"></label>
                </div>

                <!-- <div class="col-md-4 col-sm-12 mb-3">
                    
                    <label class="" for="gender"><liferay-ui:message key="gender"/><span class="text-danger">*</span></label><br/>
                    <div class="d-flex c-gap-3 align-items-center">
                        <div class="form-check">
                            <input class="form-check-input" type="radio"
                                name="<portlet:namespace />gender" id="male" value="Male"
                                ${employeeDetail.gender == 'Male' ? 'checked' : '' }>
                            <label class="form-check-label" for="male"><liferay-ui:message key="male"/></label>
                        </div>
                        <div class="form-check">
                            <input class="form-check-input" type="radio"
                                name="<portlet:namespace />gender" id="female" value="Female"
                                ${employeeDetail.gender == 'Female' ? 'checked' : '' }>
                            <label class="form-check-label" for="female"><liferay-ui:message key="female"/></label>
                        </div>
                    </div>
                    <label id="gender-error" class="error text-danger" for="gender"></label>
                </div> -->

                <div class="col-md-4 col-sm-12 mb-3">
                    <!-- Probation Status -->
                    <label class="" for="isProbationEnabled"><liferay-ui:message key="probation-status"/><span class="text-danger">*</span></label><br/>
                    <div class="d-flex c-gap-3 align-items-center">
                        <div class="form-check">
                            <input class="form-check-input" type="radio"
                                name="<portlet:namespace />isProbationEnabled" id="enabled" value="Enabled"
                                ${employeeDetail.isProbationEnabled == 'true' ? 'checked' : '' }>
                            <label class="form-check-label" for="enabled"><liferay-ui:message key="enabled"/></label>
                        </div>
                        <div class="form-check">
                            <input class="form-check-input" type="radio"
                                name="<portlet:namespace />isProbationEnabled" id="disabled" value="Disabled"
                                ${employeeDetail.isProbationEnabled  == 'false' ? 'checked' : '' }>
                            <label class="form-check-label" for="disabled"><liferay-ui:message key="disabled"/></label>
                        </div>
                    </div>
                </div>
         <div class="col-sm-12 col-md-4 col-lg-4">
                            <div class="form-group">
                                <label for="branchSelectBox">
                                    <liferay-ui:message key="branch" />
                                    <span class="text-danger">*</span>
                                </label>

                                <select id="branchSelectBox"
                                    name="<portlet:namespace/>branch"
                                    class="form-control custom-select mr-sm-2">

                                    <option value="">
                                        <liferay-ui:message key="Select Branch" />
                                    </option>

                                    <c:forEach var="branch" items="${branchMasterList}">
                                        <option value="${branch.branchMasterId}" ${branch.branchMasterId==employeeDetail.branchId? 'selected' : '' } >
                                            ${branch.branchName}
                                        </option>
                                    </c:forEach>

                                </select>
                            </div>
                        </div>
                <div class="col-sm-12 col-md-4 col-lg-4">
                    <div class="form-group">

                        <label for="managerSelectBox">
                            <liferay-ui:message key="manager" /><span class="text-danger">*</span>
                        </label>
                        <select id="managerSelectBox"
                                name="<portlet:namespace/>manager"
                                class="form-control custom-select mr-sm-2">

                            <option value="">
                                <liferay-ui:message key="select-manager"/>
                            </option>

                            <c:forEach var="employee" items="${employeeDetailsList}">
                                <option value="${employee.getEmployeeId()}"       ${employee.getEmployeeId()==employeeDetail.getManagerId()? 'selected' : '' }>
                                    ${employee.firstName} ${employee.lastName}  (${employee.getEmployeeId()})
                                </option>
                            </c:forEach>

                        </select>

                    </div>
                </div>

            </div>
        </c:if>

        <input type="hidden" name="<portlet:namespace/>employeeId" value="${employeeId}">

    </div>
    <div class="card-footer text-right align-items-center">
        <button type="submit" class="btn btn-outline-primary next-button next-button-basic-details">Next</button>
    </div>
</form>
<script>
    var values = [];
    <c:forEach var = "i" items="${employeeDepartmentList}">
    values.push('${i.departmentMasterId}');
    </c:forEach>
    $('#department').val(values).trigger('change');

   var aadhaarCardId = ${employeeDetail.aadhaarCardFileId};
   var panCardId = ${employeeDetail.panCardFileId};
    var isHrStatus = ${isHrStatus ? 'true' : 'false'};



</script>

