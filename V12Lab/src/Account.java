
import java.util.Scanner;

public class Account {

    private String account; // The code of the user
    private String name; // The name of the user

    private String password; // The password of the user

    public Account(String account, String name, String password) {
        this.account = account;
        this.name = name;
        this.password = password;
    }

    /**
     * Constructs a new instance of the user class
     */
    public Account() {
    }

    /**
     * return the string of account
     * 
     * @return the string of account
     */
    public String getAccount() {
        return account;
    }

    /**
     * return the string of name
     * 
     * @return the string of name
     */
    public String getName() {
        return name;
    }

    /**
     * return the string of password
     * 
     * @return the string of password
     */
    public String getPassword() {
        return password;
    }

    /**
     * this will return the String
     * 
     * @return the string of account
     */

    @Override
    public String toString() {
        return "Account [account=" + account + ", name=" + name + ", password=" + password + "]";
    }

    /**
     * Prompts the user to input a string and returns the input value after
     * performing validation checks.
     * 
     * @param msg the message to display as a prompt for input
     * @return the validated input string
     */
    public String inputString(String msg) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            // Check the input string
            System.out.print(msg);
            String value = sc.nextLine().trim();
            // Convert the string value to a character array
            char[] arr = value.toCharArray();

            // Check the length of the value
            if (value.isEmpty()) {
                System.out.println(msg + " cannot be empty!!");
            }
            // check id of account
            if (msg.equals(Language.labels.getString("ID"))) {
                AccountChecker.checkAccountNumber(value);
                return value;

            } // check password of account
            if (msg.equals(Language.labels.getString("Password"))) {
                try {
                    PasswordChecker.checkPassword(value);
                    return value;
                } catch (Exception e) {

                    System.out.println(Language.labels.getString("errorPasswordLength"));
                }
            }
            // this will check name of account
            if (msg.equals(Language.labels.getString("Name"))) {

                try {
                    // Check if value is a number
                    Double.parseDouble(value);
                    System.out.println(msg + Language.labels.getString("errorN"));
                } catch (NumberFormatException e) {
                    // Check if the value contains special characters
                    if (((int) arr[0] >= 33 && (int) arr[0] <= 47)
                            || ((int) arr[0] >= 58 && (int) arr[0] <= 64)
                            || ((int) arr[0] >= 123 && (int) arr[0] <= 126)) {
                        /**
                         * If the value of value contains special characters, it
                         * is an invalid string
                         */
                        System.out.println(msg + Language.labels.getString("errorK"));
                    } else {
                        // If the value is a valid string, return the value
                        return value;
                    }
                }

            }

        }
    }
}
