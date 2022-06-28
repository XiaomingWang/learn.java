package tree;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 297. Serialize and Deserialize Binary Tree
 * <p>
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 * <p>
 * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
 * <p>
 * Clarification: The input/output format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
 * <p>
 * Example 1:
 * Input: root = [1,2,3,null,null,4,5]
 * Output: [1,2,3,null,null,4,5]
 * <p>
 * Example 2:
 * Input: root = []
 * Output: []
 */
public class Codec {


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return rSerialize(root, "");
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        List<String> nodes = new LinkedList<String>(Arrays.asList(arr));

        return rDeserialize(nodes);
    }

    public String rSerialize(TreeNode root, String str) {
        if (root == null) {
            str += "null,";
        } else {
            str += root.value + ",";
            str = rSerialize(root.left, str);
            str = rSerialize(root.right, str);
        }
        return str;
    }

    public TreeNode rDeserialize(List<String> nodes) {
        if (nodes.get(0).equals("null")) {
            nodes.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(nodes.get(0)));
        nodes.remove(0);
        root.left = rDeserialize(nodes);
        root.right = rDeserialize(nodes);

        return root;
    }


    public static void main(String[] args) {
        /**
         *                    7
         *                /      \
         *              3          9
         *               \        /  \
         *                 6    1    2
         *                /  \
         *               8    5
         *
         *
         */
        TreeNode root = new TreeNode(7,
                new TreeNode(3,
                        null,
                        new TreeNode(6,
                                new TreeNode(8),
                                new TreeNode(5)
                        )
                ),
                new TreeNode(9,
                        new TreeNode(1),
                        new TreeNode(2)
                )
        );
        System.out.println(root.toString());

        Codec codec = new Codec();
        String string = codec.serialize(root);
        System.out.println(string);
        TreeNode ans = codec.deserialize(string);
        System.out.println(ans);


    }

}
