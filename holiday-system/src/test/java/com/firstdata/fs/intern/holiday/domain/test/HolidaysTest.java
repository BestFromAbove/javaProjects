package com.firstdata.fs.intern.holiday.domain.test;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import com.firstdata.fs.intern.holiday.domain.Employee;
import com.firstdata.fs.intern.holiday.domain.Holidays;

public class HolidaysTest {
    
    public HolidaysTest() {
        
    }

    // Create a test date array for testing
    private Date[] setUpDates() {
        Date[] testArray = new Date[2];
        for(int i = 0; i < 2; i++) {
            Calendar setCalendar = Calendar.getInstance();
            setCalendar.set(Calendar.YEAR, 2020 + i);
            setCalendar.set(Calendar.MONTH, 01 + i);
            setCalendar.set(Calendar.DAY_OF_MONTH, 04 + i);
            testArray[i] = setCalendar.getTime();
        }
        return testArray;
    }

    //Tests the Holidays Constructor for a correct date
    @Test
    public void holidaysConstructortest() {
        Employee testEmployee = new Employee("Harrison");
        Date[] testArray = setUpDates();
        Holidays testHoliday = new Holidays(testEmployee, testArray);
        assertEquals("Testing to the see the construcor works"
                + " by adding the holiday to the employee", true, testHoliday.getIsValid());
    }

}
