<%@ include file="/init.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

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
          
            <c:if test="${not empty leaveRequest.reason}">
                <div class="col-lg-4 col-md-4 col-sm-6 col-xs-12 ">
                    <div class="form-group-view">
                        <div class="label-name"><liferay-ui:message key="reason"/></div>
                        <div class="label-content">${leaveRequest.reason}</div>
                    </div>
                </div>
            </c:if>


            <c:if test="${empty leaveRequest.reason}">
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
                       <!-- <div class="label-content">${leaveInformToTeamMap.value }</div> -->
                       <div class="label-content email">
                           ${fn:toLowerCase(leaveInformToTeamMap.value)}
                       </div>
                    </c:forEach>
                </div>
            </div>
            <div class="col-lg-4 col-md-4 col-sm-6 col-xs-12 ">
                <div class="form-group-view">
                    <div class="label-name"><liferay-ui:message key="status"/></div>
                    <div class="label-content">${status}</div>
                </div>
            </div>
            <div class="col-lg-4 col-md-4 col-sm-6 col-xs-12 ">
                <div class="form-group-view">
                    <div class="label-name"><liferay-ui:message key="No. Of Days"/></div>
                    <div class="label-content">${leaveRequestDto.noOfDays}</div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-12 col-md-6">
                <div class="card">
                    <div class="card-header">
                        <strong>
                            Leave Summary
                        </strong>
                    </div>
                    <div class="card-body">
                        <table class="table">
                            <thead>
                            <tr>
                            <td><p class="text-center my-0"><b><liferay-ui:message key="leave-date"/></b></td>
                            <td><p class="text-center my-0"><b><liferay-ui:message key="day"/></b></td>
                            <td><p class="text-center my-0"><b><liferay-ui:message key="Day Type"/></b></td>

                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="leaveDayType" items="${leaveDayTypeList}">
                                <tr>
                                    <td>
                                        <fmt:formatDate value="${leaveDayType.leaveDate}" pattern="dd-MMM-yyyy"
                                                        var="formatedLeaveDate"/>
                                        <p class="text-center my-0">${formatedLeaveDate }</p>
                                    </td>
                                    <td>
                                        <p class="text-center my-0">${leaveDayType.isHalfDay ?  'Half Day' : "Full Day" }</p>
                                    </td>
                                   <td>
                                                                           <c:if test="${leaveDayType.isHalfDay}">
                                                                               <c:choose>
                                                                                   <c:when test="${leaveDayType.isFirstHalf }">
                                                                                        <p class="text-center my-0"><liferay-ui:message key="first-half"/></p>
                                                                                   </c:when>
                                                                                   <c:otherwise>
                                                                                       <p class="text-center my-0"> <liferay-ui:message key="second-half"/></p>
                                                                                   </c:otherwise>
                                                                               </c:choose>
                                                                           </c:if>
                                                                       </td>
                                </tr>







                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <c:if test="${not empty leaveRequestDto and not empty leaveRequestDto.comment}">
	            <div class="col-md-6 col-12">
	                <div class="card">
	                    <div class="card-header">
	                        <strong>
	                            Comment
	                        </strong>
	                    </div>
	                    <div class="card-body">
	                        <table class="table">
	                            <thead>
	                            <tr>
	                                <th scope="col"><liferay-ui:message key="comment"/></th>
	                                <th scope="col"><liferay-ui:message key="By"/></th>
	                            </tr>
	                            </thead>
	                            <tbody>
	                            	<tr>
	                            		<td>${empty leaveRequestDto ? '' : leaveRequestDto.comment}</td>
	                            		<td>${empty leaveRequestDto ? '' : leaveRequestDto.commentedBy}</td>
	                            	</tr>
	                            </tbody>
	                         </table>
	                     </div>
	                 </div>
	             </div>
             </c:if>
        </div>
        
    </div>

    <div class="card-footer text-right align-items-center">
        <a href="${homeUrl }" class="btn btn-outline-danger"><liferay-ui:message key="back"></liferay-ui:message></a>
    </div>
</div>


