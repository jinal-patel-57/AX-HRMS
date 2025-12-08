<%@ include file="/init.jsp" %>

<portlet:actionURL name="/approveRejectCompensatoryData" var="approveCompensatoryDataURL"/>
<liferay-ui:success key="compensation-request-rejected" message="compensation-request-rejected"/>
<liferay-ui:success key="compensation-request-approved" message="compensation-request-approved"/>

<head>

    <style>
        .modal-open .modal:not(.show) {
            display: none !important;
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

                <liferay-ui:search-container-column-text name="action" cssClass="text-center">
                    <c:if test="${ compensatoryDataDto.getStatus() =='Pending' }">
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
                                    <a class="dropdown-item"
                                       onclick="open_compensatory_form_modal(${compensatoryDataDto.compensatoryDataId},${ compensatoryDataDto.getRequestedHours() })"><i
                                            class="icon-check"></i> <liferay-ui:message
                                            key="approve"/>
                                    </a></li>

                                <li>
                                    <a href="${rejectCompensatoryDataURL }" class="dropdown-item "><i
                                            class="icon-ban-circle"></i> <liferay-ui:message
                                            key="reject"/></a>
                                </li>
                            </ul>
                        </div>

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
                    <input type="hidden" id="hiddenCompensatoryDataId"
                           name="<portlet:namespace />compensatoryDataId">
            </div>
            <div class="modal-footer d-flex justify-content-end">
                <button type="button" class="btn btn-outline-danger btn-sm" data-dismiss="modal"><liferay-ui:message
                        key="close"/></button>
                <button type="button" class="btn btn-outline-success btn-sm"
                        onclick="submit_compensatory_form()"><liferay-ui:message key="approve"/></button>
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
</script>