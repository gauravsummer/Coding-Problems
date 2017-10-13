package Recursion;

public class MagicIndexDistinct {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2,2,2,5,6,7,8,9};
		System.out.println(magic(nums));
	}
	public static int magic(int[] nums) {
		return magicRepeat(nums, 0, nums.length-1);
	}
	public static int magic(int[] nums, int start, int end) {
		if(end<start || start < 0 || end >= nums.length)
			return -1;
		int mid = (start + end) / 2;	
		if(nums[mid] == mid)
			return mid;
		if(nums[mid] > mid)
			return magic(nums, start, mid-1);
		else
			return magic(nums, mid+1, end);
	}
	public static int magicRepeat(int[] nums, int start, int end) {
		if(end<start || start<0 || end>=nums.length)
			return -1;
		int mid = (start + end) / 2;
		int midVal = nums[mid];
		if(mid == midVal)
			return mid;
		int leftIndex = Math.min(midVal, mid-1);
		int left = magicRepeat(nums, start, leftIndex);
		if(left >= 0)
			return left;
		int rightIndex = Math.max(midVal, mid+1);
		int right = magicRepeat(nums, rightIndex, end);
		return right;
		}
}
