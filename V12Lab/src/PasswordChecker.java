
import java.util.Scanner;
import java.util.regex.*;

/* this class will check password's user  */
public class PasswordChecker {

    /**
     * this class will check string password is valid or not and throw exception
     * from user's input
     * 
     * @param password is element of string from user input
     * @return String of password valid
     * @throws Exception is an event that interrupts the normal flow of the program.
     */
    public static String checkPassword(String password) throws Exception {
        // Regular expression pattern to check if the password contains at least one
        // letter and one digit

        String regex = "^(?=.*[a-zA-Z])(?=.*\\d).+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);

        // Flag to track if the password is valid
        boolean isValid = false;
        // Create a Scanner to read user input
        Scanner scanner = new Scanner(System.in);
  
        // Keep looping until a valid password is entered
        while (!isValid) {
            try {
                // Check if the password length is greater than 31, less than 8, or doesn't
                // match the pattern
                if (password.length() > 31 || password.length() < 8 || password.matches("\\d+")) {
                    // Throw an exception with the corresponding error message
                    throw new Exception(Language.labels.getString("errorPasswordLength"));

                } else {
                    // Password is valid, set the isValid flag to true
                    isValid = true;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                // Prompt the user to enter a valid password
                password = scanner.nextLine();
                // Reset the matcher with the updated password
                matcher.reset(password);
            }
        }

        // Return the valid password
        return password.toString();
    }
}
