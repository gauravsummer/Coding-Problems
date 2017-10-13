package common;

import java.util.Scanner;

public class StrangeCounter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String inp = scan.next();
		
		Long i = Long.parseUnsignedLong(inp);
		Long total = Long.parseUnsignedLong("0");
		int n = 3;
		while(total < i){
			total = total + n;
			n = n * 2;
		}
		//n = n / 2;
		long result = total - i + 1;
		System.out.println(result);
	}
}
