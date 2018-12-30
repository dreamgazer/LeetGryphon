/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Codec {
	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		StringBuilder sb = new StringBuilder();
		queue.add(root);
		int size = queue.size();
		while(queue.size()!=0){
			boolean isLastLayer = true;
			size = queue.size();
			for(int i=0;i<size;i++){
				TreeNode node = queue.poll();
				if(node == null){
					sb.append("null,");
					queue.add(null);
					queue.add(null);
					continue;
				}
				else{
					sb.append(node.val + ",");
					isLastLayer = false;
				}
				if(node.left != null){
					queue.add(node.left);
				}
				else{
					queue.add(null);
				}
				if(node.right != null){
					queue.add(node.right);
				}
				else{
					queue.add(null);
				}
			}
			if(isLastLayer) break;
		}
		sb.delete(sb.length() - 1, sb.length());
		return sb.toString();
	}


	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		String[] vals = data.split(",");
		if(vals.length == 0) return null;
		TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		
		int j=1;
		if(j == vals.length) return root;
		while(queue.size()!=0){
			TreeNode node = queue.poll();
			if(node == null){
				j += 2;
				queue.add(null);
				queue.add(null);
				if(j >= vals.length) return root;
			}
			else{
				if(vals[j].equals("null")){
					node.left = null;
				}
				else{
					node.left = new TreeNode(Integer.parseInt(vals[j]));
				}
				j++;
				if(j == vals.length) return root;
				if(vals[j].equals("null")){
					node.right = null;
				}
				else{
					node.right = new TreeNode(Integer.parseInt(vals[j]));
				}
				j++;
				if(j == vals.length) return root;
			}
		
		}
	}
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
