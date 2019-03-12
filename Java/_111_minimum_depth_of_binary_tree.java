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
	public int minDepth(TreeNode root) {
		if(root == null) return 0;
		int depth = 0;
        if(root.left == null&&root.right == null) return 1;
		Queue<TreeNode> queue =new LinkedList<TreeNode>();
		queue.offer(root);
		while(queue.size()>0){
			depth++;
			int size = queue.size();
			for(int i = 0; i<size ; i++){
				TreeNode node = queue.poll();
				if(node.left!=null){
					queue.add(node.left);
				}
				if(node.right!=null){
					queue.add(node.right);
				}
				if(node.left==null&&node.right==null){
					return depth;
				}
			}
		}
		return depth;
	}
}
