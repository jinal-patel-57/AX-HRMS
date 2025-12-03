<%@ include file="/init.jsp" %>

<portlet:actionURL name="/addEditEmployeeAddressURL" var="addEditEmployeeAddressURL"/>

<form id="addressStepperForm" action="${addEditEmployeeAddressURL}" method="post">
    <div class="card-header">
        <strong>
            Address Details
        </strong>
    </div>

    <div class="card-body">

        <h5 class="mb-3">
            <liferay-ui:message key="permanent-address-heading"/>
        </h5>
        <div class="row">
            <input type="hidden" class="form-control" id="<portlet:namespace />permanentAddressId"
                   name="<portlet:namespace />permanentAddressId" maxlength="250"
                   value="${permanentaddresss.addressId}"/>
            <input type="hidden" class="form-control" id="<portlet:namespace />presentAddressId"
                   name="<portlet:namespace />presentAddressId" maxlength="250"
                   value="${permanentaddresss.addressId}"/>

            <input type="hidden" class="form-control" id="<portlet:namespace />employeeAddressId"
                   name="<portlet:namespace />employeeAddressId" maxlength="250"
                   value="${employeeAddress.employeeAddressId}"/>
            <div class="col-md-4 col-sm-12 mb-3">
                <!-- Address Line 1 -->
                <div class="form-group">
                    <label for="permanentAddressLine1" class="form-label"> <liferay-ui:message
                            key="permanent-address-line1"/><span class="text-danger">*</span>
                    </label> <input type="text" class="form-control"
                                    id="<portlet:namespace />permanentAddressLine1"
                                    name="<portlet:namespace />permanentAddressLine1" maxlength="250"
                                    value="${permanentaddresss.line1}"/>
                </div>
            </div>
            <!-- Address Line 2 -->
            <div class="col-md-4 col-sm-12 mb-3">

                <div class="form-group">
                    <label for="permanentAddressLine2" class="form-label"> <liferay-ui:message
                            key="permanent-address-line2"/>
                    </label> <input type="text" class="form-control"
                                    id="<portlet:namespace />permanentAddressLine2"
                                    name="<portlet:namespace />permanentAddressLine2" maxlength="250"
                                    value="${permanentaddresss.line2}"/>
                </div>
            </div>
            <!-- Address Line 3 -->
            <div class="col-md-4 col-sm-12 mb-3">

                <div class="form-group">
                    <label for="permanentAddressLine3" class="form-label"> <liferay-ui:message
                            key="permanent-address-line3"/>
                    </label> <input type="text" class="form-control"
                                    id="<portlet:namespace />permanentAddressLine3"
                                    name="<portlet:namespace />permanentAddressLine3" maxlength="250"
                                    value="${permanentaddresss.line3}"/>
                </div>
            </div>
            <!-- State -->
            <div class="col-md-4 col-sm-12 mb-3">

                <div class="form-group">
                    <label for="permanentState" class="form-label"> <liferay-ui:message
                            key="permanent-state"/><span class="text-danger">*</span>
                    </label> <input type="text" class="form-control"
                                    id="<portlet:namespace />permanentState"
                                    name="<portlet:namespace />permanentState" maxlength="100"
                                    value="${permanentaddresss.state}"/>
                </div>
            </div>
            <!-- Country -->
            <div class="col-md-4 col-sm-12 mb-3">
                <div class="form-group">
                    <label for="permanentCountry" class="form-label"><liferay-ui:message
                            key="permanent-country"/><span class="text-danger">*</span></label>
                    <!-- Dropdown menu -->
                    <select class="form-select text-capitalize"
                            id="<portlet:namespace />permanentCountry"
                            name="<portlet:namespace />permanentCountry" required>
                        <option value="">Select a country</option>
                        <c:forEach var="country" items="${countryList}">
                            <option class="text-capitalize" value="${country.countryId}" ${country.countryId == permanentaddresss.country ? 'selected' : ''}>
                                    ${country.name}
                            </option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <!-- Pincode -->
            <div class="col-md-4 col-sm-12 mb-3">

                <div class="form-group">
                    <label for="permanentPincode" class="form-label"> <liferay-ui:message
                            key="permanent-pincode"/><span class="text-danger">*</span>
                    </label> <input type="text" class="form-control"
                                    id="<portlet:namespace />permanentPincode"
                                    name="<portlet:namespace />permanentPincode" maxlength="10"
                                    value="${permanentaddresss.pincode}"/>
                </div>
            </div>
        </div>

        <!-- Checkbox for Same as Permanent Address -->
        <div class="row">
            <div class="col-md-12 col-sm-12 mb-3">

                <div class="form-group form-check">
                    <input type="checkbox" class="form-check-input" id="<portlet:namespace />sameAsPermanent"
                           name="<portlet:namespace />sameAsPermanent"
                           onclick="togglePresentAddress()" ${employeeAddress.presentPermanentSame ? 'checked' : ''} />
                    <label class="form-check-label" for="sameAsPermanent"> <liferay-ui:message
                            key="same-as-permanent-address"/>
                    </label>
                </div>
            </div>

        </div>

        <!-- Present Address Fields -->
        <h5 class="mb-3">
            <liferay-ui:message key="present-address-heading"/>
        </h5>
        <div class="row">


            <!-- Address Line 1 -->
            <div class="col-md-4 col-sm-12 mb-3">

                <div class="form-group">
                    <label for="<portlet:namespace />presentaddressLine1" class="form-label">
                        <liferay-ui:message key="present-address-line1"/><span class="text-danger">*</span>
                    </label>
                    <input type="text" class="form-control"
                           id="<portlet:namespace />presentaddressLine1"
                           name="<portlet:namespace />presentaddressLine1" maxlength="250"
                           value="${presentaddresss.line1}"/>
                </div>
            </div>


            <!-- Address Line 2 -->
            <div class="col-md-4 col-sm-12 mb-3">

                <div class="form-group">
                    <label for="<portlet:namespace />presentaddressLine2" class="form-label">
                        <liferay-ui:message key="present-address-line2"/>
                    </label> <input type="text" class="form-control"
                                    id="<portlet:namespace />presentaddressLine2"
                                    name="<portlet:namespace />presentaddressLine2" maxlength="250"
                                    value="${presentaddresss.line2}"/>
                </div>
            </div>
            <!-- Address Line 3 -->
            <div class="col-md-4 col-sm-12 mb-3">

                <div class="form-group">
                    <label for="<portlet:namespace />presentaddressLine3" class="form-label">
                        <liferay-ui:message key="present-address-line3"/>
                    </label> <input type="text" class="form-control"
                                    id="<portlet:namespace />presentaddressLine3"
                                    name="<portlet:namespace />presentaddressLine3" maxlength="250"
                                    value="${presentaddresss.line3}"/>
                </div>
            </div>
            <!-- State -->
            <div class="col-md-4 col-sm-12 mb-3">

                <div class="form-group">
                    <label for="<portlet:namespace />presentstate" class="form-label"> <liferay-ui:message
                            key="state"/><span class="text-danger">*</span>
                    </label> <input type="text" class="form-control"
                                    id="<portlet:namespace />presentstate" name="<portlet:namespace />presentstate"
                                    maxlength="100" value="${presentaddresss.state}"/>
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
                        <!-- Default option for initial selection -->
                        <!-- Iterate over the country list -->
                        <c:forEach  var="country" items="${countryList}">
                            <%-- <option value="${country.countryId}">${country.name}</option> --%>
                            <option class="text-capitalize" value="${country.countryId}" ${country.countryId == presentaddresss.country ? 'selected' : ''}>
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
                                    value="${permanentaddresss.pincode}"/>
                </div>
            </div>
        </div>
        <input type="hidden" id="updateFlagAddress" name="<portlet:namespace/>updateFlagAddress"
               value="${not empty addressFlagStatus? addressFlagStatus : 'false' }"/>

        <input type="hidden" name="<portlet:namespace/>employeeId" value="${employeeId}">
        <!-- Navigation buttons -->

    </div>

    <div class="card-footer text-right align-items-center">
        <button class="btn btn-outline-primary previous-button" type="submit">
            <liferay-ui:message key="previous"/>
        </button>
        <button class="btn btn-outline-primary next-button next-button-adress-details" type="submit">
            <liferay-ui:message key="next"/>
        </button>
    </div>
</form>

<script>
    function togglePresentAddress() {
        var config = new Object({}),
            namespace = '<portlet:namespace />';
        config.namespace = namespace;

        AxHrmsEmployeeOnboardingEmployeeWebPortlet.setConfigsForToggleAddress(config);
    }
</script>