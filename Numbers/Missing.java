package numbers;

public class Missing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {0,1,2,3,5};
		Missing m = new Missing();
		System.out.println(m.miss(nums));
	}
	
	public int miss(int[] nums) {
		int start = 0, end = nums.length-1;
		if(end<start)
			return -1;
		while(start <= end) {
			int mid = (start + end) / 2;
			if(nums[mid] > mid)
				end = mid - 1;
			else
				start = mid + 1;
		}
		return start;
	}
}
