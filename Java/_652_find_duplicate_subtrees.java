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
	HashSet<TreeNode> nodeSet;
	HashMap<String, Integer> subTreeMap;
	public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> result = new ArrayList<TreeNode>();
        if(root == null) return result;
		nodeSet =new HashSet<TreeNode>();
        subTreeMap = new HashMap<String, Integer>();
		preOrderTraverse(root);
		for(TreeNode node: nodeSet){
			result.add(node);
		}
		return result;
	}

	private String preOrderTraverse(TreeNode node){
		String left = (node.left == null? "#": preOrderTraverse(node.left));
		String right = (node.right == null? "#": preOrderTraverse(node.right));
		String str =  node.val  + left + right;
        if(!subTreeMap.containsKey(str)){
            subTreeMap.put(str, 1);
        }
		else if(subTreeMap.get(str) == 1){
			nodeSet.add(node);
			subTreeMap.put(str, 2);
		}
		
		return str;
	}
	
}
