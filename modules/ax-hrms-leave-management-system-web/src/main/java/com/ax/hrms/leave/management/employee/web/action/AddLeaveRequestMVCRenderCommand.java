package com.ax.hrms.leave.management.employee.web.action;

import com.ax.hrms.common.api.api.AxHrmsCommonApi;
import com.ax.hrms.exception.NoSuchEmployeeDetailsException;
import com.ax.hrms.leave.management.employee.web.util.LeaveRequestUtil;
import com.ax.hrms.leave.management.web.constants.AxHrmsLeaveManagementSystemWebPortletKeys;
import com.ax.hrms.leave.management.web.constants.AxHrmsLeaveManagementWebPortletConstants;
import com.ax.hrms.leave.management.web.dto.LeaveRequestDto;
import com.ax.hrms.master.model.LeavePolicyMaster;
import com.ax.hrms.master.model.LeaveTypeMaster;
import com.ax.hrms.master.service.LeavePolicyMasterLocalService;
import com.ax.hrms.master.service.LeaveTypeMasterLocalService;
import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.model.Holiday;
import com.ax.hrms.model.LeaveBalance;
import com.ax.hrms.module.config.configuration.ModuleConfiguration;
import com.ax.hrms.service.EmployeeDetailsLocalService;
import com.ax.hrms.service.HolidayLocalService;
import com.ax.hrms.service.LeaveBalanceLocalService;
import com.ax.hrms.service.LeaveTypeViewPermitLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.*;
import java.util.stream.Collectors;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author krish.moradiya
 * @implNote Add Leave Request form render
 */
@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + AxHrmsLeaveManagementSystemWebPortletKeys.AXHRMS_EMPLOYEE_LEAVE_MANAGEMENT_SYSTEM_WEB_PORTLET,
                "mvc.command.name=/addLeaveRequest"
        },
        service = MVCRenderCommand.class
)
public class AddLeaveRequestMVCRenderCommand implements MVCRenderCommand {

	private static final Log log = LogFactoryUtil.getLog(AddLeaveRequestMVCRenderCommand.class);
	@Reference
	private	LeaveTypeMasterLocalService leaveTypeMasterLocalService;

	@Reference
	private LeavePolicyMasterLocalService leavePolicyMasterLocalService;

	@Reference
	private EmployeeDetailsLocalService employeeDetailsLocalService;

	@Reference
	private LeaveTypeViewPermitLocalService leaveTypeViewPermitLocalService;
	@Reference
	private LeaveBalanceLocalService leaveBalanceLocalService;
	@Reference
	private RoleLocalService roleLocalService;

	@Reference
	private UserLocalService userLocalService;
    @Reference
    private HolidayLocalService holidayLocalService;
    @Reference
    ModuleConfiguration moduleConfiguration;
	
	private static int currentYear = Year.now().getValue();
	
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		List<LeaveRequestDto> listOfLeaveTypeMaster = null;
		int year = Calendar.getInstance().get(Calendar.YEAR);



		List<LeavePolicyMaster> listOfLeavePolicyMaster = leavePolicyMasterLocalService.findByYear(year);
		List<EmployeeDetails> listOfEmployeeDetails = employeeDetailsLocalService.findByIsTerminated(false);
		List<LeaveBalance> leaveBalanceList = new ArrayList<>();

		/**
		 * @implNote : listOfFilteredEmployeeDetails is a list of Employee Details in which auth user's role is Employee
		 */
        String emailId =
                moduleConfiguration.employeeOfficialMailIdForIgnoreFromEmployeeDirectory();
        log.info("email Ids are :: "+emailId);
        Set<String> ignoreEmailSet = Arrays.stream(emailId.split(","))
                .map(String::trim)
                .map(String::toLowerCase)
                .filter(mail -> !mail.isEmpty())
                .collect(Collectors.toSet());
        log.info("ignoreEmailSet are :: "+ignoreEmailSet);

