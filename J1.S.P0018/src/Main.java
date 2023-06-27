
public class Main {

    public static void main(String[] args) {
        // Create instances of the validator classes
        CheckPhone c = new CheckPhone();
        CheckEmail e = new CheckEmail();
        CheckDate d = new CheckDate();

        // Validate phone number
        c.checkPhone();

        // Validate email
        e.checkEmail();

        // Validate date
        d.checkDate();

    }
}
