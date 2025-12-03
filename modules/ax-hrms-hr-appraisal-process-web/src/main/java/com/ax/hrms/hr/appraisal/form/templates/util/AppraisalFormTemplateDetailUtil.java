package com.ax.hrms.hr.appraisal.form.templates.util;

import com.ax.hrms.hr.appraisal.form.templates.dto.AppraisalFormTemplateDto;
import com.ax.hrms.master.model.TemplateLevelMaster;
import com.ax.hrms.master.service.TemplateLevelMasterLocalService;
import com.ax.hrms.model.AppraisalFormTemplates;
import com.liferay.document.library.kernel.service.DLFileEntryLocalService;
import com.liferay.portal.kernel.repository.model.FileEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * @author krish.moradiya
 * @implNote : Using this UTIL class, THis provide all the methods to get Appraisal Form Templates and Convert it in DTO Table to find all the Detail
 */
public class AppraisalFormTemplateDetailUtil {
    private static DLFileEntryLocalService dlFileEntryLocalService;
    private static TemplateLevelMasterLocalService templateLevelMasterLocalService;

    private AppraisalFormTemplateDetailUtil(){}
    public static void setLocalServices(DLFileEntryLocalService dlFileEntryLocalService,TemplateLevelMasterLocalService templateLevelMasterLocalService){
        AppraisalFormTemplateDetailUtil.dlFileEntryLocalService = dlFileEntryLocalService;
        AppraisalFormTemplateDetailUtil.templateLevelMasterLocalService = templateLevelMasterLocalService;
    }


    private static AppraisalFormTemplateDto appraisalFormTemplateDto = new AppraisalFormTemplateDto();
    public static AppraisalFormTemplateDto getAppraisalFormTemplateDetails(AppraisalFormTemplates appraisalFormTemplates, FileEntry fileEntry, TemplateLevelMaster templateLevelMaster){
        appraisalFormTemplateDto.setAppraisalFormTemplateId(appraisalFormTemplates.getAppraisalFormTemplateId());
        appraisalFormTemplateDto.setTemplateName(appraisalFormTemplates.getTemplateName());
        appraisalFormTemplateDto.setTemplateDocumentId(appraisalFormTemplates.getTemplateDocumentId());
        appraisalFormTemplateDto.setTemplateLevelId(appraisalFormTemplates.getTemplateLevelId());
        appraisalFormTemplateDto.setTemplateYear(appraisalFormTemplates.getTemplateYear());
        appraisalFormTemplateDto.setFileEntryId(appraisalFormTemplates.getTemplateDocumentId());
        appraisalFormTemplateDto.setFileName(fileEntry.getFileName());
        appraisalFormTemplateDto.setTemplateLevelName(templateLevelMaster.getLevelName());

        return appraisalFormTemplateDto;
    }

    public static List<AppraisalFormTemplateDto> getAppraisalFormTemplateList(List<AppraisalFormTemplates> appraisalFormTemplatesList){
        List<AppraisalFormTemplateDto> appraisalFormTemplateDtoList = new ArrayList<>();
        for(AppraisalFormTemplates appraisalFormTemplates : appraisalFormTemplatesList){
            appraisalFormTemplateDto = new AppraisalFormTemplateDto();
            appraisalFormTemplateDto.setAppraisalFormTemplateId(appraisalFormTemplates.getAppraisalFormTemplateId());
            appraisalFormTemplateDto.setTemplateName(appraisalFormTemplates.getTemplateName());
            appraisalFormTemplateDto.setTemplateDocumentId(appraisalFormTemplates.getTemplateDocumentId());
            appraisalFormTemplateDto.setTemplateLevelId(appraisalFormTemplates.getTemplateLevelId());
            appraisalFormTemplateDto.setTemplateYear(appraisalFormTemplates.getTemplateYear());
            appraisalFormTemplateDto.setFileEntryId(appraisalFormTemplates.getTemplateDocumentId());
            appraisalFormTemplateDto.setFileName(dlFileEntryLocalService.fetchDLFileEntry(appraisalFormTemplates.getTemplateDocumentId()).getFileName());
            appraisalFormTemplateDto.setTemplateLevelName(templateLevelMasterLocalService.fetchTemplateLevelMaster(appraisalFormTemplates.getTemplateLevelId()).getLevelName());

            appraisalFormTemplateDtoList.add(appraisalFormTemplateDto);
        }

        return appraisalFormTemplateDtoList;
    }
}
