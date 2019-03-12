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
	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

	public int[] findFrequentTreeSum(TreeNode root) {
		subTree(root);
		int max_value = 0;
		HashSet<Integer> valueSet = new HashSet<Integer>();
		for(int key: map.keySet()){
			if(map.get(key) > max_value){
                max_value = map.get(key);
				valueSet.clear();
				valueSet.add(key);
			}
			else if(map.get(key) == max_value){
				valueSet.add(key);
			}
		}

		int[] values = new int[valueSet.size()];
		int i = 0;
		for(int value:valueSet){
			values[i++] = value;
		}

		return values;
	}

	private int subTree(TreeNode node){
       
		if(node == null) return 0;
		int sum = node.val + subTree(node.left) + subTree(node.right);
		if(map.containsKey(sum)){
			map.put(sum, 1 + map.get(sum));
		}
		else{
			map.put(sum, 1);
		}
		return sum;
	}
}
