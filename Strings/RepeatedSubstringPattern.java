package Strings;

public class RepeatedSubstringPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abaabaaba";
		System.out.println(repeatedSubstring(s));
	}
	public static boolean repeatedSubstring(String str) {
		int[] prefix = getPrefix(str);
		int len = prefix[str.length()-1];
        int n = str.length();
        for(int i:prefix)
        	System.out.println(i);
        return (len > 0 && n%(n-len) == 0);
    }
	public static int[] getPrefix(String str) {
		int[] out = new int[str.length()];
		char[] c = str.toCharArray();
		out[0] = 0;
		int i = 0;
		for(int j=1; j<str.length(); j++) {
			while(i>0 && c[i] != c[j]) {
				i = out[i-1];
			}
			if(c[i] == c[j]) {
				i++;
			}
			out[j] = i;
		}
		return out;
 	}
}
