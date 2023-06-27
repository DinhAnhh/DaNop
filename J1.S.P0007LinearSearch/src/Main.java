
import java.util.Scanner;

public class Main {

    /**
     * Check the input value of n
     * @param msg the message prompt for inputting the value of n
     * @return the value of n if n is valid number
     */
    public static int getPositiveNumber(String msg) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                //Enter the value of n
                System.out.print(msg);
                String tmpString = sc.nextLine();
                int n = Integer.parseInt(tmpString);
                if (n <= 0) {//If n is not a positive integer, print the message
                    System.out.println("Accept positive integers only!");
                    continue;
                }
                //If n is a positive integer, return n
                return n;
            } catch (NumberFormatException e) {
                //If n is a string or character and is not a positive integer, print the message
                System.out.println("Must be number! Please input again.");
            }
        }
    }

    /**
     * Check the input value of v
     * @param msg the message prompt for inputting the value of v
     * @return the value of v if v is valid number 
     */
    public static int getValue(String msg) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                //Enter the value of v
                System.out.print(msg);
                String tmpString = sc.nextLine();
                int v = Integer.parseInt(tmpString);
                //If v is a integer, return v
                return v;
            } catch (NumberFormatException e) {
                //If v is a string or character and is not a positive integer, print the message
                System.out.println("Must be number! Please input again.");
            }
        }
    }

    /**
     * Main method of the program.
     * @param args Array of command-line arguments passed at runtime.
     * In this case, no command line arguments are used.
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            //Enter the number of elements in the array
            int n = getPositiveNumber("Enter number of array: ");//Check the input value of n with getPositiveNumber() function 
            //Enter the value to look up in the array
            int v = getValue("Enter search value: ");//Check the input value of v with getValue() function 
            MyLinearSearch app = new MyLinearSearch(n);
            System.out.println("The array: " + app);
            //Check the value of v with the Linear Search method.
            if (app.linearSearch(v) == -1) {//If the method returns -1 then print the result not found
                System.out.println("Searched value isn't found!!");
            } else {//If the method returns other than -1, then print the results as required
                System.out.println("Found " + v + " at index: " + app.linearSearch(v));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}
