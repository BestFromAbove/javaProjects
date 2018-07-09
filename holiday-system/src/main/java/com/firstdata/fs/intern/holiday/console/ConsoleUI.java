package com.firstdata.fs.intern.holiday.console;

import com.firstdata.fs.intern.holiday.service.HolidayService;
import java.util.logging.Logger;
import java.util.Locale;

public class ConsoleUI {
    
    private static final Logger LOGGER = Logger.getLogger( ConsoleUI.class.getName() );
    private static String userName = ""; 
    public static void welcomeScreen() {
        
        LOGGER.info("Welcome to the Holiday System.");
        String input = "";
        boolean alwaysTrue = true;
        while (alwaysTrue == true) {
            LOGGER.info("Please enter your userID");
            //Corrects an error with Immediate dereference of null pointer.
            input = System.console().readLine().toLowerCase(Locale.ENGLISH);
            boolean a = true; // get rid of !!!!!
            if (a == true) {
                userName = input;
                alwaysTrue = false;
            } else {
                continue;
            }
        }
    }

    public static void menu() {
        LOGGER.info("Welcome " + userName);
        boolean alwaysTrue = true;
        while (alwaysTrue == true) {
            LOGGER.info("MENU");
            LOGGER.info("1. Book holiday \n" + "2. View your chosen holiday selections \n"
                    + "3. View all employees chosen holiday selections \n" + "4. Exit program ");
            int choice = Integer.parseInt(System.console().readLine());
            // PAGE 51
            switch (choice) {
            default:
                // incorrect choice
                LOGGER.info("Invalid choice.");
                break;
            case 1:
                // book holiday method
                chooseDate();
                break;
            case 2:
                // view chosen holiday selections
                LOGGER.info("PLACEHOLDER_ONE");
                break;
            case 3:
                // view all employees chosen selections
                LOGGER.info("PLACEHOLDER_TWO");
                break;
            case 4:
                // Exit program
                LOGGER.info("Exiting Program.");
                alwaysTrue = false;
                break;
            }
        }
    }

    public static void chooseDate() {
        LOGGER.info("Enter beginning date in format yyyy/mm/dd");
        String startDate = System.console().readLine();
        LOGGER.info("Enter end date in format yyyy/mm/dd");
        String endDate = System.console().readLine();

        if (HolidayService.datesPasser(startDate, endDate) == true) {
            //if(// other person  hasn't booked yet)
            // books holiday
            LOGGER.info("PLACEHOLDER_THREE");
        } else {
            LOGGER.info("Error. Either you typed in dates wrong or conflicting dates");
            menu();
        }

    }

    public static void main(String[] args) {
        ConsoleUI.welcomeScreen();
        ConsoleUI.menu();

    }
}