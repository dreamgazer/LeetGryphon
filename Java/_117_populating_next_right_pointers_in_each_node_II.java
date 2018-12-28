/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */

public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null) return;

	TreeLinkNode firstNextLayerNode = null;
	TreeLinkNode left = null;
	while(root != null){ // connect nodes to their left layer by layer! 
		if(root.left != null){
			if(firstNextLayerNode == null) firstNextLayerNode = root.left;
			if(left!= null) left.next = root.left;
			if(root.right !=null){
				root.left.next = root.right;
				left = root.right;
			}
			else{
				left = root.left;
			}
		}
		else if(root.right!= null){
			if(firstNextLayerNode == null) firstNextLayerNode = root.right;
			if(left!= null) left.next = root.right;
			left = root.right;
		}
		root = root.next;
	}
	connect(firstNextLayerNode);
	
    }
}
