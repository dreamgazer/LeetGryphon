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

	int sum = 0;

	public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
		traverse(root, 0);
		return sum;
	}

	private void traverse(TreeNode node, int prefix){
		int local_sum = prefix*10 + node.val;
		if(node.left == null&&node.right == null){
			sum += local_sum;
			return;
		}
		if(node.left != null) traverse(node.left, local_sum);
		if(node.right != null) traverse(node.right, local_sum);

	}
}
