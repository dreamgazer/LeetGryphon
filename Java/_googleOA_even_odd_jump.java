// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{10,13,12,14,15};
        System.out.println(jump(nums));
        
    }
    private static int jump(int nums[]){
        int count = 0;
        boolean[] odd_jump = new boolean[nums.length];
        boolean[] even_jump = new boolean[nums.length];
        odd_jump[nums.length - 1] = true;
        even_jump[nums.length - 1] = true;
        for(int i = nums.length - 2;i>=0;i--){
            for(int j = i+1;j<nums.length;j++){
                if(nums[j]> nums[i]){
                    if(even_jump[j]){
                        odd_jump[i] = true;
                        count++;
                    } 
                    else{
                        odd_jump[i] = false;
                    }
                    break;                   
                }
            }
            for(int j = i+1;j<nums.length;j++){
                if(nums[j]< nums[i]){
                    if(odd_jump[j]){
                        even_jump[i] = true;
                        
                    } 
                    else{
                        even_jump[i] = false;
                    }
                    break;                   
                }
            }
        }
        return count;
    }
}
