/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
	int start = 1, end = n,num;
	while(start <= end){
		num = start + (end - start)/2;
		int result = guess(num);
		if(result == 0) return num;
		if(result == -1){
			end = num - 1;
		}
		else{
			start = num + 1;
		}
		
		
	}
	return -1;
    }
}
