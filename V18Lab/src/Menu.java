import java.io.IOException;

/*
 * this class Menu will show for user input their choice
 */
public class Menu {
    Validation va = new Validation();
    private String[] ops = {
            "Add Word",
            "Delete Word",
            "Translate Word",
            "Exit"
    };

    /**
     * Displays the menu and handles user input.
     * 
     * @throws IOException if there is an error during input/output operations.
     */
    public void display() throws IOException {
        Dictionary d = new Dictionary();

        int choice;
        do {
            System.out.println("=========Dictionary program=========");
            for (int i = 0; i < ops.length; i++) {
                System.out.println((i + 1) + ". " + ops[i]);
            }
            choice = va.getInt("Choose: ", 1, ops.length);

            switch (choice) {
                case 1:
                    d.addWord();
                    break;
                case 2:
                    d.removeWord();
                    break;
                case 3:
                    d.translate();
                    break;
                case 4:
                    System.exit(0);
                    break;

            }
        } while (choice != ops.length);
    }

}
