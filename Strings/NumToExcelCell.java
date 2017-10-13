package Strings;

public class NumToExcelCell {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 55;
		System.out.println(excel(n));
	}
	public static String excel(int n) {
		StringBuilder sb = new StringBuilder();
		while(n > 0) {
			n--;
			sb.append((char)('A'+ n%26));
			n /= 26;
		}
		return sb.reverse().toString();
	}
}
