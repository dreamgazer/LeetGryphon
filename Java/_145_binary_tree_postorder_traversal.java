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
	private List<Integer> list = new ArrayList<Integer>();

	public List<Integer> postorderTraversal(TreeNode root) {
		if(root == null) return list;
		if(root.left != null) postorderTraversal(root.left);
		if(root.right != null) postorderTraversal(root.right);
		list.add(root.val);
		return list;
	}
}
