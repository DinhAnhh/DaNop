import java.util.Scanner;
public class DisplayMenu {

    /**
     * Display a menu and ask users to select an option.
     */
    public void menu() {
        Scanner input = new Scanner(System.in);
        BubbleSortProgram bubbleSort = new BubbleSortProgram();
        //Print out the selection Menu
        while (true) {
            System.out.println("\n========= Bubble Sort program =========");
            System.out.println("1. Input items of the array");
            System.out.println("2. Sort the array in ascending order");
            System.out.println("3. Sort the array in descending order");
            System.out.println("4. Exit");
            System.out.print("Please choice one option: ");
            String choice = input.nextLine();
            /*
             *Options to execute the program
             */
            switch (choice) {
                case "1":
                    //Enter the number of elements of the array
                    bubbleSort.inputElements();
                    break;
                case "2":
                    //Sort in ascending array
                    bubbleSort.sortAscending();
                    break;
                case "3":
                    //Sort in descending array
                    bubbleSort.sortDescending();
                    break;
                case "4":
                    System.exit(0);//Exit the program
                    break;
                default://Exception if entering another option
                    System.out.println("The option must be from 1 to 4!!");
            }
        }
    }
}
