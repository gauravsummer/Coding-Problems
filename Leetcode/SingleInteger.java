package common;

import java.util.HashMap;

public class SingleInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,1,1,2,2,2,3,3,3,4,4,4,5,5,5,5};
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=0; i<nums.length; i++) {
			if(map.containsKey(nums[i])) {
				if(map.get(nums[i]) == 2)
					map.remove(nums[i]);
				else 
					map.put(nums[i], map.get(nums[i])+1);
			}
			else {
				map.put(nums[i], 1);
			}
		}
		System.out.println(map.keySet().iterator().next());
	}
}
