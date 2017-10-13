package numbers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ArrayIntersect2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,2,3,2,2,3,4};
		int[] b = {1,2,3,2,5,4,2};
		int[] c = inter(a,b);
		for(int i:c)
			System.out.println(i);
	}
	public static int[] inter(int[] nums1, int[] nums2) {
		Map<Integer,Integer> map = new HashMap<>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(Integer i: nums1) {
			map.put(i, map.getOrDefault(i, 0)+1);
		}
		for(Integer i:nums2) {
			if(map.containsKey(i) && map.get(i) > 0) {
				list.add(i);
				map.put(i, map.get(i)-1);
			}
		}
		int[] result = new int[list.size()];
		for(int i=0; i<list.size(); i++) {
			result[i] = list.get(i);
		}
		return result;
	}
}
