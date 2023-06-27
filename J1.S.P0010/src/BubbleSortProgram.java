import java.util.InputMismatchException;
import java.util.Scanner;
public class BubbleSortProgram {

    //Declare variable
    private int[] array;
    private int length;

    /**
     * Initializes an object and the 'length' property is set to 0.
     */
    public BubbleSortProgram() {
        length = 0;
    }

    /**
     * Enter the number of elements of the array
     */
    public void inputElements() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("----- Input Element -----");
        System.out.println("Input Length Of Array");
        while (true) {
            try {
                length = getValue("Enter Number: ");
                if (length <= 0) {
                    //If the input array length is less than or equal to 0
                    System.out.println("Number is greater than zero!!");
                } else {
                    array = new int[length];
                    for (int i = 0; i < length; i++) {
                        //Enter each element into the array
                        array[i] = getValue("Enter Number " + (i + 1) + ": ");
                    }
                    break;
                }
            } catch (InputMismatchException e) {
                //If the input value is not valid
                System.out.println("Please input number and number is greater than zero!!");
                scanner.nextLine(); // Clear the input buffer
            }
        }
    }

    /**
     * Sort in ascending array
     */
    public void sortAscending() {
        if (length > 0) {
            //Create new array
            int[] arrayAscending = new int[array.length];
            int tmp;
            // Copy array to arrayAscending
            System.arraycopy(array, 0, arrayAscending, 0, array.length);

            //Iterate over the elements from the beginning to the end of the array
            for (int i = 0; i < arrayAscending.length - 1; i++) {
                /*
                 *Traverse the elements from the beginning to the end of the array
                 *minus the sorted number of elements (i)
                 */
                for (int j = 0; j < arrayAscending.length - i - 1; j++) {
                    //Check if the current element is greater than the next element
                    if (arrayAscending[j] > arrayAscending[j + 1]) {
                        /*
                        *If this condition is true, the two elements are swapped 
                        *using the temporary variable
                         */
                        tmp = arrayAscending[j];
                        arrayAscending[j] = arrayAscending[j + 1];
                        arrayAscending[j + 1] = tmp;
                    }
                }
            }
            //Contains the first element of the array
            String str = "[" + arrayAscending[0] + "]";
            System.out.println("----- Ascending -----");
            //Iterate over the elements from the beginning to the end of the array
            for (int i = 1; i < arrayAscending.length; i++) {
                /*
                 *The loop iterates over the remaining elements of the array and 
                 *adds them to the string
                 */
                str += " -> " + "[" + arrayAscending[i] + "]";
            }
            //Print the results sorted in ascending array
            System.out.println(str);
        } else {
            //If the array is empty
            System.out.println("Array is empty! Please input elements first in option 1!!");
        }
    }

    /**
     * Sort in descending array
     */
    public void sortDescending() {
        if (length > 0) {
            //Create new array
            int[] arrayDescending = new int[array.length];
            int tmp;
            // Copy array array to arrayDescending
            System.arraycopy(array, 0, arrayDescending, 0, array.length);
            
            //Iterate over the elements from the beginning to the end of the array
            for (int i = 0; i < arrayDescending.length - 1; i++) {
                /*
                 *Traverse the elements from the beginning to the end of the array
                 *minus the sorted number of elements (i)
                 */
                for (int j = 0; j < arrayDescending.length - i - 1; j++) {
                    //Check if the current element is less than the next element
                    if (arrayDescending[j] < arrayDescending[j + 1]) {
                        /*
                         *If this condition is true, the two elements are swapped 
                         *using the temporary variable
                         */
                        tmp = arrayDescending[j];
                        arrayDescending[j] = arrayDescending[j + 1];
                        arrayDescending[j + 1] = tmp;
                    }
                }
            }
            //Contains the first element of the array
            String str = "[" + arrayDescending[0] + "]";
            System.out.println("----- Descending -----");
            //Iterate over the elements from the beginning to the end of the array
            for (int i = 1; i < arrayDescending.length; i++) {
                /*
                 *The loop iterates over the remaining elements of the array and 
                 *adds them to the string
                 */
                str += " <- " + "[" + arrayDescending[i] + "]";
            }
            //Print the results sorted in descending array
            System.out.println(str);
        } else {
            //If the array is empty
            System.out.println("Array is empty! Please input elements first in option 1!!");
        }
    }
    
    /**
     * Check the input value
     * @param msg the message prompt for inputting the value
     * @return the input value 
     */
    public static int getValue(String msg) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                //Enter the value
                System.out.print(msg);
                String tmpString = sc.nextLine();
                int value = Integer.parseInt(tmpString);
                //If value is a integer, return value
                return value;
            } catch (NumberFormatException e) {
                //If value is a string or character and is not a integer, print the message
                System.out.println("Must be number! Please input again.");
            }
        }
    }
}
