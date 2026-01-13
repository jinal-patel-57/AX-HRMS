<%@ include file="/init.jsp"%>

<portlet:actionURL name="/cloneLeavePolicy" var="cloneLeavePolicyURL" />

<div class="card">
	<div class="card-header">
		<h4 class="mb-0">Clone Leave Policy</h4>
	</div>

	<div class="card-body">

		<form action="${cloneLeavePolicyURL}" method="post" name="fmCloneLeavePolicy" id="fmCloneLeavePolicy">

			<div class="row">

				<!-- From Year -->
				<div class="col-md-6">
					<div class="form-group">
						<label for="<portlet:namespace />fromYear">From Year<span class="text-danger">*</span></label> 
						<input type="text" class="form-control"
							id="<portlet:namespace />fromYear"
							name="<portlet:namespace />fromYear"
							inputmode="numeric"
							autocomplete="off"
							placeholder="Enter From Year" />
					</div>
				</div>

				<!-- To Year -->
				<div class="col-md-6">
					<div class="form-group">
						<label for="<portlet:namespace />toYear">To Year<span class="text-danger">*</span></label> 
						<input type="text" class="form-control"
							id="<portlet:namespace />toYear"
							name="<portlet:namespace />toYear"
							inputmode="numeric"
							autocomplete="off" 
							placeholder="Enter To Year"/>
					</div>
				</div>
			</div>
			
			<div class="form-group">
				<label for="<portlet:namespace />leaveTypeIds">Select Leave Types to Clone the Policy</label>
			</div>
			<div class="row" id="leaveTypeMasters">
	            <c:forEach items="${leaveTypeMasterList}" var="leaveType">
	                <div class="col-md-3">
	                    <div class="form-check mb-2">
	                        <input
	                            type="checkbox"
	                            class="form-check-input"
	                            id="<portlet:namespace />leaveType_${leaveType.leaveTypeMasterId}"
	                            name="<portlet:namespace />leaveTypeIds"
	                            value="${leaveType.leaveTypeMasterId}" />
	
	                        <label
	                            class="form-check-label"
	                            for="<portlet:namespace />leaveType_${leaveType.leaveTypeMasterId}">
	                            ${leaveType.leaveTypeName}
	                        </label>
	                    </div>
	                </div>
	            </c:forEach>
        	</div>

			<!-- Buttons (same as Add/Edit) -->
			<div class="row mt-4">
				<div class="col-md-12 text-right">
					<button type="submit" class="btn btn-primary">Clone Policy</button>
					<button type="button" class="btn btn-secondary" onclick="history.back();">Cancel</button>
				</div>
			</div>

		</form>

	</div>
</div>

<script>
$(document).ready(function () {
	var config = new Object({}),
	namespace = '<portlet:namespace />';
	config.namespace = namespace;
	AxLeavePolicyMasterWebPortlet.setConfigsForValidation(config);
});
</script>
