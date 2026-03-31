package com.ax.hrms.report.web.util;

import com.ax.hrms.report.web.leave.report.dto.LeaveReportDTO;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.portlet.ResourceResponse;
import java.io.OutputStream;
import java.util.List;

public class LeaveReportExcelExportUtil {
    public static void exportLeaveReport(List<LeaveReportDTO> data, ResourceResponse response, String fileName) throws Exception {

        try (Workbook workbook = new XSSFWorkbook()) {

            Sheet sheet = workbook.createSheet("Leave Report");

            // Header Style
            CellStyle headerStyle = workbook.createCellStyle();
            Font font = workbook.createFont();
            font.setBold(true);
            headerStyle.setFont(font);

            // Header Row
            Row header = sheet.createRow(0);

            String[] columns = {"Employee Code", "Employee Name", "Employee Email", "Leave Type", "No of Days", "Requested Date", "Start Date", "End Date","Reason","Status", "Approved By", "Approved Date"};

            for (int i = 0; i < columns.length; i++) {
                Cell cell = header.createCell(i);
                cell.setCellValue(columns[i]);
                cell.setCellStyle(headerStyle);
            }

            // Data Rows
            int rowIdx = 1;

            for (LeaveReportDTO dto : data) {

                Row row = sheet.createRow(rowIdx++);

                row.createCell(0).setCellValue(dto.getEmployeeCode());
                row.createCell(1).setCellValue(dto.getEmployeeName());
                row.createCell(2).setCellValue(dto.getEmployeeEmail());
                row.createCell(3).setCellValue(dto.getLeaveType());
                row.createCell(4).setCellValue(dto.getDays());
                row.createCell(5).setCellValue(dto.getRequestedDate());
                row.createCell(6).setCellValue(dto.getStartDate());
                row.createCell(7).setCellValue(dto.getEndDate());
                row.createCell(8).setCellValue(dto.getReason());
                row.createCell(9).setCellValue(dto.getStatus());
                row.createCell(10).setCellValue(dto.getApprovedBy());
                row.createCell(11).setCellValue(dto.getApprovedDate());
            }

            // Auto size columns
            for (int i = 0; i < columns.length; i++) {
                sheet.autoSizeColumn(i);
            }

            sheet.createFreezePane(0, 1);

            // Response setup
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            response.setProperty("Content-Disposition", "attachment; filename=\"" + fileName + ".xlsx\"");

            try (OutputStream os = response.getPortletOutputStream()) {
                workbook.write(os);
            }
        }
    }
}
