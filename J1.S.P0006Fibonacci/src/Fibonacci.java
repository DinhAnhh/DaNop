public class Fibonacci {

    /**
     * Find Fibonacci series number with recursion
     *
     * @param n is the number of elements in the array entered from the keyboard
     * @return Fibonacci series
     */
    public static int findFibonacci(int n) {
        if (n < 2) { // Base case: If n is 0 or 1, return n itself
            return n;
        }
        // Recursive case: Calculate the Fibonacci number by summing the two previous Fibonacci numbers
        // Recursively call findFibonacci() with n-2 and n-1 to find the two previous Fibonacci numbers
        return findFibonacci(n - 2) + findFibonacci(n - 1);
    }

    /**
     * Displays the first 45 digits of the Fibonacci sequence
     *
     * @return 45 digit of Fibonacci sequence
     */
    @Override
    public String toString() {
        // Initialize the result string with the first Fibonacci number
        String result = "0";
        // Iterate from 1 to 44 (inclusive) to find Fibonacci numbers
        for (int i = 1; i < 45; i++) {
            result += ", " + findFibonacci(i); // Append a comma and the next Fibonacci number to the result string
        }
        // Return the final result string
        return result; 
    }
}
