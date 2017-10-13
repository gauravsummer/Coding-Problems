package Strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class AnagramList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs = {"abd", "bca", "ab","ba","acb"};
		AnagramList a = new AnagramList();
		a.sort(strs);
		for(String str: strs){
			System.out.println(str);
		}
	}
	public void sort(String[] strs) {
		HashMap<String, LinkedList<String>> map = new HashMap<String, LinkedList<String>>();
		for(String str: strs) {
			char[] cr = str.toCharArray();
			Arrays.sort(cr);
			String key = new String(cr);
			if(!map.containsKey(key)) {
				map.put(key, new LinkedList<String>());
			}
			LinkedList<String> anagrams = map.get(key);
			anagrams.add(str);
		}
		int index = 0;
		for(String key : map.keySet()) {
			LinkedList<String> list = map.get(key);
			for(String str: list) {
				strs[index++] = str;
			}
		}
	}
}
