class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0) return 0;
        int[] longestPreSeq = new int[nums.length];
        
        int longest = 0;
        for(int i = 0; i<nums.length; i++){
            int localLongest = 1;
            for(int j =0 ; j<i; j++){
                if(nums[i] > nums[j]){
                    localLongest = Math.max(localLongest, longestPreSeq[j] + 1);
                }
            }
            longestPreSeq[i] = localLongest;
            longest = Math.max(longest, localLongest);
        }
        
        return longest;
        
    }
}
