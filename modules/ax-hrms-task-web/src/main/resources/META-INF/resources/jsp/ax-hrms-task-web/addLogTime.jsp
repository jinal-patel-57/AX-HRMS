<%@ include file="init.jsp"%>

<portlet:renderURL var="updateTaskURL">
	<portlet:param name="mvcRenderCommandName" value="/addTask" />
	<portlet:param name="taskId" value="${timeTrackerDto.taskId}" />
	<portlet:param name="projectId" value="${ not empty task.projectId ? task.projectId : timeTrackerDto.projectId}" />

</portlet:renderURL>




<portlet:renderURL var="homeUrl">
	<portlet:param name="projectId" value="${task.getProjectId()}" />
</portlet:renderURL>

<portlet:renderURL var="editLogTimeURL">
	<portlet:param name="mvcRenderCommandName" value="/addLogTime" />
	<portlet:param name="timeTrackerId"
		value="${timeTrackerDto.timeTrackerId}" />

</portlet:renderURL>

<portlet:actionURL name="/addUpdateLogTime" var="addLogTimeURL">
	<portlet:param name="timeTrackerId"
		value="${timeTrackerDto.timeTrackerId}" />
	<portlet:param name="backURL"
		value="${empty timeTrackerDto.timeTrackerId ? homeUrl : updateTaskURL }" />
</portlet:actionURL>

<portlet:actionURL name="/deleteAttachment" var="deleteAttachmentURL">

	<portlet:param name="attachmentId" value="ATTACHMENTID" />
	<portlet:param name="backURL" value="${editLogTimeURL}" />
</portlet:actionURL>



<liferay-ui:success key="attachment-deleted"
	message="Attachment is Deleted !!"></liferay-ui:success>
<liferay-ui:error key="error" message="some error is occurs !!!"></liferay-ui:error>


<div class="card">
  <div class="card-header"><strong> <liferay-ui:message key="add-logTime"></liferay-ui:message> </strong></div>
<form method="Post" action="${addLogTimeURL }" id="addTimeForm">
  <div class="card-body mb-0">
<div class="row ">
				<input type="hidden"
					value="${not empty task.getTaskId() ? task.getTaskId() : timeTrackerDto.taskId}"
					id="<portlet:namespace/>taskId" name="<portlet:namespace/>taskId" />

<div class="col-md-4 col-sm-12">
				<div class="form-group">
					<label for="<portlet:namespace />taskName"><liferay-ui:message
							key="task-name" /><span class="text-danger">*</span></label> <input type="text" class="form-control"
						id="taskName" name="<portlet:namespace />taskName"
						value="${not empty task.getTaskName() ? task.getTaskName() : timeTrackerDto.taskName   }"
						disabled />
				</div>

</div>

<div class="col-md-4 col-sm-12">
				<div class="form-group">
					<fmt:formatDate value="${timeTrackerDto.startTime}"
						pattern="yyyy-MM-dd HH:mm:ss" var="formatedStartTime" />

					<label for="<portlet:namespace />startTime"><liferay-ui:message
							key="StartTime" /><span class="text-danger">*</span></label> <input type="datetime-local"
						class="form-control" id="startTime"
						name="<portlet:namespace />startTime" value="${formatedStartTime}">
				</div>

</div>
<div class="col-md-4 col-sm-12">

				<div class="form-group">
					<fmt:formatDate value="${timeTrackerDto.endTime}"
						pattern="yyyy-MM-dd HH:mm:ss" var="formatedEndTime" />
					<label for="<portlet:namespace />endTime"><liferay-ui:message
							key="EndTime" /><span class="text-danger">*</span></label> <input type="datetime-local"
						class="form-control" id="endTime"
						name="<portlet:namespace />endTime" value="${formatedEndTime}">
				</div>
