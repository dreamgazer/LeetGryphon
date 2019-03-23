class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);
       
        int max1 = 0, max2 = 0;
       
        
        int[] dp = new int[nums.length];
        dp = new int[nums.length];
        for(int i = 1; i< nums.length; i++){
            int maxOfPrevTwo = 0;
            for(int j = i - 2; j >=0&& j >= i - 3;j--){
                maxOfPrevTwo = Math.max(maxOfPrevTwo, dp[j]);
            }
            dp[i] = maxOfPrevTwo + nums[i];
           
        }
        
        max2 = Math.max(dp[nums.length - 1], dp[nums.length - 2]);
        
        
        
         for(int i = 0; i< nums.length - 1; i++){
            int maxOfPrevTwo = 0;
            for(int j = i - 2; j >=0&& j >= i - 3;j--){
                maxOfPrevTwo = Math.max(maxOfPrevTwo, dp[j]);
            }
            dp[i] = maxOfPrevTwo + nums[i];
           
        }
        
        max1 = Math.max(dp[nums.length - 2], dp[nums.length - 3]);
        
        return Math.max(max1, max2);
    }
}
