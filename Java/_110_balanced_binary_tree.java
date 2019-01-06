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

	boolean isBalanced = true;
    public boolean isBalanced(TreeNode root) {
	treeHeight(root);
	return isBalanced;
        
    }

	private int treeHeight(TreeNode root){
		if(!isBalanced){
			return 0;
		}
		if(root == null) return 0;
		int leftDepth = treeHeight(root.left);
		int rightDepth = treeHeight(root.right);
		if(Math.abs(leftDepth - rightDepth) > 1){
			isBalanced = false;
		}
		return Math.max(leftDepth, rightDepth)+1;
		

	}
}
