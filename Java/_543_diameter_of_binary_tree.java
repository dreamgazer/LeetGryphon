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
    
    int max_diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        getDepth(root);
        
        return max_diameter;
        
    }
    
    private int getDepth(TreeNode node){
        if(node == null) return 0;
        
        int left_depth = getDepth(node.left);
        int right_depth = getDepth(node.right);
        
        max_diameter = Math.max(max_diameter, left_depth + right_depth);
        
        return Math.max(left_depth, right_depth) + 1;
    }
}
