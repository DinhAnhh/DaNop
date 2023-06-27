
import java.util.Scanner;

/* 
 * this class is main
 */
public class Main {

    /**
     * The main function of program
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        boolean isDataValid = true;

        do {
            try {
                isDataValid = true;
                System.out.println("Enter number of array: ");
                n = Integer.parseInt(sc.nextLine().trim());

                SelectionSort sls = new SelectionSort(n);

                System.out.println("Unsorted array: " + sls);

                sls.sortArrayBySelectionSort();

                System.out.print("Sorted array: " + sls);
            } catch (Exception e) {
                isDataValid = false;
                System.out.println("Error >>> Please input a positive decimal integer!");
            }
        } while (!isDataValid);

    }

}
