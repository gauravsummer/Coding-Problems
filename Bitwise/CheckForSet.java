package bitwise;

public class CheckForSet {
//https://www.hackerearth.com/practice/notes/bit-manipulation/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 100;
		int i = 5;
		System.out.println(checkBit(x,i));
	}
	//check i ith digit from right(starting with 0) is set(set means 1) or not
	public static boolean checkBit(int x, int i) {
		if((x & (1 << i)) != 0)
			return true;
		else
			return false;
	}

}
