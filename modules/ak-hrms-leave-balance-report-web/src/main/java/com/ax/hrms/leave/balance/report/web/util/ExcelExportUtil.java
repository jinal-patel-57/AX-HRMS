package com.ax.hrms.leave.balance.report.web.util;

import com.ax.hrms.leave.balance.report.web.constants.AkHrmsLeaveBalanceReportWebPortletKeys;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.portlet.ResourceResponse;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExcelExportUtil {

    private ExcelExportUtil() {
        // private constructor to prevent instantiation
    }

    /**
     * Exports leave balance data to Excel with Paid / Unpaid / Comp Off separation
     *
     * @param leaveBalanceData Map of JSON string -> (leaveType -> remainingLeaves)
     * @param response         ResourceResponse for writing the Excel file
     * @param fileName         Desired file name for download
     * @throws Exception in case of any IO issues
     */
    public static void exportLeaveBalance(
            Map<String, Map<String, Double>> leaveBalanceData,
            ResourceResponse response,
            String fileName) throws Exception {

        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet(AkHrmsLeaveBalanceReportWebPortletKeys.SHEET_NAME_LEAVE_BALANCE);

            CellStyle headerStyle = workbook.createCellStyle();
            Font font = workbook.createFont();
            font.setBold(true);
            headerStyle.setFont(font);
            headerStyle.setAlignment(HorizontalAlignment.CENTER);
            headerStyle.setVerticalAlignment(VerticalAlignment.CENTER);
            headerStyle.setBorderBottom(BorderStyle.THIN);

            ArrayList<String> allLeaveTypes = leaveBalanceData.values().stream()
                    .findFirst()
                    .map(map -> new ArrayList<>(map.keySet()))
                    .orElse(new ArrayList<>());

            ArrayList<String> paidLeaves = new ArrayList<>();
            ArrayList<String> unpaidLeaves = new ArrayList<>();
            ArrayList<String> compOffLeaves = new ArrayList<>();

            for (String leaveType : allLeaveTypes) {
                if (AkHrmsLeaveBalanceReportWebPortletKeys.UNPAID.equalsIgnoreCase(leaveType)) {
                    unpaidLeaves.add(leaveType);
                } else if (AkHrmsLeaveBalanceReportWebPortletKeys.COMP_OFF.equalsIgnoreCase(leaveType)) {
                    compOffLeaves.add(leaveType);
                } else {
                    paidLeaves.add(leaveType);
                }
            }

            Row headerRow1 = sheet.createRow(0);
            Row headerRow2 = sheet.createRow(1);

            // Fixed Employee Columns
            String[] empHeaders = {AkHrmsLeaveBalanceReportWebPortletKeys.HEADER_EMPLOYEE_ID, AkHrmsLeaveBalanceReportWebPortletKeys.HEADER_EMPLOYEE_NAME, AkHrmsLeaveBalanceReportWebPortletKeys.HEADER_EMPLOYEE_EMAIL};
            int colIndex = 0;

            for (int i = 0; i < empHeaders.length; i++) {
                Cell cell = headerRow2.createCell(colIndex);
                cell.setCellValue(empHeaders[i]);
                cell.setCellStyle(headerStyle);
                colIndex++;
            }

            sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, empHeaders.length - 1));

            // Paid Leaves
            int paidStartCol = colIndex;
            for (String leave : paidLeaves) {
                Cell cell = headerRow2.createCell(colIndex++);
                cell.setCellValue(leave);
                cell.setCellStyle(headerStyle);
            }
            Cell paidTotalCell = headerRow2.createCell(colIndex++);
            paidTotalCell.setCellValue(AkHrmsLeaveBalanceReportWebPortletKeys.TOTAL);
            paidTotalCell.setCellStyle(headerStyle);

            sheet.addMergedRegion(new CellRangeAddress(0, 0, paidStartCol, colIndex - 1));
            Cell paidHeader = headerRow1.createCell(paidStartCol);
            paidHeader.setCellValue(AkHrmsLeaveBalanceReportWebPortletKeys.HEADER_PAID);
            paidHeader.setCellStyle(headerStyle);

            // Unpaid Leaves
            int unpaidStartCol = colIndex;
            for (String leave : unpaidLeaves) {
                Cell cell = headerRow2.createCell(colIndex++);
                cell.setCellValue(leave);
                cell.setCellStyle(headerStyle);
            }
            Cell unpaidTotalCell = headerRow2.createCell(colIndex++);
            unpaidTotalCell.setCellValue(AkHrmsLeaveBalanceReportWebPortletKeys.TOTAL);
            unpaidTotalCell.setCellStyle(headerStyle);

            sheet.addMergedRegion(new CellRangeAddress(0, 0, unpaidStartCol, colIndex - 1));
            Cell unpaidHeader = headerRow1.createCell(unpaidStartCol);
            unpaidHeader.setCellValue(AkHrmsLeaveBalanceReportWebPortletKeys.HEADER_UNPAID);
            unpaidHeader.setCellStyle(headerStyle);

            // Compensatory Off
            int compOffStartCol = colIndex;
            for (String leave : compOffLeaves) {
                Cell cell = headerRow2.createCell(colIndex++);
                cell.setCellValue(leave);
                cell.setCellStyle(headerStyle);
            }
            Cell compTotalCell = headerRow2.createCell(colIndex++);
            compTotalCell.setCellValue(AkHrmsLeaveBalanceReportWebPortletKeys.TOTAL);
            compTotalCell.setCellStyle(headerStyle);

            sheet.addMergedRegion(new CellRangeAddress(0, 0, compOffStartCol, colIndex - 1));
            Cell compHeader = headerRow1.createCell(compOffStartCol);
            compHeader.setCellValue(AkHrmsLeaveBalanceReportWebPortletKeys.COMP_OFF);
            compHeader.setCellStyle(headerStyle);


            int rowIndex = 2;
            for (Map.Entry<String, Map<String, Double>> empEntry : leaveBalanceData.entrySet()) {
                Row row = sheet.createRow(rowIndex++);
                JSONObject employeeJson = JSONFactoryUtil.createJSONObject(empEntry.getKey());

                // Employee ID, Name, Email
                row.createCell(0).setCellValue(employeeJson.getString(AkHrmsLeaveBalanceReportWebPortletKeys.EMPLOYEE_ID));
                row.createCell(1).setCellValue(employeeJson.getString(AkHrmsLeaveBalanceReportWebPortletKeys.EMPLOYEE_NAME));
                row.createCell(2).setCellValue(employeeJson.getString(AkHrmsLeaveBalanceReportWebPortletKeys.EMPLOYEE_EMAIL));

                Map<String, Double> balances = empEntry.getValue();

                // Paid Leaves
                double paidSum = 0.0;
                int paidCol = paidStartCol;
                for (String leave : paidLeaves) {
                    double val = balances.getOrDefault(leave, 0.0);
                    row.createCell(paidCol++).setCellValue(val);
                    paidSum += val;
                }
                row.createCell(paidCol).setCellValue(paidSum);

                // Unpaid Leaves
                double unpaidSum = 0.0;
                int unpaidCol = unpaidStartCol;
                for (String leave : unpaidLeaves) {
                    double val = balances.getOrDefault(leave, 0.0);
                    row.createCell(unpaidCol++).setCellValue(val);
                    unpaidSum += val;
                }
                row.createCell(unpaidCol).setCellValue(unpaidSum);

                // Compensatory Off
                double compSum = 0.0;
                int compCol = compOffStartCol;
                for (String leave : compOffLeaves) {
                    double val = balances.getOrDefault(leave, 0.0);
                    row.createCell(compCol++).setCellValue(val);
                    compSum += val;
                }
                row.createCell(compCol).setCellValue(compSum);
            }

            for (int i = 0; i < colIndex; i++) {
                sheet.autoSizeColumn(i);
            }
            sheet.createFreezePane(empHeaders.length, 2);

            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            response.setProperty(ResourceResponse.HTTP_STATUS_CODE, "200");
            response.setProperty("Content-Disposition", "attachment; filename=\"" + fileName + ".xlsx\"");

            try (OutputStream os = response.getPortletOutputStream()) {
                workbook.write(os);
            }

        } catch (Exception e) {
            throw e;
        }
    }

}
