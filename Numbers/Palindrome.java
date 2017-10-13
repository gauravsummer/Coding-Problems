package numbers;

public class Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 13343;
		System.out.println(isPalindrome(n));
	}
	public static boolean isPalindrome(int x) {
		/*if(x < 0 || (x!=0 && x%10 == 0))
			return false;
		int sum = 0;
		while(x > sum) {
			System.out.println("before sum : "+sum+" x "+x);
			sum = sum *10 + x% 10;
			x = x/10;
			System.out.println("after sum : "+sum+" x "+x);
		}
		return (x==sum) || (x == sum/10);*/
		
		if(x < 0 || (x!=0 && x % 10 == 0))
			return false;
		int sum = 0;
		while(x > sum) {
			sum = sum*10 + x%10;
			x = x/10;
		}
		return(x==sum) || (x == sum/10);
	}
}
