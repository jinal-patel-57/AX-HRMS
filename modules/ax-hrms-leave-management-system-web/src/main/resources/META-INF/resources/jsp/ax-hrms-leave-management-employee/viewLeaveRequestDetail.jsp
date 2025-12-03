<%@ include file="/init.jsp" %>

<portlet:renderURL var="homeUrl"/>


<div class="card">
    <div class="card-header">
        <strong>
            View Leave Request
        </strong>
    </div>
    <div class="card-body">
        <div class="row">
            <div class="col-lg-4 col-md-4 col-sm-6 col-xs-12 ">
                <div class="form-group-view">
                    <div class="label-name"><liferay-ui:message key="leave-type"/></div>
                    <div class="label-content">${leaveTypeMaster.leaveTypeName }</div>
                </div>
            </div>
          
            <c:if test="${empty floaterHolidayName}">
                <div class="col-lg-4 col-md-4 col-sm-6 col-xs-12 ">
                    <div class="form-group-view">
                        <div class="label-name"><liferay-ui:message key="reason"/></div>
                        <div class="label-content">${leaveRequest.reason}</div>
                    </div>
                </div>
            </c:if>


            <c:if test="${not empty floaterHolidayName}">
                <div class="col-lg-4 col-md-4 col-sm-6 col-xs-12 ">
                    <div class="form-group-view">
                        <div class="label-name"><liferay-ui:message key="floater-holiday-name"/></div>
                        <div class="label-content">${floaterHolidayName}</div>
                    </div>
                </div>
            </c:if>


            <div class="col-lg-4 col-md-4 col-sm-6 col-xs-12 ">
                <div class="form-group-view">
                    <div class="label-name"><liferay-ui:message key="team-ids"/></div>
                    <c:if test="${empty leaveInformToTeamDetailMap}">
                        <div class="label-content">-</div>
                    </c:if>
                    <c:forEach var="leaveInformToTeamMap" items="${leaveInformToTeamDetailMap}">
                        <div class="label-content">${leaveInformToTeamMap.value }</div>
                    </c:forEach>
                </div>
            </div>
            <div class="col-lg-4 col-md-4 col-sm-6 col-xs-12 ">
                <div class="form-group-view">
                    <div class="label-name"><liferay-ui:message key="status"/></div>
                    <div class="label-content">${status}</div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <table class="table">
                    <thead>
                    <tr>
                        <td><p class="text-center my-0"><b><liferay-ui:message key="leave-date"/></b></td>
                        <td><p class="text-center my-0"><b><liferay-ui:message key="day-type"/></b></td>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="leaveDayType" items="${leaveDayTypeList}">
                        <tr>
                            <td>
                                <fmt:formatDate value="${leaveDayType.leaveDate}" pattern="dd/MM/yyyy"
                                                var="formatedLeaveDate"/>
                                <p class="text-center my-0">${formatedLeaveDate }</p>
                            </td>
                            <td>
                                <p class="text-center my-0">${leaveDayType.isHalfDay ? (leaveDayType.isFirstHalf ? 'First Half' : 'Second Half') : "Full Day" }</p>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

    <div class="card-footer text-right align-items-center">
        <a href="${homeUrl }" class="btn btn-outline-danger"><liferay-ui:message key="back"></liferay-ui:message></a>
    </div>
</div>


