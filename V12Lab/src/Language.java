
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

/*
 * this class will set language for user to choose.
 */
public class Language {
    public static ResourceBundle labels;

    /**
     * The setLocale method is for user to choose their language
     * 
     * @param n is number for user to input
     * @throws Exception is an event that interrupts the normal flow of the program.
     * 
     */
    public void setLocale(int n) throws Exception {
        /* Check the user's input to determine the language */
        if (n == 1) {
            /* Set the locale to Vietnamese and get key in message Vi properties */
            Locale locale = new Locale("vi", "VN");
            labels = ResourceBundle.getBundle("messages", locale);
        } else {
            /* Set the locale to English and get key in message En properties */
            Locale locale = new Locale("en", "US");
            labels = ResourceBundle.getBundle("messages", locale);
        }

        /* Create a scanner to read user input */
        Scanner scanner = new Scanner(System.in);

        /* Generate a captcha */
        String captcha = CaptchaGenerator.generateCaptcha();
        System.out.print(labels.getString("Captcha"));
        System.out.println(captcha);
        System.out.print(labels.getString("setCaptcha"));

        /* Validate the captcha entered by the user */

        String inputCaptcha = scanner.nextLine();
        while (CaptchaGenerator.validateCaptcha(inputCaptcha, captcha) != true) { // if user input wrong captcha this
                                                                                  // will check again and user must
                                                                                  // input again

            System.out.println(labels.getString("errorCaptcha"));

            System.out.print(labels.getString("setCaptcha"));

            inputCaptcha = scanner.nextLine();

        }
        System.out.println(labels.getString("correctCaptcha"));

    }

}
