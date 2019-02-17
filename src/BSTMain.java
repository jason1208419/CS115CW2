
/**
 * A class to test the BST class.
 *
 * @author 689591
 */
public class BSTMain {

    public static void main(String[] args) {
        //Create a binary search tree
        BST tree = new BST();

        //Create some profiles
        Profile jane = new Profile("Jane", 1, 1, 2000, "a", "b", "c", new String[]{"x", "y"});
        Profile bob = new Profile("Bob", 1, 1, 2000, "a", "b", "c", new String[]{"x", "y"});
        Profile tom = new Profile("Tom", 1, 1, 2000, "a", "b", "c", new String[]{"x", "y"});
        Profile alan = new Profile("Alan", 1, 1, 2000, "a", "b", "c", new String[]{"x", "y"});
        Profile nancy = new Profile("Nancy", 1, 1, 2000, "a", "b", "c", new String[]{"x", "y"});
        Profile wendy = new Profile("Wendy", 1, 1, 2000, "a", "b", "c", new String[]{"x", "y"});
        Profile ellen = new Profile("Ellen", 1, 1, 2000, "a", "b", "c", new String[]{"x", "y"});

        //Insert all created profile into the created binary search tree
        tree.insertProfile(jane);
        tree.insertProfile(bob);
        tree.insertProfile(tom);
        tree.insertProfile(alan);
        tree.insertProfile(nancy);
        tree.insertProfile(wendy);
        tree.insertProfile(ellen);

        //Print out the tree in inorder
        tree.printAlphabetical();
    }
}
