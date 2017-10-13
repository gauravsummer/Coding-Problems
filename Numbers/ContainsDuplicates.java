package numbers;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,2,4,5,7};
		System.out.println(duplicates(a));
	}
	public static boolean duplicates(int[] nums) {
		Set<Integer> s = new HashSet<Integer>();
		for(Integer c:nums) {
			if(s.contains(c))
				return true;
			else
				s.add(c);
		}
		return false;
	}
	public static boolean duplicates2(int[] nums) {
		Set<Integer> s = new HashSet<Integer>();
		for(Integer c:nums) {
			if(!s.add(c))
				return true;
		}
		return false;
	}
}
