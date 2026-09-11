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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, 0, result);
        return result;
    }

    private void dfs(TreeNode node, int level, List<List<Integer>> result) {
        if (node == null) {
            return;
        }

        // If we've never visited this level before, we'll create a new list
        if (level == result.size()) {
            result.add(new ArrayList<>());
        }

        // Add the current node value to the correct layer
        result.get(level).add(node.val);

        // First traverse left, then right (guaranteed left-to-right order)
        dfs(node.left, level + 1, result);
        dfs(node.right, level + 1, result);
    }
}