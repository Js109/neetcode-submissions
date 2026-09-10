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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode current = root;

        while(current != null) {
            // if values are both smaller than current -> search in left subtree
            if (p.val < current.val && q.val < current.val) {
                current = current.left;
            }
            // if values are both bigger than current -> search in right subtree
            else if(p.val > current.val && q.val > current.val) {
                current = current.right;
            } else {
                // path break / node found -> lca!
                return current;
            }
        }
        return null; // for valid p and q never reached
    }
}
