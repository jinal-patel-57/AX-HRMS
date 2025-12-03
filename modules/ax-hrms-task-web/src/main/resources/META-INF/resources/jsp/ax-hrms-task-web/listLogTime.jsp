<%@ include file="init.jsp"%>
<portlet:renderURL var="updateTaskURL">
	<portlet:param name="mvcRenderCommandName" value="/addTask" />
	<portlet:param name="taskId" value="${taskDto.taskId}" />
	<portlet:param name="projectId" value="${taskDto.projectId}" />
</portlet:renderURL>

<portlet:actionURL name="/deleteLogTime" var="deleteLogTimeURL">
	<portlet:param name="timeTrackerId" value="TIMETRACKERID" />
	<portlet:param name="backURL" value="${updateTaskURL }" />

</portlet:actionURL>

 <style>
        .Btn-disabled {
            pointer-events: none;
            opacity: 0.5;
        }
        
    </style>
    <c:if test="${ empty timeTrackerDtoList }">
    <div class="alert alert-info">
    <liferay-ui:message key="No any Log Time data!"/>
    </div>
    </c:if>
    
   <c:if test="${not empty timeTrackerDtoList }">
    <div class="card">
  <div class="card-body mb-0">

<table class="table ">
	<thead>
		<tr>
			<th scope="col"><liferay-ui:message key="description" /></th>
			<th scope="col"><liferay-ui:message key="start time" /></th>
			<th scope="col"><liferay-ui:message key="end time" /></th>
			<th scope="col"><liferay-ui:message key="Assignee" /></th>
			<th scope="col"><liferay-ui:message key="Duration" /></th>
			<th scope="col"><liferay-ui:message key="Attachments" /></th>
			<th scope="col"><liferay-ui:message key="Status" /></th>
			<th scope="col"><liferay-ui:message key="Action" /></th>
		</tr>
	</thead>
	<c:forEach var="timeTracker" items="${timeTrackerDtoList}"
		varStatus="status">

		<tbody>
			<tr>
				<td>${timeTracker.description}</td>
				<fmt:formatDate value="${timeTracker.startTime}"
					pattern="dd-MM-yyyy HH:mm:ss" var="formatedStartTime" />
				<td>${formatedStartTime}</td>
				<fmt:formatDate value="${timeTracker.endTime}"
					pattern="dd-MM-yyyy HH:mm:ss" var="formatedEndTime" />
				<td>${formatedEndTime}</td>
				<td>${timeTracker.assignedEmployee}</td>
				<td>${timeTracker.duration}</td>
				<td><c:forEach var="attachment"
						items="${timeTracker.attachmentList}">
						<p>

							<a href="${attachment.previewURL }"
								download="${(attachment.file)}">${(attachment.file).getTitle()}</a>

						</p>


					</c:forEach></td>
				<td>${timeTracker.managerApproveStatus}</td>

				<portlet:actionURL name="/approveRejectLogTime"
					var="approvedLogTimeURL">
					<portlet:param name="timeTrackerId"
						value="${timeTracker.timeTrackerId}" />
					<portlet:param name="command" value="Approved" />
					<portlet:param name="backURL" value="${updateTaskURL}" />
				</portlet:actionURL>

				<portlet:actionURL name="/approveRejectLogTime"
					var="rejectLogTimeURL">
					<portlet:param name="timeTrackerId"
						value="${timeTracker.timeTrackerId}" />
					<portlet:param name="backURL" value="${updateTaskURL}" />
				</portlet:actionURL>

				<portlet:renderURL var="editLogTimeURL">
					<portlet:param name="mvcRenderCommandName" value="/addLogTime" />
					<portlet:param name="timeTrackerId"
						value="${timeTracker.timeTrackerId}" />

				</portlet:renderURL>


				<td>
				<c:choose>
						    <c:when test="${isManager}">
						        <c:set var="pending" value="${timeTracker.managerApproveStatus == 'Pending'}" />
						        <c:set var="btnClass" value="${pending ? '' : 'Btn-disabled'}" />
						        
						        
			        <div class="dropdown ">
					<button class="btn fa fa-ellipsis-v dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" >
						<i class="icon-ellipsis-vertical"></i>
					</button>
					<ul class="dropdown-menu">
						<li>
						<a href="${approvedLogTimeURL }" class="dropdown-item ${btnClass}"><i class="icon-check"></i> <liferay-ui:message
						key="Approve" /></a>
						</li>
						<li>
						<a href="${rejectLogTimeURL }" class=" dropdown-item ${btnClass}"><i class="icon-ban-circle"></i> <liferay-ui:message
						key="Reject" /></a>
						</li>
					</ul>
				</div>
				
						        
						        
						        
						    </c:when>
						    <c:otherwise>
						        <c:set var="approveStatus" value="${timeTracker.managerApproveStatus == 'Approved'}" />
						        <c:set var="btnClass" value="${approveStatus ? 'Btn-disabled' : ''}" />
						        
						            
						            <div class="dropdown ">
					<button class="btn fa fa-ellipsis-v dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" >
						<i class="icon-ellipsis-vertical"></i>
					</button>
					<ul class="dropdown-menu">
						<li>
						<a href="${approveStatus ? '' : editLogTimeURL}" class=" dropdown-item ${btnClass} "><i class="icon-edit"></i> <liferay-ui:message
						key="Edit" /></a>
						</li>
						<li>
						<a class="dropdown-item  ${btnClass}"
					onclick="deleteLogTime(${timeTracker.timeTrackerId})"><i class="icon-trash"></i> <liferay-ui:message
						key="Delete" />
						</a></li>
					</ul>
				</div>
				
						    </c:otherwise>
				</c:choose>

					
					</td>

			</tr>
		</tbody>

	</c:forEach>
</table>
</div>
</div>
</c:if>

<script type="text/javascript">

function deleteLogTime(timeTrackerId){
	deleteTaskURL = '${deleteLogTimeURL}';
		let url = deleteTaskURL;
		url = url.replace('TIMETRACKERID', timeTrackerId);
		if(confirm('Are you sure you want to delete ?')) 
			window.location.href = url;
		
		
	
};




</script>

