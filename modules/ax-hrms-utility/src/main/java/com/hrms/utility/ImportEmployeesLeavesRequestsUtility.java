package com.hrms.utility;

import com.ax.hrms.common.api.api.AxHrmsCommonApi;
import com.ax.hrms.master.service.LeaveCompensatoryStatusMasterLocalService;
import com.ax.hrms.master.service.LeaveTypeMasterLocalService;
import com.ax.hrms.model.*;
import com.ax.hrms.service.CommentLocalService;
import com.ax.hrms.service.EmployeeDetailsLocalService;
import com.ax.hrms.service.LeaveDayTypeLocalService;
import com.ax.hrms.service.LeaveRequestLocalService;
import com.hrms.utility.constants.AxHrmsUtilityConstants;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.petra.sql.dsl.DSLQueryFactoryUtil;
import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.*;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Component(
        immediate = true,
        property = {
                "com.liferay.portlet.display-category=category.hidden",
                "com.liferay.portlet.header-portlet-css=/css/main.css",
                "com.liferay.portlet.instanceable=false",
                "javax.portlet.display-name=Import Employee Leaves Requests Utility",
                "javax.portlet.init-param.template-path=/",
                "javax.portlet.init-param.view-template=/jsp/importemployeeleavesrequests/view.jsp",
                "javax.portlet.name=ImportEmployeeLeavesRequests",
                "javax.portlet.resource-bundle=content.Language",
                "javax.portlet.security-role-ref=administrator,power-user,user"
        },
        service = Portlet.class
)
public class ImportEmployeesLeavesRequestsUtility extends MVCPortlet {
    private Log log = LogFactoryUtil.getLog(ImportEmployeesLeavesRequestsUtility.class);

    @Reference
    AxHrmsCommonApi axHrmsCommonApi;

    @Reference
    EmployeeDetailsLocalService employeeDetailsLocalService;

    @Reference
    LeaveRequestLocalService leaveRequestLocalService;

    @Reference
    LeaveDayTypeLocalService leaveDayTypeLocalService;

    @Reference
    CommentLocalService commentLocalService;

    @Reference
    LeaveCompensatoryStatusMasterLocalService leaveCompensatoryStatusMasterLocalService;

    @Reference
    LeaveTypeMasterLocalService leaveTypeMasterLocalService;



    private Map<String, Long> leaveTypeCache = new HashMap<>();
    private Map<String, Long> statusCache = new HashMap<>();

    private static final String EXCEL_DATE_FORMAT = "dd-MMM-yyyy HH:mm:ss";
    private static final String CUTOFF_DATE_STR = "13-Mar-2026";

    @Override
    public void render(RenderRequest renderRequest, RenderResponse renderResponse)
            throws IOException, PortletException {
        log.info("inside render");

        super.render(renderRequest, renderResponse);
    }
    @Override
    public void serveResource(ResourceRequest resourceRequest,
                              ResourceResponse resourceResponse)
            throws IOException {

        String filePath = ParamUtil.getString(resourceRequest, "filePath");

        File file = new File(filePath);

        if (!file.exists()) {
            return;
        }

        resourceResponse.setContentType(
                "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");

        resourceResponse.setProperty(
                "Content-Disposition",
                "attachment; filename=Employee_Leaves_Requests_Error_Report.xlsx");

        try (InputStream in = new FileInputStream(file);
             OutputStream out = resourceResponse.getPortletOutputStream()) {

            byte[] buffer = new byte[1024];
            int len;

            while ((len = in.read(buffer)) > 0) {
                out.write(buffer, 0, len);
            }
        }
    }

