package tree;

/**
 *
 *  Given a root node reference of a BST and a key, delete the node with the given key in the BST.
 *  Return the root node reference (possibly updated) of the BST.
 *
 *  Basically, the deletion can be divided into two stages:
 *  1. Search for a node to remove.
 *  2. If the node is found, delete the node.
 *
 *  Example 1:
 * Input: root = [5,3,6,2,4,null,7], key = 3
 *                   5
 *                 /  \
 *               3     7
 *             /  \   / \
 *            2   4  6   8
 * Output: [5,4,6,2,null,null,7]
 * Explanation: Given key to delete is 3. So we find the node with value 3 and delete it.
 * One valid answer is [5,4,6,2,null,null,7], shown in the above BST.
 * Please notice that another valid answer is [5,2,6,null,4,null,7] and it's also accepted.
 *
 *
 */
public class DeleteNodeFromBST {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return root;

        if (root.value < key) deleteNode(root.right, key);
        else if (root.value > key) deleteNode(root.left, key);
        else {
            // the node is a leaf.
            if (root.left == null && root.right == null) root = null;
            // the node is not a leaf and has a right child.
            else if (root.right != null) {
                root.value = successor(root);
                root.right = deleteNode(root.right, root.value);
            }
            // the node is not a leaf and has a left child.
            else {
                root.value = predecessor(root);
                root.left = deleteNode(root.left, root.value);
            }
        }

        return root;
    }

    /**
     * One step right and then always left
     * @param root
     * @return
     */
    public int successor(TreeNode root) {
        root = root.right;
        while (root.left != null) root = root.left;
        return root.value;
    }

    /**
     * One step to left and then always right.
     * @param root
     * @return
     */
    public int predecessor(TreeNode root) {
        root = root.left;
        while (root.right != null) root = root.right;
        return root.value;
    }


}
