package com.ax.hrms.work.from.home.web.employee.dto;

public class DayInfo {
    public String date;
    public boolean isHalfDay;
    public boolean isFirstHalf;

    public DayInfo(String date, boolean isHalfDay, boolean isFirstHalf) {
        this.date = date;
        this.isHalfDay = isHalfDay;
        this.isFirstHalf = isFirstHalf;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isFirstHalf() {
        return isFirstHalf;
    }

    public void setFirstHalf(boolean firstHalf) {
        isFirstHalf = firstHalf;
    }

    public boolean isHalfDay() {
        return isHalfDay;
    }

    public void setHalfDay(boolean halfDay) {
        isHalfDay = halfDay;
    }
}