        @Override
        public void processAction(ActionRequest actionRequest, ActionResponse actionResponse)
                throws IOException, PortletException {
            AtomicInteger successCount = new AtomicInteger();
            List<FailedRow> failedRows = new ArrayList<>();

            ThemeDisplay themeDisplay =
                    (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

            UploadPortletRequest uploadRequest =
                    PortalUtil.getUploadPortletRequest(actionRequest);

            File file = uploadRequest.getFile("zohoEmployeeLeavesrequestsFile");
            String fileName = uploadRequest.getFileName("zohoEmployeeLeavesrequestsFile");

            Workbook workbook = axHrmsCommonApi.getWorkbook(fileName, file);

            Map<String, Map<String, Object>> dataMap =
                    axHrmsCommonApi.readExcelSheetForImportEmployee(workbook.getSheetAt(0));

            log.info("Excel data loaded, total rows: " + dataMap.size());

            loadCaches();

            dataMap.forEach((outerKey, innerMap) -> {

                String officialEmail = getSafeValue(innerMap, "1");

                try {
                    if ("0".equalsIgnoreCase(outerKey) || Validator.isNull(innerMap)) {
                        return;
                    }

                    String status = getSafeValue(innerMap, "12");

                    if (officialEmail.isEmpty()) {
                        failedRows.add(new FailedRow(outerKey, officialEmail, "Email is empty"));
                        return;
                    }

                    if ("Pending".equalsIgnoreCase(status)) {
                        failedRows.add(new FailedRow(outerKey, officialEmail, "Status is Pending"));
                        return;
                    }

                    EmployeeDetailsTable table = EmployeeDetailsTable.INSTANCE;

                    DSLQuery query = DSLQueryFactoryUtil.select(table)
                            .from(table)
                            .where(table.officialEmail.eq(officialEmail));

                    List<EmployeeDetails> employeeList =
                            employeeDetailsLocalService.dslQuery(query);

                    if (Validator.isNull(employeeList) || employeeList.isEmpty()) {
                        failedRows.add(new FailedRow(outerKey, officialEmail, "Employee not found"));
                        return;
                    }

                    EmployeeDetails employee = employeeList.get(0);

                    try {
                        LeaveRequest lr = addLeaveRequestData(employee, themeDisplay, innerMap);

                        addLeaveDayTypeData(lr, innerMap, themeDisplay);

                        addCommentData(lr, innerMap, themeDisplay);

                        successCount.getAndIncrement();

                    } catch (Exception e) {
                        failedRows.add(new FailedRow(
                                outerKey,
                                officialEmail,
                                e.getMessage()
                        ));
                    }

                } catch (Exception e) {
                    failedRows.add(new FailedRow(outerKey, officialEmail, "Exception: " + e.getMessage()));
                    log.error("Error processing row: " + outerKey, e);
                }
            });

            String errorFilePath = "";

            if (!failedRows.isEmpty()) {
                try {
                    File errorFile = generateErrorExcel(failedRows);
                    errorFilePath = errorFile.getAbsolutePath();
                } catch (Exception e) {
                    log.error("Error generating Excel report", e);
                }
            }
            actionResponse.setRenderParameter("successCount", String.valueOf(successCount.get()));
            actionResponse.setRenderParameter("failedCount", String.valueOf(failedRows.size()));
            actionResponse.setRenderParameter("errorFilePath", errorFilePath);

            SessionMessages.add(actionRequest, "sucess-key");

            log.info("Leave import process completed");
        }

    private LeaveRequest addLeaveRequestData(
            EmployeeDetails employee,
            ThemeDisplay themeDisplay,
            Map<String, Object> map) throws Exception{

        try {
//            DateFormat format = new SimpleDateFormat(EXCEL_DATE_FORMAT, Locale.ENGLISH);

            String startStr = getSafeValue(map, "3");
            String endStr = getSafeValue(map, "4");

            if (startStr.isEmpty() || endStr.isEmpty()) {
                throw new Exception("Start or End date missing");
            }

//            Date startDate = format.parse(startStr + AxHrmsUtilityConstants.DEFAULT_TIME);
//            Date endDate = format.parse(endStr + AxHrmsUtilityConstants.DEFAULT_TIME);
            Date startDate = parseDate(startStr);
            Date endDate = parseDate(endStr);

            if (startDate == null || endDate == null) {
                throw new Exception("Date parsing failed");
            }

//            Date cutoff = format.parse(CUTOFF_DATE_STR + AxHrmsUtilityConstants.DEFAULT_TIME);
            Date cutoff = parseDate(CUTOFF_DATE_STR);

            if (startDate.after(cutoff) && endDate.after(cutoff)) {
                throw new Exception("Skipped due to cutoff date");
            }

            if ((startDate.before(cutoff) || startDate.equals(cutoff)) && endDate.after(cutoff)) {
                endDate = cutoff;
            }

//            Date createdDate = format.parse(getSafeValue(map, "8") + AxHrmsUtilityConstants.DEFAULT_TIME);
//            Date modifiedDate = format.parse(getSafeValue(map, "15") + AxHrmsUtilityConstants.DEFAULT_TIME);

            Date createdDate = parseDate(getSafeValue(map, "8"));
            Date modifiedDate = parseDate(getSafeValue(map, "15"));

            if (createdDate == null || modifiedDate == null) {
                throw new Exception("Created/Modified date missing → skipping");

            }

            // Approver
            String approverEmail = getSafeValue(map, "14");

            EmployeeDetailsTable table = EmployeeDetailsTable.INSTANCE;

            DSLQuery query = DSLQueryFactoryUtil.select(table)
                    .from(table)
                    .where(table.officialEmail.eq(approverEmail));

            List<EmployeeDetails> approvers = employeeDetailsLocalService.dslQuery(query);

            if (approvers.isEmpty()) {
                throw new Exception("Approver not found - skipping");
            }

            EmployeeDetails approver = approvers.get(0);

            // Create entity
            LeaveRequest lr = leaveRequestLocalService.createLeaveRequest(
                    CounterLocalServiceUtil.increment(LeaveRequest.class.getName()));

            lr.setCompanyId(themeDisplay.getCompanyId());
            lr.setGroupId(themeDisplay.getScopeGroupId());

            lr.setCreatedBy(employee.getLrUserId());
            lr.setModifiedBy(approver.getLrUserId());

            lr.setCreateDate(createdDate);
            lr.setModifiedDate(modifiedDate);

            lr.setStartDateTime(startDate);
            lr.setEndDateTime(endDate);

            lr.setEmployeeId(employee.getEmployeeId());
            lr.setReason(getSafeValue(map, "6"));

            lr.setHrApprovalId(approver.getEmployeeId());
            lr.setManagerApprovalId(approver.getEmployeeId());

            lr.setDateOfRequest(createdDate);

            lr.setLeaveTypeMasterId(getLeaveTypeId(getSafeValue(map, "2")));
            lr.setLeaveCompensatoryStatusMasterId(getStatusId(getSafeValue(map, "12")));

            return leaveRequestLocalService.addLeaveRequest(lr);

        }catch (Exception e) {
            throw new Exception("LeaveRequest Error: " + e.getMessage());
        }


    }
    private String getSafeValue(Map<String, Object> map, String key) {
        Object val = map.get(key);
        return val != null ? val.toString().trim() : "";
    }

    private Date parseDate(String value) throws Exception {

        if (Validator.isNull(value)) {
            return null;
        }

        value = value.trim();

        List<SimpleDateFormat> formats = Arrays.asList(
                new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss", Locale.ENGLISH),
                new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH),
                new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH)
        );

