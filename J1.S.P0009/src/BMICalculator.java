


import java.util.Scanner;


public class BMICalculator {

    private double weight;
    private double height;

    /**
     * Method to create a new object from that class
     */
    public BMICalculator() {
    }

    /**
     * This method is used to retrieve the value of the weight variable of the
     * current object
     * @return a double value of the variable weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     * This method is used to set the weight value for the current object
     * @param weight is the value of the variable weight entered from the
     * keyboard
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * This method is used to retrieve the value of the height variable of the
     * current object
     * @return a double value of the variable height
     */
    public double getHeight() {
        return height;
    }

    /**
     * This method is used to set the height value for the current object
     * @param height is the value of the variable height entered from the
     * keyboard
     */
    public void setHeight(double height) {
        this.height = height / 100;
    }

    /**
     * This method calculates and displays information about BMI
     */
    public void calculateBMI() {
        Scanner input = new Scanner(System.in);
        System.out.println("----- BMI Calculator -----");
        double weight = getValueWeight("Enter Weight(kg): "); //Enter the value of the variable "weight"
        double height = getValueHeight("Enter Height(cm): "); //Enter the value of the variable "height"
        setHeight(height);//set height value in current object
        double BMI = weight / (this.height * this.height); //Calculate BMI
        //Displays the value of BMI with two decimal places.
        System.out.printf("BMI Number: %.2f\n", BMI);
        /*
         *Get the BMI status corresponding to the BMI value and display a message
         *with that status.
         */
        System.out.println("BMI Status: " + getStatus(BMI));
    }

    /**
     * Function used to give status based on BMI value provided
     * @param valueIBM is the value of IBM
     * @return a String the status corresponding to the valueIBM.
     */
    public String getStatus(double valueIBM) {
        if (valueIBM < 19) {
            //If the value is less than 19
            return "Under-standard";
        } else if (valueIBM >= 19 && valueIBM <= 25) {
            //If the value is between 19 and 25
            return "Standard";
        } else if (valueIBM > 25 && valueIBM <= 30) {
            //If the value is between 25 and 30
            return "Overweight";
        } else if (valueIBM > 30 && valueIBM <= 40) {
            //If the value is between 30 and 40
            return "Fat - should lose weight";
        } else {
            //If the value is more than 40
            return "Very fat - should lose weight immediately";
        }
    }

    /**
     * Check the input weight value
     * @param msg the message prompt for inputting the weight value
     * @return the weight value (in kilogram) if it is a positive number
     */
    public double getValueWeight(String msg) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                //Enter the number
                System.out.print(msg);
                String tmpString = sc.nextLine();
                double value = Double.parseDouble(tmpString);
                if (value > 0) {
                    //Returns a value if the value is numeric
                    return value;
                } else {
                    System.out.println("Weight (kg) must be a positive integer!!");
                }
            } catch (NumberFormatException e) {
                //If the input value is not a number
                System.out.println("BMI is digit!");
            }
        }
    }

    /**
     * Check the input height value
     * @param msg the message prompt for inputting the height value
     * @return the height value (in centimeters) if it is a positive number
     */
    public double getValueHeight(String msg) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                //Enter the number
                System.out.print(msg);
                String tmpString = sc.nextLine();
                double value = Double.parseDouble(tmpString);
                if (value > 0) {
                    //Returns a value if the value is numeric
                    return value;
                } else {
                    System.out.println("Height (cm) must be a positive integer!!");
                }
            } catch (NumberFormatException e) {
                //If the input value is not a number
                System.out.println("BMI is digit!");
            }
        }
    }
}
