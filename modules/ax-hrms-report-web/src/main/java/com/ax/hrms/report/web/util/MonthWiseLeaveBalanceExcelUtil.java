package com.ax.hrms.report.web.util;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.portlet.ResourceResponse;
import java.io.OutputStream;
import java.util.Map;

public class MonthWiseLeaveBalanceExcelUtil {

    public static void exportMonthWiseLeaveBalance(
            Map<String, Map<String, Double>> leaveBalanceData,
            ResourceResponse response) throws Exception {

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Month Wise Leave Balance");

        int rowNum = 0;

        Row headerRow = sheet.createRow(rowNum++);
        // Create bold font
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);

        CellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFont(headerFont);

        Cell cell0 = headerRow.createCell(0);
        cell0.setCellValue("EmpCode");
        cell0.setCellStyle(headerStyle);

        Cell cell1 = headerRow.createCell(1);
        cell1.setCellValue("Name");
        cell1.setCellStyle(headerStyle);

        Cell cell2 = headerRow.createCell(2);
        cell2.setCellValue("Email");
        cell2.setCellStyle(headerStyle);

        Cell cell3 = headerRow.createCell(3);
        cell3.setCellValue("LEAVE Balance");
        cell3.setCellStyle(headerStyle);

        Cell cell4 = headerRow.createCell(4);
        cell4.setCellValue("Leave Taken");
        cell4.setCellStyle(headerStyle);

        Cell cell5 = headerRow.createCell(5);
        cell5.setCellValue("Encash Leave");
        cell5.setCellStyle(headerStyle);

        Cell cell6 = headerRow.createCell(6);
        cell6.setCellValue("Unpaid Leave");
        cell6.setCellStyle(headerStyle);

        Cell cell7 = headerRow.createCell(7);
        cell7.setCellValue("Paternity Leave");
        cell7.setCellStyle(headerStyle);

        // Freeze first 3 columns and header row
        sheet.createFreezePane(3, 1);



        for (Map.Entry<String, Map<String, Double>> entry
                : leaveBalanceData.entrySet()) {

            String employeeJsonString = entry.getKey();

            JSONObject json =
                    JSONFactoryUtil.createJSONObject(employeeJsonString);

            String empCode = json.getString("Employee Code");
            String name = json.getString("Employee Name");
            String email = json.getString("Email");


            Map<String, Double> balanceMap = entry.getValue();

            double balance =
                    balanceMap.getOrDefault("Leave Balance", 0.0);

            double leaveTaken =
                    balanceMap.getOrDefault("Leave Taken", 0.0);

            double unpaid =
                    balanceMap.getOrDefault("Unpaid Leave", 0.0);

            Row row = sheet.createRow(rowNum++);

            row.createCell(0).setCellValue(empCode);
            row.createCell(1).setCellValue(name);
            row.createCell(2).setCellValue(email);
            row.createCell(3).setCellValue(balance);
            row.createCell(4).setCellValue(leaveTaken);
            row.createCell(5).setCellValue(0);
            row.createCell(6).setCellValue(unpaid);
            row.createCell(7).setCellValue(0);
        }

        // Auto size columns
        for (int i = 0; i <= 7; i++) {
            sheet.autoSizeColumn(i);
        }


        response.setContentType(
                "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");

        response.setProperty(
                "Content-Disposition",
                "attachment; filename=Month_Wise_Leave_Balance.xlsx");

        OutputStream out = response.getPortletOutputStream();
        workbook.write(out);
        workbook.close();
        out.close();
    }
}