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
	public TreeNode deleteNode(TreeNode root, int key) {
		if(root == null) return null;
		TreeNode parent = null;
		TreeNode realRoot = root;
		while(root.val != key){
			if(root.val < key){
				if(root.right == null) return realRoot;
				parent = root;
				root = root.right;
			}
			else{
				if(root.left == null) return realRoot;
				parent = root;
				root = root.left;
			}
		}
		if(root.right != null){
			
			if(root.left != null){
				TreeNode smallestInRight = root.right;
				while(smallestInRight.left != null) smallestInRight = smallestInRight.left;
				smallestInRight.left = root.left;
			}
			if(parent == null) return root.right;
			if(root.right.val < parent.val){
				parent.left = root.right;
			}
			else{
				parent.right = root.right;
			}
		}
		else if(root.left != null){
			if(parent == null) return root.left;
			if(root.left.val < parent.val){
				parent.left = root.left;
			}
			else{
				parent.right = root.left;
			}

		}
		else{
			if(parent == null) return null;
			if(root.val < parent.val){
				parent.left = null;
			}
			else{
				parent.right = null;
			}
		}
		return realRoot;
	}
}
