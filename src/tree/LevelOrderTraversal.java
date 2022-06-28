package tree;


import java.util.*;

/**
 * 102. Binary Tree Level Order Traversal
 * Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
 *
 * Example 1:
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[9,20],[15,7]]
 *
 * Example 2:
 * Input: root = [1]
 * Output: [[1]]
 */
public class LevelOrderTraversal {


    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                level.add(node.value);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ans.add(level);
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

        LevelOrderTraversal solution = new LevelOrderTraversal();
        List<List<Integer>> ans = solution.levelOrder(root);

        System.out.println(Arrays.toString(ans.toArray()));

    }


}
