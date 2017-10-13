package bitwise;

public class CountOne {
//https://www.hackerearth.com/practice/notes/bit-manipulation/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 12;
		System.out.println(countOne(x));
	}
	public static int countOne(int x) {
		int count = 0;
		while(x != 0){
			x = x &(x-1);
			count++;
		}
		return count;
	}

}
