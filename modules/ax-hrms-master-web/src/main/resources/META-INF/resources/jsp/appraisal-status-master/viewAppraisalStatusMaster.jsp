<%@ include file="/init.jsp" %>
<portlet:renderURL var="appraisalStatusMasterList" >
	<portlet:param name="mvcRenderCommandName" value="/" />
</portlet:renderURL>

<head>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css"
  integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA=="
  crossorigin="anonymous" referrerpolicy="no-referrer" />
  
</head>


<div class="card">
  <div class="card-header"><strong><liferay-ui:message key="appraisal-status-details"/></strong></div>
  <div class="card-body mb-0">
  <p class="card-text fs-5"><liferay-ui:message key="appraisal-status-master" />  : ${appraisalStatusMaster.status}</p>

	</div>
  <div class="card-footer text-right mb-0">
  <a href="${appraisalStatusMasterList}" class="btn btn-outline-danger "><liferay-ui:message key="back"/></a>

</div>
</div>

