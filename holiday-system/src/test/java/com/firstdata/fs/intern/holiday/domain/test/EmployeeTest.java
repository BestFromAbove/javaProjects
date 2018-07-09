package com.firstdata.fs.intern.holiday.domain.test;

import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import com.firstdata.fs.intern.holiday.domain.Employee;

public class EmployeeTest {
    public EmployeeTest() {

    }

    // Create a test date
    private Date setUpDates() {
        Calendar setCalendar = Calendar.getInstance();
        setCalendar.set(Calendar.YEAR, 2020);
        setCalendar.set(Calendar.MONTH, 01);
        setCalendar.set(Calendar.DAY_OF_MONTH, 04);
        return setCalendar.getTime();
    }

    @Test
    public void employeeConstructorTest() {
        Employee testEmployee = new Employee("Harrison");
        Assert.assertEquals( "Harrison",
                testEmployee.getName());
    }

    @Test
    public void employee2ndConstructorTest() {
        Employee testEmployee = new Employee("tgh98", new Date[] {setUpDates()});
        Assert.assertArrayEquals("Testing the second constructor, setting name and dates, and test getHolidayDates()",
               new Date[] {setUpDates()}, testEmployee.getHolidayDates());
    }

    @Test
    public void employeeTestSetName() {
        Employee testEmployee = new Employee("Harrison");
        String changeName = "hg123";
        testEmployee.setName(changeName);
        Assert.assertEquals("Testing the setName() method of employee", changeName, testEmployee.getName());
    }

    @Test
    public void employeeTestSetDates() {
        Employee testEmployee = new Employee("Harrison");
        testEmployee.setHolidayDates(new Date[] {setUpDates()});
        Assert.assertArrayEquals("Testing the setHolidayDates() method of employee", new Date[] {setUpDates()},
                testEmployee.getHolidayDates());
    }
}
