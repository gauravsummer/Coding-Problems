package numbers;

import java.util.HashSet;
import java.util.Set;

public class ArrayIntersection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,2,3,2,2,3,4};
		int[] b = {1,2,3,2,5,4};
		int[] c = inter(a,b);
		for(int i:c)
			System.out.println(i);
	}
	public static int[] inter(int[] nums1, int[] nums2) {
		Set<Integer> set = new HashSet<>();
		Set<Integer> inter = new HashSet<>();
		for(int i:nums1) {
			set.add(i);
		}
		for(int i:nums2) {
			if(set.contains(i)) {
				inter.add(i);
			}
		}
		int[] out = new int[inter.size()];
		int j=0;
		for(int i:inter) {
			out[j++] = i;
		}
		return out;
	}

}
