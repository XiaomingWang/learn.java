package tree;

/**
 *
 * A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them.
 * A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.
 *
 * The path sum of a path is the sum of the node's values in the path.
 *
 * Given the root of a binary tree, return the maximum path sum of any non-empty path.
 * Example1:
 *      1
 *     / \
 *    2   3
 * Input: root = [1,2,3]
 * Output: 6
 * Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.
 *
 * Example 2:
 *          -10
 *          / \
 *         9  20
 *           /  \
 *         15    7
 * Input: root = [-10,9,20,null,null,15,7]
 * Output: 42
 * Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.
 *
 */
public class MaxPathSum {

    public int maxPathSum(TreeNode root) {

        int leftChildSum = Math.max(0, root.value);
        int sum = root.value + maxPathSum(root.right) + maxPathSum(root.left);
        return -1;
    }

    public int maxGain(TreeNode root) {

        return -1;
    }

    public static void main(String[] args) {


    }

}
