package com.ax.hrms.anniversary.web.action;

import com.ax.hrms.anniversary.web.constants.AxHrmsAnniversaryWebPortletConstants;
import com.ax.hrms.anniversary.web.constants.AxHrmsAnniversaryWebPortletKeys;
import com.ax.hrms.common.api.api.AxHrmsCommonApi;
import com.ax.hrms.mail.template.config.configuration.MailTemplateConfiguration;
import com.ax.hrms.master.model.WishTypeMaster;
import com.ax.hrms.master.service.WishTypeMasterLocalService;
import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.model.EmployeeWish;
import com.ax.hrms.service.EmployeeDetailsLocalService;
import com.ax.hrms.service.EmployeeWishLocalService;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.*;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import java.util.Date;

/**
 * @author krish.moradiya
 * @implNote - This is Class which helps when Employee send wish to Anniversary employee that time this class send mail to employee whoose work anniversary
 */
@Component(immediate = true,
        property = {
            "javax.portlet.name=" + AxHrmsAnniversaryWebPortletKeys.AXHRMSANNIVERSARYWEB,
            "mvc.command.name=" + AxHrmsAnniversaryWebPortletConstants.SEND_ANNIVERSARY_WISH
        },
        service = MVCActionCommand.class
)
public class SendEmployeeAnniversaryWishesMVCActionCommand extends BaseMVCActionCommand {
    private static final Log log = LogFactoryUtil.getLog(SendEmployeeAnniversaryWishesMVCActionCommand.class);
    
    @Reference
    private MailTemplateConfiguration mailTemplateConfiguration;
    
    @Reference
    WishTypeMasterLocalService wishTypeMasterLocalService;

    @Reference
    EmployeeDetailsLocalService employeeDetailsLocalService;

    @Reference
    EmployeeWishLocalService employeeWishLocalService;

    @Reference
    AxHrmsCommonApi axHrmsCommonApi;

    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
        super.hideDefaultSuccessMessage(actionRequest);
        super.hideDefaultErrorMessage(actionRequest);
        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

        try {
            Long employeeId = ParamUtil.getLong(actionRequest, AxHrmsAnniversaryWebPortletConstants.EMPLOYEE_ID,GetterUtil.DEFAULT_LONG);

            String wishes = ParamUtil.getString(actionRequest, AxHrmsAnniversaryWebPortletConstants.WISHES_DATA,GetterUtil.DEFAULT_STRING);

            Long userId = themeDisplay.getUserId();

            String fromName = PrefsPropsUtil.getString(themeDisplay.getCompanyId(), PropsKeys.ADMIN_EMAIL_FROM_NAME);
            String fromEmailAddress = PrefsPropsUtil.getString(themeDisplay.getCompanyId(),
                    PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);

            EmployeeDetails anniversaryEmployeeDetails = employeeDetailsLocalService.getEmployeeDetails(employeeId);
            EmployeeDetails user = employeeDetailsLocalService.findByLrUserId(userId);

            if (Validator.isNotNull(wishes)) {

//                String subject = user.getFirstName() + AxHrmsAnniversaryWebPortletConstants.ONE_SPACE + user.getLastName() + AxHrmsAnniversaryWebPortletConstants.ANNIVERSARY_WISH_MAIL_SUBJECT_POSTFIX;
                
               String mailContent =  mailTemplateConfiguration.mailAnniversaryWishBody();
              mailContent =  mailContent.replace("${EMPLOYEE_NAME}", anniversaryEmployeeDetails.getFirstName()+StringPool.SPACE+anniversaryEmployeeDetails.getLastName());
              mailContent = mailContent.replace("${SENDER_NAME}", user.getFirstName()+StringPool.SPACE+user.getLastName());
              mailContent =  mailContent.replace("${WISH_BODY}", wishes);
               String subject = mailTemplateConfiguration.mailAnniversaryWishSubject();
                
                // send mail to birthday person
                axHrmsCommonApi.sendMail(anniversaryEmployeeDetails.getOfficialEmail(), fromEmailAddress, fromName, subject, mailContent);
                SessionMessages.add(actionRequest, AxHrmsAnniversaryWebPortletConstants.SEND_WISHES_SUCCESSFULLY_MESSAGE);

                // store the data
                setDataWish(wishes, employeeId, themeDisplay);
            }
        } catch (Exception e) {
            log.error("SendEmployeeAnniversaryWishesMVCActionCommand >>> doProcessAction ::: Exception is : " + e.getMessage());
            SessionErrors.add(actionRequest, AxHrmsAnniversaryWebPortletConstants.ERROR_MESSAGE_KEY);

        }
        actionResponse.sendRedirect(PortalUtil.getLayoutFullURL(themeDisplay));
    }
    private void setDataWish(String wishes, Long employeeId, ThemeDisplay themeDisplay) throws PortalException {
        EmployeeWish employeeWish = employeeWishLocalService
                .createEmployeeWish(CounterLocalServiceUtil.increment(EmployeeWish.class.getName()));

        EmployeeDetails senderEmployee = employeeDetailsLocalService.findByLrUserId(themeDisplay.getUserId());

        WishTypeMaster wishTypeMaster = wishTypeMasterLocalService
                .findByWishType(AxHrmsAnniversaryWebPortletConstants.ANNIVERSARY);

        // set audit field
        employeeWish.setCompanyId(themeDisplay.getCompanyId());
        employeeWish.setCreatedBy(themeDisplay.getUserId());
        employeeWish.setGroupId(themeDisplay.getScopeGroupId());
        employeeWish.setModifiedBy(themeDisplay.getUserId());

        // set wish field
        employeeWish.setSenderId(senderEmployee.getEmployeeId());
        employeeWish.setReceiverId(employeeId);
        employeeWish.setContent(wishes);
        employeeWish.setTimeStamp(new Date());
        employeeWish.setWishTypeMasterId(wishTypeMaster.getWishTypeMasterId());
        employeeWishLocalService.addEmployeeWish(employeeWish);
    }
}
