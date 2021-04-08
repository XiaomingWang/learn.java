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
        InOrderTreeTraversal solution = new InOrderTreeTraversal();
        TreeNode root = create();
        List<Integer> seq = solution.solution(root);
        for (Integer i : seq) {
            System.out.print(i + " -> ");
        }

    }


}
