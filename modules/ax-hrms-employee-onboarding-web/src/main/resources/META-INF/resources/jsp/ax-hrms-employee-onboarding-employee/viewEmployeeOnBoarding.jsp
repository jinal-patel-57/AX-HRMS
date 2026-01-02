<%@page import="com.ax.hrms.model.Address"%>
<%@page import="com.liferay.portal.kernel.service.CountryLocalServiceUtil"%>
<%@ include file="/init.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<portlet:actionURL var="employeeApprovalUrl" name="/employeeApprovalUrl">
    <portlet:param name="employeeId" value="${employeeDetail.employeeId}"/>
</portlet:actionURL>

<portlet:actionURL var="employeeRejectUrl" name="/employeeRejectUrl">
    <portlet:param name="employeeId" value="${employeeDetail.employeeId}"/>
    <portlet:param name="review" value="REVIEW"/>
</portlet:actionURL>


<div class="card">
    <div class="card-header">
        <strong>
            Employee OnBoarding Details (Verification)
        </strong>
    </div>
    <div class="card-body">

        <div class="card">
            <div class="card-header">
                <strong>Basic Details</strong>
            </div>
            <div class="card-body">
                <div class="row">
                    <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 ">
                        <div class="form-group-view">
                            <div class="label-name">Employee ID</div>
                            <div class="label-content">${employeeDetail.employeeId}</div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 ">
                        <div class="form-group-view">
                            <div class="label-name">First Name</div>
                            <div class="label-content">${employeeDetail.firstName}</div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 ">
                        <div class="form-group-view">
                            <div class="label-name">Last Name</div>
                            <div class="label-content">${employeeDetail.lastName}</div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 ">
                        <div class="form-group-view">
                            <div class="label-name">Personal Email</div>
                            <div class="label-content">${employeeDetail.personalEmail}</div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 ">
                        <div class="form-group-view">
                            <div class="label-name">Date of Birth</div>
                            <div class="label-content">
                                <fmt:formatDate value='${employeeDetail.dateOfBirth}' pattern='dd-MM-yyyy'/>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 ">
                        <div class="form-group-view">
                            <div class="label-name">Mobile No.</div>
                            <div class="label-content">${employeeDetail.mobileNo}</div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 ">
                        <div class="form-group-view">
                            <div class="label-name">Reporting Manager</div>
                            <div class="label-content">${employeeDetail.reportingManager}</div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 ">
                        <div class="form-group-view">
                            <div class="label-name">Father Name</div>
                            <div class="label-content">${employeeDetail.fatherName}</div>
                        </div>
                    </div>
                  <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 ">
                      <div class="form-group-view">
                          <div class="label-name">Marital Status</div>
                          <div class="label-content">${employeeDetail.maritalStatus}</div>
                      </div>
                  </div>

                  <c:if test="${employeeDetail.maritalStatus}">
                      <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 ">
                          <div class="form-group-view">
                              <div class="label-name">Marriage Date</div>
                              <div class="label-content">
                                  <fmt:formatDate value="${employeeDetail.marriageDate}" pattern="dd-MM-yyyy"/>
                              </div>
                          </div>
                      </div>

                      <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 ">
                          <div class="form-group-view">
                              <div class="label-name">Spouse Name</div>
                              <div class="label-content">${employeeDetail.spouseName}</div>
                          </div>
                      </div>
                  </c:if>

                    <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 ">
                        <div class="form-group-view">
                            <div class="label-name">Official Email</div>
                            <div class="label-content">${employeeDetail.officialEmail}</div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 ">
                        <div class="form-group-view">
                            <div class="label-name">Gender</div>
                            <div class="label-content">${employeeDetail.gender}</div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 ">
                        <div class="form-group-view">
                            <div class="label-name">EmployeeType</div>
                            <div class="label-content">${employeeDetail.employeeType}</div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 ">
                        <div class="form-group-view">
                            <div class="label-name">Aadhaar Card File</div>
                            <div class="label-content">   <a target="_blank" href="${aadharCardFile}">View Aadhaar Card</a></div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 ">
                        <div class="form-group-view">
                            <div class="label-name">Pan Card File</div>
                            <div class="label-content">   <a target="_blank" href="${panCardFile}">View Pan Card</a></div>
                        </div>
                    </div>
                     <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 ">
                        <div class="form-group-view">
                            <div class="label-name">Profile Pic</div>
                            <div class="label-content">   <a target="_blank" href="${profilePic}">View Profile Pic</a></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>


        <div class="card">
            <div class="card-header">
                <strong>Address Details</strong>
            </div>
            <div class="card-body">

                    <div >
                        <strong> Present Address Details</strong>
                    </div>

                <div class="row">

                    <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 ">
                        <div class="form-group-view">
                            <div class="label-name">Address Line 1</div>
                            <div class="label-content">${presentaddresss.line1}</div>
                        </div>
                    </div>

                    <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 ">
                        <div class="form-group-view">
                            <div class="label-name">Address Line 2</div>
                            <div class="label-content">${presentaddresss.line2}</div>
                        </div>
                    </div>

                    <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 ">
                        <div class="form-group-view">
                            <div class="label-name">Address Line 3</div>
                            <div class="label-content">${presentaddresss.line3}</div>
                        </div>
                    </div>

                    <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 ">
                        <div class="form-group-view">
                            <div class="label-name">State</div>
                            <div class="label-content">${presentaddresss.state}</div>
                        </div>
                    </div>

                    <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 ">
                        <div class="form-group-view">
                            <div class="label-name">Country</div>
                            <div class="label-content">
                            	<%
								Address permanentaddresss = (Address) request.getAttribute("permanentaddresss");
								String permanentCountryName = "";
								%>
								
								<%
								if (permanentaddresss != null && permanentaddresss.getCountry() > 0) {
								    try {
								        permanentCountryName =
								            CountryLocalServiceUtil
								                .getCountry(permanentaddresss.getCountry())
								                .getName();
								    } catch (Exception ignored) {}
								}
								%>
								
								<%= permanentCountryName %>
							</div>
                        </div>
                    </div>

                    <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 ">
                        <div class="form-group-view">
                            <div class="label-name">Pin code</div>
                            <div class="label-content">${presentaddresss.pincode}</div>
                        </div>
                    </div>
                    </div>
                    <hr>

                    <c:if test="${employeeAddress.presentPermanentSame}">

                     <div >
                        <strong> Permanent Address Details</strong>
                    </div>
                    <div class="row">

                        <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 ">
                            <div class="form-group-view">
                                <div class="label-name">Address Line 1</div>
                                <div class="label-content">${presentaddresss.line1}</div>
                            </div>
                        </div>

                        <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 ">
                            <div class="form-group-view">
                                <div class="label-name">Address Line 2</div>
                                <div class="label-content">${presentaddresss.line2}</div>
                            </div>
                        </div>

                        <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 ">
                            <div class="form-group-view">
                                <div class="label-name">Address Line 3</div>
                                <div class="label-content">${presentaddresss.line3}</div>
                            </div>
                        </div>

                        <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 ">
                            <div class="form-group-view">
                                <div class="label-name">State</div>
                                <div class="label-content">${presentaddresss.state}</div>
                            </div>
                        </div>

                        <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 ">
                            <div class="form-group-view">
                                <div class="label-name">Country</div>
                                <div class="label-content">
                                <%
								Address presentaddresss = (Address) request.getAttribute("presentaddresss");
								String presentCountryName = "";
								%>
								
								<%
								if (presentaddresss != null && presentaddresss.getCountry() > 0) {
								    try {
								        presentCountryName =
								            CountryLocalServiceUtil
								                .getCountry(presentaddresss.getCountry())
								                .getName();
								    } catch (Exception ignored) {}
								}
								%>
								
								<%= presentCountryName %>
								</div>
                            </div>
                        </div>

                        <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 ">
                            <div class="form-group-view">
                                <div class="label-name">Pin Code</div>
                                <div class="label-content">${presentaddresss.pincode}</div>
                            </div>
                        </div>
                       </div>
                    </c:if>
                    <c:if test="${not employeeAddress.presentPermanentSame}">
                     <div >
                        <strong> Permanent Address Details</strong>
                    </div>
                    <div class="row">

                        <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 ">
                            <div class="form-group-view">
                                <div class="label-name">Address Line 1</div>
                                <div class="label-content">${permanentaddresss.line1}</div>
                            </div>
                        </div>

                        <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 ">
                            <div class="form-group-view">
                                <div class="label-name">Address Line 2</div>
                                <div class="label-content">${permanentaddresss.line2}</div>
                            </div>
                        </div>

                        <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 ">
                            <div class="form-group-view">
                                <div class="label-name">Address Line 3</div>
                                <div class="label-content">${permanentaddresss.line3}</div>
                            </div>
                        </div>

                        <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 ">
                            <div class="form-group-view">
                                <div class="label-name">State</div>
                                <div class="label-content">${permanentaddresss.state}</div>
                            </div>
                        </div>

                        <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 ">
                            <div class="form-group-view">
                                <div class="label-name">Country</div>
                                <div class="label-content"><%= permanentCountryName %></div>
                            </div>
                        </div>

                        <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 ">
                            <div class="form-group-view">
                                <div class="label-name">Pin Code</div>
                                <div class="label-content">${permanentaddresss.pincode}</div>
                            </div>
                        </div>
                </div>
                </c:if>
            </div>
        </div>

