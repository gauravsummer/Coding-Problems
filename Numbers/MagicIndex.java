package numbers;

public class MagicIndex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {-10,-5,2,2,2,3,4,8,9,12,13};
		System.out.println(magicRepeat(nums));
	}
	public static int magic(int[] nums) {
		int start=0, end = nums.length - 1;
		if(start <0||end>=nums.length||end<start){
			return -1;
		}
		while(end >= start) {
			int mid = (start+end)/2;
			if(nums[mid] == mid)
				return mid;
			if(nums[mid] < mid) 
				start = mid+1;
			else
				end = mid - 1;
		}
		return -1;
	}
	public static int magicRepeat(int[] nums) {
		return magicRepeat(nums, 0, nums.length-1);
	}
	public static int magicRepeat(int[] nums, int start, int end) {
		if(start <0||end>=nums.length||end<start){
			return -1;
		}
		int mid = (start+end)/2;
		int midEle = nums[mid];
		if(mid==midEle)
			return mid;
		int leftInd = Math.min(midEle, mid - 1);
		int left = magicRepeat(nums, start, leftInd);
		if(left>=0)
			return left;
		int rightInd = Math.max(midEle, mid+1);
		int right = magicRepeat(nums, rightInd, end);
		return right;
	}
}
