package tree;


import java.sql.Array;
import java.util.*;

/**
 * 103. Binary Tree Zigzag Level Order Traversal
 *
 * Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).
 *
 *
 * Example 1:
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[20,9],[15,7]]
 *
 * Constraints:
 *  The number of nodes in the tree is in the range [0, 2000].
 *  -100 <= Node.val <= 100
 *
 */
public class ZigzagLevelOrder {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (root == null) return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean isLeftOrder = true;
        while (!queue.isEmpty()) {
            int n = queue.size();
            Deque<Integer> level = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();

                if (isLeftOrder) {
                    level.offerLast(node.value);
                } else {
                    level.offerFirst(node.value);
                }

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            isLeftOrder = !isLeftOrder;

            ans.add(new LinkedList<>(level));
        }

        return ans;
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

        ZigzagLevelOrder solution = new ZigzagLevelOrder();
        List<List<Integer>> ans = solution.zigzagLevelOrder(root);

        System.out.println(Arrays.toString(ans.toArray()));
    }


}