<c:if test="${not empty educationList }">

        <div class="card">
            <div class="card-header">
                <strong>Education Details</strong>
            </div>
            <div class="card-body">
                <c:forEach var="education" items="${educationList}">
                    <div class="row">
                        <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 ">
                            <div class="form-group-view">
                                <div class="label-name">Level Name</div>
                                <div class="label-content">${education.levelName}</div>
                            </div>
                        </div>
                        <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 ">
                            <div class="form-group-view">
                                <div class="label-name">Institute</div>
                                <div class="label-content">${education.institution}</div>
                            </div>
                        </div>
                        <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 ">
                            <div class="form-group-view">
                                <div class="label-name">Degree</div>
                                <div class="label-content">${education.degree}</div>
                            </div>
                        </div>
                        <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 ">
                            <div class="form-group-view">
                                <div class="label-name">Start Date</div>
                                <div class="label-content">
                                    <fmt:formatDate value='${education.startDate}' pattern='yyyy-MM-dd'/>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 ">
                            <div class="form-group-view">
                                <div class="label-name">End Date</div>
                                <div class="label-content">
                                    <fmt:formatDate value='${education.endDate}' pattern='yyyy-MM-dd'/>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 ">
                            <div class="form-group-view">
                                <div class="label-name">Passing Year</div>
                                <div class="label-content">
                                        ${education.passingYear}
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 ">
                                                    <div class="form-group-view">
                                                        <div class="label-name">Education Certificate</div>
                                                        <div class="label-content">
                                                            <a href="${education.educationCertificatePreviewUrl}" target="_blank"
                                                               >Download
                                                                Education Certificate</a>
                                                        </div>
                                                    </div>
                                                </div>
                    </div>
                </c:forEach>
            </div>
        </div>
