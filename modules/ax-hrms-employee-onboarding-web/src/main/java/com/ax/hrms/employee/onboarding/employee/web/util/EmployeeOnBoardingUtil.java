package com.ax.hrms.employee.onboarding.employee.web.util;

import com.ax.hrms.common.api.api.AxHrmsCommonApi;
import com.ax.hrms.employee.onboarding.employee.web.notification.SendNotificationToUserHandler;
import com.ax.hrms.employee.onboarding.web.constants.AxHrmsEmployeeOnBoardingEmployeeConstants;
import com.ax.hrms.employee.onboarding.web.constants.AxHrmsEmployeeOnboardingWebPortletKeys;
import com.ax.hrms.exception.NoSuchEmployeeDetailsException;
import com.ax.hrms.mail.template.config.configuration.MailTemplateConfiguration;
import com.ax.hrms.model.Address;
import com.ax.hrms.model.EmployeeAddress;
import com.ax.hrms.model.EmployeeBankAccount;
import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.model.EmployeeEducation;
import com.ax.hrms.model.EmployeeExperience;
import com.ax.hrms.model.EmployeeUanEsic;
import com.ax.hrms.model.Nominee;
import com.ax.hrms.service.AddressLocalService;
import com.ax.hrms.service.EmployeeAddressLocalService;
import com.ax.hrms.service.EmployeeBankAccountLocalService;
import com.ax.hrms.service.EmployeeDetailsLocalService;
import com.ax.hrms.service.EmployeeEducationLocalService;
import com.ax.hrms.service.EmployeeExperienceLocalService;
import com.ax.hrms.service.EmployeeUanEsicLocalService;
import com.ax.hrms.service.NomineeLocalService;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserNotificationDeliveryConstants;
import com.liferay.portal.kernel.model.UserNotificationEvent;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserNotificationEventLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Reference;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;

public class EmployeeOnBoardingUtil {

    private static Log log = LogFactoryUtil.getLog(EmployeeOnBoardingUtil.class);


    private MailTemplateConfiguration mailTemplateConfiguration;

    private EmployeeDetailsLocalService employeeDetailsLocalService;

    private AxHrmsCommonApi axHrmsCommonApi;

    private EmployeeAddressLocalService employeeAddressLocalService;

    private EmployeeBankAccountLocalService employeeBankAccountLocalService;

    private AddressLocalService addressLocalService;

    private NomineeLocalService nomineeLocalService;

    public EmployeeOnBoardingUtil(EmployeeDetailsLocalService employeeDetailsLocalService,
                                  AxHrmsCommonApi axHrmsCommonApi,
                                  EmployeeAddressLocalService employeeAddressLocalService,
                                  EmployeeBankAccountLocalService employeeBankAccountLocalService,
                                  AddressLocalService addressLocalService,
                                  NomineeLocalService nomineeLocalService,
                                  MailTemplateConfiguration mailTemplateConfiguration) {
        super();
        this.employeeDetailsLocalService = employeeDetailsLocalService;
        this.axHrmsCommonApi = axHrmsCommonApi;
        this.employeeAddressLocalService = employeeAddressLocalService;
        this.employeeBankAccountLocalService = employeeBankAccountLocalService;
        this.addressLocalService = addressLocalService;
        this.nomineeLocalService = nomineeLocalService;
        this.mailTemplateConfiguration = mailTemplateConfiguration;
    }

    public void sendNotification(long userId, String notificationTitle) throws Exception {

        JSONObject notificationJSON = JSONFactoryUtil.createJSONObject();

        notificationJSON.put(AxHrmsEmployeeOnBoardingEmployeeConstants.BODY, notificationTitle);

        UserNotificationEvent userNotificationEvent = UserNotificationEventLocalServiceUtil.sendUserNotificationEvents(userId, AxHrmsEmployeeOnboardingWebPortletKeys.AX_HRMS_EMPLOYEE_ONBOARDING_EMPLOYEE_WEB, UserNotificationDeliveryConstants.TYPE_WEBSITE, notificationJSON);

        ServiceContext serviceContext = new ServiceContext();

        SendNotificationToUserHandler sendNotificationToUserHandler = new SendNotificationToUserHandler();

        sendNotificationToUserHandler.callGetBody(userNotificationEvent, serviceContext);
    }

    public void sendNotificationToHR(String notificationTitle, long companyId) throws Exception {
        List<User> hrUserList = axHrmsCommonApi.fetchHrAdminList(companyId);
        for (User hrUser : hrUserList) {
            sendNotification(hrUser.getUserId(), notificationTitle);
        }
    }

