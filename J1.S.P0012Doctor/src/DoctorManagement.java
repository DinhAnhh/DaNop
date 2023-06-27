import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
this class is for managing doctor
 */
public class DoctorManagement {

    static Scanner sc = new Scanner(System.in);
    ArrayList<Doctor> doctor = new ArrayList<>();

    Doctor dt = new Doctor();
    String Code;
    int NumberOfDoctor = 0;
    String Name;
    String Specialization;
    int Availability;

    /**
     * Menu for user to choose function .
     */
    void menu() {
        int choice;
        // Display menu description
        System.out.print("----------MENU----------\n"
                + "1.Add Doctor.\n"
                + "2.Update Doctor.\n"
                + "3.Delete Doctor.\n"
                + "4.Search Doctor.\n"
                + "5.Exit.\n"
                + "Please choose: ");

        do {
            try {
                choice = sc.nextInt(); // Input choice
                sc.nextLine(); // Fix ENTER key
                if (choice < 1 || choice > 5) { // check if choice > 2
                    System.out.println("Choice must be from 1 to 5!");
                    System.out.print("Please choose: ");
                } else {
                    break;
                }
            } catch (InputMismatchException err) {
                sc.nextLine();
                System.out.println("Choice must be from 1 to 5!");
                System.out.print("Please choose: ");
            }   
        } while (true);
        try {
            switch (choice) {

                case 1: // Add new employee and call menu again
                    System.out.println("--------- ADD Doctor -------");
                    add();
                    menu();
                    break;
                case 2: // Show all available employees and call menu again
                    System.out.println("--------- UPDATE Doctor -------");
                    displayDoctorsList(doctor);
                    updateDoctor();
                    displayDoctorsList(doctor);
                    menu();
                    break;
                case 3:// Delete doctor
                    
                    System.out.println("--------- Delete Doctor -------");
                    displayDoctorsList(doctor);
                    deleteDoctor();
                  displayDoctorsList(doctor);
                    menu();
                    break;
                case 4:// To search doctor
                    System.out.println("--------- SEARCH Doctor -------");
                    searchDoctor();
                    menu();
                    break;
                case 5:// to end program
                    System.out.println("SEE YOU AGAIN");
                    break;
            }
        } catch (Exception e) {
            // System.out.println("There is no doctor!!!!");
            menu();
        }

    }

    /**
     * Input code and check error.
     *
     * @return code of the doctor
     */
    public String inputCode() {
        System.out.print("Enter Code: ");
        Scanner sc = new Scanner(System.in);
        do {
            try {

                Code = sc.nextLine();
                if (Code.trim().equals("")) {
                    System.out.print("-------Error!Please enter CODE again(Not Null): ");
                } else if (idExist(Code)) {
                    System.out.println("-------Error!CODE is Exist!");
                    System.out.print("Enter CODE: ");
                }
            } catch (Exception e) {
                System.out.print("-------Error!Please enter CODE again(Not Null): ");
            }
        } while (Code.trim().equals("") || idExist(Code));

        return Code;
    }

    /**
     * Add Doctor into array list.
     */
    public void add() {
        inputCode();
        dt.inputDoctor();

        doctor.add(
                new Doctor(Code, dt.getName(), dt.getSpecialization(), dt.getAvailability())); // add employee into
                                                                                               // ArrayList
        NumberOfDoctor++;
    }

    /**
     * Check ID Exist
     *
     * @param Code is string from user to input
     * @return String of valid code
     */
    public boolean idExist(String Code) {
        for (int i = 0; i < doctor.size(); i++) {
            Doctor q = doctor.get(i);
            if (q.getCode().equals(Code)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Delete doctor function.
     */
    public void deleteDoctor() {
        if (doctor.isEmpty()) {
            System.out.println("There is no doctor now, please add a doctor!");
            return;
        }
        String Code;
        System.out.print("Enter Code: ");
        do {
               
            Code = sc.nextLine();
            if (!idExist(Code)) {
                System.out.println("Code didn't existed");
                System.out.print("Enter Code: ");
            }
        } while (!idExist(Code));
        doctor.remove(doctor.get(doctorIndex(Code)));
      
       
        System.out.println("Delete successfully !!");
       
       
       
    }

    /**
     * Delete doctor in array
     *
     * @param Code code of the doctor
     */
    public void delete(String Code) {
        for (Doctor doctor1 : doctor) {
            if (doctor1.getCode() == Code) {
                doctor.remove(doctor);

            }

        }
        NumberOfDoctor--;
    }

    /**
     * Get code of doctor from array list.
     */
    public int doctorIndex(String code) {
        // Loop through the doctor list and return the index based on code
        for (int i = 0; i < doctor.size(); i++) {
            if (code.equalsIgnoreCase(doctor.get(i).getCode())) {
                return i;
            }
        }
        return -1; // if code is not valid
    }

    /**
     * Update doctor function.
     */
    public void updateDoctor() {
        if (doctor.isEmpty()) {
            System.out.println("There is no doctor now, please add a doctor!");
            return;
        }
        String Code;
        System.out.print("Enter Code: ");
        do {
            Code = sc.nextLine();
            if (!idExist(Code)) {
                System.out.println("Code didn't existed!");
                System.out.print("Enter Code: ");
            }
        } while (!idExist(Code));
        Doctor updateDoctor = doctor.get(doctorIndex(Code));
        updateDoctor.setName(dt.inputName());
        updateDoctor.setSpecialization(dt.inputSpecialization());
        updateDoctor.setAvailability(dt.inputAvailability());
        displayDoctorsList(doctor);
        System.out.println("Update doctor successful!!!");
        displayDoctorsList(doctor);
    }

    /**
     * Get name of doctor from arraylist.
     */
    private boolean containQueryInName(String query) {
        for (Doctor doctor : doctor) { // Loop through list of doctors to check whether the doctor's name contain query
            if (doctor.getName().toLowerCase().contains(query.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Show header table.
     */
    private void headerDescription() {
        System.out.println("+----------+----------------+----------------+--------------+");
        System.out.println("| Code     | Name           | Specialization | Availability |");
        System.out.println("+----------+----------------+----------------+--------------+");
    }

    /**
     * Show doctor list.
     */

    private void displayDoctorsList(ArrayList<Doctor> doctorsList) {
        if (doctorsList.size() == 0) {
            System.out.println("There is no doctor now, please add a doctor!");
            return;
        }
        headerDescription();
        for (Doctor doctor : doctorsList) {
            System.out.printf("| %-9s", doctor.getCode());
            System.out.printf("| %-15s", doctor.getName());
            System.out.printf("| %-15s", doctor.getSpecialization());
            System.out.printf("| %-13d|", doctor.getAvailability());
            System.out.println();
        }
        System.out.println("+----------+----------------+----------------+--------------+");
    }

    /**
     * Search Doctor function.
     */
    public void searchDoctor() {
        if (doctor.isEmpty()) {
            System.out.println("There is no doctor now, please add a doctor!");
            return;
        }
        String query = dt.inputSearchValue();
        if (!containQueryInName(query)) { // if list of doctors' name does not contain the query
            System.out.println("There is no doctor with that query!");
            return;
        }
        ArrayList<Doctor> doctorsContainQuery = new ArrayList<>();
        for (Doctor doctor : this.doctor) { // Loop through the list to check whether doctors' name contain query
            if (doctor.getName().toLowerCase().contains(query.toLowerCase())) {
                doctorsContainQuery.add(doctor);
            }
        }
        displayDoctorsList(doctorsContainQuery);
    }

}
