package bitwise;

public class AddTwoNums {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 1;
		int b = 210;
		System.out.println(add(a,b));
	}
	public static int add(int a, int b) {
		if(b==0)
			return a;
		int sum = a^b;	// get result for 0,1 and 1,0
		int carry = (a&b) << 1; // get carry for 1,1
		return add(sum, carry);
	}
}
