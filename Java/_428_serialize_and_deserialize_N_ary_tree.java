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

	StringBuilder sb;
	// Encodes a tree to a single string.
	public String serialize(Node root) {
		sb = new StringBuilder();
		sb.append("[");
		serializeHelper(root);
		sb.append("]");
		System.out.print(sb.toString());
		return sb.toString();
	}

	private void serializeHelper(Node root){
		sb.append( Integer.toString(root.val));
		if(root.children.size() !=0 ){
			sb.append("[");
			for(Node child:root.children){
				serializeHelper(child);
                sb.append(" ");
			}
			sb.append("]");
		}
	}

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        return null;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
