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

	int number = 0;
	int K = 0;
	int result = 0;

	public int kthSmallest(TreeNode root, int k) {
		K = k;
        inOrderTraverse(root);
        return result;
	}

	private void inOrderTraverse(TreeNode node){
		if(node == null) return;
		inOrderTraverse(node.left);
		number++;
		if(number == K) result = node.val;
		inOrderTraverse(node.right);

	}
}
