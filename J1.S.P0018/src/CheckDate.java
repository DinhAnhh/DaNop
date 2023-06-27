import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
/**
 * this class will check format of input from user
 */
public class CheckDate {
    private static final String DATE_FORMAT = "dd/MM/yyyy";
    private static final String ERROR_MESSAGE = "Date must be in the format dd/MM/yyyy";

    private DateFormat dateFormat;
    private Scanner scanner;

    /**
     *  this will check date format
     */
    public CheckDate() {
        dateFormat = new SimpleDateFormat(DATE_FORMAT);
        dateFormat.setLenient(false); 
        /*
        Specify whether or not date/time parsing is to be lenient. With lenient parsing, 
        the parser may use heuristics to interpret inputs that do not precisely match this object's format.
        With strict parsing, inputs must match this object's format.
         */
        scanner = new Scanner(System.in);
    }

    /**
     * Prompts the user to enter a date in the format dd/MM/yyyy and checks if the date is valid.
     * If the date format is incorrect, it displays an error message and prompts for input again.
     */
    public void checkDate() {
        String date;
        boolean valid = false;

        do {
            System.out.print("Enter a date (dd/MM/yyyy): ");
            date = scanner.nextLine();
                // if user input wrong format, this try_catch will help user to input again and display an error when wrong format
            try {
                dateFormat.parse(date);
                valid = true;   //if format true ---> valid true
                System.out.println(date);
            } catch (ParseException e) {
                System.out.println(ERROR_MESSAGE); 
                // display an error message
            }
        } while (!valid); // to loop until input right format date
    }
}


