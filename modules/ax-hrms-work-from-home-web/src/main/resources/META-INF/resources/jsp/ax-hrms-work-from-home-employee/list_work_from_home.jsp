<%@ include file="../../init.jsp" %>
<%@ page import="com.ax.hrms.work.from.home.web.employee.dto.WFHRequestDto" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<liferay-ui:success key="wfh-added" message="Work From Home request added successfully!" />
<liferay-ui:success key="wfh-updated" message="Work From Home request updated successfully!" />

<portlet:renderURL var="addWFHForm">
    <portlet:param name="mvcRenderCommandName" value="/addWFHForm" />
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
                <liferay-ui:search-container-column-text name="Modified By" value="${wfh.modifiedBy}" />

                                <liferay-ui:search-container-column-text name="Start Date">
                                    <fmt:formatDate value="${wfh.startDate}" pattern="dd-MM-yyyy" />
                                </liferay-ui:search-container-column-text>

                                <liferay-ui:search-container-column-text name="End Date">
                                    <fmt:formatDate value="${wfh.endDate}" pattern="dd-MM-yyyy" />
                                </liferay-ui:search-container-column-text>
                <liferay-ui:search-container-column-text
                        name="Reason"
                        value="${wfh.reason}" />

               <liferay-ui:search-container-column-text name="Request Date">
                    <fmt:formatDate value="${wfh.requestDate}" pattern="dd-MM-yyyy" />
                </liferay-ui:search-container-column-text>
                <liferay-ui:search-container-column-text name="Actions">

                    <portlet:renderURL var="viewWFH">
                        <portlet:param name="mvcRenderCommandName" value="/viewWFH" />
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
                            <li><a href="${viewWFH}" class="dropdown-item"><i class="icon-eye-open"></i> View</a></li>

                            <c:if test="${wfh.status == 'Pending'}">


                               <li>
                                   <a href="javascript:void(0);"
                                      class="dropdown-item delete-wfh-btn"
                                      data-delete-url="${deleteWFH}">
                                       <i class="icon-trash"></i> Delete
                                   </a>
                               </li>
                            </c:if>
                        </ul>
                    </div>

                </liferay-ui:search-container-column-text>

            </liferay-ui:search-container-row>

            <liferay-ui:search-iterator markupView="lexicon" />

        </liferay-ui:search-container>
    </div>
</div>
<script>
$('.table-responsive').on('show.bs.dropdown', function () {
     $('.table-responsive').css( "overflow", "inherit" );
});

$('.table-responsive').on('hide.bs.dropdown', function () {
     $('.table-responsive').css( "overflow", "auto" );
})
</script>

<script>
document.addEventListener("DOMContentLoaded", function () {

    document.querySelectorAll(".delete-wfh-btn").forEach(function (button) {

        button.addEventListener("click", function () {

            const deleteUrl = this.getAttribute("data-delete-url");

            Liferay.Util.openConfirmModal({
                title: "Delete Work From Home Request",
                message: "Are you sure you want to delete this Work From Home request? This action cannot be undone.",
                confirmButtonLabel: "Delete",
                cancelButtonLabel: "Cancel",
                onConfirm: function (confirmed) {

                    if (confirmed) {
                        window.location.href = deleteUrl;
                    }

                }
            });

        });

    });

});
</script></script>