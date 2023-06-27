
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
public class StudentManager {

    //Create list of Student
    List<Student> list = new ArrayList<>();

    /**
     * Prompts the user to input student information and adds it to the list.
     * Displays the list of students and the percentage of each type of student.
     */
    public void addStudentInformation() {
        boolean tmp = false;
        Scanner sc = new Scanner(System.in);
        System.out.println("====== Management Student Program =======");
        while (true) {
            Student st = new Student();
            // Prompt for name and input validation
            String name = st.inputString("Name");

            // Prompt for class and input validation
            String classes = st.inputString("Classes");

            // Prompt for math mark and input validation
            double math = st.inputMark("Maths");

            // Prompt for chemistry mark and input validation
            double chemistry = st.inputMark("Chemistry");

            // Prompt for physical mark and input validation
            double physical = st.inputMark("Physical");

            // Add student to the list
            addStudent(name, classes, math, physical, chemistry);

            // Check if the user wants to add another student
            while (true) {
                //Check if you want to import more students
                System.out.print("Do you want to enter more student information?(Y/N): ");
                String choose = sc.nextLine();
                if (choose.equalsIgnoreCase("N")) {
                    tmp = true;
                    break;
                } else if (!choose.equalsIgnoreCase("Y")) {
                    //If it is another option, the message will be displayed again
                    System.out.println("Only choose Y or N!!");
                }else{
                    //If Y is selected, continue to enter more students
                    break;
                }
            }
            if(tmp == true){
                System.exit(0);
            }
        }
        // Display the list of students
        display();
        // Calculate and display the percentage of each type of student
        HashMap<String, Double> mapStudent = getPercentTypeStudent();
        mapStudent.forEach((key, value) -> System.out.println(key + ": " + value + "%"));
    }

    /**
     * Adds a new student to the list of students
     * @param name the name of the student
     * @param className the class name of the student
     * @param math the math mark of the student
     * @param chemistry the chemistry mark of the student
     * @param physical the physical mark of the student
     */
    public void addStudent(String name, String className, double math,
            double chemistry, double physical) {
        //Add student information to the list
        list.add(new Student(name, className, math, physical, chemistry));
    }

    /**
     * Displays the information of all students in the list.
     */
    public void display() {
        int index = 1;
        //The loop that iterates over each Student object in the list collection.
        for (Student student : list) {
            //Prints the student information
            System.out.println("------ Student " + index + " Info ------");
            System.out.println("Name: " + student.getName());
            System.out.println("Classes: " + student.getClassName());
            double avg = (student.getMath() + student.getPhysical() + student.getChemistry()) / 3;
            System.out.printf("AVG: %.2f\n", avg);
            System.out.println("Type: " + student.getType(avg));
            index++;
        }
    }

    /**
     * Calculates the percentage of each student type in the list
     * @return a HashMap containing the percentage of each student type (A, B,
     * C, D)
     */
    public HashMap<String, Double> getPercentTypeStudent() {
        HashMap<String, Double> hashMap = new HashMap<>();
        //Creates a new HashMap object called hashMap to store the grade classifications
        int countA = 0;
        int countB = 0;
        int countC = 0;
        int countD = 0;
        //The loop that iterates over each Student object in the list collection
        for (Student student : list) {
            /**
             * Check the average score of each student and increment the 
             * corresponding count variable based on the score.
             */
            if (student.getAVG() > 7.5) {
                countA++;
            } else if (student.getAVG() >= 6) {
                countB++;
            } else if (student.getAVG() >= 4) {
                countC++;
            } else {
                countD++;
            }
        }
        int totalStudent = list.size();
        //Prints a header for the classification information.
        System.out.println("--------Classification Info -----");
        //Calculate the percentage of students in each grade classification
        hashMap.put("A", Math.round(100.0 * countA / totalStudent * 100.0) / 100.0);
        hashMap.put("B", Math.round(100.0 * countB / totalStudent * 100.0) / 100.0);
        hashMap.put("C", Math.round(100.0 * countC / totalStudent * 100.0) / 100.0);
        hashMap.put("D", Math.round(100.0 * countD / totalStudent * 100.0) / 100.0);
        //Returns the hashMap containing the grade classifications and their corresponding percentages.
        return hashMap;
    }
}
