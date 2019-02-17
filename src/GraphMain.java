
import java.util.Scanner;

/**
 * A class to test the Graph class.
 *
 * @author 689591
 */
public class GraphMain {

    public static void main(String[] args) {
        //Construct a binary search tree
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter a profile file to open:");
        String filename = input.next();
        BST tree = FileReader.readProfiles(filename);

        //Construct a graph
        System.out.println("Please enter a friendship file to open:");
        filename = input.next();
        Graph graph = new Graph(filename, tree);

        //Find the common friend
        System.out.print("\nPlease enter two names to find the common friends of them.\nThe first name: ");
        String name1 = input.next();
        System.out.print("The second name: ");
        String name2 = input.next();

        tree = graph.commonFriends(tree.searchProfile(name1), tree.searchProfile(name2));
        System.out.println("\nCommon friend of " + name1 + " and " + name2 + ":");
        tree.printAlphabetical();

        input.close();
    }
}
