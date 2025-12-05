<%@ include file="/init.jsp" %>
<link href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.20/summernote-lite.min.css" rel="stylesheet">


<!-- Different URL Start -->
<portlet:actionURL name="/sendWishes" var="sendWishesURL"></portlet:actionURL>


<%--SESSION_MESSAGES Start Here--%>

<liferay-ui:success key="sent-wishes-successfully" message="sent-wishes-message"/>


<c:if test="${isListEmpty}">
    <div class="alert alert-info">
        No Birthdays Today!
    </div>
</c:if>

<c:if test="${!isListEmpty}">


    <c:if test="${not empty birthdayListOfEmployee}">
    
    
    <div class="card">
  <div class="card-header"><strong><liferay-ui:message key="list-of-birthday-employee"/></strong></div>
  <div class="card-body">
 <table class="table ">
                <thead>
                <tr>

                    <th scope="col"><liferay-ui:message key="employee-name"/></th>
                    <th scope="col"><liferay-ui:message key="department-name"/></th>
                    <th scope="col"><liferay-ui:message key="designation-name"/></th>
                    <th scope="col"><liferay-ui:message key="action"/></th>
                </tr>
                </thead>
                <tbody>
                    <%-- Loop through birthdayListOfEmployee and generate table rows --%>
                <c:forEach var="birthdayEmployee" items="${birthdayListOfEmployee}">
                    <tr>
                        <td>${birthdayEmployee.employeeName}</td>
                        <td>${birthdayEmployee.departmentName}</td>
                        <td>${birthdayEmployee.designationName}</td>
                        <td>
                            <a href="javascript:void(0)" data-senna-off="true" class="btn btn-sm btn-primary sendBirthdayWish"
                               data-id='${birthdayEmployee.employeeId}' data-name='${birthdayEmployee.employeeName}'>
                                <liferay-ui:message key="send-wishes"/></a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

</div>
</div>
           

        <!-- Modal for sending wishes -->
        <div id="birthdayWishesModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
             aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title"><liferay-ui:message key="send-wishes"/></h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <!-- Form to send wishes -->
                        <form id="wishesForm" action="${sendWishesURL}" method='post'>
                            <input type="hidden" class="form-control" id="employeeId"
                                   name="<portlet:namespace />employeeId">
                            <div class="form-group">
                                <label for="employeeName"><liferay-ui:message key="employee-name"/></label>
                                <input type="text" class="form-control" id="employeeName" readonly>
                            </div>
                            <div class="form-group">
                                <label for="wishType"><liferay-ui:message key="wish-type"/></label>
                                <input type="text" class="form-control" id="wishType" readonly>
                            </div>

                            <!--                         summerNote -->

                            <div class="form-group">
                                <label for="wishes"><liferay-ui:message key="wishes"/>
                                <span class="text-danger">*</span>
                                </label>

                                <div id="wishesIdDiv" class="summernote-container"></div>

                            </div>

                            <input type="hidden" id="wishesData" name="<portlet:namespace />wishes"> </input>


                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-outline-danger btn-sm" data-dismiss="modal"><liferay-ui:message
                                key="close"/></button>
                        <button type="button" class="btn btn-outline-success btn-sm" id="send"><liferay-ui:message
                                key="send"/></button>
                    </div>
                </div>
            </div>
        </div>

    </c:if>
</c:if>


<script>
    $(document).ready(function () {
        var config = new Object({}),
            namespace = '<portlet:namespace />',
            employeeName = 'employeeName',
            wishType = 'wishType',
            wishes = 'wishes',
            employeeId = 'employeeId',
            sendWishesurl = '${sendWishesURL}';

        config.namespace = namespace;
        config.employeeName = employeeName;
        config.wishType = wishType;
        config.wishes = wishes;
        config.employeeId = employeeId;
        config.sendWishesurl = sendWishesurl;


        AXHrmsBirthdayWebPortlet.setBirthdayConfigs(config);
    });
</script>

