package numbers;

public class TrailingZeroes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 0;
		System.out.println(zeroes(n));
	}
	public static int zeroes(int n) {
		int z = 0;
		while(n > 0) {
			n /= 5;
			z += n;
		}
		return z;
	}
}
