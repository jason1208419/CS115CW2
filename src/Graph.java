
import java.io.*;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * A class that implements a graph.
 *
 * @author 689591
 */
public class Graph {

    private final ArrayList<Profile> nodes = new ArrayList<>();

    /**
     * Creates a graph with all friendships added.
     *
     * @param filename The name of the file with friendships.
     * @param tree The binary search tree with profiles.
     */
    public Graph(String filename, BST tree) {
        tree.toList(nodes);
        readFriendships(filename, tree);
    }

    /**
     * Method to read the file and connect 2 profiles.
     *
     * @param filename The name of the file.
     * @param tree The binary search tree with profiles.
     */
    private void readFriendships(String filename, BST tree) {
        Scanner in = null;

        File inputFile = new File(filename);

        try {//Open the file
            in = new Scanner(inputFile);
        } catch (FileNotFoundException e) {//Tell the user file does not exist if file not found
            System.out.println("Cannot open " + filename);
            System.exit(0);
        }

        readFileData(in, tree);
    }

    /**
     * Reads the data file used by the program.
     *
     * @param in The scanner of the file.
     * @param tree The binary search tree with profiles.
     */
    private void readFileData(Scanner in, BST tree) {
        Scanner lineReader;

        while (in.hasNext()) {//Read the next line if it exist
            String line = in.nextLine();
            lineReader = new Scanner(line);
            lineReader.useDelimiter(",");

            try {//Read data in a line
                readFileLine(lineReader, tree);
            } catch (NoSuchElementException e) {//Tell the user data is missing
                System.err.println("Some input data are missing!\nError line: " + line + "\n");
            }
        }
        in.close();
    }

    /**
     * Reads the data on a line used by the program.
     *
     * @param in The scanner of the file.
     * @param tree The binary search tree with profiles.
     */
    private void readFileLine(Scanner in, BST tree) {
        String name1 = in.next();
        String name2 = in.next();

        in.close();

        Profile profile1 = tree.searchProfile(name1);
        Profile profile2 = tree.searchProfile(name2);

        addFriendship(profile1, profile2);
    }
    
    /**
     * Connects 2 profiles.
     * @param a Profile of a person.
     * @param b Profile of a person.
     */
    private void addFriendship(Profile a, Profile b){
        if (a != null && b != null) {//Connect 2 profiles only if profiles exist
            a.addFriend(b);
            b.addFriend(a);
        } else {//Tell the user profiles does not exist
            System.out.println("ERROR: No Such Person!");
        }
    }

    /**
     * Methods to return a binary search tree that contains all common friends
     * that a and b share.
     *
     * @param a Profile of a person.
     * @param b Profile of a person.
     * @return A binary search tree that contains all common friends that a and
     * b share.
     */
    public BST commonFriends(Profile a, Profile b) {
        BST commonTree = new BST();
        if (a != null && b != null) {
            //search common friends only if both profiles exist
            
            for (int i = 0; i < a.numOfFriends(); i++) {
                //Start to look from the friend list of a

                if (a.getFriend(i).equals(b)) {
                    //Add a and b to the tree if they are friends
                    commonTree.insertProfile(a);
                    commonTree.insertProfile(b);
                }
                for (int j = 0; j < b.numOfFriends(); j++) {
                    //Go over the friend list of b

                    if (a.getFriend(i).equals(b.getFriend(j))) {
                        //Add the common friend to the tree
                        commonTree.insertProfile(b.getFriend(j));
                        break;
                    }
                }
            }
        } else {
            //Tell the user profile not exist and can't search for common friends
            System.out.println("One or more profiles do not exist!");
        }
        return commonTree;
    }
}
