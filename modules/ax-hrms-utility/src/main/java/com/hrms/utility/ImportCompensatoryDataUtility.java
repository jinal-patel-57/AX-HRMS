
package com.hrms.utility;

import com.ax.hrms.common.api.api.AxHrmsCommonApi;
import com.ax.hrms.master.exception.NoSuchLeaveCompensatoryStatusMasterException;
import com.ax.hrms.master.service.LeaveCompensatoryStatusMasterLocalService;
import com.ax.hrms.model.CompensatoryData;
import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.model.EmployeeDetailsTable;
import com.ax.hrms.service.CompensatoryDataLocalService;
import com.ax.hrms.service.EmployeeDetailsLocalService;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.petra.sql.dsl.DSLQueryFactoryUtil;
import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.poi.ss.usermodel.Workbook;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
    immediate = true,
    property = {
        "com.liferay.portlet.display-category=category.hidden",
        "javax.portlet.display-name=Import Compensatory Data",
        "javax.portlet.init-param.template-path=/",
        "javax.portlet.init-param.view-template=/jsp/importcompensatory/view.jsp",
        "javax.portlet.name=ImportCompensatoryData",
        "javax.portlet.security-role-ref=administrator,power-user,user"
    },
    service = Portlet.class
)
public class ImportCompensatoryDataUtility extends MVCPortlet {

    private Log log = LogFactoryUtil.getLog(ImportCompensatoryDataUtility.class);

    @Reference
    AxHrmsCommonApi axHrmsCommonApi;
    
    @Reference
    LeaveCompensatoryStatusMasterLocalService leaveCompensatoryStatusMasterLocalService;
    
    @Reference
    EmployeeDetailsLocalService employeeDetailsLocalService;

    @Reference
    CompensatoryDataLocalService compensatoryDataLocalService;

    @Reference
    UserLocalService userLocalService;

    @Override
    public void render(RenderRequest renderRequest, RenderResponse renderResponse)
            throws IOException, PortletException {
        log.info("inside render");
        super.render(renderRequest, renderResponse);
    }

