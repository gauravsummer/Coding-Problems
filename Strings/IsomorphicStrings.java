package Strings;

public class IsomorphicStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aasdass";
		String t = "ffgsfgg";
		System.out.println(isIsomorphic(s, t));
	}
	public static boolean isIsomorphic(String s, String t) {
		char[] cs = s.toCharArray();
		char[] ct = t.toCharArray();
		int[] m1 = new int[256];
		int[] m2 = new int[256];
		int n = s.length();
		for(int i=0; i<n; i++) {
			if(m1[cs[i]] != m2[ct[i]])
				return false;
			m1[cs[i]] = i+1;
			m2[ct[i]] = i+1;
		}
		return true;
	}
}
