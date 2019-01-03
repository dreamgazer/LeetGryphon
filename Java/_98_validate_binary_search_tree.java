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
	boolean isBST = true;
	public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
		subBST(root);
		return isBST;

	}

	private int[] subBST(TreeNode root){
		if(!isBST) return new int[]{0,0};
		int[] bounds_left = new int[]{root.val,root.val};
		int[] bounds_right = new int[]{root.val,root.val};
		if(root.left != null){
			bounds_left = subBST(root.left);
			if(bounds_left[1] >= root.val) {
				isBST = false;
				return new int[]{0,0};
			}
		}
		if(root.right != null){
            
			bounds_right = subBST(root.right);
			if(bounds_right[0] <= root.val){
				isBST = false;
				return new int[]{0,0};
			}
		}
		return new int[]{bounds_left[0],bounds_right[1]};
		
		

	}
}