    @Override
    public void processAction(ActionRequest actionRequest, ActionResponse actionResponse)
            throws IOException, PortletException {

        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

        UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
        File compensatoryFile = uploadRequest.getFile("compensatoryFile");
        String fileName = uploadRequest.getFileName("compensatoryFile");
        Workbook workbook = axHrmsCommonApi.getWorkbook(fileName, compensatoryFile);
        long managerId = 0l;
        try {
			managerId = employeeDetailsLocalService.findByLrUserId(userLocalService.getUserByEmailAddress(themeDisplay.getCompanyId(), "connect@yopmail.com").getUserId()).getEmployeeId();;
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Map<String, Map<String, Object>> compensatoryDataMap = axHrmsCommonApi.readExcelSheetForImportEmployee(workbook.getSheetAt(0));
        log.info("Read compensatory data: " + compensatoryDataMap);

		for (Map.Entry<String, Map<String, Object>> entry : compensatoryDataMap.entrySet()) {
			String outerKey = entry.getKey();
			log.info("Processing entry with outerKey: " + outerKey);
			if ("0".equalsIgnoreCase(outerKey)) {
				log.info("Skipping header row");
				continue;
			}
			Map<String, Object> innerMap = entry.getValue();
			log.info("innerMap -- " + innerMap);
        	
        	//Parse fields from innerMap
			String employeeEmail = innerMap.get("2").toString().trim();
		    log.info("employeeEmail: " + employeeEmail);

		    String employeeName = innerMap.get("1").toString().trim();
		    log.info("employeeName: " + employeeName);

		    String description = innerMap.get("11").toString().trim();
		    log.info("description: " + description);

		    String dateOfComp = innerMap.get("3").toString().trim();
		    log.info("dateOfComp: " + dateOfComp);

		    String startTime = innerMap.get("4").toString().trim();
		    log.info("startTime: " + startTime);

		    String approvedStatus = innerMap.get("6").toString().trim();
		    log.info("approvedStatus: " + approvedStatus);
		    Float requestedHoursStr = Float.parseFloat(innerMap.get("8").toString().trim())*8;
		    log.info("requestedHoursStr: " + requestedHoursStr);
		    int requestedHours = requestedHoursStr.intValue();
			if ("Availed".equalsIgnoreCase(approvedStatus)) {
				approvedStatus = "Approved";
		    }
		    
		    
			SimpleDateFormat sdfc = new SimpleDateFormat("dd-MMM-yyyy");
			Date compensationDate = null;
			try {
				compensationDate = sdfc.parse(dateOfComp);
			} catch (ParseException e) {
				e.printStackTrace();
			}

			// Find employeeId using email or name
			String officialEmail = innerMap.get("2").toString().toLowerCase().trim();
			EmployeeDetailsTable employeeDetailsTable = EmployeeDetailsTable.INSTANCE;
	    	DSLQuery dslQuery = DSLQueryFactoryUtil.select(employeeDetailsTable).from(employeeDetailsTable).where(employeeDetailsTable.officialEmail.eq(officialEmail));
	    	
	    	List<EmployeeDetails> employeeList = employeeDetailsLocalService.dslQuery(dslQuery);

			if (Validator.isNotNull(employeeList) && !employeeList.isEmpty()) {
				log.info("Found employee with email " + officialEmail + ": " + employeeList.get(0));
				long employeeId = employeeList.get(0).getEmployeeId();
				long lrUserId = employeeList.get(0).getLrUserId();
				
				// Create and populate CompensatoryData
				CompensatoryData compensatoryData = compensatoryDataLocalService
						.createCompensatoryData(CounterLocalServiceUtil.increment(CompensatoryData.class.getName()));
				if("Approved".equalsIgnoreCase(approvedStatus) || "Availed".equalsIgnoreCase(approvedStatus)) {
					compensatoryData.setApprovedHours(requestedHours);
				}
				compensatoryData.setDateOfCompensation(compensationDate);
				compensatoryData.setEmployeeId(employeeId);
				compensatoryData.setRequestedHours(requestedHours);
				compensatoryData.setDescription(description);
				compensatoryData.setCompanyId(themeDisplay.getCompanyId());
				compensatoryData.setCreatedBy(lrUserId);
				compensatoryData.setModifiedBy(lrUserId);
				compensatoryData.setGroupId(themeDisplay.getCompanyGroupId());
				compensatoryData.setCreateDate(new Date());
				compensatoryData.setModifiedDate(new Date());
				compensatoryData.setManagerId(managerId);
				if (Validator.isNotNull(startTime) && !startTime.isEmpty()) {
					String[] timeParts = startTime.split("-");
					String startTimeStr = timeParts[0].trim();
					String endTimeStr = timeParts[1].trim();

					// Combine date and time into single strings for parsing
					String startDateTimeStr = dateOfComp + " " + startTimeStr;
					String endDateTimeStr = dateOfComp + " " + endTimeStr;
					// Define formatter
					SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy hh:mm a");
					
					// Parse to Date objects
					Date startDateTime;
					Date endDateTime;
					try {
						startDateTime = sdf.parse(startDateTimeStr);
						endDateTime = sdf.parse(endDateTimeStr);
						log.info("start datetime: " + startDateTime + ", end datetime: " + endDateTime);
						compensatoryData.setStartTime(startDateTime);
						compensatoryData.setEndTime(endDateTime);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				// Set status if needed
				try {
					compensatoryData.setLeaveCompensatoryStatusMasterId(leaveCompensatoryStatusMasterLocalService
							.findByLeaveCompensatoryStatusName(approvedStatus).getLeaveCompensatoryStatusMasterId());
				} catch (NoSuchLeaveCompensatoryStatusMasterException e) {
					e.printStackTrace();
				}
				
				// Save to DB
				compensatoryDataLocalService.addCompensatoryData(compensatoryData);
				log.info("compensatory data " + compensatoryData);
				//break;
			} else {
				log.warn("No employee found with email: " + officialEmail);
			}


			/*
			 * try { if (!"0".equalsIgnoreCase(outerKey) && Validator.isNotNull(innerMap)) {
			 * CompensatoryOff compensatoryOff =
			 * compensatoryOffLocalService.createCompensatoryOff(
			 * CounterLocalServiceUtil.increment(CompensatoryOff.class.getName()) );
			 * compensatoryOff.setCompanyId(themeDisplay.getCompanyId());
			 * compensatoryOff.setGroupId(themeDisplay.getCompanyGroupId());
			 * compensatoryOff.setCreateDate(new Date());
			 * compensatoryOff.setModifiedDate(new Date());
			 * compensatoryOff.setCreatedBy(themeDisplay.getUserId());
			 * compensatoryOff.setEmployeeCode(innerMap.get("1").toString().trim());
			 * compensatoryOff.setDateEarned(new Date()); // Parse from innerMap if
			 * available
			 * compensatoryOff.setNoOfDays(Double.parseDouble(innerMap.get("2").toString().
			 * trim())); compensatoryOff.setStatus(true);
			 * 
			 * compensatoryOffLocalService.addCompensatoryOff(compensatoryOff); } } catch
			 * (Exception e) { log.error("Error processing compensatory data: " +
			 * e.getMessage()); }
			 */
			
			
		}

        String redirect = ParamUtil.getString(actionRequest, "redirect");
        actionResponse.sendRedirect(redirect);
    }
}
