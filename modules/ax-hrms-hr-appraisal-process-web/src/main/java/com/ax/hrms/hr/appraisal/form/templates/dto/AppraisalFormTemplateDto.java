package com.ax.hrms.hr.appraisal.form.templates.dto;

/**
 * @author krish.moradiya
 */
public class AppraisalFormTemplateDto {

    long appraisalFormTemplateId;
    long templateDocumentId;
    String fileName;
    String templateLevelName;
    long templateLevelId;
    String templateName;
    String templateYear;
    long fileEntryId;

    public long getAppraisalFormTemplateId() {
        return appraisalFormTemplateId;
    }

    public void setAppraisalFormTemplateId(long appraisalFormTemplateId) {
        this.appraisalFormTemplateId = appraisalFormTemplateId;
    }

    public long getTemplateDocumentId() {
        return templateDocumentId;
    }

    public void setTemplateDocumentId(long templateDocumentId) {
        this.templateDocumentId = templateDocumentId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getTemplateLevelName() {
        return templateLevelName;
    }

    public void setTemplateLevelName(String templateLevelName) {
        this.templateLevelName = templateLevelName;
    }

    public long getTemplateLevelId() {
        return templateLevelId;
    }

    public void setTemplateLevelId(long templateLevelId) {
        this.templateLevelId = templateLevelId;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public String getTemplateYear() {
        return templateYear;
    }

    public void setTemplateYear(String templateYear) {
        this.templateYear = templateYear;
    }

    public long getFileEntryId() {
        return fileEntryId;
    }

    public void setFileEntryId(long fileEntryId) {
        this.fileEntryId = fileEntryId;
    }
}
