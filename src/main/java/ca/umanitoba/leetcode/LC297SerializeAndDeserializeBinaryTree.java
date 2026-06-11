package ca.umanitoba.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import ca.umanitoba.datastructures.TreeNode;

public class LC297SerializeAndDeserializeBinaryTree {
    public String serialize(TreeNode root) {
        var result = new StringBuilder();
        ser(root, result);
        return result.toString();
    }

    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return de(queue);
    }

    private TreeNode de(Queue<String> queue) {
        String token = queue.poll();
        if (token == "#") return null;
        TreeNode root = new TreeNode(Integer.valueOf(token));
        root.left = de(queue);
        root.right = de(queue);
        return root;
    }

    private void ser(TreeNode root, StringBuilder result) {
        if (root == null) result.append("#,");
        else {
            result.append(root.val + ",");
            ser(root.left, result);
            ser(root.right, result);
        }
    }
}
