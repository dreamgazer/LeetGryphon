class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int[] max_value = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            int max = 0;
            for(int j = i - 2; j >=0&&j >= i - 3; j--){
                max = Math.max(max_value[j], max);
            }
            max_value[i] = max + nums[i];
        }
        
        return Math.max(max_value[nums.length - 1],max_value[nums.length - 2]);
        
    }
}
