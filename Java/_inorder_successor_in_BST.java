/**
1.The leftmost child of the right child, if your current node has a right child. If the right child has no left child, the right child is your inorder successor.

2.Navigate up the parent ancestor nodes, and when you find a parent whose left child is the node you're currently at, the parent is the inorder successor of your original node.

 */
class Solution {
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		TreeNode res = null;
		while(root!=null) {
			if(root.val > p.val) {
				res = root;
				root = root.left;
			}
			else root = root.right;
		}
		return res;
	}
}
