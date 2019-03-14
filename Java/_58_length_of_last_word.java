class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        int index = s.length() - 1;
        while(index >= 0&&s.charAt(index) != ' ') index--;
        return s.length() - index - 1;
    }
}
