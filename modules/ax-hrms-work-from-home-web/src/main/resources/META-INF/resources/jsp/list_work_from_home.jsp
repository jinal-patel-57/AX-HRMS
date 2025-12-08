<%@ include file="/init.jsp" %>
<%@ page import="com.ax.hrms.model.WorkFromHome" %>

<!-- Add Button -->
<portlet:renderURL var="addWFHForm">
    <portlet:param name="mvcPath" value="/jsp/add_edit_work_from_home.jsp" />
</portlet:renderURL>

<div class="card">
    <div class="card-header d-flex justify-content-end">
        <a href="${addWFHForm}" class="btn btn-primary btn-sm">Add Work From Home</a>
    </div>

    <div class="card-body">

        <liferay-portlet:renderURL varImpl="iteratorURL" />

        <liferay-ui:search-container
                searchContainer="${wfhSC}"
                total="${count}"
                delta="10"
                emptyResultsMessage="No WFH records found">

            <liferay-ui:search-container-results results="${wfhSC.results}" />

            <liferay-ui:search-container-row
                    className="com.ax.hrms.model.WorkFromHome"
                    modelVar="wfh"
                    keyProperty="workFromHomeRequestId">

                <liferay-ui:search-container-column-text
                        name="User ID"
                        value="${wfh.userId}" />

                <liferay-ui:search-container-column-text
                        name="Team Mail"
                        value="${wfh.teamMailId}" />

                <liferay-ui:search-container-column-text
                        name="Start Date"
                        value="${wfh.startDate}" />

                <liferay-ui:search-container-column-text
                        name="End Date"
                        value="${wfh.endDate}" />

                <liferay-ui:search-container-column-text name="Actions">

                    <!-- View Page -->
                    <portlet:renderURL var="viewWFH">
                        <portlet:param name="mvcPath" value="/jsp/view_work_from_home.jsp" />
                        <portlet:param name="workFromHomeRequestId" value="${wfh.workFromHomeRequestId}" />
                    </portlet:renderURL>

                    <!-- EDIT using same add_edit_work_from_home.jsp -->
                    <portlet:renderURL var="editWFH">
                        <portlet:param name="mvcPath" value="/jsp/add_edit_work_from_home.jsp" />
                        <portlet:param name="workFromHomeRequestId" value="${wfh.workFromHomeRequestId}" />
                    </portlet:renderURL>

                    <!-- DELETE -->
                    <portlet:actionURL var="deleteWFH" name="/deleteWFH">
                        <portlet:param name="workFromHomeRequestId" value="${wfh.workFromHomeRequestId}" />
                    </portlet:actionURL>

                    <div class="dropdown">
                        <button class="btn fa fa-ellipsis-v dropdown-toggle" data-toggle="dropdown"></button>
                        <ul class="dropdown-menu">
                            <li><a href="${viewWFH}" class="dropdown-item">View</a></li>
                            <li><a href="${editWFH}" class="dropdown-item">Edit</a></li>
                            <li>
                                <a href="${deleteWFH}" class="dropdown-item"
                                   onclick="return confirm('Delete WFH request?');">Delete</a>
                            </li>
                        </ul>
                    </div>

                </liferay-ui:search-container-column-text>

            </liferay-ui:search-container-row>

            <liferay-ui:search-iterator />
        </liferay-ui:search-container>

    </div>
</div>
