package ax.hrms.attendance.reconciliation.web.util;

import ax.hrms.attendance.reconciliation.web.dto.MissingAttendanceRecord;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class AttendanceExcelExportUtil {
	private AttendanceExcelExportUtil() {
		// prevents instantiation
	}
	private static final String COL_NO = "No.";
	private static final String COL_EMPLOYEE_CODE = "Employee ID";
	private static final String COL_EMPLOYEE_NAME = "Employee Name";
	private static final String COL_DATE = "Date";
	private static final String COL_REASON = "Reason";

	public static File generateMissingAttendanceExcelFile(List<MissingAttendanceRecord> records) {

		File tempFile = null;

		try (Workbook workbook = new XSSFWorkbook()) {

			tempFile = Files.createTempFile(
					"Missing_Attendance_Report",
					".xlsx"
			).toFile();

			Sheet sheet = workbook.createSheet("Missing Attendance");

			// Header Row
			Row headerRow = sheet.createRow(0);

			String[] headers = {
					COL_NO,
					COL_EMPLOYEE_CODE,
					COL_EMPLOYEE_NAME,
					COL_DATE,
					COL_REASON
			};

			for (int i = 0; i < headers.length; i++) {
				headerRow.createCell(i).setCellValue(headers[i]);
			}

			int rowIndex = 1;

			for (MissingAttendanceRecord missingAttendanceRecord : records) {

				Row row = sheet.createRow(rowIndex++);

				row.createCell(0).setCellValue(rowIndex - 1);

				if (missingAttendanceRecord.getEmployeeCode() != null) {
					row.createCell(1).setCellValue(missingAttendanceRecord.getEmployeeCode());
				}

				if (missingAttendanceRecord.getEmployeeName() != null) {
					row.createCell(2).setCellValue(missingAttendanceRecord.getEmployeeName());
				}

				if (missingAttendanceRecord.getDate() != null) {
					row.createCell(3).setCellValue(missingAttendanceRecord.getDate());
				}

				if (missingAttendanceRecord.getReason() != null) {
					row.createCell(4).setCellValue(missingAttendanceRecord.getReason());
				}
			}

			for (int i = 0; i < headers.length; i++) {
				sheet.autoSizeColumn(i);
			}

			try (FileOutputStream out = new FileOutputStream(tempFile)) {
				workbook.write(out);
			}

		} catch (IOException e) {
			_log.error("Error generating excel file for missing attendance", e);
		}

		return tempFile;
	}
	private static final Log _log = LogFactoryUtil.getLog(AttendanceExcelExportUtil.class);
}
