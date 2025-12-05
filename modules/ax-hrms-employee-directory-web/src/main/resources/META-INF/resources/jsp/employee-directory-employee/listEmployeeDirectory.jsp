<%@ include file="/init.jsp" %>

<portlet:renderURL var="searchDataURL">
    <portlet:param name="mvcRenderCommandName" value="/serachData"/>
    <portlet:param name="searchQuery" value="SEARCHQUERY"/>
</portlet:renderURL>

<portlet:renderURL var="filterDataURL">
    <portlet:param name="mvcRenderCommandName" value="/filterData"/>
    <portlet:param name="selectedDesig" value="SELECTEDVALUE"/>
    <portlet:param name="selectedDepart" value="SELECTEDVALUE"/>
    <portlet:param name="searchQuery" value="SEARCHQUERY"/>
</portlet:renderURL>



<liferay-ui:error key="employee-hr-admin-exists" message="employee-hr-admin-name-is-already-exist" />
<liferay-ui:success key="employee-hr-admin-deleted" message="employee-hr-admin-has-been-deleted-successfully" />
<liferay-ui:success key="employee-hr-admin-added" message="employee-hr-admin-has-been-successfully-added" />
<liferay-ui:success key="employee-hr-admin-updated" message="employee-hr-admin-has-been-successfully-updated" />




<div class="card">
    <div class="card-header d-flex justify-content-between align-items-center">
        <div>
            <strong>List of Employees</strong>
        </div>

        <div class="d-flex align-items-center">
            <form class="form-inline mr-2" action="${searchDataURL}" method="post">
                <input type="text" name="<portlet:namespace />searchQuery" value="${searchedValue}" class="form-control form-control-sm mr-1" placeholder="Search..." id="search" onchange="SearchValue()">
                <button type="submit" class="btn btn-outline-dark btn-sm"><liferay-ui:message key="search" /></button>
            </form>

            <form class="form-inline" action="${filterDataURL}" method="post">
                <select class="custom-select custom-select-sm mr-1" id="selectedDesig" name="<portlet:namespace />selectedDesig">
                    <option value="0" selected><liferay-ui:message key="desig" /></option>
                    <c:forEach items="${designationList}" var="designation">
                        <option value="${designation.designationMasterId}" ${designation.designationMasterId == designationValue? 'selected':''}>${designation.designationName}</option>
                    </c:forEach>
                </select>

                <select class="custom-select custom-select-sm mr-1" id="selectedDepart" name="<portlet:namespace />selectedDepart">
                    <option value="0" selected><liferay-ui:message key="depart" /></option>
                    <c:forEach items="${departmentList}" var="department">
                        <option value="${department.departmentMasterId}" ${department.departmentMasterId == departmentValue? 'selected':''}>${department.departmentName}</option>
                    </c:forEach>
                </select>

                <button type="submit" class="btn btn-outline-dark btn-sm">
                    <liferay-ui:message key="filter" />
                </button>
            </form>
        </div>
    </div>

  <div class="card-body mb-0 pb-0">
<liferay-portlet:renderURL varImpl="iteratorURL" />
    
<liferay-ui:search-container total="${directorySearchContainer.total}" delta="20" searchContainer="${directorySearchContainer}" emptyResultsMessage="No-Employee-found" iteratorURL="${iteratorURL}">
    <liferay-ui:search-container-results results="${directorySearchContainer.results}" />
        <liferay-ui:search-container-row className="com.ax.hrms.model.CustomEmployeeDetailsDTO" modelVar="employee" keyProperty="employeeId">
        <liferay-ui:search-container-column-text name="Employee Name" value="${employee.getFirstName()} ${employee.getLastName()}" />
        <liferay-ui:search-container-column-text name="Official Email" value="${employee.getOfficialEmail()}" />
        <liferay-ui:search-container-column-text name="Mobile Number" value="${employee.getMobileNo()}" />
        <liferay-ui:search-container-column-text name="Date Of Birth" value="${employee.getDateOfBirth()}" />
        <liferay-ui:search-container-column-text name="Designation" value="${employee.getDesignationName()}"/>
                <liferay-ui:search-container-column-text name="Department">
                    <c:forEach var="departmentName" items="${employee.departmentList}">
                        <span style="display: block;">${departmentName}</span>
                    </c:forEach>
                </liferay-ui:search-container-column-text>
        <liferay-ui:search-container-column-text name="Skype Id" value="${employee.getSkypeId()}" />
            <c:if test="${isHR}">
                <liferay-portlet:renderURL var="viewEmployeeFullDirectory">
                    <liferay-portlet:param name="mvcRenderCommandName" value="/viewEmployeeFullDirectory"/>
                    <liferay-portlet:param name="employeeId" value="${employee.getEmployeeId()}"/>
                </liferay-portlet:renderURL>
                <liferay-ui:search-container-column-text name="Action" cssClass="text-right">
                
                
                <div class="dropdown ">
					<button class="btn fa fa-ellipsis-v dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" >
						<i class="icon-ellipsis-vertical"></i>
					</button>
					<ul class="dropdown-menu">
						<li>
						<a href="${viewEmployeeFullDirectory }" class="dropdown-item "><i class="icon-eye-open"></i> <liferay-ui:message
						key="view" /></a>
						</li>
					</ul>
				</div>
				
                
                
                </liferay-ui:search-container-column-text>
            </c:if>

    </liferay-ui:search-container-row>

    <liferay-ui:search-iterator searchContainer="${directorySearchContainer}" markupView="lexicon" paginate="true" />
    
</liferay-ui:search-container> 

</div>
</div>





<script>

function SearchValue() {
	
    var ele = document.getElementById('search').value;
    console.log(ele);
    var config = {
        namespace: '<portlet:namespace />search',
        renderUrl: '${searchDataURL}',
        searchValue: ele
    };						
    AxHrmsEmployeeDirectoryHrAdminWebPortlet.setConfigsForSearchData(config);
}

function updateURLAndFetchData() {
    var eleDesig = document.getElementById('selectedDesig');
    var eleDepart = document.getElementById('selectedDepart');
    var eleSearch = document.getElementById('searchQuery');

    var selectedDesig = eleDesig.value;
    var selectedDepart = eleDepart.value;
	var selectedValue = eleSearch.value;
	
    console.log(selectedDesig);
    console.log(selectedDepart);

    var config = {
        namespaceDesignation: '<portlet:namespace />selectedDesig',
        namespaceDepartment: '<portlet:namespace />selectedDepart',
        namespaceSearch: '<portlet:namespace />searchQuery',
        renderUrl: '${filterDataURL}',
        selectedDesig: selectedDesig,
        selectedDepart: selectedDepart,
        searchedValue: selectedValue
    };
    AxHrmsEmployeeDirectoryHrAdminWebPortlet.setConfigsForRenderFetchData(config);	
}
</script>