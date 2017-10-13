package Strings;

import java.util.HashSet;
import java.util.Set;

public class ReverseVowels {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "hello";
		System.out.println(reverse(s));
	}
	public static String reverse(String s) {
		if(s == null || s.length()==0) return s;
		char[] ch = s.toCharArray();
		int start = 0;
		Set<Character> set = new HashSet();
		set.add('a');
		set.add('e');
		set.add('i');
		set.add('o');
		set.add('u');
		set.add('A');
		set.add('E');
		set.add('I');
		set.add('O');
		set.add('U');
		int end = s.length()-1;
		while(start < end) {
			while(start<end &&!set.contains(ch[start]))
				start++;
			while(start<end &&!set.contains(ch[end]))
				end--;
			char tmp = ch[start];
			ch[start] = ch[end];
			ch[end] = tmp;
			end--;
			start++;
		}
		return new String(ch);
	}
}
