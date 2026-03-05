<%@ include file="/init.jsp" %>

<portlet:actionURL name="/addCompensatoryData" var="addCompensatoryDataURL"/>
<liferay-ui:success key="compensation-request-deleted" message="compensation-request-deleted"/>
<liferay-ui:success key="compensation-request-submitted" message="compensation-request-submitted"/>

<head>

    <style>
        .modal-open .modal:not(.show) {
            display: none !important;
        }
        .error{

         color: #dc3545 !important;

        }
        #compensationTypeError label.error {
            display: block;

            color: #dc3545;
        }
    </style>

</head>



<div class="card">
  <div class="card-header d-flex align-items-center justify-content-end">
			<a class="btn btn-primary btn-sm " onclick="open_compensatory_form_modal()">
                <liferay-ui:message key="request-compensation"/>
                </a>
</div>
  <div class="card-body mb-0">
   <liferay-portlet:renderURL varImpl="iteratorURL"/>

            <liferay-ui:search-container total="${projectSearchContainer.total }" delta="${delta}"
                                         searchContainer="${projectSearchContainer}"
                                         emptyResultsMessage="no-project-data" iteratorURL="${iteratorURL}">

                <liferay-ui:search-container-results results="${projectSearchContainer.results}"/>

                <liferay-ui:search-container-row className="com.ax.hrms.compensatory.web.dto.CompensatoryDataDto"
                                                 modelVar="compensatoryDataDto" keyProperty="compensatoryDataId">

                    <liferay-ui:search-container-column-text name="Date of Compensation"
                                                             value="${ compensatoryDataDto.getDateOfCompensation() }"/>

             <liferay-ui:search-container-column-text name="Start Time"
                                                                     value="${ compensatoryDataDto.getStartTime() }"/>
                            <liferay-ui:search-container-column-text name="End Time"
                                                                     value="${ compensatoryDataDto.getEndTime() }"/>

                    <liferay-ui:search-container-column-text name="Modified By"
                                                             value="${ compensatoryDataDto.getModifiedBy() }"/>



                    <liferay-ui:search-container-column-text name="Requested Type"
                                                             value="${ compensatoryDataDto.getRequestedCompensationType() }"/>

                    <liferay-ui:search-container-column-text name="Approved Type"
                                                             value="${ compensatoryDataDto.getApprovedCompensationType() }"/>

                    <liferay-ui:search-container-column-text name="Manager Name"
                                                             value="${ compensatoryDataDto.getManagerName() }"/>

                    <liferay-ui:search-container-column-text name="Status"
                                                             value="${ compensatoryDataDto.getStatus() }"/>

                    <liferay-ui:search-container-column-text name="Description"
                                                             value="${ compensatoryDataDto.getDescription() }"/>

                    <liferay-ui:search-container-column-text name="Action" cssClass="text-center">
                        <c:if test="${ compensatoryDataDto.getStatus() =='Pending' }">

                            <portlet:actionURL name="/deleteCompensatoryData" var="deleteCompensatoryDataURL">
                                <portlet:param name="compensatoryDataId"
                                               value="${compensatoryDataDto.compensatoryDataId}"/>
                            </portlet:actionURL>
                            
                            
                            <div class="dropdown ">
					<button class="btn fa fa-ellipsis-v dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" >
						<i class="icon-ellipsis-vertical"></i>
					</button>
					<ul class="dropdown-menu">
						<li>
						<a class="dropdown-item"
                           onclick="openDeleteModal('${deleteCompensatoryDataURL}')">
                            <i class="icon-trash"></i>
                            <liferay-ui:message key="delete" />
                        </a>
						</li>
					</ul>
				</div>

                        </c:if>
                    </liferay-ui:search-container-column-text>

                </liferay-ui:search-container-row>

                <liferay-ui:search-iterator
                        searchContainer="${projectSearchContainer}" markupView="lexicon" paginate="true"/>
            </liferay-ui:search-container>
</div>
</div>


