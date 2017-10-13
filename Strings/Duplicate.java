package Strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Duplicate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] scores = new int[n];
        for(int scores_i=0; scores_i < n; scores_i++){
            scores[scores_i] = in.nextInt();
        }
        int m = in.nextInt();
        int[] alice = new int[m];
        for(int alice_i=0; alice_i < m; alice_i++){
            alice[alice_i] = in.nextInt();
        }
        int c = 1;
        for(int i=1; i<n; i++) {
        	if(scores[i] != scores[i-1]) {
        		c++;
        	}
        }
        int[] count = new int[c];
        int a = 0;
        for(int i=1; i<n;) {
        	if(scores[i] == scores[i-1]) {
        		i++;
        	}
        	else {
        		count[a++] = i++;
        	}
        }
        count[c-1] = n;
        for(int i=0; i<m; i++) {
        	while(c>0 && alice[i] > scores[count[c-1]-1]) {
        		c--;
        	}
        	if(c>0 && alice[i] == scores[count[c-1]-1])
        		c--;
        	System.out.println(c+1);
        }
	}
	public static String reverse(String str) {
		char[] str1 = str.toCharArray();
		char temp;
		int start = 0; int end = str.length()-1;
		while(start < end ) {
			temp = str1[start];
			str1[start] = str1[end];
			str1[end] = temp;
			start++;
			end--;
		}
		return new String(str1);
	}
	
	public static boolean duplicate(String str) {
		boolean[] check = new boolean[256];
		for(int i=0; i<str.length(); i++) {
			if(check[str.charAt(i)] == true)
				return false;
			check[str.charAt(i)] = true;
		}
		return true;
	}
	
	public static boolean duplicate1(String str) {
		HashSet<Character> check = new HashSet<Character>();
		for(int i=0; i<str.length(); i++) {
			if(check.contains(str.charAt(i)))
				return false;
			check.add(str.charAt(i));
		}
		return true;
	}

}
