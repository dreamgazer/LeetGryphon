import java.util.ArrayList;
import java.util.List;

public class ParanthesesGen {
	public List<String> generateParenthesis(int n) {
		List<String> strs = new ArrayList<String>();
        backtrack(strs, 0, 0, n, "");
        return strs;
    }
	
	private void backtrack(List<String> strs, int close, int open, int max, String str) {
        if(close > open) return;
		if(close == max) {
			strs.add(str);
			return;
		}
		if(open < max) {
			backtrack(strs, close, open + 1, max, str+"(");
		}
		if(close < max) {
			backtrack(strs, close + 1, open, max, str+")");
		}
	}
}
