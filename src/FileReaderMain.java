
import java.util.Scanner;

/**
 * A class to test the FileReader class.
 *
 * @author 689591
 */
public class FileReaderMain {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter a profile file to open:");
        String filename = input.next();
        BST readProfiles = FileReader.readProfiles(filename);

        readProfiles.printAlphabetical();
        input.close();
    }
}
