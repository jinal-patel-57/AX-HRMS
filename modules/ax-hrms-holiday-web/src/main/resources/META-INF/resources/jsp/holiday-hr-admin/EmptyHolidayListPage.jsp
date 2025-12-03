<%@ include file="/init.jsp" %>

<portlet:renderURL var="addHolidayURL">
    <portlet:param name="mvcPath" value="/jsp/holiday-hr-admin/addEditHolidayHrAdmin.jsp" />
</portlet:renderURL>

<portlet:renderURL var="goBack"/>

<div class="text-right">
    
	<a href="${goBack}" class="btn btn-secondary mt-3 pull-right"><liferay-ui:message key="back" /></a> <!-- Adjust margin as needed -->
    <a href="${addHolidayURL}" class="btn btn-primary mt-3 pull-right">
        <liferay-ui:message key="add-holiday-hr-admin" />
    </a>
</div>

<liferay-ui:error key="holiday-hr-admin-exists" message="holiday-hr-admin-name-is-already-exist" />
<liferay-ui:success key="holiday-hr-admin-deleted" message="holiday-hr-admin-has-been-deleted-successfully" />
<liferay-ui:success key="holiday-hr-admin-added" message="holiday-hr-admin-has-been-successfully-added" />
<liferay-ui:success key="holiday-hr-admin-updated" message="holiday-hr-admin-has-been-successfully-updated" />

<!-- Start -->
<liferay-portlet:renderURL varImpl="iteratorURL" />

<liferay-ui:search-container total="0" emptyResultsMessage="No-Holiday-found" iteratorURL="${iteratorURL}">

<liferay-ui:search-container-results results="${getHoliday}" />
    
    <liferay-ui:search-container-row className="com.ax.hrms.model.Holiday" modelVar="holiday" keyProperty="holidayId">
        <liferay-ui:search-container-column-text name="Holiday Name" value="${holiday.getHolidayName()}" />
        <liferay-ui:search-container-column-text name="Holiday Description" value="${holiday.getDescription()}" />
        
        <liferay-ui:search-container-column-text name="Holiday Date" value="<%= new java.text.SimpleDateFormat("yyyy-MM-dd").format(holiday.getDate()) %>" />
        
        <liferay-ui:search-container-column-text name="Holiday Is Floater" value="${holiday.getIsFloater() ? 'Yes' : 'No'}" />

        <liferay-ui:search-container-column-text name="Actions">
                      
            <c:choose>
                <c:when test="${holiday.getYear() >= currentYear - 1 && holiday.getYear() <= currentYear + 1}">
                    <portlet:renderURL var="updateHolidayURL">
                        <portlet:param name="mvcRenderCommandName" value="/fetchHoliday"/>
                        <portlet:param name="holidayId" value="${holiday.holidayId}"/>                  
                    </portlet:renderURL>
                    <a href="${updateHolidayURL}" class="btn btn-primary"><liferay-ui:message key="update" /></a>
                </c:when>
                <c:otherwise>
                    <button class="btn btn-primary" style="height: 40px; width: 70px;" disabled><liferay-ui:message key="update" /></button>
                </c:otherwise>
            </c:choose>
            
            <c:choose>
                <c:when test="${holiday.getYear() >= currentYear - 1 && holiday.getYear() <= currentYear + 1}">
                    <portlet:actionURL var="deleteHolidayURL" name="/deleteHoliday">
                        <portlet:param name="holidayId" value="${holiday.holidayId}" />
                    </portlet:actionURL>
                    <button onclick="deleteHolidayByMasterId('${holiday.holidayId}')" class="btn btn-danger"><liferay-ui:message key="delete" /></button>
                </c:when>
                <c:otherwise>
                    <button class="btn btn-danger" style="height: 40px; width: 70px;" disabled><liferay-ui:message key="delete" /></button>
                </c:otherwise>
            </c:choose>
            
        </liferay-ui:search-container-column-text>
    </liferay-ui:search-container-row>

    <liferay-ui:search-iterator markupView="lexicon" paginate="true" />
    
</liferay-ui:search-container>
<!-- end -->

<script>
function deleteHolidayByMasterId(holidayId) { 
    console.log(holidayId);
    var config = {
        namespace: '<portlet:namespace />',
        deleteUrl: '${deleteHolidayURL}',
        holidayId: holidayId
    };
    
    console.log(config.namespace);
    AxHrmsHolidayHrAdminWebPortlet.setConfigsForDeleteHoliday(config);
}

function updateURLAndFetchData(selectedYear){
    var ele=document.getElementById(selectedYear);
    var config = {
        namespace: '<portlet:namespace />selectedYear',
        renderUrl: '${fetchDataWithYearsURL}',
        selectedYear: ele.value
    };
    AxHrmsHolidayHrAdminWebPortlet.setConfigsForRenderHolidayWithYear(config);  
}
</script>
