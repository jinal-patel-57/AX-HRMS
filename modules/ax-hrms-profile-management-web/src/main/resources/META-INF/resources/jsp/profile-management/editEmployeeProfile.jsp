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
<!-- PROFILE PICTURE -->
<!-- ========================================================= -->
<div class="card mt-3">
    <div class="card-header">
        <strong>Profile Picture</strong>
    </div>

    <div class="card-body">

        <!-- EXISTING PROFILE IMAGE -->
        <c:choose>
            <c:when test="${not empty profilePicURL}">
                <img
                    id="profilePreview"
                    src="${profilePicURL}"
                    class="img-thumbnail mb-3"
                    style="width:150px;height:150px;object-fit:cover;border-radius:50%;" />
            </c:when>

            <c:otherwise>
                <img
                    id="profilePreview"
                    src="https://via.placeholder.com/150"
                    class="img-thumbnail mb-3"
                    style="width:150px;height:150px;object-fit:cover;border-radius:50%;" />
            </c:otherwise>
        </c:choose>

        <!-- FILE INPUT -->
        <div class="mb-3">
            <input type="file"
                   class="form- control"
                   id="<portlet:namespace/>profilePic"
                   name="<portlet:namespace/>profilePic"
                   accept="image/*" />
        </div>

        <small class="text-muted">
            Allowed: JPG, PNG | Max size: 2MB
        </small>

    </div>
</div>



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


<div class="col-md-4 mb-3">
            <input type="checkbox"
                   class="mt-4"
                   id="<portlet:namespace />maritalStatus"
                   name="<portlet:namespace />maritalStatus"
                   value="true"
                   <c:if test="${employeeDetail != null && employeeDetail.maritalStatus}">
                       checked="checked"
                   </c:if> />

            <label for="<portlet:namespace />maritalStatus">
                Married
            </label>
</div>
            <div class="col-md-4 col-sm-12 mb-3" id="marriageDateWrapper">
                <label for="<portlet:namespace />marriageDate" class="form-label">
                    Marriage Date
                </label>

                <input type="date"
                       class="form-control"
                       id="<portlet:namespace />marriageDate"
                       name="<portlet:namespace />marriageDate"
                       value="<fmt:formatDate value='${employeeDetail.marriageDate}' pattern='yyyy-MM-dd'/>"/>
                       <small id="<portlet:namespace/>marriageDateError"
                              class="text-danger"
                              style="display:none;"></small>
            </div>

            <div class="col-md-4 col-sm-12 mb-3" id="spouseNameWrapper">
                <label for="<portlet:namespace />spouseName" class="form-label">
                    Spouse Name
                </label>

                <input type="text"
                       class="form-control"
                       id="<portlet:namespace />spouseName"
                       name="<portlet:namespace />spouseName"
                       value="${employeeDetail.spouseName}" />
                <small id="<portlet:namespace/>spouseError"
                       class="text-danger"
                       style="display:none;"></small>
            </div>





        </div>
    </div>
</div>



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

    var ns = '<portlet:namespace />';


    var maritalCheckbox = $('#' + ns + 'maritalStatus');
    var spouseField = $('#' + ns + 'spouseName');
    var marriageDateField = $('#' + ns + 'marriageDate');

    var spouseError = $('#' + ns + 'spouseError');
    var marriageDateError = $('#' + ns + 'marriageDateError');

    function validateMarriageFields() {

        spouseError.hide().text('');
        marriageDateError.hide().text('');

        if (maritalCheckbox.is(':checked')) {

            let isValid = true;

            if (!spouseField.val().trim()) {
                spouseError.text('Spouse name is required.').show();
                isValid = false;
            }

            if (!marriageDateField.val()) {
                marriageDateError.text('Marriage date is required.').show();
                isValid = false;
            }

            return isValid;
        }

        return true;
    }

    //  FORM SUBMIT VALIDATION
    $('#profileForm').on('submit', function () {
        return validateMarriageFields();
    });

    //  LIVE ERROR REMOVE
    spouseField.on('input', function () {
        if ($(this).val().trim()) {
            spouseError.hide();
        }
    });

    marriageDateField.on('change', function () {
        if ($(this).val()) {
            marriageDateError.hide();
        }
    });

maritalCheckbox.on('change', function () {

    if (!$(this).is(':checked')) {

        // Clear values
        spouseField.val('');
        marriageDateField.val('');

        // Remove error messages
        spouseError.hide().text('');
        marriageDateError.hide().text('');
    }
});

});

Liferay.on('allPortletsReady', function () {

    var ns = '<portlet:namespace />';

    /* =======================================================
       MARITAL STATUS (CHECKBOX BASED)
    ======================================================= */

    var maritalCheckbox = document.getElementById(ns + 'maritalStatus');
    var spouseField = document.getElementById(ns + 'spouseName');
    var marriageDateField = document.getElementById(ns + 'marriageDate');

    function toggleMaritalFields() {

        if (!maritalCheckbox) return;

        if (maritalCheckbox.checked) {
            spouseField.disabled = false;
            marriageDateField.disabled = false;
        } else {
            spouseField.disabled = true;
            marriageDateField.disabled = true;

            spouseField.value = '';
            marriageDateField.value = '';
        }
    }

    toggleMaritalFields();
    maritalCheckbox.addEventListener('change', toggleMaritalFields);



});
</script>