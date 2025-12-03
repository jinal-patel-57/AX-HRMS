<%--
  Created by IntelliJ IDEA.
  User: krish.moradiya
  Date: 22-05-2024
  Time: 01:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/init.jsp"%>


<!-- Session Message Keys Start -->
<liferay-ui:success key="probation-extend-successfully" message="Probation period extended..."></liferay-ui:success>
<liferay-ui:success key="probation-confirmed-successfully" message="Probation Confirmed..."></liferay-ui:success>
<liferay-ui:success key="probation-terminated-successfully" message="Probation Terminated employee..."></liferay-ui:success>
<!-- Session Message Keys End -->
<!-- URL Start -->
<portlet:actionURL name="/probationAction" var="probationActionURL">
    <portlet:param name="probationActionType" value="PROBATION_ACTION_TYPE" />
    <portlet:param name="employeeId" value="EMPLOYEE_ID" />
</portlet:actionURL>
<!-- URL End -->
<c:if test="${ empty upcomingProbationEmployeeDetailList }">
 <div class="alert alert-info">
        No Any Upcoming Probation !
    </div>
</c:if>

<c:if test="${not empty upcomingProbationEmployeeDetailList}">
<div class="card">
  <div class="card-header d-flex align-items-center justify-content-between">
			<strong>  <liferay-ui:message key="Upcomming Probation Employee Details"/>   </strong>
</div>
  <div class="card-body mb-0 pb-0">
 <table class="table ">
                <tr>
                    <th><liferay-ui:message key="employee-code" /></th>
                    <th><liferay-ui:message key="employee-name" /></th>
                    <th><liferay-ui:message key="department" /></th>
                    <th><liferay-ui:message key="designation" /></th>
                    <th><liferay-ui:message key="joining-date" /></th>
                    <th><liferay-ui:message key="probation-end-date" /></th>
                    <th><liferay-ui:message key="action" /></th>
                </tr>
                <c:forEach items="${upcomingProbationEmployeeDetailList}" var="upcomingProbationEmployee">
                    <tr>
                        <td>${upcomingProbationEmployee.employeeCode}</td>
                        <td>${upcomingProbationEmployee.employeeName}</td>
                        <td>${upcomingProbationEmployee.departmentName}</td>
                        <td>${upcomingProbationEmployee.designationName}</td>
                        <td>${upcomingProbationEmployee.getDateString(upcomingProbationEmployee.joiningDate)}</td>
                        <td>${upcomingProbationEmployee.getDateString(upcomingProbationEmployee.probationEndDate)}</td>
                        <td>
                            <portlet:actionURL name="/probationAction" var="probationActionURL">
                                <portlet:param name="probationActionType" value="PROBATION_ACTION_TYPE" />
                                <portlet:param name="employeeId" value="EMPLOYEE_ID" />
                            </portlet:actionURL>
                            
                            
                     <div class="dropdown ">
					<button class="btn fa fa-ellipsis-v dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" >
						<i class="icon-ellipsis-vertical"></i>
					</button>
					<ul class="dropdown-menu">
						<li>
						<a onclick="performAction(${upcomingProbationEmployee.employeeId},'Completed')" class="dropdown-item "><i class="icon-thumbs-up"></i> <liferay-ui:message
						key="confirm" /></a>
						</li>
						
						<li>
						<a class="dropdown-item"
					onclick="performAction(${upcomingProbationEmployee.employeeId},'Terminated')"><i class="icon-ban-circle"></i> <liferay-ui:message
						key="terminate" />
						</a></li>
						
						<li>
						<a class="dropdown-item " data-toggle="modal" data-target="#extendProbationDetailModal" data-employee-id="${upcomingProbationEmployee.employeeId}"><i class="icon-refresh"></i> <liferay-ui:message
						key="extend" /></a>
						</li>
					</ul>
				</div>
                            
                            
                        </td>
                    </tr>
                </c:forEach>
                <tr></tr>
            </table>
</div>
</div>
</c:if>




<%--Modal start here--%>
<div class="container">
    <div class="modal fade" id="extendProbationDetailModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel"><liferay-ui:message key="new-message" /></h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form id="<portlet:namespace/>extendDetailForm" method="Post">
                        <input type="hidden" class="form-control" id="<portlet:namespace/>employeeId" name="<portlet:namespace />employeeId">
                        <div class="form-group">
                            <label for="<portlet:namespace/>noOfMonth" class="col-form-label"><liferay-ui:message key="month-of-extend" /></label>
                            <select name="<portlet:namespace/>noOfExtendMonth" id="<portlet:namespace/>noOfExtendMonth" class="form-control">
                                <option value=""><liferay-ui:message key="select-extended-month-number" /></option>
                                <option value="1"><liferay-ui:message key="one" /></option>
                                <option value="2"><liferay-ui:message key="two" /></option>
                                <option value="3"><liferay-ui:message key="three" /></option>
                                <option value="4"><liferay-ui:message key="four" /></option>
                                <option value="5"><liferay-ui:message key="five" /></option>
                                <option value="6"><liferay-ui:message key="six" /></option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="<portlet:namespace/>evalutionReview" class="col-form-label"><liferay-ui:message key="evalution-review" /></label>
                            <textarea name="<portlet:namespace/>evalutionReview" id="<portlet:namespace/>evalutionReview" class="form-control"></textarea>
                        </div>
                    </form>
                </div>
                <div class="modal-footer text-right">
                    <button type="button" class="btn btn-outline-danger mr-1" data-dismiss="modal"><liferay-ui:message key="close" /></button>
                    <button type="button" class="btn btn-outline-success" id="<portlet:namespace />extendProbationTimeBtn"><liferay-ui:message key="extend" /></button>
                </div>
            </div>
        </div>
    </div>
</div>
<%--Modal End Here --%>
<script>
    function performAction(employeeId,actionType){
        let url = '${probationActionURL}';
        url = url.replace('PROBATION_ACTION_TYPE',actionType);
        url = url.replace('EMPLOYEE_ID',employeeId);
        if(confirm("Are you sure to "+actionType+" employee?"))
            window.location.href = url;
    }

    $(document).ready(function(){
        var config = {};
        config.namespace = '<portlet:namespace />';
        config.probationActionURL = '${probationActionURL}';

        AXHRMSProbationManagementHrWeb.setConfigs(config);
    });
</script>