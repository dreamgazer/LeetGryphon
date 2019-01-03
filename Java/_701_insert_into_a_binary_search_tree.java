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
    public TreeNode insertIntoBST(TreeNode root, int val) {
	TreeNode realRoot = root;
	if(root == null) return (new TreeNode(val));
        while(root.val != val){
		if(root.val < val){
			if(root.right == null){
				root.right = new TreeNode(val);
				return realRoot;
			}
			else{
				root = root.right;
			}

		}
		else{
			if(root.left == null){
				root.left = new TreeNode(val);
				return realRoot;
			}
			else{
				root = root.left;
			}

		}
	}
	return realRoot;
    }
}
