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
	TreeNode pos= null;
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		hasAncestor(root,p,q);
		return pos;
	}

	boolean hasAncestor(TreeNode root, TreeNode p, TreeNode q){
		if(pos != null) return true;

		boolean left = false, right = false;
		if(root.left!=null) {left = hasAncestor(root.left,p,q); }
		if(root.right!=null) {right = hasAncestor(root.right,p,q);}
        if(pos != null) return true;
		if(right&&left){
			pos = root;
			return true;
		}
		if(right||left){
			if(root.val == p.val || root.val == q.val){
				pos = root;
			}
			return true;
		}	
		if(root.val == p.val || root.val == q.val){
				return true;
		}
			
		return false;
		
	}
}
