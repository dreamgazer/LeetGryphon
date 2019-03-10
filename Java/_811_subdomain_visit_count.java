class Solution {
	class Node{
		String domain;
		int count;
		ArrayList<Node> children;

		public Node(String domain, int count){
			this.domain = domain;
			this.count = count;
			children = new ArrayList<Node>();
		}
	}
	
	public List<String> subdomainVisits(String[] cpdomains) {
		Node root = new Node("",0);
		for(String cpdomain: cpdomains){
			int count = Integer.parseInt(cpdomain.split(" ")[0]);
			String[] domains = cpdomain.split(" ")[1].split("\\.");
			Node node = root;
			for(int i = domains.length - 1; i>=0; i--){
				ArrayList<Node> children = node.children;
				boolean isChild = false;
				for(int j = 0; j<children.size(); j++){
					Node child = children.get(j);
					//System.out.println(domains[i] + "==" + child.domain);
					if(child.domain.equals(domains[i])){
						child.count += count;
						node = child;
						isChild = true;
						break;
					}
				}
                		if(!isChild){
					Node newChild = new Node(domains[i], count);
					children.add(newChild);
					node = newChild;
				}
				
			}
		}


		List<String> result = new ArrayList<String>();

		visit(root, "", result);
		
		return result;
	}

	private void visit(Node node, String str, List<String> result){
		ArrayList<Node> children = node.children;
		for(Node child: node.children){
			visit(child, child.domain + "." + str, result);
		}
		if(node.count!=0) result.add(Integer.toString(node.count) + " " + str.substring(0, str.length() - 1));
	}
}
