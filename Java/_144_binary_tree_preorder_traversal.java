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
	List<Integer> list = new ArrayList<Integer>();

	public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null) return list;
		list.add(root.val);
		if(root.left != null) preorderTraversal(root.left);
		if(root.right != null) preorderTraversal(root.right);
		return list;
	}
}