</c:if>

<c:if test="${not empty experienceList }">

        <div class="card">
            <div class="card-header">
                <strong>Experience Details</strong>
            </div>
            <div class="card-body">
                <c:forEach var="experience" items="${experienceList}">
                    <div class="row">
                        <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 ">
                            <div class="form-group-view">
                                <div class="label-name">Company Name</div>
                                <div class="label-content">
                                        ${experience.companyName}
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 ">
                            <div class="form-group-view">
                                <div class="label-name">Joining Date</div>
                                <div class="label-content">
                                    <fmt:formatDate value='${experience.experienceJoiningDate}' pattern='yyyy-MM-dd'/>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 ">
                            <div class="form-group-view">
                                <div class="label-name">Reliving Date</div>
                                <div class="label-content">
                                    <fmt:formatDate value='${experience.relievingDate}' pattern='yyyy-MM-dd'/>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 ">
                                                                      <div class="form-group-view">
                                                                          <div class="label-name">Experience Certificates</div>
                                                                          <div class="label-content">

                                                                              <c:if test="${not empty experience.experienceCertificatePreviewUrls}">
                                                                                  <ul class="pl-3 mb-0">
                                                                                      <c:forEach var="docUrl"
                                                                                                 items="${experience.experienceCertificatePreviewUrls}"
                                                                                                 varStatus="status">

                                                                                          <li>
                                                                                              <a href="${docUrl}" target="_blank">
                                                                                                  Download Experience Certificate ${status.index + 1}
                                                                                              </a>
                                                                                          </li>

                                                                                      </c:forEach>
                                                                                  </ul>
                                                                              </c:if>

                                                                              <c:if test="${empty experience.experienceCertificatePreviewUrls}">
                                                                                  <span class="text-muted">No document uploaded</span>
                                                                              </c:if>

                                                                          </div>
                                                                      </div>

                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
        </c:if>

        <div class="card">
            <div class="card-header">
                <strong>Bank Account Details</strong>
            </div>
            <div class="card-body">
                <div class="row">
                    <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                        <div class="form-group-view">
                            <div class="label-name">Account Number</div>
                            <div class="label-content">${employeeBankAccount.accountNumber}</div>
                        </div>
                    </div>

                    <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                        <div class="form-group-view">
                            <div class="label-name">Account Type</div>
                            <div class="label-content">${employeeBankAccount.accountType}</div>
                        </div>
                    </div>

                    <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                        <div class="form-group-view">
                            <div class="label-name">Beneficiary Name</div>
                            <div class="label-content">${employeeBankAccount.beneficiaryName}</div>
                        </div>
                    </div>

                    <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                        <div class="form-group-view">
                            <div class="label-name">Bank Name</div>
                            <div class="label-content">${employeeBankAccount.bankName}</div>
                        </div>
                    </div>

                    <%--                    <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">--%>
                    <%--                        <div class="form-group-view">--%>
                    <%--                            <div class="label-name">Status</div>--%>
                    <%--                            <div class="label-content">${employeeBankAccount.status}</div>--%>
                    <%--                        </div>--%>
                    <%--                    </div>--%>

                    <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                        <div class="form-group-view">
                            <div class="label-name">IFSC Code</div>
                            <div class="label-content">${employeeBankAccount.ifscCode}</div>
                        </div>
                    </div>

                    <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                        <div class="form-group-view">
                            <div class="label-name">Bank Branch</div>
                            <div class="label-content">${employeeBankAccount.bankBranch}</div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="card">
            <div class="card-header">
                <strong>
                    UAN ESIC Details
                </strong>
            </div>
            <div class="card-body">
                <div class="row">
                    <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                        <div class="form-group-view">
                            <div class="label-name">UAN</div>
                            <div class="label-content">${employeeUanEsic.uan}</div>
                        </div>
                    </div>

                    <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                        <div class="form-group-view">
                            <div class="label-name">ESIC No</div>
                            <div class="label-content">${employeeUanEsic.esicNo}</div>
                        </div>
                    </div>
                </div>
            </div>
        </div>


        <div class="card">
            <div class="card-header">
                <strong>
                    Nominee Details
                </strong>
            </div>
            <div class="card-body">
                <div class="row">
                    <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                        <div class="form-group-view">
                            <div class="label-name">First Name</div>
                            <div class="label-content">${nominee.nomineeFirstName}</div>
                        </div>
                    </div>

                    <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                        <div class="form-group-view">
                            <div class="label-name">Last Name</div>
                            <div class="label-content">${nominee.nomineeLastName}</div>
                        </div>
                    </div>

                    <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                        <div class="form-group-view">
                            <div class="label-name">Contact</div>
                            <div class="label-content">${nominee.nomineeContact}</div>
                        </div>
                    </div>

                    <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                        <div class="form-group-view">
                            <div class="label-name">Address Line 1</div>
                            <div class="label-content">${nominee.line1}</div>
                        </div>
                    </div>

                    <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                        <div class="form-group-view">
                            <div class="label-name">Address Line 2</div>
                            <div class="label-content">${nominee.line2}</div>
                        </div>
                    </div>

                    <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                        <div class="form-group-view">
                            <div class="label-name">Address Line 3</div>
                            <div class="label-content">${nominee.line3}</div>
                        </div>
                    </div>

                    <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                        <div class="form-group-view">
                            <div class="label-name">State</div>
                            <div class="label-content">${nominee.state}</div>
                        </div>
                    </div>

                    <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                        <div class="form-group-view">
                            <div class="label-name">Country</div>
                            <div class="label-content">${nominee.countryName}</div>
                        </div>
                    </div>

                    <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                        <div class="form-group-view">
                            <div class="label-name">Pincode</div>
                            <div class="label-content">${nominee.pincode}</div>
                        </div>
                    </div>

                    <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                        <div class="form-group-view">
                            <div class="label-name">Relationship</div>
                            <div class="label-content">${nominee.relationshipWithNominee}</div>
                        </div>
                    </div>

                    <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                        <div class="form-group-view">
                            <div class="label-name">Date of Birth</div>
                            <div class="label-content"><fmt:formatDate value='${nominee.nomineeDob}' pattern='yyyy-MM-dd'/></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="card">
    <div class="card-header">
        <strong>
            Decision Panel
        </strong>
    </div>
    <div class="card-body">
        <div class="row">
            <div class="col">
                <div class="form-group">
                    <label for="comments">Comments</label>
                    <textarea name="<portlet:namespace/>review" id="<portlet:namespace/>review"
                              class="form-control"></textarea>
                    <label id="comments-error" class="error text-danger" for="comments"></label>
                </div>
            </div>
        </div>
    </div>
    <div class="card-footer text-right align-items-center">
        <a onclick="rejectAction()" class="btn btn-outline-danger" id="rejectButton"><i class="icon-ban-circle"></i>
            Reject</a>
       <a class="btn btn-outline-success" id="approveButton" onclick="approveAction()">
           <i class="icon-ok"></i> Approve
       </a>

    </div>
</div>

<script>
    const namespace = '<portlet:namespace />';
    const approvalUrl = '${employeeApprovalUrl}';
    let rejectUrlTemplate = '${employeeRejectUrl}';

    // Common comment validation
    function validateComments() {
        const comment = $('#' + namespace + 'review').val().trim();

        if (comment === "") {
            $("#comments-error").text("Comments are required.");
            return false;
        }

        $("#comments-error").text("");
        return true;
    }

    // Handle Approve action
    function approveAction() {
        if (!validateComments()) return;
        window.location.href = approvalUrl;
    }

    // Handle Reject action
    function rejectAction() {
        if (!validateComments()) return;

        const comment = $('#' + namespace + 'review').val().trim();
        const rejectUrl = rejectUrlTemplate.replace("REVIEW", encodeURIComponent(comment));

        window.location.href = rejectUrl;
    }
</script>
