package ax.hrms.attendance.reconciliation.web.util;

import ax.hrms.attendance.reconciliation.web.dto.AttendanceRecord;

import com.ax.hrms.common.api.api.AxHrmsCommonApi;
import com.ax.hrms.model.EmployeeDetails;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ExcelParserUtil {

	public static List<AttendanceRecord> parseAttendanceExcel(
		InputStream inputStream, String fileName, AxHrmsCommonApi commonApi,
		Map<String, Long> employeeCodeToIdMap,
		Map<Long, EmployeeDetails> employeeMap) {

		List<AttendanceRecord> records = new ArrayList<>();
		Workbook workbook = null;

		try {
			workbook = commonApi.getWorkbook(inputStream, fileName);

			if (workbook == null) {
				return records;
			}

			Sheet sheet = workbook.getSheetAt(0);

			if (sheet == null) {
				return records;
			}

			Map<String, Map<String, Object>> excelDataMap =
				commonApi.readExcelSheet(sheet);

			if (excelDataMap == null || excelDataMap.isEmpty()) {
				return records;
			}

			String headerRowKey = null;
			Map<String, Integer> columnMap = null;

			for (int rowIndex = 0; rowIndex <= 10; rowIndex++) {
				Map<String, Object> rowData = excelDataMap.get(
					String.valueOf(rowIndex));

				if (rowData == null) {
					continue;
				}

				columnMap = _detectHeaderColumns(rowData);

				if (columnMap != null) {
					headerRowKey = String.valueOf(rowIndex);
					_log.info(
						"ExcelParserUtil >> Header detected at row " + rowIndex +
							" with columns " + columnMap);

					break;
				}
			}

			if (columnMap == null || headerRowKey == null) {
				_log.info(
					"ExcelParserUtil >> Header row not detected in first 10 rows");
				return records;
			}

			int headerRowIndex = Integer.parseInt(headerRowKey);

			for (Map.Entry<String, Map<String, Object>> rowEntry :
					excelDataMap.entrySet()) {

				int rowIndex;

				try {
					rowIndex = Integer.parseInt(rowEntry.getKey());
				}
				catch (NumberFormatException numberFormatException) {
					continue;
				}

				if (rowIndex <= headerRowIndex) {
					continue;
				}

				AttendanceRecord attendanceRecord = _mapRowToAttendanceRecord(
					rowEntry.getValue(), columnMap, employeeCodeToIdMap,
					employeeMap);

				if (attendanceRecord != null) {
					records.add(attendanceRecord);
					_log.info(
						"ExcelParserUtil >> Parsed row " + rowIndex +
							" employeeCode=" + attendanceRecord.getEmployeeCode() +
							", employeeId=" + attendanceRecord.getEmployeeId() +
							", date=" + attendanceRecord.getDate() +
							", firstPunch=" + attendanceRecord.getFirstPunch());
				}
				else {
					_log.info(
						"ExcelParserUtil >> Row " + rowIndex +
							" skipped because AttendanceRecord is null");
				}
			}
		}
		catch (Exception exception) {
			_log.error("ExcelParserUtil >> Error parsing attendance file", exception);
		}
		finally {
			if (workbook != null) {
				try {
					workbook.close();
				}
				catch (Exception exception) {
					_log.error("ExcelParserUtil >> Error closing workbook", exception);
				}
			}
		}

		return records;
	}

	private static Map<String, Integer> _detectHeaderColumns(
			Map<String, Object> rowData) {

		Map<String, Integer> columnMap = new HashMap<>();
		boolean hasEmployeeCode = false;
		boolean hasDate = false;

		for (Map.Entry<String, Object> cellEntry : rowData.entrySet()) {
			int columnIndex;

			try {
				columnIndex = Integer.parseInt(cellEntry.getKey());
			}
			catch (NumberFormatException numberFormatException) {
				continue;
			}

			Object cellValue = cellEntry.getValue();

			if (cellValue == null) {
				continue;
			}

			String header = cellValue.toString().trim();

			switch (header) {

				case "Employee ID":
					columnMap.put(COL_EMPLOYEE_CODE, columnIndex);
					hasEmployeeCode = true;
					break;

				case "Last Name":
					columnMap.put(COL_EMPLOYEE_CODE, columnIndex);
					hasEmployeeCode = true;
					break;

				case "First Name":
					columnMap.put(COL_EMPLOYEE_NAME, columnIndex);
					break;

				case "Date":
					columnMap.put(COL_DATE, columnIndex);
					hasDate = true;
					break;

				case "First Punch":
					columnMap.put(COL_FIRST_PUNCH, columnIndex);
					break;

				case "Last Punch":
					columnMap.put(COL_LAST_PUNCH, columnIndex);
					break;

				case "Total Time":
					columnMap.put(COL_TOTAL_TIME, columnIndex);
					break;
			}
		}

		if (hasEmployeeCode && hasDate) {
			return columnMap;
		}

		return null;
	}

	private static String _getCellValueAsString(Object cellValue) {
		if (cellValue == null) {
			return "";
		}

		if (cellValue instanceof Double) {
			double value = (Double)cellValue;

			if (value == Math.floor(value) && !Double.isInfinite(value)) {
				return String.valueOf((long)value);
			}

			return String.valueOf(value);
		}

		if (cellValue instanceof Date) {
			return new SimpleDateFormat("HH:mm").format((Date)cellValue);
		}

		return cellValue.toString().trim();
	}

	private static String _getEmployeeName(EmployeeDetails employeeDetails) {
		if (employeeDetails == null) {
			return "";
		}

		String firstName = Validator.isNotNull(employeeDetails.getFirstName()) ?
			employeeDetails.getFirstName().trim() : "";
		String lastName = Validator.isNotNull(employeeDetails.getLastName()) ?
			employeeDetails.getLastName().trim() : "";

		return (firstName + " " + lastName).trim();
	}

	private static AttendanceRecord _mapRowToAttendanceRecord(
		Map<String, Object> rowData, Map<String, Integer> columnMap,
		Map<String, Long> employeeCodeToIdMap,
		Map<Long, EmployeeDetails> employeeMap) {

		if (rowData == null || rowData.isEmpty()) {
			return null;
		}

		Integer employeeCodeColumn = columnMap.get(COL_EMPLOYEE_CODE);
		Integer dateColumn = columnMap.get(COL_DATE);

		if (employeeCodeColumn == null || dateColumn == null) {
			return null;
		}

		String employeeCode = _getCellValueAsString(
			rowData.get(String.valueOf(employeeCodeColumn))).trim();

		if (Validator.isNull(employeeCode)) {
			_log.info("ExcelParserUtil >> employeeCode is blank, skipping row");
			return null;
		}

		LocalDate attendanceDate = _parseDate(
			rowData.get(String.valueOf(dateColumn)));

		if (attendanceDate == null) {
			_log.warn(
				"ExcelParserUtil >> Skipping row because date is invalid for employee code " +
					employeeCode);

			return null;
		}

		AttendanceRecord attendanceRecord = new AttendanceRecord();

		attendanceRecord.setEmployeeCode(employeeCode);
		attendanceRecord.setEmployeeId(employeeCodeToIdMap.get(employeeCode));
		attendanceRecord.setDate(attendanceDate);
		attendanceRecord.setFirstPunch(
			_getColumnValue(rowData, columnMap.get(COL_FIRST_PUNCH)));
		attendanceRecord.setLastPunch(
			_getColumnValue(rowData, columnMap.get(COL_LAST_PUNCH)));
		attendanceRecord.setTotalTime(
			_getColumnValue(rowData, columnMap.get(COL_TOTAL_TIME)));

		if (attendanceRecord.getEmployeeId() != null) {
			attendanceRecord.setEmployeeName(
				_getEmployeeName(employeeMap.get(attendanceRecord.getEmployeeId())));
		}

		if (Validator.isNull(attendanceRecord.getEmployeeName())) {
			attendanceRecord.setEmployeeName(
				_getColumnValue(rowData, columnMap.get(COL_EMPLOYEE_NAME)));
		}

		if (attendanceRecord.getEmployeeId() == null) {
			_log.info(
				"ExcelParserUtil >> Employee code not found in system: " +
					employeeCode + ", employeeNameFromExcel=" +
					attendanceRecord.getEmployeeName() + ", date=" +
					attendanceRecord.getDate());
		}
		else {
			_log.info(
				"ExcelParserUtil >> Employee code matched: " + employeeCode +
					" -> employeeId=" + attendanceRecord.getEmployeeId() +
					", employeeName=" + attendanceRecord.getEmployeeName());
		}

		return attendanceRecord;
	}

	private static String _getColumnValue(
		Map<String, Object> rowData, Integer columnIndex) {

		if (columnIndex == null) {
			return "";
		}

		return _getCellValueAsString(rowData.get(String.valueOf(columnIndex)));
	}

	private static LocalDate _parseDate(Object dateValue) {
		if (dateValue == null) {
			return null;
		}

		if (dateValue instanceof Date) {
			return ((Date)dateValue).toInstant(
			).atZone(
				ZoneId.systemDefault()
			).toLocalDate();
		}

		String dateString = dateValue.toString().trim();

		if (Validator.isNull(dateString)) {
			return null;
		}

		String[] supportedFormats = {
			"dd-MM-yyyy", "yyyy-MM-dd", "MM/dd/yyyy", "dd/MM/yyyy"
		};

		for (String supportedFormat : supportedFormats) {
			try {
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
					supportedFormat);

				simpleDateFormat.setLenient(false);

				return simpleDateFormat.parse(
					dateString
				).toInstant(
				).atZone(
					ZoneId.systemDefault()
				).toLocalDate();
			}
			catch (Exception exception) {
			}
		}

		return null;
	}

	private static final String COL_DATE = "DATE";
	private static final String COL_EMPLOYEE_CODE = "EMPLOYEE_CODE";
	private static final String COL_EMPLOYEE_NAME = "EMPLOYEE_NAME";
	private static final String COL_FIRST_PUNCH = "FIRST_PUNCH";
	private static final String COL_LAST_PUNCH = "LAST_PUNCH";
	private static final String COL_TOTAL_TIME = "TOTAL_TIME";

	private static final Log _log = LogFactoryUtil.getLog(
		ExcelParserUtil.class);

}
