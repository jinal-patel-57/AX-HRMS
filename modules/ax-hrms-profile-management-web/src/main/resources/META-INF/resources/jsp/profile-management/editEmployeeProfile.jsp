<%@ include file="/init.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<portlet:actionURL name="editEmployeeProfile" var="editEmployeeProfileUrl" />
<portlet:renderURL var="backURL">
    <portlet:param name="mvcCommand" value="/"/>
</portlet:renderURL>

<form id="profileForm"
      action="${editEmployeeProfileUrl}"
      method="post"
      enctype="multipart/form-data"
      data-senna="off">

<!-- ========================================================= -->
<!-- BASIC DETAILS -->
<!-- ========================================================= -->
<div class="card">
    <div class="card-header">
        <strong>Profile Details</strong>
    </div>

    <div class="card-body">
        <div class="row">

            <div class="col-md-4 mb-3">
                <label for="<portlet:namespace/>firstName" class="form-label">
                    First Name <span class="text-danger">*</span>
                </label>
                <input type="text"
                       class="form-control"
                       id="<portlet:namespace/>firstName"
                       name="<portlet:namespace/>firstName"
                       value="${employeeDetail.firstName}" />
            </div>

            <div class="col-md-4 mb-3">
                <label for="<portlet:namespace/>lastName" class="form-label">
                    Last Name <span class="text-danger">*</span>
                </label>
                <input type="text"
                       class="form-control"
                       id="<portlet:namespace/>lastName"
                       name="<portlet:namespace/>lastName"
                       value="${employeeDetail.lastName}" />
            </div>

            <div class="col-md-4 mb-3">
                <label for="<portlet:namespace/>personalEmail" class="form-label">
                    Personal Email <span class="text-danger">*</span>
                </label>
                <input type="email"
                       class="form-control"
                       id="<portlet:namespace/>personalEmail"
                       name="<portlet:namespace/>personalEmail"
                       value="${employeeDetail.personalEmail}" />
            </div>

            <div class="col-md-4 mb-3">
                <label for="<portlet:namespace/>mobileNumber" class="form-label">
                    Mobile Number <span class="text-danger">*</span>
                </label>
                <input type="text"
                       class="form-control"
                       id="<portlet:namespace/>mobileNumber"
                       name="<portlet:namespace/>mobileNumber"
                       value="${employeeDetail.mobileNo}"
                               maxlength="10"
                               pattern="[0-9]{10}"
                               inputmode="numeric"
                               oninput="this.value = this.value.replace(/[^0-9]/g, '')"/>
            </div>

        </div>
    </div>
</div>

<!-- ========================================================= -->
<!-- PERMANENT ADDRESS -->
<!-- ========================================================= -->
<c:if test="${not empty permanentaddresss}">
<div class="card mt-3">
    <div class="card-header"><strong>Permanent Address</strong></div>
    <div class="card-body">
        <div class="row">

            <div class="col-md-4 mb-3">
                <label for="<portlet:namespace/>permanantLine1" class="form-label">
                    Address Line 1 <span class="text-danger">*</span>
                </label>
                <input type="text" class="form-control"
                       id="<portlet:namespace/>permanantLine1"
                       name="<portlet:namespace/>permanantLine1"
                       value="${permanentaddresss.line1}" />
            </div>

            <div class="col-md-4 mb-3">
                <label for="<portlet:namespace/>permanantState" class="form-label">
                    State <span class="text-danger">*</span>
                </label>
                <input type="text" class="form-control"
                       id="<portlet:namespace/>permanantState"
                       name="<portlet:namespace/>permanantState"
                       value="${permanentaddresss.state}" />
            </div>
             <div class="col-md-4 col-sm-12 mb-3">


                                <label for="permanentCity" class="form-label"> <liferay-ui:message
                                        key="permanent-city"/><span class="text-danger">*</span>
                                </label> <input type="text" class="form-control"
                                                id="<portlet:namespace />permanentCity"
                                                name="<portlet:namespace />permanentCity" maxlength="100"
                                                value="${permanentaddresss.city}"/>

                        </div>

            <div class="col-md-4 mb-3">
                <label for="<portlet:namespace/>permanantPincode" class="form-label">
                    Pincode <span class="text-danger">*</span>
                </label>
                <input type="text" class="form-control"
                       id="<portlet:namespace/>permanantPincode"
                       name="<portlet:namespace/>permanantPincode"
                       value="${permanentaddresss.pincode}" />
            </div>

           <div class="col-md-4 col-sm-12 mb-3">
               <div class="form-group">
                   <label for="<portlet:namespace/>permanantCountry" class="form-label">
                       Country <span class="text-danger">*</span>
                   </label>

                   <select class="form-control text-capitalize"
                           id="<portlet:namespace/>permanantCountry"
                           name="<portlet:namespace/>permanantCountry">
                       <option value="">Select a country</option>
                       <c:forEach items="${countryList}" var="country">
                           <option class="text-capitalize"
                                   value="${country.countryId}"
                                   ${country.countryId == permanentaddresss.country ? 'selected' : ''}>
                               ${country.name}
                           </option>
                       </c:forEach>
                   </select>
               </div>
           </div>


        </div>
    </div>
