
public class Solution {
    /**
     * @param str: The string
     * @param k: The length of the substring
     * @return: The answer
     */
    public int findSubstring(String str, int k) {
        // Write your code here
        if (k > 26) {
            return 0;
        }
        HashSet<String> stringSet = new HashSet<String>();
        int ans = 0;
        for (int i = 0; i + k - 1 < str.length(); i++) {
            HashSet<Character> hashSet = new HashSet<Character>();
            boolean isLegal = true;
            for (int j = i; j <= i + k - 1; j++) {
                if (hashSet.contains(str.charAt(j))) {
                    isLegal = false;
                    break;
                } else {
                    hashSet.add(str.charAt(j));
                }
            }
            if (isLegal) {
                String s = str.substring(i, i + k);
                if (stringSet.contains(s)) {
                    continue;
                } else {
                    stringSet.add(s);
                    ans++;
                }
            }
        }
        return ans;
    }
}
