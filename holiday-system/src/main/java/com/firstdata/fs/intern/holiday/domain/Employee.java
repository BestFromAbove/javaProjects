package com.firstdata.fs.intern.holiday.domain;

import java.util.Date;

public class Employee {
    private String name; // Stores the employee name
    private Date[] holidayDates; // Stores the booked holiday dates

    // First constructor to create an employee with no holiday dates
    public Employee(String name) {
        this.name = name;
        holidayDates = null;
    }

    // Second constructor to input holiday dates already booked from a file
    public Employee(String name, Date[] bookedDates) {
        this.name = name;
        holidayDates = bookedDates;
    }

    // Getters and setters for the two variables: name, holidayDates
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date[] getHolidayDates() {
        return holidayDates;
    }

    public void setHolidayDates(Date[] holidayDates) {
        this.holidayDates = holidayDates;
    }
}
