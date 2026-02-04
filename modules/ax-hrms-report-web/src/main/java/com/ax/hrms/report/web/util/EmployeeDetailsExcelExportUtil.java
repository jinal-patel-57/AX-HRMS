package com.ax.hrms.report.web.util;

import com.liferay.petra.string.StringPool;
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
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import static com.ax.hrms.report.web.constants.AkHrmsEmployeeDetailsReportWebPortletKeys.*;

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
        //CellStyle groupHeaderStyle = createGroupHeaderStyle(workbook);
        CellStyle officialDetailsHeaderStyle =
        		createGroupHeaderStyle(workbook, IndexedColors.ROYAL_BLUE.getIndex());

        CellStyle bankDetailsHeaderStyle =
        		createGroupHeaderStyle(workbook, IndexedColors.SEA_GREEN.getIndex());

        CellStyle personalDetailsHeaderStyle =
        		createGroupHeaderStyle(workbook, IndexedColors.VIOLET.getIndex());
        
        CellStyle nomineeDetailsHeaderStyle =
        		createGroupHeaderStyle(workbook, IndexedColors.DARK_TEAL.getIndex());

        
     // ===============================
        // GROUP HEADER ROW
        // ===============================
        Row groupHeaderRow = sheet.createRow(rowNum++);

        createMergedCell(sheet, groupHeaderRow, 2, 8, "OFFICIAL DETAILS", officialDetailsHeaderStyle);
        createMergedCell(sheet, groupHeaderRow, 9, 11, "BANK DETAILS", bankDetailsHeaderStyle);
        createMergedCell(sheet, groupHeaderRow, 12, 24, "PERSONAL DETAILS", personalDetailsHeaderStyle);
        createMergedCell(sheet, groupHeaderRow, 25, 27, "NOMINEE DETAILS", nomineeDetailsHeaderStyle);
        
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
        	HEADER_EMPLOYEE_NAME,
            NAME_AS_PER_PAN,
            
            GROSS_SALARY_CTC_PM,
            GROSS_SALARY_CTC_PA,
            JOIN_DATE,
            EMAIL_ID_OFFICIAL,
            DESIGNATION,
            DEPARTMENT,
            BRANCH,
            
            NAME_OF_BANK_PERSONAL_SAVING_A_C,
            IFSC_CODE,
            SB_ACC_NO,
            
            PAN,
            EMAIL_ID_PERSONAL,
            MOBILE_NO,
            SEX,
            AS_PER_KYC_GIVEN,
            DATE_BIRTH,
            PF_MARITAL_STATUS,
            NAME_AS_PER_ADHAR_CARD,
            KYC_DOCUMENT_NO_ADHAR_CARD_PASSPORT_DRIVING_LICENCE,
            PERSENT_ADDRESS_AS_PER_KYC_SUBMITTED,
            PERMENENT_ADDRESS_AS_PER_KYC_SUBMITTED,
            IF_ALREADY_HAVE_I_E_PF_REGISTRATION_ALREADY_DONE,
            IF_ALREADY_HAVE,
            
            NAME_OF_NOMINEE_ANY_OF_FAMILY_MEMBER_IF_MARRIED_SPOUSE_ONLY,
            WITH_MEMBER,
            DOB_OF_NOMINEE,
            
            CO_EMPLOYEE_CODE,
            SPOUSE_NAME
        };
        
        String[] secondHeader = {
                StringPool.BLANK,
                StringPool.BLANK,
                
                StringPool.BLANK,
                StringPool.BLANK,
                StringPool.BLANK,
                StringPool.BLANK,
                StringPool.BLANK,
                StringPool.BLANK,
                StringPool.BLANK,
                
                StringPool.BLANK,
                StringPool.BLANK,
                StringPool.BLANK,
                
                StringPool.BLANK,
                StringPool.BLANK,
                StringPool.BLANK,
                StringPool.BLANK,
                FH_NAME,
                StringPool.BLANK,
                StringPool.BLANK,
                StringPool.BLANK,
                StringPool.BLANK,
                StringPool.BLANK,
                StringPool.BLANK,
                UAN,
                ESIC_NO,
                
                StringPool.BLANK,
                RELATIONSHIP,
                StringPool.BLANK,
                
                StringPool.BLANK,
                StringPool.BLANK
            };

        for (int i = 0; i < secondHeader.length; i++) {
        	Cell cell = secondHeaderRow.createCell(i);
        	cell.setCellValue(secondHeader[i]);
        	if(i>=2 && i<=8) {
        		cell.setCellStyle(officialDetailsHeaderStyle);
        	} else if(i>=9 && i<=11) {
        		cell.setCellStyle(bankDetailsHeaderStyle);
        	} else if(i>=12 && i<=24) {
        		cell.setCellStyle(personalDetailsHeaderStyle);
        	} else if(i>=25 && i<=27) {
        		cell.setCellStyle(nomineeDetailsHeaderStyle);
        	} else {
        		cell.setCellStyle(headerStyle);
        	}
        	sheet.autoSizeColumn(i);
        }

        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
            if(i>=2 && i<=8) {
        		cell.setCellStyle(officialDetailsHeaderStyle);
        	} else if(i>=9 && i<=11) {
        		cell.setCellStyle(bankDetailsHeaderStyle);
        	} else if(i>=12 && i<=24) {
        		cell.setCellStyle(personalDetailsHeaderStyle);
        	} else if(i>=25 && i<=27) {
        		cell.setCellStyle(nomineeDetailsHeaderStyle);
        	} else {
        		cell.setCellStyle(headerStyle);
        	}
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

            row.createCell(col++).setCellValue(emp.getString("employeeName"));
            row.createCell(col++).setCellValue(emp.getString(PAN_NAME));
            row.createCell(col++).setCellValue(emp.getDouble(GROSS_SALARY_PM));
            row.createCell(col++).setCellValue(emp.getDouble(GROSS_SALARY_PA));

            row.createCell(col++).setCellValue(emp.getString(JOINING_DATE));
            row.createCell(col++).setCellValue(emp.getString(OFFICIAL_EMAIL));
            row.createCell(col++).setCellValue(emp.getString(DESIGNATION2));
            row.createCell(col++).setCellValue(emp.getString(DEPARTMENT2));
            row.createCell(col++).setCellValue(emp.getString(BRANCH2));
            row.createCell(col++).setCellValue(emp.getString(BANK_NAME));
            row.createCell(col++).setCellValue(emp.getString(IFSC));
            row.createCell(col++).setCellValue(emp.getString(SAVING_BANK_ACCOUNT));
            row.createCell(col++).setCellValue(emp.getString(PAN2));

            row.createCell(col++).setCellValue(emp.getString(PERSONAL_EMAIL));
            CellStyle textStyle = createTextStyle(workbook);
            sheet.setDefaultColumnStyle(15, textStyle);
            Cell mobileCell = row.createCell(col++);
            mobileCell.setCellStyle(textStyle);
            mobileCell.setCellValue(emp.getString(MOBILE_NO2)+" ");
            
            //row.createCell(col++).setCellValue(StringPool.BLANK+emp.getString("mobileNo"));
            row.createCell(col++).setCellValue(emp.getString(GENDER));
            row.createCell(col++).setCellValue(emp.getString(FH_NAME2));
            row.createCell(col++).setCellValue(emp.getString(DATE_OF_BIRTH));
            row.createCell(col++).setCellValue(emp.getString(MARITAL_STATUS));
            row.createCell(col++).setCellValue(emp.getString(NAME_AS_PER_AADHAR));
            row.createCell(col++).setCellValue(emp.getString(KYC_DOC));
            row.createCell(col++).setCellValue(emp.getString(PRESENT_ADDRESS));
            row.createCell(col++).setCellValue(emp.getString(PERMANENT_ADDRESS));
            row.createCell(col++).setCellValue(emp.getString(UAN2));
            row.createCell(col++).setCellValue(emp.getString(ESIC));
            
            row.createCell(col++).setCellValue(emp.getString(NOMINEE_NAME));
            row.createCell(col++).setCellValue(emp.getString(RELATION));
            row.createCell(col++).setCellValue(emp.getString(NOMINEE_DOB));
            
            row.createCell(col++).setCellValue(emp.getString(CODE));
            row.createCell(col++).setCellValue(emp.getString(SPOUSE_NAME2));
        }
        sheet.createFreezePane(2, 3);

        // ===============================
        // DOWNLOAD RESPONSE
        // ===============================
        resourceResponse.setContentType(
            "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");

        resourceResponse.setProperty(
            "Content-Disposition", "attachment; filename=AX_Employee_Details_Report.xlsx");

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

    private static CellStyle createGroupHeaderStyle(Workbook workbook, short bgColor) {
    	CellStyle style = workbook.createCellStyle();

        style.setFillForegroundColor(bgColor);
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderTop(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);

        Font font = workbook.createFont();
        font.setBold(true);
        font.setColor(IndexedColors.WHITE.getIndex());
        style.setFont(font);

        return style;
    }
    
    private static CellStyle createTextStyle(Workbook workbook) {
        DataFormat format = workbook.createDataFormat();
        CellStyle style = workbook.createCellStyle();
        style.setDataFormat(format.getFormat(StringPool.AT)); // TEXT
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
