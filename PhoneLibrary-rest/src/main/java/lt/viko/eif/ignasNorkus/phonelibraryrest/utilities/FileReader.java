package lt.viko.eif.ignasNorkus.phonelibraryrest.utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Class that deals with file reading
 */
public class FileReader {
    /**
     * Reads a file based on it path
     * @param filePath path to the file
     * @return String data
     */
    public static String readFile(String filePath) {
        String dataRead = "";
        try {
            File myObj = new File(filePath);
            try (Scanner myReader = new Scanner(myObj)) {
                while (myReader.hasNextLine()) {
                    dataRead += myReader.nextLine();
                    dataRead += "\n";
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return dataRead;
    }
}
