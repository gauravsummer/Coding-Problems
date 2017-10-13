package numbers;

public class AddStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "6543";
		String b = "7654";
		System.out.println(add(a,b));
	}
	public static String add(String num1, String num2) {
		int i = num1.length()-1;
		int j = num2.length()-1;
		int carry = 0;
		char[] num1A = num1.toCharArray();
		char[] num2A = num2.toCharArray();
		StringBuilder sb = new StringBuilder();
		while(i>=0 || j>=0 || carry ==1) { // if digits are left or carry from previous step remains
			int a = i>= 0?(num1A[i--] - '0') : 0; // starting with the last digit till 1st
			int b = j>= 0?(num2A[j--] - '0') : 0;
			int sum = a + b + carry;
			carry = sum / 10;
			sb.append(sum % 10);
		}
		return sb.reverse().toString();
	}
}
