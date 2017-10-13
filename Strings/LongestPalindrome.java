package Strings;

public class LongestPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "asdfghgfds";
		System.out.println(longestPal(s));
	}
	public static int longestPal(String s) {
		int[] small = new int[26];
		int[] capital = new int[26];
		for(char c:s.toCharArray()) {
			if(c >= 97)
				small[c-'a']++;
			else
				capital[c-'A']++;
		}
		int result = 0;
		for(int i=0; i<26; i++) {
			result += (small[i]/2) *2;
			result += (capital[i]/2) *2;
		}
		if(result == s.length())
			return result;
		else
			return result + 1;
	}
}
