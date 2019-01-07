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
class Codec {

	
	// Encodes a tree to a single string.
	public String serialize(Node root) {
        if(root == null) return("[]");
		StringBuilder sb = new StringBuilder();
		serializeHelper(root, sb);
		return sb.toString();
	}

	private void serializeHelper(Node root, StringBuilder sb){
		sb.append( Integer.toString(root.val));
		if(root.children.size() !=0 ){
			sb.append(" [ ");
			for(Node child:root.children){
				serializeHelper(child, sb);
                sb.append(" ");
			}
			sb.append(" ]");
		}
	}

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if(data.equals("[]")) return null;
        Stack<Node> stack = new Stack<Node>();
        String[] strs = data.split("\\s+");
        
        for(String str : strs){
            if(str.equals("]")){
                LinkedList<Node> list = new LinkedList<Node>();
                Node levelNode = stack.pop();
                while(levelNode != null){
                    list.offerFirst(levelNode);
                    levelNode = stack.pop();
                }
                stack.peek().children = list;
            }
            else if(str.equals("[")){
                stack.push(null);
            }
            else{
                stack.push(new Node(Integer.parseInt(str), new ArrayList<Node>()));
                
            }
        }
        return stack.peek();
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));