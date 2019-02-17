
import java.util.Scanner;

/**
 * A class to print the tree out in alphabetical order.
 *
 * @author 689591
 */
public class AlphaMain {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter a profile file to open:");
        String filename = input.next();
        BST tree = FileReader.readProfiles(filename);

        tree.printAlphabetical();
        input.close();
    }
}
