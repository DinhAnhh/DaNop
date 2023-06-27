import java.util.Random;
/* 
 * This class will sort by selection sort
 */
public class SelectionSort {

    int[] a;

    /**
     * Check user's input until it's valid
     *
     * @param n is the number of elements in the array entered from the keyboard
     * @throws Exception is an event that interrupts the normal flow of the program.
     */
    public SelectionSort(int n) throws Exception {
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

        for (int i = 0; i < n; i++) {
            a[i] = new Random().nextInt(n)+1;
        }
    }

    /**
     * Sort elements of an array in ascending order using selection sort
     * Implement Selection sort algorithm 
      Selection Sort is sorting algorithm that works by repeatedly selecting the smallest element 
      from an unsorted list and swapping it with the first element of the unsorted list until 
      the entire list is sorted.
     */
    public void sortArrayBySelectionSort() {
        //One by one move boundary of unsorted subarray
        for (int i = 0; i < a.length - 1; i++) {
        // Find the mini element in unsorted array
            int minIndex = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[minIndex]) { // compare the smallest element with the next element
                    minIndex = j;// update the smallest element
                }
            }
        //Swap the found minimum element with the first
        // element
            if (minIndex != i) {
                int temp = a[minIndex];
                a[minIndex] = a[i];
                a[i] = temp;
            }
        }
    }

    /**
     * Convert array from numeric data type to string data type
     * Print out the results of the algorithm according to the requirements of the problem
     * @return the array list has open , close curly brackets and comma
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
