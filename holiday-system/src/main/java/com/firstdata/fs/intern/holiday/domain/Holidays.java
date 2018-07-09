package com.firstdata.fs.intern.holiday.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Holidays {

    private boolean isValid = false; // Tells the HolidayService class if the holiday was correct

    // Constructor which books the holiday by adding the dates to the employee
    public Holidays(Employee employee, Date[] holidayDates) {
        if (bookHoliday(employee, holidayDates)) {
            isValid = true;
        } else {
            isValid = false;
        }
    }

    // Adds the holiday to the user profile
    private boolean bookHoliday(Employee employee, Date[] dates) {
        try {
            Date[] newDatesArray = new Date[dates.length + employee.getHolidayDates().length];
            List<Date> tempCombineList = new ArrayList<Date>(Arrays.asList(employee.getHolidayDates()));
            tempCombineList.addAll(Arrays.asList(dates));
            newDatesArray = (Date[]) tempCombineList.toArray();
            employee.setHolidayDates(newDatesArray);
            return true;
        }catch(ClassCastException exception) {
            return false;
        }
    }

    // Getter for isValid
    public boolean getIsValid() {
        return isValid;
    }
}
