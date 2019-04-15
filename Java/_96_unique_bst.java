class Solution {
    public int numTrees(int n) {
        int[] treeNum = new int[n + 1];
        treeNum[0] = 1;
        treeNum[1] = 1;
        for(int i = 2; i <= n ; i++){
            for(int j = 1; j <= i; j++){
                treeNum[i] += treeNum[i - j]*treeNum[j - 1];
            }
        }
        return treeNum[n];
    }
}