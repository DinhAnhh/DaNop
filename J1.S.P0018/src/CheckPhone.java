import java.util.Scanner;

public class CheckPhone {
    /**
     * @return a string number of phone 
     */
    public String checkPhone() {

        System.out.print("Phone Number: ");

        Scanner scanner = new Scanner(System.in);
        String Phone = scanner.nextLine();

        boolean isValid = false; 

        do {
            try { //// it will require user input again

                if (Phone.length() != 10 || !Phone.matches("^0[1-9][0-9]{8}$") ) {

                    throw new Exception("Phone number must be 10 digits"); // if length different from 10 or it contain digit, the message will throw exception
                } else {

                    isValid = true; // the phone is right format --> isValid value is true
                }
            } catch (Exception e) {  //if it is exception , the message will display
                System.out.println(e.getMessage()); 
                System.out.print("Phone Number: ");
                Phone = scanner.nextLine();
                

            }
        } while (!isValid); // loop until isValid true.

        return Phone.toString();


    }



}
