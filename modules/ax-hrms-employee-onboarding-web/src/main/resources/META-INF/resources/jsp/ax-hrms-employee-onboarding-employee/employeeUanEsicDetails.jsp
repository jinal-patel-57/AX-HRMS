<%@ include file="/init.jsp" %>
<portlet:actionURL name="/addEditEmployeeUanEsicURL" var="addEditEmployeeUanEsicURL"/>
<form id="uanEsicStepperForm" action="${addEditEmployeeUanEsicURL}" method="post">
    <div class="card-header">
        <strong>
            <liferay-ui:message key="uan-esic-details"/>
        </strong>
    </div>
    <div class="card-body">
        <div class="row">

            <!-- UAN (Universal Account Number) -->
            <div class="col-md-6 col-sm-12 mb-3">

                <div class="form-group">
                    <label for="uan" class="form-label"> <liferay-ui:message
                            key="uan"/>
                    </label> <input type="text" class="form-control"
                                    id="<portlet:namespace />uan" name="<portlet:namespace />uan"
                                    maxlength="12" value="${employeeUanEsic.uan}"/>

                    <input type="hidden" class="form-control"
                           id="<portlet:namespace />uanEsicId" name="<portlet:namespace />uanEsicId"
                           maxlength="12" value="${employeeUanEsic.uanEsicId}"/>
                </div>
            </div>

            <div class="col-md-6 col-sm-12 mb-3">
                <!-- ESIC Number -->
                <div class="form-group">
                    <label for="esicNo" class="form-label"> <liferay-ui:message
                            key="esic-no"/>
                    </label>
                    <input type="text" class="form-control"
                           id="<portlet:namespace />esicNo" name="<portlet:namespace />esicNo"
                           maxlength="17" value="${employeeUanEsic.esicNo}"/>
                </div>
            </div>

            <input type="hidden" id="updateFlagUanEsic" name="<portlet:namespace/>updateFlagUanEsic"
                   value="${not empty flagStatus? flagStatus : 'false' }"/>
            <input type="hidden" name="<portlet:namespace/>employeeId" value="${employeeId}">
        </div>
    </div>
    <div class="card-footer text-right">
        <!-- Na vigation buttons -->
        <button class="btn btn-outline-primary previous-button" type="button">Previous</button>
        <button class="btn btn-outline-primary next-button next-button-uan-esic-details" type="button">Next</button>
    </div>

</form>