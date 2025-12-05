<%@ include file="/init.jsp" %>

<portlet:renderURL var="homeUrl">
    <portlet:param name="selectedYear" value="${selectedYear}"/>
</portlet:renderURL>

<portlet:renderURL var="addHolidayURL">
    <portlet:param name="mvcPath" value="/jsp/holiday-hr-admin/addEditHolidayHrAdmin.jsp" />
</portlet:renderURL>

<portlet:renderURL var="fetchDataWithYearsURL">
    <portlet:param name="mvcRenderCommandName" value="/fetchDataWithYears"/>
    <portlet:param name="selectedYear" value="SELECTED_YEAR"/>
</portlet:renderURL>

<div class="text-right">


</div>

<liferay-ui:error key="holiday-hr-admin-exists" message="holiday-hr-admin-name-is-already-exist" />
<liferay-ui:success key="holiday-hr-admin-deleted" message="holiday-hr-admin-has-been-deleted-successfully" />
<liferay-ui:success key="holiday-hr-admin-added" message="holiday-hr-admin-has-been-successfully-added" />
<liferay-ui:success key="holiday-hr-admin-updated" message="holiday-hr-admin-has-been-successfully-updated" />




<div class="card">
  <div class="card-header d-flex align-items-center justify-content-between">
  <div>
			<select class="form-control " id="selectedYear" onchange="updateURLAndFetchDataHR(this.id)">
    <c:forEach items="${fullList}" var="year">
        <c:if test="${year ne null and year ne ''}">
            <option value="${year}" ${year eq selectedYear ? 'selected' : ''}>${year}</option>
        </c:if>
    </c:forEach>
</select>
</div>


    <a href="${addHolidayURL}" class="btn btn-primary btn-sm">
        <liferay-ui:message key="add-holiday-hr-admin" />
    </a>
</div>
  <div class="card-body mb-0">
<!-- Start -->
<liferay-portlet:renderURL varImpl="iteratorURL" />
    
<liferay-ui:search-container total="${holidaySearchContainer.total}" delta="20" emptyResultsMessage="No-Holiday-found" searchContainer="${holidaySearchContainer}" iteratorURL="${iteratorURL}">
    <liferay-ui:search-container-results results="${holidaySearchContainer.results}" />

    <liferay-ui:search-container-row className="com.ax.hrms.model.Holiday" modelVar="holiday" keyProperty="holidayId">
        <liferay-ui:search-container-column-text name="Holiday Name" value="${holiday.getHolidayName()}" />
        <liferay-ui:search-container-column-text name="Holiday Description" value="${holiday.getDescription()}" />
        
  		<liferay-ui:search-container-column-text name="Holiday Date" value="<%= new java.text.SimpleDateFormat("yyyy-MM-dd").format(holiday.getDate()) %>" />
  		
        <liferay-ui:search-container-column-text name="Holiday Is Floater" value="${holiday.getIsFloater() ? 'Yes' : 'No'}" />

        <liferay-ui:search-container-column-text name="Actions" cssClass="text-center">
        
        
          <portlet:renderURL var="updateHolidayURL">
		                <portlet:param name="mvcRenderCommandName" value="/fetchHoliday"/>
		                <portlet:param name="holidayId" value="${holiday.holidayId}"/>		            
		            </portlet:renderURL>
		            
		              <portlet:actionURL var="deleteHolidayURL" name="/deleteHoliday">
                        <portlet:param name="holidayId" value="${holiday.holidayId}" />
                        <portlet:param name="selectedYear" value="SELECTED_YEAR"/>
                        <portlet:param name="backURL" value="${homeUrl}"/>
                    </portlet:actionURL>
                    
                    
                    <c:set var="isValidYear" value="${holiday.getYear() >= currentYear - 1 && holiday.getYear() <= currentYear + 1}" />
						        <c:set var="btnClass" value="${isValidYear ? '' : 'Btn-disabled'}" />
						        
					<div class="dropdown ">
					<button class="btn fa fa-ellipsis-v dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" >
						<i class="icon-ellipsis-vertical"></i>
					</button>
					<ul class="dropdown-menu">
						<li>
						<a href="${updateHolidayURL }" class="dropdown-item ${btnClass}"><i class="icon-edit"></i> <liferay-ui:message
						key="edit" /></a>
						</li>
						<li>
						<a onclick="deleteHolidayByMasterId('${holiday.holidayId}')"  class=" dropdown-item ${btnClass}"><i class="icon-trash"></i> <liferay-ui:message
						key="delete" /></a>
						</li>
					</ul>
				</div>
                    
                    
                    
                      
            
        </liferay-ui:search-container-column-text>
    </liferay-ui:search-container-row>

    <liferay-ui:search-iterator markupView="lexicon" paginate="true" />
</liferay-ui:search-container>

<!-- end -->

</div>
</div>



<script>
function deleteHolidayByMasterId(holidayId) {	
	console.log(holidayId);
	var ele=document.getElementById("selectedYear");
    var config = {
        namespace: '<portlet:namespace />',
        deleteUrl: '${deleteHolidayURL}',
        selectedYear: ele.value,
        holidayId: holidayId
    };
    
    console.log(config.namespace);
    AxHrmsHolidayHrAdminWebPortlet.setConfigsForDeleteHoliday(config);
}


function updateURLAndFetchDataHR(selectedYear){
	var ele=document.getElementById(selectedYear);
    var config = {
            namespace: '<portlet:namespace />selectedYear',
            renderUrl: '${fetchDataWithYearsURL}',
            selectedYear: ele.value
        };
        AxHrmsHolidayHrAdminWebPortlet.setConfigsForRenderHolidayWithYear(config);	
}


</script>

