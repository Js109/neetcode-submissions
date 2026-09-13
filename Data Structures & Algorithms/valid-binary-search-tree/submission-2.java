/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    // recall just visited value
    private Integer prev = null;

    public boolean isValidBST(TreeNode root) {
        return inOrder(root);
    }

    private boolean inOrder(TreeNode node) {
        if (node == null) {
            return true;
        }

        // left subtree
        if (!inOrder(node.left)) {
            return false;
        }

        // check current node
        if(prev != null && node.val <= prev) {
            return false;
        }

        prev = node.val;

        // right subtree
        return inOrder(node.right);
    }
}
