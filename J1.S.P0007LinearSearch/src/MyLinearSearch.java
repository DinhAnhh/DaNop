import java.util.Random;
public class MyLinearSearch {
    private int[] a;
    
    /**
     *Generate random integer in the number range input
     * @param n is the number of elements in the array entered from the keyboard
     */
    public MyLinearSearch(int n){
        a = new int[n];
        Random rnd = new Random();
        //Generate n random integer in the number range input.
        for(int i = 0; i < n; i++){
            a[i] = rnd.nextInt(n)+1;
        } 
    }

    /**
     *Implement Linear Search algorithm
     *It will traverse each element of the array to find the value to look for
     * @param x is the value to be searched entered from the keyboard
     * @return the element's index of the element to be searched
     */
    public int linearSearch(int x) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == x) {
                return i; // Returns the element's index if found
            }
        }
        return -1; //Returns -1 if the element is not found
    }
    
    
    /**
     *Print out the results of the algorithm according to the requirements of the problem
     * @return an array of elements to be created with n random integer
     */
    @Override
    public String toString() {
        String str = "[" + a[0]; 
            for(int i = 1; i < a.length; i++){
                str += ", " + a[i];  //print "," with value at index in array
            }
            str += "]";
        return str;
    }
}
