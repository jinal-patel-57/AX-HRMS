<%@ include file="/init.jsp" %>

<liferay-ui:error key="holiday-hr-admin-exists" message="holiday-hr-admin-name-is-already-exist" />

<portlet:renderURL var="homeUrl">
    <portlet:param name="selectedYear" value="${not empty holidayData.getYear() ? holidayData.getYear() : 'SELECTED_YEAR' }"/>
</portlet:renderURL>

<portlet:actionURL name="/addEditHolidayHrAdmin" var="addEditHolidayHrAdminURL" >
    <portlet:param name="backURL" value="${homeUrl}"/>

</portlet:actionURL>

<portlet:actionURL name="/fetchHolidayHrAdmin" var="fetchHolidayHrAdminURL" />

<portlet:renderURL var="goBack"/>

<head>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.min.css">
</head>

<body>

<div class="card">
  <div class="card-header"><strong> <liferay-ui:message key="add-holiday"></liferay-ui:message>  </strong></div>
      <form action="${addEditHolidayHrAdminURL}" method="post" id="addEditHolidayHrAdmin">
  
  <div class="card-body mb-0">
  <div class="row ">

  <div class="col-md-4 col-sm-12 ">
  <div class="form-group">
  
   <input value="${holidayData.getHolidayId()}" type="hidden" name="<portlet:namespace />holidayId">
            <label for="holidayName"><liferay-ui:message key="holidayName" /><span class="text-danger">*</span></label>
            <input value="${holidayData.getHolidayName()}" id="holidayName" placeholder="Enter Holiday Name" class="form-control" type="text" name="<portlet:namespace/>holidayName">
  
  </div>
  
  </div>
  
  <div class="col-md-4 col-sm-12 ">
  <div class="form-group">
  
   <label for="holidayDate"><liferay-ui:message key="holidayDate" /><span class="text-danger">*</span></label>
            <input value="<fmt:formatDate pattern='yyyy-MM-dd' value='${holidayData.getDate()}'/>" id="holidayDate" placeholder="Enter Holiday Date" class="form-control datepicker" name="<portlet:namespace/>holidayDate">
  
  </div>
  
  </div>
  
  
  
  <div class="col-md-4 col-sm-12 ">
  <div class="form-group">
  <label for="isFloater"><liferay-ui:message key="holidayFloater" /><span class="text-danger">*</span></label>
            <div class="form-check">
                <input value="Yes" type="radio" class="form-check-input" id="isFloaterYes" ${holidayData.getIsFloater() eq true ? 'checked' : ''} name="<portlet:namespace/>isFloater">
                <label class="form-check-label" for="isFloaterYes"><liferay-ui:message key="yes" /></label>
            </div>

            <div class="form-check">
                <input value="No" type="radio" class="form-check-input" id="isFloaterNo" ${holidayData.getIsFloater() eq false ? 'checked' : ''} name="<portlet:namespace/>isFloater">
                <label class="form-check-label" for="isFloaterNo"><liferay-ui:message key="no" /></label>
            </div>
  
  </div>
  
  </div>
  <div class="col-md-12 col-sm-12 ">
  <div class="form-group">
   <label for="holidayDesc"><liferay-ui:message key="Holiday Description" /><span class="text-danger">*</span></label>
<%--             <input value="${holidayData.getDescription()}" id="holidayDesc" placeholder="Enter Holiday Description" class="form-control" type="text" name="<portlet:namespace/>holidayDesc"> --%>
  <textarea rows="4" cols="30" id="holidayDesc"  placeholder="Enter Holiday Description" class="form-control"  name="<portlet:namespace/>holidayDesc">${holidayData.getDescription()}</textarea>
  
  </div>
  
  </div>
  
				
</div>
</div>
  <div class="card-footer text-right mb-0 ">
   <div class="form-group">
                    <a href="${homeUrl}" class="btn btn-outline-danger mr-1"><liferay-ui:message key="back" /></a>
                    <button class="btn btn-outline-success" type="submit"><liferay-ui:message key="submit" /></button>
                </div>
  
  </div>
    </form>
 </div>




               

 <!-- Initialize Datepicker -->
  <script>
  $(document).ready(function() {
	    var currentYear = new Date().getFullYear();
	    var startDate = new Date(currentYear - 2, 0, 1); // January 1st of previous year
	    var endDate = new Date(currentYear + 1, 11, 31); // December 31st of next year
	    
	    $('.datepicker').datepicker({
	      format: 'yyyy-mm-dd',
	      autoclose: true,
	      startDate: startDate,
	      endDate: endDate
	    });
	  });
    
    $(document).ready(function(){
    	var config = {
    	   	namespace: '<portlet:namespace />'
        };
    	config.holidayName='holidayName';
    	config.holidayDate='holidayDate';
    	config.holidayDesc='holidayDesc';
    	config.isFloater='isFloater';
    	
    	AxHrmsHolidayHrAdminWebPortlet.setConfigsForValidation(config);
    });	
  </script>
 
</body>

