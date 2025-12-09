<%@ include file="/init.jsp" %>


<h1>Hello World</h1>

<portlet:renderURL var="goToAnotherJsp">
<portlet:param name="mvcPath" value="/jsp/add_edit_work_from_home.jsp" />
</portlet:renderURL>

<a href="${goToAnotherJsp}" class="btn btn-primary mt-3">
    Add Work From Home Request
</a>