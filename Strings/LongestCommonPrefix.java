package Strings;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs = {"aaa","aabbc","aadfgdfg","aasdfsdf"};
		System.out.println(LCP(strs));
	}
	public static String LCP(String[] strs) {
		if(strs.length == 0 || strs == null)
			return "";
		String pre = strs[0];
		int i=1;
		while(i<strs.length) {
			while(strs[i].indexOf(pre) != 0)
				pre = pre.substring(0, pre.length()-1);
			i++;
		}
		return pre;
	}
}
