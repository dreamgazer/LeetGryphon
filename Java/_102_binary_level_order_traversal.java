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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
	if(root == null) return list;
	Queue<TreeNode> queue = new LinkedList<TreeNode>();
	queue.add(root);
	
	while(queue.size() != 0){
        int size = queue.size();
		ArrayList<Integer> level = new ArrayList<Integer>();
		for(int i=0;i<size;i++){
			TreeNode node = queue.poll();
			level.add(node.val);
			if(node.left != null) queue.add(node.left);
			if(node.right != null) queue.add(node.right);
		
		}
		list.add(level);
	}
	return list;
    }
}
