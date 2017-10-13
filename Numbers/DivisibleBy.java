package numbers;

public class DivisibleBy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 10;
		System.out.println(divisibleBy(n));
	}
	public static boolean divisibleBy(int n) {
		if(n == 1)
			return true;
		if(n == 0)
			return false;
		while((n % 2) == 0)
			n = n/2;
		while((n % 3) == 0)
			n = n/3;
		while((n % 5) == 0)
			n = n/5;
		return n == 1;
	}
}
