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
	int value = 0;
	public boolean isUnivalTree(TreeNode root) {
		if(root == null) return true;
		value = root.val;
		return traverse(root);
	}
	
	private boolean traverse(TreeNode root){
		if(root.val != value) return false;
		boolean unival = true;
		if(root.left != null) unival = unival&&traverse(root.left);
		if(root.right != null) unival = unival&&traverse(root.right);
		return unival;
	}
}
