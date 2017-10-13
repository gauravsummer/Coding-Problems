package numbers;

public class rotatesMultiple {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {50,5,20,30,40};
		System.out.println(find(nums, 5));
	}	
	public static int find(int[] nums, int x) {
		int start = 0, end = nums.length-1;
		if(end < start)
			return -1;
		while(start <= end) {
			int mid = (start + end) / 2;
			if(nums[mid] == x)
				return mid;
			if(nums[start] < nums[mid]) {
				if(x <= nums[mid] && x >= nums[start]) {
					end = mid-1;
				} else {
					start = mid+1;
				}
			} else if(nums[start] > nums[mid]){
				if(x >= nums[mid] && x <= nums[end]) {
					start = mid+1;
				} else {
					end = mid-1;
				}
			} else {
				start = mid+1;
			}
		}
		return -1;
	}
}
