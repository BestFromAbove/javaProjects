package com.firstdata.fs.intern.holiday.domain;

import java.util.Calendar;
import java.util.Date;

public class DateCreation {

    private int[] intArray;
    private Date[] dateArray;

    // two string argument constructor that creates Date [].

    public DateCreation() {
        // default constructor
    }

    public DateCreation(String startDate, String endDate) {
        intArray = stringToIntArray(startDate, endDate);
        dateArray = convertToDate(intArray);
    }

    // Converting the type int dateArray to a type Date array
    // Using a for loop to create the dates using the calendar class
    public Date[] convertToDate(int[] intArray) {
        Date[] datesConverted = new Date[2];
        for (int i = 0; i < 2; i++) {
            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.YEAR, intArray[0 + (i * 3)]);
            cal.set(Calendar.MONTH, intArray[1 + (i * 3) ]);
            cal.set(Calendar.DAY_OF_MONTH, intArray[2 + (i * 3)]);
            datesConverted[i] = cal.getTime();
        }
        return datesConverted;
    }

    // converts two string dates to array of dates.
    // each index is separated by "/" character created from user input.
    private int[] stringToIntArray(String startDate, String endDate) {
        String startDateArray[] = startDate.split("/");
        String endDateArray[] = endDate.split("/");
        int intDateArray[] = new int[6];
        for (int i = 0; i < 6; i++) {
            if (i < 3) {
                intDateArray[i] = Integer.parseInt(startDateArray[i]);
            } else {
                intDateArray[i] = Integer.parseInt(endDateArray[i - 3]);
            }
        }
        return intDateArray;
    }

    public Date[] getDateArray() {
        // Getter
        return dateArray;
    }

}
