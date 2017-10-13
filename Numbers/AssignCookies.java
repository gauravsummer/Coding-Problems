package numbers;

import java.util.Arrays;

public class AssignCookies {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] greed = {1,2};
		int[] sat = {1,2,3};
		System.out.println(content(greed, sat));
	}
	public static int content(int[] g, int[] s) { // greedy approach
		Arrays.sort(g);
		Arrays.sort(s);
		int i = 0;
		for(int j = 0; j<g.length && j<s.length; j++) {
			if(g[i] <= s[j]) 
				i++;
		}
		return i;
	}
}
