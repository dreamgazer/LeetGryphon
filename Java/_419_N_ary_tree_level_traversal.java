/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    List<List<Integer>> list = new ArrayList<List<Integer>>();
    public List<List<Integer>> levelOrder(Node root) {
        if(root == null){
            return list;
        }
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while(queue.size() > 0){
            int size = queue.size();
            ArrayList<Integer> levelList = new ArrayList<Integer>();
                for(int i = 0; i<size;i++){
                    Node node = queue.poll();
                    levelList.add(node.val);
                    for(Node child:node.children){
                        queue.offer(child);
                    }
                }
            list.add(levelList);
            
        }
        return list;
    }
}