package common;

public class HighestPowerOfTwo {
//	https://www.hackerearth.com/practice/notes/bit-manipulation/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long n = 255555555;
		n = n | (n >> 1);
		n = n | (n >> 2);
		n = n | (n >> 4);
		n = n | (n >> 8);
		System.out.println((n+1)>>1);
		
	}

}
