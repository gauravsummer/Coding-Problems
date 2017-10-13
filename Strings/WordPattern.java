package Strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class WordPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String pattern = "aabbab";
		String str = "hi hi hello hello hi hi";
		System.out.println(wordPattern(pattern, str));
		
	}
	public static boolean wordPattern(String pattern, String str) {
		String[] words = str.split(" ");
		char[] patt = pattern.toCharArray();
		if(words.length != pattern.length())
			return false;
		Map map = new HashMap();
		for(int i=0; i<words.length; i++) {
			if(!Objects.equals(map.put(words[i], i), map.put(patt[i], i)))
				return false;
		}
		return true;
    }
}
