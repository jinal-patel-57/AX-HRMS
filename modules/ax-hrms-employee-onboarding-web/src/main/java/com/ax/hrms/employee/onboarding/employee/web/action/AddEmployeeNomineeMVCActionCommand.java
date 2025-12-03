package com.ax.hrms.employee.onboarding.employee.web.action;

import com.ax.hrms.common.api.api.AxHrmsCommonApi;
import com.ax.hrms.employee.onboarding.employee.web.util.EmployeeOnBoardingUtil;
import com.ax.hrms.employee.onboarding.web.constants.AxHrmsEmployeeOnBoardingEmployeeConstants;
import com.ax.hrms.employee.onboarding.web.constants.AxHrmsEmployeeOnboardingWebPortletKeys;
import com.ax.hrms.mail.template.config.configuration.MailTemplateConfiguration;
import com.ax.hrms.model.Address;
import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.model.Nominee;
import com.ax.hrms.service.AddressLocalService;
import com.ax.hrms.service.EmployeeAddressLocalService;
import com.ax.hrms.service.EmployeeDetailsLocalService;
import com.ax.hrms.service.NomineeLocalService;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = {
        "javax.portlet.name=" + AxHrmsEmployeeOnboardingWebPortletKeys.AX_HRMS_EMPLOYEE_ONBOARDING_EMPLOYEE_WEB,
        "mvc.command.name=/addEditEmployeeNomineeURL"}, service = MVCActionCommand.class)
public class AddEmployeeNomineeMVCActionCommand extends BaseMVCActionCommand {

    private Log log = LogFactoryUtil.getLog(AddEmployeeNomineeMVCActionCommand.class);

    @Reference
    NomineeLocalService nomineeLocalService;

    @Reference
    MailTemplateConfiguration mailTemplateConfiguration;
    @Reference
    EmployeeAddressLocalService employeeAddressLocalService;

    @Reference
    AddressLocalService addressLocalService;

    @Reference
    EmployeeDetailsLocalService employeeDetailsLocalService;

    @Reference
    AxHrmsCommonApi axHrmsCommonApi;

    private long addressId = 0;
    private long nomineeId = 0;

    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

        log.info("AddEmployeeNomineeMVCActionCommand >>> doProcessAction ::: Action Called ::: ");
        String flag = ParamUtil.getString(actionRequest, AxHrmsEmployeeOnBoardingEmployeeConstants.UPDATE_FLAG_NOMINEE);

        String nomineeFirstName = ParamUtil.getString(actionRequest, AxHrmsEmployeeOnBoardingEmployeeConstants.NOMINEE_FIRST_NAME);
        String nomineeLastName = ParamUtil.getString(actionRequest, AxHrmsEmployeeOnBoardingEmployeeConstants.NOMINEE_LAST_NAME);
        String nomineeContact = ParamUtil.getString(actionRequest, AxHrmsEmployeeOnBoardingEmployeeConstants.NOMINEE_CONTACT);
        String relationshipWithNominee = ParamUtil.getString(actionRequest, AxHrmsEmployeeOnBoardingEmployeeConstants.RELATIONSHIP_WITH_NOMINEE);
        String nomineeDob = ParamUtil.getString(actionRequest, AxHrmsEmployeeOnBoardingEmployeeConstants.NOMINEE_JOB);

        String presentAddressLine1 = ParamUtil.getString(actionRequest, AxHrmsEmployeeOnBoardingEmployeeConstants.PRESENT_ADDRESS_LINE1);
        String presentAddressLine2 = ParamUtil.getString(actionRequest, AxHrmsEmployeeOnBoardingEmployeeConstants.PRESENT_ADDRESS_LINE2);
        String presentAddressLine3 = ParamUtil.getString(actionRequest, AxHrmsEmployeeOnBoardingEmployeeConstants.PRESENT_ADDRESS_LINE3);
        String presentState = ParamUtil.getString(actionRequest, AxHrmsEmployeeOnBoardingEmployeeConstants.PRESENT_STATE);
        long presentCountry = ParamUtil.getLong(actionRequest, AxHrmsEmployeeOnBoardingEmployeeConstants.PRESENT_COUNTRY);
        String presentPincode = ParamUtil.getString(actionRequest, AxHrmsEmployeeOnBoardingEmployeeConstants.PRESENT_PINCODE);

        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

