package ca.umanitoba.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import ca.umanitoba.datastructures.TreeNode;

public class LC236LowestCommonAncestorOfBinaryTree {
    public TreeNode lowestCommonAncestorRecursive(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestorRecursive(root.left, p, q);
        TreeNode right = lowestCommonAncestorRecursive(root.right, p, q);
        if (left != null && right != null) return root;
        if (left != null) return left;
        return right;
    }

    private Map<TreeNode, TreeNode> nodeToParent = new HashMap<>();

    public TreeNode lowestCommonAncestorIterative(TreeNode root, TreeNode p, TreeNode q) {
        mapNodeToParent(root, null);
        Set<TreeNode> parents = new HashSet<>();
        while (p != null) {
            parents.add(p);
            p = nodeToParent.get(p);
        }
        while (!parents.contains(q)) q = nodeToParent.get(q);
        return q;
    }

    private void mapNodeToParent(TreeNode node, TreeNode parent) {
        if (node == null) return;
        nodeToParent.put(node, parent);
        mapNodeToParent(node.left, node);
        mapNodeToParent(node.right, node);
    }
}