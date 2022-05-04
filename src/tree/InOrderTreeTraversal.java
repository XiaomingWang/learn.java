package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderTreeTraversal {

    public List<Integer> solution(TreeNode root) {
        List<Integer> sequence = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return sequence;
        }
        TreeNode cursor = root;
        while (cursor != null || !stack.isEmpty()) {
            if (cursor != null) {
                stack.push(cursor);
                cursor = cursor.left;
            } else {
                cursor = stack.pop();
                sequence.add(cursor.value);
                cursor = cursor.right;
            }
        }

        return sequence;
    }

    public List<Integer> inOrderTraversal(TreeNode root) {
        ArrayList<Integer> results = new ArrayList<>();

        inOrder(root, results);

        return results;
    }

    public void inOrder(TreeNode root, List<Integer> results) {
        if (root != null) {
            inOrder(root.left, results);
            results.add(root.value);
            inOrder(root.right, results);
        }
    }


    public static TreeNode create() {

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
//        TreeNode root = new TreeNode(7);
//        root.left = new TreeNode(10);
//        root.right = new TreeNode(13);
//        root.left.left = new TreeNode(1);
//        root.left.right = new TreeNode(6);
//        root.left.left.left = new TreeNode(3);
//        root.left.left.right = new TreeNode(8);
//        root.left.left.right.left = new TreeNode(15);
//        root.right.right = new TreeNode(18);
//        root.right.right.left = new TreeNode(12);
//        root.right.right.left.right = new TreeNode(27);
//

        return root;
    }


    public static void main(String[] args) {
        InOrderTreeTraversal solution = new InOrderTreeTraversal();
        TreeNode root = create();
        // List<Integer> seq = solution.solution(root);
        List<Integer> seq = solution.inOrderTraversal(root);
        for (Integer i : seq) {
            System.out.print(i + " -> ");
        }

    }


}
