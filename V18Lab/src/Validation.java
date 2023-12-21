import java.util.Scanner;

public class Validation {
    Scanner sc = new Scanner(System.in);

    /**
     * Retrieves an integer input from the user within the specified range.
     * 
     * @param msg the message prompt for the user.
     * @param min the minimum value allowed.
     * @param max the maximum value allowed.
     * @return the validated integer input from the user.
     */
    public int getInt(String msg, int min, int max) {
        // Swap min and max values if min > max
        if (min > max) {
            int temp = min;
            min = max;
            max = temp;
        }
        while (true) {
            try {
                System.out.println(msg); // Prompt the user with the provided message
                int n = Integer.parseInt(sc.nextLine()); // Read the user's input as a string and parse it as an integer

                // Check if the entered value is within the specified range
                if (min <= n && n <= max) {
                    return n; // Return the validated integer input
                }

                System.err.println("PLEASE INPUT A NUMBER IN RANGE " + min + " --> " + max); // Display an error message
                                                                                             // for invalid input

            } catch (NumberFormatException e) {
                // TODO: handle exception
                System.err.println("WRONG FORMAT!!");
            }

        }
    }

    /**
     * Retrieves a non-empty string input from the user.
     * 
     * @param msg the message prompt for the user.
     * @return the validated non-empty string input from the user.
     */
    public String getString(String msg) {
        while (true) {
            System.out.println(msg); // Prompt the user with the provided message
            String S = sc.nextLine(); // Read the user's input as a string

            if (!S.isEmpty()) {
                return S; // Return the validated non-empty string input
            }

            System.err.println("EMPTY STRING IS NOT ALLOWED!!"); // Display an error message for empty input
        }
    }

    /**
     * Retrieves a yes/no input from the user.
     * 
     * @param msg the message prompt for the user.
     * @return true if the user enters 'Y' or 'y', false if the user enters 'N' or  'n'.
     */

    public boolean getYN(String msg) {
        while (true) {
            System.out.println(msg); // Prompt the user with the provided message
            String s = sc.nextLine(); // Read the user's input as a string

            if (s.equalsIgnoreCase("Y")) {
                return true; // Return true if the user entered 'Y' or 'y'
            } else if (s.equalsIgnoreCase("N")) {
                return false; // Return false if the user entered 'N' or 'n'
            }

            System.err.println("PLEASE INPUT ONLY Y/N"); // Display an error message for invalid input
        }

    }
}