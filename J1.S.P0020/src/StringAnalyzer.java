import java.util.ArrayList;
import java.util.List;

public class StringAnalyzer {
    
    //Create an ArrayList object to store the integers found in the string
    List<Integer> numbers = new ArrayList<>();
    
    /**
     * Extracts numbers from the input string and returns a list of integers
     * @param input the input string to extract numbers from
     * @return  a list of integers containing the extracted numbers
     */
    public List<Integer> extractNumbers(String input) {
        StringBuilder numberBuilder = new StringBuilder();
        //Loop through each character in the input string
        for (char c : input.toCharArray()) {
            //Check if current character is a digit
            if (Character.isDigit(c)) {
                //If it is a digit, add this character to the substring
                numberBuilder.append(c);
            } else if (numberBuilder.length() > 0) {
                /**
                 * If the current character is not a digit and there is already 
                 * at least one character in the substring
                 */
                int number = Integer.parseInt(numberBuilder.toString());
                numbers.add(number);
                /**
                 * Delete the contents of the substring to prepare for the 
                 * next substring
                 */
                numberBuilder.setLength(0);
            }
        }
        if (numberBuilder.length() > 0) {
            //Convert substring to an integer
            int number = Integer.parseInt(numberBuilder.toString());
            numbers.add(number); //Add integers to a list of numbers
        }
        //Returns a list of integers found in a string
        return numbers;
    }

    /**
     * Filters the given list of numbers and returns a new list containing only 
     * the even numbers
     * @return a list of even numbers
     */
    public List<Integer> filterEvenNumbers() {
        //Create an ArrayList object to store even numbers
        List<Integer> evenNumbers = new ArrayList<>();
        numbers.stream().filter((number) -> (number % 2 == 0)).forEachOrdered((number) -> {
            //Add even numbers to the list of even numbers
            evenNumbers.add(number);
        });
        //Returns a new list containing only even numbers
        return evenNumbers;
    }

    /**
     * Filters the given list of numbers and returns a new list containing only 
     * the odd numbers
     * @return a list of odd numbers
     */
    public List<Integer> filterOddNumbers() {
        //Create an ArrayList object to store odd numbers
        List<Integer> oddNumbers = new ArrayList<>();
        numbers.stream().filter((number) -> (number % 2 != 0)).forEachOrdered((number) -> {
            //Add odd numbers to the list of odd numbers
            oddNumbers.add(number);
        });
        //Returns a new list containing only odd numbers
        return oddNumbers;
    }

    /**
     * Filters and returns a list of square numbers from the given list of numbers
     * @return a new list containing the square numbers
     */
    public List<Integer> filterSquareNumbers() {
        //Create an ArrayList object to store the squared numbers.
        List<Integer> squareNumbers = new ArrayList<>();
        //Use the forEach method to iterate over each number in the input integer list.
        numbers.forEach((number) -> {
            int sqrt = (int) Math.sqrt(number);
            if (sqrt * sqrt == number) {
                /**
                 * Checks if the square of the square root is equal to the 
                 * original number
                 */
                squareNumbers.add(number);
            }
        });
        //Returns a new list containing only squared numbers
        return squareNumbers;
    }

    /**
     * Extracts and returns a string containing all the special characters from 
     * the input string
     * @param input the input string to extract special characters from
     * @return a string containing all the special characters
     */
    public String extractSpecialCharacters(String input) {
        //Create a StringBuilder object to construct the resulting string
        StringBuilder result = new StringBuilder();
        //Loop through each character in the input string
        for (char c : input.toCharArray()) {
            if (!Character.isLetterOrDigit(c) && c != ' ') {
                /**
                 * Check if the character is not a letter or a number and 
                 * is not a space
                 */
                result.append(c);
            }
        }
        //Returns a new list containing only special character
        return result.toString();
    }

    /**
     * Extracts and returns a string containing all the characters from the 
     * input string
     * @param input the input string to extract characters from
     * @return a string containing all the characters
     */
    public String extractAllCharacter(String input) {
        //Create a StringBuilder object to construct the resulting string
        StringBuilder result = new StringBuilder();
        //Loop through each character in the input string
        for (char c : input.toCharArray()) {
            //Checks if the character is not a digit.
            if (!Character.isDigit(c)) {
                //Add current character to the resulting string
                result.append(c);
            }
        }
        //Returns a new list containing all character
        return result.toString();
    }
}
