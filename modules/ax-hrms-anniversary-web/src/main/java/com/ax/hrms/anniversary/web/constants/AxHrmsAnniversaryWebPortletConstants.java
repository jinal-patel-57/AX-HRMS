package com.ax.hrms.anniversary.web.constants;

/**
 * @author krish.moradiya
 * @implNote - this is class that have many constants of Anniversary notification features
 */
public class AxHrmsAnniversaryWebPortletConstants {

    private AxHrmsAnniversaryWebPortletConstants(){}

    public static final String DEFAULT_PATH = "/";
    public static final String EMPLOYEE_ANNIVERSARY_LIST_JSP_PATH = "/jsp/ax-hrms-anniversary-web/listEmployeeAnniversaryDetails.jsp";
    public static final String MAIN_CSS_PATH = "/css/ax-hrms-anniversary-web/main.css";
    public static final String MAIN_JS_PATH = "/js/ax-hrms-anniversary-web/main.js";
    public static final String JQUERY_JS_PATH = "/js/ax-hrms-anniversary-web/jquery-3.7.1.js";
    public static final String JQUERY_VALIDATOR_JS_PATH = "/js/ax-hrms-anniversary-web/jquery.validate.min.js";
    public static final String SEND_ANNIVERSARY_WISH = "/sendAnniversaryWish";

    public static final String EMPLOYEE_ID = "employeeId";
    public static final String BODY = "body";
    public static final String DEPARTMENT ="Department";
    public static final String DESIGNATION ="Designation";
    public static final String EMPLOYEE_CODE ="Employee Code";
    public static final String WISHES_DATA = "wishesData";
    public static final String HR_ADMIN = "HR Admin";
    public static final String ANNIVERSARY = "Work Anniversary";
    public static final String ONE_SPACE = " ";
    public static final String DASH = "-";
    public static final String PORTLET_CATEGORY = "AX HRMS";
    public static final String ANNIVERSARY_EMPLOYEE_OF_TODAY = "Anniversary Employee Of Today";
    public static final String ANNIVERSARY_WISH_MAIL_SUBJECT_POSTFIX = " Send you anniversary Wishes";
    public static final String DATE_OBJECT_NULL_MESSAGE = "Date object cannot be null";
    public static final String ANNIVERSARY_EMPLOYEE_LIST = "anniversaryEmployeeList";
    public static final String WISH_TYPE_MASTER_LIST = "wishTypeMasterList";
    public static final String WISH_TYPE_MASTER_ID = "wishTypeMasterId";
    public static final String ANNIVERSARY_WISH_TYPE_MASTER_ID = "anniversaryWishTypeMasterId";
    public static final String SEND_WISHES_SUCCESSFULLY_MESSAGE = "sent-wishes-successfully";
    public static final String ERROR_MESSAGE_KEY = "error-message-key";

    public static final String ANNIVERSARY_REMMINDER_MAIL_HEAD = "<table style=\"width: 100%; border-collapse: collapse;\">\n <thead>\n"
            + "                <tr>\n"
            + "                    <th style=\"border: 1px solid #ddd; padding: 10px; background-color: #f2f2f2; text-align: left;\">Employee Id</th>\n"
            + "                    <th style=\"border: 1px solid #ddd; padding: 10px; background-color: #f2f2f2; text-align: left;\">Employee Name </th>\n"
            + "                    <th style=\"border: 1px solid #ddd; padding: 10px; background-color: #f2f2f2; text-align: left;\">Department</th>\n"
            + "                    <th style=\"border: 1px solid #ddd; padding: 10px; background-color: #f2f2f2; text-align: left;\">Designation</th>\n"
            + "                </tr>\n" + "            </thead>\n" + "            <tbody>\n";

    public static final String BODY_TR_START = "<tr>\n <td style=\"border: 1px solid #ddd; padding: 10px;\">";
    public static final String BODY_TD_FIRST = "</td>\n  <td style=\"border: 1px solid #ddd; padding: 10px;\">";
    public static final String BODY_TD_SECOND = "</td>\n <td style=\"border: 1px solid #ddd; padding: 10px;\"> ";
    public static final String BODY_TD_THIRD = "</td>\n <td style=\"border: 1px solid #ddd; padding: 10px;\">";
    public static final String BODY_TR_END = "</td>\n </tr>\n";
    public static final String SLASH = "/";
    public static final String COLON_AND_SPACE = ": ";
    public static final String COMMA_AND_SPACE = ", ";
    public static final String ARROW = " --> ";

    public static final String ANNIVERSARY_REMMINDER_MAIL_FOOTER = "</tbody>\n </table>\n ";

}
