/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 0,right = n;
	while(left <= right){
		int mid = left + (right - left)/2;
		boolean cur = isBadVersion(mid);
        if(!cur){
            left = mid + 1;
            continue;
        }
		if(mid == 0) {
			return mid;
		}
		if(!isBadVersion(mid - 1)){
			return mid;
		}
		
		right = mid - 1;
		
		

	}
	return -1;
    }
}
