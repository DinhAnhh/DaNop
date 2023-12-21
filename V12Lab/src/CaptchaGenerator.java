import java.util.Random;
import java.util.Scanner;

/*
 * this class will create a random character for user to input
 */
public class CaptchaGenerator {
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final int CAPTCHA_LENGTH = 6;

    /**
     * Generates a random captcha string.
     *
     * @return The generated captcha string.
     */
    Scanner sc = new Scanner(System.in);
    
/**
 * this method will generate captcha 
 * @return captcha to user
 */
    public static String generateCaptcha() {
        StringBuilder captcha = new StringBuilder();
        Random random = new Random();
/* prompt loop to add a single character in to string  */
        for (int i = 0; i < CAPTCHA_LENGTH; i++) {
            int index = random.nextInt(CHARACTERS.length());
            captcha.append(CHARACTERS.charAt(index));
        }

        return captcha.toString();
    }

    /**
     * Validates a user-provided captcha.
     *
     * @param userInput The user's input for the captcha.
     * @param captcha   The generated captcha to validate against.
     * @return True if the user's input matches the captcha, false otherwise.
     */

    public static boolean validateCaptcha(String userInput, String captcha) {
        return userInput.equalsIgnoreCase(captcha);
    }

}
