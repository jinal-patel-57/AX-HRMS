package com.ax.hrms.master.web.constants;


public class AxDepartmentMasterWebPortletConstants {

	//common used 
	public static final String DEPARTMENTS_MASTER_ID="departmentMasterId";
	public static final String ITERATOR_URL="iteratorURL";
	public static final String DEPARTMENT_NAME="departmentName";
	
	//AddEditDepartmentMasterActionCommand
	public static final String DEPARTMENT_ADDED="departmentAdded";
	public static final String DEPARTMENT_EXISTS="departmentExists";
	public static final String EXISTED_DEPARTMENT_NAME="existedDepartmentName";
	public static final String MVC_PATH = "mvcPath";
	public static final String ADD_DEPARTMENT_MASTER_JSP="/jsp/department-master/addEditDepartmentMaster.jsp";
	
	//DeleteDepartmentMasterDetailsMVCActionCommand
	public static final String DEPARTMENTID_REQUIRED="departmentId-required";
	public static final String DEPARTMENT_DELETED="departmentDeleted";
	public static final String DEPARTMENT_NOT_FOUND="departmentNotFound";
	
	//ViewDepartmentMasterDetailsMVCRenderCommand
	public static final String GET_DEPARTMENT_MASTER_RECORD="getDepartmentMasterRecord";
	public static final String DEPARTMENT_MASTER_RECORD="/jsp/department-master/viewDepartmentMaster.jsp";
	
	//FetchDepaertmentMasterMVCRenderCommand
	public static final String GET_DEPARTMENT_MASTER="getdepartmentMaster";
	
	//ViewDepartmentMasterListMVCRenderCommand
	public static final String DEPARTMENTS_MASTER="departmentMasters";
	public static final String DEPARTMENT_MASTER_COUNT="departmentMastersCount";
	public static final String DELTA="delta";
	public static final String VIEW_DEPARTMENT_MASTER_JSP="/jsp/department-master/listDepartmentMaster.jsp";
}

