<%@ include file="/init.jsp"%>
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.20.0/jquery.validate.min.js" integrity="sha512-WMEKGZ7L5LWgaPeJtw9MBM4i5w5OSBlSjTjCtSnvFJGSVD26gE5+Td12qN5pvWXhuWaWcVwF++F7aqu9cvqP0A==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>

<portlet:actionURL name="/addEditLeavePolicy" var="addEditLeavePolicyURL" />

<liferay-ui:error key="LeavePolicyExists"  message="leave-policy-exists" />


<div class="card">
  <div class="card-header"><strong> <liferay-ui:message key="leave-policy-master" />  </strong></div>
<form action="${addEditLeavePolicyURL}" method="post" id="<portlet:namespace/>leavePolicyForm" class="container mt-5">
  <div class="card-body mb-0">
    	
    	<input type="hidden" id="<portlet:namespace/>leavePolicyMasterId" name="<portlet:namespace/>leavePolicyMasterId" value="${getLeavePolicyMaster.leavePolicyMasterId}" >
    	<div class="form-group row">
		    <label for="<portlet:namespace/>leavetypemasterid" class="col-sm-3 col-form-label"><liferay-ui:message key="leave-type-master-name" /><span class="text-danger">*</span></label>
		    <div class="col-sm-9">
		        <select id="<portlet:namespace/>leavetypemasterid" name="<portlet:namespace/>leavetypemasterid" class="form-control">
		            <option value="">Select Leave Type</option>
		            <c:forEach var="leaveType" items="${leaveTypeMasterList}">
		                <option value="${leaveType.leaveTypeMasterId}" ${getLeavePolicyMaster.leaveTypeMasterId == leaveType.leaveTypeMasterId ? 'selected' : '' }>${leaveType.leaveTypeName}</option>
		            </c:forEach>
		        </select>
		    </div>
		</div>

        <div class="form-group row">
		    <label for="<portlet:namespace/>desciption" class="col-sm-3 col-form-label"><liferay-ui:message key="description" /></label>
		    <div class="col-sm-9">
		        <textarea id="<portlet:namespace/>desciption" name="<portlet:namespace/>desciption" class="form-control">${getLeavePolicyMaster.description}</textarea>
		    </div>
		</div>


        <div class="form-group row">
            <label for="<portlet:namespace/>accrualrate" class="col-sm-3 col-form-label"><liferay-ui:message key="total-leave-of-the-year" /><span class="text-danger">*</span></label>
            <div class="col-sm-9">
                <input type="number" id="<portlet:namespace/>accrualrate" name="<portlet:namespace/>accrualrate" value="${(getLeavePolicyMaster.accrualRate * 12) == 0 ? '' : (getLeavePolicyMaster.accrualRate * 12).intValue()}" class="form-control" />
            </div>
        </div>
        
        <div class="form-group row">
            <label class="col-sm-3 col-form-label"><liferay-ui:message key="is-applicable-floater" /></label>
            <div class="col-sm-9">
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" id="<portlet:namespace/>isApplicableFloater" name="<portlet:namespace/>isApplicableFloater" ${getLeavePolicyMaster.isApplicableFloater == true ? 'checked' : '' } />
                    <label class="form-check-label" for="<portlet:namespace/>isApplicableFloater"><liferay-ui:message key="check-if-floater" /></label>
                </div>
            </div>
        </div>

	
		<div class="form-group row">
            <label class="col-sm-3 col-form-label"><liferay-ui:message key="carry-forward" /></label>
            <div class="col-sm-9">
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" id="<portlet:namespace/>iscarryforward" name="<portlet:namespace/>iscarryforward" ${getLeavePolicyMaster.isCarryForward == true ? 'checked' : '' }/>
                    <label class="form-check-label" for="<portlet:namespace/>iscarryforward"><liferay-ui:message key="check-if-carry-forward" /></label>
                </div>
            </div>
        </div>
        
        <div class="form-group row">
            <label for="<portlet:namespace/>maximumbalance" class="col-sm-3 col-form-label"><liferay-ui:message key="maximum-balance" /></label>
            <div class="col-sm-9">
                <input type="text" id="<portlet:namespace/>maximumbalance" name="<portlet:namespace/>maximumbalance" class="form-control" value="${getLeavePolicyMaster.maximumBalance}"/>
            </div>
        </div>

        <div class="form-group row">
            <label class="col-sm-3 col-form-label"><liferay-ui:message key="check-maximum" /></label>
            <div class="col-sm-9">
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" id="<portlet:namespace/>ischeckmax" name="<portlet:namespace/>ischeckmax" ${getLeavePolicyMaster.isCheckMax == true ? 'checked' : '' } />
                    <label class="form-check-label" for="<portlet:namespace/>ischeckmax"><liferay-ui:message key="check-if-maximum" /></label>
                </div>
            </div>
        </div>



        <div class="form-group row">
		    <label class="col-sm-3 col-form-label" for="<portlet:namespace/>yearOfPolicy"><liferay-ui:message key="year-of-policy" /><span class="text-danger">*</span></label>
		    <div class="col-sm-9">
		        <input type="number" class="form-control" id="<portlet:namespace/>yearOfPolicy" name="<portlet:namespace/>yearOfPolicy" value="${getLeavePolicyMaster.yearOfPolicy}" min="1900" max="3000" step="1" >
		    </div>
		</div>
        
        <div class="form-group row">
            <label class="col-sm-3 col-form-label"><liferay-ui:message key="continuous" /></label>
            <div class="col-sm-9">
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" id="<portlet:namespace/>iscontinuos" name="<portlet:namespace/>iscontinuos" ${getLeavePolicyMaster.isContinuous == true ? 'checked' : '' } />
                    <label class="form-check-label" for="<portlet:namespace/>iscontinuos"><liferay-ui:message key="check-if-continuous" /></label>
                </div>
            </div>
        </div>

        <div class="form-group row">
            <label for="<portlet:namespace/>eligibleaftermonths" class="col-sm-3 col-form-label"><liferay-ui:message key="eligible-after-months" /><span class="text-danger">*</span></label>
            <div class="col-sm-9">
                <input type="number" id="<portlet:namespace/>eligibleaftermonths" name="<portlet:namespace/>eligibleaftermonths" class="form-control"  value="${getLeavePolicyMaster.eligibleAfterMonths}"/>
            </div>
        </div>

</div>
  <div class="card-footer text-right mb-0">
                <a href="<liferay-portlet:renderURL portletMode='view' windowState='normal' />" class="btn btn-outline-danger mr-1"><liferay-ui:message key ="back-button" /></a>
 <button type="submit" class="btn btn-outline-success"><liferay-ui:message key="submit" /></button>

</div>
    </form>
</div>

    
               
<script>
$(document).ready(function () {
	var config = new Object({}),
	namespace = '<portlet:namespace />';
	var cf;
	 <c:if test = "${getLeavePolicyMaster.isCarryForward}">
		cf = true;
	 </c:if>
	 <c:if test = "${!getLeavePolicyMaster.isCarryForward}">
		cf = false;
	 </c:if>
	config.namespace = namespace;
	config.cf = cf;
	AxLeavePolicyMasterWebPortlet.setConfigsForValidation(config);
});
</script>
