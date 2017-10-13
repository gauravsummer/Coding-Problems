package Strings;

public class ExtraCharacter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "asdda";
		String b = "asddza";
		System.out.println(diffSum(a, b));
	}
	public static char diffArray(String a, String b) {
		int[] alpha = new int[26]; // array to have count of number of occurance of a character
		for(int i=0; i<26; i++) {
			alpha[i] = 0; // initialize to 0
		}
		for(char c: a.toCharArray()) {
			alpha[c - 'a']++; // add character counts for string a
		}
		for(char c: b.toCharArray()) {
			if(--alpha[c - 'a'] < 0) // check after decrementing common characters
				return c; // only a non common character will be less than 0
		}
		return 0;
	}
	public static char diffSum(String a, String b) {
		char[] ac = a.toCharArray(); 
		char[] bc = b.toCharArray();
		int sum = 0;
		for(char c: bc) {
			sum += c;
		}
		for(char c: ac) {
			sum -= c;
		}
		return (char)sum;
	}
}
