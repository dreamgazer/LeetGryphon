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

	int count = 0;

	public int pathSum(TreeNode root, int sum) {
        if(root == null) return 0;
		findPath(root, sum);
		return count;
	}

	private HashMap<Integer, Integer> findPath(TreeNode root, int sum){
		if(root.left == null&& root.right == null){
			HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
			if(root.val == sum) count++;
			map.put(root.val, 1);
			return map;
		}
		else{
			HashMap<Integer, Integer> map =  new HashMap<Integer, Integer>();
			map.put(root.val, 1);
			if(root.left != null) {
				HashMap<Integer, Integer> subMap = findPath(root.left, sum);
				for(int key: subMap.keySet()){
					if(map.containsKey(key + root.val)){
						map.put(key + root.val, subMap.get(key) + map.get(key + root.val));
					}
					else {
						map.put(key + root.val, subMap.get(key));
					}
				}
				subMap.clear();

			}
			if(root.right != null) {
				HashMap<Integer, Integer> subMap = findPath(root.right, sum);
				for(int key: subMap.keySet()){
					if(map.containsKey(key + root.val)){
						map.put(key + root.val, subMap.get(key) + map.get(key + root.val));
					}
					else {
						map.put(key + root.val, subMap.get(key));
					}
				}
				subMap.clear();
			}
            for(int key: map.keySet()){
						if(key == sum) count += map.get(key);
            }
            return map;
			
		}
        
	}
}
