class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        StringBuilder sb = new StringBuilder(paragraph);
        
        int up2low = 'a' - 'A';
        for(int i = 0; i < sb.length(); i++){
            if(sb.charAt(i) < 'A'||sb.charAt(i) > 'z') sb.setCharAt(i, ' ');
            if(sb.charAt(i) >= 'A'&&sb.charAt(i) <= 'Z') sb.setCharAt(i, (char)(sb.charAt(i) + up2low));
        }
        
        HashSet<String> bannedWords = new HashSet<String>();
        HashMap<String, Integer> words= new HashMap<String, Integer>();
        
        for(String str: banned){
            bannedWords.add(str);
        }
        
        String[] strs = sb.toString().trim().split("\\s+");
        
        for(String str:strs){
            if(bannedWords.contains(str)) continue;
            if(words.containsKey(str)) words.put(str, words.get(str) + 1);
            else    
                words.put(str, 1);
        }
        
        int max_count = 0;
        String max_string = "";
        for(String key: words.keySet()){
            if(words.get(key) > max_count){
                max_string = key;
                max_count = words.get(key);
            }
        }
        
        return max_string;
    }
}
