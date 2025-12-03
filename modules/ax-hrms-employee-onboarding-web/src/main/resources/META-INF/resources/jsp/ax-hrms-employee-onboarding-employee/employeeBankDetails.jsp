<%@ include file="/init.jsp" %>

<portlet:actionURL name="/addEditEmployeeBankAccountURL" var="addEditEmployeeBankAccountURL"/>
<form id="bankAccountStepperForm" action="${addEditEmployeeBankAccountURL}" method="post">
        <div class="card-header">
            <strong><liferay-ui:message key="bank-accounts-details"/></strong>
        </div>
        <!-- Account Number -->
        <div class="card-body">
            <div class="row">
                <div class="col-md-4 col-sm-12 mb-3">
                    <div class="form-group">
                        <label for="accountNumber" class="form-label">
                            <liferay-ui:message key="account-number"/>
                        </label>
                        <input type="text" class="form-control" id="<portlet:namespace />accountNumber"
                               name="<portlet:namespace />accountNumber" maxlength="75"
                               value="${employeeBankAccount.accountNumber}"
                               required/>
                        <input type="hidden" class="form-control" id="<portlet:namespace />bankAccountId"
                               name="<portlet:namespace />bankAccountId" maxlength="75"
                               value="${employeeBankAccount.bankAccountId}"

                               required/>
                    </div>
                </div>
                <div class="col-md-4 col-sm-12 mb-3">
                    <div class="form-group">
                        <label for="accountType" class="form-label"><liferay-ui:message key="account-type"/></label>
                        <select id="<portlet:namespace />accountType" name="<portlet:namespace />accountType"
                                class="form-select"
                                required>
                            <option value="">Select account type</option>
                            <option value="savings" ${employeeBankAccount.accountType == 'savings' ? 'selected' : ''}>
                                Savings
                            </option>
                            <option value="current" ${employeeBankAccount.accountType == 'current' ? 'selected' : ''}>
                                Current
                            </option>
                            <option value="fixed" ${employeeBankAccount.accountType == 'fixed' ? 'selected' : ''}>Fixed
                                Deposit
                            </option>
                            <option value="recurring" ${employeeBankAccount.accountType == 'recurring' ? 'selected' : ''}>
                                Recurring
                                Deposit
                            </option>
                        </select>
                    </div>
                </div>

                <!-- Beneficiary Name -->
                <div class="col-md-4 col-sm-12 mb-3">
                    <div class="form-group">
                        <label for="beneficiaryName" class="form-label">
                            <liferay-ui:message key="beneficiary-name"/>
                        </label>
                        <input type="text" class="form-control" id="<portlet:namespace />beneficiaryName"
                               name="<portlet:namespace />beneficiaryName" maxlength="75"
                               value="${employeeBankAccount.beneficiaryName}" required/>
                    </div>
                </div>
                <!-- Bank Name -->
                <div class="col-md-4 col-sm-12 mb-3">
                    <div class="form-group">
                        <label for="bankName" class="form-label">
                            <liferay-ui:message key="bank-name"/>
                        </label>
                        <input type="text" class="form-control" id="<portlet:namespace />bankName"
                               name="<portlet:namespace />bankName" maxlength="75"
                               value="${employeeBankAccount.bankName}"
                               required/>
                    </div>
                </div>

                <!-- IFSC Code -->
                <div class="col-md-4 col-sm-12 mb-3">
                    <div class="form-group">
                        <label for="ifscCode" class="form-label">
                            <liferay-ui:message key="ifsc-code"/>
                        </label>
                        <input type="text" class="form-control" id="<portlet:namespace />ifscCode"
                               name="<portlet:namespace />ifscCode" maxlength="75"
                               value="${employeeBankAccount.ifscCode}"
                               required/>
                    </div>
                </div>
                <!-- Bank Branch -->
                <div class="col-md-4 col-sm-12 mb-3">
                    <div class="form-group">
                        <label for="bankBranch" class="form-label">
                            <liferay-ui:message key="bank-branch"/>
                        </label>
                        <input type="text" class="form-control" id="<portlet:namespace />bankBranch"
                               name="<portlet:namespace />bankBranch" maxlength="75"
                               value="${employeeBankAccount.bankBranch}"
                               required/>
                    </div>
                </div>
                <input type="hidden" id="updateFlagBank" name="<portlet:namespace/>updateFlagBank"
                       value="${not empty flagStatuss? flagStatuss : 'false' }"/>

                <input type="hidden" name="<portlet:namespace/>employeeId" value="${employeeId}">
            </div>

        </div>
        <div class="card-footer text-right">
            <button class="btn btn-outline-primary previous-button" type="button">Previous</button>
            <button class="btn btn-outline-primary next-button next-button-bank-account-details" type="button">Next
            </button>
        </div>

</form>                