    public void sendMailToHr(long employeeId, ThemeDisplay themeDisplay, ActionRequest actionRequest,
                             String commandName) throws PortalException {
        String fromName = PrefsPropsUtil.getString(themeDisplay.getCompanyId(), PropsKeys.ADMIN_EMAIL_FROM_NAME);
        String fromEmailAddress = PrefsPropsUtil.getString(themeDisplay.getCompanyId(), PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);
        String subject = mailTemplateConfiguration.mailHrForOnBoardingDetailsVerificationSubject();
        String body = mailTemplateConfiguration.mailHrForOnBoardingDetailsVerificationBody();
        EmployeeDetails employeeDetails = employeeDetailsLocalService.getEmployeeDetails(employeeId);
        body = body.replace("${EMPLOYEE_NAME}", employeeDetails.getFirstName() + " " + employeeDetails.getLastName());
        body = body.replace("${VERIFICATION_LINK}", generateLink(actionRequest, employeeId, commandName));

        List<User> hrList = axHrmsCommonApi.fetchHrAdminList(themeDisplay.getCompanyId());

        EmployeeDetails hrPerson;
        for (User user : hrList) {
            hrPerson = employeeDetailsLocalService.findByLrUserId(user.getUserId());
            axHrmsCommonApi.sendMail(hrPerson.getOfficialEmail(), fromEmailAddress, fromName, subject, body);
        }
    }

    public String generateLink(ActionRequest actionRequest, long employeeId, String commandName) {

        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        Layout plId = themeDisplay.getLayout();
        PortletURL programListRenderUrl = PortletURLFactoryUtil.getPortletURLFactory().create(actionRequest, AxHrmsEmployeeOnboardingWebPortletKeys.AX_HRMS_EMPLOYEE_ONBOARDING_EMPLOYEE_WEB, plId, PortletRequest.RENDER_PHASE);
        String[] p_p_state = {AxHrmsEmployeeOnBoardingEmployeeConstants.NORMAL};
        programListRenderUrl.getParameterMap().put(AxHrmsEmployeeOnBoardingEmployeeConstants.P_P_STATE, p_p_state);
        String[] view = {AxHrmsEmployeeOnBoardingEmployeeConstants.VIEW};
        programListRenderUrl.getParameterMap().put(AxHrmsEmployeeOnBoardingEmployeeConstants.P_P_MODE, view);
        String[] mvcRenderCommandName = {commandName};
        programListRenderUrl.getParameterMap().put(AxHrmsEmployeeOnBoardingEmployeeConstants.MVC_RENDER_COMMAND_NAME, mvcRenderCommandName);
        String[] employeeIdParam = {String.valueOf(employeeId)};
        programListRenderUrl.getParameterMap().put(AxHrmsEmployeeOnBoardingEmployeeConstants.EMPLOYEE_ID, employeeIdParam);

        return programListRenderUrl.toString();
    }

    public void sendMailToEmployee(long employeeId, ThemeDisplay themeDisplay, ActionRequest actionRequest,
                                   String commandName, String review) throws PortalException {
        String fromName = PrefsPropsUtil.getString(themeDisplay.getCompanyId(), PropsKeys.ADMIN_EMAIL_FROM_NAME);
        String fromEmailAddress = PrefsPropsUtil.getString(themeDisplay.getCompanyId(), PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);
        String body = mailTemplateConfiguration.reUploadOnboardingDetailsEmployeeMailBody();
        String subject = mailTemplateConfiguration.reUploadOnboardingDetailsEmployeeMailSubject();
        EmployeeDetails employee = employeeDetailsLocalService.getEmployeeDetails(employeeId);


        body = body.replace("${COMMENTS}",review);
        body = body.replace("${EMPLOYEE_NAME}",employee.getFirstName() + " " + employee.getLastName());

        if (commandName != null) {
            log.info("EmployeeOnBoardingUtil >>> sendMailToEmployee ::: commandName " + commandName);
            body = body.replace("${RE_UPLOAD_LINK}",generateLink(actionRequest, employeeId, commandName));

            axHrmsCommonApi.sendMail(employee.getOfficialEmail(), fromEmailAddress, fromName, subject, body);
        } else {
            axHrmsCommonApi.sendMail(employee.getOfficialEmail(), fromEmailAddress, fromName, subject, "");
        }

    }

