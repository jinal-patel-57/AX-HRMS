package com.ax.hrms.mail.template.config.configuration;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;

import java.util.Map;

@Component(
        configurationPid = "com.ax.hrms.mail.template.config.configuration.MailTemplateConfiguration",
        immediate = true,
        service = MailTemplateConfiguration.class
)
public class MailTemplateConfigurationImpl implements MailTemplateConfiguration {


    @Override
    public String mailOnBoardingPermanentAndTemporaryEmployeesSubject() {
        return _configuration.mailOnBoardingPermanentAndTemporaryEmployeesSubject();
    }

    @Override
    public String mailOnBoardingPermanentAndTemporaryEmployeesBody() {
        return _configuration.mailOnBoardingPermanentAndTemporaryEmployeesBody();
    }

    @Override
    public String appraisalMeetingScheduledSubject() {
        return _configuration.appraisalMeetingScheduledSubject();
    }

    @Override
    public String appraisalMeetingScheduledBody() {
        return _configuration.appraisalMeetingScheduledBody();
    }

    @Override
    public String appraisalMeetingUpdatedSubject() {
        return _configuration.appraisalMeetingUpdatedSubject();
    }

    @Override
    public String appraisalMeetingUpdatedBody() {
        return _configuration.appraisalMeetingUpdatedBody();
    }

    @Override
    public String appraisalMeetingInvitationCancellationSubject() {
        return _configuration.appraisalMeetingInvitationCancellationSubject();
    }

    @Override
    public String appraisalMeetingInvitationCancellationBody() {
        return _configuration.appraisalMeetingInvitationCancellationBody();
    }

    @Override
    public String managerEvaluationFormMailSubject() {
        return _configuration.managerEvaluationFormMailSubject();
    }

    @Override
    public String managerEvaluationFormMailBody() {
        return _configuration.managerEvaluationFormMailBody();
    }

    @Override
    public String peerEvaluationFormMailSubject() {
        return _configuration.peerEvaluationFormMailSubject();
    }

    @Override
    public String peerEvaluationFormMailBody() {
        return _configuration.peerEvaluationFormMailBody();
    }

    @Override
    public String selfEvaluationFormMailSubject() {
        return _configuration.selfEvaluationFormMailSubject();
    }

    @Override
    public String selfEvaluationFormMailBody() {
        return _configuration.selfEvaluationFormMailBody();
    }

    @Override
    public String pipProgramMailSubject() {
        return _configuration.pipProgramMailSubject();
    }

    @Override
    public String pipProgramMailBody() {
        return _configuration.pipProgramMailBody();
    }

    @Override
    public String mailOnBoardingInternAndContractorEmployeesSubject() {
        return _configuration.mailOnBoardingInternAndContractorEmployeesSubject();
    }

    @Override
    public String mailOnBoardingInternAndContractorEmployeesBody() {
        return _configuration.mailOnBoardingInternAndContractorEmployeesBody();
    }


    @Override
    public String appraisalDocumentSubject() {
        // TODO Auto-generated method stub
        return _configuration.appraisalDocumentSubject();
    }

    @Override
    public String appraisalDocumentBody() {
        // TODO Auto-generated method stub
        return _configuration.appraisalDocumentBody();
    }

    @Override
    public String mailHrForOnBoardingDetailsVerificationSubject() {
        return _configuration.mailHrForOnBoardingDetailsVerificationSubject();
    }

    @Override
    public String mailHrForOnBoardingDetailsVerificationBody() {
        return _configuration.mailHrForOnBoardingDetailsVerificationBody();
    }

    @Override
    public String reUploadOnboardingDetailsEmployeeMailSubject() {
        return _configuration.reUploadOnboardingDetailsEmployeeMailSubject();
    }

    @Override
    public String reUploadOnboardingDetailsEmployeeMailBody() {
        return _configuration.reUploadOnboardingDetailsEmployeeMailBody();
    }

    @Override
    public String onboardingVerificationSuccessEmailSubject() {
        return _configuration.onboardingVerificationSuccessEmailSubject();
    }

    @Override
    public String onboardingVerificationSuccessEmailBody() {
        return _configuration.onboardingVerificationSuccessEmailBody();
    }

    @Override
    public String employeeOffBoardingMailSubject() {
        return _configuration.employeeOffBoardingMailSubject();
    }

    @Override
    public String employeeOffBoardingMailBody() {
        return _configuration.employeeOffBoardingMailBody();
    }


