package tree;

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
        PostOrderTreeTraversal solution = new PostOrderTreeTraversal();
        TreeNode root = create();
        List<Integer> seq = solution.solution(root);
        for (Integer i : seq) {
            System.out.print(i + " -> ");
        }

    }


}