    public void sendMailToEmployeeApproved(long employeeId, ThemeDisplay themeDisplay, ActionRequest actionRequest,
                                           String commandName) throws PortalException {
        String fromName = PrefsPropsUtil.getString(themeDisplay.getCompanyId(), PropsKeys.ADMIN_EMAIL_FROM_NAME);
        String fromEmailAddress = PrefsPropsUtil.getString(themeDisplay.getCompanyId(), PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);
        String body = mailTemplateConfiguration.onboardingVerificationSuccessEmailBody();
        String subject = mailTemplateConfiguration.onboardingVerificationSuccessEmailSubject();
        EmployeeDetails employee = employeeDetailsLocalService.getEmployeeDetails(employeeId);
        body = body.replace("${EMPLOYEE_NAME}" , employee.getFirstName() + " " + employee.getLastName());

        if (commandName != null) {
            log.info("EmployeeOnBoardingUtil >>> sendMailToEmployee ::: commandName " + commandName);
            axHrmsCommonApi.sendMail(employee.getOfficialEmail(), fromEmailAddress, fromName, subject, body);
        } else {
            axHrmsCommonApi.sendMail(employee.getOfficialEmail(), fromEmailAddress, fromName, subject, "");
        }

    }

    public void setEmployeeDetails(RenderRequest renderRequest, Long employeeId) {
        try {
            log.info("EmployeeOnBoardingUtil >>> setEmployeeDetails ::: employee details called In Util");
            EmployeeDetails employeeDetails = employeeDetailsLocalService.getEmployeeDetails(employeeId);

            long profilePicId = employeeDetails.getProfilePicId();

            if (profilePicId > 0) {
                FileEntry profilePicPathName = DLAppLocalServiceUtil.getFileEntry(profilePicId);
                String profilePicName = profilePicPathName.getFileName();
                renderRequest.setAttribute(AxHrmsEmployeeOnBoardingEmployeeConstants.PROFILE_PIC_NAME, profilePicName);
            }
            log.info("EmployeeOnBoardingUtil >>> setEmployeeDetails ::: Retrieved employeeDetails: " + employeeDetails);
            renderRequest.setAttribute(AxHrmsEmployeeOnBoardingEmployeeConstants.EMPLOYEE_DETAIL, employeeDetails);
        } catch (PortalException e) {
            e.printStackTrace();
        }
    }

    public void setAddress(RenderRequest renderRequest, Long employeeId) {
        try {
            long employeeAddressId = employeeDetailsLocalService.getEmployeeDetails(employeeId).getEmployeeAddressId();
            log.info("EmployeeOnBoardingUtil >>> setAddress ::: employeeAddressId ======>>>>>" + employeeAddressId);
            EmployeeAddress employeeAddress = employeeAddressLocalService.getEmployeeAddress(employeeAddressId);
            log.info("EmployeeOnBoardingUtil >>> setAddress :::employeeAddressss >>>>>>>>>>>>. " + employeeAddress);
            renderRequest.setAttribute(AxHrmsEmployeeOnBoardingEmployeeConstants.EMPLOYEE_ADDRESS, employeeAddress);
            if (employeeAddressId > 0) {
                renderRequest.setAttribute(AxHrmsEmployeeOnBoardingEmployeeConstants.ADDRESS_FLAG_STATUS, AxHrmsEmployeeOnBoardingEmployeeConstants.TRUE);
            }
            if (employeeAddress.getPresentPermanentSame()) {
                Address presentaddresss = addressLocalService.getAddress(employeeAddress.getPresentAddress());
                Address permanentaddresss = addressLocalService.getAddress(employeeAddress.getPermanentAddress());
                log.info("presentaddresss ===>" + presentaddresss);
                log.info("permanentaddresss ===>" + permanentaddresss);
                renderRequest.setAttribute(AxHrmsEmployeeOnBoardingEmployeeConstants.PRESENT_ADDRESS, presentaddresss);
                renderRequest.setAttribute(AxHrmsEmployeeOnBoardingEmployeeConstants.PERMANENT_ADDRESS, permanentaddresss);
            } else {
                Address presentaddresss = addressLocalService.getAddress(employeeAddress.getPresentAddress());
                Address permanentaddresss = addressLocalService.getAddress(employeeAddress.getPermanentAddress());

                log.info("presentaddresss ===>" + presentaddresss);
                log.info("permanentaddresss ===>" + permanentaddresss);
                renderRequest.setAttribute(AxHrmsEmployeeOnBoardingEmployeeConstants.PERMANENT_ADDRESS, permanentaddresss);
                renderRequest.setAttribute(AxHrmsEmployeeOnBoardingEmployeeConstants.PRESENT_ADDRESS, presentaddresss);
            }


        } catch (PortalException e) {
            log.error("Error retrieving employeeAddress: " + e.getMessage());
        }
    }

