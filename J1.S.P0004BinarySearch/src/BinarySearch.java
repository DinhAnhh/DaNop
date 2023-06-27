
import java.util.Arrays;
import java.util.Random;


public class BinarySearch {

    int[] a;

    /**
     * Check user's input until it's valid
     *
     * @param n is the number of elements in the array entered from the keyboard
     * @throws Exception is an event that interrupts the normal flow of the program.
     */
    public BinarySearch(int n) throws Exception {
        if (n <= 0) {
            throw new Exception("Error >>> Please input a positive integer!");
        } else {
            randomArray(n);
        }
    }

    /**
     * Generate random integer for each array element
     *
     * @param n is the number of elements in the array entered from the keyboard
     */
    public void randomArray(int n) {
        //Allocates memory for array a
        a = new int[n];

        for (int i = 0; i < n; i++) { // this loop which element will add to array
            a[i] = new Random().nextInt(n);
        }
    }

    /**
     * Sort elements of an array in ascending order
     */
    public void sortArray() {
        Arrays.sort(a);
    }

    /**
     * Finds index of a value by using binary search algorithm
     *
     * @param result is the result after the search algorithm is performed.
     * @param value is the value used to compare the element you want to search in the array
     * @param left to represent the start indices of the list respectively.
     * @param right to represent the end indices of the list respectively
     * Binary search is an algorithm used to find a specific element in a sorted list or array.
       It works on the principle of dividing the list into halves repeatedly until the desired 
       element is found or the search is exhausted.
     * 
     */
    public int BinarySearch(int result, int value, int left, int right) {

        if (left > right) { //Check if the left position (left) is greater than the right position (right).
            return -1; //If it is, it means that there are no more elements to search for and returns -1 (not found).
        }

        int middle = (left + right) / 2;

        if (a[middle] == value) { //If the value in the middle position is equal to the value to be searched (value)
            return middle; // the middle position is returned.
        } else if (a[middle] > value) { //If the value in the middle position is greater than the value to search, then continue searching in the range from left to middle - 1
            return BinarySearch(result, value, left, middle - 1);
        } else {//If the value in the middle position is smaller than the value to be searched, continue searching in the range from middle + 1 to right.
            return BinarySearch(result, value, middle + 1, right);
        }
    }

    /**
     * Convert array from numeric data type to string data type
     * Print out the results of the algorithm according to the requirements of the problem
     * @return the array list has open , close curly brackets and comma
     */
    @Override
    public String toString() {
        String result = ""; //create chain for result
        //Let the loop run from the beginning to the end of the array length
        for (int i = 0; i < a.length; i++) {
            result += ", " + a[i]; // Add elements to the result string with commas and spaces between the elements.
        }

        result = result.substring(2); //substring(2) method to remove first space and comma in string
        result = "[" + result + "]";
        return result;
    }

}
