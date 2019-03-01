class Solution {
	class Node{
		public Node[] children;

		public Node(){
			this.children = new Node[2];
		}
	}	

	Node trie;
	int length = 0;
	public int findMaximumXOR(int[] nums) {
		trie = new Node();
		for(int i = 0; i < nums.length; i++){
			buildTrie(nums[i]);
		}
		int max = 0;
		for(int i = 0; i < nums.length; i++){
			max = Math.max(getMax(nums[i]), max);
		}
		return max;
	
	}

	private void buildTrie(int num){
		int bits = 30;
		Node node = trie;
		while(bits >= 0){
			int temp = num>>bits;
			if(node.children[1&temp] == null) node.children[1&temp] = new Node();
			node = node.children[1&temp];
			bits--;
		}
	}

	private int getMax(int num){
		int bits = 30;
		int result = 0;
		Node node = trie;
		while(bits >= 0){
            result = result << 1;
			int temp = num>>bits;
			if(node.children[(temp&1)^1] != null){
				node = node.children[(temp&1)^1];
				result = result + 1;
			}
			else{
				node = node.children[(temp&1)];
			}
			bits--;

		}
        return result;
		
	}
}