    public void setNominee(RenderRequest renderRequest, Long employeeId) {
        try {
            log.info("EmployeeOnBoardingUtil >> setNominee ::: nominee details called");
            long nomineeId = employeeDetailsLocalService.getEmployeeDetails(employeeId).getNominneeId();
            Nominee nominee = nomineeLocalService.getNominee(nomineeId);
            Address address = addressLocalService.getAddress(nominee.getNomineeAddress());
            renderRequest.setAttribute(AxHrmsEmployeeOnBoardingEmployeeConstants.ADDRESS, address);
            renderRequest.setAttribute(AxHrmsEmployeeOnBoardingEmployeeConstants.NOMINEE, nominee);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    public void setEducationList(RenderRequest renderRequest, Long employeeId, EmployeeEducationLocalService employeeEducationLocalService) {
        List<EmployeeEducation> educationList = employeeEducationLocalService.findByEmployeeId(employeeId);

        log.info("EmployeeOnBoardingUtil >>> setEducationList ::: educationLis => " + educationList);
        renderRequest.setAttribute(AxHrmsEmployeeOnBoardingEmployeeConstants.EDUCATION_LIST, educationList);
        renderRequest.setAttribute(AxHrmsEmployeeOnBoardingEmployeeConstants.EDUCATION_LIST_SIZE, educationList.size());
    }

    public void setExperience(RenderRequest renderRequest, Long employeeId, EmployeeExperienceLocalService employeeExperienceLocalService) {
        try {
            List<EmployeeExperience> experienceList = employeeExperienceLocalService.findByEmployeeId(employeeId);
            renderRequest.setAttribute(AxHrmsEmployeeOnBoardingEmployeeConstants.EXPERIENCE_LIST, experienceList);
            renderRequest.setAttribute(AxHrmsEmployeeOnBoardingEmployeeConstants.EXPERIENCE_LIST_SIZE, experienceList.size());
        } catch (Exception e) {
            log.error("Catched Exception" + e.getMessage());
        }
    }

    public void setUanEsic(RenderRequest renderRequest, Long employeeId, EmployeeUanEsicLocalService employeeUanEsicLocalService) {
        try {
            long employeeUanEsicIdd = employeeDetailsLocalService.getEmployeeDetails(employeeId).getUanEsicId();
            EmployeeUanEsic employeeUanEsic = employeeUanEsicLocalService.getEmployeeUanEsic(employeeUanEsicIdd);
            log.info("EmployeeOnBoardingUtil >>> setUanEsic ::: Retrieved EmployeeUanEsic: " + employeeUanEsic);

            if (employeeUanEsicIdd > 0) {
                renderRequest.setAttribute(AxHrmsEmployeeOnBoardingEmployeeConstants.FLAG_STATUS, AxHrmsEmployeeOnBoardingEmployeeConstants.TRUE);
            }
            renderRequest.setAttribute(AxHrmsEmployeeOnBoardingEmployeeConstants.EMPLOYEE_UAN_ESIC, employeeUanEsic);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    public void setBankAccount(RenderRequest renderRequest, Long employeeId) {
        try {
            long bankAccountId = employeeDetailsLocalService.getEmployeeDetails(employeeId).getBankAccountId();
            EmployeeBankAccount employeeBankAccount = employeeBankAccountLocalService.getEmployeeBankAccount(bankAccountId);
            log.info("EmployeeOnBoardingUtil >>> setBankAccount :::Retrieved employeeBankAccount: " + employeeBankAccount);

            if (bankAccountId > 0) {
                log.info("bankAccount details" + bankAccountId);
                renderRequest.setAttribute(AxHrmsEmployeeOnBoardingEmployeeConstants.FLAG_STATUSS, AxHrmsEmployeeOnBoardingEmployeeConstants.TRUE);
            }
            renderRequest.setAttribute(AxHrmsEmployeeOnBoardingEmployeeConstants.EMPLOYEE_BANK_ACCOUNT, employeeBankAccount);
        } catch (PortalException e) {
            log.error("Error retrieving employeeBankAccount: " + e.getMessage());
        }
    }

    static List<Long> educationIds = new ArrayList<>();

    public static void handleEducationIds(long educationId) {
        educationIds.add(educationId);
        log.info("List Of EducationIDsh" + educationIds.toString());
    }

    public static void deleteEducationIds(long educationId) {
        educationIds.remove(educationId);
        log.info("List Of EducationIDsd" + educationIds.toString());
    }

    public static List<Long> educationIds() {
        return educationIds;
    }

    static List<Long> experienceIds = new ArrayList<>();


    public static void handleExperienceIds(long experienceId) {
        experienceIds.add(experienceId);
        log.info("List Of EducationIDsh" + educationIds.toString());
    }

    public static void deleteExperienceIds(long experienceId) {
        experienceIds.remove(experienceId);
        log.info("List Of EducationIDsd" + educationIds.toString());
    }

    public static List<Long> experienceIds() {
        return experienceIds;
    }
}
