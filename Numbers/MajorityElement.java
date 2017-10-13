package numbers;

import java.util.Arrays;

public class MajorityElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,1,1,1,2,2,3,4,5,3,1,1,1};
		System.out.println(majority(a));
	}
	public static int majority(int[] nums) {
		Arrays.sort(nums);
		return nums[nums.length/2];
	}
}
