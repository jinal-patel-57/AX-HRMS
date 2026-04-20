package ax.hrms.attendance.reconciliation.web.util;

import ax.hrms.attendance.reconciliation.web.constants.AxHrmsAttendanceReconciliationWebPortletKeys;
import ax.hrms.attendance.reconciliation.web.dto.AttendanceRecord;
import ax.hrms.attendance.reconciliation.web.dto.MissingAttendanceRecord;

import com.ax.hrms.model.EmployeeDetails;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AttendanceValidationUtil {

	public static List<MissingAttendanceRecord> validateAttendance(
		Map<Long, Map<LocalDate, AttendanceRecord>> attendanceMap,
		Map<Long, EmployeeDetails> employeeMap, YearMonth yearMonth,
		Map<Long, Set<LocalDate>> leaveMap,
		Map<Long, Set<LocalDate>> wfhMap, Set<LocalDate> holidaySet,
		Set<String> skipEmployeeCodes) {

		List<MissingAttendanceRecord> missingAttendanceRecords =
			new ArrayList<>();
		List<LocalDate> workingDays = generateWorkingDays(yearMonth);
		_log.info(
			"AttendanceValidationUtil >> Month=" + yearMonth +
				", workingDays=" + workingDays.size() + ", employees=" +
				employeeMap.size());

		for (Map.Entry<Long, EmployeeDetails> employeeEntry :
				employeeMap.entrySet()) {

			Long employeeId = employeeEntry.getKey();
			EmployeeDetails employeeDetails = employeeEntry.getValue();
			
			if (skipEmployeeCodes != null && !skipEmployeeCodes.isEmpty()) {
				String lastName = employeeDetails.getLastName() != null ? employeeDetails.getLastName().trim().toLowerCase() : "";
				String empCode = employeeDetails.getEmployeeCode() != null ? employeeDetails.getEmployeeCode().trim().toLowerCase() : "";
				
				if ((!lastName.isEmpty() && skipEmployeeCodes.contains(lastName)) || 
					(!empCode.isEmpty() && skipEmployeeCodes.contains(empCode))) {
					_log.info("AttendanceValidationUtil >> Skipping requested HR employee code/lastName=" + lastName + " / " + empCode);
					continue;
				}
			}
			
			String employeeName = _getEmployeeName(employeeDetails);
			Map<LocalDate, AttendanceRecord> employeeAttendanceMap =
				attendanceMap.getOrDefault(employeeId, Collections.emptyMap());
			Set<LocalDate> leaveDates = leaveMap.getOrDefault(
				employeeId, Collections.emptySet());
			Set<LocalDate> wfhDates = wfhMap.getOrDefault(
				employeeId, Collections.emptySet());
			_log.info(
				"AttendanceValidationUtil >> Validating employeeId=" + employeeId +
					", employeeName=" + employeeName + ", attendanceDates=" +
					employeeAttendanceMap.keySet() + ", leaveDates=" + leaveDates +
					", wfhDates=" + wfhDates);

			for (LocalDate workingDay : workingDays) {
				if (!_isEmployeeActiveOnDate(employeeDetails, workingDay)) {
					_log.info(
						"AttendanceValidationUtil >> Skipping inactive date employeeId=" +
							employeeId + ", date=" + workingDay);
					continue;
				}

				if (holidaySet.contains(workingDay)) {
					_log.info(
						"AttendanceValidationUtil >> Skipping holiday employeeId=" +
							employeeId + ", date=" + workingDay);
					continue;
				}

				if (leaveDates.contains(workingDay)) {
					_log.info(
						"AttendanceValidationUtil >> Skipping leave employeeId=" +
							employeeId + ", date=" + workingDay);
					continue;
				}

				if (wfhDates.contains(workingDay)) {
					_log.info(
						"AttendanceValidationUtil >> Skipping wfh employeeId=" +
							employeeId + ", date=" + workingDay);
					continue;
				}

				AttendanceRecord attendanceRecord = employeeAttendanceMap.get(
					workingDay);
				String displayDate = DISPLAY_DATE_FORMATTER.format(workingDay);

				if (attendanceRecord == null) {
					_log.info(
						"AttendanceValidationUtil >> Marking Missing employeeId=" +
							employeeId + ", employeeName=" + employeeName +
							", date=" + workingDay +
							" because no attendance record exists in attendanceMap");
					missingAttendanceRecords.add(
						new MissingAttendanceRecord(
							employeeDetails.getEmployeeCode(), employeeName, displayDate,
							AxHrmsAttendanceReconciliationWebPortletKeys.
								REASON_MISSING_ATTENDANCE));

					continue;
				}

				if (isInvalidPunch(attendanceRecord.getFirstPunch())) {
					_log.info(
						"AttendanceValidationUtil >> Marking Invalid employeeId=" +
							employeeId + ", employeeName=" + employeeName +
							", date=" + workingDay + ", firstPunch=" +
							attendanceRecord.getFirstPunch());
					missingAttendanceRecords.add(
						new MissingAttendanceRecord(
							employeeDetails.getEmployeeCode(), employeeName, displayDate,
							AxHrmsAttendanceReconciliationWebPortletKeys.
								REASON_INVALID_ATTENDANCE));
				}
				else {
					_log.info(
						"AttendanceValidationUtil >> Attendance valid employeeId=" +
							employeeId + ", employeeName=" + employeeName +
							", date=" + workingDay + ", firstPunch=" +
							attendanceRecord.getFirstPunch());
				}
			}
		}

		return missingAttendanceRecords;
	}

	public static List<LocalDate> generateWorkingDays(YearMonth yearMonth) {
		List<LocalDate> workingDays = new ArrayList<>();

		if (yearMonth == null) {
			return workingDays;
		}

		LocalDate currentDate = yearMonth.atDay(1);
		LocalDate endDate = yearMonth.atEndOfMonth();

		while (!currentDate.isAfter(endDate)) {
			if (!isWeekend(currentDate)) {
				workingDays.add(currentDate);
			}

			currentDate = currentDate.plusDays(1);
		}

		return workingDays;
	}

	public static boolean isInvalidPunch(String firstPunch) {
		if (Validator.isNull(firstPunch)) {
			return true;
		}

		String value = firstPunch.trim();

		return value.isEmpty() || "00:00".equals(value) || "0:00".equals(value);
	}

	public static boolean isWeekend(LocalDate date) {
		if (date == null) {
			return false;
		}

		DayOfWeek dayOfWeek = date.getDayOfWeek();

		return dayOfWeek == DayOfWeek.SATURDAY ||
			dayOfWeek == DayOfWeek.SUNDAY;
	}

	private static String _getEmployeeName(EmployeeDetails employeeDetails) {
		if (employeeDetails == null) {
			return "Unknown";
		}

		String firstName = Validator.isNotNull(employeeDetails.getFirstName()) ?
			employeeDetails.getFirstName().trim() : "";
		String lastName = Validator.isNotNull(employeeDetails.getLastName()) ?
			employeeDetails.getLastName().trim() : "";

		return (firstName + " " + lastName).trim();
	}

	private static boolean _isEmployeeActiveOnDate(
		EmployeeDetails employeeDetails, LocalDate localDate) {

		if (employeeDetails == null || localDate == null) {
			return false;
		}

		if (employeeDetails.getJoiningDate() != null) {
			LocalDate joiningDate = employeeDetails.getJoiningDate().toInstant(
			).atZone(
				ZoneId.systemDefault()
			).toLocalDate();

			if (localDate.isBefore(joiningDate)) {
				return false;
			}
		}

		if (employeeDetails.getLeavingDate() != null) {
			LocalDate leavingDate = employeeDetails.getLeavingDate().toInstant(
			).atZone(
				ZoneId.systemDefault()
			).toLocalDate();

			if (localDate.isAfter(leavingDate)) {
				return false;
			}
		}

		return true;
	}

	private static final DateTimeFormatter DISPLAY_DATE_FORMATTER =
		DateTimeFormatter.ofPattern("dd-MM-yyyy");

	private static final Log _log = LogFactoryUtil.getLog(
		AttendanceValidationUtil.class);

}
