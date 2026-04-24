package ax.hrms.attendance.reconciliation.web.util;

import ax.hrms.attendance.reconciliation.web.dto.AttendanceRecord;

import com.ax.hrms.common.api.api.AxHrmsCommonApi;
import com.ax.hrms.model.EmployeeDetails;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

import java.io.InputStream;
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

	private ExcelParserUtil() {
		// utility class
	}

	// ========================= MAIN METHOD =========================

	public static List<AttendanceRecord> parseAttendanceExcel(
			InputStream inputStream,
			String fileName,
			AxHrmsCommonApi commonApi,
			Map<String, Long> employeeCodeToIdMap,
			Map<Long, EmployeeDetails> employeeMap) {

		List<AttendanceRecord> records = new ArrayList<>();

		try (Workbook workbook = commonApi.getWorkbook(inputStream, fileName)) {

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

			HeaderInfo headerInfo = detectHeader(excelDataMap);

			if (headerInfo == null) {
				_log.info("Header row not detected in first 10 rows");
				return records;
			}

			processRows(
					excelDataMap,
					headerInfo,
					employeeCodeToIdMap,
					employeeMap,
					records
			);

		} catch (Exception e) {
			_log.error("Error parsing attendance file", e);
		}

		return records;
	}

	// ========================= HEADER DETECTION =========================

	private static HeaderInfo detectHeader(
			Map<String, Map<String, Object>> excelDataMap) {

		for (int i = 0; i <= 10; i++) {

			Map<String, Object> rowData = excelDataMap.get(String.valueOf(i));

			if (rowData == null) {
				continue;
			}

			Map<String, Integer> columnMap = detectHeaderColumns(rowData);

			if (columnMap != null) {
				_log.info("Header detected at row " + i + " " + columnMap);
				return new HeaderInfo(i, columnMap);
			}
		}

		return null;
	}

	private static Map<String, Integer> detectHeaderColumns(
			Map<String, Object> rowData) {

		Map<String, Integer> columnMap = new HashMap<>();
		boolean hasEmployeeCode = false;
		boolean hasDate = false;

		for (Map.Entry<String, Object> entry : rowData.entrySet()) {

			Integer index = parseIntSafe(entry.getKey());

			if (index == null || entry.getValue() == null) {
				continue;
			}

			String header = entry.getValue().toString().trim();

			switch (header) {

				case "Employee ID", "Last Name" -> {
					columnMap.put(COL_EMPLOYEE_CODE, index);
					hasEmployeeCode = true;
				}

				case "First Name" ->
						columnMap.put(COL_EMPLOYEE_NAME, index);

				case "Date" -> {
					columnMap.put(COL_DATE, index);
					hasDate = true;
				}

				case "First Punch" ->
						columnMap.put(COL_FIRST_PUNCH, index);

				case "Last Punch" ->
						columnMap.put(COL_LAST_PUNCH, index);

				case "Total Time" ->
						columnMap.put(COL_TOTAL_TIME, index);

				default ->
						_log.debug("Unknown header ignored: " + header);
			}
		}

		return (hasEmployeeCode && hasDate) ? columnMap : null;
	}

	// ========================= ROW PROCESSING =========================

	private static void processRows(
			Map<String, Map<String, Object>> excelDataMap,
			HeaderInfo headerInfo,
			Map<String, Long> employeeCodeToIdMap,
			Map<Long, EmployeeDetails> employeeMap,
			List<AttendanceRecord> records) {

		int headerRowIndex = headerInfo.headerRowIndex;

		for (Map.Entry<String, Map<String, Object>> entry : excelDataMap.entrySet()) {

			Integer rowIndex = parseIntSafe(entry.getKey());

			if (rowIndex == null || rowIndex <= headerRowIndex) {
				continue;
			}

			AttendanceRecord attendanceRecord = mapRowToAttendanceRecord(
					entry.getValue(),
					headerInfo.columnMap,
					employeeCodeToIdMap,
					employeeMap
			);

			if (attendanceRecord != null) {
				records.add(attendanceRecord);
			}
		}
	}

	// ========================= MAPPING =========================

	private static AttendanceRecord mapRowToAttendanceRecord(
			Map<String, Object> rowData,
			Map<String, Integer> columnMap,
			Map<String, Long> employeeCodeToIdMap,
			Map<Long, EmployeeDetails> employeeMap) {

		if (rowData == null || rowData.isEmpty()) {
			return null;
		}

		Integer empCol = columnMap.get(COL_EMPLOYEE_CODE);
		Integer dateCol = columnMap.get(COL_DATE);

		if (empCol == null || dateCol == null) {
			return null;
		}

		String employeeCode = getCellValueAsString(
				rowData.get(String.valueOf(empCol))
		).trim();

		if (Validator.isNull(employeeCode)) {
			return null;
		}

		LocalDate date = parseDate(rowData.get(String.valueOf(dateCol)));

		if (date == null) {
			return null;
		}

		AttendanceRecord attendanceRecord = new AttendanceRecord();

		attendanceRecord.setEmployeeCode(employeeCode);
		attendanceRecord.setEmployeeId(employeeCodeToIdMap.get(employeeCode));
		attendanceRecord.setDate(date);

		attendanceRecord.setFirstPunch(getColumnValue(rowData, columnMap.get(COL_FIRST_PUNCH)));
		attendanceRecord.setLastPunch(getColumnValue(rowData, columnMap.get(COL_LAST_PUNCH)));
		attendanceRecord.setTotalTime(getColumnValue(rowData, columnMap.get(COL_TOTAL_TIME)));

		if (attendanceRecord.getEmployeeId() != null) {
			attendanceRecord.setEmployeeName(getEmployeeName(
					employeeMap.get(attendanceRecord.getEmployeeId())
			));
		}

		if (Validator.isNull(attendanceRecord.getEmployeeName())) {
			attendanceRecord.setEmployeeName(
					getColumnValue(rowData, columnMap.get(COL_EMPLOYEE_NAME))
			);
		}

		return attendanceRecord;
	}

	// ========================= HELPERS =========================

	private static Integer parseIntSafe(String value) {
		try {
			return Integer.parseInt(value);
		} catch (Exception e) {
			return null;
		}
	}

	private static String getColumnValue(
			Map<String, Object> rowData,
			Integer index) {

		if (index == null) {
			return "";
		}

		return getCellValueAsString(rowData.get(String.valueOf(index)));
	}

	private static String getCellValueAsString(Object value) {

		if (value == null) {
			return "";
		}

		if (value instanceof Double d) {

			if (d == Math.floor(d) && !Double.isInfinite(d)) {
				return String.valueOf(d.longValue());
			}

			return String.valueOf(d);
		}

		if (value instanceof Date date) {
			return new java.text.SimpleDateFormat("HH:mm").format(date);
		}

		return value.toString().trim();
	}

	private static LocalDate parseDate(Object value) {

		if (value == null) {
			return null;
		}

		if (value instanceof Date date) {
			return date.toInstant()
					.atZone(ZoneId.systemDefault())
					.toLocalDate();
		}

		String str = value.toString().trim();

		if (Validator.isNull(str)) {
			return null;
		}

		String[] formats = {
				"dd-MM-yyyy", "yyyy-MM-dd", "MM/dd/yyyy", "dd/MM/yyyy"
		};

		for (String f : formats) {
			try {
				java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(f);
				sdf.setLenient(false);

				return sdf.parse(str)
						.toInstant()
						.atZone(ZoneId.systemDefault())
						.toLocalDate();

			} catch (Exception ignored) {
				// keep trying
			}
		}

		return null;
	}

	private static String getEmployeeName(EmployeeDetails details) {

		if (details == null) {
			return "";
		}

		String first = Validator.isNotNull(details.getFirstName())
				? details.getFirstName().trim()
				: "";

		String last = Validator.isNotNull(details.getLastName())
				? details.getLastName().trim()
				: "";

		return (first + " " + last).trim();
	}

	// ========================= CONSTANTS =========================

	private static final String COL_DATE = "DATE";
	private static final String COL_EMPLOYEE_CODE = "EMPLOYEE_CODE";
	private static final String COL_EMPLOYEE_NAME = "EMPLOYEE_NAME";
	private static final String COL_FIRST_PUNCH = "FIRST_PUNCH";
	private static final String COL_LAST_PUNCH = "LAST_PUNCH";
	private static final String COL_TOTAL_TIME = "TOTAL_TIME";

	private static final Log _log = LogFactoryUtil.getLog(ExcelParserUtil.class);

	// ========================= HELPER CLASS =========================

	private static class HeaderInfo {
		int headerRowIndex;
		Map<String, Integer> columnMap;

		HeaderInfo(int headerRowIndex, Map<String, Integer> columnMap) {
			this.headerRowIndex = headerRowIndex;
			this.columnMap = columnMap;
		}
	}
}