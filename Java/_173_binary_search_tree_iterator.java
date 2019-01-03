/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BSTIterator {

	LinkedList<Integer> BSTList;
	public BSTIterator(TreeNode root) {
		if(root == null) {
            BSTList =new LinkedList<Integer>();
            return;
        }
		BSTList = tree2List(root);
	}
	
	LinkedList<Integer> tree2List(TreeNode root){
		LinkedList<Integer> list = new LinkedList<Integer>();
		if(root.left != null){
			list.addAll(tree2List(root.left));
		}
		list.add(root.val);
		if(root.right != null){
			list.addAll(tree2List(root.right));
		}
		return list;
	}

	/** @return the next smallest number */
	public int next() {
		int result = BSTList.get(0);
		BSTList.removeFirst();
		return result;
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return (BSTList.size()>0);
	}
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
