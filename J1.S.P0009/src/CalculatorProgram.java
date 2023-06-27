import java.util.Scanner;

public class CalculatorProgram {

    private double memory;

    /**
     * Assign the value 0 to the memory variable
     */
    public CalculatorProgram() {
        memory = 0;
    }

    /**
     * The function will calculate and store results in the temporary memory
     * when inputting each operator and number into the calculator
     */
    public void NormalCalculator() {
        Scanner scanner = new Scanner(System.in);
        String operator;
        int count = 0;
        System.out.println("----- Normal Calculator -----");
        //Enter and check the value of the variable
        double number = getValueNumber("Enter a number: ");
        memory = number; //Store the value in the memory variable

        /*
         *Perform calculations of operators and store them in the memory variable
         */
        while (true) {
            do {
                if (count == 0) {
                    System.out.print("Enter Operator: ");
                    //Enter operator
                    operator = scanner.nextLine();
                } else {
                    count = 0;
                    System.out.println("Enter operators +, -, *, /, ^ to continue or = to exit");
                    System.out.print("Enter Operator: ");
                    //Enter operator
                    operator = scanner.nextLine();
                }

            } while (!getOperator(operator));

            if (operator.equals("=")) {
                //If operator is "=" sign then exit calculation loop
                break;
            }
            //Enter and check the value of the variable
            number = getValueNumber("Enter a number: ");

            switch (operator) {
                case "+":
                    /*
                     *If the operator is a "+" sign, perform the addition operation 
                     *and store the calculation value
                     */
                    this.memory += number;
                    break;
                case "-":
                    /*
                     *If the operator is a "-" sign, perform the subtraction operation 
                     *and store the calculation value
                     */
                    this.memory -= number;
                    break;
                case "*":
                    /*
                     *If the operator is a "*" sign, perform the multiplication operation 
                     *and store the calculation value
                     */
                    this.memory *= number;
                    break;
                case "/":
                    /*
                     *If the operator is a "/" sign, perform the division operation 
                     *and store the calculation value
                     */
                    if (number != 0) {
                        this.memory /= number;
                    } else {
                        /*
                         *If the number entered to perform the division is zero,
                         *the message is displayed
                         */
                        System.out.println("Cannot divide by zero!");
                    }
                    break;
                case "^":
                    /*
                     *If the operator is a "^" sign, perform the exponential operation 
                     *and store the calculation value
                     */
                    this.memory = Math.pow(this.memory, number);
                    break;
            }
            //Print the stored variable of each calculation execution
            System.out.println("Memory: " + memory);
            ++count;
        }
        //Print the stored variable of each calculation execution
        System.out.println("Result: " + this.memory);
    }

    /**
     * Check the input value of operator
     * @param operator is a parameter to specify the operator used in the
     * calculation
     * @return true if the value matches any value in the array, and false if
     * there is no match and the function prints the message.
     */
    public static boolean getOperator(String operator) {
        String[] validOperator = {"+", "-", "*", "/", "^", "="};
        //Check if the value of "operator" matches any value in the array
        for (String value : validOperator) {
            if (value.equals(operator)) {
                //If there is a match to any value in the array, true is returned
                return true;
            }
        }
        //If there is no match for any value in the array, it will return false and display a message
        System.out.println("Please input (+, -, *, /, ^ or = to exit)");
        return false;
    }
    
    /**
     * Check the input value of number
     * @param msg the message prompt for inputting the value of number
     * @return a value if the value is numeric
     */
    public double getValueNumber(String msg) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                //Enter the value of number
                System.out.print(msg);
                String tmpString = sc.nextLine();
                double number = Double.parseDouble(tmpString);
                //If number is a integer, return number
                return number;
            } catch (NumberFormatException e) {
                //If number is a string or character and is not a positive integer, print the message
                System.out.println("Number is digit!");
            }
        }
    }
}
