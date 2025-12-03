<%@ include file="/init.jsp" %>

<portlet:actionURL name="/addCompensatoryData" var="addCompensatoryDataURL"/>
<liferay-ui:success key="compensation-request-deleted" message="compensation-request-deleted"/>
<liferay-ui:success key="compensation-request-submitted" message="compensation-request-submitted"/>

<head>

    <style>
        .modal-open .modal:not(.show) {
            display: none !important;
        }
    </style>

</head>



<div class="card">
  <div class="card-header d-flex align-items-center justify-content-end">
			<a class="btn btn-primary btn-sm " onclick="open_compensatory_form_modal()"">
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

                    <liferay-ui:search-container-column-text name="Requested Hours"
                                                             value="${ compensatoryDataDto.getRequestedHours() }"/>

                    <liferay-ui:search-container-column-text name="Approved Hours"
                                                             value="${ compensatoryDataDto.getApprovedHours() }"/>

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
						<a href="${deleteCompensatoryDataURL }" class=" dropdown-item"><i class="icon-trash"></i> <liferay-ui:message
						key="delete" /></a>
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
                        key="add-compensatory-data"/>
                </h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form action="${addCompensatoryDataURL}" id="addCompensatoryDataForm" method="post">
                    <div class="form-group">
                        <label class="" for="compensationDate"><liferay-ui:message
                                key="compensation-date"/><span class="text-danger">*</span></label>
                        <input id="compensationDate" placeholder="<liferay-ui:message key='compensation-date'/>"
                               class="form-control" type="date" name="<portlet:namespace/>compensationDate"/>
                        <label id="compensationDate-error" class="error text-danger" for="compensationDate"></label>
                    </div>
                    <div class="form-group">
                        <label for="compensationHours"><liferay-ui:message key="no-of-compensation-hours"/><span class="text-danger">*</span></label>
                        <input id="compensationHours" class="form-control" type="text"
                               name="<portlet:namespace />compensationHours"/>
                        <label id="compensationHours-error" class="error text-danger"
                               for="compensationHours"></label>
                    </div>
                    <div class="form-group">
                        <label for="projectManagerSelect"><liferay-ui:message
                                key="select-project-manager"/><span class="text-danger">*</span></label>

                        <select id="projectManagerSelect" name="<portlet:namespace />projectManager"
                                class="custom-select mr-sm-2">
                            <!-- adding the user list -->
                            <option value=""><liferay-ui:message key="select-manager"/><span class="text-danger">*</span></option>
                            <c:forEach var="manager" items="${managerList}">
                                <option value="${manager.employeeId}">${manager.firstName} ${manager.lastName}
                                </option>
                            </c:forEach>
                        </select>
                        <label id="projectManagerSelect-error" class="error text-danger"
                               for="projectManagerSelect"></label>
                    </div>
                    <div class="form-group">
                        <label for="description"><liferay-ui:message key="description"/><span class="text-danger">*</span></label>
                        <textarea id="description" class="form-control"
                                  name="<portlet:namespace />description"></textarea>
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


<script>


    $(document).ready(function () {
        var config = {};
        config.namespace = '<portlet:namespace />';
        axHrmsCompensatoryDataWebPortlet.setConfigs(config);
    });

</script>