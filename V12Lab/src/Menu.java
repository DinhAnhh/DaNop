
import java.util.Scanner;

/* this class is a menu for user */
public class Menu {
    /**
     * this show will display menu for user to input and choose menu
     * @throws Exception
     */
    public void show() throws Exception {
        Scanner input = new Scanner(System.in);

        /** Display all menu */
        while (true) {
            System.out.println("-----Login Program------");
            System.out.println("1. Vietnamese");
            System.out.println("2. English");
            System.out.println("3. Exit");
            Language language = new Language();
            AddAccount ac = new AddAccount();
            boolean x = false;
            int Code = input.nextInt();
            /**
             * This Code value is the value from user's input.
             * prompt the loop to input until right way.
             */
             

            while (true) {
               
                    if (Code == 1) {
                        language.setLocale(1); // if Code is 1, it will call setLocale method with n in setLocale is 1
                        ac.addAccount(); // call addAccount to create account and add it in to arraylist
                        ac.showTable();
                        x=true; //x is true to exit the loop
                       

                    } else if (Code == 2) {
                        language.setLocale(2); // if Code is 2, it will call setLocale method with n in setLocale is 2
                        ac.addAccount(); ; // call addAccount to create account and add it in to arraylist
                        ac.showTable(); // after add account, will present table to user
                        x=true; //x is true to exit the loop
                       

                    } 
                    else{
                        System.out.println("Please choice other!!");
                        x =false; //x is false to stay the loop
                    }
            
                } 

            }

        }
    }

