package com.ax.hrms.leave.management.web.constants;

public class AxHrmsHrLeaveManagementSystemWebPortletConstants {

	public static final String LIST_VIEW_LEAVE_REQUEST_JSP = "/jsp/ax-hrms-leave-management-hr/listLeaveRequest.jsp";

	public static final String VIEW_LEAVE_REQUEST_JSP = "/jsp/ax-hrms-leave-management-hr/viewLeaveRequest.jsp";

	public static final String DEFAULT_JSP = "/";
	public static final String APPROVED = "Approved";
	public static final String REJECTED = "Rejected";
	public static final String CANCELLED = "Cancelled";
	public static final String TOTAL_LEAVE_REQUEST = "totalLeaveRequest";
	public static final String LEAVE_REQUEST_LIST = "leaveRequestList";
	public static final String APPROVED_ID = "approvedId";
	public static final String REJECTED_ID = "rejectedId";
	public static final String CANCELLED_ID = "cancelId";
	public static final String ITERATOR_URL = "iteratorURL";
	public static final String DATE_FORMAT = "dd-MMM-yyyy";
	public static final String TO = " to ";
	public static final String DD_MM_YYYY = "dd-MM-yyyy";


	// Aprroved Leave Request

	public static final String APPROVED_LEAVE_REQUEST = "/approveLeaveRequest";
	public static final String LEAVE_REQUEST_ID = "leaveRequestId";
	public static final String LEAVE_REQUEST_APPROVED = "leave-request-approved";
	public static final String SOME_ERROR_FOUND = "some-error-found";

	// view Leave Request
	public static final String VIEW_LEAVE_REQUEST = "/viewLeaveRequest";
	public static final String LEAVE_DAY_TYPE_LIST = "leaveDayTypeList";
	public static final String LEAVE_REQUEST_DTO = "leaveRequestDto";

	// Reject and Cancel Leave request

	public static final String REJECT_CANCEL_LEAVE_REQUEST = "/rejectCancelLeaveRequest";
	public static final String LEAVE_REQUEST_CANCELLED = "leave-request-cancelled";
	public static final String LEAVE_REQUEST_REJECTED = "leave-request-rejected";

	// Mail Body
	public static final String LEAVE_REQUEST_MAIL_HEAD = "<body style=\"font-family: Arial, sans-serif; line-height: 1.6; margin: 0; padding: 0;\">\n  <div style=\"padding: 20px;\">\n  <table style=\"width: 100%; border-collapse: collapse;\">\n <thead>\n"
			+ "                <tr>\n"
			+ "                    <th style=\"border: 1px solid #ddd; padding: 10px; background-color: #f2f2f2; text-align: left;\">Employee Code</th>\n"
			+ "                    <th style=\"border: 1px solid #ddd; padding: 10px; background-color: #f2f2f2; text-align: left;\">Employee Name </th>\n"
			+ "                    <th style=\"border: 1px solid #ddd; padding: 10px; background-color: #f2f2f2; text-align: left;\">Department</th>\n"
			+ "                    <th style=\"border: 1px solid #ddd; padding: 10px; background-color: #f2f2f2; text-align: left;\">Designation</th>\n"
			+ "                    <th style=\"border: 1px solid #ddd; padding: 10px; background-color: #f2f2f2; text-align: left;\">Status</th>\n"
			+ "                    <th style=\"border: 1px solid #ddd; padding: 10px; background-color: #f2f2f2; text-align: left;\">Leave Request Date</th>\n"
			+ "                    <th style=\"border: 1px solid #ddd; padding: 10px; background-color: #f2f2f2; text-align: left;\">Start Date of Leave</th>\n"
			+ "                    <th style=\"border: 1px solid #ddd; padding: 10px; background-color: #f2f2f2; text-align: left;\">End Date of Leave</th>\n"



			+ "                </tr>\n" + "            </thead>\n" + "            <tbody>\n";

	public static final String LEAVE_REQUEST_MAIL_FOOTER = "</tbody>\n </table>\n  </div>\n </body>\n </html>\n";

	public static final String LEAVE_REQUEST_TEAM_MAIL_HEAD = "<body style=\"font-family: Arial, sans-serif; line-height: 1.6; margin: 0; padding: 0;\">\n  <div style=\"padding: 20px;\">\n  <table style=\"width: 100%; border-collapse: collapse;\">\n <thead>\n"
			+ "                <tr>\n"
			+ "                    <th style=\"border: 1px solid #ddd; padding: 10px; background-color: #f2f2f2; text-align: left;\">Employee Code</th>\n"
			+ "                    <th style=\"border: 1px solid #ddd; padding: 10px; background-color: #f2f2f2; text-align: left;\">Employee Name </th>\n"
			+ "                    <th style=\"border: 1px solid #ddd; padding: 10px; background-color: #f2f2f2; text-align: left;\">Department</th>\n"
			+ "                    <th style=\"border: 1px solid #ddd; padding: 10px; background-color: #f2f2f2; text-align: left;\">Designation</th>\n"
			+ "                    <th style=\"border: 1px solid #ddd; padding: 10px; background-color: #f2f2f2; text-align: left;\">Status</th>\n"
			+ "                    <th style=\"border: 1px solid #ddd; padding: 10px; background-color: #f2f2f2; text-align: left;\">Leave Request Date</th>\n"
			+ "                    <th style=\"border: 1px solid #ddd; padding: 10px; background-color: #f2f2f2; text-align: left;\">Start Date of Leave</th>\n"
			+ "                    <th style=\"border: 1px solid #ddd; padding: 10px; background-color: #f2f2f2; text-align: left;\">End Date of Leave</th>\n"



			+ "                </tr>\n" + "            </thead>\n" + "            <tbody>\n";

	public static final String LEAVE_REQUEST_MAIL_STYLE = "</td>\n  <td style=\"border: 1px solid #ddd; padding: 10px;\">";
	public static final String LEAVE_REQUEST_MAIL_STYLE_CLOSING = "</td>\n </tr>\n";

	public static final String YOUR_LEAVE_REQUEST_IS_APPROVED = "Your Leave Request is Approved";
	public static final String YOUR_TEAM_MEMBER_IS_ON_LEAVE ="Your Team Member is on Leave";
	
	public static final String YOUR_LEAVE_REQUEST_IS_REJECTED = "Your Leave request is Rejected";
	public static final String YOUR_LEAVE_REQUEST_IS_CANCELLED = "Your Leave request is Cancelled";

	
}
