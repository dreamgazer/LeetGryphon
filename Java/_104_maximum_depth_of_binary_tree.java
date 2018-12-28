/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
    	if(root == null) return 0;
	int layer_left = 1;
	int layer_right = 1;
        if(root.left != null) layer_left += maxDepth(root.left);
	if(root.right != null) layer_right += maxDepth(root.right);
	return Math.max(layer_left, layer_right);
    }
}
