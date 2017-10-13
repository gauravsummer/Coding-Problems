package Strings;

import java.util.HashMap;
import java.util.Map;

public class UniqueChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "asdsdffrg";
		System.out.println(unique2(s));
	}
	public static int unique(String s) {
		Map<Character, Integer> map= new HashMap<Character, Integer>();
		for(char c: s.toCharArray()) {
			map.put(c, map.getOrDefault(c,0)+1);
		}
		for(int i=0; i<s.length(); i++) {
			if(map.get(s.charAt(i)) == 1) {
				return i;
			}	
		}
		return -1;
	}
	public static int unique2(String s) {
		int[] c = new int[26];
		for(char i: s.toCharArray()) {
			c[i-'a']++;
		}
		for(int i=0; i<s.length(); i++) {
			if(c[s.charAt(i)-'a'] == 1) {
				return i;
			}	
		}
		return -1;
	}
}
