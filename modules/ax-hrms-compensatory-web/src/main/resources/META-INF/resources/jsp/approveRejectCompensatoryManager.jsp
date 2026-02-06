<%@ include file="/init.jsp" %>

<portlet:actionURL name="/approveRejectCompensatoryData" var="approveCompensatoryDataURL"/>
<liferay-ui:success key="compensation-request-rejected" message="compensation-request-rejected"/>
<liferay-ui:success key="compensation-request-approved" message="compensation-request-approved"/>

<head>

    <style>
        .modal-open .modal:not(.show) {
            display: none !important;
        }
        label.error {
            color: #dc3545;
            font-size: 0.875rem;
            margin-top: 4px;
        }
    </style>

</head>

<div class="card">
    <div class="card-header d-flex align-items-center justify-content-between">
        <strong>
            <liferay-ui:message key="List of Compensatory Details"/>

        </strong>
    </div>
    <div class="card-body mb-0">

        <liferay-portlet:renderURL varImpl="iteratorURL"/>

        <liferay-ui:search-container total="${ compensatoryDataCount}" delta="20"
                                     emptyResultsMessage="no-request-found" iteratorURL="${iteratorURL}">
            <liferay-ui:search-container-results results="${compensatoryDataList}"/>

            <liferay-ui:search-container-row className="com.ax.hrms.compensatory.web.dto.CompensatoryDataDto"
                                             modelVar="compensatoryDataDto" keyProperty="compensatoryDataId">

                <liferay-ui:search-container-column-text name="date-of-compensation"
                                                         value="${ compensatoryDataDto.getDateOfCompensation() }"/>

                <liferay-ui:search-container-column-text name="Employee Name"
                                                             value="${ compensatoryDataDto.getEmployeeName() }"/>

                    <liferay-ui:search-container-column-text name="Modified By"
                                                             value="${ compensatoryDataDto.getModifiedBy() }"/>


                <liferay-ui:search-container-column-text name="requested-hours"
                                                         value="${ compensatoryDataDto.getRequestedHours() }"/>

                <liferay-ui:search-container-column-text name="approved-hours"
                                                         value="${ compensatoryDataDto.getApprovedHours() }"/>

                <liferay-ui:search-container-column-text name="manager-name"
                                                         value="${ compensatoryDataDto.getManagerName() }"/>

                <liferay-ui:search-container-column-text name="status"
                                                         value="${ compensatoryDataDto.getStatus() }"/>

                <liferay-ui:search-container-column-text name="description"
                                                         value="${ compensatoryDataDto.getDescription() }"/>
         <c:set var="isSameEmployee"
                value="${currentEmployeeId == compensatoryDataDto.employeeId}" />


                <liferay-ui:search-container-column-text name="action" cssClass="text-center">
                        <portlet:actionURL name="/cancelCompensatoryData"
                                           var="cancelCompensatoryDataURL">
                            <portlet:param name="compensatoryDataId"
                                           value="${compensatoryDataDto.compensatoryDataId}"/>
                        </portlet:actionURL>
                    <c:if test="${!isSameEmployee && compensatoryDataDto.getStatus() =='Pending' }">
                        <portlet:actionURL name="/approveRejectCompensatoryData"
                                           var="rejectCompensatoryDataURL">
                            <portlet:param name="compensatoryDataId"
                                           value="${compensatoryDataDto.compensatoryDataId}"/>
                        </portlet:actionURL>

                        <div class="dropdown">
                            <button class="btn fa fa-ellipsis-v dropdown-toggle" data-toggle="dropdown"
                                    aria-haspopup="true" aria-expanded="false">
                                <i class="icon-ellipsis-vertical"></i>
                            </button>
                            <ul class="dropdown-menu">

                                <li>
                                    <!--<a class="dropdown-item"
                                       onclick="open_compensatory_form_modal(${compensatoryDataDto.compensatoryDataId},${ compensatoryDataDto.getRequestedHours() })"><i
                                            class="icon-check"></i> <liferay-ui:message
                                            key="approve"/>
                                    </a>-->

                                    <a class="dropdown-item"
                                       onclick="openApproveModal(
                                           ${compensatoryDataDto.compensatoryDataId},
                                           ${compensatoryDataDto.getRequestedHours()}
                                       )">
                                        <i class="icon-check"></i>
                                        <liferay-ui:message key="approve"/>
                                    </a>

                                 </li>

                                <li>
                                    <!--<a href="${rejectCompensatoryDataURL }" class="dropdown-item "><i
                                            class="icon-ban-circle"></i> <liferay-ui:message
                                            key="reject"/></a>-->


                                    <a class="dropdown-item"
                                       onclick="openRejectModal(${compensatoryDataDto.compensatoryDataId})">
                                        <i class="icon-ban-circle"></i>
                                        <liferay-ui:message key="reject"/>
                                    </a>

                                </li>

                            </ul>
                        </div>
                    </c:if>
                    <c:if test="${ !isSameEmployee && compensatoryDataDto.getStatus() =='Approved' }">
                        <div class="dropdown">
                            <button class="btn fa fa-ellipsis-v dropdown-toggle" data-toggle="dropdown"
                                    aria-haspopup="true" aria-expanded="false">
                                <i class="icon-ellipsis-vertical"></i>
                            </button>
                            <ul class="dropdown-menu">

                                <li>
                                   <!-- <a href="${cancelCompensatoryDataURL }" class="dropdown-item "><i
                                            class="icon-ban-circle"></i> <liferay-ui:message
                                            key="cancel"/></a>-->

                                   <a class="dropdown-item"
                                      onclick="openCancelModal(${compensatoryDataDto.compensatoryDataId})">
                                       <i class="icon-ban-circle"></i>
                                       <liferay-ui:message key="cancel"/>
                                   </a>

                                </li>

                            </ul>
                    </c:if>

                </liferay-ui:search-container-column-text>

            </liferay-ui:search-container-row>

            <liferay-ui:search-iterator markupView="lexicon" paginate="true"/>
        </liferay-ui:search-container>
    </div>
