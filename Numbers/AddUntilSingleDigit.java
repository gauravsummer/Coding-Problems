package numbers;

public class AddUntilSingleDigit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 123;
		System.out.println(addSingle(a));
	}
	public static int addSingle(int a) {
		////number modulo 9 returns the sum of its digits
		////If an integer is like 100a+10b+c, then (100a+10b+c)%9=(a+99a+b+9b+c)%9=(a+b+c)%9
		
		if(a == 0) // if number is 0
			return 0;
		if(a%9 == 0) // if number modulo 9 is 0 
			return 9;
		else		// otherwise return number modulo 9
			return a%9;
	}

}
