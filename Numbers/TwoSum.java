package numbers;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2,0,7,11,15};
		int target = 11;
		int[] result = twoSum(nums, target);
		for(int r:result)
			System.out.println(r);
	}
	public static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap();
		for(int i =0; i<nums.length; i++) {
			int diff = target - nums[i];
			if(map.containsKey(diff)) {
				return new int[]{map.get(diff), i};
			}
			map.put(nums[i], i);
		}
		return null;
	}
}
