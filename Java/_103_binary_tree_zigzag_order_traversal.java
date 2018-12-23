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
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		if(root == null) return results;
		boolean toLeft = true;
		ArrayList<TreeNode> currentLayer = new ArrayList<TreeNode>();
		currentLayer.add(root);
		ArrayList<Integer> rootVal = new ArrayList<Integer>();
		rootVal.add(root.val);
		results.add(rootVal);
		visitLayer(currentLayer, results, true);

		return results;


	}

	private void visitLayer(ArrayList<TreeNode> layer, List<List<Integer>> results, boolean toLeft){
		ArrayList<Integer> valList = new ArrayList<Integer>();
		ArrayList<TreeNode> nextLayer = new ArrayList<TreeNode>();
		for(int i=layer.size()-1;i>=0 ;i--){
			if(toLeft){
				if(layer.get(i).right!=null){
					valList.add(layer.get(i).right.val);
					nextLayer.add(layer.get(i).right);
				}
				if(layer.get(i).left!=null){
					valList.add(layer.get(i).left.val);
					nextLayer.add(layer.get(i).left);
				}		
			}
			else{
				if(layer.get(i).left!=null){
					valList.add(layer.get(i).left.val);
					nextLayer.add(layer.get(i).left);
				}
				if(layer.get(i).right!=null){
					valList.add(layer.get(i).right.val);
					nextLayer.add(layer.get(i).right);
				}

			}
		}
		
		if(nextLayer.size()!=0){
			results.add(valList);
			visitLayer(nextLayer,results, !toLeft);
		}
		return;

	}


}




/* *********concise BFS traversal queue method using queue***********

https://stackoverflow.com/questions/5262308/how-do-implement-a-breadth-first-traversal

Queue<TreeNode> queue = new LinkedList<BinaryTree.TreeNode>() ;
public void breadth(TreeNode root) {
    if (root == null)
        return;
    queue.clear();
    queue.add(root);
    while(!queue.isEmpty()){
        TreeNode node = queue.remove();
        System.out.print(node.element + " ");
        if(node.left != null) queue.add(node.left);
        if(node.right != null) queue.add(node.right);
    }

}
*/
