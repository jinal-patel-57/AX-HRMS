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
                                <fmt:formatDate value='${employeeDetail.dateOfBirth}' pattern='yyyy-MM-dd'/>
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
                            <div class="label-name">Skype ID</div>
                            <div class="label-content">${employeeDetail.skypeId}</div>
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
                            <div class="label-name">Maritial Status</div>
                            <div class="label-content">${employeeDetail.maritalStatus}</div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 ">
                        <div class="form-group-view">
                            <div class="label-name">Marriage Date</div>
                            <div class="label-content">
                                <fmt:formatDate value='${employeeDetail.marriageDate}' pattern='yyyy-MM-dd'/>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 ">
                        <div class="form-group-view">
                            <div class="label-name">Spouse Name</div>
                            <div class="label-content">${employeeDetail.spouseName}</div>
                        </div>
                    </div>
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
                </div>
            </div>
        </div>


        <div class="card">
            <div class="card-header">
                <strong>Address Details</strong>
            </div>
            <div class="card-body">
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
                            <div class="label-content">${presentaddresss.country}</div>
                        </div>
                    </div>

                    <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 ">
                        <div class="form-group-view">
                            <div class="label-name">Pin code</div>
                            <div class="label-content">${presentaddresss.pincode}</div>
                        </div>
                    </div>
                    <hr>

                    <c:if test="${employeeAddress.presentPermanentSame}">

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
                                <div class="label-content">${presentaddresss.country}</div>
                            </div>
                        </div>

                        <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 ">
                            <div class="form-group-view">
                                <div class="label-name">Pin Code</div>
                                <div class="label-content">${presentaddresss.pincode}</div>
                            </div>
                        </div>
                    </c:if>
                    <c:if test="${not employeeAddress.presentPermanentSame}">

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
                                <div class="label-content">${permanentaddresss.country}</div>
                            </div>
                        </div>

                        <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 ">
                            <div class="form-group-view">
                                <div class="label-name">Pin Code</div>
                                <div class="label-content">${permanentaddresss.pincode}</div>
                            </div>
                        </div>
                    </c:if>
                </div>
            </div>
        </div>

<c:if test="${not empty educationList }">

        <div class="card">
            <div class="card-header">
                <strong>Address Details</strong>
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
                                        ${education.companyName}
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
                                <div class="label-name">Reliving Date</div>
                                <div class="label-content">
                                    <a href="${experienceCertificate}"
                                       download="${experience.companyName}_Experience_Certificate.pdf">Download
                                        Experience Certificate</a>
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
                            <div class="label-name">Line 1</div>
                            <div class="label-content">${nominee.line1}</div>
                        </div>
                    </div>

                    <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                        <div class="form-group-view">
                            <div class="label-name">Line 2</div>
                            <div class="label-content">${nominee.line2}</div>
                        </div>
                    </div>

                    <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                        <div class="form-group-view">
                            <div class="label-name">Line 3</div>
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
        <a href="${employeeApprovalUrl}" class="btn btn-outline-success" id="approveButton"><i class="icon-ok"></i>
            Approve</a>
    </div>
</div>

<script>
    function rejectAction() {
        var config = new Object({}),
            namespace = '<portlet:namespace />';
        config.namespace = namespace;
        employeeRejectUrl = '${employeeRejectUrl}';
        AxHrmsEmployeeOnboardingEmployeeWebPortlet.setConfigsForRejectUrl(config);
    }
</script>


