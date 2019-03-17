class Solution {
    public void reverseString(char[] s) {
        if(s.length == 0) return;
        int high = s.length - 1;
        int low = 0;
        while(low <= high){
            char temp = s[low];
            s[low++] = s[high];
            s[high--] = temp;
        }
    }
}