    // below code need not be changed (strictly)
    @Activate
    @Modified
    protected void activate(Map<String, Object> properties) {
        _configuration = ConfigurableUtil.createConfigurable(
                MailTemplateConfiguration.class, properties);
    }

    private volatile MailTemplateConfiguration _configuration;

    @Override
    public String mailAnniversaryWishSubject() {
        // TODO Auto-generated method stub

        return _configuration.mailAnniversaryWishSubject();
    }

    @Override
    public String mailAnniversaryWishBody() {
        // TODO Auto-generated method stub
        return _configuration.mailAnniversaryWishBody();
    }

    @Override
    public String mailBirthdayWishSubject() {
        // TODO Auto-generated method stub
        return _configuration.mailBirthdayWishSubject();
    }

    @Override
    public String mailBirthdayWishBody() {
        // TODO Auto-generated method stub
        return _configuration.mailBirthdayWishBody();
    }

    @Override
    public String mailNewJoinerWishSubject() {
        // TODO Auto-generated method stub
        return _configuration.mailNewJoinerWishSubject();
    }

    @Override
    public String mailNewJoinerWishBody() {
        // TODO Auto-generated method stub
        return _configuration.mailNewJoinerWishBody();
    }

    @Override
    public String mailAssignProjectSubject() {
        // TODO Auto-generated method stub
        return _configuration.mailAssignProjectSubject();
    }

    @Override
    public String mailAssignProjectBody() {
        // TODO Auto-generated method stub
        return _configuration.mailAssignProjectBody();
    }

    @Override
    public String mailAssignTaskSubject() {
        // TODO Auto-generated method stub
        return _configuration.mailAssignTaskSubject();
    }

    @Override
    public String mailAssignTaskBody() {
        // TODO Auto-generated method stub
        return _configuration.mailAssignTaskBody();
    }

    @Override
    public String mailDailySchedulerBirthdaySubject() {
        // TODO Auto-generated method stub
        return _configuration.mailDailySchedulerBirthdaySubject();
    }

    @Override
    public String mailDailySchedulerAnniversarySubject() {
        // TODO Auto-generated method stub
        return _configuration.mailDailySchedulerAnniversarySubject();
    }


   

    @Override
    public String mailLeaveApproveEmployeeSubject() {
        // TODO Auto-generated method stub
        return _configuration.mailLeaveApproveEmployeeSubject();
    }

    @Override
    public String mailLeaveApproveEmployeeBody() {
        // TODO Auto-generated method stub
        return _configuration.mailLeaveApproveEmployeeBody();
    }

    @Override
    public String mailLeaveManagementTeamSubject() {
        // TODO Auto-generated method stub
        return _configuration.mailLeaveManagementTeamSubject();
    }

    @Override
    public String mailLeaveManagementTeamBody() {
        // TODO Auto-generated method stub
        return _configuration.mailLeaveManagementTeamBody();
    }

	@Override
	public String mailRemovalProjectSubject() {
		// TODO Auto-generated method stub
		return _configuration.mailRemovalProjectSubject();
	}

	@Override
	public String mailRemovalProjectBody() {
		// TODO Auto-generated method stub
		return _configuration.mailRemovalProjectBody();
	}

	@Override
	public String mailRemoveTaskSubject() {
		// TODO Auto-generated method stub
		return _configuration.mailRemoveTaskSubject();
	}

	@Override
	public String mailRemoveTaskBody() {
		// TODO Auto-generated method stub
		return _configuration.mailRemoveTaskBody();
	}

	@Override
	public String mailLeaveRejectEmployeeSubject() {
		// TODO Auto-generated method stub
		return _configuration.mailLeaveRejectEmployeeSubject();
	}

	@Override
	public String mailLeaveRejectEmployeeBody() {
		// TODO Auto-generated method stub
		return _configuration.mailLeaveRejectEmployeeBody();
	}

	@Override
	public String mailLeaveCancelEmployeeSubject() {
		// TODO Auto-generated method stub
		return _configuration.mailLeaveCancelEmployeeSubject();
	}

	@Override
	public String mailLeaveCancelEmployeeBody() {
		// TODO Auto-generated method stub
		return _configuration.mailLeaveCancelEmployeeBody();
	}

	@Override
	public String mailDailySchedulerBirthdayBody() {
		// TODO Auto-generated method stub
		return _configuration.mailDailySchedulerBirthdayBody();
	}

	@Override
	public String mailDailySchedulerAnniversaryBody() {
		// TODO Auto-generated method stub
		return _configuration.mailDailySchedulerAnniversaryBody();
	}

}
