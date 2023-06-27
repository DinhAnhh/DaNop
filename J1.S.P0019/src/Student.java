import java.util.Scanner;

public class Student {

    private String name; // The name of the student
    private String className; // The class name of the student
    private double math; // The mark for math subject
    private double physical; // The mark for physical subject
    private double chemistry; // The mark for chemistry subject


    /**
     * Constructs a new Student object.
     */
    public Student() {
    }

    /**
     * Constructs a new Student object with the provided information
     * @param name the name of the student
     * @param className the class name of the student
     * @param math the math score of the student
     * @param physical the physical score of the student
     * @param chemistry the chemistry score of the student
     */
    public Student(String name, String className, double math, double physical, double chemistry) {
        this.name = name;
        this.className = className;
        this.math = math;
        this.physical = physical;
        this.chemistry = chemistry;
    }

    /**
     * Returns the name of the student
     * @return the name of the student
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the student
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the className of the student
     * @return the ClassName of the student
     */
    public String getClassName() {
        return className;
    }

    /**
     * Sets the className of the student
     * @param className the className to set
     */
    public void setClassName(String className) {
        this.className = className;
    }

    /**
     * Returns mark of the math of the student
     * @return the student's math mark
     */
    public double getMath() {
        return math;
    }

    /**
     * Sets the math of the student
     * @param math the math to set
     */
    public void setMath(double math) {
        this.math = math;
    }

    /**
     * Returns mark of the physical of the student
     * @return the student's physical mark
     */
    public double getPhysical() {
        return physical;
    }

    /**
     * Sets the physical of the student
     * @param physical the physical to set
     */
    public void setPhysical(double physical) {
        this.physical = physical;
    }

    /**
     * Returns mark of the chemistry of the student
     * @return the student's chemistry mark
     */
    public double getChemistry() {
        return chemistry;
    }

    /**
     * Sets the chemistry of the student
     * @param chemistry the chemistry to set
     */
    public void setChemistry(double chemistry) {
        this.chemistry = chemistry;
    }

    /**
     * Determines the type of the student based on the average mark
     * @param avg the average mark
     * @return the type of the student (A, B, C, D)
     */
    public String getType(double avg) {
        if (avg > 7.5) { //If the average mark is greater than 7.5
            return "A";
        } else if (avg >= 6) { //If the average mark is greater or equal to 6
            return "B";
        } else if (avg >= 4) { //If the average mark is greater than 4
            return "C";
        } else { //If the average mark is less than 4
            return "D";
        }
    }

    /**
     * Calculates and returns the average mark of the student.
     * @return the average score
     */
    public double getAVG() {
        //Create variable avg to calculate average of three subjects
        double avg = (math + physical + chemistry) / 3;
        //Returns the average mark
        return avg;
    }

    /**
     * Prompts the user to input a string and returns the input value after
     * performing validation checks.
     * @param msg the message to display as a prompt for input
     * @return the validated input string
     */
    public String inputString(String msg) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print(msg + ": ");
            String value = sc.nextLine().trim();
            //Convert the string value to a character array.
            char[] arr = value.toCharArray();
            //Check the length of the value
            if (value.length() == 0) {
                System.out.println(msg + " cannot be empty!!");
            } else {
                try {
                    //Check if value is a number
                    Double.parseDouble(value);
                    System.out.println(msg + " must not a number!!");
                } catch (NumberFormatException e) {
                    // Check if the value contains special characters
                    if (((int) arr[0] >= 33 && (int) arr[0] <= 47)
                            || ((int) arr[0] >= 58 && (int) arr[0] <= 64)
                            || ((int) arr[0] >= 123 && (int) arr[0] <= 126)) {
                        /**
                         * If the value of value contains special characters, it
                         * is an invalid string
                         */
                        System.out.println(msg + " must not a special character!");
                    } else {
                        //If the value is a valid string, return the value
                        return value;
                    }
                }
            }
        }
    }

    /**
     * Prompts the user to input a mark and returns the validated mark value.
     * @param msg the message to display as a prompt for input
     * @return the validated mark value
     */
    public double inputMark(String msg) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.print(msg + ": ");
                String tmpString = sc.nextLine();
                //Check if result is a number
                double result = Double.parseDouble(tmpString);
                if (result < 0) {
                    //If the result is a number greater than equal zero
                    System.out.println(msg + " is greater than equal zero!!");
                    continue;
                } else if (result > 10) {
                    //If the result is a number less than equal ten
                    System.out.println(msg + " is less than equal ten!!");
                    continue;
                }
                //If the result is a valid number, return the result
                return result;
            } catch (NumberFormatException e) {
                //If the result is a string
                System.out.println(msg + " is digit!!");
            }
        }
    }
}
