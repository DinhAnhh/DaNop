
import java.util.Scanner;

public class MenuCalculator {

    /**
     *Display a menu and ask users to select an option.
     */
    public void menu() {
        Scanner input = new Scanner(System.in);
        //Print out the selection Menu
        while (true) {
            System.out.println("\n========= MENU =========");
            System.out.println("1. Normal Calculator");
            System.out.println("2. BMI Calculator");
            System.out.println("0. Exit");
            System.out.print("Please choice one option: ");
            String choice = input.nextLine();
            /*
             *Options to execute the program
             */
            switch (choice) {
                case "1":
                    CalculatorProgram normal = new CalculatorProgram();
                    normal.NormalCalculator();//Perform normal calculation
                    break;
                case "2":
                    BMICalculator BMI = new BMICalculator();
                    BMI.calculateBMI();//Perform IBM calculation
                    break;
                case "0":
                    System.exit(0);//Exit the program
                    break;
                default://Exception if entering another option
                    System.out.println("The option must be from 0 to 2!!");
            }
        }
    }
}
