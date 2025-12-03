<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>

<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>

<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>

<%@taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@page import="com.ax.hrms.master.service.WishTypeMasterLocalServiceUtil"%>
<%@page import="com.ax.hrms.master.model.WishTypeMaster"%>
<%@page import="com.ax.hrms.master.service.WishTypeMasterLocalService"%>

<%@page import="com.ax.hrms.master.service.ProbationStatusMasterLocalServiceUtil"%>
<%@page import="com.ax.hrms.master.model.ProbationStatusMaster"%>
<%@page import="com.ax.hrms.master.service.ProbationStatusMasterLocalService"%>

<%@page import="com.ax.hrms.master.service.PolicyTypeMasterLocalServiceUtil"%>
<%@page import="com.ax.hrms.master.model.PolicyTypeMaster"%>
<%@page import="com.ax.hrms.master.service.PolicyTypeMasterLocalService"%>

<%@page import="com.ax.hrms.master.service.LeaveCompensatoryStatusMasterLocalServiceUtil"%>
<%@page import="com.ax.hrms.master.model.LeaveCompensatoryStatusMaster"%>
<%@page import="com.ax.hrms.master.service.LeaveCompensatoryStatusMasterLocalService"%>

<%@page import="com.ax.hrms.master.service.EducationLevelMasterLocalServiceUtil"%>
<%@page import="com.ax.hrms.master.model.EducationLevelMaster"%>
<%@page import="com.ax.hrms.master.service.EducationLevelMasterLocalService"%>

<%@ page import="java.util.List" %>

<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="javax.portlet.PortletURL"%>

<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.20.0/jquery.validate.min.js" integrity="sha512-WMEKGZ7L5LWgaPeJtw9MBM4i5w5OSBlSjTjCtSnvFJGSVD26gE5+Td12qN5pvWXhuWaWcVwF++F7aqu9cvqP0A==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>

<script type="text/javascript"><%@include file="/js/education-level-master/main.js" %></script>

<liferay-theme:defineObjects />

<portlet:defineObjects />