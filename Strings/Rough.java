 package Strings;

import java.util.HashSet;

public class Rough { 
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "asdfssdff";
		int a=19;
		System.out.println(duplicate(a));
		//System.out.println(duplicate(str));
	}
	public static boolean duplicate(int num) {
		HashSet<Integer> set = new HashSet();
		int sum,remain;
		while(set.add(num)) {
			sum = 0;
			while(num>0) {
				remain = num % 10;
				sum += remain * remain;
				num  /= 10;
			}
			if(sum == 1)
				return true;
			else
				num = sum;
		}
		return false;
	}

}
