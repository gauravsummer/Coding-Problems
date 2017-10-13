package common;

public class StrPermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "fghjklkjhgf";
		String str2 = "fghjklujhgf";
		System.out.println(permute2(str1, str2));
	}
	
	public static boolean permute2(String str1, String str2) {
		char[] count = new char[256];
		if(str1.length() != str2.length())
			return false;
		char[] s1 = str1.toCharArray();
		char[] s2 = str2.toCharArray();
		for(int i=0; i<str1.length(); i++) {
			count[s1[i]]++;
		}
		for(int i=0; i<str2.length(); i++) {
			count[s2[i]]--;
			if(count[s2[i]] < 0)
				return false;
		}
		return true;
	}
	
	
	public static boolean permute(String str1, String str2) {
		if(str1.length() != str2.length())
			return false;
		return sort(str1).equals(sort(str2));
	}
	public static String sort(String str) {
		char[] s = str.toCharArray();
		java.util.Arrays.sort(s);
		//System.out.println(s);
		return new String(s);
	}
}
