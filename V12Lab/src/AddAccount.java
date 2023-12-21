
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * this class will add user into the list
 */
public class AddAccount {

    // Create list of user
    List<Account> listAccounts = new ArrayList<>();

    /**
     * Adds a new user to the list.
     * Check if user code already exists then show message.
     * If it does not exist, continue to enter the user's information
     */

    public void addAccount() {
        Scanner sc = new Scanner(System.in);
        System.out.println("---------" + Language.labels.getString("Add") + "----------");
        boolean temp = false;
        boolean isCodeExist = false;
        Account wr = new Account();
        String tmp = null;
        while (true) {
            tmp = wr.inputString(Language.labels.getString("ID"));
            // Check if the list is empty
            if (listAccounts.isEmpty()) {
                break;
            } else {
                for (Account c : listAccounts) {
                    // Check if a account code exists
                    if (c.getAccount().equalsIgnoreCase(tmp)) {
                        // If the worker code already exists
                        System.out.println(Language.labels.getString("ExistID"));
                        isCodeExist = false;
                        break;
                    } else {
                        // If the account code does not exist yet
                        isCodeExist = true;
                    }
                }
                if (isCodeExist == true) {
                    // If the worker code is satisfied
                    break;
                }

            }
        }

        // this is information for user to input
        String ID = tmp;
        String name = wr.inputString(Language.labels.getString("Name"));
        String password = wr.inputString(Language.labels.getString("Password"));
        // Save the user's information to the list
        listAccounts.add(new Account(ID, name, password));
        System.out.println(Language.labels.getString("Success"));
        while (true) {
            // Check if you want to import more user
            System.out.print(Language.labels.getString("addMore"));
            String choose = sc.nextLine();
            if (choose.equalsIgnoreCase(Language.labels.getString("N"))) {
                showTable();
                temp = true;
                break;
            } else if (!choose.equalsIgnoreCase(Language.labels.getString("Y"))) {
                // If it is another option, the message will be displayed again
                System.out.println(Language.labels.getString("Only"));
            } else {
                // If Y is selected, continue to enter more user
                break;
            }

        }

        if (temp == true) {
            System.exit(0);
        }

    }

    /**
     * this method will show list of user
     */

    public void showTable() {

        if (listAccounts.isEmpty()) {
            System.out.println("Empty list of User!");
        } else {
            System.out.println("######## Result ########");
            System.out.println("+-----------+----------------+-------------+");
            System.out.println("|    ID     |      Name      |   Password  |");
            System.out.println("+-----------+----------------+-------------+");
            for (int i = 0; i < listAccounts.size(); i++) {
                Account o = listAccounts.get(i);
                System.out.printf("|%-11s|%-16s|%-13s|\n", listAccounts.get(i).getAccount(),
                        listAccounts.get(i).getName(), listAccounts.get(i).getPassword());
            }
            System.out.println("+-----------+----------------+-------------+");
        }
    }

}