</div>


<!-- Update Scheduled Meeting-->
<div class="modal fade" id="approveCompensationModal" tabindex="-1" role="dialog"
     aria-labelledby="approveCompensationModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="approveCompensationModalLabel"><liferay-ui:message
                        key="approve-compensation-hours"/>
                </h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form action="${approveCompensatoryDataURL}" id="approveCompensationForm" method="post"
                      class="row">

                    <div class="form-group col-6">
                        <label for="requestedHours"><liferay-ui:message key="requested-hours"/><span class="text-danger">*</span></label>
                        <input id="requestedHours" class="form-control" type="text"
                               name="<portlet:namespace />requestedHours" disabled/>
                        <label id="requestedHours-error" class="error text-danger" for="requestedHours"></label>
                    </div>

                    <div class="form-group col-6">
                        <label for="approvedHours"><liferay-ui:message key="approved-hours"/><span class="text-danger">*</span></label>
                        <input id="approvedHours" class="form-control" type="text"
                               name="<portlet:namespace />approvedHours"/>
                        <label id="approvedHours-error" class="error text-danger" for="approvedHours"></label>
                    </div>
                    <div class="form-group col-12">
                        <label for="comment">
                            <liferay-ui:message key="comment"/>
                            <span class="text-danger">*</span>
                        </label>
                        <textarea id="comment"
                                  class="form-control"
                                  rows="3"
                                  name="<portlet:namespace />comment"></textarea>
                    </div>

                    <input type="hidden" id="hiddenCompensatoryDataId"
                           name="<portlet:namespace />compensatoryDataId">

                           <input type="hidden"
                                  id="actionType"
                                  name="<portlet:namespace />actionType">

            </div>
            <div class="modal-footer d-flex justify-content-end">
                <button type="button" class="btn btn-outline-danger btn-sm" data-dismiss="modal"><liferay-ui:message
                        key="close"/></button>
               <button type="button"
                       id="submitCompensationBtn"
                       class="btn btn-outline-success btn-sm"
                       onclick="submit_compensatory_form()">
                   <liferay-ui:message key="approve"/>
               </button>

            </div>
            </form>
        </div>
    </div>
</div>


<script>
    $(document).ready(function () {
        var config = {};
        config.namespace = '<portlet:namespace />';
        axHrmsCompensatoryDataWebPortlet.setConfigs(config);
    });
        function openApproveModal(id, requestedHours) {

            resetModalState();

            $('#hiddenCompensatoryDataId').val(id);
            $('#requestedHours').val(requestedHours).prop('readonly', true);

            $('#approvedHours').prop('disabled', false).closest('.form-group').show();

            $('#actionType').val('APPROVE');

            $('#approveCompensationModal').modal('show');
        }


       function openRejectModal(id) {

           resetModalState();

           $('#hiddenCompensatoryDataId').val(id);

           // Hide hours
           $('#requestedHours').closest('.form-group').hide();
           $('#approvedHours').prop('disabled', true).closest('.form-group').hide();

           // Change title & button
           $('#approveCompensationModalLabel')
               .text('<liferay-ui:message key="Reject Compensation Request"/>');

           $('#submitCompensationBtn')
               .text('<liferay-ui:message key="reject"/>')
               .removeClass('btn-outline-success')
               .addClass('btn-outline-danger');

           $('#actionType').val('REJECT');

           $('#approveCompensationModal').modal('show');
       }


       function submit_compensatory_form() {
            $('#approveCompensationForm').submit();
        }



      function openCancelModal(id) {

          resetModalState();

          $('#hiddenCompensatoryDataId').val(id);

          // Hide hours
          $('#requestedHours').closest('.form-group').hide();
          $('#approvedHours').prop('disabled', true).closest('.form-group').hide();

          // Change title & button
          $('#approveCompensationModalLabel')
              .text('<liferay-ui:message key="Cancel Compensation Request"/>');

          $('#submitCompensationBtn')
              .text('<liferay-ui:message key="cancel"/>')
              .removeClass('btn-outline-success')
              .addClass('btn-outline-danger');

          $('#actionType').val('CANCEL');

          $('#approveCompensationModal').modal('show');
      }



       function resetModalState() {

           // Reset modal title
           $('#approveCompensationModalLabel')
               .text('<liferay-ui:message key="approve-compensation-hours"/>');

           // Reset submit button
           $('#submitCompensationBtn')
               .text('<liferay-ui:message key="approve"/>')
               .removeClass('btn-outline-danger')
               .addClass('btn-outline-success');

           // Reset fields
           $('#requestedHours').val('').prop('disabled', false)
               .prop('readonly', false)
               .closest('.form-group').show();

           $('#approvedHours').val('').prop('disabled', false)
               .closest('.form-group').show();

           $('#comment').val('');
           $('#actionType').val('');
       }
$('#approveCompensationModal').on('hidden.bs.modal', function () {
    resetModalState();
    clearValidationErrors();
});

function clearValidationErrors() {

    // Remove error messages
    $('#approveCompensationForm')
        .find('label.error')
        .text('')
        .hide();

    // Remove error class from inputs
    $('#approveCompensationForm')
        .find('.error')
        .removeClass('error');

    // Reset jQuery validator if attached
    var validator = $('#approveCompensationForm').data('validator');
    if (validator) {
        validator.resetForm();
    }
}


</script>
