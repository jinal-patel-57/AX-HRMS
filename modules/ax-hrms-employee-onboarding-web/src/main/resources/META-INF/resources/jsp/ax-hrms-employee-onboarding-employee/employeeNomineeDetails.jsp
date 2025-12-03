<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="/init.jsp" %>
<portlet:actionURL name="/addEditEmployeeNomineeURL" var="addEditEmployeeNomineeURL"/>

<portlet:renderURL var="showEmployeeOnboardingURL">
    <portlet:param name="mvcRenderCommandName" value="/showEmployeeOnboardingURL"/>
</portlet:renderURL>

<portlet:renderURL var="showEmployeeOnBoardingStatusUrl">
    <portlet:param name="mvcRenderCommandName" value="/showEmployeeOnBoardingStatus"/>
</portlet:renderURL>

<form id="nomineeStepperForm" action="${addEditEmployeeNomineeURL}" method="post">
    <div class="card-header">
        <strong><liferay-ui:message key="nominee-details"/></strong>
    </div>

    <div class="card-body">
        <!-- Nominee First Name -->
        <div class="row">
            <div class="col-md-4 col-sm-12 mb-3">
                <div class="form-group">
                    <label for="nomineeFirstName" class="form-label">
                        <liferay-ui:message key="nominee-first-name"/><span class="text-danger">*</span>
                    </label>
                    <input type="text" class="form-control" id="<portlet:namespace />nomineeFirstName"
                           name="<portlet:namespace />nomineeFirstName" maxlength="75"
                           value="${nominee.nomineeFirstName}"
                           required/>
                </div>
            </div>

            <!-- Nominee Last Name -->
            <div class="col-md-4 col-sm-12 mb-3">
                <div class="form-group">
                    <label for="nomineeLastName" class="form-label">
                        <liferay-ui:message key="nominee-last-name"/><span class="text-danger">*</span>
                    </label>
                    <input type="text" class="form-control" id="<portlet:namespace />nomineeLastName"
                           name="<portlet:namespace />nomineeLastName" maxlength="75" value="${nominee.nomineeLastName}"
                           required/>
                </div>
            </div>

            <!-- Nominee Contact -->
            <div class="col-md-4 col-sm-12 mb-3">
                <div class="form-group">
                    <label for="nomineeContact" class="form-label">
                        <liferay-ui:message key="nominee-contact"/><span class="text-danger">*</span>
                    </label>
                    <input type="text" class="form-control" id="<portlet:namespace />nomineeContact"
                           name="<portlet:namespace />nomineeContact" maxlength="30" value="${nominee.nomineeContact}"
                           required/>
                </div>
            </div>


            <!-- Address Line 1 -->
            <div class="col-md-4 col-sm-12 mb-3">
                <div class="form-group">
                    <label for="<portlet:namespace />presentaddressLine1" class="form-label">
                        <liferay-ui:message key="present-address-line1"/><span class="text-danger">*</span>
                    </label> <input type="text" class="form-control"
                                    id="<portlet:namespace />presentaddressLine1"
                                    name="<portlet:namespace />presentaddressLine1" maxlength="250"
                                    value="${address.line1}"/>
                </div>
            </div>
            <!-- Address Line 2 -->
            <div class="col-md-4 col-sm-12 mb-3">
                <div class="form-group">
                    <label for="<portlet:namespace />presentaddressLine2" class="form-label">
                        <liferay-ui:message key="present-address-line2"/><span class="text-danger">*</span>
                    </label> <input type="text" class="form-control"
                                    id="<portlet:namespace />presentaddressLine2"
                                    name="<portlet:namespace />presentaddressLine2" maxlength="250"
                                    value="${address.line2}"/>
                </div>
            </div>

            <!-- Address Line 3 -->
            <div class="col-md-4 col-sm-12 mb-3">
                <div class="form-group">
                    <label for="<portlet:namespace />presentaddressLine3" class="form-label">
                        <liferay-ui:message key="present-address-line3"/><span class="text-danger">*</span>
                    </label> <input type="text" class="form-control"
                                    id="<portlet:namespace />presentaddressLine3"
                                    name="<portlet:namespace />presentaddressLine3" maxlength="250"
                                    value="${address.line3}"/>
                </div>
            </div>


            <!-- State -->
            <div class="col-md-4 col-sm-12 mb-3">
                <div class="form-group">
                    <label for="<portlet:namespace />presentstate" class="form-label"> <liferay-ui:message
                            key="state"/><span class="text-danger">*</span>
                    </label> <input type="text" class="form-control"
                                    id="<portlet:namespace />presentstate" name="<portlet:namespace />presentstate"
                                    maxlength="100" value="${address.state}"/>
                </div>
            </div>
            <!-- Country -->
            <div class="col-md-4 col-sm-12 mb-3">
                <div class="form-group">
                    <label for="presentCountry" class="form-label"> <liferay-ui:message
                            key="country"/><span class="text-danger">*</span>
                    </label>
                    <!-- Dropdown menu for country selection -->
                    <select class="form-select text-capitalize" id="<portlet:namespace />presentCountry"
                            name="<portlet:namespace />presentCountry">
                        <option value="">Select a country</option>
                        <c:forEach var="country" items="${countryList}">
                            <option class="text-capitalize"  value="${country.countryId}" ${country.countryId == address.country ? 'selected' : ''}>
                                    ${country.name}
                            </option>
                        </c:forEach>
                    </select>
                </div>
            </div>

            <!-- Pincode -->
            <div class="col-md-4 col-sm-12 mb-3">
                <div class="form-group">
                    <label for="<portlet:namespace />presentpinCode" class="form-label">
                        <liferay-ui:message key="pincode"/><span class="text-danger">*</span>
                    </label> <input type="text" class="form-control"
                                    id="<portlet:namespace />presentpinCode"
                                    name="<portlet:namespace />presentpinCode" maxlength="10"
                                    value="${address.pincode}"/>
                </div>
            </div>

            <!-- Relationship with Nominee -->
            <div class="col-md-4 col-sm-12 mb-3">
                <div class="form-group">
                    <label for="relationshipWithNominee" class="form-label">
                        <liferay-ui:message key="relationship-with-nominee"/><span class="text-danger">*</span>
                    </label>
                    <input type="text" class="form-control" id="<portlet:namespace />relationshipWithNominee"
                           name="<portlet:namespace />relationshipWithNominee" maxlength="75"
                           value="${nominee.relationshipWithNominee}" required/>
                </div>
            </div>

            <!-- Nominee Date of Birth -->
            <div class="col-md-4 col-sm-12 mb-3">
                <div class="form-group">
                    <label for="nomineeDob" class="form-label">
                        <liferay-ui:message key="nominee-dob"/><span class="text-danger">*</span>
                    </label>
                    <input type="date" class="form-control" id="<portlet:namespace />nomineeDob"
                           name="<portlet:namespace />nomineeDob"
                           value="<fmt:formatDate value='${nominee.nomineeDob}' pattern='yyyy-MM-dd'/>" required/>
                </div>
            </div>
        </div>
    </div>

    <input type="hidden" id="updateFlagNominee" name="<portlet:namespace/>updateFlagNominee" value="false"/>
    <input type="hidden" name="<portlet:namespace/>employeeId" value="${employeeId}">
    <div class="card-footer text-right">
        <button class="btn btn-outline-primary previous-button" type="button">Previous</button>
        <button class="btn btn-outline-success next-button next-button-nominee-details" type="submit">Submit</button>
    </div>

</form>