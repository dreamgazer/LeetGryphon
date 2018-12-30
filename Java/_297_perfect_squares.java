/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// using bfs for encoding and decoding,  mind to discard the redundant null presentation of null nodes
public class Codec {
	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		StringBuilder sb = new StringBuilder();
		queue.add(root);
        	if(root == null) return "null";
		int size = queue.size();
		while(queue.size()!=0){
			boolean isLastLayer = true;
			size = queue.size();
			for(int i=0;i<size;i++){
				TreeNode node = queue.poll();
				if(node == null){
					sb.append("null,");
					continue;
				}
				else{
					sb.append(node.val + ",");
					
				}
				if(node.left != null){
					queue.add(node.left);
                    isLastLayer = false;
				}
				else{
					queue.add(null);
				}
				if(node.right != null){
					queue.add(node.right);
                    isLastLayer = false;
				}
				else{
					queue.add(null);
				}
			}
			if(isLastLayer) break;
		}
		sb.delete(sb.length() - 1, sb.length());
        System.out.println(sb.toString());
		return sb.toString();
	}


	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		if(data.equals("null")) return null;
        
        String[] vals = data.split(",");
        int len = vals.length;
		TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		
		int j=1;
		if(1 == len) return root;
		while(!queue.isEmpty()){
			TreeNode node = queue.poll();
			if(vals[j].equals("null")){
				node.left = null;
			}
			else{
				node.left = new TreeNode(Integer.parseInt(vals[j]));
            			queue.add(node.left);
			}
			j++;
			if(j >= len) return root;
        
			if(vals[j].equals("null")){
				node.right = null;
			}
			else{
				node.right = new TreeNode(Integer.parseInt(vals[j]));
            			queue.add(node.right);
			}a
			j++;
			if(j >= len) return root;
			
		
		}
            return root;
	}
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
