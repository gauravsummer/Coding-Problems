package numbers;

public class BullaAndCows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String secret = "222111";
		String guess = "111222";
		System.out.println(hint(secret, guess));
	}
	public static String hint(String secret, String guess) {
		int bulls = 0;
		int[] num1 = new int[10];
		int[] num2 = new int[10];
		char[] sec = secret.toCharArray();
		char[] gue = guess.toCharArray();
		
		for(int i =0; i<secret.length(); i++) {
			char s = sec[i], g = gue[i];
			if(s == g) {
				bulls++;
			}
			else {
				num1[s - '0']++;
				num2[g - '0']++;
			}
		}
		int cows = 0;
		for(int i = 0; i<10; i++) {
			cows = cows + Math.min(num1[i], num2[i]);
		}
		return new String(bulls+"A"+cows+"B");
	}
}
