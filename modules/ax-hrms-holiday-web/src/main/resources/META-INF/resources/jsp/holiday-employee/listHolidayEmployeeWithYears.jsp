<%@ include file="/init.jsp" %>
<portlet:renderURL var="fetchDataWithYearsURL">
    <portlet:param name="mvcRenderCommandName" value="/fetchEmployeeWithYears"/>
    <portlet:param name="selectedYear" value="SELECTED_YEAR"/>
</portlet:renderURL>

<div class="text-right">

    <select class="btn btn-secondary mt-3" id="selectedYear2" onchange="updateURLAndFetchData(this.id)">
        <c:forEach items="${YearList}" var="year">
            <c:if test="${year ne null and year ne ''}">
                <option value="${year}" ${year eq curr ? 'selected' : ''}>${year}</option>
            </c:if>
        </c:forEach>
    </select>

</div>

<!-- Start -->

<liferay-portlet:renderURL varImpl="iteratorURL" />

<liferay-ui:search-container total="${holidaySearchContainer.total}" delta="3" emptyResultsMessage="No-Holiday-found" searchContainer="${holidaySearchContainer}" iteratorURL="${iteratorURL}">
    <liferay-ui:search-container-results results="${holidaySearchContainer.results}" />

    <liferay-ui:search-container-row className="com.ax.hrms.model.Holiday" modelVar="holiday" keyProperty="holidayId">
        <liferay-ui:search-container-column-text name="Holiday Name" value="${holiday.getHolidayName()}" />
        <liferay-ui:search-container-column-text name="Holiday Description" value="${holiday.getDescription()}" />

        <liferay-ui:search-container-column-text name="Holiday Date" value="<%= new java.text.SimpleDateFormat("yyyy-MM-dd").format(holiday.getDate()) %>" />

        <liferay-ui:search-container-column-text name="Holiday Is Floater" value="${holiday.getIsFloater() ? 'Yes' : 'No'}" />

    </liferay-ui:search-container-row>

    <liferay-ui:search-iterator markupView="lexicon" paginate="true" />
</liferay-ui:search-container>

<!-- end -->

<script>
    function updateURLAndFetchData(selectedYear2){
        var ele=document.getElementById(selectedYear2);
        var demo = ele.value;
        console.log("Selected Value is "+demo);
        var config = {
            namespace: '<portlet:namespace />selectedYear',
            renderUrl: '${fetchDataWithYearsURL}',
            selectedYear: ele.value
        };
        AxHrmsHolidayEmployeeWebPortlet.setConfigsForRenderHolidayWithYear(config);
    }


</script>