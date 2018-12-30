class Solution {
    public int search(ArrayReader reader, int target) {
    int left = 0,right = 1;
    while (reader.get(right) < target) {
        left = right;
        right = 2*right;
    }
	while(left <= right){
        int mid = left + (right - left)/2;
		if(reader.get(mid)== target) return mid;
		if(reader.get(mid) > target){
			right = mid - 1;
		}
		else{
			left = mid + 1;
		}

	}
	return -1;
    }
}
