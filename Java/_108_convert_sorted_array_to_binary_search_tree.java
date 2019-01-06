/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// use the middle element to be to root of BST 
class Solution {
	public TreeNode sortedArrayToBST(int[] nums) {
		return subSortedArrayToBST(nums, 0, nums.length - 1);
	}

	public TreeNode subSortedArrayToBST(int[] nums, int left, int right) {
		if(left > right) return null;
 		int mid = left + (right - left)/2;
		TreeNode node = new TreeNode(nums[mid]);
		node.left = subSortedArrayToBST(nums, left, mid - 1);
		node.right = subSortedArrayToBST(nums, mid + 1, right);
		return node;
    	}
}
