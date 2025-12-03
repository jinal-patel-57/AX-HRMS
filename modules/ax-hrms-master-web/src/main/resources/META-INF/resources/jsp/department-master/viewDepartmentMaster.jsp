<%@ include file="/init.jsp" %>


  <div class="card">
  
  <div class="card-header"> <strong><liferay-ui:message key="department-details" />  </strong></div>
  <div class="card-body"><p class="card-text fs-5"><liferay-ui:message key="department-name" />  : ${getDepartmentMasterRecord.departmentName}</p>
   </div>
  <div class="card-footer mb-0 text-right">     <a href="<liferay-portlet:renderURL portletMode='view' windowState='normal' />" class="btn btn-outline-danger"><liferay-ui:message key ="back-button" /></a>
  </div>
  
  </div>