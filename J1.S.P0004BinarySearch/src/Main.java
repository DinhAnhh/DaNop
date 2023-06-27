

import java.util.Scanner;


public class Main {

    /**
     * The main function of program
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int result;
        int search;
        int foundIndex;
        Scanner sc = new Scanner(System.in);
        boolean isDataValid = true;

        do {
            try { 
                isDataValid = true;

                System.out.println("Enter number of array: ");
                result = Integer.parseInt(sc.nextLine().trim());
                BinarySearch searcher = new BinarySearch(result); 

                System.out.println("Enter search value:");
                search = Integer.parseInt(sc.nextLine().trim());
               

                searcher.sortArray(); //this will call sortArray method

                System.out.print("Sorted array: " + searcher);

                foundIndex = searcher.BinarySearch(result, search, 0, result - 1);
                if (foundIndex == -1) {
                    System.out.println("\nCan't find the value in array!");
                } else {
                    System.out.println("\nFound " + search + " at index: " + foundIndex);
                }
            } catch (Exception e) { // if user input wrong format this message will display
                isDataValid = false;
                System.out.println("Error >>> Please input a positive decimal integer!");
            }
        } while (!isDataValid); 

    }

}
