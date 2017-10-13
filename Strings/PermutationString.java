package Strings;

import java.util.ArrayList;

public class PermutationString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "abc";
		ArrayList<String> perm = permutation(str);
		for(String word: perm)
			System.out.println(word);
	}
	public static ArrayList<String> permutation(String str) {
		if(str==null)
			return null;
		ArrayList<String> perm = new ArrayList<String>();
		if(str.length() == 0) {
			perm.add("");
			return perm;
		}
		char first = str.charAt(0);
		String remain = str.substring(1);
		ArrayList<String> words = permutation(remain);
		for(String word: words) {
			for(int i=0; i<= word.length(); i++) {
				String s = insertAt(word, first, i);
				perm.add(s);
			}
		}
		return perm;
					
	}
	public static String insertAt(String word, char first, int index) {
		String start = word.substring(0,index);
		String end = word.substring(index);
		return start+first+end;
	}
}
