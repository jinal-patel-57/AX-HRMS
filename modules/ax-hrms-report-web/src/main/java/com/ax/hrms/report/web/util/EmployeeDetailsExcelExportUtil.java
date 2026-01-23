package com.ax.hrms.report.web.util;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONObject;

import java.io.OutputStream;

import javax.portlet.ResourceResponse;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class EmployeeDetailsExcelExportUtil {

    private EmployeeDetailsExcelExportUtil() {
        // private constructor to prevent instantiation
    }

    public static void exportEmployeeExcel(
            JSONArray employeeJsonArray,
            ResourceResponse resourceResponse) throws Exception {

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Employee Details");

        int rowNum = 0;

        CellStyle headerStyle = createHeaderStyle(workbook);
        CellStyle groupHeaderStyle = createGroupHeaderStyle(workbook);

        
     // ===============================
        // GROUP HEADER ROW
        // ===============================
        Row groupHeaderRow = sheet.createRow(rowNum++);

        createMergedCell(sheet, groupHeaderRow, 3, 9, "OFFICIAL DETAILS", groupHeaderStyle);
        createMergedCell(sheet, groupHeaderRow, 10, 12, "BANK DETAILS", groupHeaderStyle);
        createMergedCell(sheet, groupHeaderRow, 13, 25, "PERSONAL DETAILS", groupHeaderStyle);
        createMergedCell(sheet, groupHeaderRow, 26, 28, "NOMINEE DETAILS", groupHeaderStyle);
        
        // ===============================
        // COLUMN HEADER ROW
        // ===============================
        Row secondHeaderRow = sheet.createRow(rowNum++);
        Row headerRow = sheet.createRow(rowNum++);

        CellStyle secondHeaderStyle = workbook.createCellStyle();

     // Font
     Font headerFont = workbook.createFont();
     headerFont.setBold(true);
     headerFont.setColor(IndexedColors.WHITE.getIndex());
     headerFont.setFontHeightInPoints((short) 11);
     secondHeaderStyle.setFont(headerFont);

     // Background color (HRMS-like blue)
     secondHeaderStyle.setFillForegroundColor(
    		 IndexedColors.SEA_GREEN.getIndex());
     secondHeaderStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

     // Alignment
     secondHeaderStyle.setAlignment(HorizontalAlignment.CENTER);
     secondHeaderStyle.setVerticalAlignment(VerticalAlignment.CENTER);
     secondHeaderStyle.setWrapText(true);

     // Borders (optional but looks professional)
     secondHeaderStyle.setBorderTop(BorderStyle.THIN);
     secondHeaderStyle.setBorderBottom(BorderStyle.THIN);
     secondHeaderStyle.setBorderLeft(BorderStyle.THIN);
     secondHeaderStyle.setBorderRight(BorderStyle.THIN);
        
        String[] headers = {
            "Put x and get the structure)",
            "Employee Code",
            "Name as per PAN",
            
            "Gross Salary (CTC - PM)",
            "Gross Salary (CTC - PA)",
            "Join Date",
            "Email Id (Official)",
            "Designation",
            "Department",
            "Branch",
            
            "Name of Bank Personal Saving A/c",
            "IFSC Code",
            "SBAccNo",
            
            "PAN",
            "Email Id (Personal)",
            "Mobile No.",
            "Sex",
            "(As per KYC given)",
            "DateBirth",
            "PFMarital Status",
            "Name as per Adhar Card",
            "KYC document No. (Adhar Card, Passport, Driving Licence)",
            "Persent Address (As per KYC submitted)",
            "Permenent Address (As per KYC submitted)",
            "if already have (i.e PF registration already done)",
            "if already have",
            
            "Name of Nominee (Any of Family Member - IF married Spouse only)",
            " With member",
            "DOB of nominee",
            
            "Co Employee Code",
            "Spouse Name"
        };
        
        String[] secondHeader = {
                "",
                "",
                "",
                
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                
                "",
                "",
                "",
                
                "",
                "",
                "",
                "",
                "FHName",
                "",
                "",
                "",
                "",
                "",
                "",
                "UAN",
                "ESIC NO",
                
                "",
                "Relationship",
                "",
                
                "",
                ""
            };

        for (int i = 0; i < secondHeader.length; i++) {
        	Cell cell = secondHeaderRow.createCell(i);
        	cell.setCellValue(secondHeader[i]);
        	cell.setCellStyle(secondHeaderStyle);
        	sheet.autoSizeColumn(i);
        }

        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
            cell.setCellStyle(secondHeaderStyle);
            sheet.autoSizeColumn(i);
        }
        

        // ===============================
        // DATA ROWS FROM JSON
        // ===============================
      //  int srNo = 1;

        for (int i = 0; i < employeeJsonArray.length(); i++) {

            JSONObject emp = employeeJsonArray.getJSONObject(i);
            Row row = sheet.createRow(rowNum++);

            int col = 0;

            row.createCell(col++).setCellValue(emp.getString("putX"));
            row.createCell(col++).setCellValue(emp.getString("code"));
            row.createCell(col++).setCellValue(emp.getString("panName"));
            row.createCell(col++).setCellValue(emp.getDouble("grossSalaryPm"));
            row.createCell(col++).setCellValue(emp.getDouble("grossSalaryPa"));

            row.createCell(col++).setCellValue(emp.getString("joiningDate"));
            row.createCell(col++).setCellValue(emp.getString("officialEmail"));
            row.createCell(col++).setCellValue(emp.getString("designation"));
            row.createCell(col++).setCellValue(emp.getString("department"));
            row.createCell(col++).setCellValue(emp.getString("branch"));
            row.createCell(col++).setCellValue(emp.getString("bankName"));
            row.createCell(col++).setCellValue(emp.getString("ifsc"));
            row.createCell(col++).setCellValue(emp.getString("savingBankAccount"));
            row.createCell(col++).setCellValue(emp.getString("pan"));

            row.createCell(col++).setCellValue(emp.getString("personalEmail"));
            CellStyle textStyle = createTextStyle(workbook);
            sheet.setDefaultColumnStyle(15, textStyle);
            Cell mobileCell = row.createCell(col++);
            mobileCell.setCellStyle(textStyle);
            mobileCell.setCellValue(emp.getString("mobileNo")+" ");
            System.out.println("mob -- " + emp.getString("mobileNo"));
            
            
            //row.createCell(col++).setCellValue(""+emp.getString("mobileNo"));
            row.createCell(col++).setCellValue(emp.getString("gender"));
            row.createCell(col++).setCellValue(emp.getString("fhName"));
            row.createCell(col++).setCellValue(emp.getString("dateOfBirth"));
            row.createCell(col++).setCellValue(emp.getString("maritalStatus"));
            row.createCell(col++).setCellValue(emp.getString("nameAsPerAadhar"));
            row.createCell(col++).setCellValue(emp.getString("kycDoc"));
            row.createCell(col++).setCellValue(emp.getString("presentAddress"));
            row.createCell(col++).setCellValue(emp.getString("permanentAddress"));
            row.createCell(col++).setCellValue(emp.getString("uan"));
            row.createCell(col++).setCellValue(emp.getString("esic"));
            
            row.createCell(col++).setCellValue(emp.getString("nomineeName"));
            row.createCell(col++).setCellValue(emp.getString("relation"));
            row.createCell(col++).setCellValue(emp.getString("nomineeDob"));
            
            row.createCell(col++).setCellValue(emp.getString("coEmployeeCode"));
            row.createCell(col++).setCellValue(emp.getString("spouseName"));
        }

        // ===============================
        // DOWNLOAD RESPONSE
        // ===============================
        resourceResponse.setContentType(
            "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");

        resourceResponse.setProperty(
            "Content-Disposition", "attachment; filename=Employee_Details.xlsx");

        OutputStream os = resourceResponse.getPortletOutputStream();
        workbook.write(os);
        os.flush();
        workbook.close();
    }
    
    private static CellStyle createHeaderStyle(Workbook workbook) {
        CellStyle style = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setBold(true);
        style.setFont(font);
        return style;
    }

    private static CellStyle createGroupHeaderStyle(Workbook workbook) {
        CellStyle style = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setBold(true);
        style.setFont(font);
        style.setAlignment(HorizontalAlignment.CENTER);
        return style;
    }
    
    private static CellStyle createTextStyle(Workbook workbook) {
        DataFormat format = workbook.createDataFormat();
        CellStyle style = workbook.createCellStyle();
        style.setDataFormat(format.getFormat("@")); // TEXT
        return style;
    }

    private static void createMergedCell(
            Sheet sheet, Row row, int startCol, int endCol,
            String value, CellStyle style) {

        Cell cell = row.createCell(startCol);
        cell.setCellValue(value);
        cell.setCellStyle(style);

        sheet.addMergedRegion(
            new org.apache.poi.ss.util.CellRangeAddress(
                row.getRowNum(), row.getRowNum(), startCol, endCol));
    }

}
