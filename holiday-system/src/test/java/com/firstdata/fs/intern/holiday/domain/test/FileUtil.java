package com.firstdata.fs.intern.holiday.domain.test;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

public class FileUtil {
    //Testing class to supply the program with test data
    //Supplies existing employees
    private String existingUsers;
    private DateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd"); //Sets the standard format for the dates
    
    public FileUtil() {
        generateUsers(10);
    }
    
    //Generate the users for testing
    private void generateUsers(int amountOfUsers) {
        StringBuffer tempUsers = new StringBuffer("");
        String[] users = generateNames(amountOfUsers);
        for(int i = 0; i < amountOfUsers; i++) {
            tempUsers.append(users[i] + ";" + generateDates(2));
        }
    }
    
    //generate the random dates for testing
    private String generateDates(int amountOfDates) {
        StringBuffer tempDate = new StringBuffer("");
        for(int i = 0; i < amountOfDates; i++) {
            Calendar cal = Calendar.getInstance();
            Random randomNum = new Random();
            int randomMonth = randomNum.nextInt((12-1)+ 1)-1;
            int randomDay = randomNum.nextInt((25-1)+ 1)-1;
            cal.set(2018, randomMonth, randomDay);
            Date holidayDate = cal.getTime();
            tempDate.append(dateFormat.format(holidayDate)+ ";");
        }
        return tempDate.toString();
    }
    
    //generate the names of the employees for testing
    private String[] generateNames(int amountOfUsers) {
        String[] users = new String[amountOfUsers];
        for(int i = 0; i < amountOfUsers; i++) {
            Random randomNum = new Random();
            char randomChar = (char)(randomNum.nextInt(26) + 'a');
            StringBuffer tempUser = new StringBuffer(randomChar);
            randomChar = (char)(randomNum.nextInt(26) + 'a');
            tempUser.append(randomChar);
            users[i] = tempUser.toString();
        }
        return users;
    }
    
    //get the existing users string
    public String getExistingUsers() {
        return existingUsers;
    }
    
}
