<%@ include file="../../init.jsp" %>
<%@ page import="com.ax.hrms.work.from.home.web.employee.dto.WFHRequestDto" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<liferay-ui:success key="wfh-added" message="Work From Home request added successfully!" />
<liferay-ui:success key="wfh-updated" message="Work From Home request updated successfully!" />

<portlet:renderURL var="addWFHForm">
    <portlet:param name="mvcPath" value="/jsp/ax-hrms-work-from-home-employee/add_edit_work_from_home.jsp" />
</portlet:renderURL>

<div class="card">
    <div class="card-header d-flex justify-content-end">
        <a href="${addWFHForm}" class="btn btn-primary btn-sm">Add Work From Home</a>
    </div>

    <div class="card-body">

        <liferay-portlet:renderURL varImpl="iteratorURL" />

        <liferay-ui:search-container
                searchContainer="${wfhSC}"
                emptyResultsMessage="No WFH records found">

            <!-- FIXED -->
            <liferay-ui:search-container-results />

            <liferay-ui:search-container-row
                    className="com.ax.hrms.work.from.home.web.employee.dto.WFHRequestDto"
                    modelVar="wfh"
                    keyProperty="workFromHomeRequestId">
                <liferay-ui:search-container-column-text name="Status" value="${wfh.status}" />
                <liferay-ui:search-container-column-text name="Employee Name" value="${wfh.employeeName}" />
                                <liferay-ui:search-container-column-text name="Start Date">
                                    <fmt:formatDate value="${wfh.startDate}" pattern="dd/MM/yyyy" />
                                </liferay-ui:search-container-column-text>

                                <liferay-ui:search-container-column-text name="End Date">
                                    <fmt:formatDate value="${wfh.endDate}" pattern="dd/MM/yyyy" />
                                </liferay-ui:search-container-column-text>
                <liferay-ui:search-container-column-text
                        name="Reason"
                        value="${wfh.reason}" />
                <liferay-ui:search-container-column-text name="Team Mail" value="${wfh.teamMailId}" />

               <liferay-ui:search-container-column-text name="Request Date">
                    <fmt:formatDate value="${wfh.requestDate}" pattern="dd/MM/yyyy" />
                </liferay-ui:search-container-column-text>
                <liferay-ui:search-container-column-text name="Actions">

                    <portlet:renderURL var="viewWFH">
                        <portlet:param name="mvcRenderCommandName" value="/viewWFH" />
                        <portlet:param name="workFromHomeRequestId" value="${wfh.workFromHomeRequestId}" />
                    </portlet:renderURL>

                    <portlet:renderURL var="editWFH">
                        <portlet:param name="mvcRenderCommandName" value="/editWFHForm" />
                        <portlet:param name="workFromHomeRequestId" value="${wfh.workFromHomeRequestId}" />
                    </portlet:renderURL>

                    <portlet:actionURL var="deleteWFH" name="/deleteWFH">
                        <portlet:param name="workFromHomeRequestId" value="${wfh.workFromHomeRequestId}" />
                    </portlet:actionURL>

                    <div class="dropdown">
                        <button class="btn fa fa-ellipsis-v dropdown-toggle" data-toggle="dropdown">
                            <i class="icon-ellipsis-vertical"></i>
                        </button>

                        <ul class="dropdown-menu">
                            <li><a href="${viewWFH}" class="dropdown-item">View</a></li>

                            <c:if test="${wfh.status == 'Pending'}">
                                <li><a href="${editWFH}" class="dropdown-item">Edit</a></li>
                                <li><a href="${deleteWFH}" class="dropdown-item"
                                       onclick="return confirm('Delete WFH request?');">Delete</a></li>
                            </c:if>
                        </ul>
                    </div>

                </liferay-ui:search-container-column-text>

            </liferay-ui:search-container-row>

            <liferay-ui:search-iterator markupView="lexicon" />

        </liferay-ui:search-container>
    </div>
</div>
