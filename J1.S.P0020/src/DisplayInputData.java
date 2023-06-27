import java.util.List;
public class DisplayInputData {

    StringAnalyzer analyze = new StringAnalyzer();

    /**
     * Performs analysis on the input string and displays the results.
     * @param input the input string to analyze
     */
    public void performAnalysis(String input) {
        List<Integer> numbers = analyze.extractNumbers(input);

        // Display the square numbers
        System.out.println("Square Numbers: " + analyze.filterSquareNumbers());

        // Display the odd numbers
        System.out.println("Odd Numbers: " + analyze.filterOddNumbers());

        // Display the even numbers
        System.out.println("Even Numbers: " + analyze.filterEvenNumbers());

        // Display all the numbers
        System.out.println("All Numbers: " + numbers);

        // Display the uppercase characters
        System.out.println("Uppercase characters: " + input.replaceAll("[^A-Z]", ""));

        // Display the lowercase characters
        System.out.println("Lowercase characters: " + input.replaceAll("[^a-z]", ""));

        // Display the special characters
        System.out.println("Special characters: " + analyze.extractSpecialCharacters(input));

        // Display all the characters
        System.out.println("All characters: \n" + analyze.extractAllCharacter(input));

        // Exit the program
        System.exit(0);
    }
}
