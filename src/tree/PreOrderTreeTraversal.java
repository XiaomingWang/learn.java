package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrderTreeTraversal {


    public List<Integer> solution(TreeNode root) {
        List<Integer> sequence = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return sequence;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode tmp = stack.pop();
            sequence.add(tmp.value);

            if (tmp.right != null) {
                stack.push(tmp.right);
            }
            if (tmp.left != null) {
                stack.push(tmp.left);
            }

        }


        return sequence;
    }

    public List<Integer> preOrderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        preOrder(root, results);
        return results;
    }

    public void preOrder(TreeNode root, List<Integer> results) {
        if (root != null) {
            results.add(root.value);
            preOrder(root.left, results);
            preOrder(root.right, results);
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
         *   3         -2
         */
        TreeNode root = new TreeNode(
                7,
                new TreeNode(8, new TreeNode(10, null, null), new TreeNode(8, new TreeNode(3, null, null), null)),
                new TreeNode(9, new TreeNode(-1, null, null), new TreeNode(10, null, new TreeNode(-2, null, null)))
        );
        return root;
    }


    public static void main(String[] args) {
        PreOrderTreeTraversal solution = new PreOrderTreeTraversal();
        TreeNode root = create();
        // List<Integer> seq = solution.preOrderTraversal(root);
        List<Integer> seq = solution.solution(root);
        for (Integer i : seq) {
            System.out.print(i + " -> ");
        }
    }


}
