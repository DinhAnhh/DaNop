import java.util.Scanner;

public class Doctor {

    String Code;
    String Name;
    String Specialization;
    int Availability;

    /**
     * Generate default constructor.
     */
    public Doctor() {
    }

    /**
     * Generate constructor with parameter
     *
     @param Code the code of the doctor
     * @param Name the name of the doctor
     * @param Specialization the specialization of the doctor
     * @param Availability the availability of the doctor
     */
    public Doctor(String Code, String Name, String Specialization, int Availability) {
        this.Code = Code;
        this.Name = Name;
        this.Specialization = Specialization;
        this.Availability = Availability;
    }

    /**
     * Get the code of doctor
     *
     * @return the code of the doctor
     */
    public String getCode() {
        return Code;
    }

    /**
     * Set the code of doctor after get
     *
     * @param Code Code the code of the doctor
     */
    public void setCode(String Code) {
        this.Code = Code;
    }

    /**
     * Get the name of doctor
     *
     * @return the name of the doctor
     */
    public String getName() {
        return Name;
    }

    /**
     * Set the name of doctor after get
     *
     * @param Name Name the name of the doctor
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * Get the specialization of doctor
     *
     * @return the specialization of the doctor 
     */
    public String getSpecialization() {
        return Specialization;
    }

    /**
     * Set the specialization of doctor after get
     *
     * @param Specialization the specialization of the doctor
     */
    public void setSpecialization(String Specialization) {
        this.Specialization = Specialization;
    }

    /**
     * Get the getAvailability of doctor
     *
     * @return the availability of the doctor
     */
    public int getAvailability() {
        return Availability;
    }

    /**
     * Set the availability of doctor after get
     *
     * @param Availability the availability of the doctor   
     */
    public void setAvailability(int Availability) {
        this.Availability = Availability;
    }

    /**
     * Input Name of doctor and check error from user.
     *
     * @return  the name of the doctor
     */
    public String inputName() {
        boolean check = false;
        System.out.print("Enter Name: ");
        Scanner sc = new Scanner(System.in);
        do {
            try {
                check = false;
                Name = sc.nextLine();
                if (Name.trim().equals("")) {
                    System.out.print("-------Error!Please enter Name again(Not Null): ");
                    check = true;
                }

            } catch (Exception e) {
                System.out.print("-------Error!Please enter Name again(Not Null): ");
            }
        } while (check);
       
        return Name; // the name of the doctor
    }

    /**
     * Input specialization and check error from user.
     * 
     * @return  the name of the doctor
     */
    public String inputSpecialization() {
        boolean check = false;
        System.out.print("Enter Specialization: ");
        Scanner sc = new Scanner(System.in);
        do {
            try {
                check = false;
                Specialization = sc.nextLine();
                if (Specialization.trim().equals("")) {
                    System.out.print("-------Error!Please enter Specialization again(Not null):");
                    check = true;
                }

            } catch (Exception e) {
                System.out.print("-------Error!Please enter Specialization again(Not null):");
            }
        } while (check);
        
        return Specialization; // the Specialization of the doctor
    }

    /**
     * Input availability and check error from user.
     *
     * @return  Availability of the doctor
     */
    public int inputAvailability() {
        // boolean check = false;

        System.out.print("Enter Availability: ");
        Scanner sc = new Scanner(System.in);
        do {
            try {
                // check = false;
                Availability = Integer.parseInt(sc.nextLine());
                if (Availability <= 0) {
                    System.out.println("-------Error!Availability mut be greater than 0!");
                    System.out.print("Please enter Availability again: ");

                    //    check = true;
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                //      sc.nextLine();
                System.out.println("-------Error!Availability mut be greater than 0! ");
                System.out.print("Please enter Availability again: ");
            }
        } while (true);
        return Availability;
    }

    /**
     * Input search value and check error
     *
     * @return
     */
    public static String inputSearchValue() {
        String searchValue;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Enter Name: ");
            searchValue = sc.nextLine();
            if (searchValue.isEmpty()) {
                System.out.println("Search value can't be empty!");
            }
        } while (searchValue.isEmpty());
        return searchValue;
    }

    /**
     * Input name, specialization, availability.
     */
    public void inputDoctor() {
        inputName();
        inputSpecialization();
        inputAvailability();
    }

}
