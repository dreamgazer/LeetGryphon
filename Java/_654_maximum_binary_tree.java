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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return contructTree(nums, 0, nums.length - 1);
	
    }

	private TreeNode contructTree(int[] nums, int start, int end){
		if(start > end) return null;
		int max_index = start;
		for(int i = start; i<= end;i++){
			if(nums[i] > nums[max_index]) max_index = i;
		}

		TreeNode node = new TreeNode(nums[max_index]);
		node.left = contructTree(nums, start, max_index - 1);
		node.right = contructTree(nums, max_index + 1, end);
		return node;

	}
}
