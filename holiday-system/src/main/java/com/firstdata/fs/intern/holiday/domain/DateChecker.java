package com.firstdata.fs.intern.holiday.domain;

import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;

public class DateChecker {

    private boolean isValid = false;
    private Date[] HOLIDAY_DATES = new Date[10];

    public DateChecker() {
        // default constructor not used;
        holidayInitializer();
    }

    public DateChecker(Date[] d) {
        // constructor for multiple date objects
        holidayInitializer();
        // for dates in between
        ArrayList<Date> datesInBetween = getAllBetweenDates(d[0], d[1]);
        for (Date day : datesInBetween) {
            if (checkDate(day)) {
                isValid = true;
            } else {
                isValid = false;
                break;
            }
        }
    }

    public DateChecker(Date d) {
        // constructor for one date object
        holidayInitializer();
        if (checkDate(d)) {
            isValid = true;
        } else {
            isValid = false;
        }
    }

    private void holidayInitializer() {
        // Long way because of depreciation
        // Below are example dates, more can be added to this.
        // Christmas Eve
        Calendar tempCalendar = Calendar.getInstance();
        tempCalendar.set(Calendar.YEAR, 2018);
        tempCalendar.set(Calendar.MONTH, Calendar.DECEMBER);
        tempCalendar.set(Calendar.DAY_OF_MONTH, 24);
        Date christmasEve = tempCalendar.getTime();
        // Christmas Day
        tempCalendar.set(Calendar.YEAR, 2018);
        tempCalendar.set(Calendar.MONTH, Calendar.DECEMBER);
        tempCalendar.set(Calendar.DAY_OF_MONTH, 25);
        Date christmasDay = tempCalendar.getTime();
        // Adds all to Date [] HOLIDAY_DATES
        HOLIDAY_DATES[0] = christmasEve;
        HOLIDAY_DATES[1] = christmasDay;
    }

    private boolean checkDate(Date d) {
        // Sends date object through two methods, checkHoliday and checkWeekend
        // If either return false, this function will return false
        if (checkHoliday(d) && checkWeekend(d)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean checkHoliday(Date d) {
        /*
         * Goes through HOLIDAY_DATES and compares with argument to make sure booking is
         * not on a holiday. If holiday, will return false.
         */
        for (Date day : HOLIDAY_DATES) {
            if (day == d) {
                return false;
            }
        }
        return true;
    }

    private boolean checkWeekend(Date d) {
        // This will compare the argument day to the weekend. If weekend, will return
        // false.
        Calendar checkCalendar = Calendar.getInstance();
        checkCalendar.setTime(d);
        int day = checkCalendar.get(Calendar.DAY_OF_WEEK);
        if (day == Calendar.SATURDAY || day == Calendar.SUNDAY) {
            return false;
        } else {
            return true;
        }
    }

    private ArrayList<Date> getAllBetweenDates(Date startDate, Date endDate) {
        // This takes a start date and end date. This will return an array of dates in
        // between.
        ArrayList<Date> betweenDates = new ArrayList<Date>(); // can change for higher memory allocation
        Calendar firstCalendar = Calendar.getInstance();
        firstCalendar.setTime(startDate);
        Calendar endCalendar = Calendar.getInstance();
        endCalendar.setTime(endDate);
        int i = 0;
        while (firstCalendar.before(endCalendar)) {
            Date tempDate = firstCalendar.getTime();
            betweenDates.add(tempDate);
            firstCalendar.add(Calendar.DATE, 1);
            i = i + 1;
        }
        return betweenDates;
    }

    public boolean isValid() {
        // Getter
        return isValid;
    }

}
