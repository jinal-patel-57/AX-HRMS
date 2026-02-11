<%@ include file="../../init.jsp" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<liferay-ui:success key="wfh-approved" message="Work From Home request Approved successfully!" />
<liferay-ui:success key="wfh-rejected" message="Work From Home request Rejected successfully!" />
<liferay-ui:success key="wfh-cancelled" message="Work From Home request Cancelled successfully!" />
<liferay-ui:error key="wfh-error" message="Sorry,Some Error Found!" />
<portlet:renderURL var="searchWFHURL">
    <portlet:param name="mvcRenderCommandName" value="/wfh/search"/>
</portlet:renderURL>
<div class="card">
    <div class="card-header">

<!--<input type="text"
       id="searchInput"

       class="form-control form-control-sm mr-1"
       placeholder="Search..."
       value="${param.searchQuery}" />
             <a href="javascript:void(0);"
                class="btn btn-outline-dark btn-sm"
                onclick="redirectToSearch()">
                 <liferay-ui:message key="search" />
             </a>-->


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
                        name="Modified By"
                        value="${wfh.modifiedBy}" />

                        <liferay-ui:search-container-column-text
                        name="Employee Name"
                        value="${wfh.employeeName}" />

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


            <c:set var="isSameEmployee"
                   value="${currentEmployeeId == wfh.employeeId}" />

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
                                data-toggle="dropdown">
                            <i class="icon-ellipsis-vertical"></i>
                        </button>

                        <ul class="dropdown-menu">

                            <!-- ACTIONS ONLY IF NOT SAME EMPLOYEE -->
                            <c:if test="${!isSameEmployee}">
                                <c:choose>

                                    <c:when test="${wfh.status.toLowerCase() eq 'pending'}">
                                        <li>
                                            <a href="#"
                                               class="dropdown-item wfh-action-btn"
                                               data-title="Approve Work From Home"
                                               data-url="${approveURL}">
                                                <i class="icon-ok"></i> Approve
                                            </a>
                                        </li>

                                        <li>
                                            <a href="#"
                                               class="dropdown-item wfh-action-btn"
                                               data-title="Reject Work From Home"
                                               data-url="${rejectURL}">
                                                <i class="icon-ban-circle"></i> Reject
                                            </a>
                                        </li>

                                        <li>
                                            <a href="#"
                                               class="dropdown-item wfh-action-btn"
                                               data-title="Cancel Work From Home"
                                               data-url="${cancelURL}">
                                                <i class="icon-remove"></i> Cancel
                                            </a>
                                        </li>
                                    </c:when>

                                    <c:when test="${wfh.status.toLowerCase() eq 'approved'
                                        || wfh.status.toLowerCase() eq 'rejected'}">
                                        <li>
                                            <a href="#"
                                               class="dropdown-item wfh-action-btn"
                                               data-title="Cancel Work From Home"
                                               data-url="${cancelURL}">
                                                <i class="icon-remove"></i> Cancel
                                            </a>
                                        </li>
                                    </c:when>

                                </c:choose>
                            </c:if>

                            <!-- VIEW IS ALWAYS ALLOWED -->
                            <li>
                                <a href="${viewURL}" class="dropdown-item">
                                    <i class="icon-eye-open"></i> View
                                </a>
                            </li>

                        </ul>
                    </div>

                </liferay-ui:search-container-column-text>

            </liferay-ui:search-container-row>

            <liferay-ui:search-iterator markupView="lexicon" />
        </liferay-ui:search-container>
    </div>
</div>

<div class="modal" id="wfhActionModal" tabindex="-1">
  <div class="modal-dialog modal-dialog-centered modal-lg">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">Modal title</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
    <form method="post" id="wfhActionForm">
          <div class="modal-body">
          <textarea class="form-control"
                    name="<portlet:namespace/>actionComment"
                    id="<portlet:namespace/>actionComment"
                    placeholder="Enter comment"
                    rows="4"></textarea>

          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
            <button type="submit" class="btn btn-primary">Save changes</button>
          </div>
        </div>
    </form>
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
$(function () {

    const commentSelector = '#<portlet:namespace/>actionComment';

    $(document).on('click', '.wfh-action-btn', function (e) {
        e.preventDefault();

        const actionUrl = $(this).data('url');
        const title = $(this).data('title');

        // Set form action
        $('#wfhActionForm').attr('action', actionUrl);

        // Set modal title
        $('#wfhActionModal .modal-title').text(title);

        // Clear textarea
        $(commentSelector).val('');

        // Show modal (Bootstrap way)
        $('#wfhActionModal').show();
    });

});
</script>

<script>
$(document).on('click', '[data-dismiss="modal"], .modal .close', function () {

    // Reset form
    $('#wfhActionForm')[0].reset();

    // Clear modal title (optional but clean)
    $('#wfhActionModal .modal-title').text('');

     $('#wfhActionForm').attr('action', '');

    // Close modal (same method you used to open)
    $('#wfhActionModal').hide();
});




/*function redirectToSearch() {
    var value = document.getElementById('searchInput').value;

    var url = '${searchWFHURL}' +
              '&<portlet:namespace/>searchQuery=' +
              encodeURIComponent(value);

    window.location.href = url;
}*/
</script>

