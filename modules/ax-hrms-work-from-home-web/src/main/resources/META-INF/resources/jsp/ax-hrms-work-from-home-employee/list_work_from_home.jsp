<%@ include file="../../init.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page import="com.ax.hrms.work.from.home.web.employee.dto.WFHRequestDto" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<liferay-ui:success key="wfh-added" message="Work From Home request added successfully!" />
<liferay-ui:success key="wfh-updated" message="Work From Home request updated successfully!" />
<liferay-ui:success key="delete-success" message="Work From Home request deleted successfully!" />
<liferay-ui:error key="wfh-overlap-error" message="You have overlapping Work From Home. Kindly check and apply accordingly."/>

<portlet:renderURL var="addWFHForm">
    <portlet:param name="mvcRenderCommandName" value="/addWFHForm" />
</portlet:renderURL>

<div class="card">
    <div class="card-header d-flex justify-content-end">
        <a href="${addWFHForm}" class="btn btn-primary btn-sm">Request Work From Home</a>
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
                <%-- <liferay-ui:search-container-column-text name="Status" value="${wfh.status}" /> --%>

                       <%--         <liferay-ui:search-container-column-text name="Start Date">
                                    <fmt:formatDate value="${wfh.startDate}" pattern="dd-MMM-yyyy" />
                                </liferay-ui:search-container-column-text>

                                <liferay-ui:search-container-column-text name="End Date">
                                    <fmt:formatDate value="${wfh.endDate}" pattern="dd-MMM-yyyy" />
                                </liferay-ui:search-container-column-text> --%>

                    <liferay-ui:search-container-column-text name="WFH Period">
                        <fmt:formatDate value="${wfh.startDate}" pattern="dd-MMM-yyyy" />
                        to
                        <fmt:formatDate value="${wfh.endDate}" pattern="dd-MMM-yyyy" />
                    </liferay-ui:search-container-column-text>

                 <liferay-ui:search-container-column-text name="No. of Days" value="${wfh.noOfDays}" />
            <%--   <liferay-ui:search-container-column-text
                        name="Reason"
                        value="${wfh.reason}" />--%>

            <%--   <liferay-ui:search-container-column-text name="Request Date">
                    <fmt:formatDate value="${wfh.requestDate}" pattern="dd-MMM-yyyy" />
                </liferay-ui:search-container-column-text>--%>
                <liferay-ui:search-container-column-text name="Modified By" value="${wfh.modifiedBy}" />

                <liferay-ui:search-container-column-text name="Status"
					value='<span class="status ${fn:toLowerCase(fn:replace(wfh.status, " ", "-"))}">${wfh.status}</span>'/>

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
<div class="modal fade" id="deleteWFHModal" tabindex="-1"
     aria-labelledby="deleteWFHModalLabel"
     aria-hidden="true">

    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">

            <div class="modal-header text-white">
                <h5 class="modal-title" id="deleteWFHModalLabel">
                 <i class="icon-warning-sign"></i>
                    Confirm Delete
                </h5>
                <button type="button" class="close " data-dismiss="modal">
                                   <span>&times;</span>
                               </button>
            </div>

            <div class="modal-body text-center">
                <p class="mb-2">
                    <strong>This action cannot be undone.</strong>
                </p>
                <p>
                    Are you sure you want to delete this Work From Home request?
                </p>
            </div>

            <div class="modal-footer justify-content-center">
                <button type="button"
                        class="btn btn-outline-secondary btn-sm"
                        data-dismiss="modal">
                    Cancel
                </button>

                <button type="button"
                        id="confirmDeleteWFHBtn"
                        class="btn btn-danger btn-sm">
                    Delete
                </button>
            </div>

        </div>
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

    let deleteUrl = "";

    // Handle delete button click in dropdown
    document.querySelectorAll(".delete-wfh-btn").forEach(function (button) {

        button.addEventListener("click", function () {

            deleteUrl = this.getAttribute("data-delete-url");

            const modalElement = document.getElementById("deleteWFHModal");

            if (modalElement) {
                const modalInstance = new bootstrap.Modal(modalElement);
                modalInstance.show();
            }
        });
    });

    // Handle confirm delete click
    const confirmBtn = document.getElementById("confirmDeleteWFHBtn");

    if (confirmBtn) {
        confirmBtn.addEventListener("click", function () {

            if (deleteUrl) {
                this.disabled = true; // prevent double click
                window.location.href = deleteUrl;
            }
        });
    }

});
</script>