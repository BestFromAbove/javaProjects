package com.firstdata.fs.intern.holiday.service;


import java.util.Calendar;
import java.util.Date;

import com.firstdata.fs.intern.holiday.domain.DateChecker;
import com.firstdata.fs.intern.holiday.domain.DateCreation;
import com.firstdata.fs.intern.holiday.domain.Employee;



public class HolidayService {
    private Employee[] existingEmployee; // Stores existing employees

    public HolidayService(String employeesString) {
        getUsers( employeesString);
    }

    // Get the users from the FileUtil class
    // Converting them from a string to a date
    // Adds them to Employee array existingEmployee
    private void getUsers(String employeesString) {
        String[] employees = employeesString.split(";");
        for (int i = 0; i < 10; i++) {
            String employeeName = employees[i + (i * 3)];
            Date[] tempDates = { convertToDate(employees[i + 1 + (i * 3)]), convertToDate(employees[i + 2 + (i * 3)]) };
            Employee tempEmp = new Employee(employeeName, tempDates);
            existingEmployee[i] = tempEmp;
        }
    }

    // Convert a string to a date
    private Date convertToDate(String date) {
        String[] dateSplit = date.split("/");
        int[] dateArray = new int[3];
        for (int i = 0; i < 3; i++) {
            dateArray[i] = Integer.parseInt(dateSplit[i]);
        }
        Calendar tempCal = Calendar.getInstance();
        tempCal.set(dateArray[0], dateArray[1], dateArray[2]);
        return tempCal.getTime();
    }

    // datesPasser
    // middle-man between string arguments from ConsoleUI and Date [] creation in
    // DateCreation.
    // Date [] is then sent to DateChecker to verify.
    public static boolean datesPasser(String startDate, String endDate) {
        DateCreation dateCreation = new DateCreation(startDate, endDate);
        DateChecker dateChecker = new DateChecker(dateCreation.getDateArray());
        return dateChecker.isValid();
    }

}
