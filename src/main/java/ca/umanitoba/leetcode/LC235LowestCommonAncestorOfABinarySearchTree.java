package ca.umanitoba.leetcode;

import ca.umanitoba.datastructures.TreeNode;

public class LC235LowestCommonAncestorOfABinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val) 
            return lowestCommonAncestor(root.left, p, q);
        if (root.val < p.val && root.val < q.val)
            return lowestCommonAncestor(root.left, p, q);
        return root;
    }
}