<!-- Update Scheduled Meeting-->
<div class="modal fade" id="addCompensatoryDataModal" tabindex="-1" role="dialog"
     aria-labelledby="addCompensatoryDataModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="addCompensatoryDataModalLabel"><liferay-ui:message
                        key="add-comp-off"/>
                </h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form action="${addCompensatoryDataURL}" id="addCompensatoryDataForm" method="post">

                   <c:if test="${isManager or isHR}">

                                            <div class="form-group">
                                                <input type="hidden" id="<portlet:namespace />hrManagerStatus"
                                                       name="<portlet:namespace />hrManagerStatus"
                                                       value="${isManager or isHR}" style="display:none;"/>

                                               <label for="employeeNamesSelect">  <liferay-ui:message key="employee-detail"/><span class="text-danger">*</span>
                                                <select id="<portlet:namespace />employeeNames"
                                                        name="<portlet:namespace />employeeNames"
                                                        class="custom-select mr-sm-2">
                                                    <option value="">-- Select Employee --</option>
                                                    <c:forEach var="employeeDetailsList" items="${employeeDetailsList}">
                                                        <option value="${employeeDetailsList.getEmployeeId()}">${employeeDetailsList.firstName} ${employeeDetailsList.lastName}
                                                            (${employeeDetailsList.employeeCode})
                                                        </option>
                                                    </c:forEach>
                                                </select>

                                            </div>


                                    </c:if>
                    <div class="form-group">
                        <label class="" for="compensationDate"><liferay-ui:message
                                key="worked-date"/><span class="text-danger">*</span></label>
                        <input id="compensationDate" placeholder="<liferay-ui:message key='compensation-date'/>"
                               class="form-control" type="date" name="<portlet:namespace/>compensationDate"/>
                        <label id="compensationDate-error" class="error text-danger" for="compensationDate"></label>
                    </div>
                    <div class="form-group">
                        <label>
                            <liferay-ui:message key="Duration"/>
                            <span class="text-danger">*</span>
                        </label>

                      <div id="compensationTypeGroup">
                        <div class="form-check">
                            <input class="form-check-input" type="radio"
                                   name="<portlet:namespace />compensationType"
                                   id="halfDay"
                                   value="HALF">
                            <label class="form-check-label" for="halfDay">
                                Half Day
                            </label>
                        </div>

                        <div class="form-check">
                            <input class="form-check-input" type="radio"
                                   name="<portlet:namespace />compensationType"
                                   id="fullDay"
                                   value="FULL">
                            <label class="form-check-label" for="fullDay">
                                Full Day
                            </label>
                        </div>
                        <div id="compensationTypeError"></div>
                    </div>


                    </div>


                 <div class="form-group">
                     <label for="startTime">
                         Start Time
                         <span class="text-danger">*</span>
                     </label>

                     <small class="form-text text-muted">
                         Hours : Minutes (24-hour format)
                     </small>

                     <input id="startTime"
                            type="time"

                            class="form-control"
                            name="<portlet:namespace />startTime"/>

                     <label id="startTime-error" class="error text-danger" for="startTime"></label>
                 </div>

                 <div class="form-group">
                     <label for="endTime">
                         End Time
                         <span class="text-danger">*</span>
                     </label>

                     <small class="form-text text-muted">
                         Hours : Minutes (24-hour format)
                     </small>

                     <input id="endTime"
                            type="time"

                            class="form-control"
                            name="<portlet:namespace />endTime"/>

                     <label id="endTime-error" class="error text-danger" for="endTime"></label>
                 </div>


                    <div class="form-group">
                        <label for="projectManagerSelect"><liferay-ui:message
                                key="select-project-manager"/><span class="text-danger">*</span></label>

                        <select id="projectManagerSelect" name="<portlet:namespace />projectManager"
                                class="custom-select mr-sm-2">
                            <!-- adding the user list -->
                            <option value=""><liferay-ui:message key="select-manager"/></option>
                            <c:forEach var="manager" items="${managerList}">
                                <option value="${manager.employeeId}">${manager.firstName} ${manager.lastName}
                                </option>
                            </c:forEach>
                        </select>
                        <label id="projectManagerSelect-error" class="error text-danger"
                               for="projectManagerSelect"></label>
                    </div>
                    <div class="form-group">
                        <label for="description"><liferay-ui:message key="description"/></label>
                        <span class="text-danger">*</span>
                        <textarea id="description" class="form-control"
                                  name="<portlet:namespace />description"></textarea>
                                  <small class="text-muted d-block">
                                      Maximum 250 characters allowed.
                                  </small>
                        <label id="description-error" class="error text-danger" for="description"></label>
                    </div>
            </div>
            <div class="modal-footer d-flex justify-content-end">
                <button type="button" class="btn btn-outline-danger btn-sm mr-1" data-dismiss="modal"><liferay-ui:message
                        key="close"/></button>
                <button type="button" class="btn btn-outline-success btn-sm"
                        onclick="submit_compensatory_form()"><liferay-ui:message key="submit"/></button>
            </div>
            </form>
        </div>
    </div>
</div>

<div class="modal fade" id="deleteCompensatoryModal" tabindex="-1" role="dialog"
     aria-labelledby="deleteCompensatoryModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">

            <div class="modal-header  text-white">
                <h5 class="modal-title" id="deleteCompensatoryModalLabel">
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
                    Are you sure you want to delete this compensation request?
                </p>
            </div>

            <div class="modal-footer justify-content-center">
                <button type="button"
                        class="btn btn-outline-secondary btn-sm"
                        data-dismiss="modal">
                    Cancel
                </button>

                <button type="button"
                        id="confirmDeleteBtn"
                        class="btn btn-danger btn-sm">
                    Delete
                </button>
            </div>

        </div>
    </div>
</div>


<script>


    $(document).ready(function () {
        var config = {};
        config.namespace = '<portlet:namespace />';
        axHrmsCompensatoryDataWebPortlet.setConfigs(config);
    });

    var deleteUrl = "";

    function openDeleteModal(url) {

        deleteUrl = url;

        $('#deleteCompensatoryModal').modal('show');
    }

    $('#confirmDeleteBtn').click(function () {

        if (deleteUrl) {
            window.location.href = deleteUrl;
        }

    });

</script>