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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<TreeNode> nodes = new ArrayList<TreeNode>();
	LinkedList<List<Integer>> values = new LinkedList<List<Integer>>();
	if(root == null) return values;
	nodes.add(root);
	while(nodes.size()!=0){
		ArrayList<TreeNode> nodesNextLevel = new ArrayList<TreeNode>();
		List<Integer> levelValues = new ArrayList<Integer>();
		for(int i=0;i<nodes.size();i++){
			levelValues.add(nodes.get(i).val);
			if(nodes.get(i).left!=null){
				nodesNextLevel.add(nodes.get(i).left);
			}
			if(nodes.get(i).right!=null){
				nodesNextLevel.add(nodes.get(i).right);
			}

		}
		nodes = nodesNextLevel;
		values.offerFirst(levelValues);
	}
	return values;
    }
}

// use linkedlist to insert the element at head for constant time complexity (offerFirst() method)
