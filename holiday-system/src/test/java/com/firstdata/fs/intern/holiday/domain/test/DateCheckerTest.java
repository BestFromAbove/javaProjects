package com.firstdata.fs.intern.holiday.domain.test;

import com.firstdata.fs.intern.holiday.domain.DateChecker;

import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

public class DateCheckerTest {

    // Used in both DateCreationTest and DateCheckerTest
    // Creates two Dates for testing.
    public Date testDateCreationFirst() {
        Calendar setCalendar = Calendar.getInstance();
        setCalendar.set(Calendar.YEAR, 2018);
        setCalendar.set(Calendar.MONTH, 06);
        setCalendar.set(Calendar.DAY_OF_MONTH, 03);
        return setCalendar.getTime();
    }

    public Date testDateCreationSecond() {
        Calendar setCalendar = Calendar.getInstance();
        setCalendar.set(Calendar.YEAR, 2018);
        setCalendar.set(Calendar.MONTH, 06);
        setCalendar.set(Calendar.DAY_OF_MONTH, 06);
        return setCalendar.getTime();
    }

    @Test
    // this also tests the Getter for private isValid variable
    public void testDateCheckerConstructor() {
        Date testDate = testDateCreationFirst();
        DateChecker testDateChecker = new DateChecker(testDate);
        Assert.assertEquals("Checking date checker, should come back true", true, testDateChecker.isValid());
    }

    @Test
    // this also tests the Getter for private isValid variable
    public void testMultipleDateCheckerConstruction() {
        Date testDateOne = testDateCreationFirst();
        Date testDateTwo = testDateCreationSecond();
        Date [] testDateArray = new Date[2];
        testDateArray[0] = testDateOne;
        testDateArray[1] = testDateTwo;
        DateChecker testDateChecker = new DateChecker(testDateArray);
        Assert.assertEquals("Checking multiple date checker, should come back true", true, testDateChecker.isValid());
    }

}
