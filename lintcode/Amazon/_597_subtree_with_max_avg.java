/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param root: the root of binary tree
     * @return: the root of the maximum average of subtree
     */
	TreeNode node;
	double max = -Double.MAX_VALUE;

	public TreeNode findSubtree2(TreeNode root) {
		if(root == null) return null;
		subAvg(root);
		return node;
	}


	private double[] subAvg(TreeNode root){
		double[] left = new double[2];
		double[] right = new double[2];
		if(root.left != null){
			left = subAvg(root.left);
		}
		
		if(root.right != null){
			right = subAvg(root.right);
		}
		
		double avg = (left[0]*left[1] + right[0]*right[1] + root.val)/(left[1] + right[1] + 1);

		if(avg > max) {
			node = root;
			max = avg;
		}
		return (new double[]{avg, left[1] + right[1] + 1});
		
	}
}
