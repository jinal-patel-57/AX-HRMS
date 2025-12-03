<%@ include file="/init.jsp" %>

<portlet:renderURL var="filterDataURL">
	<portlet:param name="mvcRenderCommandName" value="/" />

</portlet:renderURL>



<div class="card">
  <div class="card-header d-flex align-items-center justify-content-between">
        <div>
            <strong> <liferay-ui:message key="list-of-leave-balance"/> </strong>
        </div>

        <div class="d-flex align-items-center">
            <form class="form-inline" action="${filterDataURL}" method="post">
                <select class="custom-select custom-select-sm mr-1" id="selectedYear" name="<portlet:namespace />selectedYear">
 					<option value="0" selected><liferay-ui:message key="Select Year" /></option>
                    <c:forEach items="${yearList}" var="year">
                        <option value="${year}" ${year == selectedYear ? 'selected' : '' }>${year}</option>
                    </c:forEach>               
                     </select>

                <select class="custom-select custom-select-sm mr-1" id="selectedEmployee" name="<portlet:namespace />selectedEmployee">
                    <option value="0" selected><liferay-ui:message key="Select Employee" /></option>
                    <c:forEach items="${employeeDetailsList}" var="employee">
                        <option value="${employee.employeeId}" ${employee.employeeId == selectedEmployee ? 'selected' : '' }>${employee.firstName} ${employee.lastName} (${employee.employeeCode})</option>
                    </c:forEach>
                </select>

                <button type="submit" class="btn btn-outline-dark btn-sm">
                    <liferay-ui:message key="filter" />
                </button>
            </form>
        </div>

</div>
  <div class="card-body mb-0 pb-0">

<liferay-portlet:renderURL varImpl="iteratorURL">
</liferay-portlet:renderURL>

<liferay-ui:search-container total="${leaveBalanceHistorySearchContainer.total}"
	delta="3" emptyResultsMessage="no-leave-balance-data"
	searchContainer="${leaveBalanceHistorySearchContainer}" iteratorURL="${iteratorURL}">
	<liferay-ui:search-container-results
		results="${leaveBalanceHistorySearchContainer.results}" />

	<liferay-ui:search-container-row
		className="ax.hrms.hr.leave.balance.history.dto.LeaveBalanceHistoryDto" modelVar="leaveBalance"
		keyProperty="leaveBalanceHistoryId">




		<liferay-ui:search-container-column-text name="Employee Name"
			value="${leaveBalance.employeeName}"/>
		<liferay-ui:search-container-column-text name="Leave Type Name"
			value="${leaveBalance.leaveTypeName}" />
		<liferay-ui:search-container-column-text name="Year"
			value="${leaveBalance.year}" />
		<liferay-ui:search-container-column-text name="No of Used Leaves"
			value="${leaveBalance.noOfUsedLeave}" />
		<liferay-ui:search-container-column-text name="No of Remaining Leaves "
			value="${leaveBalance.noOfRemainingLeave}" />


		
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator searchContainer="${leaveBalanceHistorySearchContainer}"
		markupView="lexicon" paginate="true" />
</liferay-ui:search-container>




</div>
</div>

