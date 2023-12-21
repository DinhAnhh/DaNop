import java.util.Scanner;

/*
 * this class will check account.
 */
public class AccountChecker {

    /**
     * This class will check account number is valid or not from user's input and
     * thrown exception.
     * 
     * @param accountNumber is string of element entered from the keyboard
     * @return String of account number
     * @throws Exception is an event that interrupts the normal flow of the program.
     */
    public static String checkAccountNumber(String accountNumber) {
        /* Create a Scanner to read user input */
        Scanner scanner = new Scanner(System.in);
        /* Flag to track if the account number is valid */
        boolean isValid = false;
        /* Keep looping until a valid account number is entered */
        while (!isValid) {
            try {
                /*
                 * Check if the account number's length is not equal to 10 or it contains
                 * non-digit characters
                 */
                if (accountNumber.length() != 10 || !accountNumber.matches("\\d+")) {
                    /* Throw an exception with the corresponding error message */
                    throw new Exception(Language.labels.getString("errorID"));
                } else {
                    /* Account number is valid, set the isValid flag to true */
                    isValid = true;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                /* Prompt the user to enter a valid account number */
                accountNumber = scanner.nextLine();
            }
        }

        // Return the valid account
        return accountNumber;

    }

    /**
     * display a string AccountChecker
     * 
     * @return a string of AccountCHecker if it valid
     */
    @Override
    public String toString() {
        return "AccountChecker []";
    }

}