</div>
<!-- SAME AS PERMANENT -->
<div class="form-check mt-3">
    <input type="checkbox"
           class="form-check-input"
           id="<portlet:namespace/>isSamePresentAddress"
           name="<portlet:namespace/>isSamePresentAddress"

           ${isSamePresentAddress ? 'checked' : ''}/>
    <label for="<portlet:namespace/>isSamePresentAddress" class="form-label">
        Same as permanent address
    </label>
</div>
</c:if>


<!-- ========================================================= -->
<!-- PRESENT ADDRESS -->
<!-- ========================================================= -->
<c:if test="${not empty presentaddresss}">
<div class="card mt-3">
    <div class="card-header"><strong>Present Address</strong></div>
    <div class="card-body">
        <div class="row">

            <div class="col-md-4 mb-3">
                <label for="<portlet:namespace/>presentLine1" class="form-label">
                    Address Line 1 <span class="text-danger">*</span>
                </label>
                <input type="text" class="form-control"
                       id="<portlet:namespace/>presentLine1"
                       name="<portlet:namespace/>presentLine1"
                       value="${presentaddresss.line1}" />
            </div>

            <div class="col-md-4 mb-3">
                <label for="<portlet:namespace/>presentState" class="form-label">
                    State <span class="text-danger">*</span>
                </label>
                <input type="text" class="form-control"
                       id="<portlet:namespace/>presentState"
                       name="<portlet:namespace/>presentState"
                       value="${presentaddresss.state}" />
            </div>

        <div class="col-md-4 col-sm-12 mb-3">


                <label for="<portlet:namespace />presentCity" class="form-label"> <liferay-ui:message
                        key="city"/><span class="text-danger">*</span>
                </label> <input type="text" class="form-control"
                                id="<portlet:namespace />presentCity" name="<portlet:namespace />presentCity"
                                maxlength="100" value="${presentaddresss.city}"/>

            </div>
            <div class="col-md-4 mb-3">
                <label for="<portlet:namespace/>presentPincode" class="form-label">
                    Pincode <span class="text-danger">*</span>
                </label>
                <input type="text" class="form-control"
                       id="<portlet:namespace/>presentPincode"
                       name="<portlet:namespace/>presentPincode"
                       value="${presentaddresss.pincode}" />
            </div>

           <div class="col-md-4 col-sm-12 mb-3">
               <div class="form-group">
                   <label for="<portlet:namespace/>presentCountry" class="form-label">
                       Country <span class="text-danger">*</span>
                   </label>

                   <select class="form-control text-capitalize"
                           id="<portlet:namespace/>presentCountry"
                           name="<portlet:namespace/>presentCountry">
                       <option value="">Select a country</option>
                       <c:forEach items="${countryList}" var="country">
                           <option class="text-capitalize"
                                   value="${country.countryId}"
                                   ${country.countryId == presentaddresss.country ? 'selected' : ''}>
                               ${country.name}
                           </option>
                       </c:forEach>
                   </select>
               </div>
           </div>

<div class="row mt-3" id="addressProofSection">
    <div class="col-md-6 col-sm-12 mb-3">
        <label class="form-label">
            <liferay-ui:message key="address-proof-document"/>
            <span class="text-danger">*</span>
        </label>

        <input type="file"
               class="form-control"
               id="<portlet:namespace/>addressProofFile"
               name="<portlet:namespace/>addressProofFile"
               accept="application/pdf,image/*" />
             <c:if test="${not presentPermanentSame}">
                            <c:if test="${not empty addressProofPreviewURL}">
                                <a href="${addressProofPreviewURL}" target="_blank">
                                    <liferay-ui:message key="view-address-proof"/>
                                </a>
                            </c:if>
             </c:if>
        <small class="form-text text-muted">
            Upload address proof (PDF / JPG / PNG)
        </small>
    </div>
</div>

        </div>
    </div>
</div>
</c:if>




