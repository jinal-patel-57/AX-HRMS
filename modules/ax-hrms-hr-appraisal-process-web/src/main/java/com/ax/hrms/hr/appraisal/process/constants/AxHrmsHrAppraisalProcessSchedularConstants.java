package com.ax.hrms.hr.appraisal.process.constants;

/**
 * @author nivid.koradiya
 */
public class AxHrmsHrAppraisalProcessSchedularConstants {

	public static final String EXTRACT_MONTH_FROM_JOINING_DATE_SQL = "EXTRACT(MONTH FROM joiningDate) = ?";
	public static final String LEAVING_DATE = "leavingDate";
	public static final String STATUS = "status";
	public static final String HR_ADMIN = "HR Admin";
	public static final String EMPLOYEE_ID = "employeeId";
	public static final String SENDER_MAIL_ADDRESS = "devflix.mail.me@gmail.com";
	public static final String SENDER_NAME = "AX HRMS";
	public static final String SUBJECT = "Upcoming Appraisals This Month";
	public static final String FETCH_APPRAISAL_DATE_SCHEDULER = "Fetch Appraisal Details Scheduler";





	public static final String HR_APPRISAL_REMMINDER_MAIL_HEAD = "<body style=\"font-family: Arial, sans-serif; line-height: 1.6; margin: 0; padding: 0;\">\n <div style=\"background-color: #007bff; color: #fff; padding: 10px; text-align: center;\">\n <h2>Upcoming Appraisals</h2>\n </div>\n <div style=\"padding: 20px;\">\n <p>Dear HR Team,</p>\n <p>Please find below the details of upcoming employee appraisals in month :</p>\n <table style=\"width: 100%; border-collapse: collapse;\">\n <thead>\n" +
			"                <tr>\n" +
			"                    <th style=\"border: 1px solid #ddd; padding: 10px; background-color: #f2f2f2; text-align: left;\">Employee Name</th>\n" +
			"                    <th style=\"border: 1px solid #ddd; padding: 10px; background-color: #f2f2f2; text-align: left;\">Employee Code</th>\n" +
			"                    <th style=\"border: 1px solid #ddd; padding: 10px; background-color: #f2f2f2; text-align: left;\">Department</th>\n" +
			"                    <th style=\"border: 1px solid #ddd; padding: 10px; background-color: #f2f2f2; text-align: left;\">Designation</th>\n" +
			"                    <th style=\"border: 1px solid #ddd; padding: 10px; background-color: #f2f2f2; text-align: left;\">Appraisal Date</th>\n" +
			"                </tr>\n" +
			"            </thead>\n" +
			"            <tbody>\n";

	public static final String HR_APPRISAL_REMMINDER_MAIL_FOOTER = "</tbody>\n </table>\n <p>This mail is sent automatically via AX_HRMS Systems, Please contact Admin if any information is found suspectful.</p>\n </div>\n </body>\n </html>\n" ;
}