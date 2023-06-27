import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckEmail {
    //this is email format 
    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
            "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
            //this is an error message
    private static final String ERROR_MESSAGE = "Email must be in correct format";

    private Pattern pattern;
    private Matcher matcher;
    private Scanner scanner;
  /**
     * Prompts the user to enter an email and checks if the email format is correct.
     * If the email format is incorrect, it displays an error message and prompts for input again.
     */
    public CheckEmail() {
        pattern = Pattern.compile(EMAIL_PATTERN);
        scanner = new Scanner(System.in);
    }
/**
 * this method will check format of email form user's input
 */
    public void checkEmail() {
        String email;
        boolean isValid = false;

        do {
            System.out.print("Enter an email: ");
            email = scanner.nextLine(); //input email

            matcher = pattern.matcher(email);
            if (matcher.matches()) { // if isValid true , it will display email and break
                isValid = true;
                System.out.println(email);

            } else { // it will display error message
                System.out.println(ERROR_MESSAGE);
            }
        } while (!isValid); //loop until isValid true
    }

   
}