        for (SimpleDateFormat sdf : formats) {
            try {
                return sdf.parse(value);
            } catch (Exception ignored) {}
        }

        throw new Exception("Invalid date format: " + value);
    }
    private long getLeaveTypeId(String type)  {
        String lower = type.toLowerCase();

        for (Map.Entry<String, String> entry : LEAVE_TYPE_MAP.entrySet()) {
            if (lower.contains(entry.getKey())) {
                return leaveTypeCache.getOrDefault(entry.getValue().toLowerCase(), 0L);
            }
        }
        return 0;
    }

    private long getStatusId(String status) {
        String lower = status.toLowerCase();

        for (Map.Entry<String, String> entry : STATUS_MAP.entrySet()) {
            if (lower.contains(entry.getKey())) {
                return statusCache.getOrDefault(entry.getValue().toLowerCase(), 0L);
            }
        }
        return 0;
    }
    private void loadCaches() {
        try {
            leaveTypeMasterLocalService.getLeaveTypeMasters(-1, -1)
                    .forEach(lt -> leaveTypeCache.put(
                            lt.getLeaveTypeName().toLowerCase(),
                            lt.getLeaveTypeMasterId()
                    ));

            leaveCompensatoryStatusMasterLocalService.getLeaveCompensatoryStatusMasters(-1, -1)
                    .forEach(st -> statusCache.put(
                            st.getLeaveCompensatoryStatus().toLowerCase(),
                            st.getLeaveCompensatoryStatusMasterId()
                    ));

            log.info("Cache loaded successfully");

        } catch (Exception e) {
            log.error("Error loading cache", e);
        }
    }
    private static final Map<String, String> LEAVE_TYPE_MAP = new HashMap<>();
    static {
        LEAVE_TYPE_MAP.put("earned", "Earned Leave");
        LEAVE_TYPE_MAP.put("maternity", "Maternity Leave");
        LEAVE_TYPE_MAP.put("bereavement", "Bereavement Leave");
        LEAVE_TYPE_MAP.put("paternity", "Paternity Leave");
        LEAVE_TYPE_MAP.put("personal", "Personal Floater");
        LEAVE_TYPE_MAP.put("festival", "Festival Floater");
        LEAVE_TYPE_MAP.put("loyalty", "Loyalty Leave");
        LEAVE_TYPE_MAP.put("compensatory", "Compensatory Off");
        LEAVE_TYPE_MAP.put("comp off", "Compensatory Off");
        LEAVE_TYPE_MAP.put("unpaid", "Unpaid Leave");
    }

    private static final Map<String, String> STATUS_MAP = new HashMap<>();
    static {
        STATUS_MAP.put("approved", "Approved");
        STATUS_MAP.put("pending", "Pending");
        STATUS_MAP.put("rejected", "Rejected");
        STATUS_MAP.put("cancel", "Cancelled");
    }


    // leaveDayType logic

    private void addLeaveDayTypeData(
            LeaveRequest leaveRequest,
            Map<String, Object> map,
            ThemeDisplay themeDisplay) throws Exception {

        try {
            String rawData = getSafeValue(map, "17");

            if (Validator.isNull(rawData)) {
                log.warn("No LeaveDayType data found");
                return;
            }

            String[] entries = rawData.split("\\},\\{");

            DateFormat inputFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            DateFormat dbFormat = new SimpleDateFormat(
                    AxHrmsUtilityConstants.LIFERAY_DB_DATETIME_FORMAT);

            for (String entry : entries) {

                entry = entry.replace("{", "").replace("}", "");

                String[] parts = entry.split(",");

                String dateStr = "";
                String duration = "";
                String session = "";

                for (String part : parts) {
                    String[] keyValue = part.split(":");

                    if (keyValue.length < 2) continue;

                    String key = keyValue[0].trim();
                    String value = keyValue[1].trim();

                    if ("Date".equalsIgnoreCase(key)) {
                        dateStr = value;
                    } else if ("Duration".equalsIgnoreCase(key)) {
                        duration = value;
                    } else if ("Session".equalsIgnoreCase(key)) {
                        session = value;
                    }
                }

                if ("Holiday/Weekend".equalsIgnoreCase(duration)) {
                    log.info("Date is Holiday/Weekend so not added: " + entry);
                    continue;
                }

                if (Validator.isNull(dateStr)) {
                    log.info("Date missing in entry: " + entry);
                    continue;
                }

                Date parsedDate = inputFormat.parse(dateStr);

                String formattedDate = new SimpleDateFormat("yyyy-MM-dd").format(parsedDate);

                Date leaveDate = dbFormat.parse(
                        formattedDate + AxHrmsUtilityConstants.DEFAULT_TIME);

                boolean isHalfDay = "Half Day".equalsIgnoreCase(duration);
                boolean isFirstHalf = false;

                if (isHalfDay) {
                    isFirstHalf = "1st Half".equalsIgnoreCase(session);
                }

                LeaveDayType leaveDayType =
                        leaveDayTypeLocalService.createLeaveDayType(
                                CounterLocalServiceUtil.increment(LeaveDayType.class.getName()));

                leaveDayType.setLeaveRequestId(leaveRequest.getLeaveRequestId());
                leaveDayType.setCompanyId(themeDisplay.getCompanyId());
                leaveDayType.setLeaveDate(leaveDate);
                leaveDayType.setIsHalfDay(isHalfDay);
                leaveDayType.setIsFirstHalf(isFirstHalf);
                leaveDayType.setCreateDate(leaveRequest.getCreateDate());
                leaveDayType.setModifiedDate(leaveRequest.getCreateDate());
                leaveDayType.setCreatedBy(leaveRequest.getCreatedBy());
                leaveDayType.setModifiedBy(leaveRequest.getCreatedBy());
                leaveDayType.setGroupId(themeDisplay.getScopeGroupId());

                leaveDayTypeLocalService.addLeaveDayType(leaveDayType);
            }

        } catch (Exception e) {
            throw new Exception("LeaveDayType Error: " + e.getMessage());
        }
    }
    private void addCommentData(
            LeaveRequest leaveRequest,
            Map<String, Object> map,
            ThemeDisplay themeDisplay) throws Exception {

        try {
            String statusStr = getSafeValue(map, "12");
            String excelComment = getSafeValue(map, "18");

            if (Validator.isNull(statusStr)) {
                log.warn("Status is null, skipping comment");
                return;
            }

            String statusLower = statusStr.toLowerCase();

            String action = "";
            String commentText = "";

            if (statusLower.contains("cancel")) {
                action = "Cancelled";
                commentText = Validator.isNotNull(excelComment)
                        ? excelComment
                        : "Cancelled";
            } else if (statusLower.contains("approved")) {
                action = "Approved";
                commentText = "Approved";
            } else if (statusLower.contains("rejected")) {
                action = "Rejected";
                commentText = "Rejected";
            } else if (statusLower.contains("pending")) {
                action = "Pending";
                commentText = "Pending";
            } else {
                log.warn("Unknown status: " + statusStr);
                return;
            }

            long requestId = leaveRequest.getLeaveRequestId();
            long type = 1L;

            Date now = new Date();

            if ("Cancelled".equalsIgnoreCase(action)) {

                List<Comment> activeComments =
                        commentLocalService.findByTypeRequestIdAndStatus(
                                type, requestId, true);

                for (Comment oldComment : activeComments) {

                    oldComment.setStatus(false);
                    oldComment.setModifiedDate(now);
                    oldComment.setModifiedBy(themeDisplay.getUserId());

                    commentLocalService.updateComment(oldComment);
                }
            }

            Comment comment =
                    commentLocalService.createComment(
                            CounterLocalServiceUtil.increment(Comment.class.getName())
                    );

            comment.setCompanyId(themeDisplay.getCompanyId());
            comment.setGroupId(themeDisplay.getScopeGroupId());
            comment.setCreatedBy(leaveRequest.getModifiedBy());
            comment.setModifiedBy(leaveRequest.getModifiedBy());
            comment.setCreateDate(leaveRequest.getModifiedDate());
            comment.setModifiedDate(leaveRequest.getModifiedDate());

            comment.setType(type);
            comment.setAction(action);
            comment.setComment(commentText);
            comment.setRequestId(requestId);
            comment.setStatus(true);

            commentLocalService.addComment(comment);

            log.info("Comment added for LeaveRequestId: " + requestId);

        } catch (Exception e) {
            throw new Exception("Comment Error: " + e.getMessage());
        }
    }
    public static class FailedRow {
        String rowNumber;
        String email;
        String reason;

        public FailedRow(String rowNumber, String email, String reason) {
            this.rowNumber = rowNumber;
            this.email = email;
            this.reason = reason;
        }
    }

    private File generateErrorExcel(List<FailedRow> failedRows) throws IOException {

        Workbook workbook = new XSSFWorkbook();
       Sheet sheet = workbook.createSheet("Errors");

        int rowNum = 0;

        // Header
        org.apache.poi.ss.usermodel.Row header = sheet.createRow(rowNum++);
        header.createCell(0).setCellValue("Row Number");
        header.createCell(1).setCellValue("Email");
        header.createCell(2).setCellValue("Reason");

        // Data
        for (FailedRow fr : failedRows) {
            org.apache.poi.ss.usermodel.Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(fr.rowNumber);
            row.createCell(1).setCellValue(fr.email);
            row.createCell(2).setCellValue(fr.reason);
        }

        sheet.autoSizeColumn(0);
        sheet.autoSizeColumn(1);
        sheet.autoSizeColumn(2);

        File file = File.createTempFile("Leave_Error_Report_", ".xlsx");

        try (FileOutputStream fos = new FileOutputStream(file)) {
            workbook.write(fos);
        }

        workbook.close();

        return file;
    }
}
