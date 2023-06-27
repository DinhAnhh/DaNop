
import java.util.Scanner;

public class Main {

    /**
     * The main entry point of the program
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Create a new instance of the DisplayInputData class
        DisplayInputData data = new DisplayInputData();
        Scanner sc = new Scanner(System.in);
        System.out.println("===== Analysis String program ====");
        System.out.print("Input string: ");
        String input = sc.nextLine();
        //Call the performAnalysis method to start input string
        data.performAnalysis(input);
    }
    
}
