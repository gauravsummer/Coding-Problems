package numbers;

public class PowerOfThree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 45;
		System.out.println(powerOfThree(n));
	}
	public static boolean powerOfThree(int n) {
		while(n > 1) {
			if(n % 3 == 0)
				n = n/3;
			else
				break;
		}
		if(n == 1)
			return true;
		return false;
	}
}
