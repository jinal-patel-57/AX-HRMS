<%@ include file="init.jsp"%>

<portlet:renderURL var="updateTaskURL">
	<portlet:param name="mvcRenderCommandName" value="/addTask" />
	<portlet:param name="taskId" value="${taskDto.taskId}" />
	<portlet:param name="projectId" value="${taskDto.projectId}" />
</portlet:renderURL>

<portlet:actionURL name="/addReview" var="addReviewURL">
	<portlet:param name="taskId" value="${taskDto.taskId}" />
	<portlet:param name="backURL" value="${updateTaskURL}" />
</portlet:actionURL>


<div class="card">
  <div class="card-header"><strong> <liferay-ui:message key="add-review"></liferay-ui:message>  </strong></div>
  <form method="post" action="${addReviewURL}" id="addReviewForm">
  <div class="card-body mb-0">
<div class="row">
<div class="col-12">
<div class="form-group">
		<label for="<portlet:namespace />review"><liferay-ui:message key="Review" /><span class="text-danger">*</span></label>
		<textarea class="form-control" cols="30" rows="4" id="review"
			name="<portlet:namespace />review"></textarea>
	</div>
</div>
<div class="col-12">
<c:if test="${not empty reviewList}">
<table class="table ">
		<thead>
			<tr>
				<th scope="col" width="170"><liferay-ui:message key="Date of Review" /></th>
				<th scope="col" class="text-break"><liferay-ui:message key="Review" /></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="review" items="${reviewList}">
				<tr>
					<fmt:formatDate value="${review.dateOfReview}" pattern="yyyy-MM-dd"
						var="formatedReviewDate" />

					<td>${formatedReviewDate}</td>
					<td class="text-break">${review.review}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</c:if>
</div>

</div>

	

</div>
  <div class="card-footer text-right mb-0">

	<button type="submit" class="btn btn-outline-success" id="submit">
		<liferay-ui:message key="Submit" /></button>

</div>
</form>
</div>

<<script type="text/javascript">
$(document).ready(function(){
 	var config = new Object({}),
 	namespace = '<portlet:namespace />',
	review = 'review';
	
	
	
	
	
 	config.namespace = namespace;
 	config.review = review;
 	
 		
 		
 		
 		
 		
 	AxHrmsTaskWebPortlet.setReviewConfigs(config);
 });	
</script>

