package google;

public class SingleStarPatternMatching {
	
	public boolean SingleStar(String text, String pattern) {
		if (text == null || pattern == null) return false;
		if (text.length() == 0 && pattern.length() == 0) return true;
		int i = 0;
		for (i = 0; i < text.length() && i < pattern.length(); i++) {
			if (pattern.charAt(i) == '*') {
				return (SingleStar(text.substring(i+1), pattern.substring(i)) || SingleStar(text.substring(i+1), pattern.substring(i)));
			}
			if (text.charAt(i) != pattern.charAt(i)) return false;
		}
		
		if (i <= text.length() || i <= pattern.length()) { // matching not finished
			return false;
		}
		return true; // default
	}
	
}