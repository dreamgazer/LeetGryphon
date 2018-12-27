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
    public List<Integer> inorderTraversal(TreeNode root) {
    if (root ==null) return (new ArrayList<Integer>());
	List<Integer> list = new ArrayList<Integer>();
        if(root.left!=null) list.addAll(inorderTraversal(root.left));
	list.add(root.val);
	if(root.right!=null) list.addAll(inorderTraversal(root.right));
	return list;
    }


	public List<Integer> inorderTraversal(TreeNode root) {
	    if (root ==null) return (new ArrayList<Integer>());
		List<Integer> list = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		
		
		while(!stack.isEmpty()){
			while(root.left!=null) {
				root = root.left;
				stack.push(root);
			}
			root = stack.pop();
			list.add(root.val);
			if(root.right!=null) root = root.right;
		}
		return list;
		
		
    }
}
