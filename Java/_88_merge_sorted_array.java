class Solution {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int[] nums = new int[nums1.length];
		int i=0,j=0,k = 0;
		while(i< (nums1.length - nums2.length)|| j<nums2.length){
            		if(i>=(nums1.length - nums2.length)){
				nums[k++] = nums2[j++];
			}
            		else if(j>=nums2.length){
				nums[k++] = nums1[i++];
			}
			else if(nums1[i] <= nums2[j]){
				nums[k++] = nums1[i++];
			}
			else{
				nums[k++] = nums2[j++];
			}

		}
        //for(int num:nums)
         //System.out.println(num);
		System.arraycopy(nums,0, nums1,0,nums1.length);
	}
}
