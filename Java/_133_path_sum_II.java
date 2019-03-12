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
	List<List<Integer>> list = new LinkedList<List<Integer>>();
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		LinkedList<Integer> preList = new LinkedList<Integer>();

		findPath(root, sum, preList);

		return list;
		
	}

	private void findPath(TreeNode node, int sum, LinkedList<Integer> preList){
		if(node == null) return;

		preList.add(node.val);

		if(node.val == sum&&(node.left == null&&node.right == null)) list.add(new LinkedList<Integer>(preList));

		findPath(node.left, sum - node.val,preList);

		findPath(node.right, sum - node.val,preList);

		preList.removeLast();
	}
}
