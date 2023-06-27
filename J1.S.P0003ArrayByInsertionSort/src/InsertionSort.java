
import java.util.Random;
/*
 * this class will sort by insertion sort
 */

public class InsertionSort {

    int[] a;

    /**
     * Check user's input until it's valid
     *
     * @param n is the number of elements in the array entered from the keyboard
     * @throws Exception is an event that interrupts the normal flow of the program.
     */
    public InsertionSort(int n) throws Exception {
        if (n <= 0) {
            throw new Exception("Error >>> Please input a positive decimal integer!");
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

        for (int i = 0; i < n; i++) {
            a[i] = new Random().nextInt(n)+1;
        }
    }

    /**
     * Sort elements of an array in ascending order using insertion sort
     * Implement Insertion Sort algorithm
     * It Take the first element of the unsorted list and consider it as the sorted list with only one element.
      Move to the next element, If the current element is smaller than the previous element, swap it with the 
      previous element and move back one position until you find the correct position for the current element 
      in the sorted list. Repeat until the entire list is sorted.
     */
    public void sortArrayByInsertionSort() {
        // Let the loop run from the beginning to the end of the array length
        for (int i = 1; i < a.length; ++i) {
            int key = a[i];//Store the value of the ith element in the key variable.
            int j = i - 1;//Initialize the variable j to be the position of the element immediately preceding the key.
            while (j >= 0 && a[j] > key) { //Move position j one step up to continue checking the previous elements in the array.
                                          
                a[j + 1] = a[j];//ahead and insert the key element at position a[j ] to complete the sorting.
                j = j - 1;
            }
            a[j + 1] = key;//Insert the value of key at position j + 1 in array a.
        }
    }

    /**
     * Convert array from numeric data type to string data type
     * @return sorted array of elements in order from smallest to largest
     */
    @Override
    public String toString() {
        String result = "";

        for (int i = 0; i < a.length; i++) {
            result += ", " + a[i]; 
        }

        result = result.substring(2);
        result = "[" + result + "]";
        return result;
    }

}
