<%@ include file="/init.jsp" %>


<%--Liferay Urls start here--%>
<portlet:actionURL name="/sendAnniversaryWish" var="sendWishesURL"></portlet:actionURL>
<%--Liferay Urls end here--%>

<%--SESSION_MESSAGES Start Here--%>
<liferay-ui:success key="sent-wishes-successfully" message="SuccessFully sent Wish"/>
<%--SESSION_MESSAGES End Here--%>
<c:if test="${empty anniversaryEmployeeList}">
    <div class="alert alert-info">No anniversaries Today!</div>
</c:if>
<c:if test="${not empty anniversaryEmployeeList}">


    <div class="card">
        <div class="card-header"><strong><liferay-ui:message key="list-of-anniversary-employees-heading"/></strong>
        </div>
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
                <c:forEach var="anniversaryEmployees" items="${anniversaryEmployeeList}">
                    <tr>
                        <td>${anniversaryEmployees.employeeName}</td>
                        <td>${anniversaryEmployees.departmentName}</td>
                        <td>${anniversaryEmployees.designationName}</td>
                        <td>
                            <a href="javascript:void(0)" data-senna-off="true"
                               class="btn btn-primary btn-sm sendAnniversaryWish" data-toggle="modal"
                               data-employee-id='${anniversaryEmployees.employeeId}'
                               data-employee-name='${anniversaryEmployees.employeeName}'> <liferay-ui:message
                                    key="send-wishes"/></a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

</c:if>
<div class="container">
    <div class="modal fade" id="anniversaryWishModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
         aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel"><liferay-ui:message key="new-message"/></h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form action="${sendWishesURL}" id="<portlet:namespace/>anniversaryWishForm" method="Post">
                        <input type="hidden" class="form-control" id="<portlet:namespace/>employeeId"
                               name="<portlet:namespace />employeeId">
                        <div class="form-group">
                            <label for="employeeNameAni" class="col-form-label"><liferay-ui:message
                                    key="employee-name"/></label>
                            <input type="text" class="form-control" id="employeeNameAni"
                                   name="<portlet:namespace/>employeeName"/>
                        </div>
                        <div class="form-group">
                            <label for="<portlet:namespace/>wishType" class="col-form-label"><liferay-ui:message
                                    key="wish-type"/></label>
                            <input class="form-control" type="text" value="Anniversary"
                                   id="<portlet:namespace/>wishType" name="<portlet:namespace/>wishType" readonly>
                        </div>
                        <!--                         summerNote  start here-->
                        <div class="form-group">
                            <label for="wishes"><liferay-ui:message key="wishes"/>
                            <span class="text-danger">*</span>
                            </label>
                            <div id="<portlet:namespace />anniversaryWishNote" class="summernote-container"
                                 name="<portlet:namespace />anniversaryWishNote"></div>
                        </div>
                        <input type="hidden" id="<portlet:namespace/>wishesData"
                               name="<portlet:namespace />wishesData"> </input>
                        <!--                        summerNote  end here-->
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-outline-danger btn-sm" data-dismiss="modal"><liferay-ui:message
                            key="close"/></button>
                    <button type="button" class="btn btn-outline-success btn-sm" id="<portlet:namespace />sendWish">
                        <liferay-ui:message key="send-message"/></button>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    $(document).ready(function () {
        var config = {};
        config.namespace = '<portlet:namespace />';
        // config.employeeName = '';
        // config.employeeId = 0;
        // config.wishType = 0;
        config.wish = '';
        config.sendWishUrl = '${sendWishesURL}';

        AXHrmsAnniversaryWebPortlet.setAnniversaryConfigs(config);
    });
</script>