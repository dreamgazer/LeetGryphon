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
    List<List<Integer>> list = new  ArrayList<List<Integer>>();
    public List<List<Integer>> findLeaves(TreeNode root) {
        DFS(root);
        return list;
    }
    
    private int DFS(TreeNode node){
        if(node == null) return 1;
        int height = Math.max(DFS(node.left), DFS(node.right));
        
        if(list.size() < height){
            list.add(new LinkedList<Integer>());
            list.get(height - 1).add(node.val);
        }
        else{
            list.get(height - 1).add(node.val);
        }
        
        return height + 1;
    }
}