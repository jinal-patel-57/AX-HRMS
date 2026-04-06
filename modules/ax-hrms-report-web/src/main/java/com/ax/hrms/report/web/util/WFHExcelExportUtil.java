package com.ax.hrms.report.web.util;

import com.ax.hrms.report.web.constants.AxHrmsWorkFromHomeReportWebPortletKeys;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.portlet.ResourceResponse;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

public class WFHExcelExportUtil {
	
	private static final Log log = LogFactoryUtil.getLog(WFHExcelExportUtil.class);
	
    public static void exportWFHReport(
            List<Map<String, String>> data,
            ResourceResponse response,
            String fileName) throws Exception {

        Workbook workbook = new XSSFWorkbook();
        OutputStream os = response.getPortletOutputStream();
        try {
        	Sheet sheet = workbook.createSheet(AxHrmsWorkFromHomeReportWebPortletKeys.SHEET_NAME);
        	// Freeze first 3 columns and header row
        	sheet.createFreezePane(3, 1);
        	String[] headers = {
        			AxHrmsWorkFromHomeReportWebPortletKeys.EMPLOYEE_CODE,
        			AxHrmsWorkFromHomeReportWebPortletKeys.EMPLOYEE_NAME,
        			AxHrmsWorkFromHomeReportWebPortletKeys.EMPLOYEE_EMAIL,
        			AxHrmsWorkFromHomeReportWebPortletKeys.DEPARTMENT,
        			AxHrmsWorkFromHomeReportWebPortletKeys.DESIGNATION,
        			AxHrmsWorkFromHomeReportWebPortletKeys.MANAGER,
        			AxHrmsWorkFromHomeReportWebPortletKeys.LOCATION,
        			AxHrmsWorkFromHomeReportWebPortletKeys.EMPLOYEE_TYPE,
        			AxHrmsWorkFromHomeReportWebPortletKeys.LEAVE_PERIOD,
        			AxHrmsWorkFromHomeReportWebPortletKeys.NO_OF_DAYS,
        			AxHrmsWorkFromHomeReportWebPortletKeys.STATUS,
        			AxHrmsWorkFromHomeReportWebPortletKeys.DATE_OF_REQUEST,
        			AxHrmsWorkFromHomeReportWebPortletKeys.ACTION_BY,
        			AxHrmsWorkFromHomeReportWebPortletKeys.ACTION_ON,
        			AxHrmsWorkFromHomeReportWebPortletKeys.REASON
        	};
        	
        	CellStyle headerStyle = workbook.createCellStyle();
        	Font font = workbook.createFont();
        	font.setBold(true);
        	headerStyle.setFont(font);
        	
        	Row headerRow = sheet.createRow(0);
        	
        	for (int i = 0; i < headers.length; i++) {
        		Cell cell = headerRow.createCell(i);
        		cell.setCellValue(headers[i]);
        		cell.setCellStyle(headerStyle);
        	}
        	
        	int rowNum = 1;
        	
        	for (Map<String, String> rowData : data) {
        		Row row = sheet.createRow(rowNum++);
        		int col = 0;
        		
        		for (String header : headers) {
        			row.createCell(col++).setCellValue(rowData.getOrDefault(header, ""));
        		}
        	}
        	
        	for (int i = 0; i < headers.length; i++) {
        		sheet.autoSizeColumn(i);
        	}
        	
        	response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        	response.setProperty("Content-Disposition", "attachment; filename=\"" + fileName + ".xlsx\"");
        	workbook.write(os);
		} catch (Exception e) {
			log.error("Error while exporting WFH report: " + e.getMessage(), e);
		} finally {
			workbook.close();
			os.close();
		}
    }
}
