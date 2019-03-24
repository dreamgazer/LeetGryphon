class Solution {
    public List<Integer> getRow(int rowIndex) {
        Integer[][] arr = new Integer[2][];
        arr[0] = new Integer[rowIndex + 1];
        arr[1] = new Integer[rowIndex + 1];
        arr[0][0] = 1;
        for(int i = 1; i <= rowIndex + 1; i++){
            int prev = (i - 1)%2;
            int curr = i%2;
            arr[curr][0] = 1;
            arr[curr][i - 1] = 1;
            for(int j = 1; j < i - 1; j++){
                arr[curr][j] = arr[prev][j] + arr[prev][j - 1];
            }
        }
        
        return Arrays.asList(arr[(rowIndex + 1)%2]);
    }
}
