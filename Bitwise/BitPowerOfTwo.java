package bitwise;

public class BitPowerOfTwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 256;
		System.out.println(isPowerOfTwo(x));
	}
	public static boolean isPowerOfTwo(int x) {
		if(x == 0)
			return false;
		if((x & (x-1)) == 0) //& between x and x-1 is always 0 for powers of 2 as powers of two will have single 1 bit
			return true;
		else
			return false;
	}

}
