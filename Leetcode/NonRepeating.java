package common;

import java.util.HashMap;

public class NonRepeating {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "gghhgghhgghha";
		System.out.println(nonRepeat(s));
	}
	public static Character nonRepeat(String s) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i=0; i<s.length(); i++) {
			if(!map.containsKey(s.charAt(i)))
				map.put(s.charAt(i), 1);
			else {
				map.put(s.charAt(i), map.get(s.charAt(i))+1);
			}
		}
		for(int i=0; i<s.length(); i++) {
			if(map.get(s.charAt(i))==1) {
				return s.charAt(i);
			}
		}
		return null;
	}

}
