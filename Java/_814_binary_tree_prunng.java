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
	public TreeNode pruneTree(TreeNode root) {
		if(!isContainingOne(root)){
			root = null;
		}
		return root;
	}

	private boolean isContainingOne(TreeNode root){
		if(root == null) return false;
		boolean one = false;
		if(root.val == 1) one = true;
		if(!isContainingOne(root.left)){
			root.left = null;
		}
		else{
			one = true;
		}
		if(!isContainingOne(root.right)){
			root.right = null;
		}
		else{
			one = true;
		}

		return one;
	}
}
