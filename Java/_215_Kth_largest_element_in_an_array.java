class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums,0, nums.length - 1,  k);
	
    }
    
    
    private int quickSelect(int[] nums, int left, int right, int k){
        int index = left;
        int pivot = right;
        for(int i=left;i<right;i++){
            if(nums[i] > nums[pivot]){
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
                index++;
            }
        }
        int temp = nums[index];
        nums[index] = nums[pivot];
        nums[pivot] = temp;
        if(index == k - 1) return nums[index];
        if(index > k - 1) return quickSelect(nums, left, index - 1,k);
        return quickSelect(nums,index + 1, right,k);
    }
}
