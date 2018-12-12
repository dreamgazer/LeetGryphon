
//****************DP******************
class Solution {
    public int minDistance(String word1, String word2) {
	int len1 = word1.length();
	int len2 = word2.length();
	if(len1*len2 == 0) return len1+len2;
	int[][] distance = new int[len1 + 1][len2 + 1];
	for(int k = 0; k <= len1; k++){
		distance[k][0] = k;
	}
	for(int k = 0; k <= len2; k++){
		distance[0][k] = k;
	}
	for(int i=1; i<= len1; i++){
		for(int j=1; j<=len2;j++){
			if(word1.charAt(i - 1) == word2.charAt(j - 1)){
				distance[i][j] = Math.min(distance[i][j - 1] + 1, Math.min(distance[i - 1][j] + 1, distance[i - 1][j - 1]));
			}
			else{
				distance[i][j] = Math.min(distance[i][j - 1] + 1, Math.min(distance[i - 1][j] + 1, distance[i - 1][j - 1] + 1));
			}
		}
	}
	return distance[len1][len2];
    }
}