<!-- ========================================================= -->
<!-- NOMINEE DETAILS -->
<!-- ========================================================= -->
<c:if test="${not empty nominee}">
<div class="card mt-3">
    <div class="card-header"><strong>Nominee Details</strong></div>

    <div class="card-body">
        <div class="row">

            <div class="col-md-4 mb-3">
                <label for="<portlet:namespace/>nomineeFirstName" class="form-label">
                    First Name <span class="text-danger">*</span>
                </label>
                <input type="text" class="form-control"
                       id="<portlet:namespace/>nomineeFirstName"
                       name="<portlet:namespace/>nomineeFirstName"
                       value="${nominee.nomineeFirstName}" />
            </div>

            <div class="col-md-4 mb-3">
                <label for="<portlet:namespace/>nomineeLastName" class="form-label">
                    Last Name <span class="text-danger">*</span>
                </label>
                <input type="text" class="form-control"
                       id="<portlet:namespace/>nomineeLastName"
                       name="<portlet:namespace/>nomineeLastName"
                       value="${nominee.nomineeLastName}" />
            </div>

            <div class="col-md-4 mb-3">
                <label for="<portlet:namespace/>nomineeContact" class="form-label">
                    Contact <span class="text-danger">*</span>
                </label>
                <input type="text" class="form-control"
                       id="<portlet:namespace/>nomineeContact"
                       name="<portlet:namespace/>nomineeContact"
                       value="${nominee.nomineeContact}"
                               maxlength="10"
                               pattern="[0-9]{10}"
                               inputmode="numeric"
                               oninput="this.value = this.value.replace(/[^0-9]/g, '')"

                       />
            </div>

            <div class="col-md-4 mb-3">
                <label for="<portlet:namespace/>relationshipWithNominee" class="form-label">
                    Relationship <span class="text-danger">*</span>
                </label>
                <input type="text" class="form-control"
                       id="<portlet:namespace/>relationshipWithNominee"
                       name="<portlet:namespace/>relationshipWithNominee"
                       value="${nominee.relationshipWithNominee}" />
            </div>

            <div class="col-md-4 mb-3">
                <label for="<portlet:namespace/>nomineeDob" class="form-label">
                    Date of Birth <span class="text-danger">*</span>
                </label>
                <input type="date" class="form-control"
                       id="<portlet:namespace/>nomineeDob"
                       name="<portlet:namespace/>nomineeDob"
                       value="<fmt:formatDate value='${nominee.nomineeDob}' pattern='yyyy-MM-dd'/>"/>
            </div>

        </div>
    </div>
</div>

<!-- NOMINEE ADDRESS -->
<div class="card mt-3">
    <div class="card-header"><strong>Nominee Address</strong></div>
    <div class="card-body">
        <div class="row">

            <div class="col-md-4 mb-3">
                <label for="<portlet:namespace/>nomineeLine1" class="form-label">
                    Address Line 1 <span class="text-danger">*</span>
                </label>
                <input type="text" class="form-control"
                       id="<portlet:namespace/>nomineeLine1"
                       name="<portlet:namespace/>nomineeLine1"
                       value="${address.line1}" />
            </div>

            <div class="col-md-4 mb-3">
                <label for="<portlet:namespace/>nomineeLine2" class="form-label">
                    Address Line 2
                </label>
                <input type="text" class="form-control"
                       id="<portlet:namespace/>nomineeLine2"
                       name="<portlet:namespace/>nomineeLine2"
                       value="${address.line2}" />
            </div>
            <div class="col-md-4 mb-3">
                <label for="<portlet:namespace/>nomineeLine3" class="form-label">
                    Address Line 3
                </label>
                <input type="text" class="form-control"
                       id="<portlet:namespace/>nomineeLine3"
                       name="<portlet:namespace/>nomineeLine3"
                       value="${address.line3}" />
            </div>

            <div class="col-md-4 mb-3">
                <label for="<portlet:namespace/>nomineeCity" class="form-label">
                    City <span class="text-danger">*</span>
                </label>
                <input type="text" class="form-control"
                       id="<portlet:namespace/>nomineeCity"
                       name="<portlet:namespace/>nomineeCity"
                       value="${address.city}" />
            </div>

            <div class="col-md-4 mb-3">
                <label for="<portlet:namespace/>nomineeState" class="form-label">
                    State <span class="text-danger">*</span>
                </label>
                <input type="text" class="form-control"
                       id="<portlet:namespace/>nomineeState"
                       name="<portlet:namespace/>nomineeState"
                       value="${address.state}" />
            </div>

           <div class="col-md-4 col-sm-12 mb-3">
               <div class="form-group">
                   <label for="<portlet:namespace/>nomineeCountry" class="form-label">
                       Country <span class="text-danger">*</span>
                   </label>

                   <select class="form-control text-capitalize"
                           id="<portlet:namespace/>nomineeCountry"
                           name="<portlet:namespace/>nomineeCountry">
                       <option value="">Select a country</option>
                       <c:forEach items="${countryList}" var="country">
                           <option class="text-capitalize"
                                   value="${country.countryId}"
                                   ${address.country == country.countryId ? 'selected' : ''}>
                               ${country.name}
                           </option>
                       </c:forEach>
                   </select>
               </div>
           </div>


            <div class="col-md-4 mb-3">
                <label for="<portlet:namespace/>nomineePincode" class="form-label">
                    Pincode <span class="text-danger">*</span>
                </label>
                <input type="text" class="form-control"
                       id="<portlet:namespace/>nomineePincode"
                       name="<portlet:namespace/>nomineePincode"
                       value="${address.pincode}" />
            </div>

        </div>
    </div>
</div>
</c:if>

<!-- ========================================================= -->
<!-- FOOTER -->
<!-- ========================================================= -->
<div class="card-footer text-right mt-3">
    <a href="${backURL}" class="btn btn-outline-danger">Back</a>
    <button type="submit" class="btn btn-outline-success">Submit</button>
</div>

</form>



<script>
$(document).ready(function () {
    AxProfileManagementWeb.setConfigs({
        namespace: '<portlet:namespace />'
    });
});
</script>
