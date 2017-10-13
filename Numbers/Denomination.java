package numbers;

public class Denomination {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 100;
		System.out.println(denom(100,25));
	}
	public static int denom(int n, int den) {
		int ways = 0;
		int next = 0;
		switch(den){
		case 25:
			next = 10;
			break;
		case 10:
			next = 5;
			break;
		case 5:
			next = 1;
			break;
		case 1:
			return 1;
		}
		for(int i=0; i*den<=n; i++) {
			ways += denom(n-i*den, next);
		}
		return ways;
	}
}
