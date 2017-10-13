package numbers;

public class HammingDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 10;
		int y = 100;
		System.out.println(hamming(x, y));
	}
	public static int hamming(int x, int y) {
		return Integer.bitCount(x^y);
	}
}
