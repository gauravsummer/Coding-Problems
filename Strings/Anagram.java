package Strings;

public class Anagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "aaaaaa";
		String b = "aaaaaa";
		System.out.println(anagram(a,b));
	}
	public static boolean anagram(String s, String t) {
		if(s.length() != t.length())
			return false;
		int[] c = new int[26];
		for(int i=0; i<26; i++) {
			c[i] = 0;
		}
		for(char ch: s.toCharArray()) {
			c[ch - 'a']++;
		}
		for(char ch: t.toCharArray()) {
			if(--c[ch - 'a'] < 0)
				return false;
		}
		return true;
	}
}
