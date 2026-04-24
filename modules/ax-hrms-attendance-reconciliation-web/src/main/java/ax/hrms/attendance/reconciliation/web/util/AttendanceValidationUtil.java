package ax.hrms.attendance.reconciliation.web.util;

import ax.hrms.attendance.reconciliation.web.constants.AxHrmsAttendanceReconciliationWebPortletKeys;
import ax.hrms.attendance.reconciliation.web.dto.AttendanceRecord;
import ax.hrms.attendance.reconciliation.web.dto.MissingAttendanceRecord;

import com.ax.hrms.model.EmployeeDetails;

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


	private AttendanceValidationUtil() {
		// prevents instantiation
	}

	// ========================= CONTEXT OBJECTS =========================

	private static class EmployeeContext {
		Long employeeId;
		EmployeeDetails employeeDetails;
		Map<LocalDate, AttendanceRecord> attendanceMap;

		EmployeeContext(Long employeeId,
		                EmployeeDetails employeeDetails,
		                Map<LocalDate, AttendanceRecord> attendanceMap) {
			this.employeeId = employeeId;
			this.employeeDetails = employeeDetails;
			this.attendanceMap = attendanceMap;
		}
	}

	private static class RuleContext {
		Set<LocalDate> leaveDates;
		Set<LocalDate> wfhDates;
		Set<LocalDate> holidaySet;
		List<LocalDate> workingDays;
		List<MissingAttendanceRecord> missingAttendanceRecords;

		RuleContext(Set<LocalDate> leaveDates,
		            Set<LocalDate> wfhDates,
		            Set<LocalDate> holidaySet,
		            List<LocalDate> workingDays,
		            List<MissingAttendanceRecord> missingAttendanceRecords) {
			this.leaveDates = leaveDates;
			this.wfhDates = wfhDates;
			this.holidaySet = holidaySet;
			this.workingDays = workingDays;
			this.missingAttendanceRecords = missingAttendanceRecords;
		}
	}

	// ========================= MAIN METHOD =========================

	public static List<MissingAttendanceRecord> validateAttendance(
			Map<Long, Map<LocalDate, AttendanceRecord>> attendanceMap,
			Map<Long, EmployeeDetails> employeeMap,
			YearMonth yearMonth,
			Map<Long, Set<LocalDate>> leaveMap,
			Map<Long, Set<LocalDate>> wfhMap,
			Set<LocalDate> holidaySet,
			Set<String> skipEmployeeCodes) {

		List<MissingAttendanceRecord> result = new ArrayList<>();
		List<LocalDate> workingDays = generateWorkingDays(yearMonth);

		for (Map.Entry<Long, EmployeeDetails> entry : employeeMap.entrySet()) {

			Long employeeId = entry.getKey();
			EmployeeDetails employeeDetails = entry.getValue();

			if (shouldSkipEmployee(employeeDetails, skipEmployeeCodes)) {
				continue;
			}

			Set<LocalDate> leaveDates =
					leaveMap.getOrDefault(employeeId, Collections.emptySet());

			Set<LocalDate> wfhDates =
					wfhMap.getOrDefault(employeeId, Collections.emptySet());

			EmployeeContext empCtx = new EmployeeContext(
					employeeId,
					employeeDetails,
					attendanceMap.getOrDefault(employeeId, Collections.emptyMap())
			);

			RuleContext ruleCtx = new RuleContext(
					leaveDates,
					wfhDates,
					holidaySet,
					workingDays,
					result
			);

			processEmployeeAttendance(empCtx, ruleCtx);
		}

		return result;
	}

	// ========================= PROCESSING =========================

	private static void processEmployeeAttendance(EmployeeContext emp,
	                                              RuleContext rule) {

		String employeeName = getEmployeeName(emp.employeeDetails);

		for (LocalDate workingDay : rule.workingDays) {

			if (shouldSkipDay(
					emp.employeeDetails,
					workingDay,
					rule.holidaySet,
					rule.leaveDates,
					rule.wfhDates)) {
				continue;
			}

			validateDay(
					workingDay,
					emp.employeeDetails,
					employeeName,
					emp.attendanceMap,
					rule.missingAttendanceRecords
			);
		}
	}

	// ========================= BUSINESS RULES =========================

	private static boolean shouldSkipEmployee(EmployeeDetails employeeDetails,
	                                          Set<String> skipEmployeeCodes) {

		if (skipEmployeeCodes == null || skipEmployeeCodes.isEmpty()) {
			return false;
		}

		String lastName = employeeDetails.getLastName() != null
				? employeeDetails.getLastName().trim().toLowerCase()
				: "";

		String empCode = employeeDetails.getEmployeeCode() != null
				? employeeDetails.getEmployeeCode().trim().toLowerCase()
				: "";

		return (!lastName.isEmpty() && skipEmployeeCodes.contains(lastName)) ||
				(!empCode.isEmpty() && skipEmployeeCodes.contains(empCode));
	}

	private static boolean shouldSkipDay(EmployeeDetails employeeDetails,
	                                     LocalDate workingDay,
	                                     Set<LocalDate> holidaySet,
	                                     Set<LocalDate> leaveDates,
	                                     Set<LocalDate> wfhDates) {

		return !isEmployeeActiveOnDate(employeeDetails, workingDay) ||
				holidaySet.contains(workingDay) ||
				leaveDates.contains(workingDay) ||
				wfhDates.contains(workingDay);
	}

	private static void validateDay(LocalDate workingDay,
	                                EmployeeDetails employeeDetails,
	                                String employeeName,
	                                Map<LocalDate, AttendanceRecord> attendanceMap,
	                                List<MissingAttendanceRecord> result) {

		AttendanceRecord attendanceRecord = attendanceMap.get(workingDay);
		String displayDate = DISPLAY_DATE_FORMATTER.format(workingDay);

		if (attendanceRecord == null) {
			result.add(new MissingAttendanceRecord(
					employeeDetails.getEmployeeCode(),
					employeeName,
					displayDate,
					AxHrmsAttendanceReconciliationWebPortletKeys.REASON_MISSING_ATTENDANCE
			));
		} else if (isInvalidPunch(attendanceRecord.getFirstPunch())) {
			result.add(new MissingAttendanceRecord(
					employeeDetails.getEmployeeCode(),
					employeeName,
					displayDate,
					AxHrmsAttendanceReconciliationWebPortletKeys.REASON_INVALID_ATTENDANCE
			));
		}
	}

	// ========================= UTILITIES =========================

	public static List<LocalDate> generateWorkingDays(YearMonth yearMonth) {

		List<LocalDate> workingDays = new ArrayList<>();

		if (yearMonth == null) {
			return workingDays;
		}

		LocalDate current = yearMonth.atDay(1);
		LocalDate end = yearMonth.atEndOfMonth();

		while (!current.isAfter(end)) {
			if (!isWeekend(current)) {
				workingDays.add(current);
			}
			current = current.plusDays(1);
		}

		return workingDays;
	}

	public static boolean isInvalidPunch(String punch) {

		if (Validator.isNull(punch)) {
			return true;
		}

		String value = punch.trim();

		return value.isEmpty()
				|| "00:00".equals(value)
				|| "0:00".equals(value);
	}

	public static boolean isWeekend(LocalDate date) {

		if (date == null) {
			return false;
		}

		DayOfWeek d = date.getDayOfWeek();

		return d == DayOfWeek.SATURDAY || d == DayOfWeek.SUNDAY;
	}

	private static String getEmployeeName(EmployeeDetails details) {

		if (details == null) {
			return "Unknown";
		}

		String first = Validator.isNotNull(details.getFirstName())
				? details.getFirstName().trim()
				: "";

		String last = Validator.isNotNull(details.getLastName())
				? details.getLastName().trim()
				: "";

		return (first + " " + last).trim();
	}

	private static boolean isEmployeeActiveOnDate(EmployeeDetails details,
	                                              LocalDate date) {

		if (details == null || date == null) {
			return false;
		}

		if (details.getJoiningDate() != null) {

			LocalDate join = details.getJoiningDate()
					.toInstant()
					.atZone(ZoneId.systemDefault())
					.toLocalDate();

			if (date.isBefore(join)) {
				return false;
			}
		}

		if (details.getLeavingDate() != null) {

			LocalDate leave = details.getLeavingDate()
					.toInstant()
					.atZone(ZoneId.systemDefault())
					.toLocalDate();

			if (date.isAfter(leave)) {
				return false;
			}
		}

		return true;
	}

	// ========================= FORMATTER =========================

	private static final DateTimeFormatter DISPLAY_DATE_FORMATTER =
			DateTimeFormatter.ofPattern("dd-MM-yyyy");
}