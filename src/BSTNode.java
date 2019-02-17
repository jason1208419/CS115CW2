
/**
 * A class that represents a link of the binary search tree.
 *
 * @author 689591
 */
public class BSTNode {

    private final Profile data;
    private BSTNode left;
    private BSTNode right;

    /**
     * Creates a binary search tree node.
     *
     * @param data A reference to a profile.
     */
    public BSTNode(Profile data) {
        this.data = data;
    }

    /**
     * Gets the profile associated with this node.
     *
     * @return The profile associated with this node.
     */
    public Profile getProfile() {
        return data;
    }

    /**
     * Gets the left child of this.
     *
     * @return The left child of this.
     */
    public BSTNode getLeft() {
        return left;
    }

    /**
     * Sets the left child of this to l.
     *
     * @param l Resets the left child of this.
     */
    public void setLeft(BSTNode l) {
        this.left = l;
    }

    /**
     * Gets the right child of this.
     *
     * @return The right child of this.
     */
    public BSTNode getRight() {
        return right;
    }

    /**
     * Sets the right child of this to r.
     *
     * @param r Resets the right child of this.
     */
    public void setRight(BSTNode r) {
        this.right = r;
    }
}
