package bitwise;

public class BitCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 1;
		int b = 4;
		System.out.println(hammingDistance(a,b));
	}
	public static int hammingDistance(int a, int b) {
		return Integer.bitCount(a ^ b); // bit count returns number of 1's in binary representation
	}

}
