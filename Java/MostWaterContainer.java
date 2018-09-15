
public class MostWaterContainer {
	 public int maxArea(int[] height) {
		 int left_index=0;
		 int right_index=height.length-1;
		 int area=0;
		 while(left_index<right_index) {
	        	area=Math.max(area, Math.min(height[left_index], height[right_index])*(right_index-left_index));
	        	if(height[left_index]<height[right_index]) {
	        		left_index++;
	        	}
	        	else {
	        		right_index--;
	        	}
	     }
		 return area;
	 }
}
