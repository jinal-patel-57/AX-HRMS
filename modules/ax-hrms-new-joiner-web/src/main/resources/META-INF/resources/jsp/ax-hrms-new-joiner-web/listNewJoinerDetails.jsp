<%@ include file="../../init.jsp"%>
<link href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.20/summernote-lite.min.css" rel="stylesheet">


<%--Liferay Urls start here--%>
<portlet:actionURL name="/sendNewJoinerWish" var="sendWishesURL"></portlet:actionURL>
<%--Liferay Urls end here--%>

<%--SESSION_MESSAGES Start Here--%>
<liferay-ui:success key="sent-wishes-successfully" message="SuccessFully sent Wish"/>
<%--SESSION_MESSAGES End Here--%>
<h1></h1>
    <c:if test="${empty newJoinerList}">
        <div class="ax-card card border-0">
            <div class="card-header invisible">No New Joiners</div>
            <div class="ax-body d-flex align-items-center">
                <div class="ax-conatiner">
                    <div class="icon-new-joiners"></div>
                    <div><strong> No New Joiners Today</strong></div>
                    <div class="wish-message">No new joiners today. We will be back to welcome our next team member very soon.</div>
                </div>
            </div>
        </div>
    </c:if>
        <c:if test="${not empty newJoinerList}">
        
        
        <div class="card">
  <div class="card-header"><strong><liferay-ui:message key="list-of-new-joiner-list-heading" /></strong></div>
  <div class="card-body ax-body">
  <table class="table ">
            <thead>
                <tr>
                    <th scope="col"><liferay-ui:message key="employee-name" /></th>
                    <th scope="col"><liferay-ui:message key="department-name" /></th>
                    <th scope="col"><liferay-ui:message key="designation-name" /></th>
                    <th scope="col"><liferay-ui:message key="action" /></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="newJoiner" items="${newJoinerList}">
                    <tr>
                        <td>${newJoiner.employeeName}</td>
                        <td>${newJoiner.departmentName}</td>
                        <td>${newJoiner.designationName}</td>
                        <td>
                            <c:if test="${currentUserId ne newJoiner.lrUserId}">
	                            <a href="javascript:void(0)" data-senna-off="true" class="btn btn-primary btn-sm sendNewJoineeWish" data-toggle="modal" data-employee-id='${newJoiner.employeeId}' data-employee-name='${newJoiner.employeeName}'> <liferay-ui:message key="send-wishes" /></a>
    						</c:if>                        
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
</div>
</div>
        
      
    </c:if>

<div class="container">

    <div class="modal fade" id="newJoinerWishModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel"><liferay-ui:message key="send-wishes"/></h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form action="${sendWishesURL}" id="<portlet:namespace/>newJoinerWishForm" method="Post">
                        <input type="hidden" class="form-control" id="<portlet:namespace/>employeeId" name="<portlet:namespace />employeeId">
                        <div class="form-group">
                            <label for="<portlet:namespace/>employeeName" class="col-form-label"><liferay-ui:message key="employee-name" /></label>
                            <input type="text" class="form-control" id="<portlet:namespace/>employeeName" name="<portlet:namespace/>employeeName"/>
                        </div>
                       <!-- <div class="form-group">
                            <label for="<portlet:namespace/>wishType" class="col-form-label"><liferay-ui:message key="wish-type" /></label>
                            <input type="text" value="New Joiner" class="form-control" id="<portlet:namespace/>wishType" name="<portlet:namespace/>wishType" readonly>
                        </div> -->
                        <!--                         summerNote  start here-->
                        <div class="form-group">
                            <label for="<portlet:namespace />newJoinerWishNote"><liferay-ui:message key="wishes"/>
                            <span class="text-danger">*</span>
                            </label>
                            <div id="<portlet:namespace />newJoinerWishNote" class="summernote-container" name="<portlet:namespace />newJoinerWishNote"></div>
                                <!-- Error message container -->
                                <div id="<portlet:namespace />wishError" class="text-danger mt-1" style="display:none;">Please enter wishes.</div>
                        </div>
                        <input type="hidden" id="<portlet:namespace/>wishesData" name="<portlet:namespace />wishesData" />
                        <!--                         summerNote end here-->
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-outline-danger btn-sm" data-dismiss="modal"><liferay-ui:message key="close" /></button>
                    <button type="button" class="btn btn-outline-success btn-sm" id="<portlet:namespace />sendWish"><liferay-ui:message key="send"/></button></button>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    $(document).ready(function(){
        var config = {};
        config.namespace = '<portlet:namespace />';
        config.employeeName = '';
        config.employeeId = 0;
        config.wishType = 0;
        config.wish= '';
        config.sendWishUrl = '${sendWishesURL}';

        AXHrmsNewJoinerWebPortlet.setConfigs(config);
    });
</script>