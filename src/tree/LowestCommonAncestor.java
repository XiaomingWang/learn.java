package tree;

/**
 *
 * @author xiaoming
 */
public class LowestCommonAncestor {

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) {
            root = right;
        } else if (right == null) {
            root = left;
        }

        return root;
    }

    public static void main(String[] args) {
        /**
         *       7
         *     /   \
         *    8     9
         *   / \   / \
         *  10 8  -1  10
         *    /        \
         *   3          -2
         */
        TreeNode root = new TreeNode(
                7,
                new TreeNode(8, new TreeNode(10, null, null), new TreeNode(8, new TreeNode(3, null, null), null)),
                new TreeNode(9, new TreeNode(-1, null, null), new TreeNode(10, null, new TreeNode(-2, null, null)))
        );

        TreeNode expected = root;
        System.out.printf("Expected node value is : %d. \n", root.value);
        TreeNode result = lowestCommonAncestor(root, root.left.left, root.right.right.right);
        System.out.printf("Result node value is : %d. \n", result.value);
        System.out.println(expected == result);

    }

}
