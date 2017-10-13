package numbers;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {99,99};
		System.out.println(containsNearbyDuplicate(nums, 2));
	}
	public static boolean containsNearbyDuplicate(int[] nums, int k) {
		Set<Integer> set = new HashSet();
		for(int i=0; i<nums.length; i++) {
			if(i > k){
				set.remove(nums[i-k-1]);
			}
			if(!set.add(nums[i]))
				return true;
		}
		return false;
	}
}
