
/**
 * A class to test the BSTNode class.
 *
 * @author 689591
 */
public class BSTNodeMain {

    public static void main(String[] args) {
        //Create some profiles
        Profile jane = new Profile("Jane", 1, 1, 2000, "a", "b", "c", new String[]{"x", "y"});
        Profile bob = new Profile("Bob", 1, 1, 2000, "a", "b", "c", new String[]{"x", "y"});
        Profile tom = new Profile("Tom", 1, 1, 2000, "a", "b", "c", new String[]{"x", "y"});

        //Create some binary search tree nodes
        BSTNode node1 = new BSTNode(jane);
        BSTNode node2 = new BSTNode(bob);
        BSTNode node3 = new BSTNode(tom);

        //Test the setters
        node1.setLeft(node2);
        node1.setRight(node3);

        //Test the getters
        System.out.println("root:\n" + node1.getProfile() + "\nroot left child:\n" + node1.getLeft().getProfile()
                + "\nroot right child:\n" + node1.getRight().getProfile());
    }
}
