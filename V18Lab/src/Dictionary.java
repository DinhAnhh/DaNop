import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * This class is Dictionary contain add the word, remove and translate
 * 
 */
public class Dictionary {
    private Map<String, String> dict;
    Validation va = new Validation();

    /**
     * Constructor for the Dictionary class.
     * Initializes a new instance of the class and loads data from a file.
     * 
     * @throws IOException if there is an error loading the data.
     */
    public Dictionary() throws IOException {
        dict = new HashMap<>();
        loadData();

    }

    /**
     * Loads data from a text file into the dictionary.
     * The file path is hardcoded in the method.
     * 
     * @throws IOException if there is an error reading the file.
     */
    private void loadData() throws IOException {
        // Load data from a text file into the dictionary
        File f = new File("E:\\2023\\Summer2023\\LAB\\V18Lab\\src\\dictionary.txt");
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        // Read each line from the file and add words to the dictionary
        while (true) {
            String line = br.readLine();
            // Check if the line is null or empty, and break the loop if true
            if (line == null || line.isEmpty())
                break;
            // Split the line into an array of words
            String[] words = line.split("[-]");
            // Extract the English and Vietnamese words from the array, trimming any
            // whitespace
            String eng = words[0].trim(), vi = words[1].trim();
            // Add the English word as the key and the Vietnamese word as the value to the
            // dictionary
            dict.put(eng, vi);
        }

        br.close();
        fr.close();

    }

    /**
     * This class will save the data from the dictionary to a text file.
     * The file path is hardcoded in the method.
     * 
     * @throws IOException if there is an error writing to the file.
     */
    private void saveData() throws IOException {
        // Save the data from the dictionary to a text file

        File f = new File("E:\\2023\\Summer2023\\LAB\\V18Lab\\src\\dictionary.txt");
        FileWriter fw = new FileWriter(f);
        BufferedWriter bw = new BufferedWriter(fw);
        // Iterate over each entry in the dictionary and write it to the file

        for (Map.Entry<String, String> entry : dict.entrySet()) {
            bw.write(entry.getKey() + "-" + entry.getValue()); // for each word entry into dictionary will add "-"
                                                               // between 2 word
        }

        bw.close();
        fw.close();
    }

    /**
     * This class will add a new word into dictionary and check if the word is
     * already exist or not.
     * 
     * @throws IOException if there is an error saving the data to the file.
     */
    public void addWord() throws IOException {
        System.out.println("---------Add----------");
        String eng = va.getString("Enter English: "); 
            for (String key : dict.keySet()) {
            while(key.equalsIgnoreCase(eng)&& !va.getYN(eng + "is already exist. Do you want to update (Y/N): ")) {// * If the English word already exists in the dictionary and the
                                                      // user chooses not to update it,the method returns without making
                                                      // any changes.        
            eng = va.getString("Enter English: "); 

            }
        }
        String vi = va.getString("Enter Vietnamese: ");
        dict.put(eng, vi);

        saveData(); // After adding the word, the data is saved to a text file.
        System.out.println("ADD SUCCESSFUL!!"); // * Prints a success message upon successful addition.

    }

    /**
     * 
     * This class will remove a word from the dictionary.
     * 
     * @throws IOException if there is an error saving the data to the file.
     */
    public void removeWord() throws IOException {
        System.out.println("---------Delete---------");
        String eng = va.getString("Enter English: "); // Prompts the user to enter the English word to be removed.
        for (String key : dict.keySet()) { //check if eng is contained
            if (!key.equalsIgnoreCase(eng)) {
                System.err.println("Not found"); // If the word is not found in the dictionary, an error message is
                // displayed and the method returns.

                return;

            }
        }

        dict.remove(eng);
        // Otherwise, the word is removed from the dictionary, the data is saved to a
        // text file, and a success message is printed.
        saveData();
        System.out.println("Delete successful!!");
    }

    /**
     * This class wil translates an English word to Vietnamese.
     */
    public void translate() {
        System.out.println("---------------Translate-----------");
        String eng = va.getString("Enter English: "); // Prompts the user to enter an English word for translation.
        for (String key : dict.keySet()) {
            if (!key.equalsIgnoreCase(eng)) {  //check if eng is contained
                System.err.println("Not found");

                return;

            }
        }

        // Otherwise, it retrieves the corresponding Vietnamese translation from the
        // dictionary and prints it.
        System.out.println("Vietnamese: " + dict.get(eng));
    }

}
