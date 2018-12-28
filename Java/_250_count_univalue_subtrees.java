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
	private int count = 0;
	public int countUnivalSubtrees(TreeNode root) {      	
		isUnivalSubtree(root);
        return count;
	}

	public boolean isUnivalSubtree(TreeNode root) {
        System.out.println(root.val);
		if(root.left == null && root.right == null){
			count += 1;
			return true;
		}
		boolean left = true,right = true;
		if(root.left != null){
			if(!isUnivalSubtree(root.left)){
				left = false;
			}
			if(root.val != root.left.val){
				left =false;
			}
		}
		if(root.right != null){
			if(!isUnivalSubtree(root.right)){
				right = false;
			}
			if(root.val != root.right.val){
				right = false;
			}
		}
		if(left&&right){
			count += 1;
			return true;
		}
		
		return false;
		
	}
}
