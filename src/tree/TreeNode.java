package tree;

public class TreeNode {

    protected TreeNode left;

    protected TreeNode right;

    protected int value;

    public TreeNode() {
    }

    public TreeNode(int value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public TreeNode(int value) {
        this.value = value;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        printNodes(this, sb);
        return sb.toString();
    }

    void printNodes(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        if (sb.length() > 0) {
            sb.append(",");
        }
        sb.append(root.value);
        if (root.left != null) {
            printNodes(root.left, sb);
        }
        if (root.right != null) {
            printNodes(root.right, sb);
        }

    }

}
