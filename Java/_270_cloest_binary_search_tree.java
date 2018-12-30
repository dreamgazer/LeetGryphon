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
	public int closestValue(TreeNode root, double target) {
		int closest = root.val;
		if(root.val < target){
			if(root.right != null){
				closest = closestValue(root.right, target);
			}
		}
		else {
			if(root.left != null){
				closest = closestValue(root.left, target);
			}
		}
        if(Math.abs(root.val - target) < Math.abs(closest - target)){
            return root.val;
        }
		else{
            return closest;
        }
		


	}
}
