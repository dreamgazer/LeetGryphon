class Solution {
	public int totalFruit(int[] tree) {
        if(tree.length == 1) return 1;
		int start = 0;
		int max = 0;
		int count = 1;
		int late_change = 0;
		int early_fruit = -1;
		for(int i=1; i<tree.length; i++){
			if(tree[i] != tree[i - 1]){
				
				if(count<2){
					count++;
					early_fruit = tree[i - 1];
				}
				else{
					if(tree[i] != early_fruit) {
						start = late_change;
						
					}
					early_fruit = tree[i - 1];
				}
                		late_change = i;
			}
			max = Math.max(max, i - start + 1);

		
		}
		return max;
	}
}
