package com.ax.hrms.report.web.util;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.portlet.ResourceResponse;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

public class CompensatoryOffExcelExportUtil {

    public static void exportCompOffReport(
            List<Map<String, String>> data,
            ResourceResponse response,
            String fileName) throws Exception {

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Comp Off Report");

        String[] headers = {
                "Employee Code",
                "Employee Name",
                "Employee Email",
                "Department",
                "Designation",
                "Manager",
                "Location",
                "Employee Type",
                "Balance",
                "Start Date",
                "End Date",
                "Status",
                "Action By",
                "Action On",
                "Reason"
        };

        Row headerRow = sheet.createRow(0);
        CellStyle headerStyle = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setBold(true);
        headerStyle.setFont(font);

        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
            cell.setCellStyle(headerStyle);
        }

        int rowNum = 1;

        for (Map<String, String> rowData : data) {
            Row row = sheet.createRow(rowNum++);
            int colNum = 0;

            for (String header : headers) {
                row.createCell(colNum++).setCellValue(rowData.getOrDefault(header, ""));
            }
        }

        for (int i = 0; i < headers.length; i++) {
            sheet.autoSizeColumn(i);
        }

        response.setContentType(
                "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setProperty(
                "Content-Disposition", "attachment; filename=" + fileName + ".xlsx");

        OutputStream outputStream = response.getPortletOutputStream();
        workbook.write(outputStream);
        outputStream.close();
        workbook.close();
    }
}
