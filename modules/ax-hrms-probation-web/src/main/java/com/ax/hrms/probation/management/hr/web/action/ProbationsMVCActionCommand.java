package com.ax.hrms.probation.management.hr.web.action;

import com.ax.hrms.master.model.ProbationStatusMaster;
import com.ax.hrms.master.service.ProbationStatusMasterLocalService;
import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.model.EmployeeProbationDetails;
import com.ax.hrms.model.ExtendedProbationDetails;
import com.ax.hrms.probation.management.hr.web.constants.AxHrmsProbationHrWebConstants;
import com.ax.hrms.probation.management.hr.web.constants.AxHrmsProbationHrWebPortletKey;
import com.ax.hrms.service.EmployeeDetailsLocalService;
import com.ax.hrms.service.EmployeeProbationDetailsLocalService;
import com.ax.hrms.service.ExtendedProbationDetailsLocalService;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 * @author krish.moradiya
 */
@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + AxHrmsProbationHrWebPortletKey.AX_HRMS_PROBATION_HR_WEB_PORTLET_KEY,
                "mvc.command.name=/probationAction"
        },
        service = MVCActionCommand.class
)
public class ProbationsMVCActionCommand extends BaseMVCActionCommand {
    private static final Log log = LogFactoryUtil.getLog(ProbationsMVCActionCommand.class);

    @Reference
    EmployeeDetailsLocalService employeeDetailsLocalService;
    @Reference
    EmployeeProbationDetailsLocalService employeeProbationDetailsLocalService;
    @Reference
    ProbationStatusMasterLocalService probationStatusMasterLocalService;
    @Reference
    ExtendedProbationDetailsLocalService extendedProbationDetailsLocalService;


    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

        super.hideDefaultErrorMessage(actionRequest);
        super.hideDefaultSuccessMessage(actionRequest);

        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

        String actionType = ParamUtil.getString(actionRequest, AxHrmsProbationHrWebConstants.PROBATION_ACTION_TYPE, GetterUtil.DEFAULT_STRING);
        long employeeId = ParamUtil.getLong(actionRequest,AxHrmsProbationHrWebConstants.EMPLOYEE_ID,GetterUtil.DEFAULT_LONG);

        EmployeeDetails employeeDetails = employeeDetailsLocalService.fetchEmployeeDetails(employeeId);
        EmployeeProbationDetails employeeProbationDetails = employeeProbationDetailsLocalService.findByEmployeeId(employeeDetails.getEmployeeId());

        ProbationStatusMaster probationStatusMaster = probationStatusMasterLocalService.findByProbationStatusName(actionType);

        if(actionType.equals(AxHrmsProbationHrWebConstants.COMPLETED)){
            try{
                employeeDetails.setProbationStatusId(probationStatusMaster.getProbationStatusMasterId());
                employeeDetails.setModifiedBy(themeDisplay.getUserId());
                employeeDetailsLocalService.updateEmployeeDetails(employeeDetails);

                employeeProbationDetails.setProbationStatusId(probationStatusMaster.getProbationStatusMasterId());
                employeeProbationDetails.setModifiedBy(themeDisplay.getUserId());
                employeeProbationDetailsLocalService.updateEmployeeProbationDetails(employeeProbationDetails);
                SessionMessages.add(actionRequest,AxHrmsProbationHrWebConstants.PROBATION_CONFIRMED_SUCCESSFULLY_KEY);
            }catch(Exception exception){
                log.error("ProbationsMVCActionCommand >>> doProcessAction ::: Exception is: "+exception.getMessage());
            }

        }else if(actionType.equals(AxHrmsProbationHrWebConstants.TERMINATED)){
            try{
                employeeDetails.setProbationStatusId(probationStatusMaster.getProbationStatusMasterId());
                employeeDetails.setIsTerminated(true);
                employeeDetails.setModifiedBy(themeDisplay.getUserId());
                employeeDetailsLocalService.updateEmployeeDetails(employeeDetails);

                employeeProbationDetails.setProbationStatusId(probationStatusMaster.getProbationStatusMasterId());
                employeeProbationDetails.setModifiedBy(themeDisplay.getUserId());
                employeeProbationDetailsLocalService.updateEmployeeProbationDetails(employeeProbationDetails);
                SessionMessages.add(actionRequest,AxHrmsProbationHrWebConstants.PROBATION_TERMINATED_SUCCESSFULLY_KEY);
            }catch(Exception e){
                log.error("ProbationsMVCActionCommand >>> doProcessAction ::: Exception: "+e.getMessage());
            }

        }
        else if(actionType.equals(AxHrmsProbationHrWebConstants.EXTENDED)){
            try{
                employeeDetails.setProbationStatusId(probationStatusMaster.getProbationStatusMasterId());
                employeeDetails.setModifiedBy(themeDisplay.getUserId());
                employeeDetailsLocalService.updateEmployeeDetails(employeeDetails);

                int extendedProbationPeriod = ParamUtil.getInteger(actionRequest,AxHrmsProbationHrWebConstants.NO_OF_EXTEND_MONTH,GetterUtil.DEFAULT_INTEGER);
                String evalutionReview = ParamUtil.getString(actionRequest,AxHrmsProbationHrWebConstants.EVALUTION_REVIEW,GetterUtil.DEFAULT_STRING);

                LocalDate oldProbationEndDate = employeeProbationDetails.getProbationEndDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                LocalDate newProbationEndLocalDate = oldProbationEndDate.plusMonths(extendedProbationPeriod);
                Date newProbationEndDate = Date.from(newProbationEndLocalDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

                employeeProbationDetails.setProbationPeriod(employeeProbationDetails.getProbationPeriod()+extendedProbationPeriod);
                employeeProbationDetails.setProbationEndDate(newProbationEndDate);
                employeeProbationDetails.setProbationStatusId(probationStatusMaster.getProbationStatusMasterId());
                employeeProbationDetails.setIsExtended(true);
                employeeProbationDetailsLocalService.updateEmployeeProbationDetails(employeeProbationDetails);

                ExtendedProbationDetails extendedProbationDetails = extendedProbationDetailsLocalService.createExtendedProbationDetails(CounterLocalServiceUtil.increment(ExtendedProbationDetails.class.getName()));
                extendedProbationDetails.setCreatedBy(themeDisplay.getUserId());
                extendedProbationDetails.setModifiedBy(themeDisplay.getUserId());
                extendedProbationDetails.setCompanyId(themeDisplay.getCompanyId());
                extendedProbationDetails.setGroupId(themeDisplay.getScopeGroupId());

                extendedProbationDetails.setProbationDetailId(employeeProbationDetails.getProbationDetailId());
                extendedProbationDetails.setExtendDate(new Date());
                extendedProbationDetails.setEvalutionReview(evalutionReview);
                extendedProbationDetails.setExtendedProbationPeriod(extendedProbationPeriod);
                extendedProbationDetails.setExtendedProbationEndDate(newProbationEndDate);
                extendedProbationDetailsLocalService.addExtendedProbationDetails(extendedProbationDetails);

                SessionMessages.add(actionRequest,AxHrmsProbationHrWebConstants.PROBATION_EXTEND_SUCCESSFULLY_KEY);
            }catch(Exception e){
                log.error("ProbationsMVCActionCommand >>> doProcessAction ::: Exception: "+e.getMessage());
            }


        }else{
            log.info("ProbationsMVCActionCommand >>> doProcessAction ::: No one action called....Something went wrong");
        }
    }
}