</div>
<div class="col-md-4 col-sm-12">
				<div class="form-group">
					<label for="<portlet:namespace />duration"><liferay-ui:message
							key="duration" /><span class="text-danger">*</span></label> <input type="number" class="form-control"
						id="duration" name="<portlet:namespace />duration"
						/ value="${timeTrackerDto.duration}">
				</div>
</div>
<div class="col-md-4 col-sm-12">
				<div class="form-group">
					<label for="<portlet:namespace />attachments"> <liferay-ui:message
							key="attachments" />
					</label>




					<div class="row" id="fileInputsContainer">
						<%-- Iterate over the list of attachments --%>
						<c:forEach var="attachment" items="${fileList}">
							<div class="col-sm-8 file-input-row">
								File name: <a href="${attachment.previewURL }"
									download="${(attachment.file)}">${(attachment.file).getTitle()}</a>
								<input type="hidden" name="<portlet:namespace />attachmentId"
									value="${(attachment.file).getFileEntryId()}"> <input
									type="file" class="custom-file-input"
									name="<portlet:namespace />attachment" multiple="multiple"
									data-filename="${(attachment.file).getFileName()}">
							</div>
							<div class="col-sm-3">
								<a href="" class=" btn btn-danger"
									onclick="deleteAttachment(${(attachment.file).getFileEntryId()})"><i class="icon-trash"></a>
							</div>
						</c:forEach>
					</div>
</div>
					<div class="row">
						<div class="col-sm-2">
							<button class="btn btn-primary" type="button" id="addFileInput">+</button>
						</div>
					</div>
				</div>
				<br>
<div class="col-md-12 col-sm-12 ">
				<div class="form-group">
					<label for="<portlet:namespace />description"><liferay-ui:message
							key="description" /></label>
					<textarea class="form-control" cols="30" rows="4" id="description"
						name="<portlet:namespace />description"> ${not empty timeTrackerDto ? timeTrackerDto.description : '' } </textarea>
				</div>
</div>


</div>
</div>
  <div class="card-footer text-right mb-0">

				<a href="${not empty timeTrackerDto ? updateTaskURL : homeUrl }" class="btn btn-outline-danger mr-1"><liferay-ui:message key="back" /></a>
				
				<button type="submit" class="btn btn-outline-success" id="submit">
					<liferay-ui:message key="submit" />
				</button>
						


</div>
			</form>
</div>
			


<script>

$(document).ready(function(){
 	var config = new Object({}),
 	namespace = '<portlet:namespace />',
 	description = 'description',
 	startTime = 'startTime',
 	endTime = 'endTime',
 	duration = 'duration';
 	
	
	
	
	
 	config.namespace = namespace;
 	config.description = description;
 	config.startTime = startTime;
 	config.endTime = endTime;
 	config.duration = duration;
 	
 
 		
 		
 		
 		
 	AxHrmsTaskWebPortlet.setTimeConfigs(config);
 });	



</script>



<script>



$(document).ready(function() {
    $("#addFileInput").click(function() {
        var container = $("#fileInputsContainer");
        var newInput = $('<div class="row file-input-row">' +
                            '<div class="col-sm-8">' +
                                '<input type="file" class="form-control" name="<portlet:namespace />attachments" multiple="multiple">' +
                            '</div>' +
                            '<div class="col-sm-2">' +
                                '<button class="btn btn-outline-danger btn-sm delete-file-input" type="button"><i class="icon-trash"></button>' +
                            '</div>' +
                        '</div>');
        container.append(newInput);
    });

    // Event delegation for delete buttons since they are dynamically added
    $("#fileInputsContainer").on("click", ".delete-file-input", function() {
        $(this).closest(".file-input-row").remove();
    });
});


</script>

<script type="text/javascript">

function deleteAttachment(attachmentId){
	console.log("attachmentId id", attachmentId)
	deleteTaskURL = '${deleteAttachmentURL}';
		let url = deleteTaskURL;
		url = url.replace('ATTACHMENTID', attachmentId);
		if(confirm('Are you sure you want to delete ?')) 
			window.location.href = url;
	
};

   
</script>


