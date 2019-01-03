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
    public TreeNode searchBST(TreeNode root, int val) {
        while(root.val != val){
		if(root.val < val){
			if(root.right == null) return null;
			root = root.right;
		}
		else{
			if(root.left == null) return null;
			root = root.left;
		}
	}
	return root;
    }
}
