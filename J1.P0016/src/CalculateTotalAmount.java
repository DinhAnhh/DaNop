import java.util.Scanner;

public class CalculateTotalAmount {

    /**
     * Constructs a new CalculateTotalAmount object.
     */
    public CalculateTotalAmount() {
        Person person = new Person();
        int totalBillsAmount = 0;
        System.out.println("======= Shopping program ==========");
        //Enter the bill amount
        int number = inputInt("input number of bill: ");
        //Loop to enter each price of each bill
        for (int i = 1; i <= number; i++) {
            int bill = inputInt("input value of bill " + i + ": ");
            //Calculate the total amount of the bill
            totalBillsAmount += bill;
        }
        //Enter the amount in the wallet
        person.getWallet().setAmount(inputInt("input value of wallet: "));
        System.out.println("------------------------------");
        System.out.println("this is total of bill: " + totalBillsAmount);
        if (totalBillsAmount > person.getWallet().getAmount()) {
            //If the amount in the wallet is less than the total amount of the bill
            System.out.println("You can’t buy it.");
        } else if(totalBillsAmount == 0){
            //If the amount in the wallet is greater than or equal to the total amount of the bill
            System.out.println("No bill for you to buy.");
        } else {
            //If the amount in the wallet is greater than or equal to the total amount of the bill
            System.out.println("You can buy it.");
        }
    }

    /**
     * Prompts the user to input an integer value.
     * @param msg the message to display as a prompt
     * @return the input integer value
     */
    public int inputInt(String msg) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.print(msg);
                String tmpString = sc.nextLine();
                int result = Integer.parseInt(tmpString);
                if(result <= 0){
                    //Check if value less than 0
                    System.out.println("Must be a positive number!!");
                }else{
                    //Return value if valid
                    return result;
                }
            } catch (NumberFormatException e) {
                //If the input value is not a number
                System.out.println("Must be a number!!");
            }
        }
    }
}