        if (flag.equals(AxHrmsEmployeeOnBoardingEmployeeConstants.FALSE)) {
            try {

                Nominee nominee = nomineeLocalService.createNominee(CounterLocalServiceUtil.increment(Nominee.class.getName()));
                nominee.setCompanyId(themeDisplay.getCompanyId());
                nominee.setGroupId(themeDisplay.getScopeGroupId());
                nominee.setCreatedBy(themeDisplay.getUserId());
                nominee.setModifiedBy(themeDisplay.getUserId());

                SimpleDateFormat formatter = new SimpleDateFormat(AxHrmsEmployeeOnBoardingEmployeeConstants.DATE_FORMAT, Locale.ENGLISH);
                Date nomineeDateOfBirth = formatter.parse(nomineeDob);

                nominee.setNomineeFirstName(nomineeFirstName);
                nominee.setNomineeLastName(nomineeLastName);
                nominee.setNomineeContact(nomineeContact);

                Address address = addressLocalService.createAddress(CounterLocalServiceUtil.increment(Address.class.getName()));
                address.setCompanyId(themeDisplay.getCompanyId());
                address.setGroupId(themeDisplay.getScopeGroupId());
                address.setCreatedBy(themeDisplay.getUserId());
                address.setModifiedBy(themeDisplay.getUserId());
                address.setLine1(presentAddressLine1);
                address.setLine2(presentAddressLine2);
                address.setLine3(presentAddressLine3);
                address.setState(presentState);

                addressId = address.getAddressId();
                nomineeId = nominee.getNomineeId();
                address.setCountry(presentCountry);
                address.setPincode(presentPincode);
                addressLocalService.addAddress(address);

                nominee.setNomineeAddress(address.getAddressId());
                nominee.setRelationshipWithNominee(relationshipWithNominee);
                nominee.setNomineeDob(nomineeDateOfBirth);

                EmployeeDetails employeeDetails = employeeDetailsLocalService.findByLrUserId(themeDisplay.getUserId());
                employeeDetails.setNominneeId(nominee.getNomineeId());
                employeeDetailsLocalService.updateEmployeeDetails(employeeDetails);
                nomineeLocalService.addNominee(nominee);
            } catch (Exception e) {
                log.error("error in catch ==>" + e.getMessage());
            }
        } else {

            Nominee nominee = nomineeLocalService.getNominee(nomineeId);
            nominee.setCompanyId(themeDisplay.getCompanyId());
            nominee.setGroupId(themeDisplay.getScopeGroupId());
            nominee.setCreatedBy(themeDisplay.getUserId());
            nominee.setModifiedBy(themeDisplay.getUserId());
            SimpleDateFormat formatter = new SimpleDateFormat(AxHrmsEmployeeOnBoardingEmployeeConstants.DATE_FORMAT, Locale.ENGLISH);
            Date nomineeDateOfBirth = formatter.parse(nomineeDob);

            nominee.setNomineeFirstName(nomineeFirstName);
            nominee.setNomineeLastName(nomineeLastName);
            nominee.setNomineeContact(nomineeContact);

            Address address = addressLocalService.getAddress(addressId);
            address.setCompanyId(themeDisplay.getCompanyId());
            address.setGroupId(themeDisplay.getScopeGroupId());
            address.setCreatedBy(themeDisplay.getUserId());
            address.setModifiedBy(themeDisplay.getUserId());
            address.setLine1(presentAddressLine1);
            address.setLine2(presentAddressLine2);
            address.setLine3(presentAddressLine3);
            address.setState(presentState);
            address.setCountry(presentCountry);
            address.setPincode(presentPincode);
            addressLocalService.updateAddress(address);

            nominee.setNomineeAddress(address.getAddressId());
            nominee.setRelationshipWithNominee(relationshipWithNominee);
            nominee.setNomineeDob(nomineeDateOfBirth);

            nomineeLocalService.updateNominee(nominee);

            log.info("AddEmployeeNomineeMVCActionCommand >>> doProcessAction ::: update called :::");
        }

        EmployeeDetails employee = employeeDetailsLocalService.findByLrUserId(themeDisplay.getUserId());
        employee.setIsEmployeeOnboarded(true);
        employeeDetailsLocalService.updateEmployeeDetails(employee);
        String subject = AxHrmsEmployeeOnBoardingEmployeeConstants.EMPLOYEE_ONBOARDING_VERIFICATION;


        EmployeeOnBoardingUtil employeeUtil = new EmployeeOnBoardingUtil(employeeDetailsLocalService, axHrmsCommonApi, employeeAddressLocalService, null, addressLocalService, nomineeLocalService,mailTemplateConfiguration);

        employeeUtil.sendMailToHr(employee.getEmployeeId(), themeDisplay, actionRequest, AxHrmsEmployeeOnBoardingEmployeeConstants.SHOW_EMPLOYEE_ONBOARDING_URL);

        log.info("Send mail to HR ");

        String name = AxHrmsEmployeeOnBoardingEmployeeConstants.VERIFY_DOCUMENTS + employee.getFirstName() + AxHrmsEmployeeOnBoardingEmployeeConstants.SPACE + employee.getLastName();

        employeeUtil.sendNotificationToHR(name, employee.getCompanyId());

        log.info("sent notificiation");
    }
}
