<%@ include file="/init.jsp"%>

<portlet:actionURL name="/saveBranchDetails" var="saveBranchDetails" />
<liferay-ui:error key="branchExists" message="Branch Name already exists!" />

<form action="${saveBranchDetails}" method="post" id="branchForm">

<div class="card">
    <div class="card-header">
        <strong><liferay-ui:message key="branch" /></strong>
    </div>

    <div class="card-body">

        <!-- Branch Name -->
        <div class="form-group">
            <label>
                Branch Name <span class="text-danger">*</span>
            </label>
            <input
                type="text"
                class="form-control"
                id="<portlet:namespace />branchName"
                name="<portlet:namespace />branchName"
                minlength="2"
                maxlength="70"
                value="${not empty branchMaster ? branchMaster.branchName : ''}"
            />
        </div>

        <!-- Address -->
        <div class="form-group">
            <label>
                Address <span class="text-danger">*</span>
            </label>
            <input
                type="text"
                class="form-control"
                id="<portlet:namespace />address"
                name="<portlet:namespace />address"
                maxlength="250"
                value="${branchMaster.address}"
            />
        </div>

        <!-- City -->
        <div class="form-group">
            <label>
                City <span class="text-danger">*</span>
            </label>
            <input
                type="text"
                class="form-control"
                id="<portlet:namespace />city"
                name="<portlet:namespace />city"
                maxlength="75"
                value="${branchMaster.city}"
            />
        </div>

        <!-- State -->
        <div class="form-group">
            <label>
                State <span class="text-danger">*</span>
            </label>
            <input
                type="text"
                class="form-control"
                id="<portlet:namespace />state"
                name="<portlet:namespace />state"
                maxlength="100"
                value="${branchMaster.state}"
            />
        </div>

        <!-- Country -->


                       <div class="form-group">
                           <label for="<portlet:namespace/>country" class="form-label">
                               Country <span class="text-danger">*</span>
                           </label>

                           <select class="form-control text-capitalize"
                                   id="<portlet:namespace/>country"
                                   name="<portlet:namespace/>country">
                               <option value="">Select a country</option>
                               <c:forEach items="${countryList}" var="country">
                                   <option class="text-capitalize"
                                           value="${country.countryId}"
                                           ${country.countryId == branchMaster.countryId ? 'selected' : ''}>
                                       ${country.name}
                                   </option>
                               </c:forEach>
                           </select>
                       </div>


        <!-- Pincode -->
        <div class="form-group">
            <label>
                Pincode <span class="text-danger">*</span>
            </label>
            <input
                type="text"
                class="form-control"
                id="<portlet:namespace />pincode"
                name="<portlet:namespace />pincode"
                maxlength="6"
                value="${branchMaster.pincode}"
            />
        </div>

        <input type="hidden"
               name="<portlet:namespace />branchMasterId"
               value="${branchMaster.branchMasterId}" />
    </div>

    <div class="card-footer text-right">
        <a href="<liferay-portlet:renderURL />"
           class="btn btn-outline-danger">
            Back
        </a>
        <button type="submit" class="btn btn-outline-success">
            Submit
        </button>
    </div>
</div>
</form>

<script>
$(document).ready(function () {
    AxBranchMasterWebPortlet.setConfigsForValidation({
        namespace: '<portlet:namespace />'
    });
});
</script>
