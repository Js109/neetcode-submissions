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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        if(p.val != q.val) {
            return false;
        }

        boolean leftIsSame = isSameTree(p.left, q.left);
        if(!leftIsSame) {
            return false;
        }
        
        boolean rightIsSame = isSameTree(p.right, q.right);
        if (!rightIsSame) {
            return false;
        }
        // everything fits -> tree is same
        return true;
    }
}
