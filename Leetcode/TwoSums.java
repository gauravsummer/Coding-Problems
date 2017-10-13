package common;

import java.util.HashMap;
import java.util.HashSet;

public class TwoSums {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {6,4,4};
		int target = 10;
		System.out.println(twoSumNoOfPairs(nums, target));
	}
	
	public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hs = new HashMap<Integer, Integer>();
		for(int i = 0; i<nums.length; i++){
            if(hs.containsKey(target - nums[i]))
                return new int[]{hs.get(target - nums[i]),i};
            hs.put(nums[i], i);
		}
		return null;
    }
	public static int twoSumNoOfPairs(int[] nums, int target) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int count = 0;
		for(int i=0; i<nums.length; i++) {
			int diff = target - nums[i];
			if(map.containsKey(diff ))
				count += map.get(diff);
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
		}
		return count;
	}
}





