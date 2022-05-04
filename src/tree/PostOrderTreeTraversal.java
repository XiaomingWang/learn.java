package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PostOrderTreeTraversal {

    public List<Integer> solution(TreeNode root) {
        LinkedList<Integer> sequence = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return sequence;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            sequence.addFirst(node.value);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }

        return sequence;
    }

    public List<Integer> postOrderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        postOrder(root, results);
        return results;
    }

    public void postOrder(TreeNode root, List<Integer> results) {
        if (root != null) {
            postOrder(root.left, results);
            postOrder(root.right, results);
            results.add(root.value);
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
//        // root.right.left = new TreeNode(1);
//        root.right.right = new TreeNode(18);
//        root.right.right.left = new TreeNode(12);
//        root.right.right.left.right = new TreeNode(27);
        return root;
    }


    public static void main(String[] args) {
        PostOrderTreeTraversal solution = new PostOrderTreeTraversal();
        TreeNode root = create();
        // List<Integer> seq = solution.solution(root);
        List<Integer> seq = solution.postOrderTraversal(root);
        for (Integer i : seq) {
            System.out.print(i + " -> ");
        }

    }


}
