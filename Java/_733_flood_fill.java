class Solution {
	private int originalColor;
	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		originalColor = image[sr][sc];
        if(originalColor == newColor) return image;// paint the same color, do nothing
		paint(image,sr,sc,newColor); //DFS painting
		return image;
	}
		
	private void paint(int[][] image, int sr, int sc, int newColor){
		image[sr][sc] = newColor;
		if(sr > 0 && image[sr - 1][sc] == originalColor) paint(image, sr - 1, sc, newColor);
		if(sr < image.length - 1&&image[sr + 1][sc] == originalColor) paint(image, sr + 1, sc, newColor);
		if(sc > 0 && image[sr][sc - 1] == originalColor) paint(image, sr, sc - 1, newColor);
		if(sc < image[sr].length - 1 && image[sr][sc + 1] == originalColor) paint(image, sr , sc + 1, newColor);
	}
}
