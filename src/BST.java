
import java.util.ArrayList;

/**
 * A class that implements a binary search tree.
 *
 * @author 689591
 */
public class BST {

    private BSTNode root;

    /**
     * Creates an empty binary search tree.
     */
    public BST() {
        this.root = null;
    }

    /**
     * Inserts a profile at the correct position to the binary search tree.
     *
     * @param p A reference to the profile.
     */
    public void insertProfile(Profile p) {
        BSTNode data = new BSTNode(p);

        if (root == null) {//Inserts the profile to the root if the tree is empty
            root = data;
            //System.out.println("Profile inserted at root: " + data.getProfile().getName());
        } else {//Find a position to insert the profile if the tree is not empty
            insertRecursive(root, data);
        }
    }

    /**
     * Recursive until the right position reached to insert the new BSTNode
     * which contain a new profile.
     *
     * @param last The BSTNode which is last visited.
     * @param data The BSTNode which is going to be inserted.
     * @return True. For breaking out the recursive only.
     */
    private boolean insertRecursive(BSTNode last, BSTNode data) {
        /*
        Compare the name of the last visited BSTNode to the name of the new BSTNode
        <0: The name of the last visited BSTNode is smaller than the name of the new BSTNode
        0: The name of the last visited BSTNode is equal to the name of the new BSTNode
        >0: The name of the last visited BSTNode is greater than the name of the new BSTNode
         */
        int compare = last.getProfile().getName().compareToIgnoreCase(data.getProfile().getName());

        if (compare > 0) {
            //The name of the last visited BSTNode is greater than the name of the new BSTNode
            //System.out.println("Current node " + last.getProfile().getName() + " is greater than " + data.getProfile().getName());

            if (last.getLeft() == null) {
                //Insert the new BSTNode to the empty space
                last.setLeft(data);
                //System.out.println("Empty left.\n" + data.getProfile().getName() + " inserted.\n");
                return true;
            } else {
                //Continue to go to the left child and compare
                //System.out.println("Node is not empty. Current node: " + last.getProfile().getName() + "\nGo left.");
                return insertRecursive(last.getLeft(), data);
            }
        } else {
            //The name of the last visited BSTNode is smaller than or equal to the name of the new BSTNode
            //System.out.println("Current node " + last.getProfile().getName() + " is smaller than or equal to " + data.getProfile().getName());

            if (last.getRight() == null) {
                //Insert the new BSTNode to the empty space
                last.setRight(data);
                //System.out.println("Empty right.\n" + data.getProfile().getName() + " inserted.\n");
                return true;
            } else {
                //Continue to go to the right child and compare
                //System.out.println("Node is not empty. Current node: " + last.getProfile().getName() + "\nGo right.");
                return insertRecursive(last.getRight(), data);
            }
        }
    }

    /**
     * Do a inorder traversal.
     *
     * @param n The BSTNode which is last visited.
     */
    private void inOrder(BSTNode n) {
        if (n != null) {//Tree is not empty

            if (n.getLeft() != null) {//Visit the left child
                inOrder(n.getLeft());
            }

            System.out.println(n.getProfile().getName());

            if (n.getRight() != null) {//Visit the right child
                inOrder(n.getRight());
            }
        } else {//Tree is empty
            System.out.println("Tree is empty!");
        }
    }

    /**
     * Do a inorder traversal start from the root which print name of profiles
     * in alphabetical order.
     */
    public void printAlphabetical() {
        inOrder(root);
    }

    /**
     * Searches and returns a profile.
     *
     * @param last The last visited node.
     * @param name The name of the target profile.
     * @return Returns the profile of the target.
     */
    private Profile searchRecursive(BSTNode last, String name) {
        /*
        Compare the name of the last visited BSTNode to the name of the target
        <0: The name of the last visited BSTNode is smaller than the name of the target
        0: The name of the last visited BSTNode is equal to the name of the target
        >0: The name of the last visited BSTNode is greater than the name of the target
         */
        int compare = last.getProfile().getName().compareToIgnoreCase(name);

        if (compare > 0) {
            //The name of the last visited BSTNode is greater than the name of the target

            if (last.getLeft() == null) {
                //Target not found
                System.out.println("Target " + name + " not found!");
                return null;
            } else {
                //Continue to go to the left child and compare
                return searchRecursive(last.getLeft(), name);
            }
        } else if (compare < 0) {
            //The name of the last visited BSTNode is smaller than or equal to the name of the target

            if (last.getRight() == null) {
                //Target not found
                System.out.println("Target " + name + " not found!");
                return null;
            } else {
                //Continue to go to the right child and compare
                return searchRecursive(last.getRight(), name);
            }
        }
        return last.getProfile();
    }

    /**
     * Starts searching from the root and returns a profile.
     *
     * @param name The name of the target profile.
     * @return The target profile.
     */
    public Profile searchProfile(String name) {
        return searchRecursive(root, name);
    }

    /**
     * Method to insert all profiles present in the binary tree into the node
     * list in inorder.
     *
     * @param n The BSTNode which is last visited.
     */
    private void toListRecursive(BSTNode n, ArrayList<Profile> nodes) {
        if (n != null) {//Tree is not empty

            if (n.getLeft() != null) {//Visit the left child
                toListRecursive(n.getLeft(), nodes);
            }

            nodes.add(n.getProfile());

            if (n.getRight() != null) {//Visit the right child
                toListRecursive(n.getRight(), nodes);
            }
        }
    }

    /**
     * Method to insert all profiles present in the binary tree into the node
     * list in inorder start from the root.
     *
     * @param nodes The node list.
     */
    public void toList(ArrayList<Profile> nodes) {
        toListRecursive(root, nodes);
    }
}