        List<EmployeeDetails> listOfFilteredEmployeeDetails = new ArrayList<>();
		long currentUserId = themeDisplay.getUserId();
		for(EmployeeDetails employeeDetails : listOfEmployeeDetails) {

            String email = employeeDetails.getOfficialEmail();
            if (Validator.isNotNull(email) &&
                    ignoreEmailSet.contains(email.trim().toLowerCase())) {
                log.info(email + " is ignored");
                continue;
            }

			if (employeeDetails.getLrUserId() != currentUserId) {
				listOfFilteredEmployeeDetails.add(employeeDetails);
				continue;
        	}



            /*
			 * try { long employeeRoleId =
			 * RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(),
			 * AxHrmsLeaveManagementWebPortletConstants.EMPLOYEE).getRoleId(); long[]
			 * userRoles =
			 * userLocalService.getUserById(employeeDetails.getLrUserId()).getRoleIds();
			 * for(long userRole : userRoles) { if(userRole == employeeRoleId)
			 * listOfFilteredEmployeeDetails.add(employeeDetails); } } catch
			 * (PortalException e) { log.
			 * error("ViewLeaveRequestFormMVCRenderCommand >>> render ::: PortalException: "
			 * +e.getMessage()); }catch (NullPointerException e) { log.
			 * error("ViewLeaveRequestFormMVCRenderCommand >>> render ::: NullPointerException: "
			 * +e.getMessage()); }catch(Exception e) {
			 * log.error("ViewLeaveRequestFormMVCRenderCommand >>> render ::: Exception: "+e
			 * .getMessage()); }
			 */
			
		}
		try{
			leaveBalanceList = leaveBalanceLocalService.findByEmployeeIdAndYear(employeeDetailsLocalService.findByLrUserId(themeDisplay.getUserId()).getEmployeeId(), currentYear);
			long hrRoleId = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), AxHrmsLeaveManagementWebPortletConstants.HR).getRoleId();
			long[] hrRoles = themeDisplay.getUser().getRoleIds();
			boolean isHr = Arrays.stream(hrRoles).anyMatch(id -> id == hrRoleId);
			if(isHr) {
				renderRequest.setAttribute(AxHrmsLeaveManagementWebPortletConstants.IS_HR_STATUS, isHr);
			}
            List<Holiday> holidayList=null;
            try {
                holidayList = holidayLocalService.findByYear(year);
            } catch (Exception exception) {
                log.info("Exception raised due to ::: "+exception.getMessage());
            }
            JSONArray holidayJsonArray = JSONFactoryUtil.createJSONArray();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            if(Validator.isNotNull(holidayList)) {
                for (Holiday holiday : holidayList) {
                    log.info("Holiday is the ::"+holiday.toString());
                    if (!holiday.getIsFloater()) {   // Filter non-floater only
                        holidayJsonArray.put(sdf.format(holiday.getDate()));
                    }
                }
            }

            renderRequest.setAttribute("holidayJson", holidayJsonArray.toString());
		}catch(Exception e){
			log.error("ViewLeaveRequestFormMVCRenderCommand >>> render ::: Exception: "+e.getMessage());
		}
		List<LeaveTypeMaster> leaveTypeMasterList = leaveTypeMasterLocalService.getLeaveTypeMasters(-1,-1);

		try {
			listOfLeaveTypeMaster = LeaveRequestUtil.getListOfLeaveType(leaveTypeMasterList,leaveBalanceList,employeeDetailsLocalService.findByLrUserId(themeDisplay.getUserId()).getEmployeeId(),listOfLeavePolicyMaster);
		} catch (NoSuchEmployeeDetailsException e) {
			e.getMessage();
		}
		
		renderRequest.setAttribute(AxHrmsLeaveManagementWebPortletConstants.EMPLOYEE_DETAILS_LIST,listOfFilteredEmployeeDetails);
		renderRequest.setAttribute(AxHrmsLeaveManagementWebPortletConstants.LEAVE_TYPE_MASTER_LIST, listOfLeaveTypeMaster);
		return AxHrmsLeaveManagementWebPortletConstants.ADD_LEAVE_REQUEST_JSP_PATH;
	}
    
}