package numbers;

public class PlusOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {9,9,9,9,9};
		int[] out = plusOne(num);
		for(int i=0; i<out.length; i++)
			System.out.println(out[i]);
	}

	public static int[] plusOne(int[] digits) {
		int carry = 0;
		int sum = digits[digits.length-1]++;
		digits[digits.length-1] = sum % 10;
		carry = sum / 10;
		if(carry == 0)
			return digits;
		for(int i=digits.length-2; i>=0; i--) {
			if(carry > 0){
				int sum1 = digits[i] + carry;
				digits[i] = sum1 % 10;
				carry = sum1 / 10;
			}
		}
		if(carry == 0){
			return digits;
		}
		else {
			int[] num1 = new int[digits.length+1];
			num1[0] = carry;
			return num1;
		}
	}
}
