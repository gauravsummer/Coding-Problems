package Strings;

public class ExcellCell {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "Z";
		System.out.println(columnNumber(s));
	}
	public static int columnNumber(String s) {
		int result = 0;
		for(int i=0; i<s.length(); i++) {
			result *= 26;
			result += ((s.charAt(i)-'A')+1);
		}
		return result;
	}
	
}
