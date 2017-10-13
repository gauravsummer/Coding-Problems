package common;

import java.util.Scanner;

public class CloudRevisited {

	public static void main(String[] args) {
		final Scanner in = new Scanner(System.in);
		
		final int n = in.nextInt();
		final int k = in.nextInt();
		int E = 100;
		for(int i = 0; i < n; i++) {
			final int num = in.nextInt();
			if( i % k == 0) {
				E -= (1 + num * 2);
			}
		}
		
		System.out.println(E);
		
		in.close();
	}

}
