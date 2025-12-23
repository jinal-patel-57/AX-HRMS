<%@ include file="../../init.jsp" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<liferay-ui:success key="wfh-approved" message="Work From Home request Approved successfully!" />
<liferay-ui:success key="wfh-rejected" message="Work From Home request Rejected successfully!" />
<liferay-ui:success key="wfh-cancelled" message="Work From Home request Cancelled successfully!" />
<liferay-ui:error key="wfh-error" message="Sorry,Some Error Found!" />

<div class="card">
    <div class="card-header">
        <strong>List Work From Home Requests</strong>
    </div>

    <div class="card-body">
        <liferay-ui:search-container
                searchContainer="${wfhSC}"
                emptyResultsMessage="no-wfh-request-found">

            <liferay-ui:search-container-row
                    className="com.ax.hrms.work.from.home.web.hr.dto.WFHRequestDto"
                    modelVar="wfh"
                    keyProperty="workFromHomeRequestId">
                <liferay-ui:search-container-column-text
                        name="Status"
                        value="${wfh.status}" />
                <liferay-ui:search-container-column-text
                        name="Employee Name"
                        value="${wfh.employeeName}" />

                <liferay-ui:search-container-column-text name="Start Date">
                    <fmt:formatDate value="${wfh.startDate}" pattern="dd/MM/yyyy" />
                </liferay-ui:search-container-column-text>

                <liferay-ui:search-container-column-text name="End Date">
                    <fmt:formatDate value="${wfh.endDate}" pattern="dd/MM/yyyy" />
                </liferay-ui:search-container-column-text>

                <liferay-ui:search-container-column-text
                        name="Reason"
                        value="${wfh.reason}" />

       <liferay-ui:search-container-column-text name="Request Date">
                    <fmt:formatDate value="${wfh.requestDate}" pattern="dd/MM/yyyy" />
                </liferay-ui:search-container-column-text>

                <liferay-ui:search-container-column-text
                        name="Team Mail"
                        value="${wfh.teamMailId}" />

                <liferay-ui:search-container-column-text name="Action">

                    <portlet:actionURL name="/wfh/approve" var="approveURL">
                        <portlet:param name="wfhId" value="${wfh.workFromHomeRequestId}" />
                    </portlet:actionURL>

                    <portlet:actionURL name="/wfh/reject" var="rejectURL">
                        <portlet:param name="wfhId" value="${wfh.workFromHomeRequestId}" />
                    </portlet:actionURL>

                    <portlet:actionURL name="/wfh/cancel" var="cancelURL">
                        <portlet:param name="wfhId" value="${wfh.workFromHomeRequestId}" />
                    </portlet:actionURL>

                    <portlet:renderURL var="viewURL">
                        <portlet:param name="mvcRenderCommandName" value="/wfh/view" />
                        <portlet:param name="wfhId" value="${wfh.workFromHomeRequestId}" />
                    </portlet:renderURL>

                    <div class="dropdown">
                        <button class="btn fa fa-ellipsis-v dropdown-toggle"
                                data-toggle="dropdown"><i class="icon-ellipsis-vertical"></i></button>

                        <ul class="dropdown-menu">
                            <c:choose>
                                <c:when test="${wfh.status.toLowerCase() eq 'pending'}">
                                    <li><a href="${approveURL}" class="dropdown-item">Approve</a></li>
                                    <li><a href="${rejectURL}" class="dropdown-item">Reject</a></li>
                                    <li><a href="${cancelURL}" class="dropdown-item">Cancel</a></li>
                                </c:when>

                                <c:when test="${wfh.status.toLowerCase() eq 'approved'
                                    || wfh.status.toLowerCase() eq 'rejected'}">
                                    <li><a href="${cancelURL}" class="dropdown-item">Cancel</a></li>
                                </c:when>
                            </c:choose>

                            <li><a href="${viewURL}" class="dropdown-item">View</a></li>
                        </ul>
                    </div>
                </liferay-ui:search-container-column-text>

            </liferay-ui:search-container-row>

            <liferay-ui:search-iterator markupView="lexicon" />
        </liferay-ui:search-container>
    </div>
</div>
