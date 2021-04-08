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

    public static TreeNode create() {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(10);
        root.right = new TreeNode(13);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(6);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(8);
        root.left.left.right.left = new TreeNode(15);
        // root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(18);
        root.right.right.left = new TreeNode(12);
        root.right.right.left.right = new TreeNode(27);
        return root;
    }


    public static void main(String[] args) {
        PreOrderTreeTraversal solution = new PreOrderTreeTraversal();
        TreeNode root = create();
        List<Integer> seq = solution.solution(root);
        for (Integer i : seq) {
            System.out.print(i + " -> ");
        }

    }


}
