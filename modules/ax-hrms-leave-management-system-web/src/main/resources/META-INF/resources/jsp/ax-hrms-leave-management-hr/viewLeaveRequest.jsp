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
            <div class="col-sm-12 col-md-4">
                <div class="col-lg-4 col-md-4 col-sm-6 col-xs-12 ">
                    <div class="form-group-view">
                        <div class="label-name"><liferay-ui:message key="employee-name"/></div>
                        <div class="label-content">${empty leaveRequestDto ? '' : leaveRequestDto.employeeName}</div>
                    </div>
                </div>
            </div>

            <div class="col-sm-12 col-md-4">
                <div class="col-lg-4 col-md-4 col-sm-6 col-xs-12 ">
                    <div class="form-group-view">
                        <div class="label-name"><liferay-ui:message key="department-name"/></div>
                        <div class="label-content">${empty leaveRequestDto ? '' : leaveRequestDto.departmentName}</div>
                    </div>
                </div>
            </div>
            <div class="col-sm-12 col-md-4">
                <div class="col-lg-4 col-md-4 col-sm-6 col-xs-12 ">
                    <div class="form-group-view">
                        <div class="label-name"><liferay-ui:message key="designation-name"/></div>
                        <div class="label-content">${empty leaveRequestDto ? '' : leaveRequestDto.designationName}</div>
                    </div>
                </div>
            </div>
            <div class="col-sm-12 col-md-4">
                <div class="col-lg-4 col-md-4 col-sm-6 col-xs-12 ">
                    <div class="form-group-view">
                        <div class="label-name"><liferay-ui:message key="leave-type-name"/></div>
                        <div class="label-content">${empty leaveRequestDto ? '' : leaveRequestDto.leaveType}</div>
                    </div>
                </div>
            </div>
            <div class="col-sm-12 col-md-4">
                <div class="col-lg-4 col-md-4 col-sm-6 col-xs-12 ">
                    <div class="form-group-view">
                        <div class="label-name"><liferay-ui:message key="date-of-request"/></div>
                        <div class="label-content">${empty leaveRequestDto ? '' : leaveRequestDto.dateOfRequestedLeave}</div>
                    </div>
                </div>
            </div>
            <div class="col-sm-12 col-md-4">
                <div class="col-lg-4 col-md-4 col-sm-6 col-xs-12 ">
                    <div class="form-group-view">
                        <div class="label-name"><liferay-ui:message key="total-no-of-days"/></div>
                        <div class="label-content">${empty leaveRequestDto ? '' : leaveRequestDto.totalNoOfDays}</div>
                    </div>
                </div>
            </div>
            <div class="col-sm-12 col-md-4">
                <div class="col-lg-4 col-md-4 col-sm-6 col-xs-12 ">
                    <div class="form-group-view">
                        <div class="label-name"><liferay-ui:message key="start-date-of-leave"/></div>
                        <div class="label-content">${empty leaveRequestDto ? '' : leaveRequestDto.startDateOfLeaveRequest}</div>
                    </div>
                </div>
            </div>
            <div class="col-sm-12 col-md-4">
                <div class="col-lg-4 col-md-4 col-sm-6 col-xs-12 ">
                    <div class="form-group-view">
                        <div class="label-name"><liferay-ui:message key="end-date-of-leave"/></div>
                        <div class="label-content">${empty leaveRequestDto ? '' : leaveRequestDto.endDateOfLeaveRequest}</div>
                    </div>
                </div>
            </div>
            <div class="col-sm-12 col-md-4">
                <div class="col-lg-4 col-md-4 col-sm-6 col-xs-12 ">
                    <div class="form-group-view">
                        <div class="label-name"><liferay-ui:message key="status"/></div>
                        <div class="label-content">${empty leaveRequestDto ? '' : leaveRequestDto.status}</div>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col"><liferay-ui:message key="leave-date"/></th>
                        <th scope="col"><liferay-ui:message key="day"/></th>
                        <th scope="col"><liferay-ui:message key="half"/></th>
                    </tr>
                    </thead>
                    <c:forEach var="data" items="${leaveDayTypeList}">

                        <tbody>
                        <tr>
                            <td>${data.leaveDate}</td>
                            <td>
                                <c:choose>
                                    <c:when test="${data.halfDay}">
                                        <liferay-ui:message key="half-day"/>
                                    </c:when>
                                    <c:otherwise>
                                        <liferay-ui:message key="full-day"/>
                                    </c:otherwise>
                                </c:choose>
                            </td>
                            <c:if test="${data.halfDay}">
                                <td>
                                    <c:choose>
                                        <c:when test="${data.firstHalf}">
                                            <liferay-ui:message key="first-half"/>
                                        </c:when>
                                        <c:otherwise>
                                            <liferay-ui:message key="second-half"/>
                                        </c:otherwise>
                                    </c:choose>
                                </td>
                            </c:if>
                        </tr>
                        </tbody>

                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
    <div class="card-footer text-right align-items-center">
        <a href="${homeUrl}" class="btn btn-outline-danger">
            <liferay-ui:message key="back"/>
        </a>

    </div>
</div>
