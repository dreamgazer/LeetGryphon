class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0, right = arr.length - 1;
        LinkedList<Integer> list = new LinkedList<Integer>();
        int count = 0;
	int index = -1;
	if(x<arr[0]){
		right = 0;
		left = -1;
	}
	else if(x>arr[arr.length - 1]){
		left = arr.length - 1;
		right = left + 1;
	}
	else{
		while(left < right - 1){
			int mid = left + (right - left)/2;
			if(x == arr[mid]){
                count ++;
                list.add(x);
				left = mid - 1;
				right = mid + 1;
				break;
			}
			if(x < arr[mid]){
				right = mid;
			}
			else{
				left = mid;
			}
		}

	}
	
	while(count < k){
		if(left<0){
			list.add(arr[right++]);
			++count;
		}
		else if(right >= arr.length){
			list.offerFirst(arr[left--]);
			++count;
		}
		else{
			if(x - arr[left]>arr[right] - x){
				list.add(arr[right++]);
				++count;
			}
			else{
				list.offerFirst(arr[left--]);
				++count;
			}
		}



      
	}
	return list;
	
    }

	
}
