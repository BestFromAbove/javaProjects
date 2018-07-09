package com.firstdata.fs.intern.holiday.domain.test;
import com.firstdata.fs.intern.holiday.domain.DateCreation;
import java.util.Date;
import java.util.Calendar;
import org.junit.Assert;
import org.junit.Test;


public class DateCreationTest {
    
    
    int [] testArray = new int [] {2018,07,05,2018,07,06};
    DateCreation tempDateCreation = new DateCreation();
    // Used in both DateCreationTest and DateCheckerTest
    // Creates two Dates for testing.
    public Date testDateCreationFirst() {
        Calendar setCalendar = Calendar.getInstance();
        setCalendar.set(Calendar.YEAR, 2018);
        setCalendar.set(Calendar.MONTH, 07);
        setCalendar.set(Calendar.DAY_OF_MONTH, 05);
        return setCalendar.getTime();
    }
    public Date testDateCreationSecond() {
        Calendar setCalendar = Calendar.getInstance();
        setCalendar.set(Calendar.YEAR, 2018);
        setCalendar.set(Calendar.MONTH, 07);
        setCalendar.set(Calendar.DAY_OF_MONTH, 06);
        return setCalendar.getTime();
    }
    

    @Test
    public void convertToDateTest() {
        Date testDateOne = testDateCreationFirst();
        Date testDateTwo = testDateCreationSecond();
        Date [] testDateArray = new Date [2];
        testDateArray[0] = testDateOne;
        testDateArray[1] = testDateTwo;
        Assert.assertEquals("Testing to see if int array turns into date array", testDateArray,tempDateCreation.convertToDate(testArray));
    }
    @Test
    public void getDateArrayChecker() {
        Date testDateOne = testDateCreationFirst();
        Date testDateTwo = testDateCreationSecond();
        String firstString = "2018/07/05";
        String secondString = "2018/07/06";
        Date [] testDateArray = new Date [2];
        testDateArray[0] = testDateOne;
        testDateArray[1] = testDateTwo;
        DateCreation testDateCreation = new DateCreation(firstString, secondString);
        Assert.assertEquals("Testing the getter for getDateArray", testDateArray, testDateCreation.getDateArray());
    }
    
    
}
